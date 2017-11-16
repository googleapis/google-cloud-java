/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsub.v1;

import static com.google.cloud.pubsub.v1.MessageDispatcher.PENDING_ACKS_SEND_DELAY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.pubsub.v1.FakeSubscriberServiceImpl.ModifyAckDeadline;
import com.google.cloud.pubsub.v1.Subscriber.Builder;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.ReceivedMessage;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.pubsub.v1.SubscriptionName;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/** Tests for {@link Subscriber}. */
@RunWith(Parameterized.class)
public class SubscriberTest {

  private static final SubscriptionName TEST_SUBSCRIPTION =
      SubscriptionName.create("test-project", "test-subscription");

  private static final PubsubMessage TEST_MESSAGE =
      PubsubMessage.newBuilder().setMessageId("1").build();

  private static final int INITIAL_ACK_DEADLINE_EXTENSION_SECS = 2;

  private final boolean isStreamingTest;

  private ManagedChannel testChannel;
  private FakeScheduledExecutorService fakeExecutor;
  private FakeSubscriberServiceImpl fakeSubscriberServiceImpl;
  private Server testServer;

  private TestReceiver testReceiver;

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {{true}, {false}});
  }

  static class TestReceiver implements MessageReceiver {
    private final LinkedBlockingQueue<AckReplyConsumer> outstandingMessageReplies =
        new LinkedBlockingQueue<>();
    private boolean shouldAck = true; // If false, the receiver will <b>nack</b> the messages
    private Optional<CountDownLatch> messageCountLatch = Optional.absent();
    private Optional<RuntimeException> error = Optional.absent();
    private boolean explicitAckReplies;

    synchronized void setAckReply() {
      this.shouldAck = true;
    }

    synchronized void setNackReply() {
      this.shouldAck = false;
    }

    synchronized void setErrorReply(RuntimeException error) {
      this.error = Optional.of(error);
    }

    synchronized void setExplicitAck(boolean explicitAckReplies) {
      this.explicitAckReplies = explicitAckReplies;
    }

    synchronized void setExpectedMessages(int expected) {
      this.messageCountLatch = Optional.of(new CountDownLatch(expected));
    }

    void waitForExpectedMessages() throws InterruptedException {
      CountDownLatch latch;
      synchronized (this) {
        if (messageCountLatch.isPresent()) {
          latch = messageCountLatch.get();
        } else {
          return;
        }
      }
      latch.await();
    }

    @Override
    public synchronized void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
      try {
        if (explicitAckReplies) {
          try {
            outstandingMessageReplies.put(consumer);
          } catch (InterruptedException e) {
            throw new IllegalStateException(e);
          }
        } else {
          replyTo(consumer);
        }
      } finally {
        if (messageCountLatch.isPresent()) {
          messageCountLatch.get().countDown();
        }
      }
    }

    public synchronized void replyNextOutstandingMessage() {
      Preconditions.checkState(explicitAckReplies);
      try {
        replyTo(outstandingMessageReplies.take());
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
    }

    public synchronized void replyAllOutstandingMessage() {
      Preconditions.checkState(explicitAckReplies);
      AckReplyConsumer reply;
      while ((reply = outstandingMessageReplies.poll()) != null) {
        replyTo(reply);
      }
    }

    private synchronized void replyTo(AckReplyConsumer reply) {
      if (error.isPresent()) {
        throw error.get();
      } else {
        if (shouldAck) {
          reply.ack();
        } else {
          reply.nack();
        }
      }
    }
  }

  public SubscriberTest(boolean streamingTest) {
    this.isStreamingTest = streamingTest;
  }

  @Rule public TestName testName = new TestName();

  @Before
  public void setUp() throws Exception {
    InProcessServerBuilder serverBuilder = InProcessServerBuilder.forName(testName.getMethodName());
    fakeSubscriberServiceImpl = new FakeSubscriberServiceImpl();
    fakeExecutor = new FakeScheduledExecutorService();
    testChannel = InProcessChannelBuilder.forName(testName.getMethodName()).build();
    serverBuilder.addService(fakeSubscriberServiceImpl);
    testServer = serverBuilder.build();
    testServer.start();

    testReceiver = new TestReceiver();
  }

  @After
  public void tearDown() throws Exception {
    testServer.shutdownNow().awaitTermination();
    testChannel.shutdown();
  }

  @Test
  public void testOpenedChannels() throws Exception {
    if (!isStreamingTest) {
      // This test is not applicable to polling.
      return;
    }

    int expectedChannelCount = 1;

    Subscriber subscriber = startSubscriber(getTestSubscriberBuilder(testReceiver));

    assertEquals(
        expectedChannelCount, fakeSubscriberServiceImpl.waitForOpenedStreams(expectedChannelCount));

    subscriber.stopAsync().awaitTerminated();
  }

  @Test
  public void testFailedChannel_recoverableError_channelReopened() throws Exception {
    if (!isStreamingTest) {
      // This test is not applicable to polling.
      return;
    }

    int expectedChannelCount = 1;

    Subscriber subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setExecutorProvider(
                    InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(1).build()));

    // Recoverable error
    fakeSubscriberServiceImpl.sendError(new StatusException(Status.INTERNAL));

    assertEquals(1, fakeSubscriberServiceImpl.waitForClosedStreams(1));
    assertEquals(
        expectedChannelCount, fakeSubscriberServiceImpl.waitForOpenedStreams(expectedChannelCount));

    subscriber.stopAsync().awaitTerminated();
  }

  @Test(expected = IllegalStateException.class)
  public void testFailedChannel_fatalError_subscriberFails() throws Exception {
    if (!isStreamingTest) {
      // This test is not applicable to polling.
      throw new IllegalStateException("To fullfil test expectation");
    }

    Subscriber subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setExecutorProvider(
                    InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(10).build()));

    // Fatal error
    fakeSubscriberServiceImpl.sendError(new StatusException(Status.INVALID_ARGUMENT));

    try {
      subscriber.awaitTerminated();
    } finally {
      // The subscriber must finish with an state error because its FAILED status.
      assertEquals(Subscriber.State.FAILED, subscriber.state());

      Throwable t = subscriber.failureCause();
      assertTrue(t instanceof ApiException);

      ApiException ex = (ApiException) (t);
      assertTrue(ex.getStatusCode() instanceof GrpcStatusCode);

      GrpcStatusCode grpcCode = (GrpcStatusCode) ex.getStatusCode();
      assertEquals(StatusCode.Code.INVALID_ARGUMENT, grpcCode.getCode());
    }
  }

  private Subscriber startSubscriber(Builder testSubscriberBuilder) throws Exception {
    Subscriber subscriber = testSubscriberBuilder.setUseStreaming(isStreamingTest).build();
    subscriber.startAsync().awaitRunning();
    subscriber.setAckDeadline(10);
    return subscriber;
  }

  private Builder getTestSubscriberBuilder(MessageReceiver receiver) {
    return Subscriber.newBuilder(TEST_SUBSCRIPTION, receiver)
        .setExecutorProvider(FixedExecutorProvider.create(fakeExecutor))
        .setSystemExecutorProvider(FixedExecutorProvider.create(fakeExecutor))
        .setChannelProvider(FixedTransportChannelProvider.create(GrpcTransportChannel.create(testChannel)))
        .setCredentialsProvider(NoCredentialsProvider.create())
        .setClock(fakeExecutor.getClock())
        .setParallelPullCount(1);
  }
}

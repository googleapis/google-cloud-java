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
import com.google.api.gax.grpc.FixedChannelProvider;
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
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.internal.ServerImpl;
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
import org.threeten.bp.Duration;

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
  private ServerImpl testServer;

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

    void setAckReply() {
      this.shouldAck = true;
    }

    void setNackReply() {
      this.shouldAck = false;
    }

    void setErrorReply(RuntimeException error) {
      this.error = Optional.of(error);
    }

    void setExplicitAck(boolean explicitAckReplies) {
      this.explicitAckReplies = explicitAckReplies;
    }

    void setExpectedMessages(int expected) {
      this.messageCountLatch = Optional.of(new CountDownLatch(expected));
    }

    void waitForExpectedMessages() throws InterruptedException {
      if (messageCountLatch.isPresent()) {
        messageCountLatch.get().await();
      }
    }

    @Override
    public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
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

    public void replyNextOutstandingMessage() {
      Preconditions.checkState(explicitAckReplies);
      try {
        replyTo(outstandingMessageReplies.take());
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
    }

    public void replyAllOutstandingMessage() {
      Preconditions.checkState(explicitAckReplies);
      AckReplyConsumer reply;
      while ((reply = outstandingMessageReplies.poll()) != null) {
        replyTo(reply);
      }
    }

    private void replyTo(AckReplyConsumer reply) {
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
  }

  @Test
  public void testAckSingleMessage() throws Exception {
    Subscriber subscriber = startSubscriber(getTestSubscriberBuilder(testReceiver));

    List<String> testAckIds = ImmutableList.of("A");
    sendMessages(testAckIds);

    // Trigger ack sending
    subscriber.stopAsync().awaitTerminated();

    assertEquivalent(testAckIds, fakeSubscriberServiceImpl.waitAndConsumeReceivedAcks(1));
  }

  @Test
  public void testGetSubscriptionOnce() throws Exception {
    if (isStreamingTest) {
      // Only applicable to polling.
      return;
    }
    Subscriber subscriber = startSubscriber(getTestSubscriberBuilder(testReceiver));

    sendMessages(ImmutableList.of("A"));

    // Trigger ack sending
    subscriber.stopAsync().awaitTerminated();

    assertEquals(1, fakeSubscriberServiceImpl.getSubscriptionCalledCount());
  }

  @Test
  public void testNackSingleMessage() throws Exception {
    Subscriber subscriber = startSubscriber(getTestSubscriberBuilder(testReceiver));

    testReceiver.setNackReply();
    sendMessages(ImmutableList.of("A"));

    // Trigger ack sending
    subscriber.stopAsync().awaitTerminated();

    assertEquivalent(
        ImmutableList.of(new ModifyAckDeadline("A", 0)),
        fakeSubscriberServiceImpl.waitAndConsumeModifyAckDeadlines(1));
  }

  @Test
  public void testReceiverError_NacksMessage() throws Exception {
    testReceiver.setErrorReply(new RuntimeException("Can't process message"));

    Subscriber subscriber = startSubscriber(getTestSubscriberBuilder(testReceiver));

    sendMessages(ImmutableList.of("A"));

    // Trigger nack sending
    subscriber.stopAsync().awaitTerminated();

    assertEquivalent(
        ImmutableList.of(new ModifyAckDeadline("A", 0)),
        fakeSubscriberServiceImpl.waitAndConsumeModifyAckDeadlines(1));
  }

  @Test
  public void testBatchAcks() throws Exception {
    Subscriber subscriber = startSubscriber(getTestSubscriberBuilder(testReceiver));

    List<String> testAckIdsBatch1 = ImmutableList.of("A", "B", "C");
    sendMessages(testAckIdsBatch1);

    // Trigger ack sending
    fakeExecutor.advanceTime(PENDING_ACKS_SEND_DELAY);

    assertEquivalent(testAckIdsBatch1, fakeSubscriberServiceImpl.waitAndConsumeReceivedAcks(3));

    // Ensures the next ack sending alarm gets properly setup
    List<String> testAckIdsBatch2 = ImmutableList.of("D", "E");
    sendMessages(testAckIdsBatch2);

    fakeExecutor.advanceTime(PENDING_ACKS_SEND_DELAY);

    assertEquivalent(testAckIdsBatch2, fakeSubscriberServiceImpl.waitAndConsumeReceivedAcks(2));

    subscriber.stopAsync().awaitTerminated();
  }

  @Test
  public void testBatchAcksAndNacks() throws Exception {
    Subscriber subscriber = startSubscriber(getTestSubscriberBuilder(testReceiver));

    // Send messages to be acked
    List<String> testAckIdsBatch1 = ImmutableList.of("A", "B", "C");
    sendMessages(testAckIdsBatch1);

    // Send messages to be nacked
    List<String> testAckIdsBatch2 = ImmutableList.of("D", "E");
    // Nack messages
    testReceiver.setNackReply();
    sendMessages(testAckIdsBatch2);

    // Trigger ack sending
    fakeExecutor.advanceTime(PENDING_ACKS_SEND_DELAY);

    assertEquivalent(testAckIdsBatch1, fakeSubscriberServiceImpl.waitAndConsumeReceivedAcks(3));
    assertEquivalent(
        ImmutableList.of(new ModifyAckDeadline("D", 0), new ModifyAckDeadline("E", 0)),
        fakeSubscriberServiceImpl.waitAndConsumeModifyAckDeadlines(2));

    subscriber.stopAsync().awaitTerminated();
  }

  @Test
  public void testModifyAckDeadline() throws Exception {
    Subscriber subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setAckExpirationPadding(Duration.ofSeconds(1))
                .setMaxAckExtensionPeriod(Duration.ofSeconds(13)));
    // Send messages to be acked
    List<String> testAckIdsBatch = ImmutableList.of("A", "B", "C");
    testReceiver.setExplicitAck(true);
    // A modify ack deadline should be scheduled for the next 9s
    fakeExecutor.setupScheduleExpectation(Duration.ofSeconds(9));
    sendMessages(testAckIdsBatch);
    // To ensure first modify ack deadline got scheduled
    fakeExecutor.waitForExpectedWork();

    fakeExecutor.advanceTime(Duration.ofSeconds(9));

    assertEquivalentWithTransformation(
        testAckIdsBatch,
        fakeSubscriberServiceImpl.waitAndConsumeModifyAckDeadlines(3),
        new Function<String, ModifyAckDeadline>() {
          @Override
          public ModifyAckDeadline apply(String ack) {
            return new ModifyAckDeadline(ack, INITIAL_ACK_DEADLINE_EXTENSION_SECS);
          }
        });

    fakeExecutor.advanceTime(Duration.ofSeconds(1));

    assertEquivalentWithTransformation(
        testAckIdsBatch,
        fakeSubscriberServiceImpl.waitAndConsumeModifyAckDeadlines(3),
        new Function<String, ModifyAckDeadline>() {
          @Override
          public ModifyAckDeadline apply(String ack) {
            return new ModifyAckDeadline(ack, 3); // It is expected that the deadline is renewed
                                                  // only three more seconds to not pass the max
                                                  // ack deadline ext.
          }
        });

    // No more modify ack deadline extension should be triggered at this point
    fakeExecutor.advanceTime(Duration.ofSeconds(20));

    assertTrue(fakeSubscriberServiceImpl.getModifyAckDeadlines().isEmpty());

    testReceiver.replyAllOutstandingMessage();
    subscriber.stopAsync().awaitTerminated();
  }

  @Test
  public void testModifyAckDeadline_defaultMaxExtensionPeriod() throws Exception {
    Subscriber subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setAckExpirationPadding(Duration.ofSeconds(1)));
    // Send messages to be acked
    List<String> testAckIdsBatch = ImmutableList.of("A", "B", "C");
    testReceiver.setExplicitAck(true);
    // A modify ack deadline should be schedule for the next 9s
    fakeExecutor.setupScheduleExpectation(Duration.ofSeconds(9));
    sendMessages(testAckIdsBatch);
    // To ensure the first modify ack deadlines got scheduled
    fakeExecutor.waitForExpectedWork();

    // Next modify ack deadline should be schedule in the next 1s
    fakeExecutor.advanceTime(Duration.ofSeconds(9));

    assertEquivalentWithTransformation(
        testAckIdsBatch,
        fakeSubscriberServiceImpl.waitAndConsumeModifyAckDeadlines(3),
        new Function<String, ModifyAckDeadline>() {
          @Override
          public ModifyAckDeadline apply(String ack) {
            return new ModifyAckDeadline(ack, INITIAL_ACK_DEADLINE_EXTENSION_SECS);
          }
        });

    fakeExecutor.advanceTime(Duration.ofSeconds(1));
    int timeIncrementSecs = INITIAL_ACK_DEADLINE_EXTENSION_SECS; // Second time increment

    // Check ack deadline extensions while the current time has not reached 60 minutes
    while (fakeExecutor.getClock().millisTime() + timeIncrementSecs - 1 < 1000 * 60 * 60) {
      timeIncrementSecs *= 2;
      final int expectedIncrementSecs = Math.min(600, timeIncrementSecs);
      assertEquivalentWithTransformation(
          testAckIdsBatch,
          fakeSubscriberServiceImpl.waitAndConsumeModifyAckDeadlines(3),
          new Function<String, ModifyAckDeadline>() {
            @Override
            public ModifyAckDeadline apply(String ack) {
              return new ModifyAckDeadline(ack, expectedIncrementSecs);
            }
          });
      fakeExecutor.advanceTime(Duration.ofSeconds(timeIncrementSecs - 1));
    }

    // No more modify ack deadline extension should be triggered at this point
    fakeExecutor.advanceTime(Duration.ofSeconds(20));

    assertTrue(fakeSubscriberServiceImpl.getModifyAckDeadlines().isEmpty());

    testReceiver.replyAllOutstandingMessage();
    subscriber.stopAsync().awaitTerminated();
  }

  @Test
  public void testStreamAckDeadlineUpdate() throws Exception {
    if (!isStreamingTest) {
      // This test is not applicable to polling.
      return;
    }

    Subscriber subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setAckExpirationPadding(Duration.ofSeconds(1)));

    fakeSubscriberServiceImpl.waitForStreamAckDeadline(10);

    // Send messages to be acked
    testReceiver.setExplicitAck(true);
    sendMessages(ImmutableList.of("A"));

    // Make the ack latency of the receiver equals 20 seconds
    fakeExecutor.advanceTime(Duration.ofSeconds(20));
    testReceiver.replyNextOutstandingMessage();

    // Wait for an ack deadline update
    fakeExecutor.advanceTime(Duration.ofSeconds(60));

    fakeSubscriberServiceImpl.waitForStreamAckDeadline(20);

    // Send more messages to be acked
    testReceiver.setExplicitAck(true);
    for (int i = 0; i < 999; i++) {
      sendMessages(ImmutableList.of(Integer.toString(i)));
    }

    // Reduce the 99th% ack latency of the receiver to 10 seconds
    fakeExecutor.advanceTime(Duration.ofSeconds(10));
    for (int i = 0; i < 999; i++) {
      testReceiver.replyNextOutstandingMessage();
    }

    // Wait for an ack deadline update
    fakeExecutor.advanceTime(Duration.ofSeconds(60));

    fakeSubscriberServiceImpl.waitForStreamAckDeadline(10);

    subscriber.stopAsync().awaitTerminated();
  }

  @Test
  public void testOpenedChannels() throws Exception {
    if (!isStreamingTest) {
      // This test is not applicable to polling.
      return;
    }

    final int expectedChannelCount =
        Runtime.getRuntime().availableProcessors() * Subscriber.CHANNELS_PER_CORE;

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

    final int expectedChannelCount =
        Runtime.getRuntime().availableProcessors() * Subscriber.CHANNELS_PER_CORE;

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
      assertEquals(
          Status.INVALID_ARGUMENT,
          ((StatusRuntimeException) subscriber.failureCause()).getStatus());
    }
  }

  private Subscriber startSubscriber(Builder testSubscriberBuilder) throws Exception {
    Subscriber subscriber = testSubscriberBuilder.setUseStreaming(isStreamingTest).build();
    subscriber.startAsync().awaitRunning();
    return subscriber;
  }

  private void sendMessages(Iterable<String> ackIds) throws InterruptedException {
    List<ReceivedMessage> messages = new ArrayList<ReceivedMessage>();
    for (String ackId : ackIds) {
      messages.add(ReceivedMessage.newBuilder().setAckId(ackId).setMessage(TEST_MESSAGE).build());
    }
    testReceiver.setExpectedMessages(messages.size());
    if (isStreamingTest) {
      fakeSubscriberServiceImpl.sendStreamingResponse(
          StreamingPullResponse.newBuilder().addAllReceivedMessages(messages).build());
    } else {
      fakeSubscriberServiceImpl.enqueuePullResponse(
          PullResponse.newBuilder().addAllReceivedMessages(messages).build());
    }
    testReceiver.waitForExpectedMessages();
  }

  private Builder getTestSubscriberBuilder(MessageReceiver receiver) {
    return Subscriber.defaultBuilder(TEST_SUBSCRIPTION, receiver)
        .setExecutorProvider(FixedExecutorProvider.create(fakeExecutor))
        .setSystemExecutorProvider(FixedExecutorProvider.create(fakeExecutor))
        .setChannelProvider(FixedChannelProvider.create(testChannel))
        .setCredentialsProvider(PublisherImplTest.NO_CREDENTIALS_PROVIDER)
        .setClock(fakeExecutor.getClock());
  }

  @SuppressWarnings("unchecked")
  private <T> void assertEquivalent(Collection<T> expectedElems, Collection<T> target) {
    List<T> remaining = new ArrayList<T>(target.size());
    remaining.addAll(target);

    for (T expectedElem : expectedElems) {
      if (!remaining.contains(expectedElem)) {
        throw new AssertionError(
            String.format("Expected element %s is not contained in %s", expectedElem, target));
      }
      remaining.remove(expectedElem);
    }
  }

  @SuppressWarnings("unchecked")
  private <T, E> void assertEquivalentWithTransformation(
      Collection<E> expectedElems, Collection<T> target, Function<E, T> transform) {
    List<T> remaining = new ArrayList<T>(target.size());
    remaining.addAll(target);

    for (E expectedElem : expectedElems) {
      T expected = transform.apply(expectedElem);
      if (!remaining.contains(expected)) {
        throw new AssertionError(
            String.format("Expected element %s is not contained in %s", expected, target));
      }
      remaining.remove(expectedElem);
    }
  }
}

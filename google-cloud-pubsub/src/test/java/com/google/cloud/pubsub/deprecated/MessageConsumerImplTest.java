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

package com.google.cloud.pubsub.deprecated;

import com.google.cloud.GrpcServiceOptions.ExecutorFactory;
import com.google.cloud.pubsub.deprecated.PubSub.MessageConsumer;
import com.google.cloud.pubsub.deprecated.PubSub.MessageProcessor;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpc;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpc.PullCallback;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpc.PullFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class MessageConsumerImplTest {

  private static final String PROJECT = "project";
  private static final String SUBSCRIPTION = "subscription";
  private static final String SUBSCRIPTION_PB = "projects/project/subscriptions/subscription";
  private static final int MAX_QUEUED_CALLBACKS = 42;
  private static final Message MESSAGE1 = Message.of("payload1");
  private static final Message MESSAGE2 = Message.of("payload2");
  private static final String ACK_ID1 = "ack-id1";
  private static final String ACK_ID2 = "ack-id2";
  private static final com.google.pubsub.v1.ReceivedMessage MESSAGE1_PB =
      com.google.pubsub.v1.ReceivedMessage.newBuilder()
          .setAckId(ACK_ID1)
          .setMessage(MESSAGE1.toPb())
          .build();
  private static final com.google.pubsub.v1.ReceivedMessage MESSAGE2_PB =
      com.google.pubsub.v1.ReceivedMessage.newBuilder()
          .setAckId(ACK_ID2)
          .setMessage(MESSAGE2.toPb())
          .build();
  private static final PullResponse PULL_RESPONSE = PullResponse.newBuilder()
      .addReceivedMessages(MESSAGE1_PB)
      .addReceivedMessages(MESSAGE2_PB)
      .build();
  private static final MessageProcessor DO_NOTHING_PROCESSOR = new MessageProcessor() {
    @Override
    public void process(Message message) throws Exception {
      // do nothing
    }
  };
  private static final MessageProcessor THROW_PROCESSOR = new MessageProcessor() {
    @Override
    public void process(Message message) throws Exception {
      throw new RuntimeException();
    }
  };
  private static final PullResponse EMPTY_RESPONSE = PullResponse.getDefaultInstance();

  private PubSubRpc pubsubRpc;
  private PubSub pubsub;
  private PubSubOptions options;
  private AckDeadlineRenewer renewer;

  @Rule
  public Timeout globalTimeout = Timeout.seconds(60);

  static final class TestPullFuture
      extends ForwardingListenableFuture.SimpleForwardingListenableFuture<PullResponse>
      implements PullFuture {

    TestPullFuture(PullResponse response) {
      super(Futures.immediateFuture(response));
    }

    @Override
    public void addCallback(final PullCallback callback) {
      Futures.addCallback(delegate(), new FutureCallback<PullResponse>() {
        @Override
        public void onSuccess(PullResponse result) {
          callback.success(result);
        }

        @Override
        public void onFailure(Throwable error) {
          callback.failure(error);
        }
      });
    }
  }

  @Before
  public void setUp() {
    pubsubRpc = EasyMock.createStrictMock(PubSubRpc.class);
    pubsub = EasyMock.createMock(PubSub.class);
    options = EasyMock.createStrictMock(PubSubOptions.class);
    renewer = EasyMock.createMock(AckDeadlineRenewer.class);
  }

  @After
  public void tearDown() {
    EasyMock.verify(pubsubRpc);
    EasyMock.verify(pubsub);
    EasyMock.verify(options);
    EasyMock.verify(renewer);

  }

  private static PullRequest pullRequest(int maxQueuedCallbacks) {
    return PullRequest.newBuilder()
        .setMaxMessages(maxQueuedCallbacks)
        .setSubscription(SUBSCRIPTION_PB)
        .setReturnImmediately(false)
        .build();
  }

  private static IAnswer<Void> createAnswer(final CountDownLatch latch) {
    return new IAnswer<Void>() {
      @Override
      public Void answer() throws Throwable {
        latch.countDown();
        return null;
      }
    };
  }

  @Test
  public void testMessageConsumerAck() throws Exception {
    PullRequest request = pullRequest(MAX_QUEUED_CALLBACKS);
    EasyMock.expect(options.getRpc()).andReturn(pubsubRpc);
    EasyMock.expect(options.getService()).andReturn(pubsub);
    EasyMock.expect(options.getProjectId()).andReturn(PROJECT).anyTimes();
    EasyMock.expect(pubsub.getOptions()).andReturn(options).times(2);
    final CountDownLatch latch = new CountDownLatch(2);
    EasyMock.expect(pubsub.ackAsync(SUBSCRIPTION, ACK_ID1)).andReturn(null);
    EasyMock.expect(pubsub.ackAsync(SUBSCRIPTION, ACK_ID2)).andReturn(null);
    EasyMock.replay(pubsub);
    EasyMock.expect(pubsubRpc.pull(request)).andReturn(new TestPullFuture(PULL_RESPONSE));
    EasyMock.expect(pubsubRpc.pull(EasyMock.<PullRequest>anyObject()))
        .andReturn(new TestPullFuture(EMPTY_RESPONSE)).anyTimes();
    renewer.add(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall();
    renewer.add(SUBSCRIPTION, ACK_ID2);
    EasyMock.expectLastCall();
    renewer.remove(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    renewer.remove(SUBSCRIPTION, ACK_ID2);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    EasyMock.replay(pubsubRpc, options, renewer);
    try (MessageConsumer consumer =
         MessageConsumerImpl.builder(options, SUBSCRIPTION, renewer, DO_NOTHING_PROCESSOR)
             .maxQueuedCallbacks(MAX_QUEUED_CALLBACKS)
             .build()) {
      latch.await();
    }
  }

  @Test
  public void testMessageConsumerNack() throws Exception {
    PullRequest request = pullRequest(MAX_QUEUED_CALLBACKS);
    EasyMock.expect(options.getRpc()).andReturn(pubsubRpc);
    EasyMock.expect(options.getService()).andReturn(pubsub);
    EasyMock.expect(options.getProjectId()).andReturn(PROJECT).anyTimes();
    EasyMock.expect(pubsub.getOptions()).andReturn(options).times(2);
    final CountDownLatch latch = new CountDownLatch(2);
    EasyMock.expect(pubsub.nackAsync(SUBSCRIPTION, ACK_ID1)).andReturn(null);
    EasyMock.expect(pubsub.nackAsync(SUBSCRIPTION, ACK_ID2)).andReturn(null);
    EasyMock.replay(pubsub);
    EasyMock.expect(pubsubRpc.pull(request)).andReturn(new TestPullFuture(PULL_RESPONSE));
    EasyMock.expect(pubsubRpc.pull(EasyMock.<PullRequest>anyObject()))
        .andReturn(new TestPullFuture(EMPTY_RESPONSE)).anyTimes();
    renewer.add(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall();
    renewer.add(SUBSCRIPTION, ACK_ID2);
    EasyMock.expectLastCall();
    renewer.remove(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    renewer.remove(SUBSCRIPTION, ACK_ID2);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    EasyMock.replay(pubsubRpc, options, renewer);
    try (MessageConsumer consumer =
        MessageConsumerImpl.builder(options, SUBSCRIPTION, renewer, THROW_PROCESSOR)
            .maxQueuedCallbacks(MAX_QUEUED_CALLBACKS)
            .build()) {
      latch.await();
    }
  }

  @Test
  public void testMessageConsumerMultipleCallsAck() throws Exception {
    PullRequest request1 = pullRequest(MAX_QUEUED_CALLBACKS);
    PullRequest request2 = pullRequest(MAX_QUEUED_CALLBACKS - 1);
    PullResponse response1 = PullResponse.newBuilder()
        .addReceivedMessages(MESSAGE1_PB)
        .build();
    final PullResponse response2 = PullResponse.newBuilder()
        .addReceivedMessages(MESSAGE2_PB)
        .build();
    EasyMock.expect(options.getRpc()).andReturn(pubsubRpc);
    EasyMock.expect(options.getService()).andReturn(pubsub);
    EasyMock.expect(options.getProjectId()).andReturn(PROJECT).anyTimes();
    final CountDownLatch nextPullLatch = new CountDownLatch(1);
    final CountDownLatch latch = new CountDownLatch(2);
    EasyMock.expect(pubsub.getOptions()).andReturn(options);
    EasyMock.expect(pubsub.ackAsync(SUBSCRIPTION, ACK_ID1)).andAnswer(new IAnswer<Future<Void>>() {
      @Override
      public Future<Void> answer() throws Throwable {
        nextPullLatch.await();
        return null;
      }
    });
    EasyMock.expect(pubsub.getOptions()).andReturn(options);
    EasyMock.expect(pubsub.ackAsync(SUBSCRIPTION, ACK_ID2)).andReturn(null);
    EasyMock.replay(pubsub);
    EasyMock.expect(pubsubRpc.pull(request1)).andReturn(new TestPullFuture(response1));
    EasyMock.expect(pubsubRpc.pull(request2)).andAnswer(new IAnswer<PullFuture>() {
      @Override
      public PullFuture answer() throws Throwable {
        nextPullLatch.countDown();
        return new TestPullFuture(response2);
      }
    });
    EasyMock.expect(pubsubRpc.pull(EasyMock.<PullRequest>anyObject()))
        .andReturn(new TestPullFuture(EMPTY_RESPONSE)).anyTimes();
    renewer.add(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall();
    renewer.remove(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    renewer.add(SUBSCRIPTION, ACK_ID2);
    EasyMock.expectLastCall();
    renewer.remove(SUBSCRIPTION, ACK_ID2);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    EasyMock.replay(pubsubRpc, options, renewer);
    try (MessageConsumer consumer =
        MessageConsumerImpl.builder(options, SUBSCRIPTION, renewer, DO_NOTHING_PROCESSOR)
            .maxQueuedCallbacks(MAX_QUEUED_CALLBACKS)
            .build()) {
      latch.await();
    }
  }

  @Test
  public void testMessageConsumerMultipleCallsNack() throws Exception {
    PullRequest request1 = pullRequest(MAX_QUEUED_CALLBACKS);
    PullRequest request2 = pullRequest(MAX_QUEUED_CALLBACKS - 1);
    PullResponse response1 = PullResponse.newBuilder()
        .addReceivedMessages(MESSAGE1_PB)
        .build();
    final PullResponse response2 = PullResponse.newBuilder()
        .addReceivedMessages(MESSAGE2_PB)
        .build();
    EasyMock.expect(options.getRpc()).andReturn(pubsubRpc);
    EasyMock.expect(options.getService()).andReturn(pubsub);
    EasyMock.expect(options.getProjectId()).andReturn(PROJECT).anyTimes();
    final CountDownLatch nextPullLatch = new CountDownLatch(1);
    final CountDownLatch latch = new CountDownLatch(2);
    EasyMock.expect(pubsub.getOptions()).andReturn(options);
    EasyMock.expect(pubsub.nackAsync(SUBSCRIPTION, ACK_ID1)).andAnswer(new IAnswer<Future<Void>>() {
      @Override
      public Future<Void> answer() throws Throwable {
        nextPullLatch.await();
        return null;
      }
    });
    EasyMock.expect(pubsub.getOptions()).andReturn(options);
    EasyMock.expect(pubsub.nackAsync(SUBSCRIPTION, ACK_ID2)).andReturn(null);
    EasyMock.replay(pubsub);
    EasyMock.expect(pubsubRpc.pull(request1)).andReturn(new TestPullFuture(response1));
    EasyMock.expect(pubsubRpc.pull(request2)).andAnswer(new IAnswer<PullFuture>() {
      @Override
      public PullFuture answer() throws Throwable {
        nextPullLatch.countDown();
        return new TestPullFuture(response2);
      }
    });
    EasyMock.expect(pubsubRpc.pull(EasyMock.<PullRequest>anyObject()))
        .andReturn(new TestPullFuture(EMPTY_RESPONSE)).anyTimes();
    renewer.add(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall();
    renewer.remove(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    renewer.add(SUBSCRIPTION, ACK_ID2);
    EasyMock.expectLastCall();
    renewer.remove(SUBSCRIPTION, ACK_ID2);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    EasyMock.replay(pubsubRpc, options, renewer);
    try (MessageConsumer consumer =
        MessageConsumerImpl.builder(options, SUBSCRIPTION, renewer, THROW_PROCESSOR)
            .maxQueuedCallbacks(MAX_QUEUED_CALLBACKS)
            .build()) {
      latch.await();
    }
  }

  @Test
  public void testMessageConsumerMaxCallbacksAck() throws Exception {
    PullRequest request1 = pullRequest(2);
    PullRequest request2 = pullRequest(1);
    final PullResponse otherPullResponse = PullResponse.newBuilder()
        .addReceivedMessages(MESSAGE1_PB)
        .build();
    EasyMock.expect(options.getRpc()).andReturn(pubsubRpc);
    EasyMock.expect(options.getService()).andReturn(pubsub);
    EasyMock.expect(options.getProjectId()).andReturn(PROJECT).anyTimes();
    EasyMock.expect(pubsub.getOptions()).andReturn(options).times(2);
    final CountDownLatch nextPullLatch = new CountDownLatch(1);
    final CountDownLatch latch = new CountDownLatch(3);
    EasyMock.expect(pubsub.ackAsync(SUBSCRIPTION, ACK_ID1)).andReturn(null);
    EasyMock.expect(pubsub.ackAsync(SUBSCRIPTION, ACK_ID2)).andAnswer(new IAnswer<Future<Void>>() {
      @Override
      public Future<Void> answer() throws Throwable {
        nextPullLatch.await();
        return null;
      }
    });
    EasyMock.expect(pubsub.getOptions()).andReturn(options);
    EasyMock.expect(pubsub.ackAsync(SUBSCRIPTION, ACK_ID1)).andReturn(null);
    EasyMock.replay(pubsub);
    EasyMock.expect(pubsubRpc.pull(request1)).andReturn(new TestPullFuture(PULL_RESPONSE));
    EasyMock.expect(pubsubRpc.pull(request2)).andAnswer(new IAnswer<PullFuture>() {
      @Override
      public PullFuture answer() throws Throwable {
        nextPullLatch.countDown();
        return new TestPullFuture(otherPullResponse);
      }
    });
    EasyMock.expect(pubsubRpc.pull(EasyMock.<PullRequest>anyObject()))
        .andReturn(new TestPullFuture(EMPTY_RESPONSE)).anyTimes();
    renewer.add(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall();
    renewer.add(SUBSCRIPTION, ACK_ID2);
    EasyMock.expectLastCall();
    renewer.remove(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    renewer.remove(SUBSCRIPTION, ACK_ID2);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    renewer.add(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall();
    renewer.remove(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    EasyMock.replay(pubsubRpc, options, renewer);
    try (MessageConsumer consumer =
         MessageConsumerImpl.builder(options, SUBSCRIPTION, renewer, DO_NOTHING_PROCESSOR)
             .maxQueuedCallbacks(2)
             .build()) {
      latch.await();
    }
  }

  @Test
  public void testMessageConsumerMaxCallbacksNack() throws Exception {
    PullRequest request1 = pullRequest(2);
    PullRequest request2 = pullRequest(1);
    final PullResponse otherPullResponse = PullResponse.newBuilder()
        .addReceivedMessages(MESSAGE1_PB)
        .build();
    EasyMock.expect(options.getRpc()).andReturn(pubsubRpc);
    EasyMock.expect(options.getService()).andReturn(pubsub);
    EasyMock.expect(options.getProjectId()).andReturn(PROJECT).anyTimes();
    EasyMock.expect(pubsub.getOptions()).andReturn(options).times(2);
    final CountDownLatch nextPullLatch = new CountDownLatch(1);
    final CountDownLatch latch = new CountDownLatch(3);
    EasyMock.expect(pubsub.nackAsync(SUBSCRIPTION, ACK_ID1)).andReturn(null);
    EasyMock.expect(pubsub.nackAsync(SUBSCRIPTION, ACK_ID2)).andAnswer(new IAnswer<Future<Void>>() {
      @Override
      public Future<Void> answer() throws Throwable {
        nextPullLatch.await();
        return null;
      }
    });
    EasyMock.expect(pubsub.getOptions()).andReturn(options);
    EasyMock.expect(pubsub.nackAsync(SUBSCRIPTION, ACK_ID1)).andReturn(null);
    EasyMock.replay(pubsub);
    EasyMock.expect(pubsubRpc.pull(request1)).andReturn(new TestPullFuture(PULL_RESPONSE));
    EasyMock.expect(pubsubRpc.pull(request2)).andAnswer(new IAnswer<PullFuture>() {
      @Override
      public PullFuture answer() throws Throwable {
        nextPullLatch.countDown();
        return new TestPullFuture(otherPullResponse);
      }
    });
    EasyMock.expect(pubsubRpc.pull(EasyMock.<PullRequest>anyObject()))
        .andReturn(new TestPullFuture(EMPTY_RESPONSE)).anyTimes();
    renewer.add(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall();
    renewer.add(SUBSCRIPTION, ACK_ID2);
    EasyMock.expectLastCall();
    renewer.remove(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    renewer.remove(SUBSCRIPTION, ACK_ID2);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    renewer.add(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall();
    renewer.remove(SUBSCRIPTION, ACK_ID1);
    EasyMock.expectLastCall().andAnswer(createAnswer(latch));
    EasyMock.replay(pubsubRpc, options, renewer);
    try (MessageConsumer consumer =
         MessageConsumerImpl.builder(options, SUBSCRIPTION, renewer, THROW_PROCESSOR)
             .maxQueuedCallbacks(2)
             .build()) {
      latch.await();
    }
  }

  @Test
  public void testClose() throws Exception {
    EasyMock.expect(options.getRpc()).andReturn(pubsubRpc);
    EasyMock.expect(options.getService()).andReturn(pubsub);
    final ExecutorService executor = EasyMock.createStrictMock(ExecutorService.class);
    executor.shutdown();
    EasyMock.expectLastCall();
    EasyMock.replay(pubsubRpc, pubsub, options, executor, renewer);
    MessageConsumer consumer =
        MessageConsumerImpl.builder(options, SUBSCRIPTION, renewer, DO_NOTHING_PROCESSOR)
            .maxQueuedCallbacks(MAX_QUEUED_CALLBACKS)
            .executorFactory(new ExecutorFactory<ExecutorService>() {
              @Override
              public ExecutorService get() {
                return executor;
              }

              @Override
              public void release(ExecutorService executor) {
                executor.shutdown();
              }
            }).build();
    consumer.close();
    // closing again should do nothing
    consumer.close();
    EasyMock.verify(executor);
  }
}

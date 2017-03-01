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

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.cloud.GrpcServiceOptions.ExecutorFactory;
import com.google.cloud.pubsub.deprecated.PubSub.MessageConsumer;
import com.google.cloud.pubsub.deprecated.PubSub.MessageProcessor;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpc;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpc.PullCallback;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpc.PullFuture;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.SubscriptionName;
import io.grpc.internal.SharedResourceHolder;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Default implementation for a message consumer.
 */
final class MessageConsumerImpl implements MessageConsumer {

  private static final int MAX_QUEUED_CALLBACKS = 100;
  // shared scheduled executor, used to schedule pulls
  private static final SharedResourceHolder.Resource<ExecutorService> CONSUMER_EXECUTOR =
      new SharedResourceHolder.Resource<ExecutorService>() {
        @Override
        public ExecutorService create() {
          return Executors.newSingleThreadExecutor();
        }

        @Override
        public void close(ExecutorService instance) {
          instance.shutdown();
        }
      };

  private final PubSubOptions pubsubOptions;
  private final PubSubRpc pubsubRpc;
  private final PubSub pubsub;
  private final AckDeadlineRenewer deadlineRenewer;
  private final String subscription;
  private final MessageProcessor messageProcessor;
  private final ExecutorService consumerExecutor;
  private final ExecutorFactory<ExecutorService> executorFactory;
  private final ExecutorService executor;
  private final AtomicInteger queuedCallbacks;
  private final int maxQueuedCallbacks;
  private final Object futureLock = new Object();
  private final Runnable consumerRunnable;
  private final NextPullPolicy pullPolicy;
  private boolean closed;
  private Future<?> scheduledFuture;
  private PullFuture pullerFuture;

  /**
   * Interface for policies according to which the consumer should pull messages.
   */
  interface NextPullPolicy {

    boolean shouldPull(int queuedCallbacks);
  }

  /**
   * Default pull policy. The consumer will pull again once {@code nextPullThreshold} messages out
   * of {@code maxQueuedCallbacks} have been processed.
   */
  static class DefaultNextPullPolicy implements NextPullPolicy {

    final int maxQueuedCallbacks;
    final int nextPullThreshold;

    DefaultNextPullPolicy(int maxQueuedCallbacks, int nextPullThreshold) {
      this.maxQueuedCallbacks = maxQueuedCallbacks;
      this.nextPullThreshold = nextPullThreshold;
    }

    @Override
    public boolean shouldPull(int queuedCallbacks) {
      return (maxQueuedCallbacks - queuedCallbacks) >= nextPullThreshold;
    }
  }

  /**
   * Default executor factory for the message processor executor. By default a single-threaded
   * executor is used.
   */
  static class DefaultExecutorFactory implements ExecutorFactory<ExecutorService> {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    public ExecutorService get() {
      return executor;
    }

    @Override
    public void release(ExecutorService executor) {
      executor.shutdownNow();
    }
  }

  class ConsumerRunnable implements Runnable {

    @Override
    public void run() {
      if (closed) {
        return;
      }
      pullerFuture = pubsubRpc.pull(createPullRequest());
      pullerFuture.addCallback(new PullCallback() {
        @Override
        public void success(PullResponse response) {
          List<com.google.pubsub.v1.ReceivedMessage> messages = response.getReceivedMessagesList();
          queuedCallbacks.addAndGet(messages.size());
          for (com.google.pubsub.v1.ReceivedMessage message : messages) {
            deadlineRenewer.add(subscription, message.getAckId());
            ReceivedMessage receivedMessage = ReceivedMessage.fromPb(pubsub, subscription, message);
            executor.execute(ackingRunnable(receivedMessage));
          }
          nextPull();
        }

        @Override
        public void failure(Throwable error) {
          if (!(error instanceof CancellationException)) {
            nextPull();
          }
        }
      });
    }

    private PullRequest createPullRequest() {
      return PullRequest.newBuilder()
          .setSubscriptionWithSubscriptionName(
              SubscriptionName.create(pubsubOptions.getProjectId(), subscription))
          .setMaxMessages(maxQueuedCallbacks - queuedCallbacks.get())
          .setReturnImmediately(false)
          .build();
    }

    private Runnable ackingRunnable(final ReceivedMessage receivedMessage) {
      return new Runnable() {
        @Override
        public void run() {
          try {
            messageProcessor.process(receivedMessage);
            pubsub.ackAsync(receivedMessage.getSubscription(), receivedMessage.getAckId());
          } catch (Exception ex) {
            pubsub.nackAsync(receivedMessage.getSubscription(), receivedMessage.getAckId());
          } finally {
            deadlineRenewer.remove(receivedMessage.getSubscription(), receivedMessage.getAckId());
            queuedCallbacks.decrementAndGet();
            // We can now pull more messages, according to the next pull policy.
            pullIfNeeded();
          }
        }
      };
    }
  }

  private MessageConsumerImpl(Builder builder) {
    this.pubsubOptions = builder.pubsubOptions;
    this.subscription = builder.subscription;
    this.messageProcessor = builder.messageProcessor;
    this.pubsubRpc = pubsubOptions.getRpc();
    this.pubsub = pubsubOptions.getService();
    this.deadlineRenewer = builder.deadlineRenewer;
    this.queuedCallbacks = new AtomicInteger();
    this.consumerExecutor = SharedResourceHolder.get(CONSUMER_EXECUTOR);
    this.executorFactory =
        builder.executorFactory != null ? builder.executorFactory : new DefaultExecutorFactory();
    this.executor = executorFactory.get();
    this.maxQueuedCallbacks = firstNonNull(builder.maxQueuedCallbacks, MAX_QUEUED_CALLBACKS);
    this.consumerRunnable = new ConsumerRunnable();
    int nextPullThreshold = builder.nextPullThreshold != null ? builder.nextPullThreshold
        : this.maxQueuedCallbacks / 2;
    this.pullPolicy = new DefaultNextPullPolicy(maxQueuedCallbacks, nextPullThreshold);
    nextPull();
  }

  private void pullIfNeeded() {
    synchronized (futureLock) {
      if (closed || scheduledFuture != null || !pullPolicy.shouldPull(queuedCallbacks.get())) {
        return;
      }
      scheduledFuture = consumerExecutor.submit(consumerRunnable);
    }
  }

  private void nextPull() {
    synchronized (futureLock) {
      if (closed || queuedCallbacks.get() == maxQueuedCallbacks) {
        scheduledFuture = null;
        return;
      }
      scheduledFuture = consumerExecutor.submit(consumerRunnable);
    }
  }

  @Override
  public void close() {
    synchronized (futureLock) {
      if (closed) {
        return;
      }
      closed = true;
      if (scheduledFuture != null) {
        scheduledFuture.cancel(true);
      }
      if (pullerFuture != null) {
        pullerFuture.cancel(true);
      }
    }
    SharedResourceHolder.release(CONSUMER_EXECUTOR, consumerExecutor);
    executorFactory.release(executor);
  }

  static final class Builder {
    private final PubSubOptions pubsubOptions;
    private final String subscription;
    private final AckDeadlineRenewer deadlineRenewer;
    private final MessageProcessor messageProcessor;
    private Integer maxQueuedCallbacks;
    private ExecutorFactory<ExecutorService> executorFactory;
    private Integer nextPullThreshold;

    Builder(PubSubOptions pubsubOptions, String subscription, AckDeadlineRenewer deadlineRenewer,
        MessageProcessor messageProcessor) {
      this.pubsubOptions = pubsubOptions;
      this.subscription = subscription;
      this.deadlineRenewer = deadlineRenewer;
      this.messageProcessor = messageProcessor;
    }

    /**
     * Sets the maximum number of callbacks either being executed or waiting for execution.
     */
    Builder maxQueuedCallbacks(Integer maxQueuedCallbacks) {
      this.maxQueuedCallbacks = maxQueuedCallbacks;
      return this;
    }

    /**
     * Sets the executor factory, used to manage the executor that will run message processor
     * callbacks message consumer.
     */
    Builder executorFactory(ExecutorFactory<ExecutorService> executorFactory) {
      this.executorFactory = executorFactory;
      return this;
    }

    /**
     * Sets a threshold for the next pull. If the consumer stopped pulling due to reaching the
     * maximum number of queued callbacks, it will be pull again only once at least
     * {@code nextPullThreshold} callbacks have completed their execution.
     */
    Builder nextPullThreshold(Integer nextPullThreshold) {
      this.nextPullThreshold = nextPullThreshold;
      return this;
    }

    /**
     * Creates a {@code MessageConsumerImpl} object.
     */
    MessageConsumerImpl build() {
      return new MessageConsumerImpl(this);
    }
  }

  /**
   * Returns a builder for {@code MessageConsumerImpl} objects given the service options, the
   * subscription from which messages must be pulled, the acknowledge deadline renewer and a message
   * processor used to process messages.
   */
  static Builder builder(PubSubOptions pubsubOptions, String subscription,
      AckDeadlineRenewer deadlineRenewer, MessageProcessor messageProcessor) {
    return new Builder(pubsubOptions, subscription, deadlineRenewer, messageProcessor);
  }
}

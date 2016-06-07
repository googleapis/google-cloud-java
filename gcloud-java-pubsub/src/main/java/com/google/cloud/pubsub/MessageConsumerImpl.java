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

package com.google.cloud.pubsub;

import static com.google.cloud.pubsub.spi.v1.SubscriberApi.formatSubscriptionName;
import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.cloud.GrpcServiceOptions.ExecutorFactory;
import com.google.cloud.pubsub.PubSub.MessageConsumer;
import com.google.cloud.pubsub.PubSub.MessageProcessor;
import com.google.cloud.pubsub.spi.PubSubRpc;
import com.google.cloud.pubsub.spi.PubSubRpc.PullCallback;
import com.google.cloud.pubsub.spi.PubSubRpc.PullFuture;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;

import io.grpc.internal.SharedResourceHolder;

import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Default implementation for a message consumer.
 */
final class MessageConsumerImpl implements MessageConsumer {

  private static final int MAX_QUEUED_CALLBACKS = 100;
  // shared scheduled executor, used to schedule pulls
  private static final SharedResourceHolder.Resource<ScheduledExecutorService> TIMER =
      new SharedResourceHolder.Resource<ScheduledExecutorService>() {
        @Override
        public ScheduledExecutorService create() {
          ScheduledThreadPoolExecutor timer = new ScheduledThreadPoolExecutor(1);
          timer.setRemoveOnCancelPolicy(true);
          return timer;
        }

        @Override
        public void close(ScheduledExecutorService instance) {
          instance.shutdown();
        }
      };

  private final PubSubOptions pubsubOptions;
  private final PubSubRpc pubsubRpc;
  private final PubSub pubsub;
  private final AckDeadlineRenewer deadlineRenewer;
  private final String subscription;
  private final MessageProcessor messageProcessor;
  private final ScheduledExecutorService timer;
  private final ExecutorFactory<ExecutorService> executorFactory;
  private final ExecutorService executor;
  private final AtomicInteger queuedCallbacks;
  private final int maxQueuedCallbacks;
  private final Object futureLock = new Object();
  private final Runnable scheduleRunnable;
  private boolean closed;
  private Future<?> scheduledFuture;
  private PullFuture pullerFuture;
  private boolean stopped = true;

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

  private MessageConsumerImpl(Builder builder) {
    this.pubsubOptions = builder.pubsubOptions;
    this.subscription = builder.subscription;
    this.messageProcessor = builder.messageProcessor;
    this.pubsubRpc = pubsubOptions.rpc();
    this.pubsub = pubsubOptions.service();
    this.deadlineRenewer = builder.deadlineRenewer;
    this.queuedCallbacks = new AtomicInteger();
    this.timer = SharedResourceHolder.get(TIMER);
    this.executorFactory = firstNonNull(builder.executorFactory, new DefaultExecutorFactory());
    this.executor = executorFactory.get();
    this.maxQueuedCallbacks = firstNonNull(builder.maxQueuedCallbacks, MAX_QUEUED_CALLBACKS);
    this.scheduleRunnable = new Runnable() {
      @Override
      public void run() {
        synchronized (futureLock) {
          if (closed) {
            return;
          }
          pull();
        }
      }
    };
    nextPull();
  }

  private Runnable ackingRunnable(final ReceivedMessage receivedMessage) {
    return new Runnable() {
      @Override
      public void run() {
        try {
          messageProcessor.process(receivedMessage);
          pubsub.ackAsync(receivedMessage.subscription(), receivedMessage.ackId());
        } catch (Exception ex) {
          pubsub.nackAsync(receivedMessage.subscription(), receivedMessage.ackId());
        } finally {
          deadlineRenewer.remove(receivedMessage.subscription(), receivedMessage.ackId());
          queuedCallbacks.decrementAndGet();
          // We can now pull more messages. We do not pull immediately to possibly wait for other
          // callbacks to end
          scheduleNextPull(500, TimeUnit.MILLISECONDS);
        }
      }
    };
  }

  private PullRequest createPullRequest() {
    return PullRequest.newBuilder()
        .setSubscription(formatSubscriptionName(pubsubOptions.projectId(), subscription))
        .setMaxMessages(maxQueuedCallbacks - queuedCallbacks.get())
        .setReturnImmediately(false)
        .build();
  }

  private void scheduleNextPull(long delay, TimeUnit timeUnit) {
    synchronized (futureLock) {
      if (!closed && stopped) {
        scheduledFuture = timer.schedule(scheduleRunnable, delay, timeUnit);
      }
    }
  }

  private void nextPull() {
    synchronized (futureLock) {
      if (closed) {
        return;
      }
      if (queuedCallbacks.get() == maxQueuedCallbacks) {
        stopped = true;
      } else {
        stopped = false;
        scheduledFuture = timer.submit(scheduleRunnable);
      }
    }
  }

  private void pull() {
    pullerFuture = pubsubRpc.pull(createPullRequest());
    pullerFuture.addCallback(new PullCallback() {
      @Override
      public void success(PullResponse response) {
        List<com.google.pubsub.v1.ReceivedMessage> messages = response.getReceivedMessagesList();
        queuedCallbacks.addAndGet(messages.size());
        for (com.google.pubsub.v1.ReceivedMessage message : messages) {
          deadlineRenewer.add(subscription, message.getAckId());
          final ReceivedMessage receivedMessage =
              ReceivedMessage.fromPb(pubsub, subscription, message);
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
    SharedResourceHolder.release(TIMER, timer);
    executorFactory.release(executor);
  }

  static final class Builder {
    private final PubSubOptions pubsubOptions;
    private final String subscription;
    private final AckDeadlineRenewer deadlineRenewer;
    private final MessageProcessor messageProcessor;
    private Integer maxQueuedCallbacks;
    private ExecutorFactory<ExecutorService> executorFactory;

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

  /**
   * Returns a {@code MessageConsumerImpl} objects given the service options, the subscription from
   * which messages must be pulled, the acknowledge deadline renewer and a message processor used to
   * process messages.
   */
  static Builder of(PubSubOptions pubsubOptions, String subscription,
      AckDeadlineRenewer deadlineRenewer, MessageProcessor messageProcessor) {
    return new Builder(pubsubOptions, subscription, deadlineRenewer, messageProcessor);
  }
}

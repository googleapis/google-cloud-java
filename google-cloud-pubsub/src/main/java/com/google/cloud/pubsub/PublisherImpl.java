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

import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PublisherGrpc;
import com.google.pubsub.v1.PubsubMessage;
import io.grpc.CallCredentials;
import io.grpc.Channel;
import io.grpc.Status;
import io.grpc.auth.MoreCallCredentials;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Implementation of {@link Publisher}. */
final class PublisherImpl implements Publisher {
  private static final int DEFAULT_MIN_THREAD_POOL_SIZE = 5;
  private static final double INITIAL_BACKOFF_MS = 5;
  private static final double BACKOFF_RANDOMNESS_FACTOR = 0.2;

  private static final Logger logger = LoggerFactory.getLogger(PublisherImpl.class);

  private final String topic;

  private final int maxBatchMessages;
  private final int maxBatchBytes;
  private final Duration maxBatchDuration;
  private final boolean hasBatchingBytes;

  private final Optional<Integer> maxOutstandingMessages;
  private final Optional<Integer> maxOutstandingBytes;
  private final boolean failOnFlowControlLimits;

  private final Lock messagesBatchLock;
  private List<OutstandingPublish> messagesBatch;
  private int batchedBytes;

  private final AtomicBoolean activeAlarm;

  private final FlowController flowController;
  private final Channel[] channels;
  private final AtomicLong channelIndex;
  private final CallCredentials credentials;
  private final Duration requestTimeout;

  private final ScheduledExecutorService executor;
  private final AtomicBoolean shutdown;
  private final MessagesWaiter messagesWaiter;
  private final Duration sendBatchDeadline;
  private ScheduledFuture<?> currentAlarmFuture;

  PublisherImpl(Builder builder) throws IOException {
    topic = builder.topic;

    maxBatchMessages = builder.maxBatchMessages;
    maxBatchBytes = builder.maxBatchBytes;
    maxBatchDuration = builder.maxBatchDuration;
    hasBatchingBytes = maxBatchBytes > 0;

    maxOutstandingMessages = builder.maxOutstandingMessages;
    maxOutstandingBytes = builder.maxOutstandingBytes;
    failOnFlowControlLimits = builder.failOnFlowControlLimits;
    this.flowController =
        new FlowController(maxOutstandingMessages, maxOutstandingBytes, failOnFlowControlLimits);

    sendBatchDeadline = builder.sendBatchDeadline;

    requestTimeout = builder.requestTimeout;

    messagesBatch = new LinkedList<>();
    messagesBatchLock = new ReentrantLock();
    activeAlarm = new AtomicBoolean(false);
    int numCores = Math.max(1, Runtime.getRuntime().availableProcessors());
    executor =
        builder.executor.isPresent()
            ? builder.executor.get()
            : Executors.newScheduledThreadPool(
                numCores * DEFAULT_MIN_THREAD_POOL_SIZE,
                new ThreadFactoryBuilder()
                    .setDaemon(true)
                    .setNameFormat("cloud-pubsub-publisher-thread-%d")
                    .build());
    channels = new Channel[numCores];
    channelIndex = new AtomicLong(0);
    for (int i = 0; i < numCores; i++) {
      channels[i] =
          builder.channelBuilder.isPresent()
              ? builder.channelBuilder.get().build()
              : NettyChannelBuilder.forAddress(PUBSUB_API_ADDRESS, 443)
                  .negotiationType(NegotiationType.TLS)
                  .sslContext(GrpcSslContexts.forClient().ciphers(null).build())
                  .executor(executor)
                  .build();
    }
    credentials =
        MoreCallCredentials.from(
            builder.userCredentials.isPresent()
                ? builder.userCredentials.get()
                : GoogleCredentials.getApplicationDefault()
                    .createScoped(Collections.singletonList(PUBSUB_API_SCOPE)));
    shutdown = new AtomicBoolean(false);
    messagesWaiter = new MessagesWaiter();
  }

  @Override
  public PublisherStats getStats() {
    // TODO: Implement this.
    throw new UnsupportedOperationException();
  }

  @Override
  public Duration getMaxBatchDuration() {
    return maxBatchDuration;
  }

  @Override
  public long getMaxBatchBytes() {
    return maxBatchBytes;
  }

  @Override
  public long getMaxBatchMessages() {
    return maxBatchMessages;
  }

  @Override
  public Optional<Integer> getMaxOutstandingMessages() {
    return maxOutstandingMessages;
  }

  @Override
  public Optional<Integer> getMaxOutstandingBytes() {
    return maxOutstandingBytes;
  }

  @Override
  public boolean failOnFlowControlLimits() {
    return failOnFlowControlLimits;
  }

  /** Whether flow control kicks in on a per outstanding messages basis. */
  boolean isPerMessageEnforced() {
    return maxOutstandingMessages.isPresent();
  }

  /** Whether flow control kicks in on a per outstanding bytes basis. */
  boolean isPerBytesEnforced() {
    return maxOutstandingBytes.isPresent();
  }

  @Override
  public String getTopic() {
    return topic;
  }

  @Override
  public ListenableFuture<String> publish(PubsubMessage message) {
    if (shutdown.get()) {
      throw new IllegalStateException("Cannot publish on a shut-down publisher.");
    }

    SettableFuture<String> publishResult = SettableFuture.create();
    final int messageSize = message.getSerializedSize();
    try {
      flowController.reserve(1, messageSize);
    } catch (CloudPubsubFlowControlException e) {
      return Futures.immediateFailedFuture(e);
    }
    OutstandingBatch batchToSend = null;
    final OutstandingPublish outstandingPublish = new OutstandingPublish(publishResult, message);
    messagesBatchLock.lock();
    try {
      // Check if the next message makes the batch exceed the current batch byte size.
      if (!messagesBatch.isEmpty()
          && hasBatchingBytes
          && batchedBytes + messageSize >= getMaxBatchBytes()) {
        batchToSend = new OutstandingBatch(messagesBatch, batchedBytes);
        messagesBatch = new LinkedList<>();
        batchedBytes = 0;
      }

      // Border case if the message to send is greater equals to the max batch size then can't be
      // included in the current batch and instead sent immediately.
      if (!hasBatchingBytes || messageSize < getMaxBatchBytes()) {
        batchedBytes += messageSize;
        messagesBatch.add(outstandingPublish);

        // If after adding the message we have reached the batch max messages then we have a batch
        // to send.
        if (messagesBatch.size() == getMaxBatchMessages()) {
          batchToSend = new OutstandingBatch(messagesBatch, batchedBytes);
          messagesBatch = new LinkedList<>();
          batchedBytes = 0;
        }
      }
      // Setup the next duration based delivery alarm if there are messages batched.
      if (!messagesBatch.isEmpty()) {
        setupDurationBasedPublishAlarm();
      } else if (currentAlarmFuture != null) {
        logger.debug("Cancelling alarm");
        if (activeAlarm.getAndSet(false)) {
          currentAlarmFuture.cancel(false);
        }
      }
    } finally {
      messagesBatchLock.unlock();
    }

    messagesWaiter.incrementPendingMessages(1);

    if (batchToSend != null) {
      logger.debug("Scheduling a batch for immediate sending.");
      final OutstandingBatch finalBatchToSend = batchToSend;
      executor.execute(
          new Runnable() {
            @Override
            public void run() {
              publishOutstandingBatch(finalBatchToSend);
            }
          });
    }

    // If the message is over the size limit, it was not added to the pending messages and it will
    // be sent in its own batch immediately.
    if (hasBatchingBytes && messageSize >= getMaxBatchBytes()) {
      logger.debug("Message exceeds the max batch bytes, scheduling it for immediate send.");
      executor.execute(
          new Runnable() {
            @Override
            public void run() {
              publishOutstandingBatch(
                  new OutstandingBatch(ImmutableList.of(outstandingPublish), messageSize));
            }
          });
    }

    return publishResult;
  }

  private void setupDurationBasedPublishAlarm() {
    if (!activeAlarm.getAndSet(true)) {
      logger.debug("Setting up alarm for the next %d ms.", getMaxBatchDuration().getMillis());
      currentAlarmFuture =
          executor.schedule(
              new Runnable() {
                @Override
                public void run() {
                  logger.debug("Sending messages based on schedule.");
                  activeAlarm.getAndSet(false);
                  publishAllOustanding();
                }
              },
              getMaxBatchDuration().getMillis(),
              TimeUnit.MILLISECONDS);
    }
  }

  private void publishAllOustanding() {
    messagesBatchLock.lock();
    OutstandingBatch batchToSend;
    try {
      if (messagesBatch.isEmpty()) {
        return;
      }
      batchToSend = new OutstandingBatch(messagesBatch, batchedBytes);
      messagesBatch = new LinkedList<>();
      batchedBytes = 0;
    } finally {
      messagesBatchLock.unlock();
    }
    publishOutstandingBatch(batchToSend);
  }

  private void publishOutstandingBatch(final OutstandingBatch outstandingBatch) {
    PublishRequest.Builder publishRequest = PublishRequest.newBuilder();
    publishRequest.setTopic(topic);
    for (OutstandingPublish outstandingPublish : outstandingBatch.outstandingPublishes) {
      publishRequest.addMessages(outstandingPublish.message);
    }
    int currentChannel = (int) (channelIndex.getAndIncrement() % channels.length);
    Futures.addCallback(
        PublisherGrpc.newFutureStub(channels[currentChannel])
            .withCallCredentials(credentials)
            .withDeadlineAfter(requestTimeout.getMillis(), TimeUnit.MILLISECONDS)
            .publish(publishRequest.build()),
        new FutureCallback<PublishResponse>() {
          @Override
          public void onSuccess(PublishResponse result) {
            try {
              if (result.getMessageIdsCount() != outstandingBatch.size()) {
                Throwable t =
                    new IllegalStateException(
                        String.format(
                            "The publish result count %s does not match "
                                + "the expected %s results. Please contact Cloud Pub/Sub support "
                                + "if this frequently occurs",
                            result.getMessageIdsCount(), outstandingBatch.size()));
                for (OutstandingPublish oustandingMessage : outstandingBatch.outstandingPublishes) {
                  oustandingMessage.publishResult.setException(t);
                }
                return;
              }

              Iterator<OutstandingPublish> messagesResultsIt =
                  outstandingBatch.outstandingPublishes.iterator();
              for (String messageId : result.getMessageIdsList()) {
                messagesResultsIt.next().publishResult.set(messageId);
              }
            } finally {
              flowController.release(outstandingBatch.size(), outstandingBatch.batchSizeBytes);
              messagesWaiter.incrementPendingMessages(-outstandingBatch.size());
            }
          }

          @Override
          public void onFailure(Throwable t) {
            long nextBackoffDelay = computeNextBackoffDelayMs(outstandingBatch);

            if (!isRetryable(t)
                || System.currentTimeMillis() + nextBackoffDelay
                    > outstandingBatch.creationTime
                        + PublisherImpl.this.sendBatchDeadline.getMillis()) {
              try {
                for (OutstandingPublish outstandingPublish :
                    outstandingBatch.outstandingPublishes) {
                  outstandingPublish.publishResult.setException(t);
                }
              } finally {
                messagesWaiter.incrementPendingMessages(-outstandingBatch.size());
              }
              return;
            }

            executor.schedule(
                new Runnable() {
                  @Override
                  public void run() {
                    publishOutstandingBatch(outstandingBatch);
                  }
                },
                nextBackoffDelay,
                TimeUnit.MILLISECONDS);
          }
        });
  }

  private static final class OutstandingBatch {
    final List<OutstandingPublish> outstandingPublishes;
    final long creationTime;
    int attempt;
    int batchSizeBytes;

    OutstandingBatch(List<OutstandingPublish> outstandingPublishes, int batchSizeBytes) {
      this.outstandingPublishes = outstandingPublishes;
      attempt = 1;
      creationTime = System.currentTimeMillis();
      this.batchSizeBytes = batchSizeBytes;
    }

    public int size() {
      return outstandingPublishes.size();
    }
  }

  private static final class OutstandingPublish {
    SettableFuture<String> publishResult;
    PubsubMessage message;

    OutstandingPublish(SettableFuture<String> publishResult, PubsubMessage message) {
      this.publishResult = publishResult;
      this.message = message;
    }
  }

  @Override
  public void shutdown() {
    if (shutdown.getAndSet(true)) {
      throw new IllegalStateException("Cannot shut down a publisher already shut-down.");
    }
    if (currentAlarmFuture != null && activeAlarm.getAndSet(false)) {
      currentAlarmFuture.cancel(false);
    }
    publishAllOustanding();
    messagesWaiter.waitNoMessages();
  }

  private static long computeNextBackoffDelayMs(OutstandingBatch outstandingBatch) {
    long delayMillis = Math.round(Math.scalb(INITIAL_BACKOFF_MS, outstandingBatch.attempt));
    int randomWaitMillis =
        Ints.saturatedCast(
            (long) ((Math.random() - 0.5) * 2 * delayMillis * BACKOFF_RANDOMNESS_FACTOR));
    ++outstandingBatch.attempt;
    return delayMillis + randomWaitMillis;
  }

  private boolean isRetryable(Throwable t) {
    Status status = Status.fromThrowable(t);
    switch (status.getCode()) {
      case ABORTED:
      case CANCELLED:
      case DEADLINE_EXCEEDED:
      case INTERNAL:
      case RESOURCE_EXHAUSTED:
      case UNKNOWN:
      case UNAVAILABLE:
        return true;
      default:
        return false;
    }
  }
}

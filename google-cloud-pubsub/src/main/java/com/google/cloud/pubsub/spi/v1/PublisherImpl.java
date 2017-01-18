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

package com.google.cloud.pubsub.spi.v1;

import com.google.api.gax.bundling.FlowController;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.BundlingSettings;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Implementation of {@link Publisher}. */
final class PublisherImpl implements Publisher {
  private static final int DEFAULT_MIN_THREAD_POOL_SIZE = 5;

  private static final Logger logger = LoggerFactory.getLogger(PublisherImpl.class);

  private final String topic;

  private final BundlingSettings bundlingSettings;
  private final RetrySettings retrySettings;

  private final FlowController.Settings flowControlSettings;
  private final boolean failOnFlowControlLimits;

  private final Lock messagesBundleLock;
  private List<OutstandingPublish> messagesBundle;
  private int bundledBytes;

  private final AtomicBoolean activeAlarm;

  private final FlowController flowController;
  private final Channel[] channels;
  private final AtomicInteger channelIndex;
  private final CallCredentials credentials;

  private final ScheduledExecutorService executor;
  private final AtomicBoolean shutdown;
  private final MessagesWaiter messagesWaiter;
  private ScheduledFuture<?> currentAlarmFuture;

  PublisherImpl(Builder builder) throws IOException {
    topic = builder.topic;

    this.bundlingSettings = builder.bundlingSettings;
    this.retrySettings = builder.retrySettings;

    flowControlSettings = builder.flowControlSettings;
    failOnFlowControlLimits = builder.failOnFlowControlLimits;
    this.flowController = new FlowController(flowControlSettings, failOnFlowControlLimits);

    messagesBundle = new LinkedList<>();
    messagesBundleLock = new ReentrantLock();
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
    channelIndex = new AtomicInteger(0);
    for (int i = 0; i < numCores; i++) {
      channels[i] =
          builder.channelBuilder.isPresent()
              ? builder.channelBuilder.get().build()
              : NettyChannelBuilder.forAddress(
                      PublisherSettings.getDefaultServiceAddress(),
                      PublisherSettings.getDefaultServicePort())
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
                    .createScoped(PublisherSettings.getDefaultServiceScopes()));
    shutdown = new AtomicBoolean(false);
    messagesWaiter = new MessagesWaiter();
  }

  @Override
  public PublisherStats getStats() {
    // TODO: Implement this.
    throw new UnsupportedOperationException();
  }

  @Override
  public Duration getMaxBundleDuration() {
    return bundlingSettings.getDelayThreshold();
  }

  @Override
  public long getMaxBundleBytes() {
    return bundlingSettings.getRequestByteThreshold();
  }

  private boolean hasBundlingBytes() {
    return getMaxBundleBytes() > 0;
  }

  @Override
  public long getMaxBundleMessages() {
    return bundlingSettings.getElementCountThreshold();
  }

  @Override
  public Optional<Integer> getMaxOutstandingElementCount() {
    return flowControlSettings.getMaxOutstandingElementCount();
  }

  @Override
  public Optional<Integer> getMaxOutstandingRequestBytes() {
    return flowControlSettings.getMaxOutstandingRequestBytes();
  }

  @Override
  public boolean failOnFlowControlLimits() {
    return failOnFlowControlLimits;
  }

  /** Whether flow control kicks in on a per outstanding messages basis. */
  boolean isPerMessageEnforced() {
    return getMaxOutstandingElementCount().isPresent();
  }

  /** Whether flow control kicks in on a per outstanding bytes basis. */
  boolean isPerBytesEnforced() {
    return getMaxOutstandingRequestBytes().isPresent();
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

    final int messageSize = message.getSerializedSize();
    try {
      flowController.reserve(1, messageSize);
    } catch (FlowController.FlowControlException e) {
      return Futures.immediateFailedFuture(e);
    }
    OutstandingBundle bundleToSend = null;
    SettableFuture<String> publishResult = SettableFuture.create();
    final OutstandingPublish outstandingPublish = new OutstandingPublish(publishResult, message);
    messagesBundleLock.lock();
    try {
      // Check if the next message makes the bundle exceed the current bundle byte size.
      if (!messagesBundle.isEmpty()
          && hasBundlingBytes()
          && bundledBytes + messageSize >= getMaxBundleBytes()) {
        bundleToSend = new OutstandingBundle(messagesBundle, bundledBytes);
        messagesBundle = new LinkedList<>();
        bundledBytes = 0;
      }

      // Border case if the message to send is greater equals to the max bundle size then can't be
      // included in the current bundle and instead sent immediately.
      if (!hasBundlingBytes() || messageSize < getMaxBundleBytes()) {
        bundledBytes += messageSize;
        messagesBundle.add(outstandingPublish);

        // If after adding the message we have reached the bundle max messages then we have a bundle
        // to send.
        if (messagesBundle.size() == getMaxBundleMessages()) {
          bundleToSend = new OutstandingBundle(messagesBundle, bundledBytes);
          messagesBundle = new LinkedList<>();
          bundledBytes = 0;
        }
      }
      // Setup the next duration based delivery alarm if there are messages bundled.
      if (!messagesBundle.isEmpty()) {
        setupDurationBasedPublishAlarm();
      } else if (currentAlarmFuture != null) {
        logger.debug("Cancelling alarm");
        if (activeAlarm.getAndSet(false)) {
          currentAlarmFuture.cancel(false);
        }
      }
    } finally {
      messagesBundleLock.unlock();
    }

    messagesWaiter.incrementPendingMessages(1);

    if (bundleToSend != null) {
      logger.debug("Scheduling a bundle for immediate sending.");
      final OutstandingBundle finalBundleToSend = bundleToSend;
      executor.execute(
          new Runnable() {
            @Override
            public void run() {
              publishOutstandingBundle(finalBundleToSend);
            }
          });
    }

    // If the message is over the size limit, it was not added to the pending messages and it will
    // be sent in its own bundle immediately.
    if (hasBundlingBytes() && messageSize >= getMaxBundleBytes()) {
      logger.debug("Message exceeds the max bundle bytes, scheduling it for immediate send.");
      executor.execute(
          new Runnable() {
            @Override
            public void run() {
              publishOutstandingBundle(
                  new OutstandingBundle(ImmutableList.of(outstandingPublish), messageSize));
            }
          });
    }

    return publishResult;
  }

  private void setupDurationBasedPublishAlarm() {
    if (!activeAlarm.getAndSet(true)) {
      logger.debug("Setting up alarm for the next %d ms.", getMaxBundleDuration().getMillis());
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
              getMaxBundleDuration().getMillis(),
              TimeUnit.MILLISECONDS);
    }
  }

  private void publishAllOustanding() {
    messagesBundleLock.lock();
    OutstandingBundle bundleToSend;
    try {
      if (messagesBundle.isEmpty()) {
        return;
      }
      bundleToSend = new OutstandingBundle(messagesBundle, bundledBytes);
      messagesBundle = new LinkedList<>();
      bundledBytes = 0;
    } finally {
      messagesBundleLock.unlock();
    }
    publishOutstandingBundle(bundleToSend);
  }

  private void publishOutstandingBundle(final OutstandingBundle outstandingBundle) {
    PublishRequest.Builder publishRequest = PublishRequest.newBuilder();
    publishRequest.setTopic(topic);
    for (OutstandingPublish outstandingPublish : outstandingBundle.outstandingPublishes) {
      publishRequest.addMessages(outstandingPublish.message);
    }
    int currentChannel = channelIndex.getAndIncrement() % channels.length;

    long rpcTimeoutMs =
        Math.round(
            retrySettings.getInitialRpcTimeout().getMillis()
                * Math.pow(retrySettings.getRpcTimeoutMultiplier(), outstandingBundle.attempt - 1));
    rpcTimeoutMs = Math.min(rpcTimeoutMs, retrySettings.getMaxRpcTimeout().getMillis());

    Futures.addCallback(
        PublisherGrpc.newFutureStub(channels[currentChannel])
            .withCallCredentials(credentials)
            .withDeadlineAfter(rpcTimeoutMs, TimeUnit.MILLISECONDS)
            .publish(publishRequest.build()),
        new FutureCallback<PublishResponse>() {
          @Override
          public void onSuccess(PublishResponse result) {
            try {
              if (result.getMessageIdsCount() != outstandingBundle.size()) {
                Throwable t =
                    new IllegalStateException(
                        String.format(
                            "The publish result count %s does not match "
                                + "the expected %s results. Please contact Cloud Pub/Sub support "
                                + "if this frequently occurs",
                            result.getMessageIdsCount(), outstandingBundle.size()));
                for (OutstandingPublish oustandingMessage :
                    outstandingBundle.outstandingPublishes) {
                  oustandingMessage.publishResult.setException(t);
                }
                return;
              }

              Iterator<OutstandingPublish> messagesResultsIt =
                  outstandingBundle.outstandingPublishes.iterator();
              for (String messageId : result.getMessageIdsList()) {
                messagesResultsIt.next().publishResult.set(messageId);
              }
            } finally {
              flowController.release(outstandingBundle.size(), outstandingBundle.bundleSizeBytes);
              messagesWaiter.incrementPendingMessages(-outstandingBundle.size());
            }
          }

          @Override
          public void onFailure(Throwable t) {
            long nextBackoffDelay = computeNextBackoffDelayMs(outstandingBundle, retrySettings);

            if (!isRetryable(t)
                || System.currentTimeMillis() + nextBackoffDelay
                    > outstandingBundle.creationTime
                        + retrySettings.getTotalTimeout().getMillis()) {
              try {
                for (OutstandingPublish outstandingPublish :
                    outstandingBundle.outstandingPublishes) {
                  outstandingPublish.publishResult.setException(t);
                }
              } finally {
                messagesWaiter.incrementPendingMessages(-outstandingBundle.size());
              }
              return;
            }

            executor.schedule(
                new Runnable() {
                  @Override
                  public void run() {
                    publishOutstandingBundle(outstandingBundle);
                  }
                },
                nextBackoffDelay,
                TimeUnit.MILLISECONDS);
          }
        });
  }

  private static final class OutstandingBundle {
    final List<OutstandingPublish> outstandingPublishes;
    final long creationTime;
    int attempt;
    int bundleSizeBytes;

    OutstandingBundle(List<OutstandingPublish> outstandingPublishes, int bundleSizeBytes) {
      this.outstandingPublishes = outstandingPublishes;
      attempt = 1;
      creationTime = System.currentTimeMillis();
      this.bundleSizeBytes = bundleSizeBytes;
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

  private static long computeNextBackoffDelayMs(
      OutstandingBundle outstandingBundle, RetrySettings retrySettings) {
    long delayMillis =
        Math.round(
            retrySettings.getInitialRetryDelay().getMillis()
                * Math.pow(retrySettings.getRetryDelayMultiplier(), outstandingBundle.attempt - 1));
    delayMillis = Math.min(retrySettings.getMaxRetryDelay().getMillis(), delayMillis);
    outstandingBundle.attempt++;
    return ThreadLocalRandom.current().nextLong(0, delayMillis);
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

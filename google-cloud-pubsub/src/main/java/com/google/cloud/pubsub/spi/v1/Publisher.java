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

import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.core.ApiFuture;
import com.google.api.gax.core.ApiFutures;
import com.google.api.gax.core.FlowControlSettings;
import com.google.api.gax.core.FlowController;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.core.SettableApiFuture;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.InstantiatingExecutorProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PublisherGrpc;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.Duration;

/**
 * A Cloud Pub/Sub <a href="https://cloud.google.com/pubsub/docs/publisher">publisher</a>, that is
 * associated with a specific topic at creation.
 *
 * <p>A {@link Publisher} provides built-in capabilities to automatically handle batching of
 * messages, controlling memory utilization, and retrying API calls on transient errors.
 *
 * <p>With customizable options that control:
 *
 * <ul>
 *   <li>Message batching: such as number of messages or max batch byte size.
 *   <li>Flow control: such as max outstanding messages and maximum outstanding bytes.
 *   <li>Retries: such as the maximum duration of retries for a failing batch of messages.
 * </ul>
 *
 * <p>If no credentials are provided, the {@link Publisher} will use application default credentials
 * through {@link GoogleCredentials#getApplicationDefault}.
 */
public class Publisher {
  private static final Logger logger = Logger.getLogger(Publisher.class.getName());

  private final TopicName topicName;
  private final String cachedTopicNameString;

  private final BatchingSettings batchingSettings;
  private final RetrySettings retrySettings;
  private final LongRandom longRandom;

  private final FlowControlSettings flowControlSettings;

  private final Lock messagesBatchLock;
  private List<OutstandingPublish> messagesBatch;
  private int batchedBytes;

  private final AtomicBoolean activeAlarm;

  private final FlowController flowController;
  private final ManagedChannel[] channels;
  private final AtomicRoundRobin channelIndex;

  private final ScheduledExecutorService executor;
  private final AtomicBoolean shutdown;
  private final List<AutoCloseable> closeables = new ArrayList<>();
  private final MessageWaiter messagesWaiter;
  private ScheduledFuture<?> currentAlarmFuture;

  /** The maximum number of messages in one request. Defined by the API. */
  public static long getApiMaxRequestElementCount() {
    return 1000L;
  }

  /** The maximum size of one request. Defined by the API. */
  public static long getApiMaxRequestBytes() {
    return 10L * 1000L * 1000L; // 10 megabytes (https://en.wikipedia.org/wiki/Megabyte)
  }

  private Publisher(Builder builder) throws IOException {
    topicName = builder.topicName;
    cachedTopicNameString = topicName.toString();

    this.batchingSettings = builder.batchingSettings;
    this.retrySettings = builder.retrySettings;
    this.longRandom = builder.longRandom;

    flowControlSettings = builder.flowControlSettings;
    this.flowController = new FlowController(flowControlSettings);

    messagesBatch = new LinkedList<>();
    messagesBatchLock = new ReentrantLock();
    activeAlarm = new AtomicBoolean(false);
    executor = builder.executorProvider.getExecutor();
    if (builder.executorProvider.shouldAutoClose()) {
      closeables.add(
          new AutoCloseable() {
            @Override
            public void close() {
              executor.shutdown();
            }
          });
    }
    channels = new ManagedChannel[Runtime.getRuntime().availableProcessors()];
    for (int i = 0; i < channels.length; i++) {
      channels[i] =
          builder.channelProvider.needsExecutor()
              ? builder.channelProvider.getChannel(executor)
              : builder.channelProvider.getChannel();
    }
    if (builder.channelProvider.shouldAutoClose()) {
      closeables.add(
          new AutoCloseable() {
            @Override
            public void close() {
              for (int i = 0; i < channels.length; i++) {
                channels[i].shutdown();
              }
            }
          });
    }
    channelIndex = new AtomicRoundRobin(channels.length);
    shutdown = new AtomicBoolean(false);
    messagesWaiter = new MessageWaiter();
  }

  /** Topic which the publisher publishes to. */
  public TopicName getTopicName() {
    return topicName;
  }

  /**
   * Schedules the publishing of a message. The publishing of the message may occur immediately or
   * be delayed based on the publisher batching options.
   *
   * <p>Depending on chosen flow control {@link FlowControlSettings#getLimitExceededBehavior
   * option}, the returned future might immediately fail with a {@link
   * FlowController.FlowControlException} or block the current thread until there are more resources
   * available to publish.
   *
   * <p>Example of publishing a message.
   *
   * <pre>{@code
   * String message = "my_message";
   * ByteString data = ByteString.copyFromUtf8(message);
   * PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();
   * ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
   * messageIdFuture.addCallback(new ApiFutureCallback<String>() {
   *   public void onSuccess(String messageId) {
   *     System.out.println("published with message id: " + messageId);
   *   }
   *
   *   public void onFailure(Throwable t) {
   *     System.out.println("failed to publish: " + t);
   *   }
   * });
   * }</pre>
   *
   * @param message the message to publish.
   * @return the message ID wrapped in a future.
   */
  public ApiFuture<String> publish(PubsubMessage message) {
    if (shutdown.get()) {
      throw new IllegalStateException("Cannot publish on a shut-down publisher.");
    }

    final int messageSize = message.getSerializedSize();
    try {
      flowController.reserve(1, messageSize);
    } catch (FlowController.FlowControlException e) {
      return ApiFutures.immediateFailedFuture(e);
    }
    OutstandingBatch batchToSend = null;
    SettableApiFuture<String> publishResult = SettableApiFuture.<String>create();
    final OutstandingPublish outstandingPublish = new OutstandingPublish(publishResult, message);
    messagesBatchLock.lock();
    try {
      // Check if the next message makes the batch exceed the current batch byte size.
      if (!messagesBatch.isEmpty()
          && hasBatchingBytes()
          && batchedBytes + messageSize >= getMaxBatchBytes()) {
        batchToSend = new OutstandingBatch(messagesBatch, batchedBytes);
        messagesBatch = new LinkedList<>();
        batchedBytes = 0;
      }

      // Border case if the message to send is greater equals to the max batch size then can't be
      // included in the current batch and instead sent immediately.
      if (!hasBatchingBytes() || messageSize < getMaxBatchBytes()) {
        batchedBytes += messageSize;
        messagesBatch.add(outstandingPublish);

        // If after adding the message we have reached the batch max messages then we have a batch
        // to send.
        if (messagesBatch.size() == getBatchingSettings().getElementCountThreshold()) {
          batchToSend = new OutstandingBatch(messagesBatch, batchedBytes);
          messagesBatch = new LinkedList<>();
          batchedBytes = 0;
        }
      }
      // Setup the next duration based delivery alarm if there are messages batched.
      if (!messagesBatch.isEmpty()) {
        setupDurationBasedPublishAlarm();
      } else if (currentAlarmFuture != null) {
        logger.log(Level.FINER, "Cancelling alarm, no more messages");
        if (activeAlarm.getAndSet(false)) {
          currentAlarmFuture.cancel(false);
        }
      }
    } finally {
      messagesBatchLock.unlock();
    }

    messagesWaiter.incrementPendingMessages(1);

    if (batchToSend != null) {
      logger.log(Level.FINER, "Scheduling a batch for immediate sending.");
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
    if (hasBatchingBytes() && messageSize >= getMaxBatchBytes()) {
      logger.log(
          Level.FINER, "Message exceeds the max batch bytes, scheduling it for immediate send.");
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
      long delayThresholdMs = getBatchingSettings().getDelayThreshold().getMillis();
      logger.log(Level.FINER, "Setting up alarm for the next {0} ms.", delayThresholdMs);
      currentAlarmFuture =
          executor.schedule(
              new Runnable() {
                @Override
                public void run() {
                  logger.log(Level.FINER, "Sending messages based on schedule.");
                  activeAlarm.getAndSet(false);
                  publishAllOutstanding();
                }
              },
              delayThresholdMs,
              TimeUnit.MILLISECONDS);
    }
  }

  private void publishAllOutstanding() {
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
    publishRequest.setTopic(cachedTopicNameString);
    for (OutstandingPublish outstandingPublish : outstandingBatch.outstandingPublishes) {
      publishRequest.addMessages(outstandingPublish.message);
    }

    int currentChannel = channelIndex.next();

    long rpcTimeoutMs =
        Math.round(
            retrySettings.getInitialRpcTimeout().getMillis()
                * Math.pow(retrySettings.getRpcTimeoutMultiplier(), outstandingBatch.attempt - 1));
    rpcTimeoutMs = Math.min(rpcTimeoutMs, retrySettings.getMaxRpcTimeout().getMillis());

    Futures.addCallback(
        PublisherGrpc.newFutureStub(channels[currentChannel])
            .withDeadlineAfter(rpcTimeoutMs, TimeUnit.MILLISECONDS)
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
                for (OutstandingPublish oustandingMessage :
                    outstandingBatch.outstandingPublishes) {
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
            long nextBackoffDelay =
                computeNextBackoffDelayMs(outstandingBatch, retrySettings, longRandom);

            if (!isRetryable(t)
                || System.currentTimeMillis() + nextBackoffDelay
                    > outstandingBatch.creationTime
                        + retrySettings.getTotalTimeout().getMillis()) {
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
    SettableApiFuture<String> publishResult;
    PubsubMessage message;

    OutstandingPublish(SettableApiFuture<String> publishResult, PubsubMessage message) {
      this.publishResult = publishResult;
      this.message = message;
    }
  }

  /** The batching settings configured on this {@code Publisher}. */
  public BatchingSettings getBatchingSettings() {
    return batchingSettings;
  }

  private long getMaxBatchBytes() {
    return getBatchingSettings().getRequestByteThreshold();
  }

  /**
   * The batching settings configured on this {@code Publisher}, including whether to block publish
   * calls when reaching flow control limits.
   *
   * <p>If {@link FlowControlSettings#getLimitExceededBehavior()} is set to {@link
   * FlowController.LimitExceededBehavior#ThrowException}, a publish call will fail with either
   * {@link FlowController.MaxOutstandingRequestBytesReachedException} or {@link
   * FlowController.MaxOutstandingElementCountReachedException}, as appropriate, when flow control
   * limits are reached.
   */
  public FlowControlSettings getFlowControlSettings() {
    return flowControlSettings;
  }

  /**
   * Schedules immediate publishing of any outstanding messages and waits until all are processed.
   *
   * <p>Sends remaining outstanding messages and prevents future calls to publish. This method
   * should be invoked prior to deleting the {@link Publisher} object in order to ensure that no
   * pending messages are lost.
   */
  public void shutdown() throws Exception {
    if (shutdown.getAndSet(true)) {
      throw new IllegalStateException("Cannot shut down a publisher already shut-down.");
    }
    if (currentAlarmFuture != null && activeAlarm.getAndSet(false)) {
      currentAlarmFuture.cancel(false);
    }
    publishAllOutstanding();
    messagesWaiter.waitNoMessages();
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }

  private boolean hasBatchingBytes() {
    return getMaxBatchBytes() > 0;
  }

  private static long computeNextBackoffDelayMs(
      OutstandingBatch outstandingBatch, RetrySettings retrySettings, LongRandom longRandom) {
    long delayMillis =
        Math.round(
            retrySettings.getInitialRetryDelay().getMillis()
                * Math.pow(retrySettings.getRetryDelayMultiplier(), outstandingBatch.attempt - 1));
    delayMillis = Math.min(retrySettings.getMaxRetryDelay().getMillis(), delayMillis);
    outstandingBatch.attempt++;
    return longRandom.nextLong(0, delayMillis);
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

  interface LongRandom {
    long nextLong(long least, long bound);
  }

  /**
   * Constructs a new {@link Builder} using the given topic.
   *
   * <p>Example of creating a {@code Publisher}.
   * <pre> {@code
   * String projectName = "my_project";
   * String topicName = "my_topic";
   * TopicName topic = TopicName.create(projectName, topicName);
   * Publisher publisher = Publisher.newBuilder(topic).build();
   * try {
   *   // ...
   * } finally {
   *   // When finished with the publisher, make sure to shutdown to free up resources.
   *   publisher.shutdown();
   * }
   * }</pre>
   *
   */
  public static Builder newBuilder(TopicName topicName) {
    return new Builder(topicName);
  }

  /** A builder of {@link Publisher}s. */
  public static final class Builder {
    static final Duration MIN_TOTAL_TIMEOUT = new Duration(10 * 1000); // 10 seconds
    static final Duration MIN_RPC_TIMEOUT = new Duration(10); // 10 milliseconds

    // Meaningful defaults.
    static final long DEFAULT_ELEMENT_COUNT_THRESHOLD = 100L;
    static final long DEFAULT_REQUEST_BYTES_THRESHOLD = 1000L; // 1 kB
    static final Duration DEFAULT_DELAY_THRESHOLD = new Duration(1); // 1ms
    static final Duration DEFAULT_RPC_TIMEOUT = new Duration(10 * 1000); // 10 seconds
    static final Duration DEFAULT_TOTAL_TIMEOUT = MIN_TOTAL_TIMEOUT;
    static final BatchingSettings DEFAULT_BATCHING_SETTINGS =
        BatchingSettings.newBuilder()
            .setDelayThreshold(DEFAULT_DELAY_THRESHOLD)
            .setRequestByteThreshold(DEFAULT_REQUEST_BYTES_THRESHOLD)
            .setElementCountThreshold(DEFAULT_ELEMENT_COUNT_THRESHOLD)
            .build();
    static final RetrySettings DEFAULT_RETRY_SETTINGS =
        RetrySettings.newBuilder()
            .setTotalTimeout(DEFAULT_TOTAL_TIMEOUT)
            .setInitialRetryDelay(Duration.millis(5))
            .setRetryDelayMultiplier(2)
            .setMaxRetryDelay(Duration.millis(Long.MAX_VALUE))
            .setInitialRpcTimeout(DEFAULT_RPC_TIMEOUT)
            .setRpcTimeoutMultiplier(2)
            .setMaxRpcTimeout(DEFAULT_RPC_TIMEOUT)
            .build();
    static final LongRandom DEFAULT_LONG_RANDOM =
        new LongRandom() {
          @Override
          public long nextLong(long least, long bound) {
            return ThreadLocalRandom.current().nextLong(least, bound);
          }
        };

    private static final int THREADS_PER_CPU = 5;
    static final ExecutorProvider DEFAULT_EXECUTOR_PROVIDER =
        InstantiatingExecutorProvider.newBuilder()
            .setExecutorThreadCount(THREADS_PER_CPU * Runtime.getRuntime().availableProcessors())
            .build();

    TopicName topicName;

    // Batching options
    BatchingSettings batchingSettings = DEFAULT_BATCHING_SETTINGS;

    // Client-side flow control options
    FlowControlSettings flowControlSettings = FlowControlSettings.getDefaultInstance();

    RetrySettings retrySettings = DEFAULT_RETRY_SETTINGS;
    LongRandom longRandom = DEFAULT_LONG_RANDOM;

    ChannelProvider channelProvider = TopicAdminSettings.defaultChannelProviderBuilder().build();
    ExecutorProvider executorProvider = DEFAULT_EXECUTOR_PROVIDER;

    private Builder(TopicName topic) {
      this.topicName = Preconditions.checkNotNull(topic);
    }

    /**
     * {@code ChannelProvider} to use to create Channels, which must point at Cloud Pub/Sub
     * endpoint.
     *
     * <p>For performance, this client benefits from having multiple channels open at once. Users
     * are encouraged to provide instances of {@code ChannelProvider} that creates new channels
     * instead of returning pre-initialized ones.
     */
    public Builder setChannelProvider(ChannelProvider channelProvider) {
      this.channelProvider = Preconditions.checkNotNull(channelProvider);
      return this;
    }

    // Batching options
    public Builder setBatchingSettings(BatchingSettings batchingSettings) {
      Preconditions.checkNotNull(batchingSettings);
      Preconditions.checkNotNull(batchingSettings.getElementCountThreshold());
      Preconditions.checkArgument(batchingSettings.getElementCountThreshold() > 0);
      Preconditions.checkNotNull(batchingSettings.getRequestByteThreshold());
      Preconditions.checkArgument(batchingSettings.getRequestByteThreshold() > 0);
      Preconditions.checkNotNull(batchingSettings.getDelayThreshold());
      Preconditions.checkArgument(batchingSettings.getDelayThreshold().getMillis() > 0);
      this.batchingSettings = batchingSettings;
      return this;
    }

    // Flow control options

    /** Sets the flow control settings. */
    public Builder setFlowControlSettings(FlowControlSettings flowControlSettings) {
      this.flowControlSettings = Preconditions.checkNotNull(flowControlSettings);
      return this;
    }

    /** Configures the Publisher's retry parameters. */
    public Builder setRetrySettings(RetrySettings retrySettings) {
      Preconditions.checkArgument(
          retrySettings.getTotalTimeout().compareTo(MIN_TOTAL_TIMEOUT) >= 0);
      Preconditions.checkArgument(
          retrySettings.getInitialRpcTimeout().compareTo(MIN_RPC_TIMEOUT) >= 0);
      this.retrySettings = retrySettings;
      return this;
    }

    @VisibleForTesting
    Builder setLongRandom(LongRandom longRandom) {
      this.longRandom = Preconditions.checkNotNull(longRandom);
      return this;
    }

    /** Gives the ability to set a custom executor to be used by the library. */
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      this.executorProvider = Preconditions.checkNotNull(executorProvider);
      return this;
    }

    public Publisher build() throws IOException {
      return new Publisher(this);
    }
  }
}

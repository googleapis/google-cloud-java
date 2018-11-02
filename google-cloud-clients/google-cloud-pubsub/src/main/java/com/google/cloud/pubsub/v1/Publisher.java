/*
 * Copyright 2016 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorAsBackgroundResource;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.NoHeaderProvider;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.pubsub.v1.stub.GrpcPublisherStub;
import com.google.cloud.pubsub.v1.stub.PublisherStub;
import com.google.cloud.pubsub.v1.stub.PublisherStubSettings;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import com.google.pubsub.v1.TopicNames;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.threeten.bp.Duration;

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
 *   <li>Retries: such as the maximum duration of retries for a failing batch of messages.
 * </ul>
 *
 * <p>{@link Publisher} will use the credentials set on the channel, which uses
 *  application default credentials through {@link GoogleCredentials#getApplicationDefault}
 *  by default.
 */
public class Publisher {
  private static final Logger logger = Logger.getLogger(Publisher.class.getName());

  private final String topicName;

  private final BatchingSettings batchingSettings;

  private final Lock messagesBatchLock;
  private List<OutstandingPublish> messagesBatch;
  private int batchedBytes;

  private final AtomicBoolean activeAlarm;

  private final PublisherStub publisherStub;

  private final ScheduledExecutorService executor;
  private final AtomicBoolean shutdown;
  private final List<AutoCloseable> closeables;
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

    this.batchingSettings = builder.batchingSettings;

    messagesBatch = new LinkedList<>();
    messagesBatchLock = new ReentrantLock();
    activeAlarm = new AtomicBoolean(false);
    executor = builder.executorProvider.getExecutor();
    if (builder.executorProvider.shouldAutoClose()) {
      closeables =
          Collections.<AutoCloseable>singletonList(new ExecutorAsBackgroundResource(executor));
    } else {
      closeables = Collections.emptyList();
    }

    // Publisher used to take maxAttempt == 0 to mean infinity, but to GAX it means don't retry.
    // We post-process this here to keep backward-compatibility.
    RetrySettings retrySettings = builder.retrySettings;
    if (retrySettings.getMaxAttempts() == 0) {
      retrySettings = retrySettings.toBuilder().setMaxAttempts(Integer.MAX_VALUE).build();
    }

    PublisherStubSettings.Builder stubSettings =
        PublisherStubSettings.newBuilder()
            .setCredentialsProvider(builder.credentialsProvider)
            .setExecutorProvider(FixedExecutorProvider.create(executor))
            .setTransportChannelProvider(builder.channelProvider);
    stubSettings
        .publishSettings()
        .setRetryableCodes(
            StatusCode.Code.ABORTED,
            StatusCode.Code.CANCELLED,
            StatusCode.Code.DEADLINE_EXCEEDED,
            StatusCode.Code.INTERNAL,
            StatusCode.Code.RESOURCE_EXHAUSTED,
            StatusCode.Code.UNKNOWN,
            StatusCode.Code.UNAVAILABLE)
        .setRetrySettings(retrySettings)
        .setBatchingSettings(BatchingSettings.newBuilder().setIsEnabled(false).build());
    this.publisherStub = GrpcPublisherStub.create(stubSettings.build());

    shutdown = new AtomicBoolean(false);
    messagesWaiter = new MessageWaiter();
  }

  /** Topic which the publisher publishes to. */
  public TopicName getTopicName() {
    return TopicNames.parse(topicName);
  }

  /** Topic which the publisher publishes to. */
  public String getTopicNameString() {
    return topicName;
  }

  /**
   * Schedules the publishing of a message. The publishing of the message may occur immediately or
   * be delayed based on the publisher batching options.
   *
   * <p>Example of publishing a message.
   *
   * <pre>{@code
   * String message = "my_message";
   * ByteString data = ByteString.copyFromUtf8(message);
   * PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();
   * ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
   * ApiFutures.addCallback(messageIdFuture, new ApiFutureCallback<String>() {
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
    OutstandingBatch batchToSend = null;
    SettableApiFuture<String> publishResult = SettableApiFuture.<String>create();
    final OutstandingPublish outstandingPublish = new OutstandingPublish(publishResult, message);
    messagesBatchLock.lock();
    try {
      // Check if the next message makes the current batch exceed the max batch byte size.
      if (!messagesBatch.isEmpty()
          && hasBatchingBytes()
          && batchedBytes + messageSize >= getMaxBatchBytes()) {
        batchToSend = new OutstandingBatch(messagesBatch, batchedBytes);
        messagesBatch = new LinkedList<>();
        batchedBytes = 0;
      }

      // Border case if the message to send is greater or equals to the max batch size then can't
      // be included in the current batch and instead sent immediately.
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
      long delayThresholdMs = getBatchingSettings().getDelayThreshold().toMillis();
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

  /**
   * Publish any outstanding batches if non-empty.   This method sends buffered messages, but does
   * not wait for the send operations to complete.  To wait for messages to send, call {@code get}
   * on the futures returned from {@code publish}.
   */
  public void publishAllOutstanding() {
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
    publishRequest.setTopic(topicName);
    for (OutstandingPublish outstandingPublish : outstandingBatch.outstandingPublishes) {
      publishRequest.addMessages(outstandingPublish.message);
    }

    ApiFutures.addCallback(
        publisherStub.publishCallable().futureCall(publishRequest.build()),
        new ApiFutureCallback<PublishResponse>() {
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
              messagesWaiter.incrementPendingMessages(-outstandingBatch.size());
            }
          }

          @Override
          public void onFailure(Throwable t) {
            try {
              for (OutstandingPublish outstandingPublish : outstandingBatch.outstandingPublishes) {
                outstandingPublish.publishResult.setException(t);
              }
            } finally {
              messagesWaiter.incrementPendingMessages(-outstandingBatch.size());
            }
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

    public int getAttempt() {
      return attempt;
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
    publisherStub.shutdown();
  }

  /**
   * Wait for all work has completed execution after a {@link #shutdown()} request, or the timeout
   * occurs, or the current thread is interrupted.
   *
   * <p>Call this method to make sure all resources are freed properly.
   */
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return publisherStub.awaitTermination(duration, unit);
  }

  private boolean hasBatchingBytes() {
    return getMaxBatchBytes() > 0;
  }

  /**
   * Constructs a new {@link Builder} using the given topic.
   *
   * <p>Example of creating a {@code Publisher}.
   *
   * <pre>{@code
   * String projectName = "my_project";
   * String topicName = "my_topic";
   * ProjectTopicName topic = ProjectTopicName.create(projectName, topicName);
   * Publisher publisher = Publisher.newBuilder(topic).build();
   * try {
   *   // ...
   * } finally {
   *   // When finished with the publisher, make sure to shutdown to free up resources.
   *   publisher.shutdown();
   *   publisher.awaitTermination(1, TimeUnit.MINUTES);
   * }
   * }</pre>
   */
  public static Builder newBuilder(TopicName topicName) {
    return newBuilder(topicName.toString());
  }

  /**
   * Constructs a new {@link Builder} using the given topic.
   *
   * <p>Example of creating a {@code Publisher}.
   *
   * <pre>{@code
   * String topic = "projects/my_project/topics/my_topic";
   * Publisher publisher = Publisher.newBuilder(topic).build();
   * try {
   *   // ...
   * } finally {
   *   // When finished with the publisher, make sure to shutdown to free up resources.
   *   publisher.shutdown();
   *   publisher.awaitTermination(1, TimeUnit.MINUTES);
   * }
   * }</pre>
   */
  public static Builder newBuilder(String topicName) {
    return new Builder(topicName);
  }

  /** A builder of {@link Publisher}s. */
  public static final class Builder {
    static final Duration MIN_TOTAL_TIMEOUT = Duration.ofSeconds(10);
    static final Duration MIN_RPC_TIMEOUT = Duration.ofMillis(10);

    // Meaningful defaults.
    static final long DEFAULT_ELEMENT_COUNT_THRESHOLD = 100L;
    static final long DEFAULT_REQUEST_BYTES_THRESHOLD = 1000L; // 1 kB
    static final Duration DEFAULT_DELAY_THRESHOLD = Duration.ofMillis(1);
    static final Duration DEFAULT_RPC_TIMEOUT = Duration.ofSeconds(10);
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
            .setInitialRetryDelay(Duration.ofMillis(5))
            .setRetryDelayMultiplier(2)
            .setMaxRetryDelay(Duration.ofMillis(Long.MAX_VALUE))
            .setInitialRpcTimeout(DEFAULT_RPC_TIMEOUT)
            .setRpcTimeoutMultiplier(2)
            .setMaxRpcTimeout(DEFAULT_RPC_TIMEOUT)
            .build();

    private static final int THREADS_PER_CPU = 5;
    static final ExecutorProvider DEFAULT_EXECUTOR_PROVIDER =
        InstantiatingExecutorProvider.newBuilder()
            .setExecutorThreadCount(THREADS_PER_CPU * Runtime.getRuntime().availableProcessors())
            .build();

    String topicName;

    // Batching options
    BatchingSettings batchingSettings = DEFAULT_BATCHING_SETTINGS;

    RetrySettings retrySettings = DEFAULT_RETRY_SETTINGS;

    TransportChannelProvider channelProvider =
        TopicAdminSettings.defaultGrpcTransportProviderBuilder().setChannelsPerCpu(1).build();

    HeaderProvider headerProvider = new NoHeaderProvider();
    HeaderProvider internalHeaderProvider =
        TopicAdminSettings.defaultApiClientHeaderProviderBuilder().build();
    ExecutorProvider executorProvider = DEFAULT_EXECUTOR_PROVIDER;
    CredentialsProvider credentialsProvider =
        TopicAdminSettings.defaultCredentialsProviderBuilder().build();

    private Builder(String topic) {
      this.topicName = Preconditions.checkNotNull(topic);
    }

    /**
     * {@code ChannelProvider} to use to create Channels, which must point at Cloud Pub/Sub
     * endpoint.
     *
     * <p>For performance, this client benefits from having multiple underlying connections. See
     * {@link com.google.api.gax.grpc.InstantiatingGrpcChannelProvider.Builder#setPoolSize(int)}.
     */
    public Builder setChannelProvider(TransportChannelProvider channelProvider) {
      this.channelProvider = Preconditions.checkNotNull(channelProvider);
      return this;
    }

    /**
     * Sets the static header provider. The header provider will be called during client
     * construction only once. The headers returned by the provider will be cached and supplied as
     * is for each request issued by the constructed client. Some reserved headers can be overridden
     * (e.g. Content-Type) or merged with the default value (e.g. User-Agent) by the underlying
     * transport layer.
     *
     * @param headerProvider the header provider
     * @return the builder
     */
    @BetaApi
    public Builder setHeaderProvider(HeaderProvider headerProvider) {
      this.headerProvider = Preconditions.checkNotNull(headerProvider);
      return this;
    }

    /**
     * Sets the static header provider for getting internal (library-defined) headers. The header
     * provider will be called during client construction only once. The headers returned by the
     * provider will be cached and supplied as is for each request issued by the constructed client.
     * Some reserved headers can be overridden (e.g. Content-Type) or merged with the default value
     * (e.g. User-Agent) by the underlying transport layer.
     *
     * @param internalHeaderProvider the internal header provider
     * @return the builder
     */
    Builder setInternalHeaderProvider(HeaderProvider internalHeaderProvider) {
      this.internalHeaderProvider = Preconditions.checkNotNull(internalHeaderProvider);
      return this;
    }

    /** {@code CredentialsProvider} to use to create Credentials to authenticate calls. */
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      this.credentialsProvider = Preconditions.checkNotNull(credentialsProvider);
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
      Preconditions.checkArgument(batchingSettings.getDelayThreshold().toMillis() > 0);
      this.batchingSettings = batchingSettings;
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

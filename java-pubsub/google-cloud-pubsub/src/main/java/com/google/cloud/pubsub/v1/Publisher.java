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

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
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
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import com.google.pubsub.v1.TopicNames;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
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
 * <p>{@link Publisher} will use the credentials set on the channel, which uses application default
 * credentials through {@link GoogleCredentials#getApplicationDefault} by default.
 */
public class Publisher {
  private static final Logger logger = Logger.getLogger(Publisher.class.getName());

  private final String topicName;

  private final BatchingSettings batchingSettings;
  private final boolean enableMessageOrdering;

  private final Lock messagesBatchLock;

  private final Map<String, MessagesBatch> messagesBatches;

  private final AtomicBoolean activeAlarm;

  private final PublisherStub publisherStub;

  private final ScheduledExecutorService executor;

  private final SequentialExecutorService.CallbackExecutor sequentialExecutor;

  private final AtomicBoolean shutdown;
  private final BackgroundResource backgroundResources;
  private final MessageWaiter messagesWaiter;
  private ScheduledFuture<?> currentAlarmFuture;
  private final ApiFunction<PubsubMessage, PubsubMessage> messageTransform;

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
    this.enableMessageOrdering = builder.enableMessageOrdering;
    this.messageTransform = builder.messageTransform;

    messagesBatches = new HashMap<>();
    messagesBatchLock = new ReentrantLock();
    activeAlarm = new AtomicBoolean(false);
    executor = builder.executorProvider.getExecutor();
    sequentialExecutor = new SequentialExecutorService.CallbackExecutor(executor);
    List<BackgroundResource> backgroundResourceList = new ArrayList<>();
    if (builder.executorProvider.shouldAutoClose()) {
      backgroundResourceList.add(new ExecutorAsBackgroundResource(executor));
    }

    // Publisher used to take maxAttempt == 0 to mean infinity, but to GAX it means don't retry.
    // We post-process this here to keep backward-compatibility.
    // Also, if "message ordering" is enabled, the publisher should retry sending the failed
    // message infinitely rather than sending the next one.
    RetrySettings.Builder retrySettingsBuilder = builder.retrySettings.toBuilder();
    if (retrySettingsBuilder.getMaxAttempts() == 0) {
      retrySettingsBuilder.setMaxAttempts(Integer.MAX_VALUE);
    }
    if (enableMessageOrdering) {
      // TODO: is there a way to have the default retry settings for requests without an ordering
      // key?
      retrySettingsBuilder
          .setMaxAttempts(Integer.MAX_VALUE)
          .setTotalTimeout(Duration.ofNanos(Long.MAX_VALUE));
    }

    PublisherStubSettings.Builder stubSettings =
        PublisherStubSettings.newBuilder()
            .setCredentialsProvider(builder.credentialsProvider)
            .setExecutorProvider(FixedExecutorProvider.create(executor))
            .setTransportChannelProvider(builder.channelProvider)
            .setEndpoint(builder.endpoint);
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
        .setRetrySettings(retrySettingsBuilder.build())
        .setBatchingSettings(BatchingSettings.newBuilder().setIsEnabled(false).build());
    this.publisherStub = GrpcPublisherStub.create(stubSettings.build());
    backgroundResourceList.add(publisherStub);
    backgroundResources = new BackgroundResourceAggregation(backgroundResourceList);
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
   * }, MoreExecutors.directExecutor());
   * }</pre>
   *
   * @param message the message to publish.
   * @return the message ID wrapped in a future.
   */
  public ApiFuture<String> publish(PubsubMessage message) {
    Preconditions.checkState(!shutdown.get(), "Cannot publish on a shut-down publisher.");

    final String orderingKey = message.getOrderingKey();
    Preconditions.checkState(
        orderingKey.isEmpty() || enableMessageOrdering,
        "Cannot publish a message with an ordering key when message ordering is not enabled.");

    final OutstandingPublish outstandingPublish =
        new OutstandingPublish(messageTransform.apply(message));
    List<OutstandingBatch> batchesToSend;
    messagesBatchLock.lock();
    try {
      MessagesBatch messagesBatch = messagesBatches.get(orderingKey);
      if (messagesBatch == null) {
        messagesBatch = new MessagesBatch(batchingSettings, orderingKey);
        messagesBatches.put(orderingKey, messagesBatch);
      }

      batchesToSend = messagesBatch.add(outstandingPublish);
      if (!batchesToSend.isEmpty() && messagesBatch.isEmpty()) {
        messagesBatches.remove(orderingKey);
      }
      // Setup the next duration based delivery alarm if there are messages batched.
      setupAlarm();
      // For messages with an ordering key, we need to publish with messagesBatchLock held in order
      // to ensure another publish doesn't slip in and send a batch before these batches we already
      // want to send.
      if (!batchesToSend.isEmpty() && !orderingKey.isEmpty()) {
        for (final OutstandingBatch batch : batchesToSend) {
          logger.log(Level.FINER, "Scheduling a batch for immediate sending.");
          publishOutstandingBatch(batch);
        }
      }
    } finally {
      messagesBatchLock.unlock();
    }

    messagesWaiter.incrementPendingMessages(1);

    // For messages without ordering keys, it is okay to send batches without holding
    // messagesBatchLock.
    if (!batchesToSend.isEmpty() && orderingKey.isEmpty()) {
      for (final OutstandingBatch batch : batchesToSend) {
        logger.log(Level.FINER, "Scheduling a batch for immediate sending.");
        executor.execute(
            new Runnable() {
              @Override
              public void run() {
                publishOutstandingBatch(batch);
              }
            });
      }
    }

    return outstandingPublish.publishResult;
  }

  /**
   * There may be non-recoverable problems with a request for an ordering key. In that case, all
   * subsequent requests will fail until this method is called. If the key is not currently paused,
   * calling this method will be a no-op.
   *
   * @param key The key for which to resume publishing.
   */
  @BetaApi("Ordering is not yet fully supported and requires special project enablements.")
  public void resumePublish(String key) {
    Preconditions.checkState(!shutdown.get(), "Cannot publish on a shut-down publisher.");
    sequentialExecutor.resumePublish(key);
  }

  private void setupAlarm() {
    if (!messagesBatches.isEmpty()) {
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
                    publishAllWithoutInflight();
                  }
                },
                delayThresholdMs,
                TimeUnit.MILLISECONDS);
      }
    } else if (currentAlarmFuture != null) {
      logger.log(Level.FINER, "Cancelling alarm, no more messages");
      if (activeAlarm.getAndSet(false)) {
        currentAlarmFuture.cancel(false);
      }
    }
  }

  /**
   * Publish any outstanding batches if non-empty. This method sends buffered messages, but does not
   * wait for the send operations to complete. To wait for messages to send, call {@code get} on the
   * futures returned from {@code publish}.
   */
  public void publishAllOutstanding() {
    OutstandingBatch unorderedOutstandingBatch = null;
    messagesBatchLock.lock();
    try {
      for (MessagesBatch batch : messagesBatches.values()) {
        if (!batch.isEmpty()) {
          if (!batch.orderingKey.isEmpty()) {
            // For messages with an ordering key, we need to publish with messagesBatchLock held in
            // order to ensure another publish doesn't slip in and send a batch before these batches
            // we already want to send.
            publishOutstandingBatch(batch.popOutstandingBatch());
          } else {
            unorderedOutstandingBatch = batch.popOutstandingBatch();
          }
        }
      }
      messagesBatches.clear();
    } finally {
      messagesBatchLock.unlock();
    }
    if (unorderedOutstandingBatch != null) {
      publishOutstandingBatch(unorderedOutstandingBatch);
    }
  }

  /**
   * Publish any outstanding batches if non-empty and there are no other batches in flight. This
   * method sends buffered messages, but does not wait for the send operations to complete. To wait
   * for messages to send, call {@code get} on the futures returned from {@code publish}.
   */
  private void publishAllWithoutInflight() {
    OutstandingBatch unorderedOutstandingBatch = null;
    messagesBatchLock.lock();
    try {
      Iterator<Map.Entry<String, MessagesBatch>> it = messagesBatches.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry<String, MessagesBatch> entry = it.next();
        MessagesBatch batch = entry.getValue();
        String key = entry.getKey();
        if (batch.isEmpty()) {
          it.remove();
        } else if (key.isEmpty()) {
          // We will publish the batch with no ordering key outside messagesBatchLock.
          unorderedOutstandingBatch = batch.popOutstandingBatch();
          it.remove();
        } else if (!sequentialExecutor.hasTasksInflight(key)) {
          publishOutstandingBatch(batch.popOutstandingBatch());
          it.remove();
        }
      }
    } finally {
      messagesBatchLock.unlock();
    }
    if (unorderedOutstandingBatch != null) {
      publishOutstandingBatch(unorderedOutstandingBatch);
    }
  }

  private ApiFuture<PublishResponse> publishCall(OutstandingBatch outstandingBatch) {
    return publisherStub
        .publishCallable()
        .futureCall(
            PublishRequest.newBuilder()
                .setTopic(topicName)
                .addAllMessages(outstandingBatch.getMessages())
                .build());
  }

  private void publishOutstandingBatch(final OutstandingBatch outstandingBatch) {
    final ApiFutureCallback<PublishResponse> futureCallback =
        new ApiFutureCallback<PublishResponse>() {
          @Override
          public void onSuccess(PublishResponse result) {
            try {
              if (result == null || result.getMessageIdsCount() != outstandingBatch.size()) {
                outstandingBatch.onFailure(
                    new IllegalStateException(
                        String.format(
                            "The publish result count %s does not match "
                                + "the expected %s results. Please contact Cloud Pub/Sub support "
                                + "if this frequently occurs",
                            result.getMessageIdsCount(), outstandingBatch.size())));
              } else {
                outstandingBatch.onSuccess(result.getMessageIdsList());
              }
            } finally {
              messagesWaiter.incrementPendingMessages(-outstandingBatch.size());
            }
          }

          @Override
          public void onFailure(Throwable t) {
            try {
              outstandingBatch.onFailure(t);
            } finally {
              messagesWaiter.incrementPendingMessages(-outstandingBatch.size());
            }
          }
        };

    ApiFuture<PublishResponse> future;
    if (outstandingBatch.orderingKey == null || outstandingBatch.orderingKey.isEmpty()) {
      future = publishCall(outstandingBatch);
    } else {
      // If ordering key is specified, publish the batch using the sequential executor.
      future =
          sequentialExecutor.submit(
              outstandingBatch.orderingKey,
              new Callable<ApiFuture<PublishResponse>>() {
                public ApiFuture<PublishResponse> call() {
                  return publishCall(outstandingBatch);
                }
              });
    }
    ApiFutures.addCallback(future, futureCallback, directExecutor());
  }

  private static final class OutstandingBatch {
    final List<OutstandingPublish> outstandingPublishes;
    final long creationTime;
    int attempt;
    int batchSizeBytes;
    final String orderingKey;

    OutstandingBatch(
        List<OutstandingPublish> outstandingPublishes, int batchSizeBytes, String orderingKey) {
      this.outstandingPublishes = outstandingPublishes;
      attempt = 1;
      creationTime = System.currentTimeMillis();
      this.batchSizeBytes = batchSizeBytes;
      this.orderingKey = orderingKey;
    }

    int size() {
      return outstandingPublishes.size();
    }

    private List<PubsubMessage> getMessages() {
      List<PubsubMessage> results = new ArrayList<>(outstandingPublishes.size());
      for (OutstandingPublish outstandingPublish : outstandingPublishes) {
        results.add(outstandingPublish.message);
      }
      return results;
    }

    private void onFailure(Throwable t) {
      for (OutstandingPublish outstandingPublish : outstandingPublishes) {
        outstandingPublish.publishResult.setException(t);
      }
    }

    private void onSuccess(Iterable<String> results) {
      Iterator<OutstandingPublish> messagesResultsIt = outstandingPublishes.iterator();
      for (String messageId : results) {
        messagesResultsIt.next().publishResult.set(messageId);
      }
    }
  }

  private static final class OutstandingPublish {
    final SettableApiFuture<String> publishResult;
    final PubsubMessage message;
    final int messageSize;

    OutstandingPublish(PubsubMessage message) {
      this.publishResult = SettableApiFuture.create();
      this.message = message;
      this.messageSize = message.getSerializedSize();
    }
  }

  /** The batching settings configured on this {@code Publisher}. */
  public BatchingSettings getBatchingSettings() {
    return batchingSettings;
  }

  /**
   * Schedules immediate publishing of any outstanding messages and waits until all are processed.
   *
   * <p>Sends remaining outstanding messages and prevents future calls to publish. This method
   * should be invoked prior to deleting the {@link Publisher} object in order to ensure that no
   * pending messages are lost.
   */
  public void shutdown() {
    Preconditions.checkState(
        !shutdown.getAndSet(true), "Cannot shut down a publisher already shut-down.");
    if (currentAlarmFuture != null && activeAlarm.getAndSet(false)) {
      currentAlarmFuture.cancel(false);
    }
    publishAllOutstanding();
    backgroundResources.shutdown();
  }

  /**
   * Wait for all work has completed execution after a {@link #shutdown()} request, or the timeout
   * occurs, or the current thread is interrupted.
   *
   * <p>Call this method to make sure all resources are freed properly.
   */
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
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
    private static final Duration DEFAULT_RPC_TIMEOUT = Duration.ofSeconds(10);
    private static final Duration DEFAULT_TOTAL_TIMEOUT = MIN_TOTAL_TIMEOUT;
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
    static final boolean DEFAULT_ENABLE_MESSAGE_ORDERING = false;
    private static final int THREADS_PER_CPU = 5;
    static final ExecutorProvider DEFAULT_EXECUTOR_PROVIDER =
        InstantiatingExecutorProvider.newBuilder()
            .setExecutorThreadCount(THREADS_PER_CPU * Runtime.getRuntime().availableProcessors())
            .build();

    String topicName;
    private String endpoint = PublisherStubSettings.getDefaultEndpoint();

    // Batching options
    BatchingSettings batchingSettings = DEFAULT_BATCHING_SETTINGS;

    RetrySettings retrySettings = DEFAULT_RETRY_SETTINGS;

    private boolean enableMessageOrdering = DEFAULT_ENABLE_MESSAGE_ORDERING;

    private TransportChannelProvider channelProvider =
        TopicAdminSettings.defaultGrpcTransportProviderBuilder().setChannelsPerCpu(1).build();

    private HeaderProvider headerProvider = new NoHeaderProvider();
    private HeaderProvider internalHeaderProvider =
        TopicAdminSettings.defaultApiClientHeaderProviderBuilder().build();
    ExecutorProvider executorProvider = DEFAULT_EXECUTOR_PROVIDER;
    private CredentialsProvider credentialsProvider =
        TopicAdminSettings.defaultCredentialsProviderBuilder().build();

    private ApiFunction<PubsubMessage, PubsubMessage> messageTransform =
        new ApiFunction<PubsubMessage, PubsubMessage>() {
          @Override
          public PubsubMessage apply(PubsubMessage input) {
            return input;
          }
        };

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

    /** Sets the message ordering option. */
    @BetaApi("Ordering is not yet fully supported and requires special project enablements.")
    public Builder setEnableMessageOrdering(boolean enableMessageOrdering) {
      this.enableMessageOrdering = enableMessageOrdering;
      return this;
    }

    /** Gives the ability to set a custom executor to be used by the library. */
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      this.executorProvider = Preconditions.checkNotNull(executorProvider);
      return this;
    }

    /**
     * Gives the ability to set an {@link ApiFunction} that will transform the {@link PubsubMessage}
     * before it is sent
     */
    @BetaApi
    public Builder setTransform(ApiFunction<PubsubMessage, PubsubMessage> messageTransform) {
      this.messageTransform =
          Preconditions.checkNotNull(messageTransform, "The messageTransform cannnot be null.");
      return this;
    }

    /** Gives the ability to override the gRPC endpoint. */
    public Builder setEndpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    public Publisher build() throws IOException {
      return new Publisher(this);
    }
  }

  private static class MessagesBatch {
    private List<OutstandingPublish> messages;
    private int batchedBytes;
    private String orderingKey;
    private final BatchingSettings batchingSettings;

    private MessagesBatch(BatchingSettings batchingSettings, String orderingKey) {
      this.batchingSettings = batchingSettings;
      this.orderingKey = orderingKey;
      reset();
    }

    private OutstandingBatch popOutstandingBatch() {
      OutstandingBatch batch = new OutstandingBatch(messages, batchedBytes, orderingKey);
      reset();
      return batch;
    }

    private void reset() {
      messages = new LinkedList<>();
      batchedBytes = 0;
    }

    private boolean isEmpty() {
      return messages.isEmpty();
    }

    private int getBatchedBytes() {
      return batchedBytes;
    }

    private int getMessagesCount() {
      return messages.size();
    }

    private boolean hasBatchingBytes() {
      return getMaxBatchBytes() > 0;
    }

    private long getMaxBatchBytes() {
      return batchingSettings.getRequestByteThreshold();
    }

    private List<OutstandingBatch> add(OutstandingPublish outstandingPublish) {
      List<OutstandingBatch> batchesToSend = new ArrayList<>();
      // Check if the next message makes the current batch exceed the max batch byte size.
      if (!isEmpty()
          && hasBatchingBytes()
          && getBatchedBytes() + outstandingPublish.messageSize >= getMaxBatchBytes()) {
        batchesToSend.add(popOutstandingBatch());
      }

      messages.add(outstandingPublish);
      batchedBytes += outstandingPublish.messageSize;

      // Border case: If the message to send is greater or equals to the max batch size then send it
      // immediately.
      // Alternatively if after adding the message we have reached the batch max messages then we
      // have a batch to send.
      if ((hasBatchingBytes() && outstandingPublish.messageSize >= getMaxBatchBytes())
          || getMessagesCount() == batchingSettings.getElementCountThreshold()) {
        batchesToSend.add(popOutstandingBatch());
      }

      return batchesToSend;
    }
  }
}

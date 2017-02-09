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

import com.google.api.gax.core.Function;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.core.RpcFuture;
import com.google.api.gax.core.RpcFutureCallback;
import com.google.api.gax.grpc.BundlingSettings;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.FlowControlSettings;
import com.google.api.gax.grpc.FlowController;
import com.google.api.gax.grpc.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.RpcFutures;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ForwardingListenableFuture.SimpleForwardingListenableFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
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
 * <p>A {@link Publisher} provides built-in capabilities to automatically handle bundling of
 * messages, controlling memory utilization, and retrying API calls on transient errors.
 *
 * <p>With customizable options that control:
 *
 * <ul>
 *   <li>Message bundling: such as number of messages or max bundle byte size.
 *   <li>Flow control: such as max outstanding messages and maximum outstanding bytes.
 *   <li>Retries: such as the maximum duration of retries for a failing bundle of messages.
 * </ul>
 *
 * <p>If no credentials are provided, the {@link Publisher} will use application default credentials
 * through {@link GoogleCredentials#getApplicationDefault}.
 *
 * <p>For example, a {@link Publisher} can be constructed and used to publish a list of messages as
 * follows:
 *
 * <pre><code>
 *  Publisher publisher =
 *       Publisher.newBuilder(MY_TOPIC)
 *           .setMaxBundleDuration(new Duration(10 * 1000))
 *           .build();
 *  List&lt;RpcFuture&lt;String&gt;&gt; results = new ArrayList&lt;&gt;();
 *
 *  for (PubsubMessage messages : messagesToPublish) {
 *    results.add(publisher.publish(message));
 *  }
 *
 *  Futures.addCallback(
 *  Futures.allAsList(results),
 *  new FutureCallback&lt;List&lt;String&gt;&gt;() {
 *    &#64;Override
 *    public void onSuccess(List&lt;String&gt; messageIds) {
 *      // ... process the acknowledgement of publish ...
 *    }
 *    &#64;Override
 *    public void onFailure(Throwable t) {
 *      // .. handle the failure ...
 *    }
 *  });
 *
 *  // Ensure all the outstanding messages have been published before shutting down your process.
 *  publisher.shutdown();
 * </code></pre>
 */
public class Publisher {
  private static final Logger logger = Logger.getLogger(Publisher.class.getName());

  private final TopicName topicName;
  private final String cachedTopicNameString;

  private final BundlingSettings bundlingSettings;
  private final RetrySettings retrySettings;
  private final LongRandom longRandom;

  private final FlowControlSettings flowControlSettings;
  private final boolean failOnFlowControlLimits;

  private final Lock messagesBundleLock;
  private List<OutstandingPublish> messagesBundle;
  private int bundledBytes;

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

    this.bundlingSettings = builder.bundlingSettings;
    this.retrySettings = builder.retrySettings;
    this.longRandom = builder.longRandom;

    flowControlSettings = builder.flowControlSettings;
    failOnFlowControlLimits = builder.failOnFlowControlLimits;
    this.flowController = new FlowController(flowControlSettings, failOnFlowControlLimits);

    messagesBundle = new LinkedList<>();
    messagesBundleLock = new ReentrantLock();
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
   * be delayed based on the publisher bundling options.
   *
   * <p>Depending on chosen flow control {@link #failOnFlowControlLimits option}, the returned
   * future might immediately fail with a {@link FlowController.FlowControlException} or block the
   * current thread until there are more resources available to publish.
   *
   * @param message the message to publish.
   * @return the message ID wrapped in a future.
   */
  public RpcFuture<String> publish(PubsubMessage message) {
    if (shutdown.get()) {
      throw new IllegalStateException("Cannot publish on a shut-down publisher.");
    }

    final int messageSize = message.getSerializedSize();
    try {
      flowController.reserve(1, messageSize);
    } catch (FlowController.FlowControlException e) {
      return RpcFutures.immediateFailedFuture(e);
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
        if (messagesBundle.size() == getBundlingSettings().getElementCountThreshold()) {
          bundleToSend = new OutstandingBundle(messagesBundle, bundledBytes);
          messagesBundle = new LinkedList<>();
          bundledBytes = 0;
        }
      }
      // Setup the next duration based delivery alarm if there are messages bundled.
      if (!messagesBundle.isEmpty()) {
        setupDurationBasedPublishAlarm();
      } else if (currentAlarmFuture != null) {
        logger.log(Level.INFO, "Cancelling alarm");
        if (activeAlarm.getAndSet(false)) {
          currentAlarmFuture.cancel(false);
        }
      }
    } finally {
      messagesBundleLock.unlock();
    }

    messagesWaiter.incrementPendingMessages(1);

    if (bundleToSend != null) {
      logger.log(Level.INFO, "Scheduling a bundle for immediate sending.");
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
      logger.log(
          Level.INFO, "Message exceeds the max bundle bytes, scheduling it for immediate send.");
      executor.execute(
          new Runnable() {
            @Override
            public void run() {
              publishOutstandingBundle(
                  new OutstandingBundle(ImmutableList.of(outstandingPublish), messageSize));
            }
          });
    }

    return new ListenableFutureDelegate<String>(publishResult);
  }

  private static class ListenableFutureDelegate<V> extends SimpleForwardingListenableFuture<V>
      implements RpcFuture<V> {
    ListenableFutureDelegate(ListenableFuture<V> delegate) {
      super(delegate);
    }

    public void addCallback(final RpcFutureCallback<? super V> callback) {
      Futures.addCallback(
          this,
          new FutureCallback<V>() {
            @Override
            public void onFailure(Throwable t) {
              callback.onFailure(t);
            }

            @Override
            public void onSuccess(V v) {
              callback.onSuccess(v);
            }
          });
    }

    public <X extends Throwable> RpcFuture catching(
        Class<X> exceptionType, final Function<? super X, ? extends V> callback) {
      return new ListenableFutureDelegate<V>(
          Futures.catching(
              this,
              exceptionType,
              new com.google.common.base.Function<X, V>() {
                @Override
                public V apply(X input) {
                  return callback.apply(input);
                }
              }));
  }
  }

  private void setupDurationBasedPublishAlarm() {
    if (!activeAlarm.getAndSet(true)) {
      long delayThresholdMs = getBundlingSettings().getDelayThreshold().getMillis();
      logger.log(Level.INFO, "Setting up alarm for the next %d ms.", delayThresholdMs);
      currentAlarmFuture =
          executor.schedule(
              new Runnable() {
                @Override
                public void run() {
                  logger.log(Level.INFO, "Sending messages based on schedule.");
                  activeAlarm.getAndSet(false);
                  publishAllOutstanding();
                }
              },
              delayThresholdMs,
              TimeUnit.MILLISECONDS);
    }
  }

  private void publishAllOutstanding() {
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
    publishRequest.setTopic(cachedTopicNameString);
    for (OutstandingPublish outstandingPublish : outstandingBundle.outstandingPublishes) {
      publishRequest.addMessages(outstandingPublish.message);
    }

    int currentChannel = channelIndex.next();

    long rpcTimeoutMs =
        Math.round(
            retrySettings.getInitialRpcTimeout().getMillis()
                * Math.pow(retrySettings.getRpcTimeoutMultiplier(), outstandingBundle.attempt - 1));
    rpcTimeoutMs = Math.min(rpcTimeoutMs, retrySettings.getMaxRpcTimeout().getMillis());

    Futures.addCallback(
        PublisherGrpc.newFutureStub(channels[currentChannel])
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
            long nextBackoffDelay =
                computeNextBackoffDelayMs(outstandingBundle, retrySettings, longRandom);

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

  /** The bundling settings configured on this {@code Publisher}. */
  public BundlingSettings getBundlingSettings() {
    return bundlingSettings;
  }

  private long getMaxBundleBytes() {
    return getBundlingSettings().getRequestByteThreshold();
  }

  /**
   * The bundling settings configured on this {@code Publisher}. See {@link
   * #failOnFlowControlLimits()}.
   */
  public FlowControlSettings getFlowControlSettings() {
    return flowControlSettings;
  }

  /**
   * Whether to block publish calls when reaching flow control limits (see {@link
   * #getFlowControlSettings()}).
   *
   * <p>If set to false, a publish call will fail with either {@link
   * FlowController.MaxOutstandingRequestBytesReachedException} or {@link
   * FlowController.MaxOutstandingElementCountReachedException}, as appropriate, when flow control
   * limits are reached.
   */
  public boolean failOnFlowControlLimits() {
    return failOnFlowControlLimits;
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

  private boolean hasBundlingBytes() {
    return getMaxBundleBytes() > 0;
  }

  private static long computeNextBackoffDelayMs(
      OutstandingBundle outstandingBundle, RetrySettings retrySettings, LongRandom longRandom) {
    long delayMillis =
        Math.round(
            retrySettings.getInitialRetryDelay().getMillis()
                * Math.pow(retrySettings.getRetryDelayMultiplier(), outstandingBundle.attempt - 1));
    delayMillis = Math.min(retrySettings.getMaxRetryDelay().getMillis(), delayMillis);
    outstandingBundle.attempt++;
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

  /** Constructs a new {@link Builder} using the given topic. */
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
    static final BundlingSettings DEFAULT_BUNDLING_SETTINGS =
        BundlingSettings.newBuilder()
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

    // Bundling options
    BundlingSettings bundlingSettings = DEFAULT_BUNDLING_SETTINGS;

    // Client-side flow control options
    FlowControlSettings flowControlSettings = FlowControlSettings.getDefaultInstance();
    boolean failOnFlowControlLimits;

    RetrySettings retrySettings = DEFAULT_RETRY_SETTINGS;
    LongRandom longRandom = DEFAULT_LONG_RANDOM;

    ChannelProvider channelProvider = PublisherSettings.defaultChannelProviderBuilder().build();
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

    // Bundling options
    public Builder setBundlingSettings(BundlingSettings bundlingSettings) {
      Preconditions.checkNotNull(bundlingSettings);
      Preconditions.checkNotNull(bundlingSettings.getElementCountThreshold());
      Preconditions.checkArgument(bundlingSettings.getElementCountThreshold() > 0);
      Preconditions.checkNotNull(bundlingSettings.getRequestByteThreshold());
      Preconditions.checkArgument(bundlingSettings.getRequestByteThreshold() > 0);
      Preconditions.checkNotNull(bundlingSettings.getDelayThreshold());
      Preconditions.checkArgument(bundlingSettings.getDelayThreshold().getMillis() > 0);
      this.bundlingSettings = bundlingSettings;
      return this;
    }

    // Flow control options

    /** Sets the flow control settings. */
    public Builder setFlowControlSettings(FlowControlSettings flowControlSettings) {
      this.flowControlSettings = Preconditions.checkNotNull(flowControlSettings);
      return this;
    }

    /**
     * Whether to fail publish when reaching any of the flow control limits, with either a {@link
     * FlowController.MaxOutstandingRequestBytesReachedException} or {@link
     * FlowController.MaxOutstandingElementCountReachedException} as appropriate.
     *
     * <p>If set to false, then publish operations will block the current thread until the
     * outstanding requests go under the limits.
     */
    public Builder setFailOnFlowControlLimits(boolean fail) {
      failOnFlowControlLimits = fail;
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

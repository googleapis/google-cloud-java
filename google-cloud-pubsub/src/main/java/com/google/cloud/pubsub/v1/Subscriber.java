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

import com.google.api.core.AbstractApiService;
import com.google.api.core.ApiClock;
import com.google.api.core.ApiService;
import com.google.api.core.CurrentMillisClock;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.Distribution;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.SubscriberGrpc;
import com.google.pubsub.v1.SubscriberGrpc.SubscriberFutureStub;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.SubscriptionName;
import io.grpc.CallCredentials;
import io.grpc.ManagedChannel;
import io.grpc.auth.MoreCallCredentials;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

/**
 * A Cloud Pub/Sub <a href="https://cloud.google.com/pubsub/docs/subscriber">subscriber</a> that is
 * associated with a specific subscription at creation.
 *
 * <p>A {@link Subscriber} allows you to provide an implementation of a {@link MessageReceiver
 * receiver} to which messages are going to be delivered as soon as they are received by the
 * subscriber. The delivered messages then can be {@link AckReplyConsumer#ack() acked} or {@link
 * AckReplyConsumer#nack() nacked} at will as they get processed by the receiver. Nacking a messages
 * implies a later redelivery of such message.
 *
 * <p>The subscriber handles the ack management, by automatically extending the ack deadline while
 * the message is being processed, to then issue the ack or nack of such message when the processing
 * is done. <strong>Note:</strong> message redelivery is still possible.
 *
 * <p>It also provides customizable options that control:
 *
 * <ul>
 *   <li>Ack deadline extension: such as the amount of time ahead to trigger the extension of
 *       message acknowledgement expiration.
 *   <li>Flow control: such as the maximum outstanding messages or maximum outstanding bytes to keep
 *       in memory before the receiver either ack or nack them.
 * </ul>
 *
 * <p>{@link Subscriber} will use the credentials set on the channel, which uses
 *  application default credentials through {@link GoogleCredentials#getApplicationDefault}
 *  by default.
 */
public class Subscriber extends AbstractApiService {
  private static final int THREADS_PER_CHANNEL = 5;
  @VisibleForTesting static final int CHANNELS_PER_CORE = 10;
  private static final int MAX_INBOUND_MESSAGE_SIZE =
      20 * 1024 * 1024; // 20MB API maximum message size.
  private static final int INITIAL_ACK_DEADLINE_SECONDS = 10;
  private static final int MAX_ACK_DEADLINE_SECONDS = 600;
  static final int MIN_ACK_DEADLINE_SECONDS = 10;
  private static final Duration ACK_DEADLINE_UPDATE_PERIOD = Duration.ofMinutes(1);
  private static final double PERCENTILE_FOR_ACK_DEADLINE_UPDATES = 99.9;

  private static final ScheduledExecutorService SHARED_SYSTEM_EXECUTOR =
      InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(6).build().getExecutor();

  private static final Logger logger = Logger.getLogger(Subscriber.class.getName());

  private final SubscriptionName subscriptionName;
  private final String cachedSubscriptionNameString;
  private final FlowControlSettings flowControlSettings;
  private final Duration ackExpirationPadding;
  private final Duration maxAckExtensionPeriod;
  private final ScheduledExecutorService executor;
  @Nullable private final ScheduledExecutorService alarmsExecutor;
  private final Distribution ackLatencyDistribution =
      new Distribution(MAX_ACK_DEADLINE_SECONDS + 1);
  private final int numChannels;
  private final FlowController flowController;
  private final ChannelProvider channelProvider;
  private final CredentialsProvider credentialsProvider;
  private final List<ManagedChannel> channels;
  private final MessageReceiver receiver;
  private final List<StreamingSubscriberConnection> streamingSubscriberConnections;
  private final List<PollingSubscriberConnection> pollingSubscriberConnections;
  private final ApiClock clock;
  private final List<AutoCloseable> closeables = new ArrayList<>();
  private ScheduledFuture<?> ackDeadlineUpdater;
  private int streamAckDeadlineSeconds;

  private Subscriber(Builder builder) {
    receiver = builder.receiver;
    flowControlSettings = builder.flowControlSettings;
    subscriptionName = builder.subscriptionName;
    cachedSubscriptionNameString = subscriptionName.toString();
    ackExpirationPadding = builder.ackExpirationPadding;
    maxAckExtensionPeriod = builder.maxAckExtensionPeriod;
    long streamAckDeadlineMillis = ackExpirationPadding.toMillis();
    streamAckDeadlineSeconds =
        Math.max(
            INITIAL_ACK_DEADLINE_SECONDS,
            Ints.saturatedCast(TimeUnit.MILLISECONDS.toSeconds(streamAckDeadlineMillis)));
    clock = builder.clock.isPresent() ? builder.clock.get() : CurrentMillisClock.getDefaultClock();

    flowController =
        new FlowController(
            builder
                .flowControlSettings
                .toBuilder()
                .setLimitExceededBehavior(LimitExceededBehavior.ThrowException)
                .build());

    executor = builder.executorProvider.getExecutor();
    if (builder.executorProvider.shouldAutoClose()) {
      closeables.add(
          new AutoCloseable() {
            @Override
            public void close() throws IOException {
              executor.shutdown();
            }
          });
    }
      alarmsExecutor = builder.systemExecutorProvider.getExecutor();
      if (builder.systemExecutorProvider.shouldAutoClose()) {
        closeables.add(
            new AutoCloseable() {
              @Override
              public void close() throws IOException {
                alarmsExecutor.shutdown();
              }
            });
      }

    channelProvider = builder.channelProvider;
    credentialsProvider = builder.credentialsProvider;

    numChannels = Math.max(1, Runtime.getRuntime().availableProcessors()) * CHANNELS_PER_CORE;
    channels = new ArrayList<ManagedChannel>(numChannels);
    streamingSubscriberConnections = new ArrayList<StreamingSubscriberConnection>(numChannels);
    pollingSubscriberConnections = new ArrayList<PollingSubscriberConnection>(numChannels);
  }

  /**
   * Constructs a new {@link Builder}.
   *
   * <p>Once {@link Builder#build} is called a gRPC stub will be created for use of the {@link
   * Subscriber}.
   *
   * @param subscription Cloud Pub/Sub subscription to bind the subscriber to
   * @param receiver an implementation of {@link MessageReceiver} used to process the received
   *     messages
   */
  public static Builder defaultBuilder(SubscriptionName subscription, MessageReceiver receiver) {
    return new Builder(subscription, receiver);
  }

  /** Subscription which the subscriber is subscribed to. */
  public SubscriptionName getSubscriptionName() {
    return subscriptionName;
  }

  /** Acknowledgement expiration padding. See {@link Builder#setAckExpirationPadding}. */
  public Duration getAckExpirationPadding() {
    return ackExpirationPadding;
  }

  /** The flow control settings the Subscriber is configured with. */
  public FlowControlSettings getFlowControlSettings() {
    return flowControlSettings;
  }

  /**
   * Initiates service startup and returns immediately.
   *
   * <p>Example of receiving a specific number of messages.
   *
   * <pre>{@code
   * Subscriber subscriber = Subscriber.defaultBuilder(subscription, receiver).build();
   * subscriber.addListener(new Subscriber.Listener() {
   *   public void failed(Subscriber.State from, Throwable failure) {
   *     // Handle error.
   *   }
   * }, executor);
   * subscriber.startAsync();
   *
   * // Wait for a stop signal.
   * done.get();
   * subscriber.stopAsync().awaitTerminated();
   * }</pre>
   */
  @Override
  public ApiService startAsync() {
    // Override only for the docs.
    return super.startAsync();
  }

  @Override
  protected void doStart() {
    logger.log(Level.FINE, "Starting subscriber group.");

    try {
      for (int i = 0; i < numChannels; i++) {
        final ManagedChannel channel =
            channelProvider.needsExecutor()
                ? channelProvider.getChannel(executor)
                : channelProvider.getChannel();
        channels.add(channel);
        if (channelProvider.shouldAutoClose()) {
          closeables.add(
              new AutoCloseable() {
                @Override
                public void close() {
                  channel.shutdown();
                }
              });
        }
      }
    } catch (IOException e) {
      // doesn't matter what we throw, the Service will just catch it and fail to start.
      throw new IllegalStateException(e);
    }

    // When started, connections submit tasks to the executor.
    // These tasks must finish before the connections can declare themselves running.
    // If we have a single-thread executor and call startPollingConnections from the
    // same executor, it will deadlock: the thread will be stuck waiting for connections
    // to start but cannot start the connections.
    // For this reason, we spawn a dedicated thread. Starting subscriber should be rare.
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          startPollingConnections();
          notifyStarted();
        } catch (Throwable t) {
          notifyFailed(t);
        }
      }
    }).start();
  }

  @Override
  protected void doStop() {
    // stopAllStreamingConnections();
    stopAllPollingConnections();
    try {
      for (AutoCloseable closeable : closeables) {
        closeable.close();
      }
      notifyStopped();
    } catch (Exception e) {
      notifyFailed(e);
    }
  }

  // Starts polling connections. Blocks until all connections declare themselves running.
  private void startPollingConnections() throws IOException {
    synchronized (pollingSubscriberConnections) {
      Credentials credentials = credentialsProvider.getCredentials();
      CallCredentials callCredentials =
          credentials == null ? null : MoreCallCredentials.from(credentials);

      SubscriberGrpc.SubscriberBlockingStub getSubStub =
          SubscriberGrpc.newBlockingStub(channels.get(0))
              .withDeadlineAfter(
                  PollingSubscriberConnection.DEFAULT_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS);
      if (callCredentials != null) {
        getSubStub = getSubStub.withCallCredentials(callCredentials);
      }
      Subscription subscriptionInfo =
          getSubStub.getSubscription(
              GetSubscriptionRequest.newBuilder()
                  .setSubscription(cachedSubscriptionNameString)
                  .build());

      for (int i = 0; i < numChannels; i++) {
        SubscriberFutureStub stub = SubscriberGrpc.newFutureStub(channels.get(i));
        if (callCredentials != null) {
          stub = stub.withCallCredentials(callCredentials);
        }
        pollingSubscriberConnections.add(
            new PollingSubscriberConnection(
                subscriptionInfo,
                receiver,
                ackExpirationPadding,
                maxAckExtensionPeriod,
                ackLatencyDistribution,
                stub,
                flowController,
                flowControlSettings.getMaxOutstandingElementCount(),
                executor,
                alarmsExecutor,
                clock));
      }
      startConnections(
          pollingSubscriberConnections,
          new Listener() {
            @Override
            public void failed(State from, Throwable failure) {
              // If a connection failed is because of a fatal error, we should fail the
              // whole subscriber.
              stopAllPollingConnections();
              try {
                notifyFailed(failure);
              } catch (IllegalStateException e) {
                if (isRunning()) {
                  throw e;
                }
                // It could happen that we are shutting down while some channels fail.
              }
            }
          });
    }
  }

  private void stopAllPollingConnections() {
    stopConnections(pollingSubscriberConnections);
  }

  private void startConnections(
      List<? extends ApiService> connections, final ApiService.Listener connectionsListener) {
    for (ApiService subscriber : connections) {
      subscriber.addListener(connectionsListener, executor);
      subscriber.startAsync();
    }
    for (ApiService subscriber : connections) {
      subscriber.awaitRunning();
    }
  }

  private void stopConnections(List<? extends ApiService> connections) {
    ArrayList<ApiService> liveConnections;
    synchronized (connections) {
      liveConnections = new ArrayList<ApiService>(connections);
      connections.clear();
    }
    for (ApiService subscriber : liveConnections) {
      subscriber.stopAsync();
    }
    for (ApiService subscriber : liveConnections) {
      try {
        subscriber.awaitTerminated();
      } catch (IllegalStateException e) {
        // If the service fails, awaitTerminated will throw an exception.
        // However, we could be stopping services because at least one
        // has already failed, so we just ignore this exception.
      }
    }
  }

  /** Builder of {@link Subscriber Subscribers}. */
  public static final class Builder {
    private static final Duration MIN_ACK_EXPIRATION_PADDING = Duration.ofMillis(100);
    private static final Duration DEFAULT_ACK_EXPIRATION_PADDING = Duration.ofMillis(500);
    private static final Duration DEFAULT_MAX_ACK_EXTENSION_PERIOD = Duration.ofMinutes(60);
    private static final long DEFAULT_MEMORY_PERCENTAGE = 20;

    static final ExecutorProvider DEFAULT_EXECUTOR_PROVIDER =
        InstantiatingExecutorProvider.newBuilder()
            .setExecutorThreadCount(
                THREADS_PER_CHANNEL
                    * CHANNELS_PER_CORE
                    * Runtime.getRuntime().availableProcessors())
            .build();

    SubscriptionName subscriptionName;
    MessageReceiver receiver;

    Duration ackExpirationPadding = DEFAULT_ACK_EXPIRATION_PADDING;
    Duration maxAckExtensionPeriod = DEFAULT_MAX_ACK_EXTENSION_PERIOD;

    FlowControlSettings flowControlSettings =
        FlowControlSettings.newBuilder()
            .setMaxOutstandingRequestBytes(
                Runtime.getRuntime().maxMemory() * DEFAULT_MEMORY_PERCENTAGE / 100L)
            .build();

    ExecutorProvider executorProvider = DEFAULT_EXECUTOR_PROVIDER;
    ExecutorProvider systemExecutorProvider = FixedExecutorProvider.create(SHARED_SYSTEM_EXECUTOR);
    ChannelProvider channelProvider =
        SubscriptionAdminSettings.defaultGrpcChannelProviderBuilder()
            .setMaxInboundMessageSize(MAX_INBOUND_MESSAGE_SIZE)
            .build();
    CredentialsProvider credentialsProvider =
        SubscriptionAdminSettings.defaultCredentialsProviderBuilder().build();
    Optional<ApiClock> clock = Optional.absent();

    Builder(SubscriptionName subscriptionName, MessageReceiver receiver) {
      this.subscriptionName = subscriptionName;
      this.receiver = receiver;
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

    /** Sets the flow control settings. */
    public Builder setFlowControlSettings(FlowControlSettings flowControlSettings) {
      this.flowControlSettings = Preconditions.checkNotNull(flowControlSettings);
      return this;
    }

    /**
     * Set acknowledgement expiration padding.
     *
     * <p>This is the time accounted before a message expiration is to happen, so the {@link
     * Subscriber} is able to send an ack extension beforehand.
     *
     * <p>This padding duration is configurable so you can account for network latency. A reasonable
     * number must be provided so messages don't expire because of network latency between when the
     * ack extension is required and when it reaches the Pub/Sub service.
     *
     * @param ackExpirationPadding must be greater or equal to {@link #MIN_ACK_EXPIRATION_PADDING}
     */
    public Builder setAckExpirationPadding(Duration ackExpirationPadding) {
      Preconditions.checkArgument(ackExpirationPadding.compareTo(MIN_ACK_EXPIRATION_PADDING) >= 0);
      this.ackExpirationPadding = ackExpirationPadding;
      return this;
    }

    /**
     * Set the maximum period a message ack deadline will be extended.
     *
     * <p>It is recommended to set this value to a reasonable upper bound of the subscriber time to
     * process any message. This maximum period avoids messages to be <i>locked</i> by a subscriber
     * in cases when the ack reply is lost.
     *
     * <p>A zero duration effectively disables auto deadline extensions.
     */
    public Builder setMaxAckExtensionPeriod(Duration maxAckExtensionPeriod) {
      Preconditions.checkArgument(maxAckExtensionPeriod.toMillis() >= 0);
      this.maxAckExtensionPeriod = maxAckExtensionPeriod;
      return this;
    }

    /** Gives the ability to set a custom executor. */
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      this.executorProvider = Preconditions.checkNotNull(executorProvider);
      return this;
    }

    /** {@code CredentialsProvider} to use to create Credentials to authenticate calls. */
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      this.credentialsProvider = Preconditions.checkNotNull(credentialsProvider);
      return this;
    }

    /**
     * Gives the ability to set a custom executor for polling and managing lease extensions. If none
     * is provided a shared one will be used by all {@link Subscriber} instances.
     */
    public Builder setSystemExecutorProvider(ExecutorProvider executorProvider) {
      this.systemExecutorProvider = Preconditions.checkNotNull(executorProvider);
      return this;
    }

    /** Gives the ability to set a custom clock. */
    Builder setClock(ApiClock clock) {
      this.clock = Optional.of(clock);
      return this;
    }

    public Subscriber build() {
      return new Subscriber(this);
    }
  }
}

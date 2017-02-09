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

import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.FlowControlSettings;
import com.google.api.gax.grpc.FlowController;
import com.google.api.gax.grpc.InstantiatingExecutorProvider;
import com.google.api.stats.Distribution;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.Clock;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Service;
import com.google.pubsub.v1.SubscriptionName;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.Duration;

/**
 * A Cloud Pub/Sub <a href="https://cloud.google.com/pubsub/docs/subscriber">subscriber</a> that is
 * associated with a specific subscription at creation.
 *
 * <p>A {@link Subscriber} allows you to provide an implementation of a {@link MessageReceiver
 * receiver} to which messages are going to be delivered as soon as they are received by the
 * subscriber. The delivered messages then can be {@link AckReply#ACK acked} or {@link AckReply#NACK
 * nacked} at will as they get processed by the receiver. Nacking a messages implies a later
 * redelivery of such message.
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
 * <p>If no credentials are provided, the {@link Subscriber} will use application default
 * credentials through {@link GoogleCredentials#getApplicationDefault}.
 *
 * <p>For example, a {@link Subscriber} can be constructed and used to receive messages as follows:
 *
 * <pre><code>
 * MessageReceiver receiver = new MessageReceiver() {
 *   &#64;Override
 *   public void receiveMessage(PubsubMessage message, SettableFuture&lt;AckReply&gt; response) {
 *     // ... process message ...
 *     return response.set(AckReply.ACK);
 *   }
 * }
 *
 * Subscriber subscriber =
 *     Subscriber.newBuilder(MY_SUBSCRIPTION, receiver)
 *         .setMaxBundleAcks(100)
 *         .build();
 *
 * subscriber.startAsync();
 *
 * // ... recommended, listen for fatal errors that break the subscriber streaming ...
 * subscriber.addListener(new Listener() {
 *   &#64;Override
 *   public void failed(State from, Throwable failure) {
 *     System.out.println("Subscriber failed with error: " + failure);
 *   }
 * }, Executors.newSingleThreadExecutor());
 *
 * // ... and when done with the subscriber ...
 * subscriber.stopAsync();
 * </code></pre>
 */
public class Subscriber {
  private static final int THREADS_PER_CHANNEL = 5;
  @VisibleForTesting static final int CHANNELS_PER_CORE = 10;
  private static final int MAX_INBOUND_MESSAGE_SIZE =
      20 * 1024 * 1024; // 20MB API maximum message size.
  private static final int INITIAL_ACK_DEADLINE_SECONDS = 10;
  private static final int MAX_ACK_DEADLINE_SECONDS = 600;
  private static final int MIN_ACK_DEADLINE_SECONDS = 10;
  private static final Duration ACK_DEADLINE_UPDATE_PERIOD = Duration.standardMinutes(1);
  private static final double PERCENTILE_FOR_ACK_DEADLINE_UPDATES = 99.9;

  private final SubscriberImpl impl;

  private Subscriber(Builder builder) throws IOException {
    impl = new SubscriberImpl(builder);
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
  public static Builder newBuilder(SubscriptionName subscription, MessageReceiver receiver) {
    return new Builder(subscription, receiver);
  }

  /** Subscription which the subscriber is subscribed to. */
  public SubscriptionName getSubscriptionName() {
    return impl.subscriptionName;
  }

  /** Acknowledgement expiration padding. See {@link Builder#setAckExpirationPadding}. */
  public Duration getAckExpirationPadding() {
    return impl.ackExpirationPadding;
  }

  /** The flow control settings the Subscriber is configured with. */
  public FlowControlSettings getFlowControlSettings() {
    return impl.flowControlSettings;
  }

  public void addListener(final SubscriberListener listener, Executor executor) {
    impl.addListener(
        new Service.Listener() {
          @Override
          public void failed(Service.State from, Throwable failure) {
            listener.failed(convertState(from), failure);
          }

          @Override
          public void running() {
            listener.running();
          }

          @Override
          public void starting() {
            listener.starting();
          }

          @Override
          public void stopping(Service.State from) {
            listener.stopping(convertState(from));
          }

          @Override
          public void terminated(Service.State from) {
            listener.terminated(convertState(from));
          }
        },
        executor);
  }

  public void awaitRunning() {
    impl.awaitRunning();
  }

  public void awaitRunning(long timeout, TimeUnit unit) throws TimeoutException {
    impl.awaitRunning(timeout, unit);
  }

  public void awaitTerminated() {
    impl.awaitTerminated();
  }

  public void awaitTerminated(long timeout, TimeUnit unit) throws TimeoutException {
    impl.awaitTerminated(timeout, unit);
  }

  public Throwable failureCause() {
    return impl.failureCause();
  }

  public boolean isRunning() {
    return impl.isRunning();
  }

  public Subscriber startAsync() {
    impl.startAsync();
    return this;
  }

  public State state() {
    return convertState(impl.state());
  }

  private State convertState(Service.State state) {
    switch (state) {
      case FAILED:
        return State.FAILED;
      case NEW:
        return State.NEW;
      case RUNNING:
        return State.RUNNING;
      case STARTING:
        return State.STARTING;
      case STOPPING:
        return State.STOPPING;
      case TERMINATED:
        return State.TERMINATED;
    }
    throw new IllegalStateException("unknown state: " + state);
  }

  public Subscriber stopAsync() {
    impl.stopAsync();
    return this;
  }

  public enum State {
    FAILED,
    NEW,
    RUNNING,
    STARTING,
    STOPPING,
    TERMINATED
  }

  public abstract static class SubscriberListener {
    public void failed(Subscriber.State from, Throwable failure) {}

    public void running() {}

    public void starting() {}

    public void stopping(State from) {}

    public void terminated(State from) {}
  }

  private static class SubscriberImpl extends AbstractService {
    private static final Logger logger = Logger.getLogger(Subscriber.class.getName());

    private final SubscriptionName subscriptionName;
    private final String cachedSubscriptionNameString;
    private final FlowControlSettings flowControlSettings;
    private final Duration ackExpirationPadding;
    private final ScheduledExecutorService executor;
    private final Distribution ackLatencyDistribution =
        new Distribution(MAX_ACK_DEADLINE_SECONDS + 1);
    private final int numChannels;
    private final FlowController flowController;
    private final ManagedChannelBuilder<? extends ManagedChannelBuilder<?>> channelBuilder;
    private final Credentials credentials;
    private final MessageReceiver receiver;
    private final List<StreamingSubscriberConnection> streamingSubscriberConnections;
    private final List<PollingSubscriberConnection> pollingSubscriberConnections;
    private final Clock clock;
    private final List<AutoCloseable> closeables = new ArrayList<>();
    private ScheduledFuture<?> ackDeadlineUpdater;
    private int streamAckDeadlineSeconds;

    private SubscriberImpl(Builder builder) throws IOException {
      receiver = builder.receiver;
      flowControlSettings = builder.flowControlSettings;
      subscriptionName = builder.subscriptionName;
      cachedSubscriptionNameString = subscriptionName.toString();
      ackExpirationPadding = builder.ackExpirationPadding;
      streamAckDeadlineSeconds =
          Math.max(
              INITIAL_ACK_DEADLINE_SECONDS,
              Ints.saturatedCast(ackExpirationPadding.getStandardSeconds()));
      clock = builder.clock.isPresent() ? builder.clock.get() : Clock.defaultClock();

      flowController = new FlowController(builder.flowControlSettings, false);

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

      channelBuilder =
          builder.channelBuilder.isPresent()
              ? builder.channelBuilder.get()
              : NettyChannelBuilder.forAddress(
                      SubscriberSettings.getDefaultServiceAddress(),
                      SubscriberSettings.getDefaultServicePort())
                  .maxMessageSize(MAX_INBOUND_MESSAGE_SIZE)
                  .flowControlWindow(5000000) // 2.5 MB
                  .negotiationType(NegotiationType.TLS)
                  .sslContext(GrpcSslContexts.forClient().ciphers(null).build())
                  .executor(executor);

      credentials =
          builder.credentials.isPresent()
              ? builder.credentials.get()
              : GoogleCredentials.getApplicationDefault()
                  .createScoped(SubscriberSettings.getDefaultServiceScopes());

      numChannels = Math.max(1, Runtime.getRuntime().availableProcessors()) * CHANNELS_PER_CORE;
      streamingSubscriberConnections = new ArrayList<StreamingSubscriberConnection>(numChannels);
      pollingSubscriberConnections = new ArrayList<PollingSubscriberConnection>(numChannels);
    }

    @Override
    protected void doStart() {
      logger.log(Level.INFO, "Starting subscriber group.");
      startStreamingConnections();
      notifyStarted();
    }

    @Override
    protected void doStop() {
      stopAllStreamingConnections();
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

    private void startStreamingConnections() {
      synchronized (streamingSubscriberConnections) {
        for (int i = 0; i < numChannels; i++) {
          streamingSubscriberConnections.add(
              new StreamingSubscriberConnection(
                  cachedSubscriptionNameString,
                  credentials,
                  receiver,
                  ackExpirationPadding,
                  streamAckDeadlineSeconds,
                  ackLatencyDistribution,
                  channelBuilder.build(),
                  flowController,
                  executor,
                  clock));
        }
        startConnections(
            streamingSubscriberConnections,
            new Listener() {
              @Override
              public void failed(State from, Throwable failure) {
                // If a connection failed is because of a fatal error, we should fail the
                // whole subscriber.
                stopAllStreamingConnections();
                if (failure instanceof StatusRuntimeException
                    && ((StatusRuntimeException) failure).getStatus().getCode()
                        == Status.Code.UNIMPLEMENTED) {
                  logger.info("Unable to open streaming connections, falling back to polling.");
                  startPollingConnections();
                  return;
                }
                notifyFailed(failure);
              }
            });
      }

      ackDeadlineUpdater =
          executor.scheduleAtFixedRate(
              new Runnable() {
                @Override
                public void run() {
                  // It is guaranteed this will be <= MAX_ACK_DEADLINE_SECONDS, the max of the API.
                  long ackLatency =
                      ackLatencyDistribution.getNthPercentile(PERCENTILE_FOR_ACK_DEADLINE_UPDATES);
                  if (ackLatency > 0) {
                    int possibleStreamAckDeadlineSeconds =
                        Math.max(
                            MIN_ACK_DEADLINE_SECONDS,
                            Ints.saturatedCast(
                                Math.max(ackLatency, ackExpirationPadding.getStandardSeconds())));
                    if (streamAckDeadlineSeconds != possibleStreamAckDeadlineSeconds) {
                      streamAckDeadlineSeconds = possibleStreamAckDeadlineSeconds;
                      logger.log(
                          Level.INFO,
                          "Updating stream deadline to {} seconds.",
                          streamAckDeadlineSeconds);
                      for (StreamingSubscriberConnection subscriberConnection :
                          streamingSubscriberConnections) {
                        subscriberConnection.updateStreamAckDeadline(streamAckDeadlineSeconds);
                      }
                    }
                  }
                }
              },
              ACK_DEADLINE_UPDATE_PERIOD.getMillis(),
              ACK_DEADLINE_UPDATE_PERIOD.getMillis(),
              TimeUnit.MILLISECONDS);
    }

    private void stopAllStreamingConnections() {
      stopConnections(streamingSubscriberConnections);
      ackDeadlineUpdater.cancel(true);
    }

    private void startPollingConnections() {
      synchronized (pollingSubscriberConnections) {
        for (int i = 0; i < numChannels; i++) {
          pollingSubscriberConnections.add(
              new PollingSubscriberConnection(
                  cachedSubscriptionNameString,
                  credentials,
                  receiver,
                  ackExpirationPadding,
                  ackLatencyDistribution,
                  channelBuilder.build(),
                  flowController,
                  executor,
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
        List<? extends Service> connections, final Listener connectionsListener) {
      final CountDownLatch subscribersStarting = new CountDownLatch(numChannels);
      for (final Service subscriber : connections) {
        executor.submit(
            new Runnable() {
              @Override
              public void run() {
                subscriber.startAsync().awaitRunning();
                subscribersStarting.countDown();
                subscriber.addListener(connectionsListener, executor);
              }
            });
      }
      try {
        subscribersStarting.await();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    private void stopConnections(List<? extends Service> connections) {
      ArrayList<Service> liveConnections;
      synchronized (connections) {
        liveConnections = new ArrayList<Service>(connections);
        connections.clear();
      }
      final CountDownLatch connectionsStopping = new CountDownLatch(liveConnections.size());
      for (final Service subscriberConnection : liveConnections) {
        executor.submit(
            new Runnable() {
              @Override
              public void run() {
                try {
                  subscriberConnection.stopAsync().awaitTerminated();
                } catch (IllegalStateException ignored) {
                  // It is expected for some connections to be already in state failed so stop will
                  // throw this expection.
                }
                connectionsStopping.countDown();
              }
            });
      }
      try {
        connectionsStopping.await();
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
    }
  }

  /** Builder of {@link Subscriber Subscribers}. */
  public static final class Builder {
    private static final Duration MIN_ACK_EXPIRATION_PADDING = Duration.millis(100);
    private static final Duration DEFAULT_ACK_EXPIRATION_PADDING = Duration.millis(500);

    static final ExecutorProvider DEFAULT_EXECUTOR_PROVIDER =
        InstantiatingExecutorProvider.newBuilder()
            .setExecutorThreadCount(
                THREADS_PER_CHANNEL
                    * CHANNELS_PER_CORE
                    * Runtime.getRuntime().availableProcessors())
            .build();

    SubscriptionName subscriptionName;
    Optional<Credentials> credentials = Optional.absent();
    MessageReceiver receiver;

    Duration ackExpirationPadding = DEFAULT_ACK_EXPIRATION_PADDING;

    FlowControlSettings flowControlSettings = FlowControlSettings.getDefaultInstance();

    ExecutorProvider executorProvider = DEFAULT_EXECUTOR_PROVIDER;
    Optional<ManagedChannelBuilder<? extends ManagedChannelBuilder<?>>> channelBuilder =
        Optional.absent();
    Optional<Clock> clock = Optional.absent();

    Builder(SubscriptionName subscriptionName, MessageReceiver receiver) {
      this.subscriptionName = subscriptionName;
      this.receiver = receiver;
    }

    /**
     * Credentials to authenticate with.
     *
     * <p>Must be properly scoped for accessing Cloud Pub/Sub APIs.
     */
    public Builder setCredentials(Credentials credentials) {
      this.credentials = Optional.of(Preconditions.checkNotNull(credentials));
      return this;
    }

    /**
     * ManagedChannelBuilder to use to create Channels.
     *
     * <p>Must point at Cloud Pub/Sub endpoint.
     */
    public Builder setChannelBuilder(
        ManagedChannelBuilder<? extends ManagedChannelBuilder<?>> channelBuilder) {
      this.channelBuilder =
          Optional.<ManagedChannelBuilder<? extends ManagedChannelBuilder<?>>>of(
              Preconditions.checkNotNull(channelBuilder));
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

    /** Gives the ability to set a custom executor. */
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      this.executorProvider = Preconditions.checkNotNull(executorProvider);
      return this;
    }

    /** Gives the ability to set a custom clock. */
    Builder setClock(Clock clock) {
      this.clock = Optional.of(clock);
      return this;
    }

    public Subscriber build() throws IOException {
      return new Subscriber(this);
    }
  }
}

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
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.Clock;
import com.google.cloud.pubsub.spi.v1.MessageReceiver.AckReply;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Service;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
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
 *   public ListenableFuture&lt;AckReply&gt; receiveMessage(PubsubMessage message) {
 *     // ... process message ...
 *     return Futures.immediateFuture(AckReply.ACK);
 *   }
 * }
 *
 * Subscriber subscriber =
 *     Subscriber.Builder.newBuilder(MY_SUBSCRIPTION, receiver)
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
public interface Subscriber extends Service {
  /** Retrieves a snapshot of the current subscriber statistics. */
  SubscriberStats getStats();

  /** Subscription for which the subscriber is streaming messages. */
  String getSubscription();

  /**
   * Time before a message is to expire when the subscriber is going to attempt to renew its ack
   * deadline.
   */
  Duration getAckExpirationPadding();

  /**
   * Maximum number of outstanding messages before limits are enforced.
   *
   * <p><b>When limits are enforced, no more messages will be dispatched to the {@link
   * MessageReceiver} but due to the gRPC and HTTP/2 buffering and congestion control window
   * management, still some extra bytes could be kept at lower layers.</b>
   */
  Optional<Integer> getMaxOutstandingElementCount();

  /** Maximum number of outstanding bytes before limits are enforced. */
  Optional<Integer> getMaxOutstandingRequestBytes();

  /** Builder of {@link Subscriber Subscribers}. */
  public final class Builder {
    private static final Duration MIN_ACK_EXPIRATION_PADDING = Duration.millis(100);
    private static final Duration DEFAULT_ACK_EXPIRATION_PADDING = Duration.millis(500);

    String subscription;
    Optional<Credentials> credentials = Optional.absent();
    MessageReceiver receiver;

    Duration ackExpirationPadding = DEFAULT_ACK_EXPIRATION_PADDING;

    FlowController.Settings flowControlSettings = FlowController.Settings.DEFAULT;

    Optional<ScheduledExecutorService> executor = Optional.absent();
    Optional<ManagedChannelBuilder<? extends ManagedChannelBuilder<?>>> channelBuilder =
        Optional.absent();
    Optional<Clock> clock = Optional.absent();

    /**
     * Constructs a new {@link Builder}.
     *
     * <p>Once {@link #build()} is called a gRPC stub will be created for use of the {@link
     * Subscriber}.
     *
     * @param subscription Cloud Pub/Sub subscription to bind the subscriber to
     * @param receiver an implementation of {@link MessageReceiver} used to process the received
     *     messages
     */
    public static Builder newBuilder(String subscription, MessageReceiver receiver) {
      return new Builder(subscription, receiver);
    }

    Builder(String subscription, MessageReceiver receiver) {
      this.subscription = subscription;
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
    public Builder setFlowControlSettings(FlowController.Settings flowControlSettings) {
      this.flowControlSettings = Preconditions.checkNotNull(flowControlSettings);
      return this;
    }

    /**
     * Set acknowledgement expiration padding.
     *
     * <p>This is the time accounted before a message expiration is to happen, so the
     * {@link Subscriber} is able to send an ack extension beforehand.
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
    public Builder setExecutor(ScheduledExecutorService executor) {
      this.executor = Optional.of(executor);
      return this;
    }

    /** Gives the ability to set a custom clock. */
    Builder setClock(Clock clock) {
      this.clock = Optional.of(clock);
      return this;
    }

    public Subscriber build() throws IOException {
      return new SubscriberImpl(this);
    }
  }
}

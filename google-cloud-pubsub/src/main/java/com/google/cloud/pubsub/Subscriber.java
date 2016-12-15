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

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.Clock;
import com.google.cloud.pubsub.Subscriber.MessageReceiver.AckReply;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Service;
import com.google.pubsub.v1.PubsubMessage;
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
 * subscriber. The delivered messages then can be {@link AckReply#ACK acked} or {@link
 * AckReply#NACK nacked} at will as they get processed by the receiver. Nacking a
 * messages implies a later redelivery of such message.
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
 * <p>If no credentials are provided, the {@link Publisher} will use application default
 * credentials through {@link GoogleCredentials#getApplicationDefault}.
 *
 * <p>For example, a {@link Subscriber} can be constructed and used to receive messages as follows:
 *
 * <pre>
 *  MessageReceiver receiver =
 *      message -> {
 *        // ... process message ...
 *        return Futures.immediateFuture(AckReply.ACK);
 *      });
 *
 *  Subscriber subscriber =
 *      Subscriber.Builder.newBuilder(MY_SUBSCRIPTION, receiver)
 *          .setMaxBundleAcks(100)
 *          .build();
 *
 *  subscriber.startAsync();
 *
 *  ... recommended, listen for fatal errors that break the subscriber streaming ...
 *  subscriber.addListener(
        new Listener() {
          @Override
          public void failed(State from, Throwable failure) {
            System.out.println("Subscriber faile with error: " + failure);
          }
        },
        Executors.newSingleThreadExecutor());
 *
 *  ... and when done with the subscriber ...
 *  subscriber.stopAsync();
 * </pre>
 */
public interface Subscriber extends Service {
  String PUBSUB_API_ADDRESS = "pubsub.googleapis.com";
  String PUBSUB_API_SCOPE = "https://www.googleapis.com/auth/pubsub";

  /** Retrieves a snapshot of the current subscriber statistics. */
  SubscriberStats getStats();

  /** Users of the {@link Subscriber} must implement this interface to receive messages. */
  interface MessageReceiver {
    public static enum AckReply {
      /**
       * To be used for acking a message.
       */
      ACK,
      /**
       * To be used for nacking a message.
       */
      NACK
    }

    /**
     * Called when a message is received by the subscriber.
     *
     * @return A future that signals when a message has been processed.
     */
    ListenableFuture<AckReply> receiveMessage(PubsubMessage message);
  }

  /** Subscription for which the subscriber is streaming messages. */
  String getSubscription();

  /**
   * Time before a message is to expire when the subscriber is going to attempt to renew its ack
   * deadline.
   */
  Duration getAckExpirationPadding();

  /**
   * Maximum number of outstanding (i.e. pending to process) messages before limits are enforced.
   *
   * <p><b>When limits are enforced, no more messages will be dispatched to the {@link
   * MessageReceiver} but due to the gRPC and HTTP/2 buffering and congestion control window
   * management, still some extra bytes could be kept at lower layers.
   */
  Optional<Integer> getMaxOutstandingMessages();

  /**
   * Maximum number of outstanding (i.e. pending to process) bytes before limits are enforced.
   */
  Optional<Integer> getMaxOutstandingBytes();

  /** Builder of {@link Subscriber Subscribers}. */
  final class Builder {
    private static final Duration MIN_ACK_EXPIRATION_PADDING = Duration.millis(100);
    private static final Duration DEFAULT_ACK_EXPIRATION_PADDING = Duration.millis(500);

    String subscription;
    Optional<Credentials> credentials;
    MessageReceiver receiver;

    Duration ackExpirationPadding;

    Optional<Integer> maxOutstandingMessages;
    Optional<Integer> maxOutstandingBytes;

    Optional<ScheduledExecutorService> executor;
    Optional<ManagedChannelBuilder<? extends ManagedChannelBuilder<?>>> channelBuilder;
    Optional<Clock> clock;

    /**
     * Constructs a new {@link Builder}.
     *
     * <p>Once {@link #build()} is called a gRPC stub will be created for use of the {@link
     * Publisher}.
     *
     * @param subscription Cloud Pub/Sub subscription to bind the subscriber to
     * @param receiver an implementation of {@link MessageReceiver} used to process the received
     *     messages
     */
    public static Builder newBuilder(String subscription, MessageReceiver receiver) {
      return new Builder(subscription, receiver);
    }

    Builder(String subscription, MessageReceiver receiver) {
      setDefaults();
      this.subscription = subscription;
      this.receiver = receiver;
    }

    private void setDefaults() {
      credentials = Optional.absent();
      channelBuilder = Optional.absent();
      ackExpirationPadding = DEFAULT_ACK_EXPIRATION_PADDING;
      maxOutstandingBytes = Optional.absent();
      maxOutstandingMessages = Optional.absent();
      executor = Optional.absent();
      clock = Optional.absent();
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

    /**
     * Sets the maximum number of outstanding messages; messages delivered to the {@link
     * MessageReceiver} that have not been acknowledged or rejected.
     *
     * @param maxOutstandingMessages must be greater than 0
     */
    public Builder setMaxOutstandingMessages(int maxOutstandingMessages) {
      Preconditions.checkArgument(
          maxOutstandingMessages > 0,
          "maxOutstandingMessages limit is disabled by default, but if set it must be set to a "
              + "value greater to 0.");
      this.maxOutstandingMessages = Optional.of(maxOutstandingMessages);
      return this;
    }

    /**
     * Sets the maximum number of outstanding bytes; bytes delivered to the {@link MessageReceiver}
     * that have not been acknowledged or rejected.
     *
     * @param maxOutstandingBytes must be greater than 0
     */
    public Builder setMaxOutstandingBytes(int maxOutstandingBytes) {
      Preconditions.checkArgument(
          maxOutstandingBytes > 0,
          "maxOutstandingBytes limit is disabled by default, but if set it must be set to a value "
              + "greater than 0.");
      this.maxOutstandingBytes = Optional.of(maxOutstandingBytes);
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

    /** Gives the ability to set a custom executor. */
    public Builder setClock(Clock clock) {
      this.clock = Optional.of(clock);
      return this;
    }

    public Subscriber build() throws IOException {
      return new SubscriberImpl(this);
    }
  }
}

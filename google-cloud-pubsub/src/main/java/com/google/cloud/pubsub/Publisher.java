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

import com.google.api.gax.grpc.BundlingSettings;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.pubsub.v1.PubsubMessage;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
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
 * <pre>
 *  Publisher publisher =
 *       Publisher.Builder.newBuilder(MY_TOPIC)
 *           .setMaxBundleDuration(new Duration(10 * 1000))
 *           .build();
 *  List<ListenableFuture<String>> results = new ArrayList<>();
 *
 *  for (PubsubMessage messages : messagesToPublish) {
 *    results.add(publisher.publish(message));
 *  }
 *
 *  Futures.addCallback(
 *  Futures.allAsList(results),
 *  new FutureCallback<List<String>>() {
 *    @Override
 *    public void onSuccess(List<String> messageIds) {
 *      // ... process the acknowledgement of publish ...
 *    }
 *    @Override
 *    public void onFailure(Throwable t) {
 *      // .. handle the failure ...
 *    }
 *  });
 *
 *  // Ensure all the outstanding messages have been published before shutting down your process.
 *  publisher.shutdown();
 * </pre>
 */
public interface Publisher {
  String PUBSUB_API_ADDRESS = "pubsub.googleapis.com";
  String PUBSUB_API_SCOPE = "https://www.googleapis.com/auth/pubsub";

  // API limits.
  int MAX_BUNDLE_MESSAGES = 1000;
  int MAX_BUNDLE_BYTES = 10 * 1000 * 1000; // 10 megabytes (https://en.wikipedia.org/wiki/Megabyte)

  // Meaningful defaults.
  int DEFAULT_MAX_BUNDLE_MESSAGES = 100;
  int DEFAULT_MAX_BUNDLE_BYTES = 1000; // 1 kB
  Duration DEFAULT_MAX_BUNDLE_DURATION = new Duration(1); // 1ms
  Duration DEFAULT_REQUEST_TIMEOUT = new Duration(10 * 1000); // 10 seconds
  Duration MIN_SEND_BUNDLE_DURATION = new Duration(10 * 1000); // 10 seconds
  Duration MIN_REQUEST_TIMEOUT = new Duration(10); // 10 milliseconds

  BundlingSettings DEFAULT_BUNDLING_SETTINGS =
      BundlingSettings.newBuilder()
          .setDelayThreshold(DEFAULT_MAX_BUNDLE_DURATION)
          .setRequestByteThreshold(DEFAULT_MAX_BUNDLE_BYTES)
          .setElementCountThreshold(DEFAULT_MAX_BUNDLE_MESSAGES)
          .build();

  /** Topic to which the publisher publishes to. */
  String getTopic();

  /**
   * Schedules the publishing of a message. The publishing of the message may occur immediately or
   * be delayed based on the publisher bundling options.
   *
   * <p>Depending on chosen flow control {@link #failOnFlowControlLimits option}, the returned
   * future might immediately fail with a {@link CloudPubsubFlowControlException} or block the
   * current thread until there are more resources available to publish.
   *
   * @param message the message to publish.
   * @return the message ID wrapped in a future.
   */
  ListenableFuture<String> publish(PubsubMessage message);

  /** Maximum amount of time to wait until scheduling the publishing of messages. */
  Duration getMaxBundleDuration();

  /** Maximum number of bytes to bundle before publishing. */
  long getMaxBundleBytes();

  /** Maximum number of messages to bundle before publishing. */
  long getMaxBundleMessages();

  /**
   * Maximum number of outstanding (i.e. pending to publish) messages before limits are enforced.
   * See {@link #failOnFlowControlLimits()}.
   */
  Optional<Integer> getMaxOutstandingMessages();

  /**
   * Maximum number of outstanding (i.e. pending to publish) bytes before limits are enforced. See
   * {@link #failOnFlowControlLimits()}.
   */
  Optional<Integer> getMaxOutstandingBytes();

  /**
   * Whether to block publish calls when reaching flow control limits (see {@link
   * #getMaxOutstandingBytes()} & {@link #getMaxOutstandingMessages()}).
   *
   * <p>If set to false, a publish call will fail with either {@link
   * MaxOutstandingBytesReachedException} or {@link MaxOutstandingMessagesReachedException}, as
   * appropriate, when flow control limits are reached.
   */
  boolean failOnFlowControlLimits();

  /** Retrieves a snapshot of the publisher current {@link PublisherStats statistics}. */
  PublisherStats getStats();

  /**
   * Schedules immediate publishing of any outstanding messages and waits until all are processed.
   *
   * <p>Sends remaining outstanding messages and prevents future calls to publish. This method
   * should be invoked prior to deleting the {@link Publisher} object in order to ensure that no
   * pending messages are lost.
   */
  void shutdown();

  /** A builder of {@link Publisher}s. */
  final class Builder {
    String topic;

    // Bundling options
    BundlingSettings bundlingSettings;

    // Client-side flow control options
    Optional<Integer> maxOutstandingMessages;
    Optional<Integer> maxOutstandingBytes;
    boolean failOnFlowControlLimits;

    // Send bundle deadline
    Duration sendBundleDeadline;

    // RPC options
    Duration requestTimeout;

    // Channels and credentials
    Optional<Credentials> userCredentials;
    Optional<ManagedChannelBuilder<? extends ManagedChannelBuilder<?>>> channelBuilder;

    Optional<ScheduledExecutorService> executor;

    /** Constructs a new {@link Builder} using the given topic. */
    public static Builder newBuilder(String topic) {
      return new Builder(topic);
    }

    Builder(String topic) {
      this.topic = Preconditions.checkNotNull(topic);
      setDefaults();
    }

    private void setDefaults() {
      userCredentials = Optional.absent();
      channelBuilder = Optional.absent();
      maxOutstandingMessages = Optional.absent();
      maxOutstandingBytes = Optional.absent();
      bundlingSettings = DEFAULT_BUNDLING_SETTINGS;
      requestTimeout = DEFAULT_REQUEST_TIMEOUT;
      sendBundleDeadline = MIN_SEND_BUNDLE_DURATION;
      failOnFlowControlLimits = false;
      executor = Optional.absent();
    }

    /**
     * Credentials to authenticate with.
     *
     * <p>Must be properly scoped for accessing Cloud Pub/Sub APIs.
     */
    public Builder setCredentials(Credentials userCredentials) {
      this.userCredentials = Optional.of(Preconditions.checkNotNull(userCredentials));
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

    // Bundling options
    public Builder setBundlingSettings(BundlingSettings bundlingSettings) {
      Preconditions.checkNotNull(bundlingSettings);
      Preconditions.checkNotNull(bundlingSettings.getElementCountThreshold());
      Preconditions.checkArgument(bundlingSettings.getElementCountThreshold() > 0);
      Preconditions.checkNotNull(bundlingSettings.getRequestByteThreshold());
      Preconditions.checkArgument(bundlingSettings.getRequestByteThreshold() > 0);
      Preconditions.checkNotNull(bundlingSettings.getDelayThreshold());
      Preconditions.checkArgument(bundlingSettings.getDelayThreshold().getMillis() > 0);

      Preconditions.checkArgument(
          bundlingSettings.getElementCountLimit() == null,
          "elementCountLimit option not honored by current implementation");
      Preconditions.checkArgument(
          bundlingSettings.getRequestByteLimit() == null,
          "requestByteLimit option not honored by current implementation");
      Preconditions.checkArgument(
          bundlingSettings.getBlockingCallCountThreshold() == null,
          "blockingCallCountThreshold option not honored by current implementation");

      this.bundlingSettings = bundlingSettings;
      return this;
    }

    // Flow control options

    /** Maximum number of outstanding messages to keep in memory before enforcing flow control. */
    public Builder setMaxOutstandingMessages(int messages) {
      Preconditions.checkArgument(messages > 0);
      maxOutstandingMessages = Optional.of(messages);
      return this;
    }

    /** Maximum number of outstanding messages to keep in memory before enforcing flow control. */
    public Builder setMaxOutstandingBytes(int bytes) {
      Preconditions.checkArgument(bytes > 0);
      maxOutstandingBytes = Optional.of(bytes);
      return this;
    }

    /**
     * Whether to fail publish when reaching any of the flow control limits, with either a {@link
     * MaxOutstandingBytesReachedException} or {@link MaxOutstandingMessagesReachedException} as
     * appropriate.
     *
     * <p>If set to false, then publish operations will block the current thread until the
     * outstanding requests go under the limits.
     */
    public Builder setFailOnFlowControlLimits(boolean fail) {
      failOnFlowControlLimits = fail;
      return this;
    }

    /** Maximum time to attempt sending (and retrying) a bundle of messages before giving up. */
    public Builder setSendBundleDeadline(Duration deadline) {
      Preconditions.checkArgument(deadline.compareTo(MIN_SEND_BUNDLE_DURATION) >= 0);
      sendBundleDeadline = deadline;
      return this;
    }

    // Runtime options
    /** Time to wait for a publish call to return from the server. */
    public Builder setRequestTimeout(Duration timeout) {
      Preconditions.checkArgument(timeout.compareTo(MIN_REQUEST_TIMEOUT) >= 0);
      requestTimeout = timeout;
      return this;
    }

    /** Gives the ability to set a custom executor to be used by the library. */
    public Builder setExecutor(ScheduledExecutorService executor) {
      this.executor = Optional.of(Preconditions.checkNotNull(executor));
      return this;
    }

    public Publisher build() throws IOException {
      return new PublisherImpl(this);
    }
  }

  /** Base exception that signals a flow control state. */
  abstract class CloudPubsubFlowControlException extends Exception {}

  /**
   * Returned as a future exception when client-side flow control is enforced based on the maximum
   * number of outstanding in-memory messages.
   */
  final class MaxOutstandingMessagesReachedException extends CloudPubsubFlowControlException {
    private final int currentMaxMessages;

    public MaxOutstandingMessagesReachedException(int currentMaxMessages) {
      this.currentMaxMessages = currentMaxMessages;
    }

    public int getCurrentMaxBundleMessages() {
      return currentMaxMessages;
    }

    @Override
    public String toString() {
      return String.format(
          "The maximum number of bundle messages: %d have been reached.", currentMaxMessages);
    }
  }

  /**
   * Returned as a future exception when client-side flow control is enforced based on the maximum
   * number of unacknowledged in-memory bytes.
   */
  final class MaxOutstandingBytesReachedException extends CloudPubsubFlowControlException {
    private final int currentMaxBytes;

    public MaxOutstandingBytesReachedException(int currentMaxBytes) {
      this.currentMaxBytes = currentMaxBytes;
    }

    public int getCurrentMaxBundleBytes() {
      return currentMaxBytes;
    }

    @Override
    public String toString() {
      return String.format(
          "The maximum number of bundle bytes: %d have been reached.", currentMaxBytes);
    }
  }
}

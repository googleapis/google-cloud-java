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

import com.google.api.gax.bundling.FlowController;
import com.google.api.gax.grpc.BundlingSettings;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auto.value.AutoValue;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.pubsub.v1.PubsubMessage;
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
  Optional<Integer> getMaxOutstandingElementCount();

  /**
   * Maximum number of outstanding (i.e. pending to publish) bytes before limits are enforced. See
   * {@link #failOnFlowControlLimits()}.
   */
  Optional<Integer> getMaxOutstandingRequestBytes();

  /**
   * Whether to block publish calls when reaching flow control limits (see {@link
   * #getMaxOutstandingRequestBytes()} & {@link #getMaxOutstandingElementCount()}).
   *
   * <p>If set to false, a publish call will fail with either {@link
   * RequestByteMaxOutstandingReachedException} or {@link
   * ElementCountMaxOutstandingReachedException}, as appropriate, when flow control limits are
   * reached.
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

  @AutoValue
  public abstract class Settings {
    static final String PUBSUB_API_ADDRESS = "pubsub.googleapis.com";
    static final String PUBSUB_API_SCOPE = "https://www.googleapis.com/auth/pubsub";

    // API limits.
    static final int MAX_BUNDLE_MESSAGES = 1000;
    static final int MAX_BUNDLE_BYTES =
        10 * 1000 * 1000; // 10 megabytes (https://en.wikipedia.org/wiki/Megabyte)

    // Meaningful defaults.
    static final long DEFAULT_MAX_BUNDLE_MESSAGES = 100L;
    static final long DEFAULT_MAX_BUNDLE_BYTES = 1000L; // 1 kB
    static final Duration DEFAULT_MAX_BUNDLE_DURATION = new Duration(1); // 1ms
    static final Duration DEFAULT_REQUEST_TIMEOUT = new Duration(10 * 1000); // 10 seconds
    static final Duration MIN_SEND_BUNDLE_DURATION = new Duration(10 * 1000); // 10 seconds
    static final Duration MIN_REQUEST_TIMEOUT = new Duration(10); // 10 milliseconds

    static final BundlingSettings DEFAULT_BUNDLING_SETTINGS =
        BundlingSettings.newBuilder()
            .setDelayThreshold(DEFAULT_MAX_BUNDLE_DURATION)
            .setRequestByteThreshold(DEFAULT_MAX_BUNDLE_BYTES)
            .setElementCountThreshold(DEFAULT_MAX_BUNDLE_MESSAGES)
            .build();

    public static Settings DEFAULT = newBuilder().build();

    public abstract BundlingSettings getBundlingSettings();

    public abstract FlowController.Settings getFlowControlSettings();

    public abstract boolean getFailOnFlowControlLimits();

    abstract Duration getSendBundleDeadline();

    abstract Duration getRequestTimeout();

    public static Builder newBuilder() {
      return new AutoValue_Publisher_Settings.Builder()
          .setFlowControlSettings(FlowController.Settings.DEFAULT)
          .setFailOnFlowControlLimits(false)
          .setSendBundleDeadline(MIN_SEND_BUNDLE_DURATION)
          .setRequestTimeout(DEFAULT_REQUEST_TIMEOUT)
          .setBundlingSettings(DEFAULT_BUNDLING_SETTINGS);
    }

    @AutoValue.Builder
    abstract static class Builder {
      public abstract Builder setBundlingSettings(BundlingSettings value);

      public abstract Builder setFlowControlSettings(FlowController.Settings value);

      public abstract Builder setFailOnFlowControlLimits(boolean value);

      abstract Builder setSendBundleDeadline(Duration value);

      abstract Builder setRequestTimeout(Duration value);

      abstract Settings autoBuild();

      public Settings build() {
        Settings settings = autoBuild();
        Preconditions.checkArgument(
            settings.getBundlingSettings().getElementCountLimit() == null,
            "elementCountLimit option not honored by current implementation");
        Preconditions.checkArgument(
            settings.getBundlingSettings().getRequestByteLimit() == null,
            "requestByteLimit option not honored by current implementation");
        Preconditions.checkArgument(
            settings.getBundlingSettings().getBlockingCallCountThreshold() == null,
            "blockingCallCountThreshold option not honored by current implementation");

        Preconditions.checkArgument(
            settings.getRequestTimeout().compareTo(MIN_REQUEST_TIMEOUT) >= 0);
        Preconditions.checkArgument(
            settings.getSendBundleDeadline().compareTo(MIN_SEND_BUNDLE_DURATION) >= 0);
        return settings;
      }
    }
  }
}

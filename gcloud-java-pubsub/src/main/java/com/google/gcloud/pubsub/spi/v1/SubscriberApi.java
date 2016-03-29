/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

/*
 * EDITING INSTRUCTIONS
 * This file was generated from the file
 * https://github.com/google/googleapis/blob/master/google/pubsub/v1/pubsub.proto
 * and updates to that file get reflected here through a refresh process.
 * For the short term, the refresh process will only be runnable by Google engineers.
 * Manual additions are allowed because the refresh process performs
 * a 3-way merge in order to preserve those manual additions. In order to not
 * break the refresh process, only certain types of modifications are
 * allowed.
 *
 * Allowed modifications - currently these are the only types allowed:
 * 1. New methods (these should be added to the end of the class)
 * 2. New imports
 * 3. Additional documentation between "manual edit" demarcations
 *
 * Happy editing!
 */

package com.google.gcloud.pubsub.spi.v1;

import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.Subscription;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Manually-added imports: add custom (non-generated) imports after this point.

// AUTO-GENERATED DOCUMENTATION AND SERVICE - see instructions at the top of the file for editing.
/**
 * Service Description: The service that an application uses to manipulate subscriptions and to
 * consume messages from a subscription via the `Pull` method.
 *
 * <!-- manual edit -->
 * <!-- end manual edit -->
 */
@javax.annotation.Generated("by GAPIC")
public class SubscriberApi implements AutoCloseable {
  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<Subscription, Subscription> createSubscriptionCallable;
  private final ApiCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable;
  private final ApiCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable;
  private final ApiCallable<ListSubscriptionsRequest, Iterable<Subscription>>
      listSubscriptionsIterableCallable;
  private final ApiCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable;
  private final ApiCallable<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineCallable;
  private final ApiCallable<AcknowledgeRequest, Empty> acknowledgeCallable;
  private final ApiCallable<PullRequest, PullResponse> pullCallable;
  private final ApiCallable<ModifyPushConfigRequest, Empty> modifyPushConfigCallable;

  /**
   * A PathTemplate representing the fully-qualified path to represent
   * a project resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  private static final PathTemplate PROJECT_PATH_TEMPLATE =
      PathTemplate.create("projects/{project}");

  /**
   * A PathTemplate representing the fully-qualified path to represent
   * a subscription resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  private static final PathTemplate SUBSCRIPTION_PATH_TEMPLATE =
      PathTemplate.create("projects/{project}/subscriptions/{subscription}");

  /**
   * Formats a string containing the fully-qualified path to represent
   * a project resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String formatProjectName(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate("project", project);
  }

  /**
   * Formats a string containing the fully-qualified path to represent
   * a subscription resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String formatSubscriptionName(String project, String subscription) {
    return SUBSCRIPTION_PATH_TEMPLATE.instantiate("project", project, "subscription", subscription);
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a project resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String parseProjectFromProjectName(String projectName) {
    return PROJECT_PATH_TEMPLATE.parse(projectName).get("project");
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a subscription resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String parseProjectFromSubscriptionName(String subscriptionName) {
    return SUBSCRIPTION_PATH_TEMPLATE.parse(subscriptionName).get("project");
  }

  /**
   * Parses the subscription from the given fully-qualified path which
   * represents a subscription resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String parseSubscriptionFromSubscriptionName(String subscriptionName) {
    return SUBSCRIPTION_PATH_TEMPLATE.parse(subscriptionName).get("subscription");
  }

  /**
   * Constructs an instance of SubscriberApi with default settings.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final SubscriberApi create() throws IOException {
    return create(SubscriberSettings.create());
  }

  /**
   * Constructs an instance of SubscriberApi, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final SubscriberApi create(SubscriberSettings settings) throws IOException {
    return new SubscriberApi(settings);
  }

  /**
   * Constructs an instance of SubscriberApi, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected SubscriberApi(SubscriberSettings settings) throws IOException {
    this.channel = settings.getChannel();

    this.createSubscriptionCallable = settings.createSubscriptionMethod().build(settings);
    this.getSubscriptionCallable = settings.getSubscriptionMethod().build(settings);
    this.listSubscriptionsCallable = settings.listSubscriptionsMethod().build(settings);
    this.listSubscriptionsIterableCallable =
        settings.listSubscriptionsMethod().buildPageStreaming(settings);
    this.deleteSubscriptionCallable = settings.deleteSubscriptionMethod().build(settings);
    this.modifyAckDeadlineCallable = settings.modifyAckDeadlineMethod().build(settings);
    this.acknowledgeCallable = settings.acknowledgeMethod().build(settings);
    this.pullCallable = settings.pullMethod().build(settings);
    this.modifyPushConfigCallable = settings.modifyPushConfigMethod().build(settings);

    if (settings.shouldAutoCloseChannel()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              channel.shutdown();
            }
          });
    }
  }

  // ----- createSubscription -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a subscription to a given topic for a given subscriber.
   * If the subscription already exists, generates `ALREADY_EXISTS`.
   * If the corresponding topic doesn't exist, generates `NOT_FOUND`.
   *
   * If the name is not provided in the request, the server will assign a random
   * name for this subscription on the same project as the topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param name The name of the subscription. It must have the format
   * `"projects/{project}/subscriptions/{subscription}"`. `{subscription}` must
   * start with a letter, and contain only letters (`[A-Za-z]`), numbers
   * (`[0-9]`), dashes (`-`), underscores (`_`), periods (`.`), tildes (`~`),
   * plus (`+`) or percent signs (`%`). It must be between 3 and 255 characters
   * in length, and it must not start with `"goog"`.
   * @param topic The name of the topic from which this subscription is receiving messages.
   * @param pushConfig If push delivery is used with this subscription, this field is
   * used to configure it. An empty `pushConfig` signifies that the subscriber
   * will pull and ack messages using API methods.
   * @param ackDeadlineSeconds This value is the maximum time after a subscriber receives a message
   * before the subscriber should acknowledge the message. After message
   * delivery but before the ack deadline expires and before the message is
   * acknowledged, it is an outstanding message and will not be delivered
   * again during that time (on a best-effort basis).
   *
   * For pull subscriptions, this value is used as the initial value for the ack
   * deadline. To override this value for a given message, call
   * `ModifyAckDeadline` with the corresponding `ack_id` if using
   * pull.
   *
   * For push delivery, this value is also used to set the request timeout for
   * the call to the push endpoint.
   *
   * If the subscriber never acknowledges the message, the Pub/Sub
   * system will eventually redeliver the message.
   *
   * If this parameter is not set, the default value of 10 seconds is used.
   */
  public final Subscription createSubscription(
      String name, String topic, PushConfig pushConfig, int ackDeadlineSeconds) {
    Subscription request =
        Subscription.newBuilder()
            .setName(name)
            .setTopic(topic)
            .setPushConfig(pushConfig)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();

    return createSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a subscription to a given topic for a given subscriber.
   * If the subscription already exists, generates `ALREADY_EXISTS`.
   * If the corresponding topic doesn't exist, generates `NOT_FOUND`.
   *
   * If the name is not provided in the request, the server will assign a random
   * name for this subscription on the same project as the topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Subscription createSubscription(Subscription request) {
    return createSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a subscription to a given topic for a given subscriber.
   * If the subscription already exists, generates `ALREADY_EXISTS`.
   * If the corresponding topic doesn't exist, generates `NOT_FOUND`.
   *
   * If the name is not provided in the request, the server will assign a random
   * name for this subscription on the same project as the topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<Subscription, Subscription> createSubscriptionCallable() {
    return createSubscriptionCallable;
  }

  // ----- getSubscription -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets the configuration details of a subscription.
   *
   * If the topic of a subscription has been deleted, the subscription itself is
   * not deleted, but the value of the `topic` field is set to `_deleted-topic_`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param subscription The name of the subscription to get.
   */
  public final Subscription getSubscription(String subscription) {
    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder().setSubscription(subscription).build();

    return getSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets the configuration details of a subscription.
   *
   * If the topic of a subscription has been deleted, the subscription itself is
   * not deleted, but the value of the `topic` field is set to `_deleted-topic_`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  private Subscription getSubscription(GetSubscriptionRequest request) {
    return getSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets the configuration details of a subscription.
   *
   * If the topic of a subscription has been deleted, the subscription itself is
   * not deleted, but the value of the `topic` field is set to `_deleted-topic_`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    return getSubscriptionCallable;
  }

  // ----- listSubscriptions -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching subscriptions.
   *
   * If the topic of a subscription has been deleted, the subscription itself is
   * not deleted, but the value of the `topic` field is set to `_deleted-topic_`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final Iterable<Subscription> listSubscriptions(String project) {
    ListSubscriptionsRequest request =
        ListSubscriptionsRequest.newBuilder().setProject(project).build();
    return listSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching subscriptions.
   *
   * If the topic of a subscription has been deleted, the subscription itself is
   * not deleted, but the value of the `topic` field is set to `_deleted-topic_`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public final Iterable<Subscription> listSubscriptions(ListSubscriptionsRequest request) {
    return listSubscriptionsIterableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching subscriptions.
   *
   * If the topic of a subscription has been deleted, the subscription itself is
   * not deleted, but the value of the `topic` field is set to `_deleted-topic_`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<ListSubscriptionsRequest, Iterable<Subscription>>
      listSubscriptionsIterableCallable() {
    return listSubscriptionsIterableCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching subscriptions.
   *
   * If the topic of a subscription has been deleted, the subscription itself is
   * not deleted, but the value of the `topic` field is set to `_deleted-topic_`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    return listSubscriptionsCallable;
  }

  // ----- deleteSubscription -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes an existing subscription. All pending messages in the subscription
   * are immediately dropped. Calls to `Pull` after deletion will generate
   * `NOT_FOUND`. After a subscription is deleted, a new one may be created with
   * the same name, but the new one has no association with the old
   * subscription, or its topic unless the same topic is specified.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param subscription The subscription to delete.
   */
  public final void deleteSubscription(String subscription) {
    DeleteSubscriptionRequest request =
        DeleteSubscriptionRequest.newBuilder().setSubscription(subscription).build();

    deleteSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes an existing subscription. All pending messages in the subscription
   * are immediately dropped. Calls to `Pull` after deletion will generate
   * `NOT_FOUND`. After a subscription is deleted, a new one may be created with
   * the same name, but the new one has no association with the old
   * subscription, or its topic unless the same topic is specified.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  private void deleteSubscription(DeleteSubscriptionRequest request) {
    deleteSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes an existing subscription. All pending messages in the subscription
   * are immediately dropped. Calls to `Pull` after deletion will generate
   * `NOT_FOUND`. After a subscription is deleted, a new one may be created with
   * the same name, but the new one has no association with the old
   * subscription, or its topic unless the same topic is specified.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable() {
    return deleteSubscriptionCallable;
  }

  // ----- modifyAckDeadline -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Modifies the ack deadline for a specific message. This method is useful
   * to indicate that more time is needed to process a message by the
   * subscriber, or to make the message available for redelivery if the
   * processing was interrupted.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param subscription The name of the subscription.
   * @param ackIds List of acknowledgment IDs.
   * @param ackDeadlineSeconds The new ack deadline with respect to the time this request was sent to
   * the Pub/Sub system. Must be >= 0. For example, if the value is 10, the new
   * ack deadline will expire 10 seconds after the `ModifyAckDeadline` call
   * was made. Specifying zero may immediately make the message available for
   * another pull request.
   */
  public final void modifyAckDeadline(
      String subscription, List<String> ackIds, int ackDeadlineSeconds) {
    ModifyAckDeadlineRequest request =
        ModifyAckDeadlineRequest.newBuilder()
            .setSubscription(subscription)
            .addAllAckIds(ackIds)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();

    modifyAckDeadline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Modifies the ack deadline for a specific message. This method is useful
   * to indicate that more time is needed to process a message by the
   * subscriber, or to make the message available for redelivery if the
   * processing was interrupted.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public void modifyAckDeadline(ModifyAckDeadlineRequest request) {
    modifyAckDeadlineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Modifies the ack deadline for a specific message. This method is useful
   * to indicate that more time is needed to process a message by the
   * subscriber, or to make the message available for redelivery if the
   * processing was interrupted.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineCallable() {
    return modifyAckDeadlineCallable;
  }

  // ----- acknowledge -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Acknowledges the messages associated with the `ack_ids` in the
   * `AcknowledgeRequest`. The Pub/Sub system can remove the relevant messages
   * from the subscription.
   *
   * Acknowledging a message whose ack deadline has expired may succeed,
   * but such a message may be redelivered later. Acknowledging a message more
   * than once will not result in an error.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param subscription The subscription whose message is being acknowledged.
   * @param ackIds The acknowledgment ID for the messages being acknowledged that was returned
   * by the Pub/Sub system in the `Pull` response. Must not be empty.
   */
  public final void acknowledge(String subscription, List<String> ackIds) {
    AcknowledgeRequest request =
        AcknowledgeRequest.newBuilder().setSubscription(subscription).addAllAckIds(ackIds).build();

    acknowledge(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Acknowledges the messages associated with the `ack_ids` in the
   * `AcknowledgeRequest`. The Pub/Sub system can remove the relevant messages
   * from the subscription.
   *
   * Acknowledging a message whose ack deadline has expired may succeed,
   * but such a message may be redelivered later. Acknowledging a message more
   * than once will not result in an error.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public void acknowledge(AcknowledgeRequest request) {
    acknowledgeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Acknowledges the messages associated with the `ack_ids` in the
   * `AcknowledgeRequest`. The Pub/Sub system can remove the relevant messages
   * from the subscription.
   *
   * Acknowledging a message whose ack deadline has expired may succeed,
   * but such a message may be redelivered later. Acknowledging a message more
   * than once will not result in an error.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<AcknowledgeRequest, Empty> acknowledgeCallable() {
    return acknowledgeCallable;
  }

  // ----- pull -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Pulls messages from the server. Returns an empty list if there are no
   * messages available in the backlog. The server may generate `UNAVAILABLE` if
   * there are too many concurrent pull requests pending for the given
   * subscription.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param subscription The subscription from which messages should be pulled.
   * @param returnImmediately If this is specified as true the system will respond immediately even if
   * it is not able to return a message in the `Pull` response. Otherwise the
   * system is allowed to wait until at least one message is available rather
   * than returning no messages.
   * @param maxMessages The maximum number of messages returned for this request. The Pub/Sub
   * system may return fewer than the number specified.
   */
  public final PullResponse pull(String subscription, boolean returnImmediately, int maxMessages) {
    PullRequest request =
        PullRequest.newBuilder()
            .setSubscription(subscription)
            .setReturnImmediately(returnImmediately)
            .setMaxMessages(maxMessages)
            .build();

    return pull(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Pulls messages from the server. Returns an empty list if there are no
   * messages available in the backlog. The server may generate `UNAVAILABLE` if
   * there are too many concurrent pull requests pending for the given
   * subscription.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public PullResponse pull(PullRequest request) {
    return pullCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Pulls messages from the server. Returns an empty list if there are no
   * messages available in the backlog. The server may generate `UNAVAILABLE` if
   * there are too many concurrent pull requests pending for the given
   * subscription.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<PullRequest, PullResponse> pullCallable() {
    return pullCallable;
  }

  // ----- modifyPushConfig -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Modifies the `PushConfig` for a specified subscription.
   *
   * This may be used to change a push subscription to a pull one (signified by
   * an empty `PushConfig`) or vice versa, or change the endpoint URL and other
   * attributes of a push subscription. Messages will accumulate for delivery
   * continuously through the call regardless of changes to the `PushConfig`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param subscription The name of the subscription.
   * @param pushConfig The push configuration for future deliveries.
   *
   * An empty `pushConfig` indicates that the Pub/Sub system should
   * stop pushing messages from the given subscription and allow
   * messages to be pulled and acknowledged - effectively pausing
   * the subscription if `Pull` is not called.
   */
  public final void modifyPushConfig(String subscription, PushConfig pushConfig) {
    ModifyPushConfigRequest request =
        ModifyPushConfigRequest.newBuilder()
            .setSubscription(subscription)
            .setPushConfig(pushConfig)
            .build();

    modifyPushConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Modifies the `PushConfig` for a specified subscription.
   *
   * This may be used to change a push subscription to a pull one (signified by
   * an empty `PushConfig`) or vice versa, or change the endpoint URL and other
   * attributes of a push subscription. Messages will accumulate for delivery
   * continuously through the call regardless of changes to the `PushConfig`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public void modifyPushConfig(ModifyPushConfigRequest request) {
    modifyPushConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Modifies the `PushConfig` for a specified subscription.
   *
   * This may be used to change a push subscription to a pull one (signified by
   * an empty `PushConfig`) or vice versa, or change the endpoint URL and other
   * attributes of a push subscription. Messages will accumulate for delivery
   * continuously through the call regardless of changes to the `PushConfig`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<ModifyPushConfigRequest, Empty> modifyPushConfigCallable() {
    return modifyPushConfigCallable;
  }

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  @Override
  public final void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }

  // ========
  // Manually-added methods: add custom (non-generated) methods after this point.
  // ========

}

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
 *
 * Happy editing!
 */
package com.google.gcloud.pubsub.spi;

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
import com.google.pubsub.v1.SubscriberGrpc;
import com.google.pubsub.v1.Subscription;

import io.gapi.gax.grpc.ApiCallable;
import io.gapi.gax.grpc.PageDescriptor;
import io.gapi.gax.grpc.ServiceApiSettings;
import io.gapi.gax.internal.ApiUtils;
import io.gapi.gax.protobuf.PathTemplate;
import io.grpc.ManagedChannel;

import java.io.IOException;
import java.util.List;

// Manually-added imports: add custom (non-generated) imports after this point.



// AUTO-GENERATED DOCUMENTATION AND SERVICE - see instructions at the top of the file for editing.
/**
 * The service that an application uses to manipulate subscriptions and to
 * consume messages from a subscription via the Pull method.
 */
@javax.annotation.Generated("by the veneer generator")
public class SubscriberApi implements AutoCloseable {

  // =========
  // Constants
  // =========

  /**
   * The default address of the service.
   */
  public static final String SERVICE_ADDRESS = "pubsub-experimental.googleapis.com";

  /**
   * The default port of the service.
   */
  public static final int DEFAULT_SERVICE_PORT = 443;


  private static final ApiCallable<Subscription, Subscription>
      CREATE_SUBSCRIPTION = ApiCallable.create(SubscriberGrpc.METHOD_CREATE_SUBSCRIPTION);
  private static final ApiCallable<GetSubscriptionRequest, Subscription>
      GET_SUBSCRIPTION = ApiCallable.create(SubscriberGrpc.METHOD_GET_SUBSCRIPTION);
  private static final ApiCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      LIST_SUBSCRIPTIONS = ApiCallable.create(SubscriberGrpc.METHOD_LIST_SUBSCRIPTIONS);
  private static final ApiCallable<DeleteSubscriptionRequest, Empty>
      DELETE_SUBSCRIPTION = ApiCallable.create(SubscriberGrpc.METHOD_DELETE_SUBSCRIPTION);
  private static final ApiCallable<ModifyAckDeadlineRequest, Empty>
      MODIFY_ACK_DEADLINE = ApiCallable.create(SubscriberGrpc.METHOD_MODIFY_ACK_DEADLINE);
  private static final ApiCallable<AcknowledgeRequest, Empty>
      ACKNOWLEDGE = ApiCallable.create(SubscriberGrpc.METHOD_ACKNOWLEDGE);
  private static final ApiCallable<PullRequest, PullResponse>
      PULL = ApiCallable.create(SubscriberGrpc.METHOD_PULL);
  private static final ApiCallable<ModifyPushConfigRequest, Empty>
      MODIFY_PUSH_CONFIG = ApiCallable.create(SubscriberGrpc.METHOD_MODIFY_PUSH_CONFIG);

  private static PageDescriptor<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> LIST_SUBSCRIPTIONS_PAGE_DESC =
      new PageDescriptor<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>() {
        @Override
        public Object emptyToken() {
          return "";
        }
        @Override
        public ListSubscriptionsRequest injectToken(
            ListSubscriptionsRequest payload, Object token) {
          return ListSubscriptionsRequest
            .newBuilder(payload)
            .setPageToken((String) token)
            .build();
        }
        @Override
        public Object extractNextToken(ListSubscriptionsResponse payload) {
          return payload.getNextPageToken();
        }
        @Override
        public Iterable<Subscription> extractResources(ListSubscriptionsResponse payload) {
          return payload.getSubscriptionsList();
        }
      };

  private static String ALL_SCOPES[] = {
    "https://www.googleapis.com/auth/pubsub"
  };

  /**
   * A PathTemplate representing the fully-qualified path to represent
   * a project resource.
   */
  private static final PathTemplate PROJECT_PATH_TEMPLATE =
      PathTemplate.create("/projects/{project}");

  /**
   * A PathTemplate representing the fully-qualified path to represent
   * a subscription resource.
   */
  private static final PathTemplate SUBSCRIPTION_PATH_TEMPLATE =
      PathTemplate.create("/projects/{project}/subscriptions/{subscription}");

  // ========
  // Members
  // ========

  private final ManagedChannel channel;
  private final ServiceApiSettings settings;

  // ===============
  // Factory Methods
  // ===============

  /**
   * Constructs an instance of SubscriberApi with default settings.
   */
  public static SubscriberApi create() throws IOException {
    return create(new ServiceApiSettings());
  }

  /**
   * Constructs an instance of SubscriberApi, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static SubscriberApi create(ServiceApiSettings settings) throws IOException {
    return new SubscriberApi(settings);
  }

  /**
   * Constructs an instance of SubscriberApi, using the given settings. This is protected so that it
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected SubscriberApi(ServiceApiSettings settings) throws IOException {
    ServiceApiSettings internalSettings = ApiUtils.settingsWithChannels(settings,
        SERVICE_ADDRESS, DEFAULT_SERVICE_PORT, ALL_SCOPES);
    this.settings = internalSettings;
    this.channel = internalSettings.getChannel();
  }

  // ==============================
  // Resource Name Helper Functions
  // ==============================

  /**
   * Creates a string containing the fully-qualified path to represent
   * a project resource.
   */
  public static final String createProjectPath(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate(
        "project", project);
  }

  /**
   * Creates a string containing the fully-qualified path to represent
   * a subscription resource.
   */
  public static final String createSubscriptionPath(String project, String subscription) {
    return SUBSCRIPTION_PATH_TEMPLATE.instantiate(
        "project", project,"subscription", subscription);
  }

  /**
   * Extracts the project from the given fully-qualified path which
   * represents a project resource.
   */
  public static final String extractProjectFromProjectPath(String projectPath) {
    return PROJECT_PATH_TEMPLATE.parse(projectPath).get("project");
  }

  /**
   * Extracts the project from the given fully-qualified path which
   * represents a subscription resource.
   */
  public static final String extractProjectFromSubscriptionPath(String subscriptionPath) {
    return SUBSCRIPTION_PATH_TEMPLATE.parse(subscriptionPath).get("project");
  }

  /**
   * Extracts the subscription from the given fully-qualified path which
   * represents a subscription resource.
   */
  public static final String extractSubscriptionFromSubscriptionPath(String subscriptionPath) {
    return SUBSCRIPTION_PATH_TEMPLATE.parse(subscriptionPath).get("subscription");
  }


  // =============
  // Service Calls
  // =============

  // ----- createSubscription -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a subscription to a given topic for a given subscriber.
   * If the subscription already exists, returns ALREADY_EXISTS.
   * If the corresponding topic doesn't exist, returns NOT_FOUND.
   *
   * If the name is not provided in the request, the server will assign a random
   * name for this subscription on the same project as the topic.
   *
   * @param name The name of the subscription. It must have the format
   * `"projects/{project}/subscriptions/{subscription}"`. `{subscription}` must
   * start with a letter, and contain only letters (`[A-Za-z]`), numbers
   * (`[0-9]`), dashes (`-`), underscores (`_`), periods (`.`), tildes (`~`),
   * plus (`+`) or percent signs (`%`). It must be between 3 and 255 characters
   * in length, and it must not start with `"goog"`.
   * @param topic The name of the topic from which this subscription is receiving messages.
   * The value of this field will be `_deleted-topic_` if the topic has been
   * deleted.
   * @param pushConfig If push delivery is used with this subscription, this field is
   * used to configure it. An empty pushConfig signifies that the subscriber
   * will pull and ack messages using API methods.
   * @param ackDeadlineSeconds This value is the maximum time after a subscriber receives a message
   * before the subscriber should acknowledge the message. After message
   * delivery but before the ack deadline expires and before the message is
   * acknowledged, it is an outstanding message and will not be delivered
   * again during that time (on a best-effort basis).
   *
   * For pull delivery this value is used as the initial value for the ack
   * deadline. To override this value for a given message, call
   * ModifyAckDeadline with the corresponding ack_id.
   *
   * For push delivery, this value is also used to set the request timeout for
   * the call to the push endpoint.
   *
   * If the subscriber never acknowledges the message, the Pub/Sub
   * system will eventually redeliver the message.
   *
   * If this parameter is not set, the default value of 10 seconds is used.
   */
  public Subscription createSubscription(String name, String topic, PushConfig pushConfig, int ackDeadlineSeconds) {
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
   * If the subscription already exists, returns ALREADY_EXISTS.
   * If the corresponding topic doesn't exist, returns NOT_FOUND.
   *
   * If the name is not provided in the request, the server will assign a random
   * name for this subscription on the same project as the topic.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Subscription createSubscription(Subscription request) {
    return createSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a subscription to a given topic for a given subscriber.
   * If the subscription already exists, returns ALREADY_EXISTS.
   * If the corresponding topic doesn't exist, returns NOT_FOUND.
   *
   * If the name is not provided in the request, the server will assign a random
   * name for this subscription on the same project as the topic.
   */
  public ApiCallable<Subscription, Subscription> createSubscriptionCallable() {
    return ApiUtils.prepareIdempotentCallable(CREATE_SUBSCRIPTION, settings).bind(channel);
  }

  // ----- getSubscription -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets the configuration details of a subscription.
   *
   * @param subscription The name of the subscription to get.
   */
  public Subscription getSubscription(String subscription) {
    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder()
        .setSubscription(subscription)
        .build();

    return getSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets the configuration details of a subscription.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Subscription getSubscription(GetSubscriptionRequest request) {
    return getSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets the configuration details of a subscription.
   */
  public ApiCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    return ApiUtils.prepareIdempotentCallable(GET_SUBSCRIPTION, settings).bind(channel);
  }

  // ----- listSubscriptions -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching subscriptions.
   */
  public Iterable<Subscription> listSubscriptions(String project) {
    ListSubscriptionsRequest request =
        ListSubscriptionsRequest.newBuilder()
        .setProject(project)
        .build();
    return listSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching subscriptions.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Iterable<Subscription> listSubscriptions(ListSubscriptionsRequest request) {
    return listSubscriptionsStreamingCallable()
        .iterableResponseStreamCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching subscriptions.
   */
  public ApiCallable<ListSubscriptionsRequest, Subscription> listSubscriptionsStreamingCallable() {
    return listSubscriptionsCallable().pageStreaming(LIST_SUBSCRIPTIONS_PAGE_DESC);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching subscriptions.
   */
  public ApiCallable<ListSubscriptionsRequest, ListSubscriptionsResponse> listSubscriptionsCallable() {
    return ApiUtils.prepareIdempotentCallable(LIST_SUBSCRIPTIONS, settings).bind(channel);
  }

  // ----- deleteSubscription -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes an existing subscription. All pending messages in the subscription
   * are immediately dropped. Calls to Pull after deletion will return
   * NOT_FOUND. After a subscription is deleted, a new one may be created with
   * the same name, but the new one has no association with the old
   * subscription, or its topic unless the same topic is specified.
   *
   * @param subscription The subscription to delete.
   */
  public void deleteSubscription(String subscription) {
    DeleteSubscriptionRequest request =
        DeleteSubscriptionRequest.newBuilder()
        .setSubscription(subscription)
        .build();

    deleteSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes an existing subscription. All pending messages in the subscription
   * are immediately dropped. Calls to Pull after deletion will return
   * NOT_FOUND. After a subscription is deleted, a new one may be created with
   * the same name, but the new one has no association with the old
   * subscription, or its topic unless the same topic is specified.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public void deleteSubscription(DeleteSubscriptionRequest request) {
    deleteSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes an existing subscription. All pending messages in the subscription
   * are immediately dropped. Calls to Pull after deletion will return
   * NOT_FOUND. After a subscription is deleted, a new one may be created with
   * the same name, but the new one has no association with the old
   * subscription, or its topic unless the same topic is specified.
   */
  public ApiCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable() {
    return ApiUtils.prepareIdempotentCallable(DELETE_SUBSCRIPTION, settings).bind(channel);
  }

  // ----- modifyAckDeadline -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Modifies the ack deadline for a specific message. This method is useful to
   * indicate that more time is needed to process a message by the subscriber,
   * or to make the message available for redelivery if the processing was
   * interrupted.
   *
   * @param subscription The name of the subscription.
   * @param ackIds List of acknowledgment IDs.
   * @param ackDeadlineSeconds The new ack deadline with respect to the time this request was sent to the
   * Pub/Sub system. Must be >= 0. For example, if the value is 10, the new ack
   * deadline will expire 10 seconds after the ModifyAckDeadline call was made.
   * Specifying zero may immediately make the message available for another pull
   * request.
   */
  public void modifyAckDeadline(String subscription, List<String> ackIds, int ackDeadlineSeconds) {
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
   * Modifies the ack deadline for a specific message. This method is useful to
   * indicate that more time is needed to process a message by the subscriber,
   * or to make the message available for redelivery if the processing was
   * interrupted.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public void modifyAckDeadline(ModifyAckDeadlineRequest request) {
    modifyAckDeadlineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Modifies the ack deadline for a specific message. This method is useful to
   * indicate that more time is needed to process a message by the subscriber,
   * or to make the message available for redelivery if the processing was
   * interrupted.
   */
  public ApiCallable<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineCallable() {
    return MODIFY_ACK_DEADLINE.bind(channel);
  }

  // ----- acknowledge -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Acknowledges the messages associated with the ack tokens in the
   * AcknowledgeRequest. The Pub/Sub system can remove the relevant messages
   * from the subscription.
   *
   * Acknowledging a message whose ack deadline has expired may succeed,
   * but such a message may be redelivered later. Acknowledging a message more
   * than once will not result in an error.
   *
   * @param subscription The subscription whose message is being acknowledged.
   * @param ackIds The acknowledgment ID for the messages being acknowledged that was returned
   * by the Pub/Sub system in the Pull response. Must not be empty.
   */
  public void acknowledge(String subscription, List<String> ackIds) {
    AcknowledgeRequest request =
        AcknowledgeRequest.newBuilder()
        .setSubscription(subscription)
        .addAllAckIds(ackIds)
        .build();

    acknowledge(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Acknowledges the messages associated with the ack tokens in the
   * AcknowledgeRequest. The Pub/Sub system can remove the relevant messages
   * from the subscription.
   *
   * Acknowledging a message whose ack deadline has expired may succeed,
   * but such a message may be redelivered later. Acknowledging a message more
   * than once will not result in an error.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public void acknowledge(AcknowledgeRequest request) {
    acknowledgeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Acknowledges the messages associated with the ack tokens in the
   * AcknowledgeRequest. The Pub/Sub system can remove the relevant messages
   * from the subscription.
   *
   * Acknowledging a message whose ack deadline has expired may succeed,
   * but such a message may be redelivered later. Acknowledging a message more
   * than once will not result in an error.
   */
  public ApiCallable<AcknowledgeRequest, Empty> acknowledgeCallable() {
    return ACKNOWLEDGE.bind(channel);
  }

  // ----- pull -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Pulls messages from the server. Returns an empty list if there are no
   * messages available in the backlog. The server may return UNAVAILABLE if
   * there are too many concurrent pull requests pending for the given
   * subscription.
   *
   * @param subscription The subscription from which messages should be pulled.
   * @param returnImmediately If this is specified as true the system will respond immediately even if
   * it is not able to return a message in the Pull response. Otherwise the
   * system is allowed to wait until at least one message is available rather
   * than returning no messages. The client may cancel the request if it does
   * not wish to wait any longer for the response.
   * @param maxMessages The maximum number of messages returned for this request. The Pub/Sub
   * system may return fewer than the number specified.
   */
  public PullResponse pull(String subscription, boolean returnImmediately, int maxMessages) {
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
   * messages available in the backlog. The server may return UNAVAILABLE if
   * there are too many concurrent pull requests pending for the given
   * subscription.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public PullResponse pull(PullRequest request) {
    return pullCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Pulls messages from the server. Returns an empty list if there are no
   * messages available in the backlog. The server may return UNAVAILABLE if
   * there are too many concurrent pull requests pending for the given
   * subscription.
   */
  public ApiCallable<PullRequest, PullResponse> pullCallable() {
    return PULL.bind(channel);
  }

  // ----- modifyPushConfig -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Modifies the PushConfig for a specified subscription.
   *
   * This may be used to change a push subscription to a pull one (signified
   * by an empty PushConfig) or vice versa, or change the endpoint URL and other
   * attributes of a push subscription. Messages will accumulate for
   * delivery continuously through the call regardless of changes to the
   * PushConfig.
   *
   * @param subscription The name of the subscription.
   * @param pushConfig The push configuration for future deliveries.
   *
   * An empty pushConfig indicates that the Pub/Sub system should
   * stop pushing messages from the given subscription and allow
   * messages to be pulled and acknowledged - effectively pausing
   * the subscription if Pull is not called.
   */
  public void modifyPushConfig(String subscription, PushConfig pushConfig) {
    ModifyPushConfigRequest request =
        ModifyPushConfigRequest.newBuilder()
        .setSubscription(subscription)
        .setPushConfig(pushConfig)
        .build();

    modifyPushConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Modifies the PushConfig for a specified subscription.
   *
   * This may be used to change a push subscription to a pull one (signified
   * by an empty PushConfig) or vice versa, or change the endpoint URL and other
   * attributes of a push subscription. Messages will accumulate for
   * delivery continuously through the call regardless of changes to the
   * PushConfig.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public void modifyPushConfig(ModifyPushConfigRequest request) {
    modifyPushConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Modifies the PushConfig for a specified subscription.
   *
   * This may be used to change a push subscription to a pull one (signified
   * by an empty PushConfig) or vice versa, or change the endpoint URL and other
   * attributes of a push subscription. Messages will accumulate for
   * delivery continuously through the call regardless of changes to the
   * PushConfig.
   */
  public ApiCallable<ModifyPushConfigRequest, Empty> modifyPushConfigCallable() {
    return MODIFY_PUSH_CONFIG.bind(channel);
  }


  // ========
  // Cleanup
  // ========

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   */
  @Override
  public void close() {
    // Manually-added shutdown code

    // Auto-generated shutdown code
    channel.shutdown();

    // Manually-added shutdown code
  }


  // ========
  // Manually-added methods: add custom (non-generated) methods after this point.
  // ========

}

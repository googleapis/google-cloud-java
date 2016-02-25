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
package com.google.gcloud.pubsub.spi;

import com.google.api.gax.core.BackoffParams;
import com.google.api.gax.core.ConnectionSettings;
import com.google.api.gax.core.RetryParams;
import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.grpc.PageDescriptor;
import com.google.api.gax.grpc.ServiceApiSettings;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
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
import io.grpc.ManagedChannel;
import io.grpc.Status;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Manually-added imports: add custom (non-generated) imports after this point.

// AUTO-GENERATED DOCUMENTATION AND SERVICE - see instructions at the top of the file for editing.
/**
 * The service that an application uses to manipulate subscriptions and to
 * consume messages from a subscription via the `Pull` method.
 *
 * <!-- manual edit -->
 * <!-- end manual edit -->
 */
@javax.annotation.Generated("by the veneer generator")
public class SubscriberApi implements AutoCloseable {

  public enum MethodIdentifier {
    CREATE_SUBSCRIPTION,
    GET_SUBSCRIPTION,
    LIST_SUBSCRIPTIONS,
    DELETE_SUBSCRIPTION,
    MODIFY_ACK_DEADLINE,
    ACKNOWLEDGE,
    PULL,
    MODIFY_PUSH_CONFIG
  }

  // =========
  // Constants
  // =========

  /**
   * The default address of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String DEFAULT_SERVICE_ADDRESS = "pubsub-experimental.googleapis.com";

  /**
   * The default port of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final int DEFAULT_SERVICE_PORT = 443;

  /**
   * The default scopes of the service.
   */
  public static ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/pubsub")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  /**
   * The default settings for the service.
   */
  public static ServiceApiSettings<MethodIdentifier> DEFAULT_SETTINGS =
      ServiceApiSettings.<MethodIdentifier>builder()
          .provideChannelWith(
              ConnectionSettings.builder()
                  .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
                  .setPort(DEFAULT_SERVICE_PORT)
                  .provideCredentialsWith(DEFAULT_SERVICE_SCOPES)
                  .build())
          .build();

  private static final ImmutableMap<MethodIdentifier, ImmutableSet<Status.Code>>
      DEFAULT_RETRY_CONFIG;

  static {
    Map<String, ImmutableSet<Status.Code>> definition = new HashMap<>();
    definition.put(
        "idempotent",
        Sets.immutableEnumSet(
            Lists.<Status.Code>newArrayList(
                Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
    definition.put("non_idempotent", Sets.immutableEnumSet(Lists.<Status.Code>newArrayList()));

    Map<MethodIdentifier, ImmutableSet<Status.Code>> retryableCodes =
        new EnumMap<>(MethodIdentifier.class);
    retryableCodes.put(MethodIdentifier.CREATE_SUBSCRIPTION, definition.get("non_idempotent"));
    retryableCodes.put(MethodIdentifier.GET_SUBSCRIPTION, definition.get("idempotent"));
    retryableCodes.put(MethodIdentifier.LIST_SUBSCRIPTIONS, definition.get("idempotent"));
    retryableCodes.put(MethodIdentifier.DELETE_SUBSCRIPTION, definition.get("idempotent"));
    retryableCodes.put(MethodIdentifier.MODIFY_ACK_DEADLINE, definition.get("non_idempotent"));
    retryableCodes.put(MethodIdentifier.ACKNOWLEDGE, definition.get("non_idempotent"));
    retryableCodes.put(MethodIdentifier.PULL, definition.get("non_idempotent"));
    retryableCodes.put(MethodIdentifier.MODIFY_PUSH_CONFIG, definition.get("non_idempotent"));
    DEFAULT_RETRY_CONFIG =
        Maps.<MethodIdentifier, ImmutableSet<Status.Code>>immutableEnumMap(retryableCodes);
  }

  private static final ImmutableMap<MethodIdentifier, RetryParams> DEFAULT_RETRY_PARAMS;

  static {
    Map<String, RetryParams> definition = new HashMap<>();
    RetryParams params = null;
    params =
        RetryParams.newBuilder()
            .setRetryBackoff(
                BackoffParams.newBuilder()
                    .setInitialDelayMillis(100L)
                    .setDelayMultiplier(1.2)
                    .setMaxDelayMillis(1000L)
                    .build())
            .setTimeoutBackoff(
                BackoffParams.newBuilder()
                    .setInitialDelayMillis(300L)
                    .setDelayMultiplier(1.3)
                    .setMaxDelayMillis(3000L)
                    .build())
            .setTotalTimeout(30000L)
            .build();
    definition.put("default", params);

    Map<MethodIdentifier, RetryParams> retryParams = new EnumMap<>(MethodIdentifier.class);
    retryParams.put(MethodIdentifier.CREATE_SUBSCRIPTION, definition.get("default"));
    retryParams.put(MethodIdentifier.GET_SUBSCRIPTION, definition.get("default"));
    retryParams.put(MethodIdentifier.LIST_SUBSCRIPTIONS, definition.get("default"));
    retryParams.put(MethodIdentifier.DELETE_SUBSCRIPTION, definition.get("default"));
    retryParams.put(MethodIdentifier.MODIFY_ACK_DEADLINE, definition.get("default"));
    retryParams.put(MethodIdentifier.ACKNOWLEDGE, definition.get("default"));
    retryParams.put(MethodIdentifier.PULL, definition.get("default"));
    retryParams.put(MethodIdentifier.MODIFY_PUSH_CONFIG, definition.get("default"));
    DEFAULT_RETRY_PARAMS = Maps.<MethodIdentifier, RetryParams>immutableEnumMap(retryParams);
  }

  private static final ApiCallable<Subscription, Subscription> CREATE_SUBSCRIPTION =
      ApiCallable.create(SubscriberGrpc.METHOD_CREATE_SUBSCRIPTION);
  private static final ApiCallable<GetSubscriptionRequest, Subscription> GET_SUBSCRIPTION =
      ApiCallable.create(SubscriberGrpc.METHOD_GET_SUBSCRIPTION);
  private static final ApiCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      LIST_SUBSCRIPTIONS = ApiCallable.create(SubscriberGrpc.METHOD_LIST_SUBSCRIPTIONS);
  private static final ApiCallable<DeleteSubscriptionRequest, Empty> DELETE_SUBSCRIPTION =
      ApiCallable.create(SubscriberGrpc.METHOD_DELETE_SUBSCRIPTION);
  private static final ApiCallable<ModifyAckDeadlineRequest, Empty> MODIFY_ACK_DEADLINE =
      ApiCallable.create(SubscriberGrpc.METHOD_MODIFY_ACK_DEADLINE);
  private static final ApiCallable<AcknowledgeRequest, Empty> ACKNOWLEDGE =
      ApiCallable.create(SubscriberGrpc.METHOD_ACKNOWLEDGE);
  private static final ApiCallable<PullRequest, PullResponse> PULL =
      ApiCallable.create(SubscriberGrpc.METHOD_PULL);
  private static final ApiCallable<ModifyPushConfigRequest, Empty> MODIFY_PUSH_CONFIG =
      ApiCallable.create(SubscriberGrpc.METHOD_MODIFY_PUSH_CONFIG);

  private static PageDescriptor<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
      LIST_SUBSCRIPTIONS_PAGE_DESC =
          new PageDescriptor<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListSubscriptionsRequest injectToken(
                ListSubscriptionsRequest payload, Object token) {
              return ListSubscriptionsRequest.newBuilder(payload)
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

  // ========
  // Members
  // ========

  private final ManagedChannel channel;
  private final ServiceApiSettings<MethodIdentifier> settings;
  private final ImmutableMap<MethodIdentifier, ImmutableSet<Status.Code>> retryCodesConfig;
  private final ImmutableMap<MethodIdentifier, RetryParams> retryParamsConfig;

  // ===============
  // Factory Methods
  // ===============

  /**
   * Constructs an instance of SubscriberApi with default settings.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static SubscriberApi create() throws IOException {
    return create(DEFAULT_SETTINGS);
  }

  /**
   * Constructs an instance of SubscriberApi, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static SubscriberApi create(ServiceApiSettings<MethodIdentifier> settings)
      throws IOException {
    return new SubscriberApi(settings);
  }

  /**
   * Constructs an instance of SubscriberApi, using the given settings. This is protected so that it
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected SubscriberApi(ServiceApiSettings<MethodIdentifier> settings) throws IOException {
    this.settings = settings;
    this.channel = settings.getChannel();

    Map<MethodIdentifier, ImmutableSet<Status.Code>> retryCodesConfig =
        new EnumMap<>(DEFAULT_RETRY_CONFIG);
    retryCodesConfig.putAll(settings.getRetryableCodes());
    this.retryCodesConfig =
        Maps.<MethodIdentifier, ImmutableSet<Status.Code>>immutableEnumMap(retryCodesConfig);

    Map<MethodIdentifier, RetryParams> retryParamsConfig = new EnumMap<>(DEFAULT_RETRY_PARAMS);
    retryParamsConfig.putAll(settings.getRetryParams());
    this.retryParamsConfig =
        Maps.<MethodIdentifier, RetryParams>immutableEnumMap(retryParamsConfig);
  }

  // ==============================
  // Resource Name Helper Functions
  // ==============================

  /**
   * Creates a string containing the fully-qualified path to represent
   * a project resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String createProjectPath(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate("project", project);
  }

  /**
   * Creates a string containing the fully-qualified path to represent
   * a subscription resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String createSubscriptionPath(String project, String subscription) {
    return SUBSCRIPTION_PATH_TEMPLATE.instantiate("project", project, "subscription", subscription);
  }

  /**
   * Extracts the project from the given fully-qualified path which
   * represents a project resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String extractProjectFromProjectPath(String projectPath) {
    return PROJECT_PATH_TEMPLATE.parse(projectPath).get("project");
  }

  /**
   * Extracts the project from the given fully-qualified path which
   * represents a subscription resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String extractProjectFromSubscriptionPath(String subscriptionPath) {
    return SUBSCRIPTION_PATH_TEMPLATE.parse(subscriptionPath).get("project");
  }

  /**
   * Extracts the subscription from the given fully-qualified path which
   * represents a subscription resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
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
  public Subscription createSubscription(
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
  public ApiCallable<Subscription, Subscription> createSubscriptionCallable() {
    ImmutableSet<Status.Code> retryableCodes =
        retryCodesConfig.get(MethodIdentifier.CREATE_SUBSCRIPTION);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.CREATE_SUBSCRIPTION);
    return CREATE_SUBSCRIPTION
        .retryableOn(retryableCodes)
        .retrying(retryParams, settings.getExecutor())
        .bind(channel);
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
  public Subscription getSubscription(String subscription) {
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
  public Subscription getSubscription(GetSubscriptionRequest request) {
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
  public ApiCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    ImmutableSet<Status.Code> retryableCodes =
        retryCodesConfig.get(MethodIdentifier.GET_SUBSCRIPTION);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.GET_SUBSCRIPTION);
    return GET_SUBSCRIPTION
        .retryableOn(retryableCodes)
        .retrying(retryParams, settings.getExecutor())
        .bind(channel);
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
  public Iterable<Subscription> listSubscriptions(String project) {
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
  public Iterable<Subscription> listSubscriptions(ListSubscriptionsRequest request) {
    return listSubscriptionsStreamingCallable().call(request);
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
  public ApiCallable<ListSubscriptionsRequest, Iterable<Subscription>>
      listSubscriptionsStreamingCallable() {
    return listSubscriptionsCallable().pageStreaming(LIST_SUBSCRIPTIONS_PAGE_DESC);
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
  public ApiCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    ImmutableSet<Status.Code> retryableCodes =
        retryCodesConfig.get(MethodIdentifier.LIST_SUBSCRIPTIONS);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.LIST_SUBSCRIPTIONS);
    return LIST_SUBSCRIPTIONS
        .retryableOn(retryableCodes)
        .retrying(retryParams, settings.getExecutor())
        .bind(channel);
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
  public void deleteSubscription(String subscription) {
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
  public void deleteSubscription(DeleteSubscriptionRequest request) {
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
  public ApiCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable() {
    ImmutableSet<Status.Code> retryableCodes =
        retryCodesConfig.get(MethodIdentifier.DELETE_SUBSCRIPTION);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.DELETE_SUBSCRIPTION);
    return DELETE_SUBSCRIPTION
        .retryableOn(retryableCodes)
        .retrying(retryParams, settings.getExecutor())
        .bind(channel);
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
  public ApiCallable<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineCallable() {
    ImmutableSet<Status.Code> retryableCodes =
        retryCodesConfig.get(MethodIdentifier.MODIFY_ACK_DEADLINE);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.MODIFY_ACK_DEADLINE);
    return MODIFY_ACK_DEADLINE
        .retryableOn(retryableCodes)
        .retrying(retryParams, settings.getExecutor())
        .bind(channel);
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
  public void acknowledge(String subscription, List<String> ackIds) {
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
  public ApiCallable<AcknowledgeRequest, Empty> acknowledgeCallable() {
    ImmutableSet<Status.Code> retryableCodes = retryCodesConfig.get(MethodIdentifier.ACKNOWLEDGE);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.ACKNOWLEDGE);
    return ACKNOWLEDGE
        .retryableOn(retryableCodes)
        .retrying(retryParams, settings.getExecutor())
        .bind(channel);
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
  public ApiCallable<PullRequest, PullResponse> pullCallable() {
    ImmutableSet<Status.Code> retryableCodes = retryCodesConfig.get(MethodIdentifier.PULL);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.PULL);
    return PULL.retryableOn(retryableCodes)
        .retrying(retryParams, settings.getExecutor())
        .bind(channel);
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
  public ApiCallable<ModifyPushConfigRequest, Empty> modifyPushConfigCallable() {
    ImmutableSet<Status.Code> retryableCodes =
        retryCodesConfig.get(MethodIdentifier.MODIFY_PUSH_CONFIG);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.MODIFY_PUSH_CONFIG);
    return MODIFY_PUSH_CONFIG
        .retryableOn(retryableCodes)
        .retrying(retryParams, settings.getExecutor())
        .bind(channel);
  }

  // ========
  // Cleanup
  // ========

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
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

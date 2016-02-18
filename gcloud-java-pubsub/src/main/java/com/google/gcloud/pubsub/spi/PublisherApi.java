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
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PublisherGrpc;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.Topic;
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
 * The service that an application uses to manipulate topics, and to send
 * messages to a topic.
 *
 * <!-- manual edit -->
 * <!-- end manual edit -->
 */
@javax.annotation.Generated("by the veneer generator")
public class PublisherApi implements AutoCloseable {

  public enum MethodIdentifier {
    CREATE_TOPIC,
    PUBLISH,
    GET_TOPIC,
    LIST_TOPICS,
    LIST_TOPIC_SUBSCRIPTIONS,
    DELETE_TOPIC
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
    retryableCodes.put(MethodIdentifier.CREATE_TOPIC, definition.get("idempotent"));
    retryableCodes.put(MethodIdentifier.PUBLISH, definition.get("non_idempotent"));
    retryableCodes.put(MethodIdentifier.GET_TOPIC, definition.get("idempotent"));
    retryableCodes.put(MethodIdentifier.LIST_TOPICS, definition.get("idempotent"));
    retryableCodes.put(MethodIdentifier.LIST_TOPIC_SUBSCRIPTIONS, definition.get("idempotent"));
    retryableCodes.put(MethodIdentifier.DELETE_TOPIC, definition.get("idempotent"));
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
    retryParams.put(MethodIdentifier.CREATE_TOPIC, definition.get("default"));
    retryParams.put(MethodIdentifier.PUBLISH, definition.get("default"));
    retryParams.put(MethodIdentifier.GET_TOPIC, definition.get("default"));
    retryParams.put(MethodIdentifier.LIST_TOPICS, definition.get("default"));
    retryParams.put(MethodIdentifier.LIST_TOPIC_SUBSCRIPTIONS, definition.get("default"));
    retryParams.put(MethodIdentifier.DELETE_TOPIC, definition.get("default"));
    DEFAULT_RETRY_PARAMS = Maps.<MethodIdentifier, RetryParams>immutableEnumMap(retryParams);
  }

  private static final ApiCallable<Topic, Topic> CREATE_TOPIC =
      ApiCallable.create(PublisherGrpc.METHOD_CREATE_TOPIC);
  private static final ApiCallable<PublishRequest, PublishResponse> PUBLISH =
      ApiCallable.create(PublisherGrpc.METHOD_PUBLISH);
  private static final ApiCallable<GetTopicRequest, Topic> GET_TOPIC =
      ApiCallable.create(PublisherGrpc.METHOD_GET_TOPIC);
  private static final ApiCallable<ListTopicsRequest, ListTopicsResponse> LIST_TOPICS =
      ApiCallable.create(PublisherGrpc.METHOD_LIST_TOPICS);
  private static final ApiCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      LIST_TOPIC_SUBSCRIPTIONS = ApiCallable.create(PublisherGrpc.METHOD_LIST_TOPIC_SUBSCRIPTIONS);
  private static final ApiCallable<DeleteTopicRequest, Empty> DELETE_TOPIC =
      ApiCallable.create(PublisherGrpc.METHOD_DELETE_TOPIC);

  private static PageDescriptor<ListTopicsRequest, ListTopicsResponse, Topic>
      LIST_TOPICS_PAGE_DESC =
          new PageDescriptor<ListTopicsRequest, ListTopicsResponse, Topic>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListTopicsRequest injectToken(ListTopicsRequest payload, Object token) {
              return ListTopicsRequest.newBuilder(payload).setPageToken((String) token).build();
            }

            @Override
            public Object extractNextToken(ListTopicsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Topic> extractResources(ListTopicsResponse payload) {
              return payload.getTopicsList();
            }
          };

  private static PageDescriptor<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
      LIST_TOPIC_SUBSCRIPTIONS_PAGE_DESC =
          new PageDescriptor<
              ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListTopicSubscriptionsRequest injectToken(
                ListTopicSubscriptionsRequest payload, Object token) {
              return ListTopicSubscriptionsRequest.newBuilder(payload)
                  .setPageToken((String) token)
                  .build();
            }

            @Override
            public Object extractNextToken(ListTopicSubscriptionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(ListTopicSubscriptionsResponse payload) {
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
   * a topic resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  private static final PathTemplate TOPIC_PATH_TEMPLATE =
      PathTemplate.create("projects/{project}/topics/{topic}");

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
   * Constructs an instance of PublisherApi with default settings.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static PublisherApi create() throws IOException {
    return create(DEFAULT_SETTINGS);
  }

  /**
   * Constructs an instance of PublisherApi, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static PublisherApi create(ServiceApiSettings<MethodIdentifier> settings)
      throws IOException {
    return new PublisherApi(settings);
  }

  /**
   * Constructs an instance of PublisherApi, using the given settings. This is protected so that it
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected PublisherApi(ServiceApiSettings<MethodIdentifier> settings) throws IOException {
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
   * a topic resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String createTopicPath(String project, String topic) {
    return TOPIC_PATH_TEMPLATE.instantiate("project", project, "topic", topic);
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
   * represents a topic resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String extractProjectFromTopicPath(String topicPath) {
    return TOPIC_PATH_TEMPLATE.parse(topicPath).get("project");
  }

  /**
   * Extracts the topic from the given fully-qualified path which
   * represents a topic resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String extractTopicFromTopicPath(String topicPath) {
    return TOPIC_PATH_TEMPLATE.parse(topicPath).get("topic");
  }

  // =============
  // Service Calls
  // =============

  // ----- createTopic -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates the given topic with the given name.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param name The name of the topic. It must have the format
   * `"projects/{project}/topics/{topic}"`. `{topic}` must start with a letter,
   * and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`),
   * underscores (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent
   * signs (`%`). It must be between 3 and 255 characters in length, and it
   * must not start with `"goog"`.
   */
  public Topic createTopic(String name) {
    Topic request = Topic.newBuilder().setName(name).build();

    return createTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates the given topic with the given name.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Topic createTopic(Topic request) {
    return createTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates the given topic with the given name.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<Topic, Topic> createTopicCallable() {
    ImmutableSet<Status.Code> retryableCodes = retryCodesConfig.get(MethodIdentifier.CREATE_TOPIC);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.CREATE_TOPIC);
    return CREATE_TOPIC
        .retryableOn(retryableCodes)
        .retrying(retryParams, settings.getExecutor())
        .bind(channel);
  }

  // ----- publish -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
   * does not exist. The message payload must not be empty; it must contain
   *  either a non-empty data field, or at least one attribute.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param topic The messages in the request will be published on this topic.
   * @param messages The messages to publish.
   */
  public PublishResponse publish(String topic, List<PubsubMessage> messages) {
    PublishRequest request =
        PublishRequest.newBuilder().setTopic(topic).addAllMessages(messages).build();

    return publish(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
   * does not exist. The message payload must not be empty; it must contain
   *  either a non-empty data field, or at least one attribute.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public PublishResponse publish(PublishRequest request) {
    return publishCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
   * does not exist. The message payload must not be empty; it must contain
   *  either a non-empty data field, or at least one attribute.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<PublishRequest, PublishResponse> publishCallable() {
    ImmutableSet<Status.Code> retryableCodes = retryCodesConfig.get(MethodIdentifier.PUBLISH);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.PUBLISH);
    return PUBLISH
        .retryableOn(retryableCodes)
        .retrying(retryParams, settings.getExecutor())
        .bind(channel);
  }

  // ----- getTopic -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets the configuration of a topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param topic The name of the topic to get.
   */
  public Topic getTopic(String topic) {
    GetTopicRequest request = GetTopicRequest.newBuilder().setTopic(topic).build();

    return getTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets the configuration of a topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Topic getTopic(GetTopicRequest request) {
    return getTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets the configuration of a topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<GetTopicRequest, Topic> getTopicCallable() {
    ImmutableSet<Status.Code> retryableCodes = retryCodesConfig.get(MethodIdentifier.GET_TOPIC);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.GET_TOPIC);
    return GET_TOPIC
        .retryableOn(retryableCodes)
        .retrying(retryParams, settings.getExecutor())
        .bind(channel);
  }

  // ----- listTopics -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching topics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public Iterable<Topic> listTopics(String project) {
    ListTopicsRequest request = ListTopicsRequest.newBuilder().setProject(project).build();
    return listTopics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching topics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Iterable<Topic> listTopics(ListTopicsRequest request) {
    return listTopicsStreamingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching topics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<ListTopicsRequest, Iterable<Topic>> listTopicsStreamingCallable() {
    return listTopicsCallable().pageStreaming(LIST_TOPICS_PAGE_DESC);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching topics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable() {
    ImmutableSet<Status.Code> retryableCodes = retryCodesConfig.get(MethodIdentifier.LIST_TOPICS);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.LIST_TOPICS);
    return LIST_TOPICS
        .retryableOn(retryableCodes)
        .retrying(retryParams, settings.getExecutor())
        .bind(channel);
  }

  // ----- listTopicSubscriptions -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public Iterable<String> listTopicSubscriptions(String topic) {
    ListTopicSubscriptionsRequest request =
        ListTopicSubscriptionsRequest.newBuilder().setTopic(topic).build();
    return listTopicSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Iterable<String> listTopicSubscriptions(ListTopicSubscriptionsRequest request) {
    return listTopicSubscriptionsStreamingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<ListTopicSubscriptionsRequest, Iterable<String>>
      listTopicSubscriptionsStreamingCallable() {
    return listTopicSubscriptionsCallable().pageStreaming(LIST_TOPIC_SUBSCRIPTIONS_PAGE_DESC);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable() {
    ImmutableSet<Status.Code> retryableCodes =
        retryCodesConfig.get(MethodIdentifier.LIST_TOPIC_SUBSCRIPTIONS);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.LIST_TOPIC_SUBSCRIPTIONS);
    return LIST_TOPIC_SUBSCRIPTIONS
        .retryableOn(retryableCodes)
        .retrying(retryParams, settings.getExecutor())
        .bind(channel);
  }

  // ----- deleteTopic -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
   * does not exist. After a topic is deleted, a new topic may be created with
   * the same name; this is an entirely new topic with none of the old
   * configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param topic Name of the topic to delete.
   */
  public void deleteTopic(String topic) {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setTopic(topic).build();

    deleteTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
   * does not exist. After a topic is deleted, a new topic may be created with
   * the same name; this is an entirely new topic with none of the old
   * configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public void deleteTopic(DeleteTopicRequest request) {
    deleteTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
   * does not exist. After a topic is deleted, a new topic may be created with
   * the same name; this is an entirely new topic with none of the old
   * configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    ImmutableSet<Status.Code> retryableCodes = retryCodesConfig.get(MethodIdentifier.DELETE_TOPIC);
    RetryParams retryParams = retryParamsConfig.get(MethodIdentifier.DELETE_TOPIC);
    return DELETE_TOPIC
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

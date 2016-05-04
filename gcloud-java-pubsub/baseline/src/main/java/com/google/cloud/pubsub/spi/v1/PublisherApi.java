/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.pubsub.spi.v1;

import com.google.api.gax.core.PageAccessor;
import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.Topic;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// Manually-added imports: add custom (non-generated) imports after this point.

// AUTO-GENERATED DOCUMENTATION AND SERVICE - see instructions at the top of the file for editing.
/**
 * Service Description: The service that an application uses to manipulate topics, and to send
 * messages to a topic.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (PublisherApi publisherApi = PublisherApi.createWithDefaults()) {
 *   String name = "";
 *   Topic callResult = publisherApi.createTopic(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the publisherApi object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * ApiCallable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of PublisherSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * PublisherSettings publisherSettings = PublisherSettings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * PublisherApi publisherApi = PublisherApi.create(publisherSettings);
 * </code>
 * </pre>
 *
 * <!-- manual edit -->
 * <!-- end manual edit -->
 */
@javax.annotation.Generated("by GAPIC")
public class PublisherApi implements AutoCloseable {
  private final PublisherSettings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<Topic, Topic> createTopicCallable;
  private final ApiCallable<PublishRequest, PublishResponse> publishCallable;
  private final ApiCallable<GetTopicRequest, Topic> getTopicCallable;
  private final ApiCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable;
  private final ApiCallable<ListTopicsRequest, PageAccessor<Topic>> listTopicsPagedCallable;
  private final ApiCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable;
  private final ApiCallable<ListTopicSubscriptionsRequest, PageAccessor<String>>
      listTopicSubscriptionsPagedCallable;
  private final ApiCallable<DeleteTopicRequest, Empty> deleteTopicCallable;

  public final PublisherSettings getSettings() {
    return settings;
  }

  private static final PathTemplate PROJECT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}");

  private static final PathTemplate TOPIC_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/topics/{topic}");

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
   * a topic resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String formatTopicName(String project, String topic) {
    return TOPIC_PATH_TEMPLATE.instantiate("project", project, "topic", topic);
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
   * represents a topic resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String parseProjectFromTopicName(String topicName) {
    return TOPIC_PATH_TEMPLATE.parse(topicName).get("project");
  }

  /**
   * Parses the topic from the given fully-qualified path which
   * represents a topic resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String parseTopicFromTopicName(String topicName) {
    return TOPIC_PATH_TEMPLATE.parse(topicName).get("topic");
  }

  /**
   * Constructs an instance of PublisherApi with default settings.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final PublisherApi createWithDefaults() throws IOException {
    return create(PublisherSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of PublisherApi, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final PublisherApi create(PublisherSettings settings) throws IOException {
    return new PublisherApi(settings);
  }

  /**
   * Constructs an instance of PublisherApi, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected PublisherApi(PublisherSettings settings) throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.createTopicCallable =
        ApiCallable.create(settings.createTopicSettings(), this.channel, this.executor);
    this.publishCallable =
        ApiCallable.create(settings.publishSettings(), this.channel, this.executor);
    if (settings.publishSettings().getBundlerFactory() != null) {
      closeables.add(settings.publishSettings().getBundlerFactory());
    }
    this.getTopicCallable =
        ApiCallable.create(settings.getTopicSettings(), this.channel, this.executor);
    this.listTopicsCallable =
        ApiCallable.create(settings.listTopicsSettings(), this.channel, this.executor);
    this.listTopicsPagedCallable =
        ApiCallable.createPagedVariant(settings.listTopicsSettings(), this.channel, this.executor);
    this.listTopicSubscriptionsCallable =
        ApiCallable.create(settings.listTopicSubscriptionsSettings(), this.channel, this.executor);
    this.listTopicSubscriptionsPagedCallable =
        ApiCallable.createPagedVariant(
            settings.listTopicSubscriptionsSettings(), this.channel, this.executor);
    this.deleteTopicCallable =
        ApiCallable.create(settings.deleteTopicSettings(), this.channel, this.executor);

    if (settings.getChannelProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              channel.shutdown();
            }
          });
    }
    if (settings.getExecutorProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              executor.shutdown();
            }
          });
    }
  }

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
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Topic createTopic(String name) {
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
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private Topic createTopic(Topic request) {
    return createTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates the given topic with the given name.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<Topic, Topic> createTopicCallable() {
    return createTopicCallable;
  }

  // ----- publish -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Adds one or more messages to the topic. Generates `NOT_FOUND` if the topic
   * does not exist. The message payload must not be empty; it must contain
   *  either a non-empty data field, or at least one attribute.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param topic The messages in the request will be published on this topic.
   * @param messages The messages to publish.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PublishResponse publish(String topic, List<PubsubMessage> messages) {
    PublishRequest request =
        PublishRequest.newBuilder().setTopic(topic).addAllMessages(messages).build();

    return publish(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Adds one or more messages to the topic. Generates `NOT_FOUND` if the topic
   * does not exist. The message payload must not be empty; it must contain
   *  either a non-empty data field, or at least one attribute.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public PublishResponse publish(PublishRequest request) {
    return publishCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Adds one or more messages to the topic. Generates `NOT_FOUND` if the topic
   * does not exist. The message payload must not be empty; it must contain
   *  either a non-empty data field, or at least one attribute.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<PublishRequest, PublishResponse> publishCallable() {
    return publishCallable;
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
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Topic getTopic(String topic) {
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
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private Topic getTopic(GetTopicRequest request) {
    return getTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets the configuration of a topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<GetTopicRequest, Topic> getTopicCallable() {
    return getTopicCallable;
  }

  // ----- listTopics -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching topics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param project The name of the cloud project that topics belong to.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<Topic> listTopics(String project) {
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
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<Topic> listTopics(ListTopicsRequest request) {
    return listTopicsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching topics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<ListTopicsRequest, PageAccessor<Topic>> listTopicsPagedCallable() {
    return listTopicsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching topics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable() {
    return listTopicsCallable;
  }

  // ----- listTopicSubscriptions -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param topic The name of the topic that subscriptions are attached to.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<String> listTopicSubscriptions(String topic) {
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
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<String> listTopicSubscriptions(ListTopicSubscriptionsRequest request) {
    return listTopicSubscriptionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<ListTopicSubscriptionsRequest, PageAccessor<String>>
      listTopicSubscriptionsPagedCallable() {
    return listTopicSubscriptionsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable() {
    return listTopicSubscriptionsCallable;
  }

  // ----- deleteTopic -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes the topic with the given name. Generates `NOT_FOUND` if the topic
   * does not exist. After a topic is deleted, a new topic may be created with
   * the same name; this is an entirely new topic with none of the old
   * configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param topic Name of the topic to delete.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteTopic(String topic) {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setTopic(topic).build();

    deleteTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes the topic with the given name. Generates `NOT_FOUND` if the topic
   * does not exist. After a topic is deleted, a new topic may be created with
   * the same name; this is an entirely new topic with none of the old
   * configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private void deleteTopic(DeleteTopicRequest request) {
    deleteTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes the topic with the given name. Generates `NOT_FOUND` if the topic
   * does not exist. After a topic is deleted, a new topic may be created with
   * the same name; this is an entirely new topic with none of the old
   * configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public final ApiCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    return deleteTopicCallable;
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

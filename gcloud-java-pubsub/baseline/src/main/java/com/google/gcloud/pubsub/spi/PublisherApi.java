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

import com.google.api.gax.grpc.ApiCallSettings;
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

// Manually-added imports: add custom (non-generated) imports after this point.

// AUTO-GENERATED DOCUMENTATION AND SERVICE - see instructions at the top of the file for editing.
/**
 * Service Description: The service that an application uses to manipulate topics, and to send
 * messages to a topic.
 *
 * <!-- manual edit -->
 * <!-- end manual edit -->
 */
@javax.annotation.Generated("by GAPIC")
public class PublisherApi implements AutoCloseable {

  public static class ResourceNames {
    private ResourceNames() {}

    // =======================
    // ResourceNames Constants
    // =======================

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

    // ==============================
    // Resource Name Helper Functions
    // ==============================

    /**
     * Formats a string containing the fully-qualified path to represent
     * a project resource.
     *
     * <!-- manual edit -->
     * <!-- end manual edit -->
     */
    public static final String formatProjectPath(String project) {
      return PROJECT_PATH_TEMPLATE.instantiate("project", project);
    }

    /**
     * Formats a string containing the fully-qualified path to represent
     * a topic resource.
     *
     * <!-- manual edit -->
     * <!-- end manual edit -->
     */
    public static final String formatTopicPath(String project, String topic) {
      return TOPIC_PATH_TEMPLATE.instantiate("project", project, "topic", topic);
    }

    /**
     * Parses the project from the given fully-qualified path which
     * represents a project resource.
     *
     * <!-- manual edit -->
     * <!-- end manual edit -->
     */
    public static final String parseProjectFromProjectPath(String projectPath) {
      return PROJECT_PATH_TEMPLATE.parse(projectPath).get("project");
    }

    /**
     * Parses the project from the given fully-qualified path which
     * represents a topic resource.
     *
     * <!-- manual edit -->
     * <!-- end manual edit -->
     */
    public static final String parseProjectFromTopicPath(String topicPath) {
      return TOPIC_PATH_TEMPLATE.parse(topicPath).get("project");
    }

    /**
     * Parses the topic from the given fully-qualified path which
     * represents a topic resource.
     *
     * <!-- manual edit -->
     * <!-- end manual edit -->
     */
    public static final String parseTopicFromTopicPath(String topicPath) {
      return TOPIC_PATH_TEMPLATE.parse(topicPath).get("topic");
    }
  }

  // ========
  // Members
  // ========

  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<Topic, Topic> createTopicCallable;
  private final ApiCallable<PublishRequest, PublishResponse> publishCallable;
  private final ApiCallable<GetTopicRequest, Topic> getTopicCallable;
  private final ApiCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable;
  private final ApiCallable<ListTopicsRequest, Iterable<Topic>> listTopicsIterableCallable;
  private final ApiCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable;
  private final ApiCallable<ListTopicSubscriptionsRequest, Iterable<String>>
      listTopicSubscriptionsIterableCallable;
  private final ApiCallable<DeleteTopicRequest, Empty> deleteTopicCallable;

  // ===============
  // Factory Methods
  // ===============

  /**
   * Constructs an instance of PublisherSettings with default settings.
   */
  public static PublisherSettings newSettings() {
    return PublisherSettings.create();
  }

  /**
   * Constructs an instance of PublisherApi with default settings.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static PublisherApi create() throws IOException {
    return create(newSettings());
  }

  /**
   * Constructs an instance of PublisherApi, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static PublisherApi create(PublisherSettings settings) throws IOException {
    return new PublisherApi(settings);
  }

  /**
   * Constructs an instance of PublisherApi, using the given settings. This is protected so that it
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected PublisherApi(PublisherSettings settings) throws IOException {
    this.channel = settings.getChannel();

    for (ApiCallSettings method : settings.allMethods()) {
      if (method.getExecutor() == null) {
        method.setExecutor(settings.getExecutor());
      }
    }

    this.createTopicCallable = settings.createTopicMethod().build(settings);
    this.publishCallable = settings.publishMethod().build(settings);
    this.getTopicCallable = settings.getTopicMethod().build(settings);
    this.listTopicsCallable = settings.listTopicsMethod().build(settings);
    this.listTopicsIterableCallable = settings.listTopicsMethod().buildPageStreaming(settings);
    this.listTopicSubscriptionsCallable = settings.listTopicSubscriptionsMethod().build(settings);
    this.listTopicSubscriptionsIterableCallable =
        settings.listTopicSubscriptionsMethod().buildPageStreaming(settings);
    this.deleteTopicCallable = settings.deleteTopicMethod().build(settings);

    closeables.add(
        new Closeable() {
          @Override
          public void close() throws IOException {
            channel.shutdown();
          }
        });
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
  public ApiCallable<Topic, Topic> createTopicCallable() {
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
   */
  public PublishResponse publish(String topic, List<PubsubMessage> messages) {
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
  public ApiCallable<PublishRequest, PublishResponse> publishCallable() {
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
  public ApiCallable<GetTopicRequest, Topic> getTopicCallable() {
    return getTopicCallable;
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
    return listTopicsIterableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching topics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<ListTopicsRequest, Iterable<Topic>> listTopicsIterableCallable() {
    return listTopicsIterableCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching topics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable() {
    return listTopicsCallable;
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
    return listTopicSubscriptionsIterableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<ListTopicSubscriptionsRequest, Iterable<String>>
      listTopicSubscriptionsIterableCallable() {
    return listTopicSubscriptionsIterableCallable;
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
   */
  public void deleteTopic(String topic) {
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
  public ApiCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    return deleteTopicCallable;
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
  public void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }

  // ========
  // Manually-added methods: add custom (non-generated) methods after this point.
  // ========

}

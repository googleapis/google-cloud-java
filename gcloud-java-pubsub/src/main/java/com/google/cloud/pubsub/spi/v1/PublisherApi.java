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
package com.google.cloud.pubsub.spi.v1;

import com.google.api.gax.core.PageAccessor;
import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
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

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The service that an application uses to manipulate topics, and to send
 * messages to a topic.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (PublisherApi publisherApi = PublisherApi.create()) {
 *   String formattedName = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
 *   Topic response = publisherApi.createTopic(formattedName);
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
  private final ApiCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final ApiCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final ApiCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

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
   */
  public static final String formatProjectName(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate("project", project);
  }

  /**
   * Formats a string containing the fully-qualified path to represent
   * a topic resource.
   */
  public static final String formatTopicName(String project, String topic) {
    return TOPIC_PATH_TEMPLATE.instantiate(
        "project", project,
        "topic", topic);
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a project resource.
   */
  public static final String parseProjectFromProjectName(String projectName) {
    return PROJECT_PATH_TEMPLATE.parse(projectName).get("project");
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a topic resource.
   */
  public static final String parseProjectFromTopicName(String topicName) {
    return TOPIC_PATH_TEMPLATE.parse(topicName).get("project");
  }

  /**
   * Parses the topic from the given fully-qualified path which
   * represents a topic resource.
   */
  public static final String parseTopicFromTopicName(String topicName) {
    return TOPIC_PATH_TEMPLATE.parse(topicName).get("topic");
  }

  /**
   * Constructs an instance of PublisherApi with default settings.
   */
  public static final PublisherApi create() throws IOException {
    return create(PublisherSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of PublisherApi, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final PublisherApi create(PublisherSettings settings) throws IOException {
    return new PublisherApi(settings);
  }

  /**
   * Constructs an instance of PublisherApi, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
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
    this.setIamPolicyCallable =
        ApiCallable.create(settings.setIamPolicySettings(), this.channel, this.executor);
    this.getIamPolicyCallable =
        ApiCallable.create(settings.getIamPolicySettings(), this.channel, this.executor);
    this.testIamPermissionsCallable =
        ApiCallable.create(settings.testIamPermissionsSettings(), this.channel, this.executor);

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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates the given topic with the given name.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedName = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   Topic response = publisherApi.createTopic(formattedName);
   * }
   * </code></pre>
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
    TOPIC_PATH_TEMPLATE.validate(name, "createTopic");
    Topic request = Topic.newBuilder().setName(name).build();
    return createTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates the given topic with the given name.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedName = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   Topic request = Topic.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Topic response = publisherApi.createTopic(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final Topic createTopic(Topic request) {
    return createTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates the given topic with the given name.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedName = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   Topic request = Topic.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ListenableFuture&lt;Topic&gt; future = publisherApi.createTopicCallable().futureCall(request);
   *   // Do something
   *   Topic response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<Topic, Topic> createTopicCallable() {
    return createTopicCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
   * does not exist. The message payload must not be empty; it must contain
   *  either a non-empty data field, or at least one attribute.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   ByteString data = ByteString.copyFromUtf8("");
   *   PubsubMessage messagesElement = PubsubMessage.newBuilder()
   *     .setData(data)
   *     .build();
   *   List&lt;PubsubMessage&gt; messages = Arrays.asList(messagesElement);
   *   PublishResponse response = publisherApi.publish(formattedTopic, messages);
   * }
   * </code></pre>
   *
   * @param topic The messages in the request will be published on this topic.
   * @param messages The messages to publish.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PublishResponse publish(String topic, List<PubsubMessage> messages) {
    TOPIC_PATH_TEMPLATE.validate(topic, "publish");
    PublishRequest request =
        PublishRequest.newBuilder().setTopic(topic).addAllMessages(messages).build();
    return publish(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
   * does not exist. The message payload must not be empty; it must contain
   *  either a non-empty data field, or at least one attribute.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   ByteString data = ByteString.copyFromUtf8("");
   *   PubsubMessage messagesElement = PubsubMessage.newBuilder()
   *     .setData(data)
   *     .build();
   *   List&lt;PubsubMessage&gt; messages = Arrays.asList(messagesElement);
   *   PublishRequest request = PublishRequest.newBuilder()
   *     .setTopic(formattedTopic)
   *     .addAllMessages(messages)
   *     .build();
   *   PublishResponse response = publisherApi.publish(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PublishResponse publish(PublishRequest request) {
    return publishCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
   * does not exist. The message payload must not be empty; it must contain
   *  either a non-empty data field, or at least one attribute.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   ByteString data = ByteString.copyFromUtf8("");
   *   PubsubMessage messagesElement = PubsubMessage.newBuilder()
   *     .setData(data)
   *     .build();
   *   List&lt;PubsubMessage&gt; messages = Arrays.asList(messagesElement);
   *   PublishRequest request = PublishRequest.newBuilder()
   *     .setTopic(formattedTopic)
   *     .addAllMessages(messages)
   *     .build();
   *   ListenableFuture&lt;PublishResponse&gt; future = publisherApi.publishCallable().futureCall(request);
   *   // Do something
   *   PublishResponse response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<PublishRequest, PublishResponse> publishCallable() {
    return publishCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the configuration of a topic.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   Topic response = publisherApi.getTopic(formattedTopic);
   * }
   * </code></pre>
   *
   * @param topic The name of the topic to get.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Topic getTopic(String topic) {
    TOPIC_PATH_TEMPLATE.validate(topic, "getTopic");
    GetTopicRequest request = GetTopicRequest.newBuilder().setTopic(topic).build();
    return getTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the configuration of a topic.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   GetTopicRequest request = GetTopicRequest.newBuilder()
   *     .setTopic(formattedTopic)
   *     .build();
   *   Topic response = publisherApi.getTopic(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final Topic getTopic(GetTopicRequest request) {
    return getTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the configuration of a topic.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   GetTopicRequest request = GetTopicRequest.newBuilder()
   *     .setTopic(formattedTopic)
   *     .build();
   *   ListenableFuture&lt;Topic&gt; future = publisherApi.getTopicCallable().futureCall(request);
   *   // Do something
   *   Topic response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<GetTopicRequest, Topic> getTopicCallable() {
    return getTopicCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching topics.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedProject = PublisherApi.formatProjectName("[PROJECT]");
   *   for (Topic element : publisherApi.listTopics(formattedProject)) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project The name of the cloud project that topics belong to.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<Topic> listTopics(String project) {
    PROJECT_PATH_TEMPLATE.validate(project, "listTopics");
    ListTopicsRequest request = ListTopicsRequest.newBuilder().setProject(project).build();
    return listTopics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching topics.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedProject = PublisherApi.formatProjectName("[PROJECT]");
   *   ListTopicsRequest request = ListTopicsRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (Topic element : publisherApi.listTopics(request)) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<Topic> listTopics(ListTopicsRequest request) {
    return listTopicsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching topics.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedProject = PublisherApi.formatProjectName("[PROJECT]");
   *   ListTopicsRequest request = ListTopicsRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ListenableFuture&lt;PageAccessor&lt;Topic&gt;&gt; future = publisherApi.listTopicsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Topic element : future.get()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<ListTopicsRequest, PageAccessor<Topic>> listTopicsPagedCallable() {
    return listTopicsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching topics.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedProject = PublisherApi.formatProjectName("[PROJECT]");
   *   ListTopicsRequest request = ListTopicsRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     ListTopicsResponse response = publisherApi.listTopicsCallable().call(request);
   *     for (Topic element : response.getTopicsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable() {
    return listTopicsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   for (String element : publisherApi.listTopicSubscriptions(formattedTopic)) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param topic The name of the topic that subscriptions are attached to.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<String> listTopicSubscriptions(String topic) {
    TOPIC_PATH_TEMPLATE.validate(topic, "listTopicSubscriptions");
    ListTopicSubscriptionsRequest request =
        ListTopicSubscriptionsRequest.newBuilder().setTopic(topic).build();
    return listTopicSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
   *     .setTopic(formattedTopic)
   *     .build();
   *   for (String element : publisherApi.listTopicSubscriptions(request)) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<String> listTopicSubscriptions(ListTopicSubscriptionsRequest request) {
    return listTopicSubscriptionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
   *     .setTopic(formattedTopic)
   *     .build();
   *   ListenableFuture&lt;PageAccessor&lt;String&gt;&gt; future = publisherApi.listTopicSubscriptionsPagedCallable().futureCall(request);
   *   // Do something
   *   for (String element : future.get()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<ListTopicSubscriptionsRequest, PageAccessor<String>>
      listTopicSubscriptionsPagedCallable() {
    return listTopicSubscriptionsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
   *     .setTopic(formattedTopic)
   *     .build();
   *   while (true) {
   *     ListTopicSubscriptionsResponse response = publisherApi.listTopicSubscriptionsCallable().call(request);
   *     for (String element : response.getSubscriptionsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable() {
    return listTopicSubscriptionsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
   * does not exist. After a topic is deleted, a new topic may be created with
   * the same name; this is an entirely new topic with none of the old
   * configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   publisherApi.deleteTopic(formattedTopic);
   * }
   * </code></pre>
   *
   * @param topic Name of the topic to delete.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteTopic(String topic) {
    TOPIC_PATH_TEMPLATE.validate(topic, "deleteTopic");
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setTopic(topic).build();
    deleteTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
   * does not exist. After a topic is deleted, a new topic may be created with
   * the same name; this is an entirely new topic with none of the old
   * configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   DeleteTopicRequest request = DeleteTopicRequest.newBuilder()
   *     .setTopic(formattedTopic)
   *     .build();
   *   publisherApi.deleteTopic(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final void deleteTopic(DeleteTopicRequest request) {
    deleteTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
   * does not exist. After a topic is deleted, a new topic may be created with
   * the same name; this is an entirely new topic with none of the old
   * configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedTopic = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   DeleteTopicRequest request = DeleteTopicRequest.newBuilder()
   *     .setTopic(formattedTopic)
   *     .build();
   *   ListenableFuture&lt;Void&gt; future = publisherApi.deleteTopicCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    return deleteTopicCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any
   * existing policy.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedResource = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = publisherApi.setIamPolicy(formattedResource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which policy is being specified.
   * Resource is usually specified as a path, such as,
   * projects/{project}/zones/{zone}/disks/{disk}.
   * @param policy REQUIRED: The complete policy to be applied to the 'resource'. The size of
   * the policy is limited to a few 10s of KB. An empty policy is in general a
   * valid policy but certain services (like Projects) might reject them.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    TOPIC_PATH_TEMPLATE.validate(resource, "setIamPolicy");
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any
   * existing policy.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedResource = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   Policy response = publisherApi.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any
   * existing policy.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedResource = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   ListenableFuture&lt;Policy&gt; future = publisherApi.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. Is empty if the
   * policy or the resource does not exist.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedResource = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   Policy response = publisherApi.getIamPolicy(formattedResource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which policy is being requested. Resource
   * is usually specified as a path, such as, projects/{project}.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    TOPIC_PATH_TEMPLATE.validate(resource, "getIamPolicy");
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. Is empty if the
   * policy or the resource does not exist.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedResource = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = publisherApi.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. Is empty if the
   * policy or the resource does not exist.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedResource = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   ListenableFuture&lt;Policy&gt; future = publisherApi.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedResource = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = publisherApi.testIamPermissions(formattedResource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which policy detail is being requested.
   * Resource is usually specified as a path, such as, projects/{project}.
   * @param permissions The set of permissions to check for the 'resource'. Permissions with
   * wildcards (such as '&ast;' or 'storage.&ast;') are not allowed.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TOPIC_PATH_TEMPLATE.validate(resource, "testIamPermissions");
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedResource = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   TestIamPermissionsResponse response = publisherApi.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * Sample code:
   * <pre><code>
   * try (PublisherApi publisherApi = PublisherApi.create()) {
   *   String formattedResource = PublisherApi.formatTopicName("[PROJECT]", "[TOPIC]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   ListenableFuture&lt;TestIamPermissionsResponse&gt; future = publisherApi.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestIamPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   */
  @Override
  public final void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }
}

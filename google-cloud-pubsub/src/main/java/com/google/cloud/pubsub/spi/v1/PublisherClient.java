/*
 * Copyright 2016, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.pubsub.spi.v1;

import static com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListTopicSubscriptionsPagedResponse;
import static com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListTopicsPagedResponse;

import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.ExperimentalApi;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The service that an application uses to manipulate topics, and to send
 * messages to a topic.
 *
 * <p>To publish messages to a topic, see the Publisher class.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (PublisherClient publisherClient = PublisherClient.create()) {
 *   TopicName name = TopicName.create("[PROJECT]", "[TOPIC]");
 *   Topic response = publisherClient.createTopic(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the publisherClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of PublisherSettings to create().
 * For example:
 *
 * <pre>
 * <code>
 * InstantiatingChannelProvider channelProvider =
 *     PublisherSettings.defaultChannelProviderBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PublisherSettings publisherSettings =
 *     PublisherSettings.defaultBuilder().setChannelProvider(channelProvider).build();
 * PublisherClient publisherClient =
 *     PublisherClient.create(publisherSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
@ExperimentalApi
public class PublisherClient implements AutoCloseable {
  private final PublisherSettings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<Topic, Topic> createTopicCallable;
  private final UnaryCallable<PublishRequest, PublishResponse> publishCallable;
  private final UnaryCallable<GetTopicRequest, Topic> getTopicCallable;
  private final UnaryCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable;
  private final UnaryCallable<ListTopicsRequest, ListTopicsPagedResponse> listTopicsPagedCallable;
  private final UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable;
  private final UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsPagedCallable;
  private final UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  /** Constructs an instance of PublisherClient with default settings. */
  public static final PublisherClient create() throws IOException {
    return create(PublisherSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of PublisherClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PublisherClient create(PublisherSettings settings) throws IOException {
    return new PublisherClient(settings);
  }

  /**
   * Constructs an instance of PublisherClient, using the given settings. This is protected so that
   * it easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected PublisherClient(PublisherSettings settings) throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();

    this.createTopicCallable =
        UnaryCallable.create(settings.createTopicSettings(), this.channel, this.executor);
    this.publishCallable =
        UnaryCallable.create(settings.publishSettings(), this.channel, this.executor);
    if (settings.publishSettings().getBundlerFactory() != null) {
      closeables.add(settings.publishSettings().getBundlerFactory());
    }
    this.getTopicCallable =
        UnaryCallable.create(settings.getTopicSettings(), this.channel, this.executor);
    this.listTopicsCallable =
        UnaryCallable.create(settings.listTopicsSettings(), this.channel, this.executor);
    this.listTopicsPagedCallable =
        UnaryCallable.createPagedVariant(
            settings.listTopicsSettings(), this.channel, this.executor);
    this.listTopicSubscriptionsCallable =
        UnaryCallable.create(
            settings.listTopicSubscriptionsSettings(), this.channel, this.executor);
    this.listTopicSubscriptionsPagedCallable =
        UnaryCallable.createPagedVariant(
            settings.listTopicSubscriptionsSettings(), this.channel, this.executor);
    this.deleteTopicCallable =
        UnaryCallable.create(settings.deleteTopicSettings(), this.channel, this.executor);
    this.setIamPolicyCallable =
        UnaryCallable.create(settings.setIamPolicySettings(), this.channel, this.executor);
    this.getIamPolicyCallable =
        UnaryCallable.create(settings.getIamPolicySettings(), this.channel, this.executor);
    this.testIamPermissionsCallable =
        UnaryCallable.create(settings.testIamPermissionsSettings(), this.channel, this.executor);

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

  public final PublisherSettings getSettings() {
    return settings;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates the given topic with the given name.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName name = TopicName.create("[PROJECT]", "[TOPIC]");
   *   Topic response = publisherClient.createTopic(name);
   * }
   * </code></pre>
   *
   * @param name The name of the topic. It must have the format
   *     `"projects/{project}/topics/{topic}"`. `{topic}` must start with a letter, and contain only
   *     letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores (`_`), periods (`.`),
   *     tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3 and 255 characters in
   *     length, and it must not start with `"goog"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Topic createTopic(TopicName name) {

    Topic request = Topic.newBuilder().setNameWithTopicName(name).build();
    return createTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates the given topic with the given name.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName name = TopicName.create("[PROJECT]", "[TOPIC]");
   *   Topic request = Topic.newBuilder()
   *     .setNameWithTopicName(name)
   *     .build();
   *   Topic response = publisherClient.createTopic(request);
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
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName name = TopicName.create("[PROJECT]", "[TOPIC]");
   *   Topic request = Topic.newBuilder()
   *     .setNameWithTopicName(name)
   *     .build();
   *   RpcFuture&lt;Topic&gt; future = publisherClient.createTopicCallable().futureCall(request);
   *   // Do something
   *   Topic response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<Topic, Topic> createTopicCallable() {
    return createTopicCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist. The
   * message payload must not be empty; it must contain either a non-empty data field, or at least
   * one attribute.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   ByteString data = ByteString.copyFromUtf8("");
   *   PubsubMessage messagesElement = PubsubMessage.newBuilder()
   *     .setData(data)
   *     .build();
   *   List&lt;PubsubMessage&gt; messages = Arrays.asList(messagesElement);
   *   PublishResponse response = publisherClient.publish(topic, messages);
   * }
   * </code></pre>
   *
   * @param topic The messages in the request will be published on this topic. Format is
   *     `projects/{project}/topics/{topic}`.
   * @param messages The messages to publish.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  @Deprecated
  public final PublishResponse publish(TopicName topic, List<PubsubMessage> messages) {

    PublishRequest request =
        PublishRequest.newBuilder().setTopicWithTopicName(topic).addAllMessages(messages).build();
    return publish(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist. The
   * message payload must not be empty; it must contain either a non-empty data field, or at least
   * one attribute.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   ByteString data = ByteString.copyFromUtf8("");
   *   PubsubMessage messagesElement = PubsubMessage.newBuilder()
   *     .setData(data)
   *     .build();
   *   List&lt;PubsubMessage&gt; messages = Arrays.asList(messagesElement);
   *   PublishRequest request = PublishRequest.newBuilder()
   *     .setTopicWithTopicName(topic)
   *     .addAllMessages(messages)
   *     .build();
   *   PublishResponse response = publisherClient.publish(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  @Deprecated
  public final PublishResponse publish(PublishRequest request) {
    return publishCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist. The
   * message payload must not be empty; it must contain either a non-empty data field, or at least
   * one attribute.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   ByteString data = ByteString.copyFromUtf8("");
   *   PubsubMessage messagesElement = PubsubMessage.newBuilder()
   *     .setData(data)
   *     .build();
   *   List&lt;PubsubMessage&gt; messages = Arrays.asList(messagesElement);
   *   PublishRequest request = PublishRequest.newBuilder()
   *     .setTopicWithTopicName(topic)
   *     .addAllMessages(messages)
   *     .build();
   *   RpcFuture&lt;PublishResponse&gt; future = publisherClient.publishCallable().futureCall(request);
   *   // Do something
   *   PublishResponse response = future.get();
   * }
   * </code></pre>
   */
  @Deprecated
  public final UnaryCallable<PublishRequest, PublishResponse> publishCallable() {
    return publishCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the configuration of a topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   Topic response = publisherClient.getTopic(topic);
   * }
   * </code></pre>
   *
   * @param topic The name of the topic to get. Format is `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Topic getTopic(TopicName topic) {

    GetTopicRequest request = GetTopicRequest.newBuilder().setTopicWithTopicName(topic).build();
    return getTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the configuration of a topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   GetTopicRequest request = GetTopicRequest.newBuilder()
   *     .setTopicWithTopicName(topic)
   *     .build();
   *   Topic response = publisherClient.getTopic(request);
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
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   GetTopicRequest request = GetTopicRequest.newBuilder()
   *     .setTopicWithTopicName(topic)
   *     .build();
   *   RpcFuture&lt;Topic&gt; future = publisherClient.getTopicCallable().futureCall(request);
   *   // Do something
   *   Topic response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTopicRequest, Topic> getTopicCallable() {
    return getTopicCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching topics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   ProjectName project = ProjectName.create("[PROJECT]");
   *   for (Topic element : publisherClient.listTopics(project).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project The name of the cloud project that topics belong to. Format is
   *     `projects/{project}`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListTopicsPagedResponse listTopics(ProjectName project) {
    ListTopicsRequest request =
        ListTopicsRequest.newBuilder().setProjectWithProjectName(project).build();
    return listTopics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching topics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   ProjectName project = ProjectName.create("[PROJECT]");
   *   ListTopicsRequest request = ListTopicsRequest.newBuilder()
   *     .setProjectWithProjectName(project)
   *     .build();
   *   for (Topic element : publisherClient.listTopics(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListTopicsPagedResponse listTopics(ListTopicsRequest request) {
    return listTopicsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching topics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   ProjectName project = ProjectName.create("[PROJECT]");
   *   ListTopicsRequest request = ListTopicsRequest.newBuilder()
   *     .setProjectWithProjectName(project)
   *     .build();
   *   RpcFuture&lt;ListTopicsPagedResponse&gt; future = publisherClient.listTopicsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Topic element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTopicsRequest, ListTopicsPagedResponse> listTopicsPagedCallable() {
    return listTopicsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching topics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   ProjectName project = ProjectName.create("[PROJECT]");
   *   ListTopicsRequest request = ListTopicsRequest.newBuilder()
   *     .setProjectWithProjectName(project)
   *     .build();
   *   while (true) {
   *     ListTopicsResponse response = publisherClient.listTopicsCallable().call(request);
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
  public final UnaryCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable() {
    return listTopicsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   for (SubscriptionName element : publisherClient.listTopicSubscriptions(topic).iterateAllAsSubscriptionName()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param topic The name of the topic that subscriptions are attached to. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListTopicSubscriptionsPagedResponse listTopicSubscriptions(TopicName topic) {
    ListTopicSubscriptionsRequest request =
        ListTopicSubscriptionsRequest.newBuilder().setTopicWithTopicName(topic).build();
    return listTopicSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
   *     .setTopicWithTopicName(topic)
   *     .build();
   *   for (SubscriptionName element : publisherClient.listTopicSubscriptions(request).iterateAllAsSubscriptionName()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListTopicSubscriptionsPagedResponse listTopicSubscriptions(
      ListTopicSubscriptionsRequest request) {
    return listTopicSubscriptionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
   *     .setTopicWithTopicName(topic)
   *     .build();
   *   RpcFuture&lt;ListTopicSubscriptionsPagedResponse&gt; future = publisherClient.listTopicSubscriptionsPagedCallable().futureCall(request);
   *   // Do something
   *   for (SubscriptionName element : future.get().iterateAllAsSubscriptionName()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsPagedCallable() {
    return listTopicSubscriptionsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
   *     .setTopicWithTopicName(topic)
   *     .build();
   *   while (true) {
   *     ListTopicSubscriptionsResponse response = publisherClient.listTopicSubscriptionsCallable().call(request);
   *     for (SubscriptionName element : response.getSubscriptionsListAsSubscriptionNameList()) {
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
  public final UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable() {
    return listTopicSubscriptionsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic does not exist. After a
   * topic is deleted, a new topic may be created with the same name; this is an entirely new topic
   * with none of the old configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   publisherClient.deleteTopic(topic);
   * }
   * </code></pre>
   *
   * @param topic Name of the topic to delete. Format is `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteTopic(TopicName topic) {

    DeleteTopicRequest request =
        DeleteTopicRequest.newBuilder().setTopicWithTopicName(topic).build();
    deleteTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic does not exist. After a
   * topic is deleted, a new topic may be created with the same name; this is an entirely new topic
   * with none of the old configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   DeleteTopicRequest request = DeleteTopicRequest.newBuilder()
   *     .setTopicWithTopicName(topic)
   *     .build();
   *   publisherClient.deleteTopic(request);
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
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic does not exist. After a
   * topic is deleted, a new topic may be created with the same name; this is an entirely new topic
   * with none of the old configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   DeleteTopicRequest request = DeleteTopicRequest.newBuilder()
   *     .setTopicWithTopicName(topic)
   *     .build();
   *   RpcFuture&lt;Void&gt; future = publisherClient.deleteTopicCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    return deleteTopicCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   String formattedResource = TopicName.create("[PROJECT]", "[TOPIC]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = publisherClient.setIamPolicy(formattedResource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   String formattedResource = TopicName.create("[PROJECT]", "[TOPIC]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   Policy response = publisherClient.setIamPolicy(request);
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
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   String formattedResource = TopicName.create("[PROJECT]", "[TOPIC]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   RpcFuture&lt;Policy&gt; future = publisherClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   String formattedResource = TopicName.create("[PROJECT]", "[TOPIC]").toString();
   *   Policy response = publisherClient.getIamPolicy(formattedResource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {

    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   String formattedResource = TopicName.create("[PROJECT]", "[TOPIC]").toString();
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = publisherClient.getIamPolicy(request);
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
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   String formattedResource = TopicName.create("[PROJECT]", "[TOPIC]").toString();
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   RpcFuture&lt;Policy&gt; future = publisherClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   String formattedResource = TopicName.create("[PROJECT]", "[TOPIC]").toString();
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = publisherClient.testIamPermissions(formattedResource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested.
   *     `resource` is usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   String formattedResource = TopicName.create("[PROJECT]", "[TOPIC]").toString();
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   TestIamPermissionsResponse response = publisherClient.testIamPermissions(request);
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
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PublisherClient publisherClient = PublisherClient.create()) {
   *   String formattedResource = TopicName.create("[PROJECT]", "[TOPIC]").toString();
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   RpcFuture&lt;TestIamPermissionsResponse&gt; future = publisherClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestIamPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
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

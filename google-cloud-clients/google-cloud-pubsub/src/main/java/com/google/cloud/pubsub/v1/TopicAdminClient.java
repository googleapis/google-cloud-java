/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.pubsub.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.pubsub.v1.stub.PublisherStub;
import com.google.cloud.pubsub.v1.stub.PublisherStubSettings;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.UpdateTopicRequest;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
 * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
 *   ProjectTopicName name = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
 *   Topic response = topicAdminClient.createTopic(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the topicAdminClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of TopicAdminSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * TopicAdminSettings topicAdminSettings =
 *     TopicAdminSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TopicAdminClient topicAdminClient =
 *     TopicAdminClient.create(topicAdminSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * TopicAdminSettings topicAdminSettings =
 *     TopicAdminSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TopicAdminClient topicAdminClient =
 *     TopicAdminClient.create(topicAdminSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
public class TopicAdminClient implements BackgroundResource {
  private final TopicAdminSettings settings;
  private final PublisherStub stub;

  /** Constructs an instance of TopicAdminClient with default settings. */
  public static final TopicAdminClient create() throws IOException {
    return create(TopicAdminSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TopicAdminClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TopicAdminClient create(TopicAdminSettings settings) throws IOException {
    return new TopicAdminClient(settings);
  }

  /**
   * Constructs an instance of TopicAdminClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use TopicAdminSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final TopicAdminClient create(PublisherStub stub) {
    return new TopicAdminClient(stub);
  }

  /**
   * Constructs an instance of TopicAdminClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected TopicAdminClient(TopicAdminSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PublisherStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TopicAdminClient(PublisherStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TopicAdminSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PublisherStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates the given topic with the given name. See the &lt;a
   * href="https://cloud.google.com/pubsub/docs/admin#resource_names"&gt; resource name
   * rules&lt;/a&gt;.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName name = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   Topic response = topicAdminClient.createTopic(name);
   * }
   * </code></pre>
   *
   * @param name The name of the topic. It must have the format
   *     `"projects/{project}/topics/{topic}"`. `{topic}` must start with a letter, and contain only
   *     letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores (`_`), periods (`.`),
   *     tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3 and 255 characters in
   *     length, and it must not start with `"goog"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic createTopic(ProjectTopicName name) {

    Topic request = Topic.newBuilder().setName(name == null ? null : name.toString()).build();
    return createTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates the given topic with the given name. See the &lt;a
   * href="https://cloud.google.com/pubsub/docs/admin#resource_names"&gt; resource name
   * rules&lt;/a&gt;.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName name = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   Topic response = topicAdminClient.createTopic(name.toString());
   * }
   * </code></pre>
   *
   * @param name The name of the topic. It must have the format
   *     `"projects/{project}/topics/{topic}"`. `{topic}` must start with a letter, and contain only
   *     letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores (`_`), periods (`.`),
   *     tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3 and 255 characters in
   *     length, and it must not start with `"goog"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic createTopic(String name) {

    Topic request = Topic.newBuilder().setName(name).build();
    return createTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates the given topic with the given name. See the &lt;a
   * href="https://cloud.google.com/pubsub/docs/admin#resource_names"&gt; resource name
   * rules&lt;/a&gt;.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName name = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   Topic request = Topic.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Topic response = topicAdminClient.createTopic(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic createTopic(Topic request) {
    return createTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates the given topic with the given name. See the &lt;a
   * href="https://cloud.google.com/pubsub/docs/admin#resource_names"&gt; resource name
   * rules&lt;/a&gt;.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName name = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   Topic request = Topic.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Topic&gt; future = topicAdminClient.createTopicCallable().futureCall(request);
   *   // Do something
   *   Topic response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<Topic, Topic> createTopicCallable() {
    return stub.createTopicCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing topic. Note that certain properties of a topic are not modifiable.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   Topic topic = Topic.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateTopicRequest request = UpdateTopicRequest.newBuilder()
   *     .setTopic(topic)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   Topic response = topicAdminClient.updateTopic(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic updateTopic(UpdateTopicRequest request) {
    return updateTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing topic. Note that certain properties of a topic are not modifiable.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   Topic topic = Topic.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateTopicRequest request = UpdateTopicRequest.newBuilder()
   *     .setTopic(topic)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Topic&gt; future = topicAdminClient.updateTopicCallable().futureCall(request);
   *   // Do something
   *   Topic response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateTopicRequest, Topic> updateTopicCallable() {
    return stub.updateTopicCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   ByteString data = ByteString.copyFromUtf8("");
   *   PubsubMessage messagesElement = PubsubMessage.newBuilder()
   *     .setData(data)
   *     .build();
   *   List&lt;PubsubMessage&gt; messages = Arrays.asList(messagesElement);
   *   PublishResponse response = topicAdminClient.publish(topic, messages);
   * }
   * </code></pre>
   *
   * @param topic The messages in the request will be published on this topic. Format is
   *     `projects/{project}/topics/{topic}`.
   * @param messages The messages to publish.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  /* package-private */ final PublishResponse publish(
      ProjectTopicName topic, List<PubsubMessage> messages) {

    PublishRequest request =
        PublishRequest.newBuilder()
            .setTopic(topic == null ? null : topic.toString())
            .addAllMessages(messages)
            .build();
    return publish(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   ByteString data = ByteString.copyFromUtf8("");
   *   PubsubMessage messagesElement = PubsubMessage.newBuilder()
   *     .setData(data)
   *     .build();
   *   List&lt;PubsubMessage&gt; messages = Arrays.asList(messagesElement);
   *   PublishResponse response = topicAdminClient.publish(topic.toString(), messages);
   * }
   * </code></pre>
   *
   * @param topic The messages in the request will be published on this topic. Format is
   *     `projects/{project}/topics/{topic}`.
   * @param messages The messages to publish.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  /* package-private */ final PublishResponse publish(String topic, List<PubsubMessage> messages) {

    PublishRequest request =
        PublishRequest.newBuilder().setTopic(topic).addAllMessages(messages).build();
    return publish(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   ByteString data = ByteString.copyFromUtf8("");
   *   PubsubMessage messagesElement = PubsubMessage.newBuilder()
   *     .setData(data)
   *     .build();
   *   List&lt;PubsubMessage&gt; messages = Arrays.asList(messagesElement);
   *   PublishRequest request = PublishRequest.newBuilder()
   *     .setTopic(topic.toString())
   *     .addAllMessages(messages)
   *     .build();
   *   PublishResponse response = topicAdminClient.publish(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  /* package-private */ final PublishResponse publish(PublishRequest request) {
    return publishCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   ByteString data = ByteString.copyFromUtf8("");
   *   PubsubMessage messagesElement = PubsubMessage.newBuilder()
   *     .setData(data)
   *     .build();
   *   List&lt;PubsubMessage&gt; messages = Arrays.asList(messagesElement);
   *   PublishRequest request = PublishRequest.newBuilder()
   *     .setTopic(topic.toString())
   *     .addAllMessages(messages)
   *     .build();
   *   ApiFuture&lt;PublishResponse&gt; future = topicAdminClient.publishCallable().futureCall(request);
   *   // Do something
   *   PublishResponse response = future.get();
   * }
   * </code></pre>
   */
  /* package-private */ final UnaryCallable<PublishRequest, PublishResponse> publishCallable() {
    return stub.publishCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the configuration of a topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   Topic response = topicAdminClient.getTopic(topic);
   * }
   * </code></pre>
   *
   * @param topic The name of the topic to get. Format is `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic getTopic(ProjectTopicName topic) {

    GetTopicRequest request =
        GetTopicRequest.newBuilder().setTopic(topic == null ? null : topic.toString()).build();
    return getTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the configuration of a topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   Topic response = topicAdminClient.getTopic(topic.toString());
   * }
   * </code></pre>
   *
   * @param topic The name of the topic to get. Format is `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic getTopic(String topic) {

    GetTopicRequest request = GetTopicRequest.newBuilder().setTopic(topic).build();
    return getTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the configuration of a topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   GetTopicRequest request = GetTopicRequest.newBuilder()
   *     .setTopic(topic.toString())
   *     .build();
   *   Topic response = topicAdminClient.getTopic(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic getTopic(GetTopicRequest request) {
    return getTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the configuration of a topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   GetTopicRequest request = GetTopicRequest.newBuilder()
   *     .setTopic(topic.toString())
   *     .build();
   *   ApiFuture&lt;Topic&gt; future = topicAdminClient.getTopicCallable().futureCall(request);
   *   // Do something
   *   Topic response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTopicRequest, Topic> getTopicCallable() {
    return stub.getTopicCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching topics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Topic element : topicAdminClient.listTopics(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project The name of the project in which to list topics. Format is
   *     `projects/{project-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicsPagedResponse listTopics(ProjectName project) {
    ListTopicsRequest request =
        ListTopicsRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listTopics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching topics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Topic element : topicAdminClient.listTopics(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project The name of the project in which to list topics. Format is
   *     `projects/{project-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicsPagedResponse listTopics(String project) {
    ListTopicsRequest request = ListTopicsRequest.newBuilder().setProject(project).build();
    return listTopics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching topics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListTopicsRequest request = ListTopicsRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (Topic element : topicAdminClient.listTopics(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListTopicsRequest request = ListTopicsRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListTopicsPagedResponse&gt; future = topicAdminClient.listTopicsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Topic element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTopicsRequest, ListTopicsPagedResponse> listTopicsPagedCallable() {
    return stub.listTopicsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching topics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListTopicsRequest request = ListTopicsRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     ListTopicsResponse response = topicAdminClient.listTopicsCallable().call(request);
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
    return stub.listTopicsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the names of the subscriptions on this topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   for (ProjectSubscriptionName element : topicAdminClient.listTopicSubscriptions(topic).iterateAllAsProjectSubscriptionName()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param topic The name of the topic that subscriptions are attached to. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicSubscriptionsPagedResponse listTopicSubscriptions(ProjectTopicName topic) {
    ListTopicSubscriptionsRequest request =
        ListTopicSubscriptionsRequest.newBuilder()
            .setTopic(topic == null ? null : topic.toString())
            .build();
    return listTopicSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the names of the subscriptions on this topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   for (ProjectSubscriptionName element : topicAdminClient.listTopicSubscriptions(topic.toString()).iterateAllAsProjectSubscriptionName()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param topic The name of the topic that subscriptions are attached to. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicSubscriptionsPagedResponse listTopicSubscriptions(String topic) {
    ListTopicSubscriptionsRequest request =
        ListTopicSubscriptionsRequest.newBuilder().setTopic(topic).build();
    return listTopicSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the names of the subscriptions on this topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
   *     .setTopic(topic.toString())
   *     .build();
   *   for (ProjectSubscriptionName element : topicAdminClient.listTopicSubscriptions(request).iterateAllAsProjectSubscriptionName()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicSubscriptionsPagedResponse listTopicSubscriptions(
      ListTopicSubscriptionsRequest request) {
    return listTopicSubscriptionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the names of the subscriptions on this topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
   *     .setTopic(topic.toString())
   *     .build();
   *   ApiFuture&lt;ListTopicSubscriptionsPagedResponse&gt; future = topicAdminClient.listTopicSubscriptionsPagedCallable().futureCall(request);
   *   // Do something
   *   for (ProjectSubscriptionName element : future.get().iterateAllAsProjectSubscriptionName()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsPagedCallable() {
    return stub.listTopicSubscriptionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the names of the subscriptions on this topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
   *     .setTopic(topic.toString())
   *     .build();
   *   while (true) {
   *     ListTopicSubscriptionsResponse response = topicAdminClient.listTopicSubscriptionsCallable().call(request);
   *     for (ProjectSubscriptionName element : ProjectSubscriptionName.parseList(response.getSubscriptionsList())) {
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
    return stub.listTopicSubscriptionsCallable();
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
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   topicAdminClient.deleteTopic(topic);
   * }
   * </code></pre>
   *
   * @param topic Name of the topic to delete. Format is `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTopic(ProjectTopicName topic) {

    DeleteTopicRequest request =
        DeleteTopicRequest.newBuilder().setTopic(topic == null ? null : topic.toString()).build();
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
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   topicAdminClient.deleteTopic(topic.toString());
   * }
   * </code></pre>
   *
   * @param topic Name of the topic to delete. Format is `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTopic(String topic) {

    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setTopic(topic).build();
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
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   DeleteTopicRequest request = DeleteTopicRequest.newBuilder()
   *     .setTopic(topic.toString())
   *     .build();
   *   topicAdminClient.deleteTopic(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTopic(DeleteTopicRequest request) {
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
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   DeleteTopicRequest request = DeleteTopicRequest.newBuilder()
   *     .setTopic(topic.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = topicAdminClient.deleteTopicCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    return stub.deleteTopicCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = topicAdminClient.setIamPolicy(formattedResource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   Policy response = topicAdminClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = topicAdminClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   Policy response = topicAdminClient.getIamPolicy(formattedResource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = topicAdminClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
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
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = topicAdminClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = topicAdminClient.testIamPermissions(formattedResource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested.
   *     `resource` is usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   TestIamPermissionsResponse response = topicAdminClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   ApiFuture&lt;TestIamPermissionsResponse&gt; future = topicAdminClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestIamPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListTopicsPagedResponse
      extends AbstractPagedListResponse<
          ListTopicsRequest,
          ListTopicsResponse,
          Topic,
          ListTopicsPage,
          ListTopicsFixedSizeCollection> {

    public static ApiFuture<ListTopicsPagedResponse> createAsync(
        PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context,
        ApiFuture<ListTopicsResponse> futureResponse) {
      ApiFuture<ListTopicsPage> futurePage =
          ListTopicsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTopicsPage, ListTopicsPagedResponse>() {
            @Override
            public ListTopicsPagedResponse apply(ListTopicsPage input) {
              return new ListTopicsPagedResponse(input);
            }
          });
    }

    private ListTopicsPagedResponse(ListTopicsPage page) {
      super(page, ListTopicsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTopicsPage
      extends AbstractPage<ListTopicsRequest, ListTopicsResponse, Topic, ListTopicsPage> {

    private ListTopicsPage(
        PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context,
        ListTopicsResponse response) {
      super(context, response);
    }

    private static ListTopicsPage createEmptyPage() {
      return new ListTopicsPage(null, null);
    }

    @Override
    protected ListTopicsPage createPage(
        PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context,
        ListTopicsResponse response) {
      return new ListTopicsPage(context, response);
    }

    @Override
    public ApiFuture<ListTopicsPage> createPageAsync(
        PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context,
        ApiFuture<ListTopicsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTopicsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTopicsRequest,
          ListTopicsResponse,
          Topic,
          ListTopicsPage,
          ListTopicsFixedSizeCollection> {

    private ListTopicsFixedSizeCollection(List<ListTopicsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTopicsFixedSizeCollection createEmptyCollection() {
      return new ListTopicsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTopicsFixedSizeCollection createCollection(
        List<ListTopicsPage> pages, int collectionSize) {
      return new ListTopicsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTopicSubscriptionsPagedResponse
      extends AbstractPagedListResponse<
          ListTopicSubscriptionsRequest,
          ListTopicSubscriptionsResponse,
          String,
          ListTopicSubscriptionsPage,
          ListTopicSubscriptionsFixedSizeCollection> {

    public static ApiFuture<ListTopicSubscriptionsPagedResponse> createAsync(
        PageContext<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String> context,
        ApiFuture<ListTopicSubscriptionsResponse> futureResponse) {
      ApiFuture<ListTopicSubscriptionsPage> futurePage =
          ListTopicSubscriptionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTopicSubscriptionsPage, ListTopicSubscriptionsPagedResponse>() {
            @Override
            public ListTopicSubscriptionsPagedResponse apply(ListTopicSubscriptionsPage input) {
              return new ListTopicSubscriptionsPagedResponse(input);
            }
          });
    }

    private ListTopicSubscriptionsPagedResponse(ListTopicSubscriptionsPage page) {
      super(page, ListTopicSubscriptionsFixedSizeCollection.createEmptyCollection());
    }

    public Iterable<ProjectSubscriptionName> iterateAllAsProjectSubscriptionName() {
      return Iterables.transform(
          iterateAll(),
          new Function<String, ProjectSubscriptionName>() {
            @Override
            public ProjectSubscriptionName apply(String arg0) {
              return ProjectSubscriptionName.parse(arg0);
            }
          });
    }
  }

  public static class ListTopicSubscriptionsPage
      extends AbstractPage<
          ListTopicSubscriptionsRequest,
          ListTopicSubscriptionsResponse,
          String,
          ListTopicSubscriptionsPage> {

    private ListTopicSubscriptionsPage(
        PageContext<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String> context,
        ListTopicSubscriptionsResponse response) {
      super(context, response);
    }

    private static ListTopicSubscriptionsPage createEmptyPage() {
      return new ListTopicSubscriptionsPage(null, null);
    }

    @Override
    protected ListTopicSubscriptionsPage createPage(
        PageContext<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String> context,
        ListTopicSubscriptionsResponse response) {
      return new ListTopicSubscriptionsPage(context, response);
    }

    @Override
    public ApiFuture<ListTopicSubscriptionsPage> createPageAsync(
        PageContext<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String> context,
        ApiFuture<ListTopicSubscriptionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }

    public Iterable<ProjectSubscriptionName> iterateAllAsProjectSubscriptionName() {
      return Iterables.transform(
          iterateAll(),
          new Function<String, ProjectSubscriptionName>() {
            @Override
            public ProjectSubscriptionName apply(String arg0) {
              return ProjectSubscriptionName.parse(arg0);
            }
          });
    }

    public Iterable<ProjectSubscriptionName> getValuesAsProjectSubscriptionName() {
      return Iterables.transform(
          getValues(),
          new Function<String, ProjectSubscriptionName>() {
            @Override
            public ProjectSubscriptionName apply(String arg0) {
              return ProjectSubscriptionName.parse(arg0);
            }
          });
    }
  }

  public static class ListTopicSubscriptionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTopicSubscriptionsRequest,
          ListTopicSubscriptionsResponse,
          String,
          ListTopicSubscriptionsPage,
          ListTopicSubscriptionsFixedSizeCollection> {

    private ListTopicSubscriptionsFixedSizeCollection(
        List<ListTopicSubscriptionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTopicSubscriptionsFixedSizeCollection createEmptyCollection() {
      return new ListTopicSubscriptionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTopicSubscriptionsFixedSizeCollection createCollection(
        List<ListTopicSubscriptionsPage> pages, int collectionSize) {
      return new ListTopicSubscriptionsFixedSizeCollection(pages, collectionSize);
    }

    public Iterable<ProjectSubscriptionName> getValuesAsProjectSubscriptionName() {
      return Iterables.transform(
          getValues(),
          new Function<String, ProjectSubscriptionName>() {
            @Override
            public ProjectSubscriptionName apply(String arg0) {
              return ProjectSubscriptionName.parse(arg0);
            }
          });
    }
  }
}

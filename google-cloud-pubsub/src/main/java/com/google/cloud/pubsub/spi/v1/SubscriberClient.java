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

import static com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListSubscriptionsPagedResponse;

import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.StreamingCallable;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.ExperimentalApi;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;
import com.google.pubsub.v1.TopicNameOneof;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The service that an application uses to manipulate subscriptions and to
 * consume messages from a subscription via the `Pull` method.
 *
 * <p>To retrieve messages from a subscription, see the Subscriber class.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
 *   SubscriptionName name = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
 *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
 *   PushConfig pushConfig = PushConfig.newBuilder().build();
 *   int ackDeadlineSeconds = 0;
 *   Subscription response = subscriberClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the subscriberClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of SubscriberSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * InstantiatingChannelProvider channelProvider =
 *     SubscriberSettings.defaultChannelProviderBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SubscriberSettings subscriberSettings =
 *     SubscriberSettings.defaultBuilder().setChannelProvider(channelProvider).build();
 * SubscriberClient subscriberClient =
 *     SubscriberClient.create(subscriberSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
@ExperimentalApi
public class SubscriberClient implements AutoCloseable {
  private final SubscriberSettings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<Subscription, Subscription> createSubscriptionCallable;
  private final UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable;
  private final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable;
  private final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable;
  private final UnaryCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable;
  private final UnaryCallable<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineCallable;
  private final UnaryCallable<AcknowledgeRequest, Empty> acknowledgeCallable;
  private final UnaryCallable<PullRequest, PullResponse> pullCallable;
  private final StreamingCallable<StreamingPullRequest, StreamingPullResponse>
      streamingPullCallable;
  private final UnaryCallable<ModifyPushConfigRequest, Empty> modifyPushConfigCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  /** Constructs an instance of SubscriberClient with default settings. */
  public static final SubscriberClient create() throws IOException {
    return create(SubscriberSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of SubscriberClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SubscriberClient create(SubscriberSettings settings) throws IOException {
    return new SubscriberClient(settings);
  }

  /**
   * Constructs an instance of SubscriberClient, using the given settings. This is protected so that
   * it easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected SubscriberClient(SubscriberSettings settings) throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();

    this.createSubscriptionCallable =
        UnaryCallable.create(settings.createSubscriptionSettings(), this.channel, this.executor);
    this.getSubscriptionCallable =
        UnaryCallable.create(settings.getSubscriptionSettings(), this.channel, this.executor);
    this.listSubscriptionsCallable =
        UnaryCallable.create(settings.listSubscriptionsSettings(), this.channel, this.executor);
    this.listSubscriptionsPagedCallable =
        UnaryCallable.createPagedVariant(
            settings.listSubscriptionsSettings(), this.channel, this.executor);
    this.deleteSubscriptionCallable =
        UnaryCallable.create(settings.deleteSubscriptionSettings(), this.channel, this.executor);
    this.modifyAckDeadlineCallable =
        UnaryCallable.create(settings.modifyAckDeadlineSettings(), this.channel, this.executor);
    this.acknowledgeCallable =
        UnaryCallable.create(settings.acknowledgeSettings(), this.channel, this.executor);
    this.pullCallable = UnaryCallable.create(settings.pullSettings(), this.channel, this.executor);
    this.streamingPullCallable =
        StreamingCallable.create(settings.streamingPullSettings(), this.channel);
    this.modifyPushConfigCallable =
        UnaryCallable.create(settings.modifyPushConfigSettings(), this.channel, this.executor);
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

  public final SubscriberSettings getSettings() {
    return settings;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a subscription to a given topic. If the subscription already exists, returns
   * `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name
   * format](https://cloud.google.com/pubsub/docs/overview#names). The generated name is populated
   * in the returned Subscription object. Note that for REST API requests, you must specify a name
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName name = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   TopicName topic = TopicName.create("[PROJECT]", "[TOPIC]");
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   int ackDeadlineSeconds = 0;
   *   Subscription response = subscriberClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
   * }
   * </code></pre>
   *
   * @param name The name of the subscription. It must have the format
   *     `"projects/{project}/subscriptions/{subscription}"`. `{subscription}` must start with a
   *     letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores
   *     (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3
   *     and 255 characters in length, and it must not start with `"goog"`.
   * @param topic The name of the topic from which this subscription is receiving messages. Format
   *     is `projects/{project}/topics/{topic}`. The value of this field will be `_deleted-topic_`
   *     if the topic has been deleted.
   * @param pushConfig If push delivery is used with this subscription, this field is used to
   *     configure it. An empty `pushConfig` signifies that the subscriber will pull and ack
   *     messages using API methods.
   * @param ackDeadlineSeconds This value is the maximum time after a subscriber receives a message
   *     before the subscriber should acknowledge the message. After message delivery but before the
   *     ack deadline expires and before the message is acknowledged, it is an outstanding message
   *     and will not be delivered again during that time (on a best-effort basis).
   *     <p>For pull subscriptions, this value is used as the initial value for the ack deadline. To
   *     override this value for a given message, call `ModifyAckDeadline` with the corresponding
   *     `ack_id` if using pull. The minimum custom deadline you can specify is 10 seconds. The
   *     maximum custom deadline you can specify is 600 seconds (10 minutes). If this parameter is
   *     0, a default value of 10 seconds is used.
   *     <p>For push delivery, this value is also used to set the request timeout for the call to
   *     the push endpoint.
   *     <p>If the subscriber never acknowledges the message, the Pub/Sub system will eventually
   *     redeliver the message.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Subscription createSubscription(
      SubscriptionName name, TopicName topic, PushConfig pushConfig, int ackDeadlineSeconds) {

    Subscription request =
        Subscription.newBuilder()
            .setNameWithSubscriptionName(name)
            .setTopicWithTopicNameOneof(topic == null ? null : TopicNameOneof.from(topic))
            .setPushConfig(pushConfig)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    return createSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a subscription to a given topic. If the subscription already exists, returns
   * `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name
   * format](https://cloud.google.com/pubsub/docs/overview#names). The generated name is populated
   * in the returned Subscription object. Note that for REST API requests, you must specify a name
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName name = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   TopicNameOneof topic = TopicNameOneof.from(TopicName.create("[PROJECT]", "[TOPIC]"));
   *   Subscription request = Subscription.newBuilder()
   *     .setNameWithSubscriptionName(name)
   *     .setTopicWithTopicName(topic)
   *     .build();
   *   Subscription response = subscriberClient.createSubscription(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Subscription createSubscription(Subscription request) {
    return createSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a subscription to a given topic. If the subscription already exists, returns
   * `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name
   * format](https://cloud.google.com/pubsub/docs/overview#names). The generated name is populated
   * in the returned Subscription object. Note that for REST API requests, you must specify a name
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName name = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   TopicNameOneof topic = TopicNameOneof.from(TopicName.create("[PROJECT]", "[TOPIC]"));
   *   Subscription request = Subscription.newBuilder()
   *     .setNameWithSubscriptionName(name)
   *     .setTopicWithTopicName(topic)
   *     .build();
   *   RpcFuture&lt;Subscription&gt; future = subscriberClient.createSubscriptionCallable().futureCall(request);
   *   // Do something
   *   Subscription response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<Subscription, Subscription> createSubscriptionCallable() {
    return createSubscriptionCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the configuration details of a subscription.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   Subscription response = subscriberClient.getSubscription(subscription);
   * }
   * </code></pre>
   *
   * @param subscription The name of the subscription to get. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final Subscription getSubscription(SubscriptionName subscription) {

    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder()
            .setSubscriptionWithSubscriptionName(subscription)
            .build();
    return getSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the configuration details of a subscription.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   GetSubscriptionRequest request = GetSubscriptionRequest.newBuilder()
   *     .setSubscriptionWithSubscriptionName(subscription)
   *     .build();
   *   Subscription response = subscriberClient.getSubscription(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final Subscription getSubscription(GetSubscriptionRequest request) {
    return getSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the configuration details of a subscription.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   GetSubscriptionRequest request = GetSubscriptionRequest.newBuilder()
   *     .setSubscriptionWithSubscriptionName(subscription)
   *     .build();
   *   RpcFuture&lt;Subscription&gt; future = subscriberClient.getSubscriptionCallable().futureCall(request);
   *   // Do something
   *   Subscription response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    return getSubscriptionCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching subscriptions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   ProjectName project = ProjectName.create("[PROJECT]");
   *   for (Subscription element : subscriberClient.listSubscriptions(project).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project The name of the cloud project that subscriptions belong to. Format is
   *     `projects/{project}`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListSubscriptionsPagedResponse listSubscriptions(ProjectName project) {
    ListSubscriptionsRequest request =
        ListSubscriptionsRequest.newBuilder().setProjectWithProjectName(project).build();
    return listSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching subscriptions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   ProjectName project = ProjectName.create("[PROJECT]");
   *   ListSubscriptionsRequest request = ListSubscriptionsRequest.newBuilder()
   *     .setProjectWithProjectName(project)
   *     .build();
   *   for (Subscription element : subscriberClient.listSubscriptions(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListSubscriptionsPagedResponse listSubscriptions(ListSubscriptionsRequest request) {
    return listSubscriptionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching subscriptions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   ProjectName project = ProjectName.create("[PROJECT]");
   *   ListSubscriptionsRequest request = ListSubscriptionsRequest.newBuilder()
   *     .setProjectWithProjectName(project)
   *     .build();
   *   RpcFuture&lt;ListSubscriptionsPagedResponse&gt; future = subscriberClient.listSubscriptionsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Subscription element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable() {
    return listSubscriptionsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists matching subscriptions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   ProjectName project = ProjectName.create("[PROJECT]");
   *   ListSubscriptionsRequest request = ListSubscriptionsRequest.newBuilder()
   *     .setProjectWithProjectName(project)
   *     .build();
   *   while (true) {
   *     ListSubscriptionsResponse response = subscriberClient.listSubscriptionsCallable().call(request);
   *     for (Subscription element : response.getSubscriptionsList()) {
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
  public final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    return listSubscriptionsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an existing subscription. All messages retained in the subscription are immediately
   * dropped. Calls to `Pull` after deletion will return `NOT_FOUND`. After a subscription is
   * deleted, a new one may be created with the same name, but the new one has no association with
   * the old subscription or its topic unless the same topic is specified.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   subscriberClient.deleteSubscription(subscription);
   * }
   * </code></pre>
   *
   * @param subscription The subscription to delete. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteSubscription(SubscriptionName subscription) {

    DeleteSubscriptionRequest request =
        DeleteSubscriptionRequest.newBuilder()
            .setSubscriptionWithSubscriptionName(subscription)
            .build();
    deleteSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an existing subscription. All messages retained in the subscription are immediately
   * dropped. Calls to `Pull` after deletion will return `NOT_FOUND`. After a subscription is
   * deleted, a new one may be created with the same name, but the new one has no association with
   * the old subscription or its topic unless the same topic is specified.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   DeleteSubscriptionRequest request = DeleteSubscriptionRequest.newBuilder()
   *     .setSubscriptionWithSubscriptionName(subscription)
   *     .build();
   *   subscriberClient.deleteSubscription(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final void deleteSubscription(DeleteSubscriptionRequest request) {
    deleteSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an existing subscription. All messages retained in the subscription are immediately
   * dropped. Calls to `Pull` after deletion will return `NOT_FOUND`. After a subscription is
   * deleted, a new one may be created with the same name, but the new one has no association with
   * the old subscription or its topic unless the same topic is specified.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   DeleteSubscriptionRequest request = DeleteSubscriptionRequest.newBuilder()
   *     .setSubscriptionWithSubscriptionName(subscription)
   *     .build();
   *   RpcFuture&lt;Void&gt; future = subscriberClient.deleteSubscriptionCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable() {
    return deleteSubscriptionCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the ack deadline for a specific message. This method is useful to indicate that more
   * time is needed to process a message by the subscriber, or to make the message available for
   * redelivery if the processing was interrupted. Note that this does not modify the
   * subscription-level `ackDeadlineSeconds` used for subsequent messages.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   List&lt;String&gt; ackIds = new ArrayList&lt;&gt;();
   *   int ackDeadlineSeconds = 0;
   *   subscriberClient.modifyAckDeadline(subscription, ackIds, ackDeadlineSeconds);
   * }
   * </code></pre>
   *
   * @param subscription The name of the subscription. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param ackIds List of acknowledgment IDs.
   * @param ackDeadlineSeconds The new ack deadline with respect to the time this request was sent
   *     to the Pub/Sub system. For example, if the value is 10, the new ack deadline will expire 10
   *     seconds after the `ModifyAckDeadline` call was made. Specifying zero may immediately make
   *     the message available for another pull request. The minimum deadline you can specify is 0
   *     seconds. The maximum deadline you can specify is 600 seconds (10 minutes).
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void modifyAckDeadline(
      SubscriptionName subscription, List<String> ackIds, int ackDeadlineSeconds) {

    ModifyAckDeadlineRequest request =
        ModifyAckDeadlineRequest.newBuilder()
            .setSubscriptionWithSubscriptionName(subscription)
            .addAllAckIds(ackIds)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    modifyAckDeadline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the ack deadline for a specific message. This method is useful to indicate that more
   * time is needed to process a message by the subscriber, or to make the message available for
   * redelivery if the processing was interrupted. Note that this does not modify the
   * subscription-level `ackDeadlineSeconds` used for subsequent messages.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   List&lt;String&gt; ackIds = new ArrayList&lt;&gt;();
   *   int ackDeadlineSeconds = 0;
   *   ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
   *     .setSubscriptionWithSubscriptionName(subscription)
   *     .addAllAckIds(ackIds)
   *     .setAckDeadlineSeconds(ackDeadlineSeconds)
   *     .build();
   *   subscriberClient.modifyAckDeadline(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void modifyAckDeadline(ModifyAckDeadlineRequest request) {
    modifyAckDeadlineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the ack deadline for a specific message. This method is useful to indicate that more
   * time is needed to process a message by the subscriber, or to make the message available for
   * redelivery if the processing was interrupted. Note that this does not modify the
   * subscription-level `ackDeadlineSeconds` used for subsequent messages.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   List&lt;String&gt; ackIds = new ArrayList&lt;&gt;();
   *   int ackDeadlineSeconds = 0;
   *   ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
   *     .setSubscriptionWithSubscriptionName(subscription)
   *     .addAllAckIds(ackIds)
   *     .setAckDeadlineSeconds(ackDeadlineSeconds)
   *     .build();
   *   RpcFuture&lt;Void&gt; future = subscriberClient.modifyAckDeadlineCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineCallable() {
    return modifyAckDeadlineCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Acknowledges the messages associated with the `ack_ids` in the `AcknowledgeRequest`. The
   * Pub/Sub system can remove the relevant messages from the subscription.
   *
   * <p>Acknowledging a message whose ack deadline has expired may succeed, but such a message may
   * be redelivered later. Acknowledging a message more than once will not result in an error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   List&lt;String&gt; ackIds = new ArrayList&lt;&gt;();
   *   subscriberClient.acknowledge(subscription, ackIds);
   * }
   * </code></pre>
   *
   * @param subscription The subscription whose message is being acknowledged. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param ackIds The acknowledgment ID for the messages being acknowledged that was returned by
   *     the Pub/Sub system in the `Pull` response. Must not be empty.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void acknowledge(SubscriptionName subscription, List<String> ackIds) {

    AcknowledgeRequest request =
        AcknowledgeRequest.newBuilder()
            .setSubscriptionWithSubscriptionName(subscription)
            .addAllAckIds(ackIds)
            .build();
    acknowledge(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Acknowledges the messages associated with the `ack_ids` in the `AcknowledgeRequest`. The
   * Pub/Sub system can remove the relevant messages from the subscription.
   *
   * <p>Acknowledging a message whose ack deadline has expired may succeed, but such a message may
   * be redelivered later. Acknowledging a message more than once will not result in an error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   List&lt;String&gt; ackIds = new ArrayList&lt;&gt;();
   *   AcknowledgeRequest request = AcknowledgeRequest.newBuilder()
   *     .setSubscriptionWithSubscriptionName(subscription)
   *     .addAllAckIds(ackIds)
   *     .build();
   *   subscriberClient.acknowledge(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void acknowledge(AcknowledgeRequest request) {
    acknowledgeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Acknowledges the messages associated with the `ack_ids` in the `AcknowledgeRequest`. The
   * Pub/Sub system can remove the relevant messages from the subscription.
   *
   * <p>Acknowledging a message whose ack deadline has expired may succeed, but such a message may
   * be redelivered later. Acknowledging a message more than once will not result in an error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   List&lt;String&gt; ackIds = new ArrayList&lt;&gt;();
   *   AcknowledgeRequest request = AcknowledgeRequest.newBuilder()
   *     .setSubscriptionWithSubscriptionName(subscription)
   *     .addAllAckIds(ackIds)
   *     .build();
   *   RpcFuture&lt;Void&gt; future = subscriberClient.acknowledgeCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AcknowledgeRequest, Empty> acknowledgeCallable() {
    return acknowledgeCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Pulls messages from the server. Returns an empty list if there are no messages available in the
   * backlog. The server may return `UNAVAILABLE` if there are too many concurrent pull requests
   * pending for the given subscription.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   boolean returnImmediately = false;
   *   int maxMessages = 0;
   *   PullResponse response = subscriberClient.pull(subscription, returnImmediately, maxMessages);
   * }
   * </code></pre>
   *
   * @param subscription The subscription from which messages should be pulled. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param returnImmediately If this field set to true, the system will respond immediately even if
   *     it there are no messages available to return in the `Pull` response. Otherwise, the system
   *     may wait (for a bounded amount of time) until at least one message is available, rather
   *     than returning no messages. The client may cancel the request if it does not wish to wait
   *     any longer for the response.
   * @param maxMessages The maximum number of messages returned for this request. The Pub/Sub system
   *     may return fewer than the number specified.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PullResponse pull(
      SubscriptionName subscription, boolean returnImmediately, int maxMessages) {

    PullRequest request =
        PullRequest.newBuilder()
            .setSubscriptionWithSubscriptionName(subscription)
            .setReturnImmediately(returnImmediately)
            .setMaxMessages(maxMessages)
            .build();
    return pull(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Pulls messages from the server. Returns an empty list if there are no messages available in the
   * backlog. The server may return `UNAVAILABLE` if there are too many concurrent pull requests
   * pending for the given subscription.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   int maxMessages = 0;
   *   PullRequest request = PullRequest.newBuilder()
   *     .setSubscriptionWithSubscriptionName(subscription)
   *     .setMaxMessages(maxMessages)
   *     .build();
   *   PullResponse response = subscriberClient.pull(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PullResponse pull(PullRequest request) {
    return pullCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Pulls messages from the server. Returns an empty list if there are no messages available in the
   * backlog. The server may return `UNAVAILABLE` if there are too many concurrent pull requests
   * pending for the given subscription.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   int maxMessages = 0;
   *   PullRequest request = PullRequest.newBuilder()
   *     .setSubscriptionWithSubscriptionName(subscription)
   *     .setMaxMessages(maxMessages)
   *     .build();
   *   RpcFuture&lt;PullResponse&gt; future = subscriberClient.pullCallable().futureCall(request);
   *   // Do something
   *   PullResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PullRequest, PullResponse> pullCallable() {
    return pullCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * (EXPERIMENTAL) StreamingPull is an experimental feature. This RPC will respond with
   * UNIMPLEMENTED errors unless you have been invited to test this feature. Contact
   * cloud-pubsub{@literal @}google.com with any questions.
   *
   * <p>Establishes a stream with the server, which sends messages down to the client. The client
   * streams acknowledgements and ack deadline modifications back to the server. The server will
   * close the stream and return the status on any error. The server may close the stream with
   * status `OK` to reassign server-side resources, in which case, the client should re-establish
   * the stream. `UNAVAILABLE` may also be returned in the case of a transient error (e.g., a server
   * restart). These should also be retried by the client. Flow control can be achieved by
   * configuring the underlying RPC channel.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   RpcStreamObserver&lt;StreamingPullResponse&gt; responseObserver =
   *       new RpcStreamObserver&lt;StreamingPullResponse&gt;() {
   *         {@literal @}Override
   *         public void onNext(StreamingPullResponse response) {
   *           // Do something when receive a response
   *         }
   *
   *         {@literal @}Override
   *         public void onError(Throwable t) {
   *           // Add error-handling
   *         }
   *
   *         {@literal @}Override
   *         public void onCompleted() {
   *           // Do something when complete.
   *         }
   *       };
   *   RpcStreamObserver&lt;StreamingRecognizeRequest&gt; requestObserver =
   *       subscriberClient.streamingPullCallable().bidiStreamingCall(responseObserver)});
   *
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   int streamAckDeadlineSeconds = 0;
   *   StreamingPullRequest request = StreamingPullRequest.newBuilder()
   *     .setSubscriptionWithSubscriptionName(subscription)
   *     .setStreamAckDeadlineSeconds(streamAckDeadlineSeconds)
   *     .build();
   *   requestObserver.onNext(request);
   * }
   * </code></pre>
   */
  /* package-private */ final StreamingCallable<StreamingPullRequest, StreamingPullResponse>
      streamingPullCallable() {
    return streamingPullCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the `PushConfig` for a specified subscription.
   *
   * <p>This may be used to change a push subscription to a pull one (signified by an empty
   * `PushConfig`) or vice versa, or change the endpoint URL and other attributes of a push
   * subscription. Messages will accumulate for delivery continuously through the call regardless of
   * changes to the `PushConfig`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   subscriberClient.modifyPushConfig(subscription, pushConfig);
   * }
   * </code></pre>
   *
   * @param subscription The name of the subscription. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param pushConfig The push configuration for future deliveries.
   *     <p>An empty `pushConfig` indicates that the Pub/Sub system should stop pushing messages
   *     from the given subscription and allow messages to be pulled and acknowledged - effectively
   *     pausing the subscription if `Pull` is not called.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void modifyPushConfig(SubscriptionName subscription, PushConfig pushConfig) {

    ModifyPushConfigRequest request =
        ModifyPushConfigRequest.newBuilder()
            .setSubscriptionWithSubscriptionName(subscription)
            .setPushConfig(pushConfig)
            .build();
    modifyPushConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the `PushConfig` for a specified subscription.
   *
   * <p>This may be used to change a push subscription to a pull one (signified by an empty
   * `PushConfig`) or vice versa, or change the endpoint URL and other attributes of a push
   * subscription. Messages will accumulate for delivery continuously through the call regardless of
   * changes to the `PushConfig`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   ModifyPushConfigRequest request = ModifyPushConfigRequest.newBuilder()
   *     .setSubscriptionWithSubscriptionName(subscription)
   *     .setPushConfig(pushConfig)
   *     .build();
   *   subscriberClient.modifyPushConfig(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void modifyPushConfig(ModifyPushConfigRequest request) {
    modifyPushConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the `PushConfig` for a specified subscription.
   *
   * <p>This may be used to change a push subscription to a pull one (signified by an empty
   * `PushConfig`) or vice versa, or change the endpoint URL and other attributes of a push
   * subscription. Messages will accumulate for delivery continuously through the call regardless of
   * changes to the `PushConfig`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]");
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   ModifyPushConfigRequest request = ModifyPushConfigRequest.newBuilder()
   *     .setSubscriptionWithSubscriptionName(subscription)
   *     .setPushConfig(pushConfig)
   *     .build();
   *   RpcFuture&lt;Void&gt; future = subscriberClient.modifyPushConfigCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ModifyPushConfigRequest, Empty> modifyPushConfigCallable() {
    return modifyPushConfigCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   String formattedResource = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = subscriberClient.setIamPolicy(formattedResource, policy);
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
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   String formattedResource = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   Policy response = subscriberClient.setIamPolicy(request);
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
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   String formattedResource = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   RpcFuture&lt;Policy&gt; future = subscriberClient.setIamPolicyCallable().futureCall(request);
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
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   String formattedResource = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   Policy response = subscriberClient.getIamPolicy(formattedResource);
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
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   String formattedResource = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = subscriberClient.getIamPolicy(request);
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
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   String formattedResource = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   RpcFuture&lt;Policy&gt; future = subscriberClient.getIamPolicyCallable().futureCall(request);
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
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   String formattedResource = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = subscriberClient.testIamPermissions(formattedResource, permissions);
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
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   String formattedResource = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   TestIamPermissionsResponse response = subscriberClient.testIamPermissions(request);
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
   * try (SubscriberClient subscriberClient = SubscriberClient.create()) {
   *   String formattedResource = SubscriptionName.create("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   RpcFuture&lt;TestIamPermissionsResponse&gt; future = subscriberClient.testIamPermissionsCallable().futureCall(request);
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

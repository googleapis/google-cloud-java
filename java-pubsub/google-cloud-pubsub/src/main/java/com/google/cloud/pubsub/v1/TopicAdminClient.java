/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsub.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.pubsub.v1.stub.PublisherStub;
import com.google.cloud.pubsub.v1.stub.PublisherStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.DetachSubscriptionRequest;
import com.google.pubsub.v1.DetachSubscriptionResponse;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSnapshotsRequest;
import com.google.pubsub.v1.ListTopicSnapshotsResponse;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import com.google.pubsub.v1.UpdateTopicRequest;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The service that an application uses to manipulate topics, and to send
 * messages to a topic.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
 *   TopicName name = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
 *   Topic response = topicAdminClient.createTopic(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TopicAdminClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTopic</td>
 *      <td><p> Creates the given topic with the given name. See the [resource name rules] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTopic(Topic request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTopic(TopicName name)
 *           <li><p> createTopic(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTopicCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTopic</td>
 *      <td><p> Updates an existing topic by updating the fields specified in the update mask. Note that certain properties of a topic are not modifiable.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTopic(UpdateTopicRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTopic(Topic topic, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTopicCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Publish</td>
 *      <td><p> Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> publish(PublishRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> publish(TopicName topic, List&lt;PubsubMessage&gt; messages)
 *           <li><p> publish(String topic, List&lt;PubsubMessage&gt; messages)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> publishCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTopic</td>
 *      <td><p> Gets the configuration of a topic.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTopic(GetTopicRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTopic(TopicName topic)
 *           <li><p> getTopic(String topic)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTopicCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTopics</td>
 *      <td><p> Lists matching topics.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTopics(ListTopicsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTopics(ProjectName project)
 *           <li><p> listTopics(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTopicsPagedCallable()
 *           <li><p> listTopicsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTopicSubscriptions</td>
 *      <td><p> Lists the names of the attached subscriptions on this topic.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTopicSubscriptions(ListTopicSubscriptionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTopicSubscriptions(TopicName topic)
 *           <li><p> listTopicSubscriptions(String topic)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTopicSubscriptionsPagedCallable()
 *           <li><p> listTopicSubscriptionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTopicSnapshots</td>
 *      <td><p> Lists the names of the snapshots on this topic. Snapshots are used in [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTopicSnapshots(ListTopicSnapshotsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTopicSnapshots(TopicName topic)
 *           <li><p> listTopicSnapshots(String topic)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTopicSnapshotsPagedCallable()
 *           <li><p> listTopicSnapshotsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTopic</td>
 *      <td><p> Deletes the topic with the given name. Returns `NOT_FOUND` if the topic does not exist. After a topic is deleted, a new topic may be created with the same name; this is an entirely new topic with none of the old configuration or subscriptions. Existing subscriptions to this topic are not deleted, but their `topic` field is set to `_deleted-topic_`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTopic(DeleteTopicRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTopic(TopicName topic)
 *           <li><p> deleteTopic(String topic)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTopicCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DetachSubscription</td>
 *      <td><p> Detaches a subscription from this topic. All messages retained in the subscription are dropped. Subsequent `Pull` and `StreamingPull` requests will return FAILED_PRECONDITION. If the subscription is a push subscription, pushes to the endpoint will stop.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> detachSubscription(DetachSubscriptionRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> detachSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TopicAdminSettings topicAdminSettings =
 *     TopicAdminSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TopicAdminClient topicAdminClient = TopicAdminClient.create(topicAdminSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TopicAdminSettings topicAdminSettings =
 *     TopicAdminSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TopicAdminClient topicAdminClient = TopicAdminClient.create(topicAdminSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TopicAdminSettings topicAdminSettings = TopicAdminSettings.newHttpJsonBuilder().build();
 * TopicAdminClient topicAdminClient = TopicAdminClient.create(topicAdminSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
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
   * advanced usage - prefer using create(TopicAdminSettings).
   */
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

  protected TopicAdminClient(PublisherStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TopicAdminSettings getSettings() {
    return settings;
  }

  public PublisherStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the given topic with the given name. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   TopicName name = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
   *   Topic response = topicAdminClient.createTopic(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the topic. It must have the format
   *     `"projects/{project}/topics/{topic}"`. `{topic}` must start with a letter, and contain only
   *     letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores (`_`), periods (`.`),
   *     tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3 and 255 characters in
   *     length, and it must not start with `"goog"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic createTopic(TopicName name) {
    Topic request = Topic.newBuilder().setName(name == null ? null : name.toString()).build();
    return createTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the given topic with the given name. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String name = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString();
   *   Topic response = topicAdminClient.createTopic(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the topic. It must have the format
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
   *   Topic response = topicAdminClient.createTopic(name);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the topic. It must have the format
   *     `"projects/{project}/topics/{topic}"`. `{topic}` must start with a letter, and contain only
   *     letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores (`_`), periods (`.`),
   *     tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3 and 255 characters in
   *     length, and it must not start with `"goog"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #createTopic(TopicName)} instead.
   */
  @Deprecated
  public final Topic createTopic(ProjectTopicName name) {
    Topic request = Topic.newBuilder().setName(name == null ? null : name.toString()).build();
    return createTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the given topic with the given name. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   Topic request =
   *       Topic.newBuilder()
   *           .setName(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .putAllLabels(new HashMap<String, String>())
   *           .setMessageStoragePolicy(MessageStoragePolicy.newBuilder().build())
   *           .setKmsKeyName("kmsKeyName412586233")
   *           .setSchemaSettings(SchemaSettings.newBuilder().build())
   *           .setSatisfiesPzs(true)
   *           .setMessageRetentionDuration(Duration.newBuilder().build())
   *           .setIngestionDataSourceSettings(IngestionDataSourceSettings.newBuilder().build())
   *           .build();
   *   Topic response = topicAdminClient.createTopic(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic createTopic(Topic request) {
    return createTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the given topic with the given name. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   Topic request =
   *       Topic.newBuilder()
   *           .setName(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .putAllLabels(new HashMap<String, String>())
   *           .setMessageStoragePolicy(MessageStoragePolicy.newBuilder().build())
   *           .setKmsKeyName("kmsKeyName412586233")
   *           .setSchemaSettings(SchemaSettings.newBuilder().build())
   *           .setSatisfiesPzs(true)
   *           .setMessageRetentionDuration(Duration.newBuilder().build())
   *           .setIngestionDataSourceSettings(IngestionDataSourceSettings.newBuilder().build())
   *           .build();
   *   ApiFuture<Topic> future = topicAdminClient.createTopicCallable().futureCall(request);
   *   // Do something.
   *   Topic response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<Topic, Topic> createTopicCallable() {
    return stub.createTopicCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing topic by updating the fields specified in the update mask. Note that
   * certain properties of a topic are not modifiable.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   Topic topic = Topic.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Topic response = topicAdminClient.updateTopic(topic, updateMask);
   * }
   * }</pre>
   *
   * @param topic Required. The updated topic object.
   * @param updateMask Required. Indicates which fields in the provided topic to update. Must be
   *     specified and non-empty. Note that if `update_mask` contains "message_storage_policy" but
   *     the `message_storage_policy` is not set in the `topic` provided above, then the updated
   *     value is determined by the policy configured at the project or organization level.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic updateTopic(Topic topic, FieldMask updateMask) {
    UpdateTopicRequest request =
        UpdateTopicRequest.newBuilder().setTopic(topic).setUpdateMask(updateMask).build();
    return updateTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing topic by updating the fields specified in the update mask. Note that
   * certain properties of a topic are not modifiable.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   UpdateTopicRequest request =
   *       UpdateTopicRequest.newBuilder()
   *           .setTopic(Topic.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Topic response = topicAdminClient.updateTopic(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic updateTopic(UpdateTopicRequest request) {
    return updateTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing topic by updating the fields specified in the update mask. Note that
   * certain properties of a topic are not modifiable.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   UpdateTopicRequest request =
   *       UpdateTopicRequest.newBuilder()
   *           .setTopic(Topic.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Topic> future = topicAdminClient.updateTopicCallable().futureCall(request);
   *   // Do something.
   *   Topic response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTopicRequest, Topic> updateTopicCallable() {
    return stub.updateTopicCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
   *   List<PubsubMessage> messages = new ArrayList<>();
   *   PublishResponse response = topicAdminClient.publish(topic, messages);
   * }
   * }</pre>
   *
   * @param topic Required. The messages in the request will be published on this topic. Format is
   *     `projects/{project}/topics/{topic}`.
   * @param messages Required. The messages to publish.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublishResponse publish(TopicName topic, List<PubsubMessage> messages) {
    PublishRequest request =
        PublishRequest.newBuilder()
            .setTopic(topic == null ? null : topic.toString())
            .addAllMessages(messages)
            .build();
    return publish(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString();
   *   List<PubsubMessage> messages = new ArrayList<>();
   *   PublishResponse response = topicAdminClient.publish(topic, messages);
   * }
   * }</pre>
   *
   * @param topic Required. The messages in the request will be published on this topic. Format is
   *     `projects/{project}/topics/{topic}`.
   * @param messages Required. The messages to publish.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublishResponse publish(String topic, List<PubsubMessage> messages) {
    PublishRequest request =
        PublishRequest.newBuilder().setTopic(topic).addAllMessages(messages).build();
    return publish(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   PublishRequest request =
   *       PublishRequest.newBuilder()
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .addAllMessages(new ArrayList<PubsubMessage>())
   *           .build();
   *   PublishResponse response = topicAdminClient.publish(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublishResponse publish(PublishRequest request) {
    return publishCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   PublishRequest request =
   *       PublishRequest.newBuilder()
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .addAllMessages(new ArrayList<PubsubMessage>())
   *           .build();
   *   ApiFuture<PublishResponse> future = topicAdminClient.publishCallable().futureCall(request);
   *   // Do something.
   *   PublishResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PublishRequest, PublishResponse> publishCallable() {
    return stub.publishCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration of a topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
   *   Topic response = topicAdminClient.getTopic(topic);
   * }
   * }</pre>
   *
   * @param topic Required. The name of the topic to get. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic getTopic(TopicName topic) {
    GetTopicRequest request =
        GetTopicRequest.newBuilder().setTopic(topic == null ? null : topic.toString()).build();
    return getTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration of a topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString();
   *   Topic response = topicAdminClient.getTopic(topic);
   * }
   * }</pre>
   *
   * @param topic Required. The name of the topic to get. Format is
   *     `projects/{project}/topics/{topic}`.
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
   *   Topic response = topicAdminClient.getTopic(topic);
   * }
   * </code></pre>
   *
   * @param topic Required. The name of the topic to get. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #getTopic(TopicName)} instead.
   */
  @Deprecated
  public final Topic getTopic(ProjectTopicName topic) {
    GetTopicRequest request =
        GetTopicRequest.newBuilder().setTopic(topic == null ? null : topic.toString()).build();
    return getTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration of a topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   GetTopicRequest request =
   *       GetTopicRequest.newBuilder()
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .build();
   *   Topic response = topicAdminClient.getTopic(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic getTopic(GetTopicRequest request) {
    return getTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration of a topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   GetTopicRequest request =
   *       GetTopicRequest.newBuilder()
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .build();
   *   ApiFuture<Topic> future = topicAdminClient.getTopicCallable().futureCall(request);
   *   // Do something.
   *   Topic response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTopicRequest, Topic> getTopicCallable() {
    return stub.getTopicCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists matching topics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Topic element : topicAdminClient.listTopics(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Required. The name of the project in which to list topics. Format is
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists matching topics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String project = ProjectName.of("[PROJECT]").toString();
   *   for (Topic element : topicAdminClient.listTopics(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Required. The name of the project in which to list topics. Format is
   *     `projects/{project-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicsPagedResponse listTopics(String project) {
    ListTopicsRequest request = ListTopicsRequest.newBuilder().setProject(project).build();
    return listTopics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists matching topics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ListTopicsRequest request =
   *       ListTopicsRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Topic element : topicAdminClient.listTopics(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicsPagedResponse listTopics(ListTopicsRequest request) {
    return listTopicsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists matching topics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ListTopicsRequest request =
   *       ListTopicsRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Topic> future = topicAdminClient.listTopicsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Topic element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTopicsRequest, ListTopicsPagedResponse> listTopicsPagedCallable() {
    return stub.listTopicsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists matching topics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ListTopicsRequest request =
   *       ListTopicsRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
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
   * }</pre>
   */
  public final UnaryCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable() {
    return stub.listTopicsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the names of the attached subscriptions on this topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
   *   for (String element : topicAdminClient.listTopicSubscriptions(topic).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param topic Required. The name of the topic that subscriptions are attached to. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicSubscriptionsPagedResponse listTopicSubscriptions(TopicName topic) {
    ListTopicSubscriptionsRequest request =
        ListTopicSubscriptionsRequest.newBuilder()
            .setTopic(topic == null ? null : topic.toString())
            .build();
    return listTopicSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the names of the attached subscriptions on this topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString();
   *   for (String element : topicAdminClient.listTopicSubscriptions(topic).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param topic Required. The name of the topic that subscriptions are attached to. Format is
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
   *   for (ProjectSubscriptionName element : topicAdminClient.listTopicSubscriptions(topic).iterateAllAsProjectSubscriptionName()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param topic Required. The name of the topic that subscriptions are attached to. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #listTopicSubscriptions(TopicName)} instead.
   */
  @Deprecated
  public final ListTopicSubscriptionsPagedResponse listTopicSubscriptions(ProjectTopicName topic) {
    ListTopicSubscriptionsRequest request =
        ListTopicSubscriptionsRequest.newBuilder()
            .setTopic(topic == null ? null : topic.toString())
            .build();
    return listTopicSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the names of the attached subscriptions on this topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ListTopicSubscriptionsRequest request =
   *       ListTopicSubscriptionsRequest.newBuilder()
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (String element : topicAdminClient.listTopicSubscriptions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicSubscriptionsPagedResponse listTopicSubscriptions(
      ListTopicSubscriptionsRequest request) {
    return listTopicSubscriptionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the names of the attached subscriptions on this topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ListTopicSubscriptionsRequest request =
   *       ListTopicSubscriptionsRequest.newBuilder()
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<String> future =
   *       topicAdminClient.listTopicSubscriptionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsPagedCallable() {
    return stub.listTopicSubscriptionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the names of the attached subscriptions on this topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ListTopicSubscriptionsRequest request =
   *       ListTopicSubscriptionsRequest.newBuilder()
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTopicSubscriptionsResponse response =
   *         topicAdminClient.listTopicSubscriptionsCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable() {
    return stub.listTopicSubscriptionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the names of the snapshots on this topic. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
   *   for (String element : topicAdminClient.listTopicSnapshots(topic).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param topic Required. The name of the topic that snapshots are attached to. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicSnapshotsPagedResponse listTopicSnapshots(TopicName topic) {
    ListTopicSnapshotsRequest request =
        ListTopicSnapshotsRequest.newBuilder()
            .setTopic(topic == null ? null : topic.toString())
            .build();
    return listTopicSnapshots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the names of the snapshots on this topic. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString();
   *   for (String element : topicAdminClient.listTopicSnapshots(topic).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param topic Required. The name of the topic that snapshots are attached to. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicSnapshotsPagedResponse listTopicSnapshots(String topic) {
    ListTopicSnapshotsRequest request =
        ListTopicSnapshotsRequest.newBuilder().setTopic(topic).build();
    return listTopicSnapshots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the names of the snapshots on this topic. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ListTopicSnapshotsRequest request =
   *       ListTopicSnapshotsRequest.newBuilder()
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (String element : topicAdminClient.listTopicSnapshots(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicSnapshotsPagedResponse listTopicSnapshots(
      ListTopicSnapshotsRequest request) {
    return listTopicSnapshotsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the names of the snapshots on this topic. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ListTopicSnapshotsRequest request =
   *       ListTopicSnapshotsRequest.newBuilder()
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<String> future =
   *       topicAdminClient.listTopicSnapshotsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTopicSnapshotsRequest, ListTopicSnapshotsPagedResponse>
      listTopicSnapshotsPagedCallable() {
    return stub.listTopicSnapshotsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the names of the snapshots on this topic. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ListTopicSnapshotsRequest request =
   *       ListTopicSnapshotsRequest.newBuilder()
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTopicSnapshotsResponse response =
   *         topicAdminClient.listTopicSnapshotsCallable().call(request);
   *     for (String element : response.getSnapshotsList()) {
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
   * }</pre>
   */
  public final UnaryCallable<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse>
      listTopicSnapshotsCallable() {
    return stub.listTopicSnapshotsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic does not exist. After a
   * topic is deleted, a new topic may be created with the same name; this is an entirely new topic
   * with none of the old configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
   *   topicAdminClient.deleteTopic(topic);
   * }
   * }</pre>
   *
   * @param topic Required. Name of the topic to delete. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTopic(TopicName topic) {
    DeleteTopicRequest request =
        DeleteTopicRequest.newBuilder().setTopic(topic == null ? null : topic.toString()).build();
    deleteTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic does not exist. After a
   * topic is deleted, a new topic may be created with the same name; this is an entirely new topic
   * with none of the old configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString();
   *   topicAdminClient.deleteTopic(topic);
   * }
   * }</pre>
   *
   * @param topic Required. Name of the topic to delete. Format is
   *     `projects/{project}/topics/{topic}`.
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
   *   topicAdminClient.deleteTopic(topic);
   * }
   * </code></pre>
   *
   * @param topic Required. Name of the topic to delete. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #deleteTopic(TopicName)} instead.
   */
  @Deprecated
  public final void deleteTopic(ProjectTopicName topic) {
    DeleteTopicRequest request =
        DeleteTopicRequest.newBuilder().setTopic(topic == null ? null : topic.toString()).build();
    deleteTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic does not exist. After a
   * topic is deleted, a new topic may be created with the same name; this is an entirely new topic
   * with none of the old configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   DeleteTopicRequest request =
   *       DeleteTopicRequest.newBuilder()
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .build();
   *   topicAdminClient.deleteTopic(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTopic(DeleteTopicRequest request) {
    deleteTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic does not exist. After a
   * topic is deleted, a new topic may be created with the same name; this is an entirely new topic
   * with none of the old configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   DeleteTopicRequest request =
   *       DeleteTopicRequest.newBuilder()
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .build();
   *   ApiFuture<Empty> future = topicAdminClient.deleteTopicCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    return stub.deleteTopicCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detaches a subscription from this topic. All messages retained in the subscription are dropped.
   * Subsequent `Pull` and `StreamingPull` requests will return FAILED_PRECONDITION. If the
   * subscription is a push subscription, pushes to the endpoint will stop.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   DetachSubscriptionRequest request =
   *       DetachSubscriptionRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   DetachSubscriptionResponse response = topicAdminClient.detachSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetachSubscriptionResponse detachSubscription(DetachSubscriptionRequest request) {
    return detachSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detaches a subscription from this topic. All messages retained in the subscription are dropped.
   * Subsequent `Pull` and `StreamingPull` requests will return FAILED_PRECONDITION. If the
   * subscription is a push subscription, pushes to the endpoint will stop.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   DetachSubscriptionRequest request =
   *       DetachSubscriptionRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   ApiFuture<DetachSubscriptionResponse> future =
   *       topicAdminClient.detachSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   DetachSubscriptionResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DetachSubscriptionRequest, DetachSubscriptionResponse>
      detachSubscriptionCallable() {
    return stub.detachSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = topicAdminClient.setIamPolicy(request);
   * }
   * }</pre>
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
   * <p>Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
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
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #setIamPolicy(SetIamPolicyRequest)} instead.
   */
  @Deprecated
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = topicAdminClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = topicAdminClient.getIamPolicy(request);
   * }
   * }</pre>
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
   *   Policy response = topicAdminClient.getIamPolicy(formattedResource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #getIamPolicy(GetIamPolicyRequest)} instead.
   */
  @Deprecated
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = topicAdminClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = topicAdminClient.testIamPermissions(request);
   * }
   * }</pre>
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
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
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
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #testIamPermissions(TestIamPermissionsRequest)} instead.
   */
  @Deprecated
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       topicAdminClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
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
          futurePage, input -> new ListTopicsPagedResponse(input), MoreExecutors.directExecutor());
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
          input -> new ListTopicSubscriptionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTopicSubscriptionsPagedResponse(ListTopicSubscriptionsPage page) {
      super(page, ListTopicSubscriptionsFixedSizeCollection.createEmptyCollection());
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
  }

  public static class ListTopicSnapshotsPagedResponse
      extends AbstractPagedListResponse<
          ListTopicSnapshotsRequest,
          ListTopicSnapshotsResponse,
          String,
          ListTopicSnapshotsPage,
          ListTopicSnapshotsFixedSizeCollection> {

    public static ApiFuture<ListTopicSnapshotsPagedResponse> createAsync(
        PageContext<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse, String> context,
        ApiFuture<ListTopicSnapshotsResponse> futureResponse) {
      ApiFuture<ListTopicSnapshotsPage> futurePage =
          ListTopicSnapshotsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTopicSnapshotsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTopicSnapshotsPagedResponse(ListTopicSnapshotsPage page) {
      super(page, ListTopicSnapshotsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTopicSnapshotsPage
      extends AbstractPage<
          ListTopicSnapshotsRequest, ListTopicSnapshotsResponse, String, ListTopicSnapshotsPage> {

    private ListTopicSnapshotsPage(
        PageContext<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse, String> context,
        ListTopicSnapshotsResponse response) {
      super(context, response);
    }

    private static ListTopicSnapshotsPage createEmptyPage() {
      return new ListTopicSnapshotsPage(null, null);
    }

    @Override
    protected ListTopicSnapshotsPage createPage(
        PageContext<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse, String> context,
        ListTopicSnapshotsResponse response) {
      return new ListTopicSnapshotsPage(context, response);
    }

    @Override
    public ApiFuture<ListTopicSnapshotsPage> createPageAsync(
        PageContext<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse, String> context,
        ApiFuture<ListTopicSnapshotsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTopicSnapshotsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTopicSnapshotsRequest,
          ListTopicSnapshotsResponse,
          String,
          ListTopicSnapshotsPage,
          ListTopicSnapshotsFixedSizeCollection> {

    private ListTopicSnapshotsFixedSizeCollection(
        List<ListTopicSnapshotsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTopicSnapshotsFixedSizeCollection createEmptyCollection() {
      return new ListTopicSnapshotsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTopicSnapshotsFixedSizeCollection createCollection(
        List<ListTopicSnapshotsPage> pages, int collectionSize) {
      return new ListTopicSnapshotsFixedSizeCollection(pages, collectionSize);
    }
  }
}

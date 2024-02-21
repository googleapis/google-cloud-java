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
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.pubsub.v1.stub.SubscriberStub;
import com.google.cloud.pubsub.v1.stub.SubscriberStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.CreateSnapshotRequest;
import com.google.pubsub.v1.DeleteSnapshotRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.GetSnapshotRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.ListSnapshotsRequest;
import com.google.pubsub.v1.ListSnapshotsResponse;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.ProjectSnapshotName;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.SeekRequest;
import com.google.pubsub.v1.SeekResponse;
import com.google.pubsub.v1.Snapshot;
import com.google.pubsub.v1.SnapshotName;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;
import com.google.pubsub.v1.UpdateSnapshotRequest;
import com.google.pubsub.v1.UpdateSubscriptionRequest;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The service that an application uses to manipulate subscriptions and to
 * consume messages from a subscription via the `Pull` method or by establishing a bi-directional
 * stream using the `StreamingPull` method.
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
 * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
 *   SubscriptionName name = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
 *   TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
 *   PushConfig pushConfig = PushConfig.newBuilder().build();
 *   int ackDeadlineSeconds = 2135351438;
 *   Subscription response =
 *       subscriptionAdminClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SubscriptionAdminClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSubscription</td>
 *      <td><p> Creates a subscription to a given topic. See the [resource name rules] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). If the subscription already exists, returns `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns `NOT_FOUND`.
 * <p>  If the name is not provided in the request, the server will assign a random name for this subscription on the same project as the topic, conforming to the [resource name format] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The generated name is populated in the returned Subscription object. Note that for REST API requests, you must specify a name in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSubscription(Subscription request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSubscription(SubscriptionName name, TopicName topic, PushConfig pushConfig, int ackDeadlineSeconds)
 *           <li><p> createSubscription(SubscriptionName name, String topic, PushConfig pushConfig, int ackDeadlineSeconds)
 *           <li><p> createSubscription(String name, TopicName topic, PushConfig pushConfig, int ackDeadlineSeconds)
 *           <li><p> createSubscription(String name, String topic, PushConfig pushConfig, int ackDeadlineSeconds)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSubscription</td>
 *      <td><p> Gets the configuration details of a subscription.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSubscription(GetSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSubscription(SubscriptionName subscription)
 *           <li><p> getSubscription(String subscription)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSubscription</td>
 *      <td><p> Updates an existing subscription by updating the fields specified in the update mask. Note that certain properties of a subscription, such as its topic, are not modifiable.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSubscription(UpdateSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSubscription(Subscription subscription, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSubscriptions</td>
 *      <td><p> Lists matching subscriptions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSubscriptions(ListSubscriptionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSubscriptions(ProjectName project)
 *           <li><p> listSubscriptions(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSubscriptionsPagedCallable()
 *           <li><p> listSubscriptionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSubscription</td>
 *      <td><p> Deletes an existing subscription. All messages retained in the subscription are immediately dropped. Calls to `Pull` after deletion will return `NOT_FOUND`. After a subscription is deleted, a new one may be created with the same name, but the new one has no association with the old subscription or its topic unless the same topic is specified.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSubscription(DeleteSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSubscription(SubscriptionName subscription)
 *           <li><p> deleteSubscription(String subscription)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ModifyAckDeadline</td>
 *      <td><p> Modifies the ack deadline for a specific message. This method is useful to indicate that more time is needed to process a message by the subscriber, or to make the message available for redelivery if the processing was interrupted. Note that this does not modify the subscription-level `ackDeadlineSeconds` used for subsequent messages.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> modifyAckDeadline(ModifyAckDeadlineRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> modifyAckDeadline(SubscriptionName subscription, List&lt;String&gt; ackIds, int ackDeadlineSeconds)
 *           <li><p> modifyAckDeadline(String subscription, List&lt;String&gt; ackIds, int ackDeadlineSeconds)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> modifyAckDeadlineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Acknowledge</td>
 *      <td><p> Acknowledges the messages associated with the `ack_ids` in the `AcknowledgeRequest`. The Pub/Sub system can remove the relevant messages from the subscription.
 * <p>  Acknowledging a message whose ack deadline has expired may succeed, but such a message may be redelivered later. Acknowledging a message more than once will not result in an error.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> acknowledge(AcknowledgeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> acknowledge(SubscriptionName subscription, List&lt;String&gt; ackIds)
 *           <li><p> acknowledge(String subscription, List&lt;String&gt; ackIds)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> acknowledgeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Pull</td>
 *      <td><p> Pulls messages from the server.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> pull(PullRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> pull(SubscriptionName subscription, int maxMessages)
 *           <li><p> pull(String subscription, int maxMessages)
 *           <li><p> pull(SubscriptionName subscription, boolean returnImmediately, int maxMessages)
 *           <li><p> pull(String subscription, boolean returnImmediately, int maxMessages)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> pullCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StreamingPull</td>
 *      <td><p> Establishes a stream with the server, which sends messages down to the client. The client streams acknowledgements and ack deadline modifications back to the server. The server will close the stream and return the status on any error. The server may close the stream with status `UNAVAILABLE` to reassign server-side resources, in which case, the client should re-establish the stream. Flow control can be achieved by configuring the underlying RPC channel.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> streamingPullCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ModifyPushConfig</td>
 *      <td><p> Modifies the `PushConfig` for a specified subscription.
 * <p>  This may be used to change a push subscription to a pull one (signified by an empty `PushConfig`) or vice versa, or change the endpoint URL and other attributes of a push subscription. Messages will accumulate for delivery continuously through the call regardless of changes to the `PushConfig`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> modifyPushConfig(ModifyPushConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> modifyPushConfig(SubscriptionName subscription, PushConfig pushConfig)
 *           <li><p> modifyPushConfig(String subscription, PushConfig pushConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> modifyPushConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSnapshot</td>
 *      <td><p> Gets the configuration details of a snapshot. Snapshots are used in [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSnapshot(GetSnapshotRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSnapshot(SnapshotName snapshot)
 *           <li><p> getSnapshot(String snapshot)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSnapshotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSnapshots</td>
 *      <td><p> Lists the existing snapshots. Snapshots are used in [Seek]( https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSnapshots(ListSnapshotsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSnapshots(ProjectName project)
 *           <li><p> listSnapshots(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSnapshotsPagedCallable()
 *           <li><p> listSnapshotsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSnapshot</td>
 *      <td><p> Creates a snapshot from the requested subscription. Snapshots are used in [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot. If the snapshot already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the `Snapshot.expire_time` field. If the name is not provided in the request, the server will assign a random name for this snapshot on the same project as the subscription, conforming to the [resource name format] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The generated name is populated in the returned Snapshot object. Note that for REST API requests, you must specify a name in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSnapshot(CreateSnapshotRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSnapshot(SnapshotName name, SubscriptionName subscription)
 *           <li><p> createSnapshot(SnapshotName name, String subscription)
 *           <li><p> createSnapshot(String name, SubscriptionName subscription)
 *           <li><p> createSnapshot(String name, String subscription)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSnapshotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSnapshot</td>
 *      <td><p> Updates an existing snapshot by updating the fields specified in the update mask. Snapshots are used in [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSnapshot(UpdateSnapshotRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSnapshot(Snapshot snapshot, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSnapshotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSnapshot</td>
 *      <td><p> Removes an existing snapshot. Snapshots are used in [Seek] (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot. When the snapshot is deleted, all messages retained in the snapshot are immediately dropped. After a snapshot is deleted, a new one may be created with the same name, but the new one has no association with the old snapshot or its subscription, unless the same subscription is specified.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSnapshot(DeleteSnapshotRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSnapshot(SnapshotName snapshot)
 *           <li><p> deleteSnapshot(String snapshot)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSnapshotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Seek</td>
 *      <td><p> Seeks an existing subscription to a point in time or to a given snapshot, whichever is provided in the request. Snapshots are used in [Seek] (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot. Note that both the subscription and the snapshot must be on the same topic.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> seek(SeekRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> seekCallable()
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
 * <p>This class can be customized by passing in a custom instance of SubscriptionAdminSettings to
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
 * SubscriptionAdminSettings subscriptionAdminSettings =
 *     SubscriptionAdminSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SubscriptionAdminClient subscriptionAdminClient =
 *     SubscriptionAdminClient.create(subscriptionAdminSettings);
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
 * SubscriptionAdminSettings subscriptionAdminSettings =
 *     SubscriptionAdminSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SubscriptionAdminClient subscriptionAdminClient =
 *     SubscriptionAdminClient.create(subscriptionAdminSettings);
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
 * SubscriptionAdminSettings subscriptionAdminSettings =
 *     SubscriptionAdminSettings.newHttpJsonBuilder().build();
 * SubscriptionAdminClient subscriptionAdminClient =
 *     SubscriptionAdminClient.create(subscriptionAdminSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SubscriptionAdminClient implements BackgroundResource {
  private final SubscriptionAdminSettings settings;
  private final SubscriberStub stub;

  /** Constructs an instance of SubscriptionAdminClient with default settings. */
  public static final SubscriptionAdminClient create() throws IOException {
    return create(SubscriptionAdminSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SubscriptionAdminClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SubscriptionAdminClient create(SubscriptionAdminSettings settings)
      throws IOException {
    return new SubscriptionAdminClient(settings);
  }

  /**
   * Constructs an instance of SubscriptionAdminClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(SubscriptionAdminSettings).
   */
  public static final SubscriptionAdminClient create(SubscriberStub stub) {
    return new SubscriptionAdminClient(stub);
  }

  /**
   * Constructs an instance of SubscriptionAdminClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SubscriptionAdminClient(SubscriptionAdminSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SubscriberStubSettings) settings.getStubSettings()).createStub();
  }

  protected SubscriptionAdminClient(SubscriberStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SubscriptionAdminSettings getSettings() {
    return settings;
  }

  public SubscriberStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription to a given topic. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). If the subscription
   * already exists, returns `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns
   * `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name format]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The generated name is
   * populated in the returned Subscription object. Note that for REST API requests, you must
   * specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SubscriptionName name = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   int ackDeadlineSeconds = 2135351438;
   *   Subscription response =
   *       subscriptionAdminClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
   * }
   * }</pre>
   *
   * @param name Required. The name of the subscription. It must have the format
   *     `"projects/{project}/subscriptions/{subscription}"`. `{subscription}` must start with a
   *     letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores
   *     (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3
   *     and 255 characters in length, and it must not start with `"goog"`.
   * @param topic Required. The name of the topic from which this subscription is receiving
   *     messages. Format is `projects/{project}/topics/{topic}`. The value of this field will be
   *     `_deleted-topic_` if the topic has been deleted.
   * @param pushConfig Optional. If push delivery is used with this subscription, this field is used
   *     to configure it.
   * @param ackDeadlineSeconds Optional. The approximate amount of time (on a best-effort basis)
   *     Pub/Sub waits for the subscriber to acknowledge receipt before resending the message. In
   *     the interval after the message is delivered and before it is acknowledged, it is considered
   *     to be _outstanding_. During that time period, the message will not be redelivered (on a
   *     best-effort basis).
   *     <p>For pull subscriptions, this value is used as the initial value for the ack deadline. To
   *     override this value for a given message, call `ModifyAckDeadline` with the corresponding
   *     `ack_id` if using non-streaming pull or send the `ack_id` in a
   *     `StreamingModifyAckDeadlineRequest` if using streaming pull. The minimum custom deadline
   *     you can specify is 10 seconds. The maximum custom deadline you can specify is 600 seconds
   *     (10 minutes). If this parameter is 0, a default value of 10 seconds is used.
   *     <p>For push delivery, this value is also used to set the request timeout for the call to
   *     the push endpoint.
   *     <p>If the subscriber never acknowledges the message, the Pub/Sub system will eventually
   *     redeliver the message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription createSubscription(
      SubscriptionName name, TopicName topic, PushConfig pushConfig, int ackDeadlineSeconds) {
    Subscription request =
        Subscription.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTopic(topic == null ? null : topic.toString())
            .setPushConfig(pushConfig)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    return createSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription to a given topic. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). If the subscription
   * already exists, returns `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns
   * `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name format]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The generated name is
   * populated in the returned Subscription object. Note that for REST API requests, you must
   * specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SubscriptionName name = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   String topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString();
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   int ackDeadlineSeconds = 2135351438;
   *   Subscription response =
   *       subscriptionAdminClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
   * }
   * }</pre>
   *
   * @param name Required. The name of the subscription. It must have the format
   *     `"projects/{project}/subscriptions/{subscription}"`. `{subscription}` must start with a
   *     letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores
   *     (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3
   *     and 255 characters in length, and it must not start with `"goog"`.
   * @param topic Required. The name of the topic from which this subscription is receiving
   *     messages. Format is `projects/{project}/topics/{topic}`. The value of this field will be
   *     `_deleted-topic_` if the topic has been deleted.
   * @param pushConfig Optional. If push delivery is used with this subscription, this field is used
   *     to configure it.
   * @param ackDeadlineSeconds Optional. The approximate amount of time (on a best-effort basis)
   *     Pub/Sub waits for the subscriber to acknowledge receipt before resending the message. In
   *     the interval after the message is delivered and before it is acknowledged, it is considered
   *     to be _outstanding_. During that time period, the message will not be redelivered (on a
   *     best-effort basis).
   *     <p>For pull subscriptions, this value is used as the initial value for the ack deadline. To
   *     override this value for a given message, call `ModifyAckDeadline` with the corresponding
   *     `ack_id` if using non-streaming pull or send the `ack_id` in a
   *     `StreamingModifyAckDeadlineRequest` if using streaming pull. The minimum custom deadline
   *     you can specify is 10 seconds. The maximum custom deadline you can specify is 600 seconds
   *     (10 minutes). If this parameter is 0, a default value of 10 seconds is used.
   *     <p>For push delivery, this value is also used to set the request timeout for the call to
   *     the push endpoint.
   *     <p>If the subscriber never acknowledges the message, the Pub/Sub system will eventually
   *     redeliver the message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription createSubscription(
      SubscriptionName name, String topic, PushConfig pushConfig, int ackDeadlineSeconds) {
    Subscription request =
        Subscription.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTopic(topic)
            .setPushConfig(pushConfig)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    return createSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription to a given topic. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). If the subscription
   * already exists, returns `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns
   * `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name format]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The generated name is
   * populated in the returned Subscription object. Note that for REST API requests, you must
   * specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String name = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   int ackDeadlineSeconds = 2135351438;
   *   Subscription response =
   *       subscriptionAdminClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
   * }
   * }</pre>
   *
   * @param name Required. The name of the subscription. It must have the format
   *     `"projects/{project}/subscriptions/{subscription}"`. `{subscription}` must start with a
   *     letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores
   *     (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3
   *     and 255 characters in length, and it must not start with `"goog"`.
   * @param topic Required. The name of the topic from which this subscription is receiving
   *     messages. Format is `projects/{project}/topics/{topic}`. The value of this field will be
   *     `_deleted-topic_` if the topic has been deleted.
   * @param pushConfig Optional. If push delivery is used with this subscription, this field is used
   *     to configure it.
   * @param ackDeadlineSeconds Optional. The approximate amount of time (on a best-effort basis)
   *     Pub/Sub waits for the subscriber to acknowledge receipt before resending the message. In
   *     the interval after the message is delivered and before it is acknowledged, it is considered
   *     to be _outstanding_. During that time period, the message will not be redelivered (on a
   *     best-effort basis).
   *     <p>For pull subscriptions, this value is used as the initial value for the ack deadline. To
   *     override this value for a given message, call `ModifyAckDeadline` with the corresponding
   *     `ack_id` if using non-streaming pull or send the `ack_id` in a
   *     `StreamingModifyAckDeadlineRequest` if using streaming pull. The minimum custom deadline
   *     you can specify is 10 seconds. The maximum custom deadline you can specify is 600 seconds
   *     (10 minutes). If this parameter is 0, a default value of 10 seconds is used.
   *     <p>For push delivery, this value is also used to set the request timeout for the call to
   *     the push endpoint.
   *     <p>If the subscriber never acknowledges the message, the Pub/Sub system will eventually
   *     redeliver the message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription createSubscription(
      String name, TopicName topic, PushConfig pushConfig, int ackDeadlineSeconds) {
    Subscription request =
        Subscription.newBuilder()
            .setName(name)
            .setTopic(topic == null ? null : topic.toString())
            .setPushConfig(pushConfig)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    return createSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription to a given topic. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). If the subscription
   * already exists, returns `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns
   * `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name format]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The generated name is
   * populated in the returned Subscription object. Note that for REST API requests, you must
   * specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String name = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   String topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString();
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   int ackDeadlineSeconds = 2135351438;
   *   Subscription response =
   *       subscriptionAdminClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
   * }
   * }</pre>
   *
   * @param name Required. The name of the subscription. It must have the format
   *     `"projects/{project}/subscriptions/{subscription}"`. `{subscription}` must start with a
   *     letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores
   *     (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3
   *     and 255 characters in length, and it must not start with `"goog"`.
   * @param topic Required. The name of the topic from which this subscription is receiving
   *     messages. Format is `projects/{project}/topics/{topic}`. The value of this field will be
   *     `_deleted-topic_` if the topic has been deleted.
   * @param pushConfig Optional. If push delivery is used with this subscription, this field is used
   *     to configure it.
   * @param ackDeadlineSeconds Optional. The approximate amount of time (on a best-effort basis)
   *     Pub/Sub waits for the subscriber to acknowledge receipt before resending the message. In
   *     the interval after the message is delivered and before it is acknowledged, it is considered
   *     to be _outstanding_. During that time period, the message will not be redelivered (on a
   *     best-effort basis).
   *     <p>For pull subscriptions, this value is used as the initial value for the ack deadline. To
   *     override this value for a given message, call `ModifyAckDeadline` with the corresponding
   *     `ack_id` if using non-streaming pull or send the `ack_id` in a
   *     `StreamingModifyAckDeadlineRequest` if using streaming pull. The minimum custom deadline
   *     you can specify is 10 seconds. The maximum custom deadline you can specify is 600 seconds
   *     (10 minutes). If this parameter is 0, a default value of 10 seconds is used.
   *     <p>For push delivery, this value is also used to set the request timeout for the call to
   *     the push endpoint.
   *     <p>If the subscriber never acknowledges the message, the Pub/Sub system will eventually
   *     redeliver the message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription createSubscription(
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription to a given topic. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). If the subscription
   * already exists, returns `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns
   * `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name format]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The generated name is
   * populated in the returned Subscription object. Note that for REST API requests, you must
   * specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   Subscription request =
   *       Subscription.newBuilder()
   *           .setName(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .setPushConfig(PushConfig.newBuilder().build())
   *           .setBigqueryConfig(BigQueryConfig.newBuilder().build())
   *           .setCloudStorageConfig(CloudStorageConfig.newBuilder().build())
   *           .setAckDeadlineSeconds(2135351438)
   *           .setRetainAckedMessages(true)
   *           .setMessageRetentionDuration(Duration.newBuilder().build())
   *           .putAllLabels(new HashMap<String, String>())
   *           .setEnableMessageOrdering(true)
   *           .setExpirationPolicy(ExpirationPolicy.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .setDeadLetterPolicy(DeadLetterPolicy.newBuilder().build())
   *           .setRetryPolicy(RetryPolicy.newBuilder().build())
   *           .setDetached(true)
   *           .setEnableExactlyOnceDelivery(true)
   *           .setTopicMessageRetentionDuration(Duration.newBuilder().build())
   *           .build();
   *   Subscription response = subscriptionAdminClient.createSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription createSubscription(Subscription request) {
    return createSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a subscription to a given topic. See the &lt;a
   * href="https://cloud.google.com/pubsub/docs/admin#resource_names"&gt; resource name
   * rules&lt;/a&gt;. If the subscription already exists, returns `ALREADY_EXISTS`. If the
   * corresponding topic doesn't exist, returns `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name
   * format](https://cloud.google.com/pubsub/docs/admin#resource_names). The generated name is
   * populated in the returned Subscription object. Note that for REST API requests, you must
   * specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName name = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   int ackDeadlineSeconds = 0;
   *   Subscription response = subscriptionAdminClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the subscription. It must have the format
   *     `"projects/{project}/subscriptions/{subscription}"`. `{subscription}` must start with a
   *     letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores
   *     (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3
   *     and 255 characters in length, and it must not start with `"goog"`.
   * @param topic Required. The name of the topic from which this subscription is receiving
   *     messages. Format is `projects/{project}/topics/{topic}`. The value of this field will be
   *     `_deleted-topic_` if the topic has been deleted.
   * @param pushConfig If push delivery is used with this subscription, this field is used to
   *     configure it. An empty `pushConfig` signifies that the subscriber will pull and ack
   *     messages using API methods.
   * @param ackDeadlineSeconds The approximate amount of time (on a best-effort basis) Pub/Sub waits
   *     for the subscriber to acknowledge receipt before resending the message. In the interval
   *     after the message is delivered and before it is acknowledged, it is considered to be
   *     &lt;i&gt;outstanding&lt;/i&gt;. During that time period, the message will not be
   *     redelivered (on a best-effort basis).
   *     <p>For pull subscriptions, this value is used as the initial value for the ack deadline. To
   *     override this value for a given message, call `ModifyAckDeadline` with the corresponding
   *     `ack_id` if using non-streaming pull or send the `ack_id` in a
   *     `StreamingModifyAckDeadlineRequest` if using streaming pull. The minimum custom deadline
   *     you can specify is 10 seconds. The maximum custom deadline you can specify is 600 seconds
   *     (10 minutes). If this parameter is 0, a default value of 10 seconds is used.
   *     <p>For push delivery, this value is also used to set the request timeout for the call to
   *     the push endpoint.
   *     <p>If the subscriber never acknowledges the message, the Pub/Sub system will eventually
   *     redeliver the message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #createSubscription(SubscriptionName, TopicName, PushConfig, int)}
   *     instead.
   */
  @Deprecated
  public final Subscription createSubscription(
      ProjectSubscriptionName name,
      ProjectTopicName topic,
      PushConfig pushConfig,
      int ackDeadlineSeconds) {
    Subscription request =
        Subscription.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTopic(topic == null ? null : topic.toString())
            .setPushConfig(pushConfig)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    return createSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription to a given topic. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/admin#resource_names). If the subscription already
   * exists, returns `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns
   * `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name format]
   * (https://cloud.google.com/pubsub/docs/admin#resource_names). The generated name is populated in
   * the returned Subscription object. Note that for REST API requests, you must specify a name in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName name = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   String topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString();
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   int ackDeadlineSeconds = 2135351438;
   *   Subscription response =
   *       subscriptionAdminClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
   * }
   * }</pre>
   *
   * @param name Required. The name of the subscription. It must have the format
   *     `"projects/{project}/subscriptions/{subscription}"`. `{subscription}` must start with a
   *     letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores
   *     (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3
   *     and 255 characters in length, and it must not start with `"goog"`.
   * @param topic Required. The name of the topic from which this subscription is receiving
   *     messages. Format is `projects/{project}/topics/{topic}`. The value of this field will be
   *     `_deleted-topic_` if the topic has been deleted.
   * @param pushConfig If push delivery is used with this subscription, this field is used to
   *     configure it. An empty `pushConfig` signifies that the subscriber will pull and ack
   *     messages using API methods.
   * @param ackDeadlineSeconds The approximate amount of time (on a best-effort basis) Pub/Sub waits
   *     for the subscriber to acknowledge receipt before resending the message. In the interval
   *     after the message is delivered and before it is acknowledged, it is considered to be
   *     &lt;i&gt;outstanding&lt;/i&gt;. During that time period, the message will not be
   *     redelivered (on a best-effort basis).
   *     <p>For pull subscriptions, this value is used as the initial value for the ack deadline. To
   *     override this value for a given message, call `ModifyAckDeadline` with the corresponding
   *     `ack_id` if using non-streaming pull or send the `ack_id` in a
   *     `StreamingModifyAckDeadlineRequest` if using streaming pull. The minimum custom deadline
   *     you can specify is 10 seconds. The maximum custom deadline you can specify is 600 seconds
   *     (10 minutes). If this parameter is 0, a default value of 10 seconds is used.
   *     <p>For push delivery, this value is also used to set the request timeout for the call to
   *     the push endpoint.
   *     <p>If the subscriber never acknowledges the message, the Pub/Sub system will eventually
   *     redeliver the message.
   * @deprecated Use {@link #createSubscription(SubscriptionName, String, PushConfig, int)} instead.
   */
  @Deprecated
  public final Subscription createSubscription(
      ProjectSubscriptionName name, String topic, PushConfig pushConfig, int ackDeadlineSeconds) {
    Subscription request =
        Subscription.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTopic(topic)
            .setPushConfig(pushConfig)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    return createSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription to a given topic. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/admin#resource_names). If the subscription already
   * exists, returns `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns
   * `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name format]
   * (https://cloud.google.com/pubsub/docs/admin#resource_names). The generated name is populated in
   * the returned Subscription object. Note that for REST API requests, you must specify a name in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName name = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   int ackDeadlineSeconds = 2135351438;
   *   Subscription response =
   *       subscriptionAdminClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
   * }
   * }</pre>
   *
   * @param name Required. The name of the subscription. It must have the format
   *     `"projects/{project}/subscriptions/{subscription}"`. `{subscription}` must start with a
   *     letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores
   *     (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3
   *     and 255 characters in length, and it must not start with `"goog"`.
   * @param topic Required. The name of the topic from which this subscription is receiving
   *     messages. Format is `projects/{project}/topics/{topic}`. The value of this field will be
   *     `_deleted-topic_` if the topic has been deleted.
   * @param pushConfig If push delivery is used with this subscription, this field is used to
   *     configure it. An empty `pushConfig` signifies that the subscriber will pull and ack
   *     messages using API methods.
   * @param ackDeadlineSeconds The approximate amount of time (on a best-effort basis) Pub/Sub waits
   *     for the subscriber to acknowledge receipt before resending the message. In the interval
   *     after the message is delivered and before it is acknowledged, it is considered to be
   *     &lt;i&gt;outstanding&lt;/i&gt;. During that time period, the message will not be
   *     redelivered (on a best-effort basis).
   *     <p>For pull subscriptions, this value is used as the initial value for the ack deadline. To
   *     override this value for a given message, call `ModifyAckDeadline` with the corresponding
   *     `ack_id` if using non-streaming pull or send the `ack_id` in a
   *     `StreamingModifyAckDeadlineRequest` if using streaming pull. The minimum custom deadline
   *     you can specify is 10 seconds. The maximum custom deadline you can specify is 600 seconds
   *     (10 minutes). If this parameter is 0, a default value of 10 seconds is used.
   *     <p>For push delivery, this value is also used to set the request timeout for the call to
   *     the push endpoint.
   *     <p>If the subscriber never acknowledges the message, the Pub/Sub system will eventually
   *     redeliver the message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #createSubscription(SubscriptionName, TopicName, PushConfig, int)}
   *     instead.
   */
  @Deprecated
  public final Subscription createSubscription(
      ProjectSubscriptionName name,
      TopicName topic,
      PushConfig pushConfig,
      int ackDeadlineSeconds) {
    Subscription request =
        Subscription.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTopic(topic == null ? null : topic.toString())
            .setPushConfig(pushConfig)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    return createSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription to a given topic. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). If the subscription
   * already exists, returns `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns
   * `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name format]
   * (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The generated name is
   * populated in the returned Subscription object. Note that for REST API requests, you must
   * specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   Subscription request =
   *       Subscription.newBuilder()
   *           .setName(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .setTopic(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
   *           .setPushConfig(PushConfig.newBuilder().build())
   *           .setBigqueryConfig(BigQueryConfig.newBuilder().build())
   *           .setCloudStorageConfig(CloudStorageConfig.newBuilder().build())
   *           .setAckDeadlineSeconds(2135351438)
   *           .setRetainAckedMessages(true)
   *           .setMessageRetentionDuration(Duration.newBuilder().build())
   *           .putAllLabels(new HashMap<String, String>())
   *           .setEnableMessageOrdering(true)
   *           .setExpirationPolicy(ExpirationPolicy.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .setDeadLetterPolicy(DeadLetterPolicy.newBuilder().build())
   *           .setRetryPolicy(RetryPolicy.newBuilder().build())
   *           .setDetached(true)
   *           .setEnableExactlyOnceDelivery(true)
   *           .setTopicMessageRetentionDuration(Duration.newBuilder().build())
   *           .build();
   *   ApiFuture<Subscription> future =
   *       subscriptionAdminClient.createSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   Subscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<Subscription, Subscription> createSubscriptionCallable() {
    return stub.createSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration details of a subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   Subscription response = subscriptionAdminClient.getSubscription(subscription);
   * }
   * }</pre>
   *
   * @param subscription Required. The name of the subscription to get. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription getSubscription(SubscriptionName subscription) {
    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .build();
    return getSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration details of a subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   Subscription response = subscriptionAdminClient.getSubscription(subscription);
   * }
   * }</pre>
   *
   * @param subscription Required. The name of the subscription to get. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription getSubscription(String subscription) {
    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder().setSubscription(subscription).build();
    return getSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration details of a subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   GetSubscriptionRequest request =
   *       GetSubscriptionRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   Subscription response = subscriptionAdminClient.getSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription getSubscription(GetSubscriptionRequest request) {
    return getSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration details of a subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   Subscription response = subscriptionAdminClient.getSubscription(subscription);
   * }
   * }</pre>
   *
   * @param subscription Required. The name of the subscription to get. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #getSubscription(SubscriptionName)} instead.
   */
  @Deprecated
  public final Subscription getSubscription(ProjectSubscriptionName subscription) {
    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .build();
    return getSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration details of a subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   GetSubscriptionRequest request =
   *       GetSubscriptionRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   ApiFuture<Subscription> future =
   *       subscriptionAdminClient.getSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   Subscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    return stub.getSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing subscription by updating the fields specified in the update mask. Note that
   * certain properties of a subscription, such as its topic, are not modifiable.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   Subscription subscription = Subscription.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Subscription response = subscriptionAdminClient.updateSubscription(subscription, updateMask);
   * }
   * }</pre>
   *
   * @param subscription Required. The updated subscription object.
   * @param updateMask Required. Indicates which fields in the provided subscription to update. Must
   *     be specified and non-empty.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription updateSubscription(Subscription subscription, FieldMask updateMask) {
    UpdateSubscriptionRequest request =
        UpdateSubscriptionRequest.newBuilder()
            .setSubscription(subscription)
            .setUpdateMask(updateMask)
            .build();
    return updateSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing subscription by updating the fields specified in the update mask. Note that
   * certain properties of a subscription, such as its topic, are not modifiable.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   UpdateSubscriptionRequest request =
   *       UpdateSubscriptionRequest.newBuilder()
   *           .setSubscription(Subscription.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Subscription response = subscriptionAdminClient.updateSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription updateSubscription(UpdateSubscriptionRequest request) {
    return updateSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing subscription by updating the fields specified in the update mask. Note that
   * certain properties of a subscription, such as its topic, are not modifiable.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   UpdateSubscriptionRequest request =
   *       UpdateSubscriptionRequest.newBuilder()
   *           .setSubscription(Subscription.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Subscription> future =
   *       subscriptionAdminClient.updateSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   Subscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSubscriptionRequest, Subscription> updateSubscriptionCallable() {
    return stub.updateSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists matching subscriptions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Subscription element : subscriptionAdminClient.listSubscriptions(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Required. The name of the project in which to list subscriptions. Format is
   *     `projects/{project-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubscriptionsPagedResponse listSubscriptions(ProjectName project) {
    ListSubscriptionsRequest request =
        ListSubscriptionsRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists matching subscriptions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String project = ProjectName.of("[PROJECT]").toString();
   *   for (Subscription element : subscriptionAdminClient.listSubscriptions(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Required. The name of the project in which to list subscriptions. Format is
   *     `projects/{project-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubscriptionsPagedResponse listSubscriptions(String project) {
    ListSubscriptionsRequest request =
        ListSubscriptionsRequest.newBuilder().setProject(project).build();
    return listSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists matching subscriptions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ListSubscriptionsRequest request =
   *       ListSubscriptionsRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Subscription element : subscriptionAdminClient.listSubscriptions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubscriptionsPagedResponse listSubscriptions(ListSubscriptionsRequest request) {
    return listSubscriptionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists matching subscriptions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ListSubscriptionsRequest request =
   *       ListSubscriptionsRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Subscription> future =
   *       subscriptionAdminClient.listSubscriptionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Subscription element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable() {
    return stub.listSubscriptionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists matching subscriptions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ListSubscriptionsRequest request =
   *       ListSubscriptionsRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSubscriptionsResponse response =
   *         subscriptionAdminClient.listSubscriptionsCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    return stub.listSubscriptionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing subscription. All messages retained in the subscription are immediately
   * dropped. Calls to `Pull` after deletion will return `NOT_FOUND`. After a subscription is
   * deleted, a new one may be created with the same name, but the new one has no association with
   * the old subscription or its topic unless the same topic is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   subscriptionAdminClient.deleteSubscription(subscription);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription to delete. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSubscription(SubscriptionName subscription) {
    DeleteSubscriptionRequest request =
        DeleteSubscriptionRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .build();
    deleteSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing subscription. All messages retained in the subscription are immediately
   * dropped. Calls to `Pull` after deletion will return `NOT_FOUND`. After a subscription is
   * deleted, a new one may be created with the same name, but the new one has no association with
   * the old subscription or its topic unless the same topic is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   subscriptionAdminClient.deleteSubscription(subscription);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription to delete. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSubscription(String subscription) {
    DeleteSubscriptionRequest request =
        DeleteSubscriptionRequest.newBuilder().setSubscription(subscription).build();
    deleteSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing subscription. All messages retained in the subscription are immediately
   * dropped. Calls to `Pull` after deletion will return `NOT_FOUND`. After a subscription is
   * deleted, a new one may be created with the same name, but the new one has no association with
   * the old subscription or its topic unless the same topic is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   DeleteSubscriptionRequest request =
   *       DeleteSubscriptionRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   subscriptionAdminClient.deleteSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSubscription(DeleteSubscriptionRequest request) {
    deleteSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing subscription. All messages retained in the subscription are immediately
   * dropped. Calls to `Pull` after deletion will return `NOT_FOUND`. After a subscription is
   * deleted, a new one may be created with the same name, but the new one has no association with
   * the old subscription or its topic unless the same topic is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   subscriptionAdminClient.deleteSubscription(subscription);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription to delete. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #deleteSubscription(SubscriptionName)} instead.
   */
  @Deprecated
  public final void deleteSubscription(ProjectSubscriptionName subscription) {
    DeleteSubscriptionRequest request =
        DeleteSubscriptionRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .build();
    deleteSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing subscription. All messages retained in the subscription are immediately
   * dropped. Calls to `Pull` after deletion will return `NOT_FOUND`. After a subscription is
   * deleted, a new one may be created with the same name, but the new one has no association with
   * the old subscription or its topic unless the same topic is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   DeleteSubscriptionRequest request =
   *       DeleteSubscriptionRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       subscriptionAdminClient.deleteSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable() {
    return stub.deleteSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the ack deadline for a specific message. This method is useful to indicate that more
   * time is needed to process a message by the subscriber, or to make the message available for
   * redelivery if the processing was interrupted. Note that this does not modify the
   * subscription-level `ackDeadlineSeconds` used for subsequent messages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   List<String> ackIds = new ArrayList<>();
   *   int ackDeadlineSeconds = 2135351438;
   *   subscriptionAdminClient.modifyAckDeadline(subscription, ackIds, ackDeadlineSeconds);
   * }
   * }</pre>
   *
   * @param subscription Required. The name of the subscription. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param ackIds Required. List of acknowledgment IDs.
   * @param ackDeadlineSeconds Required. The new ack deadline with respect to the time this request
   *     was sent to the Pub/Sub system. For example, if the value is 10, the new ack deadline will
   *     expire 10 seconds after the `ModifyAckDeadline` call was made. Specifying zero might
   *     immediately make the message available for delivery to another subscriber client. This
   *     typically results in an increase in the rate of message redeliveries (that is, duplicates).
   *     The minimum deadline you can specify is 0 seconds. The maximum deadline you can specify in
   *     a single request is 600 seconds (10 minutes).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void modifyAckDeadline(
      SubscriptionName subscription, List<String> ackIds, int ackDeadlineSeconds) {
    ModifyAckDeadlineRequest request =
        ModifyAckDeadlineRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .addAllAckIds(ackIds)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    modifyAckDeadline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the ack deadline for a specific message. This method is useful to indicate that more
   * time is needed to process a message by the subscriber, or to make the message available for
   * redelivery if the processing was interrupted. Note that this does not modify the
   * subscription-level `ackDeadlineSeconds` used for subsequent messages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   List<String> ackIds = new ArrayList<>();
   *   int ackDeadlineSeconds = 2135351438;
   *   subscriptionAdminClient.modifyAckDeadline(subscription, ackIds, ackDeadlineSeconds);
   * }
   * }</pre>
   *
   * @param subscription Required. The name of the subscription. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param ackIds Required. List of acknowledgment IDs.
   * @param ackDeadlineSeconds Required. The new ack deadline with respect to the time this request
   *     was sent to the Pub/Sub system. For example, if the value is 10, the new ack deadline will
   *     expire 10 seconds after the `ModifyAckDeadline` call was made. Specifying zero might
   *     immediately make the message available for delivery to another subscriber client. This
   *     typically results in an increase in the rate of message redeliveries (that is, duplicates).
   *     The minimum deadline you can specify is 0 seconds. The maximum deadline you can specify in
   *     a single request is 600 seconds (10 minutes).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void modifyAckDeadline(
      String subscription, List<String> ackIds, int ackDeadlineSeconds) {
    ModifyAckDeadlineRequest request =
        ModifyAckDeadlineRequest.newBuilder()
            .setSubscription(subscription)
            .addAllAckIds(ackIds)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    modifyAckDeadline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the ack deadline for a specific message. This method is useful to indicate that more
   * time is needed to process a message by the subscriber, or to make the message available for
   * redelivery if the processing was interrupted. Note that this does not modify the
   * subscription-level `ackDeadlineSeconds` used for subsequent messages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ModifyAckDeadlineRequest request =
   *       ModifyAckDeadlineRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .addAllAckIds(new ArrayList<String>())
   *           .setAckDeadlineSeconds(2135351438)
   *           .build();
   *   subscriptionAdminClient.modifyAckDeadline(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void modifyAckDeadline(ModifyAckDeadlineRequest request) {
    modifyAckDeadlineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the ack deadline for a specific message. This method is useful to indicate that more
   * time is needed to process a message by the subscriber, or to make the message available for
   * redelivery if the processing was interrupted. Note that this does not modify the
   * subscription-level `ackDeadlineSeconds` used for subsequent messages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   List<String> ackIds = new ArrayList<>();
   *   int ackDeadlineSeconds = 2135351438;
   *   subscriptionAdminClient.modifyAckDeadline(subscription, ackIds, ackDeadlineSeconds);
   * }
   * }</pre>
   *
   * @param subscription Required. The name of the subscription. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param ackIds Required. List of acknowledgment IDs.
   * @param ackDeadlineSeconds Required. The new ack deadline with respect to the time this request
   *     was sent to the Pub/Sub system. For example, if the value is 10, the new ack deadline will
   *     expire 10 seconds after the `ModifyAckDeadline` call was made. Specifying zero might
   *     immediately make the message available for delivery to another subscriber client. This
   *     typically results in an increase in the rate of message redeliveries (that is, duplicates).
   *     The minimum deadline you can specify is 0 seconds. The maximum deadline you can specify is
   *     600 seconds (10 minutes).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #modifyAckDeadline(SubscriptionName, List<String>, int)} instead.
   */
  @Deprecated
  final void modifyAckDeadline(
      ProjectSubscriptionName subscription, List<String> ackIds, int ackDeadlineSeconds) {
    ModifyAckDeadlineRequest request =
        ModifyAckDeadlineRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .addAllAckIds(ackIds)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    modifyAckDeadline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the ack deadline for a specific message. This method is useful to indicate that more
   * time is needed to process a message by the subscriber, or to make the message available for
   * redelivery if the processing was interrupted. Note that this does not modify the
   * subscription-level `ackDeadlineSeconds` used for subsequent messages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ModifyAckDeadlineRequest request =
   *       ModifyAckDeadlineRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .addAllAckIds(new ArrayList<String>())
   *           .setAckDeadlineSeconds(2135351438)
   *           .build();
   *   ApiFuture<Empty> future =
   *       subscriptionAdminClient.modifyAckDeadlineCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineCallable() {
    return stub.modifyAckDeadlineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Acknowledges the messages associated with the `ack_ids` in the `AcknowledgeRequest`. The
   * Pub/Sub system can remove the relevant messages from the subscription.
   *
   * <p>Acknowledging a message whose ack deadline has expired may succeed, but such a message may
   * be redelivered later. Acknowledging a message more than once will not result in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   List<String> ackIds = new ArrayList<>();
   *   subscriptionAdminClient.acknowledge(subscription, ackIds);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription whose message is being acknowledged. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param ackIds Required. The acknowledgment ID for the messages being acknowledged that was
   *     returned by the Pub/Sub system in the `Pull` response. Must not be empty.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void acknowledge(SubscriptionName subscription, List<String> ackIds) {
    AcknowledgeRequest request =
        AcknowledgeRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .addAllAckIds(ackIds)
            .build();
    acknowledge(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Acknowledges the messages associated with the `ack_ids` in the `AcknowledgeRequest`. The
   * Pub/Sub system can remove the relevant messages from the subscription.
   *
   * <p>Acknowledging a message whose ack deadline has expired may succeed, but such a message may
   * be redelivered later. Acknowledging a message more than once will not result in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   List<String> ackIds = new ArrayList<>();
   *   subscriptionAdminClient.acknowledge(subscription, ackIds);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription whose message is being acknowledged. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param ackIds Required. The acknowledgment ID for the messages being acknowledged that was
   *     returned by the Pub/Sub system in the `Pull` response. Must not be empty.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void acknowledge(String subscription, List<String> ackIds) {
    AcknowledgeRequest request =
        AcknowledgeRequest.newBuilder().setSubscription(subscription).addAllAckIds(ackIds).build();
    acknowledge(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Acknowledges the messages associated with the `ack_ids` in the `AcknowledgeRequest`. The
   * Pub/Sub system can remove the relevant messages from the subscription.
   *
   * <p>Acknowledging a message whose ack deadline has expired may succeed, but such a message may
   * be redelivered later. Acknowledging a message more than once will not result in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   AcknowledgeRequest request =
   *       AcknowledgeRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .addAllAckIds(new ArrayList<String>())
   *           .build();
   *   subscriptionAdminClient.acknowledge(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void acknowledge(AcknowledgeRequest request) {
    acknowledgeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Acknowledges the messages associated with the `ack_ids` in the `AcknowledgeRequest`. The
   * Pub/Sub system can remove the relevant messages from the subscription.
   *
   * <p>Acknowledging a message whose ack deadline has expired may succeed, but such a message may
   * be redelivered later. Acknowledging a message more than once will not result in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   List<String> ackIds = new ArrayList<>();
   *   subscriptionAdminClient.acknowledge(subscription, ackIds);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription whose message is being acknowledged. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param ackIds Required. The acknowledgment ID for the messages being acknowledged that was
   *     returned by the Pub/Sub system in the `Pull` response. Must not be empty.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #acknowledge(SubscriptionName, List<String>)} instead.
   */
  @Deprecated
  public final void acknowledge(ProjectSubscriptionName subscription, List<String> ackIds) {
    AcknowledgeRequest request =
        AcknowledgeRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .addAllAckIds(ackIds)
            .build();
    acknowledge(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Acknowledges the messages associated with the `ack_ids` in the `AcknowledgeRequest`. The
   * Pub/Sub system can remove the relevant messages from the subscription.
   *
   * <p>Acknowledging a message whose ack deadline has expired may succeed, but such a message may
   * be redelivered later. Acknowledging a message more than once will not result in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   AcknowledgeRequest request =
   *       AcknowledgeRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .addAllAckIds(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Empty> future = subscriptionAdminClient.acknowledgeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AcknowledgeRequest, Empty> acknowledgeCallable() {
    return stub.acknowledgeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pulls messages from the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   int maxMessages = 496131527;
   *   PullResponse response = subscriptionAdminClient.pull(subscription, maxMessages);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription from which messages should be pulled. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param maxMessages Required. The maximum number of messages to return for this request. Must be
   *     a positive integer. The Pub/Sub system may return fewer than the number specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PullResponse pull(SubscriptionName subscription, int maxMessages) {
    PullRequest request =
        PullRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .setMaxMessages(maxMessages)
            .build();
    return pull(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pulls messages from the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   int maxMessages = 496131527;
   *   PullResponse response = subscriptionAdminClient.pull(subscription, maxMessages);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription from which messages should be pulled. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param maxMessages Required. The maximum number of messages to return for this request. Must be
   *     a positive integer. The Pub/Sub system may return fewer than the number specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PullResponse pull(String subscription, int maxMessages) {
    PullRequest request =
        PullRequest.newBuilder().setSubscription(subscription).setMaxMessages(maxMessages).build();
    return pull(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pulls messages from the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   boolean returnImmediately = true;
   *   int maxMessages = 496131527;
   *   PullResponse response =
   *       subscriptionAdminClient.pull(subscription, returnImmediately, maxMessages);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription from which messages should be pulled. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param returnImmediately Optional. If this field set to true, the system will respond
   *     immediately even if it there are no messages available to return in the `Pull` response.
   *     Otherwise, the system may wait (for a bounded amount of time) until at least one message is
   *     available, rather than returning no messages. Warning: setting this field to `true` is
   *     discouraged because it adversely impacts the performance of `Pull` operations. We recommend
   *     that users do not set this field.
   * @param maxMessages Required. The maximum number of messages to return for this request. Must be
   *     a positive integer. The Pub/Sub system may return fewer than the number specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PullResponse pull(
      SubscriptionName subscription, boolean returnImmediately, int maxMessages) {
    PullRequest request =
        PullRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .setReturnImmediately(returnImmediately)
            .setMaxMessages(maxMessages)
            .build();
    return pull(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pulls messages from the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   boolean returnImmediately = true;
   *   int maxMessages = 496131527;
   *   PullResponse response =
   *       subscriptionAdminClient.pull(subscription, returnImmediately, maxMessages);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription from which messages should be pulled. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param returnImmediately Optional. If this field set to true, the system will respond
   *     immediately even if it there are no messages available to return in the `Pull` response.
   *     Otherwise, the system may wait (for a bounded amount of time) until at least one message is
   *     available, rather than returning no messages. Warning: setting this field to `true` is
   *     discouraged because it adversely impacts the performance of `Pull` operations. We recommend
   *     that users do not set this field.
   * @param maxMessages Required. The maximum number of messages to return for this request. Must be
   *     a positive integer. The Pub/Sub system may return fewer than the number specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PullResponse pull(String subscription, boolean returnImmediately, int maxMessages) {
    PullRequest request =
        PullRequest.newBuilder()
            .setSubscription(subscription)
            .setReturnImmediately(returnImmediately)
            .setMaxMessages(maxMessages)
            .build();
    return pull(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pulls messages from the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   PullRequest request =
   *       PullRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .setReturnImmediately(true)
   *           .setMaxMessages(496131527)
   *           .build();
   *   PullResponse response = subscriptionAdminClient.pull(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PullResponse pull(PullRequest request) {
    return pullCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pulls messages from the server. The server may return `UNAVAILABLE` if there are too many
   * concurrent pull requests pending for the given subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   int maxMessages = 496131527;
   *   PullResponse response = subscriptionAdminClient.pull(subscription, maxMessages);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription from which messages should be pulled. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param maxMessages Required. The maximum number of messages to return for this request. Must be
   *     a positive integer. The Pub/Sub system may return fewer than the number specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #pull(SubscriptionName, int)} instead.
   */
  @Deprecated
  public final PullResponse pull(ProjectSubscriptionName subscription, int maxMessages) {
    PullRequest request =
        PullRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .setMaxMessages(maxMessages)
            .build();
    return pull(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pulls messages from the server. The server may return `UNAVAILABLE` if there are too many
   * concurrent pull requests pending for the given subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   boolean returnImmediately = true;
   *   int maxMessages = 496131527;
   *   PullResponse response =
   *       subscriptionAdminClient.pull(subscription, returnImmediately, maxMessages);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription from which messages should be pulled. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param returnImmediately Optional. If this field set to true, the system will respond
   *     immediately even if it there are no messages available to return in the `Pull` response.
   *     Otherwise, the system may wait (for a bounded amount of time) until at least one message is
   *     available, rather than returning no messages. Warning: setting this field to `true` is
   *     discouraged because it adversely impacts the performance of `Pull` operations. We recommend
   *     that users do not set this field.
   * @param maxMessages Required. The maximum number of messages to return for this request. Must be
   *     a positive integer. The Pub/Sub system may return fewer than the number specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #pull(SubscriptionName, boolean, int)} instead.
   */
  @Deprecated
  final PullResponse pull(
      ProjectSubscriptionName subscription, boolean returnImmediately, int maxMessages) {
    PullRequest request =
        PullRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .setReturnImmediately(returnImmediately)
            .setMaxMessages(maxMessages)
            .build();
    return pull(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pulls messages from the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   PullRequest request =
   *       PullRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .setReturnImmediately(true)
   *           .setMaxMessages(496131527)
   *           .build();
   *   ApiFuture<PullResponse> future = subscriptionAdminClient.pullCallable().futureCall(request);
   *   // Do something.
   *   PullResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PullRequest, PullResponse> pullCallable() {
    return stub.pullCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Establishes a stream with the server, which sends messages down to the client. The client
   * streams acknowledgements and ack deadline modifications back to the server. The server will
   * close the stream and return the status on any error. The server may close the stream with
   * status `UNAVAILABLE` to reassign server-side resources, in which case, the client should
   * re-establish the stream. Flow control can be achieved by configuring the underlying RPC
   * channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   BidiStream<StreamingPullRequest, StreamingPullResponse> bidiStream =
   *       subscriptionAdminClient.streamingPullCallable().call();
   *   StreamingPullRequest request =
   *       StreamingPullRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .addAllAckIds(new ArrayList<String>())
   *           .addAllModifyDeadlineSeconds(new ArrayList<Integer>())
   *           .addAllModifyDeadlineAckIds(new ArrayList<String>())
   *           .setStreamAckDeadlineSeconds(1875467245)
   *           .setClientId("clientId908408390")
   *           .setMaxOutstandingMessages(-1315266996)
   *           .setMaxOutstandingBytes(-2103098517)
   *           .build();
   *   bidiStream.send(request);
   *   for (StreamingPullResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<StreamingPullRequest, StreamingPullResponse>
      streamingPullCallable() {
    return stub.streamingPullCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   subscriptionAdminClient.modifyPushConfig(subscription, pushConfig);
   * }
   * }</pre>
   *
   * @param subscription Required. The name of the subscription. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param pushConfig Required. The push configuration for future deliveries.
   *     <p>An empty `pushConfig` indicates that the Pub/Sub system should stop pushing messages
   *     from the given subscription and allow messages to be pulled and acknowledged - effectively
   *     pausing the subscription if `Pull` or `StreamingPull` is not called.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void modifyPushConfig(SubscriptionName subscription, PushConfig pushConfig) {
    ModifyPushConfigRequest request =
        ModifyPushConfigRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .setPushConfig(pushConfig)
            .build();
    modifyPushConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   subscriptionAdminClient.modifyPushConfig(subscription, pushConfig);
   * }
   * }</pre>
   *
   * @param subscription Required. The name of the subscription. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param pushConfig Required. The push configuration for future deliveries.
   *     <p>An empty `pushConfig` indicates that the Pub/Sub system should stop pushing messages
   *     from the given subscription and allow messages to be pulled and acknowledged - effectively
   *     pausing the subscription if `Pull` or `StreamingPull` is not called.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void modifyPushConfig(String subscription, PushConfig pushConfig) {
    ModifyPushConfigRequest request =
        ModifyPushConfigRequest.newBuilder()
            .setSubscription(subscription)
            .setPushConfig(pushConfig)
            .build();
    modifyPushConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ModifyPushConfigRequest request =
   *       ModifyPushConfigRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .setPushConfig(PushConfig.newBuilder().build())
   *           .build();
   *   subscriptionAdminClient.modifyPushConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void modifyPushConfig(ModifyPushConfigRequest request) {
    modifyPushConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   subscriptionAdminClient.modifyPushConfig(subscription, pushConfig);
   * }
   * }</pre>
   *
   * @param subscription Required. The name of the subscription. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param pushConfig Required. The push configuration for future deliveries.
   *     <p>An empty `pushConfig` indicates that the Pub/Sub system should stop pushing messages
   *     from the given subscription and allow messages to be pulled and acknowledged - effectively
   *     pausing the subscription if `Pull` or `StreamingPull` is not called.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #modifyPushConfig(SubscriptionName, PushConfig)} instead.
   */
  @Deprecated
  public final void modifyPushConfig(ProjectSubscriptionName subscription, PushConfig pushConfig) {
    ModifyPushConfigRequest request =
        ModifyPushConfigRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .setPushConfig(pushConfig)
            .build();
    modifyPushConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ModifyPushConfigRequest request =
   *       ModifyPushConfigRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .setPushConfig(PushConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Empty> future =
   *       subscriptionAdminClient.modifyPushConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ModifyPushConfigRequest, Empty> modifyPushConfigCallable() {
    return stub.modifyPushConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration details of a snapshot. Snapshots are used in
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SnapshotName snapshot = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");
   *   Snapshot response = subscriptionAdminClient.getSnapshot(snapshot);
   * }
   * }</pre>
   *
   * @param snapshot Required. The name of the snapshot to get. Format is
   *     `projects/{project}/snapshots/{snap}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot getSnapshot(SnapshotName snapshot) {
    GetSnapshotRequest request =
        GetSnapshotRequest.newBuilder()
            .setSnapshot(snapshot == null ? null : snapshot.toString())
            .build();
    return getSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration details of a snapshot. Snapshots are used in
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String snapshot = SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString();
   *   Snapshot response = subscriptionAdminClient.getSnapshot(snapshot);
   * }
   * }</pre>
   *
   * @param snapshot Required. The name of the snapshot to get. Format is
   *     `projects/{project}/snapshots/{snap}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot getSnapshot(String snapshot) {
    GetSnapshotRequest request = GetSnapshotRequest.newBuilder().setSnapshot(snapshot).build();
    return getSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration details of a snapshot. Snapshots are used in
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   GetSnapshotRequest request =
   *       GetSnapshotRequest.newBuilder()
   *           .setSnapshot(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
   *           .build();
   *   Snapshot response = subscriptionAdminClient.getSnapshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot getSnapshot(GetSnapshotRequest request) {
    return getSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration details of a snapshot. Snapshots are used in &lt;a
   * href="https://cloud.google.com/pubsub/docs/replay-overview"&gt;Seek&lt;/a&gt; operations, which
   * allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment
   * state of messages in an existing subscription to the state captured by a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSnapshotName snapshot = ProjectSnapshotName.of("[PROJECT]", "[SNAPSHOT]");
   *   Snapshot response = subscriptionAdminClient.getSnapshot(snapshot);
   * }
   * }</pre>
   *
   * @param snapshot Required. The name of the snapshot to get. Format is
   *     `projects/{project}/snapshots/{snap}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use Use {@link #getSnapshot(SnapshotName)} instead.
   */
  @Deprecated
  public final Snapshot getSnapshot(ProjectSnapshotName snapshot) {
    GetSnapshotRequest request =
        GetSnapshotRequest.newBuilder()
            .setSnapshot(snapshot == null ? null : snapshot.toString())
            .build();
    return getSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration details of a snapshot. Snapshots are used in
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   GetSnapshotRequest request =
   *       GetSnapshotRequest.newBuilder()
   *           .setSnapshot(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
   *           .build();
   *   ApiFuture<Snapshot> future =
   *       subscriptionAdminClient.getSnapshotCallable().futureCall(request);
   *   // Do something.
   *   Snapshot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable() {
    return stub.getSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing snapshots. Snapshots are used in [Seek](
   * https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage
   * message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in
   * an existing subscription to the state captured by a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Snapshot element : subscriptionAdminClient.listSnapshots(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Required. The name of the project in which to list snapshots. Format is
   *     `projects/{project-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnapshotsPagedResponse listSnapshots(ProjectName project) {
    ListSnapshotsRequest request =
        ListSnapshotsRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listSnapshots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing snapshots. Snapshots are used in [Seek](
   * https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage
   * message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in
   * an existing subscription to the state captured by a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String project = ProjectName.of("[PROJECT]").toString();
   *   for (Snapshot element : subscriptionAdminClient.listSnapshots(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Required. The name of the project in which to list snapshots. Format is
   *     `projects/{project-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnapshotsPagedResponse listSnapshots(String project) {
    ListSnapshotsRequest request = ListSnapshotsRequest.newBuilder().setProject(project).build();
    return listSnapshots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing snapshots. Snapshots are used in [Seek](
   * https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage
   * message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in
   * an existing subscription to the state captured by a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ListSnapshotsRequest request =
   *       ListSnapshotsRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Snapshot element : subscriptionAdminClient.listSnapshots(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnapshotsPagedResponse listSnapshots(ListSnapshotsRequest request) {
    return listSnapshotsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing snapshots. Snapshots are used in [Seek](
   * https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage
   * message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in
   * an existing subscription to the state captured by a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ListSnapshotsRequest request =
   *       ListSnapshotsRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Snapshot> future =
   *       subscriptionAdminClient.listSnapshotsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Snapshot element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSnapshotsRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable() {
    return stub.listSnapshotsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing snapshots. Snapshots are used in [Seek](
   * https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage
   * message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in
   * an existing subscription to the state captured by a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ListSnapshotsRequest request =
   *       ListSnapshotsRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSnapshotsResponse response =
   *         subscriptionAdminClient.listSnapshotsCallable().call(request);
   *     for (Snapshot element : response.getSnapshotsList()) {
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
  public final UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable() {
    return stub.listSnapshotsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot from the requested subscription. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot. If the snapshot
   * already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns
   * `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would
   * expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the
   * `Snapshot.expire_time` field. If the name is not provided in the request, the server will
   * assign a random name for this snapshot on the same project as the subscription, conforming to
   * the [resource name format] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
   * The generated name is populated in the returned Snapshot object. Note that for REST API
   * requests, you must specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SnapshotName name = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");
   *   SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   Snapshot response = subscriptionAdminClient.createSnapshot(name, subscription);
   * }
   * }</pre>
   *
   * @param name Required. User-provided name for this snapshot. If the name is not provided in the
   *     request, the server will assign a random name for this snapshot on the same project as the
   *     subscription. Note that for REST API requests, you must specify a name. See the [resource
   *     name rules](https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). Format is
   *     `projects/{project}/snapshots/{snap}`.
   * @param subscription Required. The subscription whose backlog the snapshot retains.
   *     Specifically, the created snapshot is guaranteed to retain: (a) The existing backlog on the
   *     subscription. More precisely, this is defined as the messages in the subscription's backlog
   *     that are unacknowledged upon the successful completion of the `CreateSnapshot` request; as
   *     well as: (b) Any messages published to the subscription's topic following the successful
   *     completion of the CreateSnapshot request. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot createSnapshot(SnapshotName name, SubscriptionName subscription) {
    CreateSnapshotRequest request =
        CreateSnapshotRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSubscription(subscription == null ? null : subscription.toString())
            .build();
    return createSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot from the requested subscription. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot. If the snapshot
   * already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns
   * `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would
   * expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the
   * `Snapshot.expire_time` field. If the name is not provided in the request, the server will
   * assign a random name for this snapshot on the same project as the subscription, conforming to
   * the [resource name format] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
   * The generated name is populated in the returned Snapshot object. Note that for REST API
   * requests, you must specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SnapshotName name = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");
   *   String subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   Snapshot response = subscriptionAdminClient.createSnapshot(name, subscription);
   * }
   * }</pre>
   *
   * @param name Required. User-provided name for this snapshot. If the name is not provided in the
   *     request, the server will assign a random name for this snapshot on the same project as the
   *     subscription. Note that for REST API requests, you must specify a name. See the [resource
   *     name rules](https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). Format is
   *     `projects/{project}/snapshots/{snap}`.
   * @param subscription Required. The subscription whose backlog the snapshot retains.
   *     Specifically, the created snapshot is guaranteed to retain: (a) The existing backlog on the
   *     subscription. More precisely, this is defined as the messages in the subscription's backlog
   *     that are unacknowledged upon the successful completion of the `CreateSnapshot` request; as
   *     well as: (b) Any messages published to the subscription's topic following the successful
   *     completion of the CreateSnapshot request. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot createSnapshot(SnapshotName name, String subscription) {
    CreateSnapshotRequest request =
        CreateSnapshotRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSubscription(subscription)
            .build();
    return createSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot from the requested subscription. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot. If the snapshot
   * already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns
   * `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would
   * expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the
   * `Snapshot.expire_time` field. If the name is not provided in the request, the server will
   * assign a random name for this snapshot on the same project as the subscription, conforming to
   * the [resource name format] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
   * The generated name is populated in the returned Snapshot object. Note that for REST API
   * requests, you must specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String name = SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString();
   *   SubscriptionName subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   Snapshot response = subscriptionAdminClient.createSnapshot(name, subscription);
   * }
   * }</pre>
   *
   * @param name Required. User-provided name for this snapshot. If the name is not provided in the
   *     request, the server will assign a random name for this snapshot on the same project as the
   *     subscription. Note that for REST API requests, you must specify a name. See the [resource
   *     name rules](https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). Format is
   *     `projects/{project}/snapshots/{snap}`.
   * @param subscription Required. The subscription whose backlog the snapshot retains.
   *     Specifically, the created snapshot is guaranteed to retain: (a) The existing backlog on the
   *     subscription. More precisely, this is defined as the messages in the subscription's backlog
   *     that are unacknowledged upon the successful completion of the `CreateSnapshot` request; as
   *     well as: (b) Any messages published to the subscription's topic following the successful
   *     completion of the CreateSnapshot request. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot createSnapshot(String name, SubscriptionName subscription) {
    CreateSnapshotRequest request =
        CreateSnapshotRequest.newBuilder()
            .setName(name)
            .setSubscription(subscription == null ? null : subscription.toString())
            .build();
    return createSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot from the requested subscription. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot. If the snapshot
   * already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns
   * `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would
   * expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the
   * `Snapshot.expire_time` field. If the name is not provided in the request, the server will
   * assign a random name for this snapshot on the same project as the subscription, conforming to
   * the [resource name format] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
   * The generated name is populated in the returned Snapshot object. Note that for REST API
   * requests, you must specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String name = SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString();
   *   String subscription = SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   Snapshot response = subscriptionAdminClient.createSnapshot(name, subscription);
   * }
   * }</pre>
   *
   * @param name Required. User-provided name for this snapshot. If the name is not provided in the
   *     request, the server will assign a random name for this snapshot on the same project as the
   *     subscription. Note that for REST API requests, you must specify a name. See the [resource
   *     name rules](https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). Format is
   *     `projects/{project}/snapshots/{snap}`.
   * @param subscription Required. The subscription whose backlog the snapshot retains.
   *     Specifically, the created snapshot is guaranteed to retain: (a) The existing backlog on the
   *     subscription. More precisely, this is defined as the messages in the subscription's backlog
   *     that are unacknowledged upon the successful completion of the `CreateSnapshot` request; as
   *     well as: (b) Any messages published to the subscription's topic following the successful
   *     completion of the CreateSnapshot request. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot createSnapshot(String name, String subscription) {
    CreateSnapshotRequest request =
        CreateSnapshotRequest.newBuilder().setName(name).setSubscription(subscription).build();
    return createSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot from the requested subscription. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot. If the snapshot
   * already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns
   * `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would
   * expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the
   * `Snapshot.expire_time` field. If the name is not provided in the request, the server will
   * assign a random name for this snapshot on the same project as the subscription, conforming to
   * the [resource name format] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
   * The generated name is populated in the returned Snapshot object. Note that for REST API
   * requests, you must specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   CreateSnapshotRequest request =
   *       CreateSnapshotRequest.newBuilder()
   *           .setName(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   Snapshot response = subscriptionAdminClient.createSnapshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot createSnapshot(CreateSnapshotRequest request) {
    return createSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot from the requested subscription. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot. If the snapshot
   * already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns
   * `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would
   * expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the
   * `Snapshot.expire_time` field. If the name is not provided in the request, the server will
   * assign a random name for this snapshot on the same project as the subscription, conforming to
   * the [resource name format] (https://cloud.google.com/pubsub/docs/admin#resource_names). The
   * generated name is populated in the returned Snapshot object. Note that for REST API requests,
   * you must specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSnapshotName name = ProjectSnapshotName.of("[PROJECT]", "[SNAPSHOT]");
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   Snapshot response = subscriptionAdminClient.createSnapshot(name, subscription);
   * }
   * }</pre>
   *
   * @param name Required. User-provided name for this snapshot. If the name is not provided in the
   *     request, the server will assign a random name for this snapshot on the same project as the
   *     subscription. Note that for REST API requests, you must specify a name. See the &lt;a
   *     href="https://cloud.google.com/pubsub/docs/admin#resource_names"&gt; resource name
   *     rules&lt;/a&gt;. Format is `projects/{project}/snapshots/{snap}`.
   * @param subscription Required. The subscription whose backlog the snapshot retains.
   *     Specifically, the created snapshot is guaranteed to retain: (a) The existing backlog on the
   *     subscription. More precisely, this is defined as the messages in the subscription's backlog
   *     that are unacknowledged upon the successful completion of the `CreateSnapshot` request; as
   *     well as: (b) Any messages published to the subscription's topic following the successful
   *     completion of the CreateSnapshot request. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use Use {@link #createSnapshot(SnapshotName, SubscriptionName)} instead.
   */
  @Deprecated
  public final Snapshot createSnapshot(
      ProjectSnapshotName name, ProjectSubscriptionName subscription) {
    CreateSnapshotRequest request =
        CreateSnapshotRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSubscription(subscription == null ? null : subscription.toString())
            .build();
    return createSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot from the requested subscription. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot. If the snapshot
   * already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns
   * `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would
   * expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the
   * `Snapshot.expire_time` field. If the name is not provided in the request, the server will
   * assign a random name for this snapshot on the same project as the subscription, conforming to
   * the [resource name format] (https://cloud.google.com/pubsub/docs/admin#resource_names). The
   * generated name is populated in the returned Snapshot object. Note that for REST API requests,
   * you must specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String name = ProjectSnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString();
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   Snapshot response = subscriptionAdminClient.createSnapshot(name, subscription);
   * }
   * }</pre>
   *
   * @param name Required. User-provided name for this snapshot. If the name is not provided in the
   *     request, the server will assign a random name for this snapshot on the same project as the
   *     subscription. Note that for REST API requests, you must specify a name. See the &lt;a
   *     href="https://cloud.google.com/pubsub/docs/admin#resource_names"&gt; resource name
   *     rules&lt;/a&gt;. Format is `projects/{project}/snapshots/{snap}`.
   * @param subscription Required. The subscription whose backlog the snapshot retains.
   *     Specifically, the created snapshot is guaranteed to retain: (a) The existing backlog on the
   *     subscription. More precisely, this is defined as the messages in the subscription's backlog
   *     that are unacknowledged upon the successful completion of the `CreateSnapshot` request; as
   *     well as: (b) Any messages published to the subscription's topic following the successful
   *     completion of the CreateSnapshot request. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use Use {@link #createSnapshot(String, SubscriptionName)} instead.
   */
  @Deprecated
  public final Snapshot createSnapshot(String name, ProjectSubscriptionName subscription) {
    CreateSnapshotRequest request =
        CreateSnapshotRequest.newBuilder()
            .setName(name)
            .setSubscription(subscription == null ? null : subscription.toString())
            .build();
    return createSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot from the requested subscription. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot. If the snapshot
   * already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns
   * `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would
   * expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the
   * `Snapshot.expire_time` field. If the name is not provided in the request, the server will
   * assign a random name for this snapshot on the same project as the subscription, conforming to
   * the [resource name format] (https://cloud.google.com/pubsub/docs/admin#resource_names). The
   * generated name is populated in the returned Snapshot object. Note that for REST API requests,
   * you must specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSnapshotName name = ProjectSnapshotName.of("[PROJECT]", "[SNAPSHOT]");
   *   String subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   Snapshot response = subscriptionAdminClient.createSnapshot(name, subscription);
   * }
   * }</pre>
   *
   * @param name Required. User-provided name for this snapshot. If the name is not provided in the
   *     request, the server will assign a random name for this snapshot on the same project as the
   *     subscription. Note that for REST API requests, you must specify a name. See the &lt;a
   *     href="https://cloud.google.com/pubsub/docs/admin#resource_names"&gt; resource name
   *     rules&lt;/a&gt;. Format is `projects/{project}/snapshots/{snap}`.
   * @param subscription Required. The subscription whose backlog the snapshot retains.
   *     Specifically, the created snapshot is guaranteed to retain: (a) The existing backlog on the
   *     subscription. More precisely, this is defined as the messages in the subscription's backlog
   *     that are unacknowledged upon the successful completion of the `CreateSnapshot` request; as
   *     well as: (b) Any messages published to the subscription's topic following the successful
   *     completion of the CreateSnapshot request. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use Use {@link #createSnapshot(SnapshotName, String)} instead.
   */
  @Deprecated
  public final Snapshot createSnapshot(ProjectSnapshotName name, String subscription) {
    CreateSnapshotRequest request =
        CreateSnapshotRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSubscription(subscription)
            .build();
    return createSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot from the requested subscription. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot. If the snapshot
   * already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns
   * `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would
   * expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the
   * `Snapshot.expire_time` field. If the name is not provided in the request, the server will
   * assign a random name for this snapshot on the same project as the subscription, conforming to
   * the [resource name format] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
   * The generated name is populated in the returned Snapshot object. Note that for REST API
   * requests, you must specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   CreateSnapshotRequest request =
   *       CreateSnapshotRequest.newBuilder()
   *           .setName(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<Snapshot> future =
   *       subscriptionAdminClient.createSnapshotCallable().futureCall(request);
   *   // Do something.
   *   Snapshot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSnapshotRequest, Snapshot> createSnapshotCallable() {
    return stub.createSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing snapshot by updating the fields specified in the update mask. Snapshots are
   * used in [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow
   * you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   Snapshot snapshot = Snapshot.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Snapshot response = subscriptionAdminClient.updateSnapshot(snapshot, updateMask);
   * }
   * }</pre>
   *
   * @param snapshot Required. The updated snapshot object.
   * @param updateMask Required. Indicates which fields in the provided snapshot to update. Must be
   *     specified and non-empty.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot updateSnapshot(Snapshot snapshot, FieldMask updateMask) {
    UpdateSnapshotRequest request =
        UpdateSnapshotRequest.newBuilder().setSnapshot(snapshot).setUpdateMask(updateMask).build();
    return updateSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing snapshot by updating the fields specified in the update mask. Snapshots are
   * used in [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow
   * you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   UpdateSnapshotRequest request =
   *       UpdateSnapshotRequest.newBuilder()
   *           .setSnapshot(Snapshot.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Snapshot response = subscriptionAdminClient.updateSnapshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot updateSnapshot(UpdateSnapshotRequest request) {
    return updateSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing snapshot by updating the fields specified in the update mask. Snapshots are
   * used in [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow
   * you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   UpdateSnapshotRequest request =
   *       UpdateSnapshotRequest.newBuilder()
   *           .setSnapshot(Snapshot.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Snapshot> future =
   *       subscriptionAdminClient.updateSnapshotCallable().futureCall(request);
   *   // Do something.
   *   Snapshot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSnapshotRequest, Snapshot> updateSnapshotCallable() {
    return stub.updateSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an existing snapshot. Snapshots are used in [Seek]
   * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage
   * message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in
   * an existing subscription to the state captured by a snapshot. When the snapshot is deleted, all
   * messages retained in the snapshot are immediately dropped. After a snapshot is deleted, a new
   * one may be created with the same name, but the new one has no association with the old snapshot
   * or its subscription, unless the same subscription is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SnapshotName snapshot = SnapshotName.of("[PROJECT]", "[SNAPSHOT]");
   *   subscriptionAdminClient.deleteSnapshot(snapshot);
   * }
   * }</pre>
   *
   * @param snapshot Required. The name of the snapshot to delete. Format is
   *     `projects/{project}/snapshots/{snap}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSnapshot(SnapshotName snapshot) {
    DeleteSnapshotRequest request =
        DeleteSnapshotRequest.newBuilder()
            .setSnapshot(snapshot == null ? null : snapshot.toString())
            .build();
    deleteSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an existing snapshot. Snapshots are used in [Seek]
   * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage
   * message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in
   * an existing subscription to the state captured by a snapshot. When the snapshot is deleted, all
   * messages retained in the snapshot are immediately dropped. After a snapshot is deleted, a new
   * one may be created with the same name, but the new one has no association with the old snapshot
   * or its subscription, unless the same subscription is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String snapshot = SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString();
   *   subscriptionAdminClient.deleteSnapshot(snapshot);
   * }
   * }</pre>
   *
   * @param snapshot Required. The name of the snapshot to delete. Format is
   *     `projects/{project}/snapshots/{snap}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSnapshot(String snapshot) {
    DeleteSnapshotRequest request =
        DeleteSnapshotRequest.newBuilder().setSnapshot(snapshot).build();
    deleteSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an existing snapshot. Snapshots are used in [Seek]
   * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage
   * message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in
   * an existing subscription to the state captured by a snapshot. When the snapshot is deleted, all
   * messages retained in the snapshot are immediately dropped. After a snapshot is deleted, a new
   * one may be created with the same name, but the new one has no association with the old snapshot
   * or its subscription, unless the same subscription is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   DeleteSnapshotRequest request =
   *       DeleteSnapshotRequest.newBuilder()
   *           .setSnapshot(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
   *           .build();
   *   subscriptionAdminClient.deleteSnapshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSnapshot(DeleteSnapshotRequest request) {
    deleteSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an existing snapshot. Snapshots are used in [Seek]
   * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage
   * message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in
   * an existing subscription to the state captured by a snapshot. When the snapshot is deleted, all
   * messages retained in the snapshot are immediately dropped. After a snapshot is deleted, a new
   * one may be created with the same name, but the new one has no association with the old snapshot
   * or its subscription, unless the same subscription is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSnapshotName snapshot = ProjectSnapshotName.of("[PROJECT]", "[SNAPSHOT]");
   *   subscriptionAdminClient.deleteSnapshot(snapshot);
   * }
   * }</pre>
   *
   * @param snapshot Required. The name of the snapshot to delete. Format is
   *     `projects/{project}/snapshots/{snap}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use Use {@link #deleteSnapshot(SnapshotName)} instead.
   */
  @Deprecated
  public final void deleteSnapshot(ProjectSnapshotName snapshot) {
    DeleteSnapshotRequest request =
        DeleteSnapshotRequest.newBuilder()
            .setSnapshot(snapshot == null ? null : snapshot.toString())
            .build();
    deleteSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an existing snapshot. Snapshots are used in [Seek]
   * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage
   * message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in
   * an existing subscription to the state captured by a snapshot. When the snapshot is deleted, all
   * messages retained in the snapshot are immediately dropped. After a snapshot is deleted, a new
   * one may be created with the same name, but the new one has no association with the old snapshot
   * or its subscription, unless the same subscription is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   DeleteSnapshotRequest request =
   *       DeleteSnapshotRequest.newBuilder()
   *           .setSnapshot(SnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       subscriptionAdminClient.deleteSnapshotCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSnapshotRequest, Empty> deleteSnapshotCallable() {
    return stub.deleteSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Seeks an existing subscription to a point in time or to a given snapshot, whichever is provided
   * in the request. Snapshots are used in [Seek]
   * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage
   * message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in
   * an existing subscription to the state captured by a snapshot. Note that both the subscription
   * and the snapshot must be on the same topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SeekRequest request =
   *       SeekRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   SeekResponse response = subscriptionAdminClient.seek(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SeekResponse seek(SeekRequest request) {
    return seekCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Seeks an existing subscription to a point in time or to a given snapshot, whichever is provided
   * in the request. Snapshots are used in [Seek]
   * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage
   * message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in
   * an existing subscription to the state captured by a snapshot. Note that both the subscription
   * and the snapshot must be on the same topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SeekRequest request =
   *       SeekRequest.newBuilder()
   *           .setSubscription(SubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   ApiFuture<SeekResponse> future = subscriptionAdminClient.seekCallable().futureCall(request);
   *   // Do something.
   *   SeekResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SeekRequest, SeekResponse> seekCallable() {
    return stub.seekCallable();
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = subscriptionAdminClient.setIamPolicy(request);
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = subscriptionAdminClient.setIamPolicy(formattedResource, policy);
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = subscriptionAdminClient.setIamPolicyCallable().futureCall(request);
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = subscriptionAdminClient.getIamPolicy(request);
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   Policy response = subscriptionAdminClient.getIamPolicy(formattedResource);
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = subscriptionAdminClient.getIamPolicyCallable().futureCall(request);
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = subscriptionAdminClient.testIamPermissions(request);
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = subscriptionAdminClient.testIamPermissions(formattedResource, permissions);
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
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       subscriptionAdminClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListSubscriptionsPagedResponse
      extends AbstractPagedListResponse<
          ListSubscriptionsRequest,
          ListSubscriptionsResponse,
          Subscription,
          ListSubscriptionsPage,
          ListSubscriptionsFixedSizeCollection> {

    public static ApiFuture<ListSubscriptionsPagedResponse> createAsync(
        PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> context,
        ApiFuture<ListSubscriptionsResponse> futureResponse) {
      ApiFuture<ListSubscriptionsPage> futurePage =
          ListSubscriptionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSubscriptionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSubscriptionsPagedResponse(ListSubscriptionsPage page) {
      super(page, ListSubscriptionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSubscriptionsPage
      extends AbstractPage<
          ListSubscriptionsRequest,
          ListSubscriptionsResponse,
          Subscription,
          ListSubscriptionsPage> {

    private ListSubscriptionsPage(
        PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> context,
        ListSubscriptionsResponse response) {
      super(context, response);
    }

    private static ListSubscriptionsPage createEmptyPage() {
      return new ListSubscriptionsPage(null, null);
    }

    @Override
    protected ListSubscriptionsPage createPage(
        PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> context,
        ListSubscriptionsResponse response) {
      return new ListSubscriptionsPage(context, response);
    }

    @Override
    public ApiFuture<ListSubscriptionsPage> createPageAsync(
        PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> context,
        ApiFuture<ListSubscriptionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSubscriptionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSubscriptionsRequest,
          ListSubscriptionsResponse,
          Subscription,
          ListSubscriptionsPage,
          ListSubscriptionsFixedSizeCollection> {

    private ListSubscriptionsFixedSizeCollection(
        List<ListSubscriptionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSubscriptionsFixedSizeCollection createEmptyCollection() {
      return new ListSubscriptionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSubscriptionsFixedSizeCollection createCollection(
        List<ListSubscriptionsPage> pages, int collectionSize) {
      return new ListSubscriptionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSnapshotsPagedResponse
      extends AbstractPagedListResponse<
          ListSnapshotsRequest,
          ListSnapshotsResponse,
          Snapshot,
          ListSnapshotsPage,
          ListSnapshotsFixedSizeCollection> {

    public static ApiFuture<ListSnapshotsPagedResponse> createAsync(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ApiFuture<ListSnapshotsResponse> futureResponse) {
      ApiFuture<ListSnapshotsPage> futurePage =
          ListSnapshotsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSnapshotsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSnapshotsPagedResponse(ListSnapshotsPage page) {
      super(page, ListSnapshotsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSnapshotsPage
      extends AbstractPage<
          ListSnapshotsRequest, ListSnapshotsResponse, Snapshot, ListSnapshotsPage> {

    private ListSnapshotsPage(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ListSnapshotsResponse response) {
      super(context, response);
    }

    private static ListSnapshotsPage createEmptyPage() {
      return new ListSnapshotsPage(null, null);
    }

    @Override
    protected ListSnapshotsPage createPage(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ListSnapshotsResponse response) {
      return new ListSnapshotsPage(context, response);
    }

    @Override
    public ApiFuture<ListSnapshotsPage> createPageAsync(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ApiFuture<ListSnapshotsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSnapshotsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSnapshotsRequest,
          ListSnapshotsResponse,
          Snapshot,
          ListSnapshotsPage,
          ListSnapshotsFixedSizeCollection> {

    private ListSnapshotsFixedSizeCollection(List<ListSnapshotsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSnapshotsFixedSizeCollection createEmptyCollection() {
      return new ListSnapshotsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSnapshotsFixedSizeCollection createCollection(
        List<ListSnapshotsPage> pages, int collectionSize) {
      return new ListSnapshotsFixedSizeCollection(pages, collectionSize);
    }
  }
}

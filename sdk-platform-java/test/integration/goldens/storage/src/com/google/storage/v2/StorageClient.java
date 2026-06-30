/*
 * Copyright 2026 Google LLC
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

package com.google.storage.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.storage.v2.stub.StorageStub;
import com.google.storage.v2.stub.StorageStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: ## API Overview and Naming Syntax
 *
 * <p>The Cloud Storage gRPC API allows applications to read and write data through the abstractions
 * of buckets and objects. For a description of these abstractions please see
 * https://cloud.google.com/storage/docs.
 *
 * <p>Resources are named as follows: - Projects are referred to as they are defined by the Resource
 * Manager API, using strings like `projects/123456` or `projects/my-string-id`. - Buckets are named
 * using string names of the form: `projects/{project}/buckets/{bucket}` For globally unique
 * buckets, `_` may be substituted for the project. - Objects are uniquely identified by their name
 * along with the name of the bucket they belong to, as separate strings in this API. For example:
 *
 * <p>ReadObjectRequest { bucket: 'projects/_/buckets/my-bucket' object: 'my-object' } Note that
 * object names can contain `/` characters, which are treated as any other character (no special
 * directory semantics).
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
 * try (StorageClient storageClient = StorageClient.create()) {
 *   BucketName name = BucketName.of("[PROJECT]", "[BUCKET]");
 *   storageClient.deleteBucket(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the StorageClient object to clean up resources such as
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
 *      <td><p> DeleteBucket</td>
 *      <td><p> Permanently deletes an empty bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBucket(DeleteBucketRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteBucket(BucketName name)
 *           <li><p> deleteBucket(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBucketCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBucket</td>
 *      <td><p> Returns metadata for the specified bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBucket(GetBucketRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBucket(BucketName name)
 *           <li><p> getBucket(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBucketCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBucket</td>
 *      <td><p> Creates a new bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBucket(CreateBucketRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createBucket(ProjectName parent, Bucket bucket, String bucketId)
 *           <li><p> createBucket(String parent, Bucket bucket, String bucketId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBucketCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBuckets</td>
 *      <td><p> Retrieves a list of buckets for a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBuckets(ListBucketsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBuckets(ProjectName parent)
 *           <li><p> listBuckets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBucketsPagedCallable()
 *           <li><p> listBucketsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> LockBucketRetentionPolicy</td>
 *      <td><p> Locks retention policy on a bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> lockBucketRetentionPolicy(LockBucketRetentionPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> lockBucketRetentionPolicy(BucketName bucket)
 *           <li><p> lockBucketRetentionPolicy(String bucket)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> lockBucketRetentionPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the IAM policy for a specified bucket or object. The `resource` field in the request should be projects/_/buckets/&lt;bucket_name&gt; for a bucket or projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIamPolicy(ResourceName resource)
 *           <li><p> getIamPolicy(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Updates an IAM policy for the specified bucket or object. The `resource` field in the request should be projects/_/buckets/&lt;bucket_name&gt; for a bucket or projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setIamPolicy(ResourceName resource, Policy policy)
 *           <li><p> setIamPolicy(String resource, Policy policy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Tests a set of permissions on the given bucket or object to see which, if any, are held by the caller. The `resource` field in the request should be projects/_/buckets/&lt;bucket_name&gt; for a bucket or projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> testIamPermissions(ResourceName resource, List&lt;String&gt; permissions)
 *           <li><p> testIamPermissions(String resource, List&lt;String&gt; permissions)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBucket</td>
 *      <td><p> Updates a bucket. Equivalent to JSON API's storage.buckets.patch method.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBucket(UpdateBucketRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateBucket(Bucket bucket, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBucketCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteNotification</td>
 *      <td><p> Permanently deletes a notification subscription.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteNotification(DeleteNotificationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteNotification(NotificationName name)
 *           <li><p> deleteNotification(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteNotificationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNotification</td>
 *      <td><p> View a notification config.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNotification(GetNotificationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNotification(BucketName name)
 *           <li><p> getNotification(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNotificationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateNotification</td>
 *      <td><p> Creates a notification subscription for a given bucket. These notifications, when triggered, publish messages to the specified Pub/Sub topics. See https://cloud.google.com/storage/docs/pubsub-notifications.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createNotification(CreateNotificationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createNotification(ProjectName parent, Notification notification)
 *           <li><p> createNotification(String parent, Notification notification)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createNotificationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNotifications</td>
 *      <td><p> Retrieves a list of notification subscriptions for a given bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNotifications(ListNotificationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNotifications(ProjectName parent)
 *           <li><p> listNotifications(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNotificationsPagedCallable()
 *           <li><p> listNotificationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ComposeObject</td>
 *      <td><p> Concatenates a list of existing objects into a new object in the same bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> composeObject(ComposeObjectRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> composeObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteObject</td>
 *      <td><p> Deletes an object and its metadata. Deletions are permanent if versioning is not enabled for the bucket, or if the `generation` parameter is used.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteObject(DeleteObjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteObject(String bucket, String object)
 *           <li><p> deleteObject(String bucket, String object, long generation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CancelResumableWrite</td>
 *      <td><p> Cancels an in-progress resumable upload.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelResumableWrite(CancelResumableWriteRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> cancelResumableWrite(String uploadId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelResumableWriteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetObject</td>
 *      <td><p> Retrieves an object's metadata.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getObject(GetObjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getObject(String bucket, String object)
 *           <li><p> getObject(String bucket, String object, long generation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReadObject</td>
 *      <td><p> Reads an object's data.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> readObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateObject</td>
 *      <td><p> Updates an object's metadata. Equivalent to JSON API's storage.objects.patch.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateObject(UpdateObjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateObject(Object object, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> WriteObject</td>
 *      <td><p> Stores a new object and metadata.
 * <p>  An object can be written either in a single message stream or in a resumable sequence of message streams. To write using a single stream, the client should include in the first message of the stream an `WriteObjectSpec` describing the destination bucket, object, and any preconditions. Additionally, the final message must set 'finish_write' to true, or else it is an error.
 * <p>  For a resumable write, the client should instead call `StartResumableWrite()`, populating a `WriteObjectSpec` into that request. They should then attach the returned `upload_id` to the first message of each following call to `WriteObject`. If the stream is closed before finishing the upload (either explicitly by the client or due to a network error or an error response from the server), the client should do as follows:   - Check the result Status of the stream, to determine if writing can be     resumed on this stream or must be restarted from scratch (by calling     `StartResumableWrite()`). The resumable errors are DEADLINE_EXCEEDED,     INTERNAL, and UNAVAILABLE. For each case, the client should use binary     exponential backoff before retrying.  Additionally, writes can be     resumed after RESOURCE_EXHAUSTED errors, but only after taking     appropriate measures, which may include reducing aggregate send rate     across clients and/or requesting a quota increase for your project.   - If the call to `WriteObject` returns `ABORTED`, that indicates     concurrent attempts to update the resumable write, caused either by     multiple racing clients or by a single client where the previous     request was timed out on the client side but nonetheless reached the     server. In this case the client should take steps to prevent further     concurrent writes (e.g., increase the timeouts, stop using more than     one process to perform the upload, etc.), and then should follow the     steps below for resuming the upload.   - For resumable errors, the client should call `QueryWriteStatus()` and     then continue writing from the returned `persisted_size`. This may be     less than the amount of data the client previously sent. Note also that     it is acceptable to send data starting at an offset earlier than the     returned `persisted_size`; in this case, the service will skip data at     offsets that were already persisted (without checking that it matches     the previously written data), and write only the data starting from the     persisted offset. This behavior can make client-side handling simpler     in some cases.
 * <p>  The service will not view the object as complete until the client has sent a `WriteObjectRequest` with `finish_write` set to `true`. Sending any requests on a stream after sending a request with `finish_write` set to `true` will cause an error. The client &#42;&#42;should&#42;&#42; check the response it receives to determine how much data the service was able to commit and whether the service views the object as complete.
 * <p>  Attempting to resume an already finalized object will result in an OK status, with a WriteObjectResponse containing the finalized object's metadata.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> writeObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListObjects</td>
 *      <td><p> Retrieves a list of objects matching the criteria.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listObjects(ListObjectsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listObjects(ProjectName parent)
 *           <li><p> listObjects(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listObjectsPagedCallable()
 *           <li><p> listObjectsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RewriteObject</td>
 *      <td><p> Rewrites a source object to a destination object. Optionally overrides metadata.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rewriteObject(RewriteObjectRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rewriteObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StartResumableWrite</td>
 *      <td><p> Starts a resumable write. How long the write operation remains valid, and what happens when the write operation becomes invalid, are service-dependent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> startResumableWrite(StartResumableWriteRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> startResumableWriteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryWriteStatus</td>
 *      <td><p> Determines the `persisted_size` for an object that is being written, which can then be used as the `write_offset` for the next `Write()` call.
 * <p>  If the object does not exist (i.e., the object has been deleted, or the first `Write()` has not yet reached the service), this method returns the error `NOT_FOUND`.
 * <p>  The client &#42;&#42;may&#42;&#42; call `QueryWriteStatus()` at any time to determine how much data has been processed for this object. This is useful if the client is buffering data and needs to know which data can be safely evicted. For any sequence of `QueryWriteStatus()` calls for a given object name, the sequence of returned `persisted_size` values will be non-decreasing.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryWriteStatus(QueryWriteStatusRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> queryWriteStatus(String uploadId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryWriteStatusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetServiceAccount</td>
 *      <td><p> Retrieves the name of a project's Google Cloud Storage service account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getServiceAccount(GetServiceAccountRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getServiceAccount(ProjectName project)
 *           <li><p> getServiceAccount(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getServiceAccountCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateHmacKey</td>
 *      <td><p> Creates a new HMAC key for the given service account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createHmacKey(CreateHmacKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createHmacKey(ProjectName project, String serviceAccountEmail)
 *           <li><p> createHmacKey(String project, String serviceAccountEmail)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createHmacKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteHmacKey</td>
 *      <td><p> Deletes a given HMAC key.  Key must be in an INACTIVE state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteHmacKey(DeleteHmacKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteHmacKey(String accessId, ProjectName project)
 *           <li><p> deleteHmacKey(String accessId, String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteHmacKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetHmacKey</td>
 *      <td><p> Gets an existing HMAC key metadata for the given id.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHmacKey(GetHmacKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHmacKey(String accessId, ProjectName project)
 *           <li><p> getHmacKey(String accessId, String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHmacKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListHmacKeys</td>
 *      <td><p> Lists HMAC keys under a given project with the additional filters provided.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listHmacKeys(ListHmacKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listHmacKeys(ProjectName project)
 *           <li><p> listHmacKeys(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listHmacKeysPagedCallable()
 *           <li><p> listHmacKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateHmacKey</td>
 *      <td><p> Updates a given HMAC key state between ACTIVE and INACTIVE.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateHmacKey(UpdateHmacKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateHmacKey(HmacKeyMetadata hmacKey, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateHmacKeyCallable()
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
 * <p>This class can be customized by passing in a custom instance of StorageSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StorageSettings storageSettings =
 *     StorageSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * StorageClient storageClient = StorageClient.create(storageSettings);
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
 * StorageSettings storageSettings = StorageSettings.newBuilder().setEndpoint(myEndpoint).build();
 * StorageClient storageClient = StorageClient.create(storageSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class StorageClient implements BackgroundResource {
  private final StorageSettings settings;
  private final StorageStub stub;

  /** Constructs an instance of StorageClient with default settings. */
  public static final StorageClient create() throws IOException {
    return create(StorageSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of StorageClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final StorageClient create(StorageSettings settings) throws IOException {
    return new StorageClient(settings);
  }

  /**
   * Constructs an instance of StorageClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(StorageSettings).
   */
  public static final StorageClient create(StorageStub stub) {
    return new StorageClient(stub);
  }

  /**
   * Constructs an instance of StorageClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected StorageClient(StorageSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((StorageStubSettings) settings.getStubSettings()).createStub();
  }

  protected StorageClient(StorageStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final StorageSettings getSettings() {
    return settings;
  }

  public StorageStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes an empty bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   BucketName name = BucketName.of("[PROJECT]", "[BUCKET]");
   *   storageClient.deleteBucket(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of a bucket to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBucket(BucketName name) {
    DeleteBucketRequest request =
        DeleteBucketRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes an empty bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String name = BucketName.of("[PROJECT]", "[BUCKET]").toString();
   *   storageClient.deleteBucket(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of a bucket to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBucket(String name) {
    DeleteBucketRequest request = DeleteBucketRequest.newBuilder().setName(name).build();
    deleteBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes an empty bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   DeleteBucketRequest request =
   *       DeleteBucketRequest.newBuilder()
   *           .setName(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .build();
   *   storageClient.deleteBucket(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBucket(DeleteBucketRequest request) {
    deleteBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes an empty bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   DeleteBucketRequest request =
   *       DeleteBucketRequest.newBuilder()
   *           .setName(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .build();
   *   ApiFuture<Empty> future = storageClient.deleteBucketCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBucketRequest, Empty> deleteBucketCallable() {
    return stub.deleteBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for the specified bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   BucketName name = BucketName.of("[PROJECT]", "[BUCKET]");
   *   Bucket response = storageClient.getBucket(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of a bucket.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket getBucket(BucketName name) {
    GetBucketRequest request =
        GetBucketRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for the specified bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String name = BucketName.of("[PROJECT]", "[BUCKET]").toString();
   *   Bucket response = storageClient.getBucket(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of a bucket.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket getBucket(String name) {
    GetBucketRequest request = GetBucketRequest.newBuilder().setName(name).build();
    return getBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for the specified bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   GetBucketRequest request =
   *       GetBucketRequest.newBuilder()
   *           .setName(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   Bucket response = storageClient.getBucket(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket getBucket(GetBucketRequest request) {
    return getBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for the specified bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   GetBucketRequest request =
   *       GetBucketRequest.newBuilder()
   *           .setName(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Bucket> future = storageClient.getBucketCallable().futureCall(request);
   *   // Do something.
   *   Bucket response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBucketRequest, Bucket> getBucketCallable() {
    return stub.getBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Bucket bucket = Bucket.newBuilder().build();
   *   String bucketId = "bucketId-1603305307";
   *   Bucket response = storageClient.createBucket(parent, bucket, bucketId);
   * }
   * }</pre>
   *
   * @param parent Required. The project to which this bucket will belong.
   * @param bucket Properties of the new bucket being inserted. The project and name of the bucket
   *     are specified in the parent and bucket_id fields, respectively. Populating those fields in
   *     `bucket` will result in an error.
   * @param bucketId Required. The ID to use for this bucket, which will become the final component
   *     of the bucket's resource name. For example, the value `foo` might result in a bucket with
   *     the name `projects/123456/buckets/foo`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket createBucket(ProjectName parent, Bucket bucket, String bucketId) {
    CreateBucketRequest request =
        CreateBucketRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBucket(bucket)
            .setBucketId(bucketId)
            .build();
    return createBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Bucket bucket = Bucket.newBuilder().build();
   *   String bucketId = "bucketId-1603305307";
   *   Bucket response = storageClient.createBucket(parent, bucket, bucketId);
   * }
   * }</pre>
   *
   * @param parent Required. The project to which this bucket will belong.
   * @param bucket Properties of the new bucket being inserted. The project and name of the bucket
   *     are specified in the parent and bucket_id fields, respectively. Populating those fields in
   *     `bucket` will result in an error.
   * @param bucketId Required. The ID to use for this bucket, which will become the final component
   *     of the bucket's resource name. For example, the value `foo` might result in a bucket with
   *     the name `projects/123456/buckets/foo`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket createBucket(String parent, Bucket bucket, String bucketId) {
    CreateBucketRequest request =
        CreateBucketRequest.newBuilder()
            .setParent(parent)
            .setBucket(bucket)
            .setBucketId(bucketId)
            .build();
    return createBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   CreateBucketRequest request =
   *       CreateBucketRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setBucket(Bucket.newBuilder().build())
   *           .setBucketId("bucketId-1603305307")
   *           .setPredefinedAcl("predefinedAcl1207041188")
   *           .setPredefinedDefaultObjectAcl("predefinedDefaultObjectAcl2109168048")
   *           .build();
   *   Bucket response = storageClient.createBucket(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket createBucket(CreateBucketRequest request) {
    return createBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   CreateBucketRequest request =
   *       CreateBucketRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setBucket(Bucket.newBuilder().build())
   *           .setBucketId("bucketId-1603305307")
   *           .setPredefinedAcl("predefinedAcl1207041188")
   *           .setPredefinedDefaultObjectAcl("predefinedDefaultObjectAcl2109168048")
   *           .build();
   *   ApiFuture<Bucket> future = storageClient.createBucketCallable().futureCall(request);
   *   // Do something.
   *   Bucket response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBucketRequest, Bucket> createBucketCallable() {
    return stub.createBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of buckets for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Bucket element : storageClient.listBuckets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project whose buckets we are listing.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBucketsPagedResponse listBuckets(ProjectName parent) {
    ListBucketsRequest request =
        ListBucketsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBuckets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of buckets for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Bucket element : storageClient.listBuckets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project whose buckets we are listing.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBucketsPagedResponse listBuckets(String parent) {
    ListBucketsRequest request = ListBucketsRequest.newBuilder().setParent(parent).build();
    return listBuckets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of buckets for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ListBucketsRequest request =
   *       ListBucketsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setPrefix("prefix-980110702")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (Bucket element : storageClient.listBuckets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBucketsPagedResponse listBuckets(ListBucketsRequest request) {
    return listBucketsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of buckets for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ListBucketsRequest request =
   *       ListBucketsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setPrefix("prefix-980110702")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Bucket> future = storageClient.listBucketsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Bucket element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBucketsRequest, ListBucketsPagedResponse>
      listBucketsPagedCallable() {
    return stub.listBucketsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of buckets for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ListBucketsRequest request =
   *       ListBucketsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setPrefix("prefix-980110702")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListBucketsResponse response = storageClient.listBucketsCallable().call(request);
   *     for (Bucket element : response.getBucketsList()) {
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
  public final UnaryCallable<ListBucketsRequest, ListBucketsResponse> listBucketsCallable() {
    return stub.listBucketsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks retention policy on a bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   BucketName bucket = BucketName.of("[PROJECT]", "[BUCKET]");
   *   Bucket response = storageClient.lockBucketRetentionPolicy(bucket);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of a bucket.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket lockBucketRetentionPolicy(BucketName bucket) {
    LockBucketRetentionPolicyRequest request =
        LockBucketRetentionPolicyRequest.newBuilder()
            .setBucket(bucket == null ? null : bucket.toString())
            .build();
    return lockBucketRetentionPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks retention policy on a bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String bucket = BucketName.of("[PROJECT]", "[BUCKET]").toString();
   *   Bucket response = storageClient.lockBucketRetentionPolicy(bucket);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of a bucket.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket lockBucketRetentionPolicy(String bucket) {
    LockBucketRetentionPolicyRequest request =
        LockBucketRetentionPolicyRequest.newBuilder().setBucket(bucket).build();
    return lockBucketRetentionPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks retention policy on a bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   LockBucketRetentionPolicyRequest request =
   *       LockBucketRetentionPolicyRequest.newBuilder()
   *           .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .build();
   *   Bucket response = storageClient.lockBucketRetentionPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket lockBucketRetentionPolicy(LockBucketRetentionPolicyRequest request) {
    return lockBucketRetentionPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks retention policy on a bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   LockBucketRetentionPolicyRequest request =
   *       LockBucketRetentionPolicyRequest.newBuilder()
   *           .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setIfMetagenerationMatch(1043427781)
   *           .build();
   *   ApiFuture<Bucket> future =
   *       storageClient.lockBucketRetentionPolicyCallable().futureCall(request);
   *   // Do something.
   *   Bucket response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LockBucketRetentionPolicyRequest, Bucket>
      lockBucketRetentionPolicyCallable() {
    return stub.lockBucketRetentionPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy for a specified bucket or object. The `resource` field in the request
   * should be projects/_/buckets/&lt;bucket_name&gt; for a bucket or
   * projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ResourceName resource =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   Policy response = storageClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy for a specified bucket or object. The `resource` field in the request
   * should be projects/_/buckets/&lt;bucket_name&gt; for a bucket or
   * projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String resource =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]").toString();
   *   Policy response = storageClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy for a specified bucket or object. The `resource` field in the request
   * should be projects/_/buckets/&lt;bucket_name&gt; for a bucket or
   * projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = storageClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy for a specified bucket or object. The `resource` field in the request
   * should be projects/_/buckets/&lt;bucket_name&gt; for a bucket or
   * projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = storageClient.getIamPolicyCallable().futureCall(request);
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
   * Updates an IAM policy for the specified bucket or object. The `resource` field in the request
   * should be projects/_/buckets/&lt;bucket_name&gt; for a bucket or
   * projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ResourceName resource =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = storageClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IAM policy for the specified bucket or object. The `resource` field in the request
   * should be projects/_/buckets/&lt;bucket_name&gt; for a bucket or
   * projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String resource =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = storageClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IAM policy for the specified bucket or object. The `resource` field in the request
   * should be projects/_/buckets/&lt;bucket_name&gt; for a bucket or
   * projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = storageClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IAM policy for the specified bucket or object. The `resource` field in the request
   * should be projects/_/buckets/&lt;bucket_name&gt; for a bucket or
   * projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = storageClient.setIamPolicyCallable().futureCall(request);
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
   * Tests a set of permissions on the given bucket or object to see which, if any, are held by the
   * caller. The `resource` field in the request should be projects/_/buckets/&lt;bucket_name&gt;
   * for a bucket or projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an
   * object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ResourceName resource =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response = storageClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests a set of permissions on the given bucket or object to see which, if any, are held by the
   * caller. The `resource` field in the request should be projects/_/buckets/&lt;bucket_name&gt;
   * for a bucket or projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an
   * object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String resource =
   *       CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]").toString();
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response = storageClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests a set of permissions on the given bucket or object to see which, if any, are held by the
   * caller. The `resource` field in the request should be projects/_/buckets/&lt;bucket_name&gt;
   * for a bucket or projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an
   * object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = storageClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests a set of permissions on the given bucket or object to see which, if any, are held by the
   * caller. The `resource` field in the request should be projects/_/buckets/&lt;bucket_name&gt;
   * for a bucket or projects/_/buckets/&lt;bucket_name&gt;/objects/&lt;object_name&gt; for an
   * object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       storageClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a bucket. Equivalent to JSON API's storage.buckets.patch method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   Bucket bucket = Bucket.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Bucket response = storageClient.updateBucket(bucket, updateMask);
   * }
   * }</pre>
   *
   * @param bucket Required. The bucket to update. The bucket's `name` field will be used to
   *     identify the bucket.
   * @param updateMask Required. List of fields to be updated.
   *     <p>To specify ALL fields, equivalent to the JSON API's "update" function, specify a single
   *     field with the value `&#42;`. Note: not recommended. If a new field is introduced at a
   *     later time, an older client updating with the `&#42;` may accidentally reset the new
   *     field's value.
   *     <p>Not specifying any fields is an error. Not specifying a field while setting that field
   *     to a non-default value is an error.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket updateBucket(Bucket bucket, FieldMask updateMask) {
    UpdateBucketRequest request =
        UpdateBucketRequest.newBuilder().setBucket(bucket).setUpdateMask(updateMask).build();
    return updateBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a bucket. Equivalent to JSON API's storage.buckets.patch method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   UpdateBucketRequest request =
   *       UpdateBucketRequest.newBuilder()
   *           .setBucket(Bucket.newBuilder().build())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setPredefinedAcl("predefinedAcl1207041188")
   *           .setPredefinedDefaultObjectAcl("predefinedDefaultObjectAcl2109168048")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Bucket response = storageClient.updateBucket(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket updateBucket(UpdateBucketRequest request) {
    return updateBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a bucket. Equivalent to JSON API's storage.buckets.patch method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   UpdateBucketRequest request =
   *       UpdateBucketRequest.newBuilder()
   *           .setBucket(Bucket.newBuilder().build())
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setPredefinedAcl("predefinedAcl1207041188")
   *           .setPredefinedDefaultObjectAcl("predefinedDefaultObjectAcl2109168048")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Bucket> future = storageClient.updateBucketCallable().futureCall(request);
   *   // Do something.
   *   Bucket response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBucketRequest, Bucket> updateBucketCallable() {
    return stub.updateBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a notification subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   NotificationName name = NotificationName.of("[PROJECT]", "[BUCKET]", "[NOTIFICATION]");
   *   storageClient.deleteNotification(name);
   * }
   * }</pre>
   *
   * @param name Required. The parent bucket of the notification.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNotification(NotificationName name) {
    DeleteNotificationRequest request =
        DeleteNotificationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteNotification(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a notification subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String name = NotificationName.of("[PROJECT]", "[BUCKET]", "[NOTIFICATION]").toString();
   *   storageClient.deleteNotification(name);
   * }
   * }</pre>
   *
   * @param name Required. The parent bucket of the notification.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNotification(String name) {
    DeleteNotificationRequest request =
        DeleteNotificationRequest.newBuilder().setName(name).build();
    deleteNotification(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a notification subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   DeleteNotificationRequest request =
   *       DeleteNotificationRequest.newBuilder()
   *           .setName(NotificationName.of("[PROJECT]", "[BUCKET]", "[NOTIFICATION]").toString())
   *           .build();
   *   storageClient.deleteNotification(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNotification(DeleteNotificationRequest request) {
    deleteNotificationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a notification subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   DeleteNotificationRequest request =
   *       DeleteNotificationRequest.newBuilder()
   *           .setName(NotificationName.of("[PROJECT]", "[BUCKET]", "[NOTIFICATION]").toString())
   *           .build();
   *   ApiFuture<Empty> future = storageClient.deleteNotificationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNotificationRequest, Empty> deleteNotificationCallable() {
    return stub.deleteNotificationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * View a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   BucketName name = BucketName.of("[PROJECT]", "[BUCKET]");
   *   Notification response = storageClient.getNotification(name);
   * }
   * }</pre>
   *
   * @param name Required. The parent bucket of the notification. Format:
   *     `projects/{project}/buckets/{bucket}/notificationConfigs/{notification}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Notification getNotification(BucketName name) {
    GetNotificationRequest request =
        GetNotificationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNotification(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * View a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String name = BucketName.of("[PROJECT]", "[BUCKET]").toString();
   *   Notification response = storageClient.getNotification(name);
   * }
   * }</pre>
   *
   * @param name Required. The parent bucket of the notification. Format:
   *     `projects/{project}/buckets/{bucket}/notificationConfigs/{notification}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Notification getNotification(String name) {
    GetNotificationRequest request = GetNotificationRequest.newBuilder().setName(name).build();
    return getNotification(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * View a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   GetNotificationRequest request =
   *       GetNotificationRequest.newBuilder()
   *           .setName(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .build();
   *   Notification response = storageClient.getNotification(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Notification getNotification(GetNotificationRequest request) {
    return getNotificationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * View a notification config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   GetNotificationRequest request =
   *       GetNotificationRequest.newBuilder()
   *           .setName(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .build();
   *   ApiFuture<Notification> future = storageClient.getNotificationCallable().futureCall(request);
   *   // Do something.
   *   Notification response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNotificationRequest, Notification> getNotificationCallable() {
    return stub.getNotificationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification subscription for a given bucket. These notifications, when triggered,
   * publish messages to the specified Pub/Sub topics. See
   * https://cloud.google.com/storage/docs/pubsub-notifications.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Notification notification = Notification.newBuilder().build();
   *   Notification response = storageClient.createNotification(parent, notification);
   * }
   * }</pre>
   *
   * @param parent Required. The bucket to which this notification belongs.
   * @param notification Required. Properties of the notification to be inserted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Notification createNotification(ProjectName parent, Notification notification) {
    CreateNotificationRequest request =
        CreateNotificationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNotification(notification)
            .build();
    return createNotification(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification subscription for a given bucket. These notifications, when triggered,
   * publish messages to the specified Pub/Sub topics. See
   * https://cloud.google.com/storage/docs/pubsub-notifications.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Notification notification = Notification.newBuilder().build();
   *   Notification response = storageClient.createNotification(parent, notification);
   * }
   * }</pre>
   *
   * @param parent Required. The bucket to which this notification belongs.
   * @param notification Required. Properties of the notification to be inserted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Notification createNotification(String parent, Notification notification) {
    CreateNotificationRequest request =
        CreateNotificationRequest.newBuilder()
            .setParent(parent)
            .setNotification(notification)
            .build();
    return createNotification(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification subscription for a given bucket. These notifications, when triggered,
   * publish messages to the specified Pub/Sub topics. See
   * https://cloud.google.com/storage/docs/pubsub-notifications.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   CreateNotificationRequest request =
   *       CreateNotificationRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setNotification(Notification.newBuilder().build())
   *           .build();
   *   Notification response = storageClient.createNotification(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Notification createNotification(CreateNotificationRequest request) {
    return createNotificationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification subscription for a given bucket. These notifications, when triggered,
   * publish messages to the specified Pub/Sub topics. See
   * https://cloud.google.com/storage/docs/pubsub-notifications.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   CreateNotificationRequest request =
   *       CreateNotificationRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setNotification(Notification.newBuilder().build())
   *           .build();
   *   ApiFuture<Notification> future =
   *       storageClient.createNotificationCallable().futureCall(request);
   *   // Do something.
   *   Notification response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNotificationRequest, Notification> createNotificationCallable() {
    return stub.createNotificationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of notification subscriptions for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Notification element : storageClient.listNotifications(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of a Google Cloud Storage bucket.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationsPagedResponse listNotifications(ProjectName parent) {
    ListNotificationsRequest request =
        ListNotificationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNotifications(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of notification subscriptions for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Notification element : storageClient.listNotifications(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of a Google Cloud Storage bucket.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationsPagedResponse listNotifications(String parent) {
    ListNotificationsRequest request =
        ListNotificationsRequest.newBuilder().setParent(parent).build();
    return listNotifications(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of notification subscriptions for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ListNotificationsRequest request =
   *       ListNotificationsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Notification element : storageClient.listNotifications(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationsPagedResponse listNotifications(ListNotificationsRequest request) {
    return listNotificationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of notification subscriptions for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ListNotificationsRequest request =
   *       ListNotificationsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Notification> future =
   *       storageClient.listNotificationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Notification element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNotificationsRequest, ListNotificationsPagedResponse>
      listNotificationsPagedCallable() {
    return stub.listNotificationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of notification subscriptions for a given bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ListNotificationsRequest request =
   *       ListNotificationsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListNotificationsResponse response =
   *         storageClient.listNotificationsCallable().call(request);
   *     for (Notification element : response.getNotificationsList()) {
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
  public final UnaryCallable<ListNotificationsRequest, ListNotificationsResponse>
      listNotificationsCallable() {
    return stub.listNotificationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Concatenates a list of existing objects into a new object in the same bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ComposeObjectRequest request =
   *       ComposeObjectRequest.newBuilder()
   *           .setDestination(Object.newBuilder().build())
   *           .addAllSourceObjects(new ArrayList<ComposeObjectRequest.SourceObject>())
   *           .setDestinationPredefinedAcl("destinationPredefinedAcl1111125814")
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setKmsKey(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .setObjectChecksums(ObjectChecksums.newBuilder().build())
   *           .build();
   *   Object response = storageClient.composeObject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object composeObject(ComposeObjectRequest request) {
    return composeObjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Concatenates a list of existing objects into a new object in the same bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ComposeObjectRequest request =
   *       ComposeObjectRequest.newBuilder()
   *           .setDestination(Object.newBuilder().build())
   *           .addAllSourceObjects(new ArrayList<ComposeObjectRequest.SourceObject>())
   *           .setDestinationPredefinedAcl("destinationPredefinedAcl1111125814")
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setKmsKey(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .setObjectChecksums(ObjectChecksums.newBuilder().build())
   *           .build();
   *   ApiFuture<Object> future = storageClient.composeObjectCallable().futureCall(request);
   *   // Do something.
   *   Object response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ComposeObjectRequest, Object> composeObjectCallable() {
    return stub.composeObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an object and its metadata. Deletions are permanent if versioning is not enabled for
   * the bucket, or if the `generation` parameter is used.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String bucket = "bucket-1378203158";
   *   String object = "object-1023368385";
   *   storageClient.deleteObject(bucket, object);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of the bucket in which the object resides.
   * @param object Required. The name of the finalized object to delete. Note: If you want to delete
   *     an unfinalized resumable upload please use `CancelResumableWrite`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteObject(String bucket, String object) {
    DeleteObjectRequest request =
        DeleteObjectRequest.newBuilder().setBucket(bucket).setObject(object).build();
    deleteObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an object and its metadata. Deletions are permanent if versioning is not enabled for
   * the bucket, or if the `generation` parameter is used.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String bucket = "bucket-1378203158";
   *   String object = "object-1023368385";
   *   long generation = 305703192;
   *   storageClient.deleteObject(bucket, object, generation);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of the bucket in which the object resides.
   * @param object Required. The name of the finalized object to delete. Note: If you want to delete
   *     an unfinalized resumable upload please use `CancelResumableWrite`.
   * @param generation If present, permanently deletes a specific revision of this object (as
   *     opposed to the latest version, the default).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteObject(String bucket, String object, long generation) {
    DeleteObjectRequest request =
        DeleteObjectRequest.newBuilder()
            .setBucket(bucket)
            .setObject(object)
            .setGeneration(generation)
            .build();
    deleteObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an object and its metadata. Deletions are permanent if versioning is not enabled for
   * the bucket, or if the `generation` parameter is used.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   DeleteObjectRequest request =
   *       DeleteObjectRequest.newBuilder()
   *           .setBucket("bucket-1378203158")
   *           .setObject("object-1023368385")
   *           .setGeneration(305703192)
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .build();
   *   storageClient.deleteObject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteObject(DeleteObjectRequest request) {
    deleteObjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an object and its metadata. Deletions are permanent if versioning is not enabled for
   * the bucket, or if the `generation` parameter is used.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   DeleteObjectRequest request =
   *       DeleteObjectRequest.newBuilder()
   *           .setBucket("bucket-1378203158")
   *           .setObject("object-1023368385")
   *           .setGeneration(305703192)
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .build();
   *   ApiFuture<Empty> future = storageClient.deleteObjectCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteObjectRequest, Empty> deleteObjectCallable() {
    return stub.deleteObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an in-progress resumable upload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String uploadId = "uploadId1563990780";
   *   CancelResumableWriteResponse response = storageClient.cancelResumableWrite(uploadId);
   * }
   * }</pre>
   *
   * @param uploadId Required. The upload_id of the resumable upload to cancel. This should be
   *     copied from the `upload_id` field of `StartResumableWriteResponse`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CancelResumableWriteResponse cancelResumableWrite(String uploadId) {
    CancelResumableWriteRequest request =
        CancelResumableWriteRequest.newBuilder().setUploadId(uploadId).build();
    return cancelResumableWrite(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an in-progress resumable upload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   CancelResumableWriteRequest request =
   *       CancelResumableWriteRequest.newBuilder().setUploadId("uploadId1563990780").build();
   *   CancelResumableWriteResponse response = storageClient.cancelResumableWrite(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CancelResumableWriteResponse cancelResumableWrite(
      CancelResumableWriteRequest request) {
    return cancelResumableWriteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an in-progress resumable upload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   CancelResumableWriteRequest request =
   *       CancelResumableWriteRequest.newBuilder().setUploadId("uploadId1563990780").build();
   *   ApiFuture<CancelResumableWriteResponse> future =
   *       storageClient.cancelResumableWriteCallable().futureCall(request);
   *   // Do something.
   *   CancelResumableWriteResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelResumableWriteRequest, CancelResumableWriteResponse>
      cancelResumableWriteCallable() {
    return stub.cancelResumableWriteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an object's metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String bucket = "bucket-1378203158";
   *   String object = "object-1023368385";
   *   Object response = storageClient.getObject(bucket, object);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of the bucket in which the object resides.
   * @param object Required. Name of the object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object getObject(String bucket, String object) {
    GetObjectRequest request =
        GetObjectRequest.newBuilder().setBucket(bucket).setObject(object).build();
    return getObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an object's metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String bucket = "bucket-1378203158";
   *   String object = "object-1023368385";
   *   long generation = 305703192;
   *   Object response = storageClient.getObject(bucket, object, generation);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of the bucket in which the object resides.
   * @param object Required. Name of the object.
   * @param generation If present, selects a specific revision of this object (as opposed to the
   *     latest version, the default).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object getObject(String bucket, String object, long generation) {
    GetObjectRequest request =
        GetObjectRequest.newBuilder()
            .setBucket(bucket)
            .setObject(object)
            .setGeneration(generation)
            .build();
    return getObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an object's metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   GetObjectRequest request =
   *       GetObjectRequest.newBuilder()
   *           .setBucket("bucket-1378203158")
   *           .setObject("object-1023368385")
   *           .setGeneration(305703192)
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   Object response = storageClient.getObject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object getObject(GetObjectRequest request) {
    return getObjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an object's metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   GetObjectRequest request =
   *       GetObjectRequest.newBuilder()
   *           .setBucket("bucket-1378203158")
   *           .setObject("object-1023368385")
   *           .setGeneration(305703192)
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Object> future = storageClient.getObjectCallable().futureCall(request);
   *   // Do something.
   *   Object response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetObjectRequest, Object> getObjectCallable() {
    return stub.getObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads an object's data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ReadObjectRequest request =
   *       ReadObjectRequest.newBuilder()
   *           .setBucket("bucket-1378203158")
   *           .setObject("object-1023368385")
   *           .setGeneration(305703192)
   *           .setReadOffset(-715377828)
   *           .setReadLimit(-164298798)
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ServerStream<ReadObjectResponse> stream = storageClient.readObjectCallable().call(request);
   *   for (ReadObjectResponse response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse> readObjectCallable() {
    return stub.readObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an object's metadata. Equivalent to JSON API's storage.objects.patch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   Object object = Object.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Object response = storageClient.updateObject(object, updateMask);
   * }
   * }</pre>
   *
   * @param object Required. The object to update. The object's bucket and name fields are used to
   *     identify the object to update. If present, the object's generation field selects a specific
   *     revision of this object whose metadata should be updated. Otherwise, assumes the live
   *     version of the object.
   * @param updateMask Required. List of fields to be updated.
   *     <p>To specify ALL fields, equivalent to the JSON API's "update" function, specify a single
   *     field with the value `&#42;`. Note: not recommended. If a new field is introduced at a
   *     later time, an older client updating with the `&#42;` may accidentally reset the new
   *     field's value.
   *     <p>Not specifying any fields is an error. Not specifying a field while setting that field
   *     to a non-default value is an error.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object updateObject(Object object, FieldMask updateMask) {
    UpdateObjectRequest request =
        UpdateObjectRequest.newBuilder().setObject(object).setUpdateMask(updateMask).build();
    return updateObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an object's metadata. Equivalent to JSON API's storage.objects.patch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   UpdateObjectRequest request =
   *       UpdateObjectRequest.newBuilder()
   *           .setObject(Object.newBuilder().build())
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setPredefinedAcl("predefinedAcl1207041188")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .build();
   *   Object response = storageClient.updateObject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object updateObject(UpdateObjectRequest request) {
    return updateObjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an object's metadata. Equivalent to JSON API's storage.objects.patch.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   UpdateObjectRequest request =
   *       UpdateObjectRequest.newBuilder()
   *           .setObject(Object.newBuilder().build())
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setPredefinedAcl("predefinedAcl1207041188")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .build();
   *   ApiFuture<Object> future = storageClient.updateObjectCallable().futureCall(request);
   *   // Do something.
   *   Object response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateObjectRequest, Object> updateObjectCallable() {
    return stub.updateObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stores a new object and metadata.
   *
   * <p>An object can be written either in a single message stream or in a resumable sequence of
   * message streams. To write using a single stream, the client should include in the first message
   * of the stream an `WriteObjectSpec` describing the destination bucket, object, and any
   * preconditions. Additionally, the final message must set 'finish_write' to true, or else it is
   * an error.
   *
   * <p>For a resumable write, the client should instead call `StartResumableWrite()`, populating a
   * `WriteObjectSpec` into that request. They should then attach the returned `upload_id` to the
   * first message of each following call to `WriteObject`. If the stream is closed before finishing
   * the upload (either explicitly by the client or due to a network error or an error response from
   * the server), the client should do as follows: - Check the result Status of the stream, to
   * determine if writing can be resumed on this stream or must be restarted from scratch (by
   * calling `StartResumableWrite()`). The resumable errors are DEADLINE_EXCEEDED, INTERNAL, and
   * UNAVAILABLE. For each case, the client should use binary exponential backoff before retrying.
   * Additionally, writes can be resumed after RESOURCE_EXHAUSTED errors, but only after taking
   * appropriate measures, which may include reducing aggregate send rate across clients and/or
   * requesting a quota increase for your project. - If the call to `WriteObject` returns `ABORTED`,
   * that indicates concurrent attempts to update the resumable write, caused either by multiple
   * racing clients or by a single client where the previous request was timed out on the client
   * side but nonetheless reached the server. In this case the client should take steps to prevent
   * further concurrent writes (e.g., increase the timeouts, stop using more than one process to
   * perform the upload, etc.), and then should follow the steps below for resuming the upload. -
   * For resumable errors, the client should call `QueryWriteStatus()` and then continue writing
   * from the returned `persisted_size`. This may be less than the amount of data the client
   * previously sent. Note also that it is acceptable to send data starting at an offset earlier
   * than the returned `persisted_size`; in this case, the service will skip data at offsets that
   * were already persisted (without checking that it matches the previously written data), and
   * write only the data starting from the persisted offset. This behavior can make client-side
   * handling simpler in some cases.
   *
   * <p>The service will not view the object as complete until the client has sent a
   * `WriteObjectRequest` with `finish_write` set to `true`. Sending any requests on a stream after
   * sending a request with `finish_write` set to `true` will cause an error. The client
   * &#42;&#42;should&#42;&#42; check the response it receives to determine how much data the
   * service was able to commit and whether the service views the object as complete.
   *
   * <p>Attempting to resume an already finalized object will result in an OK status, with a
   * WriteObjectResponse containing the finalized object's metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ApiStreamObserver<WriteObjectRequest> responseObserver =
   *       new ApiStreamObserver<WriteObjectRequest>() {
   *         {@literal @}Override
   *         public void onNext(WriteObjectResponse response) {
   *           // Do something when a response is received.
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
   *   ApiStreamObserver<WriteObjectRequest> requestObserver =
   *       storageClient.writeObject().clientStreamingCall(responseObserver);
   *   WriteObjectRequest request =
   *       WriteObjectRequest.newBuilder()
   *           .setWriteOffset(-1559543565)
   *           .setObjectChecksums(ObjectChecksums.newBuilder().build())
   *           .setFinishWrite(true)
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .build();
   *   requestObserver.onNext(request);
   * }
   * }</pre>
   */
  public final ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse>
      writeObjectCallable() {
    return stub.writeObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of objects matching the criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Object element : storageClient.listObjects(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the bucket in which to look for objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListObjectsPagedResponse listObjects(ProjectName parent) {
    ListObjectsRequest request =
        ListObjectsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listObjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of objects matching the criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Object element : storageClient.listObjects(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the bucket in which to look for objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListObjectsPagedResponse listObjects(String parent) {
    ListObjectsRequest request = ListObjectsRequest.newBuilder().setParent(parent).build();
    return listObjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of objects matching the criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ListObjectsRequest request =
   *       ListObjectsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setDelimiter("delimiter-250518009")
   *           .setIncludeTrailingDelimiter(true)
   *           .setPrefix("prefix-980110702")
   *           .setVersions(true)
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setLexicographicStart("lexicographicStart-2093413008")
   *           .setLexicographicEnd("lexicographicEnd1646968169")
   *           .build();
   *   for (Object element : storageClient.listObjects(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListObjectsPagedResponse listObjects(ListObjectsRequest request) {
    return listObjectsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of objects matching the criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ListObjectsRequest request =
   *       ListObjectsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setDelimiter("delimiter-250518009")
   *           .setIncludeTrailingDelimiter(true)
   *           .setPrefix("prefix-980110702")
   *           .setVersions(true)
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setLexicographicStart("lexicographicStart-2093413008")
   *           .setLexicographicEnd("lexicographicEnd1646968169")
   *           .build();
   *   ApiFuture<Object> future = storageClient.listObjectsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Object element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListObjectsRequest, ListObjectsPagedResponse>
      listObjectsPagedCallable() {
    return stub.listObjectsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of objects matching the criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ListObjectsRequest request =
   *       ListObjectsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setDelimiter("delimiter-250518009")
   *           .setIncludeTrailingDelimiter(true)
   *           .setPrefix("prefix-980110702")
   *           .setVersions(true)
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setLexicographicStart("lexicographicStart-2093413008")
   *           .setLexicographicEnd("lexicographicEnd1646968169")
   *           .build();
   *   while (true) {
   *     ListObjectsResponse response = storageClient.listObjectsCallable().call(request);
   *     for (Object element : response.getObjectsList()) {
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
  public final UnaryCallable<ListObjectsRequest, ListObjectsResponse> listObjectsCallable() {
    return stub.listObjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rewrites a source object to a destination object. Optionally overrides metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   RewriteObjectRequest request =
   *       RewriteObjectRequest.newBuilder()
   *           .setDestinationName("destinationName-1762755655")
   *           .setDestinationBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setDestinationKmsKey(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setDestination(Object.newBuilder().build())
   *           .setSourceBucket("sourceBucket841604581")
   *           .setSourceObject("sourceObject1196439354")
   *           .setSourceGeneration(1232209852)
   *           .setRewriteToken("rewriteToken80654285")
   *           .setDestinationPredefinedAcl("destinationPredefinedAcl1111125814")
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setIfSourceGenerationMatch(-1427877280)
   *           .setIfSourceGenerationNotMatch(1575612532)
   *           .setIfSourceMetagenerationMatch(1143319909)
   *           .setIfSourceMetagenerationNotMatch(1900822777)
   *           .setMaxBytesRewrittenPerCall(1178170730)
   *           .setCopySourceEncryptionAlgorithm("copySourceEncryptionAlgorithm-1524952548")
   *           .setCopySourceEncryptionKeyBytes(ByteString.EMPTY)
   *           .setCopySourceEncryptionKeySha256Bytes(ByteString.EMPTY)
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .setObjectChecksums(ObjectChecksums.newBuilder().build())
   *           .build();
   *   RewriteResponse response = storageClient.rewriteObject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RewriteResponse rewriteObject(RewriteObjectRequest request) {
    return rewriteObjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rewrites a source object to a destination object. Optionally overrides metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   RewriteObjectRequest request =
   *       RewriteObjectRequest.newBuilder()
   *           .setDestinationName("destinationName-1762755655")
   *           .setDestinationBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setDestinationKmsKey(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .setDestination(Object.newBuilder().build())
   *           .setSourceBucket("sourceBucket841604581")
   *           .setSourceObject("sourceObject1196439354")
   *           .setSourceGeneration(1232209852)
   *           .setRewriteToken("rewriteToken80654285")
   *           .setDestinationPredefinedAcl("destinationPredefinedAcl1111125814")
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setIfSourceGenerationMatch(-1427877280)
   *           .setIfSourceGenerationNotMatch(1575612532)
   *           .setIfSourceMetagenerationMatch(1143319909)
   *           .setIfSourceMetagenerationNotMatch(1900822777)
   *           .setMaxBytesRewrittenPerCall(1178170730)
   *           .setCopySourceEncryptionAlgorithm("copySourceEncryptionAlgorithm-1524952548")
   *           .setCopySourceEncryptionKeyBytes(ByteString.EMPTY)
   *           .setCopySourceEncryptionKeySha256Bytes(ByteString.EMPTY)
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .setObjectChecksums(ObjectChecksums.newBuilder().build())
   *           .build();
   *   ApiFuture<RewriteResponse> future = storageClient.rewriteObjectCallable().futureCall(request);
   *   // Do something.
   *   RewriteResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RewriteObjectRequest, RewriteResponse> rewriteObjectCallable() {
    return stub.rewriteObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a resumable write. How long the write operation remains valid, and what happens when the
   * write operation becomes invalid, are service-dependent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   StartResumableWriteRequest request =
   *       StartResumableWriteRequest.newBuilder()
   *           .setWriteObjectSpec(WriteObjectSpec.newBuilder().build())
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .setObjectChecksums(ObjectChecksums.newBuilder().build())
   *           .build();
   *   StartResumableWriteResponse response = storageClient.startResumableWrite(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StartResumableWriteResponse startResumableWrite(StartResumableWriteRequest request) {
    return startResumableWriteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a resumable write. How long the write operation remains valid, and what happens when the
   * write operation becomes invalid, are service-dependent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   StartResumableWriteRequest request =
   *       StartResumableWriteRequest.newBuilder()
   *           .setWriteObjectSpec(WriteObjectSpec.newBuilder().build())
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .setObjectChecksums(ObjectChecksums.newBuilder().build())
   *           .build();
   *   ApiFuture<StartResumableWriteResponse> future =
   *       storageClient.startResumableWriteCallable().futureCall(request);
   *   // Do something.
   *   StartResumableWriteResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartResumableWriteRequest, StartResumableWriteResponse>
      startResumableWriteCallable() {
    return stub.startResumableWriteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Determines the `persisted_size` for an object that is being written, which can then be used as
   * the `write_offset` for the next `Write()` call.
   *
   * <p>If the object does not exist (i.e., the object has been deleted, or the first `Write()` has
   * not yet reached the service), this method returns the error `NOT_FOUND`.
   *
   * <p>The client &#42;&#42;may&#42;&#42; call `QueryWriteStatus()` at any time to determine how
   * much data has been processed for this object. This is useful if the client is buffering data
   * and needs to know which data can be safely evicted. For any sequence of `QueryWriteStatus()`
   * calls for a given object name, the sequence of returned `persisted_size` values will be
   * non-decreasing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String uploadId = "uploadId1563990780";
   *   QueryWriteStatusResponse response = storageClient.queryWriteStatus(uploadId);
   * }
   * }</pre>
   *
   * @param uploadId Required. The name of the resume token for the object whose write status is
   *     being requested.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryWriteStatusResponse queryWriteStatus(String uploadId) {
    QueryWriteStatusRequest request =
        QueryWriteStatusRequest.newBuilder().setUploadId(uploadId).build();
    return queryWriteStatus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Determines the `persisted_size` for an object that is being written, which can then be used as
   * the `write_offset` for the next `Write()` call.
   *
   * <p>If the object does not exist (i.e., the object has been deleted, or the first `Write()` has
   * not yet reached the service), this method returns the error `NOT_FOUND`.
   *
   * <p>The client &#42;&#42;may&#42;&#42; call `QueryWriteStatus()` at any time to determine how
   * much data has been processed for this object. This is useful if the client is buffering data
   * and needs to know which data can be safely evicted. For any sequence of `QueryWriteStatus()`
   * calls for a given object name, the sequence of returned `persisted_size` values will be
   * non-decreasing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   QueryWriteStatusRequest request =
   *       QueryWriteStatusRequest.newBuilder()
   *           .setUploadId("uploadId1563990780")
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .build();
   *   QueryWriteStatusResponse response = storageClient.queryWriteStatus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryWriteStatusResponse queryWriteStatus(QueryWriteStatusRequest request) {
    return queryWriteStatusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Determines the `persisted_size` for an object that is being written, which can then be used as
   * the `write_offset` for the next `Write()` call.
   *
   * <p>If the object does not exist (i.e., the object has been deleted, or the first `Write()` has
   * not yet reached the service), this method returns the error `NOT_FOUND`.
   *
   * <p>The client &#42;&#42;may&#42;&#42; call `QueryWriteStatus()` at any time to determine how
   * much data has been processed for this object. This is useful if the client is buffering data
   * and needs to know which data can be safely evicted. For any sequence of `QueryWriteStatus()`
   * calls for a given object name, the sequence of returned `persisted_size` values will be
   * non-decreasing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   QueryWriteStatusRequest request =
   *       QueryWriteStatusRequest.newBuilder()
   *           .setUploadId("uploadId1563990780")
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .build();
   *   ApiFuture<QueryWriteStatusResponse> future =
   *       storageClient.queryWriteStatusCallable().futureCall(request);
   *   // Do something.
   *   QueryWriteStatusResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryWriteStatusRequest, QueryWriteStatusResponse>
      queryWriteStatusCallable() {
    return stub.queryWriteStatusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the name of a project's Google Cloud Storage service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ServiceAccount response = storageClient.getServiceAccount(project);
   * }
   * }</pre>
   *
   * @param project Required. Project ID, in the format of "projects/&lt;projectIdentifier&gt;".
   *     &lt;projectIdentifier&gt; can be the project ID or project number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount getServiceAccount(ProjectName project) {
    GetServiceAccountRequest request =
        GetServiceAccountRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return getServiceAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the name of a project's Google Cloud Storage service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String project = ProjectName.of("[PROJECT]").toString();
   *   ServiceAccount response = storageClient.getServiceAccount(project);
   * }
   * }</pre>
   *
   * @param project Required. Project ID, in the format of "projects/&lt;projectIdentifier&gt;".
   *     &lt;projectIdentifier&gt; can be the project ID or project number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount getServiceAccount(String project) {
    GetServiceAccountRequest request =
        GetServiceAccountRequest.newBuilder().setProject(project).build();
    return getServiceAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the name of a project's Google Cloud Storage service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   GetServiceAccountRequest request =
   *       GetServiceAccountRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   ServiceAccount response = storageClient.getServiceAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount getServiceAccount(GetServiceAccountRequest request) {
    return getServiceAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the name of a project's Google Cloud Storage service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   GetServiceAccountRequest request =
   *       GetServiceAccountRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<ServiceAccount> future =
   *       storageClient.getServiceAccountCallable().futureCall(request);
   *   // Do something.
   *   ServiceAccount response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceAccountRequest, ServiceAccount> getServiceAccountCallable() {
    return stub.getServiceAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HMAC key for the given service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   String serviceAccountEmail = "serviceAccountEmail1825953988";
   *   CreateHmacKeyResponse response = storageClient.createHmacKey(project, serviceAccountEmail);
   * }
   * }</pre>
   *
   * @param project Required. The project that the HMAC-owning service account lives in, in the
   *     format of "projects/&lt;projectIdentifier&gt;". &lt;projectIdentifier&gt; can be the
   *     project ID or project number.
   * @param serviceAccountEmail Required. The service account to create the HMAC for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreateHmacKeyResponse createHmacKey(
      ProjectName project, String serviceAccountEmail) {
    CreateHmacKeyRequest request =
        CreateHmacKeyRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setServiceAccountEmail(serviceAccountEmail)
            .build();
    return createHmacKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HMAC key for the given service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String project = ProjectName.of("[PROJECT]").toString();
   *   String serviceAccountEmail = "serviceAccountEmail1825953988";
   *   CreateHmacKeyResponse response = storageClient.createHmacKey(project, serviceAccountEmail);
   * }
   * }</pre>
   *
   * @param project Required. The project that the HMAC-owning service account lives in, in the
   *     format of "projects/&lt;projectIdentifier&gt;". &lt;projectIdentifier&gt; can be the
   *     project ID or project number.
   * @param serviceAccountEmail Required. The service account to create the HMAC for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreateHmacKeyResponse createHmacKey(String project, String serviceAccountEmail) {
    CreateHmacKeyRequest request =
        CreateHmacKeyRequest.newBuilder()
            .setProject(project)
            .setServiceAccountEmail(serviceAccountEmail)
            .build();
    return createHmacKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HMAC key for the given service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   CreateHmacKeyRequest request =
   *       CreateHmacKeyRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setServiceAccountEmail("serviceAccountEmail1825953988")
   *           .build();
   *   CreateHmacKeyResponse response = storageClient.createHmacKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreateHmacKeyResponse createHmacKey(CreateHmacKeyRequest request) {
    return createHmacKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HMAC key for the given service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   CreateHmacKeyRequest request =
   *       CreateHmacKeyRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setServiceAccountEmail("serviceAccountEmail1825953988")
   *           .build();
   *   ApiFuture<CreateHmacKeyResponse> future =
   *       storageClient.createHmacKeyCallable().futureCall(request);
   *   // Do something.
   *   CreateHmacKeyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateHmacKeyRequest, CreateHmacKeyResponse> createHmacKeyCallable() {
    return stub.createHmacKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a given HMAC key. Key must be in an INACTIVE state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String accessId = "accessId-2146437729";
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   storageClient.deleteHmacKey(accessId, project);
   * }
   * }</pre>
   *
   * @param accessId Required. The identifying key for the HMAC to delete.
   * @param project Required. The project that owns the HMAC key, in the format of
   *     "projects/&lt;projectIdentifier&gt;". &lt;projectIdentifier&gt; can be the project ID or
   *     project number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteHmacKey(String accessId, ProjectName project) {
    DeleteHmacKeyRequest request =
        DeleteHmacKeyRequest.newBuilder()
            .setAccessId(accessId)
            .setProject(project == null ? null : project.toString())
            .build();
    deleteHmacKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a given HMAC key. Key must be in an INACTIVE state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String accessId = "accessId-2146437729";
   *   String project = ProjectName.of("[PROJECT]").toString();
   *   storageClient.deleteHmacKey(accessId, project);
   * }
   * }</pre>
   *
   * @param accessId Required. The identifying key for the HMAC to delete.
   * @param project Required. The project that owns the HMAC key, in the format of
   *     "projects/&lt;projectIdentifier&gt;". &lt;projectIdentifier&gt; can be the project ID or
   *     project number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteHmacKey(String accessId, String project) {
    DeleteHmacKeyRequest request =
        DeleteHmacKeyRequest.newBuilder().setAccessId(accessId).setProject(project).build();
    deleteHmacKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a given HMAC key. Key must be in an INACTIVE state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   DeleteHmacKeyRequest request =
   *       DeleteHmacKeyRequest.newBuilder()
   *           .setAccessId("accessId-2146437729")
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   storageClient.deleteHmacKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteHmacKey(DeleteHmacKeyRequest request) {
    deleteHmacKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a given HMAC key. Key must be in an INACTIVE state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   DeleteHmacKeyRequest request =
   *       DeleteHmacKeyRequest.newBuilder()
   *           .setAccessId("accessId-2146437729")
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<Empty> future = storageClient.deleteHmacKeyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteHmacKeyRequest, Empty> deleteHmacKeyCallable() {
    return stub.deleteHmacKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an existing HMAC key metadata for the given id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String accessId = "accessId-2146437729";
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   HmacKeyMetadata response = storageClient.getHmacKey(accessId, project);
   * }
   * }</pre>
   *
   * @param accessId Required. The identifying key for the HMAC to delete.
   * @param project Required. The project the HMAC key lies in, in the format of
   *     "projects/&lt;projectIdentifier&gt;". &lt;projectIdentifier&gt; can be the project ID or
   *     project number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HmacKeyMetadata getHmacKey(String accessId, ProjectName project) {
    GetHmacKeyRequest request =
        GetHmacKeyRequest.newBuilder()
            .setAccessId(accessId)
            .setProject(project == null ? null : project.toString())
            .build();
    return getHmacKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an existing HMAC key metadata for the given id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String accessId = "accessId-2146437729";
   *   String project = ProjectName.of("[PROJECT]").toString();
   *   HmacKeyMetadata response = storageClient.getHmacKey(accessId, project);
   * }
   * }</pre>
   *
   * @param accessId Required. The identifying key for the HMAC to delete.
   * @param project Required. The project the HMAC key lies in, in the format of
   *     "projects/&lt;projectIdentifier&gt;". &lt;projectIdentifier&gt; can be the project ID or
   *     project number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HmacKeyMetadata getHmacKey(String accessId, String project) {
    GetHmacKeyRequest request =
        GetHmacKeyRequest.newBuilder().setAccessId(accessId).setProject(project).build();
    return getHmacKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an existing HMAC key metadata for the given id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   GetHmacKeyRequest request =
   *       GetHmacKeyRequest.newBuilder()
   *           .setAccessId("accessId-2146437729")
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   HmacKeyMetadata response = storageClient.getHmacKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HmacKeyMetadata getHmacKey(GetHmacKeyRequest request) {
    return getHmacKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an existing HMAC key metadata for the given id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   GetHmacKeyRequest request =
   *       GetHmacKeyRequest.newBuilder()
   *           .setAccessId("accessId-2146437729")
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<HmacKeyMetadata> future = storageClient.getHmacKeyCallable().futureCall(request);
   *   // Do something.
   *   HmacKeyMetadata response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHmacKeyRequest, HmacKeyMetadata> getHmacKeyCallable() {
    return stub.getHmacKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HMAC keys under a given project with the additional filters provided.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (HmacKeyMetadata element : storageClient.listHmacKeys(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Required. The project to list HMAC keys for, in the format of
   *     "projects/&lt;projectIdentifier&gt;". &lt;projectIdentifier&gt; can be the project ID or
   *     project number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHmacKeysPagedResponse listHmacKeys(ProjectName project) {
    ListHmacKeysRequest request =
        ListHmacKeysRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listHmacKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HMAC keys under a given project with the additional filters provided.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   String project = ProjectName.of("[PROJECT]").toString();
   *   for (HmacKeyMetadata element : storageClient.listHmacKeys(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Required. The project to list HMAC keys for, in the format of
   *     "projects/&lt;projectIdentifier&gt;". &lt;projectIdentifier&gt; can be the project ID or
   *     project number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHmacKeysPagedResponse listHmacKeys(String project) {
    ListHmacKeysRequest request = ListHmacKeysRequest.newBuilder().setProject(project).build();
    return listHmacKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HMAC keys under a given project with the additional filters provided.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ListHmacKeysRequest request =
   *       ListHmacKeysRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setServiceAccountEmail("serviceAccountEmail1825953988")
   *           .setShowDeletedKeys(true)
   *           .build();
   *   for (HmacKeyMetadata element : storageClient.listHmacKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHmacKeysPagedResponse listHmacKeys(ListHmacKeysRequest request) {
    return listHmacKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HMAC keys under a given project with the additional filters provided.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ListHmacKeysRequest request =
   *       ListHmacKeysRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setServiceAccountEmail("serviceAccountEmail1825953988")
   *           .setShowDeletedKeys(true)
   *           .build();
   *   ApiFuture<HmacKeyMetadata> future =
   *       storageClient.listHmacKeysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HmacKeyMetadata element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHmacKeysRequest, ListHmacKeysPagedResponse>
      listHmacKeysPagedCallable() {
    return stub.listHmacKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HMAC keys under a given project with the additional filters provided.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   ListHmacKeysRequest request =
   *       ListHmacKeysRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setServiceAccountEmail("serviceAccountEmail1825953988")
   *           .setShowDeletedKeys(true)
   *           .build();
   *   while (true) {
   *     ListHmacKeysResponse response = storageClient.listHmacKeysCallable().call(request);
   *     for (HmacKeyMetadata element : response.getHmacKeysList()) {
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
  public final UnaryCallable<ListHmacKeysRequest, ListHmacKeysResponse> listHmacKeysCallable() {
    return stub.listHmacKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a given HMAC key state between ACTIVE and INACTIVE.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   HmacKeyMetadata hmacKey = HmacKeyMetadata.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   HmacKeyMetadata response = storageClient.updateHmacKey(hmacKey, updateMask);
   * }
   * }</pre>
   *
   * @param hmacKey Required. The HMAC key to update. If present, the hmac_key's `id` field will be
   *     used to identify the key. Otherwise, the hmac_key's access_id and project fields will be
   *     used to identify the key.
   * @param updateMask Update mask for hmac_key. Not specifying any fields will mean only the
   *     `state` field is updated to the value specified in `hmac_key`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HmacKeyMetadata updateHmacKey(HmacKeyMetadata hmacKey, FieldMask updateMask) {
    UpdateHmacKeyRequest request =
        UpdateHmacKeyRequest.newBuilder().setHmacKey(hmacKey).setUpdateMask(updateMask).build();
    return updateHmacKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a given HMAC key state between ACTIVE and INACTIVE.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   UpdateHmacKeyRequest request =
   *       UpdateHmacKeyRequest.newBuilder()
   *           .setHmacKey(HmacKeyMetadata.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   HmacKeyMetadata response = storageClient.updateHmacKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HmacKeyMetadata updateHmacKey(UpdateHmacKeyRequest request) {
    return updateHmacKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a given HMAC key state between ACTIVE and INACTIVE.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StorageClient storageClient = StorageClient.create()) {
   *   UpdateHmacKeyRequest request =
   *       UpdateHmacKeyRequest.newBuilder()
   *           .setHmacKey(HmacKeyMetadata.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<HmacKeyMetadata> future = storageClient.updateHmacKeyCallable().futureCall(request);
   *   // Do something.
   *   HmacKeyMetadata response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateHmacKeyRequest, HmacKeyMetadata> updateHmacKeyCallable() {
    return stub.updateHmacKeyCallable();
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

  public static class ListBucketsPagedResponse
      extends AbstractPagedListResponse<
          ListBucketsRequest,
          ListBucketsResponse,
          Bucket,
          ListBucketsPage,
          ListBucketsFixedSizeCollection> {

    public static ApiFuture<ListBucketsPagedResponse> createAsync(
        PageContext<ListBucketsRequest, ListBucketsResponse, Bucket> context,
        ApiFuture<ListBucketsResponse> futureResponse) {
      ApiFuture<ListBucketsPage> futurePage =
          ListBucketsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListBucketsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListBucketsPagedResponse(ListBucketsPage page) {
      super(page, ListBucketsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBucketsPage
      extends AbstractPage<ListBucketsRequest, ListBucketsResponse, Bucket, ListBucketsPage> {

    private ListBucketsPage(
        PageContext<ListBucketsRequest, ListBucketsResponse, Bucket> context,
        ListBucketsResponse response) {
      super(context, response);
    }

    private static ListBucketsPage createEmptyPage() {
      return new ListBucketsPage(null, null);
    }

    @Override
    protected ListBucketsPage createPage(
        PageContext<ListBucketsRequest, ListBucketsResponse, Bucket> context,
        ListBucketsResponse response) {
      return new ListBucketsPage(context, response);
    }

    @Override
    public ApiFuture<ListBucketsPage> createPageAsync(
        PageContext<ListBucketsRequest, ListBucketsResponse, Bucket> context,
        ApiFuture<ListBucketsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBucketsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBucketsRequest,
          ListBucketsResponse,
          Bucket,
          ListBucketsPage,
          ListBucketsFixedSizeCollection> {

    private ListBucketsFixedSizeCollection(List<ListBucketsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBucketsFixedSizeCollection createEmptyCollection() {
      return new ListBucketsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBucketsFixedSizeCollection createCollection(
        List<ListBucketsPage> pages, int collectionSize) {
      return new ListBucketsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNotificationsPagedResponse
      extends AbstractPagedListResponse<
          ListNotificationsRequest,
          ListNotificationsResponse,
          Notification,
          ListNotificationsPage,
          ListNotificationsFixedSizeCollection> {

    public static ApiFuture<ListNotificationsPagedResponse> createAsync(
        PageContext<ListNotificationsRequest, ListNotificationsResponse, Notification> context,
        ApiFuture<ListNotificationsResponse> futureResponse) {
      ApiFuture<ListNotificationsPage> futurePage =
          ListNotificationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNotificationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNotificationsPagedResponse(ListNotificationsPage page) {
      super(page, ListNotificationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNotificationsPage
      extends AbstractPage<
          ListNotificationsRequest,
          ListNotificationsResponse,
          Notification,
          ListNotificationsPage> {

    private ListNotificationsPage(
        PageContext<ListNotificationsRequest, ListNotificationsResponse, Notification> context,
        ListNotificationsResponse response) {
      super(context, response);
    }

    private static ListNotificationsPage createEmptyPage() {
      return new ListNotificationsPage(null, null);
    }

    @Override
    protected ListNotificationsPage createPage(
        PageContext<ListNotificationsRequest, ListNotificationsResponse, Notification> context,
        ListNotificationsResponse response) {
      return new ListNotificationsPage(context, response);
    }

    @Override
    public ApiFuture<ListNotificationsPage> createPageAsync(
        PageContext<ListNotificationsRequest, ListNotificationsResponse, Notification> context,
        ApiFuture<ListNotificationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNotificationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNotificationsRequest,
          ListNotificationsResponse,
          Notification,
          ListNotificationsPage,
          ListNotificationsFixedSizeCollection> {

    private ListNotificationsFixedSizeCollection(
        List<ListNotificationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNotificationsFixedSizeCollection createEmptyCollection() {
      return new ListNotificationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNotificationsFixedSizeCollection createCollection(
        List<ListNotificationsPage> pages, int collectionSize) {
      return new ListNotificationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListObjectsPagedResponse
      extends AbstractPagedListResponse<
          ListObjectsRequest,
          ListObjectsResponse,
          Object,
          ListObjectsPage,
          ListObjectsFixedSizeCollection> {

    public static ApiFuture<ListObjectsPagedResponse> createAsync(
        PageContext<ListObjectsRequest, ListObjectsResponse, Object> context,
        ApiFuture<ListObjectsResponse> futureResponse) {
      ApiFuture<ListObjectsPage> futurePage =
          ListObjectsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListObjectsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListObjectsPagedResponse(ListObjectsPage page) {
      super(page, ListObjectsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListObjectsPage
      extends AbstractPage<ListObjectsRequest, ListObjectsResponse, Object, ListObjectsPage> {

    private ListObjectsPage(
        PageContext<ListObjectsRequest, ListObjectsResponse, Object> context,
        ListObjectsResponse response) {
      super(context, response);
    }

    private static ListObjectsPage createEmptyPage() {
      return new ListObjectsPage(null, null);
    }

    @Override
    protected ListObjectsPage createPage(
        PageContext<ListObjectsRequest, ListObjectsResponse, Object> context,
        ListObjectsResponse response) {
      return new ListObjectsPage(context, response);
    }

    @Override
    public ApiFuture<ListObjectsPage> createPageAsync(
        PageContext<ListObjectsRequest, ListObjectsResponse, Object> context,
        ApiFuture<ListObjectsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListObjectsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListObjectsRequest,
          ListObjectsResponse,
          Object,
          ListObjectsPage,
          ListObjectsFixedSizeCollection> {

    private ListObjectsFixedSizeCollection(List<ListObjectsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListObjectsFixedSizeCollection createEmptyCollection() {
      return new ListObjectsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListObjectsFixedSizeCollection createCollection(
        List<ListObjectsPage> pages, int collectionSize) {
      return new ListObjectsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListHmacKeysPagedResponse
      extends AbstractPagedListResponse<
          ListHmacKeysRequest,
          ListHmacKeysResponse,
          HmacKeyMetadata,
          ListHmacKeysPage,
          ListHmacKeysFixedSizeCollection> {

    public static ApiFuture<ListHmacKeysPagedResponse> createAsync(
        PageContext<ListHmacKeysRequest, ListHmacKeysResponse, HmacKeyMetadata> context,
        ApiFuture<ListHmacKeysResponse> futureResponse) {
      ApiFuture<ListHmacKeysPage> futurePage =
          ListHmacKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListHmacKeysPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListHmacKeysPagedResponse(ListHmacKeysPage page) {
      super(page, ListHmacKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHmacKeysPage
      extends AbstractPage<
          ListHmacKeysRequest, ListHmacKeysResponse, HmacKeyMetadata, ListHmacKeysPage> {

    private ListHmacKeysPage(
        PageContext<ListHmacKeysRequest, ListHmacKeysResponse, HmacKeyMetadata> context,
        ListHmacKeysResponse response) {
      super(context, response);
    }

    private static ListHmacKeysPage createEmptyPage() {
      return new ListHmacKeysPage(null, null);
    }

    @Override
    protected ListHmacKeysPage createPage(
        PageContext<ListHmacKeysRequest, ListHmacKeysResponse, HmacKeyMetadata> context,
        ListHmacKeysResponse response) {
      return new ListHmacKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListHmacKeysPage> createPageAsync(
        PageContext<ListHmacKeysRequest, ListHmacKeysResponse, HmacKeyMetadata> context,
        ApiFuture<ListHmacKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHmacKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHmacKeysRequest,
          ListHmacKeysResponse,
          HmacKeyMetadata,
          ListHmacKeysPage,
          ListHmacKeysFixedSizeCollection> {

    private ListHmacKeysFixedSizeCollection(List<ListHmacKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHmacKeysFixedSizeCollection createEmptyCollection() {
      return new ListHmacKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHmacKeysFixedSizeCollection createCollection(
        List<ListHmacKeysPage> pages, int collectionSize) {
      return new ListHmacKeysFixedSizeCollection(pages, collectionSize);
    }
  }
}

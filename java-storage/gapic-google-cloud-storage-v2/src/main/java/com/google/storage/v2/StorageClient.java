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
import com.google.api.gax.rpc.BidiStreamingCallable;
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
 * of buckets and objects. For a description of these abstractions please see [Cloud Storage
 * documentation](https://cloud.google.com/storage/docs).
 *
 * <p>Resources are named as follows:
 *
 * <p>- Projects are referred to as they are defined by the Resource Manager API, using strings like
 * `projects/123456` or `projects/my-string-id`. - Buckets are named using string names of the form:
 * `projects/{project}/buckets/{bucket}`. For globally unique buckets, `_` might be substituted for
 * the project. - Objects are uniquely identified by their name along with the name of the bucket
 * they belong to, as separate strings in this API. For example:
 *
 * <p>``` ReadObjectRequest { bucket: 'projects/_/buckets/my-bucket' object: 'my-object' } ```
 *
 * <p>Note that object names can contain `/` characters, which are treated as any other character
 * (no special directory semantics).
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
 *      <td><p> Permanently deletes an empty bucket. The request fails if there are any live or noncurrent objects in the bucket, but the request succeeds if the bucket only contains soft-deleted objects or incomplete uploads, such as ongoing XML API multipart uploads. Does not permanently delete soft-deleted objects.
 * <p>  When this API is used to delete a bucket containing an object that has a soft delete policy enabled, the object becomes soft deleted, and the `softDeleteTime` and `hardDeleteTime` properties are set on the object.
 * <p>  Objects and multipart uploads that were in the bucket at the time of deletion are also retained for the specified retention duration. When a soft-deleted bucket reaches the end of its retention duration, it is permanently deleted. The `hardDeleteTime` of the bucket always equals or exceeds the expiration time of the last soft-deleted object in the bucket.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.buckets.delete` IAM permission on the bucket.</td>
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
 *      <td><p> Returns metadata for the specified bucket.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.buckets.get` IAM permission on the bucket. Additionally, to return specific bucket metadata, the authenticated user must have the following permissions:
 * <p>  - To return the IAM policies: `storage.buckets.getIamPolicy` - To return the bucket IP filtering rules: `storage.buckets.getIpFilter`</td>
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
 *      <td><p> Creates a new bucket.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.buckets.create` IAM permission on the bucket. Additionally, to enable specific bucket features, the authenticated user must have the following permissions:
 * <p>  - To enable object retention using the `enableObjectRetention` query parameter: `storage.buckets.enableObjectRetention` - To set the bucket IP filtering rules: `storage.buckets.setIpFilter`</td>
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
 *      <td><p> Retrieves a list of buckets for a given project, ordered lexicographically by name.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.buckets.list` IAM permission on the bucket. Additionally, to enable specific bucket features, the authenticated user must have the following permissions:
 * <p>  - To list the IAM policies: `storage.buckets.getIamPolicy` - To list the bucket IP filtering rules: `storage.buckets.getIpFilter`</td>
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
 *      <td><p> Permanently locks the retention policy that is currently applied to the specified bucket.
 * <p>  Caution: Locking a bucket is an irreversible action. Once you lock a bucket:
 * <p>  - You cannot remove the retention policy from the bucket. - You cannot decrease the retention period for the policy.
 * <p>  Once locked, you must delete the entire bucket in order to remove the bucket's retention policy. However, before you can delete the bucket, you must delete all the objects in the bucket, which is only possible if all the objects have reached the retention period set by the retention policy.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.buckets.update` IAM permission on the bucket.</td>
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
 *      <td><p> Gets the IAM policy for a specified bucket or managed folder. The `resource` field in the request should be `projects/_/buckets/{bucket}` for a bucket, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.buckets.getIamPolicy` on the bucket or `storage.managedFolders.getIamPolicy` IAM permission on the managed folder.</td>
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
 *      <td><p> Updates an IAM policy for the specified bucket or managed folder. The `resource` field in the request should be `projects/_/buckets/{bucket}` for a bucket, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.</td>
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
 *      <td><p> Tests a set of permissions on the given bucket, object, or managed folder to see which, if any, are held by the caller. The `resource` field in the request should be `projects/_/buckets/{bucket}` for a bucket, `projects/_/buckets/{bucket}/objects/{object}` for an object, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.</td>
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
 *      <td><p> Updates a bucket. Changes to the bucket are readable immediately after writing, but configuration changes might take time to propagate. This method supports `patch` semantics.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.buckets.update` IAM permission on the bucket. Additionally, to enable specific bucket features, the authenticated user must have the following permissions:
 * <p>  - To set bucket IP filtering rules: `storage.buckets.setIpFilter` - To update public access prevention policies or access control lists (ACLs): `storage.buckets.setIamPolicy`</td>
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
 *      <td><p> ComposeObject</td>
 *      <td><p> Concatenates a list of existing objects into a new object in the same bucket. The existing source objects are unaffected by this operation.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires the `storage.objects.create` and `storage.objects.get` IAM permissions to use this method. If the new composite object overwrites an existing object, the authenticated user must also have the `storage.objects.delete` permission. If the request body includes the retention property, the authenticated user must also have the `storage.objects.setRetention` IAM permission.</td>
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
 *      <td><p> Deletes an object and its metadata. Deletions are permanent if versioning is not enabled for the bucket, or if the generation parameter is used, or if soft delete is not enabled for the bucket. When this API is used to delete an object from a bucket that has soft delete policy enabled, the object becomes soft deleted, and the `softDeleteTime` and `hardDeleteTime` properties are set on the object. This API cannot be used to permanently delete soft-deleted objects. Soft-deleted objects are permanently deleted according to their `hardDeleteTime`.
 * <p>  You can use the [`RestoreObject`][google.storage.v2.Storage.RestoreObject] API to restore soft-deleted objects until the soft delete retention period has passed.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.objects.delete` IAM permission on the bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteObject(DeleteObjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteObject(BucketName bucket, String object)
 *           <li><p> deleteObject(String bucket, String object)
 *           <li><p> deleteObject(BucketName bucket, String object, long generation)
 *           <li><p> deleteObject(String bucket, String object, long generation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RestoreObject</td>
 *      <td><p> Restores a soft-deleted object. When a soft-deleted object is restored, a new copy of that object is created in the same bucket and inherits the same metadata as the soft-deleted object. The inherited metadata is the metadata that existed when the original object became soft deleted, with the following exceptions:
 * <p>    - The `createTime` of the new object is set to the time at which the   soft-deleted object was restored.   - The `softDeleteTime` and `hardDeleteTime` values are cleared.   - A new generation is assigned and the metageneration is reset to 1.   - If the soft-deleted object was in a bucket that had Autoclass enabled,   the new object is     restored to Standard storage.   - The restored object inherits the bucket's default object ACL, unless   `copySourceAcl` is `true`.
 * <p>  If a live object using the same name already exists in the bucket and becomes overwritten, the live object becomes a noncurrent object if Object Versioning is enabled on the bucket. If Object Versioning is not enabled, the live object becomes soft deleted.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires the following IAM permissions to use this method:
 * <p>    - `storage.objects.restore`   - `storage.objects.create`   - `storage.objects.delete` (only required if overwriting an existing   object)   - `storage.objects.getIamPolicy` (only required if `projection` is `full`   and the relevant bucket     has uniform bucket-level access disabled)   - `storage.objects.setIamPolicy` (only required if `copySourceAcl` is   `true` and the relevant     bucket has uniform bucket-level access disabled)</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> restoreObject(RestoreObjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> restoreObject(BucketName bucket, String object, long generation)
 *           <li><p> restoreObject(String bucket, String object, long generation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> restoreObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CancelResumableWrite</td>
 *      <td><p> Cancels an in-progress resumable upload.
 * <p>  Any attempts to write to the resumable upload after cancelling the upload fail.
 * <p>  The behavior for any in-progress write operations is not guaranteed; they could either complete before the cancellation or fail if the cancellation completes first.</td>
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
 *      <td><p> Retrieves object metadata.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.objects.get` IAM permission on the bucket. To return object ACLs, the authenticated user must also have the `storage.objects.getIamPolicy` permission.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getObject(GetObjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getObject(BucketName bucket, String object)
 *           <li><p> getObject(String bucket, String object)
 *           <li><p> getObject(BucketName bucket, String object, long generation)
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
 *      <td><p> Retrieves object data.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.objects.get` IAM permission on the bucket.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> readObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BidiReadObject</td>
 *      <td><p> Reads an object's data.
 * <p>  This bi-directional API reads data from an object, allowing you to request multiple data ranges within a single stream, even across several messages. If an error occurs with any request, the stream closes with a relevant error code. Since you can have multiple outstanding requests, the error response includes a `BidiReadObjectError` proto in its `details` field, reporting the specific error, if any, for each pending `read_id`.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.objects.get` IAM permission on the bucket.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> bidiReadObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateObject</td>
 *      <td><p> Updates an object's metadata. Equivalent to JSON API's `storage.objects.patch` method.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.objects.update` IAM permission on the bucket.</td>
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
 * <p>  For a resumable write, the client should instead call `StartResumableWrite()`, populating a `WriteObjectSpec` into that request. They should then attach the returned `upload_id` to the first message of each following call to `WriteObject`. If the stream is closed before finishing the upload (either explicitly by the client or due to a network error or an error response from the server), the client should do as follows:
 * <p>    - Check the result Status of the stream, to determine if writing can be     resumed on this stream or must be restarted from scratch (by calling     `StartResumableWrite()`). The resumable errors are `DEADLINE_EXCEEDED`,     `INTERNAL`, and `UNAVAILABLE`. For each case, the client should use     binary exponential backoff before retrying.  Additionally, writes can     be resumed after `RESOURCE_EXHAUSTED` errors, but only after taking     appropriate measures, which might include reducing aggregate send rate     across clients and/or requesting a quota increase for your project.   - If the call to `WriteObject` returns `ABORTED`, that indicates     concurrent attempts to update the resumable write, caused either by     multiple racing clients or by a single client where the previous     request was timed out on the client side but nonetheless reached the     server. In this case the client should take steps to prevent further     concurrent writes. For example, increase the timeouts and stop using     more than one process to perform the upload. Follow the steps below for     resuming the upload.   - For resumable errors, the client should call `QueryWriteStatus()` and     then continue writing from the returned `persisted_size`. This might be     less than the amount of data the client previously sent. Note also that     it is acceptable to send data starting at an offset earlier than the     returned `persisted_size`; in this case, the service skips data at     offsets that were already persisted (without checking that it matches     the previously written data), and write only the data starting from the     persisted offset. Even though the data isn't written, it might still     incur a performance cost over resuming at the correct write offset.     This behavior can make client-side handling simpler in some cases.   - Clients must only send data that is a multiple of 256 KiB per message,     unless the object is being finished with `finish_write` set to `true`.
 * <p>  The service does not view the object as complete until the client has sent a `WriteObjectRequest` with `finish_write` set to `true`. Sending any requests on a stream after sending a request with `finish_write` set to `true` causes an error. The client must check the response it receives to determine how much data the service is able to commit and whether the service views the object as complete.
 * <p>  Attempting to resume an already finalized object results in an `OK` status, with a `WriteObjectResponse` containing the finalized object's metadata.
 * <p>  Alternatively, you can use the `BidiWriteObject` operation to write an object with controls over flushing and the ability to fetch the ability to determine the current persisted size.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.objects.create` IAM permission on the bucket.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> writeObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BidiWriteObject</td>
 *      <td><p> Stores a new object and metadata.
 * <p>  This is similar to the `WriteObject` call with the added support for manual flushing of persisted state, and the ability to determine current persisted size without closing the stream.
 * <p>  The client might specify one or both of the `state_lookup` and `flush` fields in each `BidiWriteObjectRequest`. If `flush` is specified, the data written so far is persisted to storage. If `state_lookup` is specified, the service responds with a `BidiWriteObjectResponse` that contains the persisted size. If both `flush` and `state_lookup` are specified, the flush always occurs before a `state_lookup`, so that both might be set in the same request and the returned state is the state of the object post-flush. When the stream is closed, a `BidiWriteObjectResponse` is always sent to the client, regardless of the value of `state_lookup`.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> bidiWriteObjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListObjects</td>
 *      <td><p> Retrieves a list of objects matching the criteria.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  The authenticated user requires `storage.objects.list` IAM permission to use this method. To return object ACLs, the authenticated user must also have the `storage.objects.getIamPolicy` permission.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listObjects(ListObjectsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listObjects(BucketName parent)
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
 *      <td><p> Starts a resumable write operation. This method is part of the Resumable upload feature. This allows you to upload large objects in multiple chunks, which is more resilient to network interruptions than a single upload. The validity duration of the write operation, and the consequences of it becoming invalid, are service-dependent.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires `storage.objects.create` IAM permission on the bucket.</td>
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
 *      <td><p> Determines the `persisted_size` of an object that is being written. This method is part of the resumable upload feature. The returned value is the size of the object that has been persisted so far. The value can be used as the `write_offset` for the next `Write()` call.
 * <p>  If the object does not exist, meaning if it was deleted, or the first `Write()` has not yet reached the service, this method returns the error `NOT_FOUND`.
 * <p>  This method is useful for clients that buffer data and need to know which data can be safely evicted. The client can call `QueryWriteStatus()` at any time to determine how much data has been logged for this object. For any sequence of `QueryWriteStatus()` calls for a given object name, the sequence of returned `persisted_size` values are non-decreasing.</td>
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
 *      <td><p> MoveObject</td>
 *      <td><p> Moves the source object to the destination object in the same bucket. This operation moves a source object to a destination object in the same bucket by renaming the object. The move itself is an atomic transaction, ensuring all steps either complete successfully or no changes are made.
 * <p>  &#42;&#42;IAM Permissions&#42;&#42;:
 * <p>  Requires the following IAM permissions to use this method:
 * <p>    - `storage.objects.move`   - `storage.objects.create`   - `storage.objects.delete` (only required if overwriting an existing   object)</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> moveObject(MoveObjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> moveObject(BucketName bucket, String sourceObject, String destinationObject)
 *           <li><p> moveObject(String bucket, String sourceObject, String destinationObject)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> moveObjectCallable()
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
   * Permanently deletes an empty bucket. The request fails if there are any live or noncurrent
   * objects in the bucket, but the request succeeds if the bucket only contains soft-deleted
   * objects or incomplete uploads, such as ongoing XML API multipart uploads. Does not permanently
   * delete soft-deleted objects.
   *
   * <p>When this API is used to delete a bucket containing an object that has a soft delete policy
   * enabled, the object becomes soft deleted, and the `softDeleteTime` and `hardDeleteTime`
   * properties are set on the object.
   *
   * <p>Objects and multipart uploads that were in the bucket at the time of deletion are also
   * retained for the specified retention duration. When a soft-deleted bucket reaches the end of
   * its retention duration, it is permanently deleted. The `hardDeleteTime` of the bucket always
   * equals or exceeds the expiration time of the last soft-deleted object in the bucket.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.delete` IAM permission on the bucket.
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
   * Permanently deletes an empty bucket. The request fails if there are any live or noncurrent
   * objects in the bucket, but the request succeeds if the bucket only contains soft-deleted
   * objects or incomplete uploads, such as ongoing XML API multipart uploads. Does not permanently
   * delete soft-deleted objects.
   *
   * <p>When this API is used to delete a bucket containing an object that has a soft delete policy
   * enabled, the object becomes soft deleted, and the `softDeleteTime` and `hardDeleteTime`
   * properties are set on the object.
   *
   * <p>Objects and multipart uploads that were in the bucket at the time of deletion are also
   * retained for the specified retention duration. When a soft-deleted bucket reaches the end of
   * its retention duration, it is permanently deleted. The `hardDeleteTime` of the bucket always
   * equals or exceeds the expiration time of the last soft-deleted object in the bucket.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.delete` IAM permission on the bucket.
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
   * Permanently deletes an empty bucket. The request fails if there are any live or noncurrent
   * objects in the bucket, but the request succeeds if the bucket only contains soft-deleted
   * objects or incomplete uploads, such as ongoing XML API multipart uploads. Does not permanently
   * delete soft-deleted objects.
   *
   * <p>When this API is used to delete a bucket containing an object that has a soft delete policy
   * enabled, the object becomes soft deleted, and the `softDeleteTime` and `hardDeleteTime`
   * properties are set on the object.
   *
   * <p>Objects and multipart uploads that were in the bucket at the time of deletion are also
   * retained for the specified retention duration. When a soft-deleted bucket reaches the end of
   * its retention duration, it is permanently deleted. The `hardDeleteTime` of the bucket always
   * equals or exceeds the expiration time of the last soft-deleted object in the bucket.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.delete` IAM permission on the bucket.
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
   * Permanently deletes an empty bucket. The request fails if there are any live or noncurrent
   * objects in the bucket, but the request succeeds if the bucket only contains soft-deleted
   * objects or incomplete uploads, such as ongoing XML API multipart uploads. Does not permanently
   * delete soft-deleted objects.
   *
   * <p>When this API is used to delete a bucket containing an object that has a soft delete policy
   * enabled, the object becomes soft deleted, and the `softDeleteTime` and `hardDeleteTime`
   * properties are set on the object.
   *
   * <p>Objects and multipart uploads that were in the bucket at the time of deletion are also
   * retained for the specified retention duration. When a soft-deleted bucket reaches the end of
   * its retention duration, it is permanently deleted. The `hardDeleteTime` of the bucket always
   * equals or exceeds the expiration time of the last soft-deleted object in the bucket.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.delete` IAM permission on the bucket.
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
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.get` IAM permission on the bucket. Additionally, to return
   * specific bucket metadata, the authenticated user must have the following permissions:
   *
   * <p>- To return the IAM policies: `storage.buckets.getIamPolicy` - To return the bucket IP
   * filtering rules: `storage.buckets.getIpFilter`
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
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.get` IAM permission on the bucket. Additionally, to return
   * specific bucket metadata, the authenticated user must have the following permissions:
   *
   * <p>- To return the IAM policies: `storage.buckets.getIamPolicy` - To return the bucket IP
   * filtering rules: `storage.buckets.getIpFilter`
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
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.get` IAM permission on the bucket. Additionally, to return
   * specific bucket metadata, the authenticated user must have the following permissions:
   *
   * <p>- To return the IAM policies: `storage.buckets.getIamPolicy` - To return the bucket IP
   * filtering rules: `storage.buckets.getIpFilter`
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
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.get` IAM permission on the bucket. Additionally, to return
   * specific bucket metadata, the authenticated user must have the following permissions:
   *
   * <p>- To return the IAM policies: `storage.buckets.getIamPolicy` - To return the bucket IP
   * filtering rules: `storage.buckets.getIpFilter`
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
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.create` IAM permission on the bucket. Additionally, to enable
   * specific bucket features, the authenticated user must have the following permissions:
   *
   * <p>- To enable object retention using the `enableObjectRetention` query parameter:
   * `storage.buckets.enableObjectRetention` - To set the bucket IP filtering rules:
   * `storage.buckets.setIpFilter`
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
   * @param parent Required. The project to which this bucket belongs. This field must either be
   *     empty or `projects/_`. The project ID that owns this bucket should be specified in the
   *     `bucket.project` field.
   * @param bucket Optional. Properties of the new bucket being inserted. The name of the bucket is
   *     specified in the `bucket_id` field. Populating `bucket.name` field results in an error. The
   *     project of the bucket must be specified in the `bucket.project` field. This field must be
   *     in `projects/{projectIdentifier}` format, {projectIdentifier} can be the project ID or
   *     project number. The `parent` field must be either empty or `projects/_`.
   * @param bucketId Required. The ID to use for this bucket, which becomes the final component of
   *     the bucket's resource name. For example, the value `foo` might result in a bucket with the
   *     name `projects/123456/buckets/foo`.
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
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.create` IAM permission on the bucket. Additionally, to enable
   * specific bucket features, the authenticated user must have the following permissions:
   *
   * <p>- To enable object retention using the `enableObjectRetention` query parameter:
   * `storage.buckets.enableObjectRetention` - To set the bucket IP filtering rules:
   * `storage.buckets.setIpFilter`
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
   * @param parent Required. The project to which this bucket belongs. This field must either be
   *     empty or `projects/_`. The project ID that owns this bucket should be specified in the
   *     `bucket.project` field.
   * @param bucket Optional. Properties of the new bucket being inserted. The name of the bucket is
   *     specified in the `bucket_id` field. Populating `bucket.name` field results in an error. The
   *     project of the bucket must be specified in the `bucket.project` field. This field must be
   *     in `projects/{projectIdentifier}` format, {projectIdentifier} can be the project ID or
   *     project number. The `parent` field must be either empty or `projects/_`.
   * @param bucketId Required. The ID to use for this bucket, which becomes the final component of
   *     the bucket's resource name. For example, the value `foo` might result in a bucket with the
   *     name `projects/123456/buckets/foo`.
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
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.create` IAM permission on the bucket. Additionally, to enable
   * specific bucket features, the authenticated user must have the following permissions:
   *
   * <p>- To enable object retention using the `enableObjectRetention` query parameter:
   * `storage.buckets.enableObjectRetention` - To set the bucket IP filtering rules:
   * `storage.buckets.setIpFilter`
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
   *           .setEnableObjectRetention(true)
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
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.create` IAM permission on the bucket. Additionally, to enable
   * specific bucket features, the authenticated user must have the following permissions:
   *
   * <p>- To enable object retention using the `enableObjectRetention` query parameter:
   * `storage.buckets.enableObjectRetention` - To set the bucket IP filtering rules:
   * `storage.buckets.setIpFilter`
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
   *           .setEnableObjectRetention(true)
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
   * Retrieves a list of buckets for a given project, ordered lexicographically by name.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.list` IAM permission on the bucket. Additionally, to enable
   * specific bucket features, the authenticated user must have the following permissions:
   *
   * <p>- To list the IAM policies: `storage.buckets.getIamPolicy` - To list the bucket IP filtering
   * rules: `storage.buckets.getIpFilter`
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
   * Retrieves a list of buckets for a given project, ordered lexicographically by name.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.list` IAM permission on the bucket. Additionally, to enable
   * specific bucket features, the authenticated user must have the following permissions:
   *
   * <p>- To list the IAM policies: `storage.buckets.getIamPolicy` - To list the bucket IP filtering
   * rules: `storage.buckets.getIpFilter`
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
   * Retrieves a list of buckets for a given project, ordered lexicographically by name.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.list` IAM permission on the bucket. Additionally, to enable
   * specific bucket features, the authenticated user must have the following permissions:
   *
   * <p>- To list the IAM policies: `storage.buckets.getIamPolicy` - To list the bucket IP filtering
   * rules: `storage.buckets.getIpFilter`
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
   *           .setReturnPartialSuccess(true)
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
   * Retrieves a list of buckets for a given project, ordered lexicographically by name.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.list` IAM permission on the bucket. Additionally, to enable
   * specific bucket features, the authenticated user must have the following permissions:
   *
   * <p>- To list the IAM policies: `storage.buckets.getIamPolicy` - To list the bucket IP filtering
   * rules: `storage.buckets.getIpFilter`
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
   *           .setReturnPartialSuccess(true)
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
   * Retrieves a list of buckets for a given project, ordered lexicographically by name.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.list` IAM permission on the bucket. Additionally, to enable
   * specific bucket features, the authenticated user must have the following permissions:
   *
   * <p>- To list the IAM policies: `storage.buckets.getIamPolicy` - To list the bucket IP filtering
   * rules: `storage.buckets.getIpFilter`
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
   *           .setReturnPartialSuccess(true)
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
   * Permanently locks the retention policy that is currently applied to the specified bucket.
   *
   * <p>Caution: Locking a bucket is an irreversible action. Once you lock a bucket:
   *
   * <p>- You cannot remove the retention policy from the bucket. - You cannot decrease the
   * retention period for the policy.
   *
   * <p>Once locked, you must delete the entire bucket in order to remove the bucket's retention
   * policy. However, before you can delete the bucket, you must delete all the objects in the
   * bucket, which is only possible if all the objects have reached the retention period set by the
   * retention policy.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.update` IAM permission on the bucket.
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
   * Permanently locks the retention policy that is currently applied to the specified bucket.
   *
   * <p>Caution: Locking a bucket is an irreversible action. Once you lock a bucket:
   *
   * <p>- You cannot remove the retention policy from the bucket. - You cannot decrease the
   * retention period for the policy.
   *
   * <p>Once locked, you must delete the entire bucket in order to remove the bucket's retention
   * policy. However, before you can delete the bucket, you must delete all the objects in the
   * bucket, which is only possible if all the objects have reached the retention period set by the
   * retention policy.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.update` IAM permission on the bucket.
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
   * Permanently locks the retention policy that is currently applied to the specified bucket.
   *
   * <p>Caution: Locking a bucket is an irreversible action. Once you lock a bucket:
   *
   * <p>- You cannot remove the retention policy from the bucket. - You cannot decrease the
   * retention period for the policy.
   *
   * <p>Once locked, you must delete the entire bucket in order to remove the bucket's retention
   * policy. However, before you can delete the bucket, you must delete all the objects in the
   * bucket, which is only possible if all the objects have reached the retention period set by the
   * retention policy.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.update` IAM permission on the bucket.
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
   * Permanently locks the retention policy that is currently applied to the specified bucket.
   *
   * <p>Caution: Locking a bucket is an irreversible action. Once you lock a bucket:
   *
   * <p>- You cannot remove the retention policy from the bucket. - You cannot decrease the
   * retention period for the policy.
   *
   * <p>Once locked, you must delete the entire bucket in order to remove the bucket's retention
   * policy. However, before you can delete the bucket, you must delete all the objects in the
   * bucket, which is only possible if all the objects have reached the retention period set by the
   * retention policy.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.update` IAM permission on the bucket.
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
   * Gets the IAM policy for a specified bucket or managed folder. The `resource` field in the
   * request should be `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.getIamPolicy` on the bucket or
   * `storage.managedFolders.getIamPolicy` IAM permission on the managed folder.
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
   * Gets the IAM policy for a specified bucket or managed folder. The `resource` field in the
   * request should be `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.getIamPolicy` on the bucket or
   * `storage.managedFolders.getIamPolicy` IAM permission on the managed folder.
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
   * Gets the IAM policy for a specified bucket or managed folder. The `resource` field in the
   * request should be `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.getIamPolicy` on the bucket or
   * `storage.managedFolders.getIamPolicy` IAM permission on the managed folder.
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
   * Gets the IAM policy for a specified bucket or managed folder. The `resource` field in the
   * request should be `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.getIamPolicy` on the bucket or
   * `storage.managedFolders.getIamPolicy` IAM permission on the managed folder.
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
   * Updates an IAM policy for the specified bucket or managed folder. The `resource` field in the
   * request should be `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
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
   * Updates an IAM policy for the specified bucket or managed folder. The `resource` field in the
   * request should be `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
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
   * Updates an IAM policy for the specified bucket or managed folder. The `resource` field in the
   * request should be `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
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
   * Updates an IAM policy for the specified bucket or managed folder. The `resource` field in the
   * request should be `projects/_/buckets/{bucket}` for a bucket, or
   * `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed folder.
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
   * Tests a set of permissions on the given bucket, object, or managed folder to see which, if any,
   * are held by the caller. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, `projects/_/buckets/{bucket}/objects/{object}` for
   * an object, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed
   * folder.
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
   * Tests a set of permissions on the given bucket, object, or managed folder to see which, if any,
   * are held by the caller. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, `projects/_/buckets/{bucket}/objects/{object}` for
   * an object, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed
   * folder.
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
   * Tests a set of permissions on the given bucket, object, or managed folder to see which, if any,
   * are held by the caller. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, `projects/_/buckets/{bucket}/objects/{object}` for
   * an object, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed
   * folder.
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
   * Tests a set of permissions on the given bucket, object, or managed folder to see which, if any,
   * are held by the caller. The `resource` field in the request should be
   * `projects/_/buckets/{bucket}` for a bucket, `projects/_/buckets/{bucket}/objects/{object}` for
   * an object, or `projects/_/buckets/{bucket}/managedFolders/{managedFolder}` for a managed
   * folder.
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
   * Updates a bucket. Changes to the bucket are readable immediately after writing, but
   * configuration changes might take time to propagate. This method supports `patch` semantics.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.update` IAM permission on the bucket. Additionally, to enable
   * specific bucket features, the authenticated user must have the following permissions:
   *
   * <p>- To set bucket IP filtering rules: `storage.buckets.setIpFilter` - To update public access
   * prevention policies or access control lists (ACLs): `storage.buckets.setIamPolicy`
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
   * @param bucket Required. The bucket to update. The bucket's `name` field is used to identify the
   *     bucket.
   * @param updateMask Required. List of fields to be updated.
   *     <p>To specify ALL fields, equivalent to the JSON API's "update" function, specify a single
   *     field with the value `&#42;`. Note: not recommended. If a new field is introduced at a
   *     later time, an older client updating with the `&#42;` might accidentally reset the new
   *     field's value.
   *     <p>Not specifying any fields is an error.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket updateBucket(Bucket bucket, FieldMask updateMask) {
    UpdateBucketRequest request =
        UpdateBucketRequest.newBuilder().setBucket(bucket).setUpdateMask(updateMask).build();
    return updateBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a bucket. Changes to the bucket are readable immediately after writing, but
   * configuration changes might take time to propagate. This method supports `patch` semantics.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.update` IAM permission on the bucket. Additionally, to enable
   * specific bucket features, the authenticated user must have the following permissions:
   *
   * <p>- To set bucket IP filtering rules: `storage.buckets.setIpFilter` - To update public access
   * prevention policies or access control lists (ACLs): `storage.buckets.setIamPolicy`
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
   * Updates a bucket. Changes to the bucket are readable immediately after writing, but
   * configuration changes might take time to propagate. This method supports `patch` semantics.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.buckets.update` IAM permission on the bucket. Additionally, to enable
   * specific bucket features, the authenticated user must have the following permissions:
   *
   * <p>- To set bucket IP filtering rules: `storage.buckets.setIpFilter` - To update public access
   * prevention policies or access control lists (ACLs): `storage.buckets.setIamPolicy`
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
   * Concatenates a list of existing objects into a new object in the same bucket. The existing
   * source objects are unaffected by this operation.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires the `storage.objects.create` and `storage.objects.get` IAM permissions to use this
   * method. If the new composite object overwrites an existing object, the authenticated user must
   * also have the `storage.objects.delete` permission. If the request body includes the retention
   * property, the authenticated user must also have the `storage.objects.setRetention` IAM
   * permission.
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
   *           .setDeleteSourceObjects(true)
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
   * Concatenates a list of existing objects into a new object in the same bucket. The existing
   * source objects are unaffected by this operation.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires the `storage.objects.create` and `storage.objects.get` IAM permissions to use this
   * method. If the new composite object overwrites an existing object, the authenticated user must
   * also have the `storage.objects.delete` permission. If the request body includes the retention
   * property, the authenticated user must also have the `storage.objects.setRetention` IAM
   * permission.
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
   *           .setDeleteSourceObjects(true)
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
   * the bucket, or if the generation parameter is used, or if soft delete is not enabled for the
   * bucket. When this API is used to delete an object from a bucket that has soft delete policy
   * enabled, the object becomes soft deleted, and the `softDeleteTime` and `hardDeleteTime`
   * properties are set on the object. This API cannot be used to permanently delete soft-deleted
   * objects. Soft-deleted objects are permanently deleted according to their `hardDeleteTime`.
   *
   * <p>You can use the [`RestoreObject`][google.storage.v2.Storage.RestoreObject] API to restore
   * soft-deleted objects until the soft delete retention period has passed.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.delete` IAM permission on the bucket.
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
  public final void deleteObject(BucketName bucket, String object) {
    DeleteObjectRequest request =
        DeleteObjectRequest.newBuilder()
            .setBucket(bucket == null ? null : bucket.toString())
            .setObject(object)
            .build();
    deleteObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an object and its metadata. Deletions are permanent if versioning is not enabled for
   * the bucket, or if the generation parameter is used, or if soft delete is not enabled for the
   * bucket. When this API is used to delete an object from a bucket that has soft delete policy
   * enabled, the object becomes soft deleted, and the `softDeleteTime` and `hardDeleteTime`
   * properties are set on the object. This API cannot be used to permanently delete soft-deleted
   * objects. Soft-deleted objects are permanently deleted according to their `hardDeleteTime`.
   *
   * <p>You can use the [`RestoreObject`][google.storage.v2.Storage.RestoreObject] API to restore
   * soft-deleted objects until the soft delete retention period has passed.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.delete` IAM permission on the bucket.
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
   * the bucket, or if the generation parameter is used, or if soft delete is not enabled for the
   * bucket. When this API is used to delete an object from a bucket that has soft delete policy
   * enabled, the object becomes soft deleted, and the `softDeleteTime` and `hardDeleteTime`
   * properties are set on the object. This API cannot be used to permanently delete soft-deleted
   * objects. Soft-deleted objects are permanently deleted according to their `hardDeleteTime`.
   *
   * <p>You can use the [`RestoreObject`][google.storage.v2.Storage.RestoreObject] API to restore
   * soft-deleted objects until the soft delete retention period has passed.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.delete` IAM permission on the bucket.
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
   *   String object = "object-1023368385";
   *   long generation = 305703192;
   *   storageClient.deleteObject(bucket, object, generation);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of the bucket in which the object resides.
   * @param object Required. The name of the finalized object to delete. Note: If you want to delete
   *     an unfinalized resumable upload please use `CancelResumableWrite`.
   * @param generation Optional. If present, permanently deletes a specific revision of this object
   *     (as opposed to the latest version, the default).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteObject(BucketName bucket, String object, long generation) {
    DeleteObjectRequest request =
        DeleteObjectRequest.newBuilder()
            .setBucket(bucket == null ? null : bucket.toString())
            .setObject(object)
            .setGeneration(generation)
            .build();
    deleteObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an object and its metadata. Deletions are permanent if versioning is not enabled for
   * the bucket, or if the generation parameter is used, or if soft delete is not enabled for the
   * bucket. When this API is used to delete an object from a bucket that has soft delete policy
   * enabled, the object becomes soft deleted, and the `softDeleteTime` and `hardDeleteTime`
   * properties are set on the object. This API cannot be used to permanently delete soft-deleted
   * objects. Soft-deleted objects are permanently deleted according to their `hardDeleteTime`.
   *
   * <p>You can use the [`RestoreObject`][google.storage.v2.Storage.RestoreObject] API to restore
   * soft-deleted objects until the soft delete retention period has passed.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.delete` IAM permission on the bucket.
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
   *   String object = "object-1023368385";
   *   long generation = 305703192;
   *   storageClient.deleteObject(bucket, object, generation);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of the bucket in which the object resides.
   * @param object Required. The name of the finalized object to delete. Note: If you want to delete
   *     an unfinalized resumable upload please use `CancelResumableWrite`.
   * @param generation Optional. If present, permanently deletes a specific revision of this object
   *     (as opposed to the latest version, the default).
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
   * the bucket, or if the generation parameter is used, or if soft delete is not enabled for the
   * bucket. When this API is used to delete an object from a bucket that has soft delete policy
   * enabled, the object becomes soft deleted, and the `softDeleteTime` and `hardDeleteTime`
   * properties are set on the object. This API cannot be used to permanently delete soft-deleted
   * objects. Soft-deleted objects are permanently deleted according to their `hardDeleteTime`.
   *
   * <p>You can use the [`RestoreObject`][google.storage.v2.Storage.RestoreObject] API to restore
   * soft-deleted objects until the soft delete retention period has passed.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.delete` IAM permission on the bucket.
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
   *           .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
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
   * the bucket, or if the generation parameter is used, or if soft delete is not enabled for the
   * bucket. When this API is used to delete an object from a bucket that has soft delete policy
   * enabled, the object becomes soft deleted, and the `softDeleteTime` and `hardDeleteTime`
   * properties are set on the object. This API cannot be used to permanently delete soft-deleted
   * objects. Soft-deleted objects are permanently deleted according to their `hardDeleteTime`.
   *
   * <p>You can use the [`RestoreObject`][google.storage.v2.Storage.RestoreObject] API to restore
   * soft-deleted objects until the soft delete retention period has passed.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.delete` IAM permission on the bucket.
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
   *           .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
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
   * Restores a soft-deleted object. When a soft-deleted object is restored, a new copy of that
   * object is created in the same bucket and inherits the same metadata as the soft-deleted object.
   * The inherited metadata is the metadata that existed when the original object became soft
   * deleted, with the following exceptions:
   *
   * <p>- The `createTime` of the new object is set to the time at which the soft-deleted object was
   * restored. - The `softDeleteTime` and `hardDeleteTime` values are cleared. - A new generation is
   * assigned and the metageneration is reset to 1. - If the soft-deleted object was in a bucket
   * that had Autoclass enabled, the new object is restored to Standard storage. - The restored
   * object inherits the bucket's default object ACL, unless `copySourceAcl` is `true`.
   *
   * <p>If a live object using the same name already exists in the bucket and becomes overwritten,
   * the live object becomes a noncurrent object if Object Versioning is enabled on the bucket. If
   * Object Versioning is not enabled, the live object becomes soft deleted.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires the following IAM permissions to use this method:
   *
   * <p>- `storage.objects.restore` - `storage.objects.create` - `storage.objects.delete` (only
   * required if overwriting an existing object) - `storage.objects.getIamPolicy` (only required if
   * `projection` is `full` and the relevant bucket has uniform bucket-level access disabled) -
   * `storage.objects.setIamPolicy` (only required if `copySourceAcl` is `true` and the relevant
   * bucket has uniform bucket-level access disabled)
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
   *   String object = "object-1023368385";
   *   long generation = 305703192;
   *   Object response = storageClient.restoreObject(bucket, object, generation);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of the bucket in which the object resides.
   * @param object Required. The name of the object to restore.
   * @param generation Required. The specific revision of the object to restore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object restoreObject(BucketName bucket, String object, long generation) {
    RestoreObjectRequest request =
        RestoreObjectRequest.newBuilder()
            .setBucket(bucket == null ? null : bucket.toString())
            .setObject(object)
            .setGeneration(generation)
            .build();
    return restoreObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a soft-deleted object. When a soft-deleted object is restored, a new copy of that
   * object is created in the same bucket and inherits the same metadata as the soft-deleted object.
   * The inherited metadata is the metadata that existed when the original object became soft
   * deleted, with the following exceptions:
   *
   * <p>- The `createTime` of the new object is set to the time at which the soft-deleted object was
   * restored. - The `softDeleteTime` and `hardDeleteTime` values are cleared. - A new generation is
   * assigned and the metageneration is reset to 1. - If the soft-deleted object was in a bucket
   * that had Autoclass enabled, the new object is restored to Standard storage. - The restored
   * object inherits the bucket's default object ACL, unless `copySourceAcl` is `true`.
   *
   * <p>If a live object using the same name already exists in the bucket and becomes overwritten,
   * the live object becomes a noncurrent object if Object Versioning is enabled on the bucket. If
   * Object Versioning is not enabled, the live object becomes soft deleted.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires the following IAM permissions to use this method:
   *
   * <p>- `storage.objects.restore` - `storage.objects.create` - `storage.objects.delete` (only
   * required if overwriting an existing object) - `storage.objects.getIamPolicy` (only required if
   * `projection` is `full` and the relevant bucket has uniform bucket-level access disabled) -
   * `storage.objects.setIamPolicy` (only required if `copySourceAcl` is `true` and the relevant
   * bucket has uniform bucket-level access disabled)
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
   *   String object = "object-1023368385";
   *   long generation = 305703192;
   *   Object response = storageClient.restoreObject(bucket, object, generation);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of the bucket in which the object resides.
   * @param object Required. The name of the object to restore.
   * @param generation Required. The specific revision of the object to restore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object restoreObject(String bucket, String object, long generation) {
    RestoreObjectRequest request =
        RestoreObjectRequest.newBuilder()
            .setBucket(bucket)
            .setObject(object)
            .setGeneration(generation)
            .build();
    return restoreObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a soft-deleted object. When a soft-deleted object is restored, a new copy of that
   * object is created in the same bucket and inherits the same metadata as the soft-deleted object.
   * The inherited metadata is the metadata that existed when the original object became soft
   * deleted, with the following exceptions:
   *
   * <p>- The `createTime` of the new object is set to the time at which the soft-deleted object was
   * restored. - The `softDeleteTime` and `hardDeleteTime` values are cleared. - A new generation is
   * assigned and the metageneration is reset to 1. - If the soft-deleted object was in a bucket
   * that had Autoclass enabled, the new object is restored to Standard storage. - The restored
   * object inherits the bucket's default object ACL, unless `copySourceAcl` is `true`.
   *
   * <p>If a live object using the same name already exists in the bucket and becomes overwritten,
   * the live object becomes a noncurrent object if Object Versioning is enabled on the bucket. If
   * Object Versioning is not enabled, the live object becomes soft deleted.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires the following IAM permissions to use this method:
   *
   * <p>- `storage.objects.restore` - `storage.objects.create` - `storage.objects.delete` (only
   * required if overwriting an existing object) - `storage.objects.getIamPolicy` (only required if
   * `projection` is `full` and the relevant bucket has uniform bucket-level access disabled) -
   * `storage.objects.setIamPolicy` (only required if `copySourceAcl` is `true` and the relevant
   * bucket has uniform bucket-level access disabled)
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
   *   RestoreObjectRequest request =
   *       RestoreObjectRequest.newBuilder()
   *           .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setObject("object-1023368385")
   *           .setGeneration(305703192)
   *           .setRestoreToken("restoreToken1638686731")
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setCopySourceAcl(true)
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .build();
   *   Object response = storageClient.restoreObject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object restoreObject(RestoreObjectRequest request) {
    return restoreObjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a soft-deleted object. When a soft-deleted object is restored, a new copy of that
   * object is created in the same bucket and inherits the same metadata as the soft-deleted object.
   * The inherited metadata is the metadata that existed when the original object became soft
   * deleted, with the following exceptions:
   *
   * <p>- The `createTime` of the new object is set to the time at which the soft-deleted object was
   * restored. - The `softDeleteTime` and `hardDeleteTime` values are cleared. - A new generation is
   * assigned and the metageneration is reset to 1. - If the soft-deleted object was in a bucket
   * that had Autoclass enabled, the new object is restored to Standard storage. - The restored
   * object inherits the bucket's default object ACL, unless `copySourceAcl` is `true`.
   *
   * <p>If a live object using the same name already exists in the bucket and becomes overwritten,
   * the live object becomes a noncurrent object if Object Versioning is enabled on the bucket. If
   * Object Versioning is not enabled, the live object becomes soft deleted.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires the following IAM permissions to use this method:
   *
   * <p>- `storage.objects.restore` - `storage.objects.create` - `storage.objects.delete` (only
   * required if overwriting an existing object) - `storage.objects.getIamPolicy` (only required if
   * `projection` is `full` and the relevant bucket has uniform bucket-level access disabled) -
   * `storage.objects.setIamPolicy` (only required if `copySourceAcl` is `true` and the relevant
   * bucket has uniform bucket-level access disabled)
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
   *   RestoreObjectRequest request =
   *       RestoreObjectRequest.newBuilder()
   *           .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setObject("object-1023368385")
   *           .setGeneration(305703192)
   *           .setRestoreToken("restoreToken1638686731")
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setCopySourceAcl(true)
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .build();
   *   ApiFuture<Object> future = storageClient.restoreObjectCallable().futureCall(request);
   *   // Do something.
   *   Object response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestoreObjectRequest, Object> restoreObjectCallable() {
    return stub.restoreObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an in-progress resumable upload.
   *
   * <p>Any attempts to write to the resumable upload after cancelling the upload fail.
   *
   * <p>The behavior for any in-progress write operations is not guaranteed; they could either
   * complete before the cancellation or fail if the cancellation completes first.
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
   * <p>Any attempts to write to the resumable upload after cancelling the upload fail.
   *
   * <p>The behavior for any in-progress write operations is not guaranteed; they could either
   * complete before the cancellation or fail if the cancellation completes first.
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
   * <p>Any attempts to write to the resumable upload after cancelling the upload fail.
   *
   * <p>The behavior for any in-progress write operations is not guaranteed; they could either
   * complete before the cancellation or fail if the cancellation completes first.
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
   * Retrieves object metadata.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.get` IAM permission on the bucket. To return object ACLs, the
   * authenticated user must also have the `storage.objects.getIamPolicy` permission.
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
   *   String object = "object-1023368385";
   *   Object response = storageClient.getObject(bucket, object);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of the bucket in which the object resides.
   * @param object Required. Name of the object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object getObject(BucketName bucket, String object) {
    GetObjectRequest request =
        GetObjectRequest.newBuilder()
            .setBucket(bucket == null ? null : bucket.toString())
            .setObject(object)
            .build();
    return getObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves object metadata.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.get` IAM permission on the bucket. To return object ACLs, the
   * authenticated user must also have the `storage.objects.getIamPolicy` permission.
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
   * Retrieves object metadata.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.get` IAM permission on the bucket. To return object ACLs, the
   * authenticated user must also have the `storage.objects.getIamPolicy` permission.
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
   *   String object = "object-1023368385";
   *   long generation = 305703192;
   *   Object response = storageClient.getObject(bucket, object, generation);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of the bucket in which the object resides.
   * @param object Required. Name of the object.
   * @param generation Optional. If present, selects a specific revision of this object (as opposed
   *     to the latest version, the default).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object getObject(BucketName bucket, String object, long generation) {
    GetObjectRequest request =
        GetObjectRequest.newBuilder()
            .setBucket(bucket == null ? null : bucket.toString())
            .setObject(object)
            .setGeneration(generation)
            .build();
    return getObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves object metadata.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.get` IAM permission on the bucket. To return object ACLs, the
   * authenticated user must also have the `storage.objects.getIamPolicy` permission.
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
   *   String object = "object-1023368385";
   *   long generation = 305703192;
   *   Object response = storageClient.getObject(bucket, object, generation);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of the bucket in which the object resides.
   * @param object Required. Name of the object.
   * @param generation Optional. If present, selects a specific revision of this object (as opposed
   *     to the latest version, the default).
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
   * Retrieves object metadata.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.get` IAM permission on the bucket. To return object ACLs, the
   * authenticated user must also have the `storage.objects.getIamPolicy` permission.
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
   *           .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setObject("object-1023368385")
   *           .setGeneration(305703192)
   *           .setSoftDeleted(true)
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setRestoreToken("restoreToken1638686731")
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
   * Retrieves object metadata.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.get` IAM permission on the bucket. To return object ACLs, the
   * authenticated user must also have the `storage.objects.getIamPolicy` permission.
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
   *           .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setObject("object-1023368385")
   *           .setGeneration(305703192)
   *           .setSoftDeleted(true)
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setRestoreToken("restoreToken1638686731")
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
   * Retrieves object data.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.get` IAM permission on the bucket.
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
   *           .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
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
   * Reads an object's data.
   *
   * <p>This bi-directional API reads data from an object, allowing you to request multiple data
   * ranges within a single stream, even across several messages. If an error occurs with any
   * request, the stream closes with a relevant error code. Since you can have multiple outstanding
   * requests, the error response includes a `BidiReadObjectError` proto in its `details` field,
   * reporting the specific error, if any, for each pending `read_id`.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.get` IAM permission on the bucket.
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
   *   BidiStream<BidiReadObjectRequest, BidiReadObjectResponse> bidiStream =
   *       storageClient.bidiReadObjectCallable().call();
   *   BidiReadObjectRequest request =
   *       BidiReadObjectRequest.newBuilder()
   *           .setReadObjectSpec(BidiReadObjectSpec.newBuilder().build())
   *           .addAllReadRanges(new ArrayList<ReadRange>())
   *           .build();
   *   bidiStream.send(request);
   *   for (BidiReadObjectResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse>
      bidiReadObjectCallable() {
    return stub.bidiReadObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an object's metadata. Equivalent to JSON API's `storage.objects.patch` method.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.update` IAM permission on the bucket.
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
   *     later time, an older client updating with the `&#42;` might accidentally reset the new
   *     field's value.
   *     <p>Not specifying any fields is an error.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object updateObject(Object object, FieldMask updateMask) {
    UpdateObjectRequest request =
        UpdateObjectRequest.newBuilder().setObject(object).setUpdateMask(updateMask).build();
    return updateObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an object's metadata. Equivalent to JSON API's `storage.objects.patch` method.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.update` IAM permission on the bucket.
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
   *           .setOverrideUnlockedRetention(true)
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
   * Updates an object's metadata. Equivalent to JSON API's `storage.objects.patch` method.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.update` IAM permission on the bucket.
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
   *           .setOverrideUnlockedRetention(true)
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
   * the server), the client should do as follows:
   *
   * <p>- Check the result Status of the stream, to determine if writing can be resumed on this
   * stream or must be restarted from scratch (by calling `StartResumableWrite()`). The resumable
   * errors are `DEADLINE_EXCEEDED`, `INTERNAL`, and `UNAVAILABLE`. For each case, the client should
   * use binary exponential backoff before retrying. Additionally, writes can be resumed after
   * `RESOURCE_EXHAUSTED` errors, but only after taking appropriate measures, which might include
   * reducing aggregate send rate across clients and/or requesting a quota increase for your
   * project. - If the call to `WriteObject` returns `ABORTED`, that indicates concurrent attempts
   * to update the resumable write, caused either by multiple racing clients or by a single client
   * where the previous request was timed out on the client side but nonetheless reached the server.
   * In this case the client should take steps to prevent further concurrent writes. For example,
   * increase the timeouts and stop using more than one process to perform the upload. Follow the
   * steps below for resuming the upload. - For resumable errors, the client should call
   * `QueryWriteStatus()` and then continue writing from the returned `persisted_size`. This might
   * be less than the amount of data the client previously sent. Note also that it is acceptable to
   * send data starting at an offset earlier than the returned `persisted_size`; in this case, the
   * service skips data at offsets that were already persisted (without checking that it matches the
   * previously written data), and write only the data starting from the persisted offset. Even
   * though the data isn't written, it might still incur a performance cost over resuming at the
   * correct write offset. This behavior can make client-side handling simpler in some cases. -
   * Clients must only send data that is a multiple of 256 KiB per message, unless the object is
   * being finished with `finish_write` set to `true`.
   *
   * <p>The service does not view the object as complete until the client has sent a
   * `WriteObjectRequest` with `finish_write` set to `true`. Sending any requests on a stream after
   * sending a request with `finish_write` set to `true` causes an error. The client must check the
   * response it receives to determine how much data the service is able to commit and whether the
   * service views the object as complete.
   *
   * <p>Attempting to resume an already finalized object results in an `OK` status, with a
   * `WriteObjectResponse` containing the finalized object's metadata.
   *
   * <p>Alternatively, you can use the `BidiWriteObject` operation to write an object with controls
   * over flushing and the ability to fetch the ability to determine the current persisted size.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.create` IAM permission on the bucket.
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
   * Stores a new object and metadata.
   *
   * <p>This is similar to the `WriteObject` call with the added support for manual flushing of
   * persisted state, and the ability to determine current persisted size without closing the
   * stream.
   *
   * <p>The client might specify one or both of the `state_lookup` and `flush` fields in each
   * `BidiWriteObjectRequest`. If `flush` is specified, the data written so far is persisted to
   * storage. If `state_lookup` is specified, the service responds with a `BidiWriteObjectResponse`
   * that contains the persisted size. If both `flush` and `state_lookup` are specified, the flush
   * always occurs before a `state_lookup`, so that both might be set in the same request and the
   * returned state is the state of the object post-flush. When the stream is closed, a
   * `BidiWriteObjectResponse` is always sent to the client, regardless of the value of
   * `state_lookup`.
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
   *   BidiStream<BidiWriteObjectRequest, BidiWriteObjectResponse> bidiStream =
   *       storageClient.bidiWriteObjectCallable().call();
   *   BidiWriteObjectRequest request =
   *       BidiWriteObjectRequest.newBuilder()
   *           .setWriteOffset(-1559543565)
   *           .setObjectChecksums(ObjectChecksums.newBuilder().build())
   *           .setStateLookup(true)
   *           .setFlush(true)
   *           .setFinishWrite(true)
   *           .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
   *           .build();
   *   bidiStream.send(request);
   *   for (BidiWriteObjectResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<BidiWriteObjectRequest, BidiWriteObjectResponse>
      bidiWriteObjectCallable() {
    return stub.bidiWriteObjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of objects matching the criteria.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>The authenticated user requires `storage.objects.list` IAM permission to use this method. To
   * return object ACLs, the authenticated user must also have the `storage.objects.getIamPolicy`
   * permission.
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
   *   BucketName parent = BucketName.of("[PROJECT]", "[BUCKET]");
   *   for (Object element : storageClient.listObjects(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the bucket in which to look for objects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListObjectsPagedResponse listObjects(BucketName parent) {
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
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>The authenticated user requires `storage.objects.list` IAM permission to use this method. To
   * return object ACLs, the authenticated user must also have the `storage.objects.getIamPolicy`
   * permission.
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
   *   String parent = BucketName.of("[PROJECT]", "[BUCKET]").toString();
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
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>The authenticated user requires `storage.objects.list` IAM permission to use this method. To
   * return object ACLs, the authenticated user must also have the `storage.objects.getIamPolicy`
   * permission.
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
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setDelimiter("delimiter-250518009")
   *           .setIncludeTrailingDelimiter(true)
   *           .setPrefix("prefix-980110702")
   *           .setVersions(true)
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setLexicographicStart("lexicographicStart-2093413008")
   *           .setLexicographicEnd("lexicographicEnd1646968169")
   *           .setSoftDeleted(true)
   *           .setIncludeFoldersAsPrefixes(true)
   *           .setMatchGlob("matchGlob613636317")
   *           .setFilter("filter-1274492040")
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
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>The authenticated user requires `storage.objects.list` IAM permission to use this method. To
   * return object ACLs, the authenticated user must also have the `storage.objects.getIamPolicy`
   * permission.
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
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setDelimiter("delimiter-250518009")
   *           .setIncludeTrailingDelimiter(true)
   *           .setPrefix("prefix-980110702")
   *           .setVersions(true)
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setLexicographicStart("lexicographicStart-2093413008")
   *           .setLexicographicEnd("lexicographicEnd1646968169")
   *           .setSoftDeleted(true)
   *           .setIncludeFoldersAsPrefixes(true)
   *           .setMatchGlob("matchGlob613636317")
   *           .setFilter("filter-1274492040")
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
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>The authenticated user requires `storage.objects.list` IAM permission to use this method. To
   * return object ACLs, the authenticated user must also have the `storage.objects.getIamPolicy`
   * permission.
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
   *           .setParent(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setDelimiter("delimiter-250518009")
   *           .setIncludeTrailingDelimiter(true)
   *           .setPrefix("prefix-980110702")
   *           .setVersions(true)
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setLexicographicStart("lexicographicStart-2093413008")
   *           .setLexicographicEnd("lexicographicEnd1646968169")
   *           .setSoftDeleted(true)
   *           .setIncludeFoldersAsPrefixes(true)
   *           .setMatchGlob("matchGlob613636317")
   *           .setFilter("filter-1274492040")
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
   *           .setSourceBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
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
   *           .setSourceBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
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
   * Starts a resumable write operation. This method is part of the Resumable upload feature. This
   * allows you to upload large objects in multiple chunks, which is more resilient to network
   * interruptions than a single upload. The validity duration of the write operation, and the
   * consequences of it becoming invalid, are service-dependent.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.create` IAM permission on the bucket.
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
   * Starts a resumable write operation. This method is part of the Resumable upload feature. This
   * allows you to upload large objects in multiple chunks, which is more resilient to network
   * interruptions than a single upload. The validity duration of the write operation, and the
   * consequences of it becoming invalid, are service-dependent.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires `storage.objects.create` IAM permission on the bucket.
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
   * Determines the `persisted_size` of an object that is being written. This method is part of the
   * resumable upload feature. The returned value is the size of the object that has been persisted
   * so far. The value can be used as the `write_offset` for the next `Write()` call.
   *
   * <p>If the object does not exist, meaning if it was deleted, or the first `Write()` has not yet
   * reached the service, this method returns the error `NOT_FOUND`.
   *
   * <p>This method is useful for clients that buffer data and need to know which data can be safely
   * evicted. The client can call `QueryWriteStatus()` at any time to determine how much data has
   * been logged for this object. For any sequence of `QueryWriteStatus()` calls for a given object
   * name, the sequence of returned `persisted_size` values are non-decreasing.
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
   * Determines the `persisted_size` of an object that is being written. This method is part of the
   * resumable upload feature. The returned value is the size of the object that has been persisted
   * so far. The value can be used as the `write_offset` for the next `Write()` call.
   *
   * <p>If the object does not exist, meaning if it was deleted, or the first `Write()` has not yet
   * reached the service, this method returns the error `NOT_FOUND`.
   *
   * <p>This method is useful for clients that buffer data and need to know which data can be safely
   * evicted. The client can call `QueryWriteStatus()` at any time to determine how much data has
   * been logged for this object. For any sequence of `QueryWriteStatus()` calls for a given object
   * name, the sequence of returned `persisted_size` values are non-decreasing.
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
   * Determines the `persisted_size` of an object that is being written. This method is part of the
   * resumable upload feature. The returned value is the size of the object that has been persisted
   * so far. The value can be used as the `write_offset` for the next `Write()` call.
   *
   * <p>If the object does not exist, meaning if it was deleted, or the first `Write()` has not yet
   * reached the service, this method returns the error `NOT_FOUND`.
   *
   * <p>This method is useful for clients that buffer data and need to know which data can be safely
   * evicted. The client can call `QueryWriteStatus()` at any time to determine how much data has
   * been logged for this object. For any sequence of `QueryWriteStatus()` calls for a given object
   * name, the sequence of returned `persisted_size` values are non-decreasing.
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
   * Moves the source object to the destination object in the same bucket. This operation moves a
   * source object to a destination object in the same bucket by renaming the object. The move
   * itself is an atomic transaction, ensuring all steps either complete successfully or no changes
   * are made.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires the following IAM permissions to use this method:
   *
   * <p>- `storage.objects.move` - `storage.objects.create` - `storage.objects.delete` (only
   * required if overwriting an existing object)
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
   *   String sourceObject = "sourceObject1196439354";
   *   String destinationObject = "destinationObject-1761603347";
   *   Object response = storageClient.moveObject(bucket, sourceObject, destinationObject);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of the bucket in which the object resides.
   * @param sourceObject Required. Name of the source object.
   * @param destinationObject Required. Name of the destination object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object moveObject(BucketName bucket, String sourceObject, String destinationObject) {
    MoveObjectRequest request =
        MoveObjectRequest.newBuilder()
            .setBucket(bucket == null ? null : bucket.toString())
            .setSourceObject(sourceObject)
            .setDestinationObject(destinationObject)
            .build();
    return moveObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves the source object to the destination object in the same bucket. This operation moves a
   * source object to a destination object in the same bucket by renaming the object. The move
   * itself is an atomic transaction, ensuring all steps either complete successfully or no changes
   * are made.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires the following IAM permissions to use this method:
   *
   * <p>- `storage.objects.move` - `storage.objects.create` - `storage.objects.delete` (only
   * required if overwriting an existing object)
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
   *   String sourceObject = "sourceObject1196439354";
   *   String destinationObject = "destinationObject-1761603347";
   *   Object response = storageClient.moveObject(bucket, sourceObject, destinationObject);
   * }
   * }</pre>
   *
   * @param bucket Required. Name of the bucket in which the object resides.
   * @param sourceObject Required. Name of the source object.
   * @param destinationObject Required. Name of the destination object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object moveObject(String bucket, String sourceObject, String destinationObject) {
    MoveObjectRequest request =
        MoveObjectRequest.newBuilder()
            .setBucket(bucket)
            .setSourceObject(sourceObject)
            .setDestinationObject(destinationObject)
            .build();
    return moveObject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves the source object to the destination object in the same bucket. This operation moves a
   * source object to a destination object in the same bucket by renaming the object. The move
   * itself is an atomic transaction, ensuring all steps either complete successfully or no changes
   * are made.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires the following IAM permissions to use this method:
   *
   * <p>- `storage.objects.move` - `storage.objects.create` - `storage.objects.delete` (only
   * required if overwriting an existing object)
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
   *   MoveObjectRequest request =
   *       MoveObjectRequest.newBuilder()
   *           .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setSourceObject("sourceObject1196439354")
   *           .setDestinationObject("destinationObject-1761603347")
   *           .setIfSourceGenerationMatch(-1427877280)
   *           .setIfSourceGenerationNotMatch(1575612532)
   *           .setIfSourceMetagenerationMatch(1143319909)
   *           .setIfSourceMetagenerationNotMatch(1900822777)
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .build();
   *   Object response = storageClient.moveObject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Object moveObject(MoveObjectRequest request) {
    return moveObjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves the source object to the destination object in the same bucket. This operation moves a
   * source object to a destination object in the same bucket by renaming the object. The move
   * itself is an atomic transaction, ensuring all steps either complete successfully or no changes
   * are made.
   *
   * <p>&#42;&#42;IAM Permissions&#42;&#42;:
   *
   * <p>Requires the following IAM permissions to use this method:
   *
   * <p>- `storage.objects.move` - `storage.objects.create` - `storage.objects.delete` (only
   * required if overwriting an existing object)
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
   *   MoveObjectRequest request =
   *       MoveObjectRequest.newBuilder()
   *           .setBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
   *           .setSourceObject("sourceObject1196439354")
   *           .setDestinationObject("destinationObject-1761603347")
   *           .setIfSourceGenerationMatch(-1427877280)
   *           .setIfSourceGenerationNotMatch(1575612532)
   *           .setIfSourceMetagenerationMatch(1143319909)
   *           .setIfSourceMetagenerationNotMatch(1900822777)
   *           .setIfGenerationMatch(-1086241088)
   *           .setIfGenerationNotMatch(1475720404)
   *           .setIfMetagenerationMatch(1043427781)
   *           .setIfMetagenerationNotMatch(1025430873)
   *           .build();
   *   ApiFuture<Object> future = storageClient.moveObjectCallable().futureCall(request);
   *   // Do something.
   *   Object response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MoveObjectRequest, Object> moveObjectCallable() {
    return stub.moveObjectCallable();
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
}

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

package com.google.cloud.logging.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.logging.v2.stub.ConfigServiceV2Stub;
import com.google.cloud.logging.v2.stub.ConfigServiceV2StubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.logging.v2.BillingAccountLocationName;
import com.google.logging.v2.BillingAccountName;
import com.google.logging.v2.BucketMetadata;
import com.google.logging.v2.CmekSettings;
import com.google.logging.v2.CopyLogEntriesMetadata;
import com.google.logging.v2.CopyLogEntriesRequest;
import com.google.logging.v2.CopyLogEntriesResponse;
import com.google.logging.v2.CreateBucketRequest;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateLinkRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.CreateViewRequest;
import com.google.logging.v2.DeleteBucketRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteLinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.DeleteViewRequest;
import com.google.logging.v2.FolderLocationName;
import com.google.logging.v2.FolderName;
import com.google.logging.v2.GetBucketRequest;
import com.google.logging.v2.GetCmekSettingsRequest;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetLinkRequest;
import com.google.logging.v2.GetSettingsRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.GetViewRequest;
import com.google.logging.v2.Link;
import com.google.logging.v2.LinkMetadata;
import com.google.logging.v2.LinkName;
import com.google.logging.v2.ListBucketsRequest;
import com.google.logging.v2.ListBucketsResponse;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListLinksRequest;
import com.google.logging.v2.ListLinksResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.ListViewsRequest;
import com.google.logging.v2.ListViewsResponse;
import com.google.logging.v2.LocationName;
import com.google.logging.v2.LogBucket;
import com.google.logging.v2.LogBucketName;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogExclusionName;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.LogSinkName;
import com.google.logging.v2.LogView;
import com.google.logging.v2.OrganizationLocationName;
import com.google.logging.v2.OrganizationName;
import com.google.logging.v2.ProjectName;
import com.google.logging.v2.Settings;
import com.google.logging.v2.SettingsName;
import com.google.logging.v2.UndeleteBucketRequest;
import com.google.logging.v2.UpdateBucketRequest;
import com.google.logging.v2.UpdateCmekSettingsRequest;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateSettingsRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.logging.v2.UpdateViewRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for configuring sinks used to route log entries.
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
 * try (ConfigClient configClient = ConfigClient.create()) {
 *   GetBucketRequest request =
 *       GetBucketRequest.newBuilder()
 *           .setName(
 *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
 *                   .toString())
 *           .build();
 *   LogBucket response = configClient.getBucket(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConfigClient object to clean up resources such as
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
 *      <td><p> ListBuckets</td>
 *      <td><p> Lists log buckets.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBuckets(ListBucketsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBuckets(BillingAccountLocationName parent)
 *           <li><p> listBuckets(FolderLocationName parent)
 *           <li><p> listBuckets(LocationName parent)
 *           <li><p> listBuckets(OrganizationLocationName parent)
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
 *      <td><p> GetBucket</td>
 *      <td><p> Gets a log bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBucket(GetBucketRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBucketCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBucketAsync</td>
 *      <td><p> Creates a log bucket asynchronously that can be used to store log entries.
 * <p>  After a bucket has been created, the bucket's location cannot be changed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBucketAsyncAsync(CreateBucketRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBucketAsyncOperationCallable()
 *           <li><p> createBucketAsyncCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBucketAsync</td>
 *      <td><p> Updates a log bucket asynchronously.
 * <p>  If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then `FAILED_PRECONDITION` will be returned.
 * <p>  After a bucket has been created, the bucket's location cannot be changed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBucketAsyncAsync(UpdateBucketRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBucketAsyncOperationCallable()
 *           <li><p> updateBucketAsyncCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBucket</td>
 *      <td><p> Creates a log bucket that can be used to store log entries. After a bucket has been created, the bucket's location cannot be changed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBucket(CreateBucketRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBucketCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBucket</td>
 *      <td><p> Updates a log bucket.
 * <p>  If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then `FAILED_PRECONDITION` will be returned.
 * <p>  After a bucket has been created, the bucket's location cannot be changed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBucket(UpdateBucketRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBucketCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBucket</td>
 *      <td><p> Deletes a log bucket.
 * <p>  Changes the bucket's `lifecycle_state` to the `DELETE_REQUESTED` state. After 7 days, the bucket will be purged and all log entries in the bucket will be permanently deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBucket(DeleteBucketRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBucketCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UndeleteBucket</td>
 *      <td><p> Undeletes a log bucket. A bucket that has been deleted can be undeleted within the grace period of 7 days.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> undeleteBucket(UndeleteBucketRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> undeleteBucketCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListViews</td>
 *      <td><p> Lists views on a log bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listViews(ListViewsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listViews(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listViewsPagedCallable()
 *           <li><p> listViewsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetView</td>
 *      <td><p> Gets a view on a log bucket..</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getView(GetViewRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateView</td>
 *      <td><p> Creates a view over log entries in a log bucket. A bucket may contain a maximum of 30 views.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createView(CreateViewRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateView</td>
 *      <td><p> Updates a view on a log bucket. This method replaces the following fields in the existing view with values from the new view: `filter`. If an `UNAVAILABLE` error is returned, this indicates that system is not in a state where it can update the view. If this occurs, please try again in a few minutes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateView(UpdateViewRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteView</td>
 *      <td><p> Deletes a view on a log bucket. If an `UNAVAILABLE` error is returned, this indicates that system is not in a state where it can delete the view. If this occurs, please try again in a few minutes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteView(DeleteViewRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSinks</td>
 *      <td><p> Lists sinks.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSinks(ListSinksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSinks(BillingAccountName parent)
 *           <li><p> listSinks(FolderName parent)
 *           <li><p> listSinks(OrganizationName parent)
 *           <li><p> listSinks(ProjectName parent)
 *           <li><p> listSinks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSinksPagedCallable()
 *           <li><p> listSinksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSink</td>
 *      <td><p> Gets a sink.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSink(GetSinkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSink(LogSinkName sinkName)
 *           <li><p> getSink(String sinkName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSink</td>
 *      <td><p> Creates a sink that exports specified log entries to a destination. The export of newly-ingested log entries begins immediately, unless the sink's `writer_identity` is not permitted to write to the destination. A sink can export log entries only from the resource owning the sink.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSink(CreateSinkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSink(BillingAccountName parent, LogSink sink)
 *           <li><p> createSink(FolderName parent, LogSink sink)
 *           <li><p> createSink(OrganizationName parent, LogSink sink)
 *           <li><p> createSink(ProjectName parent, LogSink sink)
 *           <li><p> createSink(String parent, LogSink sink)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSink</td>
 *      <td><p> Updates a sink. This method replaces the following fields in the existing sink with values from the new sink: `destination`, and `filter`.
 * <p>  The updated sink might also have a new `writer_identity`; see the `unique_writer_identity` field.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSink(UpdateSinkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSink(LogSinkName sinkName, LogSink sink)
 *           <li><p> updateSink(String sinkName, LogSink sink)
 *           <li><p> updateSink(LogSinkName sinkName, LogSink sink, FieldMask updateMask)
 *           <li><p> updateSink(String sinkName, LogSink sink, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSink</td>
 *      <td><p> Deletes a sink. If the sink has a unique `writer_identity`, then that service account is also deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSink(DeleteSinkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSink(LogSinkName sinkName)
 *           <li><p> deleteSink(String sinkName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateLink</td>
 *      <td><p> Asynchronously creates a linked dataset in BigQuery which makes it possible to use BigQuery to read the logs stored in the log bucket. A log bucket may currently only contain one link.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createLinkAsync(CreateLinkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createLinkAsync(LogBucketName parent, Link link, String linkId)
 *           <li><p> createLinkAsync(String parent, Link link, String linkId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createLinkOperationCallable()
 *           <li><p> createLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteLink</td>
 *      <td><p> Deletes a link. This will also delete the corresponding BigQuery linked dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteLinkAsync(DeleteLinkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteLinkAsync(LinkName name)
 *           <li><p> deleteLinkAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteLinkOperationCallable()
 *           <li><p> deleteLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLinks</td>
 *      <td><p> Lists links.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLinks(ListLinksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLinks(LogBucketName parent)
 *           <li><p> listLinks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLinksPagedCallable()
 *           <li><p> listLinksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLink</td>
 *      <td><p> Gets a link.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLink(GetLinkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLink(LinkName name)
 *           <li><p> getLink(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListExclusions</td>
 *      <td><p> Lists all the exclusions on the _Default sink in a parent resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listExclusions(ListExclusionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listExclusions(BillingAccountName parent)
 *           <li><p> listExclusions(FolderName parent)
 *           <li><p> listExclusions(OrganizationName parent)
 *           <li><p> listExclusions(ProjectName parent)
 *           <li><p> listExclusions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listExclusionsPagedCallable()
 *           <li><p> listExclusionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetExclusion</td>
 *      <td><p> Gets the description of an exclusion in the _Default sink.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getExclusion(GetExclusionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getExclusion(LogExclusionName name)
 *           <li><p> getExclusion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getExclusionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateExclusion</td>
 *      <td><p> Creates a new exclusion in the _Default sink in a specified parent resource. Only log entries belonging to that resource can be excluded. You can have up to 10 exclusions in a resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createExclusion(CreateExclusionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createExclusion(BillingAccountName parent, LogExclusion exclusion)
 *           <li><p> createExclusion(FolderName parent, LogExclusion exclusion)
 *           <li><p> createExclusion(OrganizationName parent, LogExclusion exclusion)
 *           <li><p> createExclusion(ProjectName parent, LogExclusion exclusion)
 *           <li><p> createExclusion(String parent, LogExclusion exclusion)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createExclusionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateExclusion</td>
 *      <td><p> Changes one or more properties of an existing exclusion in the _Default sink.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateExclusion(UpdateExclusionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateExclusion(LogExclusionName name, LogExclusion exclusion, FieldMask updateMask)
 *           <li><p> updateExclusion(String name, LogExclusion exclusion, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateExclusionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteExclusion</td>
 *      <td><p> Deletes an exclusion in the _Default sink.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteExclusion(DeleteExclusionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteExclusion(LogExclusionName name)
 *           <li><p> deleteExclusion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteExclusionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCmekSettings</td>
 *      <td><p> Gets the Logging CMEK settings for the given resource.
 * <p>  Note: CMEK for the Log Router can be configured for Google Cloud projects, folders, organizations and billing accounts. Once configured for an organization, it applies to all projects and folders in the Google Cloud organization.
 * <p>  See [Enabling CMEK for Log Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCmekSettings(GetCmekSettingsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCmekSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCmekSettings</td>
 *      <td><p> Updates the Log Router CMEK settings for the given resource.
 * <p>  Note: CMEK for the Log Router can currently only be configured for Google Cloud organizations. Once configured, it applies to all projects and folders in the Google Cloud organization.
 * <p>  [UpdateCmekSettings][google.logging.v2.ConfigServiceV2.UpdateCmekSettings] will fail if 1) `kms_key_name` is invalid, or 2) the associated service account does not have the required `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or 3) access to the key is disabled.
 * <p>  See [Enabling CMEK for Log Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCmekSettings(UpdateCmekSettingsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCmekSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSettings</td>
 *      <td><p> Gets the Log Router settings for the given resource.
 * <p>  Note: Settings for the Log Router can be get for Google Cloud projects, folders, organizations and billing accounts. Currently it can only be configured for organizations. Once configured for an organization, it applies to all projects and folders in the Google Cloud organization.
 * <p>  See [Enabling CMEK for Log Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSettings(GetSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSettings(SettingsName name)
 *           <li><p> getSettings(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSettings</td>
 *      <td><p> Updates the Log Router settings for the given resource.
 * <p>  Note: Settings for the Log Router can currently only be configured for Google Cloud organizations. Once configured, it applies to all projects and folders in the Google Cloud organization.
 * <p>  [UpdateSettings][google.logging.v2.ConfigServiceV2.UpdateSettings] will fail if 1) `kms_key_name` is invalid, or 2) the associated service account does not have the required `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or 3) access to the key is disabled. 4) `location_id` is not supported by Logging. 5) `location_id` violate OrgPolicy.
 * <p>  See [Enabling CMEK for Log Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSettings(UpdateSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSettings(Settings settings, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CopyLogEntries</td>
 *      <td><p> Copies a set of log entries from a log bucket to a Cloud Storage bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> copyLogEntriesAsync(CopyLogEntriesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> copyLogEntriesOperationCallable()
 *           <li><p> copyLogEntriesCallable()
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
 * <p>This class can be customized by passing in a custom instance of ConfigSettings to create().
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
 * ConfigSettings configSettings =
 *     ConfigSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConfigClient configClient = ConfigClient.create(configSettings);
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
 * ConfigSettings configSettings = ConfigSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConfigClient configClient = ConfigClient.create(configSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ConfigClient implements BackgroundResource {
  private final ConfigSettings settings;
  private final ConfigServiceV2Stub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ConfigClient with default settings. */
  public static final ConfigClient create() throws IOException {
    return create(ConfigSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConfigClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConfigClient create(ConfigSettings settings) throws IOException {
    return new ConfigClient(settings);
  }

  /**
   * Constructs an instance of ConfigClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ConfigSettings).
   */
  public static final ConfigClient create(ConfigServiceV2Stub stub) {
    return new ConfigClient(stub);
  }

  /**
   * Constructs an instance of ConfigClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ConfigClient(ConfigSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ConfigServiceV2StubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected ConfigClient(ConfigServiceV2Stub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ConfigSettings getSettings() {
    return settings;
  }

  public ConfigServiceV2Stub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists log buckets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   BillingAccountLocationName parent =
   *       BillingAccountLocationName.of("[BILLING_ACCOUNT]", "[LOCATION]");
   *   for (LogBucket element : configClient.listBuckets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose buckets are to be listed:
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]"
   *     "folders/[FOLDER_ID]/locations/[LOCATION_ID]"
   *     <p>Note: The locations portion of the resource must be specified, but supplying the
   *     character `-` in place of [LOCATION_ID] will return all buckets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBucketsPagedResponse listBuckets(BillingAccountLocationName parent) {
    ListBucketsRequest request =
        ListBucketsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBuckets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists log buckets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (LogBucket element : configClient.listBuckets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose buckets are to be listed:
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]"
   *     "folders/[FOLDER_ID]/locations/[LOCATION_ID]"
   *     <p>Note: The locations portion of the resource must be specified, but supplying the
   *     character `-` in place of [LOCATION_ID] will return all buckets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBucketsPagedResponse listBuckets(FolderLocationName parent) {
    ListBucketsRequest request =
        ListBucketsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBuckets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists log buckets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (LogBucket element : configClient.listBuckets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose buckets are to be listed:
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]"
   *     "folders/[FOLDER_ID]/locations/[LOCATION_ID]"
   *     <p>Note: The locations portion of the resource must be specified, but supplying the
   *     character `-` in place of [LOCATION_ID] will return all buckets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBucketsPagedResponse listBuckets(LocationName parent) {
    ListBucketsRequest request =
        ListBucketsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBuckets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists log buckets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (LogBucket element : configClient.listBuckets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose buckets are to be listed:
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]"
   *     "folders/[FOLDER_ID]/locations/[LOCATION_ID]"
   *     <p>Note: The locations portion of the resource must be specified, but supplying the
   *     character `-` in place of [LOCATION_ID] will return all buckets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBucketsPagedResponse listBuckets(OrganizationLocationName parent) {
    ListBucketsRequest request =
        ListBucketsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBuckets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists log buckets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (LogBucket element : configClient.listBuckets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose buckets are to be listed:
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]"
   *     "folders/[FOLDER_ID]/locations/[LOCATION_ID]"
   *     <p>Note: The locations portion of the resource must be specified, but supplying the
   *     character `-` in place of [LOCATION_ID] will return all buckets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBucketsPagedResponse listBuckets(String parent) {
    ListBucketsRequest request = ListBucketsRequest.newBuilder().setParent(parent).build();
    return listBuckets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists log buckets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListBucketsRequest request =
   *       ListBucketsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (LogBucket element : configClient.listBuckets(request).iterateAll()) {
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
   * Lists log buckets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListBucketsRequest request =
   *       ListBucketsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<LogBucket> future = configClient.listBucketsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LogBucket element : future.get().iterateAll()) {
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
   * Lists log buckets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListBucketsRequest request =
   *       ListBucketsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListBucketsResponse response = configClient.listBucketsCallable().call(request);
   *     for (LogBucket element : response.getBucketsList()) {
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
   * Gets a log bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetBucketRequest request =
   *       GetBucketRequest.newBuilder()
   *           .setName(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .build();
   *   LogBucket response = configClient.getBucket(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogBucket getBucket(GetBucketRequest request) {
    return getBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a log bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetBucketRequest request =
   *       GetBucketRequest.newBuilder()
   *           .setName(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<LogBucket> future = configClient.getBucketCallable().futureCall(request);
   *   // Do something.
   *   LogBucket response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBucketRequest, LogBucket> getBucketCallable() {
    return stub.getBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a log bucket asynchronously that can be used to store log entries.
   *
   * <p>After a bucket has been created, the bucket's location cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateBucketRequest request =
   *       CreateBucketRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBucketId("bucketId-1603305307")
   *           .setBucket(LogBucket.newBuilder().build())
   *           .build();
   *   LogBucket response = configClient.createBucketAsyncAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LogBucket, BucketMetadata> createBucketAsyncAsync(
      CreateBucketRequest request) {
    return createBucketAsyncOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a log bucket asynchronously that can be used to store log entries.
   *
   * <p>After a bucket has been created, the bucket's location cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateBucketRequest request =
   *       CreateBucketRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBucketId("bucketId-1603305307")
   *           .setBucket(LogBucket.newBuilder().build())
   *           .build();
   *   OperationFuture<LogBucket, BucketMetadata> future =
   *       configClient.createBucketAsyncOperationCallable().futureCall(request);
   *   // Do something.
   *   LogBucket response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBucketRequest, LogBucket, BucketMetadata>
      createBucketAsyncOperationCallable() {
    return stub.createBucketAsyncOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a log bucket asynchronously that can be used to store log entries.
   *
   * <p>After a bucket has been created, the bucket's location cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateBucketRequest request =
   *       CreateBucketRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBucketId("bucketId-1603305307")
   *           .setBucket(LogBucket.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = configClient.createBucketAsyncCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBucketRequest, Operation> createBucketAsyncCallable() {
    return stub.createBucketAsyncCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a log bucket asynchronously.
   *
   * <p>If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then `FAILED_PRECONDITION` will
   * be returned.
   *
   * <p>After a bucket has been created, the bucket's location cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateBucketRequest request =
   *       UpdateBucketRequest.newBuilder()
   *           .setName(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .setBucket(LogBucket.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   LogBucket response = configClient.updateBucketAsyncAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LogBucket, BucketMetadata> updateBucketAsyncAsync(
      UpdateBucketRequest request) {
    return updateBucketAsyncOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a log bucket asynchronously.
   *
   * <p>If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then `FAILED_PRECONDITION` will
   * be returned.
   *
   * <p>After a bucket has been created, the bucket's location cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateBucketRequest request =
   *       UpdateBucketRequest.newBuilder()
   *           .setName(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .setBucket(LogBucket.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<LogBucket, BucketMetadata> future =
   *       configClient.updateBucketAsyncOperationCallable().futureCall(request);
   *   // Do something.
   *   LogBucket response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBucketRequest, LogBucket, BucketMetadata>
      updateBucketAsyncOperationCallable() {
    return stub.updateBucketAsyncOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a log bucket asynchronously.
   *
   * <p>If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then `FAILED_PRECONDITION` will
   * be returned.
   *
   * <p>After a bucket has been created, the bucket's location cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateBucketRequest request =
   *       UpdateBucketRequest.newBuilder()
   *           .setName(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .setBucket(LogBucket.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = configClient.updateBucketAsyncCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBucketRequest, Operation> updateBucketAsyncCallable() {
    return stub.updateBucketAsyncCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a log bucket that can be used to store log entries. After a bucket has been created,
   * the bucket's location cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateBucketRequest request =
   *       CreateBucketRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBucketId("bucketId-1603305307")
   *           .setBucket(LogBucket.newBuilder().build())
   *           .build();
   *   LogBucket response = configClient.createBucket(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogBucket createBucket(CreateBucketRequest request) {
    return createBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a log bucket that can be used to store log entries. After a bucket has been created,
   * the bucket's location cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateBucketRequest request =
   *       CreateBucketRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBucketId("bucketId-1603305307")
   *           .setBucket(LogBucket.newBuilder().build())
   *           .build();
   *   ApiFuture<LogBucket> future = configClient.createBucketCallable().futureCall(request);
   *   // Do something.
   *   LogBucket response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBucketRequest, LogBucket> createBucketCallable() {
    return stub.createBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a log bucket.
   *
   * <p>If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then `FAILED_PRECONDITION` will
   * be returned.
   *
   * <p>After a bucket has been created, the bucket's location cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateBucketRequest request =
   *       UpdateBucketRequest.newBuilder()
   *           .setName(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .setBucket(LogBucket.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   LogBucket response = configClient.updateBucket(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogBucket updateBucket(UpdateBucketRequest request) {
    return updateBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a log bucket.
   *
   * <p>If the bucket has a `lifecycle_state` of `DELETE_REQUESTED`, then `FAILED_PRECONDITION` will
   * be returned.
   *
   * <p>After a bucket has been created, the bucket's location cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateBucketRequest request =
   *       UpdateBucketRequest.newBuilder()
   *           .setName(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .setBucket(LogBucket.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<LogBucket> future = configClient.updateBucketCallable().futureCall(request);
   *   // Do something.
   *   LogBucket response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBucketRequest, LogBucket> updateBucketCallable() {
    return stub.updateBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a log bucket.
   *
   * <p>Changes the bucket's `lifecycle_state` to the `DELETE_REQUESTED` state. After 7 days, the
   * bucket will be purged and all log entries in the bucket will be permanently deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteBucketRequest request =
   *       DeleteBucketRequest.newBuilder()
   *           .setName(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .build();
   *   configClient.deleteBucket(request);
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
   * Deletes a log bucket.
   *
   * <p>Changes the bucket's `lifecycle_state` to the `DELETE_REQUESTED` state. After 7 days, the
   * bucket will be purged and all log entries in the bucket will be permanently deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteBucketRequest request =
   *       DeleteBucketRequest.newBuilder()
   *           .setName(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = configClient.deleteBucketCallable().futureCall(request);
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
   * Undeletes a log bucket. A bucket that has been deleted can be undeleted within the grace period
   * of 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UndeleteBucketRequest request =
   *       UndeleteBucketRequest.newBuilder()
   *           .setName(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .build();
   *   configClient.undeleteBucket(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void undeleteBucket(UndeleteBucketRequest request) {
    undeleteBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a log bucket. A bucket that has been deleted can be undeleted within the grace period
   * of 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UndeleteBucketRequest request =
   *       UndeleteBucketRequest.newBuilder()
   *           .setName(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = configClient.undeleteBucketCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteBucketRequest, Empty> undeleteBucketCallable() {
    return stub.undeleteBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views on a log bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = "parent-995424086";
   *   for (LogView element : configClient.listViews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The bucket whose views are to be listed:
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViewsPagedResponse listViews(String parent) {
    ListViewsRequest request = ListViewsRequest.newBuilder().setParent(parent).build();
    return listViews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views on a log bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListViewsRequest request =
   *       ListViewsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (LogView element : configClient.listViews(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViewsPagedResponse listViews(ListViewsRequest request) {
    return listViewsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views on a log bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListViewsRequest request =
   *       ListViewsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<LogView> future = configClient.listViewsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LogView element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable() {
    return stub.listViewsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views on a log bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListViewsRequest request =
   *       ListViewsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListViewsResponse response = configClient.listViewsCallable().call(request);
   *     for (LogView element : response.getViewsList()) {
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
  public final UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable() {
    return stub.listViewsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a view on a log bucket..
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetViewRequest request =
   *       GetViewRequest.newBuilder()
   *           .setName(
   *               LogViewName.ofProjectLocationBucketViewName(
   *                       "[PROJECT]", "[LOCATION]", "[BUCKET]", "[VIEW]")
   *                   .toString())
   *           .build();
   *   LogView response = configClient.getView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogView getView(GetViewRequest request) {
    return getViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a view on a log bucket..
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetViewRequest request =
   *       GetViewRequest.newBuilder()
   *           .setName(
   *               LogViewName.ofProjectLocationBucketViewName(
   *                       "[PROJECT]", "[LOCATION]", "[BUCKET]", "[VIEW]")
   *                   .toString())
   *           .build();
   *   ApiFuture<LogView> future = configClient.getViewCallable().futureCall(request);
   *   // Do something.
   *   LogView response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetViewRequest, LogView> getViewCallable() {
    return stub.getViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a view over log entries in a log bucket. A bucket may contain a maximum of 30 views.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateViewRequest request =
   *       CreateViewRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setViewId("viewId-816632160")
   *           .setView(LogView.newBuilder().build())
   *           .build();
   *   LogView response = configClient.createView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogView createView(CreateViewRequest request) {
    return createViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a view over log entries in a log bucket. A bucket may contain a maximum of 30 views.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateViewRequest request =
   *       CreateViewRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setViewId("viewId-816632160")
   *           .setView(LogView.newBuilder().build())
   *           .build();
   *   ApiFuture<LogView> future = configClient.createViewCallable().futureCall(request);
   *   // Do something.
   *   LogView response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateViewRequest, LogView> createViewCallable() {
    return stub.createViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a view on a log bucket. This method replaces the following fields in the existing view
   * with values from the new view: `filter`. If an `UNAVAILABLE` error is returned, this indicates
   * that system is not in a state where it can update the view. If this occurs, please try again in
   * a few minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateViewRequest request =
   *       UpdateViewRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(LogView.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   LogView response = configClient.updateView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogView updateView(UpdateViewRequest request) {
    return updateViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a view on a log bucket. This method replaces the following fields in the existing view
   * with values from the new view: `filter`. If an `UNAVAILABLE` error is returned, this indicates
   * that system is not in a state where it can update the view. If this occurs, please try again in
   * a few minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateViewRequest request =
   *       UpdateViewRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(LogView.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<LogView> future = configClient.updateViewCallable().futureCall(request);
   *   // Do something.
   *   LogView response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateViewRequest, LogView> updateViewCallable() {
    return stub.updateViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a view on a log bucket. If an `UNAVAILABLE` error is returned, this indicates that
   * system is not in a state where it can delete the view. If this occurs, please try again in a
   * few minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteViewRequest request =
   *       DeleteViewRequest.newBuilder()
   *           .setName(
   *               LogViewName.ofProjectLocationBucketViewName(
   *                       "[PROJECT]", "[LOCATION]", "[BUCKET]", "[VIEW]")
   *                   .toString())
   *           .build();
   *   configClient.deleteView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteView(DeleteViewRequest request) {
    deleteViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a view on a log bucket. If an `UNAVAILABLE` error is returned, this indicates that
   * system is not in a state where it can delete the view. If this occurs, please try again in a
   * few minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteViewRequest request =
   *       DeleteViewRequest.newBuilder()
   *           .setName(
   *               LogViewName.ofProjectLocationBucketViewName(
   *                       "[PROJECT]", "[LOCATION]", "[BUCKET]", "[VIEW]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = configClient.deleteViewCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteViewRequest, Empty> deleteViewCallable() {
    return stub.deleteViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sinks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
   *   for (LogSink element : configClient.listSinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose sinks are to be listed:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSinksPagedResponse listSinks(BillingAccountName parent) {
    ListSinksRequest request =
        ListSinksRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sinks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   for (LogSink element : configClient.listSinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose sinks are to be listed:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSinksPagedResponse listSinks(FolderName parent) {
    ListSinksRequest request =
        ListSinksRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sinks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (LogSink element : configClient.listSinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose sinks are to be listed:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSinksPagedResponse listSinks(OrganizationName parent) {
    ListSinksRequest request =
        ListSinksRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sinks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (LogSink element : configClient.listSinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose sinks are to be listed:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSinksPagedResponse listSinks(ProjectName parent) {
    ListSinksRequest request =
        ListSinksRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sinks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (LogSink element : configClient.listSinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose sinks are to be listed:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSinksPagedResponse listSinks(String parent) {
    ListSinksRequest request = ListSinksRequest.newBuilder().setParent(parent).build();
    return listSinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sinks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListSinksRequest request =
   *       ListSinksRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (LogSink element : configClient.listSinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSinksPagedResponse listSinks(ListSinksRequest request) {
    return listSinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sinks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListSinksRequest request =
   *       ListSinksRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<LogSink> future = configClient.listSinksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LogSink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSinksRequest, ListSinksPagedResponse> listSinksPagedCallable() {
    return stub.listSinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sinks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListSinksRequest request =
   *       ListSinksRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListSinksResponse response = configClient.listSinksCallable().call(request);
   *     for (LogSink element : response.getSinksList()) {
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
  public final UnaryCallable<ListSinksRequest, ListSinksResponse> listSinksCallable() {
    return stub.listSinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
   *   LogSink response = configClient.getSink(sinkName);
   * }
   * }</pre>
   *
   * @param sinkName Required. The resource name of the sink:
   *     <p>"projects/[PROJECT_ID]/sinks/[SINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/sinks/[SINK_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/sinks/[SINK_ID]"
   *     "folders/[FOLDER_ID]/sinks/[SINK_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/sinks/my-sink"`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink getSink(LogSinkName sinkName) {
    GetSinkRequest request =
        GetSinkRequest.newBuilder()
            .setSinkName(sinkName == null ? null : sinkName.toString())
            .build();
    return getSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString();
   *   LogSink response = configClient.getSink(sinkName);
   * }
   * }</pre>
   *
   * @param sinkName Required. The resource name of the sink:
   *     <p>"projects/[PROJECT_ID]/sinks/[SINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/sinks/[SINK_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/sinks/[SINK_ID]"
   *     "folders/[FOLDER_ID]/sinks/[SINK_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/sinks/my-sink"`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink getSink(String sinkName) {
    GetSinkRequest request = GetSinkRequest.newBuilder().setSinkName(sinkName).build();
    return getSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetSinkRequest request =
   *       GetSinkRequest.newBuilder()
   *           .setSinkName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
   *           .build();
   *   LogSink response = configClient.getSink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink getSink(GetSinkRequest request) {
    return getSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetSinkRequest request =
   *       GetSinkRequest.newBuilder()
   *           .setSinkName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
   *           .build();
   *   ApiFuture<LogSink> future = configClient.getSinkCallable().futureCall(request);
   *   // Do something.
   *   LogSink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSinkRequest, LogSink> getSinkCallable() {
    return stub.getSinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a sink that exports specified log entries to a destination. The export of
   * newly-ingested log entries begins immediately, unless the sink's `writer_identity` is not
   * permitted to write to the destination. A sink can export log entries only from the resource
   * owning the sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   LogSink response = configClient.createSink(parent, sink);
   * }
   * }</pre>
   *
   * @param parent Required. The resource in which to create the sink:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   *     <p>For examples:
   *     <p>`"projects/my-project"` `"organizations/123456789"`
   * @param sink Required. The new sink, whose `name` parameter is a sink identifier that is not
   *     already in use.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink createSink(BillingAccountName parent, LogSink sink) {
    CreateSinkRequest request =
        CreateSinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSink(sink)
            .build();
    return createSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a sink that exports specified log entries to a destination. The export of
   * newly-ingested log entries begins immediately, unless the sink's `writer_identity` is not
   * permitted to write to the destination. A sink can export log entries only from the resource
   * owning the sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   LogSink response = configClient.createSink(parent, sink);
   * }
   * }</pre>
   *
   * @param parent Required. The resource in which to create the sink:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   *     <p>For examples:
   *     <p>`"projects/my-project"` `"organizations/123456789"`
   * @param sink Required. The new sink, whose `name` parameter is a sink identifier that is not
   *     already in use.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink createSink(FolderName parent, LogSink sink) {
    CreateSinkRequest request =
        CreateSinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSink(sink)
            .build();
    return createSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a sink that exports specified log entries to a destination. The export of
   * newly-ingested log entries begins immediately, unless the sink's `writer_identity` is not
   * permitted to write to the destination. A sink can export log entries only from the resource
   * owning the sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   LogSink response = configClient.createSink(parent, sink);
   * }
   * }</pre>
   *
   * @param parent Required. The resource in which to create the sink:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   *     <p>For examples:
   *     <p>`"projects/my-project"` `"organizations/123456789"`
   * @param sink Required. The new sink, whose `name` parameter is a sink identifier that is not
   *     already in use.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink createSink(OrganizationName parent, LogSink sink) {
    CreateSinkRequest request =
        CreateSinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSink(sink)
            .build();
    return createSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a sink that exports specified log entries to a destination. The export of
   * newly-ingested log entries begins immediately, unless the sink's `writer_identity` is not
   * permitted to write to the destination. A sink can export log entries only from the resource
   * owning the sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   LogSink response = configClient.createSink(parent, sink);
   * }
   * }</pre>
   *
   * @param parent Required. The resource in which to create the sink:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   *     <p>For examples:
   *     <p>`"projects/my-project"` `"organizations/123456789"`
   * @param sink Required. The new sink, whose `name` parameter is a sink identifier that is not
   *     already in use.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink createSink(ProjectName parent, LogSink sink) {
    CreateSinkRequest request =
        CreateSinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSink(sink)
            .build();
    return createSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a sink that exports specified log entries to a destination. The export of
   * newly-ingested log entries begins immediately, unless the sink's `writer_identity` is not
   * permitted to write to the destination. A sink can export log entries only from the resource
   * owning the sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   LogSink sink = LogSink.newBuilder().build();
   *   LogSink response = configClient.createSink(parent, sink);
   * }
   * }</pre>
   *
   * @param parent Required. The resource in which to create the sink:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   *     <p>For examples:
   *     <p>`"projects/my-project"` `"organizations/123456789"`
   * @param sink Required. The new sink, whose `name` parameter is a sink identifier that is not
   *     already in use.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink createSink(String parent, LogSink sink) {
    CreateSinkRequest request =
        CreateSinkRequest.newBuilder().setParent(parent).setSink(sink).build();
    return createSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a sink that exports specified log entries to a destination. The export of
   * newly-ingested log entries begins immediately, unless the sink's `writer_identity` is not
   * permitted to write to the destination. A sink can export log entries only from the resource
   * owning the sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateSinkRequest request =
   *       CreateSinkRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSink(LogSink.newBuilder().build())
   *           .setUniqueWriterIdentity(true)
   *           .build();
   *   LogSink response = configClient.createSink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink createSink(CreateSinkRequest request) {
    return createSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a sink that exports specified log entries to a destination. The export of
   * newly-ingested log entries begins immediately, unless the sink's `writer_identity` is not
   * permitted to write to the destination. A sink can export log entries only from the resource
   * owning the sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateSinkRequest request =
   *       CreateSinkRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSink(LogSink.newBuilder().build())
   *           .setUniqueWriterIdentity(true)
   *           .build();
   *   ApiFuture<LogSink> future = configClient.createSinkCallable().futureCall(request);
   *   // Do something.
   *   LogSink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSinkRequest, LogSink> createSinkCallable() {
    return stub.createSinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a sink. This method replaces the following fields in the existing sink with values from
   * the new sink: `destination`, and `filter`.
   *
   * <p>The updated sink might also have a new `writer_identity`; see the `unique_writer_identity`
   * field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   LogSink response = configClient.updateSink(sinkName, sink);
   * }
   * }</pre>
   *
   * @param sinkName Required. The full resource name of the sink to update, including the parent
   *     resource and the sink identifier:
   *     <p>"projects/[PROJECT_ID]/sinks/[SINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/sinks/[SINK_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/sinks/[SINK_ID]"
   *     "folders/[FOLDER_ID]/sinks/[SINK_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/sinks/my-sink"`
   * @param sink Required. The updated sink, whose name is the same identifier that appears as part
   *     of `sink_name`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink updateSink(LogSinkName sinkName, LogSink sink) {
    UpdateSinkRequest request =
        UpdateSinkRequest.newBuilder()
            .setSinkName(sinkName == null ? null : sinkName.toString())
            .setSink(sink)
            .build();
    return updateSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a sink. This method replaces the following fields in the existing sink with values from
   * the new sink: `destination`, and `filter`.
   *
   * <p>The updated sink might also have a new `writer_identity`; see the `unique_writer_identity`
   * field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString();
   *   LogSink sink = LogSink.newBuilder().build();
   *   LogSink response = configClient.updateSink(sinkName, sink);
   * }
   * }</pre>
   *
   * @param sinkName Required. The full resource name of the sink to update, including the parent
   *     resource and the sink identifier:
   *     <p>"projects/[PROJECT_ID]/sinks/[SINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/sinks/[SINK_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/sinks/[SINK_ID]"
   *     "folders/[FOLDER_ID]/sinks/[SINK_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/sinks/my-sink"`
   * @param sink Required. The updated sink, whose name is the same identifier that appears as part
   *     of `sink_name`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink updateSink(String sinkName, LogSink sink) {
    UpdateSinkRequest request =
        UpdateSinkRequest.newBuilder().setSinkName(sinkName).setSink(sink).build();
    return updateSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a sink. This method replaces the following fields in the existing sink with values from
   * the new sink: `destination`, and `filter`.
   *
   * <p>The updated sink might also have a new `writer_identity`; see the `unique_writer_identity`
   * field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
   *   LogSink sink = LogSink.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LogSink response = configClient.updateSink(sinkName, sink, updateMask);
   * }
   * }</pre>
   *
   * @param sinkName Required. The full resource name of the sink to update, including the parent
   *     resource and the sink identifier:
   *     <p>"projects/[PROJECT_ID]/sinks/[SINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/sinks/[SINK_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/sinks/[SINK_ID]"
   *     "folders/[FOLDER_ID]/sinks/[SINK_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/sinks/my-sink"`
   * @param sink Required. The updated sink, whose name is the same identifier that appears as part
   *     of `sink_name`.
   * @param updateMask Optional. Field mask that specifies the fields in `sink` that need an update.
   *     A sink field will be overwritten if, and only if, it is in the update mask. `name` and
   *     output only fields cannot be updated.
   *     <p>An empty `updateMask` is temporarily treated as using the following mask for backwards
   *     compatibility purposes:
   *     <p>`destination,filter,includeChildren`
   *     <p>At some point in the future, behavior will be removed and specifying an empty
   *     `updateMask` will be an error.
   *     <p>For a detailed `FieldMask` definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#google.protobuf.FieldMask
   *     <p>For example: `updateMask=filter`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink updateSink(LogSinkName sinkName, LogSink sink, FieldMask updateMask) {
    UpdateSinkRequest request =
        UpdateSinkRequest.newBuilder()
            .setSinkName(sinkName == null ? null : sinkName.toString())
            .setSink(sink)
            .setUpdateMask(updateMask)
            .build();
    return updateSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a sink. This method replaces the following fields in the existing sink with values from
   * the new sink: `destination`, and `filter`.
   *
   * <p>The updated sink might also have a new `writer_identity`; see the `unique_writer_identity`
   * field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString();
   *   LogSink sink = LogSink.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LogSink response = configClient.updateSink(sinkName, sink, updateMask);
   * }
   * }</pre>
   *
   * @param sinkName Required. The full resource name of the sink to update, including the parent
   *     resource and the sink identifier:
   *     <p>"projects/[PROJECT_ID]/sinks/[SINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/sinks/[SINK_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/sinks/[SINK_ID]"
   *     "folders/[FOLDER_ID]/sinks/[SINK_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/sinks/my-sink"`
   * @param sink Required. The updated sink, whose name is the same identifier that appears as part
   *     of `sink_name`.
   * @param updateMask Optional. Field mask that specifies the fields in `sink` that need an update.
   *     A sink field will be overwritten if, and only if, it is in the update mask. `name` and
   *     output only fields cannot be updated.
   *     <p>An empty `updateMask` is temporarily treated as using the following mask for backwards
   *     compatibility purposes:
   *     <p>`destination,filter,includeChildren`
   *     <p>At some point in the future, behavior will be removed and specifying an empty
   *     `updateMask` will be an error.
   *     <p>For a detailed `FieldMask` definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#google.protobuf.FieldMask
   *     <p>For example: `updateMask=filter`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink updateSink(String sinkName, LogSink sink, FieldMask updateMask) {
    UpdateSinkRequest request =
        UpdateSinkRequest.newBuilder()
            .setSinkName(sinkName)
            .setSink(sink)
            .setUpdateMask(updateMask)
            .build();
    return updateSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a sink. This method replaces the following fields in the existing sink with values from
   * the new sink: `destination`, and `filter`.
   *
   * <p>The updated sink might also have a new `writer_identity`; see the `unique_writer_identity`
   * field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateSinkRequest request =
   *       UpdateSinkRequest.newBuilder()
   *           .setSinkName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
   *           .setSink(LogSink.newBuilder().build())
   *           .setUniqueWriterIdentity(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   LogSink response = configClient.updateSink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogSink updateSink(UpdateSinkRequest request) {
    return updateSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a sink. This method replaces the following fields in the existing sink with values from
   * the new sink: `destination`, and `filter`.
   *
   * <p>The updated sink might also have a new `writer_identity`; see the `unique_writer_identity`
   * field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateSinkRequest request =
   *       UpdateSinkRequest.newBuilder()
   *           .setSinkName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
   *           .setSink(LogSink.newBuilder().build())
   *           .setUniqueWriterIdentity(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<LogSink> future = configClient.updateSinkCallable().futureCall(request);
   *   // Do something.
   *   LogSink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSinkRequest, LogSink> updateSinkCallable() {
    return stub.updateSinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a sink. If the sink has a unique `writer_identity`, then that service account is also
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
   *   configClient.deleteSink(sinkName);
   * }
   * }</pre>
   *
   * @param sinkName Required. The full resource name of the sink to delete, including the parent
   *     resource and the sink identifier:
   *     <p>"projects/[PROJECT_ID]/sinks/[SINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/sinks/[SINK_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/sinks/[SINK_ID]"
   *     "folders/[FOLDER_ID]/sinks/[SINK_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/sinks/my-sink"`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSink(LogSinkName sinkName) {
    DeleteSinkRequest request =
        DeleteSinkRequest.newBuilder()
            .setSinkName(sinkName == null ? null : sinkName.toString())
            .build();
    deleteSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a sink. If the sink has a unique `writer_identity`, then that service account is also
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString();
   *   configClient.deleteSink(sinkName);
   * }
   * }</pre>
   *
   * @param sinkName Required. The full resource name of the sink to delete, including the parent
   *     resource and the sink identifier:
   *     <p>"projects/[PROJECT_ID]/sinks/[SINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/sinks/[SINK_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/sinks/[SINK_ID]"
   *     "folders/[FOLDER_ID]/sinks/[SINK_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/sinks/my-sink"`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSink(String sinkName) {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(sinkName).build();
    deleteSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a sink. If the sink has a unique `writer_identity`, then that service account is also
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteSinkRequest request =
   *       DeleteSinkRequest.newBuilder()
   *           .setSinkName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
   *           .build();
   *   configClient.deleteSink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSink(DeleteSinkRequest request) {
    deleteSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a sink. If the sink has a unique `writer_identity`, then that service account is also
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteSinkRequest request =
   *       DeleteSinkRequest.newBuilder()
   *           .setSinkName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
   *           .build();
   *   ApiFuture<Empty> future = configClient.deleteSinkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSinkRequest, Empty> deleteSinkCallable() {
    return stub.deleteSinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Asynchronously creates a linked dataset in BigQuery which makes it possible to use BigQuery to
   * read the logs stored in the log bucket. A log bucket may currently only contain one link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LogBucketName parent =
   *       LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]");
   *   Link link = Link.newBuilder().build();
   *   String linkId = "linkId-1102667083";
   *   Link response = configClient.createLinkAsync(parent, link, linkId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The full resource name of the bucket to create a link for.
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]"
   *     "folders/[FOLDER_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]"
   * @param link Required. The new link.
   * @param linkId Required. The ID to use for the link. The link_id can have up to 100 characters.
   *     A valid link_id must only have alphanumeric characters and underscores within it.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Link, LinkMetadata> createLinkAsync(
      LogBucketName parent, Link link, String linkId) {
    CreateLinkRequest request =
        CreateLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLink(link)
            .setLinkId(linkId)
            .build();
    return createLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Asynchronously creates a linked dataset in BigQuery which makes it possible to use BigQuery to
   * read the logs stored in the log bucket. A log bucket may currently only contain one link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent =
   *       LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *           .toString();
   *   Link link = Link.newBuilder().build();
   *   String linkId = "linkId-1102667083";
   *   Link response = configClient.createLinkAsync(parent, link, linkId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The full resource name of the bucket to create a link for.
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]"
   *     "folders/[FOLDER_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]"
   * @param link Required. The new link.
   * @param linkId Required. The ID to use for the link. The link_id can have up to 100 characters.
   *     A valid link_id must only have alphanumeric characters and underscores within it.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Link, LinkMetadata> createLinkAsync(
      String parent, Link link, String linkId) {
    CreateLinkRequest request =
        CreateLinkRequest.newBuilder().setParent(parent).setLink(link).setLinkId(linkId).build();
    return createLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Asynchronously creates a linked dataset in BigQuery which makes it possible to use BigQuery to
   * read the logs stored in the log bucket. A log bucket may currently only contain one link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateLinkRequest request =
   *       CreateLinkRequest.newBuilder()
   *           .setParent(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .setLink(Link.newBuilder().build())
   *           .setLinkId("linkId-1102667083")
   *           .build();
   *   Link response = configClient.createLinkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Link, LinkMetadata> createLinkAsync(CreateLinkRequest request) {
    return createLinkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Asynchronously creates a linked dataset in BigQuery which makes it possible to use BigQuery to
   * read the logs stored in the log bucket. A log bucket may currently only contain one link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateLinkRequest request =
   *       CreateLinkRequest.newBuilder()
   *           .setParent(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .setLink(Link.newBuilder().build())
   *           .setLinkId("linkId-1102667083")
   *           .build();
   *   OperationFuture<Link, LinkMetadata> future =
   *       configClient.createLinkOperationCallable().futureCall(request);
   *   // Do something.
   *   Link response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateLinkRequest, Link, LinkMetadata>
      createLinkOperationCallable() {
    return stub.createLinkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Asynchronously creates a linked dataset in BigQuery which makes it possible to use BigQuery to
   * read the logs stored in the log bucket. A log bucket may currently only contain one link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateLinkRequest request =
   *       CreateLinkRequest.newBuilder()
   *           .setParent(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .setLink(Link.newBuilder().build())
   *           .setLinkId("linkId-1102667083")
   *           .build();
   *   ApiFuture<Operation> future = configClient.createLinkCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLinkRequest, Operation> createLinkCallable() {
    return stub.createLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a link. This will also delete the corresponding BigQuery linked dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LinkName name =
   *       LinkName.ofProjectLocationBucketLinkName("[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]");
   *   configClient.deleteLinkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the link to delete.
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   *     "folders/[FOLDER_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, LinkMetadata> deleteLinkAsync(LinkName name) {
    DeleteLinkRequest request =
        DeleteLinkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a link. This will also delete the corresponding BigQuery linked dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name =
   *       LinkName.ofProjectLocationBucketLinkName("[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]")
   *           .toString();
   *   configClient.deleteLinkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the link to delete.
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   *     "folders/[FOLDER_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, LinkMetadata> deleteLinkAsync(String name) {
    DeleteLinkRequest request = DeleteLinkRequest.newBuilder().setName(name).build();
    return deleteLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a link. This will also delete the corresponding BigQuery linked dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteLinkRequest request =
   *       DeleteLinkRequest.newBuilder()
   *           .setName(
   *               LinkName.ofProjectLocationBucketLinkName(
   *                       "[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]")
   *                   .toString())
   *           .build();
   *   configClient.deleteLinkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, LinkMetadata> deleteLinkAsync(DeleteLinkRequest request) {
    return deleteLinkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a link. This will also delete the corresponding BigQuery linked dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteLinkRequest request =
   *       DeleteLinkRequest.newBuilder()
   *           .setName(
   *               LinkName.ofProjectLocationBucketLinkName(
   *                       "[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, LinkMetadata> future =
   *       configClient.deleteLinkOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteLinkRequest, Empty, LinkMetadata>
      deleteLinkOperationCallable() {
    return stub.deleteLinkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a link. This will also delete the corresponding BigQuery linked dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteLinkRequest request =
   *       DeleteLinkRequest.newBuilder()
   *           .setName(
   *               LinkName.ofProjectLocationBucketLinkName(
   *                       "[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = configClient.deleteLinkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteLinkRequest, Operation> deleteLinkCallable() {
    return stub.deleteLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists links.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LogBucketName parent =
   *       LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]");
   *   for (Link element : configClient.listLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose links are to be listed:
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/"
   *     "folders/[FOLDER_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinksPagedResponse listLinks(LogBucketName parent) {
    ListLinksRequest request =
        ListLinksRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists links.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent =
   *       LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *           .toString();
   *   for (Link element : configClient.listLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose links are to be listed:
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/"
   *     "folders/[FOLDER_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinksPagedResponse listLinks(String parent) {
    ListLinksRequest request = ListLinksRequest.newBuilder().setParent(parent).build();
    return listLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists links.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListLinksRequest request =
   *       ListLinksRequest.newBuilder()
   *           .setParent(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (Link element : configClient.listLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinksPagedResponse listLinks(ListLinksRequest request) {
    return listLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists links.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListLinksRequest request =
   *       ListLinksRequest.newBuilder()
   *           .setParent(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<Link> future = configClient.listLinksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Link element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLinksRequest, ListLinksPagedResponse> listLinksPagedCallable() {
    return stub.listLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists links.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListLinksRequest request =
   *       ListLinksRequest.newBuilder()
   *           .setParent(
   *               LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
   *                   .toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListLinksResponse response = configClient.listLinksCallable().call(request);
   *     for (Link element : response.getLinksList()) {
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
  public final UnaryCallable<ListLinksRequest, ListLinksResponse> listLinksCallable() {
    return stub.listLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LinkName name =
   *       LinkName.ofProjectLocationBucketLinkName("[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]");
   *   Link response = configClient.getLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the link:
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   *     "folders/[FOLDER_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Link getLink(LinkName name) {
    GetLinkRequest request =
        GetLinkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name =
   *       LinkName.ofProjectLocationBucketLinkName("[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]")
   *           .toString();
   *   Link response = configClient.getLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the link:
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]"
   *     "folders/[FOLDER_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/links/[LINK_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Link getLink(String name) {
    GetLinkRequest request = GetLinkRequest.newBuilder().setName(name).build();
    return getLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetLinkRequest request =
   *       GetLinkRequest.newBuilder()
   *           .setName(
   *               LinkName.ofProjectLocationBucketLinkName(
   *                       "[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]")
   *                   .toString())
   *           .build();
   *   Link response = configClient.getLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Link getLink(GetLinkRequest request) {
    return getLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetLinkRequest request =
   *       GetLinkRequest.newBuilder()
   *           .setName(
   *               LinkName.ofProjectLocationBucketLinkName(
   *                       "[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Link> future = configClient.getLinkCallable().futureCall(request);
   *   // Do something.
   *   Link response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLinkRequest, Link> getLinkCallable() {
    return stub.getLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the exclusions on the _Default sink in a parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
   *   for (LogExclusion element : configClient.listExclusions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose exclusions are to be listed.
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExclusionsPagedResponse listExclusions(BillingAccountName parent) {
    ListExclusionsRequest request =
        ListExclusionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExclusions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the exclusions on the _Default sink in a parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   for (LogExclusion element : configClient.listExclusions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose exclusions are to be listed.
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExclusionsPagedResponse listExclusions(FolderName parent) {
    ListExclusionsRequest request =
        ListExclusionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExclusions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the exclusions on the _Default sink in a parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (LogExclusion element : configClient.listExclusions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose exclusions are to be listed.
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExclusionsPagedResponse listExclusions(OrganizationName parent) {
    ListExclusionsRequest request =
        ListExclusionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExclusions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the exclusions on the _Default sink in a parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (LogExclusion element : configClient.listExclusions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose exclusions are to be listed.
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExclusionsPagedResponse listExclusions(ProjectName parent) {
    ListExclusionsRequest request =
        ListExclusionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExclusions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the exclusions on the _Default sink in a parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (LogExclusion element : configClient.listExclusions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource whose exclusions are to be listed.
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExclusionsPagedResponse listExclusions(String parent) {
    ListExclusionsRequest request = ListExclusionsRequest.newBuilder().setParent(parent).build();
    return listExclusions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the exclusions on the _Default sink in a parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListExclusionsRequest request =
   *       ListExclusionsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (LogExclusion element : configClient.listExclusions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExclusionsPagedResponse listExclusions(ListExclusionsRequest request) {
    return listExclusionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the exclusions on the _Default sink in a parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListExclusionsRequest request =
   *       ListExclusionsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<LogExclusion> future =
   *       configClient.listExclusionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LogExclusion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExclusionsRequest, ListExclusionsPagedResponse>
      listExclusionsPagedCallable() {
    return stub.listExclusionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the exclusions on the _Default sink in a parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListExclusionsRequest request =
   *       ListExclusionsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListExclusionsResponse response = configClient.listExclusionsCallable().call(request);
   *     for (LogExclusion element : response.getExclusionsList()) {
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
  public final UnaryCallable<ListExclusionsRequest, ListExclusionsResponse>
      listExclusionsCallable() {
    return stub.listExclusionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the description of an exclusion in the _Default sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
   *   LogExclusion response = configClient.getExclusion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of an existing exclusion:
   *     <p>"projects/[PROJECT_ID]/exclusions/[EXCLUSION_ID]"
   *     "organizations/[ORGANIZATION_ID]/exclusions/[EXCLUSION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/exclusions/[EXCLUSION_ID]"
   *     "folders/[FOLDER_ID]/exclusions/[EXCLUSION_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/exclusions/my-exclusion"`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogExclusion getExclusion(LogExclusionName name) {
    GetExclusionRequest request =
        GetExclusionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getExclusion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the description of an exclusion in the _Default sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString();
   *   LogExclusion response = configClient.getExclusion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of an existing exclusion:
   *     <p>"projects/[PROJECT_ID]/exclusions/[EXCLUSION_ID]"
   *     "organizations/[ORGANIZATION_ID]/exclusions/[EXCLUSION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/exclusions/[EXCLUSION_ID]"
   *     "folders/[FOLDER_ID]/exclusions/[EXCLUSION_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/exclusions/my-exclusion"`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogExclusion getExclusion(String name) {
    GetExclusionRequest request = GetExclusionRequest.newBuilder().setName(name).build();
    return getExclusion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the description of an exclusion in the _Default sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetExclusionRequest request =
   *       GetExclusionRequest.newBuilder()
   *           .setName(
   *               LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
   *           .build();
   *   LogExclusion response = configClient.getExclusion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogExclusion getExclusion(GetExclusionRequest request) {
    return getExclusionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the description of an exclusion in the _Default sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetExclusionRequest request =
   *       GetExclusionRequest.newBuilder()
   *           .setName(
   *               LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
   *           .build();
   *   ApiFuture<LogExclusion> future = configClient.getExclusionCallable().futureCall(request);
   *   // Do something.
   *   LogExclusion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExclusionRequest, LogExclusion> getExclusionCallable() {
    return stub.getExclusionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new exclusion in the _Default sink in a specified parent resource. Only log entries
   * belonging to that resource can be excluded. You can have up to 10 exclusions in a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
   *   LogExclusion exclusion = LogExclusion.newBuilder().build();
   *   LogExclusion response = configClient.createExclusion(parent, exclusion);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create the exclusion:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   *     <p>For examples:
   *     <p>`"projects/my-logging-project"` `"organizations/123456789"`
   * @param exclusion Required. The new exclusion, whose `name` parameter is an exclusion name that
   *     is not already used in the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogExclusion createExclusion(BillingAccountName parent, LogExclusion exclusion) {
    CreateExclusionRequest request =
        CreateExclusionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExclusion(exclusion)
            .build();
    return createExclusion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new exclusion in the _Default sink in a specified parent resource. Only log entries
   * belonging to that resource can be excluded. You can have up to 10 exclusions in a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   LogExclusion exclusion = LogExclusion.newBuilder().build();
   *   LogExclusion response = configClient.createExclusion(parent, exclusion);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create the exclusion:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   *     <p>For examples:
   *     <p>`"projects/my-logging-project"` `"organizations/123456789"`
   * @param exclusion Required. The new exclusion, whose `name` parameter is an exclusion name that
   *     is not already used in the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogExclusion createExclusion(FolderName parent, LogExclusion exclusion) {
    CreateExclusionRequest request =
        CreateExclusionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExclusion(exclusion)
            .build();
    return createExclusion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new exclusion in the _Default sink in a specified parent resource. Only log entries
   * belonging to that resource can be excluded. You can have up to 10 exclusions in a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   LogExclusion exclusion = LogExclusion.newBuilder().build();
   *   LogExclusion response = configClient.createExclusion(parent, exclusion);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create the exclusion:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   *     <p>For examples:
   *     <p>`"projects/my-logging-project"` `"organizations/123456789"`
   * @param exclusion Required. The new exclusion, whose `name` parameter is an exclusion name that
   *     is not already used in the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogExclusion createExclusion(OrganizationName parent, LogExclusion exclusion) {
    CreateExclusionRequest request =
        CreateExclusionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExclusion(exclusion)
            .build();
    return createExclusion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new exclusion in the _Default sink in a specified parent resource. Only log entries
   * belonging to that resource can be excluded. You can have up to 10 exclusions in a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   LogExclusion exclusion = LogExclusion.newBuilder().build();
   *   LogExclusion response = configClient.createExclusion(parent, exclusion);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create the exclusion:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   *     <p>For examples:
   *     <p>`"projects/my-logging-project"` `"organizations/123456789"`
   * @param exclusion Required. The new exclusion, whose `name` parameter is an exclusion name that
   *     is not already used in the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogExclusion createExclusion(ProjectName parent, LogExclusion exclusion) {
    CreateExclusionRequest request =
        CreateExclusionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExclusion(exclusion)
            .build();
    return createExclusion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new exclusion in the _Default sink in a specified parent resource. Only log entries
   * belonging to that resource can be excluded. You can have up to 10 exclusions in a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   LogExclusion exclusion = LogExclusion.newBuilder().build();
   *   LogExclusion response = configClient.createExclusion(parent, exclusion);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource in which to create the exclusion:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]" "folders/[FOLDER_ID]"
   *     <p>For examples:
   *     <p>`"projects/my-logging-project"` `"organizations/123456789"`
   * @param exclusion Required. The new exclusion, whose `name` parameter is an exclusion name that
   *     is not already used in the parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogExclusion createExclusion(String parent, LogExclusion exclusion) {
    CreateExclusionRequest request =
        CreateExclusionRequest.newBuilder().setParent(parent).setExclusion(exclusion).build();
    return createExclusion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new exclusion in the _Default sink in a specified parent resource. Only log entries
   * belonging to that resource can be excluded. You can have up to 10 exclusions in a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateExclusionRequest request =
   *       CreateExclusionRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setExclusion(LogExclusion.newBuilder().build())
   *           .build();
   *   LogExclusion response = configClient.createExclusion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogExclusion createExclusion(CreateExclusionRequest request) {
    return createExclusionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new exclusion in the _Default sink in a specified parent resource. Only log entries
   * belonging to that resource can be excluded. You can have up to 10 exclusions in a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateExclusionRequest request =
   *       CreateExclusionRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setExclusion(LogExclusion.newBuilder().build())
   *           .build();
   *   ApiFuture<LogExclusion> future = configClient.createExclusionCallable().futureCall(request);
   *   // Do something.
   *   LogExclusion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExclusionRequest, LogExclusion> createExclusionCallable() {
    return stub.createExclusionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes one or more properties of an existing exclusion in the _Default sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
   *   LogExclusion exclusion = LogExclusion.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LogExclusion response = configClient.updateExclusion(name, exclusion, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the exclusion to update:
   *     <p>"projects/[PROJECT_ID]/exclusions/[EXCLUSION_ID]"
   *     "organizations/[ORGANIZATION_ID]/exclusions/[EXCLUSION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/exclusions/[EXCLUSION_ID]"
   *     "folders/[FOLDER_ID]/exclusions/[EXCLUSION_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/exclusions/my-exclusion"`
   * @param exclusion Required. New values for the existing exclusion. Only the fields specified in
   *     `update_mask` are relevant.
   * @param updateMask Required. A non-empty list of fields to change in the existing exclusion. New
   *     values for the fields are taken from the corresponding fields in the
   *     [LogExclusion][google.logging.v2.LogExclusion] included in this request. Fields not
   *     mentioned in `update_mask` are not changed and are ignored in the request.
   *     <p>For example, to change the filter and description of an exclusion, specify an
   *     `update_mask` of `"filter,description"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogExclusion updateExclusion(
      LogExclusionName name, LogExclusion exclusion, FieldMask updateMask) {
    UpdateExclusionRequest request =
        UpdateExclusionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setExclusion(exclusion)
            .setUpdateMask(updateMask)
            .build();
    return updateExclusion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes one or more properties of an existing exclusion in the _Default sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString();
   *   LogExclusion exclusion = LogExclusion.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LogExclusion response = configClient.updateExclusion(name, exclusion, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the exclusion to update:
   *     <p>"projects/[PROJECT_ID]/exclusions/[EXCLUSION_ID]"
   *     "organizations/[ORGANIZATION_ID]/exclusions/[EXCLUSION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/exclusions/[EXCLUSION_ID]"
   *     "folders/[FOLDER_ID]/exclusions/[EXCLUSION_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/exclusions/my-exclusion"`
   * @param exclusion Required. New values for the existing exclusion. Only the fields specified in
   *     `update_mask` are relevant.
   * @param updateMask Required. A non-empty list of fields to change in the existing exclusion. New
   *     values for the fields are taken from the corresponding fields in the
   *     [LogExclusion][google.logging.v2.LogExclusion] included in this request. Fields not
   *     mentioned in `update_mask` are not changed and are ignored in the request.
   *     <p>For example, to change the filter and description of an exclusion, specify an
   *     `update_mask` of `"filter,description"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogExclusion updateExclusion(
      String name, LogExclusion exclusion, FieldMask updateMask) {
    UpdateExclusionRequest request =
        UpdateExclusionRequest.newBuilder()
            .setName(name)
            .setExclusion(exclusion)
            .setUpdateMask(updateMask)
            .build();
    return updateExclusion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes one or more properties of an existing exclusion in the _Default sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateExclusionRequest request =
   *       UpdateExclusionRequest.newBuilder()
   *           .setName(
   *               LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
   *           .setExclusion(LogExclusion.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   LogExclusion response = configClient.updateExclusion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LogExclusion updateExclusion(UpdateExclusionRequest request) {
    return updateExclusionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes one or more properties of an existing exclusion in the _Default sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateExclusionRequest request =
   *       UpdateExclusionRequest.newBuilder()
   *           .setName(
   *               LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
   *           .setExclusion(LogExclusion.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<LogExclusion> future = configClient.updateExclusionCallable().futureCall(request);
   *   // Do something.
   *   LogExclusion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExclusionRequest, LogExclusion> updateExclusionCallable() {
    return stub.updateExclusionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an exclusion in the _Default sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
   *   configClient.deleteExclusion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of an existing exclusion to delete:
   *     <p>"projects/[PROJECT_ID]/exclusions/[EXCLUSION_ID]"
   *     "organizations/[ORGANIZATION_ID]/exclusions/[EXCLUSION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/exclusions/[EXCLUSION_ID]"
   *     "folders/[FOLDER_ID]/exclusions/[EXCLUSION_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/exclusions/my-exclusion"`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExclusion(LogExclusionName name) {
    DeleteExclusionRequest request =
        DeleteExclusionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteExclusion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an exclusion in the _Default sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString();
   *   configClient.deleteExclusion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of an existing exclusion to delete:
   *     <p>"projects/[PROJECT_ID]/exclusions/[EXCLUSION_ID]"
   *     "organizations/[ORGANIZATION_ID]/exclusions/[EXCLUSION_ID]"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/exclusions/[EXCLUSION_ID]"
   *     "folders/[FOLDER_ID]/exclusions/[EXCLUSION_ID]"
   *     <p>For example:
   *     <p>`"projects/my-project/exclusions/my-exclusion"`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExclusion(String name) {
    DeleteExclusionRequest request = DeleteExclusionRequest.newBuilder().setName(name).build();
    deleteExclusion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an exclusion in the _Default sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteExclusionRequest request =
   *       DeleteExclusionRequest.newBuilder()
   *           .setName(
   *               LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
   *           .build();
   *   configClient.deleteExclusion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExclusion(DeleteExclusionRequest request) {
    deleteExclusionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an exclusion in the _Default sink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteExclusionRequest request =
   *       DeleteExclusionRequest.newBuilder()
   *           .setName(
   *               LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
   *           .build();
   *   ApiFuture<Empty> future = configClient.deleteExclusionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExclusionRequest, Empty> deleteExclusionCallable() {
    return stub.deleteExclusionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Logging CMEK settings for the given resource.
   *
   * <p>Note: CMEK for the Log Router can be configured for Google Cloud projects, folders,
   * organizations and billing accounts. Once configured for an organization, it applies to all
   * projects and folders in the Google Cloud organization.
   *
   * <p>See [Enabling CMEK for Log
   * Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetCmekSettingsRequest request =
   *       GetCmekSettingsRequest.newBuilder()
   *           .setName(CmekSettingsName.ofProjectName("[PROJECT]").toString())
   *           .build();
   *   CmekSettings response = configClient.getCmekSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CmekSettings getCmekSettings(GetCmekSettingsRequest request) {
    return getCmekSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Logging CMEK settings for the given resource.
   *
   * <p>Note: CMEK for the Log Router can be configured for Google Cloud projects, folders,
   * organizations and billing accounts. Once configured for an organization, it applies to all
   * projects and folders in the Google Cloud organization.
   *
   * <p>See [Enabling CMEK for Log
   * Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetCmekSettingsRequest request =
   *       GetCmekSettingsRequest.newBuilder()
   *           .setName(CmekSettingsName.ofProjectName("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<CmekSettings> future = configClient.getCmekSettingsCallable().futureCall(request);
   *   // Do something.
   *   CmekSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCmekSettingsRequest, CmekSettings> getCmekSettingsCallable() {
    return stub.getCmekSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Log Router CMEK settings for the given resource.
   *
   * <p>Note: CMEK for the Log Router can currently only be configured for Google Cloud
   * organizations. Once configured, it applies to all projects and folders in the Google Cloud
   * organization.
   *
   * <p>[UpdateCmekSettings][google.logging.v2.ConfigServiceV2.UpdateCmekSettings] will fail if 1)
   * `kms_key_name` is invalid, or 2) the associated service account does not have the required
   * `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or 3) access to the key
   * is disabled.
   *
   * <p>See [Enabling CMEK for Log
   * Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateCmekSettingsRequest request =
   *       UpdateCmekSettingsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setCmekSettings(CmekSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CmekSettings response = configClient.updateCmekSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CmekSettings updateCmekSettings(UpdateCmekSettingsRequest request) {
    return updateCmekSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Log Router CMEK settings for the given resource.
   *
   * <p>Note: CMEK for the Log Router can currently only be configured for Google Cloud
   * organizations. Once configured, it applies to all projects and folders in the Google Cloud
   * organization.
   *
   * <p>[UpdateCmekSettings][google.logging.v2.ConfigServiceV2.UpdateCmekSettings] will fail if 1)
   * `kms_key_name` is invalid, or 2) the associated service account does not have the required
   * `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or 3) access to the key
   * is disabled.
   *
   * <p>See [Enabling CMEK for Log
   * Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateCmekSettingsRequest request =
   *       UpdateCmekSettingsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setCmekSettings(CmekSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CmekSettings> future =
   *       configClient.updateCmekSettingsCallable().futureCall(request);
   *   // Do something.
   *   CmekSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCmekSettingsRequest, CmekSettings> updateCmekSettingsCallable() {
    return stub.updateCmekSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Log Router settings for the given resource.
   *
   * <p>Note: Settings for the Log Router can be get for Google Cloud projects, folders,
   * organizations and billing accounts. Currently it can only be configured for organizations. Once
   * configured for an organization, it applies to all projects and folders in the Google Cloud
   * organization.
   *
   * <p>See [Enabling CMEK for Log
   * Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   SettingsName name = SettingsName.ofProjectName("[PROJECT]");
   *   Settings response = configClient.getSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource for which to retrieve settings.
   *     <p>"projects/[PROJECT_ID]/settings" "organizations/[ORGANIZATION_ID]/settings"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/settings" "folders/[FOLDER_ID]/settings"
   *     <p>For example:
   *     <p>`"organizations/12345/settings"`
   *     <p>Note: Settings for the Log Router can be get for Google Cloud projects, folders,
   *     organizations and billing accounts. Currently it can only be configured for organizations.
   *     Once configured for an organization, it applies to all projects and folders in the Google
   *     Cloud organization.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(SettingsName name) {
    GetSettingsRequest request =
        GetSettingsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Log Router settings for the given resource.
   *
   * <p>Note: Settings for the Log Router can be get for Google Cloud projects, folders,
   * organizations and billing accounts. Currently it can only be configured for organizations. Once
   * configured for an organization, it applies to all projects and folders in the Google Cloud
   * organization.
   *
   * <p>See [Enabling CMEK for Log
   * Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = SettingsName.ofProjectName("[PROJECT]").toString();
   *   Settings response = configClient.getSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource for which to retrieve settings.
   *     <p>"projects/[PROJECT_ID]/settings" "organizations/[ORGANIZATION_ID]/settings"
   *     "billingAccounts/[BILLING_ACCOUNT_ID]/settings" "folders/[FOLDER_ID]/settings"
   *     <p>For example:
   *     <p>`"organizations/12345/settings"`
   *     <p>Note: Settings for the Log Router can be get for Google Cloud projects, folders,
   *     organizations and billing accounts. Currently it can only be configured for organizations.
   *     Once configured for an organization, it applies to all projects and folders in the Google
   *     Cloud organization.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(String name) {
    GetSettingsRequest request = GetSettingsRequest.newBuilder().setName(name).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Log Router settings for the given resource.
   *
   * <p>Note: Settings for the Log Router can be get for Google Cloud projects, folders,
   * organizations and billing accounts. Currently it can only be configured for organizations. Once
   * configured for an organization, it applies to all projects and folders in the Google Cloud
   * organization.
   *
   * <p>See [Enabling CMEK for Log
   * Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetSettingsRequest request =
   *       GetSettingsRequest.newBuilder()
   *           .setName(SettingsName.ofProjectName("[PROJECT]").toString())
   *           .build();
   *   Settings response = configClient.getSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(GetSettingsRequest request) {
    return getSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Log Router settings for the given resource.
   *
   * <p>Note: Settings for the Log Router can be get for Google Cloud projects, folders,
   * organizations and billing accounts. Currently it can only be configured for organizations. Once
   * configured for an organization, it applies to all projects and folders in the Google Cloud
   * organization.
   *
   * <p>See [Enabling CMEK for Log
   * Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetSettingsRequest request =
   *       GetSettingsRequest.newBuilder()
   *           .setName(SettingsName.ofProjectName("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<Settings> future = configClient.getSettingsCallable().futureCall(request);
   *   // Do something.
   *   Settings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return stub.getSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Log Router settings for the given resource.
   *
   * <p>Note: Settings for the Log Router can currently only be configured for Google Cloud
   * organizations. Once configured, it applies to all projects and folders in the Google Cloud
   * organization.
   *
   * <p>[UpdateSettings][google.logging.v2.ConfigServiceV2.UpdateSettings] will fail if 1)
   * `kms_key_name` is invalid, or 2) the associated service account does not have the required
   * `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or 3) access to the key
   * is disabled. 4) `location_id` is not supported by Logging. 5) `location_id` violate OrgPolicy.
   *
   * <p>See [Enabling CMEK for Log
   * Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   Settings settings = Settings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Settings response = configClient.updateSettings(settings, updateMask);
   * }
   * }</pre>
   *
   * @param settings Required. The settings to update.
   *     <p>See [Enabling CMEK for Log
   *     Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more
   *     information.
   * @param updateMask Optional. Field mask identifying which fields from `settings` should be
   *     updated. A field will be overwritten if and only if it is in the update mask. Output only
   *     fields cannot be updated.
   *     <p>See [FieldMask][google.protobuf.FieldMask] for more information.
   *     <p>For example: `"updateMask=kmsKeyName"`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings updateSettings(Settings settings, FieldMask updateMask) {
    UpdateSettingsRequest request =
        UpdateSettingsRequest.newBuilder().setSettings(settings).setUpdateMask(updateMask).build();
    return updateSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Log Router settings for the given resource.
   *
   * <p>Note: Settings for the Log Router can currently only be configured for Google Cloud
   * organizations. Once configured, it applies to all projects and folders in the Google Cloud
   * organization.
   *
   * <p>[UpdateSettings][google.logging.v2.ConfigServiceV2.UpdateSettings] will fail if 1)
   * `kms_key_name` is invalid, or 2) the associated service account does not have the required
   * `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or 3) access to the key
   * is disabled. 4) `location_id` is not supported by Logging. 5) `location_id` violate OrgPolicy.
   *
   * <p>See [Enabling CMEK for Log
   * Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setSettings(Settings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Settings response = configClient.updateSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings updateSettings(UpdateSettingsRequest request) {
    return updateSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Log Router settings for the given resource.
   *
   * <p>Note: Settings for the Log Router can currently only be configured for Google Cloud
   * organizations. Once configured, it applies to all projects and folders in the Google Cloud
   * organization.
   *
   * <p>[UpdateSettings][google.logging.v2.ConfigServiceV2.UpdateSettings] will fail if 1)
   * `kms_key_name` is invalid, or 2) the associated service account does not have the required
   * `roles/cloudkms.cryptoKeyEncrypterDecrypter` role assigned for the key, or 3) access to the key
   * is disabled. 4) `location_id` is not supported by Logging. 5) `location_id` violate OrgPolicy.
   *
   * <p>See [Enabling CMEK for Log
   * Router](https://cloud.google.com/logging/docs/routing/managed-encryption) for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setSettings(Settings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Settings> future = configClient.updateSettingsCallable().futureCall(request);
   *   // Do something.
   *   Settings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    return stub.updateSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies a set of log entries from a log bucket to a Cloud Storage bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CopyLogEntriesRequest request =
   *       CopyLogEntriesRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setDestination("destination-1429847026")
   *           .build();
   *   CopyLogEntriesResponse response = configClient.copyLogEntriesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CopyLogEntriesResponse, CopyLogEntriesMetadata> copyLogEntriesAsync(
      CopyLogEntriesRequest request) {
    return copyLogEntriesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies a set of log entries from a log bucket to a Cloud Storage bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CopyLogEntriesRequest request =
   *       CopyLogEntriesRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setDestination("destination-1429847026")
   *           .build();
   *   OperationFuture<CopyLogEntriesResponse, CopyLogEntriesMetadata> future =
   *       configClient.copyLogEntriesOperationCallable().futureCall(request);
   *   // Do something.
   *   CopyLogEntriesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CopyLogEntriesRequest, CopyLogEntriesResponse, CopyLogEntriesMetadata>
      copyLogEntriesOperationCallable() {
    return stub.copyLogEntriesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies a set of log entries from a log bucket to a Cloud Storage bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CopyLogEntriesRequest request =
   *       CopyLogEntriesRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setDestination("destination-1429847026")
   *           .build();
   *   ApiFuture<Operation> future = configClient.copyLogEntriesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CopyLogEntriesRequest, Operation> copyLogEntriesCallable() {
    return stub.copyLogEntriesCallable();
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
          LogBucket,
          ListBucketsPage,
          ListBucketsFixedSizeCollection> {

    public static ApiFuture<ListBucketsPagedResponse> createAsync(
        PageContext<ListBucketsRequest, ListBucketsResponse, LogBucket> context,
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
      extends AbstractPage<ListBucketsRequest, ListBucketsResponse, LogBucket, ListBucketsPage> {

    private ListBucketsPage(
        PageContext<ListBucketsRequest, ListBucketsResponse, LogBucket> context,
        ListBucketsResponse response) {
      super(context, response);
    }

    private static ListBucketsPage createEmptyPage() {
      return new ListBucketsPage(null, null);
    }

    @Override
    protected ListBucketsPage createPage(
        PageContext<ListBucketsRequest, ListBucketsResponse, LogBucket> context,
        ListBucketsResponse response) {
      return new ListBucketsPage(context, response);
    }

    @Override
    public ApiFuture<ListBucketsPage> createPageAsync(
        PageContext<ListBucketsRequest, ListBucketsResponse, LogBucket> context,
        ApiFuture<ListBucketsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBucketsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBucketsRequest,
          ListBucketsResponse,
          LogBucket,
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

  public static class ListViewsPagedResponse
      extends AbstractPagedListResponse<
          ListViewsRequest,
          ListViewsResponse,
          LogView,
          ListViewsPage,
          ListViewsFixedSizeCollection> {

    public static ApiFuture<ListViewsPagedResponse> createAsync(
        PageContext<ListViewsRequest, ListViewsResponse, LogView> context,
        ApiFuture<ListViewsResponse> futureResponse) {
      ApiFuture<ListViewsPage> futurePage =
          ListViewsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListViewsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListViewsPagedResponse(ListViewsPage page) {
      super(page, ListViewsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListViewsPage
      extends AbstractPage<ListViewsRequest, ListViewsResponse, LogView, ListViewsPage> {

    private ListViewsPage(
        PageContext<ListViewsRequest, ListViewsResponse, LogView> context,
        ListViewsResponse response) {
      super(context, response);
    }

    private static ListViewsPage createEmptyPage() {
      return new ListViewsPage(null, null);
    }

    @Override
    protected ListViewsPage createPage(
        PageContext<ListViewsRequest, ListViewsResponse, LogView> context,
        ListViewsResponse response) {
      return new ListViewsPage(context, response);
    }

    @Override
    public ApiFuture<ListViewsPage> createPageAsync(
        PageContext<ListViewsRequest, ListViewsResponse, LogView> context,
        ApiFuture<ListViewsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListViewsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListViewsRequest,
          ListViewsResponse,
          LogView,
          ListViewsPage,
          ListViewsFixedSizeCollection> {

    private ListViewsFixedSizeCollection(List<ListViewsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListViewsFixedSizeCollection createEmptyCollection() {
      return new ListViewsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListViewsFixedSizeCollection createCollection(
        List<ListViewsPage> pages, int collectionSize) {
      return new ListViewsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSinksPagedResponse
      extends AbstractPagedListResponse<
          ListSinksRequest,
          ListSinksResponse,
          LogSink,
          ListSinksPage,
          ListSinksFixedSizeCollection> {

    public static ApiFuture<ListSinksPagedResponse> createAsync(
        PageContext<ListSinksRequest, ListSinksResponse, LogSink> context,
        ApiFuture<ListSinksResponse> futureResponse) {
      ApiFuture<ListSinksPage> futurePage =
          ListSinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSinksPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSinksPagedResponse(ListSinksPage page) {
      super(page, ListSinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSinksPage
      extends AbstractPage<ListSinksRequest, ListSinksResponse, LogSink, ListSinksPage> {

    private ListSinksPage(
        PageContext<ListSinksRequest, ListSinksResponse, LogSink> context,
        ListSinksResponse response) {
      super(context, response);
    }

    private static ListSinksPage createEmptyPage() {
      return new ListSinksPage(null, null);
    }

    @Override
    protected ListSinksPage createPage(
        PageContext<ListSinksRequest, ListSinksResponse, LogSink> context,
        ListSinksResponse response) {
      return new ListSinksPage(context, response);
    }

    @Override
    public ApiFuture<ListSinksPage> createPageAsync(
        PageContext<ListSinksRequest, ListSinksResponse, LogSink> context,
        ApiFuture<ListSinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSinksRequest,
          ListSinksResponse,
          LogSink,
          ListSinksPage,
          ListSinksFixedSizeCollection> {

    private ListSinksFixedSizeCollection(List<ListSinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSinksFixedSizeCollection createEmptyCollection() {
      return new ListSinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSinksFixedSizeCollection createCollection(
        List<ListSinksPage> pages, int collectionSize) {
      return new ListSinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLinksPagedResponse
      extends AbstractPagedListResponse<
          ListLinksRequest, ListLinksResponse, Link, ListLinksPage, ListLinksFixedSizeCollection> {

    public static ApiFuture<ListLinksPagedResponse> createAsync(
        PageContext<ListLinksRequest, ListLinksResponse, Link> context,
        ApiFuture<ListLinksResponse> futureResponse) {
      ApiFuture<ListLinksPage> futurePage =
          ListLinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListLinksPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListLinksPagedResponse(ListLinksPage page) {
      super(page, ListLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLinksPage
      extends AbstractPage<ListLinksRequest, ListLinksResponse, Link, ListLinksPage> {

    private ListLinksPage(
        PageContext<ListLinksRequest, ListLinksResponse, Link> context,
        ListLinksResponse response) {
      super(context, response);
    }

    private static ListLinksPage createEmptyPage() {
      return new ListLinksPage(null, null);
    }

    @Override
    protected ListLinksPage createPage(
        PageContext<ListLinksRequest, ListLinksResponse, Link> context,
        ListLinksResponse response) {
      return new ListLinksPage(context, response);
    }

    @Override
    public ApiFuture<ListLinksPage> createPageAsync(
        PageContext<ListLinksRequest, ListLinksResponse, Link> context,
        ApiFuture<ListLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLinksRequest, ListLinksResponse, Link, ListLinksPage, ListLinksFixedSizeCollection> {

    private ListLinksFixedSizeCollection(List<ListLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLinksFixedSizeCollection createEmptyCollection() {
      return new ListLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLinksFixedSizeCollection createCollection(
        List<ListLinksPage> pages, int collectionSize) {
      return new ListLinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListExclusionsPagedResponse
      extends AbstractPagedListResponse<
          ListExclusionsRequest,
          ListExclusionsResponse,
          LogExclusion,
          ListExclusionsPage,
          ListExclusionsFixedSizeCollection> {

    public static ApiFuture<ListExclusionsPagedResponse> createAsync(
        PageContext<ListExclusionsRequest, ListExclusionsResponse, LogExclusion> context,
        ApiFuture<ListExclusionsResponse> futureResponse) {
      ApiFuture<ListExclusionsPage> futurePage =
          ListExclusionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExclusionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExclusionsPagedResponse(ListExclusionsPage page) {
      super(page, ListExclusionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExclusionsPage
      extends AbstractPage<
          ListExclusionsRequest, ListExclusionsResponse, LogExclusion, ListExclusionsPage> {

    private ListExclusionsPage(
        PageContext<ListExclusionsRequest, ListExclusionsResponse, LogExclusion> context,
        ListExclusionsResponse response) {
      super(context, response);
    }

    private static ListExclusionsPage createEmptyPage() {
      return new ListExclusionsPage(null, null);
    }

    @Override
    protected ListExclusionsPage createPage(
        PageContext<ListExclusionsRequest, ListExclusionsResponse, LogExclusion> context,
        ListExclusionsResponse response) {
      return new ListExclusionsPage(context, response);
    }

    @Override
    public ApiFuture<ListExclusionsPage> createPageAsync(
        PageContext<ListExclusionsRequest, ListExclusionsResponse, LogExclusion> context,
        ApiFuture<ListExclusionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExclusionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExclusionsRequest,
          ListExclusionsResponse,
          LogExclusion,
          ListExclusionsPage,
          ListExclusionsFixedSizeCollection> {

    private ListExclusionsFixedSizeCollection(List<ListExclusionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExclusionsFixedSizeCollection createEmptyCollection() {
      return new ListExclusionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExclusionsFixedSizeCollection createCollection(
        List<ListExclusionsPage> pages, int collectionSize) {
      return new ListExclusionsFixedSizeCollection(pages, collectionSize);
    }
  }
}

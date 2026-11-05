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

package com.google.cloud.observability.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.observability.v1.stub.ObservabilityStub;
import com.google.cloud.observability.v1.stub.ObservabilityStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
 *   ScopeName name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
 *   Scope response = observabilityClient.getScope(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ObservabilityClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetScope</td>
 *      <td><p> Gets details of a single Scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getScope(GetScopeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getScope(ScopeName name)
 *           <li><p> getScope(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateScope</td>
 *      <td><p> Updates the parameters of a single Scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateScope(UpdateScopeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateScope(Scope scope, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBucket</td>
 *      <td><p> Get bucket resource.</td>
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
 *      <td><p> ListBuckets</td>
 *      <td><p> List buckets of a project in a particular location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBuckets(ListBucketsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBuckets(LocationName parent)
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
 *      <td><p> CreateBucket</td>
 *      <td><p> Create a new bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBucketAsync(CreateBucketRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createBucketAsync(LocationName parent, Bucket bucket, String bucketId)
 *           <li><p> createBucketAsync(String parent, Bucket bucket, String bucketId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBucketOperationCallable()
 *           <li><p> createBucketCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBucket</td>
 *      <td><p> Update a bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBucketAsync(UpdateBucketRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateBucketAsync(Bucket bucket, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBucketOperationCallable()
 *           <li><p> updateBucketCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataset</td>
 *      <td><p> Get a dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataset(GetDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataset(DatasetName name)
 *           <li><p> getDataset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDatasets</td>
 *      <td><p> List datasets of a bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatasets(ListDatasetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatasets(BucketName parent)
 *           <li><p> listDatasets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDatasetsPagedCallable()
 *           <li><p> listDatasetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetView</td>
 *      <td><p> Get a view.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getView(GetViewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getView(ViewName name)
 *           <li><p> getView(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListViews</td>
 *      <td><p> List views of a dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listViews(ListViewsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listViews(DatasetName parent)
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
 *      <td><p> GetLink</td>
 *      <td><p> Get a link.</td>
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
 *      <td><p> ListLinks</td>
 *      <td><p> List links of a dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLinks(ListLinksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLinks(DatasetName parent)
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
 *      <td><p> CreateLink</td>
 *      <td><p> Create a new link.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createLinkAsync(CreateLinkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createLinkAsync(DatasetName parent, Link link, String linkId)
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
 *      <td><p> UpdateLink</td>
 *      <td><p> Update a link.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLinkAsync(UpdateLinkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateLinkAsync(Link link, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLinkOperationCallable()
 *           <li><p> updateLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteLink</td>
 *      <td><p> Delete a link.</td>
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
 *      <td><p> GetTraceScope</td>
 *      <td><p> Get TraceScope resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTraceScope(GetTraceScopeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTraceScope(TraceScopeName name)
 *           <li><p> getTraceScope(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTraceScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTraceScopes</td>
 *      <td><p> List TraceScopes of a project in a particular location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTraceScopes(ListTraceScopesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTraceScopes(LocationName parent)
 *           <li><p> listTraceScopes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTraceScopesPagedCallable()
 *           <li><p> listTraceScopesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTraceScope</td>
 *      <td><p> Create a new TraceScope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTraceScope(CreateTraceScopeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTraceScope(LocationName parent, TraceScope traceScope, String traceScopeId)
 *           <li><p> createTraceScope(String parent, TraceScope traceScope, String traceScopeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTraceScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTraceScope</td>
 *      <td><p> Update a TraceScope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTraceScope(UpdateTraceScopeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTraceScope(TraceScope traceScope, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTraceScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTraceScope</td>
 *      <td><p> Delete a TraceScope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTraceScope(DeleteTraceScopeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTraceScope(TraceScopeName name)
 *           <li><p> deleteTraceScope(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTraceScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSettings</td>
 *      <td><p> Get Settings</td>
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
 *      <td><p> Update Settings</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSettingsAsync(UpdateSettingsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSettingsAsync(Settings settings, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSettingsOperationCallable()
 *           <li><p> updateSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field: &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
 * <p> For gRPC and client library implementations, the resource name ispassed as the `name` field. For direct service calls, the resourcename isincorporated into the request path based on the specific serviceimplementation and version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
 * <p>This class can be customized by passing in a custom instance of ObservabilitySettings to
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
 * ObservabilitySettings observabilitySettings =
 *     ObservabilitySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ObservabilityClient observabilityClient = ObservabilityClient.create(observabilitySettings);
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
 * ObservabilitySettings observabilitySettings =
 *     ObservabilitySettings.newBuilder().setEndpoint(myEndpoint).build();
 * ObservabilityClient observabilityClient = ObservabilityClient.create(observabilitySettings);
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
 * ObservabilitySettings observabilitySettings =
 *     ObservabilitySettings.newHttpJsonBuilder().build();
 * ObservabilityClient observabilityClient = ObservabilityClient.create(observabilitySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ObservabilityClient implements BackgroundResource {
  private final @Nullable ObservabilitySettings settings;
  private final ObservabilityStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ObservabilityClient with default settings. */
  public static final ObservabilityClient create() throws IOException {
    return create(ObservabilitySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ObservabilityClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ObservabilityClient create(ObservabilitySettings settings)
      throws IOException {
    return new ObservabilityClient(settings);
  }

  /**
   * Constructs an instance of ObservabilityClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ObservabilitySettings).
   */
  public static final ObservabilityClient create(ObservabilityStub stub) {
    return new ObservabilityClient(stub);
  }

  /**
   * Constructs an instance of ObservabilityClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ObservabilityClient(ObservabilitySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ObservabilityStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ObservabilityClient(ObservabilityStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final @Nullable ObservabilitySettings getSettings() {
    return settings;
  }

  public ObservabilityStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ScopeName name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
   *   Scope response = observabilityClient.getScope(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource. The format is:
   *     <p>projects/{project}/locations/{location}/scopes/{scope}
   *     <p>The `{location}` field must be set to `global`. The `{scope}` field must be set to
   *     `_Default`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Scope getScope(@Nullable ScopeName name) {
    GetScopeRequest request =
        GetScopeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString();
   *   Scope response = observabilityClient.getScope(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource. The format is:
   *     <p>projects/{project}/locations/{location}/scopes/{scope}
   *     <p>The `{location}` field must be set to `global`. The `{scope}` field must be set to
   *     `_Default`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Scope getScope(String name) {
    GetScopeRequest request = GetScopeRequest.newBuilder().setName(name).build();
    return getScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetScopeRequest request =
   *       GetScopeRequest.newBuilder()
   *           .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .build();
   *   Scope response = observabilityClient.getScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Scope getScope(GetScopeRequest request) {
    return getScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetScopeRequest request =
   *       GetScopeRequest.newBuilder()
   *           .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .build();
   *   ApiFuture<Scope> future = observabilityClient.getScopeCallable().futureCall(request);
   *   // Do something.
   *   Scope response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetScopeRequest, Scope> getScopeCallable() {
    return stub.getScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   Scope scope = Scope.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Scope response = observabilityClient.updateScope(scope, updateMask);
   * }
   * }</pre>
   *
   * @param scope Required. The resource being updated.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Scope resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field is overwritten when it is in the mask. If the user
   *     does not provide a mask, then all fields present in the request are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Scope updateScope(Scope scope, FieldMask updateMask) {
    UpdateScopeRequest request =
        UpdateScopeRequest.newBuilder().setScope(scope).setUpdateMask(updateMask).build();
    return updateScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   UpdateScopeRequest request =
   *       UpdateScopeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setScope(Scope.newBuilder().build())
   *           .build();
   *   Scope response = observabilityClient.updateScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Scope updateScope(UpdateScopeRequest request) {
    return updateScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   UpdateScopeRequest request =
   *       UpdateScopeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setScope(Scope.newBuilder().build())
   *           .build();
   *   ApiFuture<Scope> future = observabilityClient.updateScopeCallable().futureCall(request);
   *   // Do something.
   *   Scope response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateScopeRequest, Scope> updateScopeCallable() {
    return stub.updateScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get bucket resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   BucketName name = BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]");
   *   Bucket response = observabilityClient.getBucket(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the bucket to retrieve. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket getBucket(@Nullable BucketName name) {
    GetBucketRequest request =
        GetBucketRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get bucket resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String name = BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]").toString();
   *   Bucket response = observabilityClient.getBucket(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the bucket to retrieve. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Bucket getBucket(String name) {
    GetBucketRequest request = GetBucketRequest.newBuilder().setName(name).build();
    return getBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get bucket resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetBucketRequest request =
   *       GetBucketRequest.newBuilder()
   *           .setName(BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]").toString())
   *           .build();
   *   Bucket response = observabilityClient.getBucket(request);
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
   * Get bucket resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetBucketRequest request =
   *       GetBucketRequest.newBuilder()
   *           .setName(BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]").toString())
   *           .build();
   *   ApiFuture<Bucket> future = observabilityClient.getBucketCallable().futureCall(request);
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
   * List buckets of a project in a particular location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Bucket element : observabilityClient.listBuckets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of buckets. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBucketsPagedResponse listBuckets(@Nullable LocationName parent) {
    ListBucketsRequest request =
        ListBucketsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBuckets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List buckets of a project in a particular location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Bucket element : observabilityClient.listBuckets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of buckets. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBucketsPagedResponse listBuckets(String parent) {
    ListBucketsRequest request = ListBucketsRequest.newBuilder().setParent(parent).build();
    return listBuckets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List buckets of a project in a particular location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListBucketsRequest request =
   *       ListBucketsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (Bucket element : observabilityClient.listBuckets(request).iterateAll()) {
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
   * List buckets of a project in a particular location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListBucketsRequest request =
   *       ListBucketsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<Bucket> future = observabilityClient.listBucketsPagedCallable().futureCall(request);
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
   * List buckets of a project in a particular location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListBucketsRequest request =
   *       ListBucketsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListBucketsResponse response = observabilityClient.listBucketsCallable().call(request);
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
   * Create a new bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Bucket bucket = Bucket.newBuilder().build();
   *   String bucketId = "bucketId-1603305307";
   *   Bucket response = observabilityClient.createBucketAsync(parent, bucket, bucketId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the project and location for the bucket. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]
   * @param bucket Required. Bucket to create.
   * @param bucketId Required. Id of the bucket to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Bucket, OperationMetadata> createBucketAsync(
      @Nullable LocationName parent, Bucket bucket, String bucketId) {
    CreateBucketRequest request =
        CreateBucketRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBucket(bucket)
            .setBucketId(bucketId)
            .build();
    return createBucketAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Bucket bucket = Bucket.newBuilder().build();
   *   String bucketId = "bucketId-1603305307";
   *   Bucket response = observabilityClient.createBucketAsync(parent, bucket, bucketId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the project and location for the bucket. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]
   * @param bucket Required. Bucket to create.
   * @param bucketId Required. Id of the bucket to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Bucket, OperationMetadata> createBucketAsync(
      String parent, Bucket bucket, String bucketId) {
    CreateBucketRequest request =
        CreateBucketRequest.newBuilder()
            .setParent(parent)
            .setBucket(bucket)
            .setBucketId(bucketId)
            .build();
    return createBucketAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   CreateBucketRequest request =
   *       CreateBucketRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBucketId("bucketId-1603305307")
   *           .setBucket(Bucket.newBuilder().build())
   *           .build();
   *   Bucket response = observabilityClient.createBucketAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Bucket, OperationMetadata> createBucketAsync(
      CreateBucketRequest request) {
    return createBucketOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   CreateBucketRequest request =
   *       CreateBucketRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBucketId("bucketId-1603305307")
   *           .setBucket(Bucket.newBuilder().build())
   *           .build();
   *   OperationFuture<Bucket, OperationMetadata> future =
   *       observabilityClient.createBucketOperationCallable().futureCall(request);
   *   // Do something.
   *   Bucket response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBucketRequest, Bucket, OperationMetadata>
      createBucketOperationCallable() {
    return stub.createBucketOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   CreateBucketRequest request =
   *       CreateBucketRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBucketId("bucketId-1603305307")
   *           .setBucket(Bucket.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = observabilityClient.createBucketCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBucketRequest, Operation> createBucketCallable() {
    return stub.createBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   Bucket bucket = Bucket.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Bucket response = observabilityClient.updateBucketAsync(bucket, updateMask).get();
   * }
   * }</pre>
   *
   * @param bucket Required. The bucket to update.
   *     <p>The name field of bucket identifies the resource to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Bucket, OperationMetadata> updateBucketAsync(
      Bucket bucket, FieldMask updateMask) {
    UpdateBucketRequest request =
        UpdateBucketRequest.newBuilder().setBucket(bucket).setUpdateMask(updateMask).build();
    return updateBucketAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   UpdateBucketRequest request =
   *       UpdateBucketRequest.newBuilder()
   *           .setBucket(Bucket.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Bucket response = observabilityClient.updateBucketAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Bucket, OperationMetadata> updateBucketAsync(
      UpdateBucketRequest request) {
    return updateBucketOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   UpdateBucketRequest request =
   *       UpdateBucketRequest.newBuilder()
   *           .setBucket(Bucket.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Bucket, OperationMetadata> future =
   *       observabilityClient.updateBucketOperationCallable().futureCall(request);
   *   // Do something.
   *   Bucket response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBucketRequest, Bucket, OperationMetadata>
      updateBucketOperationCallable() {
    return stub.updateBucketOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   UpdateBucketRequest request =
   *       UpdateBucketRequest.newBuilder()
   *           .setBucket(Bucket.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = observabilityClient.updateBucketCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBucketRequest, Operation> updateBucketCallable() {
    return stub.updateBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");
   *   Dataset response = observabilityClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the dataset to retrieve. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(@Nullable DatasetName name) {
    GetDatasetRequest request =
        GetDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString();
   *   Dataset response = observabilityClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the dataset to retrieve. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(String name) {
    GetDatasetRequest request = GetDatasetRequest.newBuilder().setName(name).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(
   *               DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString())
   *           .build();
   *   Dataset response = observabilityClient.getDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(GetDatasetRequest request) {
    return getDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(
   *               DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString())
   *           .build();
   *   ApiFuture<Dataset> future = observabilityClient.getDatasetCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return stub.getDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List datasets of a bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   BucketName parent = BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]");
   *   for (Dataset element : observabilityClient.listDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent bucket that owns this collection of datasets. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(@Nullable BucketName parent) {
    ListDatasetsRequest request =
        ListDatasetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List datasets of a bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String parent = BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]").toString();
   *   for (Dataset element : observabilityClient.listDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent bucket that owns this collection of datasets. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(String parent) {
    ListDatasetsRequest request = ListDatasetsRequest.newBuilder().setParent(parent).build();
    return listDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List datasets of a bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (Dataset element : observabilityClient.listDatasets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(ListDatasetsRequest request) {
    return listDatasetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List datasets of a bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<Dataset> future =
   *       observabilityClient.listDatasetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Dataset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable() {
    return stub.listDatasetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List datasets of a bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListDatasetsResponse response = observabilityClient.listDatasetsCallable().call(request);
   *     for (Dataset element : response.getDatasetsList()) {
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
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return stub.listDatasetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[VIEW]");
   *   View response = observabilityClient.getView(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the view to retrieve. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]/views/[VIEW_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View getView(@Nullable ViewName name) {
    GetViewRequest request =
        GetViewRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String name =
   *       ViewName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[VIEW]").toString();
   *   View response = observabilityClient.getView(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the view to retrieve. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]/views/[VIEW_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View getView(String name) {
    GetViewRequest request = GetViewRequest.newBuilder().setName(name).build();
    return getView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetViewRequest request =
   *       GetViewRequest.newBuilder()
   *           .setName(
   *               ViewName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[VIEW]")
   *                   .toString())
   *           .build();
   *   View response = observabilityClient.getView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View getView(GetViewRequest request) {
    return getViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetViewRequest request =
   *       GetViewRequest.newBuilder()
   *           .setName(
   *               ViewName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[VIEW]")
   *                   .toString())
   *           .build();
   *   ApiFuture<View> future = observabilityClient.getViewCallable().futureCall(request);
   *   // Do something.
   *   View response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetViewRequest, View> getViewCallable() {
    return stub.getViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List views of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");
   *   for (View element : observabilityClient.listViews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Dataset whose views are to be listed. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViewsPagedResponse listViews(@Nullable DatasetName parent) {
    ListViewsRequest request =
        ListViewsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listViews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List views of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString();
   *   for (View element : observabilityClient.listViews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Dataset whose views are to be listed. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViewsPagedResponse listViews(String parent) {
    ListViewsRequest request = ListViewsRequest.newBuilder().setParent(parent).build();
    return listViews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List views of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListViewsRequest request =
   *       ListViewsRequest.newBuilder()
   *           .setParent(
   *               DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (View element : observabilityClient.listViews(request).iterateAll()) {
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
   * List views of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListViewsRequest request =
   *       ListViewsRequest.newBuilder()
   *           .setParent(
   *               DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<View> future = observabilityClient.listViewsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (View element : future.get().iterateAll()) {
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
   * List views of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListViewsRequest request =
   *       ListViewsRequest.newBuilder()
   *           .setParent(
   *               DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListViewsResponse response = observabilityClient.listViewsCallable().call(request);
   *     for (View element : response.getViewsList()) {
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
   * Get a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   LinkName name = LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]");
   *   Link response = observabilityClient.getLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the link to retrieve. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]/links/[LINK_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Link getLink(@Nullable LinkName name) {
    GetLinkRequest request =
        GetLinkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String name =
   *       LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]").toString();
   *   Link response = observabilityClient.getLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the link to retrieve. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]/links/[LINK_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Link getLink(String name) {
    GetLinkRequest request = GetLinkRequest.newBuilder().setName(name).build();
    return getLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetLinkRequest request =
   *       GetLinkRequest.newBuilder()
   *           .setName(
   *               LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]")
   *                   .toString())
   *           .build();
   *   Link response = observabilityClient.getLink(request);
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
   * Get a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetLinkRequest request =
   *       GetLinkRequest.newBuilder()
   *           .setName(
   *               LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Link> future = observabilityClient.getLinkCallable().futureCall(request);
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
   * List links of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");
   *   for (Link element : observabilityClient.listLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent dataset that owns this collection of links. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinksPagedResponse listLinks(@Nullable DatasetName parent) {
    ListLinksRequest request =
        ListLinksRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List links of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString();
   *   for (Link element : observabilityClient.listLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent dataset that owns this collection of links. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinksPagedResponse listLinks(String parent) {
    ListLinksRequest request = ListLinksRequest.newBuilder().setParent(parent).build();
    return listLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List links of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListLinksRequest request =
   *       ListLinksRequest.newBuilder()
   *           .setParent(
   *               DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Link element : observabilityClient.listLinks(request).iterateAll()) {
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
   * List links of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListLinksRequest request =
   *       ListLinksRequest.newBuilder()
   *           .setParent(
   *               DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Link> future = observabilityClient.listLinksPagedCallable().futureCall(request);
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
   * List links of a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListLinksRequest request =
   *       ListLinksRequest.newBuilder()
   *           .setParent(
   *               DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLinksResponse response = observabilityClient.listLinksCallable().call(request);
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
   * Create a new link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");
   *   Link link = Link.newBuilder().build();
   *   String linkId = "linkId-1102667083";
   *   Link response = observabilityClient.createLinkAsync(parent, link, linkId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the containing dataset for this link. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]
   * @param link Required. Link to create.
   * @param linkId Required. Id of the link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Link, OperationMetadata> createLinkAsync(
      @Nullable DatasetName parent, Link link, String linkId) {
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
   * Create a new link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString();
   *   Link link = Link.newBuilder().build();
   *   String linkId = "linkId-1102667083";
   *   Link response = observabilityClient.createLinkAsync(parent, link, linkId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the containing dataset for this link. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]
   * @param link Required. Link to create.
   * @param linkId Required. Id of the link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Link, OperationMetadata> createLinkAsync(
      String parent, Link link, String linkId) {
    CreateLinkRequest request =
        CreateLinkRequest.newBuilder().setParent(parent).setLink(link).setLinkId(linkId).build();
    return createLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   CreateLinkRequest request =
   *       CreateLinkRequest.newBuilder()
   *           .setParent(
   *               DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString())
   *           .setLinkId("linkId-1102667083")
   *           .setLink(Link.newBuilder().build())
   *           .build();
   *   Link response = observabilityClient.createLinkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Link, OperationMetadata> createLinkAsync(CreateLinkRequest request) {
    return createLinkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   CreateLinkRequest request =
   *       CreateLinkRequest.newBuilder()
   *           .setParent(
   *               DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString())
   *           .setLinkId("linkId-1102667083")
   *           .setLink(Link.newBuilder().build())
   *           .build();
   *   OperationFuture<Link, OperationMetadata> future =
   *       observabilityClient.createLinkOperationCallable().futureCall(request);
   *   // Do something.
   *   Link response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateLinkRequest, Link, OperationMetadata>
      createLinkOperationCallable() {
    return stub.createLinkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   CreateLinkRequest request =
   *       CreateLinkRequest.newBuilder()
   *           .setParent(
   *               DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString())
   *           .setLinkId("linkId-1102667083")
   *           .setLink(Link.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = observabilityClient.createLinkCallable().futureCall(request);
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
   * Update a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   Link link = Link.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Link response = observabilityClient.updateLinkAsync(link, updateMask).get();
   * }
   * }</pre>
   *
   * @param link Required. Link to update.
   *     <p>The name field of link identifies the resource to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Link, OperationMetadata> updateLinkAsync(
      Link link, FieldMask updateMask) {
    UpdateLinkRequest request =
        UpdateLinkRequest.newBuilder().setLink(link).setUpdateMask(updateMask).build();
    return updateLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   UpdateLinkRequest request =
   *       UpdateLinkRequest.newBuilder()
   *           .setLink(Link.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Link response = observabilityClient.updateLinkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Link, OperationMetadata> updateLinkAsync(UpdateLinkRequest request) {
    return updateLinkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   UpdateLinkRequest request =
   *       UpdateLinkRequest.newBuilder()
   *           .setLink(Link.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Link, OperationMetadata> future =
   *       observabilityClient.updateLinkOperationCallable().futureCall(request);
   *   // Do something.
   *   Link response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateLinkRequest, Link, OperationMetadata>
      updateLinkOperationCallable() {
    return stub.updateLinkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   UpdateLinkRequest request =
   *       UpdateLinkRequest.newBuilder()
   *           .setLink(Link.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = observabilityClient.updateLinkCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLinkRequest, Operation> updateLinkCallable() {
    return stub.updateLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   LinkName name = LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]");
   *   observabilityClient.deleteLinkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the link to delete. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]/links/[LINK_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLinkAsync(@Nullable LinkName name) {
    DeleteLinkRequest request =
        DeleteLinkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String name =
   *       LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]").toString();
   *   observabilityClient.deleteLinkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the link to delete. The format is:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION]/buckets/[BUCKET_ID]/datasets/[DATASET_ID]/links/[LINK_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLinkAsync(String name) {
    DeleteLinkRequest request = DeleteLinkRequest.newBuilder().setName(name).build();
    return deleteLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   DeleteLinkRequest request =
   *       DeleteLinkRequest.newBuilder()
   *           .setName(
   *               LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]")
   *                   .toString())
   *           .build();
   *   observabilityClient.deleteLinkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLinkAsync(
      DeleteLinkRequest request) {
    return deleteLinkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   DeleteLinkRequest request =
   *       DeleteLinkRequest.newBuilder()
   *           .setName(
   *               LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       observabilityClient.deleteLinkOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteLinkRequest, Empty, OperationMetadata>
      deleteLinkOperationCallable() {
    return stub.deleteLinkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   DeleteLinkRequest request =
   *       DeleteLinkRequest.newBuilder()
   *           .setName(
   *               LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = observabilityClient.deleteLinkCallable().futureCall(request);
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
   * Get TraceScope resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   TraceScopeName name = TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]");
   *   TraceScope response = observabilityClient.getTraceScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the trace scope:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION_ID]/traceScopes/[TRACE_SCOPE_ID]
   *     <p>For example:
   *     <p>projects/my-project/locations/global/traceScopes/my-trace-scope
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TraceScope getTraceScope(@Nullable TraceScopeName name) {
    GetTraceScopeRequest request =
        GetTraceScopeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTraceScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get TraceScope resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String name = TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]").toString();
   *   TraceScope response = observabilityClient.getTraceScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the trace scope:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION_ID]/traceScopes/[TRACE_SCOPE_ID]
   *     <p>For example:
   *     <p>projects/my-project/locations/global/traceScopes/my-trace-scope
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TraceScope getTraceScope(String name) {
    GetTraceScopeRequest request = GetTraceScopeRequest.newBuilder().setName(name).build();
    return getTraceScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get TraceScope resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetTraceScopeRequest request =
   *       GetTraceScopeRequest.newBuilder()
   *           .setName(TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]").toString())
   *           .build();
   *   TraceScope response = observabilityClient.getTraceScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TraceScope getTraceScope(GetTraceScopeRequest request) {
    return getTraceScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get TraceScope resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetTraceScopeRequest request =
   *       GetTraceScopeRequest.newBuilder()
   *           .setName(TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]").toString())
   *           .build();
   *   ApiFuture<TraceScope> future =
   *       observabilityClient.getTraceScopeCallable().futureCall(request);
   *   // Do something.
   *   TraceScope response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTraceScopeRequest, TraceScope> getTraceScopeCallable() {
    return stub.getTraceScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List TraceScopes of a project in a particular location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (TraceScope element : observabilityClient.listTraceScopes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The full resource name of the location to look for trace scopes:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION_ID]
   *     <p>For example:
   *     <p>projects/my-project/locations/global
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTraceScopesPagedResponse listTraceScopes(@Nullable LocationName parent) {
    ListTraceScopesRequest request =
        ListTraceScopesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTraceScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List TraceScopes of a project in a particular location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (TraceScope element : observabilityClient.listTraceScopes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The full resource name of the location to look for trace scopes:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION_ID]
   *     <p>For example:
   *     <p>projects/my-project/locations/global
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTraceScopesPagedResponse listTraceScopes(String parent) {
    ListTraceScopesRequest request = ListTraceScopesRequest.newBuilder().setParent(parent).build();
    return listTraceScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List TraceScopes of a project in a particular location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListTraceScopesRequest request =
   *       ListTraceScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TraceScope element : observabilityClient.listTraceScopes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTraceScopesPagedResponse listTraceScopes(ListTraceScopesRequest request) {
    return listTraceScopesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List TraceScopes of a project in a particular location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListTraceScopesRequest request =
   *       ListTraceScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TraceScope> future =
   *       observabilityClient.listTraceScopesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TraceScope element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTraceScopesRequest, ListTraceScopesPagedResponse>
      listTraceScopesPagedCallable() {
    return stub.listTraceScopesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List TraceScopes of a project in a particular location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListTraceScopesRequest request =
   *       ListTraceScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTraceScopesResponse response =
   *         observabilityClient.listTraceScopesCallable().call(request);
   *     for (TraceScope element : response.getTraceScopesList()) {
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
  public final UnaryCallable<ListTraceScopesRequest, ListTraceScopesResponse>
      listTraceScopesCallable() {
    return stub.listTraceScopesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new TraceScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   TraceScope traceScope = TraceScope.newBuilder().build();
   *   String traceScopeId = "traceScopeId-2107793014";
   *   TraceScope response = observabilityClient.createTraceScope(parent, traceScope, traceScopeId);
   * }
   * }</pre>
   *
   * @param parent Required. The full resource name of the location where the trace scope should be
   *     created
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION_ID]
   *     <p>For example:
   *     <p>projects/my-project/locations/global
   * @param traceScope Required. The new trace scope.
   * @param traceScopeId Required. A client-assigned identifier for the trace scope.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TraceScope createTraceScope(
      @Nullable LocationName parent, TraceScope traceScope, String traceScopeId) {
    CreateTraceScopeRequest request =
        CreateTraceScopeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTraceScope(traceScope)
            .setTraceScopeId(traceScopeId)
            .build();
    return createTraceScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new TraceScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   TraceScope traceScope = TraceScope.newBuilder().build();
   *   String traceScopeId = "traceScopeId-2107793014";
   *   TraceScope response = observabilityClient.createTraceScope(parent, traceScope, traceScopeId);
   * }
   * }</pre>
   *
   * @param parent Required. The full resource name of the location where the trace scope should be
   *     created
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION_ID]
   *     <p>For example:
   *     <p>projects/my-project/locations/global
   * @param traceScope Required. The new trace scope.
   * @param traceScopeId Required. A client-assigned identifier for the trace scope.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TraceScope createTraceScope(
      String parent, TraceScope traceScope, String traceScopeId) {
    CreateTraceScopeRequest request =
        CreateTraceScopeRequest.newBuilder()
            .setParent(parent)
            .setTraceScope(traceScope)
            .setTraceScopeId(traceScopeId)
            .build();
    return createTraceScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new TraceScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   CreateTraceScopeRequest request =
   *       CreateTraceScopeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTraceScopeId("traceScopeId-2107793014")
   *           .setTraceScope(TraceScope.newBuilder().build())
   *           .build();
   *   TraceScope response = observabilityClient.createTraceScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TraceScope createTraceScope(CreateTraceScopeRequest request) {
    return createTraceScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new TraceScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   CreateTraceScopeRequest request =
   *       CreateTraceScopeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTraceScopeId("traceScopeId-2107793014")
   *           .setTraceScope(TraceScope.newBuilder().build())
   *           .build();
   *   ApiFuture<TraceScope> future =
   *       observabilityClient.createTraceScopeCallable().futureCall(request);
   *   // Do something.
   *   TraceScope response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTraceScopeRequest, TraceScope> createTraceScopeCallable() {
    return stub.createTraceScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a TraceScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   TraceScope traceScope = TraceScope.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TraceScope response = observabilityClient.updateTraceScope(traceScope, updateMask);
   * }
   * }</pre>
   *
   * @param traceScope Required. The updated trace scope.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TraceScope updateTraceScope(TraceScope traceScope, FieldMask updateMask) {
    UpdateTraceScopeRequest request =
        UpdateTraceScopeRequest.newBuilder()
            .setTraceScope(traceScope)
            .setUpdateMask(updateMask)
            .build();
    return updateTraceScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a TraceScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   UpdateTraceScopeRequest request =
   *       UpdateTraceScopeRequest.newBuilder()
   *           .setTraceScope(TraceScope.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   TraceScope response = observabilityClient.updateTraceScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TraceScope updateTraceScope(UpdateTraceScopeRequest request) {
    return updateTraceScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a TraceScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   UpdateTraceScopeRequest request =
   *       UpdateTraceScopeRequest.newBuilder()
   *           .setTraceScope(TraceScope.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TraceScope> future =
   *       observabilityClient.updateTraceScopeCallable().futureCall(request);
   *   // Do something.
   *   TraceScope response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTraceScopeRequest, TraceScope> updateTraceScopeCallable() {
    return stub.updateTraceScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a TraceScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   TraceScopeName name = TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]");
   *   observabilityClient.deleteTraceScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the trace scope to delete:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION_ID]/traceScopes/[TRACE_SCOPE_ID]
   *     <p>For example:
   *     <p>projects/my-project/locations/global/traceScopes/my-trace-scope
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTraceScope(@Nullable TraceScopeName name) {
    DeleteTraceScopeRequest request =
        DeleteTraceScopeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTraceScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a TraceScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String name = TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]").toString();
   *   observabilityClient.deleteTraceScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the trace scope to delete:
   *     <p>projects/[PROJECT_ID]/locations/[LOCATION_ID]/traceScopes/[TRACE_SCOPE_ID]
   *     <p>For example:
   *     <p>projects/my-project/locations/global/traceScopes/my-trace-scope
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTraceScope(String name) {
    DeleteTraceScopeRequest request = DeleteTraceScopeRequest.newBuilder().setName(name).build();
    deleteTraceScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a TraceScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   DeleteTraceScopeRequest request =
   *       DeleteTraceScopeRequest.newBuilder()
   *           .setName(TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]").toString())
   *           .build();
   *   observabilityClient.deleteTraceScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTraceScope(DeleteTraceScopeRequest request) {
    deleteTraceScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a TraceScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   DeleteTraceScopeRequest request =
   *       DeleteTraceScopeRequest.newBuilder()
   *           .setName(TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]").toString())
   *           .build();
   *   ApiFuture<Empty> future = observabilityClient.deleteTraceScopeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTraceScopeRequest, Empty> deleteTraceScopeCallable() {
    return stub.deleteTraceScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get Settings
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   SettingsName name = SettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
   *   Settings response = observabilityClient.getSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the settings to retrieve.
   *     <p>Name format:
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION]/settings"
   *     "folders/[FOLDER_ID]/locations/[LOCATION]/settings"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION]/settings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(@Nullable SettingsName name) {
    GetSettingsRequest request =
        GetSettingsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get Settings
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   String name = SettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString();
   *   Settings response = observabilityClient.getSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the settings to retrieve.
   *     <p>Name format:
   *     <p>"projects/[PROJECT_ID]/locations/[LOCATION]/settings"
   *     "folders/[FOLDER_ID]/locations/[LOCATION]/settings"
   *     "organizations/[ORGANIZATION_ID]/locations/[LOCATION]/settings"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(String name) {
    GetSettingsRequest request = GetSettingsRequest.newBuilder().setName(name).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get Settings
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetSettingsRequest request =
   *       GetSettingsRequest.newBuilder()
   *           .setName(SettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   Settings response = observabilityClient.getSettings(request);
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
   * Get Settings
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetSettingsRequest request =
   *       GetSettingsRequest.newBuilder()
   *           .setName(SettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<Settings> future = observabilityClient.getSettingsCallable().futureCall(request);
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
   * Update Settings
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   Settings settings = Settings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Settings response = observabilityClient.updateSettingsAsync(settings, updateMask).get();
   * }
   * }</pre>
   *
   * @param settings Required. The settings to update.
   *     <p>The name field of settings is used to identify the resource to be updated.
   * @param updateMask Optional. The field mask specifying which fields of the settings are to be
   *     updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Settings, OperationMetadata> updateSettingsAsync(
      Settings settings, FieldMask updateMask) {
    UpdateSettingsRequest request =
        UpdateSettingsRequest.newBuilder().setSettings(settings).setUpdateMask(updateMask).build();
    return updateSettingsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update Settings
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setSettings(Settings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Settings response = observabilityClient.updateSettingsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Settings, OperationMetadata> updateSettingsAsync(
      UpdateSettingsRequest request) {
    return updateSettingsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update Settings
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setSettings(Settings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Settings, OperationMetadata> future =
   *       observabilityClient.updateSettingsOperationCallable().futureCall(request);
   *   // Do something.
   *   Settings response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationCallable() {
    return stub.updateSettingsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update Settings
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setSettings(Settings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       observabilityClient.updateSettingsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSettingsRequest, Operation> updateSettingsCallable() {
    return stub.updateSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : observabilityClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       observabilityClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = observabilityClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = observabilityClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = observabilityClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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
        @Nullable PageContext<ListBucketsRequest, ListBucketsResponse, Bucket> context,
        @Nullable ListBucketsResponse response) {
      super(context, response);
    }

    private static ListBucketsPage createEmptyPage() {
      return new ListBucketsPage(null, null);
    }

    @Override
    protected ListBucketsPage createPage(
        @Nullable PageContext<ListBucketsRequest, ListBucketsResponse, Bucket> context,
        @Nullable ListBucketsResponse response) {
      return new ListBucketsPage(context, response);
    }

    @Override
    public ApiFuture<ListBucketsPage> createPageAsync(
        @Nullable PageContext<ListBucketsRequest, ListBucketsResponse, Bucket> context,
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

    private ListBucketsFixedSizeCollection(
        @Nullable List<ListBucketsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBucketsFixedSizeCollection createEmptyCollection() {
      return new ListBucketsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBucketsFixedSizeCollection createCollection(
        @Nullable List<ListBucketsPage> pages, int collectionSize) {
      return new ListBucketsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDatasetsPagedResponse
      extends AbstractPagedListResponse<
          ListDatasetsRequest,
          ListDatasetsResponse,
          Dataset,
          ListDatasetsPage,
          ListDatasetsFixedSizeCollection> {

    public static ApiFuture<ListDatasetsPagedResponse> createAsync(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ApiFuture<ListDatasetsResponse> futureResponse) {
      ApiFuture<ListDatasetsPage> futurePage =
          ListDatasetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatasetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatasetsPagedResponse(ListDatasetsPage page) {
      super(page, ListDatasetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatasetsPage
      extends AbstractPage<ListDatasetsRequest, ListDatasetsResponse, Dataset, ListDatasetsPage> {

    private ListDatasetsPage(
        @Nullable PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        @Nullable ListDatasetsResponse response) {
      super(context, response);
    }

    private static ListDatasetsPage createEmptyPage() {
      return new ListDatasetsPage(null, null);
    }

    @Override
    protected ListDatasetsPage createPage(
        @Nullable PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        @Nullable ListDatasetsResponse response) {
      return new ListDatasetsPage(context, response);
    }

    @Override
    public ApiFuture<ListDatasetsPage> createPageAsync(
        @Nullable PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ApiFuture<ListDatasetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatasetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatasetsRequest,
          ListDatasetsResponse,
          Dataset,
          ListDatasetsPage,
          ListDatasetsFixedSizeCollection> {

    private ListDatasetsFixedSizeCollection(
        @Nullable List<ListDatasetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatasetsFixedSizeCollection createEmptyCollection() {
      return new ListDatasetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatasetsFixedSizeCollection createCollection(
        @Nullable List<ListDatasetsPage> pages, int collectionSize) {
      return new ListDatasetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListViewsPagedResponse
      extends AbstractPagedListResponse<
          ListViewsRequest, ListViewsResponse, View, ListViewsPage, ListViewsFixedSizeCollection> {

    public static ApiFuture<ListViewsPagedResponse> createAsync(
        PageContext<ListViewsRequest, ListViewsResponse, View> context,
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
      extends AbstractPage<ListViewsRequest, ListViewsResponse, View, ListViewsPage> {

    private ListViewsPage(
        @Nullable PageContext<ListViewsRequest, ListViewsResponse, View> context,
        @Nullable ListViewsResponse response) {
      super(context, response);
    }

    private static ListViewsPage createEmptyPage() {
      return new ListViewsPage(null, null);
    }

    @Override
    protected ListViewsPage createPage(
        @Nullable PageContext<ListViewsRequest, ListViewsResponse, View> context,
        @Nullable ListViewsResponse response) {
      return new ListViewsPage(context, response);
    }

    @Override
    public ApiFuture<ListViewsPage> createPageAsync(
        @Nullable PageContext<ListViewsRequest, ListViewsResponse, View> context,
        ApiFuture<ListViewsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListViewsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListViewsRequest, ListViewsResponse, View, ListViewsPage, ListViewsFixedSizeCollection> {

    private ListViewsFixedSizeCollection(@Nullable List<ListViewsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListViewsFixedSizeCollection createEmptyCollection() {
      return new ListViewsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListViewsFixedSizeCollection createCollection(
        @Nullable List<ListViewsPage> pages, int collectionSize) {
      return new ListViewsFixedSizeCollection(pages, collectionSize);
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
        @Nullable PageContext<ListLinksRequest, ListLinksResponse, Link> context,
        @Nullable ListLinksResponse response) {
      super(context, response);
    }

    private static ListLinksPage createEmptyPage() {
      return new ListLinksPage(null, null);
    }

    @Override
    protected ListLinksPage createPage(
        @Nullable PageContext<ListLinksRequest, ListLinksResponse, Link> context,
        @Nullable ListLinksResponse response) {
      return new ListLinksPage(context, response);
    }

    @Override
    public ApiFuture<ListLinksPage> createPageAsync(
        @Nullable PageContext<ListLinksRequest, ListLinksResponse, Link> context,
        ApiFuture<ListLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLinksRequest, ListLinksResponse, Link, ListLinksPage, ListLinksFixedSizeCollection> {

    private ListLinksFixedSizeCollection(@Nullable List<ListLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLinksFixedSizeCollection createEmptyCollection() {
      return new ListLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLinksFixedSizeCollection createCollection(
        @Nullable List<ListLinksPage> pages, int collectionSize) {
      return new ListLinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTraceScopesPagedResponse
      extends AbstractPagedListResponse<
          ListTraceScopesRequest,
          ListTraceScopesResponse,
          TraceScope,
          ListTraceScopesPage,
          ListTraceScopesFixedSizeCollection> {

    public static ApiFuture<ListTraceScopesPagedResponse> createAsync(
        PageContext<ListTraceScopesRequest, ListTraceScopesResponse, TraceScope> context,
        ApiFuture<ListTraceScopesResponse> futureResponse) {
      ApiFuture<ListTraceScopesPage> futurePage =
          ListTraceScopesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTraceScopesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTraceScopesPagedResponse(ListTraceScopesPage page) {
      super(page, ListTraceScopesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTraceScopesPage
      extends AbstractPage<
          ListTraceScopesRequest, ListTraceScopesResponse, TraceScope, ListTraceScopesPage> {

    private ListTraceScopesPage(
        @Nullable PageContext<ListTraceScopesRequest, ListTraceScopesResponse, TraceScope> context,
        @Nullable ListTraceScopesResponse response) {
      super(context, response);
    }

    private static ListTraceScopesPage createEmptyPage() {
      return new ListTraceScopesPage(null, null);
    }

    @Override
    protected ListTraceScopesPage createPage(
        @Nullable PageContext<ListTraceScopesRequest, ListTraceScopesResponse, TraceScope> context,
        @Nullable ListTraceScopesResponse response) {
      return new ListTraceScopesPage(context, response);
    }

    @Override
    public ApiFuture<ListTraceScopesPage> createPageAsync(
        @Nullable PageContext<ListTraceScopesRequest, ListTraceScopesResponse, TraceScope> context,
        ApiFuture<ListTraceScopesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTraceScopesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTraceScopesRequest,
          ListTraceScopesResponse,
          TraceScope,
          ListTraceScopesPage,
          ListTraceScopesFixedSizeCollection> {

    private ListTraceScopesFixedSizeCollection(
        @Nullable List<ListTraceScopesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTraceScopesFixedSizeCollection createEmptyCollection() {
      return new ListTraceScopesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTraceScopesFixedSizeCollection createCollection(
        @Nullable List<ListTraceScopesPage> pages, int collectionSize) {
      return new ListTraceScopesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}

/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.TargetHttpProxiesStub;
import com.google.cloud.compute.v1.stub.TargetHttpProxiesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The TargetHttpProxies API.
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
 * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String targetHttpProxy = "targetHttpProxy-1944074187";
 *   TargetHttpProxy response = targetHttpProxiesClient.get(project, targetHttpProxy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TargetHttpProxiesClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of TargetHttpProxiesSettings to
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
 * TargetHttpProxiesSettings targetHttpProxiesSettings =
 *     TargetHttpProxiesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetHttpProxiesClient targetHttpProxiesClient =
 *     TargetHttpProxiesClient.create(targetHttpProxiesSettings);
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
 * TargetHttpProxiesSettings targetHttpProxiesSettings =
 *     TargetHttpProxiesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetHttpProxiesClient targetHttpProxiesClient =
 *     TargetHttpProxiesClient.create(targetHttpProxiesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TargetHttpProxiesClient implements BackgroundResource {
  private final TargetHttpProxiesSettings settings;
  private final TargetHttpProxiesStub stub;

  /** Constructs an instance of TargetHttpProxiesClient with default settings. */
  public static final TargetHttpProxiesClient create() throws IOException {
    return create(TargetHttpProxiesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetHttpProxiesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetHttpProxiesClient create(TargetHttpProxiesSettings settings)
      throws IOException {
    return new TargetHttpProxiesClient(settings);
  }

  /**
   * Constructs an instance of TargetHttpProxiesClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(TargetHttpProxiesSettings).
   */
  public static final TargetHttpProxiesClient create(TargetHttpProxiesStub stub) {
    return new TargetHttpProxiesClient(stub);
  }

  /**
   * Constructs an instance of TargetHttpProxiesClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TargetHttpProxiesClient(TargetHttpProxiesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetHttpProxiesStubSettings) settings.getStubSettings()).createStub();
  }

  protected TargetHttpProxiesClient(TargetHttpProxiesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetHttpProxiesSettings getSettings() {
    return settings;
  }

  public TargetHttpProxiesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all TargetHttpProxy resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, TargetHttpProxiesScopedList> element :
   *       targetHttpProxiesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListTargetHttpProxiesRequest request =
        AggregatedListTargetHttpProxiesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all TargetHttpProxy resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   AggregatedListTargetHttpProxiesRequest request =
   *       AggregatedListTargetHttpProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, TargetHttpProxiesScopedList> element :
   *       targetHttpProxiesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListTargetHttpProxiesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all TargetHttpProxy resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   AggregatedListTargetHttpProxiesRequest request =
   *       AggregatedListTargetHttpProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, TargetHttpProxiesScopedList>> future =
   *       targetHttpProxiesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, TargetHttpProxiesScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListTargetHttpProxiesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all TargetHttpProxy resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   AggregatedListTargetHttpProxiesRequest request =
   *       AggregatedListTargetHttpProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     TargetHttpProxyAggregatedList response =
   *         targetHttpProxiesClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, TargetHttpProxiesScopedList> element : response.getItemsList()) {
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
  public final UnaryCallable<AggregatedListTargetHttpProxiesRequest, TargetHttpProxyAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetHttpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetHttpProxy = "targetHttpProxy-1944074187";
   *   Operation response = targetHttpProxiesClient.deleteAsync(project, targetHttpProxy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpProxy Name of the TargetHttpProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String targetHttpProxy) {
    DeleteTargetHttpProxyRequest request =
        DeleteTargetHttpProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpProxy(targetHttpProxy)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetHttpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   DeleteTargetHttpProxyRequest request =
   *       DeleteTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpProxy("targetHttpProxy-1944074187")
   *           .build();
   *   Operation response = targetHttpProxiesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteTargetHttpProxyRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetHttpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   DeleteTargetHttpProxyRequest request =
   *       DeleteTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpProxy("targetHttpProxy-1944074187")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetHttpProxiesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTargetHttpProxyRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetHttpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   DeleteTargetHttpProxyRequest request =
   *       DeleteTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpProxy("targetHttpProxy-1944074187")
   *           .build();
   *   ApiFuture<Operation> future = targetHttpProxiesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTargetHttpProxyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetHttpProxy resource. Gets a list of available target HTTP proxies by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetHttpProxy = "targetHttpProxy-1944074187";
   *   TargetHttpProxy response = targetHttpProxiesClient.get(project, targetHttpProxy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpProxy Name of the TargetHttpProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetHttpProxy get(String project, String targetHttpProxy) {
    GetTargetHttpProxyRequest request =
        GetTargetHttpProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpProxy(targetHttpProxy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetHttpProxy resource. Gets a list of available target HTTP proxies by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   GetTargetHttpProxyRequest request =
   *       GetTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setTargetHttpProxy("targetHttpProxy-1944074187")
   *           .build();
   *   TargetHttpProxy response = targetHttpProxiesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetHttpProxy get(GetTargetHttpProxyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetHttpProxy resource. Gets a list of available target HTTP proxies by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   GetTargetHttpProxyRequest request =
   *       GetTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setTargetHttpProxy("targetHttpProxy-1944074187")
   *           .build();
   *   ApiFuture<TargetHttpProxy> future = targetHttpProxiesClient.getCallable().futureCall(request);
   *   // Do something.
   *   TargetHttpProxy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTargetHttpProxyRequest, TargetHttpProxy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetHttpProxy resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   String project = "project-309310695";
   *   TargetHttpProxy targetHttpProxyResource = TargetHttpProxy.newBuilder().build();
   *   Operation response =
   *       targetHttpProxiesClient.insertAsync(project, targetHttpProxyResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, TargetHttpProxy targetHttpProxyResource) {
    InsertTargetHttpProxyRequest request =
        InsertTargetHttpProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpProxyResource(targetHttpProxyResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetHttpProxy resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   InsertTargetHttpProxyRequest request =
   *       InsertTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpProxyResource(TargetHttpProxy.newBuilder().build())
   *           .build();
   *   Operation response = targetHttpProxiesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertTargetHttpProxyRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetHttpProxy resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   InsertTargetHttpProxyRequest request =
   *       InsertTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpProxyResource(TargetHttpProxy.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetHttpProxiesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertTargetHttpProxyRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetHttpProxy resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   InsertTargetHttpProxyRequest request =
   *       InsertTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpProxyResource(TargetHttpProxy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetHttpProxiesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertTargetHttpProxyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetHttpProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   String project = "project-309310695";
   *   for (TargetHttpProxy element : targetHttpProxiesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListTargetHttpProxiesRequest request =
        ListTargetHttpProxiesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetHttpProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   ListTargetHttpProxiesRequest request =
   *       ListTargetHttpProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (TargetHttpProxy element : targetHttpProxiesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListTargetHttpProxiesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetHttpProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   ListTargetHttpProxiesRequest request =
   *       ListTargetHttpProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<TargetHttpProxy> future =
   *       targetHttpProxiesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TargetHttpProxy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTargetHttpProxiesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetHttpProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   ListTargetHttpProxiesRequest request =
   *       ListTargetHttpProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     TargetHttpProxyList response = targetHttpProxiesClient.listCallable().call(request);
   *     for (TargetHttpProxy element : response.getItemsList()) {
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
  public final UnaryCallable<ListTargetHttpProxiesRequest, TargetHttpProxyList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified TargetHttpProxy resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetHttpProxy = "targetHttpProxy-1944074187";
   *   TargetHttpProxy targetHttpProxyResource = TargetHttpProxy.newBuilder().build();
   *   Operation response =
   *       targetHttpProxiesClient
   *           .patchAsync(project, targetHttpProxy, targetHttpProxyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpProxy Name of the TargetHttpProxy resource to patch.
   * @param targetHttpProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String targetHttpProxy, TargetHttpProxy targetHttpProxyResource) {
    PatchTargetHttpProxyRequest request =
        PatchTargetHttpProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpProxy(targetHttpProxy)
            .setTargetHttpProxyResource(targetHttpProxyResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified TargetHttpProxy resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   PatchTargetHttpProxyRequest request =
   *       PatchTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpProxy("targetHttpProxy-1944074187")
   *           .setTargetHttpProxyResource(TargetHttpProxy.newBuilder().build())
   *           .build();
   *   Operation response = targetHttpProxiesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchTargetHttpProxyRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified TargetHttpProxy resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   PatchTargetHttpProxyRequest request =
   *       PatchTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpProxy("targetHttpProxy-1944074187")
   *           .setTargetHttpProxyResource(TargetHttpProxy.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetHttpProxiesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchTargetHttpProxyRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified TargetHttpProxy resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   PatchTargetHttpProxyRequest request =
   *       PatchTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpProxy("targetHttpProxy-1944074187")
   *           .setTargetHttpProxyResource(TargetHttpProxy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetHttpProxiesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchTargetHttpProxyRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the URL map for TargetHttpProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetHttpProxy = "targetHttpProxy-1944074187";
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   Operation response =
   *       targetHttpProxiesClient
   *           .setUrlMapAsync(project, targetHttpProxy, urlMapReferenceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpProxy Name of the TargetHttpProxy to set a URL map for.
   * @param urlMapReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setUrlMapAsync(
      String project, String targetHttpProxy, UrlMapReference urlMapReferenceResource) {
    SetUrlMapTargetHttpProxyRequest request =
        SetUrlMapTargetHttpProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpProxy(targetHttpProxy)
            .setUrlMapReferenceResource(urlMapReferenceResource)
            .build();
    return setUrlMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the URL map for TargetHttpProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   SetUrlMapTargetHttpProxyRequest request =
   *       SetUrlMapTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpProxy("targetHttpProxy-1944074187")
   *           .setUrlMapReferenceResource(UrlMapReference.newBuilder().build())
   *           .build();
   *   Operation response = targetHttpProxiesClient.setUrlMapAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setUrlMapAsync(
      SetUrlMapTargetHttpProxyRequest request) {
    return setUrlMapOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the URL map for TargetHttpProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   SetUrlMapTargetHttpProxyRequest request =
   *       SetUrlMapTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpProxy("targetHttpProxy-1944074187")
   *           .setUrlMapReferenceResource(UrlMapReference.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetHttpProxiesClient.setUrlMapOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetUrlMapTargetHttpProxyRequest, Operation, Operation>
      setUrlMapOperationCallable() {
    return stub.setUrlMapOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the URL map for TargetHttpProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
   *   SetUrlMapTargetHttpProxyRequest request =
   *       SetUrlMapTargetHttpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpProxy("targetHttpProxy-1944074187")
   *           .setUrlMapReferenceResource(UrlMapReference.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetHttpProxiesClient.setUrlMapCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetUrlMapTargetHttpProxyRequest, Operation> setUrlMapCallable() {
    return stub.setUrlMapCallable();
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListTargetHttpProxiesRequest,
          TargetHttpProxyAggregatedList,
          Map.Entry<String, TargetHttpProxiesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListTargetHttpProxiesRequest,
                TargetHttpProxyAggregatedList,
                Map.Entry<String, TargetHttpProxiesScopedList>>
            context,
        ApiFuture<TargetHttpProxyAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregatedListPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListTargetHttpProxiesRequest,
          TargetHttpProxyAggregatedList,
          Map.Entry<String, TargetHttpProxiesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListTargetHttpProxiesRequest,
                TargetHttpProxyAggregatedList,
                Map.Entry<String, TargetHttpProxiesScopedList>>
            context,
        TargetHttpProxyAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListTargetHttpProxiesRequest,
                TargetHttpProxyAggregatedList,
                Map.Entry<String, TargetHttpProxiesScopedList>>
            context,
        TargetHttpProxyAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListTargetHttpProxiesRequest,
                TargetHttpProxyAggregatedList,
                Map.Entry<String, TargetHttpProxiesScopedList>>
            context,
        ApiFuture<TargetHttpProxyAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListTargetHttpProxiesRequest,
          TargetHttpProxyAggregatedList,
          Map.Entry<String, TargetHttpProxiesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    private AggregatedListFixedSizeCollection(List<AggregatedListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListFixedSizeCollection createEmptyCollection() {
      return new AggregatedListFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListFixedSizeCollection createCollection(
        List<AggregatedListPage> pages, int collectionSize) {
      return new AggregatedListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListTargetHttpProxiesRequest,
          TargetHttpProxyList,
          TargetHttpProxy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListTargetHttpProxiesRequest, TargetHttpProxyList, TargetHttpProxy> context,
        ApiFuture<TargetHttpProxyList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListTargetHttpProxiesRequest, TargetHttpProxyList, TargetHttpProxy, ListPage> {

    private ListPage(
        PageContext<ListTargetHttpProxiesRequest, TargetHttpProxyList, TargetHttpProxy> context,
        TargetHttpProxyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListTargetHttpProxiesRequest, TargetHttpProxyList, TargetHttpProxy> context,
        TargetHttpProxyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListTargetHttpProxiesRequest, TargetHttpProxyList, TargetHttpProxy> context,
        ApiFuture<TargetHttpProxyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetHttpProxiesRequest,
          TargetHttpProxyList,
          TargetHttpProxy,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}

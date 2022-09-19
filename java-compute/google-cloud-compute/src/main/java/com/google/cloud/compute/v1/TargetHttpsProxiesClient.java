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
import com.google.cloud.compute.v1.stub.TargetHttpsProxiesStub;
import com.google.cloud.compute.v1.stub.TargetHttpsProxiesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The TargetHttpsProxies API.
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
 * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String targetHttpsProxy = "targetHttpsProxy833943732";
 *   TargetHttpsProxy response = targetHttpsProxiesClient.get(project, targetHttpsProxy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TargetHttpsProxiesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of TargetHttpsProxiesSettings to
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
 * TargetHttpsProxiesSettings targetHttpsProxiesSettings =
 *     TargetHttpsProxiesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetHttpsProxiesClient targetHttpsProxiesClient =
 *     TargetHttpsProxiesClient.create(targetHttpsProxiesSettings);
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
 * TargetHttpsProxiesSettings targetHttpsProxiesSettings =
 *     TargetHttpsProxiesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetHttpsProxiesClient targetHttpsProxiesClient =
 *     TargetHttpsProxiesClient.create(targetHttpsProxiesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TargetHttpsProxiesClient implements BackgroundResource {
  private final TargetHttpsProxiesSettings settings;
  private final TargetHttpsProxiesStub stub;

  /** Constructs an instance of TargetHttpsProxiesClient with default settings. */
  public static final TargetHttpsProxiesClient create() throws IOException {
    return create(TargetHttpsProxiesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetHttpsProxiesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetHttpsProxiesClient create(TargetHttpsProxiesSettings settings)
      throws IOException {
    return new TargetHttpsProxiesClient(settings);
  }

  /**
   * Constructs an instance of TargetHttpsProxiesClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(TargetHttpsProxiesSettings).
   */
  public static final TargetHttpsProxiesClient create(TargetHttpsProxiesStub stub) {
    return new TargetHttpsProxiesClient(stub);
  }

  /**
   * Constructs an instance of TargetHttpsProxiesClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TargetHttpsProxiesClient(TargetHttpsProxiesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetHttpsProxiesStubSettings) settings.getStubSettings()).createStub();
  }

  protected TargetHttpsProxiesClient(TargetHttpsProxiesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetHttpsProxiesSettings getSettings() {
    return settings;
  }

  public TargetHttpsProxiesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all TargetHttpsProxy resources, regional and global, available to the
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
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, TargetHttpsProxiesScopedList> element :
   *       targetHttpsProxiesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListTargetHttpsProxiesRequest request =
        AggregatedListTargetHttpsProxiesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all TargetHttpsProxy resources, regional and global, available to the
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
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   AggregatedListTargetHttpsProxiesRequest request =
   *       AggregatedListTargetHttpsProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, TargetHttpsProxiesScopedList> element :
   *       targetHttpsProxiesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListTargetHttpsProxiesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all TargetHttpsProxy resources, regional and global, available to the
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
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   AggregatedListTargetHttpsProxiesRequest request =
   *       AggregatedListTargetHttpsProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, TargetHttpsProxiesScopedList>> future =
   *       targetHttpsProxiesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, TargetHttpsProxiesScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListTargetHttpsProxiesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all TargetHttpsProxy resources, regional and global, available to the
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
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   AggregatedListTargetHttpsProxiesRequest request =
   *       AggregatedListTargetHttpsProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     TargetHttpsProxyAggregatedList response =
   *         targetHttpsProxiesClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, TargetHttpsProxiesScopedList> element : response.getItemsList()) {
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
  public final UnaryCallable<
          AggregatedListTargetHttpsProxiesRequest, TargetHttpsProxyAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetHttpsProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetHttpsProxy = "targetHttpsProxy833943732";
   *   Operation response = targetHttpsProxiesClient.deleteAsync(project, targetHttpsProxy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String targetHttpsProxy) {
    DeleteTargetHttpsProxyRequest request =
        DeleteTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpsProxy(targetHttpsProxy)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetHttpsProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   DeleteTargetHttpsProxyRequest request =
   *       DeleteTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   Operation response = targetHttpsProxiesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteTargetHttpsProxyRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetHttpsProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   DeleteTargetHttpsProxyRequest request =
   *       DeleteTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetHttpsProxiesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTargetHttpsProxyRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetHttpsProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   DeleteTargetHttpsProxyRequest request =
   *       DeleteTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   ApiFuture<Operation> future = targetHttpsProxiesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTargetHttpsProxyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetHttpsProxy resource. Gets a list of available target HTTPS proxies
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetHttpsProxy = "targetHttpsProxy833943732";
   *   TargetHttpsProxy response = targetHttpsProxiesClient.get(project, targetHttpsProxy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetHttpsProxy get(String project, String targetHttpsProxy) {
    GetTargetHttpsProxyRequest request =
        GetTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpsProxy(targetHttpsProxy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetHttpsProxy resource. Gets a list of available target HTTPS proxies
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   GetTargetHttpsProxyRequest request =
   *       GetTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   TargetHttpsProxy response = targetHttpsProxiesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetHttpsProxy get(GetTargetHttpsProxyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetHttpsProxy resource. Gets a list of available target HTTPS proxies
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   GetTargetHttpsProxyRequest request =
   *       GetTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   ApiFuture<TargetHttpsProxy> future =
   *       targetHttpsProxiesClient.getCallable().futureCall(request);
   *   // Do something.
   *   TargetHttpsProxy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTargetHttpsProxyRequest, TargetHttpsProxy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetHttpsProxy resource in the specified project using the data included in the
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
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   TargetHttpsProxy targetHttpsProxyResource = TargetHttpsProxy.newBuilder().build();
   *   Operation response =
   *       targetHttpsProxiesClient.insertAsync(project, targetHttpsProxyResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpsProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, TargetHttpsProxy targetHttpsProxyResource) {
    InsertTargetHttpsProxyRequest request =
        InsertTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpsProxyResource(targetHttpsProxyResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetHttpsProxy resource in the specified project using the data included in the
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
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   InsertTargetHttpsProxyRequest request =
   *       InsertTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxyResource(TargetHttpsProxy.newBuilder().build())
   *           .build();
   *   Operation response = targetHttpsProxiesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertTargetHttpsProxyRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetHttpsProxy resource in the specified project using the data included in the
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
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   InsertTargetHttpsProxyRequest request =
   *       InsertTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxyResource(TargetHttpsProxy.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetHttpsProxiesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertTargetHttpsProxyRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetHttpsProxy resource in the specified project using the data included in the
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
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   InsertTargetHttpsProxyRequest request =
   *       InsertTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxyResource(TargetHttpsProxy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetHttpsProxiesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertTargetHttpsProxyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   for (TargetHttpsProxy element : targetHttpsProxiesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListTargetHttpsProxiesRequest request =
        ListTargetHttpsProxiesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   ListTargetHttpsProxiesRequest request =
   *       ListTargetHttpsProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (TargetHttpsProxy element : targetHttpsProxiesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListTargetHttpsProxiesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   ListTargetHttpsProxiesRequest request =
   *       ListTargetHttpsProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<TargetHttpsProxy> future =
   *       targetHttpsProxiesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TargetHttpsProxy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTargetHttpsProxiesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   ListTargetHttpsProxiesRequest request =
   *       ListTargetHttpsProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     TargetHttpsProxyList response = targetHttpsProxiesClient.listCallable().call(request);
   *     for (TargetHttpsProxy element : response.getItemsList()) {
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
  public final UnaryCallable<ListTargetHttpsProxiesRequest, TargetHttpsProxyList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified TargetHttpsProxy resource with the data included in the request. This
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
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetHttpsProxy = "targetHttpsProxy833943732";
   *   TargetHttpsProxy targetHttpsProxyResource = TargetHttpsProxy.newBuilder().build();
   *   Operation response =
   *       targetHttpsProxiesClient
   *           .patchAsync(project, targetHttpsProxy, targetHttpsProxyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to patch.
   * @param targetHttpsProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String targetHttpsProxy, TargetHttpsProxy targetHttpsProxyResource) {
    PatchTargetHttpsProxyRequest request =
        PatchTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpsProxy(targetHttpsProxy)
            .setTargetHttpsProxyResource(targetHttpsProxyResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified TargetHttpsProxy resource with the data included in the request. This
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
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   PatchTargetHttpsProxyRequest request =
   *       PatchTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .setTargetHttpsProxyResource(TargetHttpsProxy.newBuilder().build())
   *           .build();
   *   Operation response = targetHttpsProxiesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchTargetHttpsProxyRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified TargetHttpsProxy resource with the data included in the request. This
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
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   PatchTargetHttpsProxyRequest request =
   *       PatchTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .setTargetHttpsProxyResource(TargetHttpsProxy.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetHttpsProxiesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchTargetHttpsProxyRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified TargetHttpsProxy resource with the data included in the request. This
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
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   PatchTargetHttpsProxyRequest request =
   *       PatchTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .setTargetHttpsProxyResource(TargetHttpsProxy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetHttpsProxiesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchTargetHttpsProxyRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the Certificate Map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetHttpsProxy = "targetHttpsProxy833943732";
   *   TargetHttpsProxiesSetCertificateMapRequest
   *       targetHttpsProxiesSetCertificateMapRequestResource =
   *           TargetHttpsProxiesSetCertificateMapRequest.newBuilder().build();
   *   Operation response =
   *       targetHttpsProxiesClient
   *           .setCertificateMapAsync(
   *               project, targetHttpsProxy, targetHttpsProxiesSetCertificateMapRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource whose CertificateMap is to be
   *     set. The name must be 1-63 characters long, and comply with RFC1035.
   * @param targetHttpsProxiesSetCertificateMapRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setCertificateMapAsync(
      String project,
      String targetHttpsProxy,
      TargetHttpsProxiesSetCertificateMapRequest
          targetHttpsProxiesSetCertificateMapRequestResource) {
    SetCertificateMapTargetHttpsProxyRequest request =
        SetCertificateMapTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpsProxy(targetHttpsProxy)
            .setTargetHttpsProxiesSetCertificateMapRequestResource(
                targetHttpsProxiesSetCertificateMapRequestResource)
            .build();
    return setCertificateMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the Certificate Map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetCertificateMapTargetHttpsProxyRequest request =
   *       SetCertificateMapTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxiesSetCertificateMapRequestResource(
   *               TargetHttpsProxiesSetCertificateMapRequest.newBuilder().build())
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   Operation response = targetHttpsProxiesClient.setCertificateMapAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setCertificateMapAsync(
      SetCertificateMapTargetHttpsProxyRequest request) {
    return setCertificateMapOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the Certificate Map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetCertificateMapTargetHttpsProxyRequest request =
   *       SetCertificateMapTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxiesSetCertificateMapRequestResource(
   *               TargetHttpsProxiesSetCertificateMapRequest.newBuilder().build())
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetHttpsProxiesClient.setCertificateMapOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetCertificateMapTargetHttpsProxyRequest, Operation, Operation>
      setCertificateMapOperationCallable() {
    return stub.setCertificateMapOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the Certificate Map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetCertificateMapTargetHttpsProxyRequest request =
   *       SetCertificateMapTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxiesSetCertificateMapRequestResource(
   *               TargetHttpsProxiesSetCertificateMapRequest.newBuilder().build())
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   ApiFuture<Operation> future =
   *       targetHttpsProxiesClient.setCertificateMapCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetCertificateMapTargetHttpsProxyRequest, Operation>
      setCertificateMapCallable() {
    return stub.setCertificateMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the QUIC override policy for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetHttpsProxy = "targetHttpsProxy833943732";
   *   TargetHttpsProxiesSetQuicOverrideRequest targetHttpsProxiesSetQuicOverrideRequestResource =
   *       TargetHttpsProxiesSetQuicOverrideRequest.newBuilder().build();
   *   Operation response =
   *       targetHttpsProxiesClient
   *           .setQuicOverrideAsync(
   *               project, targetHttpsProxy, targetHttpsProxiesSetQuicOverrideRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to set the QUIC override policy
   *     for. The name should conform to RFC1035.
   * @param targetHttpsProxiesSetQuicOverrideRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setQuicOverrideAsync(
      String project,
      String targetHttpsProxy,
      TargetHttpsProxiesSetQuicOverrideRequest targetHttpsProxiesSetQuicOverrideRequestResource) {
    SetQuicOverrideTargetHttpsProxyRequest request =
        SetQuicOverrideTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpsProxy(targetHttpsProxy)
            .setTargetHttpsProxiesSetQuicOverrideRequestResource(
                targetHttpsProxiesSetQuicOverrideRequestResource)
            .build();
    return setQuicOverrideAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the QUIC override policy for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetQuicOverrideTargetHttpsProxyRequest request =
   *       SetQuicOverrideTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxiesSetQuicOverrideRequestResource(
   *               TargetHttpsProxiesSetQuicOverrideRequest.newBuilder().build())
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   Operation response = targetHttpsProxiesClient.setQuicOverrideAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setQuicOverrideAsync(
      SetQuicOverrideTargetHttpsProxyRequest request) {
    return setQuicOverrideOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the QUIC override policy for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetQuicOverrideTargetHttpsProxyRequest request =
   *       SetQuicOverrideTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxiesSetQuicOverrideRequestResource(
   *               TargetHttpsProxiesSetQuicOverrideRequest.newBuilder().build())
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetHttpsProxiesClient.setQuicOverrideOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetQuicOverrideTargetHttpsProxyRequest, Operation, Operation>
      setQuicOverrideOperationCallable() {
    return stub.setQuicOverrideOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the QUIC override policy for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetQuicOverrideTargetHttpsProxyRequest request =
   *       SetQuicOverrideTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxiesSetQuicOverrideRequestResource(
   *               TargetHttpsProxiesSetQuicOverrideRequest.newBuilder().build())
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   ApiFuture<Operation> future =
   *       targetHttpsProxiesClient.setQuicOverrideCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetQuicOverrideTargetHttpsProxyRequest, Operation>
      setQuicOverrideCallable() {
    return stub.setQuicOverrideCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replaces SslCertificates for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetHttpsProxy = "targetHttpsProxy833943732";
   *   TargetHttpsProxiesSetSslCertificatesRequest
   *       targetHttpsProxiesSetSslCertificatesRequestResource =
   *           TargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build();
   *   Operation response =
   *       targetHttpsProxiesClient
   *           .setSslCertificatesAsync(
   *               project, targetHttpsProxy, targetHttpsProxiesSetSslCertificatesRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to set an SslCertificates
   *     resource for.
   * @param targetHttpsProxiesSetSslCertificatesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setSslCertificatesAsync(
      String project,
      String targetHttpsProxy,
      TargetHttpsProxiesSetSslCertificatesRequest
          targetHttpsProxiesSetSslCertificatesRequestResource) {
    SetSslCertificatesTargetHttpsProxyRequest request =
        SetSslCertificatesTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpsProxy(targetHttpsProxy)
            .setTargetHttpsProxiesSetSslCertificatesRequestResource(
                targetHttpsProxiesSetSslCertificatesRequestResource)
            .build();
    return setSslCertificatesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replaces SslCertificates for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetSslCertificatesTargetHttpsProxyRequest request =
   *       SetSslCertificatesTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxiesSetSslCertificatesRequestResource(
   *               TargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build())
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   Operation response = targetHttpsProxiesClient.setSslCertificatesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setSslCertificatesAsync(
      SetSslCertificatesTargetHttpsProxyRequest request) {
    return setSslCertificatesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replaces SslCertificates for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetSslCertificatesTargetHttpsProxyRequest request =
   *       SetSslCertificatesTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxiesSetSslCertificatesRequestResource(
   *               TargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build())
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetHttpsProxiesClient.setSslCertificatesOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetSslCertificatesTargetHttpsProxyRequest, Operation, Operation>
      setSslCertificatesOperationCallable() {
    return stub.setSslCertificatesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replaces SslCertificates for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetSslCertificatesTargetHttpsProxyRequest request =
   *       SetSslCertificatesTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxiesSetSslCertificatesRequestResource(
   *               TargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build())
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   ApiFuture<Operation> future =
   *       targetHttpsProxiesClient.setSslCertificatesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetSslCertificatesTargetHttpsProxyRequest, Operation>
      setSslCertificatesCallable() {
    return stub.setSslCertificatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the SSL policy for TargetHttpsProxy. The SSL policy specifies the server-side support for
   * SSL features. This affects connections between clients and the HTTPS proxy load balancer. They
   * do not affect the connection between the load balancer and the backends.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetHttpsProxy = "targetHttpsProxy833943732";
   *   SslPolicyReference sslPolicyReferenceResource = SslPolicyReference.newBuilder().build();
   *   Operation response =
   *       targetHttpsProxiesClient
   *           .setSslPolicyAsync(project, targetHttpsProxy, sslPolicyReferenceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource whose SSL policy is to be set.
   *     The name must be 1-63 characters long, and comply with RFC1035.
   * @param sslPolicyReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setSslPolicyAsync(
      String project, String targetHttpsProxy, SslPolicyReference sslPolicyReferenceResource) {
    SetSslPolicyTargetHttpsProxyRequest request =
        SetSslPolicyTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpsProxy(targetHttpsProxy)
            .setSslPolicyReferenceResource(sslPolicyReferenceResource)
            .build();
    return setSslPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the SSL policy for TargetHttpsProxy. The SSL policy specifies the server-side support for
   * SSL features. This affects connections between clients and the HTTPS proxy load balancer. They
   * do not affect the connection between the load balancer and the backends.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetSslPolicyTargetHttpsProxyRequest request =
   *       SetSslPolicyTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSslPolicyReferenceResource(SslPolicyReference.newBuilder().build())
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   Operation response = targetHttpsProxiesClient.setSslPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setSslPolicyAsync(
      SetSslPolicyTargetHttpsProxyRequest request) {
    return setSslPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the SSL policy for TargetHttpsProxy. The SSL policy specifies the server-side support for
   * SSL features. This affects connections between clients and the HTTPS proxy load balancer. They
   * do not affect the connection between the load balancer and the backends.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetSslPolicyTargetHttpsProxyRequest request =
   *       SetSslPolicyTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSslPolicyReferenceResource(SslPolicyReference.newBuilder().build())
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetHttpsProxiesClient.setSslPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetSslPolicyTargetHttpsProxyRequest, Operation, Operation>
      setSslPolicyOperationCallable() {
    return stub.setSslPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the SSL policy for TargetHttpsProxy. The SSL policy specifies the server-side support for
   * SSL features. This affects connections between clients and the HTTPS proxy load balancer. They
   * do not affect the connection between the load balancer and the backends.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetSslPolicyTargetHttpsProxyRequest request =
   *       SetSslPolicyTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSslPolicyReferenceResource(SslPolicyReference.newBuilder().build())
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   ApiFuture<Operation> future =
   *       targetHttpsProxiesClient.setSslPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetSslPolicyTargetHttpsProxyRequest, Operation>
      setSslPolicyCallable() {
    return stub.setSslPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the URL map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetHttpsProxy = "targetHttpsProxy833943732";
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   Operation response =
   *       targetHttpsProxiesClient
   *           .setUrlMapAsync(project, targetHttpsProxy, urlMapReferenceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource whose URL map is to be set.
   * @param urlMapReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setUrlMapAsync(
      String project, String targetHttpsProxy, UrlMapReference urlMapReferenceResource) {
    SetUrlMapTargetHttpsProxyRequest request =
        SetUrlMapTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setTargetHttpsProxy(targetHttpsProxy)
            .setUrlMapReferenceResource(urlMapReferenceResource)
            .build();
    return setUrlMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the URL map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetUrlMapTargetHttpsProxyRequest request =
   *       SetUrlMapTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .setUrlMapReferenceResource(UrlMapReference.newBuilder().build())
   *           .build();
   *   Operation response = targetHttpsProxiesClient.setUrlMapAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setUrlMapAsync(
      SetUrlMapTargetHttpsProxyRequest request) {
    return setUrlMapOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the URL map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetUrlMapTargetHttpsProxyRequest request =
   *       SetUrlMapTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .setUrlMapReferenceResource(UrlMapReference.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetHttpsProxiesClient.setUrlMapOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetUrlMapTargetHttpsProxyRequest, Operation, Operation>
      setUrlMapOperationCallable() {
    return stub.setUrlMapOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the URL map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
   *   SetUrlMapTargetHttpsProxyRequest request =
   *       SetUrlMapTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .setUrlMapReferenceResource(UrlMapReference.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       targetHttpsProxiesClient.setUrlMapCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetUrlMapTargetHttpsProxyRequest, Operation> setUrlMapCallable() {
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
          AggregatedListTargetHttpsProxiesRequest,
          TargetHttpsProxyAggregatedList,
          Map.Entry<String, TargetHttpsProxiesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListTargetHttpsProxiesRequest,
                TargetHttpsProxyAggregatedList,
                Map.Entry<String, TargetHttpsProxiesScopedList>>
            context,
        ApiFuture<TargetHttpsProxyAggregatedList> futureResponse) {
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
          AggregatedListTargetHttpsProxiesRequest,
          TargetHttpsProxyAggregatedList,
          Map.Entry<String, TargetHttpsProxiesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListTargetHttpsProxiesRequest,
                TargetHttpsProxyAggregatedList,
                Map.Entry<String, TargetHttpsProxiesScopedList>>
            context,
        TargetHttpsProxyAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListTargetHttpsProxiesRequest,
                TargetHttpsProxyAggregatedList,
                Map.Entry<String, TargetHttpsProxiesScopedList>>
            context,
        TargetHttpsProxyAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListTargetHttpsProxiesRequest,
                TargetHttpsProxyAggregatedList,
                Map.Entry<String, TargetHttpsProxiesScopedList>>
            context,
        ApiFuture<TargetHttpsProxyAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListTargetHttpsProxiesRequest,
          TargetHttpsProxyAggregatedList,
          Map.Entry<String, TargetHttpsProxiesScopedList>,
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
          ListTargetHttpsProxiesRequest,
          TargetHttpsProxyList,
          TargetHttpsProxy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy> context,
        ApiFuture<TargetHttpsProxyList> futureResponse) {
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
          ListTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy, ListPage> {

    private ListPage(
        PageContext<ListTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy> context,
        TargetHttpsProxyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy> context,
        TargetHttpsProxyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy> context,
        ApiFuture<TargetHttpsProxyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetHttpsProxiesRequest,
          TargetHttpsProxyList,
          TargetHttpsProxy,
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

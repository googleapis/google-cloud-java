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
import com.google.cloud.compute.v1.stub.TargetGrpcProxiesStub;
import com.google.cloud.compute.v1.stub.TargetGrpcProxiesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The TargetGrpcProxies API.
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
 * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String targetGrpcProxy = "targetGrpcProxy1045500511";
 *   TargetGrpcProxy response = targetGrpcProxiesClient.get(project, targetGrpcProxy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TargetGrpcProxiesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of TargetGrpcProxiesSettings to
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
 * TargetGrpcProxiesSettings targetGrpcProxiesSettings =
 *     TargetGrpcProxiesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetGrpcProxiesClient targetGrpcProxiesClient =
 *     TargetGrpcProxiesClient.create(targetGrpcProxiesSettings);
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
 * TargetGrpcProxiesSettings targetGrpcProxiesSettings =
 *     TargetGrpcProxiesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetGrpcProxiesClient targetGrpcProxiesClient =
 *     TargetGrpcProxiesClient.create(targetGrpcProxiesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TargetGrpcProxiesClient implements BackgroundResource {
  private final TargetGrpcProxiesSettings settings;
  private final TargetGrpcProxiesStub stub;

  /** Constructs an instance of TargetGrpcProxiesClient with default settings. */
  public static final TargetGrpcProxiesClient create() throws IOException {
    return create(TargetGrpcProxiesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetGrpcProxiesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetGrpcProxiesClient create(TargetGrpcProxiesSettings settings)
      throws IOException {
    return new TargetGrpcProxiesClient(settings);
  }

  /**
   * Constructs an instance of TargetGrpcProxiesClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(TargetGrpcProxiesSettings).
   */
  public static final TargetGrpcProxiesClient create(TargetGrpcProxiesStub stub) {
    return new TargetGrpcProxiesClient(stub);
  }

  /**
   * Constructs an instance of TargetGrpcProxiesClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TargetGrpcProxiesClient(TargetGrpcProxiesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetGrpcProxiesStubSettings) settings.getStubSettings()).createStub();
  }

  protected TargetGrpcProxiesClient(TargetGrpcProxiesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetGrpcProxiesSettings getSettings() {
    return settings;
  }

  public TargetGrpcProxiesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetGrpcProxy in the given scope
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetGrpcProxy = "targetGrpcProxy1045500511";
   *   Operation response = targetGrpcProxiesClient.deleteAsync(project, targetGrpcProxy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetGrpcProxy Name of the TargetGrpcProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String targetGrpcProxy) {
    DeleteTargetGrpcProxyRequest request =
        DeleteTargetGrpcProxyRequest.newBuilder()
            .setProject(project)
            .setTargetGrpcProxy(targetGrpcProxy)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetGrpcProxy in the given scope
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   DeleteTargetGrpcProxyRequest request =
   *       DeleteTargetGrpcProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetGrpcProxy("targetGrpcProxy1045500511")
   *           .build();
   *   Operation response = targetGrpcProxiesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteTargetGrpcProxyRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetGrpcProxy in the given scope
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   DeleteTargetGrpcProxyRequest request =
   *       DeleteTargetGrpcProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetGrpcProxy("targetGrpcProxy1045500511")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetGrpcProxiesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTargetGrpcProxyRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetGrpcProxy in the given scope
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   DeleteTargetGrpcProxyRequest request =
   *       DeleteTargetGrpcProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetGrpcProxy("targetGrpcProxy1045500511")
   *           .build();
   *   ApiFuture<Operation> future = targetGrpcProxiesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTargetGrpcProxyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetGrpcProxy resource in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetGrpcProxy = "targetGrpcProxy1045500511";
   *   TargetGrpcProxy response = targetGrpcProxiesClient.get(project, targetGrpcProxy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetGrpcProxy Name of the TargetGrpcProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetGrpcProxy get(String project, String targetGrpcProxy) {
    GetTargetGrpcProxyRequest request =
        GetTargetGrpcProxyRequest.newBuilder()
            .setProject(project)
            .setTargetGrpcProxy(targetGrpcProxy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetGrpcProxy resource in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   GetTargetGrpcProxyRequest request =
   *       GetTargetGrpcProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setTargetGrpcProxy("targetGrpcProxy1045500511")
   *           .build();
   *   TargetGrpcProxy response = targetGrpcProxiesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetGrpcProxy get(GetTargetGrpcProxyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetGrpcProxy resource in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   GetTargetGrpcProxyRequest request =
   *       GetTargetGrpcProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setTargetGrpcProxy("targetGrpcProxy1045500511")
   *           .build();
   *   ApiFuture<TargetGrpcProxy> future = targetGrpcProxiesClient.getCallable().futureCall(request);
   *   // Do something.
   *   TargetGrpcProxy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTargetGrpcProxyRequest, TargetGrpcProxy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetGrpcProxy in the specified project in the given scope using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "project-309310695";
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   Operation response =
   *       targetGrpcProxiesClient.insertAsync(project, targetGrpcProxyResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetGrpcProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, TargetGrpcProxy targetGrpcProxyResource) {
    InsertTargetGrpcProxyRequest request =
        InsertTargetGrpcProxyRequest.newBuilder()
            .setProject(project)
            .setTargetGrpcProxyResource(targetGrpcProxyResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetGrpcProxy in the specified project in the given scope using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   InsertTargetGrpcProxyRequest request =
   *       InsertTargetGrpcProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetGrpcProxyResource(TargetGrpcProxy.newBuilder().build())
   *           .build();
   *   Operation response = targetGrpcProxiesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertTargetGrpcProxyRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetGrpcProxy in the specified project in the given scope using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   InsertTargetGrpcProxyRequest request =
   *       InsertTargetGrpcProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetGrpcProxyResource(TargetGrpcProxy.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetGrpcProxiesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertTargetGrpcProxyRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetGrpcProxy in the specified project in the given scope using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   InsertTargetGrpcProxyRequest request =
   *       InsertTargetGrpcProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetGrpcProxyResource(TargetGrpcProxy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetGrpcProxiesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertTargetGrpcProxyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the TargetGrpcProxies for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "project-309310695";
   *   for (TargetGrpcProxy element : targetGrpcProxiesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListTargetGrpcProxiesRequest request =
        ListTargetGrpcProxiesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the TargetGrpcProxies for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   ListTargetGrpcProxiesRequest request =
   *       ListTargetGrpcProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (TargetGrpcProxy element : targetGrpcProxiesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListTargetGrpcProxiesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the TargetGrpcProxies for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   ListTargetGrpcProxiesRequest request =
   *       ListTargetGrpcProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<TargetGrpcProxy> future =
   *       targetGrpcProxiesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TargetGrpcProxy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTargetGrpcProxiesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the TargetGrpcProxies for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   ListTargetGrpcProxiesRequest request =
   *       ListTargetGrpcProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     TargetGrpcProxyList response = targetGrpcProxiesClient.listCallable().call(request);
   *     for (TargetGrpcProxy element : response.getItemsList()) {
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
  public final UnaryCallable<ListTargetGrpcProxiesRequest, TargetGrpcProxyList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified TargetGrpcProxy resource with the data included in the request. This
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
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetGrpcProxy = "targetGrpcProxy1045500511";
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   Operation response =
   *       targetGrpcProxiesClient
   *           .patchAsync(project, targetGrpcProxy, targetGrpcProxyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetGrpcProxy Name of the TargetGrpcProxy resource to patch.
   * @param targetGrpcProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String targetGrpcProxy, TargetGrpcProxy targetGrpcProxyResource) {
    PatchTargetGrpcProxyRequest request =
        PatchTargetGrpcProxyRequest.newBuilder()
            .setProject(project)
            .setTargetGrpcProxy(targetGrpcProxy)
            .setTargetGrpcProxyResource(targetGrpcProxyResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified TargetGrpcProxy resource with the data included in the request. This
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
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   PatchTargetGrpcProxyRequest request =
   *       PatchTargetGrpcProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetGrpcProxy("targetGrpcProxy1045500511")
   *           .setTargetGrpcProxyResource(TargetGrpcProxy.newBuilder().build())
   *           .build();
   *   Operation response = targetGrpcProxiesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchTargetGrpcProxyRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified TargetGrpcProxy resource with the data included in the request. This
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
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   PatchTargetGrpcProxyRequest request =
   *       PatchTargetGrpcProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetGrpcProxy("targetGrpcProxy1045500511")
   *           .setTargetGrpcProxyResource(TargetGrpcProxy.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetGrpcProxiesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchTargetGrpcProxyRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified TargetGrpcProxy resource with the data included in the request. This
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
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   PatchTargetGrpcProxyRequest request =
   *       PatchTargetGrpcProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetGrpcProxy("targetGrpcProxy1045500511")
   *           .setTargetGrpcProxyResource(TargetGrpcProxy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetGrpcProxiesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchTargetGrpcProxyRequest, Operation> patchCallable() {
    return stub.patchCallable();
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListTargetGrpcProxiesRequest,
          TargetGrpcProxyList,
          TargetGrpcProxy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListTargetGrpcProxiesRequest, TargetGrpcProxyList, TargetGrpcProxy> context,
        ApiFuture<TargetGrpcProxyList> futureResponse) {
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
          ListTargetGrpcProxiesRequest, TargetGrpcProxyList, TargetGrpcProxy, ListPage> {

    private ListPage(
        PageContext<ListTargetGrpcProxiesRequest, TargetGrpcProxyList, TargetGrpcProxy> context,
        TargetGrpcProxyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListTargetGrpcProxiesRequest, TargetGrpcProxyList, TargetGrpcProxy> context,
        TargetGrpcProxyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListTargetGrpcProxiesRequest, TargetGrpcProxyList, TargetGrpcProxy> context,
        ApiFuture<TargetGrpcProxyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetGrpcProxiesRequest,
          TargetGrpcProxyList,
          TargetGrpcProxy,
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

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
import com.google.cloud.compute.v1.stub.TargetSslProxiesStub;
import com.google.cloud.compute.v1.stub.TargetSslProxiesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The TargetSslProxies API.
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
 * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String targetSslProxy = "targetSslProxy-879314829";
 *   TargetSslProxy response = targetSslProxiesClient.get(project, targetSslProxy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TargetSslProxiesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of TargetSslProxiesSettings to
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
 * TargetSslProxiesSettings targetSslProxiesSettings =
 *     TargetSslProxiesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetSslProxiesClient targetSslProxiesClient =
 *     TargetSslProxiesClient.create(targetSslProxiesSettings);
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
 * TargetSslProxiesSettings targetSslProxiesSettings =
 *     TargetSslProxiesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetSslProxiesClient targetSslProxiesClient =
 *     TargetSslProxiesClient.create(targetSslProxiesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TargetSslProxiesClient implements BackgroundResource {
  private final TargetSslProxiesSettings settings;
  private final TargetSslProxiesStub stub;

  /** Constructs an instance of TargetSslProxiesClient with default settings. */
  public static final TargetSslProxiesClient create() throws IOException {
    return create(TargetSslProxiesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetSslProxiesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetSslProxiesClient create(TargetSslProxiesSettings settings)
      throws IOException {
    return new TargetSslProxiesClient(settings);
  }

  /**
   * Constructs an instance of TargetSslProxiesClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(TargetSslProxiesSettings).
   */
  public static final TargetSslProxiesClient create(TargetSslProxiesStub stub) {
    return new TargetSslProxiesClient(stub);
  }

  /**
   * Constructs an instance of TargetSslProxiesClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TargetSslProxiesClient(TargetSslProxiesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetSslProxiesStubSettings) settings.getStubSettings()).createStub();
  }

  protected TargetSslProxiesClient(TargetSslProxiesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetSslProxiesSettings getSettings() {
    return settings;
  }

  public TargetSslProxiesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetSslProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetSslProxy = "targetSslProxy-879314829";
   *   Operation response = targetSslProxiesClient.deleteAsync(project, targetSslProxy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxy Name of the TargetSslProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String targetSslProxy) {
    DeleteTargetSslProxyRequest request =
        DeleteTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxy(targetSslProxy)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetSslProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   DeleteTargetSslProxyRequest request =
   *       DeleteTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   Operation response = targetSslProxiesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteTargetSslProxyRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetSslProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   DeleteTargetSslProxyRequest request =
   *       DeleteTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetSslProxiesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTargetSslProxyRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetSslProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   DeleteTargetSslProxyRequest request =
   *       DeleteTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   ApiFuture<Operation> future = targetSslProxiesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTargetSslProxyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetSslProxy resource. Gets a list of available target SSL proxies by
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
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetSslProxy = "targetSslProxy-879314829";
   *   TargetSslProxy response = targetSslProxiesClient.get(project, targetSslProxy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxy Name of the TargetSslProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetSslProxy get(String project, String targetSslProxy) {
    GetTargetSslProxyRequest request =
        GetTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxy(targetSslProxy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetSslProxy resource. Gets a list of available target SSL proxies by
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
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   GetTargetSslProxyRequest request =
   *       GetTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   TargetSslProxy response = targetSslProxiesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetSslProxy get(GetTargetSslProxyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetSslProxy resource. Gets a list of available target SSL proxies by
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
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   GetTargetSslProxyRequest request =
   *       GetTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   ApiFuture<TargetSslProxy> future = targetSslProxiesClient.getCallable().futureCall(request);
   *   // Do something.
   *   TargetSslProxy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTargetSslProxyRequest, TargetSslProxy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetSslProxy resource in the specified project using the data included in the
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
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "project-309310695";
   *   TargetSslProxy targetSslProxyResource = TargetSslProxy.newBuilder().build();
   *   Operation response =
   *       targetSslProxiesClient.insertAsync(project, targetSslProxyResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, TargetSslProxy targetSslProxyResource) {
    InsertTargetSslProxyRequest request =
        InsertTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxyResource(targetSslProxyResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetSslProxy resource in the specified project using the data included in the
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
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   InsertTargetSslProxyRequest request =
   *       InsertTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxyResource(TargetSslProxy.newBuilder().build())
   *           .build();
   *   Operation response = targetSslProxiesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertTargetSslProxyRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetSslProxy resource in the specified project using the data included in the
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
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   InsertTargetSslProxyRequest request =
   *       InsertTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxyResource(TargetSslProxy.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetSslProxiesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertTargetSslProxyRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetSslProxy resource in the specified project using the data included in the
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
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   InsertTargetSslProxyRequest request =
   *       InsertTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxyResource(TargetSslProxy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetSslProxiesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertTargetSslProxyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetSslProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "project-309310695";
   *   for (TargetSslProxy element : targetSslProxiesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListTargetSslProxiesRequest request =
        ListTargetSslProxiesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetSslProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   ListTargetSslProxiesRequest request =
   *       ListTargetSslProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (TargetSslProxy element : targetSslProxiesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListTargetSslProxiesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetSslProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   ListTargetSslProxiesRequest request =
   *       ListTargetSslProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<TargetSslProxy> future =
   *       targetSslProxiesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TargetSslProxy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTargetSslProxiesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetSslProxy resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   ListTargetSslProxiesRequest request =
   *       ListTargetSslProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     TargetSslProxyList response = targetSslProxiesClient.listCallable().call(request);
   *     for (TargetSslProxy element : response.getItemsList()) {
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
  public final UnaryCallable<ListTargetSslProxiesRequest, TargetSslProxyList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the BackendService for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetSslProxy = "targetSslProxy-879314829";
   *   TargetSslProxiesSetBackendServiceRequest targetSslProxiesSetBackendServiceRequestResource =
   *       TargetSslProxiesSetBackendServiceRequest.newBuilder().build();
   *   Operation response =
   *       targetSslProxiesClient
   *           .setBackendServiceAsync(
   *               project, targetSslProxy, targetSslProxiesSetBackendServiceRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxy Name of the TargetSslProxy resource whose BackendService resource is to
   *     be set.
   * @param targetSslProxiesSetBackendServiceRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setBackendServiceAsync(
      String project,
      String targetSslProxy,
      TargetSslProxiesSetBackendServiceRequest targetSslProxiesSetBackendServiceRequestResource) {
    SetBackendServiceTargetSslProxyRequest request =
        SetBackendServiceTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxy(targetSslProxy)
            .setTargetSslProxiesSetBackendServiceRequestResource(
                targetSslProxiesSetBackendServiceRequestResource)
            .build();
    return setBackendServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the BackendService for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetBackendServiceTargetSslProxyRequest request =
   *       SetBackendServiceTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxiesSetBackendServiceRequestResource(
   *               TargetSslProxiesSetBackendServiceRequest.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   Operation response = targetSslProxiesClient.setBackendServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setBackendServiceAsync(
      SetBackendServiceTargetSslProxyRequest request) {
    return setBackendServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the BackendService for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetBackendServiceTargetSslProxyRequest request =
   *       SetBackendServiceTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxiesSetBackendServiceRequestResource(
   *               TargetSslProxiesSetBackendServiceRequest.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetSslProxiesClient.setBackendServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetBackendServiceTargetSslProxyRequest, Operation, Operation>
      setBackendServiceOperationCallable() {
    return stub.setBackendServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the BackendService for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetBackendServiceTargetSslProxyRequest request =
   *       SetBackendServiceTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxiesSetBackendServiceRequestResource(
   *               TargetSslProxiesSetBackendServiceRequest.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   ApiFuture<Operation> future =
   *       targetSslProxiesClient.setBackendServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetBackendServiceTargetSslProxyRequest, Operation>
      setBackendServiceCallable() {
    return stub.setBackendServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the Certificate Map for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetSslProxy = "targetSslProxy-879314829";
   *   TargetSslProxiesSetCertificateMapRequest targetSslProxiesSetCertificateMapRequestResource =
   *       TargetSslProxiesSetCertificateMapRequest.newBuilder().build();
   *   Operation response =
   *       targetSslProxiesClient
   *           .setCertificateMapAsync(
   *               project, targetSslProxy, targetSslProxiesSetCertificateMapRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxy Name of the TargetSslProxy resource whose CertificateMap is to be set.
   *     The name must be 1-63 characters long, and comply with RFC1035.
   * @param targetSslProxiesSetCertificateMapRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setCertificateMapAsync(
      String project,
      String targetSslProxy,
      TargetSslProxiesSetCertificateMapRequest targetSslProxiesSetCertificateMapRequestResource) {
    SetCertificateMapTargetSslProxyRequest request =
        SetCertificateMapTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxy(targetSslProxy)
            .setTargetSslProxiesSetCertificateMapRequestResource(
                targetSslProxiesSetCertificateMapRequestResource)
            .build();
    return setCertificateMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the Certificate Map for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetCertificateMapTargetSslProxyRequest request =
   *       SetCertificateMapTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxiesSetCertificateMapRequestResource(
   *               TargetSslProxiesSetCertificateMapRequest.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   Operation response = targetSslProxiesClient.setCertificateMapAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setCertificateMapAsync(
      SetCertificateMapTargetSslProxyRequest request) {
    return setCertificateMapOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the Certificate Map for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetCertificateMapTargetSslProxyRequest request =
   *       SetCertificateMapTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxiesSetCertificateMapRequestResource(
   *               TargetSslProxiesSetCertificateMapRequest.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetSslProxiesClient.setCertificateMapOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetCertificateMapTargetSslProxyRequest, Operation, Operation>
      setCertificateMapOperationCallable() {
    return stub.setCertificateMapOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the Certificate Map for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetCertificateMapTargetSslProxyRequest request =
   *       SetCertificateMapTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxiesSetCertificateMapRequestResource(
   *               TargetSslProxiesSetCertificateMapRequest.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   ApiFuture<Operation> future =
   *       targetSslProxiesClient.setCertificateMapCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetCertificateMapTargetSslProxyRequest, Operation>
      setCertificateMapCallable() {
    return stub.setCertificateMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the ProxyHeaderType for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetSslProxy = "targetSslProxy-879314829";
   *   TargetSslProxiesSetProxyHeaderRequest targetSslProxiesSetProxyHeaderRequestResource =
   *       TargetSslProxiesSetProxyHeaderRequest.newBuilder().build();
   *   Operation response =
   *       targetSslProxiesClient
   *           .setProxyHeaderAsync(
   *               project, targetSslProxy, targetSslProxiesSetProxyHeaderRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxy Name of the TargetSslProxy resource whose ProxyHeader is to be set.
   * @param targetSslProxiesSetProxyHeaderRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setProxyHeaderAsync(
      String project,
      String targetSslProxy,
      TargetSslProxiesSetProxyHeaderRequest targetSslProxiesSetProxyHeaderRequestResource) {
    SetProxyHeaderTargetSslProxyRequest request =
        SetProxyHeaderTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxy(targetSslProxy)
            .setTargetSslProxiesSetProxyHeaderRequestResource(
                targetSslProxiesSetProxyHeaderRequestResource)
            .build();
    return setProxyHeaderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the ProxyHeaderType for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetProxyHeaderTargetSslProxyRequest request =
   *       SetProxyHeaderTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxiesSetProxyHeaderRequestResource(
   *               TargetSslProxiesSetProxyHeaderRequest.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   Operation response = targetSslProxiesClient.setProxyHeaderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setProxyHeaderAsync(
      SetProxyHeaderTargetSslProxyRequest request) {
    return setProxyHeaderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the ProxyHeaderType for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetProxyHeaderTargetSslProxyRequest request =
   *       SetProxyHeaderTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxiesSetProxyHeaderRequestResource(
   *               TargetSslProxiesSetProxyHeaderRequest.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetSslProxiesClient.setProxyHeaderOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetProxyHeaderTargetSslProxyRequest, Operation, Operation>
      setProxyHeaderOperationCallable() {
    return stub.setProxyHeaderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the ProxyHeaderType for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetProxyHeaderTargetSslProxyRequest request =
   *       SetProxyHeaderTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxiesSetProxyHeaderRequestResource(
   *               TargetSslProxiesSetProxyHeaderRequest.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   ApiFuture<Operation> future =
   *       targetSslProxiesClient.setProxyHeaderCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetProxyHeaderTargetSslProxyRequest, Operation>
      setProxyHeaderCallable() {
    return stub.setProxyHeaderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes SslCertificates for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetSslProxy = "targetSslProxy-879314829";
   *   TargetSslProxiesSetSslCertificatesRequest targetSslProxiesSetSslCertificatesRequestResource =
   *       TargetSslProxiesSetSslCertificatesRequest.newBuilder().build();
   *   Operation response =
   *       targetSslProxiesClient
   *           .setSslCertificatesAsync(
   *               project, targetSslProxy, targetSslProxiesSetSslCertificatesRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxy Name of the TargetSslProxy resource whose SslCertificate resource is to
   *     be set.
   * @param targetSslProxiesSetSslCertificatesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setSslCertificatesAsync(
      String project,
      String targetSslProxy,
      TargetSslProxiesSetSslCertificatesRequest targetSslProxiesSetSslCertificatesRequestResource) {
    SetSslCertificatesTargetSslProxyRequest request =
        SetSslCertificatesTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxy(targetSslProxy)
            .setTargetSslProxiesSetSslCertificatesRequestResource(
                targetSslProxiesSetSslCertificatesRequestResource)
            .build();
    return setSslCertificatesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes SslCertificates for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetSslCertificatesTargetSslProxyRequest request =
   *       SetSslCertificatesTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxiesSetSslCertificatesRequestResource(
   *               TargetSslProxiesSetSslCertificatesRequest.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   Operation response = targetSslProxiesClient.setSslCertificatesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setSslCertificatesAsync(
      SetSslCertificatesTargetSslProxyRequest request) {
    return setSslCertificatesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes SslCertificates for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetSslCertificatesTargetSslProxyRequest request =
   *       SetSslCertificatesTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxiesSetSslCertificatesRequestResource(
   *               TargetSslProxiesSetSslCertificatesRequest.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetSslProxiesClient.setSslCertificatesOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetSslCertificatesTargetSslProxyRequest, Operation, Operation>
      setSslCertificatesOperationCallable() {
    return stub.setSslCertificatesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes SslCertificates for TargetSslProxy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetSslCertificatesTargetSslProxyRequest request =
   *       SetSslCertificatesTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTargetSslProxiesSetSslCertificatesRequestResource(
   *               TargetSslProxiesSetSslCertificatesRequest.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   ApiFuture<Operation> future =
   *       targetSslProxiesClient.setSslCertificatesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetSslCertificatesTargetSslProxyRequest, Operation>
      setSslCertificatesCallable() {
    return stub.setSslCertificatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the SSL policy for TargetSslProxy. The SSL policy specifies the server-side support for
   * SSL features. This affects connections between clients and the SSL proxy load balancer. They do
   * not affect the connection between the load balancer and the backends.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String targetSslProxy = "targetSslProxy-879314829";
   *   SslPolicyReference sslPolicyReferenceResource = SslPolicyReference.newBuilder().build();
   *   Operation response =
   *       targetSslProxiesClient
   *           .setSslPolicyAsync(project, targetSslProxy, sslPolicyReferenceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param targetSslProxy Name of the TargetSslProxy resource whose SSL policy is to be set. The
   *     name must be 1-63 characters long, and comply with RFC1035.
   * @param sslPolicyReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setSslPolicyAsync(
      String project, String targetSslProxy, SslPolicyReference sslPolicyReferenceResource) {
    SetSslPolicyTargetSslProxyRequest request =
        SetSslPolicyTargetSslProxyRequest.newBuilder()
            .setProject(project)
            .setTargetSslProxy(targetSslProxy)
            .setSslPolicyReferenceResource(sslPolicyReferenceResource)
            .build();
    return setSslPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the SSL policy for TargetSslProxy. The SSL policy specifies the server-side support for
   * SSL features. This affects connections between clients and the SSL proxy load balancer. They do
   * not affect the connection between the load balancer and the backends.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetSslPolicyTargetSslProxyRequest request =
   *       SetSslPolicyTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSslPolicyReferenceResource(SslPolicyReference.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   Operation response = targetSslProxiesClient.setSslPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setSslPolicyAsync(
      SetSslPolicyTargetSslProxyRequest request) {
    return setSslPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the SSL policy for TargetSslProxy. The SSL policy specifies the server-side support for
   * SSL features. This affects connections between clients and the SSL proxy load balancer. They do
   * not affect the connection between the load balancer and the backends.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetSslPolicyTargetSslProxyRequest request =
   *       SetSslPolicyTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSslPolicyReferenceResource(SslPolicyReference.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetSslProxiesClient.setSslPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetSslPolicyTargetSslProxyRequest, Operation, Operation>
      setSslPolicyOperationCallable() {
    return stub.setSslPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the SSL policy for TargetSslProxy. The SSL policy specifies the server-side support for
   * SSL features. This affects connections between clients and the SSL proxy load balancer. They do
   * not affect the connection between the load balancer and the backends.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
   *   SetSslPolicyTargetSslProxyRequest request =
   *       SetSslPolicyTargetSslProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSslPolicyReferenceResource(SslPolicyReference.newBuilder().build())
   *           .setTargetSslProxy("targetSslProxy-879314829")
   *           .build();
   *   ApiFuture<Operation> future =
   *       targetSslProxiesClient.setSslPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetSslPolicyTargetSslProxyRequest, Operation> setSslPolicyCallable() {
    return stub.setSslPolicyCallable();
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
          ListTargetSslProxiesRequest,
          TargetSslProxyList,
          TargetSslProxy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListTargetSslProxiesRequest, TargetSslProxyList, TargetSslProxy> context,
        ApiFuture<TargetSslProxyList> futureResponse) {
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
          ListTargetSslProxiesRequest, TargetSslProxyList, TargetSslProxy, ListPage> {

    private ListPage(
        PageContext<ListTargetSslProxiesRequest, TargetSslProxyList, TargetSslProxy> context,
        TargetSslProxyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListTargetSslProxiesRequest, TargetSslProxyList, TargetSslProxy> context,
        TargetSslProxyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListTargetSslProxiesRequest, TargetSslProxyList, TargetSslProxy> context,
        ApiFuture<TargetSslProxyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetSslProxiesRequest,
          TargetSslProxyList,
          TargetSslProxy,
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

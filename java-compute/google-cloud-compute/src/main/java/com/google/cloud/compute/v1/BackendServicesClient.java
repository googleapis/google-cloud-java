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
import com.google.cloud.compute.v1.stub.BackendServicesStub;
import com.google.cloud.compute.v1.stub.BackendServicesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The BackendServices API.
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
 * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
 *   String project = "project-309310695";
 *   String backendService = "backendService-1884714623";
 *   BackendService response = backendServicesClient.get(project, backendService);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BackendServicesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of BackendServicesSettings to
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
 * BackendServicesSettings backendServicesSettings =
 *     BackendServicesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BackendServicesClient backendServicesClient =
 *     BackendServicesClient.create(backendServicesSettings);
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
 * BackendServicesSettings backendServicesSettings =
 *     BackendServicesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BackendServicesClient backendServicesClient =
 *     BackendServicesClient.create(backendServicesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BackendServicesClient implements BackgroundResource {
  private final BackendServicesSettings settings;
  private final BackendServicesStub stub;

  /** Constructs an instance of BackendServicesClient with default settings. */
  public static final BackendServicesClient create() throws IOException {
    return create(BackendServicesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BackendServicesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BackendServicesClient create(BackendServicesSettings settings)
      throws IOException {
    return new BackendServicesClient(settings);
  }

  /**
   * Constructs an instance of BackendServicesClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(BackendServicesSettings).
   */
  public static final BackendServicesClient create(BackendServicesStub stub) {
    return new BackendServicesClient(stub);
  }

  /**
   * Constructs an instance of BackendServicesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BackendServicesClient(BackendServicesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BackendServicesStubSettings) settings.getStubSettings()).createStub();
  }

  protected BackendServicesClient(BackendServicesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BackendServicesSettings getSettings() {
    return settings;
  }

  public BackendServicesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String backendService = "backendService-1884714623";
   *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
   *   Operation response =
   *       backendServicesClient
   *           .addSignedUrlKeyAsync(project, backendService, signedUrlKeyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to which the Signed URL Key should be
   *     added. The name should conform to RFC1035.
   * @param signedUrlKeyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addSignedUrlKeyAsync(
      String project, String backendService, SignedUrlKey signedUrlKeyResource) {
    AddSignedUrlKeyBackendServiceRequest request =
        AddSignedUrlKeyBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .setSignedUrlKeyResource(signedUrlKeyResource)
            .build();
    return addSignedUrlKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   AddSignedUrlKeyBackendServiceRequest request =
   *       AddSignedUrlKeyBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSignedUrlKeyResource(SignedUrlKey.newBuilder().build())
   *           .build();
   *   Operation response = backendServicesClient.addSignedUrlKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> addSignedUrlKeyAsync(
      AddSignedUrlKeyBackendServiceRequest request) {
    return addSignedUrlKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   AddSignedUrlKeyBackendServiceRequest request =
   *       AddSignedUrlKeyBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSignedUrlKeyResource(SignedUrlKey.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendServicesClient.addSignedUrlKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddSignedUrlKeyBackendServiceRequest, Operation, Operation>
      addSignedUrlKeyOperationCallable() {
    return stub.addSignedUrlKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   AddSignedUrlKeyBackendServiceRequest request =
   *       AddSignedUrlKeyBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSignedUrlKeyResource(SignedUrlKey.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       backendServicesClient.addSignedUrlKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddSignedUrlKeyBackendServiceRequest, Operation>
      addSignedUrlKeyCallable() {
    return stub.addSignedUrlKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all BackendService resources, regional and global, available to the
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
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, BackendServicesScopedList> element :
   *       backendServicesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListBackendServicesRequest request =
        AggregatedListBackendServicesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all BackendService resources, regional and global, available to the
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
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   AggregatedListBackendServicesRequest request =
   *       AggregatedListBackendServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, BackendServicesScopedList> element :
   *       backendServicesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListBackendServicesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all BackendService resources, regional and global, available to the
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
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   AggregatedListBackendServicesRequest request =
   *       AggregatedListBackendServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, BackendServicesScopedList>> future =
   *       backendServicesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, BackendServicesScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListBackendServicesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all BackendService resources, regional and global, available to the
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
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   AggregatedListBackendServicesRequest request =
   *       AggregatedListBackendServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     BackendServiceAggregatedList response =
   *         backendServicesClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, BackendServicesScopedList> element : response.getItemsList()) {
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
  public final UnaryCallable<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String backendService = "backendService-1884714623";
   *   Operation response = backendServicesClient.deleteAsync(project, backendService).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String backendService) {
    DeleteBackendServiceRequest request =
        DeleteBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   DeleteBackendServiceRequest request =
   *       DeleteBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = backendServicesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteBackendServiceRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   DeleteBackendServiceRequest request =
   *       DeleteBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendServicesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackendServiceRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   DeleteBackendServiceRequest request =
   *       DeleteBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backendServicesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackendServiceRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String backendService = "backendService-1884714623";
   *   String keyName = "keyName-815643254";
   *   Operation response =
   *       backendServicesClient.deleteSignedUrlKeyAsync(project, backendService, keyName).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to which the Signed URL Key should be
   *     added. The name should conform to RFC1035.
   * @param keyName The name of the Signed URL Key to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteSignedUrlKeyAsync(
      String project, String backendService, String keyName) {
    DeleteSignedUrlKeyBackendServiceRequest request =
        DeleteSignedUrlKeyBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .setKeyName(keyName)
            .build();
    return deleteSignedUrlKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   DeleteSignedUrlKeyBackendServiceRequest request =
   *       DeleteSignedUrlKeyBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setKeyName("keyName-815643254")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = backendServicesClient.deleteSignedUrlKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteSignedUrlKeyAsync(
      DeleteSignedUrlKeyBackendServiceRequest request) {
    return deleteSignedUrlKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   DeleteSignedUrlKeyBackendServiceRequest request =
   *       DeleteSignedUrlKeyBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setKeyName("keyName-815643254")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendServicesClient.deleteSignedUrlKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSignedUrlKeyBackendServiceRequest, Operation, Operation>
      deleteSignedUrlKeyOperationCallable() {
    return stub.deleteSignedUrlKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a key for validating requests with signed URLs for this backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   DeleteSignedUrlKeyBackendServiceRequest request =
   *       DeleteSignedUrlKeyBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setKeyName("keyName-815643254")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backendServicesClient.deleteSignedUrlKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSignedUrlKeyBackendServiceRequest, Operation>
      deleteSignedUrlKeyCallable() {
    return stub.deleteSignedUrlKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified BackendService resource. Gets a list of available backend services.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String backendService = "backendService-1884714623";
   *   BackendService response = backendServicesClient.get(project, backendService);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendService get(String project, String backendService) {
    GetBackendServiceRequest request =
        GetBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified BackendService resource. Gets a list of available backend services.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   GetBackendServiceRequest request =
   *       GetBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .build();
   *   BackendService response = backendServicesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendService get(GetBackendServiceRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified BackendService resource. Gets a list of available backend services.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   GetBackendServiceRequest request =
   *       GetBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<BackendService> future = backendServicesClient.getCallable().futureCall(request);
   *   // Do something.
   *   BackendService response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackendServiceRequest, BackendService> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent health check results for this BackendService. Example request body: {
   * "group": "/zones/us-east1-b/instanceGroups/lb-backend-example" }
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String backendService = "backendService-1884714623";
   *   ResourceGroupReference resourceGroupReferenceResource =
   *       ResourceGroupReference.newBuilder().build();
   *   BackendServiceGroupHealth response =
   *       backendServicesClient.getHealth(project, backendService, resourceGroupReferenceResource);
   * }
   * }</pre>
   *
   * @param project
   * @param backendService Name of the BackendService resource to which the queried instance
   *     belongs.
   * @param resourceGroupReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendServiceGroupHealth getHealth(
      String project,
      String backendService,
      ResourceGroupReference resourceGroupReferenceResource) {
    GetHealthBackendServiceRequest request =
        GetHealthBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .setResourceGroupReferenceResource(resourceGroupReferenceResource)
            .build();
    return getHealth(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent health check results for this BackendService. Example request body: {
   * "group": "/zones/us-east1-b/instanceGroups/lb-backend-example" }
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   GetHealthBackendServiceRequest request =
   *       GetHealthBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setResourceGroupReferenceResource(ResourceGroupReference.newBuilder().build())
   *           .build();
   *   BackendServiceGroupHealth response = backendServicesClient.getHealth(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendServiceGroupHealth getHealth(GetHealthBackendServiceRequest request) {
    return getHealthCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent health check results for this BackendService. Example request body: {
   * "group": "/zones/us-east1-b/instanceGroups/lb-backend-example" }
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   GetHealthBackendServiceRequest request =
   *       GetHealthBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setResourceGroupReferenceResource(ResourceGroupReference.newBuilder().build())
   *           .build();
   *   ApiFuture<BackendServiceGroupHealth> future =
   *       backendServicesClient.getHealthCallable().futureCall(request);
   *   // Do something.
   *   BackendServiceGroupHealth response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
      getHealthCallable() {
    return stub.getHealthCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   Policy response = backendServicesClient.getIamPolicy(project, resource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String resource) {
    GetIamPolicyBackendServiceRequest request =
        GetIamPolicyBackendServiceRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   GetIamPolicyBackendServiceRequest request =
   *       GetIamPolicyBackendServiceRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = backendServicesClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyBackendServiceRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   GetIamPolicyBackendServiceRequest request =
   *       GetIamPolicyBackendServiceRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future = backendServicesClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyBackendServiceRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BackendService resource in the specified project using the data included in the
   * request. For more information, see Backend services overview .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   Operation response = backendServicesClient.insertAsync(project, backendServiceResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, BackendService backendServiceResource) {
    InsertBackendServiceRequest request =
        InsertBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendServiceResource(backendServiceResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BackendService resource in the specified project using the data included in the
   * request. For more information, see Backend services overview .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   InsertBackendServiceRequest request =
   *       InsertBackendServiceRequest.newBuilder()
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = backendServicesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertBackendServiceRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BackendService resource in the specified project using the data included in the
   * request. For more information, see Backend services overview .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   InsertBackendServiceRequest request =
   *       InsertBackendServiceRequest.newBuilder()
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendServicesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertBackendServiceRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BackendService resource in the specified project using the data included in the
   * request. For more information, see Backend services overview .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   InsertBackendServiceRequest request =
   *       InsertBackendServiceRequest.newBuilder()
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backendServicesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertBackendServiceRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of BackendService resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   for (BackendService element : backendServicesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListBackendServicesRequest request =
        ListBackendServicesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of BackendService resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   ListBackendServicesRequest request =
   *       ListBackendServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (BackendService element : backendServicesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListBackendServicesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of BackendService resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   ListBackendServicesRequest request =
   *       ListBackendServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<BackendService> future =
   *       backendServicesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackendService element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackendServicesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of BackendService resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   ListBackendServicesRequest request =
   *       ListBackendServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     BackendServiceList response = backendServicesClient.listCallable().call(request);
   *     for (BackendService element : response.getItemsList()) {
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
  public final UnaryCallable<ListBackendServicesRequest, BackendServiceList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview. This method supports PATCH semantics and uses the
   * JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String backendService = "backendService-1884714623";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   Operation response =
   *       backendServicesClient.patchAsync(project, backendService, backendServiceResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to patch.
   * @param backendServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String backendService, BackendService backendServiceResource) {
    PatchBackendServiceRequest request =
        PatchBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .setBackendServiceResource(backendServiceResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview. This method supports PATCH semantics and uses the
   * JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   PatchBackendServiceRequest request =
   *       PatchBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = backendServicesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchBackendServiceRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview. This method supports PATCH semantics and uses the
   * JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   PatchBackendServiceRequest request =
   *       PatchBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendServicesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchBackendServiceRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview. This method supports PATCH semantics and uses the
   * JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   PatchBackendServiceRequest request =
   *       PatchBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backendServicesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchBackendServiceRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the edge security policy for the specified backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String backendService = "backendService-1884714623";
   *   SecurityPolicyReference securityPolicyReferenceResource =
   *       SecurityPolicyReference.newBuilder().build();
   *   Operation response =
   *       backendServicesClient
   *           .setEdgeSecurityPolicyAsync(project, backendService, securityPolicyReferenceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to which the edge security policy
   *     should be set. The name should conform to RFC1035.
   * @param securityPolicyReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setEdgeSecurityPolicyAsync(
      String project,
      String backendService,
      SecurityPolicyReference securityPolicyReferenceResource) {
    SetEdgeSecurityPolicyBackendServiceRequest request =
        SetEdgeSecurityPolicyBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .setSecurityPolicyReferenceResource(securityPolicyReferenceResource)
            .build();
    return setEdgeSecurityPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the edge security policy for the specified backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   SetEdgeSecurityPolicyBackendServiceRequest request =
   *       SetEdgeSecurityPolicyBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyReferenceResource(SecurityPolicyReference.newBuilder().build())
   *           .build();
   *   Operation response = backendServicesClient.setEdgeSecurityPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setEdgeSecurityPolicyAsync(
      SetEdgeSecurityPolicyBackendServiceRequest request) {
    return setEdgeSecurityPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the edge security policy for the specified backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   SetEdgeSecurityPolicyBackendServiceRequest request =
   *       SetEdgeSecurityPolicyBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyReferenceResource(SecurityPolicyReference.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendServicesClient.setEdgeSecurityPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetEdgeSecurityPolicyBackendServiceRequest, Operation, Operation>
      setEdgeSecurityPolicyOperationCallable() {
    return stub.setEdgeSecurityPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the edge security policy for the specified backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   SetEdgeSecurityPolicyBackendServiceRequest request =
   *       SetEdgeSecurityPolicyBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyReferenceResource(SecurityPolicyReference.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       backendServicesClient.setEdgeSecurityPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetEdgeSecurityPolicyBackendServiceRequest, Operation>
      setEdgeSecurityPolicyCallable() {
    return stub.setEdgeSecurityPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource =
   *       GlobalSetPolicyRequest.newBuilder().build();
   *   Policy response =
   *       backendServicesClient.setIamPolicy(project, resource, globalSetPolicyRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param globalSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project, String resource, GlobalSetPolicyRequest globalSetPolicyRequestResource) {
    SetIamPolicyBackendServiceRequest request =
        SetIamPolicyBackendServiceRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   SetIamPolicyBackendServiceRequest request =
   *       SetIamPolicyBackendServiceRequest.newBuilder()
   *           .setGlobalSetPolicyRequestResource(GlobalSetPolicyRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = backendServicesClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyBackendServiceRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   SetIamPolicyBackendServiceRequest request =
   *       SetIamPolicyBackendServiceRequest.newBuilder()
   *           .setGlobalSetPolicyRequestResource(GlobalSetPolicyRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future = backendServicesClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyBackendServiceRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Google Cloud Armor security policy for the specified backend service. For more
   * information, see Google Cloud Armor Overview
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String backendService = "backendService-1884714623";
   *   SecurityPolicyReference securityPolicyReferenceResource =
   *       SecurityPolicyReference.newBuilder().build();
   *   Operation response =
   *       backendServicesClient
   *           .setSecurityPolicyAsync(project, backendService, securityPolicyReferenceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to which the security policy should
   *     be set. The name should conform to RFC1035.
   * @param securityPolicyReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setSecurityPolicyAsync(
      String project,
      String backendService,
      SecurityPolicyReference securityPolicyReferenceResource) {
    SetSecurityPolicyBackendServiceRequest request =
        SetSecurityPolicyBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .setSecurityPolicyReferenceResource(securityPolicyReferenceResource)
            .build();
    return setSecurityPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Google Cloud Armor security policy for the specified backend service. For more
   * information, see Google Cloud Armor Overview
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   SetSecurityPolicyBackendServiceRequest request =
   *       SetSecurityPolicyBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyReferenceResource(SecurityPolicyReference.newBuilder().build())
   *           .build();
   *   Operation response = backendServicesClient.setSecurityPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setSecurityPolicyAsync(
      SetSecurityPolicyBackendServiceRequest request) {
    return setSecurityPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Google Cloud Armor security policy for the specified backend service. For more
   * information, see Google Cloud Armor Overview
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   SetSecurityPolicyBackendServiceRequest request =
   *       SetSecurityPolicyBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyReferenceResource(SecurityPolicyReference.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendServicesClient.setSecurityPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetSecurityPolicyBackendServiceRequest, Operation, Operation>
      setSecurityPolicyOperationCallable() {
    return stub.setSecurityPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Google Cloud Armor security policy for the specified backend service. For more
   * information, see Google Cloud Armor Overview
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   SetSecurityPolicyBackendServiceRequest request =
   *       SetSecurityPolicyBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyReferenceResource(SecurityPolicyReference.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       backendServicesClient.setSecurityPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetSecurityPolicyBackendServiceRequest, Operation>
      setSecurityPolicyCallable() {
    return stub.setSecurityPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String backendService = "backendService-1884714623";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   Operation response =
   *       backendServicesClient.updateAsync(project, backendService, backendServiceResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendService Name of the BackendService resource to update.
   * @param backendServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      String project, String backendService, BackendService backendServiceResource) {
    UpdateBackendServiceRequest request =
        UpdateBackendServiceRequest.newBuilder()
            .setProject(project)
            .setBackendService(backendService)
            .setBackendServiceResource(backendServiceResource)
            .build();
    return updateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   UpdateBackendServiceRequest request =
   *       UpdateBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = backendServicesClient.updateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> updateAsync(
      UpdateBackendServiceRequest request) {
    return updateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   UpdateBackendServiceRequest request =
   *       UpdateBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendServicesClient.updateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBackendServiceRequest, Operation, Operation>
      updateOperationCallable() {
    return stub.updateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified BackendService resource with the data included in the request. For more
   * information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
   *   UpdateBackendServiceRequest request =
   *       UpdateBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backendServicesClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBackendServiceRequest, Operation> updateCallable() {
    return stub.updateCallable();
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
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          Map.Entry<String, BackendServicesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListBackendServicesRequest,
                BackendServiceAggregatedList,
                Map.Entry<String, BackendServicesScopedList>>
            context,
        ApiFuture<BackendServiceAggregatedList> futureResponse) {
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
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          Map.Entry<String, BackendServicesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListBackendServicesRequest,
                BackendServiceAggregatedList,
                Map.Entry<String, BackendServicesScopedList>>
            context,
        BackendServiceAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListBackendServicesRequest,
                BackendServiceAggregatedList,
                Map.Entry<String, BackendServicesScopedList>>
            context,
        BackendServiceAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListBackendServicesRequest,
                BackendServiceAggregatedList,
                Map.Entry<String, BackendServicesScopedList>>
            context,
        ApiFuture<BackendServiceAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListBackendServicesRequest,
          BackendServiceAggregatedList,
          Map.Entry<String, BackendServicesScopedList>,
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
          ListBackendServicesRequest,
          BackendServiceList,
          BackendService,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListBackendServicesRequest, BackendServiceList, BackendService> context,
        ApiFuture<BackendServiceList> futureResponse) {
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
          ListBackendServicesRequest, BackendServiceList, BackendService, ListPage> {

    private ListPage(
        PageContext<ListBackendServicesRequest, BackendServiceList, BackendService> context,
        BackendServiceList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListBackendServicesRequest, BackendServiceList, BackendService> context,
        BackendServiceList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListBackendServicesRequest, BackendServiceList, BackendService> context,
        ApiFuture<BackendServiceList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackendServicesRequest,
          BackendServiceList,
          BackendService,
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

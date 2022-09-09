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
import com.google.cloud.compute.v1.stub.NetworkEdgeSecurityServicesStub;
import com.google.cloud.compute.v1.stub.NetworkEdgeSecurityServicesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The NetworkEdgeSecurityServices API.
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
 * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
 *     NetworkEdgeSecurityServicesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String networkEdgeSecurityService = "networkEdgeSecurityService-1390253366";
 *   NetworkEdgeSecurityService response =
 *       networkEdgeSecurityServicesClient.get(project, region, networkEdgeSecurityService);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NetworkEdgeSecurityServicesClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * NetworkEdgeSecurityServicesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkEdgeSecurityServicesSettings networkEdgeSecurityServicesSettings =
 *     NetworkEdgeSecurityServicesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
 *     NetworkEdgeSecurityServicesClient.create(networkEdgeSecurityServicesSettings);
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
 * NetworkEdgeSecurityServicesSettings networkEdgeSecurityServicesSettings =
 *     NetworkEdgeSecurityServicesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
 *     NetworkEdgeSecurityServicesClient.create(networkEdgeSecurityServicesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class NetworkEdgeSecurityServicesClient implements BackgroundResource {
  private final NetworkEdgeSecurityServicesSettings settings;
  private final NetworkEdgeSecurityServicesStub stub;

  /** Constructs an instance of NetworkEdgeSecurityServicesClient with default settings. */
  public static final NetworkEdgeSecurityServicesClient create() throws IOException {
    return create(NetworkEdgeSecurityServicesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NetworkEdgeSecurityServicesClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final NetworkEdgeSecurityServicesClient create(
      NetworkEdgeSecurityServicesSettings settings) throws IOException {
    return new NetworkEdgeSecurityServicesClient(settings);
  }

  /**
   * Constructs an instance of NetworkEdgeSecurityServicesClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(NetworkEdgeSecurityServicesSettings).
   */
  public static final NetworkEdgeSecurityServicesClient create(
      NetworkEdgeSecurityServicesStub stub) {
    return new NetworkEdgeSecurityServicesClient(stub);
  }

  /**
   * Constructs an instance of NetworkEdgeSecurityServicesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected NetworkEdgeSecurityServicesClient(NetworkEdgeSecurityServicesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((NetworkEdgeSecurityServicesStubSettings) settings.getStubSettings()).createStub();
  }

  protected NetworkEdgeSecurityServicesClient(NetworkEdgeSecurityServicesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NetworkEdgeSecurityServicesSettings getSettings() {
    return settings;
  }

  public NetworkEdgeSecurityServicesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all NetworkEdgeSecurityService resources available to the specified
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, NetworkEdgeSecurityServicesScopedList> element :
   *       networkEdgeSecurityServicesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListNetworkEdgeSecurityServicesRequest request =
        AggregatedListNetworkEdgeSecurityServicesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all NetworkEdgeSecurityService resources available to the specified
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   AggregatedListNetworkEdgeSecurityServicesRequest request =
   *       AggregatedListNetworkEdgeSecurityServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, NetworkEdgeSecurityServicesScopedList> element :
   *       networkEdgeSecurityServicesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListNetworkEdgeSecurityServicesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all NetworkEdgeSecurityService resources available to the specified
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   AggregatedListNetworkEdgeSecurityServicesRequest request =
   *       AggregatedListNetworkEdgeSecurityServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, NetworkEdgeSecurityServicesScopedList>> future =
   *       networkEdgeSecurityServicesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, NetworkEdgeSecurityServicesScopedList> element :
   *       future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          AggregatedListNetworkEdgeSecurityServicesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all NetworkEdgeSecurityService resources available to the specified
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   AggregatedListNetworkEdgeSecurityServicesRequest request =
   *       AggregatedListNetworkEdgeSecurityServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     NetworkEdgeSecurityServiceAggregatedList response =
   *         networkEdgeSecurityServicesClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, NetworkEdgeSecurityServicesScopedList> element :
   *         response.getItemsList()) {
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
          AggregatedListNetworkEdgeSecurityServicesRequest,
          NetworkEdgeSecurityServiceAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String networkEdgeSecurityService = "networkEdgeSecurityService-1390253366";
   *   Operation response =
   *       networkEdgeSecurityServicesClient
   *           .deleteAsync(project, region, networkEdgeSecurityService)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param networkEdgeSecurityService Name of the network edge security service to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String networkEdgeSecurityService) {
    DeleteNetworkEdgeSecurityServiceRequest request =
        DeleteNetworkEdgeSecurityServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetworkEdgeSecurityService(networkEdgeSecurityService)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   DeleteNetworkEdgeSecurityServiceRequest request =
   *       DeleteNetworkEdgeSecurityServiceRequest.newBuilder()
   *           .setNetworkEdgeSecurityService("networkEdgeSecurityService-1390253366")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = networkEdgeSecurityServicesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteNetworkEdgeSecurityServiceRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   DeleteNetworkEdgeSecurityServiceRequest request =
   *       DeleteNetworkEdgeSecurityServiceRequest.newBuilder()
   *           .setNetworkEdgeSecurityService("networkEdgeSecurityService-1390253366")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkEdgeSecurityServicesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteNetworkEdgeSecurityServiceRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   DeleteNetworkEdgeSecurityServiceRequest request =
   *       DeleteNetworkEdgeSecurityServiceRequest.newBuilder()
   *           .setNetworkEdgeSecurityService("networkEdgeSecurityService-1390253366")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkEdgeSecurityServicesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNetworkEdgeSecurityServiceRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specified NetworkEdgeSecurityService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String networkEdgeSecurityService = "networkEdgeSecurityService-1390253366";
   *   NetworkEdgeSecurityService response =
   *       networkEdgeSecurityServicesClient.get(project, region, networkEdgeSecurityService);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param networkEdgeSecurityService Name of the network edge security service to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkEdgeSecurityService get(
      String project, String region, String networkEdgeSecurityService) {
    GetNetworkEdgeSecurityServiceRequest request =
        GetNetworkEdgeSecurityServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetworkEdgeSecurityService(networkEdgeSecurityService)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specified NetworkEdgeSecurityService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   GetNetworkEdgeSecurityServiceRequest request =
   *       GetNetworkEdgeSecurityServiceRequest.newBuilder()
   *           .setNetworkEdgeSecurityService("networkEdgeSecurityService-1390253366")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   NetworkEdgeSecurityService response = networkEdgeSecurityServicesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkEdgeSecurityService get(GetNetworkEdgeSecurityServiceRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specified NetworkEdgeSecurityService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   GetNetworkEdgeSecurityServiceRequest request =
   *       GetNetworkEdgeSecurityServiceRequest.newBuilder()
   *           .setNetworkEdgeSecurityService("networkEdgeSecurityService-1390253366")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<NetworkEdgeSecurityService> future =
   *       networkEdgeSecurityServicesClient.getCallable().futureCall(request);
   *   // Do something.
   *   NetworkEdgeSecurityService response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNetworkEdgeSecurityServiceRequest, NetworkEdgeSecurityService>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   NetworkEdgeSecurityService networkEdgeSecurityServiceResource =
   *       NetworkEdgeSecurityService.newBuilder().build();
   *   Operation response =
   *       networkEdgeSecurityServicesClient
   *           .insertAsync(project, region, networkEdgeSecurityServiceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param networkEdgeSecurityServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project,
      String region,
      NetworkEdgeSecurityService networkEdgeSecurityServiceResource) {
    InsertNetworkEdgeSecurityServiceRequest request =
        InsertNetworkEdgeSecurityServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetworkEdgeSecurityServiceResource(networkEdgeSecurityServiceResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   InsertNetworkEdgeSecurityServiceRequest request =
   *       InsertNetworkEdgeSecurityServiceRequest.newBuilder()
   *           .setNetworkEdgeSecurityServiceResource(
   *               NetworkEdgeSecurityService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Operation response = networkEdgeSecurityServicesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertNetworkEdgeSecurityServiceRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   InsertNetworkEdgeSecurityServiceRequest request =
   *       InsertNetworkEdgeSecurityServiceRequest.newBuilder()
   *           .setNetworkEdgeSecurityServiceResource(
   *               NetworkEdgeSecurityService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkEdgeSecurityServicesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertNetworkEdgeSecurityServiceRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new service in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   InsertNetworkEdgeSecurityServiceRequest request =
   *       InsertNetworkEdgeSecurityServiceRequest.newBuilder()
   *           .setNetworkEdgeSecurityServiceResource(
   *               NetworkEdgeSecurityService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkEdgeSecurityServicesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertNetworkEdgeSecurityServiceRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String networkEdgeSecurityService = "networkEdgeSecurityService-1390253366";
   *   NetworkEdgeSecurityService networkEdgeSecurityServiceResource =
   *       NetworkEdgeSecurityService.newBuilder().build();
   *   Operation response =
   *       networkEdgeSecurityServicesClient
   *           .patchAsync(
   *               project, region, networkEdgeSecurityService, networkEdgeSecurityServiceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param networkEdgeSecurityService Name of the network edge security service to update.
   * @param networkEdgeSecurityServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project,
      String region,
      String networkEdgeSecurityService,
      NetworkEdgeSecurityService networkEdgeSecurityServiceResource) {
    PatchNetworkEdgeSecurityServiceRequest request =
        PatchNetworkEdgeSecurityServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetworkEdgeSecurityService(networkEdgeSecurityService)
            .setNetworkEdgeSecurityServiceResource(networkEdgeSecurityServiceResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   PatchNetworkEdgeSecurityServiceRequest request =
   *       PatchNetworkEdgeSecurityServiceRequest.newBuilder()
   *           .setNetworkEdgeSecurityService("networkEdgeSecurityService-1390253366")
   *           .setNetworkEdgeSecurityServiceResource(
   *               NetworkEdgeSecurityService.newBuilder().build())
   *           .setPaths("paths106438894")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   Operation response = networkEdgeSecurityServicesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchNetworkEdgeSecurityServiceRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   PatchNetworkEdgeSecurityServiceRequest request =
   *       PatchNetworkEdgeSecurityServiceRequest.newBuilder()
   *           .setNetworkEdgeSecurityService("networkEdgeSecurityService-1390253366")
   *           .setNetworkEdgeSecurityServiceResource(
   *               NetworkEdgeSecurityService.newBuilder().build())
   *           .setPaths("paths106438894")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkEdgeSecurityServicesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchNetworkEdgeSecurityServiceRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
   *     NetworkEdgeSecurityServicesClient.create()) {
   *   PatchNetworkEdgeSecurityServiceRequest request =
   *       PatchNetworkEdgeSecurityServiceRequest.newBuilder()
   *           .setNetworkEdgeSecurityService("networkEdgeSecurityService-1390253366")
   *           .setNetworkEdgeSecurityServiceResource(
   *               NetworkEdgeSecurityService.newBuilder().build())
   *           .setPaths("paths106438894")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkEdgeSecurityServicesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchNetworkEdgeSecurityServiceRequest, Operation> patchCallable() {
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListNetworkEdgeSecurityServicesRequest,
          NetworkEdgeSecurityServiceAggregatedList,
          Map.Entry<String, NetworkEdgeSecurityServicesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListNetworkEdgeSecurityServicesRequest,
                NetworkEdgeSecurityServiceAggregatedList,
                Map.Entry<String, NetworkEdgeSecurityServicesScopedList>>
            context,
        ApiFuture<NetworkEdgeSecurityServiceAggregatedList> futureResponse) {
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
          AggregatedListNetworkEdgeSecurityServicesRequest,
          NetworkEdgeSecurityServiceAggregatedList,
          Map.Entry<String, NetworkEdgeSecurityServicesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListNetworkEdgeSecurityServicesRequest,
                NetworkEdgeSecurityServiceAggregatedList,
                Map.Entry<String, NetworkEdgeSecurityServicesScopedList>>
            context,
        NetworkEdgeSecurityServiceAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListNetworkEdgeSecurityServicesRequest,
                NetworkEdgeSecurityServiceAggregatedList,
                Map.Entry<String, NetworkEdgeSecurityServicesScopedList>>
            context,
        NetworkEdgeSecurityServiceAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListNetworkEdgeSecurityServicesRequest,
                NetworkEdgeSecurityServiceAggregatedList,
                Map.Entry<String, NetworkEdgeSecurityServicesScopedList>>
            context,
        ApiFuture<NetworkEdgeSecurityServiceAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListNetworkEdgeSecurityServicesRequest,
          NetworkEdgeSecurityServiceAggregatedList,
          Map.Entry<String, NetworkEdgeSecurityServicesScopedList>,
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
}

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
import com.google.cloud.compute.v1.stub.RegionHealthCheckServicesStub;
import com.google.cloud.compute.v1.stub.RegionHealthCheckServicesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionHealthCheckServices API.
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
 * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
 *     RegionHealthCheckServicesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String healthCheckService = "healthCheckService-917902071";
 *   HealthCheckService response =
 *       regionHealthCheckServicesClient.get(project, region, healthCheckService);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionHealthCheckServicesClient object to clean up
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
 * RegionHealthCheckServicesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionHealthCheckServicesSettings regionHealthCheckServicesSettings =
 *     RegionHealthCheckServicesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionHealthCheckServicesClient regionHealthCheckServicesClient =
 *     RegionHealthCheckServicesClient.create(regionHealthCheckServicesSettings);
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
 * RegionHealthCheckServicesSettings regionHealthCheckServicesSettings =
 *     RegionHealthCheckServicesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionHealthCheckServicesClient regionHealthCheckServicesClient =
 *     RegionHealthCheckServicesClient.create(regionHealthCheckServicesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionHealthCheckServicesClient implements BackgroundResource {
  private final RegionHealthCheckServicesSettings settings;
  private final RegionHealthCheckServicesStub stub;

  /** Constructs an instance of RegionHealthCheckServicesClient with default settings. */
  public static final RegionHealthCheckServicesClient create() throws IOException {
    return create(RegionHealthCheckServicesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionHealthCheckServicesClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionHealthCheckServicesClient create(
      RegionHealthCheckServicesSettings settings) throws IOException {
    return new RegionHealthCheckServicesClient(settings);
  }

  /**
   * Constructs an instance of RegionHealthCheckServicesClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(RegionHealthCheckServicesSettings).
   */
  public static final RegionHealthCheckServicesClient create(RegionHealthCheckServicesStub stub) {
    return new RegionHealthCheckServicesClient(stub);
  }

  /**
   * Constructs an instance of RegionHealthCheckServicesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionHealthCheckServicesClient(RegionHealthCheckServicesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionHealthCheckServicesStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionHealthCheckServicesClient(RegionHealthCheckServicesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionHealthCheckServicesSettings getSettings() {
    return settings;
  }

  public RegionHealthCheckServicesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified regional HealthCheckService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String healthCheckService = "healthCheckService-917902071";
   *   Operation response =
   *       regionHealthCheckServicesClient.deleteAsync(project, region, healthCheckService).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthCheckService Name of the HealthCheckService to delete. The name must be 1-63
   *     characters long, and comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String healthCheckService) {
    DeleteRegionHealthCheckServiceRequest request =
        DeleteRegionHealthCheckServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthCheckService(healthCheckService)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified regional HealthCheckService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   DeleteRegionHealthCheckServiceRequest request =
   *       DeleteRegionHealthCheckServiceRequest.newBuilder()
   *           .setHealthCheckService("healthCheckService-917902071")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionHealthCheckServicesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionHealthCheckServiceRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified regional HealthCheckService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   DeleteRegionHealthCheckServiceRequest request =
   *       DeleteRegionHealthCheckServiceRequest.newBuilder()
   *           .setHealthCheckService("healthCheckService-917902071")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionHealthCheckServicesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionHealthCheckServiceRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified regional HealthCheckService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   DeleteRegionHealthCheckServiceRequest request =
   *       DeleteRegionHealthCheckServiceRequest.newBuilder()
   *           .setHealthCheckService("healthCheckService-917902071")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionHealthCheckServicesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionHealthCheckServiceRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified regional HealthCheckService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String healthCheckService = "healthCheckService-917902071";
   *   HealthCheckService response =
   *       regionHealthCheckServicesClient.get(project, region, healthCheckService);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthCheckService Name of the HealthCheckService to update. The name must be 1-63
   *     characters long, and comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HealthCheckService get(String project, String region, String healthCheckService) {
    GetRegionHealthCheckServiceRequest request =
        GetRegionHealthCheckServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthCheckService(healthCheckService)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified regional HealthCheckService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   GetRegionHealthCheckServiceRequest request =
   *       GetRegionHealthCheckServiceRequest.newBuilder()
   *           .setHealthCheckService("healthCheckService-917902071")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   HealthCheckService response = regionHealthCheckServicesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HealthCheckService get(GetRegionHealthCheckServiceRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified regional HealthCheckService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   GetRegionHealthCheckServiceRequest request =
   *       GetRegionHealthCheckServiceRequest.newBuilder()
   *           .setHealthCheckService("healthCheckService-917902071")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<HealthCheckService> future =
   *       regionHealthCheckServicesClient.getCallable().futureCall(request);
   *   // Do something.
   *   HealthCheckService response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionHealthCheckServiceRequest, HealthCheckService> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a regional HealthCheckService resource in the specified project and region using the
   * data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   Operation response =
   *       regionHealthCheckServicesClient
   *           .insertAsync(project, region, healthCheckServiceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthCheckServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, HealthCheckService healthCheckServiceResource) {
    InsertRegionHealthCheckServiceRequest request =
        InsertRegionHealthCheckServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthCheckServiceResource(healthCheckServiceResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a regional HealthCheckService resource in the specified project and region using the
   * data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   InsertRegionHealthCheckServiceRequest request =
   *       InsertRegionHealthCheckServiceRequest.newBuilder()
   *           .setHealthCheckServiceResource(HealthCheckService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionHealthCheckServicesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionHealthCheckServiceRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a regional HealthCheckService resource in the specified project and region using the
   * data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   InsertRegionHealthCheckServiceRequest request =
   *       InsertRegionHealthCheckServiceRequest.newBuilder()
   *           .setHealthCheckServiceResource(HealthCheckService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionHealthCheckServicesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionHealthCheckServiceRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a regional HealthCheckService resource in the specified project and region using the
   * data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   InsertRegionHealthCheckServiceRequest request =
   *       InsertRegionHealthCheckServiceRequest.newBuilder()
   *           .setHealthCheckServiceResource(HealthCheckService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionHealthCheckServicesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionHealthCheckServiceRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the HealthCheckService resources that have been configured for the specified project
   * in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (HealthCheckService element :
   *       regionHealthCheckServicesClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRegionHealthCheckServicesRequest request =
        ListRegionHealthCheckServicesRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the HealthCheckService resources that have been configured for the specified project
   * in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   ListRegionHealthCheckServicesRequest request =
   *       ListRegionHealthCheckServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (HealthCheckService element :
   *       regionHealthCheckServicesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionHealthCheckServicesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the HealthCheckService resources that have been configured for the specified project
   * in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   ListRegionHealthCheckServicesRequest request =
   *       ListRegionHealthCheckServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<HealthCheckService> future =
   *       regionHealthCheckServicesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HealthCheckService element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionHealthCheckServicesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the HealthCheckService resources that have been configured for the specified project
   * in the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   ListRegionHealthCheckServicesRequest request =
   *       ListRegionHealthCheckServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     HealthCheckServicesList response =
   *         regionHealthCheckServicesClient.listCallable().call(request);
   *     for (HealthCheckService element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionHealthCheckServicesRequest, HealthCheckServicesList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional HealthCheckService resource with the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String healthCheckService = "healthCheckService-917902071";
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   Operation response =
   *       regionHealthCheckServicesClient
   *           .patchAsync(project, region, healthCheckService, healthCheckServiceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthCheckService Name of the HealthCheckService to update. The name must be 1-63
   *     characters long, and comply with RFC1035.
   * @param healthCheckServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project,
      String region,
      String healthCheckService,
      HealthCheckService healthCheckServiceResource) {
    PatchRegionHealthCheckServiceRequest request =
        PatchRegionHealthCheckServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthCheckService(healthCheckService)
            .setHealthCheckServiceResource(healthCheckServiceResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional HealthCheckService resource with the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   PatchRegionHealthCheckServiceRequest request =
   *       PatchRegionHealthCheckServiceRequest.newBuilder()
   *           .setHealthCheckService("healthCheckService-917902071")
   *           .setHealthCheckServiceResource(HealthCheckService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionHealthCheckServicesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchRegionHealthCheckServiceRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional HealthCheckService resource with the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   PatchRegionHealthCheckServiceRequest request =
   *       PatchRegionHealthCheckServiceRequest.newBuilder()
   *           .setHealthCheckService("healthCheckService-917902071")
   *           .setHealthCheckServiceResource(HealthCheckService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionHealthCheckServicesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRegionHealthCheckServiceRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional HealthCheckService resource with the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
   *     RegionHealthCheckServicesClient.create()) {
   *   PatchRegionHealthCheckServiceRequest request =
   *       PatchRegionHealthCheckServiceRequest.newBuilder()
   *           .setHealthCheckService("healthCheckService-917902071")
   *           .setHealthCheckServiceResource(HealthCheckService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionHealthCheckServicesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRegionHealthCheckServiceRequest, Operation> patchCallable() {
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
          ListRegionHealthCheckServicesRequest,
          HealthCheckServicesList,
          HealthCheckService,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListRegionHealthCheckServicesRequest, HealthCheckServicesList, HealthCheckService>
            context,
        ApiFuture<HealthCheckServicesList> futureResponse) {
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
          ListRegionHealthCheckServicesRequest,
          HealthCheckServicesList,
          HealthCheckService,
          ListPage> {

    private ListPage(
        PageContext<
                ListRegionHealthCheckServicesRequest, HealthCheckServicesList, HealthCheckService>
            context,
        HealthCheckServicesList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListRegionHealthCheckServicesRequest, HealthCheckServicesList, HealthCheckService>
            context,
        HealthCheckServicesList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListRegionHealthCheckServicesRequest, HealthCheckServicesList, HealthCheckService>
            context,
        ApiFuture<HealthCheckServicesList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionHealthCheckServicesRequest,
          HealthCheckServicesList,
          HealthCheckService,
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

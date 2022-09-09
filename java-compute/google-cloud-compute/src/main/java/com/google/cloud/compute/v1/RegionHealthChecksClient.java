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
import com.google.cloud.compute.v1.stub.RegionHealthChecksStub;
import com.google.cloud.compute.v1.stub.RegionHealthChecksStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionHealthChecks API.
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
 * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String healthCheck = "healthCheck-1938093044";
 *   HealthCheck response = regionHealthChecksClient.get(project, region, healthCheck);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionHealthChecksClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of RegionHealthChecksSettings to
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
 * RegionHealthChecksSettings regionHealthChecksSettings =
 *     RegionHealthChecksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionHealthChecksClient regionHealthChecksClient =
 *     RegionHealthChecksClient.create(regionHealthChecksSettings);
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
 * RegionHealthChecksSettings regionHealthChecksSettings =
 *     RegionHealthChecksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionHealthChecksClient regionHealthChecksClient =
 *     RegionHealthChecksClient.create(regionHealthChecksSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionHealthChecksClient implements BackgroundResource {
  private final RegionHealthChecksSettings settings;
  private final RegionHealthChecksStub stub;

  /** Constructs an instance of RegionHealthChecksClient with default settings. */
  public static final RegionHealthChecksClient create() throws IOException {
    return create(RegionHealthChecksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionHealthChecksClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionHealthChecksClient create(RegionHealthChecksSettings settings)
      throws IOException {
    return new RegionHealthChecksClient(settings);
  }

  /**
   * Constructs an instance of RegionHealthChecksClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(RegionHealthChecksSettings).
   */
  public static final RegionHealthChecksClient create(RegionHealthChecksStub stub) {
    return new RegionHealthChecksClient(stub);
  }

  /**
   * Constructs an instance of RegionHealthChecksClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionHealthChecksClient(RegionHealthChecksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionHealthChecksStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionHealthChecksClient(RegionHealthChecksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionHealthChecksSettings getSettings() {
    return settings;
  }

  public RegionHealthChecksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified HealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String healthCheck = "healthCheck-1938093044";
   *   Operation response = regionHealthChecksClient.deleteAsync(project, region, healthCheck).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthCheck Name of the HealthCheck resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String healthCheck) {
    DeleteRegionHealthCheckRequest request =
        DeleteRegionHealthCheckRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthCheck(healthCheck)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified HealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   DeleteRegionHealthCheckRequest request =
   *       DeleteRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheck("healthCheck-1938093044")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionHealthChecksClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionHealthCheckRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified HealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   DeleteRegionHealthCheckRequest request =
   *       DeleteRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheck("healthCheck-1938093044")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionHealthChecksClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionHealthCheckRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified HealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   DeleteRegionHealthCheckRequest request =
   *       DeleteRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheck("healthCheck-1938093044")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = regionHealthChecksClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionHealthCheckRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified HealthCheck resource. Gets a list of available health checks by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String healthCheck = "healthCheck-1938093044";
   *   HealthCheck response = regionHealthChecksClient.get(project, region, healthCheck);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthCheck Name of the HealthCheck resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HealthCheck get(String project, String region, String healthCheck) {
    GetRegionHealthCheckRequest request =
        GetRegionHealthCheckRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthCheck(healthCheck)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified HealthCheck resource. Gets a list of available health checks by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   GetRegionHealthCheckRequest request =
   *       GetRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheck("healthCheck-1938093044")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   HealthCheck response = regionHealthChecksClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HealthCheck get(GetRegionHealthCheckRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified HealthCheck resource. Gets a list of available health checks by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   GetRegionHealthCheckRequest request =
   *       GetRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheck("healthCheck-1938093044")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<HealthCheck> future = regionHealthChecksClient.getCallable().futureCall(request);
   *   // Do something.
   *   HealthCheck response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionHealthCheckRequest, HealthCheck> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   Operation response =
   *       regionHealthChecksClient.insertAsync(project, region, healthCheckResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthCheckResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, HealthCheck healthCheckResource) {
    InsertRegionHealthCheckRequest request =
        InsertRegionHealthCheckRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthCheckResource(healthCheckResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   InsertRegionHealthCheckRequest request =
   *       InsertRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheckResource(HealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionHealthChecksClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionHealthCheckRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   InsertRegionHealthCheckRequest request =
   *       InsertRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheckResource(HealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionHealthChecksClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionHealthCheckRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   InsertRegionHealthCheckRequest request =
   *       InsertRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheckResource(HealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = regionHealthChecksClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionHealthCheckRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of HealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (HealthCheck element : regionHealthChecksClient.list(project, region).iterateAll()) {
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
    ListRegionHealthChecksRequest request =
        ListRegionHealthChecksRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of HealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   ListRegionHealthChecksRequest request =
   *       ListRegionHealthChecksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (HealthCheck element : regionHealthChecksClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionHealthChecksRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of HealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   ListRegionHealthChecksRequest request =
   *       ListRegionHealthChecksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<HealthCheck> future =
   *       regionHealthChecksClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HealthCheck element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionHealthChecksRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of HealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   ListRegionHealthChecksRequest request =
   *       ListRegionHealthChecksRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     HealthCheckList response = regionHealthChecksClient.listCallable().call(request);
   *     for (HealthCheck element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionHealthChecksRequest, HealthCheckList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   * This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String healthCheck = "healthCheck-1938093044";
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   Operation response =
   *       regionHealthChecksClient
   *           .patchAsync(project, region, healthCheck, healthCheckResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthCheck Name of the HealthCheck resource to patch.
   * @param healthCheckResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String region, String healthCheck, HealthCheck healthCheckResource) {
    PatchRegionHealthCheckRequest request =
        PatchRegionHealthCheckRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthCheck(healthCheck)
            .setHealthCheckResource(healthCheckResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   * This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   PatchRegionHealthCheckRequest request =
   *       PatchRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheck("healthCheck-1938093044")
   *           .setHealthCheckResource(HealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionHealthChecksClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchRegionHealthCheckRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   * This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   PatchRegionHealthCheckRequest request =
   *       PatchRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheck("healthCheck-1938093044")
   *           .setHealthCheckResource(HealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionHealthChecksClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRegionHealthCheckRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   * This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   PatchRegionHealthCheckRequest request =
   *       PatchRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheck("healthCheck-1938093044")
   *           .setHealthCheckResource(HealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = regionHealthChecksClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRegionHealthCheckRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String healthCheck = "healthCheck-1938093044";
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   Operation response =
   *       regionHealthChecksClient
   *           .updateAsync(project, region, healthCheck, healthCheckResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthCheck Name of the HealthCheck resource to update.
   * @param healthCheckResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      String project, String region, String healthCheck, HealthCheck healthCheckResource) {
    UpdateRegionHealthCheckRequest request =
        UpdateRegionHealthCheckRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthCheck(healthCheck)
            .setHealthCheckResource(healthCheckResource)
            .build();
    return updateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   UpdateRegionHealthCheckRequest request =
   *       UpdateRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheck("healthCheck-1938093044")
   *           .setHealthCheckResource(HealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionHealthChecksClient.updateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> updateAsync(
      UpdateRegionHealthCheckRequest request) {
    return updateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   UpdateRegionHealthCheckRequest request =
   *       UpdateRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheck("healthCheck-1938093044")
   *           .setHealthCheckResource(HealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionHealthChecksClient.updateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRegionHealthCheckRequest, Operation, Operation>
      updateOperationCallable() {
    return stub.updateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
   *   UpdateRegionHealthCheckRequest request =
   *       UpdateRegionHealthCheckRequest.newBuilder()
   *           .setHealthCheck("healthCheck-1938093044")
   *           .setHealthCheckResource(HealthCheck.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = regionHealthChecksClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRegionHealthCheckRequest, Operation> updateCallable() {
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListRegionHealthChecksRequest,
          HealthCheckList,
          HealthCheck,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionHealthChecksRequest, HealthCheckList, HealthCheck> context,
        ApiFuture<HealthCheckList> futureResponse) {
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
      extends AbstractPage<ListRegionHealthChecksRequest, HealthCheckList, HealthCheck, ListPage> {

    private ListPage(
        PageContext<ListRegionHealthChecksRequest, HealthCheckList, HealthCheck> context,
        HealthCheckList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionHealthChecksRequest, HealthCheckList, HealthCheck> context,
        HealthCheckList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionHealthChecksRequest, HealthCheckList, HealthCheck> context,
        ApiFuture<HealthCheckList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionHealthChecksRequest,
          HealthCheckList,
          HealthCheck,
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

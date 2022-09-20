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
import com.google.cloud.compute.v1.stub.RegionBackendServicesStub;
import com.google.cloud.compute.v1.stub.RegionBackendServicesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionBackendServices API.
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
 * try (RegionBackendServicesClient regionBackendServicesClient =
 *     RegionBackendServicesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String backendService = "backendService-1884714623";
 *   BackendService response = regionBackendServicesClient.get(project, region, backendService);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionBackendServicesClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of RegionBackendServicesSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionBackendServicesSettings regionBackendServicesSettings =
 *     RegionBackendServicesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionBackendServicesClient regionBackendServicesClient =
 *     RegionBackendServicesClient.create(regionBackendServicesSettings);
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
 * RegionBackendServicesSettings regionBackendServicesSettings =
 *     RegionBackendServicesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionBackendServicesClient regionBackendServicesClient =
 *     RegionBackendServicesClient.create(regionBackendServicesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionBackendServicesClient implements BackgroundResource {
  private final RegionBackendServicesSettings settings;
  private final RegionBackendServicesStub stub;

  /** Constructs an instance of RegionBackendServicesClient with default settings. */
  public static final RegionBackendServicesClient create() throws IOException {
    return create(RegionBackendServicesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionBackendServicesClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionBackendServicesClient create(RegionBackendServicesSettings settings)
      throws IOException {
    return new RegionBackendServicesClient(settings);
  }

  /**
   * Constructs an instance of RegionBackendServicesClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(RegionBackendServicesSettings).
   */
  public static final RegionBackendServicesClient create(RegionBackendServicesStub stub) {
    return new RegionBackendServicesClient(stub);
  }

  /**
   * Constructs an instance of RegionBackendServicesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionBackendServicesClient(RegionBackendServicesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionBackendServicesStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionBackendServicesClient(RegionBackendServicesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionBackendServicesSettings getSettings() {
    return settings;
  }

  public RegionBackendServicesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified regional BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String backendService = "backendService-1884714623";
   *   Operation response =
   *       regionBackendServicesClient.deleteAsync(project, region, backendService).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param backendService Name of the BackendService resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String backendService) {
    DeleteRegionBackendServiceRequest request =
        DeleteRegionBackendServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setBackendService(backendService)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified regional BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   DeleteRegionBackendServiceRequest request =
   *       DeleteRegionBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionBackendServicesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionBackendServiceRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified regional BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   DeleteRegionBackendServiceRequest request =
   *       DeleteRegionBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionBackendServicesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionBackendServiceRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified regional BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   DeleteRegionBackendServiceRequest request =
   *       DeleteRegionBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionBackendServicesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionBackendServiceRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified regional BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String backendService = "backendService-1884714623";
   *   BackendService response = regionBackendServicesClient.get(project, region, backendService);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param backendService Name of the BackendService resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendService get(String project, String region, String backendService) {
    GetRegionBackendServiceRequest request =
        GetRegionBackendServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setBackendService(backendService)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified regional BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   GetRegionBackendServiceRequest request =
   *       GetRegionBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   BackendService response = regionBackendServicesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendService get(GetRegionBackendServiceRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified regional BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   GetRegionBackendServiceRequest request =
   *       GetRegionBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<BackendService> future =
   *       regionBackendServicesClient.getCallable().futureCall(request);
   *   // Do something.
   *   BackendService response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionBackendServiceRequest, BackendService> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent health check results for this regional BackendService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String backendService = "backendService-1884714623";
   *   ResourceGroupReference resourceGroupReferenceResource =
   *       ResourceGroupReference.newBuilder().build();
   *   BackendServiceGroupHealth response =
   *       regionBackendServicesClient.getHealth(
   *           project, region, backendService, resourceGroupReferenceResource);
   * }
   * }</pre>
   *
   * @param project
   * @param region Name of the region scoping this request.
   * @param backendService Name of the BackendService resource for which to get health.
   * @param resourceGroupReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendServiceGroupHealth getHealth(
      String project,
      String region,
      String backendService,
      ResourceGroupReference resourceGroupReferenceResource) {
    GetHealthRegionBackendServiceRequest request =
        GetHealthRegionBackendServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setBackendService(backendService)
            .setResourceGroupReferenceResource(resourceGroupReferenceResource)
            .build();
    return getHealth(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent health check results for this regional BackendService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   GetHealthRegionBackendServiceRequest request =
   *       GetHealthRegionBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResourceGroupReferenceResource(ResourceGroupReference.newBuilder().build())
   *           .build();
   *   BackendServiceGroupHealth response = regionBackendServicesClient.getHealth(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendServiceGroupHealth getHealth(GetHealthRegionBackendServiceRequest request) {
    return getHealthCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent health check results for this regional BackendService.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   GetHealthRegionBackendServiceRequest request =
   *       GetHealthRegionBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResourceGroupReferenceResource(ResourceGroupReference.newBuilder().build())
   *           .build();
   *   ApiFuture<BackendServiceGroupHealth> future =
   *       regionBackendServicesClient.getHealthCallable().futureCall(request);
   *   // Do something.
   *   BackendServiceGroupHealth response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHealthRegionBackendServiceRequest, BackendServiceGroupHealth>
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
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resource = "resource-341064690";
   *   Policy response = regionBackendServicesClient.getIamPolicy(project, region, resource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String region, String resource) {
    GetIamPolicyRegionBackendServiceRequest request =
        GetIamPolicyRegionBackendServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   GetIamPolicyRegionBackendServiceRequest request =
   *       GetIamPolicyRegionBackendServiceRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = regionBackendServicesClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRegionBackendServiceRequest request) {
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
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   GetIamPolicyRegionBackendServiceRequest request =
   *       GetIamPolicyRegionBackendServiceRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future =
   *       regionBackendServicesClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRegionBackendServiceRequest, Policy>
      getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a regional BackendService resource in the specified project using the data included in
   * the request. For more information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   Operation response =
   *       regionBackendServicesClient.insertAsync(project, region, backendServiceResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param backendServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, BackendService backendServiceResource) {
    InsertRegionBackendServiceRequest request =
        InsertRegionBackendServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setBackendServiceResource(backendServiceResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a regional BackendService resource in the specified project using the data included in
   * the request. For more information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   InsertRegionBackendServiceRequest request =
   *       InsertRegionBackendServiceRequest.newBuilder()
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionBackendServicesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionBackendServiceRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a regional BackendService resource in the specified project using the data included in
   * the request. For more information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   InsertRegionBackendServiceRequest request =
   *       InsertRegionBackendServiceRequest.newBuilder()
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionBackendServicesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionBackendServiceRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a regional BackendService resource in the specified project using the data included in
   * the request. For more information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   InsertRegionBackendServiceRequest request =
   *       InsertRegionBackendServiceRequest.newBuilder()
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionBackendServicesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionBackendServiceRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of regional BackendService resources available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (BackendService element :
   *       regionBackendServicesClient.list(project, region).iterateAll()) {
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
    ListRegionBackendServicesRequest request =
        ListRegionBackendServicesRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of regional BackendService resources available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   ListRegionBackendServicesRequest request =
   *       ListRegionBackendServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (BackendService element : regionBackendServicesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionBackendServicesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of regional BackendService resources available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   ListRegionBackendServicesRequest request =
   *       ListRegionBackendServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<BackendService> future =
   *       regionBackendServicesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackendService element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionBackendServicesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of regional BackendService resources available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   ListRegionBackendServicesRequest request =
   *       ListRegionBackendServicesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     BackendServiceList response = regionBackendServicesClient.listCallable().call(request);
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
  public final UnaryCallable<ListRegionBackendServicesRequest, BackendServiceList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Understanding backend services This method supports PATCH semantics
   * and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String backendService = "backendService-1884714623";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   Operation response =
   *       regionBackendServicesClient
   *           .patchAsync(project, region, backendService, backendServiceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param backendService Name of the BackendService resource to patch.
   * @param backendServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String region, String backendService, BackendService backendServiceResource) {
    PatchRegionBackendServiceRequest request =
        PatchRegionBackendServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setBackendService(backendService)
            .setBackendServiceResource(backendServiceResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Understanding backend services This method supports PATCH semantics
   * and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   PatchRegionBackendServiceRequest request =
   *       PatchRegionBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionBackendServicesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchRegionBackendServiceRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Understanding backend services This method supports PATCH semantics
   * and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   PatchRegionBackendServiceRequest request =
   *       PatchRegionBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionBackendServicesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRegionBackendServiceRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Understanding backend services This method supports PATCH semantics
   * and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   PatchRegionBackendServiceRequest request =
   *       PatchRegionBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = regionBackendServicesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRegionBackendServiceRequest, Operation> patchCallable() {
    return stub.patchCallable();
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
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resource = "resource-341064690";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource =
   *       RegionSetPolicyRequest.newBuilder().build();
   *   Policy response =
   *       regionBackendServicesClient.setIamPolicy(
   *           project, region, resource, regionSetPolicyRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param regionSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project,
      String region,
      String resource,
      RegionSetPolicyRequest regionSetPolicyRequestResource) {
    SetIamPolicyRegionBackendServiceRequest request =
        SetIamPolicyRegionBackendServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
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
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   SetIamPolicyRegionBackendServiceRequest request =
   *       SetIamPolicyRegionBackendServiceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionSetPolicyRequestResource(RegionSetPolicyRequest.newBuilder().build())
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = regionBackendServicesClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRegionBackendServiceRequest request) {
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
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   SetIamPolicyRegionBackendServiceRequest request =
   *       SetIamPolicyRegionBackendServiceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionSetPolicyRequestResource(RegionSetPolicyRequest.newBuilder().build())
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future =
   *       regionBackendServicesClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRegionBackendServiceRequest, Policy>
      setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Backend services overview .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String backendService = "backendService-1884714623";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   Operation response =
   *       regionBackendServicesClient
   *           .updateAsync(project, region, backendService, backendServiceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param backendService Name of the BackendService resource to update.
   * @param backendServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      String project, String region, String backendService, BackendService backendServiceResource) {
    UpdateRegionBackendServiceRequest request =
        UpdateRegionBackendServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setBackendService(backendService)
            .setBackendServiceResource(backendServiceResource)
            .build();
    return updateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Backend services overview .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   UpdateRegionBackendServiceRequest request =
   *       UpdateRegionBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionBackendServicesClient.updateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> updateAsync(
      UpdateRegionBackendServiceRequest request) {
    return updateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Backend services overview .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   UpdateRegionBackendServiceRequest request =
   *       UpdateRegionBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionBackendServicesClient.updateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRegionBackendServiceRequest, Operation, Operation>
      updateOperationCallable() {
    return stub.updateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Backend services overview .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionBackendServicesClient regionBackendServicesClient =
   *     RegionBackendServicesClient.create()) {
   *   UpdateRegionBackendServiceRequest request =
   *       UpdateRegionBackendServiceRequest.newBuilder()
   *           .setBackendService("backendService-1884714623")
   *           .setBackendServiceResource(BackendService.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionBackendServicesClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRegionBackendServiceRequest, Operation> updateCallable() {
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
          ListRegionBackendServicesRequest,
          BackendServiceList,
          BackendService,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionBackendServicesRequest, BackendServiceList, BackendService> context,
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
          ListRegionBackendServicesRequest, BackendServiceList, BackendService, ListPage> {

    private ListPage(
        PageContext<ListRegionBackendServicesRequest, BackendServiceList, BackendService> context,
        BackendServiceList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionBackendServicesRequest, BackendServiceList, BackendService> context,
        BackendServiceList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionBackendServicesRequest, BackendServiceList, BackendService> context,
        ApiFuture<BackendServiceList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionBackendServicesRequest,
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

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
import com.google.cloud.compute.v1.stub.RegionTargetTcpProxiesStub;
import com.google.cloud.compute.v1.stub.RegionTargetTcpProxiesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionTargetTcpProxies API.
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
 * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
 *     RegionTargetTcpProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String targetTcpProxy = "targetTcpProxy-337144898";
 *   TargetTcpProxy response = regionTargetTcpProxiesClient.get(project, region, targetTcpProxy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionTargetTcpProxiesClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of RegionTargetTcpProxiesSettings
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
 * RegionTargetTcpProxiesSettings regionTargetTcpProxiesSettings =
 *     RegionTargetTcpProxiesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
 *     RegionTargetTcpProxiesClient.create(regionTargetTcpProxiesSettings);
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
 * RegionTargetTcpProxiesSettings regionTargetTcpProxiesSettings =
 *     RegionTargetTcpProxiesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
 *     RegionTargetTcpProxiesClient.create(regionTargetTcpProxiesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionTargetTcpProxiesClient implements BackgroundResource {
  private final RegionTargetTcpProxiesSettings settings;
  private final RegionTargetTcpProxiesStub stub;

  /** Constructs an instance of RegionTargetTcpProxiesClient with default settings. */
  public static final RegionTargetTcpProxiesClient create() throws IOException {
    return create(RegionTargetTcpProxiesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionTargetTcpProxiesClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionTargetTcpProxiesClient create(RegionTargetTcpProxiesSettings settings)
      throws IOException {
    return new RegionTargetTcpProxiesClient(settings);
  }

  /**
   * Constructs an instance of RegionTargetTcpProxiesClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(RegionTargetTcpProxiesSettings).
   */
  public static final RegionTargetTcpProxiesClient create(RegionTargetTcpProxiesStub stub) {
    return new RegionTargetTcpProxiesClient(stub);
  }

  /**
   * Constructs an instance of RegionTargetTcpProxiesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionTargetTcpProxiesClient(RegionTargetTcpProxiesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionTargetTcpProxiesStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionTargetTcpProxiesClient(RegionTargetTcpProxiesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionTargetTcpProxiesSettings getSettings() {
    return settings;
  }

  public RegionTargetTcpProxiesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetTcpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetTcpProxy = "targetTcpProxy-337144898";
   *   Operation response =
   *       regionTargetTcpProxiesClient.deleteAsync(project, region, targetTcpProxy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetTcpProxy Name of the TargetTcpProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String targetTcpProxy) {
    DeleteRegionTargetTcpProxyRequest request =
        DeleteRegionTargetTcpProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetTcpProxy(targetTcpProxy)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetTcpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   DeleteRegionTargetTcpProxyRequest request =
   *       DeleteRegionTargetTcpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetTcpProxy("targetTcpProxy-337144898")
   *           .build();
   *   Operation response = regionTargetTcpProxiesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionTargetTcpProxyRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetTcpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   DeleteRegionTargetTcpProxyRequest request =
   *       DeleteRegionTargetTcpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetTcpProxy("targetTcpProxy-337144898")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionTargetTcpProxiesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionTargetTcpProxyRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified TargetTcpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   DeleteRegionTargetTcpProxyRequest request =
   *       DeleteRegionTargetTcpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetTcpProxy("targetTcpProxy-337144898")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionTargetTcpProxiesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionTargetTcpProxyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetTcpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetTcpProxy = "targetTcpProxy-337144898";
   *   TargetTcpProxy response = regionTargetTcpProxiesClient.get(project, region, targetTcpProxy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetTcpProxy Name of the TargetTcpProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetTcpProxy get(String project, String region, String targetTcpProxy) {
    GetRegionTargetTcpProxyRequest request =
        GetRegionTargetTcpProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetTcpProxy(targetTcpProxy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetTcpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   GetRegionTargetTcpProxyRequest request =
   *       GetRegionTargetTcpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setTargetTcpProxy("targetTcpProxy-337144898")
   *           .build();
   *   TargetTcpProxy response = regionTargetTcpProxiesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetTcpProxy get(GetRegionTargetTcpProxyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetTcpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   GetRegionTargetTcpProxyRequest request =
   *       GetRegionTargetTcpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setTargetTcpProxy("targetTcpProxy-337144898")
   *           .build();
   *   ApiFuture<TargetTcpProxy> future =
   *       regionTargetTcpProxiesClient.getCallable().futureCall(request);
   *   // Do something.
   *   TargetTcpProxy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionTargetTcpProxyRequest, TargetTcpProxy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetTcpProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   TargetTcpProxy targetTcpProxyResource = TargetTcpProxy.newBuilder().build();
   *   Operation response =
   *       regionTargetTcpProxiesClient.insertAsync(project, region, targetTcpProxyResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetTcpProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, TargetTcpProxy targetTcpProxyResource) {
    InsertRegionTargetTcpProxyRequest request =
        InsertRegionTargetTcpProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetTcpProxyResource(targetTcpProxyResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetTcpProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   InsertRegionTargetTcpProxyRequest request =
   *       InsertRegionTargetTcpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetTcpProxyResource(TargetTcpProxy.newBuilder().build())
   *           .build();
   *   Operation response = regionTargetTcpProxiesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionTargetTcpProxyRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetTcpProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   InsertRegionTargetTcpProxyRequest request =
   *       InsertRegionTargetTcpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetTcpProxyResource(TargetTcpProxy.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionTargetTcpProxiesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionTargetTcpProxyRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetTcpProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   InsertRegionTargetTcpProxyRequest request =
   *       InsertRegionTargetTcpProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetTcpProxyResource(TargetTcpProxy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionTargetTcpProxiesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionTargetTcpProxyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of TargetTcpProxy resources available to the specified project in a given
   * region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (TargetTcpProxy element :
   *       regionTargetTcpProxiesClient.list(project, region).iterateAll()) {
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
    ListRegionTargetTcpProxiesRequest request =
        ListRegionTargetTcpProxiesRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of TargetTcpProxy resources available to the specified project in a given
   * region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   ListRegionTargetTcpProxiesRequest request =
   *       ListRegionTargetTcpProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (TargetTcpProxy element : regionTargetTcpProxiesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionTargetTcpProxiesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of TargetTcpProxy resources available to the specified project in a given
   * region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   ListRegionTargetTcpProxiesRequest request =
   *       ListRegionTargetTcpProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<TargetTcpProxy> future =
   *       regionTargetTcpProxiesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TargetTcpProxy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionTargetTcpProxiesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of TargetTcpProxy resources available to the specified project in a given
   * region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
   *     RegionTargetTcpProxiesClient.create()) {
   *   ListRegionTargetTcpProxiesRequest request =
   *       ListRegionTargetTcpProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     TargetTcpProxyList response = regionTargetTcpProxiesClient.listCallable().call(request);
   *     for (TargetTcpProxy element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionTargetTcpProxiesRequest, TargetTcpProxyList> listCallable() {
    return stub.listCallable();
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
          ListRegionTargetTcpProxiesRequest,
          TargetTcpProxyList,
          TargetTcpProxy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionTargetTcpProxiesRequest, TargetTcpProxyList, TargetTcpProxy> context,
        ApiFuture<TargetTcpProxyList> futureResponse) {
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
          ListRegionTargetTcpProxiesRequest, TargetTcpProxyList, TargetTcpProxy, ListPage> {

    private ListPage(
        PageContext<ListRegionTargetTcpProxiesRequest, TargetTcpProxyList, TargetTcpProxy> context,
        TargetTcpProxyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionTargetTcpProxiesRequest, TargetTcpProxyList, TargetTcpProxy> context,
        TargetTcpProxyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionTargetTcpProxiesRequest, TargetTcpProxyList, TargetTcpProxy> context,
        ApiFuture<TargetTcpProxyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionTargetTcpProxiesRequest,
          TargetTcpProxyList,
          TargetTcpProxy,
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

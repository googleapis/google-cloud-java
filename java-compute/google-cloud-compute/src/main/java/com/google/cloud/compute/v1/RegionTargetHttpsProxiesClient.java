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
import com.google.cloud.compute.v1.stub.RegionTargetHttpsProxiesStub;
import com.google.cloud.compute.v1.stub.RegionTargetHttpsProxiesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionTargetHttpsProxies API.
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
 * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
 *     RegionTargetHttpsProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String targetHttpsProxy = "targetHttpsProxy833943732";
 *   TargetHttpsProxy response =
 *       regionTargetHttpsProxiesClient.get(project, region, targetHttpsProxy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionTargetHttpsProxiesClient object to clean up
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
 * RegionTargetHttpsProxiesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionTargetHttpsProxiesSettings regionTargetHttpsProxiesSettings =
 *     RegionTargetHttpsProxiesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
 *     RegionTargetHttpsProxiesClient.create(regionTargetHttpsProxiesSettings);
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
 * RegionTargetHttpsProxiesSettings regionTargetHttpsProxiesSettings =
 *     RegionTargetHttpsProxiesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
 *     RegionTargetHttpsProxiesClient.create(regionTargetHttpsProxiesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionTargetHttpsProxiesClient implements BackgroundResource {
  private final RegionTargetHttpsProxiesSettings settings;
  private final RegionTargetHttpsProxiesStub stub;

  /** Constructs an instance of RegionTargetHttpsProxiesClient with default settings. */
  public static final RegionTargetHttpsProxiesClient create() throws IOException {
    return create(RegionTargetHttpsProxiesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionTargetHttpsProxiesClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionTargetHttpsProxiesClient create(
      RegionTargetHttpsProxiesSettings settings) throws IOException {
    return new RegionTargetHttpsProxiesClient(settings);
  }

  /**
   * Constructs an instance of RegionTargetHttpsProxiesClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(RegionTargetHttpsProxiesSettings).
   */
  public static final RegionTargetHttpsProxiesClient create(RegionTargetHttpsProxiesStub stub) {
    return new RegionTargetHttpsProxiesClient(stub);
  }

  /**
   * Constructs an instance of RegionTargetHttpsProxiesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionTargetHttpsProxiesClient(RegionTargetHttpsProxiesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionTargetHttpsProxiesStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionTargetHttpsProxiesClient(RegionTargetHttpsProxiesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionTargetHttpsProxiesSettings getSettings() {
    return settings;
  }

  public RegionTargetHttpsProxiesStub getStub() {
    return stub;
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetHttpsProxy = "targetHttpsProxy833943732";
   *   Operation response =
   *       regionTargetHttpsProxiesClient.deleteAsync(project, region, targetHttpsProxy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String targetHttpsProxy) {
    DeleteRegionTargetHttpsProxyRequest request =
        DeleteRegionTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   DeleteRegionTargetHttpsProxyRequest request =
   *       DeleteRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   Operation response = regionTargetHttpsProxiesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionTargetHttpsProxyRequest request) {
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   DeleteRegionTargetHttpsProxyRequest request =
   *       DeleteRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionTargetHttpsProxiesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionTargetHttpsProxyRequest, Operation, Operation>
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   DeleteRegionTargetHttpsProxyRequest request =
   *       DeleteRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionTargetHttpsProxiesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionTargetHttpsProxyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetHttpsProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetHttpsProxy = "targetHttpsProxy833943732";
   *   TargetHttpsProxy response =
   *       regionTargetHttpsProxiesClient.get(project, region, targetHttpsProxy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetHttpsProxy get(String project, String region, String targetHttpsProxy) {
    GetRegionTargetHttpsProxyRequest request =
        GetRegionTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetHttpsProxy(targetHttpsProxy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetHttpsProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   GetRegionTargetHttpsProxyRequest request =
   *       GetRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   TargetHttpsProxy response = regionTargetHttpsProxiesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetHttpsProxy get(GetRegionTargetHttpsProxyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified TargetHttpsProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   GetRegionTargetHttpsProxyRequest request =
   *       GetRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   ApiFuture<TargetHttpsProxy> future =
   *       regionTargetHttpsProxiesClient.getCallable().futureCall(request);
   *   // Do something.
   *   TargetHttpsProxy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetHttpsProxy resource in the specified project and region using the data included
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   TargetHttpsProxy targetHttpsProxyResource = TargetHttpsProxy.newBuilder().build();
   *   Operation response =
   *       regionTargetHttpsProxiesClient
   *           .insertAsync(project, region, targetHttpsProxyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetHttpsProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, TargetHttpsProxy targetHttpsProxyResource) {
    InsertRegionTargetHttpsProxyRequest request =
        InsertRegionTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetHttpsProxyResource(targetHttpsProxyResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetHttpsProxy resource in the specified project and region using the data included
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   InsertRegionTargetHttpsProxyRequest request =
   *       InsertRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxyResource(TargetHttpsProxy.newBuilder().build())
   *           .build();
   *   Operation response = regionTargetHttpsProxiesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionTargetHttpsProxyRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetHttpsProxy resource in the specified project and region using the data included
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   InsertRegionTargetHttpsProxyRequest request =
   *       InsertRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxyResource(TargetHttpsProxy.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionTargetHttpsProxiesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionTargetHttpsProxyRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TargetHttpsProxy resource in the specified project and region using the data included
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   InsertRegionTargetHttpsProxyRequest request =
   *       InsertRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxyResource(TargetHttpsProxy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionTargetHttpsProxiesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionTargetHttpsProxyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (TargetHttpsProxy element :
   *       regionTargetHttpsProxiesClient.list(project, region).iterateAll()) {
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
    ListRegionTargetHttpsProxiesRequest request =
        ListRegionTargetHttpsProxiesRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   ListRegionTargetHttpsProxiesRequest request =
   *       ListRegionTargetHttpsProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (TargetHttpsProxy element : regionTargetHttpsProxiesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionTargetHttpsProxiesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   ListRegionTargetHttpsProxiesRequest request =
   *       ListRegionTargetHttpsProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<TargetHttpsProxy> future =
   *       regionTargetHttpsProxiesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TargetHttpsProxy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionTargetHttpsProxiesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   ListRegionTargetHttpsProxiesRequest request =
   *       ListRegionTargetHttpsProxiesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     TargetHttpsProxyList response = regionTargetHttpsProxiesClient.listCallable().call(request);
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
  public final UnaryCallable<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified regional TargetHttpsProxy resource with the data included in the request.
   * This method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetHttpsProxy = "targetHttpsProxy833943732";
   *   TargetHttpsProxy targetHttpsProxyResource = TargetHttpsProxy.newBuilder().build();
   *   Operation response =
   *       regionTargetHttpsProxiesClient
   *           .patchAsync(project, region, targetHttpsProxy, targetHttpsProxyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to patch.
   * @param targetHttpsProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project,
      String region,
      String targetHttpsProxy,
      TargetHttpsProxy targetHttpsProxyResource) {
    PatchRegionTargetHttpsProxyRequest request =
        PatchRegionTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetHttpsProxy(targetHttpsProxy)
            .setTargetHttpsProxyResource(targetHttpsProxyResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified regional TargetHttpsProxy resource with the data included in the request.
   * This method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   PatchRegionTargetHttpsProxyRequest request =
   *       PatchRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .setTargetHttpsProxyResource(TargetHttpsProxy.newBuilder().build())
   *           .build();
   *   Operation response = regionTargetHttpsProxiesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchRegionTargetHttpsProxyRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified regional TargetHttpsProxy resource with the data included in the request.
   * This method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   PatchRegionTargetHttpsProxyRequest request =
   *       PatchRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .setTargetHttpsProxyResource(TargetHttpsProxy.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionTargetHttpsProxiesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRegionTargetHttpsProxyRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified regional TargetHttpsProxy resource with the data included in the request.
   * This method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   PatchRegionTargetHttpsProxyRequest request =
   *       PatchRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .setTargetHttpsProxyResource(TargetHttpsProxy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionTargetHttpsProxiesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRegionTargetHttpsProxyRequest, Operation> patchCallable() {
    return stub.patchCallable();
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetHttpsProxy = "targetHttpsProxy833943732";
   *   RegionTargetHttpsProxiesSetSslCertificatesRequest
   *       regionTargetHttpsProxiesSetSslCertificatesRequestResource =
   *           RegionTargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build();
   *   Operation response =
   *       regionTargetHttpsProxiesClient
   *           .setSslCertificatesAsync(
   *               project,
   *               region,
   *               targetHttpsProxy,
   *               regionTargetHttpsProxiesSetSslCertificatesRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to set an SslCertificates
   *     resource for.
   * @param regionTargetHttpsProxiesSetSslCertificatesRequestResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setSslCertificatesAsync(
      String project,
      String region,
      String targetHttpsProxy,
      RegionTargetHttpsProxiesSetSslCertificatesRequest
          regionTargetHttpsProxiesSetSslCertificatesRequestResource) {
    SetSslCertificatesRegionTargetHttpsProxyRequest request =
        SetSslCertificatesRegionTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetHttpsProxy(targetHttpsProxy)
            .setRegionTargetHttpsProxiesSetSslCertificatesRequestResource(
                regionTargetHttpsProxiesSetSslCertificatesRequestResource)
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   SetSslCertificatesRegionTargetHttpsProxyRequest request =
   *       SetSslCertificatesRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionTargetHttpsProxiesSetSslCertificatesRequestResource(
   *               RegionTargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   Operation response = regionTargetHttpsProxiesClient.setSslCertificatesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setSslCertificatesAsync(
      SetSslCertificatesRegionTargetHttpsProxyRequest request) {
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   SetSslCertificatesRegionTargetHttpsProxyRequest request =
   *       SetSslCertificatesRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionTargetHttpsProxiesSetSslCertificatesRequestResource(
   *               RegionTargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionTargetHttpsProxiesClient.setSslCertificatesOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          SetSslCertificatesRegionTargetHttpsProxyRequest, Operation, Operation>
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   SetSslCertificatesRegionTargetHttpsProxyRequest request =
   *       SetSslCertificatesRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionTargetHttpsProxiesSetSslCertificatesRequestResource(
   *               RegionTargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionTargetHttpsProxiesClient.setSslCertificatesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>
      setSslCertificatesCallable() {
    return stub.setSslCertificatesCallable();
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetHttpsProxy = "targetHttpsProxy833943732";
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   Operation response =
   *       regionTargetHttpsProxiesClient
   *           .setUrlMapAsync(project, region, targetHttpsProxy, urlMapReferenceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy to set a URL map for.
   * @param urlMapReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setUrlMapAsync(
      String project,
      String region,
      String targetHttpsProxy,
      UrlMapReference urlMapReferenceResource) {
    SetUrlMapRegionTargetHttpsProxyRequest request =
        SetUrlMapRegionTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   SetUrlMapRegionTargetHttpsProxyRequest request =
   *       SetUrlMapRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .setUrlMapReferenceResource(UrlMapReference.newBuilder().build())
   *           .build();
   *   Operation response = regionTargetHttpsProxiesClient.setUrlMapAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setUrlMapAsync(
      SetUrlMapRegionTargetHttpsProxyRequest request) {
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   SetUrlMapRegionTargetHttpsProxyRequest request =
   *       SetUrlMapRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .setUrlMapReferenceResource(UrlMapReference.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionTargetHttpsProxiesClient.setUrlMapOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetUrlMapRegionTargetHttpsProxyRequest, Operation, Operation>
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
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
   *     RegionTargetHttpsProxiesClient.create()) {
   *   SetUrlMapRegionTargetHttpsProxyRequest request =
   *       SetUrlMapRegionTargetHttpsProxyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetHttpsProxy("targetHttpsProxy833943732")
   *           .setUrlMapReferenceResource(UrlMapReference.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionTargetHttpsProxiesClient.setUrlMapCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetUrlMapRegionTargetHttpsProxyRequest, Operation>
      setUrlMapCallable() {
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListRegionTargetHttpsProxiesRequest,
          TargetHttpsProxyList,
          TargetHttpsProxy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy>
            context,
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
          ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy, ListPage> {

    private ListPage(
        PageContext<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy>
            context,
        TargetHttpsProxyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy>
            context,
        TargetHttpsProxyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy>
            context,
        ApiFuture<TargetHttpsProxyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionTargetHttpsProxiesRequest,
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

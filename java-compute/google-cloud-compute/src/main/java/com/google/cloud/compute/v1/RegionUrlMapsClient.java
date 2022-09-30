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
import com.google.cloud.compute.v1.stub.RegionUrlMapsStub;
import com.google.cloud.compute.v1.stub.RegionUrlMapsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionUrlMaps API.
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
 * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String urlMap = "urlMap-836780691";
 *   UrlMap response = regionUrlMapsClient.get(project, region, urlMap);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionUrlMapsClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of RegionUrlMapsSettings to
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
 * RegionUrlMapsSettings regionUrlMapsSettings =
 *     RegionUrlMapsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create(regionUrlMapsSettings);
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
 * RegionUrlMapsSettings regionUrlMapsSettings =
 *     RegionUrlMapsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create(regionUrlMapsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionUrlMapsClient implements BackgroundResource {
  private final RegionUrlMapsSettings settings;
  private final RegionUrlMapsStub stub;

  /** Constructs an instance of RegionUrlMapsClient with default settings. */
  public static final RegionUrlMapsClient create() throws IOException {
    return create(RegionUrlMapsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionUrlMapsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionUrlMapsClient create(RegionUrlMapsSettings settings)
      throws IOException {
    return new RegionUrlMapsClient(settings);
  }

  /**
   * Constructs an instance of RegionUrlMapsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(RegionUrlMapsSettings).
   */
  public static final RegionUrlMapsClient create(RegionUrlMapsStub stub) {
    return new RegionUrlMapsClient(stub);
  }

  /**
   * Constructs an instance of RegionUrlMapsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionUrlMapsClient(RegionUrlMapsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionUrlMapsStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionUrlMapsClient(RegionUrlMapsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionUrlMapsSettings getSettings() {
    return settings;
  }

  public RegionUrlMapsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String urlMap = "urlMap-836780691";
   *   Operation response = regionUrlMapsClient.deleteAsync(project, region, urlMap).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param urlMap Name of the UrlMap resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String urlMap) {
    DeleteRegionUrlMapRequest request =
        DeleteRegionUrlMapRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setUrlMap(urlMap)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   DeleteRegionUrlMapRequest request =
   *       DeleteRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   Operation response = regionUrlMapsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionUrlMapRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   DeleteRegionUrlMapRequest request =
   *       DeleteRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionUrlMapsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionUrlMapRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   DeleteRegionUrlMapRequest request =
   *       DeleteRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   ApiFuture<Operation> future = regionUrlMapsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionUrlMapRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
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
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String urlMap = "urlMap-836780691";
   *   UrlMap response = regionUrlMapsClient.get(project, region, urlMap);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param urlMap Name of the UrlMap resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMap get(String project, String region, String urlMap) {
    GetRegionUrlMapRequest request =
        GetRegionUrlMapRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setUrlMap(urlMap)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
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
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   GetRegionUrlMapRequest request =
   *       GetRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   UrlMap response = regionUrlMapsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMap get(GetRegionUrlMapRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
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
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   GetRegionUrlMapRequest request =
   *       GetRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   ApiFuture<UrlMap> future = regionUrlMapsClient.getCallable().futureCall(request);
   *   // Do something.
   *   UrlMap response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionUrlMapRequest, UrlMap> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = regionUrlMapsClient.insertAsync(project, region, urlMapResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param urlMapResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, UrlMap urlMapResource) {
    InsertRegionUrlMapRequest request =
        InsertRegionUrlMapRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setUrlMapResource(urlMapResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   InsertRegionUrlMapRequest request =
   *       InsertRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   Operation response = regionUrlMapsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionUrlMapRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   InsertRegionUrlMapRequest request =
   *       InsertRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionUrlMapsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionUrlMapRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   InsertRegionUrlMapRequest request =
   *       InsertRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = regionUrlMapsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionUrlMapRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of UrlMap resources available to the specified project in the specified
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
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (UrlMap element : regionUrlMapsClient.list(project, region).iterateAll()) {
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
    ListRegionUrlMapsRequest request =
        ListRegionUrlMapsRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of UrlMap resources available to the specified project in the specified
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
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   ListRegionUrlMapsRequest request =
   *       ListRegionUrlMapsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (UrlMap element : regionUrlMapsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionUrlMapsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of UrlMap resources available to the specified project in the specified
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
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   ListRegionUrlMapsRequest request =
   *       ListRegionUrlMapsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<UrlMap> future = regionUrlMapsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UrlMap element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionUrlMapsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of UrlMap resources available to the specified project in the specified
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
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   ListRegionUrlMapsRequest request =
   *       ListRegionUrlMapsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     UrlMapList response = regionUrlMapsClient.listCallable().call(request);
   *     for (UrlMap element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionUrlMapsRequest, UrlMapList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String urlMap = "urlMap-836780691";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response =
   *       regionUrlMapsClient.patchAsync(project, region, urlMap, urlMapResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param urlMap Name of the UrlMap resource to patch.
   * @param urlMapResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String region, String urlMap, UrlMap urlMapResource) {
    PatchRegionUrlMapRequest request =
        PatchRegionUrlMapRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setUrlMap(urlMap)
            .setUrlMapResource(urlMapResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   PatchRegionUrlMapRequest request =
   *       PatchRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   Operation response = regionUrlMapsClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(PatchRegionUrlMapRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   PatchRegionUrlMapRequest request =
   *       PatchRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionUrlMapsClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRegionUrlMapRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   PatchRegionUrlMapRequest request =
   *       PatchRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = regionUrlMapsClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRegionUrlMapRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String urlMap = "urlMap-836780691";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response =
   *       regionUrlMapsClient.updateAsync(project, region, urlMap, urlMapResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param urlMap Name of the UrlMap resource to update.
   * @param urlMapResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      String project, String region, String urlMap, UrlMap urlMapResource) {
    UpdateRegionUrlMapRequest request =
        UpdateRegionUrlMapRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setUrlMap(urlMap)
            .setUrlMapResource(urlMapResource)
            .build();
    return updateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   UpdateRegionUrlMapRequest request =
   *       UpdateRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   Operation response = regionUrlMapsClient.updateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> updateAsync(
      UpdateRegionUrlMapRequest request) {
    return updateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   UpdateRegionUrlMapRequest request =
   *       UpdateRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionUrlMapsClient.updateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRegionUrlMapRequest, Operation, Operation>
      updateOperationCallable() {
    return stub.updateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   UpdateRegionUrlMapRequest request =
   *       UpdateRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = regionUrlMapsClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRegionUrlMapRequest, Operation> updateCallable() {
    return stub.updateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String urlMap = "urlMap-836780691";
   *   RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource =
   *       RegionUrlMapsValidateRequest.newBuilder().build();
   *   UrlMapsValidateResponse response =
   *       regionUrlMapsClient.validate(
   *           project, region, urlMap, regionUrlMapsValidateRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param urlMap Name of the UrlMap resource to be validated as.
   * @param regionUrlMapsValidateRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMapsValidateResponse validate(
      String project,
      String region,
      String urlMap,
      RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource) {
    ValidateRegionUrlMapRequest request =
        ValidateRegionUrlMapRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setUrlMap(urlMap)
            .setRegionUrlMapsValidateRequestResource(regionUrlMapsValidateRequestResource)
            .build();
    return validate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   ValidateRegionUrlMapRequest request =
   *       ValidateRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionUrlMapsValidateRequestResource(
   *               RegionUrlMapsValidateRequest.newBuilder().build())
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   UrlMapsValidateResponse response = regionUrlMapsClient.validate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMapsValidateResponse validate(ValidateRegionUrlMapRequest request) {
    return validateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   ValidateRegionUrlMapRequest request =
   *       ValidateRegionUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionUrlMapsValidateRequestResource(
   *               RegionUrlMapsValidateRequest.newBuilder().build())
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   ApiFuture<UrlMapsValidateResponse> future =
   *       regionUrlMapsClient.validateCallable().futureCall(request);
   *   // Do something.
   *   UrlMapsValidateResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ValidateRegionUrlMapRequest, UrlMapsValidateResponse>
      validateCallable() {
    return stub.validateCallable();
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
          ListRegionUrlMapsRequest, UrlMapList, UrlMap, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionUrlMapsRequest, UrlMapList, UrlMap> context,
        ApiFuture<UrlMapList> futureResponse) {
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
      extends AbstractPage<ListRegionUrlMapsRequest, UrlMapList, UrlMap, ListPage> {

    private ListPage(
        PageContext<ListRegionUrlMapsRequest, UrlMapList, UrlMap> context, UrlMapList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionUrlMapsRequest, UrlMapList, UrlMap> context, UrlMapList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionUrlMapsRequest, UrlMapList, UrlMap> context,
        ApiFuture<UrlMapList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionUrlMapsRequest, UrlMapList, UrlMap, ListPage, ListFixedSizeCollection> {

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

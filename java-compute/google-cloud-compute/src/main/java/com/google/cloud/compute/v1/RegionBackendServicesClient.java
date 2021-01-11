/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.RegionBackendServicesStub;
import com.google.cloud.compute.v1.stub.RegionBackendServicesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The RegionBackendServices API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String backendService = "";
 *   Operation response = regionBackendServicesClient.delete(project, region, backendService);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionBackendServicesClient object to clean up
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
 * <pre>
 * <code>
 * RegionBackendServicesSettings regionBackendServicesSettings =
 *     RegionBackendServicesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionBackendServicesClient regionBackendServicesClient =
 *     RegionBackendServicesClient.create(regionBackendServicesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionBackendServicesSettings regionBackendServicesSettings =
 *     RegionBackendServicesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionBackendServicesClient regionBackendServicesClient =
 *     RegionBackendServicesClient.create(regionBackendServicesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
   * This is for advanced usage - prefer to use RegionBackendServicesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionBackendServicesClient(RegionBackendServicesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionBackendServicesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionBackendServicesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified regional BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String backendService = "";
   *   Operation response = regionBackendServicesClient.delete(project, region, backendService);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param backendService Name of the BackendService resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String backendService) {
    DeleteRegionBackendServiceRequest request =
        DeleteRegionBackendServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setBackendService(backendService)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified regional BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   String region = "";
   *   DeleteRegionBackendServiceRequest request = DeleteRegionBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionBackendServicesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteRegionBackendServiceRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified regional BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   String region = "";
   *   DeleteRegionBackendServiceRequest request = DeleteRegionBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionBackendServicesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteRegionBackendServiceRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String backendService = "";
   *   BackendService response = regionBackendServicesClient.get(project, region, backendService);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   String region = "";
   *   GetRegionBackendServiceRequest request = GetRegionBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   BackendService response = regionBackendServicesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendService get(GetRegionBackendServiceRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional BackendService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   String region = "";
   *   GetRegionBackendServiceRequest request = GetRegionBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;BackendService&gt; future = regionBackendServicesClient.getCallable().futureCall(request);
   *   // Do something
   *   BackendService response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetRegionBackendServiceRequest, BackendService> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the most recent health check results for this regional BackendService.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String backendService = "";
   *   ResourceGroupReference resourceGroupReferenceResource = ResourceGroupReference.newBuilder().build();
   *   BackendServiceGroupHealth response = regionBackendServicesClient.getHealth(project, region, backendService, resourceGroupReferenceResource);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the most recent health check results for this regional BackendService.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   String region = "";
   *   ResourceGroupReference resourceGroupReferenceResource = ResourceGroupReference.newBuilder().build();
   *   GetHealthRegionBackendServiceRequest request = GetHealthRegionBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResourceGroupReferenceResource(resourceGroupReferenceResource)
   *     .build();
   *   BackendServiceGroupHealth response = regionBackendServicesClient.getHealth(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendServiceGroupHealth getHealth(GetHealthRegionBackendServiceRequest request) {
    return getHealthCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the most recent health check results for this regional BackendService.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String backendService = "";
   *   String project = "";
   *   String region = "";
   *   ResourceGroupReference resourceGroupReferenceResource = ResourceGroupReference.newBuilder().build();
   *   GetHealthRegionBackendServiceRequest request = GetHealthRegionBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResourceGroupReferenceResource(resourceGroupReferenceResource)
   *     .build();
   *   ApiFuture&lt;BackendServiceGroupHealth&gt; future = regionBackendServicesClient.getHealthCallable().futureCall(request);
   *   // Do something
   *   BackendServiceGroupHealth response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetHealthRegionBackendServiceRequest, BackendServiceGroupHealth>
      getHealthCallable() {
    return stub.getHealthCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a regional BackendService resource in the specified project using the data included in
   * the request. For more information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   Operation response = regionBackendServicesClient.insert(project, region, backendServiceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param backendServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, String region, BackendService backendServiceResource) {
    InsertRegionBackendServiceRequest request =
        InsertRegionBackendServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setBackendServiceResource(backendServiceResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a regional BackendService resource in the specified project using the data included in
   * the request. For more information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertRegionBackendServiceRequest request = InsertRegionBackendServiceRequest.newBuilder()
   *     .setBackendServiceResource(backendServiceResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionBackendServicesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertRegionBackendServiceRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a regional BackendService resource in the specified project using the data included in
   * the request. For more information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertRegionBackendServiceRequest request = InsertRegionBackendServiceRequest.newBuilder()
   *     .setBackendServiceResource(backendServiceResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionBackendServicesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertRegionBackendServiceRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of regional BackendService resources available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (BackendService element : regionBackendServicesClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of regional BackendService resources available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionBackendServicesRequest request = ListRegionBackendServicesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (BackendService element : regionBackendServicesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionBackendServicesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of regional BackendService resources available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionBackendServicesRequest request = ListRegionBackendServicesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = regionBackendServicesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (BackendService element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListRegionBackendServicesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of regional BackendService resources available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionBackendServicesRequest request = ListRegionBackendServicesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
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
   * </code></pre>
   */
  public final UnaryCallable<ListRegionBackendServicesRequest, BackendServiceList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Understanding backend services This method supports PATCH semantics
   * and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String backendService = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   Operation response = regionBackendServicesClient.patch(project, region, backendService, backendServiceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param backendService Name of the BackendService resource to patch.
   * @param backendServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project, String region, String backendService, BackendService backendServiceResource) {
    PatchRegionBackendServiceRequest request =
        PatchRegionBackendServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setBackendService(backendService)
            .setBackendServiceResource(backendServiceResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Understanding backend services This method supports PATCH semantics
   * and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String backendService = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchRegionBackendServiceRequest request = PatchRegionBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setBackendServiceResource(backendServiceResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionBackendServicesClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchRegionBackendServiceRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Understanding backend services This method supports PATCH semantics
   * and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String backendService = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchRegionBackendServiceRequest request = PatchRegionBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setBackendServiceResource(backendServiceResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionBackendServicesClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchRegionBackendServiceRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String backendService = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   Operation response = regionBackendServicesClient.update(project, region, backendService, backendServiceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param backendService Name of the BackendService resource to update.
   * @param backendServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(
      String project, String region, String backendService, BackendService backendServiceResource) {
    UpdateRegionBackendServiceRequest request =
        UpdateRegionBackendServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setBackendService(backendService)
            .setBackendServiceResource(backendServiceResource)
            .build();
    return update(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String backendService = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   UpdateRegionBackendServiceRequest request = UpdateRegionBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setBackendServiceResource(backendServiceResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionBackendServicesClient.update(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(UpdateRegionBackendServiceRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified regional BackendService resource with the data included in the request.
   * For more information, see Backend services overview.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
   *   String backendService = "";
   *   BackendService backendServiceResource = BackendService.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   UpdateRegionBackendServiceRequest request = UpdateRegionBackendServiceRequest.newBuilder()
   *     .setBackendService(backendService)
   *     .setBackendServiceResource(backendServiceResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionBackendServicesClient.updateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
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
          futurePage,
          new ApiFunction<ListPage, ListPagedResponse>() {
            @Override
            public ListPagedResponse apply(ListPage input) {
              return new ListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
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

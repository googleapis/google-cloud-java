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
import com.google.cloud.compute.v1.stub.RegionHealthCheckServicesStub;
import com.google.cloud.compute.v1.stub.RegionHealthCheckServicesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The RegionHealthCheckServices API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String healthCheckService = "";
 *   Operation response = regionHealthCheckServicesClient.delete(project, region, healthCheckService);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionHealthCheckServicesClient object to clean up
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
 * <pre>
 * <code>
 * RegionHealthCheckServicesSettings regionHealthCheckServicesSettings =
 *     RegionHealthCheckServicesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionHealthCheckServicesClient regionHealthCheckServicesClient =
 *     RegionHealthCheckServicesClient.create(regionHealthCheckServicesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionHealthCheckServicesSettings regionHealthCheckServicesSettings =
 *     RegionHealthCheckServicesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionHealthCheckServicesClient regionHealthCheckServicesClient =
 *     RegionHealthCheckServicesClient.create(regionHealthCheckServicesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
   * calls. This is for advanced usage - prefer to use RegionHealthCheckServicesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionHealthCheckServicesClient(RegionHealthCheckServicesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionHealthCheckServicesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionHealthCheckServicesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified regional HealthCheckService.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String healthCheckService = "";
   *   Operation response = regionHealthCheckServicesClient.delete(project, region, healthCheckService);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthCheckService Name of the HealthCheckService to delete. The name must be 1-63
   *     characters long, and comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String healthCheckService) {
    DeleteRegionHealthCheckServiceRequest request =
        DeleteRegionHealthCheckServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthCheckService(healthCheckService)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified regional HealthCheckService.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String healthCheckService = "";
   *   String project = "";
   *   String region = "";
   *   DeleteRegionHealthCheckServiceRequest request = DeleteRegionHealthCheckServiceRequest.newBuilder()
   *     .setHealthCheckService(healthCheckService)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionHealthCheckServicesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteRegionHealthCheckServiceRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified regional HealthCheckService.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String healthCheckService = "";
   *   String project = "";
   *   String region = "";
   *   DeleteRegionHealthCheckServiceRequest request = DeleteRegionHealthCheckServiceRequest.newBuilder()
   *     .setHealthCheckService(healthCheckService)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionHealthCheckServicesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteRegionHealthCheckServiceRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional HealthCheckService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String healthCheckService = "";
   *   HealthCheckService response = regionHealthCheckServicesClient.get(project, region, healthCheckService);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional HealthCheckService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String healthCheckService = "";
   *   String project = "";
   *   String region = "";
   *   GetRegionHealthCheckServiceRequest request = GetRegionHealthCheckServiceRequest.newBuilder()
   *     .setHealthCheckService(healthCheckService)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   HealthCheckService response = regionHealthCheckServicesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HealthCheckService get(GetRegionHealthCheckServiceRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional HealthCheckService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String healthCheckService = "";
   *   String project = "";
   *   String region = "";
   *   GetRegionHealthCheckServiceRequest request = GetRegionHealthCheckServiceRequest.newBuilder()
   *     .setHealthCheckService(healthCheckService)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;HealthCheckService&gt; future = regionHealthCheckServicesClient.getCallable().futureCall(request);
   *   // Do something
   *   HealthCheckService response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetRegionHealthCheckServiceRequest, HealthCheckService> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a regional HealthCheckService resource in the specified project and region using the
   * data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   Operation response = regionHealthCheckServicesClient.insert(project, region, healthCheckServiceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthCheckServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, String region, HealthCheckService healthCheckServiceResource) {
    InsertRegionHealthCheckServiceRequest request =
        InsertRegionHealthCheckServiceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setHealthCheckServiceResource(healthCheckServiceResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a regional HealthCheckService resource in the specified project and region using the
   * data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertRegionHealthCheckServiceRequest request = InsertRegionHealthCheckServiceRequest.newBuilder()
   *     .setHealthCheckServiceResource(healthCheckServiceResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionHealthCheckServicesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertRegionHealthCheckServiceRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a regional HealthCheckService resource in the specified project and region using the
   * data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertRegionHealthCheckServiceRequest request = InsertRegionHealthCheckServiceRequest.newBuilder()
   *     .setHealthCheckServiceResource(healthCheckServiceResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionHealthCheckServicesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertRegionHealthCheckServiceRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the HealthCheckService resources that have been configured for the specified project
   * in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (HealthCheckService element : regionHealthCheckServicesClient.list(project, region).iterateAll()) {
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
    ListRegionHealthCheckServicesRequest request =
        ListRegionHealthCheckServicesRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the HealthCheckService resources that have been configured for the specified project
   * in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionHealthCheckServicesRequest request = ListRegionHealthCheckServicesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (HealthCheckService element : regionHealthCheckServicesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionHealthCheckServicesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the HealthCheckService resources that have been configured for the specified project
   * in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionHealthCheckServicesRequest request = ListRegionHealthCheckServicesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = regionHealthCheckServicesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (HealthCheckService element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListRegionHealthCheckServicesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the HealthCheckService resources that have been configured for the specified project
   * in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionHealthCheckServicesRequest request = ListRegionHealthCheckServicesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     HealthCheckServicesList response = regionHealthCheckServicesClient.listCallable().call(request);
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
   * </code></pre>
   */
  public final UnaryCallable<ListRegionHealthCheckServicesRequest, HealthCheckServicesList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified regional HealthCheckService resource with the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String healthCheckService = "";
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   Operation response = regionHealthCheckServicesClient.patch(project, region, healthCheckService, healthCheckServiceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param healthCheckService Name of the HealthCheckService to update. The name must be 1-63
   *     characters long, and comply with RFC1035.
   * @param healthCheckServiceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
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
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified regional HealthCheckService resource with the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String healthCheckService = "";
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchRegionHealthCheckServiceRequest request = PatchRegionHealthCheckServiceRequest.newBuilder()
   *     .setHealthCheckService(healthCheckService)
   *     .setHealthCheckServiceResource(healthCheckServiceResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionHealthCheckServicesClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchRegionHealthCheckServiceRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified regional HealthCheckService resource with the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
   *   String healthCheckService = "";
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchRegionHealthCheckServiceRequest request = PatchRegionHealthCheckServiceRequest.newBuilder()
   *     .setHealthCheckService(healthCheckService)
   *     .setHealthCheckServiceResource(healthCheckServiceResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionHealthCheckServicesClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
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

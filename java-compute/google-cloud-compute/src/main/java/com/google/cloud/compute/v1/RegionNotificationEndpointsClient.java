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
import com.google.cloud.compute.v1.stub.RegionNotificationEndpointsStub;
import com.google.cloud.compute.v1.stub.RegionNotificationEndpointsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The RegionNotificationEndpoints API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String notificationEndpoint = "";
 *   Operation response = regionNotificationEndpointsClient.delete(project, region, notificationEndpoint);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionNotificationEndpointsClient object to clean up
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
 * RegionNotificationEndpointsSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionNotificationEndpointsSettings regionNotificationEndpointsSettings =
 *     RegionNotificationEndpointsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionNotificationEndpointsClient regionNotificationEndpointsClient =
 *     RegionNotificationEndpointsClient.create(regionNotificationEndpointsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionNotificationEndpointsSettings regionNotificationEndpointsSettings =
 *     RegionNotificationEndpointsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionNotificationEndpointsClient regionNotificationEndpointsClient =
 *     RegionNotificationEndpointsClient.create(regionNotificationEndpointsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionNotificationEndpointsClient implements BackgroundResource {
  private final RegionNotificationEndpointsSettings settings;
  private final RegionNotificationEndpointsStub stub;

  /** Constructs an instance of RegionNotificationEndpointsClient with default settings. */
  public static final RegionNotificationEndpointsClient create() throws IOException {
    return create(RegionNotificationEndpointsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionNotificationEndpointsClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionNotificationEndpointsClient create(
      RegionNotificationEndpointsSettings settings) throws IOException {
    return new RegionNotificationEndpointsClient(settings);
  }

  /**
   * Constructs an instance of RegionNotificationEndpointsClient, using the given stub for making
   * calls. This is for advanced usage - prefer to use RegionNotificationEndpointsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionNotificationEndpointsClient create(
      RegionNotificationEndpointsStub stub) {
    return new RegionNotificationEndpointsClient(stub);
  }

  /**
   * Constructs an instance of RegionNotificationEndpointsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionNotificationEndpointsClient(RegionNotificationEndpointsSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionNotificationEndpointsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionNotificationEndpointsClient(RegionNotificationEndpointsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionNotificationEndpointsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionNotificationEndpointsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NotificationEndpoint in the given region
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String notificationEndpoint = "";
   *   Operation response = regionNotificationEndpointsClient.delete(project, region, notificationEndpoint);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param notificationEndpoint Name of the NotificationEndpoint resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String notificationEndpoint) {
    DeleteRegionNotificationEndpointRequest request =
        DeleteRegionNotificationEndpointRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNotificationEndpoint(notificationEndpoint)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NotificationEndpoint in the given region
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
   *   String notificationEndpoint = "";
   *   String project = "";
   *   String region = "";
   *   DeleteRegionNotificationEndpointRequest request = DeleteRegionNotificationEndpointRequest.newBuilder()
   *     .setNotificationEndpoint(notificationEndpoint)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionNotificationEndpointsClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteRegionNotificationEndpointRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NotificationEndpoint in the given region
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
   *   String notificationEndpoint = "";
   *   String project = "";
   *   String region = "";
   *   DeleteRegionNotificationEndpointRequest request = DeleteRegionNotificationEndpointRequest.newBuilder()
   *     .setNotificationEndpoint(notificationEndpoint)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionNotificationEndpointsClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteRegionNotificationEndpointRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified NotificationEndpoint resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String notificationEndpoint = "";
   *   NotificationEndpoint response = regionNotificationEndpointsClient.get(project, region, notificationEndpoint);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param notificationEndpoint Name of the NotificationEndpoint resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationEndpoint get(
      String project, String region, String notificationEndpoint) {
    GetRegionNotificationEndpointRequest request =
        GetRegionNotificationEndpointRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNotificationEndpoint(notificationEndpoint)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified NotificationEndpoint resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
   *   String notificationEndpoint = "";
   *   String project = "";
   *   String region = "";
   *   GetRegionNotificationEndpointRequest request = GetRegionNotificationEndpointRequest.newBuilder()
   *     .setNotificationEndpoint(notificationEndpoint)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   NotificationEndpoint response = regionNotificationEndpointsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationEndpoint get(GetRegionNotificationEndpointRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified NotificationEndpoint resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
   *   String notificationEndpoint = "";
   *   String project = "";
   *   String region = "";
   *   GetRegionNotificationEndpointRequest request = GetRegionNotificationEndpointRequest.newBuilder()
   *     .setNotificationEndpoint(notificationEndpoint)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;NotificationEndpoint&gt; future = regionNotificationEndpointsClient.getCallable().futureCall(request);
   *   // Do something
   *   NotificationEndpoint response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetRegionNotificationEndpointRequest, NotificationEndpoint>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a NotificationEndpoint in the specified project in the given region using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   NotificationEndpoint notificationEndpointResource = NotificationEndpoint.newBuilder().build();
   *   Operation response = regionNotificationEndpointsClient.insert(project, region, notificationEndpointResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param notificationEndpointResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, String region, NotificationEndpoint notificationEndpointResource) {
    InsertRegionNotificationEndpointRequest request =
        InsertRegionNotificationEndpointRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNotificationEndpointResource(notificationEndpointResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a NotificationEndpoint in the specified project in the given region using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
   *   NotificationEndpoint notificationEndpointResource = NotificationEndpoint.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertRegionNotificationEndpointRequest request = InsertRegionNotificationEndpointRequest.newBuilder()
   *     .setNotificationEndpointResource(notificationEndpointResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionNotificationEndpointsClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertRegionNotificationEndpointRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a NotificationEndpoint in the specified project in the given region using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
   *   NotificationEndpoint notificationEndpointResource = NotificationEndpoint.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertRegionNotificationEndpointRequest request = InsertRegionNotificationEndpointRequest.newBuilder()
   *     .setNotificationEndpointResource(notificationEndpointResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionNotificationEndpointsClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertRegionNotificationEndpointRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the NotificationEndpoints for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (NotificationEndpoint element : regionNotificationEndpointsClient.list(project, region).iterateAll()) {
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
    ListRegionNotificationEndpointsRequest request =
        ListRegionNotificationEndpointsRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the NotificationEndpoints for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionNotificationEndpointsRequest request = ListRegionNotificationEndpointsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (NotificationEndpoint element : regionNotificationEndpointsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionNotificationEndpointsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the NotificationEndpoints for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionNotificationEndpointsRequest request = ListRegionNotificationEndpointsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = regionNotificationEndpointsClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (NotificationEndpoint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListRegionNotificationEndpointsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the NotificationEndpoints for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionNotificationEndpointsRequest request = ListRegionNotificationEndpointsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     NotificationEndpointList response = regionNotificationEndpointsClient.listCallable().call(request);
   *     for (NotificationEndpoint element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionNotificationEndpointsRequest, NotificationEndpointList>
      listCallable() {
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
          ListRegionNotificationEndpointsRequest,
          NotificationEndpointList,
          NotificationEndpoint,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListRegionNotificationEndpointsRequest,
                NotificationEndpointList,
                NotificationEndpoint>
            context,
        ApiFuture<NotificationEndpointList> futureResponse) {
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
          ListRegionNotificationEndpointsRequest,
          NotificationEndpointList,
          NotificationEndpoint,
          ListPage> {

    private ListPage(
        PageContext<
                ListRegionNotificationEndpointsRequest,
                NotificationEndpointList,
                NotificationEndpoint>
            context,
        NotificationEndpointList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListRegionNotificationEndpointsRequest,
                NotificationEndpointList,
                NotificationEndpoint>
            context,
        NotificationEndpointList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListRegionNotificationEndpointsRequest,
                NotificationEndpointList,
                NotificationEndpoint>
            context,
        ApiFuture<NotificationEndpointList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionNotificationEndpointsRequest,
          NotificationEndpointList,
          NotificationEndpoint,
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

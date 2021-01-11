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
import com.google.cloud.compute.v1.stub.RoutesStub;
import com.google.cloud.compute.v1.stub.RoutesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Routes API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (RoutesClient routesClient = RoutesClient.create()) {
 *   String project = "";
 *   String route = "";
 *   Operation response = routesClient.delete(project, route);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the routesClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of RoutesSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RoutesSettings routesSettings =
 *     RoutesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RoutesClient routesClient =
 *     RoutesClient.create(routesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RoutesSettings routesSettings =
 *     RoutesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RoutesClient routesClient =
 *     RoutesClient.create(routesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RoutesClient implements BackgroundResource {
  private final RoutesSettings settings;
  private final RoutesStub stub;

  /** Constructs an instance of RoutesClient with default settings. */
  public static final RoutesClient create() throws IOException {
    return create(RoutesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RoutesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RoutesClient create(RoutesSettings settings) throws IOException {
    return new RoutesClient(settings);
  }

  /**
   * Constructs an instance of RoutesClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use RoutesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RoutesClient create(RoutesStub stub) {
    return new RoutesClient(stub);
  }

  /**
   * Constructs an instance of RoutesClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected RoutesClient(RoutesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RoutesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RoutesClient(RoutesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RoutesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RoutesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Route resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   String project = "";
   *   String route = "";
   *   Operation response = routesClient.delete(project, route);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param route Name of the Route resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String route) {
    DeleteRouteRequest request =
        DeleteRouteRequest.newBuilder().setProject(project).setRoute(route).build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Route resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   String project = "";
   *   String route = "";
   *   DeleteRouteRequest request = DeleteRouteRequest.newBuilder()
   *     .setProject(project)
   *     .setRoute(route)
   *     .build();
   *   Operation response = routesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteRouteRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Route resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   String project = "";
   *   String route = "";
   *   DeleteRouteRequest request = DeleteRouteRequest.newBuilder()
   *     .setProject(project)
   *     .setRoute(route)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = routesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteRouteRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Route resource. Gets a list of available routes by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   String project = "";
   *   String route = "";
   *   Route response = routesClient.get(project, route);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param route Name of the Route resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Route get(String project, String route) {
    GetRouteRequest request =
        GetRouteRequest.newBuilder().setProject(project).setRoute(route).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Route resource. Gets a list of available routes by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   String project = "";
   *   String route = "";
   *   GetRouteRequest request = GetRouteRequest.newBuilder()
   *     .setProject(project)
   *     .setRoute(route)
   *     .build();
   *   Route response = routesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Route get(GetRouteRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Route resource. Gets a list of available routes by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   String project = "";
   *   String route = "";
   *   GetRouteRequest request = GetRouteRequest.newBuilder()
   *     .setProject(project)
   *     .setRoute(route)
   *     .build();
   *   ApiFuture&lt;Route&gt; future = routesClient.getCallable().futureCall(request);
   *   // Do something
   *   Route response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetRouteRequest, Route> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Route resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   String project = "";
   *   Route routeResource = Route.newBuilder().build();
   *   Operation response = routesClient.insert(project, routeResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param routeResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, Route routeResource) {
    InsertRouteRequest request =
        InsertRouteRequest.newBuilder().setProject(project).setRouteResource(routeResource).build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Route resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   String project = "";
   *   Route routeResource = Route.newBuilder().build();
   *   InsertRouteRequest request = InsertRouteRequest.newBuilder()
   *     .setProject(project)
   *     .setRouteResource(routeResource)
   *     .build();
   *   Operation response = routesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertRouteRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Route resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   String project = "";
   *   Route routeResource = Route.newBuilder().build();
   *   InsertRouteRequest request = InsertRouteRequest.newBuilder()
   *     .setProject(project)
   *     .setRouteResource(routeResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = routesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertRouteRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of Route resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   String project = "";
   *   for (Route element : routesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListRoutesRequest request = ListRoutesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of Route resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   String project = "";
   *   ListRoutesRequest request = ListRoutesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Route element : routesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRoutesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of Route resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   String project = "";
   *   ListRoutesRequest request = ListRoutesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = routesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (Route element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListRoutesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of Route resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   String project = "";
   *   ListRoutesRequest request = ListRoutesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     RouteList response = routesClient.listCallable().call(request);
   *     for (Route element : response.getItemsList()) {
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
  public final UnaryCallable<ListRoutesRequest, RouteList> listCallable() {
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
          ListRoutesRequest, RouteList, Route, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRoutesRequest, RouteList, Route> context,
        ApiFuture<RouteList> futureResponse) {
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

  public static class ListPage extends AbstractPage<ListRoutesRequest, RouteList, Route, ListPage> {

    private ListPage(PageContext<ListRoutesRequest, RouteList, Route> context, RouteList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRoutesRequest, RouteList, Route> context, RouteList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRoutesRequest, RouteList, Route> context,
        ApiFuture<RouteList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRoutesRequest, RouteList, Route, ListPage, ListFixedSizeCollection> {

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

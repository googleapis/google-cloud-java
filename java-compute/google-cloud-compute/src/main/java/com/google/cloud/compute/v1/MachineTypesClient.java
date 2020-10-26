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
import com.google.cloud.compute.v1.stub.MachineTypesStub;
import com.google.cloud.compute.v1.stub.MachineTypesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The MachineTypes API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String machineType = "";
 *   MachineType response = machineTypesClient.get(project, zone, machineType);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the machineTypesClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of MachineTypesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * MachineTypesSettings machineTypesSettings =
 *     MachineTypesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MachineTypesClient machineTypesClient =
 *     MachineTypesClient.create(machineTypesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * MachineTypesSettings machineTypesSettings =
 *     MachineTypesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MachineTypesClient machineTypesClient =
 *     MachineTypesClient.create(machineTypesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class MachineTypesClient implements BackgroundResource {
  private final MachineTypesSettings settings;
  private final MachineTypesStub stub;

  /** Constructs an instance of MachineTypesClient with default settings. */
  public static final MachineTypesClient create() throws IOException {
    return create(MachineTypesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MachineTypesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MachineTypesClient create(MachineTypesSettings settings) throws IOException {
    return new MachineTypesClient(settings);
  }

  /**
   * Constructs an instance of MachineTypesClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use MachineTypesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final MachineTypesClient create(MachineTypesStub stub) {
    return new MachineTypesClient(stub);
  }

  /**
   * Constructs an instance of MachineTypesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MachineTypesClient(MachineTypesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MachineTypesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected MachineTypesClient(MachineTypesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MachineTypesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public MachineTypesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of machine types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, MachineTypesScopedList&gt; element : machineTypesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListMachineTypesRequest request =
        AggregatedListMachineTypesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of machine types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
   *   String project = "";
   *   AggregatedListMachineTypesRequest request = AggregatedListMachineTypesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, MachineTypesScopedList&gt; element : machineTypesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListMachineTypesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of machine types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
   *   String project = "";
   *   AggregatedListMachineTypesRequest request = AggregatedListMachineTypesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = machineTypesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, MachineTypesScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListMachineTypesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of machine types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
   *   String project = "";
   *   AggregatedListMachineTypesRequest request = AggregatedListMachineTypesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     MachineTypeAggregatedList response = machineTypesClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, MachineTypesScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListMachineTypesRequest, MachineTypeAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified machine type. Gets a list of available machine types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String machineType = "";
   *   MachineType response = machineTypesClient.get(project, zone, machineType);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param machineType Name of the machine type to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MachineType get(String project, String zone, String machineType) {
    GetMachineTypeRequest request =
        GetMachineTypeRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setMachineType(machineType)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified machine type. Gets a list of available machine types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
   *   String machineType = "";
   *   String project = "";
   *   String zone = "";
   *   GetMachineTypeRequest request = GetMachineTypeRequest.newBuilder()
   *     .setMachineType(machineType)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   MachineType response = machineTypesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MachineType get(GetMachineTypeRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified machine type. Gets a list of available machine types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
   *   String machineType = "";
   *   String project = "";
   *   String zone = "";
   *   GetMachineTypeRequest request = GetMachineTypeRequest.newBuilder()
   *     .setMachineType(machineType)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;MachineType&gt; future = machineTypesClient.getCallable().futureCall(request);
   *   // Do something
   *   MachineType response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetMachineTypeRequest, MachineType> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of machine types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   for (MachineType element : machineTypesClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone) {
    ListMachineTypesRequest request =
        ListMachineTypesRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of machine types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListMachineTypesRequest request = ListMachineTypesRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   for (MachineType element : machineTypesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListMachineTypesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of machine types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListMachineTypesRequest request = ListMachineTypesRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = machineTypesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (MachineType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListMachineTypesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of machine types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListMachineTypesRequest request = ListMachineTypesRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   while (true) {
   *     MachineTypeList response = machineTypesClient.listCallable().call(request);
   *     for (MachineType element : response.getItemsList()) {
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
  public final UnaryCallable<ListMachineTypesRequest, MachineTypeList> listCallable() {
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListMachineTypesRequest,
          MachineTypeAggregatedList,
          Entry<String, MachineTypesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListMachineTypesRequest,
                MachineTypeAggregatedList,
                Entry<String, MachineTypesScopedList>>
            context,
        ApiFuture<MachineTypeAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListPage, AggregatedListPagedResponse>() {
            @Override
            public AggregatedListPagedResponse apply(AggregatedListPage input) {
              return new AggregatedListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListMachineTypesRequest,
          MachineTypeAggregatedList,
          Entry<String, MachineTypesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListMachineTypesRequest,
                MachineTypeAggregatedList,
                Entry<String, MachineTypesScopedList>>
            context,
        MachineTypeAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListMachineTypesRequest,
                MachineTypeAggregatedList,
                Entry<String, MachineTypesScopedList>>
            context,
        MachineTypeAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListMachineTypesRequest,
                MachineTypeAggregatedList,
                Entry<String, MachineTypesScopedList>>
            context,
        ApiFuture<MachineTypeAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListMachineTypesRequest,
          MachineTypeAggregatedList,
          Entry<String, MachineTypesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    private AggregatedListFixedSizeCollection(List<AggregatedListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListFixedSizeCollection createEmptyCollection() {
      return new AggregatedListFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListFixedSizeCollection createCollection(
        List<AggregatedListPage> pages, int collectionSize) {
      return new AggregatedListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListMachineTypesRequest,
          MachineTypeList,
          MachineType,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListMachineTypesRequest, MachineTypeList, MachineType> context,
        ApiFuture<MachineTypeList> futureResponse) {
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
      extends AbstractPage<ListMachineTypesRequest, MachineTypeList, MachineType, ListPage> {

    private ListPage(
        PageContext<ListMachineTypesRequest, MachineTypeList, MachineType> context,
        MachineTypeList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListMachineTypesRequest, MachineTypeList, MachineType> context,
        MachineTypeList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListMachineTypesRequest, MachineTypeList, MachineType> context,
        ApiFuture<MachineTypeList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMachineTypesRequest,
          MachineTypeList,
          MachineType,
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

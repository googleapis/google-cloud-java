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
import com.google.cloud.compute.v1.stub.DiskTypesStub;
import com.google.cloud.compute.v1.stub.DiskTypesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The DiskTypes API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String diskType = "";
 *   DiskType response = diskTypesClient.get(project, zone, diskType);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the diskTypesClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of DiskTypesSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * DiskTypesSettings diskTypesSettings =
 *     DiskTypesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DiskTypesClient diskTypesClient =
 *     DiskTypesClient.create(diskTypesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * DiskTypesSettings diskTypesSettings =
 *     DiskTypesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DiskTypesClient diskTypesClient =
 *     DiskTypesClient.create(diskTypesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class DiskTypesClient implements BackgroundResource {
  private final DiskTypesSettings settings;
  private final DiskTypesStub stub;

  /** Constructs an instance of DiskTypesClient with default settings. */
  public static final DiskTypesClient create() throws IOException {
    return create(DiskTypesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DiskTypesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DiskTypesClient create(DiskTypesSettings settings) throws IOException {
    return new DiskTypesClient(settings);
  }

  /**
   * Constructs an instance of DiskTypesClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use DiskTypesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final DiskTypesClient create(DiskTypesStub stub) {
    return new DiskTypesClient(stub);
  }

  /**
   * Constructs an instance of DiskTypesClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DiskTypesClient(DiskTypesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DiskTypesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DiskTypesClient(DiskTypesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DiskTypesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DiskTypesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of disk types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, DiskTypesScopedList&gt; element : diskTypesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListDiskTypesRequest request =
        AggregatedListDiskTypesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of disk types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
   *   String project = "";
   *   AggregatedListDiskTypesRequest request = AggregatedListDiskTypesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, DiskTypesScopedList&gt; element : diskTypesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(AggregatedListDiskTypesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of disk types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
   *   String project = "";
   *   AggregatedListDiskTypesRequest request = AggregatedListDiskTypesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = diskTypesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, DiskTypesScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListDiskTypesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of disk types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
   *   String project = "";
   *   AggregatedListDiskTypesRequest request = AggregatedListDiskTypesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     DiskTypeAggregatedList response = diskTypesClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, DiskTypesScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListDiskTypesRequest, DiskTypeAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified disk type. Gets a list of available disk types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String diskType = "";
   *   DiskType response = diskTypesClient.get(project, zone, diskType);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param diskType Name of the disk type to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiskType get(String project, String zone, String diskType) {
    GetDiskTypeRequest request =
        GetDiskTypeRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setDiskType(diskType)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified disk type. Gets a list of available disk types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
   *   String diskType = "";
   *   String project = "";
   *   String zone = "";
   *   GetDiskTypeRequest request = GetDiskTypeRequest.newBuilder()
   *     .setDiskType(diskType)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   DiskType response = diskTypesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiskType get(GetDiskTypeRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified disk type. Gets a list of available disk types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
   *   String diskType = "";
   *   String project = "";
   *   String zone = "";
   *   GetDiskTypeRequest request = GetDiskTypeRequest.newBuilder()
   *     .setDiskType(diskType)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;DiskType&gt; future = diskTypesClient.getCallable().futureCall(request);
   *   // Do something
   *   DiskType response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetDiskTypeRequest, DiskType> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   for (DiskType element : diskTypesClient.list(project, zone).iterateAll()) {
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
    ListDiskTypesRequest request =
        ListDiskTypesRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListDiskTypesRequest request = ListDiskTypesRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   for (DiskType element : diskTypesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListDiskTypesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListDiskTypesRequest request = ListDiskTypesRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = diskTypesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (DiskType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListDiskTypesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListDiskTypesRequest request = ListDiskTypesRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   while (true) {
   *     DiskTypeList response = diskTypesClient.listCallable().call(request);
   *     for (DiskType element : response.getItemsList()) {
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
  public final UnaryCallable<ListDiskTypesRequest, DiskTypeList> listCallable() {
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
          AggregatedListDiskTypesRequest,
          DiskTypeAggregatedList,
          Entry<String, DiskTypesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListDiskTypesRequest,
                DiskTypeAggregatedList,
                Entry<String, DiskTypesScopedList>>
            context,
        ApiFuture<DiskTypeAggregatedList> futureResponse) {
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
          AggregatedListDiskTypesRequest,
          DiskTypeAggregatedList,
          Entry<String, DiskTypesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListDiskTypesRequest,
                DiskTypeAggregatedList,
                Entry<String, DiskTypesScopedList>>
            context,
        DiskTypeAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListDiskTypesRequest,
                DiskTypeAggregatedList,
                Entry<String, DiskTypesScopedList>>
            context,
        DiskTypeAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListDiskTypesRequest,
                DiskTypeAggregatedList,
                Entry<String, DiskTypesScopedList>>
            context,
        ApiFuture<DiskTypeAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListDiskTypesRequest,
          DiskTypeAggregatedList,
          Entry<String, DiskTypesScopedList>,
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
          ListDiskTypesRequest, DiskTypeList, DiskType, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListDiskTypesRequest, DiskTypeList, DiskType> context,
        ApiFuture<DiskTypeList> futureResponse) {
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
      extends AbstractPage<ListDiskTypesRequest, DiskTypeList, DiskType, ListPage> {

    private ListPage(
        PageContext<ListDiskTypesRequest, DiskTypeList, DiskType> context, DiskTypeList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListDiskTypesRequest, DiskTypeList, DiskType> context, DiskTypeList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListDiskTypesRequest, DiskTypeList, DiskType> context,
        ApiFuture<DiskTypeList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDiskTypesRequest, DiskTypeList, DiskType, ListPage, ListFixedSizeCollection> {

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

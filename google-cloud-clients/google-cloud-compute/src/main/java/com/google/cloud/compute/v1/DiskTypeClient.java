/*
 * Copyright 2019 Google LLC
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
import com.google.cloud.compute.v1.stub.DiskTypeStub;
import com.google.cloud.compute.v1.stub.DiskTypeStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
 *   ProjectZoneDiskTypeName diskType = ProjectZoneDiskTypeName.of("[PROJECT]", "[ZONE]", "[DISK_TYPE]");
 *   DiskType response = diskTypeClient.getDiskType(diskType);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the diskTypeClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of DiskTypeSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * DiskTypeSettings diskTypeSettings =
 *     DiskTypeSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DiskTypeClient diskTypeClient =
 *     DiskTypeClient.create(diskTypeSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * DiskTypeSettings diskTypeSettings =
 *     DiskTypeSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DiskTypeClient diskTypeClient =
 *     DiskTypeClient.create(diskTypeSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class DiskTypeClient implements BackgroundResource {
  private final DiskTypeSettings settings;
  private final DiskTypeStub stub;

  /** Constructs an instance of DiskTypeClient with default settings. */
  public static final DiskTypeClient create() throws IOException {
    return create(DiskTypeSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DiskTypeClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DiskTypeClient create(DiskTypeSettings settings) throws IOException {
    return new DiskTypeClient(settings);
  }

  /**
   * Constructs an instance of DiskTypeClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use DiskTypeSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final DiskTypeClient create(DiskTypeStub stub) {
    return new DiskTypeClient(stub);
  }

  /**
   * Constructs an instance of DiskTypeClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DiskTypeClient(DiskTypeSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DiskTypeStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DiskTypeClient(DiskTypeStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DiskTypeSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DiskTypeStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of disk types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (DiskTypesScopedList element : diskTypeClient.aggregatedListDiskTypes(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListDiskTypesPagedResponse aggregatedListDiskTypes(ProjectName project) {
    AggregatedListDiskTypesHttpRequest request =
        AggregatedListDiskTypesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListDiskTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of disk types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (DiskTypesScopedList element : diskTypeClient.aggregatedListDiskTypes(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListDiskTypesPagedResponse aggregatedListDiskTypes(String project) {
    AggregatedListDiskTypesHttpRequest request =
        AggregatedListDiskTypesHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListDiskTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of disk types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListDiskTypesHttpRequest request = AggregatedListDiskTypesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (DiskTypesScopedList element : diskTypeClient.aggregatedListDiskTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListDiskTypesPagedResponse aggregatedListDiskTypes(
      AggregatedListDiskTypesHttpRequest request) {
    return aggregatedListDiskTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of disk types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListDiskTypesHttpRequest request = AggregatedListDiskTypesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;AggregatedListDiskTypesPagedResponse&gt; future = diskTypeClient.aggregatedListDiskTypesPagedCallable().futureCall(request);
   *   // Do something
   *   for (DiskTypesScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListDiskTypesHttpRequest, AggregatedListDiskTypesPagedResponse>
      aggregatedListDiskTypesPagedCallable() {
    return stub.aggregatedListDiskTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of disk types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListDiskTypesHttpRequest request = AggregatedListDiskTypesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     DiskTypeAggregatedList response = diskTypeClient.aggregatedListDiskTypesCallable().call(request);
   *     for (DiskTypesScopedList element : response.getItemsMap()) {
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
  @BetaApi
  public final UnaryCallable<AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList>
      aggregatedListDiskTypesCallable() {
    return stub.aggregatedListDiskTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified disk type. Gets a list of available disk types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   ProjectZoneDiskTypeName diskType = ProjectZoneDiskTypeName.of("[PROJECT]", "[ZONE]", "[DISK_TYPE]");
   *   DiskType response = diskTypeClient.getDiskType(diskType);
   * }
   * </code></pre>
   *
   * @param diskType Name of the disk type to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final DiskType getDiskType(ProjectZoneDiskTypeName diskType) {

    GetDiskTypeHttpRequest request =
        GetDiskTypeHttpRequest.newBuilder()
            .setDiskType(diskType == null ? null : diskType.toString())
            .build();
    return getDiskType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified disk type. Gets a list of available disk types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   ProjectZoneDiskTypeName diskType = ProjectZoneDiskTypeName.of("[PROJECT]", "[ZONE]", "[DISK_TYPE]");
   *   DiskType response = diskTypeClient.getDiskType(diskType.toString());
   * }
   * </code></pre>
   *
   * @param diskType Name of the disk type to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final DiskType getDiskType(String diskType) {

    GetDiskTypeHttpRequest request =
        GetDiskTypeHttpRequest.newBuilder().setDiskType(diskType).build();
    return getDiskType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified disk type. Gets a list of available disk types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   String formattedDiskType = ProjectZoneDiskTypeName.format("[PROJECT]", "[ZONE]", "[DISK_TYPE]");
   *   GetDiskTypeHttpRequest request = GetDiskTypeHttpRequest.newBuilder()
   *     .setDiskType(formattedDiskType)
   *     .build();
   *   DiskType response = diskTypeClient.getDiskType(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final DiskType getDiskType(GetDiskTypeHttpRequest request) {
    return getDiskTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified disk type. Gets a list of available disk types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   String formattedDiskType = ProjectZoneDiskTypeName.format("[PROJECT]", "[ZONE]", "[DISK_TYPE]");
   *   GetDiskTypeHttpRequest request = GetDiskTypeHttpRequest.newBuilder()
   *     .setDiskType(formattedDiskType)
   *     .build();
   *   ApiFuture&lt;DiskType&gt; future = diskTypeClient.getDiskTypeCallable().futureCall(request);
   *   // Do something
   *   DiskType response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetDiskTypeHttpRequest, DiskType> getDiskTypeCallable() {
    return stub.getDiskTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (DiskType element : diskTypeClient.listDiskTypes(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListDiskTypesPagedResponse listDiskTypes(ProjectZoneName zone) {
    ListDiskTypesHttpRequest request =
        ListDiskTypesHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listDiskTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (DiskType element : diskTypeClient.listDiskTypes(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListDiskTypesPagedResponse listDiskTypes(String zone) {
    ListDiskTypesHttpRequest request = ListDiskTypesHttpRequest.newBuilder().setZone(zone).build();
    return listDiskTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListDiskTypesHttpRequest request = ListDiskTypesHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   for (DiskType element : diskTypeClient.listDiskTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListDiskTypesPagedResponse listDiskTypes(ListDiskTypesHttpRequest request) {
    return listDiskTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListDiskTypesHttpRequest request = ListDiskTypesHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   ApiFuture&lt;ListDiskTypesPagedResponse&gt; future = diskTypeClient.listDiskTypesPagedCallable().futureCall(request);
   *   // Do something
   *   for (DiskType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListDiskTypesHttpRequest, ListDiskTypesPagedResponse>
      listDiskTypesPagedCallable() {
    return stub.listDiskTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListDiskTypesHttpRequest request = ListDiskTypesHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   while (true) {
   *     DiskTypeList response = diskTypeClient.listDiskTypesCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListDiskTypesHttpRequest, DiskTypeList> listDiskTypesCallable() {
    return stub.listDiskTypesCallable();
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

  public static class AggregatedListDiskTypesPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListDiskTypesHttpRequest,
          DiskTypeAggregatedList,
          DiskTypesScopedList,
          AggregatedListDiskTypesPage,
          AggregatedListDiskTypesFixedSizeCollection> {

    public static ApiFuture<AggregatedListDiskTypesPagedResponse> createAsync(
        PageContext<AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList, DiskTypesScopedList>
            context,
        ApiFuture<DiskTypeAggregatedList> futureResponse) {
      ApiFuture<AggregatedListDiskTypesPage> futurePage =
          AggregatedListDiskTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListDiskTypesPage, AggregatedListDiskTypesPagedResponse>() {
            @Override
            public AggregatedListDiskTypesPagedResponse apply(AggregatedListDiskTypesPage input) {
              return new AggregatedListDiskTypesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListDiskTypesPagedResponse(AggregatedListDiskTypesPage page) {
      super(page, AggregatedListDiskTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListDiskTypesPage
      extends AbstractPage<
          AggregatedListDiskTypesHttpRequest,
          DiskTypeAggregatedList,
          DiskTypesScopedList,
          AggregatedListDiskTypesPage> {

    private AggregatedListDiskTypesPage(
        PageContext<AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList, DiskTypesScopedList>
            context,
        DiskTypeAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListDiskTypesPage createEmptyPage() {
      return new AggregatedListDiskTypesPage(null, null);
    }

    @Override
    protected AggregatedListDiskTypesPage createPage(
        PageContext<AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList, DiskTypesScopedList>
            context,
        DiskTypeAggregatedList response) {
      return new AggregatedListDiskTypesPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListDiskTypesPage> createPageAsync(
        PageContext<AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList, DiskTypesScopedList>
            context,
        ApiFuture<DiskTypeAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListDiskTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListDiskTypesHttpRequest,
          DiskTypeAggregatedList,
          DiskTypesScopedList,
          AggregatedListDiskTypesPage,
          AggregatedListDiskTypesFixedSizeCollection> {

    private AggregatedListDiskTypesFixedSizeCollection(
        List<AggregatedListDiskTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListDiskTypesFixedSizeCollection createEmptyCollection() {
      return new AggregatedListDiskTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListDiskTypesFixedSizeCollection createCollection(
        List<AggregatedListDiskTypesPage> pages, int collectionSize) {
      return new AggregatedListDiskTypesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDiskTypesPagedResponse
      extends AbstractPagedListResponse<
          ListDiskTypesHttpRequest,
          DiskTypeList,
          DiskType,
          ListDiskTypesPage,
          ListDiskTypesFixedSizeCollection> {

    public static ApiFuture<ListDiskTypesPagedResponse> createAsync(
        PageContext<ListDiskTypesHttpRequest, DiskTypeList, DiskType> context,
        ApiFuture<DiskTypeList> futureResponse) {
      ApiFuture<ListDiskTypesPage> futurePage =
          ListDiskTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDiskTypesPage, ListDiskTypesPagedResponse>() {
            @Override
            public ListDiskTypesPagedResponse apply(ListDiskTypesPage input) {
              return new ListDiskTypesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListDiskTypesPagedResponse(ListDiskTypesPage page) {
      super(page, ListDiskTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDiskTypesPage
      extends AbstractPage<ListDiskTypesHttpRequest, DiskTypeList, DiskType, ListDiskTypesPage> {

    private ListDiskTypesPage(
        PageContext<ListDiskTypesHttpRequest, DiskTypeList, DiskType> context,
        DiskTypeList response) {
      super(context, response);
    }

    private static ListDiskTypesPage createEmptyPage() {
      return new ListDiskTypesPage(null, null);
    }

    @Override
    protected ListDiskTypesPage createPage(
        PageContext<ListDiskTypesHttpRequest, DiskTypeList, DiskType> context,
        DiskTypeList response) {
      return new ListDiskTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListDiskTypesPage> createPageAsync(
        PageContext<ListDiskTypesHttpRequest, DiskTypeList, DiskType> context,
        ApiFuture<DiskTypeList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDiskTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDiskTypesHttpRequest,
          DiskTypeList,
          DiskType,
          ListDiskTypesPage,
          ListDiskTypesFixedSizeCollection> {

    private ListDiskTypesFixedSizeCollection(List<ListDiskTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDiskTypesFixedSizeCollection createEmptyCollection() {
      return new ListDiskTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDiskTypesFixedSizeCollection createCollection(
        List<ListDiskTypesPage> pages, int collectionSize) {
      return new ListDiskTypesFixedSizeCollection(pages, collectionSize);
    }
  }
}

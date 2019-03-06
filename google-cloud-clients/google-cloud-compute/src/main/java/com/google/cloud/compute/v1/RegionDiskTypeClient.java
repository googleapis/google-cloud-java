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
import com.google.cloud.compute.v1.stub.RegionDiskTypeStub;
import com.google.cloud.compute.v1.stub.RegionDiskTypeStubSettings;
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
 * try (RegionDiskTypeClient regionDiskTypeClient = RegionDiskTypeClient.create()) {
 *   ProjectRegionDiskTypeName diskType = ProjectRegionDiskTypeName.of("[PROJECT]", "[REGION]", "[DISK_TYPE]");
 *   DiskType response = regionDiskTypeClient.getRegionDiskType(diskType);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionDiskTypeClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of RegionDiskTypeSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionDiskTypeSettings regionDiskTypeSettings =
 *     RegionDiskTypeSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionDiskTypeClient regionDiskTypeClient =
 *     RegionDiskTypeClient.create(regionDiskTypeSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionDiskTypeSettings regionDiskTypeSettings =
 *     RegionDiskTypeSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionDiskTypeClient regionDiskTypeClient =
 *     RegionDiskTypeClient.create(regionDiskTypeSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionDiskTypeClient implements BackgroundResource {
  private final RegionDiskTypeSettings settings;
  private final RegionDiskTypeStub stub;

  /** Constructs an instance of RegionDiskTypeClient with default settings. */
  public static final RegionDiskTypeClient create() throws IOException {
    return create(RegionDiskTypeSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionDiskTypeClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionDiskTypeClient create(RegionDiskTypeSettings settings)
      throws IOException {
    return new RegionDiskTypeClient(settings);
  }

  /**
   * Constructs an instance of RegionDiskTypeClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use RegionDiskTypeSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionDiskTypeClient create(RegionDiskTypeStub stub) {
    return new RegionDiskTypeClient(stub);
  }

  /**
   * Constructs an instance of RegionDiskTypeClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionDiskTypeClient(RegionDiskTypeSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionDiskTypeStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionDiskTypeClient(RegionDiskTypeStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionDiskTypeSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionDiskTypeStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional disk type. Gets a list of available disk types by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskTypeClient regionDiskTypeClient = RegionDiskTypeClient.create()) {
   *   ProjectRegionDiskTypeName diskType = ProjectRegionDiskTypeName.of("[PROJECT]", "[REGION]", "[DISK_TYPE]");
   *   DiskType response = regionDiskTypeClient.getRegionDiskType(diskType);
   * }
   * </code></pre>
   *
   * @param diskType Name of the disk type to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final DiskType getRegionDiskType(ProjectRegionDiskTypeName diskType) {

    GetRegionDiskTypeHttpRequest request =
        GetRegionDiskTypeHttpRequest.newBuilder()
            .setDiskType(diskType == null ? null : diskType.toString())
            .build();
    return getRegionDiskType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional disk type. Gets a list of available disk types by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskTypeClient regionDiskTypeClient = RegionDiskTypeClient.create()) {
   *   ProjectRegionDiskTypeName diskType = ProjectRegionDiskTypeName.of("[PROJECT]", "[REGION]", "[DISK_TYPE]");
   *   DiskType response = regionDiskTypeClient.getRegionDiskType(diskType.toString());
   * }
   * </code></pre>
   *
   * @param diskType Name of the disk type to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final DiskType getRegionDiskType(String diskType) {

    GetRegionDiskTypeHttpRequest request =
        GetRegionDiskTypeHttpRequest.newBuilder().setDiskType(diskType).build();
    return getRegionDiskType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional disk type. Gets a list of available disk types by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskTypeClient regionDiskTypeClient = RegionDiskTypeClient.create()) {
   *   ProjectRegionDiskTypeName diskType = ProjectRegionDiskTypeName.of("[PROJECT]", "[REGION]", "[DISK_TYPE]");
   *   GetRegionDiskTypeHttpRequest request = GetRegionDiskTypeHttpRequest.newBuilder()
   *     .setDiskType(diskType.toString())
   *     .build();
   *   DiskType response = regionDiskTypeClient.getRegionDiskType(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final DiskType getRegionDiskType(GetRegionDiskTypeHttpRequest request) {
    return getRegionDiskTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional disk type. Gets a list of available disk types by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskTypeClient regionDiskTypeClient = RegionDiskTypeClient.create()) {
   *   ProjectRegionDiskTypeName diskType = ProjectRegionDiskTypeName.of("[PROJECT]", "[REGION]", "[DISK_TYPE]");
   *   GetRegionDiskTypeHttpRequest request = GetRegionDiskTypeHttpRequest.newBuilder()
   *     .setDiskType(diskType.toString())
   *     .build();
   *   ApiFuture&lt;DiskType&gt; future = regionDiskTypeClient.getRegionDiskTypeCallable().futureCall(request);
   *   // Do something
   *   DiskType response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionDiskTypeHttpRequest, DiskType> getRegionDiskTypeCallable() {
    return stub.getRegionDiskTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of regional disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskTypeClient regionDiskTypeClient = RegionDiskTypeClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (DiskType element : regionDiskTypeClient.listRegionDiskTypes(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region The name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionDiskTypesPagedResponse listRegionDiskTypes(ProjectRegionName region) {
    ListRegionDiskTypesHttpRequest request =
        ListRegionDiskTypesHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionDiskTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of regional disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskTypeClient regionDiskTypeClient = RegionDiskTypeClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (DiskType element : regionDiskTypeClient.listRegionDiskTypes(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region The name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionDiskTypesPagedResponse listRegionDiskTypes(String region) {
    ListRegionDiskTypesHttpRequest request =
        ListRegionDiskTypesHttpRequest.newBuilder().setRegion(region).build();
    return listRegionDiskTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of regional disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskTypeClient regionDiskTypeClient = RegionDiskTypeClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionDiskTypesHttpRequest request = ListRegionDiskTypesHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   for (DiskType element : regionDiskTypeClient.listRegionDiskTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionDiskTypesPagedResponse listRegionDiskTypes(
      ListRegionDiskTypesHttpRequest request) {
    return listRegionDiskTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of regional disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskTypeClient regionDiskTypeClient = RegionDiskTypeClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionDiskTypesHttpRequest request = ListRegionDiskTypesHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   ApiFuture&lt;ListRegionDiskTypesPagedResponse&gt; future = regionDiskTypeClient.listRegionDiskTypesPagedCallable().futureCall(request);
   *   // Do something
   *   for (DiskType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListRegionDiskTypesHttpRequest, ListRegionDiskTypesPagedResponse>
      listRegionDiskTypesPagedCallable() {
    return stub.listRegionDiskTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of regional disk types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskTypeClient regionDiskTypeClient = RegionDiskTypeClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionDiskTypesHttpRequest request = ListRegionDiskTypesHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   while (true) {
   *     RegionDiskTypeList response = regionDiskTypeClient.listRegionDiskTypesCallable().call(request);
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
  public final UnaryCallable<ListRegionDiskTypesHttpRequest, RegionDiskTypeList>
      listRegionDiskTypesCallable() {
    return stub.listRegionDiskTypesCallable();
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

  public static class ListRegionDiskTypesPagedResponse
      extends AbstractPagedListResponse<
          ListRegionDiskTypesHttpRequest,
          RegionDiskTypeList,
          DiskType,
          ListRegionDiskTypesPage,
          ListRegionDiskTypesFixedSizeCollection> {

    public static ApiFuture<ListRegionDiskTypesPagedResponse> createAsync(
        PageContext<ListRegionDiskTypesHttpRequest, RegionDiskTypeList, DiskType> context,
        ApiFuture<RegionDiskTypeList> futureResponse) {
      ApiFuture<ListRegionDiskTypesPage> futurePage =
          ListRegionDiskTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListRegionDiskTypesPage, ListRegionDiskTypesPagedResponse>() {
            @Override
            public ListRegionDiskTypesPagedResponse apply(ListRegionDiskTypesPage input) {
              return new ListRegionDiskTypesPagedResponse(input);
            }
          });
    }

    private ListRegionDiskTypesPagedResponse(ListRegionDiskTypesPage page) {
      super(page, ListRegionDiskTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionDiskTypesPage
      extends AbstractPage<
          ListRegionDiskTypesHttpRequest, RegionDiskTypeList, DiskType, ListRegionDiskTypesPage> {

    private ListRegionDiskTypesPage(
        PageContext<ListRegionDiskTypesHttpRequest, RegionDiskTypeList, DiskType> context,
        RegionDiskTypeList response) {
      super(context, response);
    }

    private static ListRegionDiskTypesPage createEmptyPage() {
      return new ListRegionDiskTypesPage(null, null);
    }

    @Override
    protected ListRegionDiskTypesPage createPage(
        PageContext<ListRegionDiskTypesHttpRequest, RegionDiskTypeList, DiskType> context,
        RegionDiskTypeList response) {
      return new ListRegionDiskTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionDiskTypesPage> createPageAsync(
        PageContext<ListRegionDiskTypesHttpRequest, RegionDiskTypeList, DiskType> context,
        ApiFuture<RegionDiskTypeList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionDiskTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionDiskTypesHttpRequest,
          RegionDiskTypeList,
          DiskType,
          ListRegionDiskTypesPage,
          ListRegionDiskTypesFixedSizeCollection> {

    private ListRegionDiskTypesFixedSizeCollection(
        List<ListRegionDiskTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionDiskTypesFixedSizeCollection createEmptyCollection() {
      return new ListRegionDiskTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionDiskTypesFixedSizeCollection createCollection(
        List<ListRegionDiskTypesPage> pages, int collectionSize) {
      return new ListRegionDiskTypesFixedSizeCollection(pages, collectionSize);
    }
  }
}

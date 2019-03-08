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
import com.google.cloud.compute.v1.stub.ZoneStub;
import com.google.cloud.compute.v1.stub.ZoneStubSettings;
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
 * try (ZoneClient zoneClient = ZoneClient.create()) {
 *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
 *   Zone response = zoneClient.getZone(zone);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the zoneClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of ZoneSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ZoneSettings zoneSettings =
 *     ZoneSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ZoneClient zoneClient =
 *     ZoneClient.create(zoneSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ZoneSettings zoneSettings =
 *     ZoneSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ZoneClient zoneClient =
 *     ZoneClient.create(zoneSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ZoneClient implements BackgroundResource {
  private final ZoneSettings settings;
  private final ZoneStub stub;

  /** Constructs an instance of ZoneClient with default settings. */
  public static final ZoneClient create() throws IOException {
    return create(ZoneSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ZoneClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ZoneClient create(ZoneSettings settings) throws IOException {
    return new ZoneClient(settings);
  }

  /**
   * Constructs an instance of ZoneClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use ZoneSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ZoneClient create(ZoneStub stub) {
    return new ZoneClient(stub);
  }

  /**
   * Constructs an instance of ZoneClient, using the given settings. This is protected so that it is
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ZoneClient(ZoneSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ZoneStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ZoneClient(ZoneStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ZoneSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ZoneStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Zone resource. Gets a list of available zones by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneClient zoneClient = ZoneClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Zone response = zoneClient.getZone(zone);
   * }
   * </code></pre>
   *
   * @param zone Name of the zone resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Zone getZone(ProjectZoneName zone) {

    GetZoneHttpRequest request =
        GetZoneHttpRequest.newBuilder().setZone(zone == null ? null : zone.toString()).build();
    return getZone(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Zone resource. Gets a list of available zones by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneClient zoneClient = ZoneClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Zone response = zoneClient.getZone(zone.toString());
   * }
   * </code></pre>
   *
   * @param zone Name of the zone resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Zone getZone(String zone) {

    GetZoneHttpRequest request = GetZoneHttpRequest.newBuilder().setZone(zone).build();
    return getZone(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Zone resource. Gets a list of available zones by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneClient zoneClient = ZoneClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   GetZoneHttpRequest request = GetZoneHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   Zone response = zoneClient.getZone(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Zone getZone(GetZoneHttpRequest request) {
    return getZoneCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Zone resource. Gets a list of available zones by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneClient zoneClient = ZoneClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   GetZoneHttpRequest request = GetZoneHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   ApiFuture&lt;Zone&gt; future = zoneClient.getZoneCallable().futureCall(request);
   *   // Do something
   *   Zone response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetZoneHttpRequest, Zone> getZoneCallable() {
    return stub.getZoneCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of Zone resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneClient zoneClient = ZoneClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Zone element : zoneClient.listZones(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListZonesPagedResponse listZones(ProjectName project) {
    ListZonesHttpRequest request =
        ListZonesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listZones(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of Zone resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneClient zoneClient = ZoneClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Zone element : zoneClient.listZones(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListZonesPagedResponse listZones(String project) {
    ListZonesHttpRequest request = ListZonesHttpRequest.newBuilder().setProject(project).build();
    return listZones(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of Zone resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneClient zoneClient = ZoneClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListZonesHttpRequest request = ListZonesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (Zone element : zoneClient.listZones(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListZonesPagedResponse listZones(ListZonesHttpRequest request) {
    return listZonesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of Zone resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneClient zoneClient = ZoneClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListZonesHttpRequest request = ListZonesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListZonesPagedResponse&gt; future = zoneClient.listZonesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Zone element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListZonesHttpRequest, ListZonesPagedResponse>
      listZonesPagedCallable() {
    return stub.listZonesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of Zone resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ZoneClient zoneClient = ZoneClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListZonesHttpRequest request = ListZonesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     ZoneList response = zoneClient.listZonesCallable().call(request);
   *     for (Zone element : response.getItemsList()) {
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
  public final UnaryCallable<ListZonesHttpRequest, ZoneList> listZonesCallable() {
    return stub.listZonesCallable();
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

  public static class ListZonesPagedResponse
      extends AbstractPagedListResponse<
          ListZonesHttpRequest, ZoneList, Zone, ListZonesPage, ListZonesFixedSizeCollection> {

    public static ApiFuture<ListZonesPagedResponse> createAsync(
        PageContext<ListZonesHttpRequest, ZoneList, Zone> context,
        ApiFuture<ZoneList> futureResponse) {
      ApiFuture<ListZonesPage> futurePage =
          ListZonesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListZonesPage, ListZonesPagedResponse>() {
            @Override
            public ListZonesPagedResponse apply(ListZonesPage input) {
              return new ListZonesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListZonesPagedResponse(ListZonesPage page) {
      super(page, ListZonesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListZonesPage
      extends AbstractPage<ListZonesHttpRequest, ZoneList, Zone, ListZonesPage> {

    private ListZonesPage(
        PageContext<ListZonesHttpRequest, ZoneList, Zone> context, ZoneList response) {
      super(context, response);
    }

    private static ListZonesPage createEmptyPage() {
      return new ListZonesPage(null, null);
    }

    @Override
    protected ListZonesPage createPage(
        PageContext<ListZonesHttpRequest, ZoneList, Zone> context, ZoneList response) {
      return new ListZonesPage(context, response);
    }

    @Override
    public ApiFuture<ListZonesPage> createPageAsync(
        PageContext<ListZonesHttpRequest, ZoneList, Zone> context,
        ApiFuture<ZoneList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListZonesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListZonesHttpRequest, ZoneList, Zone, ListZonesPage, ListZonesFixedSizeCollection> {

    private ListZonesFixedSizeCollection(List<ListZonesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListZonesFixedSizeCollection createEmptyCollection() {
      return new ListZonesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListZonesFixedSizeCollection createCollection(
        List<ListZonesPage> pages, int collectionSize) {
      return new ListZonesFixedSizeCollection(pages, collectionSize);
    }
  }
}

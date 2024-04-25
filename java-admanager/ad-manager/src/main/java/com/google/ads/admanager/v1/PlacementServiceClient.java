/*
 * Copyright 2024 Google LLC
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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.PlacementServiceStub;
import com.google.ads.admanager.v1.stub.PlacementServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `Placement` objects.
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
 * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
 *   PlacementName name = PlacementName.of("[NETWORK_CODE]", "[PLACEMENT]");
 *   Placement response = placementServiceClient.getPlacement(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PlacementServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetPlacement</td>
 *      <td><p> API to retrieve a `Placement` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPlacement(GetPlacementRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPlacement(PlacementName name)
 *           <li><p> getPlacement(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPlacementCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPlacements</td>
 *      <td><p> API to retrieve a list of `Placement` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPlacements(ListPlacementsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPlacements(NetworkName parent)
 *           <li><p> listPlacements(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPlacementsPagedCallable()
 *           <li><p> listPlacementsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of PlacementServiceSettings to
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
 * PlacementServiceSettings placementServiceSettings =
 *     PlacementServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PlacementServiceClient placementServiceClient =
 *     PlacementServiceClient.create(placementServiceSettings);
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
 * PlacementServiceSettings placementServiceSettings =
 *     PlacementServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PlacementServiceClient placementServiceClient =
 *     PlacementServiceClient.create(placementServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PlacementServiceClient implements BackgroundResource {
  private final PlacementServiceSettings settings;
  private final PlacementServiceStub stub;

  /** Constructs an instance of PlacementServiceClient with default settings. */
  public static final PlacementServiceClient create() throws IOException {
    return create(PlacementServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PlacementServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PlacementServiceClient create(PlacementServiceSettings settings)
      throws IOException {
    return new PlacementServiceClient(settings);
  }

  /**
   * Constructs an instance of PlacementServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(PlacementServiceSettings).
   */
  public static final PlacementServiceClient create(PlacementServiceStub stub) {
    return new PlacementServiceClient(stub);
  }

  /**
   * Constructs an instance of PlacementServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PlacementServiceClient(PlacementServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PlacementServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected PlacementServiceClient(PlacementServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PlacementServiceSettings getSettings() {
    return settings;
  }

  public PlacementServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   PlacementName name = PlacementName.of("[NETWORK_CODE]", "[PLACEMENT]");
   *   Placement response = placementServiceClient.getPlacement(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Placement. Format:
   *     `networks/{network_code}/placements/{placement_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Placement getPlacement(PlacementName name) {
    GetPlacementRequest request =
        GetPlacementRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPlacement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   String name = PlacementName.of("[NETWORK_CODE]", "[PLACEMENT]").toString();
   *   Placement response = placementServiceClient.getPlacement(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Placement. Format:
   *     `networks/{network_code}/placements/{placement_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Placement getPlacement(String name) {
    GetPlacementRequest request = GetPlacementRequest.newBuilder().setName(name).build();
    return getPlacement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   GetPlacementRequest request =
   *       GetPlacementRequest.newBuilder()
   *           .setName(PlacementName.of("[NETWORK_CODE]", "[PLACEMENT]").toString())
   *           .build();
   *   Placement response = placementServiceClient.getPlacement(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Placement getPlacement(GetPlacementRequest request) {
    return getPlacementCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   GetPlacementRequest request =
   *       GetPlacementRequest.newBuilder()
   *           .setName(PlacementName.of("[NETWORK_CODE]", "[PLACEMENT]").toString())
   *           .build();
   *   ApiFuture<Placement> future =
   *       placementServiceClient.getPlacementCallable().futureCall(request);
   *   // Do something.
   *   Placement response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPlacementRequest, Placement> getPlacementCallable() {
    return stub.getPlacementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Placement element : placementServiceClient.listPlacements(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Placements. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPlacementsPagedResponse listPlacements(NetworkName parent) {
    ListPlacementsRequest request =
        ListPlacementsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Placement element : placementServiceClient.listPlacements(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Placements. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPlacementsPagedResponse listPlacements(String parent) {
    ListPlacementsRequest request = ListPlacementsRequest.newBuilder().setParent(parent).build();
    return listPlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   ListPlacementsRequest request =
   *       ListPlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Placement element : placementServiceClient.listPlacements(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPlacementsPagedResponse listPlacements(ListPlacementsRequest request) {
    return listPlacementsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   ListPlacementsRequest request =
   *       ListPlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Placement> future =
   *       placementServiceClient.listPlacementsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Placement element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPlacementsRequest, ListPlacementsPagedResponse>
      listPlacementsPagedCallable() {
    return stub.listPlacementsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   ListPlacementsRequest request =
   *       ListPlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListPlacementsResponse response =
   *         placementServiceClient.listPlacementsCallable().call(request);
   *     for (Placement element : response.getPlacementsList()) {
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
  public final UnaryCallable<ListPlacementsRequest, ListPlacementsResponse>
      listPlacementsCallable() {
    return stub.listPlacementsCallable();
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

  public static class ListPlacementsPagedResponse
      extends AbstractPagedListResponse<
          ListPlacementsRequest,
          ListPlacementsResponse,
          Placement,
          ListPlacementsPage,
          ListPlacementsFixedSizeCollection> {

    public static ApiFuture<ListPlacementsPagedResponse> createAsync(
        PageContext<ListPlacementsRequest, ListPlacementsResponse, Placement> context,
        ApiFuture<ListPlacementsResponse> futureResponse) {
      ApiFuture<ListPlacementsPage> futurePage =
          ListPlacementsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPlacementsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPlacementsPagedResponse(ListPlacementsPage page) {
      super(page, ListPlacementsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPlacementsPage
      extends AbstractPage<
          ListPlacementsRequest, ListPlacementsResponse, Placement, ListPlacementsPage> {

    private ListPlacementsPage(
        PageContext<ListPlacementsRequest, ListPlacementsResponse, Placement> context,
        ListPlacementsResponse response) {
      super(context, response);
    }

    private static ListPlacementsPage createEmptyPage() {
      return new ListPlacementsPage(null, null);
    }

    @Override
    protected ListPlacementsPage createPage(
        PageContext<ListPlacementsRequest, ListPlacementsResponse, Placement> context,
        ListPlacementsResponse response) {
      return new ListPlacementsPage(context, response);
    }

    @Override
    public ApiFuture<ListPlacementsPage> createPageAsync(
        PageContext<ListPlacementsRequest, ListPlacementsResponse, Placement> context,
        ApiFuture<ListPlacementsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPlacementsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPlacementsRequest,
          ListPlacementsResponse,
          Placement,
          ListPlacementsPage,
          ListPlacementsFixedSizeCollection> {

    private ListPlacementsFixedSizeCollection(List<ListPlacementsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPlacementsFixedSizeCollection createEmptyCollection() {
      return new ListPlacementsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPlacementsFixedSizeCollection createCollection(
        List<ListPlacementsPage> pages, int collectionSize) {
      return new ListPlacementsFixedSizeCollection(pages, collectionSize);
    }
  }
}

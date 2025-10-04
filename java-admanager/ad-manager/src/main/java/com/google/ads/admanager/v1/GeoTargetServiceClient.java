/*
 * Copyright 2025 Google LLC
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

import com.google.ads.admanager.v1.stub.GeoTargetServiceStub;
import com.google.ads.admanager.v1.stub.GeoTargetServiceStubSettings;
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
 * Service Description: Provides methods for handling `GeoTarget` objects.
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
 * try (GeoTargetServiceClient geoTargetServiceClient = GeoTargetServiceClient.create()) {
 *   GeoTargetName name = GeoTargetName.of("[NETWORK_CODE]", "[GEO_TARGET]");
 *   GeoTarget response = geoTargetServiceClient.getGeoTarget(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GeoTargetServiceClient object to clean up resources
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
 *      <td><p> GetGeoTarget</td>
 *      <td><p> API to retrieve a `GeoTarget` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGeoTarget(GetGeoTargetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGeoTarget(GeoTargetName name)
 *           <li><p> getGeoTarget(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGeoTargetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGeoTargets</td>
 *      <td><p> API to retrieve a list of `GeoTarget` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGeoTargets(ListGeoTargetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGeoTargets(NetworkName parent)
 *           <li><p> listGeoTargets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGeoTargetsPagedCallable()
 *           <li><p> listGeoTargetsCallable()
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
 * <p>This class can be customized by passing in a custom instance of GeoTargetServiceSettings to
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
 * GeoTargetServiceSettings geoTargetServiceSettings =
 *     GeoTargetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GeoTargetServiceClient geoTargetServiceClient =
 *     GeoTargetServiceClient.create(geoTargetServiceSettings);
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
 * GeoTargetServiceSettings geoTargetServiceSettings =
 *     GeoTargetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GeoTargetServiceClient geoTargetServiceClient =
 *     GeoTargetServiceClient.create(geoTargetServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GeoTargetServiceClient implements BackgroundResource {
  private final GeoTargetServiceSettings settings;
  private final GeoTargetServiceStub stub;

  /** Constructs an instance of GeoTargetServiceClient with default settings. */
  public static final GeoTargetServiceClient create() throws IOException {
    return create(GeoTargetServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GeoTargetServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GeoTargetServiceClient create(GeoTargetServiceSettings settings)
      throws IOException {
    return new GeoTargetServiceClient(settings);
  }

  /**
   * Constructs an instance of GeoTargetServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(GeoTargetServiceSettings).
   */
  public static final GeoTargetServiceClient create(GeoTargetServiceStub stub) {
    return new GeoTargetServiceClient(stub);
  }

  /**
   * Constructs an instance of GeoTargetServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GeoTargetServiceClient(GeoTargetServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GeoTargetServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected GeoTargetServiceClient(GeoTargetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GeoTargetServiceSettings getSettings() {
    return settings;
  }

  public GeoTargetServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `GeoTarget` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeoTargetServiceClient geoTargetServiceClient = GeoTargetServiceClient.create()) {
   *   GeoTargetName name = GeoTargetName.of("[NETWORK_CODE]", "[GEO_TARGET]");
   *   GeoTarget response = geoTargetServiceClient.getGeoTarget(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the GeoTarget. Format:
   *     `networks/{network_code}/geoTargets/{geo_target_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GeoTarget getGeoTarget(GeoTargetName name) {
    GetGeoTargetRequest request =
        GetGeoTargetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGeoTarget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `GeoTarget` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeoTargetServiceClient geoTargetServiceClient = GeoTargetServiceClient.create()) {
   *   String name = GeoTargetName.of("[NETWORK_CODE]", "[GEO_TARGET]").toString();
   *   GeoTarget response = geoTargetServiceClient.getGeoTarget(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the GeoTarget. Format:
   *     `networks/{network_code}/geoTargets/{geo_target_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GeoTarget getGeoTarget(String name) {
    GetGeoTargetRequest request = GetGeoTargetRequest.newBuilder().setName(name).build();
    return getGeoTarget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `GeoTarget` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeoTargetServiceClient geoTargetServiceClient = GeoTargetServiceClient.create()) {
   *   GetGeoTargetRequest request =
   *       GetGeoTargetRequest.newBuilder()
   *           .setName(GeoTargetName.of("[NETWORK_CODE]", "[GEO_TARGET]").toString())
   *           .build();
   *   GeoTarget response = geoTargetServiceClient.getGeoTarget(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GeoTarget getGeoTarget(GetGeoTargetRequest request) {
    return getGeoTargetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `GeoTarget` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeoTargetServiceClient geoTargetServiceClient = GeoTargetServiceClient.create()) {
   *   GetGeoTargetRequest request =
   *       GetGeoTargetRequest.newBuilder()
   *           .setName(GeoTargetName.of("[NETWORK_CODE]", "[GEO_TARGET]").toString())
   *           .build();
   *   ApiFuture<GeoTarget> future =
   *       geoTargetServiceClient.getGeoTargetCallable().futureCall(request);
   *   // Do something.
   *   GeoTarget response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGeoTargetRequest, GeoTarget> getGeoTargetCallable() {
    return stub.getGeoTargetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `GeoTarget` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeoTargetServiceClient geoTargetServiceClient = GeoTargetServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (GeoTarget element : geoTargetServiceClient.listGeoTargets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of GeoTargets. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGeoTargetsPagedResponse listGeoTargets(NetworkName parent) {
    ListGeoTargetsRequest request =
        ListGeoTargetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGeoTargets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `GeoTarget` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeoTargetServiceClient geoTargetServiceClient = GeoTargetServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (GeoTarget element : geoTargetServiceClient.listGeoTargets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of GeoTargets. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGeoTargetsPagedResponse listGeoTargets(String parent) {
    ListGeoTargetsRequest request = ListGeoTargetsRequest.newBuilder().setParent(parent).build();
    return listGeoTargets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `GeoTarget` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeoTargetServiceClient geoTargetServiceClient = GeoTargetServiceClient.create()) {
   *   ListGeoTargetsRequest request =
   *       ListGeoTargetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (GeoTarget element : geoTargetServiceClient.listGeoTargets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGeoTargetsPagedResponse listGeoTargets(ListGeoTargetsRequest request) {
    return listGeoTargetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `GeoTarget` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeoTargetServiceClient geoTargetServiceClient = GeoTargetServiceClient.create()) {
   *   ListGeoTargetsRequest request =
   *       ListGeoTargetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<GeoTarget> future =
   *       geoTargetServiceClient.listGeoTargetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GeoTarget element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGeoTargetsRequest, ListGeoTargetsPagedResponse>
      listGeoTargetsPagedCallable() {
    return stub.listGeoTargetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `GeoTarget` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeoTargetServiceClient geoTargetServiceClient = GeoTargetServiceClient.create()) {
   *   ListGeoTargetsRequest request =
   *       ListGeoTargetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListGeoTargetsResponse response =
   *         geoTargetServiceClient.listGeoTargetsCallable().call(request);
   *     for (GeoTarget element : response.getGeoTargetsList()) {
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
  public final UnaryCallable<ListGeoTargetsRequest, ListGeoTargetsResponse>
      listGeoTargetsCallable() {
    return stub.listGeoTargetsCallable();
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

  public static class ListGeoTargetsPagedResponse
      extends AbstractPagedListResponse<
          ListGeoTargetsRequest,
          ListGeoTargetsResponse,
          GeoTarget,
          ListGeoTargetsPage,
          ListGeoTargetsFixedSizeCollection> {

    public static ApiFuture<ListGeoTargetsPagedResponse> createAsync(
        PageContext<ListGeoTargetsRequest, ListGeoTargetsResponse, GeoTarget> context,
        ApiFuture<ListGeoTargetsResponse> futureResponse) {
      ApiFuture<ListGeoTargetsPage> futurePage =
          ListGeoTargetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGeoTargetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGeoTargetsPagedResponse(ListGeoTargetsPage page) {
      super(page, ListGeoTargetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGeoTargetsPage
      extends AbstractPage<
          ListGeoTargetsRequest, ListGeoTargetsResponse, GeoTarget, ListGeoTargetsPage> {

    private ListGeoTargetsPage(
        PageContext<ListGeoTargetsRequest, ListGeoTargetsResponse, GeoTarget> context,
        ListGeoTargetsResponse response) {
      super(context, response);
    }

    private static ListGeoTargetsPage createEmptyPage() {
      return new ListGeoTargetsPage(null, null);
    }

    @Override
    protected ListGeoTargetsPage createPage(
        PageContext<ListGeoTargetsRequest, ListGeoTargetsResponse, GeoTarget> context,
        ListGeoTargetsResponse response) {
      return new ListGeoTargetsPage(context, response);
    }

    @Override
    public ApiFuture<ListGeoTargetsPage> createPageAsync(
        PageContext<ListGeoTargetsRequest, ListGeoTargetsResponse, GeoTarget> context,
        ApiFuture<ListGeoTargetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGeoTargetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGeoTargetsRequest,
          ListGeoTargetsResponse,
          GeoTarget,
          ListGeoTargetsPage,
          ListGeoTargetsFixedSizeCollection> {

    private ListGeoTargetsFixedSizeCollection(List<ListGeoTargetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGeoTargetsFixedSizeCollection createEmptyCollection() {
      return new ListGeoTargetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGeoTargetsFixedSizeCollection createCollection(
        List<ListGeoTargetsPage> pages, int collectionSize) {
      return new ListGeoTargetsFixedSizeCollection(pages, collectionSize);
    }
  }
}

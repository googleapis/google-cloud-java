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

import com.google.ads.admanager.v1.stub.AdUnitServiceStub;
import com.google.ads.admanager.v1.stub.AdUnitServiceStubSettings;
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
 * Service Description: Provides methods for handling AdUnit objects.
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
 * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
 *   AdUnitName name = AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]");
 *   AdUnit response = adUnitServiceClient.getAdUnit(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AdUnitServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetAdUnit</td>
 *      <td><p> API to retrieve an AdUnit object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAdUnit(GetAdUnitRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAdUnit(AdUnitName name)
 *           <li><p> getAdUnit(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAdUnitCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAdUnits</td>
 *      <td><p> API to retrieve a list of AdUnit objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAdUnits(ListAdUnitsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAdUnits(NetworkName parent)
 *           <li><p> listAdUnits(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAdUnitsPagedCallable()
 *           <li><p> listAdUnitsCallable()
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
 * <p>This class can be customized by passing in a custom instance of AdUnitServiceSettings to
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
 * AdUnitServiceSettings adUnitServiceSettings =
 *     AdUnitServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create(adUnitServiceSettings);
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
 * AdUnitServiceSettings adUnitServiceSettings =
 *     AdUnitServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create(adUnitServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AdUnitServiceClient implements BackgroundResource {
  private final AdUnitServiceSettings settings;
  private final AdUnitServiceStub stub;

  /** Constructs an instance of AdUnitServiceClient with default settings. */
  public static final AdUnitServiceClient create() throws IOException {
    return create(AdUnitServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AdUnitServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AdUnitServiceClient create(AdUnitServiceSettings settings)
      throws IOException {
    return new AdUnitServiceClient(settings);
  }

  /**
   * Constructs an instance of AdUnitServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AdUnitServiceSettings).
   */
  public static final AdUnitServiceClient create(AdUnitServiceStub stub) {
    return new AdUnitServiceClient(stub);
  }

  /**
   * Constructs an instance of AdUnitServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AdUnitServiceClient(AdUnitServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AdUnitServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AdUnitServiceClient(AdUnitServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AdUnitServiceSettings getSettings() {
    return settings;
  }

  public AdUnitServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an AdUnit object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   AdUnitName name = AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]");
   *   AdUnit response = adUnitServiceClient.getAdUnit(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AdUnit. Format:
   *     `networks/{network_code}/adUnits/{ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdUnit getAdUnit(AdUnitName name) {
    GetAdUnitRequest request =
        GetAdUnitRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAdUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an AdUnit object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   String name = AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString();
   *   AdUnit response = adUnitServiceClient.getAdUnit(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AdUnit. Format:
   *     `networks/{network_code}/adUnits/{ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdUnit getAdUnit(String name) {
    GetAdUnitRequest request = GetAdUnitRequest.newBuilder().setName(name).build();
    return getAdUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an AdUnit object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   GetAdUnitRequest request =
   *       GetAdUnitRequest.newBuilder()
   *           .setName(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
   *           .build();
   *   AdUnit response = adUnitServiceClient.getAdUnit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdUnit getAdUnit(GetAdUnitRequest request) {
    return getAdUnitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an AdUnit object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   GetAdUnitRequest request =
   *       GetAdUnitRequest.newBuilder()
   *           .setName(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
   *           .build();
   *   ApiFuture<AdUnit> future = adUnitServiceClient.getAdUnitCallable().futureCall(request);
   *   // Do something.
   *   AdUnit response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAdUnitRequest, AdUnit> getAdUnitCallable() {
    return stub.getAdUnitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnit objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (AdUnit element : adUnitServiceClient.listAdUnits(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdUnits. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdUnitsPagedResponse listAdUnits(NetworkName parent) {
    ListAdUnitsRequest request =
        ListAdUnitsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnit objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (AdUnit element : adUnitServiceClient.listAdUnits(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdUnits. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdUnitsPagedResponse listAdUnits(String parent) {
    ListAdUnitsRequest request = ListAdUnitsRequest.newBuilder().setParent(parent).build();
    return listAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnit objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   ListAdUnitsRequest request =
   *       ListAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (AdUnit element : adUnitServiceClient.listAdUnits(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdUnitsPagedResponse listAdUnits(ListAdUnitsRequest request) {
    return listAdUnitsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnit objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   ListAdUnitsRequest request =
   *       ListAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<AdUnit> future = adUnitServiceClient.listAdUnitsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AdUnit element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdUnitsRequest, ListAdUnitsPagedResponse>
      listAdUnitsPagedCallable() {
    return stub.listAdUnitsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnit objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   ListAdUnitsRequest request =
   *       ListAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListAdUnitsResponse response = adUnitServiceClient.listAdUnitsCallable().call(request);
   *     for (AdUnit element : response.getAdUnitsList()) {
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
  public final UnaryCallable<ListAdUnitsRequest, ListAdUnitsResponse> listAdUnitsCallable() {
    return stub.listAdUnitsCallable();
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

  public static class ListAdUnitsPagedResponse
      extends AbstractPagedListResponse<
          ListAdUnitsRequest,
          ListAdUnitsResponse,
          AdUnit,
          ListAdUnitsPage,
          ListAdUnitsFixedSizeCollection> {

    public static ApiFuture<ListAdUnitsPagedResponse> createAsync(
        PageContext<ListAdUnitsRequest, ListAdUnitsResponse, AdUnit> context,
        ApiFuture<ListAdUnitsResponse> futureResponse) {
      ApiFuture<ListAdUnitsPage> futurePage =
          ListAdUnitsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListAdUnitsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListAdUnitsPagedResponse(ListAdUnitsPage page) {
      super(page, ListAdUnitsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAdUnitsPage
      extends AbstractPage<ListAdUnitsRequest, ListAdUnitsResponse, AdUnit, ListAdUnitsPage> {

    private ListAdUnitsPage(
        PageContext<ListAdUnitsRequest, ListAdUnitsResponse, AdUnit> context,
        ListAdUnitsResponse response) {
      super(context, response);
    }

    private static ListAdUnitsPage createEmptyPage() {
      return new ListAdUnitsPage(null, null);
    }

    @Override
    protected ListAdUnitsPage createPage(
        PageContext<ListAdUnitsRequest, ListAdUnitsResponse, AdUnit> context,
        ListAdUnitsResponse response) {
      return new ListAdUnitsPage(context, response);
    }

    @Override
    public ApiFuture<ListAdUnitsPage> createPageAsync(
        PageContext<ListAdUnitsRequest, ListAdUnitsResponse, AdUnit> context,
        ApiFuture<ListAdUnitsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAdUnitsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAdUnitsRequest,
          ListAdUnitsResponse,
          AdUnit,
          ListAdUnitsPage,
          ListAdUnitsFixedSizeCollection> {

    private ListAdUnitsFixedSizeCollection(List<ListAdUnitsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAdUnitsFixedSizeCollection createEmptyCollection() {
      return new ListAdUnitsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAdUnitsFixedSizeCollection createCollection(
        List<ListAdUnitsPage> pages, int collectionSize) {
      return new ListAdUnitsFixedSizeCollection(pages, collectionSize);
    }
  }
}

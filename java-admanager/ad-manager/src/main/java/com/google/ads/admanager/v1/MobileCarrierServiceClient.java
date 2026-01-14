/*
 * Copyright 2026 Google LLC
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

import com.google.ads.admanager.v1.stub.MobileCarrierServiceStub;
import com.google.ads.admanager.v1.stub.MobileCarrierServiceStubSettings;
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
 * Service Description: Provides methods for handling `MobileCarrier` objects.
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
 * try (MobileCarrierServiceClient mobileCarrierServiceClient =
 *     MobileCarrierServiceClient.create()) {
 *   MobileCarrierName name = MobileCarrierName.of("[NETWORK_CODE]", "[MOBILE_CARRIER]");
 *   MobileCarrier response = mobileCarrierServiceClient.getMobileCarrier(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MobileCarrierServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetMobileCarrier</td>
 *      <td><p> API to retrieve a `MobileCarrier` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMobileCarrier(GetMobileCarrierRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMobileCarrier(MobileCarrierName name)
 *           <li><p> getMobileCarrier(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMobileCarrierCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMobileCarriers</td>
 *      <td><p> API to retrieve a list of `MobileCarrier` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMobileCarriers(ListMobileCarriersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMobileCarriers(NetworkName parent)
 *           <li><p> listMobileCarriers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMobileCarriersPagedCallable()
 *           <li><p> listMobileCarriersCallable()
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
 * <p>This class can be customized by passing in a custom instance of MobileCarrierServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MobileCarrierServiceSettings mobileCarrierServiceSettings =
 *     MobileCarrierServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MobileCarrierServiceClient mobileCarrierServiceClient =
 *     MobileCarrierServiceClient.create(mobileCarrierServiceSettings);
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
 * MobileCarrierServiceSettings mobileCarrierServiceSettings =
 *     MobileCarrierServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MobileCarrierServiceClient mobileCarrierServiceClient =
 *     MobileCarrierServiceClient.create(mobileCarrierServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class MobileCarrierServiceClient implements BackgroundResource {
  private final MobileCarrierServiceSettings settings;
  private final MobileCarrierServiceStub stub;

  /** Constructs an instance of MobileCarrierServiceClient with default settings. */
  public static final MobileCarrierServiceClient create() throws IOException {
    return create(MobileCarrierServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MobileCarrierServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MobileCarrierServiceClient create(MobileCarrierServiceSettings settings)
      throws IOException {
    return new MobileCarrierServiceClient(settings);
  }

  /**
   * Constructs an instance of MobileCarrierServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(MobileCarrierServiceSettings).
   */
  public static final MobileCarrierServiceClient create(MobileCarrierServiceStub stub) {
    return new MobileCarrierServiceClient(stub);
  }

  /**
   * Constructs an instance of MobileCarrierServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected MobileCarrierServiceClient(MobileCarrierServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MobileCarrierServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected MobileCarrierServiceClient(MobileCarrierServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MobileCarrierServiceSettings getSettings() {
    return settings;
  }

  public MobileCarrierServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `MobileCarrier` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileCarrierServiceClient mobileCarrierServiceClient =
   *     MobileCarrierServiceClient.create()) {
   *   MobileCarrierName name = MobileCarrierName.of("[NETWORK_CODE]", "[MOBILE_CARRIER]");
   *   MobileCarrier response = mobileCarrierServiceClient.getMobileCarrier(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the MobileCarrier. Format:
   *     `networks/{network_code}/mobileCarriers/{mobile_carrier_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MobileCarrier getMobileCarrier(MobileCarrierName name) {
    GetMobileCarrierRequest request =
        GetMobileCarrierRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMobileCarrier(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `MobileCarrier` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileCarrierServiceClient mobileCarrierServiceClient =
   *     MobileCarrierServiceClient.create()) {
   *   String name = MobileCarrierName.of("[NETWORK_CODE]", "[MOBILE_CARRIER]").toString();
   *   MobileCarrier response = mobileCarrierServiceClient.getMobileCarrier(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the MobileCarrier. Format:
   *     `networks/{network_code}/mobileCarriers/{mobile_carrier_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MobileCarrier getMobileCarrier(String name) {
    GetMobileCarrierRequest request = GetMobileCarrierRequest.newBuilder().setName(name).build();
    return getMobileCarrier(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `MobileCarrier` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileCarrierServiceClient mobileCarrierServiceClient =
   *     MobileCarrierServiceClient.create()) {
   *   GetMobileCarrierRequest request =
   *       GetMobileCarrierRequest.newBuilder()
   *           .setName(MobileCarrierName.of("[NETWORK_CODE]", "[MOBILE_CARRIER]").toString())
   *           .build();
   *   MobileCarrier response = mobileCarrierServiceClient.getMobileCarrier(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MobileCarrier getMobileCarrier(GetMobileCarrierRequest request) {
    return getMobileCarrierCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `MobileCarrier` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileCarrierServiceClient mobileCarrierServiceClient =
   *     MobileCarrierServiceClient.create()) {
   *   GetMobileCarrierRequest request =
   *       GetMobileCarrierRequest.newBuilder()
   *           .setName(MobileCarrierName.of("[NETWORK_CODE]", "[MOBILE_CARRIER]").toString())
   *           .build();
   *   ApiFuture<MobileCarrier> future =
   *       mobileCarrierServiceClient.getMobileCarrierCallable().futureCall(request);
   *   // Do something.
   *   MobileCarrier response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMobileCarrierRequest, MobileCarrier> getMobileCarrierCallable() {
    return stub.getMobileCarrierCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileCarrier` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileCarrierServiceClient mobileCarrierServiceClient =
   *     MobileCarrierServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (MobileCarrier element :
   *       mobileCarrierServiceClient.listMobileCarriers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of MobileCarriers. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMobileCarriersPagedResponse listMobileCarriers(NetworkName parent) {
    ListMobileCarriersRequest request =
        ListMobileCarriersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMobileCarriers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileCarrier` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileCarrierServiceClient mobileCarrierServiceClient =
   *     MobileCarrierServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (MobileCarrier element :
   *       mobileCarrierServiceClient.listMobileCarriers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of MobileCarriers. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMobileCarriersPagedResponse listMobileCarriers(String parent) {
    ListMobileCarriersRequest request =
        ListMobileCarriersRequest.newBuilder().setParent(parent).build();
    return listMobileCarriers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileCarrier` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileCarrierServiceClient mobileCarrierServiceClient =
   *     MobileCarrierServiceClient.create()) {
   *   ListMobileCarriersRequest request =
   *       ListMobileCarriersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (MobileCarrier element :
   *       mobileCarrierServiceClient.listMobileCarriers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMobileCarriersPagedResponse listMobileCarriers(
      ListMobileCarriersRequest request) {
    return listMobileCarriersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileCarrier` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileCarrierServiceClient mobileCarrierServiceClient =
   *     MobileCarrierServiceClient.create()) {
   *   ListMobileCarriersRequest request =
   *       ListMobileCarriersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<MobileCarrier> future =
   *       mobileCarrierServiceClient.listMobileCarriersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MobileCarrier element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMobileCarriersRequest, ListMobileCarriersPagedResponse>
      listMobileCarriersPagedCallable() {
    return stub.listMobileCarriersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `MobileCarrier` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MobileCarrierServiceClient mobileCarrierServiceClient =
   *     MobileCarrierServiceClient.create()) {
   *   ListMobileCarriersRequest request =
   *       ListMobileCarriersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListMobileCarriersResponse response =
   *         mobileCarrierServiceClient.listMobileCarriersCallable().call(request);
   *     for (MobileCarrier element : response.getMobileCarriersList()) {
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
  public final UnaryCallable<ListMobileCarriersRequest, ListMobileCarriersResponse>
      listMobileCarriersCallable() {
    return stub.listMobileCarriersCallable();
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

  public static class ListMobileCarriersPagedResponse
      extends AbstractPagedListResponse<
          ListMobileCarriersRequest,
          ListMobileCarriersResponse,
          MobileCarrier,
          ListMobileCarriersPage,
          ListMobileCarriersFixedSizeCollection> {

    public static ApiFuture<ListMobileCarriersPagedResponse> createAsync(
        PageContext<ListMobileCarriersRequest, ListMobileCarriersResponse, MobileCarrier> context,
        ApiFuture<ListMobileCarriersResponse> futureResponse) {
      ApiFuture<ListMobileCarriersPage> futurePage =
          ListMobileCarriersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMobileCarriersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMobileCarriersPagedResponse(ListMobileCarriersPage page) {
      super(page, ListMobileCarriersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMobileCarriersPage
      extends AbstractPage<
          ListMobileCarriersRequest,
          ListMobileCarriersResponse,
          MobileCarrier,
          ListMobileCarriersPage> {

    private ListMobileCarriersPage(
        PageContext<ListMobileCarriersRequest, ListMobileCarriersResponse, MobileCarrier> context,
        ListMobileCarriersResponse response) {
      super(context, response);
    }

    private static ListMobileCarriersPage createEmptyPage() {
      return new ListMobileCarriersPage(null, null);
    }

    @Override
    protected ListMobileCarriersPage createPage(
        PageContext<ListMobileCarriersRequest, ListMobileCarriersResponse, MobileCarrier> context,
        ListMobileCarriersResponse response) {
      return new ListMobileCarriersPage(context, response);
    }

    @Override
    public ApiFuture<ListMobileCarriersPage> createPageAsync(
        PageContext<ListMobileCarriersRequest, ListMobileCarriersResponse, MobileCarrier> context,
        ApiFuture<ListMobileCarriersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMobileCarriersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMobileCarriersRequest,
          ListMobileCarriersResponse,
          MobileCarrier,
          ListMobileCarriersPage,
          ListMobileCarriersFixedSizeCollection> {

    private ListMobileCarriersFixedSizeCollection(
        List<ListMobileCarriersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMobileCarriersFixedSizeCollection createEmptyCollection() {
      return new ListMobileCarriersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMobileCarriersFixedSizeCollection createCollection(
        List<ListMobileCarriersPage> pages, int collectionSize) {
      return new ListMobileCarriersFixedSizeCollection(pages, collectionSize);
    }
  }
}

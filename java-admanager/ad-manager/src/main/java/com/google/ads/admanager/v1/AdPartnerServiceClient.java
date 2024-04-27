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

import com.google.ads.admanager.v1.stub.AdPartnerServiceStub;
import com.google.ads.admanager.v1.stub.AdPartnerServiceStubSettings;
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
 * Service Description: Provides methods for handling AdPartner objects.
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
 * try (AdPartnerServiceClient adPartnerServiceClient = AdPartnerServiceClient.create()) {
 *   AdPartnerName name = AdPartnerName.of("[NETWORK_CODE]", "[AD_PARTNER]");
 *   AdPartner response = adPartnerServiceClient.getAdPartner(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AdPartnerServiceClient object to clean up resources
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
 *      <td><p> GetAdPartner</td>
 *      <td><p> API to retrieve a AdPartner object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAdPartner(GetAdPartnerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAdPartner(AdPartnerName name)
 *           <li><p> getAdPartner(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAdPartnerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAdPartners</td>
 *      <td><p> API to retrieve a list of AdPartner objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAdPartners(ListAdPartnersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAdPartners(NetworkName parent)
 *           <li><p> listAdPartners(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAdPartnersPagedCallable()
 *           <li><p> listAdPartnersCallable()
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
 * <p>This class can be customized by passing in a custom instance of AdPartnerServiceSettings to
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
 * AdPartnerServiceSettings adPartnerServiceSettings =
 *     AdPartnerServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AdPartnerServiceClient adPartnerServiceClient =
 *     AdPartnerServiceClient.create(adPartnerServiceSettings);
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
 * AdPartnerServiceSettings adPartnerServiceSettings =
 *     AdPartnerServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AdPartnerServiceClient adPartnerServiceClient =
 *     AdPartnerServiceClient.create(adPartnerServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AdPartnerServiceClient implements BackgroundResource {
  private final AdPartnerServiceSettings settings;
  private final AdPartnerServiceStub stub;

  /** Constructs an instance of AdPartnerServiceClient with default settings. */
  public static final AdPartnerServiceClient create() throws IOException {
    return create(AdPartnerServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AdPartnerServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AdPartnerServiceClient create(AdPartnerServiceSettings settings)
      throws IOException {
    return new AdPartnerServiceClient(settings);
  }

  /**
   * Constructs an instance of AdPartnerServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(AdPartnerServiceSettings).
   */
  public static final AdPartnerServiceClient create(AdPartnerServiceStub stub) {
    return new AdPartnerServiceClient(stub);
  }

  /**
   * Constructs an instance of AdPartnerServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AdPartnerServiceClient(AdPartnerServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AdPartnerServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AdPartnerServiceClient(AdPartnerServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AdPartnerServiceSettings getSettings() {
    return settings;
  }

  public AdPartnerServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a AdPartner object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdPartnerServiceClient adPartnerServiceClient = AdPartnerServiceClient.create()) {
   *   AdPartnerName name = AdPartnerName.of("[NETWORK_CODE]", "[AD_PARTNER]");
   *   AdPartner response = adPartnerServiceClient.getAdPartner(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AdPartner. Format:
   *     `networks/{network_code}/adPartners/{ad_partner_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdPartner getAdPartner(AdPartnerName name) {
    GetAdPartnerRequest request =
        GetAdPartnerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAdPartner(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a AdPartner object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdPartnerServiceClient adPartnerServiceClient = AdPartnerServiceClient.create()) {
   *   String name = AdPartnerName.of("[NETWORK_CODE]", "[AD_PARTNER]").toString();
   *   AdPartner response = adPartnerServiceClient.getAdPartner(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AdPartner. Format:
   *     `networks/{network_code}/adPartners/{ad_partner_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdPartner getAdPartner(String name) {
    GetAdPartnerRequest request = GetAdPartnerRequest.newBuilder().setName(name).build();
    return getAdPartner(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a AdPartner object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdPartnerServiceClient adPartnerServiceClient = AdPartnerServiceClient.create()) {
   *   GetAdPartnerRequest request =
   *       GetAdPartnerRequest.newBuilder()
   *           .setName(AdPartnerName.of("[NETWORK_CODE]", "[AD_PARTNER]").toString())
   *           .build();
   *   AdPartner response = adPartnerServiceClient.getAdPartner(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdPartner getAdPartner(GetAdPartnerRequest request) {
    return getAdPartnerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a AdPartner object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdPartnerServiceClient adPartnerServiceClient = AdPartnerServiceClient.create()) {
   *   GetAdPartnerRequest request =
   *       GetAdPartnerRequest.newBuilder()
   *           .setName(AdPartnerName.of("[NETWORK_CODE]", "[AD_PARTNER]").toString())
   *           .build();
   *   ApiFuture<AdPartner> future =
   *       adPartnerServiceClient.getAdPartnerCallable().futureCall(request);
   *   // Do something.
   *   AdPartner response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAdPartnerRequest, AdPartner> getAdPartnerCallable() {
    return stub.getAdPartnerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdPartner objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdPartnerServiceClient adPartnerServiceClient = AdPartnerServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (AdPartner element : adPartnerServiceClient.listAdPartners(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdPartners. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdPartnersPagedResponse listAdPartners(NetworkName parent) {
    ListAdPartnersRequest request =
        ListAdPartnersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAdPartners(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdPartner objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdPartnerServiceClient adPartnerServiceClient = AdPartnerServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (AdPartner element : adPartnerServiceClient.listAdPartners(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdPartners. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdPartnersPagedResponse listAdPartners(String parent) {
    ListAdPartnersRequest request = ListAdPartnersRequest.newBuilder().setParent(parent).build();
    return listAdPartners(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdPartner objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdPartnerServiceClient adPartnerServiceClient = AdPartnerServiceClient.create()) {
   *   ListAdPartnersRequest request =
   *       ListAdPartnersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (AdPartner element : adPartnerServiceClient.listAdPartners(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdPartnersPagedResponse listAdPartners(ListAdPartnersRequest request) {
    return listAdPartnersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdPartner objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdPartnerServiceClient adPartnerServiceClient = AdPartnerServiceClient.create()) {
   *   ListAdPartnersRequest request =
   *       ListAdPartnersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<AdPartner> future =
   *       adPartnerServiceClient.listAdPartnersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AdPartner element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdPartnersRequest, ListAdPartnersPagedResponse>
      listAdPartnersPagedCallable() {
    return stub.listAdPartnersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdPartner objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdPartnerServiceClient adPartnerServiceClient = AdPartnerServiceClient.create()) {
   *   ListAdPartnersRequest request =
   *       ListAdPartnersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListAdPartnersResponse response =
   *         adPartnerServiceClient.listAdPartnersCallable().call(request);
   *     for (AdPartner element : response.getAdPartnersList()) {
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
  public final UnaryCallable<ListAdPartnersRequest, ListAdPartnersResponse>
      listAdPartnersCallable() {
    return stub.listAdPartnersCallable();
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

  public static class ListAdPartnersPagedResponse
      extends AbstractPagedListResponse<
          ListAdPartnersRequest,
          ListAdPartnersResponse,
          AdPartner,
          ListAdPartnersPage,
          ListAdPartnersFixedSizeCollection> {

    public static ApiFuture<ListAdPartnersPagedResponse> createAsync(
        PageContext<ListAdPartnersRequest, ListAdPartnersResponse, AdPartner> context,
        ApiFuture<ListAdPartnersResponse> futureResponse) {
      ApiFuture<ListAdPartnersPage> futurePage =
          ListAdPartnersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAdPartnersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAdPartnersPagedResponse(ListAdPartnersPage page) {
      super(page, ListAdPartnersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAdPartnersPage
      extends AbstractPage<
          ListAdPartnersRequest, ListAdPartnersResponse, AdPartner, ListAdPartnersPage> {

    private ListAdPartnersPage(
        PageContext<ListAdPartnersRequest, ListAdPartnersResponse, AdPartner> context,
        ListAdPartnersResponse response) {
      super(context, response);
    }

    private static ListAdPartnersPage createEmptyPage() {
      return new ListAdPartnersPage(null, null);
    }

    @Override
    protected ListAdPartnersPage createPage(
        PageContext<ListAdPartnersRequest, ListAdPartnersResponse, AdPartner> context,
        ListAdPartnersResponse response) {
      return new ListAdPartnersPage(context, response);
    }

    @Override
    public ApiFuture<ListAdPartnersPage> createPageAsync(
        PageContext<ListAdPartnersRequest, ListAdPartnersResponse, AdPartner> context,
        ApiFuture<ListAdPartnersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAdPartnersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAdPartnersRequest,
          ListAdPartnersResponse,
          AdPartner,
          ListAdPartnersPage,
          ListAdPartnersFixedSizeCollection> {

    private ListAdPartnersFixedSizeCollection(List<ListAdPartnersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAdPartnersFixedSizeCollection createEmptyCollection() {
      return new ListAdPartnersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAdPartnersFixedSizeCollection createCollection(
        List<ListAdPartnersPage> pages, int collectionSize) {
      return new ListAdPartnersFixedSizeCollection(pages, collectionSize);
    }
  }
}

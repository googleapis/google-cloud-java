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

import com.google.ads.admanager.v1.stub.YieldPartnerServiceStub;
import com.google.ads.admanager.v1.stub.YieldPartnerServiceStubSettings;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for retrieving yield partners.
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
 * try (YieldPartnerServiceClient yieldPartnerServiceClient = YieldPartnerServiceClient.create()) {
 *   YieldPartnerName name = YieldPartnerName.of("[NETWORK_CODE]", "[YIELD_PARTNER]");
 *   YieldPartner response = yieldPartnerServiceClient.getYieldPartner(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the YieldPartnerServiceClient object to clean up resources
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
 *      <td><p> GetYieldPartner</td>
 *      <td><p> Gets a `YieldPartner` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getYieldPartner(GetYieldPartnerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getYieldPartner(YieldPartnerName name)
 *           <li><p> getYieldPartner(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getYieldPartnerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListYieldPartners</td>
 *      <td><p> Gets a list of all yield partners.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listYieldPartners(ListYieldPartnersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listYieldPartners(NetworkName parent)
 *           <li><p> listYieldPartners(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listYieldPartnersPagedCallable()
 *           <li><p> listYieldPartnersCallable()
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
 * <p>This class can be customized by passing in a custom instance of YieldPartnerServiceSettings to
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
 * YieldPartnerServiceSettings yieldPartnerServiceSettings =
 *     YieldPartnerServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * YieldPartnerServiceClient yieldPartnerServiceClient =
 *     YieldPartnerServiceClient.create(yieldPartnerServiceSettings);
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
 * YieldPartnerServiceSettings yieldPartnerServiceSettings =
 *     YieldPartnerServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * YieldPartnerServiceClient yieldPartnerServiceClient =
 *     YieldPartnerServiceClient.create(yieldPartnerServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class YieldPartnerServiceClient implements BackgroundResource {
  private final @Nullable YieldPartnerServiceSettings settings;
  private final YieldPartnerServiceStub stub;

  /** Constructs an instance of YieldPartnerServiceClient with default settings. */
  public static final YieldPartnerServiceClient create() throws IOException {
    return create(YieldPartnerServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of YieldPartnerServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final YieldPartnerServiceClient create(YieldPartnerServiceSettings settings)
      throws IOException {
    return new YieldPartnerServiceClient(settings);
  }

  /**
   * Constructs an instance of YieldPartnerServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(YieldPartnerServiceSettings).
   */
  public static final YieldPartnerServiceClient create(YieldPartnerServiceStub stub) {
    return new YieldPartnerServiceClient(stub);
  }

  /**
   * Constructs an instance of YieldPartnerServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected YieldPartnerServiceClient(YieldPartnerServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((YieldPartnerServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected YieldPartnerServiceClient(YieldPartnerServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable YieldPartnerServiceSettings getSettings() {
    return settings;
  }

  public YieldPartnerServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a `YieldPartner` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldPartnerServiceClient yieldPartnerServiceClient = YieldPartnerServiceClient.create()) {
   *   YieldPartnerName name = YieldPartnerName.of("[NETWORK_CODE]", "[YIELD_PARTNER]");
   *   YieldPartner response = yieldPartnerServiceClient.getYieldPartner(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the yield partner. Format:
   *     `networks/{network_code}/yieldPartners/{yieldPartnerId}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final YieldPartner getYieldPartner(@Nullable YieldPartnerName name) {
    GetYieldPartnerRequest request =
        GetYieldPartnerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getYieldPartner(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a `YieldPartner` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldPartnerServiceClient yieldPartnerServiceClient = YieldPartnerServiceClient.create()) {
   *   String name = YieldPartnerName.of("[NETWORK_CODE]", "[YIELD_PARTNER]").toString();
   *   YieldPartner response = yieldPartnerServiceClient.getYieldPartner(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the yield partner. Format:
   *     `networks/{network_code}/yieldPartners/{yieldPartnerId}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final YieldPartner getYieldPartner(String name) {
    GetYieldPartnerRequest request = GetYieldPartnerRequest.newBuilder().setName(name).build();
    return getYieldPartner(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a `YieldPartner` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldPartnerServiceClient yieldPartnerServiceClient = YieldPartnerServiceClient.create()) {
   *   GetYieldPartnerRequest request =
   *       GetYieldPartnerRequest.newBuilder()
   *           .setName(YieldPartnerName.of("[NETWORK_CODE]", "[YIELD_PARTNER]").toString())
   *           .build();
   *   YieldPartner response = yieldPartnerServiceClient.getYieldPartner(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final YieldPartner getYieldPartner(GetYieldPartnerRequest request) {
    return getYieldPartnerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a `YieldPartner` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldPartnerServiceClient yieldPartnerServiceClient = YieldPartnerServiceClient.create()) {
   *   GetYieldPartnerRequest request =
   *       GetYieldPartnerRequest.newBuilder()
   *           .setName(YieldPartnerName.of("[NETWORK_CODE]", "[YIELD_PARTNER]").toString())
   *           .build();
   *   ApiFuture<YieldPartner> future =
   *       yieldPartnerServiceClient.getYieldPartnerCallable().futureCall(request);
   *   // Do something.
   *   YieldPartner response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetYieldPartnerRequest, YieldPartner> getYieldPartnerCallable() {
    return stub.getYieldPartnerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of all yield partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldPartnerServiceClient yieldPartnerServiceClient = YieldPartnerServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (YieldPartner element :
   *       yieldPartnerServiceClient.listYieldPartners(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of yield partners. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListYieldPartnersPagedResponse listYieldPartners(@Nullable NetworkName parent) {
    ListYieldPartnersRequest request =
        ListYieldPartnersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listYieldPartners(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of all yield partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldPartnerServiceClient yieldPartnerServiceClient = YieldPartnerServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (YieldPartner element :
   *       yieldPartnerServiceClient.listYieldPartners(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of yield partners. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListYieldPartnersPagedResponse listYieldPartners(String parent) {
    ListYieldPartnersRequest request =
        ListYieldPartnersRequest.newBuilder().setParent(parent).build();
    return listYieldPartners(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of all yield partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldPartnerServiceClient yieldPartnerServiceClient = YieldPartnerServiceClient.create()) {
   *   ListYieldPartnersRequest request =
   *       ListYieldPartnersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (YieldPartner element :
   *       yieldPartnerServiceClient.listYieldPartners(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListYieldPartnersPagedResponse listYieldPartners(ListYieldPartnersRequest request) {
    return listYieldPartnersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of all yield partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldPartnerServiceClient yieldPartnerServiceClient = YieldPartnerServiceClient.create()) {
   *   ListYieldPartnersRequest request =
   *       ListYieldPartnersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<YieldPartner> future =
   *       yieldPartnerServiceClient.listYieldPartnersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (YieldPartner element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListYieldPartnersRequest, ListYieldPartnersPagedResponse>
      listYieldPartnersPagedCallable() {
    return stub.listYieldPartnersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of all yield partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (YieldPartnerServiceClient yieldPartnerServiceClient = YieldPartnerServiceClient.create()) {
   *   ListYieldPartnersRequest request =
   *       ListYieldPartnersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListYieldPartnersResponse response =
   *         yieldPartnerServiceClient.listYieldPartnersCallable().call(request);
   *     for (YieldPartner element : response.getYieldPartnersList()) {
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
  public final UnaryCallable<ListYieldPartnersRequest, ListYieldPartnersResponse>
      listYieldPartnersCallable() {
    return stub.listYieldPartnersCallable();
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

  public static class ListYieldPartnersPagedResponse
      extends AbstractPagedListResponse<
          ListYieldPartnersRequest,
          ListYieldPartnersResponse,
          YieldPartner,
          ListYieldPartnersPage,
          ListYieldPartnersFixedSizeCollection> {

    public static ApiFuture<ListYieldPartnersPagedResponse> createAsync(
        PageContext<ListYieldPartnersRequest, ListYieldPartnersResponse, YieldPartner> context,
        ApiFuture<ListYieldPartnersResponse> futureResponse) {
      ApiFuture<ListYieldPartnersPage> futurePage =
          ListYieldPartnersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListYieldPartnersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListYieldPartnersPagedResponse(ListYieldPartnersPage page) {
      super(page, ListYieldPartnersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListYieldPartnersPage
      extends AbstractPage<
          ListYieldPartnersRequest,
          ListYieldPartnersResponse,
          YieldPartner,
          ListYieldPartnersPage> {

    private ListYieldPartnersPage(
        @Nullable PageContext<ListYieldPartnersRequest, ListYieldPartnersResponse, YieldPartner>
            context,
        @Nullable ListYieldPartnersResponse response) {
      super(context, response);
    }

    private static ListYieldPartnersPage createEmptyPage() {
      return new ListYieldPartnersPage(null, null);
    }

    @Override
    protected ListYieldPartnersPage createPage(
        @Nullable PageContext<ListYieldPartnersRequest, ListYieldPartnersResponse, YieldPartner>
            context,
        @Nullable ListYieldPartnersResponse response) {
      return new ListYieldPartnersPage(context, response);
    }

    @Override
    public ApiFuture<ListYieldPartnersPage> createPageAsync(
        @Nullable PageContext<ListYieldPartnersRequest, ListYieldPartnersResponse, YieldPartner>
            context,
        ApiFuture<ListYieldPartnersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListYieldPartnersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListYieldPartnersRequest,
          ListYieldPartnersResponse,
          YieldPartner,
          ListYieldPartnersPage,
          ListYieldPartnersFixedSizeCollection> {

    private ListYieldPartnersFixedSizeCollection(
        @Nullable List<ListYieldPartnersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListYieldPartnersFixedSizeCollection createEmptyCollection() {
      return new ListYieldPartnersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListYieldPartnersFixedSizeCollection createCollection(
        @Nullable List<ListYieldPartnersPage> pages, int collectionSize) {
      return new ListYieldPartnersFixedSizeCollection(pages, collectionSize);
    }
  }
}

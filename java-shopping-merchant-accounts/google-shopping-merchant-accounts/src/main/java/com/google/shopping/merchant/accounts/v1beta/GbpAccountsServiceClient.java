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

package com.google.shopping.merchant.accounts.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.shopping.merchant.accounts.v1beta.stub.GbpAccountsServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.GbpAccountsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The service facilitates the management of a merchant's Google Business
 * Profile (GBP) account settings. This API defines the following resource model: -
 * [GbpAccount][google.shopping.merchant.accounts.v1.GbpAccount]
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
 * try (GbpAccountsServiceClient gbpAccountsServiceClient = GbpAccountsServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT]");
 *   LinkGbpAccountResponse response = gbpAccountsServiceClient.linkGbpAccount(parent);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GbpAccountsServiceClient object to clean up resources
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
 *      <td><p> ListGbpAccounts</td>
 *      <td><p> List the GBP accounts for a given merchant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGbpAccounts(ListGbpAccountsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGbpAccounts(AccountName parent)
 *           <li><p> listGbpAccounts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGbpAccountsPagedCallable()
 *           <li><p> listGbpAccountsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> LinkGbpAccount</td>
 *      <td><p> Link the specified merchant to a GBP account for all countries.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> linkGbpAccount(LinkGbpAccountRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> linkGbpAccount(AccountName parent)
 *           <li><p> linkGbpAccount(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> linkGbpAccountCallable()
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
 * <p>This class can be customized by passing in a custom instance of GbpAccountsServiceSettings to
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
 * GbpAccountsServiceSettings gbpAccountsServiceSettings =
 *     GbpAccountsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GbpAccountsServiceClient gbpAccountsServiceClient =
 *     GbpAccountsServiceClient.create(gbpAccountsServiceSettings);
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
 * GbpAccountsServiceSettings gbpAccountsServiceSettings =
 *     GbpAccountsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GbpAccountsServiceClient gbpAccountsServiceClient =
 *     GbpAccountsServiceClient.create(gbpAccountsServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GbpAccountsServiceSettings gbpAccountsServiceSettings =
 *     GbpAccountsServiceSettings.newHttpJsonBuilder().build();
 * GbpAccountsServiceClient gbpAccountsServiceClient =
 *     GbpAccountsServiceClient.create(gbpAccountsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GbpAccountsServiceClient implements BackgroundResource {
  private final GbpAccountsServiceSettings settings;
  private final GbpAccountsServiceStub stub;

  /** Constructs an instance of GbpAccountsServiceClient with default settings. */
  public static final GbpAccountsServiceClient create() throws IOException {
    return create(GbpAccountsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GbpAccountsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GbpAccountsServiceClient create(GbpAccountsServiceSettings settings)
      throws IOException {
    return new GbpAccountsServiceClient(settings);
  }

  /**
   * Constructs an instance of GbpAccountsServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(GbpAccountsServiceSettings).
   */
  public static final GbpAccountsServiceClient create(GbpAccountsServiceStub stub) {
    return new GbpAccountsServiceClient(stub);
  }

  /**
   * Constructs an instance of GbpAccountsServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GbpAccountsServiceClient(GbpAccountsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GbpAccountsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected GbpAccountsServiceClient(GbpAccountsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GbpAccountsServiceSettings getSettings() {
    return settings;
  }

  public GbpAccountsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the GBP accounts for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GbpAccountsServiceClient gbpAccountsServiceClient = GbpAccountsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (GbpAccount element : gbpAccountsServiceClient.listGbpAccounts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource under which the GBP accounts are
   *     listed. Format: `accounts/{account}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGbpAccountsPagedResponse listGbpAccounts(AccountName parent) {
    ListGbpAccountsRequest request =
        ListGbpAccountsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGbpAccounts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the GBP accounts for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GbpAccountsServiceClient gbpAccountsServiceClient = GbpAccountsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (GbpAccount element : gbpAccountsServiceClient.listGbpAccounts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource under which the GBP accounts are
   *     listed. Format: `accounts/{account}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGbpAccountsPagedResponse listGbpAccounts(String parent) {
    ListGbpAccountsRequest request = ListGbpAccountsRequest.newBuilder().setParent(parent).build();
    return listGbpAccounts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the GBP accounts for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GbpAccountsServiceClient gbpAccountsServiceClient = GbpAccountsServiceClient.create()) {
   *   ListGbpAccountsRequest request =
   *       ListGbpAccountsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (GbpAccount element : gbpAccountsServiceClient.listGbpAccounts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGbpAccountsPagedResponse listGbpAccounts(ListGbpAccountsRequest request) {
    return listGbpAccountsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the GBP accounts for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GbpAccountsServiceClient gbpAccountsServiceClient = GbpAccountsServiceClient.create()) {
   *   ListGbpAccountsRequest request =
   *       ListGbpAccountsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<GbpAccount> future =
   *       gbpAccountsServiceClient.listGbpAccountsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GbpAccount element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGbpAccountsRequest, ListGbpAccountsPagedResponse>
      listGbpAccountsPagedCallable() {
    return stub.listGbpAccountsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the GBP accounts for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GbpAccountsServiceClient gbpAccountsServiceClient = GbpAccountsServiceClient.create()) {
   *   ListGbpAccountsRequest request =
   *       ListGbpAccountsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListGbpAccountsResponse response =
   *         gbpAccountsServiceClient.listGbpAccountsCallable().call(request);
   *     for (GbpAccount element : response.getGbpAccountsList()) {
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
  public final UnaryCallable<ListGbpAccountsRequest, ListGbpAccountsResponse>
      listGbpAccountsCallable() {
    return stub.listGbpAccountsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Link the specified merchant to a GBP account for all countries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GbpAccountsServiceClient gbpAccountsServiceClient = GbpAccountsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   LinkGbpAccountResponse response = gbpAccountsServiceClient.linkGbpAccount(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource to which the GBP account is linked.
   *     Format: `accounts/{account}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LinkGbpAccountResponse linkGbpAccount(AccountName parent) {
    LinkGbpAccountRequest request =
        LinkGbpAccountRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return linkGbpAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Link the specified merchant to a GBP account for all countries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GbpAccountsServiceClient gbpAccountsServiceClient = GbpAccountsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   LinkGbpAccountResponse response = gbpAccountsServiceClient.linkGbpAccount(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent resource to which the GBP account is linked.
   *     Format: `accounts/{account}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LinkGbpAccountResponse linkGbpAccount(String parent) {
    LinkGbpAccountRequest request = LinkGbpAccountRequest.newBuilder().setParent(parent).build();
    return linkGbpAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Link the specified merchant to a GBP account for all countries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GbpAccountsServiceClient gbpAccountsServiceClient = GbpAccountsServiceClient.create()) {
   *   LinkGbpAccountRequest request =
   *       LinkGbpAccountRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setGbpEmail("gbpEmail-824582745")
   *           .build();
   *   LinkGbpAccountResponse response = gbpAccountsServiceClient.linkGbpAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LinkGbpAccountResponse linkGbpAccount(LinkGbpAccountRequest request) {
    return linkGbpAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Link the specified merchant to a GBP account for all countries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GbpAccountsServiceClient gbpAccountsServiceClient = GbpAccountsServiceClient.create()) {
   *   LinkGbpAccountRequest request =
   *       LinkGbpAccountRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setGbpEmail("gbpEmail-824582745")
   *           .build();
   *   ApiFuture<LinkGbpAccountResponse> future =
   *       gbpAccountsServiceClient.linkGbpAccountCallable().futureCall(request);
   *   // Do something.
   *   LinkGbpAccountResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LinkGbpAccountRequest, LinkGbpAccountResponse>
      linkGbpAccountCallable() {
    return stub.linkGbpAccountCallable();
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

  public static class ListGbpAccountsPagedResponse
      extends AbstractPagedListResponse<
          ListGbpAccountsRequest,
          ListGbpAccountsResponse,
          GbpAccount,
          ListGbpAccountsPage,
          ListGbpAccountsFixedSizeCollection> {

    public static ApiFuture<ListGbpAccountsPagedResponse> createAsync(
        PageContext<ListGbpAccountsRequest, ListGbpAccountsResponse, GbpAccount> context,
        ApiFuture<ListGbpAccountsResponse> futureResponse) {
      ApiFuture<ListGbpAccountsPage> futurePage =
          ListGbpAccountsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGbpAccountsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGbpAccountsPagedResponse(ListGbpAccountsPage page) {
      super(page, ListGbpAccountsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGbpAccountsPage
      extends AbstractPage<
          ListGbpAccountsRequest, ListGbpAccountsResponse, GbpAccount, ListGbpAccountsPage> {

    private ListGbpAccountsPage(
        PageContext<ListGbpAccountsRequest, ListGbpAccountsResponse, GbpAccount> context,
        ListGbpAccountsResponse response) {
      super(context, response);
    }

    private static ListGbpAccountsPage createEmptyPage() {
      return new ListGbpAccountsPage(null, null);
    }

    @Override
    protected ListGbpAccountsPage createPage(
        PageContext<ListGbpAccountsRequest, ListGbpAccountsResponse, GbpAccount> context,
        ListGbpAccountsResponse response) {
      return new ListGbpAccountsPage(context, response);
    }

    @Override
    public ApiFuture<ListGbpAccountsPage> createPageAsync(
        PageContext<ListGbpAccountsRequest, ListGbpAccountsResponse, GbpAccount> context,
        ApiFuture<ListGbpAccountsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGbpAccountsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGbpAccountsRequest,
          ListGbpAccountsResponse,
          GbpAccount,
          ListGbpAccountsPage,
          ListGbpAccountsFixedSizeCollection> {

    private ListGbpAccountsFixedSizeCollection(
        List<ListGbpAccountsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGbpAccountsFixedSizeCollection createEmptyCollection() {
      return new ListGbpAccountsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGbpAccountsFixedSizeCollection createCollection(
        List<ListGbpAccountsPage> pages, int collectionSize) {
      return new ListGbpAccountsFixedSizeCollection(pages, collectionSize);
    }
  }
}

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

package com.google.shopping.merchant.quota.v1beta;

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
import com.google.shopping.merchant.quota.v1beta.stub.QuotaServiceStub;
import com.google.shopping.merchant.quota.v1beta.stub.QuotaServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to get method call quota information per Merchant API method.
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
 * try (QuotaServiceClient quotaServiceClient = QuotaServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT]");
 *   for (QuotaGroup element : quotaServiceClient.listQuotaGroups(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the QuotaServiceClient object to clean up resources such
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
 *      <td><p> ListQuotaGroups</td>
 *      <td><p> Lists the daily call quota and usage per group for your Merchant Center account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listQuotaGroups(ListQuotaGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listQuotaGroups(AccountName parent)
 *           <li><p> listQuotaGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listQuotaGroupsPagedCallable()
 *           <li><p> listQuotaGroupsCallable()
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
 * <p>This class can be customized by passing in a custom instance of QuotaServiceSettings to
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
 * QuotaServiceSettings quotaServiceSettings =
 *     QuotaServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * QuotaServiceClient quotaServiceClient = QuotaServiceClient.create(quotaServiceSettings);
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
 * QuotaServiceSettings quotaServiceSettings =
 *     QuotaServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * QuotaServiceClient quotaServiceClient = QuotaServiceClient.create(quotaServiceSettings);
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
 * QuotaServiceSettings quotaServiceSettings = QuotaServiceSettings.newHttpJsonBuilder().build();
 * QuotaServiceClient quotaServiceClient = QuotaServiceClient.create(quotaServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class QuotaServiceClient implements BackgroundResource {
  private final QuotaServiceSettings settings;
  private final QuotaServiceStub stub;

  /** Constructs an instance of QuotaServiceClient with default settings. */
  public static final QuotaServiceClient create() throws IOException {
    return create(QuotaServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of QuotaServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final QuotaServiceClient create(QuotaServiceSettings settings) throws IOException {
    return new QuotaServiceClient(settings);
  }

  /**
   * Constructs an instance of QuotaServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(QuotaServiceSettings).
   */
  public static final QuotaServiceClient create(QuotaServiceStub stub) {
    return new QuotaServiceClient(stub);
  }

  /**
   * Constructs an instance of QuotaServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected QuotaServiceClient(QuotaServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((QuotaServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected QuotaServiceClient(QuotaServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final QuotaServiceSettings getSettings() {
    return settings;
  }

  public QuotaServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the daily call quota and usage per group for your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaServiceClient quotaServiceClient = QuotaServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (QuotaGroup element : quotaServiceClient.listQuotaGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account who owns the collection of method quotas Format:
   *     accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQuotaGroupsPagedResponse listQuotaGroups(AccountName parent) {
    ListQuotaGroupsRequest request =
        ListQuotaGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listQuotaGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the daily call quota and usage per group for your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaServiceClient quotaServiceClient = QuotaServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (QuotaGroup element : quotaServiceClient.listQuotaGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account who owns the collection of method quotas Format:
   *     accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQuotaGroupsPagedResponse listQuotaGroups(String parent) {
    ListQuotaGroupsRequest request = ListQuotaGroupsRequest.newBuilder().setParent(parent).build();
    return listQuotaGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the daily call quota and usage per group for your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaServiceClient quotaServiceClient = QuotaServiceClient.create()) {
   *   ListQuotaGroupsRequest request =
   *       ListQuotaGroupsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (QuotaGroup element : quotaServiceClient.listQuotaGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQuotaGroupsPagedResponse listQuotaGroups(ListQuotaGroupsRequest request) {
    return listQuotaGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the daily call quota and usage per group for your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaServiceClient quotaServiceClient = QuotaServiceClient.create()) {
   *   ListQuotaGroupsRequest request =
   *       ListQuotaGroupsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<QuotaGroup> future =
   *       quotaServiceClient.listQuotaGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (QuotaGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListQuotaGroupsRequest, ListQuotaGroupsPagedResponse>
      listQuotaGroupsPagedCallable() {
    return stub.listQuotaGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the daily call quota and usage per group for your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaServiceClient quotaServiceClient = QuotaServiceClient.create()) {
   *   ListQuotaGroupsRequest request =
   *       ListQuotaGroupsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListQuotaGroupsResponse response =
   *         quotaServiceClient.listQuotaGroupsCallable().call(request);
   *     for (QuotaGroup element : response.getQuotaGroupsList()) {
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
  public final UnaryCallable<ListQuotaGroupsRequest, ListQuotaGroupsResponse>
      listQuotaGroupsCallable() {
    return stub.listQuotaGroupsCallable();
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

  public static class ListQuotaGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListQuotaGroupsRequest,
          ListQuotaGroupsResponse,
          QuotaGroup,
          ListQuotaGroupsPage,
          ListQuotaGroupsFixedSizeCollection> {

    public static ApiFuture<ListQuotaGroupsPagedResponse> createAsync(
        PageContext<ListQuotaGroupsRequest, ListQuotaGroupsResponse, QuotaGroup> context,
        ApiFuture<ListQuotaGroupsResponse> futureResponse) {
      ApiFuture<ListQuotaGroupsPage> futurePage =
          ListQuotaGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListQuotaGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListQuotaGroupsPagedResponse(ListQuotaGroupsPage page) {
      super(page, ListQuotaGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListQuotaGroupsPage
      extends AbstractPage<
          ListQuotaGroupsRequest, ListQuotaGroupsResponse, QuotaGroup, ListQuotaGroupsPage> {

    private ListQuotaGroupsPage(
        PageContext<ListQuotaGroupsRequest, ListQuotaGroupsResponse, QuotaGroup> context,
        ListQuotaGroupsResponse response) {
      super(context, response);
    }

    private static ListQuotaGroupsPage createEmptyPage() {
      return new ListQuotaGroupsPage(null, null);
    }

    @Override
    protected ListQuotaGroupsPage createPage(
        PageContext<ListQuotaGroupsRequest, ListQuotaGroupsResponse, QuotaGroup> context,
        ListQuotaGroupsResponse response) {
      return new ListQuotaGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListQuotaGroupsPage> createPageAsync(
        PageContext<ListQuotaGroupsRequest, ListQuotaGroupsResponse, QuotaGroup> context,
        ApiFuture<ListQuotaGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListQuotaGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListQuotaGroupsRequest,
          ListQuotaGroupsResponse,
          QuotaGroup,
          ListQuotaGroupsPage,
          ListQuotaGroupsFixedSizeCollection> {

    private ListQuotaGroupsFixedSizeCollection(
        List<ListQuotaGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListQuotaGroupsFixedSizeCollection createEmptyCollection() {
      return new ListQuotaGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListQuotaGroupsFixedSizeCollection createCollection(
        List<ListQuotaGroupsPage> pages, int collectionSize) {
      return new ListQuotaGroupsFixedSizeCollection(pages, collectionSize);
    }
  }
}

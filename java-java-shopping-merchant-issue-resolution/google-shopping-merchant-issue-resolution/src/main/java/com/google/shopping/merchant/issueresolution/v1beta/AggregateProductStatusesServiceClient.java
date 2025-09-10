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

package com.google.shopping.merchant.issueresolution.v1beta;

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
import com.google.shopping.merchant.issueresolution.v1beta.stub.AggregateProductStatusesServiceStub;
import com.google.shopping.merchant.issueresolution.v1beta.stub.AggregateProductStatusesServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to manage aggregate product statuses.
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
 * try (AggregateProductStatusesServiceClient aggregateProductStatusesServiceClient =
 *     AggregateProductStatusesServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT]");
 *   for (AggregateProductStatus element :
 *       aggregateProductStatusesServiceClient.listAggregateProductStatuses(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AggregateProductStatusesServiceClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListAggregateProductStatuses</td>
 *      <td><p> Lists the `AggregateProductStatuses` resources for your merchant account. The response might contain fewer items than specified by `pageSize`. If `pageToken` was returned in previous request, it can be used to obtain additional results.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAggregateProductStatuses(ListAggregateProductStatusesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAggregateProductStatuses(AccountName parent)
 *           <li><p> listAggregateProductStatuses(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAggregateProductStatusesPagedCallable()
 *           <li><p> listAggregateProductStatusesCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * AggregateProductStatusesServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AggregateProductStatusesServiceSettings aggregateProductStatusesServiceSettings =
 *     AggregateProductStatusesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AggregateProductStatusesServiceClient aggregateProductStatusesServiceClient =
 *     AggregateProductStatusesServiceClient.create(aggregateProductStatusesServiceSettings);
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
 * AggregateProductStatusesServiceSettings aggregateProductStatusesServiceSettings =
 *     AggregateProductStatusesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AggregateProductStatusesServiceClient aggregateProductStatusesServiceClient =
 *     AggregateProductStatusesServiceClient.create(aggregateProductStatusesServiceSettings);
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
 * AggregateProductStatusesServiceSettings aggregateProductStatusesServiceSettings =
 *     AggregateProductStatusesServiceSettings.newHttpJsonBuilder().build();
 * AggregateProductStatusesServiceClient aggregateProductStatusesServiceClient =
 *     AggregateProductStatusesServiceClient.create(aggregateProductStatusesServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AggregateProductStatusesServiceClient implements BackgroundResource {
  private final AggregateProductStatusesServiceSettings settings;
  private final AggregateProductStatusesServiceStub stub;

  /** Constructs an instance of AggregateProductStatusesServiceClient with default settings. */
  public static final AggregateProductStatusesServiceClient create() throws IOException {
    return create(AggregateProductStatusesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AggregateProductStatusesServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final AggregateProductStatusesServiceClient create(
      AggregateProductStatusesServiceSettings settings) throws IOException {
    return new AggregateProductStatusesServiceClient(settings);
  }

  /**
   * Constructs an instance of AggregateProductStatusesServiceClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(AggregateProductStatusesServiceSettings).
   */
  public static final AggregateProductStatusesServiceClient create(
      AggregateProductStatusesServiceStub stub) {
    return new AggregateProductStatusesServiceClient(stub);
  }

  /**
   * Constructs an instance of AggregateProductStatusesServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AggregateProductStatusesServiceClient(AggregateProductStatusesServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((AggregateProductStatusesServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AggregateProductStatusesServiceClient(AggregateProductStatusesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AggregateProductStatusesServiceSettings getSettings() {
    return settings;
  }

  public AggregateProductStatusesServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `AggregateProductStatuses` resources for your merchant account. The response might
   * contain fewer items than specified by `pageSize`. If `pageToken` was returned in previous
   * request, it can be used to obtain additional results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AggregateProductStatusesServiceClient aggregateProductStatusesServiceClient =
   *     AggregateProductStatusesServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (AggregateProductStatus element :
   *       aggregateProductStatusesServiceClient.listAggregateProductStatuses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account to list aggregate product statuses for. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAggregateProductStatusesPagedResponse listAggregateProductStatuses(
      AccountName parent) {
    ListAggregateProductStatusesRequest request =
        ListAggregateProductStatusesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAggregateProductStatuses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `AggregateProductStatuses` resources for your merchant account. The response might
   * contain fewer items than specified by `pageSize`. If `pageToken` was returned in previous
   * request, it can be used to obtain additional results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AggregateProductStatusesServiceClient aggregateProductStatusesServiceClient =
   *     AggregateProductStatusesServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (AggregateProductStatus element :
   *       aggregateProductStatusesServiceClient.listAggregateProductStatuses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account to list aggregate product statuses for. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAggregateProductStatusesPagedResponse listAggregateProductStatuses(
      String parent) {
    ListAggregateProductStatusesRequest request =
        ListAggregateProductStatusesRequest.newBuilder().setParent(parent).build();
    return listAggregateProductStatuses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `AggregateProductStatuses` resources for your merchant account. The response might
   * contain fewer items than specified by `pageSize`. If `pageToken` was returned in previous
   * request, it can be used to obtain additional results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AggregateProductStatusesServiceClient aggregateProductStatusesServiceClient =
   *     AggregateProductStatusesServiceClient.create()) {
   *   ListAggregateProductStatusesRequest request =
   *       ListAggregateProductStatusesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (AggregateProductStatus element :
   *       aggregateProductStatusesServiceClient
   *           .listAggregateProductStatuses(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAggregateProductStatusesPagedResponse listAggregateProductStatuses(
      ListAggregateProductStatusesRequest request) {
    return listAggregateProductStatusesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `AggregateProductStatuses` resources for your merchant account. The response might
   * contain fewer items than specified by `pageSize`. If `pageToken` was returned in previous
   * request, it can be used to obtain additional results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AggregateProductStatusesServiceClient aggregateProductStatusesServiceClient =
   *     AggregateProductStatusesServiceClient.create()) {
   *   ListAggregateProductStatusesRequest request =
   *       ListAggregateProductStatusesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<AggregateProductStatus> future =
   *       aggregateProductStatusesServiceClient
   *           .listAggregateProductStatusesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (AggregateProductStatus element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAggregateProductStatusesRequest, ListAggregateProductStatusesPagedResponse>
      listAggregateProductStatusesPagedCallable() {
    return stub.listAggregateProductStatusesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `AggregateProductStatuses` resources for your merchant account. The response might
   * contain fewer items than specified by `pageSize`. If `pageToken` was returned in previous
   * request, it can be used to obtain additional results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AggregateProductStatusesServiceClient aggregateProductStatusesServiceClient =
   *     AggregateProductStatusesServiceClient.create()) {
   *   ListAggregateProductStatusesRequest request =
   *       ListAggregateProductStatusesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListAggregateProductStatusesResponse response =
   *         aggregateProductStatusesServiceClient
   *             .listAggregateProductStatusesCallable()
   *             .call(request);
   *     for (AggregateProductStatus element : response.getAggregateProductStatusesList()) {
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
  public final UnaryCallable<
          ListAggregateProductStatusesRequest, ListAggregateProductStatusesResponse>
      listAggregateProductStatusesCallable() {
    return stub.listAggregateProductStatusesCallable();
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

  public static class ListAggregateProductStatusesPagedResponse
      extends AbstractPagedListResponse<
          ListAggregateProductStatusesRequest,
          ListAggregateProductStatusesResponse,
          AggregateProductStatus,
          ListAggregateProductStatusesPage,
          ListAggregateProductStatusesFixedSizeCollection> {

    public static ApiFuture<ListAggregateProductStatusesPagedResponse> createAsync(
        PageContext<
                ListAggregateProductStatusesRequest,
                ListAggregateProductStatusesResponse,
                AggregateProductStatus>
            context,
        ApiFuture<ListAggregateProductStatusesResponse> futureResponse) {
      ApiFuture<ListAggregateProductStatusesPage> futurePage =
          ListAggregateProductStatusesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAggregateProductStatusesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAggregateProductStatusesPagedResponse(ListAggregateProductStatusesPage page) {
      super(page, ListAggregateProductStatusesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAggregateProductStatusesPage
      extends AbstractPage<
          ListAggregateProductStatusesRequest,
          ListAggregateProductStatusesResponse,
          AggregateProductStatus,
          ListAggregateProductStatusesPage> {

    private ListAggregateProductStatusesPage(
        PageContext<
                ListAggregateProductStatusesRequest,
                ListAggregateProductStatusesResponse,
                AggregateProductStatus>
            context,
        ListAggregateProductStatusesResponse response) {
      super(context, response);
    }

    private static ListAggregateProductStatusesPage createEmptyPage() {
      return new ListAggregateProductStatusesPage(null, null);
    }

    @Override
    protected ListAggregateProductStatusesPage createPage(
        PageContext<
                ListAggregateProductStatusesRequest,
                ListAggregateProductStatusesResponse,
                AggregateProductStatus>
            context,
        ListAggregateProductStatusesResponse response) {
      return new ListAggregateProductStatusesPage(context, response);
    }

    @Override
    public ApiFuture<ListAggregateProductStatusesPage> createPageAsync(
        PageContext<
                ListAggregateProductStatusesRequest,
                ListAggregateProductStatusesResponse,
                AggregateProductStatus>
            context,
        ApiFuture<ListAggregateProductStatusesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAggregateProductStatusesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAggregateProductStatusesRequest,
          ListAggregateProductStatusesResponse,
          AggregateProductStatus,
          ListAggregateProductStatusesPage,
          ListAggregateProductStatusesFixedSizeCollection> {

    private ListAggregateProductStatusesFixedSizeCollection(
        List<ListAggregateProductStatusesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAggregateProductStatusesFixedSizeCollection createEmptyCollection() {
      return new ListAggregateProductStatusesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAggregateProductStatusesFixedSizeCollection createCollection(
        List<ListAggregateProductStatusesPage> pages, int collectionSize) {
      return new ListAggregateProductStatusesFixedSizeCollection(pages, collectionSize);
    }
  }
}

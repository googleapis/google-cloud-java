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

import com.google.ads.admanager.v1.stub.LineItemServiceStub;
import com.google.ads.admanager.v1.stub.LineItemServiceStubSettings;
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
 * Service Description: Provides methods for handling LineItem objects.
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
 * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
 *   LineItemName name = LineItemName.of("[NETWORK_CODE]", "[ORDER]", "[LINE_ITEM]");
 *   LineItem response = lineItemServiceClient.getLineItem(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LineItemServiceClient object to clean up resources
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
 *      <td><p> GetLineItem</td>
 *      <td><p> API to retrieve a LineItem object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLineItem(GetLineItemRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLineItem(LineItemName name)
 *           <li><p> getLineItem(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLineItemCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLineItems</td>
 *      <td><p> API to retrieve a list of LineItem objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLineItems(ListLineItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLineItems(OrderName parent)
 *           <li><p> listLineItems(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLineItemsPagedCallable()
 *           <li><p> listLineItemsCallable()
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
 * <p>This class can be customized by passing in a custom instance of LineItemServiceSettings to
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
 * LineItemServiceSettings lineItemServiceSettings =
 *     LineItemServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LineItemServiceClient lineItemServiceClient =
 *     LineItemServiceClient.create(lineItemServiceSettings);
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
 * LineItemServiceSettings lineItemServiceSettings =
 *     LineItemServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LineItemServiceClient lineItemServiceClient =
 *     LineItemServiceClient.create(lineItemServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LineItemServiceClient implements BackgroundResource {
  private final LineItemServiceSettings settings;
  private final LineItemServiceStub stub;

  /** Constructs an instance of LineItemServiceClient with default settings. */
  public static final LineItemServiceClient create() throws IOException {
    return create(LineItemServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LineItemServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LineItemServiceClient create(LineItemServiceSettings settings)
      throws IOException {
    return new LineItemServiceClient(settings);
  }

  /**
   * Constructs an instance of LineItemServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(LineItemServiceSettings).
   */
  public static final LineItemServiceClient create(LineItemServiceStub stub) {
    return new LineItemServiceClient(stub);
  }

  /**
   * Constructs an instance of LineItemServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LineItemServiceClient(LineItemServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LineItemServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LineItemServiceClient(LineItemServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LineItemServiceSettings getSettings() {
    return settings;
  }

  public LineItemServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a LineItem object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   LineItemName name = LineItemName.of("[NETWORK_CODE]", "[ORDER]", "[LINE_ITEM]");
   *   LineItem response = lineItemServiceClient.getLineItem(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the LineItem. Format:
   *     `networks/{network_code}/orders/{order_id}/lineItems/{line_item_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItem getLineItem(LineItemName name) {
    GetLineItemRequest request =
        GetLineItemRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLineItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a LineItem object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String name = LineItemName.of("[NETWORK_CODE]", "[ORDER]", "[LINE_ITEM]").toString();
   *   LineItem response = lineItemServiceClient.getLineItem(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the LineItem. Format:
   *     `networks/{network_code}/orders/{order_id}/lineItems/{line_item_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItem getLineItem(String name) {
    GetLineItemRequest request = GetLineItemRequest.newBuilder().setName(name).build();
    return getLineItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a LineItem object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   GetLineItemRequest request =
   *       GetLineItemRequest.newBuilder()
   *           .setName(LineItemName.of("[NETWORK_CODE]", "[ORDER]", "[LINE_ITEM]").toString())
   *           .build();
   *   LineItem response = lineItemServiceClient.getLineItem(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItem getLineItem(GetLineItemRequest request) {
    return getLineItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a LineItem object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   GetLineItemRequest request =
   *       GetLineItemRequest.newBuilder()
   *           .setName(LineItemName.of("[NETWORK_CODE]", "[ORDER]", "[LINE_ITEM]").toString())
   *           .build();
   *   ApiFuture<LineItem> future = lineItemServiceClient.getLineItemCallable().futureCall(request);
   *   // Do something.
   *   LineItem response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLineItemRequest, LineItem> getLineItemCallable() {
    return stub.getLineItemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of LineItem objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   OrderName parent = OrderName.of("[NETWORK_CODE]", "[ORDER]");
   *   for (LineItem element : lineItemServiceClient.listLineItems(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LineItems. Format:
   *     networks/{network_code}/orders/{order_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineItemsPagedResponse listLineItems(OrderName parent) {
    ListLineItemsRequest request =
        ListLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of LineItem objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = OrderName.of("[NETWORK_CODE]", "[ORDER]").toString();
   *   for (LineItem element : lineItemServiceClient.listLineItems(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LineItems. Format:
   *     networks/{network_code}/orders/{order_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineItemsPagedResponse listLineItems(String parent) {
    ListLineItemsRequest request = ListLineItemsRequest.newBuilder().setParent(parent).build();
    return listLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of LineItem objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   ListLineItemsRequest request =
   *       ListLineItemsRequest.newBuilder()
   *           .setParent(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (LineItem element : lineItemServiceClient.listLineItems(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineItemsPagedResponse listLineItems(ListLineItemsRequest request) {
    return listLineItemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of LineItem objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   ListLineItemsRequest request =
   *       ListLineItemsRequest.newBuilder()
   *           .setParent(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<LineItem> future =
   *       lineItemServiceClient.listLineItemsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LineItem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLineItemsRequest, ListLineItemsPagedResponse>
      listLineItemsPagedCallable() {
    return stub.listLineItemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of LineItem objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   ListLineItemsRequest request =
   *       ListLineItemsRequest.newBuilder()
   *           .setParent(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListLineItemsResponse response =
   *         lineItemServiceClient.listLineItemsCallable().call(request);
   *     for (LineItem element : response.getLineItemsList()) {
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
  public final UnaryCallable<ListLineItemsRequest, ListLineItemsResponse> listLineItemsCallable() {
    return stub.listLineItemsCallable();
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

  public static class ListLineItemsPagedResponse
      extends AbstractPagedListResponse<
          ListLineItemsRequest,
          ListLineItemsResponse,
          LineItem,
          ListLineItemsPage,
          ListLineItemsFixedSizeCollection> {

    public static ApiFuture<ListLineItemsPagedResponse> createAsync(
        PageContext<ListLineItemsRequest, ListLineItemsResponse, LineItem> context,
        ApiFuture<ListLineItemsResponse> futureResponse) {
      ApiFuture<ListLineItemsPage> futurePage =
          ListLineItemsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLineItemsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLineItemsPagedResponse(ListLineItemsPage page) {
      super(page, ListLineItemsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLineItemsPage
      extends AbstractPage<
          ListLineItemsRequest, ListLineItemsResponse, LineItem, ListLineItemsPage> {

    private ListLineItemsPage(
        PageContext<ListLineItemsRequest, ListLineItemsResponse, LineItem> context,
        ListLineItemsResponse response) {
      super(context, response);
    }

    private static ListLineItemsPage createEmptyPage() {
      return new ListLineItemsPage(null, null);
    }

    @Override
    protected ListLineItemsPage createPage(
        PageContext<ListLineItemsRequest, ListLineItemsResponse, LineItem> context,
        ListLineItemsResponse response) {
      return new ListLineItemsPage(context, response);
    }

    @Override
    public ApiFuture<ListLineItemsPage> createPageAsync(
        PageContext<ListLineItemsRequest, ListLineItemsResponse, LineItem> context,
        ApiFuture<ListLineItemsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLineItemsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLineItemsRequest,
          ListLineItemsResponse,
          LineItem,
          ListLineItemsPage,
          ListLineItemsFixedSizeCollection> {

    private ListLineItemsFixedSizeCollection(List<ListLineItemsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLineItemsFixedSizeCollection createEmptyCollection() {
      return new ListLineItemsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLineItemsFixedSizeCollection createCollection(
        List<ListLineItemsPage> pages, int collectionSize) {
      return new ListLineItemsFixedSizeCollection(pages, collectionSize);
    }
  }
}

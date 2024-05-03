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

import com.google.ads.admanager.v1.stub.OrderServiceStub;
import com.google.ads.admanager.v1.stub.OrderServiceStubSettings;
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
 * Service Description: Provides methods for handling `Order` objects.
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
 * try (OrderServiceClient orderServiceClient = OrderServiceClient.create()) {
 *   OrderName name = OrderName.of("[NETWORK_CODE]", "[ORDER]");
 *   Order response = orderServiceClient.getOrder(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OrderServiceClient object to clean up resources such
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
 *      <td><p> GetOrder</td>
 *      <td><p> API to retrieve an Order object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOrder(GetOrderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOrder(OrderName name)
 *           <li><p> getOrder(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOrderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOrders</td>
 *      <td><p> API to retrieve a list of `Order` objects.
 * <p>  Fields used for literal matching in filter string:
 * <ul>
 * <li>  `order_id`
 * <li>  `display_name`
 * <li>  `external_order_id`
 * </ul></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOrders(ListOrdersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOrders(NetworkName parent)
 *           <li><p> listOrders(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOrdersPagedCallable()
 *           <li><p> listOrdersCallable()
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
 * <p>This class can be customized by passing in a custom instance of OrderServiceSettings to
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
 * OrderServiceSettings orderServiceSettings =
 *     OrderServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OrderServiceClient orderServiceClient = OrderServiceClient.create(orderServiceSettings);
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
 * OrderServiceSettings orderServiceSettings =
 *     OrderServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OrderServiceClient orderServiceClient = OrderServiceClient.create(orderServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class OrderServiceClient implements BackgroundResource {
  private final OrderServiceSettings settings;
  private final OrderServiceStub stub;

  /** Constructs an instance of OrderServiceClient with default settings. */
  public static final OrderServiceClient create() throws IOException {
    return create(OrderServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OrderServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final OrderServiceClient create(OrderServiceSettings settings) throws IOException {
    return new OrderServiceClient(settings);
  }

  /**
   * Constructs an instance of OrderServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(OrderServiceSettings).
   */
  public static final OrderServiceClient create(OrderServiceStub stub) {
    return new OrderServiceClient(stub);
  }

  /**
   * Constructs an instance of OrderServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected OrderServiceClient(OrderServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((OrderServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected OrderServiceClient(OrderServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OrderServiceSettings getSettings() {
    return settings;
  }

  public OrderServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an Order object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrderServiceClient orderServiceClient = OrderServiceClient.create()) {
   *   OrderName name = OrderName.of("[NETWORK_CODE]", "[ORDER]");
   *   Order response = orderServiceClient.getOrder(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Order. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Order getOrder(OrderName name) {
    GetOrderRequest request =
        GetOrderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getOrder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an Order object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrderServiceClient orderServiceClient = OrderServiceClient.create()) {
   *   String name = OrderName.of("[NETWORK_CODE]", "[ORDER]").toString();
   *   Order response = orderServiceClient.getOrder(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Order. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Order getOrder(String name) {
    GetOrderRequest request = GetOrderRequest.newBuilder().setName(name).build();
    return getOrder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an Order object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrderServiceClient orderServiceClient = OrderServiceClient.create()) {
   *   GetOrderRequest request =
   *       GetOrderRequest.newBuilder()
   *           .setName(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
   *           .build();
   *   Order response = orderServiceClient.getOrder(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Order getOrder(GetOrderRequest request) {
    return getOrderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an Order object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrderServiceClient orderServiceClient = OrderServiceClient.create()) {
   *   GetOrderRequest request =
   *       GetOrderRequest.newBuilder()
   *           .setName(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
   *           .build();
   *   ApiFuture<Order> future = orderServiceClient.getOrderCallable().futureCall(request);
   *   // Do something.
   *   Order response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOrderRequest, Order> getOrderCallable() {
    return stub.getOrderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Order` objects.
   *
   * <p>Fields used for literal matching in filter string:
   *
   * <ul>
   *   <li>`order_id`
   *   <li>`display_name`
   *   <li>`external_order_id`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrderServiceClient orderServiceClient = OrderServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Order element : orderServiceClient.listOrders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrdersPagedResponse listOrders(NetworkName parent) {
    ListOrdersRequest request =
        ListOrdersRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Order` objects.
   *
   * <p>Fields used for literal matching in filter string:
   *
   * <ul>
   *   <li>`order_id`
   *   <li>`display_name`
   *   <li>`external_order_id`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrderServiceClient orderServiceClient = OrderServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Order element : orderServiceClient.listOrders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrdersPagedResponse listOrders(String parent) {
    ListOrdersRequest request = ListOrdersRequest.newBuilder().setParent(parent).build();
    return listOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Order` objects.
   *
   * <p>Fields used for literal matching in filter string:
   *
   * <ul>
   *   <li>`order_id`
   *   <li>`display_name`
   *   <li>`external_order_id`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrderServiceClient orderServiceClient = OrderServiceClient.create()) {
   *   ListOrdersRequest request =
   *       ListOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Order element : orderServiceClient.listOrders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrdersPagedResponse listOrders(ListOrdersRequest request) {
    return listOrdersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Order` objects.
   *
   * <p>Fields used for literal matching in filter string:
   *
   * <ul>
   *   <li>`order_id`
   *   <li>`display_name`
   *   <li>`external_order_id`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrderServiceClient orderServiceClient = OrderServiceClient.create()) {
   *   ListOrdersRequest request =
   *       ListOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Order> future = orderServiceClient.listOrdersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Order element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOrdersRequest, ListOrdersPagedResponse> listOrdersPagedCallable() {
    return stub.listOrdersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Order` objects.
   *
   * <p>Fields used for literal matching in filter string:
   *
   * <ul>
   *   <li>`order_id`
   *   <li>`display_name`
   *   <li>`external_order_id`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrderServiceClient orderServiceClient = OrderServiceClient.create()) {
   *   ListOrdersRequest request =
   *       ListOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListOrdersResponse response = orderServiceClient.listOrdersCallable().call(request);
   *     for (Order element : response.getOrdersList()) {
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
  public final UnaryCallable<ListOrdersRequest, ListOrdersResponse> listOrdersCallable() {
    return stub.listOrdersCallable();
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

  public static class ListOrdersPagedResponse
      extends AbstractPagedListResponse<
          ListOrdersRequest,
          ListOrdersResponse,
          Order,
          ListOrdersPage,
          ListOrdersFixedSizeCollection> {

    public static ApiFuture<ListOrdersPagedResponse> createAsync(
        PageContext<ListOrdersRequest, ListOrdersResponse, Order> context,
        ApiFuture<ListOrdersResponse> futureResponse) {
      ApiFuture<ListOrdersPage> futurePage =
          ListOrdersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListOrdersPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListOrdersPagedResponse(ListOrdersPage page) {
      super(page, ListOrdersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOrdersPage
      extends AbstractPage<ListOrdersRequest, ListOrdersResponse, Order, ListOrdersPage> {

    private ListOrdersPage(
        PageContext<ListOrdersRequest, ListOrdersResponse, Order> context,
        ListOrdersResponse response) {
      super(context, response);
    }

    private static ListOrdersPage createEmptyPage() {
      return new ListOrdersPage(null, null);
    }

    @Override
    protected ListOrdersPage createPage(
        PageContext<ListOrdersRequest, ListOrdersResponse, Order> context,
        ListOrdersResponse response) {
      return new ListOrdersPage(context, response);
    }

    @Override
    public ApiFuture<ListOrdersPage> createPageAsync(
        PageContext<ListOrdersRequest, ListOrdersResponse, Order> context,
        ApiFuture<ListOrdersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOrdersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOrdersRequest,
          ListOrdersResponse,
          Order,
          ListOrdersPage,
          ListOrdersFixedSizeCollection> {

    private ListOrdersFixedSizeCollection(List<ListOrdersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOrdersFixedSizeCollection createEmptyCollection() {
      return new ListOrdersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOrdersFixedSizeCollection createCollection(
        List<ListOrdersPage> pages, int collectionSize) {
      return new ListOrdersFixedSizeCollection(pages, collectionSize);
    }
  }
}

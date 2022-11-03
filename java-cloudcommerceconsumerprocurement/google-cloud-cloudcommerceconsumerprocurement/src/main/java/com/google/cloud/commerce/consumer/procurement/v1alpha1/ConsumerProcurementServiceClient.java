/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.commerce.consumer.procurement.v1alpha1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.commerce.consumer.procurement.v1alpha1.stub.ConsumerProcurementServiceStub;
import com.google.cloud.commerce.consumer.procurement.v1alpha1.stub.ConsumerProcurementServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: ConsumerProcurementService allows customers to make purchases of products
 * served by the Cloud Commerce platform.
 *
 * <p>When purchases are made, the
 * [ConsumerProcurementService][google.cloud.commerce.consumer.procurement.v1alpha1.ConsumerProcurementService]
 * programs the appropriate backends, including both Google's own infrastructure, as well as
 * third-party systems, and to enable billing setup for charging for the procured item.
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
 * try (ConsumerProcurementServiceClient consumerProcurementServiceClient =
 *     ConsumerProcurementServiceClient.create()) {
 *   GetOrderRequest request = GetOrderRequest.newBuilder().setName("name3373707").build();
 *   Order response = consumerProcurementServiceClient.getOrder(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConsumerProcurementServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * ConsumerProcurementServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConsumerProcurementServiceSettings consumerProcurementServiceSettings =
 *     ConsumerProcurementServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConsumerProcurementServiceClient consumerProcurementServiceClient =
 *     ConsumerProcurementServiceClient.create(consumerProcurementServiceSettings);
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
 * ConsumerProcurementServiceSettings consumerProcurementServiceSettings =
 *     ConsumerProcurementServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConsumerProcurementServiceClient consumerProcurementServiceClient =
 *     ConsumerProcurementServiceClient.create(consumerProcurementServiceSettings);
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
 * ConsumerProcurementServiceSettings consumerProcurementServiceSettings =
 *     ConsumerProcurementServiceSettings.newHttpJsonBuilder().build();
 * ConsumerProcurementServiceClient consumerProcurementServiceClient =
 *     ConsumerProcurementServiceClient.create(consumerProcurementServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConsumerProcurementServiceClient implements BackgroundResource {
  private final ConsumerProcurementServiceSettings settings;
  private final ConsumerProcurementServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ConsumerProcurementServiceClient with default settings. */
  public static final ConsumerProcurementServiceClient create() throws IOException {
    return create(ConsumerProcurementServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConsumerProcurementServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final ConsumerProcurementServiceClient create(
      ConsumerProcurementServiceSettings settings) throws IOException {
    return new ConsumerProcurementServiceClient(settings);
  }

  /**
   * Constructs an instance of ConsumerProcurementServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(ConsumerProcurementServiceSettings).
   */
  public static final ConsumerProcurementServiceClient create(ConsumerProcurementServiceStub stub) {
    return new ConsumerProcurementServiceClient(stub);
  }

  /**
   * Constructs an instance of ConsumerProcurementServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ConsumerProcurementServiceClient(ConsumerProcurementServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ConsumerProcurementServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ConsumerProcurementServiceClient(ConsumerProcurementServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ConsumerProcurementServiceSettings getSettings() {
    return settings;
  }

  public ConsumerProcurementServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [Order][google.cloud.commerce.consumer.procurement.v1alpha1.Order].
   *
   * <p>The returned long-running operation is in-progress until the backend completes the creation
   * of the resource. Once completed, the order is in
   * [OrderState.ORDER_STATE_ACTIVE][google.cloud.commerce.consumer.procurement.v1alpha1.OrderState.ORDER_STATE_ACTIVE].
   * In case of failure, the order resource will be removed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConsumerProcurementServiceClient consumerProcurementServiceClient =
   *     ConsumerProcurementServiceClient.create()) {
   *   PlaceOrderRequest request =
   *       PlaceOrderRequest.newBuilder()
   *           .setParent(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
   *           .setDisplayName("displayName1714148973")
   *           .addAllLineItemInfo(new ArrayList<LineItemInfo>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Order response = consumerProcurementServiceClient.placeOrderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Order, PlaceOrderMetadata> placeOrderAsync(
      PlaceOrderRequest request) {
    return placeOrderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [Order][google.cloud.commerce.consumer.procurement.v1alpha1.Order].
   *
   * <p>The returned long-running operation is in-progress until the backend completes the creation
   * of the resource. Once completed, the order is in
   * [OrderState.ORDER_STATE_ACTIVE][google.cloud.commerce.consumer.procurement.v1alpha1.OrderState.ORDER_STATE_ACTIVE].
   * In case of failure, the order resource will be removed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConsumerProcurementServiceClient consumerProcurementServiceClient =
   *     ConsumerProcurementServiceClient.create()) {
   *   PlaceOrderRequest request =
   *       PlaceOrderRequest.newBuilder()
   *           .setParent(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
   *           .setDisplayName("displayName1714148973")
   *           .addAllLineItemInfo(new ArrayList<LineItemInfo>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Order, PlaceOrderMetadata> future =
   *       consumerProcurementServiceClient.placeOrderOperationCallable().futureCall(request);
   *   // Do something.
   *   Order response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PlaceOrderRequest, Order, PlaceOrderMetadata>
      placeOrderOperationCallable() {
    return stub.placeOrderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [Order][google.cloud.commerce.consumer.procurement.v1alpha1.Order].
   *
   * <p>The returned long-running operation is in-progress until the backend completes the creation
   * of the resource. Once completed, the order is in
   * [OrderState.ORDER_STATE_ACTIVE][google.cloud.commerce.consumer.procurement.v1alpha1.OrderState.ORDER_STATE_ACTIVE].
   * In case of failure, the order resource will be removed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConsumerProcurementServiceClient consumerProcurementServiceClient =
   *     ConsumerProcurementServiceClient.create()) {
   *   PlaceOrderRequest request =
   *       PlaceOrderRequest.newBuilder()
   *           .setParent(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
   *           .setDisplayName("displayName1714148973")
   *           .addAllLineItemInfo(new ArrayList<LineItemInfo>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       consumerProcurementServiceClient.placeOrderCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PlaceOrderRequest, Operation> placeOrderCallable() {
    return stub.placeOrderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Order][google.cloud.commerce.consumer.procurement.v1alpha1.Order]
   * resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConsumerProcurementServiceClient consumerProcurementServiceClient =
   *     ConsumerProcurementServiceClient.create()) {
   *   GetOrderRequest request = GetOrderRequest.newBuilder().setName("name3373707").build();
   *   Order response = consumerProcurementServiceClient.getOrder(request);
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
   * Returns the requested [Order][google.cloud.commerce.consumer.procurement.v1alpha1.Order]
   * resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConsumerProcurementServiceClient consumerProcurementServiceClient =
   *     ConsumerProcurementServiceClient.create()) {
   *   GetOrderRequest request = GetOrderRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Order> future =
   *       consumerProcurementServiceClient.getOrderCallable().futureCall(request);
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
   * Lists [Order][google.cloud.commerce.consumer.procurement.v1alpha1.Order] resources that the
   * user has access to, within the scope of the parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConsumerProcurementServiceClient consumerProcurementServiceClient =
   *     ConsumerProcurementServiceClient.create()) {
   *   ListOrdersRequest request =
   *       ListOrdersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Order element : consumerProcurementServiceClient.listOrders(request).iterateAll()) {
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
   * Lists [Order][google.cloud.commerce.consumer.procurement.v1alpha1.Order] resources that the
   * user has access to, within the scope of the parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConsumerProcurementServiceClient consumerProcurementServiceClient =
   *     ConsumerProcurementServiceClient.create()) {
   *   ListOrdersRequest request =
   *       ListOrdersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Order> future =
   *       consumerProcurementServiceClient.listOrdersPagedCallable().futureCall(request);
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
   * Lists [Order][google.cloud.commerce.consumer.procurement.v1alpha1.Order] resources that the
   * user has access to, within the scope of the parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConsumerProcurementServiceClient consumerProcurementServiceClient =
   *     ConsumerProcurementServiceClient.create()) {
   *   ListOrdersRequest request =
   *       ListOrdersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListOrdersResponse response =
   *         consumerProcurementServiceClient.listOrdersCallable().call(request);
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

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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

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
 *      <td><p> Retrieves an `Order` object.</td>
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
 *      <td><p> Lists `Order` objects.
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
 *    <tr>
 *      <td><p> BatchCreateOrders</td>
 *      <td><p> Creates `Order` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateOrders(NetworkName parent, List&lt;CreateOrderRequest&gt; requests)
 *           <li><p> batchCreateOrders(String parent, List&lt;CreateOrderRequest&gt; requests)
 *           <li><p> batchCreateOrders(BatchCreateOrdersRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateOrdersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateOrders</td>
 *      <td><p> Batch updates `Order` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateOrders(NetworkName parent, List&lt;UpdateOrderRequest&gt; requests)
 *           <li><p> batchUpdateOrders(String parent, List&lt;UpdateOrderRequest&gt; requests)
 *           <li><p> batchUpdateOrders(BatchUpdateOrdersRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateOrdersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchApproveOrders</td>
 *      <td><p> Approves a list of `Order` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchApproveOrders(BatchApproveOrdersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchApproveOrders(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchApproveOrders(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchApproveOrdersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchApproveAndOverbookOrders</td>
 *      <td><p> Approves and overbooks a list of `Order` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchApproveAndOverbookOrders(BatchApproveAndOverbookOrdersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchApproveAndOverbookOrders(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchApproveAndOverbookOrders(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchApproveAndOverbookOrdersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchSubmitOrdersForApproval</td>
 *      <td><p> Submits a list of `Order` objects for approval.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchSubmitOrdersForApproval(BatchSubmitOrdersForApprovalRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchSubmitOrdersForApproval(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchSubmitOrdersForApproval(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchSubmitOrdersForApprovalCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchSubmitOrdersForApprovalAndOverbook</td>
 *      <td><p> Submits and overbooks a list of `Order` objects for approval.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchSubmitOrdersForApprovalAndOverbook(BatchSubmitOrdersForApprovalAndOverbookRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchSubmitOrdersForApprovalAndOverbook(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchSubmitOrdersForApprovalAndOverbook(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchSubmitOrdersForApprovalAndOverbookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchSubmitOrdersForApprovalWithoutReservationChanges</td>
 *      <td><p> Submits a list of `Order` objects for approval without changing reservation status.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchSubmitOrdersForApprovalWithoutReservationChanges(BatchSubmitOrdersForApprovalWithoutReservationChangesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchSubmitOrdersForApprovalWithoutReservationChanges(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchSubmitOrdersForApprovalWithoutReservationChanges(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchSubmitOrdersForApprovalWithoutReservationChangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchPauseOrders</td>
 *      <td><p> Pauses a list of `Order` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchPauseOrders(BatchPauseOrdersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchPauseOrders(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchPauseOrders(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchPauseOrdersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchResumeOrders</td>
 *      <td><p> Resumes a list of `Order` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchResumeOrders(BatchResumeOrdersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchResumeOrders(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchResumeOrders(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchResumeOrdersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchResumeAndOverbookOrders</td>
 *      <td><p> Resumes and overbooks a list of `Order` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchResumeAndOverbookOrders(BatchResumeAndOverbookOrdersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchResumeAndOverbookOrders(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchResumeAndOverbookOrders(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchResumeAndOverbookOrdersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchApproveOrdersWithoutReservation</td>
 *      <td><p> Approves a list of `Order` objects without changing reservation status.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchApproveOrdersWithoutReservation(BatchApproveOrdersWithoutReservationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchApproveOrdersWithoutReservation(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchApproveOrdersWithoutReservation(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchApproveOrdersWithoutReservationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchArchiveOrders</td>
 *      <td><p> Archives a list of `Order` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchArchiveOrders(BatchArchiveOrdersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchArchiveOrders(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchArchiveOrders(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchArchiveOrdersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUnarchiveOrders</td>
 *      <td><p> Unarchives a list of `Order` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUnarchiveOrders(BatchUnarchiveOrdersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchUnarchiveOrders(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchUnarchiveOrders(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUnarchiveOrdersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeleteOrders</td>
 *      <td><p> Deletes a list of `Order` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeleteOrders(BatchDeleteOrdersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeleteOrders(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeleteOrders(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeleteOrdersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDisapproveOrders</td>
 *      <td><p> Disapproves a list of `Order` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDisapproveOrders(BatchDisapproveOrdersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDisapproveOrders(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDisapproveOrders(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDisapproveOrdersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDisapproveOrdersWithoutReservationChanges</td>
 *      <td><p> Disapproves a list of `Order` objects without changing reservation status.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDisapproveOrdersWithoutReservationChanges(BatchDisapproveOrdersWithoutReservationChangesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDisapproveOrdersWithoutReservationChanges(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDisapproveOrdersWithoutReservationChanges(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDisapproveOrdersWithoutReservationChangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchRetractOrders</td>
 *      <td><p> Retracts a list of `Order` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchRetractOrders(BatchRetractOrdersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchRetractOrders(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchRetractOrders(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchRetractOrdersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchRetractOrdersWithoutReservationChanges</td>
 *      <td><p> Retracts a list of `Order` objects without changing reservation status.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchRetractOrdersWithoutReservationChanges(BatchRetractOrdersWithoutReservationChangesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchRetractOrdersWithoutReservationChanges(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchRetractOrdersWithoutReservationChanges(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchRetractOrdersWithoutReservationChangesCallable()
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
@NullMarked
@Generated("by gapic-generator-java")
public class OrderServiceClient implements BackgroundResource {
  private final @Nullable OrderServiceSettings settings;
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

  public final @Nullable OrderServiceSettings getSettings() {
    return settings;
  }

  public OrderServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an `Order` object.
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
  public final Order getOrder(@Nullable OrderName name) {
    GetOrderRequest request =
        GetOrderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getOrder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an `Order` object.
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
   * Retrieves an `Order` object.
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
   * Retrieves an `Order` object.
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
   * Lists `Order` objects.
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
  public final ListOrdersPagedResponse listOrders(@Nullable NetworkName parent) {
    ListOrdersRequest request =
        ListOrdersRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Order` objects.
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
   * Lists `Order` objects.
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
   * Lists `Order` objects.
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
   * Lists `Order` objects.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `Order` objects.
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
   *   List<CreateOrderRequest> requests = new ArrayList<>();
   *   BatchCreateOrdersResponse response = orderServiceClient.batchCreateOrders(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Orders` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateOrderRequest must match this field.
   * @param requests Required. The `Order` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateOrdersResponse batchCreateOrders(
      @Nullable NetworkName parent, List<CreateOrderRequest> requests) {
    BatchCreateOrdersRequest request =
        BatchCreateOrdersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `Order` objects.
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
   *   List<CreateOrderRequest> requests = new ArrayList<>();
   *   BatchCreateOrdersResponse response = orderServiceClient.batchCreateOrders(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Orders` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateOrderRequest must match this field.
   * @param requests Required. The `Order` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateOrdersResponse batchCreateOrders(
      String parent, List<CreateOrderRequest> requests) {
    BatchCreateOrdersRequest request =
        BatchCreateOrdersRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchCreateOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `Order` objects.
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
   *   BatchCreateOrdersRequest request =
   *       BatchCreateOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateOrderRequest>())
   *           .build();
   *   BatchCreateOrdersResponse response = orderServiceClient.batchCreateOrders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateOrdersResponse batchCreateOrders(BatchCreateOrdersRequest request) {
    return batchCreateOrdersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `Order` objects.
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
   *   BatchCreateOrdersRequest request =
   *       BatchCreateOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateOrderRequest>())
   *           .build();
   *   ApiFuture<BatchCreateOrdersResponse> future =
   *       orderServiceClient.batchCreateOrdersCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateOrdersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateOrdersRequest, BatchCreateOrdersResponse>
      batchCreateOrdersCallable() {
    return stub.batchCreateOrdersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `Order` objects.
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
   *   List<UpdateOrderRequest> requests = new ArrayList<>();
   *   BatchUpdateOrdersResponse response = orderServiceClient.batchUpdateOrders(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Orders` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateOrderRequest must match this field.
   * @param requests Required. The `Order` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateOrdersResponse batchUpdateOrders(
      @Nullable NetworkName parent, List<UpdateOrderRequest> requests) {
    BatchUpdateOrdersRequest request =
        BatchUpdateOrdersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `Order` objects.
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
   *   List<UpdateOrderRequest> requests = new ArrayList<>();
   *   BatchUpdateOrdersResponse response = orderServiceClient.batchUpdateOrders(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Orders` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateOrderRequest must match this field.
   * @param requests Required. The `Order` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateOrdersResponse batchUpdateOrders(
      String parent, List<UpdateOrderRequest> requests) {
    BatchUpdateOrdersRequest request =
        BatchUpdateOrdersRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchUpdateOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `Order` objects.
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
   *   BatchUpdateOrdersRequest request =
   *       BatchUpdateOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateOrderRequest>())
   *           .build();
   *   BatchUpdateOrdersResponse response = orderServiceClient.batchUpdateOrders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateOrdersResponse batchUpdateOrders(BatchUpdateOrdersRequest request) {
    return batchUpdateOrdersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `Order` objects.
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
   *   BatchUpdateOrdersRequest request =
   *       BatchUpdateOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateOrderRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateOrdersResponse> future =
   *       orderServiceClient.batchUpdateOrdersCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateOrdersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateOrdersRequest, BatchUpdateOrdersResponse>
      batchUpdateOrdersCallable() {
    return stub.batchUpdateOrdersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchApproveOrdersResponse response = orderServiceClient.batchApproveOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to approve. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchApproveOrdersResponse batchApproveOrders(
      @Nullable NetworkName parent, List<String> names) {
    BatchApproveOrdersRequest request =
        BatchApproveOrdersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchApproveOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchApproveOrdersResponse response = orderServiceClient.batchApproveOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to approve. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchApproveOrdersResponse batchApproveOrders(String parent, List<String> names) {
    BatchApproveOrdersRequest request =
        BatchApproveOrdersRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchApproveOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a list of `Order` objects.
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
   *   BatchApproveOrdersRequest request =
   *       BatchApproveOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setSkipInventoryCheck(true)
   *           .build();
   *   BatchApproveOrdersResponse response = orderServiceClient.batchApproveOrders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchApproveOrdersResponse batchApproveOrders(BatchApproveOrdersRequest request) {
    return batchApproveOrdersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a list of `Order` objects.
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
   *   BatchApproveOrdersRequest request =
   *       BatchApproveOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setSkipInventoryCheck(true)
   *           .build();
   *   ApiFuture<BatchApproveOrdersResponse> future =
   *       orderServiceClient.batchApproveOrdersCallable().futureCall(request);
   *   // Do something.
   *   BatchApproveOrdersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchApproveOrdersRequest, BatchApproveOrdersResponse>
      batchApproveOrdersCallable() {
    return stub.batchApproveOrdersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves and overbooks a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchApproveAndOverbookOrdersResponse response =
   *       orderServiceClient.batchApproveAndOverbookOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to approve and overbook. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchApproveAndOverbookOrdersResponse batchApproveAndOverbookOrders(
      @Nullable NetworkName parent, List<String> names) {
    BatchApproveAndOverbookOrdersRequest request =
        BatchApproveAndOverbookOrdersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchApproveAndOverbookOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves and overbooks a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchApproveAndOverbookOrdersResponse response =
   *       orderServiceClient.batchApproveAndOverbookOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to approve and overbook. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchApproveAndOverbookOrdersResponse batchApproveAndOverbookOrders(
      String parent, List<String> names) {
    BatchApproveAndOverbookOrdersRequest request =
        BatchApproveAndOverbookOrdersRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchApproveAndOverbookOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves and overbooks a list of `Order` objects.
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
   *   BatchApproveAndOverbookOrdersRequest request =
   *       BatchApproveAndOverbookOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setSkipInventoryCheck(true)
   *           .build();
   *   BatchApproveAndOverbookOrdersResponse response =
   *       orderServiceClient.batchApproveAndOverbookOrders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchApproveAndOverbookOrdersResponse batchApproveAndOverbookOrders(
      BatchApproveAndOverbookOrdersRequest request) {
    return batchApproveAndOverbookOrdersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves and overbooks a list of `Order` objects.
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
   *   BatchApproveAndOverbookOrdersRequest request =
   *       BatchApproveAndOverbookOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setSkipInventoryCheck(true)
   *           .build();
   *   ApiFuture<BatchApproveAndOverbookOrdersResponse> future =
   *       orderServiceClient.batchApproveAndOverbookOrdersCallable().futureCall(request);
   *   // Do something.
   *   BatchApproveAndOverbookOrdersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchApproveAndOverbookOrdersRequest, BatchApproveAndOverbookOrdersResponse>
      batchApproveAndOverbookOrdersCallable() {
    return stub.batchApproveAndOverbookOrdersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a list of `Order` objects for approval.
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
   *   List<String> names = new ArrayList<>();
   *   BatchSubmitOrdersForApprovalResponse response =
   *       orderServiceClient.batchSubmitOrdersForApproval(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to submit for approval. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSubmitOrdersForApprovalResponse batchSubmitOrdersForApproval(
      @Nullable NetworkName parent, List<String> names) {
    BatchSubmitOrdersForApprovalRequest request =
        BatchSubmitOrdersForApprovalRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchSubmitOrdersForApproval(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a list of `Order` objects for approval.
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
   *   List<String> names = new ArrayList<>();
   *   BatchSubmitOrdersForApprovalResponse response =
   *       orderServiceClient.batchSubmitOrdersForApproval(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to submit for approval. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSubmitOrdersForApprovalResponse batchSubmitOrdersForApproval(
      String parent, List<String> names) {
    BatchSubmitOrdersForApprovalRequest request =
        BatchSubmitOrdersForApprovalRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchSubmitOrdersForApproval(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a list of `Order` objects for approval.
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
   *   BatchSubmitOrdersForApprovalRequest request =
   *       BatchSubmitOrdersForApprovalRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setSkipInventoryCheck(true)
   *           .build();
   *   BatchSubmitOrdersForApprovalResponse response =
   *       orderServiceClient.batchSubmitOrdersForApproval(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSubmitOrdersForApprovalResponse batchSubmitOrdersForApproval(
      BatchSubmitOrdersForApprovalRequest request) {
    return batchSubmitOrdersForApprovalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a list of `Order` objects for approval.
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
   *   BatchSubmitOrdersForApprovalRequest request =
   *       BatchSubmitOrdersForApprovalRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setSkipInventoryCheck(true)
   *           .build();
   *   ApiFuture<BatchSubmitOrdersForApprovalResponse> future =
   *       orderServiceClient.batchSubmitOrdersForApprovalCallable().futureCall(request);
   *   // Do something.
   *   BatchSubmitOrdersForApprovalResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchSubmitOrdersForApprovalRequest, BatchSubmitOrdersForApprovalResponse>
      batchSubmitOrdersForApprovalCallable() {
    return stub.batchSubmitOrdersForApprovalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits and overbooks a list of `Order` objects for approval.
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
   *   List<String> names = new ArrayList<>();
   *   BatchSubmitOrdersForApprovalAndOverbookResponse response =
   *       orderServiceClient.batchSubmitOrdersForApprovalAndOverbook(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the orders to submit for approval and overbook.
   *     Format: `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSubmitOrdersForApprovalAndOverbookResponse
      batchSubmitOrdersForApprovalAndOverbook(@Nullable NetworkName parent, List<String> names) {
    BatchSubmitOrdersForApprovalAndOverbookRequest request =
        BatchSubmitOrdersForApprovalAndOverbookRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchSubmitOrdersForApprovalAndOverbook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits and overbooks a list of `Order` objects for approval.
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
   *   List<String> names = new ArrayList<>();
   *   BatchSubmitOrdersForApprovalAndOverbookResponse response =
   *       orderServiceClient.batchSubmitOrdersForApprovalAndOverbook(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the orders to submit for approval and overbook.
   *     Format: `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSubmitOrdersForApprovalAndOverbookResponse
      batchSubmitOrdersForApprovalAndOverbook(String parent, List<String> names) {
    BatchSubmitOrdersForApprovalAndOverbookRequest request =
        BatchSubmitOrdersForApprovalAndOverbookRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchSubmitOrdersForApprovalAndOverbook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits and overbooks a list of `Order` objects for approval.
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
   *   BatchSubmitOrdersForApprovalAndOverbookRequest request =
   *       BatchSubmitOrdersForApprovalAndOverbookRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchSubmitOrdersForApprovalAndOverbookResponse response =
   *       orderServiceClient.batchSubmitOrdersForApprovalAndOverbook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSubmitOrdersForApprovalAndOverbookResponse
      batchSubmitOrdersForApprovalAndOverbook(
          BatchSubmitOrdersForApprovalAndOverbookRequest request) {
    return batchSubmitOrdersForApprovalAndOverbookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits and overbooks a list of `Order` objects for approval.
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
   *   BatchSubmitOrdersForApprovalAndOverbookRequest request =
   *       BatchSubmitOrdersForApprovalAndOverbookRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchSubmitOrdersForApprovalAndOverbookResponse> future =
   *       orderServiceClient.batchSubmitOrdersForApprovalAndOverbookCallable().futureCall(request);
   *   // Do something.
   *   BatchSubmitOrdersForApprovalAndOverbookResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchSubmitOrdersForApprovalAndOverbookRequest,
          BatchSubmitOrdersForApprovalAndOverbookResponse>
      batchSubmitOrdersForApprovalAndOverbookCallable() {
    return stub.batchSubmitOrdersForApprovalAndOverbookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a list of `Order` objects for approval without changing reservation status.
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
   *   List<String> names = new ArrayList<>();
   *   BatchSubmitOrdersForApprovalWithoutReservationChangesResponse response =
   *       orderServiceClient.batchSubmitOrdersForApprovalWithoutReservationChanges(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to submit for approval. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSubmitOrdersForApprovalWithoutReservationChangesResponse
      batchSubmitOrdersForApprovalWithoutReservationChanges(
          @Nullable NetworkName parent, List<String> names) {
    BatchSubmitOrdersForApprovalWithoutReservationChangesRequest request =
        BatchSubmitOrdersForApprovalWithoutReservationChangesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchSubmitOrdersForApprovalWithoutReservationChanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a list of `Order` objects for approval without changing reservation status.
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
   *   List<String> names = new ArrayList<>();
   *   BatchSubmitOrdersForApprovalWithoutReservationChangesResponse response =
   *       orderServiceClient.batchSubmitOrdersForApprovalWithoutReservationChanges(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to submit for approval. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSubmitOrdersForApprovalWithoutReservationChangesResponse
      batchSubmitOrdersForApprovalWithoutReservationChanges(String parent, List<String> names) {
    BatchSubmitOrdersForApprovalWithoutReservationChangesRequest request =
        BatchSubmitOrdersForApprovalWithoutReservationChangesRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchSubmitOrdersForApprovalWithoutReservationChanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a list of `Order` objects for approval without changing reservation status.
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
   *   BatchSubmitOrdersForApprovalWithoutReservationChangesRequest request =
   *       BatchSubmitOrdersForApprovalWithoutReservationChangesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchSubmitOrdersForApprovalWithoutReservationChangesResponse response =
   *       orderServiceClient.batchSubmitOrdersForApprovalWithoutReservationChanges(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSubmitOrdersForApprovalWithoutReservationChangesResponse
      batchSubmitOrdersForApprovalWithoutReservationChanges(
          BatchSubmitOrdersForApprovalWithoutReservationChangesRequest request) {
    return batchSubmitOrdersForApprovalWithoutReservationChangesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits a list of `Order` objects for approval without changing reservation status.
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
   *   BatchSubmitOrdersForApprovalWithoutReservationChangesRequest request =
   *       BatchSubmitOrdersForApprovalWithoutReservationChangesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchSubmitOrdersForApprovalWithoutReservationChangesResponse> future =
   *       orderServiceClient
   *           .batchSubmitOrdersForApprovalWithoutReservationChangesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchSubmitOrdersForApprovalWithoutReservationChangesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchSubmitOrdersForApprovalWithoutReservationChangesRequest,
          BatchSubmitOrdersForApprovalWithoutReservationChangesResponse>
      batchSubmitOrdersForApprovalWithoutReservationChangesCallable() {
    return stub.batchSubmitOrdersForApprovalWithoutReservationChangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchPauseOrdersResponse response = orderServiceClient.batchPauseOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to pause. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseOrdersResponse batchPauseOrders(
      @Nullable NetworkName parent, List<String> names) {
    BatchPauseOrdersRequest request =
        BatchPauseOrdersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchPauseOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchPauseOrdersResponse response = orderServiceClient.batchPauseOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to pause. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseOrdersResponse batchPauseOrders(String parent, List<String> names) {
    BatchPauseOrdersRequest request =
        BatchPauseOrdersRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchPauseOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a list of `Order` objects.
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
   *   BatchPauseOrdersRequest request =
   *       BatchPauseOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchPauseOrdersResponse response = orderServiceClient.batchPauseOrders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseOrdersResponse batchPauseOrders(BatchPauseOrdersRequest request) {
    return batchPauseOrdersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a list of `Order` objects.
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
   *   BatchPauseOrdersRequest request =
   *       BatchPauseOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchPauseOrdersResponse> future =
   *       orderServiceClient.batchPauseOrdersCallable().futureCall(request);
   *   // Do something.
   *   BatchPauseOrdersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchPauseOrdersRequest, BatchPauseOrdersResponse>
      batchPauseOrdersCallable() {
    return stub.batchPauseOrdersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchResumeOrdersResponse response = orderServiceClient.batchResumeOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to resume. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeOrdersResponse batchResumeOrders(
      @Nullable NetworkName parent, List<String> names) {
    BatchResumeOrdersRequest request =
        BatchResumeOrdersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchResumeOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchResumeOrdersResponse response = orderServiceClient.batchResumeOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to resume. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeOrdersResponse batchResumeOrders(String parent, List<String> names) {
    BatchResumeOrdersRequest request =
        BatchResumeOrdersRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchResumeOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a list of `Order` objects.
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
   *   BatchResumeOrdersRequest request =
   *       BatchResumeOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setSkipInventoryCheck(true)
   *           .build();
   *   BatchResumeOrdersResponse response = orderServiceClient.batchResumeOrders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeOrdersResponse batchResumeOrders(BatchResumeOrdersRequest request) {
    return batchResumeOrdersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a list of `Order` objects.
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
   *   BatchResumeOrdersRequest request =
   *       BatchResumeOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setSkipInventoryCheck(true)
   *           .build();
   *   ApiFuture<BatchResumeOrdersResponse> future =
   *       orderServiceClient.batchResumeOrdersCallable().futureCall(request);
   *   // Do something.
   *   BatchResumeOrdersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchResumeOrdersRequest, BatchResumeOrdersResponse>
      batchResumeOrdersCallable() {
    return stub.batchResumeOrdersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes and overbooks a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchResumeAndOverbookOrdersResponse response =
   *       orderServiceClient.batchResumeAndOverbookOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to resume and overbook. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeAndOverbookOrdersResponse batchResumeAndOverbookOrders(
      @Nullable NetworkName parent, List<String> names) {
    BatchResumeAndOverbookOrdersRequest request =
        BatchResumeAndOverbookOrdersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchResumeAndOverbookOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes and overbooks a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchResumeAndOverbookOrdersResponse response =
   *       orderServiceClient.batchResumeAndOverbookOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to resume and overbook. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeAndOverbookOrdersResponse batchResumeAndOverbookOrders(
      String parent, List<String> names) {
    BatchResumeAndOverbookOrdersRequest request =
        BatchResumeAndOverbookOrdersRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchResumeAndOverbookOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes and overbooks a list of `Order` objects.
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
   *   BatchResumeAndOverbookOrdersRequest request =
   *       BatchResumeAndOverbookOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchResumeAndOverbookOrdersResponse response =
   *       orderServiceClient.batchResumeAndOverbookOrders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeAndOverbookOrdersResponse batchResumeAndOverbookOrders(
      BatchResumeAndOverbookOrdersRequest request) {
    return batchResumeAndOverbookOrdersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes and overbooks a list of `Order` objects.
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
   *   BatchResumeAndOverbookOrdersRequest request =
   *       BatchResumeAndOverbookOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchResumeAndOverbookOrdersResponse> future =
   *       orderServiceClient.batchResumeAndOverbookOrdersCallable().futureCall(request);
   *   // Do something.
   *   BatchResumeAndOverbookOrdersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchResumeAndOverbookOrdersRequest, BatchResumeAndOverbookOrdersResponse>
      batchResumeAndOverbookOrdersCallable() {
    return stub.batchResumeAndOverbookOrdersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a list of `Order` objects without changing reservation status.
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
   *   List<String> names = new ArrayList<>();
   *   BatchApproveOrdersWithoutReservationResponse response =
   *       orderServiceClient.batchApproveOrdersWithoutReservation(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to approve. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchApproveOrdersWithoutReservationResponse batchApproveOrdersWithoutReservation(
      @Nullable NetworkName parent, List<String> names) {
    BatchApproveOrdersWithoutReservationRequest request =
        BatchApproveOrdersWithoutReservationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchApproveOrdersWithoutReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a list of `Order` objects without changing reservation status.
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
   *   List<String> names = new ArrayList<>();
   *   BatchApproveOrdersWithoutReservationResponse response =
   *       orderServiceClient.batchApproveOrdersWithoutReservation(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to approve. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchApproveOrdersWithoutReservationResponse batchApproveOrdersWithoutReservation(
      String parent, List<String> names) {
    BatchApproveOrdersWithoutReservationRequest request =
        BatchApproveOrdersWithoutReservationRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchApproveOrdersWithoutReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a list of `Order` objects without changing reservation status.
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
   *   BatchApproveOrdersWithoutReservationRequest request =
   *       BatchApproveOrdersWithoutReservationRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchApproveOrdersWithoutReservationResponse response =
   *       orderServiceClient.batchApproveOrdersWithoutReservation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchApproveOrdersWithoutReservationResponse batchApproveOrdersWithoutReservation(
      BatchApproveOrdersWithoutReservationRequest request) {
    return batchApproveOrdersWithoutReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approves a list of `Order` objects without changing reservation status.
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
   *   BatchApproveOrdersWithoutReservationRequest request =
   *       BatchApproveOrdersWithoutReservationRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchApproveOrdersWithoutReservationResponse> future =
   *       orderServiceClient.batchApproveOrdersWithoutReservationCallable().futureCall(request);
   *   // Do something.
   *   BatchApproveOrdersWithoutReservationResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchApproveOrdersWithoutReservationRequest, BatchApproveOrdersWithoutReservationResponse>
      batchApproveOrdersWithoutReservationCallable() {
    return stub.batchApproveOrdersWithoutReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveOrdersResponse response = orderServiceClient.batchArchiveOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to archive. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveOrdersResponse batchArchiveOrders(
      @Nullable NetworkName parent, List<String> names) {
    BatchArchiveOrdersRequest request =
        BatchArchiveOrdersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchArchiveOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveOrdersResponse response = orderServiceClient.batchArchiveOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to archive. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveOrdersResponse batchArchiveOrders(String parent, List<String> names) {
    BatchArchiveOrdersRequest request =
        BatchArchiveOrdersRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchArchiveOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `Order` objects.
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
   *   BatchArchiveOrdersRequest request =
   *       BatchArchiveOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchArchiveOrdersResponse response = orderServiceClient.batchArchiveOrders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveOrdersResponse batchArchiveOrders(BatchArchiveOrdersRequest request) {
    return batchArchiveOrdersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `Order` objects.
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
   *   BatchArchiveOrdersRequest request =
   *       BatchArchiveOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchArchiveOrdersResponse> future =
   *       orderServiceClient.batchArchiveOrdersCallable().futureCall(request);
   *   // Do something.
   *   BatchArchiveOrdersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchArchiveOrdersRequest, BatchArchiveOrdersResponse>
      batchArchiveOrdersCallable() {
    return stub.batchArchiveOrdersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unarchives a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchUnarchiveOrdersResponse response =
   *       orderServiceClient.batchUnarchiveOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to extract. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUnarchiveOrdersResponse batchUnarchiveOrders(
      @Nullable NetworkName parent, List<String> names) {
    BatchUnarchiveOrdersRequest request =
        BatchUnarchiveOrdersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchUnarchiveOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unarchives a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchUnarchiveOrdersResponse response =
   *       orderServiceClient.batchUnarchiveOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to extract. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUnarchiveOrdersResponse batchUnarchiveOrders(
      String parent, List<String> names) {
    BatchUnarchiveOrdersRequest request =
        BatchUnarchiveOrdersRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchUnarchiveOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unarchives a list of `Order` objects.
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
   *   BatchUnarchiveOrdersRequest request =
   *       BatchUnarchiveOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchUnarchiveOrdersResponse response = orderServiceClient.batchUnarchiveOrders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUnarchiveOrdersResponse batchUnarchiveOrders(
      BatchUnarchiveOrdersRequest request) {
    return batchUnarchiveOrdersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unarchives a list of `Order` objects.
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
   *   BatchUnarchiveOrdersRequest request =
   *       BatchUnarchiveOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchUnarchiveOrdersResponse> future =
   *       orderServiceClient.batchUnarchiveOrdersCallable().futureCall(request);
   *   // Do something.
   *   BatchUnarchiveOrdersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUnarchiveOrdersRequest, BatchUnarchiveOrdersResponse>
      batchUnarchiveOrdersCallable() {
    return stub.batchUnarchiveOrdersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchDeleteOrdersResponse response = orderServiceClient.batchDeleteOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to delete. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeleteOrdersResponse batchDeleteOrders(
      @Nullable NetworkName parent, List<String> names) {
    BatchDeleteOrdersRequest request =
        BatchDeleteOrdersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeleteOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchDeleteOrdersResponse response = orderServiceClient.batchDeleteOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to delete. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeleteOrdersResponse batchDeleteOrders(String parent, List<String> names) {
    BatchDeleteOrdersRequest request =
        BatchDeleteOrdersRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchDeleteOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of `Order` objects.
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
   *   BatchDeleteOrdersRequest request =
   *       BatchDeleteOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeleteOrdersResponse response = orderServiceClient.batchDeleteOrders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeleteOrdersResponse batchDeleteOrders(BatchDeleteOrdersRequest request) {
    return batchDeleteOrdersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of `Order` objects.
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
   *   BatchDeleteOrdersRequest request =
   *       BatchDeleteOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDeleteOrdersResponse> future =
   *       orderServiceClient.batchDeleteOrdersCallable().futureCall(request);
   *   // Do something.
   *   BatchDeleteOrdersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteOrdersRequest, BatchDeleteOrdersResponse>
      batchDeleteOrdersCallable() {
    return stub.batchDeleteOrdersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disapproves a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchDisapproveOrdersResponse response =
   *       orderServiceClient.batchDisapproveOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to disapprove. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDisapproveOrdersResponse batchDisapproveOrders(
      @Nullable NetworkName parent, List<String> names) {
    BatchDisapproveOrdersRequest request =
        BatchDisapproveOrdersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDisapproveOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disapproves a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchDisapproveOrdersResponse response =
   *       orderServiceClient.batchDisapproveOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to disapprove. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDisapproveOrdersResponse batchDisapproveOrders(
      String parent, List<String> names) {
    BatchDisapproveOrdersRequest request =
        BatchDisapproveOrdersRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchDisapproveOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disapproves a list of `Order` objects.
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
   *   BatchDisapproveOrdersRequest request =
   *       BatchDisapproveOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDisapproveOrdersResponse response = orderServiceClient.batchDisapproveOrders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDisapproveOrdersResponse batchDisapproveOrders(
      BatchDisapproveOrdersRequest request) {
    return batchDisapproveOrdersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disapproves a list of `Order` objects.
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
   *   BatchDisapproveOrdersRequest request =
   *       BatchDisapproveOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDisapproveOrdersResponse> future =
   *       orderServiceClient.batchDisapproveOrdersCallable().futureCall(request);
   *   // Do something.
   *   BatchDisapproveOrdersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDisapproveOrdersRequest, BatchDisapproveOrdersResponse>
      batchDisapproveOrdersCallable() {
    return stub.batchDisapproveOrdersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disapproves a list of `Order` objects without changing reservation status.
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
   *   List<String> names = new ArrayList<>();
   *   BatchDisapproveOrdersWithoutReservationChangesResponse response =
   *       orderServiceClient.batchDisapproveOrdersWithoutReservationChanges(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to disapprove without reservation
   *     changes. Format: `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDisapproveOrdersWithoutReservationChangesResponse
      batchDisapproveOrdersWithoutReservationChanges(
          @Nullable NetworkName parent, List<String> names) {
    BatchDisapproveOrdersWithoutReservationChangesRequest request =
        BatchDisapproveOrdersWithoutReservationChangesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDisapproveOrdersWithoutReservationChanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disapproves a list of `Order` objects without changing reservation status.
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
   *   List<String> names = new ArrayList<>();
   *   BatchDisapproveOrdersWithoutReservationChangesResponse response =
   *       orderServiceClient.batchDisapproveOrdersWithoutReservationChanges(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to disapprove without reservation
   *     changes. Format: `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDisapproveOrdersWithoutReservationChangesResponse
      batchDisapproveOrdersWithoutReservationChanges(String parent, List<String> names) {
    BatchDisapproveOrdersWithoutReservationChangesRequest request =
        BatchDisapproveOrdersWithoutReservationChangesRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchDisapproveOrdersWithoutReservationChanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disapproves a list of `Order` objects without changing reservation status.
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
   *   BatchDisapproveOrdersWithoutReservationChangesRequest request =
   *       BatchDisapproveOrdersWithoutReservationChangesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDisapproveOrdersWithoutReservationChangesResponse response =
   *       orderServiceClient.batchDisapproveOrdersWithoutReservationChanges(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDisapproveOrdersWithoutReservationChangesResponse
      batchDisapproveOrdersWithoutReservationChanges(
          BatchDisapproveOrdersWithoutReservationChangesRequest request) {
    return batchDisapproveOrdersWithoutReservationChangesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disapproves a list of `Order` objects without changing reservation status.
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
   *   BatchDisapproveOrdersWithoutReservationChangesRequest request =
   *       BatchDisapproveOrdersWithoutReservationChangesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDisapproveOrdersWithoutReservationChangesResponse> future =
   *       orderServiceClient
   *           .batchDisapproveOrdersWithoutReservationChangesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchDisapproveOrdersWithoutReservationChangesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchDisapproveOrdersWithoutReservationChangesRequest,
          BatchDisapproveOrdersWithoutReservationChangesResponse>
      batchDisapproveOrdersWithoutReservationChangesCallable() {
    return stub.batchDisapproveOrdersWithoutReservationChangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retracts a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchRetractOrdersResponse response = orderServiceClient.batchRetractOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to retract. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRetractOrdersResponse batchRetractOrders(
      @Nullable NetworkName parent, List<String> names) {
    BatchRetractOrdersRequest request =
        BatchRetractOrdersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchRetractOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retracts a list of `Order` objects.
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
   *   List<String> names = new ArrayList<>();
   *   BatchRetractOrdersResponse response = orderServiceClient.batchRetractOrders(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to retract. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRetractOrdersResponse batchRetractOrders(String parent, List<String> names) {
    BatchRetractOrdersRequest request =
        BatchRetractOrdersRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchRetractOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retracts a list of `Order` objects.
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
   *   BatchRetractOrdersRequest request =
   *       BatchRetractOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchRetractOrdersResponse response = orderServiceClient.batchRetractOrders(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRetractOrdersResponse batchRetractOrders(BatchRetractOrdersRequest request) {
    return batchRetractOrdersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retracts a list of `Order` objects.
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
   *   BatchRetractOrdersRequest request =
   *       BatchRetractOrdersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchRetractOrdersResponse> future =
   *       orderServiceClient.batchRetractOrdersCallable().futureCall(request);
   *   // Do something.
   *   BatchRetractOrdersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchRetractOrdersRequest, BatchRetractOrdersResponse>
      batchRetractOrdersCallable() {
    return stub.batchRetractOrdersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retracts a list of `Order` objects without changing reservation status.
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
   *   List<String> names = new ArrayList<>();
   *   BatchRetractOrdersWithoutReservationChangesResponse response =
   *       orderServiceClient.batchRetractOrdersWithoutReservationChanges(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to retract. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRetractOrdersWithoutReservationChangesResponse
      batchRetractOrdersWithoutReservationChanges(
          @Nullable NetworkName parent, List<String> names) {
    BatchRetractOrdersWithoutReservationChangesRequest request =
        BatchRetractOrdersWithoutReservationChangesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchRetractOrdersWithoutReservationChanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retracts a list of `Order` objects without changing reservation status.
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
   *   List<String> names = new ArrayList<>();
   *   BatchRetractOrdersWithoutReservationChangesResponse response =
   *       orderServiceClient.batchRetractOrdersWithoutReservationChanges(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Orders. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the orders to retract. Format:
   *     `networks/{network_code}/orders/{order_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRetractOrdersWithoutReservationChangesResponse
      batchRetractOrdersWithoutReservationChanges(String parent, List<String> names) {
    BatchRetractOrdersWithoutReservationChangesRequest request =
        BatchRetractOrdersWithoutReservationChangesRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchRetractOrdersWithoutReservationChanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retracts a list of `Order` objects without changing reservation status.
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
   *   BatchRetractOrdersWithoutReservationChangesRequest request =
   *       BatchRetractOrdersWithoutReservationChangesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchRetractOrdersWithoutReservationChangesResponse response =
   *       orderServiceClient.batchRetractOrdersWithoutReservationChanges(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRetractOrdersWithoutReservationChangesResponse
      batchRetractOrdersWithoutReservationChanges(
          BatchRetractOrdersWithoutReservationChangesRequest request) {
    return batchRetractOrdersWithoutReservationChangesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retracts a list of `Order` objects without changing reservation status.
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
   *   BatchRetractOrdersWithoutReservationChangesRequest request =
   *       BatchRetractOrdersWithoutReservationChangesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchRetractOrdersWithoutReservationChangesResponse> future =
   *       orderServiceClient
   *           .batchRetractOrdersWithoutReservationChangesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchRetractOrdersWithoutReservationChangesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchRetractOrdersWithoutReservationChangesRequest,
          BatchRetractOrdersWithoutReservationChangesResponse>
      batchRetractOrdersWithoutReservationChangesCallable() {
    return stub.batchRetractOrdersWithoutReservationChangesCallable();
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
        @Nullable PageContext<ListOrdersRequest, ListOrdersResponse, Order> context,
        @Nullable ListOrdersResponse response) {
      super(context, response);
    }

    private static ListOrdersPage createEmptyPage() {
      return new ListOrdersPage(null, null);
    }

    @Override
    protected ListOrdersPage createPage(
        @Nullable PageContext<ListOrdersRequest, ListOrdersResponse, Order> context,
        @Nullable ListOrdersResponse response) {
      return new ListOrdersPage(context, response);
    }

    @Override
    public ApiFuture<ListOrdersPage> createPageAsync(
        @Nullable PageContext<ListOrdersRequest, ListOrdersResponse, Order> context,
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

    private ListOrdersFixedSizeCollection(
        @Nullable List<ListOrdersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOrdersFixedSizeCollection createEmptyCollection() {
      return new ListOrdersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOrdersFixedSizeCollection createCollection(
        @Nullable List<ListOrdersPage> pages, int collectionSize) {
      return new ListOrdersFixedSizeCollection(pages, collectionSize);
    }
  }
}

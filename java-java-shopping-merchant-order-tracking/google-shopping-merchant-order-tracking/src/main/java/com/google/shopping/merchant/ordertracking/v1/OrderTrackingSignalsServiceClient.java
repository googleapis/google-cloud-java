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

package com.google.shopping.merchant.ordertracking.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.ordertracking.v1.stub.OrderTrackingSignalsServiceStub;
import com.google.shopping.merchant.ordertracking.v1.stub.OrderTrackingSignalsServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to serve order tracking signals public API.
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
 * try (OrderTrackingSignalsServiceClient orderTrackingSignalsServiceClient =
 *     OrderTrackingSignalsServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT]");
 *   String orderTrackingSignalId = "orderTrackingSignalId1140832552";
 *   OrderTrackingSignal response =
 *       orderTrackingSignalsServiceClient.createOrderTrackingSignal(
 *           parent, orderTrackingSignalId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OrderTrackingSignalsServiceClient object to clean up
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
 *      <td><p> CreateOrderTrackingSignal</td>
 *      <td><p> Creates new order tracking signal.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createOrderTrackingSignal(CreateOrderTrackingSignalRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createOrderTrackingSignal(AccountName parent, String orderTrackingSignalId)
 *           <li><p> createOrderTrackingSignal(String parent, String orderTrackingSignalId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createOrderTrackingSignalCallable()
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
 * OrderTrackingSignalsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrderTrackingSignalsServiceSettings orderTrackingSignalsServiceSettings =
 *     OrderTrackingSignalsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OrderTrackingSignalsServiceClient orderTrackingSignalsServiceClient =
 *     OrderTrackingSignalsServiceClient.create(orderTrackingSignalsServiceSettings);
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
 * OrderTrackingSignalsServiceSettings orderTrackingSignalsServiceSettings =
 *     OrderTrackingSignalsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OrderTrackingSignalsServiceClient orderTrackingSignalsServiceClient =
 *     OrderTrackingSignalsServiceClient.create(orderTrackingSignalsServiceSettings);
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
 * OrderTrackingSignalsServiceSettings orderTrackingSignalsServiceSettings =
 *     OrderTrackingSignalsServiceSettings.newHttpJsonBuilder().build();
 * OrderTrackingSignalsServiceClient orderTrackingSignalsServiceClient =
 *     OrderTrackingSignalsServiceClient.create(orderTrackingSignalsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class OrderTrackingSignalsServiceClient implements BackgroundResource {
  private final OrderTrackingSignalsServiceSettings settings;
  private final OrderTrackingSignalsServiceStub stub;

  /** Constructs an instance of OrderTrackingSignalsServiceClient with default settings. */
  public static final OrderTrackingSignalsServiceClient create() throws IOException {
    return create(OrderTrackingSignalsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OrderTrackingSignalsServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final OrderTrackingSignalsServiceClient create(
      OrderTrackingSignalsServiceSettings settings) throws IOException {
    return new OrderTrackingSignalsServiceClient(settings);
  }

  /**
   * Constructs an instance of OrderTrackingSignalsServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(OrderTrackingSignalsServiceSettings).
   */
  public static final OrderTrackingSignalsServiceClient create(
      OrderTrackingSignalsServiceStub stub) {
    return new OrderTrackingSignalsServiceClient(stub);
  }

  /**
   * Constructs an instance of OrderTrackingSignalsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected OrderTrackingSignalsServiceClient(OrderTrackingSignalsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((OrderTrackingSignalsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected OrderTrackingSignalsServiceClient(OrderTrackingSignalsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OrderTrackingSignalsServiceSettings getSettings() {
    return settings;
  }

  public OrderTrackingSignalsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new order tracking signal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrderTrackingSignalsServiceClient orderTrackingSignalsServiceClient =
   *     OrderTrackingSignalsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   String orderTrackingSignalId = "orderTrackingSignalId1140832552";
   *   OrderTrackingSignal response =
   *       orderTrackingSignalsServiceClient.createOrderTrackingSignal(
   *           parent, orderTrackingSignalId);
   * }
   * }</pre>
   *
   * @param parent Required. The account of the business for which the order signal is created.
   *     Format: accounts/{account}
   * @param orderTrackingSignalId Output only. The ID that uniquely identifies this order tracking
   *     signal.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrderTrackingSignal createOrderTrackingSignal(
      AccountName parent, String orderTrackingSignalId) {
    CreateOrderTrackingSignalRequest request =
        CreateOrderTrackingSignalRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setOrderTrackingSignalId(orderTrackingSignalId)
            .build();
    return createOrderTrackingSignal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new order tracking signal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrderTrackingSignalsServiceClient orderTrackingSignalsServiceClient =
   *     OrderTrackingSignalsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   String orderTrackingSignalId = "orderTrackingSignalId1140832552";
   *   OrderTrackingSignal response =
   *       orderTrackingSignalsServiceClient.createOrderTrackingSignal(
   *           parent, orderTrackingSignalId);
   * }
   * }</pre>
   *
   * @param parent Required. The account of the business for which the order signal is created.
   *     Format: accounts/{account}
   * @param orderTrackingSignalId Output only. The ID that uniquely identifies this order tracking
   *     signal.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrderTrackingSignal createOrderTrackingSignal(
      String parent, String orderTrackingSignalId) {
    CreateOrderTrackingSignalRequest request =
        CreateOrderTrackingSignalRequest.newBuilder()
            .setParent(parent)
            .setOrderTrackingSignalId(orderTrackingSignalId)
            .build();
    return createOrderTrackingSignal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new order tracking signal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrderTrackingSignalsServiceClient orderTrackingSignalsServiceClient =
   *     OrderTrackingSignalsServiceClient.create()) {
   *   CreateOrderTrackingSignalRequest request =
   *       CreateOrderTrackingSignalRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setOrderTrackingSignalId("orderTrackingSignalId1140832552")
   *           .setOrderTrackingSignal(OrderTrackingSignal.newBuilder().build())
   *           .build();
   *   OrderTrackingSignal response =
   *       orderTrackingSignalsServiceClient.createOrderTrackingSignal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrderTrackingSignal createOrderTrackingSignal(
      CreateOrderTrackingSignalRequest request) {
    return createOrderTrackingSignalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new order tracking signal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrderTrackingSignalsServiceClient orderTrackingSignalsServiceClient =
   *     OrderTrackingSignalsServiceClient.create()) {
   *   CreateOrderTrackingSignalRequest request =
   *       CreateOrderTrackingSignalRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setOrderTrackingSignalId("orderTrackingSignalId1140832552")
   *           .setOrderTrackingSignal(OrderTrackingSignal.newBuilder().build())
   *           .build();
   *   ApiFuture<OrderTrackingSignal> future =
   *       orderTrackingSignalsServiceClient.createOrderTrackingSignalCallable().futureCall(request);
   *   // Do something.
   *   OrderTrackingSignal response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateOrderTrackingSignalRequest, OrderTrackingSignal>
      createOrderTrackingSignalCallable() {
    return stub.createOrderTrackingSignalCallable();
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
}

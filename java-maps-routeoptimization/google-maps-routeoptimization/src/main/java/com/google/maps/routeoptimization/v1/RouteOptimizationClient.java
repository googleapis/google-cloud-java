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

package com.google.maps.routeoptimization.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.maps.routeoptimization.v1.stub.RouteOptimizationStub;
import com.google.maps.routeoptimization.v1.stub.RouteOptimizationStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for optimizing vehicle tours.
 *
 * <p>Validity of certain types of fields:
 *
 * <p>&#42; `google.protobuf.Timestamp` &#42; Times are in Unix time: seconds since
 * 1970-01-01T00:00:00+00:00. &#42; seconds must be in [0, 253402300799], i.e. in
 * [1970-01-01T00:00:00+00:00, 9999-12-31T23:59:59+00:00]. &#42; nanos must be unset or set to 0.
 * &#42; `google.protobuf.Duration` &#42; seconds must be in [0, 253402300799], i.e. in
 * [1970-01-01T00:00:00+00:00, 9999-12-31T23:59:59+00:00]. &#42; nanos must be unset or set to 0.
 * &#42; `google.type.LatLng` &#42; latitude must be in [-90.0, 90.0]. &#42; longitude must be in
 * [-180.0, 180.0]. &#42; at least one of latitude and longitude must be non-zero.
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
 * try (RouteOptimizationClient routeOptimizationClient = RouteOptimizationClient.create()) {
 *   OptimizeToursRequest request =
 *       OptimizeToursRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setTimeout(Duration.newBuilder().build())
 *           .setModel(ShipmentModel.newBuilder().build())
 *           .addAllInjectedFirstSolutionRoutes(new ArrayList<ShipmentRoute>())
 *           .setInjectedSolutionConstraint(InjectedSolutionConstraint.newBuilder().build())
 *           .addAllRefreshDetailsRoutes(new ArrayList<ShipmentRoute>())
 *           .setInterpretInjectedSolutionsUsingLabels(true)
 *           .setConsiderRoadTraffic(true)
 *           .setPopulatePolylines(true)
 *           .setPopulateTransitionPolylines(true)
 *           .setAllowLargeDeadlineDespiteInterruptionRisk(true)
 *           .setUseGeodesicDistances(true)
 *           .setGeodesicMetersPerSecond(-2129658905)
 *           .setMaxValidationErrors(-1367418922)
 *           .setLabel("label102727412")
 *           .build();
 *   OptimizeToursResponse response = routeOptimizationClient.optimizeTours(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RouteOptimizationClient object to clean up resources
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
 *      <td><p> OptimizeTours</td>
 *      <td><p> Sends an `OptimizeToursRequest` containing a `ShipmentModel` and returns an `OptimizeToursResponse` containing `ShipmentRoute`s, which are a set of routes to be performed by vehicles minimizing the overall cost.
 * <p>  A `ShipmentModel` model consists mainly of `Shipment`s that need to be carried out and `Vehicle`s that can be used to transport the `Shipment`s. The `ShipmentRoute`s assign `Shipment`s to `Vehicle`s. More specifically, they assign a series of `Visit`s to each vehicle, where a `Visit` corresponds to a `VisitRequest`, which is a pickup or delivery for a `Shipment`.
 * <p>  The goal is to provide an assignment of `ShipmentRoute`s to `Vehicle`s that minimizes the total cost where cost has many components defined in the `ShipmentModel`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> optimizeTours(OptimizeToursRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> optimizeToursCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchOptimizeTours</td>
 *      <td><p> Optimizes vehicle tours for one or more `OptimizeToursRequest` messages as a batch.
 * <p>  This method is a Long Running Operation (LRO). The inputs for optimization (`OptimizeToursRequest` messages) and outputs (`OptimizeToursResponse` messages) are read/written from/to Cloud Storage in user-specified format. Like the `OptimizeTours` method, each `OptimizeToursRequest` contains a `ShipmentModel` and returns an `OptimizeToursResponse` containing `ShipmentRoute`s, which are a set of routes to be performed by vehicles minimizing the overall cost.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchOptimizeToursAsync(BatchOptimizeToursRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchOptimizeToursOperationCallable()
 *           <li><p> batchOptimizeToursCallable()
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
 * <p>This class can be customized by passing in a custom instance of RouteOptimizationSettings to
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
 * RouteOptimizationSettings routeOptimizationSettings =
 *     RouteOptimizationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RouteOptimizationClient routeOptimizationClient =
 *     RouteOptimizationClient.create(routeOptimizationSettings);
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
 * RouteOptimizationSettings routeOptimizationSettings =
 *     RouteOptimizationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RouteOptimizationClient routeOptimizationClient =
 *     RouteOptimizationClient.create(routeOptimizationSettings);
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
 * RouteOptimizationSettings routeOptimizationSettings =
 *     RouteOptimizationSettings.newHttpJsonBuilder().build();
 * RouteOptimizationClient routeOptimizationClient =
 *     RouteOptimizationClient.create(routeOptimizationSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RouteOptimizationClient implements BackgroundResource {
  private final RouteOptimizationSettings settings;
  private final RouteOptimizationStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of RouteOptimizationClient with default settings. */
  public static final RouteOptimizationClient create() throws IOException {
    return create(RouteOptimizationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RouteOptimizationClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RouteOptimizationClient create(RouteOptimizationSettings settings)
      throws IOException {
    return new RouteOptimizationClient(settings);
  }

  /**
   * Constructs an instance of RouteOptimizationClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(RouteOptimizationSettings).
   */
  public static final RouteOptimizationClient create(RouteOptimizationStub stub) {
    return new RouteOptimizationClient(stub);
  }

  /**
   * Constructs an instance of RouteOptimizationClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RouteOptimizationClient(RouteOptimizationSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RouteOptimizationStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected RouteOptimizationClient(RouteOptimizationStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final RouteOptimizationSettings getSettings() {
    return settings;
  }

  public RouteOptimizationStub getStub() {
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
   * Sends an `OptimizeToursRequest` containing a `ShipmentModel` and returns an
   * `OptimizeToursResponse` containing `ShipmentRoute`s, which are a set of routes to be performed
   * by vehicles minimizing the overall cost.
   *
   * <p>A `ShipmentModel` model consists mainly of `Shipment`s that need to be carried out and
   * `Vehicle`s that can be used to transport the `Shipment`s. The `ShipmentRoute`s assign
   * `Shipment`s to `Vehicle`s. More specifically, they assign a series of `Visit`s to each vehicle,
   * where a `Visit` corresponds to a `VisitRequest`, which is a pickup or delivery for a
   * `Shipment`.
   *
   * <p>The goal is to provide an assignment of `ShipmentRoute`s to `Vehicle`s that minimizes the
   * total cost where cost has many components defined in the `ShipmentModel`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RouteOptimizationClient routeOptimizationClient = RouteOptimizationClient.create()) {
   *   OptimizeToursRequest request =
   *       OptimizeToursRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setTimeout(Duration.newBuilder().build())
   *           .setModel(ShipmentModel.newBuilder().build())
   *           .addAllInjectedFirstSolutionRoutes(new ArrayList<ShipmentRoute>())
   *           .setInjectedSolutionConstraint(InjectedSolutionConstraint.newBuilder().build())
   *           .addAllRefreshDetailsRoutes(new ArrayList<ShipmentRoute>())
   *           .setInterpretInjectedSolutionsUsingLabels(true)
   *           .setConsiderRoadTraffic(true)
   *           .setPopulatePolylines(true)
   *           .setPopulateTransitionPolylines(true)
   *           .setAllowLargeDeadlineDespiteInterruptionRisk(true)
   *           .setUseGeodesicDistances(true)
   *           .setGeodesicMetersPerSecond(-2129658905)
   *           .setMaxValidationErrors(-1367418922)
   *           .setLabel("label102727412")
   *           .build();
   *   OptimizeToursResponse response = routeOptimizationClient.optimizeTours(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OptimizeToursResponse optimizeTours(OptimizeToursRequest request) {
    return optimizeToursCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends an `OptimizeToursRequest` containing a `ShipmentModel` and returns an
   * `OptimizeToursResponse` containing `ShipmentRoute`s, which are a set of routes to be performed
   * by vehicles minimizing the overall cost.
   *
   * <p>A `ShipmentModel` model consists mainly of `Shipment`s that need to be carried out and
   * `Vehicle`s that can be used to transport the `Shipment`s. The `ShipmentRoute`s assign
   * `Shipment`s to `Vehicle`s. More specifically, they assign a series of `Visit`s to each vehicle,
   * where a `Visit` corresponds to a `VisitRequest`, which is a pickup or delivery for a
   * `Shipment`.
   *
   * <p>The goal is to provide an assignment of `ShipmentRoute`s to `Vehicle`s that minimizes the
   * total cost where cost has many components defined in the `ShipmentModel`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RouteOptimizationClient routeOptimizationClient = RouteOptimizationClient.create()) {
   *   OptimizeToursRequest request =
   *       OptimizeToursRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setTimeout(Duration.newBuilder().build())
   *           .setModel(ShipmentModel.newBuilder().build())
   *           .addAllInjectedFirstSolutionRoutes(new ArrayList<ShipmentRoute>())
   *           .setInjectedSolutionConstraint(InjectedSolutionConstraint.newBuilder().build())
   *           .addAllRefreshDetailsRoutes(new ArrayList<ShipmentRoute>())
   *           .setInterpretInjectedSolutionsUsingLabels(true)
   *           .setConsiderRoadTraffic(true)
   *           .setPopulatePolylines(true)
   *           .setPopulateTransitionPolylines(true)
   *           .setAllowLargeDeadlineDespiteInterruptionRisk(true)
   *           .setUseGeodesicDistances(true)
   *           .setGeodesicMetersPerSecond(-2129658905)
   *           .setMaxValidationErrors(-1367418922)
   *           .setLabel("label102727412")
   *           .build();
   *   ApiFuture<OptimizeToursResponse> future =
   *       routeOptimizationClient.optimizeToursCallable().futureCall(request);
   *   // Do something.
   *   OptimizeToursResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<OptimizeToursRequest, OptimizeToursResponse> optimizeToursCallable() {
    return stub.optimizeToursCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Optimizes vehicle tours for one or more `OptimizeToursRequest` messages as a batch.
   *
   * <p>This method is a Long Running Operation (LRO). The inputs for optimization
   * (`OptimizeToursRequest` messages) and outputs (`OptimizeToursResponse` messages) are
   * read/written from/to Cloud Storage in user-specified format. Like the `OptimizeTours` method,
   * each `OptimizeToursRequest` contains a `ShipmentModel` and returns an `OptimizeToursResponse`
   * containing `ShipmentRoute`s, which are a set of routes to be performed by vehicles minimizing
   * the overall cost.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RouteOptimizationClient routeOptimizationClient = RouteOptimizationClient.create()) {
   *   BatchOptimizeToursRequest request =
   *       BatchOptimizeToursRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllModelConfigs(new ArrayList<BatchOptimizeToursRequest.AsyncModelConfig>())
   *           .build();
   *   BatchOptimizeToursResponse response =
   *       routeOptimizationClient.batchOptimizeToursAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchOptimizeToursResponse, BatchOptimizeToursMetadata>
      batchOptimizeToursAsync(BatchOptimizeToursRequest request) {
    return batchOptimizeToursOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Optimizes vehicle tours for one or more `OptimizeToursRequest` messages as a batch.
   *
   * <p>This method is a Long Running Operation (LRO). The inputs for optimization
   * (`OptimizeToursRequest` messages) and outputs (`OptimizeToursResponse` messages) are
   * read/written from/to Cloud Storage in user-specified format. Like the `OptimizeTours` method,
   * each `OptimizeToursRequest` contains a `ShipmentModel` and returns an `OptimizeToursResponse`
   * containing `ShipmentRoute`s, which are a set of routes to be performed by vehicles minimizing
   * the overall cost.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RouteOptimizationClient routeOptimizationClient = RouteOptimizationClient.create()) {
   *   BatchOptimizeToursRequest request =
   *       BatchOptimizeToursRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllModelConfigs(new ArrayList<BatchOptimizeToursRequest.AsyncModelConfig>())
   *           .build();
   *   OperationFuture<BatchOptimizeToursResponse, BatchOptimizeToursMetadata> future =
   *       routeOptimizationClient.batchOptimizeToursOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchOptimizeToursResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchOptimizeToursRequest, BatchOptimizeToursResponse, BatchOptimizeToursMetadata>
      batchOptimizeToursOperationCallable() {
    return stub.batchOptimizeToursOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Optimizes vehicle tours for one or more `OptimizeToursRequest` messages as a batch.
   *
   * <p>This method is a Long Running Operation (LRO). The inputs for optimization
   * (`OptimizeToursRequest` messages) and outputs (`OptimizeToursResponse` messages) are
   * read/written from/to Cloud Storage in user-specified format. Like the `OptimizeTours` method,
   * each `OptimizeToursRequest` contains a `ShipmentModel` and returns an `OptimizeToursResponse`
   * containing `ShipmentRoute`s, which are a set of routes to be performed by vehicles minimizing
   * the overall cost.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RouteOptimizationClient routeOptimizationClient = RouteOptimizationClient.create()) {
   *   BatchOptimizeToursRequest request =
   *       BatchOptimizeToursRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllModelConfigs(new ArrayList<BatchOptimizeToursRequest.AsyncModelConfig>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       routeOptimizationClient.batchOptimizeToursCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchOptimizeToursRequest, Operation> batchOptimizeToursCallable() {
    return stub.batchOptimizeToursCallable();
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

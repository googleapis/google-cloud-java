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

package com.google.cloud.optimization.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.optimization.v1.stub.FleetRoutingStub;
import com.google.cloud.optimization.v1.stub.FleetRoutingStubSettings;
import com.google.longrunning.Operation;
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
 * try (FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create()) {
 *   OptimizeToursRequest request =
 *       OptimizeToursRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setTimeout(Duration.newBuilder().build())
 *           .setModel(ShipmentModel.newBuilder().build())
 *           .setMaxValidationErrors(-1367418922)
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
 *           .setLabel("label102727412")
 *           .setPopulateTravelStepPolylines(true)
 *           .build();
 *   OptimizeToursResponse response = fleetRoutingClient.optimizeTours(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FleetRoutingClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of FleetRoutingSettings to
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
 * FleetRoutingSettings fleetRoutingSettings =
 *     FleetRoutingSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create(fleetRoutingSettings);
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
 * FleetRoutingSettings fleetRoutingSettings =
 *     FleetRoutingSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create(fleetRoutingSettings);
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
 * FleetRoutingSettings fleetRoutingSettings =
 *     FleetRoutingSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             FleetRoutingSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create(fleetRoutingSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class FleetRoutingClient implements BackgroundResource {
  private final FleetRoutingSettings settings;
  private final FleetRoutingStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of FleetRoutingClient with default settings. */
  public static final FleetRoutingClient create() throws IOException {
    return create(FleetRoutingSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FleetRoutingClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FleetRoutingClient create(FleetRoutingSettings settings) throws IOException {
    return new FleetRoutingClient(settings);
  }

  /**
   * Constructs an instance of FleetRoutingClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(FleetRoutingSettings).
   */
  public static final FleetRoutingClient create(FleetRoutingStub stub) {
    return new FleetRoutingClient(stub);
  }

  /**
   * Constructs an instance of FleetRoutingClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected FleetRoutingClient(FleetRoutingSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FleetRoutingStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected FleetRoutingClient(FleetRoutingStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final FleetRoutingSettings getSettings() {
    return settings;
  }

  public FleetRoutingStub getStub() {
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
   * try (FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create()) {
   *   OptimizeToursRequest request =
   *       OptimizeToursRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setTimeout(Duration.newBuilder().build())
   *           .setModel(ShipmentModel.newBuilder().build())
   *           .setMaxValidationErrors(-1367418922)
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
   *           .setLabel("label102727412")
   *           .setPopulateTravelStepPolylines(true)
   *           .build();
   *   OptimizeToursResponse response = fleetRoutingClient.optimizeTours(request);
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
   * try (FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create()) {
   *   OptimizeToursRequest request =
   *       OptimizeToursRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setTimeout(Duration.newBuilder().build())
   *           .setModel(ShipmentModel.newBuilder().build())
   *           .setMaxValidationErrors(-1367418922)
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
   *           .setLabel("label102727412")
   *           .setPopulateTravelStepPolylines(true)
   *           .build();
   *   ApiFuture<OptimizeToursResponse> future =
   *       fleetRoutingClient.optimizeToursCallable().futureCall(request);
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
   * try (FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create()) {
   *   BatchOptimizeToursRequest request =
   *       BatchOptimizeToursRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllModelConfigs(new ArrayList<BatchOptimizeToursRequest.AsyncModelConfig>())
   *           .build();
   *   BatchOptimizeToursResponse response =
   *       fleetRoutingClient.batchOptimizeToursAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchOptimizeToursResponse, AsyncModelMetadata>
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
   * try (FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create()) {
   *   BatchOptimizeToursRequest request =
   *       BatchOptimizeToursRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllModelConfigs(new ArrayList<BatchOptimizeToursRequest.AsyncModelConfig>())
   *           .build();
   *   OperationFuture<BatchOptimizeToursResponse, AsyncModelMetadata> future =
   *       fleetRoutingClient.batchOptimizeToursOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchOptimizeToursResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchOptimizeToursRequest, BatchOptimizeToursResponse, AsyncModelMetadata>
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
   * try (FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create()) {
   *   BatchOptimizeToursRequest request =
   *       BatchOptimizeToursRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllModelConfigs(new ArrayList<BatchOptimizeToursRequest.AsyncModelConfig>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       fleetRoutingClient.batchOptimizeToursCallable().futureCall(request);
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

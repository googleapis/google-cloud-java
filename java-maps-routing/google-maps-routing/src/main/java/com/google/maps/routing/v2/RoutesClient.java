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

package com.google.maps.routing.v2;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.routing.v2.stub.RoutesStub;
import com.google.maps.routing.v2.stub.RoutesStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Routes API.
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
 * try (RoutesClient routesClient = RoutesClient.create()) {
 *   ComputeRoutesRequest request =
 *       ComputeRoutesRequest.newBuilder()
 *           .setOrigin(Waypoint.newBuilder().build())
 *           .setDestination(Waypoint.newBuilder().build())
 *           .addAllIntermediates(new ArrayList<Waypoint>())
 *           .setTravelMode(RouteTravelMode.forNumber(0))
 *           .setRoutingPreference(RoutingPreference.forNumber(0))
 *           .setPolylineQuality(PolylineQuality.forNumber(0))
 *           .setPolylineEncoding(PolylineEncoding.forNumber(0))
 *           .setDepartureTime(Timestamp.newBuilder().build())
 *           .setComputeAlternativeRoutes(true)
 *           .setRouteModifiers(RouteModifiers.newBuilder().build())
 *           .setLanguageCode("languageCode-2092349083")
 *           .setUnits(Units.forNumber(0))
 *           .addAllRequestedReferenceRoutes(new ArrayList<ComputeRoutesRequest.ReferenceRoute>())
 *           .build();
 *   ComputeRoutesResponse response = routesClient.computeRoutes(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RoutesClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of RoutesSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RoutesSettings routesSettings =
 *     RoutesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RoutesClient routesClient = RoutesClient.create(routesSettings);
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
 * RoutesSettings routesSettings = RoutesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RoutesClient routesClient = RoutesClient.create(routesSettings);
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
 * RoutesSettings routesSettings = RoutesSettings.newHttpJsonBuilder().build();
 * RoutesClient routesClient = RoutesClient.create(routesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RoutesClient implements BackgroundResource {
  private final RoutesSettings settings;
  private final RoutesStub stub;

  /** Constructs an instance of RoutesClient with default settings. */
  public static final RoutesClient create() throws IOException {
    return create(RoutesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RoutesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RoutesClient create(RoutesSettings settings) throws IOException {
    return new RoutesClient(settings);
  }

  /**
   * Constructs an instance of RoutesClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(RoutesSettings).
   */
  public static final RoutesClient create(RoutesStub stub) {
    return new RoutesClient(stub);
  }

  /**
   * Constructs an instance of RoutesClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected RoutesClient(RoutesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RoutesStubSettings) settings.getStubSettings()).createStub();
  }

  protected RoutesClient(RoutesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RoutesSettings getSettings() {
    return settings;
  }

  public RoutesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the primary route along with optional alternate routes, given a set of terminal and
   * intermediate waypoints.
   *
   * <p>&#42;&#42;NOTE:&#42;&#42; This method requires that you specify a response field mask in the
   * input. You can provide the response field mask by using URL parameter `$fields` or `fields`, or
   * by using an HTTP/gRPC header `X-Goog-FieldMask` (see the [available URL parameters and
   * headers](https://cloud.google.com/apis/docs/system-parameters). The value is a comma separated
   * list of field paths. See detailed documentation about [how to construct the field
   * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
   *
   * <p>For example, in this method:
   *
   * <ul>
   *   <li>Field mask of all available fields (for manual inspection): `X-Goog-FieldMask: &#42;`
   *   <li>Field mask of Route-level duration, distance, and polyline (an example production setup):
   *       `X-Goog-FieldMask: routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline`
   * </ul>
   *
   * <p>Google discourage the use of the wildcard (`&#42;`) response field mask, or specifying the
   * field mask at the top level (`routes`), because:
   *
   * <ul>
   *   <li>Selecting only the fields that you need helps our server save computation cycles,
   *       allowing us to return the result to you with a lower latency.
   *   <li>Selecting only the fields that you need in your production job ensures stable latency
   *       performance. We might add more response fields in the future, and those new fields might
   *       require extra computation time. If you select all fields, or if you select all fields at
   *       the top level, then you might experience performance degradation because any new field we
   *       add will be automatically included in the response.
   *   <li>Selecting only the fields that you need results in a smaller response size, and thus
   *       higher network throughput.
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
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   ComputeRoutesRequest request =
   *       ComputeRoutesRequest.newBuilder()
   *           .setOrigin(Waypoint.newBuilder().build())
   *           .setDestination(Waypoint.newBuilder().build())
   *           .addAllIntermediates(new ArrayList<Waypoint>())
   *           .setTravelMode(RouteTravelMode.forNumber(0))
   *           .setRoutingPreference(RoutingPreference.forNumber(0))
   *           .setPolylineQuality(PolylineQuality.forNumber(0))
   *           .setPolylineEncoding(PolylineEncoding.forNumber(0))
   *           .setDepartureTime(Timestamp.newBuilder().build())
   *           .setComputeAlternativeRoutes(true)
   *           .setRouteModifiers(RouteModifiers.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setUnits(Units.forNumber(0))
   *           .addAllRequestedReferenceRoutes(new ArrayList<ComputeRoutesRequest.ReferenceRoute>())
   *           .build();
   *   ComputeRoutesResponse response = routesClient.computeRoutes(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeRoutesResponse computeRoutes(ComputeRoutesRequest request) {
    return computeRoutesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the primary route along with optional alternate routes, given a set of terminal and
   * intermediate waypoints.
   *
   * <p>&#42;&#42;NOTE:&#42;&#42; This method requires that you specify a response field mask in the
   * input. You can provide the response field mask by using URL parameter `$fields` or `fields`, or
   * by using an HTTP/gRPC header `X-Goog-FieldMask` (see the [available URL parameters and
   * headers](https://cloud.google.com/apis/docs/system-parameters). The value is a comma separated
   * list of field paths. See detailed documentation about [how to construct the field
   * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
   *
   * <p>For example, in this method:
   *
   * <ul>
   *   <li>Field mask of all available fields (for manual inspection): `X-Goog-FieldMask: &#42;`
   *   <li>Field mask of Route-level duration, distance, and polyline (an example production setup):
   *       `X-Goog-FieldMask: routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline`
   * </ul>
   *
   * <p>Google discourage the use of the wildcard (`&#42;`) response field mask, or specifying the
   * field mask at the top level (`routes`), because:
   *
   * <ul>
   *   <li>Selecting only the fields that you need helps our server save computation cycles,
   *       allowing us to return the result to you with a lower latency.
   *   <li>Selecting only the fields that you need in your production job ensures stable latency
   *       performance. We might add more response fields in the future, and those new fields might
   *       require extra computation time. If you select all fields, or if you select all fields at
   *       the top level, then you might experience performance degradation because any new field we
   *       add will be automatically included in the response.
   *   <li>Selecting only the fields that you need results in a smaller response size, and thus
   *       higher network throughput.
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
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   ComputeRoutesRequest request =
   *       ComputeRoutesRequest.newBuilder()
   *           .setOrigin(Waypoint.newBuilder().build())
   *           .setDestination(Waypoint.newBuilder().build())
   *           .addAllIntermediates(new ArrayList<Waypoint>())
   *           .setTravelMode(RouteTravelMode.forNumber(0))
   *           .setRoutingPreference(RoutingPreference.forNumber(0))
   *           .setPolylineQuality(PolylineQuality.forNumber(0))
   *           .setPolylineEncoding(PolylineEncoding.forNumber(0))
   *           .setDepartureTime(Timestamp.newBuilder().build())
   *           .setComputeAlternativeRoutes(true)
   *           .setRouteModifiers(RouteModifiers.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setUnits(Units.forNumber(0))
   *           .addAllRequestedReferenceRoutes(new ArrayList<ComputeRoutesRequest.ReferenceRoute>())
   *           .build();
   *   ApiFuture<ComputeRoutesResponse> future =
   *       routesClient.computeRoutesCallable().futureCall(request);
   *   // Do something.
   *   ComputeRoutesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ComputeRoutesRequest, ComputeRoutesResponse> computeRoutesCallable() {
    return stub.computeRoutesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Takes in a list of origins and destinations and returns a stream containing route information
   * for each combination of origin and destination.
   *
   * <p>&#42;&#42;NOTE:&#42;&#42; This method requires that you specify a response field mask in the
   * input. You can provide the response field mask by using the URL parameter `$fields` or
   * `fields`, or by using the HTTP/gRPC header `X-Goog-FieldMask` (see the [available URL
   * parameters and headers](https://cloud.google.com/apis/docs/system-parameters). The value is a
   * comma separated list of field paths. See this detailed documentation about [how to construct
   * the field
   * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
   *
   * <p>For example, in this method:
   *
   * <ul>
   *   <li>Field mask of all available fields (for manual inspection): `X-Goog-FieldMask: &#42;`
   *   <li>Field mask of route durations, distances, element status, condition, and element indices
   *       (an example production setup): `X-Goog-FieldMask:
   *       originIndex,destinationIndex,status,condition,distanceMeters,duration`
   * </ul>
   *
   * <p>It is critical that you include `status` in your field mask as otherwise all messages will
   * appear to be OK. Google discourages the use of the wildcard (`&#42;`) response field mask,
   * because:
   *
   * <ul>
   *   <li>Selecting only the fields that you need helps our server save computation cycles,
   *       allowing us to return the result to you with a lower latency.
   *   <li>Selecting only the fields that you need in your production job ensures stable latency
   *       performance. We might add more response fields in the future, and those new fields might
   *       require extra computation time. If you select all fields, or if you select all fields at
   *       the top level, then you might experience performance degradation because any new field we
   *       add will be automatically included in the response.
   *   <li>Selecting only the fields that you need results in a smaller response size, and thus
   *       higher network throughput.
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
   * try (RoutesClient routesClient = RoutesClient.create()) {
   *   ComputeRouteMatrixRequest request =
   *       ComputeRouteMatrixRequest.newBuilder()
   *           .addAllOrigins(new ArrayList<RouteMatrixOrigin>())
   *           .addAllDestinations(new ArrayList<RouteMatrixDestination>())
   *           .setTravelMode(RouteTravelMode.forNumber(0))
   *           .setRoutingPreference(RoutingPreference.forNumber(0))
   *           .setDepartureTime(Timestamp.newBuilder().build())
   *           .build();
   *   ServerStream<RouteMatrixElement> stream =
   *       routesClient.computeRouteMatrixCallable().call(request);
   *   for (RouteMatrixElement response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<ComputeRouteMatrixRequest, RouteMatrixElement>
      computeRouteMatrixCallable() {
    return stub.computeRouteMatrixCallable();
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

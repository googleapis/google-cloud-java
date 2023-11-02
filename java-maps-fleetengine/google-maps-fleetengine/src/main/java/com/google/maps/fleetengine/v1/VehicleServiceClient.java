/*
 * Copyright 2023 Google LLC
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

package google.maps.fleetengine.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import google.maps.fleetengine.v1.stub.VehicleServiceStub;
import google.maps.fleetengine.v1.stub.VehicleServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Vehicle management service.
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
 * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
 *   CreateVehicleRequest request =
 *       CreateVehicleRequest.newBuilder()
 *           .setHeader(RequestHeader.newBuilder().build())
 *           .setParent("parent-995424086")
 *           .setVehicleId("vehicleId-1984135833")
 *           .setVehicle(Vehicle.newBuilder().build())
 *           .build();
 *   Vehicle response = vehicleServiceClient.createVehicle(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the VehicleServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of VehicleServiceSettings to
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
 * VehicleServiceSettings vehicleServiceSettings =
 *     VehicleServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create(vehicleServiceSettings);
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
 * VehicleServiceSettings vehicleServiceSettings =
 *     VehicleServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create(vehicleServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class VehicleServiceClient implements BackgroundResource {
  private final VehicleServiceSettings settings;
  private final VehicleServiceStub stub;

  /** Constructs an instance of VehicleServiceClient with default settings. */
  public static final VehicleServiceClient create() throws IOException {
    return create(VehicleServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VehicleServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VehicleServiceClient create(VehicleServiceSettings settings)
      throws IOException {
    return new VehicleServiceClient(settings);
  }

  /**
   * Constructs an instance of VehicleServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(VehicleServiceSettings).
   */
  public static final VehicleServiceClient create(VehicleServiceStub stub) {
    return new VehicleServiceClient(stub);
  }

  /**
   * Constructs an instance of VehicleServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected VehicleServiceClient(VehicleServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VehicleServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected VehicleServiceClient(VehicleServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final VehicleServiceSettings getSettings() {
    return settings;
  }

  public VehicleServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Instantiates a new vehicle associated with an on-demand rideshare or deliveries provider. Each
   * `Vehicle` must have a unique vehicle ID.
   *
   * <p>The following `Vehicle` fields are required when creating a `Vehicle`:
   *
   * <ul>
   *   <li>`vehicleState`
   *   <li>`supportedTripTypes`
   *   <li>`maximumCapacity`
   *   <li>`vehicleType`
   * </ul>
   *
   * <p>The following `Vehicle` fields are ignored when creating a `Vehicle`:
   *
   * <ul>
   *   <li>`name`
   *   <li>`currentTrips`
   *   <li>`availableCapacity`
   *   <li>`current_route_segment`
   *   <li>`current_route_segment_end_point`
   *   <li>`current_route_segment_version`
   *   <li>`current_route_segment_traffic`
   *   <li>`route`
   *   <li>`waypoints`
   *   <li>`waypoints_version`
   *   <li>`remaining_distance_meters`
   *   <li>`remaining_time_seconds`
   *   <li>`eta_to_next_waypoint`
   *   <li>`navigation_status`
   * </ul>
   *
   * <p>All other fields are optional and used if provided.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   CreateVehicleRequest request =
   *       CreateVehicleRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setVehicleId("vehicleId-1984135833")
   *           .setVehicle(Vehicle.newBuilder().build())
   *           .build();
   *   Vehicle response = vehicleServiceClient.createVehicle(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Vehicle createVehicle(CreateVehicleRequest request) {
    return createVehicleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Instantiates a new vehicle associated with an on-demand rideshare or deliveries provider. Each
   * `Vehicle` must have a unique vehicle ID.
   *
   * <p>The following `Vehicle` fields are required when creating a `Vehicle`:
   *
   * <ul>
   *   <li>`vehicleState`
   *   <li>`supportedTripTypes`
   *   <li>`maximumCapacity`
   *   <li>`vehicleType`
   * </ul>
   *
   * <p>The following `Vehicle` fields are ignored when creating a `Vehicle`:
   *
   * <ul>
   *   <li>`name`
   *   <li>`currentTrips`
   *   <li>`availableCapacity`
   *   <li>`current_route_segment`
   *   <li>`current_route_segment_end_point`
   *   <li>`current_route_segment_version`
   *   <li>`current_route_segment_traffic`
   *   <li>`route`
   *   <li>`waypoints`
   *   <li>`waypoints_version`
   *   <li>`remaining_distance_meters`
   *   <li>`remaining_time_seconds`
   *   <li>`eta_to_next_waypoint`
   *   <li>`navigation_status`
   * </ul>
   *
   * <p>All other fields are optional and used if provided.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   CreateVehicleRequest request =
   *       CreateVehicleRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setVehicleId("vehicleId-1984135833")
   *           .setVehicle(Vehicle.newBuilder().build())
   *           .build();
   *   ApiFuture<Vehicle> future = vehicleServiceClient.createVehicleCallable().futureCall(request);
   *   // Do something.
   *   Vehicle response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateVehicleRequest, Vehicle> createVehicleCallable() {
    return stub.createVehicleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a vehicle from the Fleet Engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   GetVehicleRequest request =
   *       GetVehicleRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setName(VehicleName.of("[PROVIDER]", "[VEHICLE]").toString())
   *           .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
   *           .setWaypointsVersion(Timestamp.newBuilder().build())
   *           .build();
   *   Vehicle response = vehicleServiceClient.getVehicle(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Vehicle getVehicle(GetVehicleRequest request) {
    return getVehicleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a vehicle from the Fleet Engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   GetVehicleRequest request =
   *       GetVehicleRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setName(VehicleName.of("[PROVIDER]", "[VEHICLE]").toString())
   *           .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
   *           .setWaypointsVersion(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<Vehicle> future = vehicleServiceClient.getVehicleCallable().futureCall(request);
   *   // Do something.
   *   Vehicle response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVehicleRequest, Vehicle> getVehicleCallable() {
    return stub.getVehicleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes updated vehicle data to the Fleet Engine.
   *
   * <p>When updating a `Vehicle`, the following fields cannot be updated since they are managed by
   * the server:
   *
   * <ul>
   *   <li>`currentTrips`
   *   <li>`availableCapacity`
   *   <li>`current_route_segment_version`
   *   <li>`waypoints_version`
   * </ul>
   *
   * <p>The vehicle `name` also cannot be updated.
   *
   * <p>If the `attributes` field is updated, &#42;&#42;all&#42;&#42; the vehicle's attributes are
   * replaced with the attributes provided in the request. If you want to update only some
   * attributes, see the `UpdateVehicleAttributes` method. Likewise, the `waypoints` field can be
   * updated, but must contain all the waypoints currently on the vehicle, and no other waypoints.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   UpdateVehicleRequest request =
   *       UpdateVehicleRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setName("name3373707")
   *           .setVehicle(Vehicle.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Vehicle response = vehicleServiceClient.updateVehicle(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Vehicle updateVehicle(UpdateVehicleRequest request) {
    return updateVehicleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes updated vehicle data to the Fleet Engine.
   *
   * <p>When updating a `Vehicle`, the following fields cannot be updated since they are managed by
   * the server:
   *
   * <ul>
   *   <li>`currentTrips`
   *   <li>`availableCapacity`
   *   <li>`current_route_segment_version`
   *   <li>`waypoints_version`
   * </ul>
   *
   * <p>The vehicle `name` also cannot be updated.
   *
   * <p>If the `attributes` field is updated, &#42;&#42;all&#42;&#42; the vehicle's attributes are
   * replaced with the attributes provided in the request. If you want to update only some
   * attributes, see the `UpdateVehicleAttributes` method. Likewise, the `waypoints` field can be
   * updated, but must contain all the waypoints currently on the vehicle, and no other waypoints.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   UpdateVehicleRequest request =
   *       UpdateVehicleRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setName("name3373707")
   *           .setVehicle(Vehicle.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Vehicle> future = vehicleServiceClient.updateVehicleCallable().futureCall(request);
   *   // Do something.
   *   Vehicle response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateVehicleRequest, Vehicle> updateVehicleCallable() {
    return stub.updateVehicleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Use the `UpdateVehicle` method instead. UpdateVehicleLocation updates the location
   * of the vehicle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   UpdateVehicleLocationRequest request =
   *       UpdateVehicleLocationRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setName("name3373707")
   *           .setCurrentLocation(VehicleLocation.newBuilder().build())
   *           .setCurrentState(VehicleState.forNumber(0))
   *           .build();
   *   VehicleLocation response = vehicleServiceClient.updateVehicleLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final VehicleLocation updateVehicleLocation(UpdateVehicleLocationRequest request) {
    return updateVehicleLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Use the `UpdateVehicle` method instead. UpdateVehicleLocation updates the location
   * of the vehicle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   UpdateVehicleLocationRequest request =
   *       UpdateVehicleLocationRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setName("name3373707")
   *           .setCurrentLocation(VehicleLocation.newBuilder().build())
   *           .setCurrentState(VehicleState.forNumber(0))
   *           .build();
   *   ApiFuture<VehicleLocation> future =
   *       vehicleServiceClient.updateVehicleLocationCallable().futureCall(request);
   *   // Do something.
   *   VehicleLocation response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<UpdateVehicleLocationRequest, VehicleLocation>
      updateVehicleLocationCallable() {
    return stub.updateVehicleLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates a vehicle's attributes. Only the attributes mentioned in the request will be
   * updated, other attributes will NOT be altered. Note: this is different in `UpdateVehicle`,
   * where the whole `attributes` field will be replaced by the one in `UpdateVehicleRequest`,
   * attributes not in the request would be removed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   UpdateVehicleAttributesRequest request =
   *       UpdateVehicleAttributesRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setName("name3373707")
   *           .addAllAttributes(new ArrayList<VehicleAttribute>())
   *           .build();
   *   UpdateVehicleAttributesResponse response =
   *       vehicleServiceClient.updateVehicleAttributes(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UpdateVehicleAttributesResponse updateVehicleAttributes(
      UpdateVehicleAttributesRequest request) {
    return updateVehicleAttributesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates a vehicle's attributes. Only the attributes mentioned in the request will be
   * updated, other attributes will NOT be altered. Note: this is different in `UpdateVehicle`,
   * where the whole `attributes` field will be replaced by the one in `UpdateVehicleRequest`,
   * attributes not in the request would be removed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   UpdateVehicleAttributesRequest request =
   *       UpdateVehicleAttributesRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setName("name3373707")
   *           .addAllAttributes(new ArrayList<VehicleAttribute>())
   *           .build();
   *   ApiFuture<UpdateVehicleAttributesResponse> future =
   *       vehicleServiceClient.updateVehicleAttributesCallable().futureCall(request);
   *   // Do something.
   *   UpdateVehicleAttributesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>
      updateVehicleAttributesCallable() {
    return stub.updateVehicleAttributesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a paginated list of vehicles associated with a provider that match the request options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   ListVehiclesRequest request =
   *       ListVehiclesRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setMinimumCapacity(Int32Value.newBuilder().build())
   *           .addAllTripTypes(new ArrayList<TripType>())
   *           .setMaximumStaleness(Duration.newBuilder().build())
   *           .addAllVehicleTypeCategories(new ArrayList<Vehicle.VehicleType.Category>())
   *           .addAllRequiredAttributes(new ArrayList<String>())
   *           .addAllRequiredOneOfAttributes(new ArrayList<String>())
   *           .addAllRequiredOneOfAttributeSets(new ArrayList<String>())
   *           .setVehicleState(VehicleState.forNumber(0))
   *           .setOnTripOnly(true)
   *           .setFilter("filter-1274492040")
   *           .setViewport(Viewport.newBuilder().build())
   *           .build();
   *   for (Vehicle element : vehicleServiceClient.listVehicles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVehiclesPagedResponse listVehicles(ListVehiclesRequest request) {
    return listVehiclesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a paginated list of vehicles associated with a provider that match the request options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   ListVehiclesRequest request =
   *       ListVehiclesRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setMinimumCapacity(Int32Value.newBuilder().build())
   *           .addAllTripTypes(new ArrayList<TripType>())
   *           .setMaximumStaleness(Duration.newBuilder().build())
   *           .addAllVehicleTypeCategories(new ArrayList<Vehicle.VehicleType.Category>())
   *           .addAllRequiredAttributes(new ArrayList<String>())
   *           .addAllRequiredOneOfAttributes(new ArrayList<String>())
   *           .addAllRequiredOneOfAttributeSets(new ArrayList<String>())
   *           .setVehicleState(VehicleState.forNumber(0))
   *           .setOnTripOnly(true)
   *           .setFilter("filter-1274492040")
   *           .setViewport(Viewport.newBuilder().build())
   *           .build();
   *   ApiFuture<Vehicle> future =
   *       vehicleServiceClient.listVehiclesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Vehicle element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVehiclesRequest, ListVehiclesPagedResponse>
      listVehiclesPagedCallable() {
    return stub.listVehiclesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a paginated list of vehicles associated with a provider that match the request options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   ListVehiclesRequest request =
   *       ListVehiclesRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setMinimumCapacity(Int32Value.newBuilder().build())
   *           .addAllTripTypes(new ArrayList<TripType>())
   *           .setMaximumStaleness(Duration.newBuilder().build())
   *           .addAllVehicleTypeCategories(new ArrayList<Vehicle.VehicleType.Category>())
   *           .addAllRequiredAttributes(new ArrayList<String>())
   *           .addAllRequiredOneOfAttributes(new ArrayList<String>())
   *           .addAllRequiredOneOfAttributeSets(new ArrayList<String>())
   *           .setVehicleState(VehicleState.forNumber(0))
   *           .setOnTripOnly(true)
   *           .setFilter("filter-1274492040")
   *           .setViewport(Viewport.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListVehiclesResponse response = vehicleServiceClient.listVehiclesCallable().call(request);
   *     for (Vehicle element : response.getVehiclesList()) {
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
  public final UnaryCallable<ListVehiclesRequest, ListVehiclesResponse> listVehiclesCallable() {
    return stub.listVehiclesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of vehicles that match the request options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   SearchVehiclesRequest request =
   *       SearchVehiclesRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setPickupPoint(TerminalLocation.newBuilder().build())
   *           .setDropoffPoint(TerminalLocation.newBuilder().build())
   *           .setPickupRadiusMeters(-254656044)
   *           .setCount(94851343)
   *           .setMinimumCapacity(518841803)
   *           .addAllTripTypes(new ArrayList<TripType>())
   *           .setMaximumStaleness(Duration.newBuilder().build())
   *           .addAllVehicleTypes(new ArrayList<Vehicle.VehicleType>())
   *           .addAllRequiredAttributes(new ArrayList<VehicleAttribute>())
   *           .addAllRequiredOneOfAttributes(new ArrayList<VehicleAttributeList>())
   *           .addAllRequiredOneOfAttributeSets(new ArrayList<VehicleAttributeList>())
   *           .setIncludeBackToBack(true)
   *           .setTripId("tripId-865466336")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   SearchVehiclesResponse response = vehicleServiceClient.searchVehicles(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchVehiclesResponse searchVehicles(SearchVehiclesRequest request) {
    return searchVehiclesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of vehicles that match the request options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   SearchVehiclesRequest request =
   *       SearchVehiclesRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setPickupPoint(TerminalLocation.newBuilder().build())
   *           .setDropoffPoint(TerminalLocation.newBuilder().build())
   *           .setPickupRadiusMeters(-254656044)
   *           .setCount(94851343)
   *           .setMinimumCapacity(518841803)
   *           .addAllTripTypes(new ArrayList<TripType>())
   *           .setMaximumStaleness(Duration.newBuilder().build())
   *           .addAllVehicleTypes(new ArrayList<Vehicle.VehicleType>())
   *           .addAllRequiredAttributes(new ArrayList<VehicleAttribute>())
   *           .addAllRequiredOneOfAttributes(new ArrayList<VehicleAttributeList>())
   *           .addAllRequiredOneOfAttributeSets(new ArrayList<VehicleAttributeList>())
   *           .setIncludeBackToBack(true)
   *           .setTripId("tripId-865466336")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<SearchVehiclesResponse> future =
   *       vehicleServiceClient.searchVehiclesCallable().futureCall(request);
   *   // Do something.
   *   SearchVehiclesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchVehiclesRequest, SearchVehiclesResponse>
      searchVehiclesCallable() {
    return stub.searchVehiclesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Use `SearchVehicles` instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   SearchVehiclesRequest request =
   *       SearchVehiclesRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setPickupPoint(TerminalLocation.newBuilder().build())
   *           .setDropoffPoint(TerminalLocation.newBuilder().build())
   *           .setPickupRadiusMeters(-254656044)
   *           .setCount(94851343)
   *           .setMinimumCapacity(518841803)
   *           .addAllTripTypes(new ArrayList<TripType>())
   *           .setMaximumStaleness(Duration.newBuilder().build())
   *           .addAllVehicleTypes(new ArrayList<Vehicle.VehicleType>())
   *           .addAllRequiredAttributes(new ArrayList<VehicleAttribute>())
   *           .addAllRequiredOneOfAttributes(new ArrayList<VehicleAttributeList>())
   *           .addAllRequiredOneOfAttributeSets(new ArrayList<VehicleAttributeList>())
   *           .setIncludeBackToBack(true)
   *           .setTripId("tripId-865466336")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   SearchVehiclesResponse response = vehicleServiceClient.searchFuzzedVehicles(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final SearchVehiclesResponse searchFuzzedVehicles(SearchVehiclesRequest request) {
    return searchFuzzedVehiclesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Use `SearchVehicles` instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
   *   SearchVehiclesRequest request =
   *       SearchVehiclesRequest.newBuilder()
   *           .setHeader(RequestHeader.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .setPickupPoint(TerminalLocation.newBuilder().build())
   *           .setDropoffPoint(TerminalLocation.newBuilder().build())
   *           .setPickupRadiusMeters(-254656044)
   *           .setCount(94851343)
   *           .setMinimumCapacity(518841803)
   *           .addAllTripTypes(new ArrayList<TripType>())
   *           .setMaximumStaleness(Duration.newBuilder().build())
   *           .addAllVehicleTypes(new ArrayList<Vehicle.VehicleType>())
   *           .addAllRequiredAttributes(new ArrayList<VehicleAttribute>())
   *           .addAllRequiredOneOfAttributes(new ArrayList<VehicleAttributeList>())
   *           .addAllRequiredOneOfAttributeSets(new ArrayList<VehicleAttributeList>())
   *           .setIncludeBackToBack(true)
   *           .setTripId("tripId-865466336")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<SearchVehiclesResponse> future =
   *       vehicleServiceClient.searchFuzzedVehiclesCallable().futureCall(request);
   *   // Do something.
   *   SearchVehiclesResponse response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<SearchVehiclesRequest, SearchVehiclesResponse>
      searchFuzzedVehiclesCallable() {
    return stub.searchFuzzedVehiclesCallable();
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

  public static class ListVehiclesPagedResponse
      extends AbstractPagedListResponse<
          ListVehiclesRequest,
          ListVehiclesResponse,
          Vehicle,
          ListVehiclesPage,
          ListVehiclesFixedSizeCollection> {

    public static ApiFuture<ListVehiclesPagedResponse> createAsync(
        PageContext<ListVehiclesRequest, ListVehiclesResponse, Vehicle> context,
        ApiFuture<ListVehiclesResponse> futureResponse) {
      ApiFuture<ListVehiclesPage> futurePage =
          ListVehiclesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVehiclesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVehiclesPagedResponse(ListVehiclesPage page) {
      super(page, ListVehiclesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVehiclesPage
      extends AbstractPage<ListVehiclesRequest, ListVehiclesResponse, Vehicle, ListVehiclesPage> {

    private ListVehiclesPage(
        PageContext<ListVehiclesRequest, ListVehiclesResponse, Vehicle> context,
        ListVehiclesResponse response) {
      super(context, response);
    }

    private static ListVehiclesPage createEmptyPage() {
      return new ListVehiclesPage(null, null);
    }

    @Override
    protected ListVehiclesPage createPage(
        PageContext<ListVehiclesRequest, ListVehiclesResponse, Vehicle> context,
        ListVehiclesResponse response) {
      return new ListVehiclesPage(context, response);
    }

    @Override
    public ApiFuture<ListVehiclesPage> createPageAsync(
        PageContext<ListVehiclesRequest, ListVehiclesResponse, Vehicle> context,
        ApiFuture<ListVehiclesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVehiclesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVehiclesRequest,
          ListVehiclesResponse,
          Vehicle,
          ListVehiclesPage,
          ListVehiclesFixedSizeCollection> {

    private ListVehiclesFixedSizeCollection(List<ListVehiclesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVehiclesFixedSizeCollection createEmptyCollection() {
      return new ListVehiclesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVehiclesFixedSizeCollection createCollection(
        List<ListVehiclesPage> pages, int collectionSize) {
      return new ListVehiclesFixedSizeCollection(pages, collectionSize);
    }
  }
}

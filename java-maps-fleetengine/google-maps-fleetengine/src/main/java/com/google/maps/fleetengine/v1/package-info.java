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

/**
 * A client to Local Rides and Deliveries API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= TripServiceClient =======================
 *
 * <p>Service Description: Trip management service.
 *
 * <p>Sample for TripServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
 *   CreateTripRequest request =
 *       CreateTripRequest.newBuilder()
 *           .setHeader(RequestHeader.newBuilder().build())
 *           .setParent(TripName.of("[PROVIDER]", "[TRIP]").toString())
 *           .setTripId("tripId-865466336")
 *           .setTrip(Trip.newBuilder().build())
 *           .build();
 *   Trip response = tripServiceClient.createTrip(request);
 * }
 * }</pre>
 *
 * <p>======================= VehicleServiceClient =======================
 *
 * <p>Service Description: Vehicle management service.
 *
 * <p>Sample for VehicleServiceClient:
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
 */
@Generated("by gapic-generator-java")
package google.maps.fleetengine.v1;

import javax.annotation.Generated;

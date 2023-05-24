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

/**
 * A client to Cloud Optimization API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= FleetRoutingClient =======================
 *
 * <p>Service Description: A service for optimizing vehicle tours.
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
 * <p>Sample for FleetRoutingClient:
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
 */
@Generated("by gapic-generator-java")
package com.google.cloud.optimization.v1;

import javax.annotation.Generated;

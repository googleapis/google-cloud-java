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
 * A client to Routes API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= RoutesClient =======================
 *
 * <p>Service Description: The Routes API.
 *
 * <p>Sample for RoutesClient:
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
 */
@Generated("by gapic-generator-java")
package com.google.maps.routing.v2;

import javax.annotation.Generated;

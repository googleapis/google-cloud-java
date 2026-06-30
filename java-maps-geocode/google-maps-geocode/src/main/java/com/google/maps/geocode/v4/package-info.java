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

/**
 * A client to Geocoding API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= DestinationServiceClient =======================
 *
 * <p>Service Description: A service for retrieving destinations.
 *
 * <p>A destination provides hierarchical context about a place, which allows you to, for example,
 * find apartment buildings within a larger apartment complex and vice versa. It also provides
 * navigation points suitable for use cases such as ridesharing or delivery.
 *
 * <p>Sample for DestinationServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DestinationServiceClient destinationServiceClient = DestinationServiceClient.create()) {
 *   SearchDestinationsRequest request =
 *       SearchDestinationsRequest.newBuilder()
 *           .addAllTravelModes(new ArrayList<NavigationPoint.TravelMode>())
 *           .setLanguageCode("languageCode-2092349083")
 *           .setRegionCode("regionCode-1991004415")
 *           .build();
 *   SearchDestinationsResponse response = destinationServiceClient.searchDestinations(request);
 * }
 * }</pre>
 *
 * <p>======================= GeocodeServiceClient =======================
 *
 * <p>Service Description: A service for performing geocoding.
 *
 * <p>Sample for GeocodeServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GeocodeServiceClient geocodeServiceClient = GeocodeServiceClient.create()) {
 *   GeocodeAddressRequest request =
 *       GeocodeAddressRequest.newBuilder()
 *           .setLocationBias(GeocodeAddressRequest.LocationBias.newBuilder().build())
 *           .setLanguageCode("languageCode-2092349083")
 *           .setRegionCode("regionCode-1991004415")
 *           .build();
 *   GeocodeAddressResponse response = geocodeServiceClient.geocodeAddress(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.maps.geocode.v4;

import javax.annotation.Generated;

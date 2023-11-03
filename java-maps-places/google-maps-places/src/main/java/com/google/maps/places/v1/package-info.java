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
 * A client to Places API (New)
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= PlacesClient =======================
 *
 * <p>Service Description: Service definition for the Places API.
 *
 * <p>Sample for PlacesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PlacesClient placesClient = PlacesClient.create()) {
 *   SearchTextRequest request =
 *       SearchTextRequest.newBuilder()
 *           .setTextQuery("textQuery-1050470501")
 *           .setLanguageCode("languageCode-2092349083")
 *           .setRegionCode("regionCode-1991004415")
 *           .setLocation(SearchTextRequest.Location.newBuilder().build())
 *           .setIncludedType("includedType-45971946")
 *           .setOpenNow(true)
 *           .setPriceRange(Int32Range.newBuilder().build())
 *           .setMinRating(-543315926)
 *           .setMaxResultCount(-1736124056)
 *           .addAllPriceLevels(new ArrayList<PriceLevel>())
 *           .setStrictTypeFiltering(true)
 *           .setLocationBias(SearchTextRequest.LocationBias.newBuilder().build())
 *           .setLocationRestriction(SearchTextRequest.LocationRestriction.newBuilder().build())
 *           .build();
 *   SearchTextResponse response = placesClient.searchText(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.maps.places.v1;

import javax.annotation.Generated;

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

package com.google.maps.places.v1.samples;

// [START places_v1_generated_Places_AutocompletePlaces_sync]
import com.google.maps.places.v1.AutocompletePlacesRequest;
import com.google.maps.places.v1.AutocompletePlacesResponse;
import com.google.maps.places.v1.PlacesClient;
import com.google.type.LatLng;
import java.util.ArrayList;

public class SyncAutocompletePlaces {

  public static void main(String[] args) throws Exception {
    syncAutocompletePlaces();
  }

  public static void syncAutocompletePlaces() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PlacesClient placesClient = PlacesClient.create()) {
      AutocompletePlacesRequest request =
          AutocompletePlacesRequest.newBuilder()
              .setInput("input100358090")
              .setLocationBias(AutocompletePlacesRequest.LocationBias.newBuilder().build())
              .setLocationRestriction(
                  AutocompletePlacesRequest.LocationRestriction.newBuilder().build())
              .addAllIncludedPrimaryTypes(new ArrayList<String>())
              .addAllIncludedRegionCodes(new ArrayList<String>())
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .setOrigin(LatLng.newBuilder().build())
              .setInputOffset(1010406056)
              .setIncludeQueryPredictions(true)
              .setSessionToken("sessionToken-696552189")
              .build();
      AutocompletePlacesResponse response = placesClient.autocompletePlaces(request);
    }
  }
}
// [END places_v1_generated_Places_AutocompletePlaces_sync]

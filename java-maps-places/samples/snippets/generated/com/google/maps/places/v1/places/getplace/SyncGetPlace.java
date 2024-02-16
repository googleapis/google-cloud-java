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

// [START places_v1_generated_Places_GetPlace_sync]
import com.google.maps.places.v1.GetPlaceRequest;
import com.google.maps.places.v1.Place;
import com.google.maps.places.v1.PlaceName;
import com.google.maps.places.v1.PlacesClient;

public class SyncGetPlace {

  public static void main(String[] args) throws Exception {
    syncGetPlace();
  }

  public static void syncGetPlace() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PlacesClient placesClient = PlacesClient.create()) {
      GetPlaceRequest request =
          GetPlaceRequest.newBuilder()
              .setName(PlaceName.of("[PLACE_ID]").toString())
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .build();
      Place response = placesClient.getPlace(request);
    }
  }
}
// [END places_v1_generated_Places_GetPlace_sync]

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

package com.google.maps.geocode.v4.samples;

// [START backend_v4_generated_GeocodeService_GeocodeLocation_async]
import com.google.api.core.ApiFuture;
import com.google.maps.geocode.v4.GeocodeLocationRequest;
import com.google.maps.geocode.v4.GeocodeLocationResponse;
import com.google.maps.geocode.v4.GeocodeResult;
import com.google.maps.geocode.v4.GeocodeServiceClient;
import java.util.ArrayList;

public class AsyncGeocodeLocation {

  public static void main(String[] args) throws Exception {
    asyncGeocodeLocation();
  }

  public static void asyncGeocodeLocation() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (GeocodeServiceClient geocodeServiceClient = GeocodeServiceClient.create()) {
      GeocodeLocationRequest request =
          GeocodeLocationRequest.newBuilder()
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .addAllTypes(new ArrayList<String>())
              .addAllGranularity(new ArrayList<GeocodeResult.Granularity>())
              .build();
      ApiFuture<GeocodeLocationResponse> future =
          geocodeServiceClient.geocodeLocationCallable().futureCall(request);
      // Do something.
      GeocodeLocationResponse response = future.get();
    }
  }
}
// [END backend_v4_generated_GeocodeService_GeocodeLocation_async]

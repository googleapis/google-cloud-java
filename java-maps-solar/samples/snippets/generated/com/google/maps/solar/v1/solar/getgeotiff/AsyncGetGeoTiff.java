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

package com.google.maps.solar.v1.samples;

// [START solar_v1_generated_Solar_GetGeoTiff_async]
import com.google.api.HttpBody;
import com.google.api.core.ApiFuture;
import com.google.maps.solar.v1.GetGeoTiffRequest;
import com.google.maps.solar.v1.SolarClient;

public class AsyncGetGeoTiff {

  public static void main(String[] args) throws Exception {
    asyncGetGeoTiff();
  }

  public static void asyncGetGeoTiff() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SolarClient solarClient = SolarClient.create()) {
      GetGeoTiffRequest request = GetGeoTiffRequest.newBuilder().setId("id3355").build();
      ApiFuture<HttpBody> future = solarClient.getGeoTiffCallable().futureCall(request);
      // Do something.
      HttpBody response = future.get();
    }
  }
}
// [END solar_v1_generated_Solar_GetGeoTiff_async]

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

// [START solar_v1_generated_Solar_GetDataLayers_async]
import com.google.api.core.ApiFuture;
import com.google.maps.solar.v1.DataLayerView;
import com.google.maps.solar.v1.DataLayers;
import com.google.maps.solar.v1.GetDataLayersRequest;
import com.google.maps.solar.v1.ImageryQuality;
import com.google.maps.solar.v1.SolarClient;
import com.google.type.LatLng;

public class AsyncGetDataLayers {

  public static void main(String[] args) throws Exception {
    asyncGetDataLayers();
  }

  public static void asyncGetDataLayers() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SolarClient solarClient = SolarClient.create()) {
      GetDataLayersRequest request =
          GetDataLayersRequest.newBuilder()
              .setLocation(LatLng.newBuilder().build())
              .setRadiusMeters(1254190679)
              .setView(DataLayerView.forNumber(0))
              .setRequiredQuality(ImageryQuality.forNumber(0))
              .setPixelSizeMeters(-1623742513)
              .setExactQualityRequired(true)
              .build();
      ApiFuture<DataLayers> future = solarClient.getDataLayersCallable().futureCall(request);
      // Do something.
      DataLayers response = future.get();
    }
  }
}
// [END solar_v1_generated_Solar_GetDataLayers_async]

/*
 * Copyright 2025 Google LLC
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

// [START solar_v1_generated_Solar_FindClosestBuildingInsights_sync]
import com.google.maps.solar.v1.BuildingInsights;
import com.google.maps.solar.v1.Experiment;
import com.google.maps.solar.v1.FindClosestBuildingInsightsRequest;
import com.google.maps.solar.v1.ImageryQuality;
import com.google.maps.solar.v1.SolarClient;
import com.google.type.LatLng;
import java.util.ArrayList;

public class SyncFindClosestBuildingInsights {

  public static void main(String[] args) throws Exception {
    syncFindClosestBuildingInsights();
  }

  public static void syncFindClosestBuildingInsights() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SolarClient solarClient = SolarClient.create()) {
      FindClosestBuildingInsightsRequest request =
          FindClosestBuildingInsightsRequest.newBuilder()
              .setLocation(LatLng.newBuilder().build())
              .setRequiredQuality(ImageryQuality.forNumber(0))
              .setExactQualityRequired(true)
              .addAllExperiments(new ArrayList<Experiment>())
              .build();
      BuildingInsights response = solarClient.findClosestBuildingInsights(request);
    }
  }
}
// [END solar_v1_generated_Solar_FindClosestBuildingInsights_sync]

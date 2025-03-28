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

package com.google.maps.areainsights.v1.samples;

// [START areainsights_v1_generated_AreaInsights_ComputeInsights_sync]
import com.google.maps.areainsights.v1.AreaInsightsClient;
import com.google.maps.areainsights.v1.ComputeInsightsRequest;
import com.google.maps.areainsights.v1.ComputeInsightsResponse;
import com.google.maps.areainsights.v1.Filter;
import com.google.maps.areainsights.v1.Insight;
import java.util.ArrayList;

public class SyncComputeInsights {

  public static void main(String[] args) throws Exception {
    syncComputeInsights();
  }

  public static void syncComputeInsights() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AreaInsightsClient areaInsightsClient = AreaInsightsClient.create()) {
      ComputeInsightsRequest request =
          ComputeInsightsRequest.newBuilder()
              .addAllInsights(new ArrayList<Insight>())
              .setFilter(Filter.newBuilder().build())
              .build();
      ComputeInsightsResponse response = areaInsightsClient.computeInsights(request);
    }
  }
}
// [END areainsights_v1_generated_AreaInsights_ComputeInsights_sync]

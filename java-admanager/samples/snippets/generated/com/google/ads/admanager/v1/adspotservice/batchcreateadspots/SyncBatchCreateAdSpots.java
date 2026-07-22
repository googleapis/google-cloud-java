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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_AdSpotService_BatchCreateAdSpots_sync]
import com.google.ads.admanager.v1.AdSpotServiceClient;
import com.google.ads.admanager.v1.BatchCreateAdSpotsRequest;
import com.google.ads.admanager.v1.BatchCreateAdSpotsResponse;
import com.google.ads.admanager.v1.CreateAdSpotRequest;
import com.google.ads.admanager.v1.NetworkName;
import java.util.ArrayList;

public class SyncBatchCreateAdSpots {

  public static void main(String[] args) throws Exception {
    syncBatchCreateAdSpots();
  }

  public static void syncBatchCreateAdSpots() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
      BatchCreateAdSpotsRequest request =
          BatchCreateAdSpotsRequest.newBuilder()
              .setParent(NetworkName.of("[NETWORK_CODE]").toString())
              .addAllRequests(new ArrayList<CreateAdSpotRequest>())
              .build();
      BatchCreateAdSpotsResponse response = adSpotServiceClient.batchCreateAdSpots(request);
    }
  }
}
// [END admanager_v1_generated_AdSpotService_BatchCreateAdSpots_sync]

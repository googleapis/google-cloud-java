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

// [START admanager_v1_generated_PlacementService_BatchCreatePlacements_StringListcreateplacementrequest_sync]
import com.google.ads.admanager.v1.BatchCreatePlacementsResponse;
import com.google.ads.admanager.v1.CreatePlacementRequest;
import com.google.ads.admanager.v1.NetworkName;
import com.google.ads.admanager.v1.PlacementServiceClient;
import java.util.ArrayList;
import java.util.List;

public class SyncBatchCreatePlacementsStringListcreateplacementrequest {

  public static void main(String[] args) throws Exception {
    syncBatchCreatePlacementsStringListcreateplacementrequest();
  }

  public static void syncBatchCreatePlacementsStringListcreateplacementrequest() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
      String parent = NetworkName.of("[NETWORK_CODE]").toString();
      List<CreatePlacementRequest> requests = new ArrayList<>();
      BatchCreatePlacementsResponse response =
          placementServiceClient.batchCreatePlacements(parent, requests);
    }
  }
}
// [END admanager_v1_generated_PlacementService_BatchCreatePlacements_StringListcreateplacementrequest_sync]

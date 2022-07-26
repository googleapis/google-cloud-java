/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.networkconnectivity.v1.samples;

// [START networkconnectivity_v1_generated_hubserviceclient_gethub_sync]
import com.google.cloud.networkconnectivity.v1.GetHubRequest;
import com.google.cloud.networkconnectivity.v1.Hub;
import com.google.cloud.networkconnectivity.v1.HubName;
import com.google.cloud.networkconnectivity.v1.HubServiceClient;

public class SyncGetHub {

  public static void main(String[] args) throws Exception {
    syncGetHub();
  }

  public static void syncGetHub() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
      GetHubRequest request =
          GetHubRequest.newBuilder().setName(HubName.of("[PROJECT]", "[HUB]").toString()).build();
      Hub response = hubServiceClient.getHub(request);
    }
  }
}
// [END networkconnectivity_v1_generated_hubserviceclient_gethub_sync]

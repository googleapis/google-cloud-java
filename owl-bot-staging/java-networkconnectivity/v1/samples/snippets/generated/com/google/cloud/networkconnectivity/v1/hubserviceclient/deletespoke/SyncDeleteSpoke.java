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

// [START networkconnectivity_v1_generated_hubserviceclient_deletespoke_sync]
import com.google.cloud.networkconnectivity.v1.DeleteSpokeRequest;
import com.google.cloud.networkconnectivity.v1.HubServiceClient;
import com.google.cloud.networkconnectivity.v1.SpokeName;
import com.google.protobuf.Empty;

public class SyncDeleteSpoke {

  public static void main(String[] args) throws Exception {
    syncDeleteSpoke();
  }

  public static void syncDeleteSpoke() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
      DeleteSpokeRequest request =
          DeleteSpokeRequest.newBuilder()
              .setName(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
              .setRequestId("requestId693933066")
              .build();
      hubServiceClient.deleteSpokeAsync(request).get();
    }
  }
}
// [END networkconnectivity_v1_generated_hubserviceclient_deletespoke_sync]

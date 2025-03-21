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

package com.google.cloud.networkconnectivity.v1.samples;

// [START networkconnectivity_v1_generated_HubService_AcceptSpokeUpdate_HubnameStringString_sync]
import com.google.cloud.networkconnectivity.v1.AcceptSpokeUpdateResponse;
import com.google.cloud.networkconnectivity.v1.HubName;
import com.google.cloud.networkconnectivity.v1.HubServiceClient;
import com.google.cloud.networkconnectivity.v1.SpokeName;

public class SyncAcceptSpokeUpdateHubnameStringString {

  public static void main(String[] args) throws Exception {
    syncAcceptSpokeUpdateHubnameStringString();
  }

  public static void syncAcceptSpokeUpdateHubnameStringString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
      HubName name = HubName.of("[PROJECT]", "[HUB]");
      String spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString();
      String spokeEtag = "spokeEtag-1185145407";
      AcceptSpokeUpdateResponse response =
          hubServiceClient.acceptSpokeUpdateAsync(name, spokeUri, spokeEtag).get();
    }
  }
}
// [END networkconnectivity_v1_generated_HubService_AcceptSpokeUpdate_HubnameStringString_sync]

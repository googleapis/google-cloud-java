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

package com.google.cloud.networkconnectivity.v1alpha1.samples;

// [START networkconnectivity_v1alpha1_generated_hubserviceclient_gethub_string_sync]
import com.google.cloud.networkconnectivity.v1alpha1.Hub;
import com.google.cloud.networkconnectivity.v1alpha1.HubName;
import com.google.cloud.networkconnectivity.v1alpha1.HubServiceClient;

public class SyncGetHubString {

  public static void main(String[] args) throws Exception {
    syncGetHubString();
  }

  public static void syncGetHubString() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
      String name = HubName.of("[PROJECT]", "[HUB]").toString();
      Hub response = hubServiceClient.getHub(name);
    }
  }
}
// [END networkconnectivity_v1alpha1_generated_hubserviceclient_gethub_string_sync]

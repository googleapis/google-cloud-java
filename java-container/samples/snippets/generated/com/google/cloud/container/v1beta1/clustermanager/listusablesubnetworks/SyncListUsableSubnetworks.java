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

package com.google.cloud.container.v1beta1.samples;

// [START container_v1beta1_generated_ClusterManager_ListUsableSubnetworks_sync]
import com.google.cloud.container.v1beta1.ClusterManagerClient;
import com.google.container.v1beta1.ListUsableSubnetworksRequest;
import com.google.container.v1beta1.UsableSubnetwork;

public class SyncListUsableSubnetworks {

  public static void main(String[] args) throws Exception {
    syncListUsableSubnetworks();
  }

  public static void syncListUsableSubnetworks() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
      ListUsableSubnetworksRequest request =
          ListUsableSubnetworksRequest.newBuilder()
              .setParent("parent-995424086")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      for (UsableSubnetwork element :
          clusterManagerClient.listUsableSubnetworks(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END container_v1beta1_generated_ClusterManager_ListUsableSubnetworks_sync]

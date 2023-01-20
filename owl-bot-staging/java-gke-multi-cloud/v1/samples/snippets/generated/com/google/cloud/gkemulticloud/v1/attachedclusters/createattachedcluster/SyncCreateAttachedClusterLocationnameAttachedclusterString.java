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

package com.google.cloud.gkemulticloud.v1.samples;

// [START gkemulticloud_v1_generated_AttachedClusters_CreateAttachedCluster_LocationnameAttachedclusterString_sync]
import com.google.cloud.gkemulticloud.v1.AttachedCluster;
import com.google.cloud.gkemulticloud.v1.AttachedClustersClient;
import com.google.cloud.gkemulticloud.v1.LocationName;

public class SyncCreateAttachedClusterLocationnameAttachedclusterString {

  public static void main(String[] args) throws Exception {
    syncCreateAttachedClusterLocationnameAttachedclusterString();
  }

  public static void syncCreateAttachedClusterLocationnameAttachedclusterString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
      String attachedClusterId = "attachedClusterId865943409";
      AttachedCluster response =
          attachedClustersClient
              .createAttachedClusterAsync(parent, attachedCluster, attachedClusterId)
              .get();
    }
  }
}
// [END gkemulticloud_v1_generated_AttachedClusters_CreateAttachedCluster_LocationnameAttachedclusterString_sync]

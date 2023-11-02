/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.workstations.v1.samples;

// [START workstations_v1_generated_Workstations_CreateWorkstationCluster_LocationnameWorkstationclusterString_sync]
import com.google.cloud.workstations.v1.LocationName;
import com.google.cloud.workstations.v1.WorkstationCluster;
import com.google.cloud.workstations.v1.WorkstationsClient;

public class SyncCreateWorkstationClusterLocationnameWorkstationclusterString {

  public static void main(String[] args) throws Exception {
    syncCreateWorkstationClusterLocationnameWorkstationclusterString();
  }

  public static void syncCreateWorkstationClusterLocationnameWorkstationclusterString()
      throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
      String workstationClusterId = "workstationClusterId351421170";
      WorkstationCluster response =
          workstationsClient
              .createWorkstationClusterAsync(parent, workstationCluster, workstationClusterId)
              .get();
    }
  }
}
// [END workstations_v1_generated_Workstations_CreateWorkstationCluster_LocationnameWorkstationclusterString_sync]

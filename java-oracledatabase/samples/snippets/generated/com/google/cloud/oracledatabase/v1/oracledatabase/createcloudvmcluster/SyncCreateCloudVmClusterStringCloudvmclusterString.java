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

package com.google.cloud.oracledatabase.v1.samples;

// [START oracledatabase_v1_generated_OracleDatabase_CreateCloudVmCluster_StringCloudvmclusterString_sync]
import com.google.cloud.oracledatabase.v1.CloudVmCluster;
import com.google.cloud.oracledatabase.v1.LocationName;
import com.google.cloud.oracledatabase.v1.OracleDatabaseClient;

public class SyncCreateCloudVmClusterStringCloudvmclusterString {

  public static void main(String[] args) throws Exception {
    syncCreateCloudVmClusterStringCloudvmclusterString();
  }

  public static void syncCreateCloudVmClusterStringCloudvmclusterString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
      String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
      CloudVmCluster cloudVmCluster = CloudVmCluster.newBuilder().build();
      String cloudVmClusterId = "cloudVmClusterId-1217103287";
      CloudVmCluster response =
          oracleDatabaseClient
              .createCloudVmClusterAsync(parent, cloudVmCluster, cloudVmClusterId)
              .get();
    }
  }
}
// [END oracledatabase_v1_generated_OracleDatabase_CreateCloudVmCluster_StringCloudvmclusterString_sync]

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

package com.google.cloud.biglake.hive.v1beta.samples;

// [START biglake_v1beta_generated_HiveMetastoreService_CreateHiveCatalog_sync]
import com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.HiveCatalog;
import com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient;
import com.google.cloud.biglake.hive.v1beta.ProjectName;

public class SyncCreateHiveCatalog {

  public static void main(String[] args) throws Exception {
    syncCreateHiveCatalog();
  }

  public static void syncCreateHiveCatalog() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
        HiveMetastoreServiceClient.create()) {
      CreateHiveCatalogRequest request =
          CreateHiveCatalogRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setHiveCatalog(HiveCatalog.newBuilder().build())
              .setHiveCatalogId("hiveCatalogId-575314556")
              .setPrimaryLocation("primaryLocation-1140723753")
              .build();
      HiveCatalog response = hiveMetastoreServiceClient.createHiveCatalog(request);
    }
  }
}
// [END biglake_v1beta_generated_HiveMetastoreService_CreateHiveCatalog_sync]

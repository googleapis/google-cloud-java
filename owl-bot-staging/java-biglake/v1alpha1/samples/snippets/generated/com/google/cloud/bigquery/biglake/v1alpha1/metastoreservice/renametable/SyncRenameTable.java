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

package com.google.cloud.bigquery.biglake.v1alpha1.samples;

// [START biglake_v1alpha1_generated_MetastoreService_RenameTable_sync]
import com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceClient;
import com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest;
import com.google.cloud.bigquery.biglake.v1alpha1.Table;
import com.google.cloud.bigquery.biglake.v1alpha1.TableName;

public class SyncRenameTable {

  public static void main(String[] args) throws Exception {
    syncRenameTable();
  }

  public static void syncRenameTable() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
      RenameTableRequest request =
          RenameTableRequest.newBuilder()
              .setName(
                  TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
                      .toString())
              .setNewName(
                  TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
                      .toString())
              .build();
      Table response = metastoreServiceClient.renameTable(request);
    }
  }
}
// [END biglake_v1alpha1_generated_MetastoreService_RenameTable_sync]

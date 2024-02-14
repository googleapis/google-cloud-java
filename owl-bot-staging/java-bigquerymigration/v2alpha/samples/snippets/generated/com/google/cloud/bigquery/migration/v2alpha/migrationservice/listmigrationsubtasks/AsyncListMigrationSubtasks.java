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

package com.google.cloud.bigquery.migration.v2alpha.samples;

// [START bigquerymigration_v2alpha_generated_MigrationService_ListMigrationSubtasks_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksRequest;
import com.google.cloud.bigquery.migration.v2alpha.MigrationServiceClient;
import com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask;
import com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflowName;
import com.google.protobuf.FieldMask;

public class AsyncListMigrationSubtasks {

  public static void main(String[] args) throws Exception {
    asyncListMigrationSubtasks();
  }

  public static void asyncListMigrationSubtasks() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
      ListMigrationSubtasksRequest request =
          ListMigrationSubtasksRequest.newBuilder()
              .setParent(
                  MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
              .setReadMask(FieldMask.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      ApiFuture<MigrationSubtask> future =
          migrationServiceClient.listMigrationSubtasksPagedCallable().futureCall(request);
      // Do something.
      for (MigrationSubtask element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END bigquerymigration_v2alpha_generated_MigrationService_ListMigrationSubtasks_async]

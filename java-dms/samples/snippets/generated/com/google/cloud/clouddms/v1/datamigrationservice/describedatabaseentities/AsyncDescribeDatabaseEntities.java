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

package com.google.cloud.clouddms.v1.samples;

// [START datamigration_v1_generated_DataMigrationService_DescribeDatabaseEntities_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.clouddms.v1.ConversionWorkspaceName;
import com.google.cloud.clouddms.v1.DataMigrationServiceClient;
import com.google.cloud.clouddms.v1.DatabaseEntity;
import com.google.cloud.clouddms.v1.DatabaseEntityView;
import com.google.cloud.clouddms.v1.DescribeDatabaseEntitiesRequest;

public class AsyncDescribeDatabaseEntities {

  public static void main(String[] args) throws Exception {
    asyncDescribeDatabaseEntities();
  }

  public static void asyncDescribeDatabaseEntities() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataMigrationServiceClient dataMigrationServiceClient =
        DataMigrationServiceClient.create()) {
      DescribeDatabaseEntitiesRequest request =
          DescribeDatabaseEntitiesRequest.newBuilder()
              .setConversionWorkspace(
                  ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setUncommitted(true)
              .setCommitId("commitId-602292046")
              .setFilter("filter-1274492040")
              .setView(DatabaseEntityView.forNumber(0))
              .build();
      ApiFuture<DatabaseEntity> future =
          dataMigrationServiceClient.describeDatabaseEntitiesPagedCallable().futureCall(request);
      // Do something.
      for (DatabaseEntity element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END datamigration_v1_generated_DataMigrationService_DescribeDatabaseEntities_async]

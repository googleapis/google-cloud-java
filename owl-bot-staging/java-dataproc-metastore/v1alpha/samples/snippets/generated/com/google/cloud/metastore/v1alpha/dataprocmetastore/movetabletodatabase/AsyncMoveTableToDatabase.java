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

package com.google.cloud.metastore.v1alpha.samples;

// [START metastore_v1alpha_generated_DataprocMetastore_MoveTableToDatabase_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.metastore.v1alpha.DataprocMetastoreClient;
import com.google.cloud.metastore.v1alpha.MoveTableToDatabaseRequest;
import com.google.cloud.metastore.v1alpha.ServiceName;
import com.google.longrunning.Operation;

public class AsyncMoveTableToDatabase {

  public static void main(String[] args) throws Exception {
    asyncMoveTableToDatabase();
  }

  public static void asyncMoveTableToDatabase() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
      MoveTableToDatabaseRequest request =
          MoveTableToDatabaseRequest.newBuilder()
              .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
              .setTableName("tableName-1988717703")
              .setDbName("dbName-1339126743")
              .setDestinationDbName("destinationDbName-2077361705")
              .build();
      ApiFuture<Operation> future =
          dataprocMetastoreClient.moveTableToDatabaseCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END metastore_v1alpha_generated_DataprocMetastore_MoveTableToDatabase_async]

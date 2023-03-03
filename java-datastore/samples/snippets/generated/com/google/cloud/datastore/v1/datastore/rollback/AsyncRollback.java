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

package com.google.cloud.datastore.v1.samples;

// [START datastore_v1_generated_Datastore_Rollback_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.datastore.v1.DatastoreClient;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.protobuf.ByteString;

public class AsyncRollback {

  public static void main(String[] args) throws Exception {
    asyncRollback();
  }

  public static void asyncRollback() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DatastoreClient datastoreClient = DatastoreClient.create()) {
      RollbackRequest request =
          RollbackRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setDatabaseId("databaseId1688905718")
              .setTransaction(ByteString.EMPTY)
              .build();
      ApiFuture<RollbackResponse> future = datastoreClient.rollbackCallable().futureCall(request);
      // Do something.
      RollbackResponse response = future.get();
    }
  }
}
// [END datastore_v1_generated_Datastore_Rollback_async]

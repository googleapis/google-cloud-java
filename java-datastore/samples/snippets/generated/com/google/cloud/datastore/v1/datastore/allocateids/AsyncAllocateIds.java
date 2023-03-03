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

// [START datastore_v1_generated_Datastore_AllocateIds_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.datastore.v1.DatastoreClient;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.Key;
import java.util.ArrayList;

public class AsyncAllocateIds {

  public static void main(String[] args) throws Exception {
    asyncAllocateIds();
  }

  public static void asyncAllocateIds() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DatastoreClient datastoreClient = DatastoreClient.create()) {
      AllocateIdsRequest request =
          AllocateIdsRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setDatabaseId("databaseId1688905718")
              .addAllKeys(new ArrayList<Key>())
              .build();
      ApiFuture<AllocateIdsResponse> future =
          datastoreClient.allocateIdsCallable().futureCall(request);
      // Do something.
      AllocateIdsResponse response = future.get();
    }
  }
}
// [END datastore_v1_generated_Datastore_AllocateIds_async]

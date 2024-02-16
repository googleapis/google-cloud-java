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

package com.google.cloud.discoveryengine.v1.samples;

// [START discoveryengine_v1_generated_DataStoreService_UpdateDataStore_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.discoveryengine.v1.DataStore;
import com.google.cloud.discoveryengine.v1.DataStoreServiceClient;
import com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateDataStore {

  public static void main(String[] args) throws Exception {
    asyncUpdateDataStore();
  }

  public static void asyncUpdateDataStore() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
      UpdateDataStoreRequest request =
          UpdateDataStoreRequest.newBuilder()
              .setDataStore(DataStore.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      ApiFuture<DataStore> future =
          dataStoreServiceClient.updateDataStoreCallable().futureCall(request);
      // Do something.
      DataStore response = future.get();
    }
  }
}
// [END discoveryengine_v1_generated_DataStoreService_UpdateDataStore_async]

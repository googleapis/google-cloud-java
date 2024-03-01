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

package com.google.cloud.netapp.v1.samples;

// [START netapp_v1_generated_NetApp_CreateStoragePool_sync]
import com.google.cloud.netapp.v1.CreateStoragePoolRequest;
import com.google.cloud.netapp.v1.LocationName;
import com.google.cloud.netapp.v1.NetAppClient;
import com.google.cloud.netapp.v1.StoragePool;

public class SyncCreateStoragePool {

  public static void main(String[] args) throws Exception {
    syncCreateStoragePool();
  }

  public static void syncCreateStoragePool() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NetAppClient netAppClient = NetAppClient.create()) {
      CreateStoragePoolRequest request =
          CreateStoragePoolRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setStoragePoolId("storagePoolId1617506482")
              .setStoragePool(StoragePool.newBuilder().build())
              .build();
      StoragePool response = netAppClient.createStoragePoolAsync(request).get();
    }
  }
}
// [END netapp_v1_generated_NetApp_CreateStoragePool_sync]

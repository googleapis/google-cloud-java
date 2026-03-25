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

package com.google.storage.v2.samples;

// [START storage_v2_generated_Storage_GetObject_StringStringLong_sync]
import com.google.storage.v2.Object;
import com.google.storage.v2.StorageClient;

public class SyncGetObjectStringStringLong {

  public static void main(String[] args) throws Exception {
    syncGetObjectStringStringLong();
  }

  public static void syncGetObjectStringStringLong() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (StorageClient storageClient = StorageClient.create()) {
      String bucket = "bucket-1378203158";
      String object = "object-1023368385";
      long generation = 305703192;
      Object response = storageClient.getObject(bucket, object, generation);
    }
  }
}
// [END storage_v2_generated_Storage_GetObject_StringStringLong_sync]

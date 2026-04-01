/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.storage;

// [START storage_control_quickstart_sample]
import com.google.storage.control.v2.GetStorageLayoutRequest;
import com.google.storage.control.v2.StorageControlClient;
import com.google.storage.control.v2.StorageLayout;
import com.google.storage.control.v2.StorageLayoutName;

public class QuickstartStorageControlSample {
  public static void main(String... args) throws Exception {
    String bucketName = args[0]; // "your-bucket-name";

    // Instantiates a client in a try-with-resource to automatically cleanup underlying resources
    try (StorageControlClient storageControlClient = StorageControlClient.create()) {
      GetStorageLayoutRequest request =
          GetStorageLayoutRequest.newBuilder()
              // Set project to "_" to signify global bucket
              .setName(StorageLayoutName.format("_", bucketName))
              .build();
      StorageLayout response = storageControlClient.getStorageLayout(request);
      System.out.printf("Performed getStorageLayout request for %s%n", response.getName());
    }
  }
}
// [END storage_control_quickstart_sample]

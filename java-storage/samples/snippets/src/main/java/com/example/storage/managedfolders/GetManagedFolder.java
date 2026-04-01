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

package com.example.storage.managedfolders;

// [START storage_control_managed_folder_get]

import com.google.storage.control.v2.BucketName;
import com.google.storage.control.v2.GetManagedFolderRequest;
import com.google.storage.control.v2.ManagedFolder;
import com.google.storage.control.v2.ManagedFolderName;
import com.google.storage.control.v2.StorageControlClient;

class GetManagedFolder {

  public static void managedFolderGet(String bucketName, String managedFolderId) throws Exception {
    // Instantiates a client in a try-with-resource to automatically cleanup underlying resources
    try (StorageControlClient storageControlClient = StorageControlClient.create()) {
      // Set project to "_" to signify global bucket
      BucketName resourceBucketName = BucketName.of("_", bucketName);
      GetManagedFolderRequest getManagedFolderRequest =
          GetManagedFolderRequest.newBuilder()
              .setName(
                  ManagedFolderName.format(
                      resourceBucketName.getProject(),
                      resourceBucketName.getBucket(),
                      managedFolderId))
              .build();
      ManagedFolder managedFolder = storageControlClient.getManagedFolder(getManagedFolderRequest);
      System.out.printf("Got Managed Folder %s%n", managedFolder.getName());
    }
  }
}

// [END storage_control_managed_folder_get]

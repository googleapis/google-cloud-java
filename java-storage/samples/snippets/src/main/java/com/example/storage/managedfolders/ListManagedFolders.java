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

// [START storage_control_managed_folder_list]

import com.google.storage.control.v2.BucketName;
import com.google.storage.control.v2.ListManagedFoldersRequest;
import com.google.storage.control.v2.ManagedFolder;
import com.google.storage.control.v2.StorageControlClient;

class ListManagedFolders {

  public static void managedFolderList(String bucketName) throws Exception {
    // Instantiates a client in a try-with-resource to automatically cleanup underlying resources
    try (StorageControlClient storageControlClient = StorageControlClient.create()) {
      ListManagedFoldersRequest listManagedFoldersRequest =
          ListManagedFoldersRequest.newBuilder()
              // Set project to "_" to signify global bucket
              .setParent(BucketName.format("_", bucketName))
              .build();
      Iterable<ManagedFolder> managedFolders =
          storageControlClient.listManagedFolders(listManagedFoldersRequest).iterateAll();
      for (ManagedFolder folder : managedFolders) {
        System.out.printf("%s bucket has managed folder %s%n", bucketName, folder.getName());
      }
    }
  }
}

// [END storage_control_managed_folder_list]

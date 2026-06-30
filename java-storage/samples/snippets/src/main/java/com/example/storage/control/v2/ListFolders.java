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

package com.example.storage.control.v2;

// [START storage_control_list_folders]

import com.google.storage.control.v2.BucketName;
import com.google.storage.control.v2.Folder;
import com.google.storage.control.v2.ListFoldersRequest;
import com.google.storage.control.v2.StorageControlClient;
import java.io.IOException;

public final class ListFolders {

  public static void listFolders(String bucketName) throws IOException {
    // The name of the bucket
    // String bucketName = "your-unique-bucket-name";

    try (StorageControlClient storageControl = StorageControlClient.create()) {

      ListFoldersRequest request =
          ListFoldersRequest.newBuilder()
              // Set project to "_" to signify globally scoped bucket
              .setParent(BucketName.format("_", bucketName))
              .build();

      Iterable<Folder> folders = storageControl.listFolders(request).iterateAll();
      for (Folder folder : folders) {
        System.out.printf("Found folder: %s%n", folder.getName());
      }
    }
  }
}
// [END storage_control_list_folders]

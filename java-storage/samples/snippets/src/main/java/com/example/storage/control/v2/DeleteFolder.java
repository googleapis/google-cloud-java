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

// [START storage_control_delete_folder]

import com.google.storage.control.v2.DeleteFolderRequest;
import com.google.storage.control.v2.FolderName;
import com.google.storage.control.v2.StorageControlClient;
import java.io.IOException;

public final class DeleteFolder {

  public static void deleteFolder(String bucketName, String folderName) throws IOException {
    // The name of the bucket
    // String bucketName = "your-unique-bucket-name";

    // The name of the folder within the bucket
    // String folderName = "your-unique-folder-name";

    try (StorageControlClient storageControl = StorageControlClient.create()) {

      // Set project to "_" to signify globally scoped bucket
      String folderResourceName = FolderName.format("_", bucketName, folderName);
      DeleteFolderRequest request =
          DeleteFolderRequest.newBuilder().setName(folderResourceName).build();

      storageControl.deleteFolder(request);

      System.out.printf("Deleted folder: %s%n", folderResourceName);
    }
  }
}
// [END storage_control_delete_folder]

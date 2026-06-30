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

// [START storage_control_rename_folder]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.storage.control.v2.Folder;
import com.google.storage.control.v2.FolderName;
import com.google.storage.control.v2.RenameFolderMetadata;
import com.google.storage.control.v2.RenameFolderRequest;
import com.google.storage.control.v2.StorageControlClient;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class RenameFolder {

  public static void renameFolder(
      String bucketName, String sourceFolderName, String destinationFolderName)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // The name of the bucket
    // String bucketName = "your-unique-bucket-name";

    // The name of the folder within the bucket
    // String sourceFolderName = "your-unique-source-folder-name";

    // The new name of the folder within the bucket
    // String destinationFolderName = "your-unique-destination-folder-name";

    try (StorageControlClient storageControl = StorageControlClient.create()) {

      // Set project to "_" to signify globally scoped bucket
      String sourceFolderResourceName = FolderName.format("_", bucketName, sourceFolderName);
      RenameFolderRequest request =
          RenameFolderRequest.newBuilder()
              .setName(sourceFolderResourceName)
              .setDestinationFolderId(destinationFolderName)
              .build();

      OperationFuture<Folder, RenameFolderMetadata> renameOperation =
          storageControl.renameFolderAsync(request);

      Folder destinationFolder = renameOperation.get(30, TimeUnit.SECONDS);

      System.out.printf(
          "Renamed folder from %s to %s%n", sourceFolderResourceName, destinationFolder.getName());
    }
  }
}
// [END storage_control_rename_folder]

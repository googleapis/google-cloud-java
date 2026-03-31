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

package com.example.storage.transfermanager;

// [START storage_transfer_manager_upload_directory]
import com.google.cloud.storage.transfermanager.ParallelUploadConfig;
import com.google.cloud.storage.transfermanager.TransferManager;
import com.google.cloud.storage.transfermanager.TransferManagerConfig;
import com.google.cloud.storage.transfermanager.UploadResult;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class UploadDirectory {

  public static void uploadDirectoryContents(String bucketName, Path sourceDirectory)
      throws IOException {
    TransferManager transferManager = TransferManagerConfig.newBuilder().build().getService();
    ParallelUploadConfig parallelUploadConfig =
        ParallelUploadConfig.newBuilder().setBucketName(bucketName).build();

    // Create a list to store the file paths
    List<Path> filePaths = new ArrayList<>();
    // Get all files in the directory
    // try-with-resource to ensure pathStream is closed
    try (Stream<Path> pathStream = Files.walk(sourceDirectory)) {
      pathStream.filter(Files::isRegularFile).forEach(filePaths::add);
    }
    List<UploadResult> results =
        transferManager.uploadFiles(filePaths, parallelUploadConfig).getUploadResults();
    for (UploadResult result : results) {
      System.out.println(
          "Upload for "
              + result.getInput().getName()
              + " completed with status "
              + result.getStatus());
    }
  }
}
// [END storage_transfer_manager_upload_directory]

/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.example.storage.transfermanager;

// [START storage_transfer_manager_download_chunks_concurrently]
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.transfermanager.DownloadResult;
import com.google.cloud.storage.transfermanager.ParallelDownloadConfig;
import com.google.cloud.storage.transfermanager.TransferManager;
import com.google.cloud.storage.transfermanager.TransferManagerConfig;
import java.nio.file.Path;
import java.util.List;

class AllowDivideAndConquerDownload {

  public static void divideAndConquerDownloadAllowed(
      List<BlobInfo> blobs, String bucketName, Path destinationDirectory) {
    TransferManager transferManager =
        TransferManagerConfig.newBuilder()
            .setAllowDivideAndConquerDownload(true)
            .build()
            .getService();
    ParallelDownloadConfig parallelDownloadConfig =
        ParallelDownloadConfig.newBuilder()
            .setBucketName(bucketName)
            .setDownloadDirectory(destinationDirectory)
            .build();
    List<DownloadResult> results =
        transferManager.downloadBlobs(blobs, parallelDownloadConfig).getDownloadResults();

    for (DownloadResult result : results) {
      System.out.println(
          "Download of "
              + result.getInput().getName()
              + " completed with status "
              + result.getStatus());
    }
  }
}
// [END storage_transfer_manager_download_chunks_concurrently]

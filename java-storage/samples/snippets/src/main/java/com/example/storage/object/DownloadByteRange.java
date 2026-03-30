/*
 * Copyright 2022 Google LLC
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

package com.example.storage.object;

// [START storage_download_byte_range]

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DownloadByteRange {

  public static void downloadByteRange(
      String projectId,
      String bucketName,
      String blobName,
      long startByte,
      long endBytes,
      String destFileName)
      throws IOException {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The name of the blob/file that you wish to modify permissions on
    // String blobName = "your-blob-name";

    // The starting byte at which to begin the download
    // long startByte = 0;

    // The ending byte at which to end the download
    // long endByte = 20;

    // The path to which the file should be downloaded
    // String destFileName = '/local/path/to/file.txt';

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    BlobId blobId = BlobId.of(bucketName, blobName);
    try (ReadChannel from = storage.reader(blobId);
        FileChannel to = FileChannel.open(Paths.get(destFileName), StandardOpenOption.WRITE)) {
      from.seek(startByte);
      from.limit(endBytes);

      ByteStreams.copy(from, to);

      System.out.printf(
          "%s downloaded to %s from byte %d to byte %d%n",
          blobId.toGsUtilUri(), destFileName, startByte, endBytes);
    }
  }
}
// [END storage_download_byte_range]

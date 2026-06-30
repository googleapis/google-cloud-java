/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.storage.object;

// [START storage_download_file]

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.nio.file.Paths;

public class DownloadObject {
  public static void downloadObject(
      String projectId, String bucketName, String objectName, String destFilePath)
      throws Exception {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The path to which the file should be downloaded
    // String destFilePath = "/local/path/to/file.txt";

    StorageOptions storageOptions = StorageOptions.newBuilder().setProjectId(projectId).build();
    try (Storage storage = storageOptions.getService()) {

      storage.downloadTo(BlobId.of(bucketName, objectName), Paths.get(destFilePath));

      System.out.println(
          "Downloaded object "
              + objectName
              + " from bucket name "
              + bucketName
              + " to "
              + destFilePath);
    }
  }
}
// [END storage_download_file]

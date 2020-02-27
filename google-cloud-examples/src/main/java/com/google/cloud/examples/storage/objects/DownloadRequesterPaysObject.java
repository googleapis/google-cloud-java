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
package com.google.cloud.examples.storage.objects;

// [START storage_download_file_requester_pays]
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.nio.file.Path;

public class DownloadRequesterPaysObject {
  public static void downloadRequesterPaysObject(
      String projectId, String bucketName, String objectName, Path destFilePath) {
    // The project ID to bill
    // String projectId = "my-billable-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The path to which the file should be downloaded
    // Path destFilePath = Paths.get("/local/path/to/file.txt");

    Storage storage = StorageOptions.getDefaultInstance().getService();
    Blob blob = storage.get(BlobId.of(bucketName, objectName));
    blob.downloadTo(destFilePath, Blob.BlobSourceOption.userProject(projectId));

    System.out.println(
        "Object " + objectName + " downloaded to " + destFilePath + " and billed to " + projectId);
  }
}
// [START storage_download_file_requester_pays]

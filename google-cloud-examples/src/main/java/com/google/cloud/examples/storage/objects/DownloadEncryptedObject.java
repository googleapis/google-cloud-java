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

// [START storage_download_encrypted_file]
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import java.nio.file.Path;

public class DownloadEncryptedObject {
  public static void downloadEncryptedObject(
      String projectId,
      String bucketName,
      String objectName,
      Path destFilePath,
      String decryptionKey)
      throws IOException {

    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The path to which the file should be downloaded
    // Path destFilePath = Paths.get("/local/path/to/file.txt");

    // The Base64 encoded decryption key, which should be the same key originally used to encrypt
    // the object
    // String decryptionKey = "TIbv/fjexq+VmtXzAlc63J4z5kFmWJ6NdAPQulQBT7g=";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    Blob blob = storage.get(bucketName, objectName);
    blob.downloadTo(destFilePath, Blob.BlobSourceOption.decryptionKey(decryptionKey));

    System.out.println(
        "Downloaded object "
            + objectName
            + " from bucket name "
            + bucketName
            + " to "
            + destFilePath
            + " using customer-supplied encryption key");
  }
}
// [END storage_download_encrypted_file]

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

// [START storage_upload_encrypted_file]
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UploadEncryptedObject {
  public static void uploadEncryptedObject(
      String projectId, String bucketName, String objectName, String filePath, String encryptionKey)
      throws IOException {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The path to your file to upload
    // String filePath = "path/to/your/file"

    // The key to encrypt the object with
    // String encryptionKey = "TIbv/fjexq+VmtXzAlc63J4z5kFmWJ6NdAPQulQBT7g=";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    BlobId blobId = BlobId.of(bucketName, objectName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
    storage.create(
        blobInfo,
        Files.readAllBytes(Paths.get(filePath)),
        Storage.BlobTargetOption.encryptionKey(encryptionKey));

    System.out.println(
        "File "
            + filePath
            + " uploaded to bucket "
            + bucketName
            + " as "
            + objectName
            + " with supplied encryption key");
  }
}
// [END storage_upload_encrypted_file]

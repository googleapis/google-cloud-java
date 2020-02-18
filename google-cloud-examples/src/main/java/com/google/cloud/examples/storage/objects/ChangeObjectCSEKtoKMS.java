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

// [START storage_object_csek_to_cmek]
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class ChangeObjectCSEKtoKMS {
  public static void changeObjectFromCSEKtoKMS(
      String projectId,
      String bucketName,
      String objectName,
      String decryptionKey,
      String kmsKeyName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The Base64 encoded decryption key, which should be the same key originally used to encrypt
    // the object
    // String decryptionKey = "TIbv/fjexq+VmtXzAlc63J4z5kFmWJ6NdAPQulQBT7g=";

    // The name of the KMS key to manage this object with
    // String kmsKeyName =
    // "projects/your-project-id/locations/global/keyRings/your-key-ring/cryptoKeys/your-key";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    BlobId blobId = BlobId.of(bucketName, objectName);
    Storage.CopyRequest request =
        Storage.CopyRequest.newBuilder()
            .setSource(blobId)
            .setSourceOptions(Storage.BlobSourceOption.decryptionKey(decryptionKey))
            .setTarget(blobId, Storage.BlobTargetOption.kmsKeyName(kmsKeyName))
            .build();
    storage.copy(request);

    System.out.println(
        "Object "
            + objectName
            + " in bucket "
            + bucketName
            + " is now managed by the KMS key "
            + kmsKeyName
            + " instead of a customer-supplied encryption key");
  }
}
// [END storage_object_csek_to_cmek]

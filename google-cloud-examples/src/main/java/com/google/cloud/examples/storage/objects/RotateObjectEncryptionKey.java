/*
 * Copyright 2019 Google LLC
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

// [START storate_rotate_encryption_key]
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class RotateObjectEncryptionKey {
  public static void rotateObjectEncryptionKey(
      String projectId,
      String bucketName,
      String objectName,
      String oldEncryptionKey,
      String newEncryptionKey) {
    // String projectId = "your-project-id";
    // String bucketName = "your-unique-bucket-name";
    // String objectName = "your-object-name"
    // String oldEncyrptionKey = "old-encryption-key-to-rotate"
    // String newEncryptionKey = "new-encryption-key-to-set"
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    BlobId blobId = BlobId.of(bucketName, objectName);
    // You can't change an object's encryption key directly, the only way is to overwrite the object
    Storage.CopyRequest request =
        Storage.CopyRequest.newBuilder()
            .setSource(blobId)
            .setSourceOptions(Storage.BlobSourceOption.decryptionKey(oldEncryptionKey))
            .setTarget(blobId, Storage.BlobTargetOption.encryptionKey(newEncryptionKey))
            .build();
    storage.copy(request);
    System.out.println("Rotated encryption key for object " + objectName + "in bucket " + bucketName);
  }
}
// [END storate_rotate_encryption_key]

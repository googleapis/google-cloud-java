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

// [START storage_rotate_encryption_key]
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
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The Base64 encoded AES-256 encryption key originally used to encrypt the object. See the
    // documentation
    // on Customer-Supplied Encryption keys for more info:
    // https://cloud.google.com/storage/docs/encryption/using-customer-supplied-keys
    // String oldEncryptionKey = "TIbv/fjexq+VmtXzAlc63J4z5kFmWJ6NdAPQulQBT7g="

    // The new encryption key to use
    // String newEncryptionKey = "0mMWhFvQOdS4AmxRpo8SJxXn5MjFhbz7DkKBUdUIef8="

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

    System.out.println(
        "Rotated encryption key for object " + objectName + "in bucket " + bucketName);
  }
}
// [END storage_rotate_encryption_key]

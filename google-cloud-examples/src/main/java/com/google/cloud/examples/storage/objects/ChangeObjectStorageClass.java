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

// [START storage_change_file_storage_class]
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.CopyWriter;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageOptions;

public class ChangeObjectStorageClass {
  public static void changeObjectStorageClass(
      String projectId, String bucketName, String objectName) {
    // String projectId = "your-project-id";
    // String bucketName = "your-unique-bucket-name";
    // String objectName = "your-object-name"
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    BlobId blobId = BlobId.of(bucketName, objectName);
    StorageClass storageClass = StorageClass.COLDLINE; // See class for other values
    // You can't change an object's storage class directly, the only way is to overwrite the object
    Storage.CopyRequest request = Storage.CopyRequest
            .newBuilder()
            .setSource(blobId)
            .setTarget(BlobInfo.newBuilder(blobId).setStorageClass(storageClass).build())
            .build();
    CopyWriter copyWriter = storage.copy(request);
    Blob updatedBlob = copyWriter.getResult();
    System.out.println(
        "Object "
            + objectName
            + " in bucket "
            + bucketName
            + " had its storage class set to "
            + updatedBlob.getStorageClass().name());
  }
}
// [END storage_change_file_storage_class]
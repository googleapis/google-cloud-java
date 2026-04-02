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

// [START storage_change_file_storage_class]
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageOptions;

public class ChangeObjectStorageClass {
  public static void changeObjectStorageClass(
      String projectId, String bucketName, String objectName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    BlobId blobId = BlobId.of(bucketName, objectName);
    Blob sourceBlob = storage.get(blobId);
    if (sourceBlob == null) {
      System.out.println("The object " + objectName + " wasn't found in " + bucketName);
      return;
    }

    // See the StorageClass documentation for other valid storage classes:
    // https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/storage/StorageClass.html
    StorageClass storageClass = StorageClass.COLDLINE;

    // You can't change an object's storage class directly, the only way is to rewrite the object
    // with the desired storage class

    BlobInfo targetBlob = BlobInfo.newBuilder(blobId).setStorageClass(storageClass).build();

    // Optional: set a generation-match precondition to avoid potential race
    // conditions and data corruptions. The request to upload returns a 412 error if
    // the object's generation number does not match your precondition.
    Storage.BlobSourceOption precondition =
        Storage.BlobSourceOption.generationMatch(sourceBlob.getGeneration());

    Storage.CopyRequest request =
        Storage.CopyRequest.newBuilder()
            .setSource(blobId)
            .setSourceOptions(precondition) // delete this line to run without preconditions
            .setTarget(targetBlob)
            .build();
    Blob updatedBlob = storage.copy(request).getResult();

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

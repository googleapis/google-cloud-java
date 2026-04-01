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

// [START storage_delete_file]
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class DeleteObject {
  public static void deleteObject(String projectId, String bucketName, String objectName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Blob blob = storage.get(bucketName, objectName);
    if (blob == null) {
      System.out.println("The object " + objectName + " wasn't found in " + bucketName);
      return;
    }
    BlobId idWithGeneration = blob.getBlobId();
    // Deletes the blob specified by its id. When the generation is present and non-null it will be
    // specified in the request.
    // If versioning is enabled on the bucket and the generation is present in the delete request,
    // only the version of the object with the matching generation will be deleted.
    // If instead you want to delete the current version, the generation should be dropped by
    // performing the following.
    // BlobId idWithoutGeneration =
    //    BlobId.of(idWithGeneration.getBucket(), idWithGeneration.getName());
    // storage.delete(idWithoutGeneration);
    storage.delete(idWithGeneration);

    System.out.println("Object " + objectName + " was permanently deleted from " + bucketName);
  }
}
// [END storage_delete_file]

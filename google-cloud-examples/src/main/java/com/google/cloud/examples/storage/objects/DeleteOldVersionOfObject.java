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

// [START storage_delete_file_archived_generation]
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class DeleteOldVersionOfObject {
  public static void deleteOldVersionOfObject(
      String projectId, String bucketName, String objectName, long generationToDelete) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The generation of objectName to delete
    // long generationToDelete = 1579287380533984;

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    storage.delete(BlobId.of(bucketName, objectName, generationToDelete));

    System.out.println(
        "Generation "
            + generationToDelete
            + " of object "
            + objectName
            + " was deleted from "
            + bucketName);
  }
}
// [END storage_delete_file_archived_generation]

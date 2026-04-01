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

// [START storage_copy_file_archived_generation]
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class CopyOldVersionOfObject {
  public static void copyOldVersionOfObject(
      String projectId,
      String bucketName,
      String objectToCopy,
      long generationToCopy,
      String newObjectName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of the GCS object to copy an old version of
    // String objectToCopy = "your-object-name";

    // The generation of objectToCopy to copy
    // long generationToCopy = 1579287380533984;

    // What to name the new object with the old data from objectToCopy
    // String newObjectName = "your-new-object";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    // Optional: set a generation-match precondition to avoid potential race
    // conditions and data corruptions. The request returns a 412 error if the
    // preconditions are not met.
    Storage.BlobTargetOption precondition;
    if (storage.get(bucketName, newObjectName) == null) {
      // For a target object that does not yet exist, set the DoesNotExist precondition.
      // This will cause the request to fail if the object is created before the request runs.
      precondition = Storage.BlobTargetOption.doesNotExist();
    } else {
      // If the destination already exists in your bucket, instead set a generation-match
      // precondition. This will cause the request to fail if the existing object's generation
      // changes before the request runs.
      precondition =
          Storage.BlobTargetOption.generationMatch(
              storage.get(bucketName, newObjectName).getGeneration());
    }

    Storage.CopyRequest copyRequest =
        Storage.CopyRequest.newBuilder()
            .setSource(BlobId.of(bucketName, objectToCopy, generationToCopy))
            .setTarget(BlobId.of(bucketName, newObjectName), precondition)
            .build();
    storage.copy(copyRequest);

    System.out.println(
        "Generation "
            + generationToCopy
            + " of object "
            + objectToCopy
            + " in bucket "
            + bucketName
            + " was copied to "
            + newObjectName);
  }
}
// [END storage_copy_file_archived_generation]

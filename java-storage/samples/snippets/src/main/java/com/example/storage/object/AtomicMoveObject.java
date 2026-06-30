/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.storage.object;

// [START storage_move_object]

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.MoveBlobRequest;
import com.google.cloud.storage.StorageOptions;

public final class AtomicMoveObject {

  public static void moveObject(
      String projectId, String bucketName, String sourceObjectName, String targetObjectName) {

    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String sourceObjectName = "your-object-name";

    // The ID of your GCS object
    // String targetObjectName = "your-new-object-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    BlobId source = BlobId.of(bucketName, sourceObjectName);
    BlobId target = BlobId.of(bucketName, targetObjectName);

    // Optional: set a generation-match precondition to avoid potential race
    // conditions and data corruptions. The request returns a 412 error if the
    // preconditions are not met.
    Storage.BlobTargetOption precondition;
    BlobInfo existingTarget = storage.get(target);
    if (existingTarget == null) {
      // For a target object that does not yet exist, set the DoesNotExist precondition.
      // This will cause the request to fail if the object is created before the request runs.
      precondition = Storage.BlobTargetOption.doesNotExist();
    } else {
      // If the destination already exists in your bucket, instead set a generation-match
      // precondition. This will cause the request to fail if the existing object's generation
      // changes before the request runs.
      precondition = Storage.BlobTargetOption.generationMatch(existingTarget.getGeneration());
    }

    // Atomically move source object to target object within the bucket
    MoveBlobRequest moveBlobRequest =
        MoveBlobRequest.newBuilder()
            .setSource(source)
            .setTarget(target)
            .setTargetOptions(precondition)
            .build();
    BlobInfo movedBlob = storage.moveBlob(moveBlobRequest);

    System.out.println(
        "Moved object "
            + source.toGsUtilUri()
            + " to "
            + movedBlob.getBlobId().toGsUtilUriWithGeneration());
  }
}
// [END storage_move_object]

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

// [START storage_copy_file]

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.CopyWriter;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.StorageOptions;

public class CopyObject {
  public static void copyObject(
      String projectId, String sourceBucketName, String objectName, String targetBucketName)
      throws Exception {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of the bucket the original object is in
    // String sourceBucketName = "your-source-bucket";

    // The ID of the GCS object to copy
    // String objectName = "your-object-name";

    // The ID of the bucket to copy the object to
    // String targetBucketName = "target-object-bucket";

    try (Storage storage =
        StorageOptions.newBuilder().setProjectId(projectId).build().getService()) {
      BlobId sourceId = BlobId.of(sourceBucketName, objectName);
      // you could change "objectName" to rename the object
      BlobId targetId = BlobId.of(targetBucketName, objectName);

      // Recommended: set a generation-match precondition to avoid potential race
      // conditions and data corruptions. The request returns a 412 error if the
      // preconditions are not met.
      Storage.BlobTargetOption precondition;
      BlobInfo existingTarget = storage.get(targetBucketName, objectName);
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

      CopyRequest copyRequest =
          CopyRequest.newBuilder()
              .setSource(sourceId)
              .setTarget(targetId, precondition)
              // limit the number of bytes Cloud Storage will attempt to copy before responding to
              // an individual request.
              // If you see Read Timeout errors, try reducing this value.
              .setMegabytesCopiedPerChunk(2048L) // 2GiB
              .build();
      CopyWriter copyWriter = storage.copy(copyRequest);
      BlobInfo successfulCopyResult = copyWriter.getResult();

      System.out.printf(
          "Copied object gs://%s/%s to %s%n",
          sourceBucketName,
          objectName,
          successfulCopyResult.getBlobId().toGsUtilUriWithGeneration());
    }
  }
}
// [END storage_copy_file]

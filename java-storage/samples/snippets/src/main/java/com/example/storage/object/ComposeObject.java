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

// [START storage_compose_file]
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class ComposeObject {
  public static void composeObject(
      String bucketName,
      String firstObjectName,
      String secondObjectName,
      String targetObjectName,
      String projectId) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of the first GCS object to compose
    // String firstObjectName = "your-first-object-name";

    // The ID of the second GCS object to compose
    // String secondObjectName = "your-second-object-name";

    // The ID to give the new composite object
    // String targetObjectName = "new-composite-object-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    // Optional: set a generation-match precondition to avoid potential race
    // conditions and data corruptions. The request returns a 412 error if the
    // preconditions are not met.
    Storage.BlobTargetOption precondition;
    if (storage.get(bucketName, targetObjectName) == null) {
      // For a target object that does not yet exist, set the DoesNotExist precondition.
      // This will cause the request to fail if the object is created before the request runs.
      precondition = Storage.BlobTargetOption.doesNotExist();
    } else {
      // If the destination already exists in your bucket, instead set a generation-match
      // precondition. This will cause the request to fail if the existing object's generation
      // changes before the request runs.
      precondition =
          Storage.BlobTargetOption.generationMatch(
              storage.get(bucketName, targetObjectName).getGeneration());
    }

    Storage.ComposeRequest composeRequest =
        Storage.ComposeRequest.newBuilder()
            // addSource takes varargs, so you can put as many objects here as you want, up to the
            // max of 32
            .addSource(firstObjectName, secondObjectName)
            .setTarget(BlobInfo.newBuilder(bucketName, targetObjectName).build())
            .setTargetOptions(precondition)
            .build();

    Blob compositeObject = storage.compose(composeRequest);

    System.out.println(
        "New composite object "
            + compositeObject.getName()
            + " was created by combining "
            + firstObjectName
            + " and "
            + secondObjectName);
  }
}
// [END storage_compose_file]

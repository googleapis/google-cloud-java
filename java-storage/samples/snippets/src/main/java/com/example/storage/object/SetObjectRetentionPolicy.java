/*
 * Copyright 2022 Google LLC
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

// [START storage_set_object_retention_policy]

import static java.time.OffsetDateTime.now;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo.Retention;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;

public class SetObjectRetentionPolicy {
  public static void setObjectRetentionPolicy(
      String projectId, String bucketName, String objectName) throws StorageException {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket that has object retention enabled
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    BlobId blobId = BlobId.of(bucketName, objectName);
    Blob blob = storage.get(blobId);
    if (blob == null) {
      System.out.println("The object " + objectName + " was not found in " + bucketName);
      return;
    }

    Blob updated =
        blob.toBuilder()
            .setRetention(
                Retention.newBuilder()
                    .setMode(Retention.Mode.UNLOCKED)
                    .setRetainUntilTime(now().plusDays(10))
                    .build())
            .build()
            .update();

    System.out.println("Retention policy for object " + objectName + " was set to:");
    System.out.println(updated.getRetention().toString());

    // To modify an existing policy on an Unlocked object, pass in the override parameter
    blob.toBuilder()
        .setRetention(
            updated.getRetention().toBuilder().setRetainUntilTime(now().plusDays(9)).build())
        .build()
        .update(Storage.BlobTargetOption.overrideUnlockedRetention(true));

    System.out.println("Retention policy for object " + objectName + " was updated to:");
    System.out.println(storage.get(blobId).getRetention().toString());
  }
}

// [END storage_set_object_retention_policy]

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

// [START storage_set_metadata]

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.HashMap;
import java.util.Map;

public class SetObjectMetadata {
  public static void setObjectMetadata(String projectId, String bucketName, String objectName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Map<String, String> newMetadata = new HashMap<>();
    newMetadata.put("keyToAddOrUpdate", "value");
    BlobId blobId = BlobId.of(bucketName, objectName);
    Blob blob = storage.get(blobId);
    if (blob == null) {
      System.out.println("The object " + objectName + " was not found in " + bucketName);
      return;
    }

    // Optional: set a generation-match precondition to avoid potential race
    // conditions and data corruptions. The request to upload returns a 412 error if
    // the object's generation number does not match your precondition.
    Storage.BlobTargetOption precondition = Storage.BlobTargetOption.generationMatch();

    // Does an upsert operation, if the key already exists it's replaced by the new value, otherwise
    // it's added.
    BlobInfo pendingUpdate = blob.toBuilder().setMetadata(newMetadata).build();
    storage.update(pendingUpdate, precondition);

    System.out.println(
        "Updated custom metadata for object " + objectName + " in bucket " + bucketName);
  }
}
// [END storage_set_metadata]

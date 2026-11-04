/*
 * Copyright 2026 Google LLC
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

// [START storage_delete_object_contexts]

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobInfo.ObjectContexts;
import com.google.cloud.storage.BlobInfo.ObjectCustomContextPayload;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.Maps;
import java.util.Map;

public class DeleteObjectContexts {
  public static void deleteObjectContexts(String projectId, String bucketName, String objectName)
      throws Exception {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    try (Storage storage =
        StorageOptions.newBuilder().setProjectId(projectId).build().getService()) {
      BlobId blobId = BlobId.of(bucketName, objectName);
      Blob blob = storage.get(blobId);
      if (blob == null) {
        System.out.println("The object " + objectName + " was not found in " + bucketName);
        return;
      }

      // Recommended: Set a generation-match precondition to avoid potential race
      // conditions and data corruptions. The request to update returns a 412 error if
      // the object's generation number does not match your precondition.
      Storage.BlobTargetOption precondition = Storage.BlobTargetOption.generationMatch();

      // To delete all existing custom contexts, set the custom contexts to an empty map.
      // The update is computed against the contexts of the fetched object, so every
      // existing key is removed.
      Map<String, ObjectCustomContextPayload> custom = Maps.newHashMap();
      ObjectContexts contexts = ObjectContexts.newBuilder().setCustom(custom).build();

      BlobInfo pendingUpdate = blob.toBuilder().setContexts(contexts).build();
      storage.update(pendingUpdate, precondition);

      System.out.println(
          "Deleted all custom contexts for object " + objectName + " in bucket " + bucketName);
    }
  }
}
// [END storage_delete_object_contexts]

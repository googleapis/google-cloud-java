/*
 * Copyright 2025 Google LLC
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

// [START storage_get_object_contexts]

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo.ObjectContexts;
import com.google.cloud.storage.BlobInfo.ObjectCustomContextPayload;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.Map;

public class GetObjectContexts {
  public static void getObjectContexts(String projectId, String bucketName, String objectName)
      throws Exception {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    try (Storage storage =
        StorageOptions.newBuilder().setProjectId(projectId).build().getService()) {

      Blob blob = storage.get(bucketName, objectName);
      if (blob == null) {
        System.out.println("The object " + objectName + " was not found in " + bucketName);
        return;
      }
      ObjectContexts objectContexts = blob.getContexts();

      if (objectContexts != null) {
        Map<String, ObjectCustomContextPayload> customContexts = objectContexts.getCustom();
        if (customContexts == null) {
          System.out.println("No custom contexts found for object: " + objectName);
          return;
        }
        // Print blob's object contexts
        System.out.println("\nCustom Contexts:");
        for (Map.Entry<String, ObjectCustomContextPayload> custom : customContexts.entrySet()) {
          System.out.println(custom.getKey() + "=" + custom.getValue());
        }
      }
    }
  }
}
// [END storage_get_object_contexts]

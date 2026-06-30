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

// [START storage_list_object_contexts]

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class ListObjectContexts {
  public static void listObjectContexts(String projectId, String bucketName, String key)
      throws Exception {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The context key you want to filter
    // String key = "your-context-key";

    try (Storage storage =
        StorageOptions.newBuilder().setProjectId(projectId).build().getService()) {
      /*
       * List any object that has a context with the specified key attached
       * String filter = "contexts.\"KEY\":*";
       *
       * List any object that that does not have a context with the specified key attached
       * String filter = "NOT contexts.\"KEY\":*";
       *
       * List any object that has a context with the specified key and value attached
       * String filter = "contexts.\"KEY\"=\"VALUE\"";
       *
       * List any object that does not have a context with the specified key and value attached
       * String filter = "NOT contexts.\"KEY\"=\"VALUE\"";
       */

      String filter = "contexts.\"" + key + "\":*";

      System.out.println("Listing objects for bucket: " + bucketName + "with context key: " + key);
      Page<Blob> blobs = storage.list(bucketName, Storage.BlobListOption.filter(filter));
      for (Blob blob : blobs.iterateAll()) {
        System.out.println(blob.getBlobId().toGsUtilUri());
      }
    }
  }
}
// [END storage_list_object_contexts]

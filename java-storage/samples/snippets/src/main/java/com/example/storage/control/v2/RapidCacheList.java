/*
 * Copyright 2026 Google LLC
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

package com.example.storage.control.v2;

// [START storage_control_list_rapid_caches]

import com.google.storage.control.v2.BucketName;
import com.google.storage.control.v2.ListRapidCachesRequest;
import com.google.storage.control.v2.RapidCache;
import com.google.storage.control.v2.StorageControlClient;
import com.google.storage.control.v2.StorageControlClient.ListRapidCachesPagedResponse;
import java.io.IOException;

public final class RapidCacheList {

  public static void rapidCacheList(String bucketName) throws IOException {
    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    try (StorageControlClient storageControl = StorageControlClient.create()) {

      ListRapidCachesRequest request =
          ListRapidCachesRequest.newBuilder()
              // Set project to "_" to signify globally scoped bucket
              .setParent(BucketName.format("_", bucketName))
              .build();

      // The paged response handles pagination automatically.
      ListRapidCachesPagedResponse response = storageControl.listRapidCaches(request);
      for (RapidCache rapidCache : response.iterateAll()) {
        System.out.println(rapidCache.getName());
      }

      System.out.printf("Listed Rapid Caches in bucket %s%n", bucketName);
    }
  }
}
// [END storage_control_list_rapid_caches]

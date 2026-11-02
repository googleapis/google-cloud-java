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

// [START storage_control_get_rapid_cache]

import com.google.storage.control.v2.GetRapidCacheRequest;
import com.google.storage.control.v2.RapidCache;
import com.google.storage.control.v2.RapidCacheName;
import com.google.storage.control.v2.StorageControlClient;
import java.io.IOException;

public final class RapidCacheGet {

  public static void rapidCacheGet(String bucketName, String cacheId) throws IOException {
    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of the Rapid Cache
    // String cacheId = "your-rapid-cache-id";

    try (StorageControlClient storageControl = StorageControlClient.create()) {

      GetRapidCacheRequest request =
          GetRapidCacheRequest.newBuilder()
              // Set project to "_" to signify globally scoped bucket
              .setName(RapidCacheName.format("_", bucketName, cacheId))
              .build();

      RapidCache rapidCache = storageControl.getRapidCache(request);

      System.out.printf("Got Rapid Cache: %s%n", rapidCache.getName());
      System.out.printf("Zone: %s%n", rapidCache.getZone());
      System.out.printf("State: %s%n", rapidCache.getState());
    }
  }
}
// [END storage_control_get_rapid_cache]

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

// [START storage_control_create_rapid_cache]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.protobuf.Duration;
import com.google.storage.control.v2.BucketName;
import com.google.storage.control.v2.CreateRapidCacheMetadata;
import com.google.storage.control.v2.CreateRapidCacheRequest;
import com.google.storage.control.v2.RapidCache;
import com.google.storage.control.v2.RapidCacheName;
import com.google.storage.control.v2.StorageControlClient;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public final class RapidCacheCreate {

  public static void rapidCacheCreate(String bucketName, String cacheId)
      throws InterruptedException, ExecutionException, IOException {
    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of the Rapid Cache. It must be the zone in which to create the cache, and the zone
    // must be in the same region as the bucket.
    // String cacheId = "us-central1-a";

    try (StorageControlClient storageControl = StorageControlClient.create()) {

      // Rapid Cache Ultra requires a regional bucket with hierarchical namespace enabled.
      RapidCache rapidCache =
          RapidCache.newBuilder()
              .setName(RapidCacheName.format("_", bucketName, cacheId))
              // The Rapid Cache ID is the zone in which the cache is created.
              .setZone(cacheId)
              .setCacheType("rapid-cache-ultra")
              // How long a cache entry can live (between 1 hour and 7 days). 86400s = 24 hours.
              .setTtl(Duration.newBuilder().setSeconds(86400).build())
              .build();

      CreateRapidCacheRequest request =
          CreateRapidCacheRequest.newBuilder()
              // Set project to "_" to signify globally scoped bucket
              .setParent(BucketName.format("_", bucketName))
              .setRapidCache(rapidCache)
              .build();

      // Start a long-running operation (LRO).
      OperationFuture<RapidCache, CreateRapidCacheMetadata> operation =
          storageControl.createRapidCacheAsync(request);

      // Await the LRO's completion.
      RapidCache createdRapidCache = operation.get();
      System.out.printf("Created Rapid Cache: %s%n", createdRapidCache.getName());
      System.out.printf("Cache type: %s%n", createdRapidCache.getCacheType());
      System.out.printf("State: %s%n", createdRapidCache.getState());
    }
  }
}
// [END storage_control_create_rapid_cache]

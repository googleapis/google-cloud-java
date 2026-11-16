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

// [START storage_control_update_rapid_cache]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.storage.control.v2.RapidCache;
import com.google.storage.control.v2.RapidCacheName;
import com.google.storage.control.v2.StorageControlClient;
import com.google.storage.control.v2.UpdateRapidCacheMetadata;
import com.google.storage.control.v2.UpdateRapidCacheRequest;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public final class RapidCacheUpdate {

  public static void rapidCacheUpdate(String bucketName, String cacheId, long ttlSeconds)
      throws InterruptedException, ExecutionException, IOException {
    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of the Rapid Cache
    // String cacheId = "your-rapid-cache-id";

    // The new time to live (TTL) for cache entries, in seconds. The TTL must be between 1 hour and
    // 7 days.
    // long ttlSeconds = 172800; // 2 days

    try (StorageControlClient storageControl = StorageControlClient.create()) {

      RapidCache pendingUpdate =
          RapidCache.newBuilder()
              // Set project to "_" to signify globally scoped bucket
              .setName(RapidCacheName.format("_", bucketName, cacheId))
              .setTtl(Duration.newBuilder().setSeconds(ttlSeconds).build())
              .build();

      UpdateRapidCacheRequest request =
          UpdateRapidCacheRequest.newBuilder()
              .setRapidCache(pendingUpdate)
              // Only the fields listed in the update mask are changed.
              .setUpdateMask(FieldMask.newBuilder().addPaths("ttl").build())
              .build();

      // Start a long-running operation (LRO).
      OperationFuture<RapidCache, UpdateRapidCacheMetadata> operation =
          storageControl.updateRapidCacheAsync(request);

      // Await the LRO's completion.
      RapidCache updatedRapidCache = operation.get();
      System.out.printf("Updated Rapid Cache: %s%n", updatedRapidCache.getName());
      System.out.printf("TTL: %d seconds%n", updatedRapidCache.getTtl().getSeconds());
    }
  }
}
// [END storage_control_update_rapid_cache]

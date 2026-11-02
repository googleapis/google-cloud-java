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

// [START storage_control_disable_rapid_cache]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.storage.control.v2.DisableRapidCacheMetadata;
import com.google.storage.control.v2.DisableRapidCacheRequest;
import com.google.storage.control.v2.RapidCache;
import com.google.storage.control.v2.RapidCacheName;
import com.google.storage.control.v2.StorageControlClient;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public final class RapidCacheDisable {

  public static void rapidCacheDisable(String bucketName, String cacheId)
      throws InterruptedException, ExecutionException, IOException {
    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of the Rapid Cache
    // String cacheId = "your-rapid-cache-id";

    try (StorageControlClient storageControl = StorageControlClient.create()) {

      // Set project to "_" to signify globally scoped bucket
      String rapidCacheName = RapidCacheName.format("_", bucketName, cacheId);
      DisableRapidCacheRequest request =
          DisableRapidCacheRequest.newBuilder().setName(rapidCacheName).build();

      // Disabling a Rapid Cache starts a long-running operation (LRO). The cache moves to the
      // "disabled" state within seconds, but the operation only completes once the cache has been
      // fully removed, which can take more than 30 minutes. This sample does not wait for the
      // operation to complete; use RapidCacheGet to check the cache state.
      OperationFuture<RapidCache, DisableRapidCacheMetadata> operation =
          storageControl.disableRapidCacheAsync(request);

      System.out.printf("Disabling Rapid Cache: %s%n", rapidCacheName);
      System.out.printf("Operation: %s%n", operation.getName());
    }
  }
}
// [END storage_control_disable_rapid_cache]

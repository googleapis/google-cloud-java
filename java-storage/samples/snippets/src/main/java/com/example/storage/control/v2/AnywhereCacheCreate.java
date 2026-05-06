/*
 * Copyright 2025 Google LLC
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

// [START storage_control_create_anywhere_cache]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.storage.control.v2.AnywhereCache;
import com.google.storage.control.v2.BucketName;
import com.google.storage.control.v2.CreateAnywhereCacheMetadata;
import com.google.storage.control.v2.CreateAnywhereCacheRequest;
import com.google.storage.control.v2.StorageControlClient;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public final class AnywhereCacheCreate {

  public static void anywhereCacheCreate(String bucketName, String cacheName, String zoneName)
      throws InterruptedException, ExecutionException, IOException {
    try (StorageControlClient storageControl = StorageControlClient.create()) {

      CreateAnywhereCacheRequest request =
          CreateAnywhereCacheRequest.newBuilder()
              // Set project to "_" to signify globally scoped bucket
              .setParent(BucketName.format("_", bucketName))
              .setAnywhereCache(
                  AnywhereCache.newBuilder().setName(cacheName).setZone(zoneName).build())
              .build();

      // Start a long-running operation (LRO).
      OperationFuture<AnywhereCache, CreateAnywhereCacheMetadata> operation =
          storageControl.createAnywhereCacheAsync(request);

      // Await the LROs completion.
      AnywhereCache anywhereCache = operation.get();
      System.out.printf("Created anywhere cache: %s%n", anywhereCache.getName());
    }
  }
}
// [END storage_control_create_anywhere_cache]

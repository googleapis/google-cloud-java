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

// [START storage_control_update_anywhere_cache]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.protobuf.FieldMask;
import com.google.storage.control.v2.AnywhereCache;
import com.google.storage.control.v2.StorageControlClient;
import com.google.storage.control.v2.UpdateAnywhereCacheMetadata;
import com.google.storage.control.v2.UpdateAnywhereCacheRequest;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public final class AnywhereCacheUpdate {

  public static void anywhereCacheUpdate(String cacheName, String admissionPolicy)
      throws InterruptedException, ExecutionException, IOException {
    try (StorageControlClient storageControl = StorageControlClient.create()) {

      AnywhereCache pendingUpdate =
          AnywhereCache.newBuilder().setName(cacheName).setAdmissionPolicy(admissionPolicy).build();

      UpdateAnywhereCacheRequest request =
          UpdateAnywhereCacheRequest.newBuilder()
              .setAnywhereCache(pendingUpdate)
              .setUpdateMask(FieldMask.newBuilder().addPaths("admission_policy").build())
              .build();

      // Start a long-running operation (LRO).
      OperationFuture<AnywhereCache, UpdateAnywhereCacheMetadata> operation =
          storageControl.updateAnywhereCacheAsync(request);

      // Await the LROs completion.
      AnywhereCache updatedAnywhereCache = operation.get();
      System.out.printf("Updated anywhere cache: %s%n", updatedAnywhereCache.getName());
    }
  }
}
// [END storage_control_update_anywhere_cache]

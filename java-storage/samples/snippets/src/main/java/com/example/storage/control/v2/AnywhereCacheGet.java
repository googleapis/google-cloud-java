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

// [START storage_control_get_anywhere_cache]

import com.google.storage.control.v2.AnywhereCache;
import com.google.storage.control.v2.GetAnywhereCacheRequest;
import com.google.storage.control.v2.StorageControlClient;
import java.io.IOException;

public final class AnywhereCacheGet {

  public static void anywhereCacheGet(String cacheName) throws IOException {
    try (StorageControlClient storageControl = StorageControlClient.create()) {

      GetAnywhereCacheRequest request =
          GetAnywhereCacheRequest.newBuilder().setName(cacheName).build();

      AnywhereCache anywhereCache = storageControl.getAnywhereCache(request);

      System.out.printf("Got anywhere cache: %s%n", anywhereCache.getName());
    }
  }
}
// [END storage_control_get_anywhere_cache]

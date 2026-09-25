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

package com.example.storage.object;

// [START storage_optimize_write_latency_pool]

import com.google.cloud.storage.BlobAppendableUpload.AppendableUploadWriteableByteChannel;
import com.google.cloud.storage.BlobAppendableUploadConfig;
import com.google.cloud.storage.BlobAppendableUploadConfig.CloseAction;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobReadSession;
import com.google.cloud.storage.RangeSpec;
import com.google.cloud.storage.ReadProjectionConfigs;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class OptimizeWriteLatencyPool {
  public static void optimizeWriteLatencyPool(String bucketName, String keyPrefix)
      throws Exception {
    // The ID of your GCS zonal bucket
    // String bucketName = "your-unique-bucket-name";

    // The prefix for your pooled GCS objects
    // String keyPrefix = "pooled-object";

    int poolSize = 3;
    String nextObjectName = keyPrefix + "_" + poolSize;
    byte[] payload = "0123456789".getBytes(StandardCharsets.UTF_8);

    try (Storage storage = StorageOptions.grpc().build().getService()) {
      BlobAppendableUploadConfig config =
          BlobAppendableUploadConfig.of().withCloseAction(CloseAction.CLOSE_WITHOUT_FINALIZING);
      Queue<AppendableUploadWriteableByteChannel> pool = new ConcurrentLinkedQueue<>();
      ExecutorService executor = Executors.newSingleThreadExecutor();
      try {
        // 1. Init pool: Sized to ensure pre-warmed channels are always available.
        for (int i = 0; i < poolSize; i++) {
          BlobInfo info = BlobInfo.newBuilder(bucketName, keyPrefix + "_" + i).build();
          // open() establishes the stream and creates the 0-byte object in the background.
          pool.add(
              storage
                  .blobAppendableUpload(info, config, Storage.BlobWriteOption.doesNotExist())
                  .open());
        }

        // 2. Write: Pop a pre-warmed writer and commit with flush() (~1-2 ms)
        // instead of blocking on close().
        AppendableUploadWriteableByteChannel channel = pool.poll();
        if (channel == null) {
          throw new IllegalStateException("Writer pool is empty");
        }
        try {
          channel.write(ByteBuffer.wrap(payload));
          channel.flush();
        } catch (Exception e) {
          try {
            channel.closeWithoutFinalizing();
          } catch (Exception closeException) {
            e.addSuppressed(closeException);
          }
          throw e;
        }

        // 3. Pool maintenance (run asynchronously off the critical write path):
        // Close the used channel without finalizing and refill the pool.
        Future<Void> maintenanceFuture =
            executor.submit(
                () -> {
                  channel.closeWithoutFinalizing();
                  BlobInfo nextInfo = BlobInfo.newBuilder(bucketName, nextObjectName).build();
                  pool.add(
                      storage
                          .blobAppendableUpload(
                              nextInfo, config, Storage.BlobWriteOption.doesNotExist())
                          .open());
                  return null;
                });

        // 4. Read: Unfinalized objects are readable after flush().
        try (BlobReadSession readSession =
            storage
                .blobReadSession(BlobId.of(bucketName, keyPrefix + "_0"))
                .get(10, TimeUnit.SECONDS)) {
          byte[] bytes =
              readSession
                  .readAs(
                      ReadProjectionConfigs.asFutureBytes()
                          .withRangeSpec(RangeSpec.of(0, payload.length)))
                  .get();
          System.out.printf(
              "Read unfinalized object %s_0: %s%n",
              keyPrefix, new String(bytes, StandardCharsets.UTF_8));
        }

        maintenanceFuture.get(10, TimeUnit.SECONDS);
      } finally {
        // Wait for in-flight maintenance so it can't add a channel after the pool is drained.
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        // Runs before the Storage client is closed by the outer try-with-resources.
        AppendableUploadWriteableByteChannel remaining;
        while ((remaining = pool.poll()) != null) {
          try {
            remaining.closeWithoutFinalizing();
          } catch (Exception e) {
            // Ignore so the remaining channels are still closed.
          }
        }
      }
    }
  }
}

// [END storage_optimize_write_latency_pool]

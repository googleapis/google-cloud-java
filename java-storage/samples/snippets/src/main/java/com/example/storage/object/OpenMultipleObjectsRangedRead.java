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

package com.example.storage.object;

// [START storage_open_multiple_objects_ranged_read]

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobReadSession;
import com.google.cloud.storage.RangeSpec;
import com.google.cloud.storage.ReadAsFutureBytes;
import com.google.cloud.storage.ReadProjectionConfigs;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OpenMultipleObjectsRangedRead {
  public static void multipleObjectsSingleRangedRead(
      String bucketName, List<String> objectNames, long startOffset, int length) throws Exception {
    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS objects to read
    // List<String> objectName = Arrays.asList("object-1", "object-2", "object-3");

    RangeSpec singleRange = RangeSpec.of(startOffset, length);
    ReadAsFutureBytes rangeConfig =
        ReadProjectionConfigs.asFutureBytes().withRangeSpec(singleRange);

    try (Storage storage = StorageOptions.grpc().build().getService()) {
      List<ApiFuture<byte[]>> futuresToWaitOn = new ArrayList<>();

      System.out.printf(
          "Initiating single ranged read [%d, %d] on %d objects...%n",
          startOffset, startOffset + length - 1, objectNames.size());

      for (String objectName : objectNames) {
        BlobId blobId = BlobId.of(bucketName, objectName);
        ApiFuture<BlobReadSession> futureReadSession = storage.blobReadSession(blobId);

        ApiFuture<byte[]> readAndCloseFuture =
            ApiFutures.transformAsync(
                futureReadSession,
                (BlobReadSession session) -> {
                  ApiFuture<byte[]> readFuture = session.readAs(rangeConfig);

                  readFuture.addListener(
                      () -> {
                        try {
                          session.close();
                        } catch (java.io.IOException e) {
                          System.err.println(
                              "WARN: Background error while closing session: " + e.getMessage());
                        }
                      },
                      MoreExecutors.directExecutor());
                  return readFuture;
                },
                MoreExecutors.directExecutor());

        futuresToWaitOn.add(readAndCloseFuture);
      }
      ApiFutures.allAsList(futuresToWaitOn).get(30, TimeUnit.SECONDS);

      System.out.println("All concurrent single-ranged read operations are complete.");
    }
  }
}
// [END storage_open_multiple_objects_ranged_read]

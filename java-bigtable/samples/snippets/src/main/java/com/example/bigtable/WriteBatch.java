/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigtable;

// [START bigtable_writes_batch]

import com.google.api.core.ApiFuture;
import com.google.api.gax.batching.Batcher;
import com.google.api.gax.batching.BatchingException;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class WriteBatch {
  private static final String COLUMN_FAMILY_NAME = "stats_summary";

  public static void writeBatch(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      List<ApiFuture<Void>> batchFutures = new ArrayList<>();
      try (Batcher<RowMutationEntry, Void> batcher =
          dataClient.newBulkMutationBatcher(TableId.of(tableId))) {
        long timestamp = System.currentTimeMillis() * 1000;
        batchFutures.add(
            batcher.add(
                RowMutationEntry.create("tablet#a0b81f74#20190501")
                    .setCell(
                        COLUMN_FAMILY_NAME, ByteString.copyFromUtf8("connected_wifi"), timestamp, 1)
                    .setCell(COLUMN_FAMILY_NAME, "os_build", timestamp, "12155.0.0-rc1")));
        batchFutures.add(
            batcher.add(
                RowMutationEntry.create("tablet#a0b81f74#20190502")
                    .setCell(
                        COLUMN_FAMILY_NAME, ByteString.copyFromUtf8("connected_wifi"), timestamp, 1)
                    .setCell(COLUMN_FAMILY_NAME, "os_build", timestamp, "12155.0.0-rc6")));

        // Blocks until mutations are applied on all submitted row entries.
        // flush will be called automatically when a batch is full.
        batcher.flush();
        // Before batcher is closed, all remaining (if any) mutations are applied.
      } catch (BatchingException batchingException) {
        System.out.println(
            "At least one entry failed to apply. Summary of the errors: \n" + batchingException);
        // get individual entry error details
        for (ApiFuture<Void> future : batchFutures) {
          try {
            future.get();
          } catch (ExecutionException entryException) {
            System.out.println("Entry failure: " + entryException.getCause());
          } catch (InterruptedException e) {
            // handle interrupted exception
          }
        }
      }
      System.out.println("Successfully wrote 2 rows");
    } catch (Exception e) {
      System.out.println("Error during WriteBatch: \n" + e);
    }
  }
}

// [END bigtable_writes_batch]

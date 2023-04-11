/*
 * Copyright 2022 Google LLC
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

package com.example.bigtable.deletes;

// [START bigtable_streaming_and_batching]
import com.google.api.gax.batching.Batcher;
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import java.io.IOException;

public class BatchDeleteExample {
  public void batchDelete(String projectId, String instanceId, String tableId)
      throws InterruptedException, IOException {
    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      try (Batcher<RowMutationEntry, Void> batcher = dataClient.newBulkMutationBatcher(tableId)) {
        ServerStream<Row> rows = dataClient.readRows(Query.create(tableId));
        for (Row row : rows) {
          batcher.add(
              RowMutationEntry.create(row.getKey()).deleteCells("cell_plan", "data_plan_05gb"));
        }
        // Blocks until mutations are applied on all submitted row entries.
        batcher.flush();
      }
    }
  }
}
// [END bigtable_streaming_and_batching]

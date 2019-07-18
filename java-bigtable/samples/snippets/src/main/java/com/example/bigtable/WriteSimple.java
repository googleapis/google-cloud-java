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

// [START bigtable_writes_simple]

import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.protobuf.ByteString;

public class WriteSimple {
  private static final String COLUMN_FAMILY_NAME = "stats_summary";

  public static void writeSimple(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      long timestamp = System.currentTimeMillis() * 1000;

      String rowKey = "phone#4c410523#20190501";
      ByteString one = ByteString.copyFrom(new byte[] {0, 0, 0, 0, 0, 0, 0, 1});

      RowMutation rowMutation =
          RowMutation.create(tableId, rowKey)
              .setCell(
                  COLUMN_FAMILY_NAME,
                  ByteString.copyFrom("connected_cell".getBytes()),
                  timestamp,
                  one)
              .setCell(
                  COLUMN_FAMILY_NAME,
                  ByteString.copyFrom("connected_wifi".getBytes()),
                  timestamp,
                  one)
              .setCell(COLUMN_FAMILY_NAME, "os_build", timestamp, "PQ2A.190405.003");

      dataClient.mutateRow(rowMutation);
      System.out.printf("Successfully wrote row %s", rowKey);

    } catch (Exception e) {
      System.out.println("Error during WriteSimple: \n" + e.toString());
    }
  }
}

// [END bigtable_writes_simple]

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

// [START bigtable_writes_increment]

import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import java.nio.charset.Charset;

public class WriteIncrement {
  private static final String COLUMN_FAMILY_NAME = "stats_summary";

  public static void writeIncrement(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      // Get an existing row that has a cell with an incrementable value. A value can be incremented
      // if it is encoded as a 64-bit big-endian signed integer.
      String rowKey = "phone#4c410523#20190501";
      ReadModifyWriteRow mutation =
          ReadModifyWriteRow.create(tableId, rowKey)
              .increment(COLUMN_FAMILY_NAME, "connected_cell", -1);
      Row success = dataClient.readModifyWriteRow(mutation);

      System.out.printf(
          "Successfully updated row %s", success.getKey().toString(Charset.defaultCharset()));
    } catch (Exception e) {
      System.out.println("Error during WriteIncrement: \n" + e.toString());
    }
  }
}

// [END bigtable_writes_increment]

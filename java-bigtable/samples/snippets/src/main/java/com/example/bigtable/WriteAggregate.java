/*
 * Copyright 2024 Google LLC
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

// [START bigtable_writes_aggregate]

import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.common.primitives.Longs;
import com.google.protobuf.ByteString;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class WriteAggregate {
  private static final String COUNT_COLUMN_FAMILY_NAME = "view_count";
  private static final long MICROS_PER_MILLI = 1000;

  public static void writeAggregate(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "page-view-counter";

    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {

      String rowKey = "page#index.html";
      Instant viewTimestamp = Instant.parse("2024-03-13T12:41:34.123Z");

      // Bucket the views for an hour into a single count, giving us an hourly view count for a
      // given page.
      Instant hourlyBucket = viewTimestamp.truncatedTo(ChronoUnit.HOURS);
      long hourlyBucketMicros = hourlyBucket.toEpochMilli() * MICROS_PER_MILLI;

      RowMutation rowMutation =
          RowMutation.create(tableId, rowKey)
              .addToCell(COUNT_COLUMN_FAMILY_NAME, "views", hourlyBucketMicros, 1);

      dataClient.mutateRow(rowMutation);
      System.out.printf("Successfully wrote row %s", rowKey);

    } catch (Exception e) {
      System.out.println("Error during WriteAggregate: \n" + e.toString());
    }
  }

  public static void mergeAggregate(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "page-view-counter";

    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {

      String rowKey = "page#index.html";
      Instant viewTimestamp = Instant.parse("2024-03-13T12:41:34.123Z");

      // Bucket the views for an hour into a single count, giving us an hourly view count for a
      // given page.
      Instant hourlyBucket = viewTimestamp.truncatedTo(ChronoUnit.HOURS);
      long hourlyBucketMicros = hourlyBucket.toEpochMilli() * MICROS_PER_MILLI;

      RowMutation rowMutation =
          RowMutation.create(tableId, rowKey)
              .mergeToCell(
                  COUNT_COLUMN_FAMILY_NAME,
                  "views",
                  hourlyBucketMicros,
                  ByteString.copyFrom(Longs.toByteArray(1L)));

      dataClient.mutateRow(rowMutation);
      System.out.printf("Successfully wrote row %s", rowKey);

    } catch (Exception e) {
      System.out.println("Error during mergeAggregate: \n" + e.toString());
    }
  }
}

// [END bigtable_writes_aggregate]

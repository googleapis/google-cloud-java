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

// [START bigtable_writes_conditional]

import static com.google.cloud.bigtable.data.v2.models.Filters.FILTERS;

import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.Filters.Filter;
import com.google.cloud.bigtable.data.v2.models.Mutation;

public class WriteConditionally {
  private static final String COLUMN_FAMILY_NAME = "stats_summary";

  public static void writeConditionally(String projectId, String instanceId, String tableId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";
    // String tableId = "mobile-time-series";

    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      long timestamp = System.currentTimeMillis() * 1000;

      String rowkey = "phone#4c410523#20190501";

      Mutation mutation =
          Mutation.create().setCell(COLUMN_FAMILY_NAME, "os_name", timestamp, "android");

      Filter filter =
          FILTERS
              .chain()
              .filter(FILTERS.family().exactMatch(COLUMN_FAMILY_NAME))
              .filter(FILTERS.qualifier().exactMatch("os_build"))
              .filter(FILTERS.value().regex("PQ2A\\..*"));

      ConditionalRowMutation conditionalRowMutation =
          ConditionalRowMutation.create(tableId, rowkey).condition(filter).then(mutation);

      boolean success = dataClient.checkAndMutateRow(conditionalRowMutation);

      System.out.printf("Successfully updated row's os_name: %b", success);

    } catch (Exception e) {
      System.out.println("Error during WriteConditionally: \n" + e.toString());
      e.printStackTrace();
    }
  }
}

// [END bigtable_writes_conditional]

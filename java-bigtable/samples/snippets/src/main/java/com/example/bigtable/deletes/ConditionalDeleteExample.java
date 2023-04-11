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

// [START bigtable_delete_check_and_mutate]
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.Filters;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import java.io.IOException;

public class ConditionalDeleteExample {
  public void conditionalDelete(String projectId, String instanceId, String tableId)
      throws IOException {
    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      Filters.Filter condition = Filters.FILTERS.value().exactMatch("PQ2A.190405.004");
      Mutation mutation = Mutation.create().deleteCells("stats_summary", "os_build");
      dataClient.checkAndMutateRow(
          ConditionalRowMutation.create(tableId, "phone#4c410523#20190502")
              .condition(condition)
              .then(mutation));
    }
  }
}
// [END bigtable_delete_check_and_mutate]

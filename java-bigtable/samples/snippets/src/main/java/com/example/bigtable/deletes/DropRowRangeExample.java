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

// [START bigtable_drop_row_range]
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import java.io.IOException;

public class DropRowRangeExample {
  public void dropRowRange(String projectId, String instanceId, String tableId) throws IOException {
    try (BigtableTableAdminClient tableAdminClient =
        BigtableTableAdminClient.create(projectId, instanceId)) {
      tableAdminClient.dropRowRange(tableId, "phone#4c410523");
    }
  }
}
// [END bigtable_drop_row_range]

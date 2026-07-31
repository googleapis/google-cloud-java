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

// [START bigtable_delete_table]
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClientV2;
import java.io.IOException;

public class DeleteTableExample {
  public void deleteTable(String projectId, String instanceId, String tableId) throws IOException {
    BaseBigtableTableAdminSettings adminSettings =
        BaseBigtableTableAdminSettings.newBuilder().build();
    try (BigtableTableAdminClientV2 tableAdminClient =
        BigtableTableAdminClientV2.create(adminSettings)) {
      tableAdminClient.deleteTable(
          "projects/" + projectId + "/instances/" + instanceId + "/tables/" + tableId);
    }
  }
}
// [END bigtable_delete_table]

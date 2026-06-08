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

import static org.junit.Assert.assertThat;

import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClientV2;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.TableId;
import java.io.IOException;
import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;

/** Integration tests for {@link Quickstart} */
public class QuickstartTest extends BigtableBaseTest {

  private static final String TABLE_ID = "quickstart-table";

  @BeforeClass
  public static void beforeClass() throws IOException {
    initializeVariables();

    // set up required table and row data if not present
    BaseBigtableTableAdminSettings adminSettings =
        BaseBigtableTableAdminSettings.newBuilder().build();
    try (BigtableTableAdminClientV2 tableAdminClient =
        BigtableTableAdminClientV2.create(adminSettings)) {
      String columnFamily = "cf1";
      boolean exists = true;
      try {
        tableAdminClient.getTable(
            com.google.bigtable.admin.v2.GetTableRequest.newBuilder()
                .setName(
                    "projects/" + projectId + "/instances/" + instanceId + "/tables/" + TABLE_ID)
                .build());
      } catch (com.google.api.gax.rpc.NotFoundException e) {
        exists = false;
      }
      if (!exists) {
        com.google.bigtable.admin.v2.CreateTableRequest request =
            com.google.bigtable.admin.v2.CreateTableRequest.newBuilder()
                .setParent("projects/" + projectId + "/instances/" + instanceId)
                .setTableId(TABLE_ID)
                .setTable(
                    com.google.bigtable.admin.v2.Table.newBuilder()
                        .putColumnFamilies(
                            columnFamily,
                            com.google.bigtable.admin.v2.ColumnFamily.getDefaultInstance())
                        .build())
                .build();
        tableAdminClient.createTable(request);
      }
      try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
        String rowKey = "r1";
        Row row = dataClient.readRow(TableId.of(TABLE_ID), rowKey);
        if (row == null) {
          dataClient.mutateRow(
              RowMutation.create(TableId.of(TABLE_ID), rowKey)
                  .setCell(columnFamily, "c1", "quickstart"));
        }
      }
    }
  }

  @Test
  public void testQuickstart() {
    Quickstart.quickstart(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output, CoreMatchers.containsString("Reading a single row by row key"));
    assertThat(output, CoreMatchers.containsString("Row: r1"));
    assertThat(
        output, CoreMatchers.containsString("Family: cf1    Qualifier: c1    Value: quickstart"));
  }
}

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

import com.example.bigtable.MobileTimeSeriesBaseTest;
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.common.truth.Truth;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/*
 * These tests are order dependent because they delete rows and cells from a table.
 * They are prefixed with `testN_` to signal the order in which they should run.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeletesTest extends MobileTimeSeriesBaseTest {
  public static BigtableDataClient bigtableDataClient;

  @BeforeClass
  public static void beforeClass() throws IOException {
    initializeVariables();
    createTable();
    writeStatsData();
    writePlanData();
    bigtableDataClient = BigtableDataClient.create(projectId, instanceId);
  }

  @AfterClass
  public static void afterClass() throws IOException {
    cleanupTable();
  }

  @Test
  public void test1_testDeleteFromColumn() throws IOException {
    String rowKey = "phone#4c410523#20190501";
    Row row = bigtableDataClient.readRow(TABLE_ID, rowKey);
    String qualifier = "data_plan_01gb";
    List<RowCell> cells = row.getCells(COLUMN_FAMILY_NAME_PLAN, qualifier);

    Truth.assertThat(cells).isNotEmpty();

    DeleteColumnCellsExample deleteColumnCellsExample = new DeleteColumnCellsExample();
    deleteColumnCellsExample.deleteColumnCells(projectId, instanceId, TABLE_ID);
    row = bigtableDataClient.readRow(TABLE_ID, rowKey);
    List<RowCell> cellsAfterDelete = row.getCells(COLUMN_FAMILY_NAME_PLAN, qualifier);

    Truth.assertThat(cellsAfterDelete).isEmpty();
  }

  @Test
  public void test2_testDeleteFromRow() throws IOException {
    String rowKey = "phone#4c410523#20190501";
    Row row = bigtableDataClient.readRow(TABLE_ID, rowKey);

    Truth.assertThat(row).isNotNull();

    DeleteRowExample deleteRowExample = new DeleteRowExample();
    deleteRowExample.deleteRow(projectId, instanceId, TABLE_ID);
    row = bigtableDataClient.readRow(TABLE_ID, rowKey);

    Truth.assertThat(row).isNull();
  }

  @Test
  public void test3_testStreamingAndBatching() throws IOException, InterruptedException {
    String rowKey = "phone#4c410523#20190502";
    Row row = bigtableDataClient.readRow(TABLE_ID, rowKey);
    String qualifier = "data_plan_05gb";
    List<RowCell> cells = row.getCells(COLUMN_FAMILY_NAME_PLAN, qualifier);

    Truth.assertThat(cells).isNotEmpty();

    BatchDeleteExample batchDeleteExample = new BatchDeleteExample();
    batchDeleteExample.batchDelete(projectId, instanceId, TABLE_ID);
    row = bigtableDataClient.readRow(TABLE_ID, rowKey);
    List<RowCell> cellsAfterDelete = row.getCells(COLUMN_FAMILY_NAME_PLAN, qualifier);

    Truth.assertThat(cellsAfterDelete).isEmpty();
  }

  @Test
  public void test4_testCheckAndMutate() throws IOException {
    String rowKey = "phone#4c410523#20190502";
    Row row = bigtableDataClient.readRow(TABLE_ID, rowKey);
    String qualifier = "os_build";
    List<RowCell> cells = row.getCells(COLUMN_FAMILY_NAME_STATS, qualifier);

    Truth.assertThat(cells).isNotEmpty();

    ConditionalDeleteExample conditionalDeleteExample = new ConditionalDeleteExample();
    conditionalDeleteExample.conditionalDelete(projectId, instanceId, TABLE_ID);
    row = bigtableDataClient.readRow(TABLE_ID, rowKey);
    List<RowCell> cellsAfterDelete = row.getCells(COLUMN_FAMILY_NAME_STATS, qualifier);

    Truth.assertThat(cellsAfterDelete).isEmpty();
  }

  @Test
  public void test5_testDropRowRange() throws IOException {
    String rowPrefix = "phone#4c410523";
    Query query = Query.create(TABLE_ID).prefix(rowPrefix);
    ServerStream<Row> rows = bigtableDataClient.readRows(query);
    int rowCount = 0;
    for (Row ignored : rows) {
      rowCount++;
    }

    Truth.assertThat(rowCount).isGreaterThan(1);

    DropRowRangeExample dropRowRangeExample = new DropRowRangeExample();
    dropRowRangeExample.dropRowRange(projectId, instanceId, TABLE_ID);
    rows = bigtableDataClient.readRows(query);
    rowCount = 0;
    for (Row ignored : rows) {
      rowCount++;
    }

    Truth.assertThat(rowCount).isEqualTo(0);
  }

  @Test
  public void test6_testDeleteColumnFamily() throws IOException {
    String rowKey = "phone#5c10102#20190501";
    Row row = bigtableDataClient.readRow(TABLE_ID, rowKey);
    List<RowCell> cells = row.getCells(COLUMN_FAMILY_NAME_STATS);

    Truth.assertThat(cells).isNotEmpty();

    DeleteColumnFamilyExample deleteColumnFamilyExample = new DeleteColumnFamilyExample();
    deleteColumnFamilyExample.deleteColumnFamily(projectId, instanceId, TABLE_ID);
    row = bigtableDataClient.readRow(TABLE_ID, rowKey);
    List<RowCell> cellsAfterDelete = row.getCells(COLUMN_FAMILY_NAME_STATS);

    Truth.assertThat(cellsAfterDelete).isEmpty();
  }

  @Test
  public void test7_testDeleteTable() throws IOException {
    try (BigtableTableAdminClient tableAdminClient =
        BigtableTableAdminClient.create(projectId, instanceId)) {
      Truth.assertThat(tableAdminClient.exists(TABLE_ID)).isTrue();

      DeleteTableExample deleteTableExample = new DeleteTableExample();
      deleteTableExample.deleteTable(projectId, instanceId, TABLE_ID);

      Truth.assertThat(tableAdminClient.exists(TABLE_ID)).isFalse();
    }
  }
}

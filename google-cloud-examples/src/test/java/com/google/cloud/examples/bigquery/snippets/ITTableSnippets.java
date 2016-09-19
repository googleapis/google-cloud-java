/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.examples.bigquery.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.cloud.Page;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.BigQuery.TableDataListOption;
import com.google.cloud.bigquery.BigQuery.TableField;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Field.Type;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Integration tests for {@link TableSnippets}.
 */
public class ITTableSnippets {
  private static final String BASE_TABLE_NAME = "my_table";
  private static final String DATASET_NAME = "my_dataset";
  private static final String COPY_DATASET_NAME = "my_copy_dataset";
  private static final Value ROW1 = new Value("value1", true);
  private static final Value ROW2 = new Value("value2", false);
  private static final Logger log = Logger.getLogger(ITTableSnippets.class.getName());

  private static BigQuery bigquery;
  private Table table;
  private TableSnippets tableSnippets;

  private static final String DOOMED_TABLE_NAME = "doomed_table";
  private static final String DOOMED_DATASET_NAME = "doomed_dataset";
  public static final TableId DOOMED_TABLE_ID = TableId.of(DOOMED_DATASET_NAME, DOOMED_TABLE_NAME);

  private static Table doomedTable;
  private static TableSnippets doomedTableSnippets;

  private static int nextTableNumber;

  @BeforeClass
  public static void beforeClass() {
    bigquery = BigQueryOptions.defaultInstance().service();
    bigquery.create(DatasetInfo.builder(DATASET_NAME).build());
    bigquery.create(DatasetInfo.builder(COPY_DATASET_NAME).build());
    bigquery.create(DatasetInfo.builder(DOOMED_DATASET_NAME).build());
  }

  @Before
  public void before() {
    ++nextTableNumber;
    StandardTableDefinition.Builder builder = StandardTableDefinition.builder();
    builder.schema(
        Schema.of(Field.of("stringField", Type.string()), Field.of("booleanField", Type.bool())));
    table = bigquery.create(TableInfo.of(getTableId(), builder.build()));
    bigquery.create(TableInfo.of(getCopyTableId(), builder.build()));
    tableSnippets = new TableSnippets(table);

    doomedTable = bigquery.create(TableInfo.of(DOOMED_TABLE_ID, builder.build()));
    doomedTableSnippets = new TableSnippets(doomedTable);
  }

  @After
  public void after() {
    bigquery.delete(getTableId());
    bigquery.delete(getCopyTableId());
    bigquery.delete(DOOMED_TABLE_ID);
  }

  @AfterClass
  public static void afterClass() {
    bigquery.delete(DATASET_NAME, DatasetDeleteOption.deleteContents());
    bigquery.delete(COPY_DATASET_NAME, DatasetDeleteOption.deleteContents());
    bigquery.delete(DOOMED_DATASET_NAME, DatasetDeleteOption.deleteContents());
  }

  private String getTableName() {
    return BASE_TABLE_NAME + nextTableNumber;
  }

  private TableId getTableId() {
    return TableId.of(DATASET_NAME, getTableName());
  }

  private String getCopyTableName() {
    return BASE_TABLE_NAME + "_copy_" + nextTableNumber;
  }

  private TableId getCopyTableId() {
    return TableId.of(COPY_DATASET_NAME, getCopyTableName());
  }

  @Test
  public void testCheckExists() {
    log.info("testCheckExists");
    tableSnippets.checkExists();
  }

  @Test
  public void testReloadTableWithFields() {
    log.info("testReloadTableWithFields");
    tableSnippets.reloadTableWithFields(TableField.LAST_MODIFIED_TIME, TableField.NUM_ROWS);
  }

  @Test
  public void testUpdateTableWithFields() {
    log.info("testUpdateTableWithFields");
    tableSnippets.updateTableWithFields(TableField.LAST_MODIFIED_TIME, TableField.NUM_ROWS);
  }

  @Test
  public void testDelete() {
    log.info("testDelete");
    doomedTableSnippets.delete();
  }

  @Test
  public void testInsert() {
    log.info("testInsert");
    InsertAllResponse response = tableSnippets.insert("row1", "row2");
    assertFalse(response.hasErrors());
    verifyTestRows(table);
  }

  @Test
  public void testInsertParams() throws InterruptedException {
    InsertAllResponse response = tableSnippets.insertWithParams("row1", "row2");
    assertTrue(response.hasErrors());
    List<List<FieldValue>> rows = ImmutableList.copyOf(tableSnippets.list().values());
    while (rows.isEmpty()) {
      Thread.sleep(500);
      rows = ImmutableList.copyOf(tableSnippets.list().values());
    }
    Set<Value> values =
        FluentIterable.from(rows).transform(new Function<List<FieldValue>, Value>() {
          @Override
          public Value apply(List<FieldValue> row) {
            return new Value(row.get(0).stringValue(), row.get(1).booleanValue());
          }
        }).toSet();
    assertEquals(ImmutableSet.of(ROW2), values);
  }

  @Test
  public void testList() throws InterruptedException {
    List<List<FieldValue>> rows = ImmutableList.copyOf(tableSnippets.list().values());
    assertEquals(0, rows.size());

    InsertAllResponse response = tableSnippets.insert("row1", "row2");
    assertFalse(response.hasErrors());
    rows = ImmutableList.copyOf(tableSnippets.list().values());
    while (rows.isEmpty()) {
      Thread.sleep(500);
      rows = ImmutableList.copyOf(tableSnippets.list().values());
    }
    assertEquals(2, rows.size());
  }

  @Test
  public void testCopy() {
    tableSnippets.copy(COPY_DATASET_NAME, BASE_TABLE_NAME);
  }

  @Test
  public void testCopyTableId() {
    log.info("testCopyTableId");
    tableSnippets.copyTableId(COPY_DATASET_NAME, getCopyTableName());
  }

  @Test
  public void testExtractList() {
    log.info("testExtractList");
    String projectId = bigquery.options().projectId();
    String gcsFile1 = "gs://" + projectId + ".appspot.com/extractTestA_*.csv";
    String gcsFile2 = "gs://" + projectId + ".appspot.com/extractTestB_*.csv";
    tableSnippets.extractList("CSV", gcsFile1, gcsFile2);
  }

  @Test
  public void testExtractSingle() {
    log.info("testExtractSingle");
    String projectId = bigquery.options().projectId();
    String gcsFile = "gs://" + projectId + ".appspot.com/extractTest.csv";
    tableSnippets.extractSingle("CSV", gcsFile);
  }

  @Test
  public void testLoadList() {
    log.info("testLoadList");
    String projectId = bigquery.options().projectId();
    String gcsFile1 = "gs://" + projectId + ".appspot.com/loadTest1.csv";
    String gcsFile2 = "gs://" + projectId + ".appspot.com/loadTest2.csv";

    // Before we can load, we should make sure those files exist.
    tableSnippets.extractSingle("CSV", gcsFile1);
    tableSnippets.extractSingle("CSV", gcsFile2);

    tableSnippets.loadList(gcsFile1, gcsFile2);
  }

  @Test
  public void testLoadSingle() {
    log.info("testLoadSingle");
    String projectId = bigquery.options().projectId();
    String gcsFile = "gs://" + projectId + ".appspot.com/loadSingle.csv";

    // Before we can load, we should make sure the file exists.
    tableSnippets.extractSingle("CSV", gcsFile);

    tableSnippets.loadSingle(gcsFile);
  }

  private static class Value {
    final String stringField;
    final boolean booleanField;

    Value(String stringField, boolean booleanField) {
      this.stringField = stringField;
      this.booleanField = booleanField;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Value) {
        Value o = (Value) obj;
        return Objects.equal(stringField, o.stringField) && booleanField == o.booleanField;
      }
      return false;
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(stringField, booleanField);
    }

    @Override
    public String toString() {
      return "<Value stringField: " + stringField + " booleanField: " + booleanField + ">";
    }
  }

  /**
   * Verifies that the given table has the rows inserted by InsertTestRows().
   *
   * @param checkTable The table to query.
   */
  private void verifyTestRows(Table checkTable) {
    List<List<FieldValue>> rows = waitForTableRows(checkTable, 2);
    // Verify that the table data matches what it's supposed to.
    Set<Value> values =
        FluentIterable.from(rows).transform(new Function<List<FieldValue>, Value>() {
          @Override
          public Value apply(List<FieldValue> row) {
            return new Value(row.get(0).stringValue(), row.get(1).booleanValue());
          }
        }).toSet();
    assertEquals(ImmutableSet.of(ROW2, ROW1), values);
  }

  /**
   * Waits for a specified number of rows to appear in the given table. This is used by
   * verifyTestRows to wait for data to appear before verifying.
   *
   * @param checkTable
   * @param numRows
   * @return The rows from the table.
   */
  private List<List<FieldValue>> waitForTableRows(Table checkTable, int numRows) {
    // Wait for the data to appear.
    Page<List<FieldValue>> page = checkTable.list(TableDataListOption.pageSize(100));
    List<List<FieldValue>> rows = ImmutableList.copyOf(page.values());
    int numSleeps = 0;
    while (rows.size() != numRows) {
      assertTrue(numSleeps < 10);
      log.info("Sleeping and waiting for " + numRows + " test rows to appear (currently "
          + rows.size() + ")...");
      try {
        ++numSleeps;
        Thread.sleep(5000);
      } catch (InterruptedException e) {
      }
      page = checkTable.list(TableDataListOption.pageSize(100));
      rows = ImmutableList.copyOf(page.values());
    }
    return rows;
  }
}

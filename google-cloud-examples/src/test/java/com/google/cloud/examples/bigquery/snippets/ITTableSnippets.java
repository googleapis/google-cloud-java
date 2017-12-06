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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.paging.Page;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.TableDataListOption;
import com.google.cloud.bigquery.BigQuery.TableField;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.List;
import java.util.Set;

/**
 * Integration tests for {@link TableSnippets}.
 */
public class ITTableSnippets {

  private static final String BASE_TABLE_NAME = "my_table";
  private static final String DATASET_NAME = RemoteBigQueryHelper.generateDatasetName();
  private static final String COPY_DATASET_NAME = RemoteBigQueryHelper.generateDatasetName();
  private static final String BUCKET_NAME = RemoteStorageHelper.generateBucketName();
  private static final Schema SCHEMA = Schema.of(
      Field.of("stringField", LegacySQLTypeName.STRING),
      Field.of("booleanField", LegacySQLTypeName.BOOLEAN));
  private static final List<?> ROW1 = ImmutableList.of("value1", true);
  private static final List<?> ROW2 = ImmutableList.of("value2", false);
  private static final String DOOMED_TABLE_NAME = "doomed_table";
  private static final TableId DOOMED_TABLE_ID = TableId.of(DATASET_NAME, DOOMED_TABLE_NAME);

  private static BigQuery bigquery;
  private static Storage storage;
  private static int nextTableNumber;

  private Table table;
  private TableSnippets tableSnippets;

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() {
    bigquery = RemoteBigQueryHelper.create().getOptions().getService();
    bigquery.create(DatasetInfo.newBuilder(DATASET_NAME).build());
    bigquery.create(DatasetInfo.newBuilder(COPY_DATASET_NAME).build());
    storage = RemoteStorageHelper.create().getOptions().getService();
    storage.create(BucketInfo.of(BUCKET_NAME));
  }

  @Before
  public void before() {
    ++nextTableNumber;
    StandardTableDefinition.Builder builder = StandardTableDefinition.newBuilder();
    builder.setSchema(SCHEMA);
    table = bigquery.create(TableInfo.of(getTableId(), builder.build()));
    bigquery.create(TableInfo.of(getCopyTableId(), builder.build()));
    tableSnippets = new TableSnippets(table);
  }

  @After
  public void after() {
    bigquery.delete(getTableId());
    bigquery.delete(getCopyTableId());
  }

  @AfterClass
  public static void afterClass() {
    RemoteBigQueryHelper.forceDelete(bigquery, DATASET_NAME);
    RemoteBigQueryHelper.forceDelete(bigquery, COPY_DATASET_NAME);
    RemoteStorageHelper.forceDelete(storage, BUCKET_NAME);
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
  public void testExists() {
    assertTrue(tableSnippets.exists());
  }

  @Test
  public void testReloadTableWithFields() {
    Table latestTable =
        tableSnippets.reloadTableWithFields(TableField.LAST_MODIFIED_TIME, TableField.NUM_ROWS);
    assertNotNull(latestTable);
    assertNotNull(latestTable.getLastModifiedTime());
  }

  @Test
  public void testUpdate() {
    Table updatedTable = tableSnippets.update();
    assertEquals("new description", updatedTable.getDescription());
  }

  @Test
  public void testDelete() {
    Table doomedTable =
        bigquery.create(TableInfo.of(DOOMED_TABLE_ID, StandardTableDefinition.of(SCHEMA)));
    TableSnippets doomedTableSnippets = new TableSnippets(doomedTable);
    assertTrue(doomedTableSnippets.delete());
  }

  @Test
  public void testInsert() throws InterruptedException {
    InsertAllResponse response = tableSnippets.insert("row1", "row2");
    assertFalse(response.hasErrors());
    verifyTestRows(table);
  }

  @Test
  public void testInsertParams() throws InterruptedException {
    InsertAllResponse response = tableSnippets.insertWithParams("row1", "row2");
    assertFalse(response.hasErrors());
    List<FieldValueList> rows = ImmutableList.copyOf(tableSnippets.list().getValues());
    while (rows.isEmpty()) {
      Thread.sleep(500);
      rows = ImmutableList.copyOf(tableSnippets.list().getValues());
    }
    Set<List<?>> values =
        FluentIterable.from(rows).transform(new Function<FieldValueList, List<?>>() {
          @Override
          public List<?> apply(FieldValueList row) {
            return ImmutableList.of(row.get(0).getStringValue(), row.get(1).getBooleanValue());
          }
        }).toSet();
    assertEquals(ImmutableSet.of(ROW2), values);
  }

  @Test
  public void testList() throws InterruptedException {
    List<FieldValueList> rows = ImmutableList.copyOf(tableSnippets.list().getValues());
    assertEquals(0, rows.size());

    InsertAllResponse response = tableSnippets.insert("row1", "row2");
    assertFalse(response.hasErrors());
    rows = ImmutableList.copyOf(tableSnippets.list().getValues());
    while (rows.isEmpty()) {
      Thread.sleep(500);
      rows = ImmutableList.copyOf(tableSnippets.list().getValues());
    }
    assertEquals(2, rows.size());
  }

  @Test
  public void testCopy() {
    tableSnippets.copy(COPY_DATASET_NAME, BASE_TABLE_NAME);
  }

  @Test
  public void testCopyTableId() {
    Job copyJob = tableSnippets.copyTableId(COPY_DATASET_NAME, getCopyTableName());
    assertSuccessful(copyJob);
  }

  @Test
  public void testExtractAndLoadList() {
    String gcsFile1 = "gs://" + BUCKET_NAME + "/extractTestA_*.csv";
    String gcsFile2 = "gs://" + BUCKET_NAME + "/extractTestB_*.csv";
    Job extractJob = tableSnippets.extractList("CSV", gcsFile1, gcsFile2);
    gcsFile1 = gcsFile1.replace("*", "000000000000");
    gcsFile2 = gcsFile2.replace("*", "000000000000");
    assertSuccessful(extractJob);
    Job loadJob = tableSnippets.loadList(gcsFile1, gcsFile2);
    assertSuccessful(loadJob);
  }

  @Test
  public void testExtractAndLoadSingle() {
    String gcsFile = "gs://" + BUCKET_NAME + "/extractTest.csv";
    Job extractJob = tableSnippets.extractSingle("CSV", gcsFile);
    assertSuccessful(extractJob);
    Job loadJob = tableSnippets.loadSingle(gcsFile);
    assertSuccessful(loadJob);
  }

  /**
   * Verifies that the given table has the rows inserted by InsertTestRows().
   *
   * @param checkTable the table to query
   */
  private void verifyTestRows(Table checkTable) throws InterruptedException {
    List<FieldValueList> rows = waitForTableRows(checkTable, 2);
    // Verify that the table data matches what it's supposed to.
    Set<List<?>> values =
        FluentIterable.from(rows).transform(new Function<FieldValueList, List<?>>() {
          @Override
          public List<?> apply(FieldValueList row) {
            return ImmutableList.of(row.get(0).getStringValue(), row.get(1).getBooleanValue());
          }
        }).toSet();
    assertEquals(ImmutableSet.of(ROW2, ROW1), values);
  }

  /**
   * Waits for a specified number of rows to appear in the given table. This is used by
   * verifyTestRows to wait for data to appear before verifying.
   *
   * @param checkTable the table to query
   * @param numRows the expected number of rows
   * @return the rows from the table
   */
  private List<FieldValueList> waitForTableRows(Table checkTable, int numRows)
      throws InterruptedException {
    // Wait for the data to appear.
    Page<FieldValueList> page = checkTable.list(TableDataListOption.pageSize(100));
    List<FieldValueList> rows = ImmutableList.copyOf(page.getValues());
    while (rows.size() != numRows) {
      Thread.sleep(1000);
      page = checkTable.list(TableDataListOption.pageSize(100));
      rows = ImmutableList.copyOf(page.getValues());
    }
    return rows;
  }

  private void assertSuccessful(Job job) {
    assertTrue(job.isDone());
    assertNull(job.getStatus().getError());
  }
}

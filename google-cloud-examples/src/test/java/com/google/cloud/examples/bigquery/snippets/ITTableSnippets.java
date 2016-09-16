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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.google.cloud.Page;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Field.Type;
import com.google.cloud.bigquery.InsertAllRequest.RowToInsert;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.BigQuery.TableDataListOption;
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
  // TODO: Make the copy table name unique.
  private static final TableId COPY_TABLE_ID = TableId.of(COPY_DATASET_NAME, BASE_TABLE_NAME);
  private static final Logger log = Logger.getLogger(ITTableSnippets.class.getName());

  private Table table;
  private Table copyTable;
  private TableSnippets tableSnippets;
  private BigQuery bigquery;
  
  private static int nextTableNumber = 0;
  
  private String GetTableName() {
    return BASE_TABLE_NAME + nextTableNumber;
  }
  
  private TableId GetTableId() {
    return TableId.of(DATASET_NAME, GetTableName());
  }

  @Before
  public void before() {
    ++nextTableNumber;
    bigquery = BigQueryOptions.defaultInstance().service();
    bigquery.create(DatasetInfo.builder(DATASET_NAME).build());
    bigquery.create(DatasetInfo.builder(COPY_DATASET_NAME).build());
    StandardTableDefinition.Builder builder = StandardTableDefinition.builder();
    builder.schema(
        Schema.of(Field.of("stringField", Type.string()), Field.of("booleanField", Type.bool())));
    table = bigquery.create(TableInfo.of(GetTableId(), builder.build()));
    copyTable = bigquery.create(TableInfo.of(COPY_TABLE_ID, builder.build()));
    tableSnippets = new TableSnippets(table);
  }

  @After
  public void after() {
    bigquery.delete(GetTableId());
    bigquery.delete(COPY_TABLE_ID);
    bigquery.delete(DATASET_NAME);
    bigquery.delete(COPY_DATASET_NAME);
  }

  @Test
  public void testInsert() throws InterruptedException {
    InsertAllResponse response = tableSnippets.insert("row1", "row2");
    assertFalse(response.hasErrors());
    
    // TODO: Replace the following with VerifyTestRows(table)?
    List<List<FieldValue>> rows = ImmutableList.copyOf(tableSnippets.list().values());
    while (rows.size() != 2) {
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
    assertEquals(new Value("value1", true), new Value("value1", true));
    assertEquals(new Value("value2", false), new Value("value2", false));
    assertEquals(ImmutableSet.of(ROW2, ROW1), values);
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
   * Inserts some data into the test table.
   */
  private void InsertTestRows() {
    log.info("Inserting test rows...");
    String rowId1 = "row1";
    String rowId2 = "row2";
    List<RowToInsert> rows = new ArrayList<>();
    Map<String, Object> row1 = new HashMap<>();
    row1.put("stringField", ROW1.stringField);
    row1.put("booleanField", ROW1.booleanField);
    Map<String, Object> row2 = new HashMap<>();
    row2.put("stringField", ROW2.stringField);
    row2.put("booleanField", ROW2.booleanField);
    rows.add(RowToInsert.of(rowId1, row1));
    rows.add(RowToInsert.of(rowId2, row2));
    table.insert(rows);
  }
  
  /**
   * Verifies that the given table has the rows inserted by InsertTestRows().
   * @param checkTable The table to query.
   */
  private void VerifyTestRows(Table checkTable) {
    List<List<FieldValue>> rows = WaitForTableRows(checkTable, 2);
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

  private List<List<FieldValue>> WaitForTableRows(Table checkTable, int numRows) {
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
      } catch(InterruptedException e) {
      }
      page = checkTable.list(TableDataListOption.pageSize(100));
      rows = ImmutableList.copyOf(page.values());
    }
    return rows;
  }
  
  @Test
  public void testCopyTableId() {
    InsertTestRows();
    VerifyTestRows(table);
    log.info("Found test rows in original table.");

    tableSnippets.copyTableId(COPY_DATASET_NAME, BASE_TABLE_NAME);
  }
}

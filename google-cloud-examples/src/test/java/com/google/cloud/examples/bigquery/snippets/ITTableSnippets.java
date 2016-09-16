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

import com.google.cloud.Page;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Field.Type;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Integration tests for {@link TableSnippets}.
 */
public class ITTableSnippets {
  private static final String TABLE_NAME = "my_table";
  private static final String DATASET_NAME = "my_dataset";
  private static final Value ROW1 = new Value("value1", true);
  private static final Value ROW2 = new Value("value2", false);
  private static final TableId TABLE_ID = TableId.of(DATASET_NAME, TABLE_NAME);
  private static final Logger log = Logger.getLogger(ITTableSnippets.class.getName());

  private static Table table;
  private static TableSnippets tableSnippets;
  private static BigQuery bigquery;

  @BeforeClass
  public static void beforeClass() {
    bigquery = BigQueryOptions.defaultInstance().service();
    bigquery.create(DatasetInfo.builder(DATASET_NAME).build());
    StandardTableDefinition.Builder builder = StandardTableDefinition.builder();
    builder.schema(Schema.of(
        Field.of("stringField", Type.string()),
        Field.of("booleanField", Type.bool())));
    table = bigquery.create(TableInfo.of(TABLE_ID, builder.build()));
    tableSnippets = new TableSnippets(table);
  }

  @AfterClass
  public static void afterClass() {
    bigquery.delete(TABLE_ID);
    bigquery.delete(DATASET_NAME);
  }

  @Test
  public void testInsert() {
    InsertAllResponse response = tableSnippets.insert("row1", "row2");
    assertFalse(response.hasErrors());
    Page<List<FieldValue>> page = table.list();
    List<List<FieldValue>> results = new ArrayList<>();
    for (List<FieldValue> row : page.values()) {
      results.add(row);
    }
    assertEquals(2, results.size());
  }

  private static class Value {
    final String stringField;
    final boolean booleanField;

    Value(String stringField, boolean booleanField) {
      this.stringField = stringField;
      this.booleanField = booleanField;
    }
  }
  
  @Test
  public void testCopyTableId() {
    final String destinationTableName = "copy_destination";
    StandardTableDefinition.Builder builder = StandardTableDefinition.builder();
    builder.schema(Schema.of(
        Field.of("stringField", Type.string()),
        Field.of("booleanField", Type.bool())));
    TableId destinationId = TableId.of(DATASET_NAME, destinationTableName);
    Table destinationTable = bigquery.create(TableInfo.of(destinationId, builder.build()));

    try {
      Job job = tableSnippets.copyTableId(DATASET_NAME, destinationTableName);
      
      // TODO: Test that the destination table has the same contents as the source.
    } finally {
      bigquery.delete(destinationId);
    }
  }
}

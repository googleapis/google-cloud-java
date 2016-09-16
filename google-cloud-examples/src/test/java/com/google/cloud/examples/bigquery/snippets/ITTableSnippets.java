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

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Field.Type;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * Integration tests for {@link TableSnippets}.
 */
public class ITTableSnippets {
  private static final String TABLE_NAME = "table";
  private static final String DATASET_NAME = "dataset";
  public static final TableId TABLE_ID = TableId.of(DATASET_NAME, TABLE_NAME);
  private static final Logger log = Logger.getLogger(ITTableSnippets.class.getName());

  private static BigQuery bq;
  private static Table table;
  private static TableSnippets tableSnippets;

  @BeforeClass
  public static void beforeClass() {
    bq = BigQueryOptions.defaultInstance().service();
    StandardTableDefinition.Builder builder = StandardTableDefinition.builder();
    builder.schema(Schema.of(
        Field.of("stringField", Type.string()),
        Field.of("booleanField", Type.bool())));
    table = bq.create(TableInfo.of(TABLE_ID, builder.build()));
    tableSnippets = new TableSnippets(table);
  }

  @AfterClass
  public static void afterClass() {
    bq.delete(TABLE_ID);
  }

  @Test
  public void testInsert() {
    tableSnippets.insert("row1", "row2");
  }
  
  @Test
  public void testCopyTableId() {
    Job job = tableSnippets.copy(TABLE_ID);
  }
}

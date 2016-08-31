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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in READMEs and javadoc. Any change to this file should be reflected in
 * the project's READMEs and package-info.java.
 */

package com.google.cloud.examples.bigquery.snippets;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;

import java.util.concurrent.TimeoutException;

/**
 * A snippet for Google Cloud BigQuery showing how to get a BigQuery table or create it if it does
 * not exist. The snippet also starts a BigQuery job to load data into the table from a Cloud
 * Storage blob and wait until the job completes.
 */
public class CreateTableAndLoadData {

  public static void main(String... args) throws InterruptedException, TimeoutException {
    BigQuery bigquery = BigQueryOptions.defaultInstance().service();
    TableId tableId = TableId.of("dataset", "table");
    Table table = bigquery.getTable(tableId);
    if (table == null) {
      System.out.println("Creating table " + tableId);
      Field integerField = Field.of("fieldName", Field.Type.integer());
      Schema schema = Schema.of(integerField);
      table = bigquery.create(TableInfo.of(tableId, StandardTableDefinition.of(schema)));
    }
    System.out.println("Loading data into table " + tableId);
    Job loadJob = table.load(FormatOptions.csv(), "gs://bucket/path");
    loadJob = loadJob.waitFor();
    if (loadJob.status().error() != null) {
      System.out.println("Job completed with errors");
    } else {
      System.out.println("Job succeeded");
    }
  }
}

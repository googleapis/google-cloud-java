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

package com.google.gcloud.examples.bigquery.snippets;

import com.google.gcloud.bigquery.BigQuery;
import com.google.gcloud.bigquery.BigQueryOptions;
import com.google.gcloud.bigquery.Field;
import com.google.gcloud.bigquery.FormatOptions;
import com.google.gcloud.bigquery.Job;
import com.google.gcloud.bigquery.Schema;
import com.google.gcloud.bigquery.StandardTableDefinition;
import com.google.gcloud.bigquery.Table;
import com.google.gcloud.bigquery.TableId;
import com.google.gcloud.bigquery.TableInfo;

/**
 * A snippet for Google Cloud BigQuery showing how to get a BigQuery table or create it if it does
 * not exists. The snippet also starts a BigQuery job to load data into the table from a Cloud
 * Storage blob and wait until the job completes.
 */
public class CreateTableAndLoadData {

  public static void main(String... args) throws InterruptedException {
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
    while (!loadJob.isDone()) {
      Thread.sleep(1000L);
    }
    if (loadJob.status().error() != null) {
      System.out.println("Job completed with errors");
    } else {
      System.out.println("Job succeeded");
    }
  }
}

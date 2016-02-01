/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

/**
 * A client to Google Cloud BigQuery.
 *
 * <p>A simple usage example:
 * <pre> {@code
 * BigQuery bigquery = BigQueryOptions.defaultInstance().service();
 * TableId tableId = TableId.of("dataset", "table");
 * TableInfo info = bigquery.getTable(tableId);
 * if (info == null) {
 *   System.out.println("Creating table " + tableId);
 *   Field integerField = Field.of("fieldName", Field.Type.integer());
 *   Schema schema = Schema.of(integerField);
 *   bigquery.create(TableInfo.of(tableId, TableDefinition.of(schema)));
 * } else {
 *   System.out.println("Loading data into table " + tableId);
 *   LoadJobConfiguration configuration = LoadJobConfiguration.of(tableId, "gs://bucket/path");
 *   JobInfo loadJob = JobInfo.of(configuration);
 *   loadJob = bigquery.create(loadJob);
 *   while (loadJob.status().state() != JobStatus.State.DONE) {
 *     Thread.sleep(1000L);
 *     loadJob = bigquery.getJob(loadJob.jobId());
 *   }
 *   if (loadJob.status().error() != null) {
 *     System.out.println("Job completed with errors");
 *   } else {
 *     System.out.println("Job succeeded");
 *   }
 * }}</pre>
 *
 * @see <a href="https://cloud.google.com/bigquery/">Google Cloud BigQuery</a>
 */
package com.google.gcloud.bigquery;

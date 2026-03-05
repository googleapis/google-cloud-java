/*
 * Copyright 2015 Google LLC
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
 * A client for BigQuery – A fully managed, petabyte scale, low cost enterprise data warehouse for
 * analytics.
 *
 * <p>A simple usage example showing how to create a table in Bigquery. For the complete source code
 * see <a
 * href="https://github.com/googleapis/java-bigquery/blob/main/samples/snippets/src/main/java/com/example/bigquery/CreateTable.java">
 * CreateTable.java</a>.
 *
 * <pre>{@code
 * BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService(); *
 * TableId tableId = TableId.of(datasetName, tableName);
 * TableDefinition tableDefinition = StandardTableDefinition.of(schema);
 * TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build(); *
 * bigquery.create(tableInfo);
 * System.out.println("Table created successfully");
 * }</pre>
 *
 * @see <a href="https://cloud.google.com/bigquery/">Google Cloud BigQuery</a>
 */
package com.google.cloud.bigquery;

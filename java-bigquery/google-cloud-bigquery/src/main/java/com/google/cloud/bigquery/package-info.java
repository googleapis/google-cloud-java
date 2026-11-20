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
 * <p>Use {@link com.google.cloud.bigquery.BigQuery} in this package to manage datasets, tables,
 * routines, models, and jobs, run SQL queries, and read paginated results. For new streaming
 * ingestion workloads or reading large tables directly in parallel (Apache Arrow or Avro), prefer
 * {@code google-cloud-bigquerystorage}. See <a
 * href="https://docs.cloud.google.com/bigquery/docs/loading-data">Introduction to loading data</a>,
 * <a href="https://docs.cloud.google.com/bigquery/docs/write-api-grpc">BigQuery Storage Write API
 * (gRPC)</a>, and <a href="https://docs.cloud.google.com/bigquery/docs/reference/storage">BigQuery
 * Storage Read API</a> for guidance on choosing between APIs.
 *
 * <p>A simple usage example showing how to create a table in BigQuery. For more Java examples, see
 * <a href="https://docs.cloud.google.com/bigquery/docs/samples?language=java">BigQuery Java code
 * samples</a>.
 *
 * <pre>{@code
 * // Initialize a client once and reuse it across multiple requests.
 * BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
 * TableId tableId = TableId.of(datasetName, tableName);
 * TableDefinition tableDefinition = StandardTableDefinition.of(schema);
 * TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build();
 * bigquery.create(tableInfo);
 * }</pre>
 *
 * @see com.google.cloud.bigquery.BigQuery
 * @see <a href="https://docs.cloud.google.com/bigquery/docs">Google Cloud BigQuery
 *     Documentation</a>
 */
package com.google.cloud.bigquery;

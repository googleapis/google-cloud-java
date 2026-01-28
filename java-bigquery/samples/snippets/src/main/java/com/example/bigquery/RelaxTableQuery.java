/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigquery;

// [START bigquery_relax_column_query_append]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobInfo.SchemaUpdateOption;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableResult;
import com.google.common.collect.ImmutableList;

public class RelaxTableQuery {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    relaxTableQuery(projectId, datasetName, tableName);
  }

  // To relax all columns in a destination table when you append data to it during a query job
  public static void relaxTableQuery(String projectId, String datasetName, String tableName)
      throws Exception {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, tableName);

      String sourceTable = "`" + projectId + "." + datasetName + "." + tableName + "`";
      String query = "SELECT word FROM " + sourceTable + " WHERE word like '%is%'";

      QueryJobConfiguration queryConfig =
          QueryJobConfiguration.newBuilder(query)
              // Use standard SQL syntax for queries.
              // See: https://cloud.google.com/bigquery/sql-reference/
              .setUseLegacySql(false)
              .setSchemaUpdateOptions(ImmutableList.of(SchemaUpdateOption.ALLOW_FIELD_RELAXATION))
              .setWriteDisposition(WriteDisposition.WRITE_APPEND)
              .setDestinationTable(tableId)
              .build();

      Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).build());

      queryJob = queryJob.waitFor();

      // Check for errors
      if (queryJob == null) {
        throw new Exception("Job no longer exists");
      } else if (queryJob.getStatus().getError() != null) {
        // You can also look at queryJob.getStatus().getExecutionErrors() for all
        // errors, not just the latest one.
        throw new Exception(queryJob.getStatus().getError().toString());
      }

      // Get the results.
      TableResult results = queryJob.getQueryResults();

      // Print all pages of the results.
      results
          .iterateAll()
          .forEach(
              rows -> {
                rows.forEach(row -> System.out.println("row: " + row.toString()));
              });

      System.out.println("Successfully relaxed all columns in destination table during query job");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Columns not relaxed during query job \n" + e.toString());
    }
  }
}
// [END bigquery_relax_column_query_append]

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

// [START bigquery_load_table_gcs_csv_truncate]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.LoadJobConfiguration;
import com.google.cloud.bigquery.TableId;

// Sample to overwrite the BigQuery table data by loading a CSV file from GCS
public class LoadCsvFromGcsTruncate {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    String sourceUri = "gs://cloud-samples-data/bigquery/us-states/us-states.csv";
    loadCsvFromGcsTruncate(datasetName, tableName, sourceUri);
  }

  public static void loadCsvFromGcsTruncate(String datasetName, String tableName, String sourceUri)
      throws Exception {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, tableName);

      LoadJobConfiguration configuration =
          LoadJobConfiguration.builder(tableId, sourceUri)
              .setFormatOptions(FormatOptions.csv())
              // Set the write disposition to overwrite existing table data
              .setWriteDisposition(WriteDisposition.WRITE_TRUNCATE)
              .build();

      // For more information on Job see:
      // https://googleapis.dev/java/google-cloud-clients/latest/index.html?com/google/cloud/bigquery/package-summary.html
      // Load the table
      Job loadJob = bigquery.create(JobInfo.of(configuration));

      // Load data from a GCS parquet file into the table
      // Blocks until this load table job completes its execution, either failing or succeeding.
      Job completedJob = loadJob.waitFor();

      // Check for errors
      if (completedJob == null) {
        throw new Exception("Job not executed since it no longer exists.");
      } else if (completedJob.getStatus().getError() != null) {
        // You can also look at queryJob.getStatus().getExecutionErrors() for all
        // errors, not just the latest one.
        throw new Exception(
            "BigQuery was unable to load into the table due to an error: \n"
                + loadJob.getStatus().getError());
      }
      System.out.println("Table is successfully overwritten by CSV file loaded from GCS");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Column not added during load append \n" + e.toString());
    }
  }
}
// [END bigquery_load_table_gcs_csv_truncate]

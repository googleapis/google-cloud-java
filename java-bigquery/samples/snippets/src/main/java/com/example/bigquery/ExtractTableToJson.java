/*
 * Copyright 2020 Google LLC
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

// [START bigquery_extract_table_json]
import com.google.cloud.RetryOption;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import org.threeten.bp.Duration;

public class ExtractTableToJson {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "bigquery-public-data";
    String datasetName = "samples";
    String tableName = "shakespeare";
    String bucketName = "my-bucket";
    String destinationUri = "gs://" + bucketName + "/path/to/file";
    // For more information on export formats available see:
    // https://cloud.google.com/bigquery/docs/exporting-data#export_formats_and_compression_types
    // For more information on Job see:
    // https://googleapis.dev/java/google-cloud-clients/latest/index.html?com/google/cloud/bigquery/package-summary.html

    // Note that FormatOptions.json().toString() is not "JSON" but "NEWLINE_DELIMITED_JSON"
    // Using FormatOptions Enum for this will prevent problems with unexpected format names.
    String dataFormat = FormatOptions.json().getType();

    extractTableToJson(projectId, datasetName, tableName, destinationUri, dataFormat);
  }

  // Exports datasetName:tableName to destinationUri as a JSON file
  public static void extractTableToJson(
      String projectId,
      String datasetName,
      String tableName,
      String destinationUri,
      String dataFormat) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(projectId, datasetName, tableName);
      Table table = bigquery.getTable(tableId);

      Job job = table.extract(dataFormat, destinationUri);

      // Blocks until this job completes its execution, either failing or succeeding.
      Job completedJob =
          job.waitFor(
              RetryOption.initialRetryDelay(Duration.ofSeconds(1)),
              RetryOption.totalTimeout(Duration.ofMinutes(3)));
      if (completedJob == null) {
        System.out.println("Job not executed since it no longer exists.");
        return;
      } else if (completedJob.getStatus().getError() != null) {
        System.out.println(
            "BigQuery was unable to extract due to an error: \n" + job.getStatus().getError());
        return;
      }
      System.out.println(
          "Table export successful. Check in GCS bucket for the " + dataFormat + " file.");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Table extraction job was interrupted. \n" + e.toString());
    }
  }
}
// [END bigquery_extract_table_json]

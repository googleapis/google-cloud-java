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

// [START bigquery_update_with_dml]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableDataWriteChannel;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.WriteChannelConfiguration;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

// Sample to update data in BigQuery tables using DML query
public class UpdateTableDml {

  public static void main(String[] args) throws IOException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    updateTableDml(datasetName, tableName);
  }

  public static void updateTableDml(String datasetName, String tableName)
      throws IOException, InterruptedException {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // Load JSON file into UserSessions table
      TableId tableId = TableId.of(datasetName, tableName);

      WriteChannelConfiguration writeChannelConfiguration =
          WriteChannelConfiguration.newBuilder(tableId)
              .setFormatOptions(FormatOptions.json())
              .build();

      // Imports a local JSON file into a table.
      Path jsonPath =
          FileSystems.getDefault().getPath("src/test/resources", "userSessionsData.json");

      // The location and JobName must be specified; other fields can be auto-detected.
      String jobName = "jobId_" + UUID.randomUUID().toString();
      JobId jobId = JobId.newBuilder().setLocation("us").setJob(jobName).build();

      try (TableDataWriteChannel writer = bigquery.writer(jobId, writeChannelConfiguration);
          OutputStream stream = Channels.newOutputStream(writer)) {
        Files.copy(jsonPath, stream);
      }

      // Get the Job created by the TableDataWriteChannel and wait for it to complete.
      Job job = bigquery.getJob(jobId);
      Job completedJob = job.waitFor();
      if (completedJob == null) {
        System.out.println("Job not executed since it no longer exists.");
        return;
      } else if (completedJob.getStatus().getError() != null) {
        System.out.println(
            "BigQuery was unable to load local file to the table due to an error: \n"
                + job.getStatus().getError());
        return;
      }

      System.out.println(
          job.getStatistics().toString() + " userSessionsData json uploaded successfully");

      // Write a DML query to modify UserSessions table
      // To create DML query job to mask the last octet in every row's ip_address column
      String dmlQuery =
          String.format(
              "UPDATE `%s.%s` \n"
                  + "SET ip_address = REGEXP_REPLACE(ip_address, r\"(\\.[0-9]+)$\", \".0\")\n"
                  + "WHERE TRUE",
              datasetName, tableName);

      QueryJobConfiguration dmlQueryConfig = QueryJobConfiguration.newBuilder(dmlQuery).build();

      // Execute the query.
      TableResult result = bigquery.query(dmlQueryConfig);

      // Print the results.
      result.iterateAll().forEach(rows -> rows.forEach(row -> System.out.println(row.getValue())));

      System.out.println("Table updated successfully using DML");
    } catch (BigQueryException e) {
      System.out.println("Table update failed \n" + e.toString());
    }
  }
}
// [END bigquery_update_with_dml]

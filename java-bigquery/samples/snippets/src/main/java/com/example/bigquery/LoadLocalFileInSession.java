/*
 * Copyright 2023 Google LLC
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

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.ConnectionProperty;
import com.google.cloud.bigquery.CsvOptions;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobStatistics.LoadStatistics;
import com.google.cloud.bigquery.TableDataWriteChannel;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.WriteChannelConfiguration;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class LoadLocalFileInSession {

  public static void main(String[] args) throws IOException, InterruptedException {
    // Use _SESSION if the table is a temporary table
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    Path csvPath = FileSystems.getDefault().getPath(".", "my-data.csv");
    String sessionId =
        createSessionForLoading(datasetName, tableName, csvPath, FormatOptions.csv());
    loadLocalFileInSession(datasetName, tableName, csvPath, FormatOptions.csv(), sessionId);
  }

  // [START bigquery_load_from_file_create_session]

  public static String createSessionForLoading(
      String datasetName, String tableName, Path csvPath, CsvOptions formatOptions)
      throws IOException, InterruptedException {
    LoadStatistics loadStatistics = null;
    try {

      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, tableName);

      // Enable createSession in the configuration
      WriteChannelConfiguration writeChannelConfiguration =
          WriteChannelConfiguration.newBuilder(tableId)
              .setFormatOptions(formatOptions)
              .setCreateSession(true)
              .build();

      // The location and JobName must be specified; other fields can be auto-detected.
      String jobName = "jobId_" + UUID.randomUUID().toString();
      JobId jobId = JobId.newBuilder().setLocation("us").setJob(jobName).build();

      // Imports a local file into a table.
      try (TableDataWriteChannel writer = bigquery.writer(jobId, writeChannelConfiguration);
          OutputStream stream = Channels.newOutputStream(writer)) {
        Files.copy(csvPath, stream);
      }

      // Get the Job created by the TableDataWriteChannel and wait for it to complete.
      // Then retrieve the session ID
      Job job = bigquery.getJob(jobId);
      Job completedJob = job.waitFor();
      loadStatistics = completedJob.getStatistics();
      if (completedJob == null) {
        System.out.println("Job not executed since it no longer exists.");
        return "";
      } else if (completedJob.getStatus().getError() != null) {
        System.out.println(
            "BigQuery was unable to load local file to the table due to an error: \n"
                + job.getStatus().getError());
        return "";
      }

    } catch (BigQueryException e) {
      System.out.println("Local file not loaded. \n" + e.toString());
    }
    return loadStatistics.getSessionInfo().getSessionId();
  }

  // [END bigquery_load_from_file_create_session]

  // [START bigquery_load_from_file_with_session]
  public static void loadLocalFileInSession(
      String datasetName,
      String tableName,
      Path csvPath,
      FormatOptions formatOptions,
      String sessionId)
      throws IOException, InterruptedException {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
      TableId tableId = TableId.of(datasetName, tableName);

      // Create ConnectionProperty with sessionID
      ConnectionProperty sessionConnectionProperty =
          ConnectionProperty.newBuilder().setKey("session_id").setValue(sessionId).build();

      // Set the Connection Property with the SessionID in the Configuration.
      WriteChannelConfiguration writeChannelConfiguration =
          WriteChannelConfiguration.newBuilder(tableId)
              .setFormatOptions(formatOptions)
              .setConnectionProperties(ImmutableList.of(sessionConnectionProperty))
              .build();

      // The location and JobName must be specified; other fields can be auto-detected.
      String jobName = "jobId_" + UUID.randomUUID().toString();
      JobId jobId = JobId.newBuilder().setLocation("us").setJob(jobName).build();

      // Imports a local file into a table.
      try (TableDataWriteChannel writer = bigquery.writer(jobId, writeChannelConfiguration);
          OutputStream stream = Channels.newOutputStream(writer)) {
        Files.copy(csvPath, stream);
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

      // Get output status
      LoadStatistics stats = job.getStatistics();
      System.out.printf(
          "Successfully loaded to Session %s. \n", stats.getSessionInfo().getSessionId());
    } catch (BigQueryException e) {
      System.out.println("Local file not loaded. \n" + e.toString());
    }
  }
  // [END bigquery_load_from_file_with_session]
}

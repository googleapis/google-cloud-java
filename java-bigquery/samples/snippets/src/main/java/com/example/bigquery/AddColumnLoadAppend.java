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

// [START bigquery_add_column_load_append]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobInfo.SchemaUpdateOption;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.LoadJobConfiguration;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.TableId;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Sample to append column in existing table.
public class AddColumnLoadAppend {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    String sourceUri = "/path/to/file.csv";
    // Add a new column to a BigQuery table while appending rows via a load job.
    // 'REQUIRED' fields cannot  be added to an existing schema, so the additional column must be
    // 'NULLABLE'.
    Schema schema =
        Schema.of(
            Field.newBuilder("name", LegacySQLTypeName.STRING)
                .setMode(Field.Mode.REQUIRED)
                .build());

    List<Field> fields = schema.getFields();
    // Adding below additional column during the load job
    Field newField =
        Field.newBuilder("post_abbr", LegacySQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build();
    List<Field> newFields = new ArrayList<>(fields);
    newFields.add(newField);
    Schema newSchema = Schema.of(newFields);
    addColumnLoadAppend(datasetName, tableName, sourceUri, newSchema);
  }

  public static void addColumnLoadAppend(
      String datasetName, String tableName, String sourceUri, Schema newSchema) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, tableName);

      LoadJobConfiguration loadJobConfig =
          LoadJobConfiguration.builder(tableId, sourceUri)
              .setFormatOptions(FormatOptions.csv())
              .setWriteDisposition(WriteDisposition.WRITE_APPEND)
              .setSchema(newSchema)
              .setSchemaUpdateOptions(ImmutableList.of(SchemaUpdateOption.ALLOW_FIELD_ADDITION))
              .build();

      // Create a job ID so that we can safely retry.
      JobId jobId = JobId.of(UUID.randomUUID().toString());
      Job loadJob = bigquery.create(JobInfo.newBuilder(loadJobConfig).setJobId(jobId).build());

      // Load data from a GCS parquet file into the table
      // Blocks until this load table job completes its execution, either failing or succeeding.
      Job job = loadJob.waitFor();

      // Check for errors
      if (job.isDone() && job.getStatus().getError() == null) {
        System.out.println("Column successfully added during load append job");
      } else {
        System.out.println(
            "BigQuery was unable to load into the table due to an error:"
                + job.getStatus().getError());
      }
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Column not added during load append \n" + e.toString());
    }
  }
}
// [END bigquery_add_column_load_append]

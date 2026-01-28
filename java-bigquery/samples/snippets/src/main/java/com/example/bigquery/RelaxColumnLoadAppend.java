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

// [START bigquery_relax_column_load_append]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.CsvOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.LoadJobConfiguration;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.common.collect.ImmutableList;

// Sample to append relax column in a table.
public class RelaxColumnLoadAppend {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    String sourceUri = "gs://cloud-samples-data/bigquery/us-states/us-states.csv";
    relaxColumnLoadAppend(datasetName, tableName, sourceUri);
  }

  public static void relaxColumnLoadAppend(String datasetName, String tableName, String sourceUri) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // Retrieve destination table reference
      Table table = bigquery.getTable(TableId.of(datasetName, tableName));

      // column as a 'REQUIRED' field.
      Field name =
          Field.newBuilder("name", StandardSQLTypeName.STRING).setMode(Field.Mode.REQUIRED).build();
      Field postAbbr =
          Field.newBuilder("post_abbr", StandardSQLTypeName.STRING)
              .setMode(Field.Mode.REQUIRED)
              .build();
      Schema schema = Schema.of(name, postAbbr);

      // Skip header row in the file.
      CsvOptions csvOptions = CsvOptions.newBuilder().setSkipLeadingRows(1).build();

      // Set job options
      LoadJobConfiguration loadConfig =
          LoadJobConfiguration.newBuilder(table.getTableId(), sourceUri)
              .setSchema(schema)
              .setFormatOptions(csvOptions)
              .setSchemaUpdateOptions(
                  ImmutableList.of(JobInfo.SchemaUpdateOption.ALLOW_FIELD_RELAXATION))
              .setWriteDisposition(JobInfo.WriteDisposition.WRITE_APPEND)
              .build();

      // Create a load job and wait for it to complete.
      Job job = bigquery.create(JobInfo.of(loadConfig));
      job = job.waitFor();
      // Check the job's status for errors
      if (job.isDone() && job.getStatus().getError() == null) {
        System.out.println("Relax column append successfully loaded in a table");
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
// [END bigquery_relax_column_load_append]

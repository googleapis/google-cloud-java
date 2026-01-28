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

// [START bigquery_load_table_clustered]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Clustering;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.LoadJobConfiguration;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TimePartitioning;
import com.google.common.collect.ImmutableList;
import java.util.List;

// Sample to load clustered table.
public class LoadTableClustered {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    String sourceUri = "/path/to/file.csv";
    Schema schema =
        Schema.of(
            Field.of("name", StandardSQLTypeName.STRING),
            Field.of("post_abbr", StandardSQLTypeName.STRING),
            Field.of("date", StandardSQLTypeName.DATE));
    loadTableClustered(
        datasetName, tableName, sourceUri, schema, ImmutableList.of("name", "post_abbr"));
  }

  public static void loadTableClustered(
      String datasetName,
      String tableName,
      String sourceUri,
      Schema schema,
      List<String> clusteringFields) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, tableName);

      TimePartitioning partitioning = TimePartitioning.of(TimePartitioning.Type.DAY);
      // Clustering fields will be consisted of fields mentioned in the schema.
      // BigQuery supports clustering for both partitioned and non-partitioned tables.
      Clustering clustering = Clustering.newBuilder().setFields(clusteringFields).build();

      LoadJobConfiguration loadJobConfig =
          LoadJobConfiguration.builder(tableId, sourceUri)
              .setFormatOptions(FormatOptions.csv())
              .setSchema(schema)
              .setTimePartitioning(partitioning)
              .setClustering(clustering)
              .build();

      Job loadJob = bigquery.create(JobInfo.newBuilder(loadJobConfig).build());

      // Load data from a GCS parquet file into the table
      // Blocks until this load table job completes its execution, either failing or succeeding.
      Job job = loadJob.waitFor();

      // Check for errors
      if (job.isDone() && job.getStatus().getError() == null) {
        System.out.println("Data successfully loaded into clustered table during load job");
      } else {
        System.out.println(
            "BigQuery was unable to load into the table due to an error:"
                + job.getStatus().getError());
      }
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Data not loaded into clustered table during load job \n" + e.toString());
    }
  }
}
// [END bigquery_load_table_clustered]

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

// [START bigquery_set_hivepartitioningoptions]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.ExternalTableDefinition;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.HivePartitioningOptions;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;

// Sample to create external table using hive partitioning
public class SetHivePartitioningOptions {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    String sourceUri = "gs://cloud-samples-data/bigquery/hive-partitioning-samples/customlayout/*";
    String sourceUriPrefix =
        "gs://cloud-samples-data/bigquery/hive-partitioning-samples/customlayout/{pkey:STRING}/";
    setHivePartitioningOptions(datasetName, tableName, sourceUriPrefix, sourceUri);
  }

  public static void setHivePartitioningOptions(
      String datasetName, String tableName, String sourceUriPrefix, String sourceUri) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // Configuring partitioning options
      HivePartitioningOptions hivePartitioningOptions =
          HivePartitioningOptions.newBuilder()
              .setMode("CUSTOM")
              .setRequirePartitionFilter(true)
              .setSourceUriPrefix(sourceUriPrefix)
              .build();

      TableId tableId = TableId.of(datasetName, tableName);
      ExternalTableDefinition customTable =
          ExternalTableDefinition.newBuilder(sourceUri, FormatOptions.parquet())
              .setAutodetect(true)
              .setHivePartitioningOptions(hivePartitioningOptions)
              .build();
      bigquery.create(TableInfo.of(tableId, customTable));
      System.out.println("External table created using hivepartitioningoptions");
    } catch (BigQueryException e) {
      System.out.println("External table was not created" + e.toString());
    }
  }
}
// [END bigquery_set_hivepartitioningoptions]

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

// [START bigquery_update_table_require_partition_filter]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Table;

// Sample to update require partition filter on a table.
public class UpdateTableRequirePartitionFilter {

  public static void runUpdateTableRequirePartitionFilter() {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    updateTableRequirePartitionFilter(datasetName, tableName);
  }

  public static void updateTableRequirePartitionFilter(String datasetName, String tableName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      Table table = bigquery.getTable(datasetName, tableName);
      table.toBuilder().setRequirePartitionFilter(true).build().update();

      System.out.println("Table require partition filter updated successfully");
    } catch (BigQueryException e) {
      System.out.println("Table require partition filter was not updated \n" + e.toString());
    }
  }
}
// [END bigquery_update_table_require_partition_filter]

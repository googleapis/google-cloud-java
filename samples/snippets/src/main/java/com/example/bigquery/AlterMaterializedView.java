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

// [START bigquery_alter_materialized_view]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.MaterializedViewDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;

// Sample to alter materialized view
public class AlterMaterializedView {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String materializedViewName = "MY_MATERIALIZED_VIEW_NAME";
    alterMaterializedView(datasetName, materializedViewName);
  }

  public static void alterMaterializedView(String datasetName, String materializedViewName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, materializedViewName);

      // Get existing materialized view
      Table table = bigquery.getTable(tableId);
      MaterializedViewDefinition materializedViewDefinition = table.getDefinition();
      // Alter materialized view
      materializedViewDefinition
          .toBuilder()
          .setEnableRefresh(true)
          .setRefreshIntervalMs(1000L)
          .build();
      table.toBuilder().setDefinition(materializedViewDefinition).build().update();
      System.out.println("Materialized view altered successfully");
    } catch (BigQueryException e) {
      System.out.println("Materialized view was not altered. \n" + e.toString());
    }
  }
}
// [END bigquery_alter_materialized_view]

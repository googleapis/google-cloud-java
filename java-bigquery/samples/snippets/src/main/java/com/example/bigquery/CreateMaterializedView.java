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

// [START bigquery_create_materialized_view]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.MaterializedViewDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;

// Sample to create materialized view
public class CreateMaterializedView {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    String materializedViewName = "MY_MATERIALIZED_VIEW_NAME";
    String query =
        String.format(
            "SELECT MAX(TimestampField) AS TimestampField, StringField, "
                + "MAX(BooleanField) AS BooleanField "
                + "FROM %s.%s GROUP BY StringField",
            datasetName, tableName);
    createMaterializedView(datasetName, materializedViewName, query);
  }

  public static void createMaterializedView(
      String datasetName, String materializedViewName, String query) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, materializedViewName);

      MaterializedViewDefinition materializedViewDefinition =
          MaterializedViewDefinition.newBuilder(query).build();

      bigquery.create(TableInfo.of(tableId, materializedViewDefinition));
      System.out.println("Materialized view created successfully");
    } catch (BigQueryException e) {
      System.out.println("Materialized view was not created. \n" + e.toString());
    }
  }
}
// [END bigquery_create_materialized_view]

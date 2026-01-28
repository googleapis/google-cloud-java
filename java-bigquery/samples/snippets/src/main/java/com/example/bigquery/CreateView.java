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

// [START bigquery_create_view]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.ViewDefinition;

// Sample to create a view
public class CreateView {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    String viewName = "MY_VIEW_NAME";
    String query =
        String.format(
            "SELECT TimestampField, StringField, BooleanField FROM %s.%s", datasetName, tableName);
    createView(datasetName, viewName, query);
  }

  public static void createView(String datasetName, String viewName, String query) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, viewName);

      ViewDefinition viewDefinition =
          ViewDefinition.newBuilder(query).setUseLegacySql(false).build();

      bigquery.create(TableInfo.of(tableId, viewDefinition));
      System.out.println("View created successfully");
    } catch (BigQueryException e) {
      System.out.println("View was not created. \n" + e.toString());
    }
  }
}
// [END bigquery_create_view]

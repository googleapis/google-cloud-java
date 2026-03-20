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

// [START bigquery_update_view_query]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.ViewDefinition;

// Sample to update query on a view
public class UpdateViewQuery {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    String viewName = "MY_VIEW_NAME";
    String updateQuery =
        String.format("SELECT TimestampField, StringField FROM %s.%s", datasetName, tableName);
    updateViewQuery(datasetName, viewName, updateQuery);
  }

  public static void updateViewQuery(String datasetName, String viewName, String query) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // Retrieve existing view metadata
      TableInfo viewMetadata = bigquery.getTable(TableId.of(datasetName, viewName));

      // Update view query
      ViewDefinition viewDefinition = viewMetadata.getDefinition();
      ViewDefinition updatedViewDefinition = viewDefinition.toBuilder().setQuery(query).build();

      // Set metadata
      bigquery.update(viewMetadata.toBuilder().setDefinition(updatedViewDefinition).build());

      System.out.println("View query updated successfully");
    } catch (BigQueryException e) {
      System.out.println("View query was not updated. \n" + e.toString());
    }
  }
}
// [END bigquery_update_view_query]

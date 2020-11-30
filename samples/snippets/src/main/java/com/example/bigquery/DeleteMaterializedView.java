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

// [START bigquery_delete_materialized_view]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.TableId;

// Sample to delete materialized view
public class DeleteMaterializedView {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String materializedViewName = "MY_MATERIALIZED_VIEW_NAME";
    deleteMaterializedView(datasetName, materializedViewName);
  }

  public static void deleteMaterializedView(String datasetName, String materializedViewName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, materializedViewName);

      boolean success = bigquery.delete(tableId);
      if (success) {
        System.out.println("Materialized view deleted successfully");
      } else {
        System.out.println("Materialized view was not found");
      }
    } catch (BigQueryException e) {
      System.out.println("Materialized view was not found. \n" + e.toString());
    }
  }
}
// [END bigquery_delete_materialized_view]

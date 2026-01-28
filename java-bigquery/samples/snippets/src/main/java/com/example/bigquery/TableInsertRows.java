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

// [START bigquery_table_insert_rows]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.TableId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Sample to inserting rows into a table without running a load job.
public class TableInsertRows {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    // Create a row to insert
    Map<String, Object> rowContent = new HashMap<>();
    rowContent.put("booleanField", true);
    rowContent.put("numericField", "3.14");
    // TODO(developer): Replace the row id with a unique value for each row.
    String rowId = "ROW_ID";
    tableInsertRows(datasetName, tableName, rowId, rowContent);
  }

  public static void tableInsertRows(
      String datasetName, String tableName, String rowId, Map<String, Object> rowContent) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // Get table
      TableId tableId = TableId.of(datasetName, tableName);

      // Inserts rowContent into datasetName:tableId.
      InsertAllResponse response =
          bigquery.insertAll(
              InsertAllRequest.newBuilder(tableId)
                  // More rows can be added in the same RPC by invoking .addRow() on the builder.
                  // You can omit the unique row ids to disable de-duplication.
                  .addRow(rowId, rowContent)
                  .build());

      if (response.hasErrors()) {
        // If any of the insertions failed, this lets you inspect the errors
        for (Map.Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
          System.out.println("Response error: \n" + entry.getValue());
        }
      }
      System.out.println("Rows successfully inserted into table");
    } catch (BigQueryException e) {
      System.out.println("Insert operation not performed \n" + e.toString());
    }
  }
}
// [END bigquery_table_insert_rows]

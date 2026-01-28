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

// [START bigquery_table_insert_rows_explicit_none_insert_ids]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.TableId;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Sample to insert rows without row ids in a table
public class TableInsertRowsWithoutRowIds {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    tableInsertRowsWithoutRowIds(datasetName, tableName);
  }

  public static void tableInsertRowsWithoutRowIds(String datasetName, String tableName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      final BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
      // Create rows to insert
      Map<String, Object> rowContent1 = new HashMap<>();
      rowContent1.put("stringField", "Phred Phlyntstone");
      rowContent1.put("numericField", 32);
      Map<String, Object> rowContent2 = new HashMap<>();
      rowContent2.put("stringField", "Wylma Phlyntstone");
      rowContent2.put("numericField", 29);
      InsertAllResponse response =
          bigquery.insertAll(
              InsertAllRequest.newBuilder(TableId.of(datasetName, tableName))
                  // No row ids disable de-duplication, and also disable the retries in the Java
                  // library.
                  .setRows(
                      ImmutableList.of(
                          InsertAllRequest.RowToInsert.of(rowContent1),
                          InsertAllRequest.RowToInsert.of(rowContent2)))
                  .build());

      if (response.hasErrors()) {
        // If any of the insertions failed, this lets you inspect the errors
        for (Map.Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
          System.out.println("Response error: \n" + entry.getValue());
        }
      }
      System.out.println("Rows successfully inserted into table without row ids");
    } catch (BigQueryException e) {
      System.out.println("Insert operation not performed \n" + e.toString());
    }
  }
}
// [END bigquery_table_insert_rows_explicit_none_insert_ids]

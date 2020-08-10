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

// [START bigquery_browse_table]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.TableDataListOption;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableResult;

// Sample to directly browse a table with optional paging
public class BrowseTable {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String table = "MY_TABLE_NAME";
    String dataset = "MY_DATASET_NAME";
    browseTable(dataset, table);
  }

  public static void browseTable(String dataset, String table) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // Identify the table itself
      TableId tableId = TableId.of(dataset, table);

      // Page over 100 records. If you don't need pagination, remove the pageSize parameter.
      TableResult result = bigquery.listTableData(tableId, TableDataListOption.pageSize(100));

      // Print the records
      result
          .iterateAll()
          .forEach(
              row -> {
                row.forEach(fieldValue -> System.out.print(fieldValue.toString() + ", "));
                System.out.println();
              });

      System.out.println("Query ran successfully");
    } catch (BigQueryException e) {
      System.out.println("Query failed to run \n" + e.toString());
    }
  }
}
// [END bigquery_browse_table]

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

// [START bigquery_query_pagination]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableResult;

// Sample to run query with pagination.
public class QueryPagination {

  public static void main(String[] args) {
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    String query =
        "SELECT name, SUM(number) as total_people"
            + " FROM `bigquery-public-data.usa_names.usa_1910_2013`"
            + " GROUP BY name"
            + " ORDER BY total_people DESC"
            + " LIMIT 100";
    queryPagination(datasetName, tableName, query);
  }

  public static void queryPagination(String datasetName, String tableName, String query) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, tableName);
      QueryJobConfiguration queryConfig =
          QueryJobConfiguration.newBuilder(query)
              // save results into a table.
              .setDestinationTable(tableId)
              .build();

      bigquery.query(queryConfig);

      TableResult results =
          bigquery.listTableData(tableId, BigQuery.TableDataListOption.pageSize(20));

      // First Page
      results
          .iterateAll()
          .forEach(row -> row.forEach(val -> System.out.printf("%s,", val.toString())));

      if (results.hasNextPage()) {
        // Next Page
        results
            .getNextPage()
            .iterateAll()
            .forEach(row -> row.forEach(val -> System.out.printf("%s,", val.toString())));
      }

      System.out.println("Query pagination performed successfully.");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Query not performed \n" + e.toString());
    }
  }
}
// [END bigquery_query_pagination]

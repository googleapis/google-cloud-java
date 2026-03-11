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

// [START bigquery_query_legacy_large_results]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableResult;

// Sample to run query with large results and save the results to a table.
public class QueryLargeResults {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String destinationDataset = "MY_DESTINATION_DATASET_NAME";
    String destinationTable = "MY_DESTINATION_TABLE_NAME";
    String query = "SELECT corpus FROM [bigquery-public-data:samples.shakespeare] GROUP BY corpus;";
    queryLargeResults(destinationDataset, destinationTable, query);
  }

  public static void queryLargeResults(
      String destinationDataset, String destinationTable, String query) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      QueryJobConfiguration queryConfig =
          // To use legacy SQL syntax, set useLegacySql to true.
          QueryJobConfiguration.newBuilder(query)
              .setUseLegacySql(true)
              // Save the results of the query to a permanent table.
              .setDestinationTable(TableId.of(destinationDataset, destinationTable))
              // Allow results larger than the maximum response size.
              // If true, a destination table must be set.
              .setAllowLargeResults(true)
              .build();

      TableResult results = bigquery.query(queryConfig);

      results
          .iterateAll()
          .forEach(row -> row.forEach(val -> System.out.printf("%s,", val.toString())));

      System.out.println("Query large results performed successfully.");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Query not performed \n" + e.toString());
    }
  }
}
// [END bigquery_query_legacy_large_results]

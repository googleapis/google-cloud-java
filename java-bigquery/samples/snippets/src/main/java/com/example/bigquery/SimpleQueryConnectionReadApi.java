/*
 * Copyright 2024 Google LLC
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

// [START bigquery_simple_query_connection_read_api]

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.BigQueryResult;
import com.google.cloud.bigquery.Connection;
import com.google.cloud.bigquery.ConnectionSettings;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleQueryConnectionReadApi {

  public static void main(String[] args) {
    String query =
        "SELECT corpus, count(*) as corpus_count "
            + "FROM `bigquery-public-data.samples.shakespeare` GROUP BY corpus;";
    simpleQueryConnectionReadApi(query);
  }

  public static void simpleQueryConnectionReadApi(String query) {

    try {
      // Initialize client and create a Connection session.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
      ConnectionSettings connectionSettings =
          ConnectionSettings.newBuilder()
              .setRequestTimeout(10L)
              .setMaxResults(100L)
              .setUseQueryCache(true)
              .build();
      Connection connection = bigquery.createConnection(connectionSettings);

      // Execute the query using the Connection session.
      BigQueryResult bigQueryResult = connection.executeSelect(query);
      ResultSet resultSet = bigQueryResult.getResultSet();

      while (resultSet.next()) {
        System.out.print("corpus:" + resultSet.getString("corpus"));
        System.out.print(", count:" + resultSet.getLong("corpus_count"));
        System.out.println();
      }
      System.out.println("Query ran successfully");
    } catch (SQLException e) {
      System.out.println("Query did not run \n" + e.toString());
    }
  }
}
// [END bigquery_simple_query_connection_read_api]

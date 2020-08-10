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

// [START bigquery_query_params_arrays]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.TableResult;

// Sample to running a query with array query parameters.
public class QueryWithArrayParameters {

  public static void main(String[] args) {
    String gender = "M";
    String[] states = {"WA", "WI", "WV", "WY"};
    String query =
        "SELECT name, sum(number) as count\n"
            + "FROM `bigquery-public-data.usa_names.usa_1910_2013`\n"
            + "WHERE gender = @gender\n"
            + "AND state IN UNNEST(@states)\n"
            + "GROUP BY name\n"
            + "ORDER BY count DESC\n"
            + "LIMIT 10;";
    queryWithArrayParameters(query, gender, states);
  }

  public static void queryWithArrayParameters(String query, String gender, String[] states) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // Note: Standard SQL is required to use query parameters.
      QueryJobConfiguration queryConfig =
          QueryJobConfiguration.newBuilder(query)
              .addNamedParameter("gender", QueryParameterValue.string(gender))
              .addNamedParameter("states", QueryParameterValue.array(states, String.class))
              .build();

      TableResult results = bigquery.query(queryConfig);

      // Print the results.
      results
          .iterateAll()
          .forEach(row -> row.forEach(val -> System.out.printf("%s,", val.toString())));
      System.out.println("Query with arrays parameters performed successfully");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Query not performed \n" + e.toString());
    }
  }
}
// [END bigquery_query_params_arrays]

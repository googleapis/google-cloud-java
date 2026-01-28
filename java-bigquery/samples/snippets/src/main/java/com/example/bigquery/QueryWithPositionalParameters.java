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

// [START bigquery_query_params_positional]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.TableResult;

public class QueryWithPositionalParameters {

  public static void main(String[] args) {
    queryWithPositionalParameters();
  }

  public static void queryWithPositionalParameters() {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      String corpus = "romeoandjuliet";
      long minWordCount = 250;
      String query =
          "SELECT word, word_count\n"
              + "FROM `bigquery-public-data.samples.shakespeare`\n"
              + "WHERE corpus = ?\n"
              + "AND word_count >= ?\n"
              + "ORDER BY word_count DESC";

      // Note: Standard SQL is required to use query parameters.
      QueryJobConfiguration queryConfig =
          QueryJobConfiguration.newBuilder(query)
              .addPositionalParameter(QueryParameterValue.string(corpus))
              .addPositionalParameter(QueryParameterValue.int64(minWordCount))
              .build();

      TableResult results = bigquery.query(queryConfig);

      results
          .iterateAll()
          .forEach(row -> row.forEach(val -> System.out.printf("%s,", val.toString())));

      System.out.println("Query with positional parameters performed successfully.");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Query not performed \n" + e.toString());
    }
  }
}
// [END bigquery_query_params_positional]

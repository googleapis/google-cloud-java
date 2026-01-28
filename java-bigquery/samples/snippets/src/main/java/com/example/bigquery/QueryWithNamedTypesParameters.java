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

// [START bigquery_query_params_named_types]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.TableResult;

// Sample to run query with named types parameters.
public class QueryWithNamedTypesParameters {

  public static void main(String[] args) {
    String[] words = {"and", "is", "the", "moon"};
    String corpus = "romeoandjuliet";
    Integer wordsCount = 250;
    String query =
        "SELECT word, word_count"
            + " FROM `bigquery-public-data.samples.shakespeare`"
            + " WHERE word IN UNNEST(@wordList)"
            + " AND corpus = @corpus"
            + " AND word_count >= @minWordCount"
            + " ORDER BY word_count DESC";
    queryWithNamedTypesParameters(query, words, corpus, wordsCount);
  }

  public static void queryWithNamedTypesParameters(
      String query, String[] words, String corpus, Integer wordsCount) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      QueryParameterValue wordList = QueryParameterValue.array(words, StandardSQLTypeName.STRING);
      QueryParameterValue corpusParam = QueryParameterValue.of(corpus, StandardSQLTypeName.STRING);
      QueryParameterValue minWordCount =
          QueryParameterValue.of(wordsCount, StandardSQLTypeName.INT64);

      // Note: Standard SQL is required to use query parameters.
      QueryJobConfiguration queryConfig =
          QueryJobConfiguration.newBuilder(query)
              .addNamedParameter("wordList", wordList)
              .addNamedParameter("corpus", corpusParam)
              .addNamedParameter("minWordCount", minWordCount)
              .build();

      TableResult results = bigquery.query(queryConfig);

      results
          .iterateAll()
          .forEach(row -> row.forEach(val -> System.out.printf("%s,", val.toString())));

      System.out.println("Query with named types parameters performed successfully.");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Query not performed \n" + e.toString());
    }
  }
}
// [END bigquery_query_params_named_types]

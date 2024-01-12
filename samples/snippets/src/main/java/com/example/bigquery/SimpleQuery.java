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

// [START bigquery_query]

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;

public class SimpleQuery {

  public static void main(String[] args) {
    // TODO(developer): Replace this query before running the sample.
    String query =
        "SELECT corpus, count(*) as corpus_count "
            + "FROM `bigquery-public-data.samples.shakespeare` GROUP BY corpus;";
    simpleQuery(query);
  }

  public static void simpleQuery(String query) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // Create the query job.
      QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();

      // Execute the query.
      TableResult result = bigquery.query(queryConfig);

      // Print the results.
      result
          .iterateAll()
          .forEach(
              row -> {
                System.out.print("corpus:" + row.get("corpus").getStringValue());
                System.out.print(", count:" + row.get("corpus_count").getLongValue());
                System.out.println();
              });

      System.out.println("Query ran successfully");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Query did not run \n" + e.toString());
    }
  }
}
// [END bigquery_query]

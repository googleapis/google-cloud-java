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

// [START bigquery_query_dry_run]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobStatistics;
import com.google.cloud.bigquery.QueryJobConfiguration;

// Sample to run dry query on the table
public class QueryDryRun {

  public static void main(String[] args) {
    String query =
        "SELECT name, COUNT(*) as name_count "
            + "FROM `bigquery-public-data.usa_names.usa_1910_2013` "
            + "WHERE state = 'WA' "
            + "GROUP BY name";
    queryDryRun(query);
  }

  public static void queryDryRun(String query) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      QueryJobConfiguration queryConfig =
          QueryJobConfiguration.newBuilder(query).setDryRun(true).setUseQueryCache(false).build();

      Job job = bigquery.create(JobInfo.of(queryConfig));
      JobStatistics.QueryStatistics statistics = job.getStatistics();

      System.out.println(
          "Query dry run performed successfully." + statistics.getTotalBytesProcessed());
    } catch (BigQueryException e) {
      System.out.println("Query not performed \n" + e.toString());
    }
  }
}
// [END bigquery_query_dry_run]

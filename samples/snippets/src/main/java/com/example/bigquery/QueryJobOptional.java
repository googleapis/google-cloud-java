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

// [START bigquery_query_job_optional]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryJobConfiguration.JobCreationMode;
import com.google.cloud.bigquery.TableResult;

// Sample demonstrating short mode query execution.
//
// This feature is controlled by setting the defaultJobCreationMode
// field in the BigQueryOptions used for the client. JOB_CREATION_OPTIONAL
// allows for the execution of queries without creating a job.
public class QueryJobOptional {

  public static void main(String[] args) {
    String query =
        "SELECT name, gender, SUM(number) AS total FROM "
            + "bigquery-public-data.usa_names.usa_1910_2013 GROUP BY "
            + "name, gender ORDER BY total DESC LIMIT 10";
    queryJobOptional(query);
  }

  public static void queryJobOptional(String query) {
    try {
      // Initialize client that will be used to send requests. This client only needs
      // to be created once, and can be reused for multiple requests.
      BigQueryOptions options = BigQueryOptions.getDefaultInstance();
      options.setDefaultJobCreationMode(JobCreationMode.JOB_CREATION_OPTIONAL);
      BigQuery bigquery = options.getService();

      // Execute the query. The returned TableResult provides access information
      // about the query execution as well as query results.
      TableResult results = bigquery.query(QueryJobConfiguration.of(query));

      JobId jobId = results.getJobId();
      if (jobId != null) {
        System.out.println("Query was run with job state.  Job ID: " + jobId.toString());
      } else {
        System.out.println("Query was run in short mode.  Query ID: " + results.getQueryId());
      }

      // Print the results.
      results
          .iterateAll()
          .forEach(
              row -> {
                System.out.print("name:" + row.get("name").getStringValue());
                System.out.print(", gender: " + row.get("gender").getStringValue());
                System.out.print(", total: " + row.get("total").getLongValue());
                System.out.println();
              });

    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Query not performed \n" + e.toString());
    }
  }
}
// [END bigquery_query_job_optional]

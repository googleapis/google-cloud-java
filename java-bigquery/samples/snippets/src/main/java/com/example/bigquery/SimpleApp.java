/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigquery;

// [START bigquery_simple_app_all]
// [START bigquery_simple_app_deps]

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;

// [END bigquery_simple_app_deps]

public class SimpleApp {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the app.
    String projectId = "MY_PROJECT_ID";
    simpleApp(projectId);
  }

  public static void simpleApp(String projectId) {
    try {
      // [START bigquery_simple_app_client]
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
      // [END bigquery_simple_app_client]
      // [START bigquery_simple_app_query]
      QueryJobConfiguration queryConfig =
          QueryJobConfiguration.newBuilder(
                  "SELECT CONCAT('https://stackoverflow.com/questions/', "
                      + "CAST(id as STRING)) as url, view_count "
                      + "FROM `bigquery-public-data.stackoverflow.posts_questions` "
                      + "WHERE tags like '%google-bigquery%' "
                      + "ORDER BY view_count DESC "
                      + "LIMIT 10")
              // Use standard SQL syntax for queries.
              // See: https://cloud.google.com/bigquery/sql-reference/
              .setUseLegacySql(false)
              .build();

      JobId jobId = JobId.newBuilder().setProject(projectId).build();
      Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

      // Wait for the query to complete.
      queryJob = queryJob.waitFor();

      // Check for errors
      if (queryJob == null) {
        throw new RuntimeException("Job no longer exists");
      } else if (queryJob.getStatus().getExecutionErrors() != null
          && queryJob.getStatus().getExecutionErrors().size() > 0) {
        // TODO(developer): Handle errors here. An error here do not necessarily mean that the job
        // has completed or was unsuccessful.
        // For more details: https://cloud.google.com/bigquery/troubleshooting-errors
        throw new RuntimeException("An unhandled error has occurred");
      }
      // [END bigquery_simple_app_query]

      // [START bigquery_simple_app_print]
      // Get the results.
      TableResult result = queryJob.getQueryResults();

      // Print all pages of the results.
      for (FieldValueList row : result.iterateAll()) {
        // String type
        String url = row.get("url").getStringValue();
        String viewCount = row.get("view_count").getStringValue();
        System.out.printf("%s : %s views\n", url, viewCount);
      }
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Simple App failed due to error: \n" + e.toString());
    }
    // [END bigquery_simple_app_print]
  }
}
// [END bigquery_simple_app_all]

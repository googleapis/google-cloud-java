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

// [START bigquery_create_routine_ddl]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;

// Sample to create a routine using DDL
public class CreateRoutineDdl {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String datasetId = "MY_DATASET_ID";
    String routineId = "MY_ROUTINE_ID";
    String sql =
        "CREATE FUNCTION "
            + "`"
            + projectId
            + "."
            + datasetId
            + "."
            + routineId
            + "`"
            + "( arr ARRAY<STRUCT<name STRING, val INT64>>) AS "
            + "( (SELECT SUM(IF(elem.name = \"foo\",elem.val,null)) FROM UNNEST(arr) AS elem))";
    createRoutineDdl(sql);
  }

  public static void createRoutineDdl(String sql) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      QueryJobConfiguration config = QueryJobConfiguration.newBuilder(sql).build();

      // create a routine using query and it will wait to complete job.
      Job job = bigquery.create(JobInfo.of(config));
      job = job.waitFor();
      if (job.isDone()) {
        System.out.println("Routine created successfully");
      } else {
        System.out.println("Routine was not created");
      }
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Routine was not created. \n" + e.toString());
    }
  }
}
// [END bigquery_create_routine_ddl]

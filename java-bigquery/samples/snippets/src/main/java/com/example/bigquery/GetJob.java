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

// [START bigquery_get_job]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;

// Sample to get a job
public class GetJob {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String jobName = "MY_JOB_NAME";
    getJob(jobName);
  }

  public static void getJob(String jobName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      JobId jobId = JobId.of(jobName);
      Job job = bigquery.getJob(jobId);
      System.out.println("Job retrieved successfully");
    } catch (BigQueryException e) {
      System.out.println("Job not retrieved. \n" + e.toString());
    }
  }
}
// [END bigquery_get_job]

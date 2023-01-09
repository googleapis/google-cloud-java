/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.run.v2.samples;

// [START run_v2_generated_Jobs_RunJob_sync]
import com.google.cloud.run.v2.Execution;
import com.google.cloud.run.v2.JobName;
import com.google.cloud.run.v2.JobsClient;
import com.google.cloud.run.v2.RunJobRequest;

public class SyncRunJob {

  public static void main(String[] args) throws Exception {
    syncRunJob();
  }

  public static void syncRunJob() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (JobsClient jobsClient = JobsClient.create()) {
      RunJobRequest request =
          RunJobRequest.newBuilder()
              .setName(JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
              .setValidateOnly(true)
              .setEtag("etag3123477")
              .build();
      Execution response = jobsClient.runJobAsync(request).get();
    }
  }
}
// [END run_v2_generated_Jobs_RunJob_sync]

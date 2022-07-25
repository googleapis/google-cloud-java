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

package com.google.cloud.dataproc.v1.samples;

// [START dataproc_v1_generated_jobcontrollerclient_deletejob_stringstringstring_sync]
import com.google.cloud.dataproc.v1.JobControllerClient;

public class SyncDeleteJobStringStringString {

  public static void main(String[] args) throws Exception {
    syncDeleteJobStringStringString();
  }

  public static void syncDeleteJobStringStringString() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
      String projectId = "projectId-894832108";
      String region = "region-934795532";
      String jobId = "jobId101296568";
      jobControllerClient.deleteJob(projectId, region, jobId);
    }
  }
}
// [END dataproc_v1_generated_jobcontrollerclient_deletejob_stringstringstring_sync]

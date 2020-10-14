/*
 * Copyright 2020 Google LLC
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

package com.example.jobs;

// [START job_search_delete_job_beta]

import com.google.cloud.talent.v4.DeleteJobRequest;
import com.google.cloud.talent.v4.JobName;
import com.google.cloud.talent.v4.JobServiceClient;
import java.io.IOException;

public class JobSearchDeleteJob {

  public static void deleteJob() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String tenantId = "your-tenant-id";
    String jobId = "your-job-id";
    deleteJob(projectId, tenantId, jobId);
  }

  // Delete Job.
  public static void deleteJob(String projectId, String tenantId, String jobId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      JobName name = JobName.of(projectId, tenantId, jobId);

      DeleteJobRequest request = DeleteJobRequest.newBuilder().setName(name.toString()).build();

      jobServiceClient.deleteJob(request);
      System.out.println("Deleted job.");
    }
  }
}
// [END job_search_delete_job_beta]

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

// [START job_search_create_job_beta]

import com.google.cloud.talent.v4.CreateJobRequest;
import com.google.cloud.talent.v4.Job;
import com.google.cloud.talent.v4.JobServiceClient;
import com.google.cloud.talent.v4.TenantName;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JobSearchCreateJob {

  public static void createJob() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String tenantId = "your-tenant-id";
    String companyId = "your-company-id";
    String requisitionId = "your-unique-req-id";
    String jobApplicationUrl = "your-job-url";
    // String projectId = "me-qa-1";
    // String tenantId = "8ed97629-27ee-4215-909b-18cfe3b7e8e3";
    // String companyId = "05317758-b30e-4b26-a57d-d9e54e4cccd8";
    // String requisitionId = "test-requisitionid-1";
    // String jobApplicationUrl = "http://job.url";
    createJob(projectId, tenantId, companyId, requisitionId, jobApplicationUrl);
  }

  // Create a job.
  public static void createJob(
      String projectId,
      String tenantId,
      String companyId,
      String requisitionId,
      String jobApplicationUrl)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      TenantName parent = TenantName.of(projectId, tenantId);
      Job.ApplicationInfo applicationInfo =
          Job.ApplicationInfo.newBuilder().addUris(jobApplicationUrl).build();

      List<String> addresses =
          Arrays.asList(
              "1600 Amphitheatre Parkway, Mountain View, CA 94043",
              "111 8th Avenue, New York, NY 10011");

      // By default, job will expire in 30 days.
      // https://cloud.google.com/talent-solution/job-search/docs/jobs
      Job job =
          Job.newBuilder()
              .setCompany(companyId)
              .setRequisitionId(requisitionId)
              .setTitle("Software Developer")
              .setDescription("Develop, maintain the software solutions.")
              .setApplicationInfo(applicationInfo)
              .addAllAddresses(addresses)
              .setLanguageCode("en-US")
              .build();

      CreateJobRequest request =
          CreateJobRequest.newBuilder().setParent(parent.toString()).setJob(job).build();

      Job response = jobServiceClient.createJob(request);
      System.out.format("Created job: %s%n", response.getName());
    }
  }
}
// [END job_search_create_job_beta]

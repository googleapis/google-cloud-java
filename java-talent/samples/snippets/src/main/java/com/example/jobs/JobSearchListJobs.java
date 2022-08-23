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

// [START job_search_list_jobs]

import com.google.cloud.talent.v4.Job;
import com.google.cloud.talent.v4.JobServiceClient;
import com.google.cloud.talent.v4.ListJobsRequest;
import com.google.cloud.talent.v4.TenantName;
import java.io.IOException;

public class JobSearchListJobs {

  public static void listJobs() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String tenantId = "your-tenant-id";
    String query = "count(base_compensation, [bucket(12, 20)])";
    listJobs(projectId, tenantId, query);
  }

  // Search Jobs with histogram queries.
  public static void listJobs(String projectId, String tenantId, String filter) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      TenantName parent = TenantName.of(projectId, tenantId);
      ListJobsRequest request =
          ListJobsRequest.newBuilder().setParent(parent.toString()).setFilter(filter).build();
      for (Job responseItem : jobServiceClient.listJobs(request).iterateAll()) {
        System.out.format("Job name: %s%n", responseItem.getName());
        System.out.format("Job requisition ID: %s%n", responseItem.getRequisitionId());
        System.out.format("Job title: %s%n", responseItem.getTitle());
        System.out.format("Job description: %s%n", responseItem.getDescription());
      }
    }
  }
}
// [END job_search_list_jobs]

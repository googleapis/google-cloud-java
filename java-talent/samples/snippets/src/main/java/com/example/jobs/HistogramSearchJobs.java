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

// [START job_search_histogram_search]

import com.google.cloud.talent.v4.HistogramQuery;
import com.google.cloud.talent.v4.Job;
import com.google.cloud.talent.v4.JobServiceClient;
import com.google.cloud.talent.v4.RequestMetadata;
import com.google.cloud.talent.v4.SearchJobsRequest;
import com.google.cloud.talent.v4.SearchJobsResponse;
import com.google.cloud.talent.v4.TenantName;
import java.io.IOException;

public class HistogramSearchJobs {

  public static void searchJobs() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String tenantId = "your-tenant-id";
    String query = "count(base_compensation, [bucket(12, 20)])";
    searchJobs(projectId, tenantId, query);
  }

  // Search Jobs with histogram queries.
  public static void searchJobs(String projectId, String tenantId, String query)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      TenantName parent = TenantName.of(projectId, tenantId);

      String domain = "http://www.jobUrl.com";
      String sessionId = "Hashed session identifier";
      String userId = "Hashed user identifier";
      RequestMetadata requestMetadata =
          RequestMetadata.newBuilder()
              .setDomain(domain)
              .setSessionId(sessionId)
              .setUserId(userId)
              .build();
      HistogramQuery histogramQueriesElement =
          HistogramQuery.newBuilder().setHistogramQuery(query).build();
      SearchJobsRequest request =
          SearchJobsRequest.newBuilder()
              .setParent(parent.toString())
              .setRequestMetadata(requestMetadata)
              .addHistogramQueries(histogramQueriesElement)
              .build();

      for (SearchJobsResponse.MatchingJob responseItem :
          jobServiceClient.searchJobs(request).getMatchingJobsList()) {
        System.out.format("Job summary: %s%n", responseItem.getJobSummary());
        System.out.format("Job title snippet: %s%n", responseItem.getJobTitleSnippet());
        Job job = responseItem.getJob();
        System.out.format("Job name: %s%n", job.getName());
        System.out.format("Job title: %s%n", job.getTitle());
      }
    }
  }
}
// [END job_search_histogram_search]

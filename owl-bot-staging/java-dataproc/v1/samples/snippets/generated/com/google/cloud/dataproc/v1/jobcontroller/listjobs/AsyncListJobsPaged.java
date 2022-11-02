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

// [START dataproc_v1_generated_JobController_ListJobs_Paged_async]
import com.google.cloud.dataproc.v1.Job;
import com.google.cloud.dataproc.v1.JobControllerClient;
import com.google.cloud.dataproc.v1.ListJobsRequest;
import com.google.cloud.dataproc.v1.ListJobsResponse;
import com.google.common.base.Strings;

public class AsyncListJobsPaged {

  public static void main(String[] args) throws Exception {
    asyncListJobsPaged();
  }

  public static void asyncListJobsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
      ListJobsRequest request =
          ListJobsRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setRegion("region-934795532")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setClusterName("clusterName-1141738587")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ListJobsResponse response = jobControllerClient.listJobsCallable().call(request);
        for (Job element : response.getJobsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END dataproc_v1_generated_JobController_ListJobs_Paged_async]

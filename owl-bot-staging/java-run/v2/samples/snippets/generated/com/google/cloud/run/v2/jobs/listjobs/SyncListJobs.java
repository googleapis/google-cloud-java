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

// [START run_v2_generated_Jobs_ListJobs_sync]
import com.google.cloud.run.v2.Job;
import com.google.cloud.run.v2.JobsClient;
import com.google.cloud.run.v2.ListJobsRequest;
import com.google.cloud.run.v2.LocationName;

public class SyncListJobs {

  public static void main(String[] args) throws Exception {
    syncListJobs();
  }

  public static void syncListJobs() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (JobsClient jobsClient = JobsClient.create()) {
      ListJobsRequest request =
          ListJobsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setShowDeleted(true)
              .build();
      for (Job element : jobsClient.listJobs(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END run_v2_generated_Jobs_ListJobs_sync]

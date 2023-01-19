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

package com.google.cloud.talent.v4beta1.samples;

// [START jobs_v4beta1_generated_JobService_ListJobs_ProjectnameString_sync]
import com.google.cloud.talent.v4beta1.Job;
import com.google.cloud.talent.v4beta1.JobServiceClient;
import com.google.cloud.talent.v4beta1.ProjectName;

public class SyncListJobsProjectnameString {

  public static void main(String[] args) throws Exception {
    syncListJobsProjectnameString();
  }

  public static void syncListJobsProjectnameString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";
      for (Job element : jobServiceClient.listJobs(parent, filter).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END jobs_v4beta1_generated_JobService_ListJobs_ProjectnameString_sync]

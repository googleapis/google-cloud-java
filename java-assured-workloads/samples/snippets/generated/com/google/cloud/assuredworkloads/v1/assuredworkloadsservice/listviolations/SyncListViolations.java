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

package com.google.cloud.assuredworkloads.v1.samples;

// [START assuredworkloads_v1_generated_AssuredWorkloadsService_ListViolations_sync]
import com.google.cloud.assuredworkloads.v1.AssuredWorkloadsServiceClient;
import com.google.cloud.assuredworkloads.v1.ListViolationsRequest;
import com.google.cloud.assuredworkloads.v1.TimeWindow;
import com.google.cloud.assuredworkloads.v1.Violation;
import com.google.cloud.assuredworkloads.v1.WorkloadName;

public class SyncListViolations {

  public static void main(String[] args) throws Exception {
    syncListViolations();
  }

  public static void syncListViolations() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AssuredWorkloadsServiceClient assuredWorkloadsServiceClient =
        AssuredWorkloadsServiceClient.create()) {
      ListViolationsRequest request =
          ListViolationsRequest.newBuilder()
              .setParent(WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString())
              .setInterval(TimeWindow.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      for (Violation element : assuredWorkloadsServiceClient.listViolations(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END assuredworkloads_v1_generated_AssuredWorkloadsService_ListViolations_sync]

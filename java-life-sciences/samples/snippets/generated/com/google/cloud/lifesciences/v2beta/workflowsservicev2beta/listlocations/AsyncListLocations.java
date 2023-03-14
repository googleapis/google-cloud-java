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

package com.google.cloud.lifesciences.v2beta.samples;

// [START lifesciences_v2beta_generated_WorkflowsServiceV2Beta_ListLocations_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.lifesciences.v2beta.WorkflowsServiceV2BetaClient;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.Location;

public class AsyncListLocations {

  public static void main(String[] args) throws Exception {
    asyncListLocations();
  }

  public static void asyncListLocations() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WorkflowsServiceV2BetaClient workflowsServiceV2BetaClient =
        WorkflowsServiceV2BetaClient.create()) {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<Location> future =
          workflowsServiceV2BetaClient.listLocationsPagedCallable().futureCall(request);
      // Do something.
      for (Location element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END lifesciences_v2beta_generated_WorkflowsServiceV2Beta_ListLocations_async]

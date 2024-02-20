/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.telcoautomation.v1.samples;

// [START telcoautomation_v1_generated_TelcoAutomation_ListBlueprints_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.telcoautomation.v1.Blueprint;
import com.google.cloud.telcoautomation.v1.ListBlueprintsRequest;
import com.google.cloud.telcoautomation.v1.OrchestrationClusterName;
import com.google.cloud.telcoautomation.v1.TelcoAutomationClient;

public class AsyncListBlueprints {

  public static void main(String[] args) throws Exception {
    asyncListBlueprints();
  }

  public static void asyncListBlueprints() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
      ListBlueprintsRequest request =
          ListBlueprintsRequest.newBuilder()
              .setParent(
                  OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
                      .toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<Blueprint> future =
          telcoAutomationClient.listBlueprintsPagedCallable().futureCall(request);
      // Do something.
      for (Blueprint element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END telcoautomation_v1_generated_TelcoAutomation_ListBlueprints_async]

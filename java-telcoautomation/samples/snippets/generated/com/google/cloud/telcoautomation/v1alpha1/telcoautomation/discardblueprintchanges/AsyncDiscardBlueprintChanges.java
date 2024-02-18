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

package com.google.cloud.telcoautomation.v1alpha1.samples;

// [START telcoautomation_v1alpha1_generated_TelcoAutomation_DiscardBlueprintChanges_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.telcoautomation.v1alpha1.BlueprintName;
import com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest;
import com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse;
import com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient;

public class AsyncDiscardBlueprintChanges {

  public static void main(String[] args) throws Exception {
    asyncDiscardBlueprintChanges();
  }

  public static void asyncDiscardBlueprintChanges() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
      DiscardBlueprintChangesRequest request =
          DiscardBlueprintChangesRequest.newBuilder()
              .setName(
                  BlueprintName.of(
                          "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                      .toString())
              .build();
      ApiFuture<DiscardBlueprintChangesResponse> future =
          telcoAutomationClient.discardBlueprintChangesCallable().futureCall(request);
      // Do something.
      DiscardBlueprintChangesResponse response = future.get();
    }
  }
}
// [END telcoautomation_v1alpha1_generated_TelcoAutomation_DiscardBlueprintChanges_async]

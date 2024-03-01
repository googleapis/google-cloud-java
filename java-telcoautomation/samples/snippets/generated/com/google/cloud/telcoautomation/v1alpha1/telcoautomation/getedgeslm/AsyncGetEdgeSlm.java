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

// [START telcoautomation_v1alpha1_generated_TelcoAutomation_GetEdgeSlm_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.telcoautomation.v1alpha1.EdgeSlm;
import com.google.cloud.telcoautomation.v1alpha1.EdgeSlmName;
import com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest;
import com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient;

public class AsyncGetEdgeSlm {

  public static void main(String[] args) throws Exception {
    asyncGetEdgeSlm();
  }

  public static void asyncGetEdgeSlm() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TelcoAutomationClient telcoAutomationClient = TelcoAutomationClient.create()) {
      GetEdgeSlmRequest request =
          GetEdgeSlmRequest.newBuilder()
              .setName(EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]").toString())
              .build();
      ApiFuture<EdgeSlm> future = telcoAutomationClient.getEdgeSlmCallable().futureCall(request);
      // Do something.
      EdgeSlm response = future.get();
    }
  }
}
// [END telcoautomation_v1alpha1_generated_TelcoAutomation_GetEdgeSlm_async]

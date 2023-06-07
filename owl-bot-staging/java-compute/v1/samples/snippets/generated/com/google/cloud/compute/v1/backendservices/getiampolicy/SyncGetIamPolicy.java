/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.compute.v1.samples;

// [START compute_v1_generated_BackendServices_GetIamPolicy_sync]
import com.google.cloud.compute.v1.BackendServicesClient;
import com.google.cloud.compute.v1.GetIamPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.Policy;

public class SyncGetIamPolicy {

  public static void main(String[] args) throws Exception {
    syncGetIamPolicy();
  }

  public static void syncGetIamPolicy() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
      GetIamPolicyBackendServiceRequest request =
          GetIamPolicyBackendServiceRequest.newBuilder()
              .setOptionsRequestedPolicyVersion(-574521795)
              .setProject("project-309310695")
              .setResource("resource-341064690")
              .build();
      Policy response = backendServicesClient.getIamPolicy(request);
    }
  }
}
// [END compute_v1_generated_BackendServices_GetIamPolicy_sync]

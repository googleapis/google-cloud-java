/*
 * Copyright 2026 Google LLC
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

package com.google.iam.v3.samples;

// [START iam_v3_generated_PolicyBindings_CreatePolicyBinding_async]
import com.google.api.core.ApiFuture;
import com.google.iam.v3.CreatePolicyBindingRequest;
import com.google.iam.v3.OrganizationLocationName;
import com.google.iam.v3.PolicyBinding;
import com.google.iam.v3.PolicyBindingsClient;
import com.google.longrunning.Operation;

public class AsyncCreatePolicyBinding {

  public static void main(String[] args) throws Exception {
    asyncCreatePolicyBinding();
  }

  public static void asyncCreatePolicyBinding() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
      CreatePolicyBindingRequest request =
          CreatePolicyBindingRequest.newBuilder()
              .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
              .setPolicyBindingId("policyBindingId1375821166")
              .setPolicyBinding(PolicyBinding.newBuilder().build())
              .setValidateOnly(true)
              .build();
      ApiFuture<Operation> future =
          policyBindingsClient.createPolicyBindingCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END iam_v3_generated_PolicyBindings_CreatePolicyBinding_async]

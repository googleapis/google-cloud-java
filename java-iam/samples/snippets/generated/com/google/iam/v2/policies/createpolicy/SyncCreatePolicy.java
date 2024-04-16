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

package com.google.iam.v2.samples;

// [START iam_v2_generated_Policies_CreatePolicy_sync]
import com.google.iam.v2.CreatePolicyRequest;
import com.google.iam.v2.PoliciesClient;
import com.google.iam.v2.Policy;

public class SyncCreatePolicy {

  public static void main(String[] args) throws Exception {
    syncCreatePolicy();
  }

  public static void syncCreatePolicy() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PoliciesClient policiesClient = PoliciesClient.create()) {
      CreatePolicyRequest request =
          CreatePolicyRequest.newBuilder()
              .setParent("parent-995424086")
              .setPolicy(Policy.newBuilder().build())
              .setPolicyId("policyId546908653")
              .build();
      Policy response = policiesClient.createPolicyAsync(request).get();
    }
  }
}
// [END iam_v2_generated_Policies_CreatePolicy_sync]

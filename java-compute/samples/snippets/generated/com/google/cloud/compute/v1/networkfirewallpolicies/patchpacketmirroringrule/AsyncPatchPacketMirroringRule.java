/*
 * Copyright 2025 Google LLC
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

// [START compute_v1_generated_NetworkFirewallPolicies_PatchPacketMirroringRule_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.compute.v1.FirewallPolicyRule;
import com.google.cloud.compute.v1.NetworkFirewallPoliciesClient;
import com.google.cloud.compute.v1.PatchPacketMirroringRuleNetworkFirewallPolicyRequest;
import com.google.longrunning.Operation;

public class AsyncPatchPacketMirroringRule {

  public static void main(String[] args) throws Exception {
    asyncPatchPacketMirroringRule();
  }

  public static void asyncPatchPacketMirroringRule() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
        NetworkFirewallPoliciesClient.create()) {
      PatchPacketMirroringRuleNetworkFirewallPolicyRequest request =
          PatchPacketMirroringRuleNetworkFirewallPolicyRequest.newBuilder()
              .setFirewallPolicy("firewallPolicy1819692626")
              .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
              .setPriority(-1165461084)
              .setProject("project-309310695")
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Operation> future =
          networkFirewallPoliciesClient.patchPacketMirroringRuleCallable().futureCall(request);
      // Do something.
      com.google.cloud.compute.v1.Operation response = future.get();
    }
  }
}
// [END compute_v1_generated_NetworkFirewallPolicies_PatchPacketMirroringRule_async]

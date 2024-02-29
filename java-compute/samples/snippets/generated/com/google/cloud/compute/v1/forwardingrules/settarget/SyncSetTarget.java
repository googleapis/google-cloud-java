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

package com.google.cloud.compute.v1.samples;

// [START compute_v1_generated_ForwardingRules_SetTarget_sync]
import com.google.cloud.compute.v1.ForwardingRulesClient;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetTargetForwardingRuleRequest;
import com.google.cloud.compute.v1.TargetReference;

public class SyncSetTarget {

  public static void main(String[] args) throws Exception {
    syncSetTarget();
  }

  public static void syncSetTarget() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
      SetTargetForwardingRuleRequest request =
          SetTargetForwardingRuleRequest.newBuilder()
              .setForwardingRule("forwardingRule-1429104743")
              .setProject("project-309310695")
              .setRegion("region-934795532")
              .setRequestId("requestId693933066")
              .setTargetReferenceResource(TargetReference.newBuilder().build())
              .build();
      Operation response = forwardingRulesClient.setTargetAsync(request).get();
    }
  }
}
// [END compute_v1_generated_ForwardingRules_SetTarget_sync]

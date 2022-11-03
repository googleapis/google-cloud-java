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

package com.google.cloud.orgpolicy.v2.samples;

// [START orgpolicy_v2_generated_OrgPolicy_DeletePolicy_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.orgpolicy.v2.DeletePolicyRequest;
import com.google.cloud.orgpolicy.v2.OrgPolicyClient;
import com.google.cloud.orgpolicy.v2.PolicyName;
import com.google.protobuf.Empty;

public class AsyncDeletePolicy {

  public static void main(String[] args) throws Exception {
    asyncDeletePolicy();
  }

  public static void asyncDeletePolicy() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
      DeletePolicyRequest request =
          DeletePolicyRequest.newBuilder()
              .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
              .build();
      ApiFuture<Empty> future = orgPolicyClient.deletePolicyCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END orgpolicy_v2_generated_OrgPolicy_DeletePolicy_async]

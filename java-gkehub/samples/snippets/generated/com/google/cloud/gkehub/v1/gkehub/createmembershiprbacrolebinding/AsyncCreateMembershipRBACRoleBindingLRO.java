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

package com.google.cloud.gkehub.v1.samples;

// [START gkehub_v1_generated_GkeHub_CreateMembershipRBACRoleBinding_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.GkeHubClient;
import com.google.cloud.gkehub.v1.OperationMetadata;
import com.google.cloud.gkehub.v1.RBACRoleBinding;
import com.google.cloud.gkehub.v1.ScopeName;

public class AsyncCreateMembershipRBACRoleBindingLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateMembershipRBACRoleBindingLRO();
  }

  public static void asyncCreateMembershipRBACRoleBindingLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
      CreateMembershipRBACRoleBindingRequest request =
          CreateMembershipRBACRoleBindingRequest.newBuilder()
              .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
              .setRbacrolebindingId("rbacrolebindingId827577784")
              .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
              .build();
      OperationFuture<RBACRoleBinding, OperationMetadata> future =
          gkeHubClient.createMembershipRBACRoleBindingOperationCallable().futureCall(request);
      // Do something.
      RBACRoleBinding response = future.get();
    }
  }
}
// [END gkehub_v1_generated_GkeHub_CreateMembershipRBACRoleBinding_LRO_async]

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

package com.google.cloud.kms.v1.samples;

// [START cloudkms_v1_generated_HsmManagement_CreateSingleTenantHsmInstanceProposal_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalMetadata;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.HsmManagementClient;
import com.google.cloud.kms.v1.SingleTenantHsmInstanceName;
import com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal;

public class AsyncCreateSingleTenantHsmInstanceProposalLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateSingleTenantHsmInstanceProposalLRO();
  }

  public static void asyncCreateSingleTenantHsmInstanceProposalLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (HsmManagementClient hsmManagementClient = HsmManagementClient.create()) {
      CreateSingleTenantHsmInstanceProposalRequest request =
          CreateSingleTenantHsmInstanceProposalRequest.newBuilder()
              .setParent(
                  SingleTenantHsmInstanceName.of(
                          "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
                      .toString())
              .setSingleTenantHsmInstanceProposalId("singleTenantHsmInstanceProposalId-994202990")
              .setSingleTenantHsmInstanceProposal(
                  SingleTenantHsmInstanceProposal.newBuilder().build())
              .build();
      OperationFuture<
              SingleTenantHsmInstanceProposal, CreateSingleTenantHsmInstanceProposalMetadata>
          future =
              hsmManagementClient
                  .createSingleTenantHsmInstanceProposalOperationCallable()
                  .futureCall(request);
      // Do something.
      SingleTenantHsmInstanceProposal response = future.get();
    }
  }
}
// [END cloudkms_v1_generated_HsmManagement_CreateSingleTenantHsmInstanceProposal_LRO_async]

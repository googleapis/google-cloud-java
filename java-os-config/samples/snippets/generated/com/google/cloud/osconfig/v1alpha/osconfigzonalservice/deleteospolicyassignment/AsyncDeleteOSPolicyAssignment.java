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

package com.google.cloud.osconfig.v1alpha.samples;

// [START osconfig_v1alpha_generated_OsConfigZonalService_DeleteOSPolicyAssignment_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest;
import com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentName;
import com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceClient;
import com.google.longrunning.Operation;

public class AsyncDeleteOSPolicyAssignment {

  public static void main(String[] args) throws Exception {
    asyncDeleteOSPolicyAssignment();
  }

  public static void asyncDeleteOSPolicyAssignment() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OsConfigZonalServiceClient osConfigZonalServiceClient =
        OsConfigZonalServiceClient.create()) {
      DeleteOSPolicyAssignmentRequest request =
          DeleteOSPolicyAssignmentRequest.newBuilder()
              .setName(
                  OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
                      .toString())
              .build();
      ApiFuture<Operation> future =
          osConfigZonalServiceClient.deleteOSPolicyAssignmentCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END osconfig_v1alpha_generated_OsConfigZonalService_DeleteOSPolicyAssignment_async]

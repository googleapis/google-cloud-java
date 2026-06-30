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

package com.google.cloud.networksecurity.v1.samples;

// [START networksecurity_v1_generated_NetworkSecurity_UpdateTlsInspectionPolicy_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.networksecurity.v1.NetworkSecurityClient;
import com.google.cloud.networksecurity.v1.TlsInspectionPolicy;
import com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;

public class AsyncUpdateTlsInspectionPolicy {

  public static void main(String[] args) throws Exception {
    asyncUpdateTlsInspectionPolicy();
  }

  public static void asyncUpdateTlsInspectionPolicy() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
      UpdateTlsInspectionPolicyRequest request =
          UpdateTlsInspectionPolicyRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setTlsInspectionPolicy(TlsInspectionPolicy.newBuilder().build())
              .build();
      ApiFuture<Operation> future =
          networkSecurityClient.updateTlsInspectionPolicyCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END networksecurity_v1_generated_NetworkSecurity_UpdateTlsInspectionPolicy_async]

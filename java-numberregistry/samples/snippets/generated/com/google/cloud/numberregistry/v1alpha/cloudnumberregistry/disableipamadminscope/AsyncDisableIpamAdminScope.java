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

package com.google.cloud.numberregistry.v1alpha.samples;

// [START cloudnumberregistry_v1alpha_generated_CloudNumberRegistry_DisableIpamAdminScope_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient;
import com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.IpamAdminScopeName;
import com.google.longrunning.Operation;

public class AsyncDisableIpamAdminScope {

  public static void main(String[] args) throws Exception {
    asyncDisableIpamAdminScope();
  }

  public static void asyncDisableIpamAdminScope() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
      DisableIpamAdminScopeRequest request =
          DisableIpamAdminScopeRequest.newBuilder()
              .setName(
                  IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Operation> future =
          cloudNumberRegistryClient.disableIpamAdminScopeCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END cloudnumberregistry_v1alpha_generated_CloudNumberRegistry_DisableIpamAdminScope_async]

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

package com.google.cloud.talent.v4beta1.samples;

// [START talent_v4beta1_generated_tenantserviceclient_deletetenant_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.talent.v4beta1.DeleteTenantRequest;
import com.google.cloud.talent.v4beta1.TenantName;
import com.google.cloud.talent.v4beta1.TenantServiceClient;
import com.google.protobuf.Empty;

public class AsyncDeleteTenant {

  public static void main(String[] args) throws Exception {
    asyncDeleteTenant();
  }

  public static void asyncDeleteTenant() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (TenantServiceClient tenantServiceClient = TenantServiceClient.create()) {
      DeleteTenantRequest request =
          DeleteTenantRequest.newBuilder()
              .setName(TenantName.of("[PROJECT]", "[TENANT]").toString())
              .build();
      ApiFuture<Empty> future = tenantServiceClient.deleteTenantCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END talent_v4beta1_generated_tenantserviceclient_deletetenant_async]

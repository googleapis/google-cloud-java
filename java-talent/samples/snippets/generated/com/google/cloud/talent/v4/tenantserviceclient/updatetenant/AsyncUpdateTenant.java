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

package com.google.cloud.talent.v4.samples;

// [START talent_v4_generated_tenantserviceclient_updatetenant_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.talent.v4.Tenant;
import com.google.cloud.talent.v4.TenantServiceClient;
import com.google.cloud.talent.v4.UpdateTenantRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateTenant {

  public static void main(String[] args) throws Exception {
    asyncUpdateTenant();
  }

  public static void asyncUpdateTenant() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TenantServiceClient tenantServiceClient = TenantServiceClient.create()) {
      UpdateTenantRequest request =
          UpdateTenantRequest.newBuilder()
              .setTenant(Tenant.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      ApiFuture<Tenant> future = tenantServiceClient.updateTenantCallable().futureCall(request);
      // Do something.
      Tenant response = future.get();
    }
  }
}
// [END talent_v4_generated_tenantserviceclient_updatetenant_async]

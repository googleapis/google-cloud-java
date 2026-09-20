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

package com.google.ads.marketingplatform.admin.v1alpha.samples;

// [START marketingplatformadmin_v1alpha_generated_MarketingplatformAdminService_CreateAdminAccessBinding_async]
import com.google.ads.marketingplatform.admin.v1alpha.AdminAccessBinding;
import com.google.ads.marketingplatform.admin.v1alpha.CreateAdminAccessBindingRequest;
import com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient;
import com.google.ads.marketingplatform.admin.v1alpha.OrganizationName;
import com.google.api.core.ApiFuture;

public class AsyncCreateAdminAccessBinding {

  public static void main(String[] args) throws Exception {
    asyncCreateAdminAccessBinding();
  }

  public static void asyncCreateAdminAccessBinding() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
        MarketingplatformAdminServiceClient.create()) {
      CreateAdminAccessBindingRequest request =
          CreateAdminAccessBindingRequest.newBuilder()
              .setParent(OrganizationName.of("[ORGANIZATION]").toString())
              .setAdminAccessBinding(AdminAccessBinding.newBuilder().build())
              .build();
      ApiFuture<AdminAccessBinding> future =
          marketingplatformAdminServiceClient
              .createAdminAccessBindingCallable()
              .futureCall(request);
      // Do something.
      AdminAccessBinding response = future.get();
    }
  }
}
// [END marketingplatformadmin_v1alpha_generated_MarketingplatformAdminService_CreateAdminAccessBinding_async]

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

package com.google.ads.marketingplatform.admin.v1alpha.samples;

// [START marketingplatformadmin_v1alpha_generated_MarketingplatformAdminService_CreateAnalyticsAccountLink_async]
import com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink;
import com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest;
import com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient;
import com.google.ads.marketingplatform.admin.v1alpha.OrganizationName;
import com.google.api.core.ApiFuture;

public class AsyncCreateAnalyticsAccountLink {

  public static void main(String[] args) throws Exception {
    asyncCreateAnalyticsAccountLink();
  }

  public static void asyncCreateAnalyticsAccountLink() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
        MarketingplatformAdminServiceClient.create()) {
      CreateAnalyticsAccountLinkRequest request =
          CreateAnalyticsAccountLinkRequest.newBuilder()
              .setParent(OrganizationName.of("[ORGANIZATION]").toString())
              .setAnalyticsAccountLink(AnalyticsAccountLink.newBuilder().build())
              .build();
      ApiFuture<AnalyticsAccountLink> future =
          marketingplatformAdminServiceClient
              .createAnalyticsAccountLinkCallable()
              .futureCall(request);
      // Do something.
      AnalyticsAccountLink response = future.get();
    }
  }
}
// [END marketingplatformadmin_v1alpha_generated_MarketingplatformAdminService_CreateAnalyticsAccountLink_async]

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

// [START marketingplatformadmin_v1alpha_generated_MarketingplatformAdminService_DeleteAnalyticsAccountLink_async]
import com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLinkName;
import com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest;
import com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient;
import com.google.api.core.ApiFuture;
import com.google.protobuf.Empty;

public class AsyncDeleteAnalyticsAccountLink {

  public static void main(String[] args) throws Exception {
    asyncDeleteAnalyticsAccountLink();
  }

  public static void asyncDeleteAnalyticsAccountLink() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
        MarketingplatformAdminServiceClient.create()) {
      DeleteAnalyticsAccountLinkRequest request =
          DeleteAnalyticsAccountLinkRequest.newBuilder()
              .setName(
                  AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]")
                      .toString())
              .build();
      ApiFuture<Empty> future =
          marketingplatformAdminServiceClient
              .deleteAnalyticsAccountLinkCallable()
              .futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END marketingplatformadmin_v1alpha_generated_MarketingplatformAdminService_DeleteAnalyticsAccountLink_async]

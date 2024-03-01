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

package com.google.analytics.admin.v1alpha.samples;

// [START analyticsadmin_v1alpha_generated_AnalyticsAdminService_GetDisplayVideo360AdvertiserLink_sync]
import com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient;
import com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink;
import com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkName;
import com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest;

public class SyncGetDisplayVideo360AdvertiserLink {

  public static void main(String[] args) throws Exception {
    syncGetDisplayVideo360AdvertiserLink();
  }

  public static void syncGetDisplayVideo360AdvertiserLink() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
        AnalyticsAdminServiceClient.create()) {
      GetDisplayVideo360AdvertiserLinkRequest request =
          GetDisplayVideo360AdvertiserLinkRequest.newBuilder()
              .setName(
                  DisplayVideo360AdvertiserLinkName.of(
                          "[PROPERTY]", "[DISPLAY_VIDEO_360_ADVERTISER_LINK]")
                      .toString())
              .build();
      DisplayVideo360AdvertiserLink response =
          analyticsAdminServiceClient.getDisplayVideo360AdvertiserLink(request);
    }
  }
}
// [END analyticsadmin_v1alpha_generated_AnalyticsAdminService_GetDisplayVideo360AdvertiserLink_sync]

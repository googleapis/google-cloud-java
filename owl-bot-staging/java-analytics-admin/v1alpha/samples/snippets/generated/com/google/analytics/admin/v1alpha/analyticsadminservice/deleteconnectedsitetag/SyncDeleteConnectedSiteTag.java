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

// [START analyticsadmin_v1alpha_generated_AnalyticsAdminService_DeleteConnectedSiteTag_sync]
import com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient;
import com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest;
import com.google.protobuf.Empty;

public class SyncDeleteConnectedSiteTag {

  public static void main(String[] args) throws Exception {
    syncDeleteConnectedSiteTag();
  }

  public static void syncDeleteConnectedSiteTag() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
        AnalyticsAdminServiceClient.create()) {
      DeleteConnectedSiteTagRequest request =
          DeleteConnectedSiteTagRequest.newBuilder()
              .setProperty("property-993141291")
              .setTagId("tagId110119509")
              .build();
      analyticsAdminServiceClient.deleteConnectedSiteTag(request);
    }
  }
}
// [END analyticsadmin_v1alpha_generated_AnalyticsAdminService_DeleteConnectedSiteTag_sync]

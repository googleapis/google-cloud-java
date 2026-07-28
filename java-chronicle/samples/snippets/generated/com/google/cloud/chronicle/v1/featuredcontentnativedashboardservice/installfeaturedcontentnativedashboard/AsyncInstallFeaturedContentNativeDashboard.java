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

package com.google.cloud.chronicle.v1.samples;

// [START chronicle_v1_generated_FeaturedContentNativeDashboardService_InstallFeaturedContentNativeDashboard_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard;
import com.google.cloud.chronicle.v1.FeaturedContentNativeDashboardName;
import com.google.cloud.chronicle.v1.FeaturedContentNativeDashboardServiceClient;
import com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest;
import com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse;

public class AsyncInstallFeaturedContentNativeDashboard {

  public static void main(String[] args) throws Exception {
    asyncInstallFeaturedContentNativeDashboard();
  }

  public static void asyncInstallFeaturedContentNativeDashboard() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
        FeaturedContentNativeDashboardServiceClient.create()) {
      InstallFeaturedContentNativeDashboardRequest request =
          InstallFeaturedContentNativeDashboardRequest.newBuilder()
              .setName(
                  FeaturedContentNativeDashboardName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[INSTANCE]",
                          "[FEATURED_CONTENT_NATIVE_DASHBOARD]")
                      .toString())
              .setFeaturedContentNativeDashboard(
                  FeaturedContentNativeDashboard.newBuilder().build())
              .build();
      ApiFuture<InstallFeaturedContentNativeDashboardResponse> future =
          featuredContentNativeDashboardServiceClient
              .installFeaturedContentNativeDashboardCallable()
              .futureCall(request);
      // Do something.
      InstallFeaturedContentNativeDashboardResponse response = future.get();
    }
  }
}
// [END chronicle_v1_generated_FeaturedContentNativeDashboardService_InstallFeaturedContentNativeDashboard_async]

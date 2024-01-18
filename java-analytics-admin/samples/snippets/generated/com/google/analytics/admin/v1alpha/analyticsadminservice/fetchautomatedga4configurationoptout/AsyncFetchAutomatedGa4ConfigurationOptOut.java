/*
 * Copyright 2023 Google LLC
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

// [START analyticsadmin_v1alpha_generated_AnalyticsAdminService_FetchAutomatedGa4ConfigurationOptOut_async]
import com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient;
import com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutRequest;
import com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutResponse;
import com.google.api.core.ApiFuture;

public class AsyncFetchAutomatedGa4ConfigurationOptOut {

  public static void main(String[] args) throws Exception {
    asyncFetchAutomatedGa4ConfigurationOptOut();
  }

  public static void asyncFetchAutomatedGa4ConfigurationOptOut() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
        AnalyticsAdminServiceClient.create()) {
      FetchAutomatedGa4ConfigurationOptOutRequest request =
          FetchAutomatedGa4ConfigurationOptOutRequest.newBuilder()
              .setProperty("property-993141291")
              .build();
      ApiFuture<FetchAutomatedGa4ConfigurationOptOutResponse> future =
          analyticsAdminServiceClient
              .fetchAutomatedGa4ConfigurationOptOutCallable()
              .futureCall(request);
      // Do something.
      FetchAutomatedGa4ConfigurationOptOutResponse response = future.get();
    }
  }
}
// [END analyticsadmin_v1alpha_generated_AnalyticsAdminService_FetchAutomatedGa4ConfigurationOptOut_async]

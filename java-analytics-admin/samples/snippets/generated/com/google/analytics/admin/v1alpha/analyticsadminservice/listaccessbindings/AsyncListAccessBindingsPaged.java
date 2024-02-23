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

// [START analyticsadmin_v1alpha_generated_AnalyticsAdminService_ListAccessBindings_Paged_async]
import com.google.analytics.admin.v1alpha.AccessBinding;
import com.google.analytics.admin.v1alpha.AccountName;
import com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient;
import com.google.analytics.admin.v1alpha.ListAccessBindingsRequest;
import com.google.analytics.admin.v1alpha.ListAccessBindingsResponse;
import com.google.common.base.Strings;

public class AsyncListAccessBindingsPaged {

  public static void main(String[] args) throws Exception {
    asyncListAccessBindingsPaged();
  }

  public static void asyncListAccessBindingsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
        AnalyticsAdminServiceClient.create()) {
      ListAccessBindingsRequest request =
          ListAccessBindingsRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListAccessBindingsResponse response =
            analyticsAdminServiceClient.listAccessBindingsCallable().call(request);
        for (AccessBinding element : response.getAccessBindingsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END analyticsadmin_v1alpha_generated_AnalyticsAdminService_ListAccessBindings_Paged_async]

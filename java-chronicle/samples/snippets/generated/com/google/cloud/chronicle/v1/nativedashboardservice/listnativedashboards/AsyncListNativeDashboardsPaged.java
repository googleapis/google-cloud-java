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

// [START chronicle_v1_generated_NativeDashboardService_ListNativeDashboards_Paged_async]
import com.google.cloud.chronicle.v1.InstanceName;
import com.google.cloud.chronicle.v1.ListNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ListNativeDashboardsResponse;
import com.google.cloud.chronicle.v1.NativeDashboard;
import com.google.cloud.chronicle.v1.NativeDashboardServiceClient;
import com.google.cloud.chronicle.v1.NativeDashboardView;
import com.google.common.base.Strings;

public class AsyncListNativeDashboardsPaged {

  public static void main(String[] args) throws Exception {
    asyncListNativeDashboardsPaged();
  }

  public static void asyncListNativeDashboardsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NativeDashboardServiceClient nativeDashboardServiceClient =
        NativeDashboardServiceClient.create()) {
      ListNativeDashboardsRequest request =
          ListNativeDashboardsRequest.newBuilder()
              .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setView(NativeDashboardView.forNumber(0))
              .build();
      while (true) {
        ListNativeDashboardsResponse response =
            nativeDashboardServiceClient.listNativeDashboardsCallable().call(request);
        for (NativeDashboard element : response.getNativeDashboardsList()) {
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
// [END chronicle_v1_generated_NativeDashboardService_ListNativeDashboards_Paged_async]

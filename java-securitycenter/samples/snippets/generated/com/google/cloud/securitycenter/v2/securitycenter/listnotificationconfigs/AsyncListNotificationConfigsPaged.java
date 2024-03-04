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

package com.google.cloud.securitycenter.v2.samples;

// [START securitycenter_v2_generated_SecurityCenter_ListNotificationConfigs_Paged_async]
import com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest;
import com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse;
import com.google.cloud.securitycenter.v2.NotificationConfig;
import com.google.cloud.securitycenter.v2.OrganizationLocationName;
import com.google.cloud.securitycenter.v2.SecurityCenterClient;
import com.google.common.base.Strings;

public class AsyncListNotificationConfigsPaged {

  public static void main(String[] args) throws Exception {
    asyncListNotificationConfigsPaged();
  }

  public static void asyncListNotificationConfigsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
      ListNotificationConfigsRequest request =
          ListNotificationConfigsRequest.newBuilder()
              .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      while (true) {
        ListNotificationConfigsResponse response =
            securityCenterClient.listNotificationConfigsCallable().call(request);
        for (NotificationConfig element : response.getNotificationConfigsList()) {
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
// [END securitycenter_v2_generated_SecurityCenter_ListNotificationConfigs_Paged_async]

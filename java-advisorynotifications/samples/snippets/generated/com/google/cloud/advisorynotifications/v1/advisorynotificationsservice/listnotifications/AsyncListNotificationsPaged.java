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

package com.google.cloud.advisorynotifications.v1.samples;

// [START advisorynotifications_v1_generated_AdvisoryNotificationsService_ListNotifications_Paged_async]
import com.google.cloud.advisorynotifications.v1.AdvisoryNotificationsServiceClient;
import com.google.cloud.advisorynotifications.v1.ListNotificationsRequest;
import com.google.cloud.advisorynotifications.v1.ListNotificationsResponse;
import com.google.cloud.advisorynotifications.v1.LocationName;
import com.google.cloud.advisorynotifications.v1.Notification;
import com.google.cloud.advisorynotifications.v1.NotificationView;
import com.google.common.base.Strings;

public class AsyncListNotificationsPaged {

  public static void main(String[] args) throws Exception {
    asyncListNotificationsPaged();
  }

  public static void asyncListNotificationsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdvisoryNotificationsServiceClient advisoryNotificationsServiceClient =
        AdvisoryNotificationsServiceClient.create()) {
      ListNotificationsRequest request =
          ListNotificationsRequest.newBuilder()
              .setParent(
                  LocationName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setView(NotificationView.forNumber(0))
              .setLanguageCode("languageCode-2092349083")
              .build();
      while (true) {
        ListNotificationsResponse response =
            advisoryNotificationsServiceClient.listNotificationsCallable().call(request);
        for (Notification element : response.getNotificationsList()) {
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
// [END advisorynotifications_v1_generated_AdvisoryNotificationsService_ListNotifications_Paged_async]

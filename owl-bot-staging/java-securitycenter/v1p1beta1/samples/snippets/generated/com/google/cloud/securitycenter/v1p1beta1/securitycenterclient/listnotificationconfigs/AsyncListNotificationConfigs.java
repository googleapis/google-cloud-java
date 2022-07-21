/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.securitycenter.v1p1beta1.samples;

// [START securitycenter_v1p1beta1_generated_securitycenterclient_listnotificationconfigs_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsRequest;
import com.google.cloud.securitycenter.v1p1beta1.NotificationConfig;
import com.google.cloud.securitycenter.v1p1beta1.OrganizationName;
import com.google.cloud.securitycenter.v1p1beta1.SecurityCenterClient;

public class AsyncListNotificationConfigs {

  public static void main(String[] args) throws Exception {
    asyncListNotificationConfigs();
  }

  public static void asyncListNotificationConfigs() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
      ListNotificationConfigsRequest request =
          ListNotificationConfigsRequest.newBuilder()
              .setParent(OrganizationName.of("[ORGANIZATION]").toString())
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      ApiFuture<NotificationConfig> future =
          securityCenterClient.listNotificationConfigsPagedCallable().futureCall(request);
      // Do something.
      for (NotificationConfig element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END securitycenter_v1p1beta1_generated_securitycenterclient_listnotificationconfigs_async]

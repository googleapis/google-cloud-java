/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.examples.securitycenter.snippets;

// [START securitycenter_get_notification_config]
// [START scc_get_notification_config]
import com.google.cloud.securitycenter.v1.NotificationConfig;
import com.google.cloud.securitycenter.v1.NotificationConfigName;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import java.io.IOException;
// [END scc_get_notification_config]
// [END securitycenter_get_notification_config]

/** Snippets for how to GetNotificationConfig. */
final class GetNotificationConfigSnippets {
  private GetNotificationConfigSnippets() {}

  // [START securitycenter_get_notification_config]
  // [START scc_get_notification_config]
  public static NotificationConfig getNotificationConfig(
      String organizationId, String notificationConfigId) throws IOException {

    // String organizationId = "{your-org-id}";
    // String notificationConfigId = "{config-id}";

    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      NotificationConfig response =
          client.getNotificationConfig(
              NotificationConfigName.newBuilder()
                  .setOrganization(organizationId)
                  .setNotificationConfig(notificationConfigId)
                  .build());

      System.out.println(String.format("Notification config: %s", response));
      return response;
    }
  }
  // [END scc_get_notification_config]
  // [END securitycenter_get_notification_config]
}

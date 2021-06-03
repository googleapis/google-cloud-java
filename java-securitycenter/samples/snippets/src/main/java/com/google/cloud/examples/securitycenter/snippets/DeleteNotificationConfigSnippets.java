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

// [START securitycenter_delete_notification_config]
import com.google.cloud.securitycenter.v1.NotificationConfigName;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import java.io.IOException;

/** Snippets for how to Delete NotificationConfigs. */
final class DeleteNotificationConfigSnippets {
  private DeleteNotificationConfigSnippets() {}

  public static boolean deleteNotificationConfig(String organizationId, String notificationConfigId)
      throws IOException {
    // String organizationId = "{your-org-id}";
    // String notificationConfigId = "{config-id}";

    NotificationConfigName notificationConfigName =
        NotificationConfigName.newBuilder()
            .setOrganization(organizationId)
            .setNotificationConfig(notificationConfigId)
            .build();

    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      client.deleteNotificationConfig(notificationConfigName);

      System.out.println(String.format("Deleted Notification config: %s", notificationConfigName));
    }

    return true;
  }
}
// [END securitycenter_delete_notification_config]

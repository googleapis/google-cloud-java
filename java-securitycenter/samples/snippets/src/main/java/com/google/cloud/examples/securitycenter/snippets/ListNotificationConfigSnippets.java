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

// [START securitycenter_list_notification_configs]
// [START scc_list_notification_configs]
import com.google.cloud.securitycenter.v1.NotificationConfig;
import com.google.cloud.securitycenter.v1.OrganizationName;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import com.google.cloud.securitycenter.v1.SecurityCenterClient.ListNotificationConfigsPagedResponse;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
// [END scc_list_notification_configs]
// [END securitycenter_list_notification_configs]

/** Snippets for how to ListNotificationConfig. */
final class ListNotificationConfigSnippets {
  private ListNotificationConfigSnippets() {}

  // [START securitycenter_list_notification_configs]
  // [START scc_list_notification_configs]
  public static ImmutableList<NotificationConfig> listNotificationConfigs(String organizationId)
      throws IOException {
    // String organizationId = "{your-org-id}";

    OrganizationName orgName =
        OrganizationName.newBuilder().setOrganization(organizationId).build();

    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      ListNotificationConfigsPagedResponse response = client.listNotificationConfigs(orgName);

      ImmutableList<NotificationConfig> notificationConfigs =
          ImmutableList.copyOf(response.iterateAll());
      System.out.println(
          String.format("List notifications response: %s", response.getPage().getValues()));
      return notificationConfigs;
    }
  }
  // [END scc_list_notification_configs]
  // [END securitycenter_list_notification_configs]

}

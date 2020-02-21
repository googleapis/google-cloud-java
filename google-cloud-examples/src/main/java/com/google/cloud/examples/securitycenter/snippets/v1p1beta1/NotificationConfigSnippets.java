/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.examples.securitycenter.snippets.v1p1beta1;

import com.google.cloud.securitycenter.v1p1beta1.CreateNotificationConfigRequest;
import com.google.cloud.securitycenter.v1p1beta1.NotificationConfig;
import com.google.cloud.securitycenter.v1p1beta1.NotificationConfig.EventType;
import com.google.cloud.securitycenter.v1p1beta1.NotificationConfig.StreamingConfig;
import com.google.cloud.securitycenter.v1p1beta1.NotificationConfigName;
import com.google.cloud.securitycenter.v1p1beta1.OrganizationName;
import com.google.cloud.securitycenter.v1p1beta1.SecurityCenterClient;
import com.google.cloud.securitycenter.v1p1beta1.SecurityCenterClient.ListNotificationConfigsPagedResponse;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.FieldMask;
import java.io.IOException;

/** Snippets for how to work with Notifications in Cloud SCC. */
final class NotificationConfigSnippets {
  private NotificationConfigSnippets() {}

  public static NotificationConfig createNotificationConfig(
      String organizationId, String pubsubTopic, String notificationConfigId) throws IOException {

    // [START scc_create_notification_config]
    // TODO(UpdateMe) String organizationId = "{your-org-id}";
    // TODO(UpdateMe) String notificationConfigId = "config-id";
    // TODO(UpdateMe) String pubsubTopic = "projects/{your-project}/topics/{your-topic}";
    // Ensure this ServiceAccount has the "pubsub.topics.setIamPolicy" permission on the topic.

    String orgName = String.format("organizations/%s", organizationId);

    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      CreateNotificationConfigRequest request =
          CreateNotificationConfigRequest.newBuilder()
              .setParent(orgName)
              .setConfigId(notificationConfigId)
              .setNotificationConfig(
                  NotificationConfig.newBuilder()
                      .setDescription("Java notification config")
                      .setPubsubTopic(pubsubTopic)
                      .setEventType(EventType.FINDING)
                      .setStreamingConfig(
                          StreamingConfig.newBuilder().setFilter("state = \"ACTIVE\"").build())
                      .build())
              .build();

      NotificationConfig response = client.createNotificationConfig(request);
      System.out.println(String.format("Notification config was created: %s", response));
      return response;
    }
    // [END scc_create_notification_config]
  }

  public static boolean deleteNotificationConfig(String organizationId, String notificationConfigId)
      throws IOException {

    // [START scc_delete_notification_config]
    // TODO(UpdateMe) String organizationId = "{your-org-id}";
    // TODO(UpdateMe) String notificationConfigId = "config-id";

    NotificationConfigName notificationConfigName =
        NotificationConfigName.newBuilder()
            .setOrganization(organizationId)
            .setNotificationConfig(notificationConfigId)
            .build();

    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      client.deleteNotificationConfig(notificationConfigName);

      System.out.println(String.format("Deleted Notification config: %s", notificationConfigName));
    }
    // [END scc_delete_notification_config]

    return true;
  }

  public static NotificationConfig getNotificationConfig(
      String organizationId, String notificationConfigId) throws IOException {

    // [START scc_get_notification_config]
    // TODO(UpdateMe) String organizationId = "{your-org-id}";
    // TODO(UpdateMe) String notificationConfigId = "config-id";

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
    // [END scc_get_notification_config]
  }

  public static ImmutableList<NotificationConfig> listNotificationConfigs(String organizationId)
      throws IOException {
    // [START scc_list_notification_configs]
    // TODO(UpdateMe) String organizationId = "{your-org-id}";

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
    // [END scc_list_notification_configs]
  }

  public static NotificationConfig updateNotificationConfig(
      String organizationId, String notificationConfigId, String pubsubTopic) throws IOException {
    // [START scc_update_notification_config]
    // TODO(UpdateMe) String organizationId = "{your-org-id}";
    // TODO(UpdateMe) String notificationConfigId = "{your-config-id}";
    String notificationConfigName =
        String.format(
            "organizations/%s/notificationConfigs/%s", organizationId, notificationConfigId);

    // TODO(UpdateMe) String pubsubTopic = "projects/{your-project}/topics/{your-new-topic}";
    // Ensure this ServiceAccount has the "pubsub.topics.setIamPolicy" permission on the topic.

    NotificationConfig configToUpdate =
        NotificationConfig.newBuilder()
            .setName(notificationConfigName)
            .setDescription("updated description")
            .setPubsubTopic(pubsubTopic)
            .build();
    FieldMask fieldMask =
        FieldMask.newBuilder().addPaths("description").addPaths("pubsub_topic").build();

    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      NotificationConfig updatedConfig = client.updateNotificationConfig(configToUpdate, fieldMask);

      System.out.println(String.format("Notification config: %s", updatedConfig));
      return updatedConfig;
    }
    // [END scc_update_notification_config]
  }
}

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

// [START securitycenter_update_notification_config]
import com.google.cloud.securitycenter.v1.NotificationConfig;
import com.google.cloud.securitycenter.v1.NotificationConfig.StreamingConfig;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import com.google.protobuf.FieldMask;
import java.io.IOException;

// [END securitycenter_update_notification_config]

/** Snippets for UpdateNotificationConfig. */
final class UpdateNotificationConfigSnippets {
  private UpdateNotificationConfigSnippets() {}

  // [START securitycenter_update_notification_config]
  public static NotificationConfig updateNotificationConfig(
      String organizationId, String notificationConfigId, String projectId, String topicName)
      throws IOException {
    // String organizationId = "{your-org-id}";
    // String notificationConfigId = "{your-config-id}";
    // String projectId = "{your-project}";
    // String topicName = "{your-topic}";

    String notificationConfigName =
        String.format(
            "organizations/%s/notificationConfigs/%s", organizationId, notificationConfigId);

    // Ensure this ServiceAccount has the "pubsub.topics.setIamPolicy" permission on the topic.
    String pubsubTopic = String.format("projects/%s/topics/%s", projectId, topicName);

    NotificationConfig configToUpdate =
        NotificationConfig.newBuilder()
            .setName(notificationConfigName)
            .setDescription("updated description")
            .setPubsubTopic(pubsubTopic)
            .setStreamingConfig(StreamingConfig.newBuilder().setFilter("state = \"ACTIVE\""))
            .build();
    FieldMask fieldMask =
        FieldMask.newBuilder()
            .addPaths("description")
            .addPaths("pubsub_topic")
            .addPaths("streaming_config.filter")
            .build();

    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      NotificationConfig updatedConfig = client.updateNotificationConfig(configToUpdate, fieldMask);

      System.out.println(String.format("Notification config: %s", updatedConfig));
      return updatedConfig;
    }
  }
  // [END securitycenter_update_notification_config]
}

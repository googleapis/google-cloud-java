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

// [START securitycenter_create_notification_config]
import com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest;
import com.google.cloud.securitycenter.v1.NotificationConfig;
import com.google.cloud.securitycenter.v1.NotificationConfig.StreamingConfig;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import java.io.IOException;

// [END securitycenter_create_notification_config]

/** Create NotificationConfig Snippet. */
final class CreateNotificationConfigSnippets {
  private CreateNotificationConfigSnippets() {}

  // [START securitycenter_create_notification_config]
  public static NotificationConfig createNotificationConfig(
      String organizationId, String notificationConfigId, String projectId, String topicName)
      throws IOException {
    // String organizationId = "{your-org-id}";
    // String notificationConfigId = {"your-unique-id"};
    // String projectId = "{your-project}"";
    // String topicName = "{your-topic}";

    String orgName = String.format("organizations/%s", organizationId);

    // Ensure this ServiceAccount has the "pubsub.topics.setIamPolicy" permission on the topic.
    String pubsubTopic = String.format("projects/%s/topics/%s", projectId, topicName);

    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      CreateNotificationConfigRequest request =
          CreateNotificationConfigRequest.newBuilder()
              .setParent(orgName)
              .setConfigId(notificationConfigId)
              .setNotificationConfig(
                  NotificationConfig.newBuilder()
                      .setDescription("Java notification config")
                      .setPubsubTopic(pubsubTopic)
                      .setStreamingConfig(
                          StreamingConfig.newBuilder().setFilter("state = \"ACTIVE\"").build())
                      .build())
              .build();

      NotificationConfig response = client.createNotificationConfig(request);
      System.out.println(String.format("Notification config was created: %s", response));
      return response;
    }
  }
  // [END securitycenter_create_notification_config]
}

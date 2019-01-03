/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import com.google.cloud.monitoring.v3.NotificationChannelServiceClient;
import com.google.monitoring.v3.NotificationChannelName;

import java.io.IOException;

public class DeleteNotificationChannel {
  /**
   * Demonstrates deleting a notification channel by name.
   * @param channelName Name of the notification channel to delete.
   */
  // [START monitoring_alert_delete_channel]
  static void deleteNotificationChannel(String channelName) throws IOException {
    String projectId = System.getProperty("projectId");
    try (NotificationChannelServiceClient client = NotificationChannelServiceClient.create()) {
      NotificationChannelName name = NotificationChannelName.of(projectId, channelName);
      client.deleteNotificationChannel(channelName, false);
      System.out.println("Deleted notification channel " + channelName);
    }
  }
  // [END monitoring_alert_delete_channel]
}

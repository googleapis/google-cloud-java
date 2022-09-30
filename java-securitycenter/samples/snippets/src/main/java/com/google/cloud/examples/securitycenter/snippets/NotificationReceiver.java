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

// [START securitycenter_receive_notifications]

import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.cloud.securitycenter.v1.NotificationMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NotificationReceiver {
  private NotificationReceiver() {}

  static class NotificationMessageReceiver implements MessageReceiver {

    @Override
    public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
      NotificationMessage.Builder notificationMessageBuilder = NotificationMessage.newBuilder();

      try {
        String jsonString = message.getData().toStringUtf8();
        JsonFormat.parser().merge(jsonString, notificationMessageBuilder);

        NotificationMessage notificationMessage = notificationMessageBuilder.build();
        System.out.println(
            String.format("Config id: %s", notificationMessage.getNotificationConfigName()));
        System.out.println(String.format("Finding: %s", notificationMessage.getFinding()));
      } catch (InvalidProtocolBufferException e) {
        System.out.println("Could not parse message: " + e);
      } finally {
        consumer.ack();
      }
    }
  }

  public static void receiveNotificationMessages(String projectId, String subscriptionId) {
    // String projectId = "{your-project}";
    // String subscriptionId = "{your-subscription}";
    ProjectSubscriptionName subscriptionName =
        ProjectSubscriptionName.of(projectId, subscriptionId);

    try {
      Subscriber subscriber =
          Subscriber.newBuilder(subscriptionName, new NotificationMessageReceiver()).build();
      subscriber.startAsync().awaitRunning();

      // This sets the timeout value of the subscriber to 10s.
      subscriber.awaitTerminated(10_000, TimeUnit.MILLISECONDS);
    } catch (IllegalStateException | TimeoutException e) {
      System.out.println("Subscriber stopped: " + e);
    }
  }
}
// [END securitycenter_receive_notifications]

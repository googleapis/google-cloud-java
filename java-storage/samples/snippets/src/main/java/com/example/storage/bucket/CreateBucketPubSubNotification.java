/*
 * Copyright 2022 Google LLC
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

package com.example.storage.bucket;

// [START storage_create_bucket_notifications]
import com.google.cloud.storage.Notification;
import com.google.cloud.storage.NotificationInfo;
import com.google.cloud.storage.NotificationInfo.EventType;
import com.google.cloud.storage.NotificationInfo.PayloadFormat;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.Map;

public class CreateBucketPubSubNotification {

  public static void createBucketPubSubNotification(
      String bucketName,
      String topicName,
      Map<String, String> customAttributes,
      EventType[] eventTypes,
      String objectNamePrefix,
      PayloadFormat payloadFormat) {
    // The ID to give your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The name of the topic you would like to create a notification for
    // String topicName = "projects/{your-project}/topics/{your-topic}";

    // Any custom attributes
    // Map<String, String> customAttributes = Map.of("label", "value");

    // The object name prefix for which this notification configuration applies
    // String objectNamePrefix = "blob-";

    // Desired content of the Payload
    // PayloadFormat payloadFormat = PayloadFormat.JSON_API_V1.JSON_API_V1;

    Storage storage = StorageOptions.newBuilder().build().getService();
    NotificationInfo notificationInfo =
        NotificationInfo.newBuilder(topicName)
            .setCustomAttributes(customAttributes)
            .setEventTypes(eventTypes)
            .setObjectNamePrefix(objectNamePrefix)
            .setPayloadFormat(payloadFormat)
            .build();
    Notification notification = storage.createNotification(bucketName, notificationInfo);
    String topic = notification.getTopic();
    System.out.println("Successfully created notification for topic " + topic);
  }
}
// [END storage_create_bucket_notifications]

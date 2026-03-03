/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.pubsub.v1.samples;

// [START pubsub_v1_generated_Publisher_CreateTopic_sync]
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.protobuf.Duration;
import com.google.pubsub.v1.MessageStoragePolicy;
import com.google.pubsub.v1.SchemaSettings;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import java.util.HashMap;

public class SyncCreateTopic {

  public static void main(String[] args) throws Exception {
    syncCreateTopic();
  }

  public static void syncCreateTopic() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      Topic request =
          Topic.newBuilder()
              .setName(TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString())
              .putAllLabels(new HashMap<String, String>())
              .setMessageStoragePolicy(MessageStoragePolicy.newBuilder().build())
              .setKmsKeyName("kmsKeyName412586233")
              .setSchemaSettings(SchemaSettings.newBuilder().build())
              .setSatisfiesPzs(true)
              .setMessageRetentionDuration(Duration.newBuilder().build())
              .build();
      Topic response = topicAdminClient.createTopic(request);
    }
  }
}
// [END pubsub_v1_generated_Publisher_CreateTopic_sync]

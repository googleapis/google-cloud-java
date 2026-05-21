/*
 * Copyright 2023 Google LLC
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

package pubsub;

// [START pubsub_update_topic_schema]

import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.protobuf.FieldMask;
import com.google.pubsub.v1.SchemaSettings;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import com.google.pubsub.v1.UpdateTopicRequest;
import java.io.IOException;

public class UpdateTopicSchemaExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    // This is an existing topic that has schema settings attached to it.
    String topicId = "your-topic-id";
    // Set the minimum and maximum revsion ID
    String firstRevisionId = "your-revision-id";
    String lastRevisionId = "your-revision-id";

    UpdateTopicSchemaExample.updateTopicSchemaExample(
        projectId, topicId, firstRevisionId, lastRevisionId);
  }

  public static void updateTopicSchemaExample(
      String projectId, String topicId, String firstRevisionid, String lastRevisionId)
      throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {

      TopicName topicName = TopicName.of(projectId, topicId);

      // Construct the schema settings with the changes you want to make.
      SchemaSettings schemaSettings =
          SchemaSettings.newBuilder()
              .setFirstRevisionId(firstRevisionid)
              .setLastRevisionId(lastRevisionId)
              .build();

      // Construct the topic with the schema settings you want to change.
      Topic topic =
          Topic.newBuilder()
              .setName(topicName.toString())
              .setSchemaSettings(schemaSettings)
              .build();

      // Construct a field mask to indicate which field to update in the topic.
      FieldMask updateMask =
          FieldMask.newBuilder()
              .addPaths("schema_settings.first_revision_id")
              .addPaths("schema_settings.last_revision_id")
              .build();

      UpdateTopicRequest request =
          UpdateTopicRequest.newBuilder().setTopic(topic).setUpdateMask(updateMask).build();

      Topic response = topicAdminClient.updateTopic(request);

      System.out.println("Updated topic with schema: " + topic.getName());
    }
  }
}
// [END pubsub_update_topic_schema]

/*
 * Copyright 2021 Google LLC
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

// [START pubsub_create_topic_with_schema]

import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.Encoding;
import com.google.pubsub.v1.SchemaName;
import com.google.pubsub.v1.SchemaSettings;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;

public class CreateTopicWithSchemaExample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String topicId = "your-topic-id";
    // Use an existing schema.
    String schemaId = "your-schema-id";
    // Choose either BINARY or JSON message serialization in this topic.
    Encoding encoding = Encoding.BINARY;

    createTopicWithSchemaExample(projectId, topicId, schemaId, encoding);
  }

  public static void createTopicWithSchemaExample(
      String projectId, String topicId, String schemaId, Encoding encoding) throws IOException {
    TopicName topicName = TopicName.of(projectId, topicId);
    SchemaName schemaName = SchemaName.of(projectId, schemaId);

    SchemaSettings schemaSettings =
        SchemaSettings.newBuilder().setSchema(schemaName.toString()).setEncoding(encoding).build();

    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {

      Topic topic =
          topicAdminClient.createTopic(
              Topic.newBuilder()
                  .setName(topicName.toString())
                  .setSchemaSettings(schemaSettings)
                  .build());

      System.out.println("Created topic with schema: " + topic.getName());
    } catch (AlreadyExistsException e) {
      System.out.println(schemaName + "already exists.");
    }
  }
}
// [END pubsub_create_topic_with_schema]

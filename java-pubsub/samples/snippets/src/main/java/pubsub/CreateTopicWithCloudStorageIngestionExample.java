/*
 * Copyright 2024 Google LLC
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

// [START pubsub_create_topic_with_cloud_storage_ingestion]

import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.protobuf.util.Timestamps;
import com.google.pubsub.v1.IngestionDataSourceSettings;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;
import java.text.ParseException;

public class CreateTopicWithCloudStorageIngestionExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String topicId = "your-topic-id";
    // Cloud Storage ingestion settings.
    // bucket and inputFormat are required arguments.
    String bucket = "your-bucket";
    String inputFormat = "text";
    String textDelimiter = "\n";
    String matchGlob = "**.txt";
    String minimumObjectCreateTime = "YYYY-MM-DDThh:mm:ssZ";

    createTopicWithCloudStorageIngestionExample(
        projectId, topicId, bucket, inputFormat, textDelimiter, matchGlob, minimumObjectCreateTime);
  }

  public static void createTopicWithCloudStorageIngestionExample(
      String projectId,
      String topicId,
      String bucket,
      String inputFormat,
      String textDelimiter,
      String matchGlob,
      String minimumObjectCreateTime)
      throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      IngestionDataSourceSettings.CloudStorage.Builder cloudStorageBuilder =
          IngestionDataSourceSettings.CloudStorage.newBuilder().setBucket(bucket);
      switch (inputFormat) {
        case "text":
          cloudStorageBuilder.setTextFormat(
              IngestionDataSourceSettings.CloudStorage.TextFormat.newBuilder()
                  .setDelimiter(textDelimiter)
                  .build());
          break;
        case "avro":
          cloudStorageBuilder.setAvroFormat(
              IngestionDataSourceSettings.CloudStorage.AvroFormat.getDefaultInstance());
          break;
        case "pubsub_avro":
          cloudStorageBuilder.setPubsubAvroFormat(
              IngestionDataSourceSettings.CloudStorage.PubSubAvroFormat.getDefaultInstance());
          break;
        default:
          throw new IllegalArgumentException(
              "inputFormat must be in ('text', 'avro', 'pubsub_avro'); got value: " + inputFormat);
      }

      if (matchGlob != null && !matchGlob.isEmpty()) {
        cloudStorageBuilder.setMatchGlob(matchGlob);
      }

      if (minimumObjectCreateTime != null && !minimumObjectCreateTime.isEmpty()) {
        try {
          cloudStorageBuilder.setMinimumObjectCreateTime(Timestamps.parse(minimumObjectCreateTime));
        } catch (ParseException e) {
          System.err.println("Unable to parse timestamp: " + minimumObjectCreateTime);
        }
      }

      IngestionDataSourceSettings ingestionDataSourceSettings =
          IngestionDataSourceSettings.newBuilder()
              .setCloudStorage(cloudStorageBuilder.build())
              .build();

      TopicName topicName = TopicName.of(projectId, topicId);

      Topic topic =
          topicAdminClient.createTopic(
              Topic.newBuilder()
                  .setName(topicName.toString())
                  .setIngestionDataSourceSettings(ingestionDataSourceSettings)
                  .build());

      System.out.println(
          "Created topic with Cloud Storage ingestion settings: " + topic.getAllFields());
    }
  }
}
// [END pubsub_create_topic_with_cloud_storage_ingestion]

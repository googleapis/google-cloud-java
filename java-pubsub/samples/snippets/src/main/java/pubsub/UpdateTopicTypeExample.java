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

// [START pubsub_update_topic_type]

import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.protobuf.FieldMask;
import com.google.pubsub.v1.IngestionDataSourceSettings;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import com.google.pubsub.v1.UpdateTopicRequest;
import java.io.IOException;

public class UpdateTopicTypeExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String topicId = "your-topic-id";
    // Kinesis ingestion settings.
    String streamArn = "stream-arn";
    String consumerArn = "consumer-arn";
    String awsRoleArn = "aws-role-arn";
    String gcpServiceAccount = "gcp-service-account";

    UpdateTopicTypeExample.updateTopicTypeExample(
        projectId, topicId, streamArn, consumerArn, awsRoleArn, gcpServiceAccount);
  }

  public static void updateTopicTypeExample(
      String projectId,
      String topicId,
      String streamArn,
      String consumerArn,
      String awsRoleArn,
      String gcpServiceAccount)
      throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      TopicName topicName = TopicName.of(projectId, topicId);

      IngestionDataSourceSettings.AwsKinesis awsKinesis =
          IngestionDataSourceSettings.AwsKinesis.newBuilder()
              .setStreamArn(streamArn)
              .setConsumerArn(consumerArn)
              .setAwsRoleArn(awsRoleArn)
              .setGcpServiceAccount(gcpServiceAccount)
              .build();
      IngestionDataSourceSettings ingestionDataSourceSettings =
          IngestionDataSourceSettings.newBuilder().setAwsKinesis(awsKinesis).build();

      // Construct the topic with Kinesis ingestion settings.
      Topic topic =
          Topic.newBuilder()
              .setName(topicName.toString())
              .setIngestionDataSourceSettings(ingestionDataSourceSettings)
              .build();

      // Construct a field mask to indicate which field to update in the topic.
      FieldMask updateMask =
          FieldMask.newBuilder().addPaths("ingestion_data_source_settings").build();

      UpdateTopicRequest request =
          UpdateTopicRequest.newBuilder().setTopic(topic).setUpdateMask(updateMask).build();

      Topic response = topicAdminClient.updateTopic(request);

      System.out.println(
          "Updated topic with Kinesis ingestion settings: " + response.getAllFields());
    }
  }
}
// [END pubsub_update_topic_type]

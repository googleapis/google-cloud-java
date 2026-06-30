/*
 * Copyright 2022 Google LLC
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

// [START pubsub_create_cloud_storage_subscription]
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.protobuf.Duration;
import com.google.pubsub.v1.CloudStorageConfig;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.Subscription;
import java.io.IOException;

public class CreateCloudStorageSubscriptionExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String topicId = "your-topic-id";
    String subscriptionId = "your-subscription-id";
    String bucket = "your-bucket";
    String filenamePrefix = "log_events_";
    String filenameSuffix = ".text";
    Duration maxDuration = Duration.newBuilder().setSeconds(300).build();

    createCloudStorageSubscription(
        projectId, topicId, subscriptionId, bucket, filenamePrefix, filenameSuffix, maxDuration);
  }

  public static void createCloudStorageSubscription(
      String projectId,
      String topicId,
      String subscriptionId,
      String bucket,
      String filenamePrefix,
      String filenameSuffix,
      Duration maxDuration)
      throws IOException {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {

      ProjectTopicName topicName = ProjectTopicName.of(projectId, topicId);
      ProjectSubscriptionName subscriptionName =
          ProjectSubscriptionName.of(projectId, subscriptionId);

      CloudStorageConfig cloudStorageConfig =
          CloudStorageConfig.newBuilder()
              .setBucket(bucket)
              .setFilenamePrefix(filenamePrefix)
              .setFilenameSuffix(filenameSuffix)
              .setMaxDuration(maxDuration)
              .build();

      Subscription subscription =
          subscriptionAdminClient.createSubscription(
              Subscription.newBuilder()
                  .setName(subscriptionName.toString())
                  .setTopic(topicName.toString())
                  .setCloudStorageConfig(cloudStorageConfig)
                  .build());

      System.out.println("Created a CloudStorage subscription: " + subscription.getAllFields());
    }
  }
}
// [END pubsub_create_cloud_storage_subscription]

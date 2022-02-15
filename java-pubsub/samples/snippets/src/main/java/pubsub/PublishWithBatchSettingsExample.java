/*
 * Copyright 2016 Google LLC
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

// [START pubsub_publisher_batch_settings]

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.batching.BatchingSettings;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.threeten.bp.Duration;

public class PublishWithBatchSettingsExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String topicId = "your-topic-id";

    publishWithBatchSettingsExample(projectId, topicId);
  }

  public static void publishWithBatchSettingsExample(String projectId, String topicId)
      throws IOException, ExecutionException, InterruptedException {
    TopicName topicName = TopicName.of(projectId, topicId);
    Publisher publisher = null;
    List<ApiFuture<String>> messageIdFutures = new ArrayList<>();

    try {
      // Batch settings control how the publisher batches messages
      long requestBytesThreshold = 5000L; // default : 1000 bytes
      long messageCountBatchSize = 100L; // default : 100 message

      Duration publishDelayThreshold = Duration.ofMillis(100); // default : 1 ms

      // Publish request get triggered based on request size, messages count & time since last
      // publish, whichever condition is met first.
      BatchingSettings batchingSettings =
          BatchingSettings.newBuilder()
              .setElementCountThreshold(messageCountBatchSize)
              .setRequestByteThreshold(requestBytesThreshold)
              .setDelayThreshold(publishDelayThreshold)
              .build();

      // Create a publisher instance with default settings bound to the topic
      publisher = Publisher.newBuilder(topicName).setBatchingSettings(batchingSettings).build();

      // schedule publishing one message at a time : messages get automatically batched
      for (int i = 0; i < 100; i++) {
        String message = "message " + i;
        ByteString data = ByteString.copyFromUtf8(message);
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

        // Once published, returns a server-assigned message id (unique within the topic)
        ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
        messageIdFutures.add(messageIdFuture);
      }
    } finally {
      // Wait on any pending publish requests.
      List<String> messageIds = ApiFutures.allAsList(messageIdFutures).get();

      System.out.println("Published " + messageIds.size() + " messages with batch settings.");

      if (publisher != null) {
        // When finished with the publisher, shutdown to free up resources.
        publisher.shutdown();
        publisher.awaitTermination(1, TimeUnit.MINUTES);
      }
    }
  }
}
// [END pubsub_publisher_batch_settings]

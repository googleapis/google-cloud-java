/*
 * Copyright 2026 Google LLC
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

// [START pubsub_publish_hedging_settings]

import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.HedgingSettings;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class PublishWithHedgingSettingsExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String topicId = "your-topic-id";

    publishWithHedgingSettingsExample(projectId, topicId);
  }

  public static void publishWithHedgingSettingsExample(String projectId, String topicId)
      throws IOException, ExecutionException, InterruptedException {
    TopicName topicName = TopicName.of(projectId, topicId);
    Publisher publisher = null;

    try {
      // Hedging settings configures how and when the publisher sends multiple concurrent publish
      // requests to reduce tail latency.
      Duration hedgeDelay = Duration.ofMillis(500); // default: 1000 ms (1 second)
      int maxTokens = 100; // default: 50
      float refillRatio = 0.05f; // default: 0.1

      HedgingSettings hedgingSettings =
          HedgingSettings.newBuilder()
              .setHedgeDelay(hedgeDelay)
              .setMaxTokens(maxTokens)
              .setRefillRatio(refillRatio)
              .build();

      // Create a publisher instance with hedging settings bound to the topic
      publisher = Publisher.newBuilder(topicName).setHedgingSettings(hedgingSettings).build();

      String message = "Hello world!";
      ByteString data = ByteString.copyFromUtf8(message);
      PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

      // Once published, returns a server-assigned message id (unique within the topic)
      ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
      String messageId = messageIdFuture.get();
      System.out.println("Published a message with hedging settings: " + messageId);

    } finally {
      if (publisher != null) {
        // When finished with the publisher, shutdown to free up resources.
        publisher.shutdown();
        publisher.awaitTermination(1, TimeUnit.MINUTES);
      }
    }
  }
}
// [END pubsub_publish_hedging_settings]

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

import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class PublishWithGrpcCompressionExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    // Choose an existing topic.
    String topicId = "your-topic-id";

    publishWithGrpcCompressionExample(projectId, topicId);
  }

  public static void publishWithGrpcCompressionExample(String projectId, String topicId)
      throws IOException, ExecutionException, InterruptedException {
    TopicName topicName = TopicName.of(projectId, topicId);

    // Create a publisher and set enable compression to true.
    Publisher publisher = null;
    try {
      // Enable compression and configure the compression threshold to 10 bytes (default to 240 B).
      // Publish requests of sizes > 10 B (excluding the request headers) will get compressed.
      // The number of messages in a publish request is determined by publisher batch settings.
      // Batching is turned off by default, i.e. each publish request contains only one message.
      publisher =
          Publisher.newBuilder(topicName)
              .setEnableCompression(true)
              .setCompressionBytesThreshold(10L)
              .build();

      byte[] bytes = new byte[1024];
      ByteString data = ByteString.copyFrom(bytes);
      PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

      // Once published, returns a server-assigned message id (unique within the topic).
      // You can look up the actual size of the outbound data using the Java Logging API.
      // Configure logging properties as shown in
      // https://github.com/googleapis/java-pubsub/tree/main/samples/snippets/src/main/resources/logging.properties
      // and look for "OUTBOUND DATA" with "length=" in the output log.
      ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
      String messageId = messageIdFuture.get();
      System.out.println("Published a compressed message of message ID: " + messageId);
    } finally {
      if (publisher != null) {
        // When finished with the publisher, shutdown to free up resources.
        publisher.shutdown();
        publisher.awaitTermination(1, TimeUnit.MINUTES);
      }
    }
  }
}

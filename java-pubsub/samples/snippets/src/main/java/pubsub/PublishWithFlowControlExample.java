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

// [START pubsub_publisher_flow_control]

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class PublishWithFlowControlExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String topicId = "your-topic-id";

    publishWithFlowControlExample(projectId, topicId);
  }

  public static void publishWithFlowControlExample(String projectId, String topicId)
      throws IOException, ExecutionException, InterruptedException {
    TopicName topicName = TopicName.of(projectId, topicId);
    Publisher publisher = null;
    List<ApiFuture<String>> messageIdFutures = new ArrayList<>();

    try {
      // Configure how many messages the publisher client can hold in memory
      // and what to do when messages exceed the limit.
      FlowControlSettings flowControlSettings =
          FlowControlSettings.newBuilder()
              // Block more messages from being published when the limit is reached. The other
              // options are Ignore (or continue publishing) and ThrowException (or error out).
              .setLimitExceededBehavior(LimitExceededBehavior.Block)
              .setMaxOutstandingRequestBytes(10 * 1024 * 1024L) // 10 MiB
              .setMaxOutstandingElementCount(100L) // 100 messages
              .build();

      // By default, messages are not batched.
      BatchingSettings batchingSettings =
          BatchingSettings.newBuilder().setFlowControlSettings(flowControlSettings).build();

      publisher = Publisher.newBuilder(topicName).setBatchingSettings(batchingSettings).build();

      // Publish 1000 messages in quick succession may be constrained by publisher flow control.
      for (int i = 0; i < 1000; i++) {
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

      System.out.println(
          "Published " + messageIds.size() + " messages with flow control settings.");

      if (publisher != null) {
        // When finished with the publisher, shut down to free up resources.
        publisher.shutdown();
        publisher.awaitTermination(1, TimeUnit.MINUTES);
      }
    }
  }
}
// [END pubsub_publisher_flow_control]

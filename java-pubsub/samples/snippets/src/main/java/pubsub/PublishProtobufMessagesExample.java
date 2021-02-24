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

// [START pubsub_publish_proto_messages]

import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.protobuf.ByteString;
import com.google.protobuf.util.JsonFormat;
import com.google.pubsub.v1.Encoding;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import utilities.StateProto.State;

public class PublishProtobufMessagesExample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    // Use a topic created with a proto schema.
    String topicId = "your-topic-id";

    publishProtobufMessagesExample(projectId, topicId);
  }

  public static void publishProtobufMessagesExample(String projectId, String topicId)
      throws IOException, ExecutionException, InterruptedException {

    Encoding encoding = null;

    TopicName topicName = TopicName.of(projectId, topicId);

    // Get the topic encoding type.
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      encoding = topicAdminClient.getTopic(topicName).getSchemaSettings().getEncoding();
    }

    Publisher publisher = null;

    // Create an object of an avro-tools-generated class.
    State state = State.newBuilder().setName("Alaska").setPostAbbr("AK").build();

    block:
    try {
      publisher = Publisher.newBuilder(topicName).build();

      PubsubMessage.Builder message = PubsubMessage.newBuilder();

      // Prepare an appropriately formatted message based on topic encoding.
      switch (encoding) {
        case BINARY:
          message.setData(state.toByteString());
          System.out.println("Publishing a BINARY-formatted message:\n" + message);
          break;

        case JSON:
          String jsonString = JsonFormat.printer().omittingInsignificantWhitespace().print(state);
          message.setData(ByteString.copyFromUtf8(jsonString));
          System.out.println("Publishing a JSON-formatted message:\n" + message);
          break;

        default:
          break block;
      }

      // Publish the message.
      ApiFuture<String> future = publisher.publish(message.build());
      System.out.println("Published message ID: " + future.get());

    } finally {
      if (publisher != null) {
        publisher.shutdown();
        publisher.awaitTermination(1, TimeUnit.MINUTES);
      }
    }
  }
}
// [END pubsub_publish_proto_messages]

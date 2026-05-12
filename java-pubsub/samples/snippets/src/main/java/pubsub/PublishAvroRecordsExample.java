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

// [START pubsub_publish_avro_records]

import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.Encoding;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import utilities.State;

public class PublishAvroRecordsExample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    // Use a topic created with an Avro schema.
    String topicId = "your-topic-id";

    publishAvroRecordsExample(projectId, topicId);
  }

  public static void publishAvroRecordsExample(String projectId, String topicId)
      throws IOException, ExecutionException, InterruptedException {

    Encoding encoding = null;

    TopicName topicName = TopicName.of(projectId, topicId);

    // Get the topic encoding type.
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      encoding = topicAdminClient.getTopic(topicName).getSchemaSettings().getEncoding();
    }

    // Instantiate an avro-tools-generated class defined in `us-states.avsc`.
    State state = State.newBuilder().setName("Alaska").setPostAbbr("AK").build();

    Publisher publisher = null;

    block:
    try {
      publisher = Publisher.newBuilder(topicName).build();

      // Prepare to serialize the object to the output stream.
      ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

      Encoder encoder = null;

      // Prepare an appropriate encoder for publishing to the topic.
      switch (encoding) {
        case BINARY:
          System.out.println("Preparing a BINARY encoder...");
          encoder = EncoderFactory.get().directBinaryEncoder(byteStream, /* reuse= */ null);
          break;

        case JSON:
          System.out.println("Preparing a JSON encoder...");
          encoder = EncoderFactory.get().jsonEncoder(State.getClassSchema(), byteStream);
          break;

        default:
          break block;
      }

      // Encode the object and write it to the output stream.
      state.customEncode(encoder);
      encoder.flush();

      // Publish the encoded object as a Pub/Sub message.
      ByteString data = ByteString.copyFrom(byteStream.toByteArray());
      PubsubMessage message = PubsubMessage.newBuilder().setData(data).build();
      System.out.println("Publishing message: " + message);

      ApiFuture<String> future = publisher.publish(message);
      System.out.println("Published message ID: " + future.get());

    } finally {
      if (publisher != null) {
        publisher.shutdown();
        publisher.awaitTermination(1, TimeUnit.MINUTES);
      }
    }
  }
}
// [END pubsub_publish_avro_records]

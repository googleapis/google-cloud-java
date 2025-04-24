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

// [START pubsub_subscribe_avro_records]

import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import utilities.State;

public class SubscribeWithAvroSchemaExample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    // Use an existing subscription.
    String subscriptionId = "your-subscription-id";

    subscribeWithAvroSchemaExample(projectId, subscriptionId);
  }

  public static void subscribeWithAvroSchemaExample(String projectId, String subscriptionId) {

    ProjectSubscriptionName subscriptionName =
        ProjectSubscriptionName.of(projectId, subscriptionId);

    // Prepare a reader for the encoded Avro records.
    SpecificDatumReader<State> reader = new SpecificDatumReader<>(State.getClassSchema());

    // Instantiate an asynchronous message receiver.
    MessageReceiver receiver =
        (PubsubMessage message, AckReplyConsumer consumer) -> {
          ByteString data = message.getData();

          // Get the schema encoding type.
          String encoding = message.getAttributesMap().get("googclient_schemaencoding");

          // Send the message data to a byte[] input stream.
          InputStream inputStream = new ByteArrayInputStream(data.toByteArray());

          Decoder decoder = null;

          // Prepare an appropriate decoder for the message data in the input stream
          // based on the schema encoding type.
          block:
          try {
            switch (encoding) {
              case "BINARY":
                decoder = DecoderFactory.get().directBinaryDecoder(inputStream, /* reuse= */ null);
                System.out.println("Receiving a binary-encoded message:");
                break;
              case "JSON":
                decoder = DecoderFactory.get().jsonDecoder(State.getClassSchema(), inputStream);
                System.out.println("Receiving a JSON-encoded message:");
                break;
              default:
                break block;
            }

            // Obtain an object of the generated Avro class using the decoder.
            State state = reader.read(null, decoder);
            System.out.println(state.getName() + " is abbreviated as " + state.getPostAbbr());

          } catch (IOException e) {
            System.err.println(e);
          }

          // Ack the message.
          consumer.ack();
        };

    Subscriber subscriber = null;
    try {
      subscriber = Subscriber.newBuilder(subscriptionName, receiver).build();
      subscriber.startAsync().awaitRunning();
      System.out.printf("Listening for messages on %s:\n", subscriptionName.toString());
      subscriber.awaitTerminated(30, TimeUnit.SECONDS);
    } catch (TimeoutException timeoutException) {
      subscriber.stopAsync();
    }
  }
}
// [END pubsub_subscribe_avro_records]

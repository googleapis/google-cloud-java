/*
 * Copyright 2023 Google LLC
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

// [START pubsub_subscribe_avro_records_with_revisions]

import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.SchemaServiceClient;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.Schema;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import utilities.State;

public class SubscribeWithAvroSchemaRevisionsExample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    // Use an existing subscription.
    String subscriptionId = "your-subscription-id";

    subscribeWithAvroSchemaRevisionsExample(projectId, subscriptionId);
  }

  static SchemaServiceClient getSchemaServiceClient() {
    try {
      return SchemaServiceClient.create();
    } catch (IOException e) {
      System.out.println("Could not get schema client: " + e);
      return null;
    }
  }

  public static void subscribeWithAvroSchemaRevisionsExample(
      String projectId, String subscriptionId) {
    // Used to get the schemas for revsions.
    final SchemaServiceClient schemaServiceClient = getSchemaServiceClient();
    if (schemaServiceClient == null) {
      return;
    }

    // Cache for the readers for different revision IDs.
    Map<String, SpecificDatumReader<State>> revisionReaders =
        new HashMap<String, SpecificDatumReader<State>>();

    ProjectSubscriptionName subscriptionName =
        ProjectSubscriptionName.of(projectId, subscriptionId);

    // Instantiate an asynchronous message receiver.
    MessageReceiver receiver =
        (PubsubMessage message, AckReplyConsumer consumer) -> {
          // Get the schema encoding type.
          String name = message.getAttributesMap().get("googclient_schemaname");
          String revision = message.getAttributesMap().get("googclient_schemarevisionid");

          SpecificDatumReader<State> reader = null;
          synchronized (revisionReaders) {
            reader = revisionReaders.get(revision);
          }
          if (reader == null) {
            // This is the first time we are seeing this revision. We need to
            // fetch the schema and cache its decoder. It would be more typical
            // to do this asynchronously, but is shown here in a synchronous
            // way to ease readability.
            try {
              Schema schema = schemaServiceClient.getSchema(name + "@" + revision);
              org.apache.avro.Schema avroSchema =
                  new org.apache.avro.Schema.Parser().parse(schema.getDefinition());
              reader = new SpecificDatumReader<State>(avroSchema, State.getClassSchema());
              synchronized (revisionReaders) {
                revisionReaders.put(revision, reader);
              }
            } catch (Exception e) {
              System.out.println("Could not get schema: " + e);
              // Without the schema, we cannot read the message, so nack it.
              consumer.nack();
              return;
            }
          }

          ByteString data = message.getData();
          // Send the message data to a byte[] input stream.
          InputStream inputStream = new ByteArrayInputStream(data.toByteArray());

          String encoding = message.getAttributesMap().get("googclient_schemaencoding");

          Decoder decoder = null;

          // Prepare an appropriate decoder for the message data in the input stream
          // based on the schema encoding type.
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
                System.out.println("Unknown message type; nacking.");
                consumer.nack();
                break;
            }

            // Obtain an object of the generated Avro class using the decoder.
            State state = reader.read(null, decoder);
            System.out.println(state.getName() + " is abbreviated as " + state.getPostAbbr());

            // Ack the message.
            consumer.ack();
          } catch (IOException e) {
            System.err.println(e);
            // If we failed to process the message, nack it.
            consumer.nack();
          }
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
// [END pubsub_subscribe_avro_records_with_revisions]

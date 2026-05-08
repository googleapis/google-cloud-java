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

// [START pubsub_subscribe_proto_messages]

import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import utilities.StateProto.State;

public class SubscribeWithProtoSchemaExample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    // Use an existing subscription.
    String subscriptionId = "your-subscription-id";

    subscribeWithProtoSchemaExample(projectId, subscriptionId);
  }

  public static void subscribeWithProtoSchemaExample(String projectId, String subscriptionId) {

    ProjectSubscriptionName subscriptionName =
        ProjectSubscriptionName.of(projectId, subscriptionId);

    MessageReceiver receiver =
        (PubsubMessage message, AckReplyConsumer consumer) -> {
          ByteString data = message.getData();

          // Get the schema encoding type.
          String encoding = message.getAttributesMap().get("googclient_schemaencoding");

          block:
          try {
            switch (encoding) {
              case "BINARY":
                // Obtain an object of the generated proto class.
                State state = State.parseFrom(data);
                System.out.println("Received a BINARY-formatted message: " + state);
                break;

              case "JSON":
                State.Builder stateBuilder = State.newBuilder();
                JsonFormat.parser().merge(data.toStringUtf8(), stateBuilder);
                System.out.println("Received a JSON-formatted message:" + stateBuilder.build());
                break;

              default:
                break block;
            }
          } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
          }

          consumer.ack();
          System.out.println("Ack'ed the message");
        };

    // Create subscriber client.
    Subscriber subscriber = Subscriber.newBuilder(subscriptionName, receiver).build();

    try {
      subscriber.startAsync().awaitRunning();
      System.out.printf("Listening for messages on %s:\n", subscriptionName);
      subscriber.awaitTerminated(30, TimeUnit.SECONDS);
    } catch (TimeoutException timeoutException) {
      subscriber.stopAsync();
    }
  }
}
// [END pubsub_subscribe_proto_messages]

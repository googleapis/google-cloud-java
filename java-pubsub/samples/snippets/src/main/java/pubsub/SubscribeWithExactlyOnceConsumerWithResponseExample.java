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

// [START pubsub_subscriber_exactly_once]

import com.google.cloud.pubsub.v1.AckReplyConsumerWithResponse;
import com.google.cloud.pubsub.v1.AckResponse;
import com.google.cloud.pubsub.v1.MessageReceiverWithAckResponse;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SubscribeWithExactlyOnceConsumerWithResponseExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String subscriptionId = "your-subscription-id";

    subscribeWithExactlyOnceConsumerWithResponseExample(projectId, subscriptionId);
  }

  public static void subscribeWithExactlyOnceConsumerWithResponseExample(
      String projectId, String subscriptionId) {
    ProjectSubscriptionName subscriptionName =
        ProjectSubscriptionName.of(projectId, subscriptionId);

    // Instantiate an asynchronous message receiver using `AckReplyConsumerWithResponse`
    // instead of `AckReplyConsumer` to get a future that tracks the result of the ack call.
    // When exactly once delivery is enabled on the subscription, the message is guaranteed
    // to not be delivered again if the ack future succeeds.
    MessageReceiverWithAckResponse receiverWithResponse =
        (PubsubMessage message, AckReplyConsumerWithResponse consumerWithResponse) -> {
          try {
            // Handle incoming message, then ack the message, and receive an ack response.
            System.out.println("Message received: " + message.getData().toStringUtf8());
            Future<AckResponse> ackResponseFuture = consumerWithResponse.ack();

            // Retrieve the completed future for the ack response from the server.
            AckResponse ackResponse = ackResponseFuture.get();

            switch (ackResponse) {
              case SUCCESSFUL:
                // Success code means that this MessageID will not be delivered again.
                System.out.println("Message successfully acked: " + message.getMessageId());
                break;
              case INVALID:
                System.out.println(
                    "Message failed to ack with a response of Invalid. Id: "
                        + message.getMessageId());
                break;
              case PERMISSION_DENIED:
                System.out.println(
                    "Message failed to ack with a response of Permission Denied. Id: "
                        + message.getMessageId());
                break;
              case FAILED_PRECONDITION:
                System.out.println(
                    "Message failed to ack with a response of Failed Precondition. Id: "
                        + message.getMessageId());
                break;
              case OTHER:
                System.out.println(
                    "Message failed to ack with a response of Other. Id: "
                        + message.getMessageId());
                break;
              default:
                break;
            }
          } catch (InterruptedException | ExecutionException e) {
            System.out.println(
                "MessageId: " + message.getMessageId() + " failed when retrieving future");
          } catch (Throwable t) {
            System.out.println("Throwable caught" + t.getMessage());
          }
        };

    Subscriber subscriber = null;
    try {
      // Pub/Sub's exactly once delivery guarantee only applies when subscribers connect to the
      // service in the same region.
      // For list of locational endpoints for Pub/Sub, see
      // https://cloud.google.com/pubsub/docs/reference/service_apis_overview#list_of_locational_endpoints
      subscriber =
          Subscriber.newBuilder(subscriptionName, receiverWithResponse)
              .setEndpoint("us-west1-pubsub.googleapis.com:443")
              .build();
      // Start the subscriber.
      subscriber.startAsync().awaitRunning();
      System.out.printf("Listening for messages on %s:\n", subscriptionName.toString());
      // Allow the subscriber to run for 30s unless an unrecoverable error occurs.
      subscriber.awaitTerminated(30, TimeUnit.SECONDS);
    } catch (TimeoutException timeoutException) {
      // Shut down the subscriber after 30s. Stop receiving messages.
      subscriber.stopAsync();
    }
  }
}
// [END pubsub_subscriber_exactly_once]

/*
 * Copyright 2024 Google LLC
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

// [START pubsub_optimistic_subscribe]

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class OptimisticSubscribeExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String subscriptionId = "your-subscription-id";
    String topicId = "your-topic-id";

    optimisticSubscribeExample(projectId, subscriptionId, topicId);
  }

  public static void optimisticSubscribeExample(
      String projectId, String subscriptionId, String topicId) throws IOException {
    ProjectSubscriptionName subscriptionName =
        ProjectSubscriptionName.of(projectId, subscriptionId);

    // Instantiate an asynchronous message receiver.
    MessageReceiver receiver =
        (PubsubMessage message, AckReplyConsumer consumer) -> {
          // Handle incoming message, then ack the received message.
          System.out.println("Id: " + message.getMessageId());
          System.out.println("Data: " + message.getData().toStringUtf8());
          consumer.ack();
        };

    Subscriber subscriber = null;
    try {
      subscriber = Subscriber.newBuilder(subscriptionName, receiver).build();

      // Listen for resource NOT_FOUND errors and rebuild the  subscriber and restart subscribing
      // when the current subscriber encounters these errors.
      subscriber.addListener(
          new Subscriber.Listener() {
            public void failed(Subscriber.State from, Throwable failure) {
              System.out.println(failure.getStackTrace());
              if (failure instanceof NotFoundException) {
                try (SubscriptionAdminClient subscriptionAdminClient =
                    SubscriptionAdminClient.create()) {
                  TopicName topicName = TopicName.of(projectId, topicId);
                  // Create a pull subscription with default acknowledgement deadline of 10 seconds.
                  // The client library will automatically extend acknowledgement deadlines.
                  Subscription subscription =
                      subscriptionAdminClient.createSubscription(
                          subscriptionName, topicName, PushConfig.getDefaultInstance(), 10);
                  System.out.println("Created pull subscription: " + subscription.getName());
                  optimisticSubscribeExample(projectId, subscriptionId, topicId);
                } catch (IOException err) {
                  System.out.println("Failed to create pull subscription: " + err.getMessage());
                }
              }
            }
          },
          MoreExecutors.directExecutor());

      subscriber.startAsync().awaitRunning();
      System.out.printf("Listening for messages on %s:\n", subscriptionName.toString());
      subscriber.awaitTerminated(30, TimeUnit.SECONDS);
    } catch (IllegalStateException e) {
      // Prevent an exception from being thrown if it is the expected NotFoundException
      if (!(subscriber.failureCause() instanceof NotFoundException)) {
        throw e;
      }
    } catch (TimeoutException e) {
      subscriber.stopAsync();
    }
  }
}

// [END pubsub_optimistic_subscribe]

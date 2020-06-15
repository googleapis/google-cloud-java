/*
 * Copyright 2020 Google LLC
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

// [START pubsub_dead_letter_create_subscription]

import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.pubsub.v1.DeadLetterPolicy;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.Subscription;
import java.io.IOException;

public class CreateSubscriptionWithDeadLetterPolicyExample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    // This is the subscription you want to create with a dead letter policy.
    String subscriptionId = "your-subscription-id";
    // This is an existing topic that you want to attach the subscription with dead letter policy
    // to.
    String topicId = "your-topic-id";
    // This is an existing topic that the subscription with dead letter policy forwards dead letter
    // messages to.
    String deadLetterTopicId = "your-dead-letter-topic-id";

    CreateSubscriptionWithDeadLetterPolicyExample.createSubscriptionWithDeadLetterPolicyExample(
        projectId, subscriptionId, topicId, deadLetterTopicId);
  }

  public static void createSubscriptionWithDeadLetterPolicyExample(
      String projectId, String subscriptionId, String topicId, String deadLetterTopicId)
      throws IOException {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {

      ProjectTopicName topicName = ProjectTopicName.of(projectId, topicId);
      ProjectSubscriptionName subscriptionName =
          ProjectSubscriptionName.of(projectId, subscriptionId);
      ProjectTopicName deadLetterTopicName = ProjectTopicName.of(projectId, deadLetterTopicId);

      DeadLetterPolicy deadLetterPolicy =
          DeadLetterPolicy.newBuilder()
              .setDeadLetterTopic(deadLetterTopicName.toString())
              // The maximum number of times that the service attempts to deliver a
              // message before forwarding it to the dead letter topic. Must be [5-100].
              .setMaxDeliveryAttempts(10)
              .build();

      Subscription request =
          Subscription.newBuilder()
              .setName(subscriptionName.toString())
              .setTopic(topicName.toString())
              .setDeadLetterPolicy(deadLetterPolicy)
              .build();

      Subscription subscription = subscriptionAdminClient.createSubscription(request);

      System.out.println("Created subscription: " + subscription.getName());
      System.out.println(
          "It will forward dead letter messages to: "
              + subscription.getDeadLetterPolicy().getDeadLetterTopic());
      System.out.println(
          "After "
              + subscription.getDeadLetterPolicy().getMaxDeliveryAttempts()
              + " delivery attempts.");
      // Remember to attach a subscription to the dead letter topic because
      // messages published to a topic with no subscriptions are lost.
    }
  }
}
// [END pubsub_dead_letter_create_subscription]

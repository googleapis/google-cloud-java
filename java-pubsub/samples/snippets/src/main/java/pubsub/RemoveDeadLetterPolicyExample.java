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

// [START pubsub_dead_letter_remove]

import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.protobuf.FieldMask;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.TopicName;
import com.google.pubsub.v1.UpdateSubscriptionRequest;

public class RemoveDeadLetterPolicyExample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "Your Project ID";
    // This is an existing subscription with dead letter policy.
    String subscriptionId = "Your Subscription ID";
    // This is an existing topic that the subscription with dead letter policy is attached to.
    String topicId = "Your Topic ID";

    RemoveDeadLetterPolicyExample.removeDeadLetterPolicyExample(projectId, subscriptionId, topicId);
  }

  public static void removeDeadLetterPolicyExample(
      String projectId, String subscriptionId, String topicId) throws Exception {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {

      ProjectSubscriptionName subscriptionName =
          ProjectSubscriptionName.of(projectId, subscriptionId);
      TopicName topicName = TopicName.of(projectId, topicId);

      System.out.println(
          "Before: " + subscriptionAdminClient.getSubscription(subscriptionName).getAllFields());

      // Construct the subscription you expect to have after the request. Here,
      // values in the required fields (name, topic) help identify the subscription.
      // No dead letter policy is supplied.
      Subscription expectedSubscription =
          Subscription.newBuilder()
              .setName(subscriptionName.toString())
              .setTopic(topicName.toString())
              .build();

      // Construct a field mask to indicate which field to update in the subscription.
      FieldMask updateMask =
          FieldMask.newBuilder()
              .addPaths("dead_letter_policy.dead_letter_topic")
              // A default of 5 is applied upon successful update.
              .addPaths("dead_letter_policy.max_delivery_attempts")
              .build();

      UpdateSubscriptionRequest request =
          UpdateSubscriptionRequest.newBuilder()
              .setSubscription(expectedSubscription)
              .setUpdateMask(updateMask)
              .build();

      Subscription response = subscriptionAdminClient.updateSubscription(request);

      // You should see an empty dead letter topic field inside the dead letter policy.
      System.out.println("After: " + response.getAllFields());
    }
  }
}
// [END pubsub_dead_letter_remove]

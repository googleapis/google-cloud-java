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

// [START pubsub_detach_subscription]
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.DetachSubscriptionRequest;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.Subscription;
import java.io.IOException;

public class DetachSubscriptionExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    // Choose an existing subscription.
    String subscriptionId = "your-subscription-id";

    detachSubscriptionExample(projectId, subscriptionId);
  }

  public static void detachSubscriptionExample(String projectId, String subscriptionId)
      throws IOException {
    ProjectSubscriptionName subscriptionName =
        ProjectSubscriptionName.of(projectId, subscriptionId);

    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.detachSubscription(
          DetachSubscriptionRequest.newBuilder()
              .setSubscription(subscriptionName.toString())
              .build());
    }

    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      Subscription subscription = subscriptionAdminClient.getSubscription(subscriptionName);
      if (subscription.getDetached()) {
        System.out.println("Subscription is detached.");
      } else {
        System.out.println("Subscription is NOT detached.");
      }
    }
  }
}
// [END pubsub_detach_subscription]
/*
 * Copyright 2016 Google LLC
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

// [START pubsub_delete_subscription]

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.pubsub.v1.SubscriptionName;
import java.io.IOException;

public class DeleteSubscriptionExample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String subscriptionId = "your-subscription-id";

    deleteSubscriptionExample(projectId, subscriptionId);
  }

  public static void deleteSubscriptionExample(String projectId, String subscriptionId)
      throws IOException {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      SubscriptionName subscriptionName = SubscriptionName.of(projectId, subscriptionId);
      try {
        subscriptionAdminClient.deleteSubscription(subscriptionName);
        System.out.println("Deleted subscription.");
      } catch (NotFoundException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
// [END pubsub_delete_subscription]

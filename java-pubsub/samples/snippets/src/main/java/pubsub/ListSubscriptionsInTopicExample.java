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

// [START pubsub_list_topic_subscriptions]

import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;

public class ListSubscriptionsInTopicExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String topicId = "your-topic-id";

    listSubscriptionInTopicExample(projectId, topicId);
  }

  public static void listSubscriptionInTopicExample(String projectId, String topicId)
      throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      TopicName topicName = TopicName.of(projectId, topicId);
      for (String subscription : topicAdminClient.listTopicSubscriptions(topicName).iterateAll()) {
        System.out.println(subscription);
      }
      System.out.println("Listed all the subscriptions in the topic.");
    }
  }
}
// [END pubsub_list_topic_subscriptions]

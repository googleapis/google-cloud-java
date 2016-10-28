/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.examples.pubsub.snippets;

import com.google.cloud.pubsub.Message;
import com.google.cloud.pubsub.PubSub;
import com.google.cloud.pubsub.PubSub.MessageConsumer;
import com.google.cloud.pubsub.PubSub.MessageProcessor;
import com.google.cloud.pubsub.PubSubOptions;
import com.google.cloud.pubsub.Subscription;
import com.google.cloud.pubsub.SubscriptionInfo;

/**
 * A snippet for Google Cloud Pub/Sub showing how to create a Pub/Sub pull subscription and
 * asynchronously pull messages from it.
 */
public class CreateSubscriptionAndPullMessages {

  public static void main(String... args) throws Exception {
    try (PubSub pubsub = PubSubOptions.defaultInstance().service()) {
      Subscription subscription =
          pubsub.create(SubscriptionInfo.of("test-topic", "test-subscription"));
      MessageProcessor callback = new MessageProcessor() {
        @Override
        public void process(Message message) throws Exception {
          System.out.printf("Received message \"%s\"%n", message.getPayloadAsString());
        }
      };
      // Create a message consumer and pull messages (for 60 seconds)
      try (MessageConsumer consumer = subscription.pullAsync(callback)) {
        Thread.sleep(60_000);
      }
    }
  }
}

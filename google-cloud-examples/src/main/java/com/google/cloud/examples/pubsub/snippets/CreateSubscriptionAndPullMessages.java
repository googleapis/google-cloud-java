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

import com.google.cloud.pubsub.spi.v1.AckReply;
import com.google.cloud.pubsub.spi.v1.AckReplyConsumer;
import com.google.cloud.pubsub.spi.v1.MessageReceiver;
import com.google.cloud.pubsub.spi.v1.Subscriber;
import com.google.cloud.pubsub.spi.v1.SubscriberClient;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;

/**
 * A snippet for Google Cloud Pub/Sub showing how to create a Pub/Sub pull subscription and
 * asynchronously pull messages from it.
 */
public class CreateSubscriptionAndPullMessages {

  public static void main(String... args) throws Exception {
    TopicName topic = TopicName.create("test-project", "test-topic");
    SubscriptionName subscription = SubscriptionName.create("test-project", "test-subscription");

    try (SubscriberClient subscriberClient = SubscriberClient.create()) {
      subscriberClient.createSubscription(subscription, topic, PushConfig.getDefaultInstance(), 0);
    }

    MessageReceiver receiver =
        new MessageReceiver() {
          @Override
          public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
            System.out.println("got message: " + message.getData().toStringUtf8());
            consumer.accept(AckReply.ACK, null);
          }
        };
    Subscriber subscriber = null;
    try {
      subscriber = Subscriber.newBuilder(subscription, receiver).build();
      subscriber.addListener(
          new Subscriber.SubscriberListener() {
            @Override
            public void failed(Subscriber.State from, Throwable failure) {
              System.err.println(failure);
            }
          },
          MoreExecutors.directExecutor());
      subscriber.startAsync().awaitRunning();
      Thread.sleep(60000);
    } finally {
      if (subscriber != null) {
        subscriber.stopAsync();
      }
    }
  }
}

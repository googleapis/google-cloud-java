/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in Subscriber's javadoc. Any change to this file should be reflected in
 * Subscriber's javadoc.
 */

package com.google.cloud.examples.pubsub.snippets;

import com.google.api.core.ApiFuture;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.InstantiatingExecutorProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.pubsub.spi.v1.AckReplyConsumer;
import com.google.cloud.pubsub.spi.v1.MessageReceiver;
import com.google.cloud.pubsub.spi.v1.Subscriber;
import com.google.cloud.pubsub.spi.v1.TopicAdminSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.SubscriptionName;
import java.io.FileInputStream;
import java.util.concurrent.Executor;

/** This class contains snippets for the {@link Subscriber} interface. */
public class SubscriberSnippets {

  private final SubscriptionName subscriptionName;
  private final MessageReceiver receiver;
  private final ApiFuture<Void> done;
  private final Executor executor;

  public SubscriberSnippets(
      SubscriptionName subscriptionName,
      MessageReceiver receiver,
      ApiFuture<Void> done,
      Executor executor) {
    this.subscriptionName = subscriptionName;
    this.receiver = receiver;
    this.done = done;
    this.executor = executor;
  }

  // [TARGET startAsync()]
  public void startAndWait() throws Exception {
    // [START startAsync]
    Subscriber subscriber = Subscriber.defaultBuilder(subscriptionName, receiver).build();
    subscriber.addListener(new Subscriber.Listener() {
      public void failed(Subscriber.State from, Throwable failure) {
        // Handle error.
      }
    }, executor);
    subscriber.startAsync();

    // Wait for a stop signal.
    done.get();
    subscriber.stopAsync().awaitTerminated();
    // [END startAsync]
  }

  private void createSubscriber() throws Exception {
    // [START pullSubscriber]
    String projectId = "my-project-id";
    String subscriptionId = "my-subscription-id";

    SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscriptionId);
    // Instantiate an asynchronous message receiver
    MessageReceiver receiver = new MessageReceiver() {
          @Override
          public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
            // handle incoming message, then ack/nack the received message
            System.out.println("Id : " + message.getMessageId());
            System.out.println("Data : " + message.getData().toStringUtf8());
            consumer.ack();
          }
        };

    Subscriber subscriber = null;
    try {
      // Create a subscriber for "my-subscription-id" bound to the message receiver
      subscriber = Subscriber.defaultBuilder(subscriptionName, receiver).build();
      subscriber.startAsync();
      // ...
    } finally {
      // stop receiving messages
      if (subscriber != null) {
        subscriber.stopAsync();
      }
    }
    // [END pullSubscriber]
  }

  private Subscriber createSubscriberWithErrorListener(Subscriber subscriber) throws Exception {
    // [START subscriberWithErrorListener]
    subscriber.addListener(new Subscriber.Listener() {
      public void failed(Subscriber.State from, Throwable failure) {
        // Handle error.
      }
    }, MoreExecutors.directExecutor());
    // [END subscriberWithErrorListener]
    return subscriber;
  }

  private Subscriber createSingleThreadedSubscriber() throws Exception {
    // [START singleThreadedSubscriber]
    // provide a separate executor service for polling
    ExecutorProvider executorProvider = InstantiatingExecutorProvider.newBuilder()
        .setExecutorThreadCount(1).build();

    Subscriber subscriber = Subscriber.defaultBuilder(subscriptionName, receiver)
        .setExecutorProvider(executorProvider)
        .build();
    // [END singleThreadedSubscriber]
    return subscriber;
  }

  private Subscriber createSubscriberWithCustomFlowSettings() throws Exception {
    // [START subscriberWithCustomFlow]
    int maxMessageCount = 10;
    // Configure max number of messages to be pulled
    FlowControlSettings flowControlSettings = FlowControlSettings.newBuilder()
        .setMaxOutstandingElementCount(maxMessageCount)
        .build();
    Subscriber subscriber = Subscriber.defaultBuilder(subscriptionName, receiver)
        .setFlowControlSettings(flowControlSettings)
        .build();
    // [END subscriberWithCustomFlow]
    return subscriber;
  }

  private Subscriber createSubscriberWithCustomCredentials() throws Exception {
    // [START subscriberWithCustomCredentials]
    CredentialsProvider credentialsProvider =
        FixedCredentialsProvider
            .create(ServiceAccountCredentials.fromStream(
                new FileInputStream("credentials.json")));
    ChannelProvider channelProvider =
        TopicAdminSettings.defaultChannelProviderBuilder()
            .setCredentialsProvider(credentialsProvider).build();

    Subscriber subscriber = Subscriber.defaultBuilder(subscriptionName, receiver)
        .setChannelProvider(channelProvider)
        .build();
    // [START subscriberWithCustomCredentials]
    return subscriber;
  }
}

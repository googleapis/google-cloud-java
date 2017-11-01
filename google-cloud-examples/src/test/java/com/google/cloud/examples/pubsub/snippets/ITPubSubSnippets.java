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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.ReceivedMessage;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ITPubSubSnippets {

  private static final String NAME_SUFFIX = UUID.randomUUID().toString();

  @Rule public Timeout globalTimeout = Timeout.seconds(300);

  private TopicName topicName;
  private SubscriptionName subscriptionName;

  private static String formatForTest(String resourceName) {
    return resourceName + "-" + NAME_SUFFIX;
  }

  @Before
  public void setUp() throws Exception {
    topicName = TopicName.create(ServiceOptions.getDefaultProjectId(), formatForTest("test-topic"));
    subscriptionName =
        SubscriptionName.create(
            ServiceOptions.getDefaultProjectId(), formatForTest("test-subscription"));

    try (TopicAdminClient publisherClient = TopicAdminClient.create();
        SubscriptionAdminClient subscriberClient = SubscriptionAdminClient.create()) {
      publisherClient.createTopic(topicName);
      subscriberClient.createSubscription(
          subscriptionName, topicName, PushConfig.getDefaultInstance(), 0);
    }
  }

  @Test
  public void testPublisherAsyncSubscriber() throws Exception {
    String messageToPublish = "my-message";

    Publisher publisher = null;
    try {
      publisher = Publisher.newBuilder(topicName).build();
      PublisherSnippets snippets = new PublisherSnippets(publisher);
      final SettableApiFuture<Void> done = SettableApiFuture.create();
      ApiFutures.addCallback(
          snippets.publish(messageToPublish),
          new ApiFutureCallback<String>() {
            public void onSuccess(String messageId) {
              done.set(null);
            }

            public void onFailure(Throwable t) {
              done.setException(t);
            }
          });
      done.get();
    } finally {
      if (publisher != null) {
        publisher.shutdown();
      }
    }

    final BlockingQueue<PubsubMessage> queue = new ArrayBlockingQueue<>(1);
    final SettableApiFuture<Void> done = SettableApiFuture.create();
    final SettableApiFuture<PubsubMessage> received = SettableApiFuture.create();
    SubscriberSnippets snippets =
        new SubscriberSnippets(
            subscriptionName,
            new MessageReceiverSnippets(queue).messageReceiver(),
            done,
            MoreExecutors.directExecutor());
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  received.set(queue.poll(10, TimeUnit.MINUTES));
                } catch (InterruptedException e) {
                  received.set(null);
                }
                done.set(null); // signal the subscriber to clean up
              }
            })
        .start();
    snippets.startAndWait(); // blocks until done is set

    PubsubMessage message = received.get();
    assertNotNull(message);
    assertEquals(message.getData().toStringUtf8(), messageToPublish);
  }

  @Test
  public void testPublisherSyncSubscriber() throws Exception {
    String messageToPublish = "my-message";
    Publisher publisher = null;
    try {
      publisher = Publisher.newBuilder(topicName).build();
      PublisherSnippets snippets = new PublisherSnippets(publisher);
      List<ApiFuture<String>> apiFutures = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
        apiFutures.add(snippets.publish(messageToPublish + "-" + i));
      }
      ApiFutures.allAsList(apiFutures).get();
    } finally {
      if (publisher != null) {
        publisher.shutdown();
      }
    }

    List<ReceivedMessage> messages =
        SubscriberSnippets.createSubscriberWithSyncPull(
            subscriptionName.getProject(), subscriptionName.getSubscription(), 5);
    assertEquals(messages.size(), 5);
    for (int i = 0; i < 5; i++) {
      String messageData = messages.get(i).getMessage().getData().toStringUtf8();
      assertEquals(messageData, messageToPublish + "-" + i);
    }
  }

  @After
  public void tearDown() throws Exception {
    try (TopicAdminClient publisherClient = TopicAdminClient.create();
        SubscriptionAdminClient subscriberClient = SubscriptionAdminClient.create()) {
      subscriberClient.deleteSubscription(subscriptionName);
      publisherClient.deleteTopic(topicName);
    }
  }
}

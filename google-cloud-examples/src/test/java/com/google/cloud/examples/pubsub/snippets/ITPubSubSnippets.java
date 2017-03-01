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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.core.RpcFutureCallback;
import com.google.api.gax.core.SettableRpcFuture;
import com.google.cloud.Identity;
import com.google.cloud.Page;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.pubsub.deprecated.PubSub;
import com.google.cloud.pubsub.deprecated.PubSubOptions;
import com.google.cloud.pubsub.deprecated.ReceivedMessage;
import com.google.cloud.pubsub.deprecated.Subscription;
import com.google.cloud.pubsub.deprecated.SubscriptionId;
import com.google.cloud.pubsub.deprecated.SubscriptionInfo;
import com.google.cloud.pubsub.deprecated.Topic;
import com.google.cloud.pubsub.deprecated.TopicInfo;
import com.google.cloud.pubsub.spi.v1.Publisher;
import com.google.cloud.pubsub.spi.v1.PublisherClient;
import com.google.cloud.pubsub.spi.v1.SubscriberClient;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ITPubSubSnippets {

  private static final String NAME_SUFFIX = UUID.randomUUID().toString();

  private static PubSub pubsub;
  private static PubSubSnippets pubsubSnippets;

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  private static String formatForTest(String resourceName) {
    return resourceName + "-" + NAME_SUFFIX;
  }

  @BeforeClass
  public static void beforeClass() {
    pubsub = PubSubOptions.getDefaultInstance().getService();
    pubsubSnippets = new PubSubSnippets(pubsub);
  }

  @AfterClass
  public static void afterClass() throws Exception {
    if (pubsub != null) {
      pubsub.close();
    }
  }

  @Test
  public void testTopicAndSubscription() throws ExecutionException, InterruptedException {
    String topicName1 = formatForTest("topic-name1");
    String topicName2 = formatForTest("topic-name2");
    Topic topic1 = pubsubSnippets.createTopic(topicName1);
    Topic topic2 = pubsubSnippets.createTopicAsync(topicName2);
    assertNotNull(topic1);
    assertNotNull(topic2);
    topic1 = pubsubSnippets.getTopic(topicName1);
    topic2 = pubsubSnippets.getTopicAsync(topicName2);
    assertNotNull(topic1);
    assertNotNull(topic2);
    Set<Topic> topics = Sets.newHashSet(pubsubSnippets.listTopics().iterateAll());
    while (!topics.contains(topic1) || !topics.contains(topic2)) {
      Thread.sleep(500);
      topics = Sets.newHashSet(pubsubSnippets.listTopics().iterateAll());
    }
    topics = Sets.newHashSet(pubsubSnippets.listTopicsAsync().iterateAll());
    while (!topics.contains(topic1) || !topics.contains(topic2)) {
      Thread.sleep(500);
      topics = Sets.newHashSet(pubsubSnippets.listTopicsAsync().iterateAll());
    }
    String subscriptionName1 = formatForTest("subscription-name1");
    String subscriptionName2 = formatForTest("subscription-name2");
    Subscription subscription1 =
        pubsubSnippets.createSubscription(topicName1, subscriptionName1);
    Subscription subscription2 =
        pubsubSnippets.createSubscriptionAsync(topicName2, subscriptionName2);
    assertNotNull(subscription1);
    assertNotNull(subscription2);
    Page<SubscriptionId> page = pubsubSnippets.listSubscriptionsForTopic(topicName1);
    while (Iterators.size(page.iterateAll()) < 1) {
      page = pubsubSnippets.listSubscriptionsForTopic(topicName1);
    }
    assertEquals(subscriptionName1, page.iterateAll().next().getSubscription());
    page = pubsubSnippets.listSubscriptionsForTopicAsync(topicName2);
    while (Iterators.size(page.iterateAll()) < 1) {
      page = pubsubSnippets.listSubscriptionsForTopicAsync(topicName2);
    }
    assertEquals(subscriptionName2, page.iterateAll().next().getSubscription());
    String endpoint = "https://" + pubsub.getOptions().getProjectId() + ".appspot.com/push";
    pubsubSnippets.replacePushConfig(subscriptionName1, endpoint);
    pubsubSnippets.replacePushConfigAsync(subscriptionName2, endpoint);
    subscription1 = pubsubSnippets.getSubscription(subscriptionName1);
    subscription2 = pubsubSnippets.getSubscriptionAsync(subscriptionName2);
    assertEquals(endpoint, subscription1.getPushConfig().getEndpoint());
    assertEquals(endpoint, subscription2.getPushConfig().getEndpoint());
    pubsubSnippets.replacePushConfigToPull(subscriptionName1);
    pubsubSnippets.replacePushConfigToPullAsync(subscriptionName2);
    subscription1 = pubsubSnippets.getSubscription(subscriptionName1);
    subscription2 = pubsubSnippets.getSubscriptionAsync(subscriptionName2);
    assertNull(subscription1.getPushConfig());
    assertNull(subscription2.getPushConfig());
    assertTrue(pubsubSnippets.deleteTopic(topicName1));
    assertTrue(pubsubSnippets.deleteTopicAsync(topicName2));
    assertTrue(pubsubSnippets.deleteSubscription(subscriptionName1));
    assertTrue(pubsubSnippets.deleteSubscriptionAsync(subscriptionName2));
  }

  @Test
  public void testPublishAndPullMessage() throws Exception {
    String topicName = formatForTest("topic-name");
    String subscriptionName = formatForTest("subscription-name");
    pubsub.create(TopicInfo.of(topicName));
    pubsub.create(SubscriptionInfo.of(topicName, subscriptionName));
    assertNotNull(pubsubSnippets.publishOneMessage(topicName));
    pubsubSnippets.pull(subscriptionName);
    assertNotNull(pubsubSnippets.publishOneMessage(topicName));
    assertEquals(2, pubsubSnippets.publishMessages(topicName).size());
    assertEquals(2, pubsubSnippets.publishMessageList(topicName).size());
    Set<ReceivedMessage> messages = new HashSet<>();
    while (messages.size() < 5) {
      Iterators.addAll(messages, pubsub.pull(subscriptionName, 100));
    }
    Iterator<ReceivedMessage> messageIterator = messages.iterator();
    pubsubSnippets.modifyAckDeadlineOneMessage(subscriptionName, messageIterator.next().getAckId());
    pubsubSnippets.modifyAckDeadlineMoreMessages(subscriptionName,
        messageIterator.next().getAckId(), messageIterator.next().getAckId());
    pubsubSnippets.modifyAckDeadlineMessageList(subscriptionName, messageIterator.next().getAckId(),
        messageIterator.next().getAckId());
    messageIterator = messages.iterator();
    pubsubSnippets.nackOneMessage(subscriptionName, messageIterator.next().getAckId());
    pubsubSnippets.nackMoreMessages(subscriptionName, messageIterator.next().getAckId(),
        messageIterator.next().getAckId());
    pubsubSnippets.nackMessageList(subscriptionName, messageIterator.next().getAckId(),
        messageIterator.next().getAckId());
    messages.clear();
    while (messages.size() < 5) {
      Iterators.addAll(messages, pubsub.pull(subscriptionName, 100));
    }
    messageIterator = messages.iterator();
    pubsubSnippets.ackOneMessage(subscriptionName, messageIterator.next().getAckId());
    pubsubSnippets.ackMoreMessages(subscriptionName, messageIterator.next().getAckId(),
        messageIterator.next().getAckId());
    pubsubSnippets.ackMessageList(subscriptionName, messageIterator.next().getAckId(),
        messageIterator.next().getAckId());
    assertTrue(pubsubSnippets.deleteTopic(topicName));
    assertTrue(pubsubSnippets.deleteSubscription(subscriptionName));
  }

  @Test
  public void testPublishAndPullMessageAsync() throws Exception {
    String topicName = formatForTest("topic-name-async");
    String subscriptionName = formatForTest("subscription-name-async");
    pubsub.create(TopicInfo.of(topicName));
    pubsub.create(SubscriptionInfo.of(topicName, subscriptionName));
    pubsubSnippets.pullWithMessageConsumer(subscriptionName);
    assertNotNull(pubsubSnippets.publishOneMessageAsync(topicName));
    pubsubSnippets.pullAsync(subscriptionName);
    assertNotNull(pubsubSnippets.publishOneMessageAsync(topicName));
    assertEquals(2, pubsubSnippets.publishMessagesAsync(topicName).size());
    assertEquals(2, pubsubSnippets.publishMessageListAsync(topicName).size());
    Set<ReceivedMessage> messages = new HashSet<>();
    while (messages.size() < 5) {
      Iterators.addAll(messages, pubsub.pull(subscriptionName, 100));
    }
    Iterator<ReceivedMessage> messageIterator = messages.iterator();
    pubsubSnippets.modifyAckDeadlineOneMessageAsync(subscriptionName,
        messageIterator.next().getAckId());
    pubsubSnippets.modifyAckDeadlineMoreMessagesAsync(subscriptionName,
        messageIterator.next().getAckId(), messageIterator.next().getAckId());
    pubsubSnippets.modifyAckDeadlineMessageListAsync(subscriptionName,
        messageIterator.next().getAckId(), messageIterator.next().getAckId());
    messageIterator = messages.iterator();
    pubsubSnippets.nackOneMessageAsync(subscriptionName, messageIterator.next().getAckId());
    pubsubSnippets.nackMoreMessagesAsync(subscriptionName, messageIterator.next().getAckId(),
        messageIterator.next().getAckId());
    pubsubSnippets.nackMessageListAsync(subscriptionName, messageIterator.next().getAckId(),
        messageIterator.next().getAckId());
    messages.clear();
    while (messages.size() < 5) {
      Iterators.addAll(messages, pubsub.pull(subscriptionName, 100));
    }
    messageIterator = messages.iterator();
    pubsubSnippets.ackOneMessageAsync(subscriptionName, messageIterator.next().getAckId());
    pubsubSnippets.ackMoreMessagesAsync(subscriptionName, messageIterator.next().getAckId(),
        messageIterator.next().getAckId());
    pubsubSnippets.ackMessageListAsync(subscriptionName, messageIterator.next().getAckId(),
        messageIterator.next().getAckId());
    assertTrue(pubsubSnippets.deleteTopicAsync(topicName));
    assertTrue(pubsubSnippets.deleteSubscriptionAsync(subscriptionName));
  }

  @Test
  public void testTopicSubscriptionPolicy() {
    String topicName = formatForTest("test-topic-policy");
    Topic topic = pubsubSnippets.createTopic(topicName);
    Policy policy = pubsubSnippets.getTopicPolicy(topicName);
    assertNotNull(policy);
    policy = pubsubSnippets.replaceTopicPolicy(topicName);
    assertTrue(policy.getBindings().containsKey(Role.viewer()));
    assertTrue(policy.getBindings().get(Role.viewer()).contains(Identity.allAuthenticatedUsers()));
    List<Boolean> permissions = pubsubSnippets.testTopicPermissions(topicName);
    assertTrue(permissions.get(0));
    String subscriptionName = formatForTest("test-subscription-policy");
    Subscription subscription = pubsubSnippets.createSubscription(topicName, subscriptionName);
    policy = pubsubSnippets.getSubscriptionPolicy(subscriptionName);
    assertNotNull(policy);
    policy = pubsubSnippets.replaceSubscriptionPolicy(subscriptionName);
    assertTrue(policy.getBindings().containsKey(Role.viewer()));
    assertTrue(policy.getBindings().get(Role.viewer()).contains(Identity.allAuthenticatedUsers()));
    permissions = pubsubSnippets.testSubscriptionPermissions(subscriptionName);
    assertTrue(permissions.get(0));
    topic.delete();
    subscription.delete();
  }

  @Test
  public void testTopicPolicyAsync() throws ExecutionException, InterruptedException {
    String topicName = formatForTest("test-topic-policy-async");
    Topic topic = pubsubSnippets.createTopic(topicName);
    Policy policy = pubsubSnippets.getTopicPolicyAsync(topicName);
    assertNotNull(policy);
    policy = pubsubSnippets.replaceTopicPolicyAsync(topicName);
    assertTrue(policy.getBindings().containsKey(Role.viewer()));
    assertTrue(policy.getBindings().get(Role.viewer()).contains(Identity.allAuthenticatedUsers()));
    List<Boolean> permissions = pubsubSnippets.testTopicPermissionsAsync(topicName);
    assertTrue(permissions.get(0));
    String subscriptionName = formatForTest("test-subscription-policy-async");
    Subscription subscription = pubsubSnippets.createSubscription(topicName, subscriptionName);
    policy = pubsubSnippets.getSubscriptionPolicyAsync(subscriptionName);
    assertNotNull(policy);
    policy = pubsubSnippets.replaceSubscriptionPolicyAsync(subscriptionName);
    assertTrue(policy.getBindings().containsKey(Role.viewer()));
    assertTrue(policy.getBindings().get(Role.viewer()).contains(Identity.allAuthenticatedUsers()));
    permissions = pubsubSnippets.testSubscriptionPermissionsAsync(subscriptionName);
    assertTrue(permissions.get(0));
    topic.delete();
    subscription.delete();
  }

  @Test
  public void testPublisherSubscriber() throws Exception {
    TopicName topicName =
        TopicName.create(pubsub.getOptions().getProjectId(), formatForTest("test-topic"));
    SubscriptionName subscriptionName =
        SubscriptionName.create(
            pubsub.getOptions().getProjectId(), formatForTest("test-subscription"));
    try (PublisherClient publisherClient = PublisherClient.create();
        SubscriberClient subscriberClient = SubscriberClient.create()) {
      publisherClient.createTopic(topicName);
      subscriberClient.createSubscription(
          subscriptionName, topicName, PushConfig.getDefaultInstance(), 0);

      testPublisherSubscriberHelper(topicName, subscriptionName);

      subscriberClient.deleteSubscription(subscriptionName);
      publisherClient.deleteTopic(topicName);
    }
  }

  private void testPublisherSubscriberHelper(
      TopicName topicName, SubscriptionName subscriptionName) throws Exception {
    String messageToPublish = "my-message";

    Publisher publisher = null;
    try {
      publisher = Publisher.newBuilder(topicName).build();
      PublisherSnippets snippets = new PublisherSnippets(publisher);
      final SettableRpcFuture<Void> done = new SettableRpcFuture<>();
      snippets
          .publish(messageToPublish)
          .addCallback(
              new RpcFutureCallback<String>() {
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
    final SettableRpcFuture<Void> done = new SettableRpcFuture<>();
    final SettableRpcFuture<PubsubMessage> received = new SettableRpcFuture<>();
    SubscriberSnippets snippets =
        new SubscriberSnippets(
            subscriptionName,
            new MessageReceiverSnippets(queue).messageReceiver(),
            done,
            MoreExecutors.directExecutor());
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          received.set(queue.poll(10, TimeUnit.MINUTES));
        } catch (InterruptedException e) {
          received.set(null);
        }
        done.set(null); // signal the subscriber to clean up
      }
    }).start();
    snippets.startAndWait(); // blocks until done is set

    PubsubMessage message = received.get();
    assertNotNull(message);
    assertEquals(message.getData().toStringUtf8(), messageToPublish);
  }
}

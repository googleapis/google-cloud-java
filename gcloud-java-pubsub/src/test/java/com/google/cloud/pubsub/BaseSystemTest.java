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

package com.google.cloud.pubsub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.AsyncPage;
import com.google.cloud.Page;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * A base class for system tests. This class can be extended to run system tests in different
 * environments (e.g. local emulator or remote Pub/Sub service).
 */
public abstract class BaseSystemTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  /**
   * Returns the Pub/Sub service used to issue requests. This service can be such that it interacts
   * with the remote Pub/Sub service (for integration tests) or with an emulator
   * (for local testing).
   */
  protected abstract PubSub pubsub();

  /**
   * Formats a resource name for testing purpose. For instance, for tests against the remote
   * service, it is recommended to append to the name a random or time-based seed to prevent
   * name clashes.
   */
  protected abstract String formatForTest(String resourceName);

  @Test
  public void testCreateGetAndDeleteTopic() {
    String name = formatForTest("test-create-get-delete-topic");
    Topic topic = pubsub().create(TopicInfo.of(name));
    assertEquals(name, topic.name());
    Topic remoteTopic = pubsub().getTopic(name);
    assertEquals(topic, remoteTopic);
    assertTrue(topic.delete());
  }

  @Test
  public void testGetTopic_NotExist() {
    String name = formatForTest("test-get-non-existing-topic");
    assertNull(pubsub().getTopic(name));
  }

  @Test
  public void testDeleteTopic_NotExist() {
    assertFalse(pubsub().deleteTopic(formatForTest("test-delete-non-existing-topic")));
  }

  @Test
  public void testCreateGetAndDeleteTopicAsync() throws ExecutionException, InterruptedException {
    String name = formatForTest("test-create-get-delete-async-topic");
    Future<Topic> topicFuture = pubsub().createAsync(TopicInfo.of(name));
    Topic createdTopic = topicFuture.get();
    assertEquals(name, createdTopic.name());
    topicFuture = pubsub().getTopicAsync(name);
    assertEquals(createdTopic, topicFuture.get());
    assertTrue(createdTopic.deleteAsync().get());
  }

  @Test
  public void testListTopics() {
    Topic topic1 = pubsub().create(TopicInfo.of(formatForTest("test-list-topic1")));
    Topic topic2 = pubsub().create(TopicInfo.of(formatForTest("test-list-topic2")));
    Topic topic3 = pubsub().create(TopicInfo.of(formatForTest("test-list-topic3")));
    Set<String> topicNames = Sets.newHashSet();
    // We use 1 as page size to force pagination
    Page<Topic> topics = pubsub().listTopics(PubSub.ListOption.pageSize(1));
    Iterator<Topic> iterator = topics.iterateAll();
    while (iterator.hasNext()) {
      topicNames.add(iterator.next().name());
    }
    assertTrue(topicNames.contains(topic1.name()));
    assertTrue(topicNames.contains(topic2.name()));
    assertTrue(topicNames.contains(topic3.name()));
    assertTrue(topic1.delete());
    assertTrue(topic2.delete());
    assertTrue(topic3.delete());
  }

  @Test
  public void testListTopicsAsync() throws ExecutionException, InterruptedException {
    Topic topic1 = pubsub().create(TopicInfo.of(formatForTest("test-list-async-topic1")));
    Topic topic2 = pubsub().create(TopicInfo.of(formatForTest("test-list-async-topic2")));
    Topic topic3 = pubsub().create(TopicInfo.of(formatForTest("test-list-async-topic3")));
    Set<String> topicNames = Sets.newHashSet();
    Future<AsyncPage<Topic>> pageFuture = pubsub().listTopicsAsync(PubSub.ListOption.pageSize(1));
    Iterator<Topic> iterator = pageFuture.get().iterateAll();
    while (iterator.hasNext()) {
      topicNames.add(iterator.next().name());
    }
    assertTrue(topicNames.contains(topic1.name()));
    assertTrue(topicNames.contains(topic2.name()));
    assertTrue(topicNames.contains(topic3.name()));
    assertTrue(topic1.delete());
    assertTrue(topic2.delete());
    assertTrue(topic3.delete());
  }

  @Test
  public void testPublishOneMessage() {
    String topic = formatForTest("test-publish-one-message-topic");
    pubsub().create(TopicInfo.of(topic));
    Message message = Message.of("payload");
    assertNotNull(pubsub().publish(topic, message));
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testPublishNonExistingTopic() {
    String topic = formatForTest("test-publish-non-existing-topic");
    Message message = Message.of("payload");
    thrown.expect(PubSubException.class);
    pubsub().publish(topic, message);
  }

  @Test
  public void testPublishOneMessageAsync() throws ExecutionException, InterruptedException {
    String topic = formatForTest("test-publish-one-message-async-topic");
    pubsub().create(TopicInfo.of(topic));
    Message message = Message.of("payload");
    Future<String> publishFuture = pubsub().publishAsync(topic, message);
    assertNotNull(publishFuture.get());
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testPublishMoreMessages() {
    String topic = formatForTest("test-publish-more-messages-topic");
    pubsub().create(TopicInfo.of(topic));
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    List<String> messageIds = pubsub().publish(topic, message1, message2);
    assertEquals(2, messageIds.size());
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testPublishMoreMessagesAsync() throws ExecutionException, InterruptedException {
    String topic = formatForTest("test-publish-more-messages-topic-async-topic");
    pubsub().create(TopicInfo.of(topic));
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    Future<List<String>> publishFuture = pubsub().publishAsync(topic, message1, message2);
    assertEquals(2, publishFuture.get().size());
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testPublishMessageList() {
    String topic = formatForTest("test-publish-message-list-topic");
    pubsub().create(TopicInfo.of(topic));
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    List<String> messageIds = pubsub().publish(topic, ImmutableList.of(message1, message2));
    assertEquals(2, messageIds.size());
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testPublishMessagesListAsync() throws ExecutionException, InterruptedException {
    String topic = formatForTest("test-publish-message-list-async-topic");
    pubsub().create(TopicInfo.of(topic));
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    Future<List<String>> publishFuture =
        pubsub().publishAsync(topic, ImmutableList.of(message1, message2));
    assertEquals(2, publishFuture.get().size());
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testCreateGetAndDeleteSubscription() {
    String topic = formatForTest("test-create-get-delete-subscription-topic");
    pubsub().create(TopicInfo.of(topic));
    String name = formatForTest("test-create-get-delete-subscription");
    Subscription subscription = pubsub().create(SubscriptionInfo.of(topic, name));
    assertEquals(TopicId.of(pubsub().options().projectId(), topic), subscription.topic());
    assertEquals(name, subscription.name());
    assertNull(subscription.pushConfig());
    // todo(mziccard) seems not to work on the emulator (returns 60) - see #989
    // assertEquals(10, subscription.ackDeadlineSeconds());
    Subscription remoteSubscription = pubsub().getSubscription(name);
    assertEquals(subscription, remoteSubscription);
    assertTrue(subscription.delete());
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testGetSubscription_NotExist() {
    assertNull(pubsub().getSubscription(formatForTest("test-get-non-existing-subscription")));
  }

  @Test
  public void testDeleteSubscription_NotExist() {
    assertFalse(
        pubsub().deleteSubscription(formatForTest("test-delete-non-existing-subscription")));
  }

  @Test
  public void testCreateGetAndDeleteSubscriptionAsync()
      throws ExecutionException, InterruptedException {
    String topic = formatForTest("test-create-get-delete-async-subscription-topic");
    pubsub().create(TopicInfo.of(topic));
    String name = formatForTest("test-create-get-delete-async-subscription");
    String endpoint = "https://" + pubsub().options().projectId() + ".appspot.com/push";
    PushConfig pushConfig = PushConfig.of(endpoint);
    Future<Subscription> subscriptionFuture =
        pubsub().createAsync(SubscriptionInfo.builder(topic, name).pushConfig(pushConfig).build());
    Subscription subscription = subscriptionFuture.get();
    assertEquals(TopicId.of(pubsub().options().projectId(), topic), subscription.topic());
    assertEquals(name, subscription.name());
    assertEquals(pushConfig, subscription.pushConfig());
    // todo(mziccard) seems not to work on the emulator (returns 60) - see #989
    // assertEquals(10, subscription.ackDeadlineSeconds());
    subscriptionFuture = pubsub().getSubscriptionAsync(name);
    Subscription remoteSubscription = subscriptionFuture.get();
    assertEquals(subscription, remoteSubscription);
    assertTrue(subscription.deleteAsync().get());
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  @Ignore("Emulator incosistency; see issue ##988")
  public void testGetSubscriptionDeletedTopic() {
    String topic = formatForTest("test-get-deleted-topic-subscription-topic");
    pubsub().create(TopicInfo.of(topic));
    String name = formatForTest("test-get-deleted-topic-subscription");
    Subscription subscription = pubsub().create(SubscriptionInfo.of(topic, name));
    assertEquals(TopicId.of(pubsub().options().projectId(), topic), subscription.topic());
    assertEquals(name, subscription.name());
    assertNull(subscription.pushConfig());
    // todo(mziccard) seems not to work on the emulator (returns 60) - see #989
    // assertEquals(10, subscription.ackDeadlineSeconds());
    assertTrue(pubsub().deleteTopic(topic));
    assertNull(pubsub().getTopic(topic));
    Subscription remoteSubscription = pubsub().getSubscription(name);
    assertEquals(TopicId.of("_deleted-topic_"), remoteSubscription.topic());
    assertEquals(name, remoteSubscription.name());
    assertNull(remoteSubscription.pushConfig());
    assertTrue(subscription.delete());
  }

  @Test
  public void testReplaceSubscriptionPushConfig() {
    String topic = formatForTest("test-replace-push-config-topic");
    pubsub().create(TopicInfo.of(topic));
    String name = formatForTest("test-replace-push-config-subscription");
    String endpoint = "https://" + pubsub().options().projectId() + ".appspot.com/push";
    PushConfig pushConfig = PushConfig.of(endpoint);
    Subscription subscription =
        pubsub().create(SubscriptionInfo.builder(topic, name).pushConfig(pushConfig).build());
    assertEquals(TopicId.of(pubsub().options().projectId(), topic), subscription.topic());
    assertEquals(name, subscription.name());
    assertEquals(pushConfig, subscription.pushConfig());
    // todo(mziccard) seems not to work on the emulator (returns 60) - see #989
    // assertEquals(10, subscription.ackDeadlineSeconds());
    pubsub().replacePushConfig(name, null);
    Subscription remoteSubscription = pubsub().getSubscription(name);
    assertEquals(TopicId.of(pubsub().options().projectId(), topic), remoteSubscription.topic());
    assertEquals(name, remoteSubscription.name());
    assertNull(remoteSubscription.pushConfig());
    // todo(mziccard) seems not to work on the emulator (returns 60) - see #989
    // assertEquals(10, remoteSubscription.ackDeadlineSeconds());
    assertTrue(subscription.delete());
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testReplaceNonExistingSubscriptionPushConfig() {
    String name = formatForTest("test-replace-push-config-non-existing-subscription");
    thrown.expect(PubSubException.class);
    pubsub().replacePushConfig(name, null);
  }

  @Test
  public void testReplaceSubscriptionPushConfigAsync()
      throws ExecutionException, InterruptedException {
    String topic = formatForTest("test-replace-push-config-async-topic");
    pubsub().create(TopicInfo.of(topic));
    String name = formatForTest("test-replace-push-config-async-subscription");
    Future<Subscription> subscriptionFuture =
        pubsub().createAsync(SubscriptionInfo.of(topic, name));
    Subscription subscription = subscriptionFuture.get();
    assertEquals(TopicId.of(pubsub().options().projectId(), topic), subscription.topic());
    assertEquals(name, subscription.name());
    assertNull(subscription.pushConfig());
    // todo(mziccard) seems not to work on the emulator (returns 60) - see #989
    // assertEquals(10, subscription.ackDeadlineSeconds());
    String endpoint = "https://" + pubsub().options().projectId() + ".appspot.com/push";
    PushConfig pushConfig = PushConfig.of(endpoint);
    pubsub().replacePushConfigAsync(name, pushConfig).get();
    Subscription remoteSubscription = pubsub().getSubscriptionAsync(name).get();
    assertEquals(TopicId.of(pubsub().options().projectId(), topic), remoteSubscription.topic());
    assertEquals(name, remoteSubscription.name());
    assertEquals(pushConfig, remoteSubscription.pushConfig());
    // todo(mziccard) seems not to work on the emulator (returns 60) - see #989
    // assertEquals(10, remoteSubscription.ackDeadlineSeconds());
    assertTrue(subscription.deleteAsync().get());
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testListSubscriptions() {
    String topicName1 = formatForTest("test-list-subscriptions-topic1");
    String topicName2 = formatForTest("test-list-subscriptions-topic2");
    Topic topic1 = pubsub().create(TopicInfo.of(topicName1));
    Topic topic2 = pubsub().create(TopicInfo.of(topicName2));
    String subscriptionName1 = formatForTest("test-list-subscriptions-subscription1");
    String subscriptionName2 = formatForTest("test-list-subscriptions-subscription2");
    String subscriptionName3 = formatForTest("test-list-subscriptions-subscription3");
    Subscription subscription1 =
        pubsub().create(SubscriptionInfo.of(topicName1, subscriptionName1));
    Subscription subscription2 =
        pubsub().create(SubscriptionInfo.of(topicName1, subscriptionName2));
    Subscription subscription3 =
        pubsub().create(SubscriptionInfo.of(topicName2, subscriptionName3));
    Set<String> subscriptionNames = Sets.newHashSet();
    // We use 1 as page size to force pagination
    Page<Subscription> subscriptions = pubsub().listSubscriptions(PubSub.ListOption.pageSize(1));
    Iterator<Subscription> iterator = subscriptions.iterateAll();
    while (iterator.hasNext()) {
      String name = iterator.next().name();
      subscriptionNames.add(name);
    }
    assertTrue(subscriptionNames.contains(subscriptionName1));
    assertTrue(subscriptionNames.contains(subscriptionName2));
    assertTrue(subscriptionNames.contains(subscriptionName3));
    Set<String> topicSubscriptionNames = Sets.newHashSet();
    Page<SubscriptionId> topic1Subscriptions =
        topic1.listSubscriptions(PubSub.ListOption.pageSize(1));
    Iterator<SubscriptionId> firstStringPageIterator = topic1Subscriptions.values().iterator();
    topicSubscriptionNames.add(firstStringPageIterator.next().subscription());
    assertFalse(firstStringPageIterator.hasNext());
    Iterator<SubscriptionId> topicSubscriptionsIterator =
        topic1Subscriptions.nextPage().iterateAll();
    while (topicSubscriptionsIterator.hasNext()) {
      topicSubscriptionNames.add(topicSubscriptionsIterator.next().subscription());
    }
    assertEquals(2, topicSubscriptionNames.size());
    assertTrue(topicSubscriptionNames.contains(subscriptionName1));
    assertTrue(topicSubscriptionNames.contains(subscriptionName2));
    assertTrue(topic1.delete());
    assertTrue(topic2.delete());
    assertTrue(subscription1.delete());
    assertTrue(subscription2.delete());
    assertTrue(subscription3.delete());
  }

  @Test
  public void testListSubscriptionsAsync() throws ExecutionException, InterruptedException {
    String topicName1 = formatForTest("test-list-subscriptions-async-topic1");
    String topicName2 = formatForTest("test-list-subscriptions-async-topic2");
    Topic topic1 = pubsub().create(TopicInfo.of(topicName1));
    Topic topic2 = pubsub().create(TopicInfo.of(topicName2));
    String subscriptionName1 = formatForTest("test-list-subscriptions-async-subscription1");
    String subscriptionName2 = formatForTest("test-list-subscriptions-async-subscription2");
    String subscriptionName3 = formatForTest("test-list-subscriptions-async-subscription3");
    Subscription subscription1 =
        pubsub().create(SubscriptionInfo.of(topicName1, subscriptionName1));
    Subscription subscription2 =
        pubsub().create(SubscriptionInfo.of(topicName1, subscriptionName2));
    Subscription subscription3 =
        pubsub().create(SubscriptionInfo.of(topicName2, subscriptionName3));
    // We use 1 as page size to force pagination
    Set<String> subscriptionNames = Sets.newHashSet();
    Future<AsyncPage<Subscription>> pageFuture =
        pubsub().listSubscriptionsAsync(PubSub.ListOption.pageSize(1));
    Iterator<Subscription> iterator = pageFuture.get().iterateAll();
    while (iterator.hasNext()) {
      subscriptionNames.add(iterator.next().name());
    }
    assertTrue(subscriptionNames.contains(subscriptionName1));
    assertTrue(subscriptionNames.contains(subscriptionName2));
    assertTrue(subscriptionNames.contains(subscriptionName3));
    Set<String> topicSubscriptionNames = Sets.newHashSet();
    AsyncPage<SubscriptionId> topic1Subscriptions =
        topic1.listSubscriptionsAsync(PubSub.ListOption.pageSize(1)).get();
    Iterator<SubscriptionId> firstStringPageIterator = topic1Subscriptions.values().iterator();
    topicSubscriptionNames.add(firstStringPageIterator.next().subscription());
    assertFalse(firstStringPageIterator.hasNext());
    Iterator<SubscriptionId> topicSubscriptionsIterator =
        topic1Subscriptions.nextPageAsync().get().iterateAll();
    while (topicSubscriptionsIterator.hasNext()) {
      topicSubscriptionNames.add(topicSubscriptionsIterator.next().subscription());
    }
    assertEquals(2, topicSubscriptionNames.size());
    assertTrue(topicSubscriptionNames.contains(subscriptionName1));
    assertTrue(topicSubscriptionNames.contains(subscriptionName2));
    assertTrue(topic1.delete());
    assertTrue(topic2.delete());
    assertTrue(subscription1.delete());
    assertTrue(subscription2.delete());
    assertTrue(subscription3.delete());
  }

  @Test
  public void testPullMessages() {
    String topic = formatForTest("test-pull-messages-topic");
    pubsub().create(TopicInfo.of(topic));
    String subscription = formatForTest("test-pull-messages-subscription");
    pubsub().create(SubscriptionInfo.of(topic, subscription));
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    List<String> messageIds = pubsub().publish(topic, ImmutableList.of(message1, message2));
    assertEquals(2, messageIds.size());
    Iterator<ReceivedMessage> iterator = pubsub().pull(subscription, 2);
    assertEquals(message1.payloadAsString(), iterator.next().payloadAsString());
    assertEquals(message2.payloadAsString(), iterator.next().payloadAsString());
    assertTrue(pubsub().deleteSubscription(subscription));
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testPullMessagesAndAutoRenewDeadline() throws InterruptedException {
    String topic = formatForTest("test-pull-messages-and-renew-deadline-topic");
    pubsub().create(TopicInfo.of(topic));
    String subscription = formatForTest("test-pull-messages-and-renew-deadline-subscription");
    pubsub().create(SubscriptionInfo.builder(topic, subscription).ackDeadLineSeconds(10).build());
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    // todo(mziccard): use batch publish if #1017 gets fixed, or remove this comment
    pubsub().publish(topic, message1);
    pubsub().publish(topic, message2);
    Iterator<ReceivedMessage> iterator = pubsub().pull(subscription, 2);
    ReceivedMessage consumedMessage = iterator.next();
    Thread.sleep(15000);
    // first message was consumed while second message is still being renewed
    Iterator<ReceivedMessage> nextIterator = pubsub().pull(subscription, 2);
    assertTrue(nextIterator.hasNext());
    ReceivedMessage message = nextIterator.next();
    assertEquals(consumedMessage.payloadAsString(), message.payloadAsString());
    assertFalse(nextIterator.hasNext());
    consumedMessage.ack();
    iterator.next().ack();
    nextIterator = pubsub().pull(subscription, 2);
    assertFalse(nextIterator.hasNext());
    assertTrue(pubsub().deleteSubscription(subscription));
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testPullMessagesAndModifyAckDeadline() throws InterruptedException {
    String topic = formatForTest("test-pull-messages-and-modify-deadline-topic");
    pubsub().create(TopicInfo.of(topic));
    String subscription = formatForTest("test-pull-messages-and-modify-deadline-subscription");
    pubsub().create(SubscriptionInfo.builder(topic, subscription).ackDeadLineSeconds(10).build());
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    // todo(mziccard): use batch publish if #1017 gets fixed, or remove this comment
    pubsub().publish(topic, message1);
    pubsub().publish(topic, message2);
    // Consume all messages and stop ack renewal
    List<ReceivedMessage> receivedMessages = Lists.newArrayList(pubsub().pull(subscription, 2));
    receivedMessages.get(0).modifyAckDeadline(60, TimeUnit.SECONDS);
    Thread.sleep(15000);
    // first message was renewed while second message should still be sent on pull requests
    Iterator<ReceivedMessage> nextIterator = pubsub().pull(subscription, 2);
    assertTrue(nextIterator.hasNext());
    ReceivedMessage message = nextIterator.next();
    assertEquals(receivedMessages.get(1).payloadAsString(), message.payloadAsString());
    assertFalse(nextIterator.hasNext());
    assertTrue(pubsub().deleteSubscription(subscription));
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testPullNonExistingSubscription() {
    thrown.expect(PubSubException.class);
    pubsub().pull(formatForTest("non-existing-subscription"), 2);
  }

  @Test
  public void testPullMessagesAsync() throws ExecutionException, InterruptedException {
    String topic = formatForTest("test-pull-messages-async-topic");
    pubsub().create(TopicInfo.of(topic));
    String subscription = formatForTest("test-pull-messages-async-subscription");
    pubsub().create(SubscriptionInfo.of(topic, subscription));
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    List<String> messageIds = pubsub().publish(topic, ImmutableList.of(message1, message2));
    assertEquals(2, messageIds.size());
    Iterator<ReceivedMessage> iterator = pubsub().pullAsync(subscription, 2).get();
    assertEquals(message1.payloadAsString(), iterator.next().payloadAsString());
    assertEquals(message2.payloadAsString(), iterator.next().payloadAsString());
    assertTrue(pubsub().deleteSubscription(subscription));
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testPullAsyncNonExistingSubscription()
      throws ExecutionException, InterruptedException {
    thrown.expect(ExecutionException.class);
    pubsub().pullAsync(formatForTest("non-existing-subscription"), 2).get();
  }

  @Test
  public void testAckAndNackOneMessage() {
    String topic = formatForTest("test-ack-one-message-topic");
    pubsub().create(TopicInfo.of(topic));
    String subscription = formatForTest("test-ack-one-message-subscription");
    pubsub().create(SubscriptionInfo.of(topic, subscription));
    Message message = Message.of("payload");
    assertNotNull(pubsub().publish(topic, message));
    Iterator<ReceivedMessage> receivedMessages = pubsub().pull(subscription, 1);
    receivedMessages.next().nack();
    receivedMessages = pubsub().pull(subscription, 1);
    receivedMessages.next().ack();
    assertFalse(pubsub().pull(subscription, 1).hasNext());
    assertTrue(pubsub().deleteSubscription(subscription));
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testAckAndNackOneMessageAsync() throws ExecutionException, InterruptedException {
    String topic = formatForTest("test-ack-one-message-async-topic");
    pubsub().create(TopicInfo.of(topic));
    String subscription = formatForTest("test-ack-one-message-async-subscription");
    pubsub().create(SubscriptionInfo.of(topic, subscription));
    Message message = Message.of("payload");
    assertNotNull(pubsub().publish(topic, message));
    Iterator<ReceivedMessage> receivedMessages = pubsub().pull(subscription, 1);
    receivedMessages.next().nackAsync().get();
    receivedMessages = pubsub().pull(subscription, 1);
    receivedMessages.next().ackAsync().get();
    assertFalse(pubsub().pull(subscription, 1).hasNext());
    assertTrue(pubsub().deleteSubscription(subscription));
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testAckAndNackMoreMessages() throws ExecutionException, InterruptedException {
    String topic = formatForTest("test-ack-more-messages-topic");
    pubsub().create(TopicInfo.of(topic));
    String subscription = formatForTest("test-ack-more-messages-subscription");
    pubsub().create(SubscriptionInfo.of(topic, subscription));
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    assertNotNull(pubsub().publish(topic, message1, message2));
    Iterator<ReceivedMessage> receivedMessages = pubsub().pull(subscription, 2);
    pubsub().nack(subscription, receivedMessages.next().ackId(), receivedMessages.next().ackId());
    receivedMessages = pubsub().pull(subscription, 2);
    pubsub().ack(subscription, receivedMessages.next().ackId(), receivedMessages.next().ackId());
    assertFalse(pubsub().pull(subscription, 2).hasNext());
    assertTrue(pubsub().deleteSubscription(subscription));
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testAckAndNackMoreMessagesAsync() throws ExecutionException, InterruptedException {
    String topic = formatForTest("test-ack-more-messages-async-topic");
    pubsub().create(TopicInfo.of(topic));
    String subscription = formatForTest("test-ack-more-messages-async-subscription");
    pubsub().create(SubscriptionInfo.of(topic, subscription));
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    assertNotNull(pubsub().publish(topic, message1, message2));
    Iterator<ReceivedMessage> receivedMessages = pubsub().pull(subscription, 2);
    pubsub()
        .nackAsync(subscription, receivedMessages.next().ackId(), receivedMessages.next().ackId())
        .get();
    receivedMessages = pubsub().pull(subscription, 2);
    pubsub()
        .ackAsync(subscription, receivedMessages.next().ackId(), receivedMessages.next().ackId())
        .get();
    assertFalse(pubsub().pull(subscription, 2).hasNext());
    assertTrue(pubsub().deleteSubscription(subscription));
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testAckAndNackMessageList() throws ExecutionException, InterruptedException {
    String topic = formatForTest("test-ack-message-list-topic");
    pubsub().create(TopicInfo.of(topic));
    String subscription = formatForTest("test-ack-message-list-subscription");
    pubsub().create(SubscriptionInfo.of(topic, subscription));
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    assertNotNull(pubsub().publish(topic, ImmutableList.of(message1, message2)));
    Iterator<ReceivedMessage> receivedMessages = pubsub().pull(subscription, 2);
    pubsub().nack(subscription,
        ImmutableList.of(receivedMessages.next().ackId(), receivedMessages.next().ackId()));
    receivedMessages = pubsub().pull(subscription, 2);
    pubsub().ack(subscription,
        ImmutableList.of(receivedMessages.next().ackId(), receivedMessages.next().ackId()));
    assertFalse(pubsub().pull(subscription, 2).hasNext());
    assertTrue(pubsub().deleteSubscription(subscription));
    assertTrue(pubsub().deleteTopic(topic));
  }

  @Test
  public void testAckAndNackMessageListAsync() throws ExecutionException, InterruptedException {
    String topic = formatForTest("test-ack-message-list-async-topic");
    pubsub().create(TopicInfo.of(topic));
    String subscription = formatForTest("test-ack-message-list-async-subscription");
    pubsub().create(SubscriptionInfo.of(topic, subscription));
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    assertNotNull(pubsub().publish(topic, ImmutableList.of(message1, message2)));
    Iterator<ReceivedMessage> receivedMessages = pubsub().pull(subscription, 2);
    pubsub().nackAsync(subscription,
        ImmutableList.of(receivedMessages.next().ackId(), receivedMessages.next().ackId())).get();
    receivedMessages = pubsub().pull(subscription, 2);
    pubsub().ackAsync(subscription,
        ImmutableList.of(receivedMessages.next().ackId(), receivedMessages.next().ackId())).get();
    assertFalse(pubsub().pull(subscription, 2).hasNext());
    assertTrue(pubsub().deleteSubscription(subscription));
    assertTrue(pubsub().deleteTopic(topic));
  }
}

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

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.AsyncPage;
import com.google.cloud.AsyncPageImpl;
import com.google.cloud.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.pubsub.PubSub.ListOption;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;

import org.junit.After;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class TopicTest {

  private static final String NAME = "topic";
  private static final TopicInfo TOPIC_INFO = TopicInfo.of(NAME);

  private final PubSub serviceMockReturnsOptions = createStrictMock(PubSub.class);
  private final PubSubOptions mockOptions = createMock(PubSubOptions.class);
  private PubSub pubsub;
  private Topic expectedTopic;
  private Topic topic;

  private void initializeExpectedTopic(int optionsCalls) {
    expect(serviceMockReturnsOptions.options()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    pubsub = createStrictMock(PubSub.class);
    expectedTopic = new Topic(serviceMockReturnsOptions, new Topic.BuilderImpl(TOPIC_INFO));
  }

  private void initializeTopic() {
    topic = new Topic(pubsub, new Topic.BuilderImpl(TOPIC_INFO));
  }

  @After
  public void tearDown() throws Exception {
    verify(pubsub, serviceMockReturnsOptions);
  }

  @Test
  public void testBuilder() {
    initializeExpectedTopic(2);
    replay(pubsub);
    Topic builtTopic = expectedTopic.toBuilder().name("newTopic").build();
    assertEquals("newTopic", builtTopic.name());
  }

  @Test
  public void testToBuilder() {
    initializeExpectedTopic(2);
    replay(pubsub);
    compareTopic(expectedTopic, expectedTopic.toBuilder().build());
  }

  @Test
  public void testReload() {
    initializeExpectedTopic(2);
    TopicInfo updatedInfo = TOPIC_INFO.toBuilder().name("newTopic").build();
    Topic expectedTopic =
        new Topic(serviceMockReturnsOptions, new TopicInfo.BuilderImpl(updatedInfo));
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.getTopic(NAME)).andReturn(expectedTopic);
    replay(pubsub);
    initializeTopic();
    Topic updatedTopic = topic.reload();
    compareTopic(expectedTopic, updatedTopic);
  }

  @Test
  public void testReloadNull() {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.getTopic(NAME)).andReturn(null);
    replay(pubsub);
    initializeTopic();
    assertNull(topic.reload());
  }

  @Test
  public void testReloadAsync() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(2);
    TopicInfo updatedInfo = TOPIC_INFO.toBuilder().name("newTopic").build();
    Topic expectedTopic =
        new Topic(serviceMockReturnsOptions, new TopicInfo.BuilderImpl(updatedInfo));
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.getTopicAsync(NAME))
        .andReturn(Futures.immediateFuture(expectedTopic));
    replay(pubsub);
    initializeTopic();
    Topic updatedTopic = topic.reloadAsync().get();
    compareTopic(expectedTopic, updatedTopic);
  }

  @Test
  public void testReloadAsyncNull() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.getTopicAsync(NAME)).andReturn(Futures.<Topic>immediateFuture(null));
    replay(pubsub);
    initializeTopic();
    assertNull(topic.reloadAsync().get());
  }

  @Test
  public void testDeleteTrue() {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.deleteTopic(NAME)).andReturn(true);
    replay(pubsub);
    initializeTopic();
    assertTrue(topic.delete());
  }

  @Test
  public void testDeleteFalse() {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.deleteTopic(NAME)).andReturn(false);
    replay(pubsub);
    initializeTopic();
    assertFalse(topic.delete());
  }

  @Test
  public void testDeleteAsyncTrue() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.deleteTopicAsync(NAME)).andReturn(Futures.immediateFuture(true));
    replay(pubsub);
    initializeTopic();
    assertTrue(topic.deleteAsync().get());
  }

  @Test
  public void testDeleteAsyncFalse() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.deleteTopicAsync(NAME)).andReturn(Futures.immediateFuture(false));
    replay(pubsub);
    initializeTopic();
    assertFalse(topic.deleteAsync().get());
  }

  @Test
  public void testPublishOneMessage() {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    Message message = Message.of("payload1");
    String messageId = "messageId";
    expect(pubsub.publish(NAME, message)).andReturn(messageId);
    replay(pubsub);
    initializeTopic();
    assertEquals(messageId, topic.publish(message));
  }

  @Test
  public void testPublishOneMessageAsync() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    Message message = Message.of("payload1");
    String messageId = "messageId";
    expect(pubsub.publishAsync(NAME, message))
        .andReturn(Futures.immediateFuture(messageId));
    replay(pubsub);
    initializeTopic();
    assertEquals(messageId, topic.publishAsync(message).get());
  }

  @Test
  public void testPublishMoreMessages() {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    List<String> messageIds = ImmutableList.of("messageId1", "messageId2");
    expect(pubsub.publish(NAME, message1, message2)).andReturn(messageIds);
    replay(pubsub);
    initializeTopic();
    assertEquals(messageIds, topic.publish(message1, message2));
  }

  @Test
  public void testPublishMoreMessagesAsync() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    List<String> messageIds = ImmutableList.of("messageId1", "messageId2");
    expect(pubsub.publishAsync(NAME, message1, message2))
        .andReturn(Futures.immediateFuture(messageIds));
    replay(pubsub);
    initializeTopic();
    assertEquals(messageIds, topic.publishAsync(message1, message2).get());
  }

  @Test
  public void testPublishMessageList() {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    List<Message> messages = ImmutableList.of(message1, message2);
    List<String> messageIds = ImmutableList.of("messageId1", "messageId2");
    expect(pubsub.publish(NAME, messages)).andReturn(messageIds);
    replay(pubsub);
    initializeTopic();
    assertEquals(messageIds, topic.publish(messages));
  }

  @Test
  public void testPublishMessageListAsync() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    List<Message> messages = ImmutableList.of(message1, message2);
    List<String> messageIds = ImmutableList.of("messageId1", "messageId2");
    expect(pubsub.publishAsync(NAME, messages))
        .andReturn(Futures.immediateFuture(messageIds));
    replay(pubsub);
    initializeTopic();
    assertEquals(messageIds, topic.publishAsync(messages).get());
  }

  @Test
  public void testListSubscriptions() {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    final List<SubscriptionId> subscriptions = ImmutableList.of(
        new SubscriptionId("project", "subscription1"),
        new SubscriptionId("project", "subscription2"));
    Page<SubscriptionId> result = new PageImpl<>(null, null, subscriptions);
    expect(pubsub.listSubscriptions(NAME)).andReturn(result);
    replay(pubsub);
    initializeTopic();
    assertEquals(subscriptions, topic.listSubscriptions().values());
  }

  @Test
  public void testListSubscriptionsWithOptions() {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    final List<SubscriptionId> subscriptions = ImmutableList.of(
        new SubscriptionId("project", "subscription1"),
        new SubscriptionId("project", "subscription2"));
    Page<SubscriptionId> result = new PageImpl<>(null, null, subscriptions);
    expect(pubsub.listSubscriptions(NAME, ListOption.pageSize(42))).andReturn(result);
    replay(pubsub);
    initializeTopic();
    assertEquals(subscriptions, topic.listSubscriptions(ListOption.pageSize(42)).values());
  }

  @Test
  public void testListSubscriptionsAsync() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    final List<SubscriptionId> subscriptions = ImmutableList.of(
        new SubscriptionId("project", "subscription1"),
        new SubscriptionId("project", "subscription2"));
    AsyncPage<SubscriptionId> result = new AsyncPageImpl<>(null, null, subscriptions);
    expect(pubsub.listSubscriptionsAsync(NAME))
        .andReturn(Futures.immediateFuture(result));
    replay(pubsub);
    initializeTopic();
    assertEquals(subscriptions, topic.listSubscriptionsAsync().get().values());
  }

  @Test
  public void testListSubscriptionsAsyncWithOptions()
      throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.options()).andReturn(mockOptions);
    final List<SubscriptionId> subscriptions = ImmutableList.of(
        new SubscriptionId("project", "subscription1"),
        new SubscriptionId("project", "subscription2"));
    AsyncPage<SubscriptionId> result = new AsyncPageImpl<>(null, null, subscriptions);
    expect(pubsub.listSubscriptionsAsync(NAME, ListOption.pageSize(42)))
        .andReturn(Futures.immediateFuture(result));
    replay(pubsub);
    initializeTopic();
    assertEquals(subscriptions,
        topic.listSubscriptionsAsync(ListOption.pageSize(42)).get().values());
  }

  private void compareTopic(Topic expected, Topic value) {
    assertEquals(expected, value);
    assertEquals(expected.name(), value.name());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}

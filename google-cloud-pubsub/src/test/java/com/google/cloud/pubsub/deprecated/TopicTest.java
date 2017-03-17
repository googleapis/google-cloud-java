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

package com.google.cloud.pubsub.deprecated;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.core.ApiFutures;
import com.google.cloud.AsyncPage;
import com.google.cloud.AsyncPageImpl;
import com.google.cloud.Identity;
import com.google.cloud.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.pubsub.deprecated.PubSub.ListOption;
import com.google.common.collect.ImmutableList;

import org.junit.After;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class TopicTest {

  private static final String NAME = "topic";
  private static final TopicInfo TOPIC_INFO = TopicInfo.of(NAME);
  private static final Policy POLICY = Policy.newBuilder()
      .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
      .build();

  private final PubSub serviceMockReturnsOptions = createStrictMock(PubSub.class);
  private final PubSubOptions mockOptions = createMock(PubSubOptions.class);
  private PubSub pubsub;
  private Topic expectedTopic;
  private Topic topic;

  private void initializeExpectedTopic(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
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
    Topic builtTopic = expectedTopic.toBuilder().setName("newTopic").build();
    assertEquals("newTopic", builtTopic.getName());
    assertSame(serviceMockReturnsOptions, expectedTopic.getPubsub());
  }

  @Test
  public void testBuilderDeprecated() {
    initializeExpectedTopic(2);
    replay(pubsub);
    Topic builtTopic = expectedTopic.toBuilder().name("newTopic").build();
    assertEquals("newTopic", builtTopic.name());
    assertSame(serviceMockReturnsOptions, expectedTopic.pubSub());
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
    TopicInfo updatedInfo = TOPIC_INFO.toBuilder().setName("newTopic").build();
    Topic expectedTopic =
        new Topic(serviceMockReturnsOptions, new TopicInfo.BuilderImpl(updatedInfo));
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getTopic(NAME)).andReturn(expectedTopic);
    replay(pubsub);
    initializeTopic();
    Topic updatedTopic = topic.reload();
    compareTopic(expectedTopic, updatedTopic);
  }

  @Test
  public void testReloadNull() {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getTopic(NAME)).andReturn(null);
    replay(pubsub);
    initializeTopic();
    assertNull(topic.reload());
  }

  @Test
  public void testReloadAsync() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(2);
    TopicInfo updatedInfo = TOPIC_INFO.toBuilder().setName("newTopic").build();
    Topic expectedTopic =
        new Topic(serviceMockReturnsOptions, new TopicInfo.BuilderImpl(updatedInfo));
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getTopicAsync(NAME))
        .andReturn(ApiFutures.immediateFuture(expectedTopic));
    replay(pubsub);
    initializeTopic();
    Topic updatedTopic = topic.reloadAsync().get();
    compareTopic(expectedTopic, updatedTopic);
  }

  @Test
  public void testReloadAsyncNull() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getTopicAsync(NAME)).andReturn(ApiFutures.<Topic>immediateFuture(null));
    replay(pubsub);
    initializeTopic();
    assertNull(topic.reloadAsync().get());
  }

  @Test
  public void testDeleteTrue() {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.deleteTopic(NAME)).andReturn(true);
    replay(pubsub);
    initializeTopic();
    assertTrue(topic.delete());
  }

  @Test
  public void testDeleteFalse() {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.deleteTopic(NAME)).andReturn(false);
    replay(pubsub);
    initializeTopic();
    assertFalse(topic.delete());
  }

  @Test
  public void testDeleteAsyncTrue() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.deleteTopicAsync(NAME)).andReturn(ApiFutures.immediateFuture(true));
    replay(pubsub);
    initializeTopic();
    assertTrue(topic.deleteAsync().get());
  }

  @Test
  public void testDeleteAsyncFalse() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.deleteTopicAsync(NAME)).andReturn(ApiFutures.immediateFuture(false));
    replay(pubsub);
    initializeTopic();
    assertFalse(topic.deleteAsync().get());
  }

  @Test
  public void testPublishOneMessage() {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
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
    expect(pubsub.getOptions()).andReturn(mockOptions);
    Message message = Message.of("payload1");
    String messageId = "messageId";
    expect(pubsub.publishAsync(NAME, message))
        .andReturn(ApiFutures.immediateFuture(messageId));
    replay(pubsub);
    initializeTopic();
    assertEquals(messageId, topic.publishAsync(message).get());
  }

  @Test
  public void testPublishMoreMessages() {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
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
    expect(pubsub.getOptions()).andReturn(mockOptions);
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    List<String> messageIds = ImmutableList.of("messageId1", "messageId2");
    expect(pubsub.publishAsync(NAME, message1, message2))
        .andReturn(ApiFutures.immediateFuture(messageIds));
    replay(pubsub);
    initializeTopic();
    assertEquals(messageIds, topic.publishAsync(message1, message2).get());
  }

  @Test
  public void testPublishMessageList() {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
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
    expect(pubsub.getOptions()).andReturn(mockOptions);
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    List<Message> messages = ImmutableList.of(message1, message2);
    List<String> messageIds = ImmutableList.of("messageId1", "messageId2");
    expect(pubsub.publishAsync(NAME, messages))
        .andReturn(ApiFutures.immediateFuture(messageIds));
    replay(pubsub);
    initializeTopic();
    assertEquals(messageIds, topic.publishAsync(messages).get());
  }

  @Test
  public void testListSubscriptions() {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    final List<SubscriptionId> subscriptions = ImmutableList.of(
        new SubscriptionId("project", "subscription1"),
        new SubscriptionId("project", "subscription2"));
    Page<SubscriptionId> result = new PageImpl<>(null, null, subscriptions);
    expect(pubsub.listSubscriptions(NAME)).andReturn(result);
    replay(pubsub);
    initializeTopic();
    assertEquals(subscriptions, topic.listSubscriptions().getValues());
  }

  @Test
  public void testListSubscriptionsWithOptions() {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    final List<SubscriptionId> subscriptions = ImmutableList.of(
        new SubscriptionId("project", "subscription1"),
        new SubscriptionId("project", "subscription2"));
    Page<SubscriptionId> result = new PageImpl<>(null, null, subscriptions);
    expect(pubsub.listSubscriptions(NAME, ListOption.pageSize(42))).andReturn(result);
    replay(pubsub);
    initializeTopic();
    assertEquals(subscriptions, topic.listSubscriptions(ListOption.pageSize(42)).getValues());
  }

  @Test
  public void testListSubscriptionsAsync() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    final List<SubscriptionId> subscriptions = ImmutableList.of(
        new SubscriptionId("project", "subscription1"),
        new SubscriptionId("project", "subscription2"));
    AsyncPage<SubscriptionId> result = new AsyncPageImpl<>(null, null, subscriptions);
    expect(pubsub.listSubscriptionsAsync(NAME))
        .andReturn(ApiFutures.immediateFuture(result));
    replay(pubsub);
    initializeTopic();
    assertEquals(subscriptions, topic.listSubscriptionsAsync().get().getValues());
  }

  @Test
  public void testListSubscriptionsAsyncWithOptions()
      throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    final List<SubscriptionId> subscriptions = ImmutableList.of(
        new SubscriptionId("project", "subscription1"),
        new SubscriptionId("project", "subscription2"));
    AsyncPage<SubscriptionId> result = new AsyncPageImpl<>(null, null, subscriptions);
    expect(pubsub.listSubscriptionsAsync(NAME, ListOption.pageSize(42)))
        .andReturn(ApiFutures.immediateFuture(result));
    replay(pubsub);
    initializeTopic();
    assertEquals(subscriptions,
        topic.listSubscriptionsAsync(ListOption.pageSize(42)).get().getValues());
  }

  @Test
  public void testGetPolicy() {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getTopicPolicy(NAME)).andReturn(POLICY);
    replay(pubsub);
    initializeTopic();
    Policy policy = topic.getPolicy();
    assertEquals(POLICY, policy);
  }

  @Test
  public void testGetPolicyNull() {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getTopicPolicy(NAME)).andReturn(null);
    replay(pubsub);
    initializeTopic();
    assertNull(topic.getPolicy());
  }

  @Test
  public void testGetPolicyAsync() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getTopicPolicyAsync(NAME)).andReturn(ApiFutures.immediateFuture(POLICY));
    replay(pubsub);
    initializeTopic();
    Policy policy = topic.getPolicyAsync().get();
    assertEquals(POLICY, policy);
  }

  @Test
  public void testReplacePolicy() {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.replaceTopicPolicy(NAME, POLICY)).andReturn(POLICY);
    replay(pubsub);
    initializeTopic();
    Policy policy = topic.replacePolicy(POLICY);
    assertEquals(POLICY, policy);
  }

  @Test
  public void testReplacePolicyAsync() throws ExecutionException, InterruptedException {
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.replaceTopicPolicyAsync(NAME, POLICY)).andReturn(ApiFutures.immediateFuture(POLICY));
    replay(pubsub);
    initializeTopic();
    Policy policy = topic.replacePolicyAsync(POLICY).get();
    assertEquals(POLICY, policy);
  }

  @Test
  public void testTestPermissions() {
    List<String> permissions = ImmutableList.of("pubsub.topics.get");
    List<Boolean> permissionsResult = ImmutableList.of(true);
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.testTopicPermissions(NAME, permissions)).andReturn(permissionsResult);
    replay(pubsub);
    initializeTopic();
    assertEquals(permissionsResult, topic.testPermissions(permissions));
  }

  @Test
  public void testTestPermissionsAsync() throws ExecutionException, InterruptedException {
    List<String> permissions = ImmutableList.of("pubsub.topics.get");
    List<Boolean> permissionsResult = ImmutableList.of(true);
    initializeExpectedTopic(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.testTopicPermissionsAsync(NAME, permissions))
        .andReturn(ApiFutures.immediateFuture(permissionsResult));
    replay(pubsub);
    initializeTopic();
    assertEquals(permissionsResult, topic.testPermissionsAsync(permissions).get());
  }

  private void compareTopic(Topic expected, Topic value) {
    assertEquals(expected, value);
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}

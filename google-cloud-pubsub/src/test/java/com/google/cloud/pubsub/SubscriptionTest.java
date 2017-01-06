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

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.pubsub.v1.PushConfig;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Test;

public class SubscriptionTest {

  private static final TopicId TOPIC_ID = TopicId.of("project", "topic");
  private static final String NAME = "subscription";
  private static final String ENDPOINT = "https://example.com/push";
  private static final PushConfig PUSH_CONFIG =
      PushConfig.newBuilder().setPushEndpoint(ENDPOINT).build();
  private static final int ACK_DEADLINE = 42;
  private static final SubscriptionInfo SUBSCRIPTION_INFO =
      SubscriptionInfo.newBuilder(TOPIC_ID, NAME)
          .setPushConfig(PUSH_CONFIG)
          .setAckDeadLineSeconds(ACK_DEADLINE)
          .build();
  private static final Policy POLICY = Policy.newBuilder()
      .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
      .build();

  private final PubSub serviceMockReturnsOptions = createStrictMock(PubSub.class);
  private final PubSubOptions mockOptions = createStrictMock(PubSubOptions.class);
  private PubSub pubsub;
  private Subscription expectedSubscription;
  private Subscription subscription;

  private void initializeExpectedSubscription(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    pubsub = createStrictMock(PubSub.class);
    expectedSubscription = new Subscription(serviceMockReturnsOptions,
        new Subscription.BuilderImpl(SUBSCRIPTION_INFO));
  }

  private void initializeSubscription() {
    subscription = new Subscription(pubsub, new Subscription.BuilderImpl(SUBSCRIPTION_INFO));
  }

  @After
  public void tearDown() throws Exception {
    verify(pubsub, serviceMockReturnsOptions);
  }

  @Test
  public void testBuilder() {
    initializeExpectedSubscription(2);
    replay(pubsub);
    assertEquals(TOPIC_ID, expectedSubscription.getTopic());
    assertEquals(NAME, expectedSubscription.getName());
    assertEquals(PUSH_CONFIG, expectedSubscription.getPushConfig());
    assertEquals(ACK_DEADLINE, expectedSubscription.getAckDeadlineSeconds());
    assertSame(serviceMockReturnsOptions, expectedSubscription.getPubsub());
    Subscription builtSubscription = expectedSubscription.toBuilder()
        .setName("newSubscription")
        .setTopic("newProject", "newTopic")
        .setPushConfig(null)
        .setAckDeadLineSeconds(10)
        .build();
    assertEquals(TopicId.of("newProject", "newTopic"), builtSubscription.getTopic());
    assertEquals("newSubscription", builtSubscription.getName());
    assertEquals(null, builtSubscription.getPushConfig());
    assertEquals(10, builtSubscription.getAckDeadlineSeconds());
  }

  @Test
  public void testBuilderDeprecated() {
    initializeExpectedSubscription(2);
    replay(pubsub);
    assertEquals(TOPIC_ID, expectedSubscription.topic());
    assertEquals(NAME, expectedSubscription.name());
    assertEquals(PUSH_CONFIG, expectedSubscription.pushConfig());
    assertEquals(ACK_DEADLINE, expectedSubscription.ackDeadlineSeconds());
    assertSame(serviceMockReturnsOptions, expectedSubscription.pubSub());
    Subscription builtSubscription = expectedSubscription.toBuilder()
        .name("newSubscription")
        .topic("newProject", "newTopic")
        .pushConfig(null)
        .ackDeadLineSeconds(10)
        .build();
    assertEquals(TopicId.of("newProject", "newTopic"), builtSubscription.topic());
    assertEquals("newSubscription", builtSubscription.name());
    assertEquals(null, builtSubscription.pushConfig());
    assertEquals(10, builtSubscription.ackDeadlineSeconds());
  }

  @Test
  public void testToBuilder() {
    initializeExpectedSubscription(2);
    replay(pubsub);
    compareSubscription(expectedSubscription, expectedSubscription.toBuilder().build());
  }

  @Test
  public void testReload() {
    initializeExpectedSubscription(2);
    SubscriptionInfo updatedInfo = SUBSCRIPTION_INFO.toBuilder().setName("newSubscription").build();
    Subscription expectedSubscription =
        new Subscription(serviceMockReturnsOptions, new SubscriptionInfo.BuilderImpl(updatedInfo));
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getSubscription(NAME)).andReturn(expectedSubscription);
    replay(pubsub);
    initializeSubscription();
    Subscription updatedSubscription = subscription.reload();
    compareSubscription(expectedSubscription, updatedSubscription);
  }

  @Test
  public void testReloadNull() {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getSubscription(NAME)).andReturn(null);
    replay(pubsub);
    initializeSubscription();
    assertNull(subscription.reload());
  }

  @Test
  public void testReloadAsync() throws ExecutionException, InterruptedException {
    initializeExpectedSubscription(2);
    SubscriptionInfo updatedInfo = SUBSCRIPTION_INFO.toBuilder().setName("newSubscription").build();
    Subscription expectedSubscription =
        new Subscription(serviceMockReturnsOptions, new SubscriptionInfo.BuilderImpl(updatedInfo));
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getSubscriptionAsync(NAME))
        .andReturn(Futures.immediateFuture(expectedSubscription));
    replay(pubsub);
    initializeSubscription();
    Subscription updatedSubscription = subscription.reloadAsync().get();
    compareSubscription(expectedSubscription, updatedSubscription);
  }

  @Test
  public void testReloadAsyncNull() throws ExecutionException, InterruptedException {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getSubscriptionAsync(NAME))
        .andReturn(Futures.<Subscription>immediateFuture(null));
    replay(pubsub);
    initializeSubscription();
    assertNull(subscription.reloadAsync().get());
  }

  @Test
  public void testDeleteTrue() {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.deleteSubscription(NAME)).andReturn(true);
    replay(pubsub);
    initializeSubscription();
    assertTrue(subscription.delete());
  }

  @Test
  public void testDeleteFalse() {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.deleteSubscription(NAME)).andReturn(false);
    replay(pubsub);
    initializeSubscription();
    assertFalse(subscription.delete());
  }

  @Test
  public void testDeleteAsyncTrue() throws ExecutionException, InterruptedException {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.deleteSubscriptionAsync(NAME))
        .andReturn(Futures.immediateFuture(true));
    replay(pubsub);
    initializeSubscription();
    assertTrue(subscription.deleteAsync().get());
  }

  @Test
  public void testDeleteAsyncFalse() throws ExecutionException, InterruptedException {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.deleteSubscriptionAsync(NAME))
        .andReturn(Futures.immediateFuture(false));
    replay(pubsub);
    initializeSubscription();
    assertFalse(subscription.deleteAsync().get());
  }

  @Test
  public void testReplacePushConfig() {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    PushConfig pushConfig =
        PushConfig.newBuilder().setPushEndpoint("https://example.com/newPush").build();
    pubsub.replacePushConfig(NAME, pushConfig);
    EasyMock.expectLastCall();
    replay(pubsub);
    initializeSubscription();
    subscription.replacePushConfig(pushConfig);
  }

  @Test
  public void testReplacePushConfig_Null() {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    pubsub.replacePushConfig(NAME, null);
    EasyMock.expectLastCall();
    replay(pubsub);
    initializeSubscription();
    subscription.replacePushConfig(null);
  }

  @Test
  public void testReplacePushConfig_Async() throws ExecutionException, InterruptedException {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    PushConfig pushConfig =
        PushConfig.newBuilder().setPushEndpoint("https://example.com/newPush").build();
    expect(pubsub.replacePushConfigAsync(NAME, pushConfig))
        .andReturn(Futures.<Void>immediateFuture(null));
    EasyMock.expectLastCall();
    replay(pubsub);
    initializeSubscription();
    assertNull(subscription.replacePushConfigAsync(pushConfig).get());
  }

  @Test
  public void testReplacePushConfigAsync_Null() throws ExecutionException, InterruptedException {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.replacePushConfigAsync(NAME, null))
        .andReturn(Futures.<Void>immediateFuture(null));
    replay(pubsub);
    initializeSubscription();
    assertNull(subscription.replacePushConfigAsync(null).get());
  }

  @Test
  public void testGetPolicy() {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getSubscriptionPolicy(NAME)).andReturn(POLICY);
    replay(pubsub);
    initializeSubscription();
    Policy policy = subscription.getPolicy();
    assertEquals(POLICY, policy);
  }

  @Test
  public void testGetPolicyNull() {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getSubscriptionPolicy(NAME)).andReturn(null);
    replay(pubsub);
    initializeSubscription();
    assertNull(subscription.getPolicy());
  }

  @Test
  public void testGetPolicyAsync() throws ExecutionException, InterruptedException {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.getSubscriptionPolicyAsync(NAME)).andReturn(Futures.immediateFuture(POLICY));
    replay(pubsub);
    initializeSubscription();
    Policy policy = subscription.getPolicyAsync().get();
    assertEquals(POLICY, policy);
  }

  @Test
  public void testReplacePolicy() {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.replaceSubscriptionPolicy(NAME, POLICY)).andReturn(POLICY);
    replay(pubsub);
    initializeSubscription();
    Policy policy = subscription.replacePolicy(POLICY);
    assertEquals(POLICY, policy);
  }

  @Test
  public void testReplacePolicyAsync() throws ExecutionException, InterruptedException {
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.replaceSubscriptionPolicyAsync(NAME, POLICY))
        .andReturn(Futures.immediateFuture(POLICY));
    replay(pubsub);
    initializeSubscription();
    Policy policy = subscription.replacePolicyAsync(POLICY).get();
    assertEquals(POLICY, policy);
  }

  @Test
  public void testTestPermissions() {
    List<String> permissions = ImmutableList.of("pubsub.subscriptions.get");
    List<Boolean> permissionsResult = ImmutableList.of(true);
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.testSubscriptionPermissions(NAME, permissions)).andReturn(permissionsResult);
    replay(pubsub);
    initializeSubscription();
    assertEquals(permissionsResult, subscription.testPermissions(permissions));
  }

  @Test
  public void testTestPermissionsAsync() throws ExecutionException, InterruptedException {
    List<String> permissions = ImmutableList.of("pubsub.subscriptions.get");
    List<Boolean> permissionsResult = ImmutableList.of(true);
    initializeExpectedSubscription(1);
    expect(pubsub.getOptions()).andReturn(mockOptions);
    expect(pubsub.testSubscriptionPermissionsAsync(NAME, permissions))
        .andReturn(Futures.immediateFuture(permissionsResult));
    replay(pubsub);
    initializeSubscription();
    assertEquals(permissionsResult, subscription.testPermissionsAsync(permissions).get());
  }

  private void compareSubscription(Subscription expected, Subscription value) {
    assertEquals(expected, value);
    assertEquals(expected.getTopic(), value.getTopic());
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getPushConfig(), value.getPushConfig());
    assertEquals(expected.getAckDeadlineSeconds(), value.getAckDeadlineSeconds());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}

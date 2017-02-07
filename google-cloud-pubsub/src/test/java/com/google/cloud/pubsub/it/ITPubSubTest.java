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

package com.google.cloud.pubsub.it;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.pubsub.BaseSystemTest;
import com.google.cloud.pubsub.PubSub;
import com.google.cloud.pubsub.PubSubOptions;
import com.google.cloud.pubsub.Subscription;
import com.google.cloud.pubsub.SubscriptionInfo;
import com.google.cloud.pubsub.Topic;
import com.google.cloud.pubsub.TopicInfo;
import com.google.common.collect.ImmutableList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class ITPubSubTest extends BaseSystemTest {

  private static final PubSub PUB_SUB = PubSubOptions.getDefaultInstance().getService();
  private static final String NAME_SUFFIX = UUID.randomUUID().toString();

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  @Override
  protected PubSub pubsub() {
    return PUB_SUB;
  }

  @Override
  protected String formatForTest(String resourceName) {
    return resourceName + "-" + NAME_SUFFIX;
  }

  // Policy tests are defined here and not in BaseSystemTest because Pub/Sub emulator does not
  // support IAM yet

  @Test
  public void testTopicPolicy() {
    String topicName = formatForTest("test-topic-policy");
    Topic topic = pubsub().create(TopicInfo.of(topicName));
    Policy policy = pubsub().getTopicPolicy(topicName);
    policy = pubsub().replaceTopicPolicy(topicName, policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build());
    assertTrue(policy.getBindings().containsKey(Role.viewer()));
    assertTrue(policy.getBindings().get(Role.viewer()).contains(Identity.allAuthenticatedUsers()));
    List<Boolean> permissions =
        pubsub().testTopicPermissions(topicName, ImmutableList.of("pubsub.topics.get"));
    assertTrue(permissions.get(0));
    topic.delete();
  }

  @Test
  public void testNonExistingTopicPolicy() {
    String topicName = formatForTest("test-non-existing-topic-policy");
    assertNull(pubsub().getTopicPolicy(topicName));
  }

  @Test
  public void testTopicPolicyAsync() throws ExecutionException, InterruptedException {
    String topicName = formatForTest("test-topic-policy-async");
    Topic topic = pubsub().create(TopicInfo.of(topicName));
    Policy policy = pubsub().getTopicPolicyAsync(topicName).get();
    policy = pubsub().replaceTopicPolicyAsync(topicName, policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build()).get();
    assertTrue(policy.getBindings().containsKey(Role.viewer()));
    assertTrue(policy.getBindings().get(Role.viewer()).contains(Identity.allAuthenticatedUsers()));
    List<Boolean> permissions =
        pubsub().testTopicPermissionsAsync(topicName, ImmutableList.of("pubsub.topics.get")).get();
    assertTrue(permissions.get(0));
    topic.delete();
  }

  @Test
  public void testSubscriptionPolicy() {
    String topicName = formatForTest("test-subscription-policy");
    Topic topic = pubsub().create(TopicInfo.of(topicName));
    String subscriptionName = formatForTest("test-subscription-policy");
    Subscription subscription = pubsub().create(SubscriptionInfo.of(topicName, subscriptionName));
    Policy policy = pubsub().getSubscriptionPolicy(subscriptionName);
    policy = pubsub().replaceSubscriptionPolicy(subscriptionName, policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build());
    assertTrue(policy.getBindings().containsKey(Role.viewer()));
    assertTrue(policy.getBindings().get(Role.viewer()).contains(Identity.allAuthenticatedUsers()));
    List<Boolean> permissions = pubsub().testSubscriptionPermissions(subscriptionName,
        ImmutableList.of("pubsub.subscriptions.get"));
    assertTrue(permissions.get(0));
    topic.delete();
    subscription.delete();
  }

  @Test
  public void testSubscriptionPolicyAsync() throws ExecutionException, InterruptedException {
    String topicName = formatForTest("test-subscription-policy-async");
    Topic topic = pubsub().create(TopicInfo.of(topicName));
    String subscriptionName = formatForTest("test-subscription-policy-async");
    Subscription subscription = pubsub().create(SubscriptionInfo.of(topicName, subscriptionName));
    Policy policy = pubsub().getSubscriptionPolicyAsync(subscriptionName).get();
    policy = pubsub().replaceSubscriptionPolicyAsync(subscriptionName, policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build()).get();
    assertTrue(policy.getBindings().containsKey(Role.viewer()));
    assertTrue(policy.getBindings().get(Role.viewer()).contains(Identity.allAuthenticatedUsers()));
    List<Boolean> permissions = pubsub().testSubscriptionPermissionsAsync(subscriptionName,
        ImmutableList.of("pubsub.subscriptions.get")).get();
    assertTrue(permissions.get(0));
    topic.delete();
    subscription.delete();
  }

  @Test
  public void testNonExistingSubscriptionPolicy() {
    String subscriptionName = formatForTest("test-non-existing-subscription-policy");
    assertNull(pubsub().getSubscriptionPolicy(subscriptionName));
  }
}

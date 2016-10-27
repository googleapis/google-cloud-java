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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Identity;
import com.google.cloud.Page;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.pubsub.PubSub;
import com.google.cloud.pubsub.PubSubOptions;
import com.google.cloud.pubsub.SubscriptionId;
import com.google.cloud.pubsub.SubscriptionInfo;
import com.google.cloud.pubsub.Topic;
import com.google.cloud.pubsub.TopicInfo;
import com.google.common.collect.Iterators;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class ITTopicSnippets {

  private static final String TOPIC = "it-topic-snippets-topic-" + UUID.randomUUID().toString();
  private static final String SUBSCRIPTION =
      "it-topic-snippets-subscription-" + UUID.randomUUID().toString();

  private static PubSub pubsub;
  private static Topic topic;

  @BeforeClass
  public static void beforeClass() {
    pubsub = PubSubOptions.getDefaultInstance().getService();
    topic = pubsub.create(TopicInfo.of(TOPIC));
  }

  @AfterClass
  public static void afterClass() throws Exception {
    if (pubsub != null) {
      topic.delete();
      pubsub.close();
    }
  }

  @Test
  public void testTopic() throws ExecutionException, InterruptedException {
    TopicSnippets topicSnippets = new TopicSnippets(topic);
    Topic updatedTopic = topicSnippets.reload();
    assertEquals(topic, updatedTopic);
    updatedTopic = topicSnippets.reloadAsync();
    assertEquals(topic, updatedTopic);
    assertNotNull(topicSnippets.publishOneMessage());
    assertNotNull(topicSnippets.publishOneMessageAsync());
    assertEquals(2, topicSnippets.publishMessageList().size());
    assertEquals(2, topicSnippets.publishMessageListAsync().size());
    assertEquals(2, topicSnippets.publishMessages().size());
    assertEquals(2, topicSnippets.publishMessagesAsync().size());
  }

  @Test
  public void testTopicSubscriptions() throws ExecutionException, InterruptedException {
    TopicSnippets topicSnippets = new TopicSnippets(topic);
    pubsub.create(SubscriptionInfo.of(TOPIC, SUBSCRIPTION));
    try {
      Page<SubscriptionId> subscriptions = topicSnippets.listSubscriptionsForTopic();
      while (Iterators.size(subscriptions.getValues().iterator()) < 1) {
        subscriptions = topicSnippets.listSubscriptionsForTopic();
      }
      assertEquals(SUBSCRIPTION, subscriptions.getValues().iterator().next().getSubscription());
      subscriptions = topicSnippets.listSubscriptionsForTopicAsync();
      while (Iterators.size(subscriptions.getValues().iterator()) < 1) {
        subscriptions = topicSnippets.listSubscriptionsForTopic();
      }
      assertEquals(SUBSCRIPTION, subscriptions.getValues().iterator().next().getSubscription());
    } finally {
      pubsub.deleteSubscription(SUBSCRIPTION);
    }
  }

  @Test
  public void testPolicy() throws ExecutionException, InterruptedException {
    TopicSnippets topicSnippets = new TopicSnippets(topic);
    Policy policy = topicSnippets.getPolicy();
    assertNotNull(policy);
    assertEquals(policy, topicSnippets.getPolicyAsync());
    policy = topicSnippets.replacePolicy();
    assertTrue(policy.getBindings().get(Role.viewer()).contains(Identity.allAuthenticatedUsers()));
    policy = topic.replacePolicy(policy.toBuilder()
        .removeIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build());
    assertFalse(policy.getBindings().containsKey(Role.viewer()));
    policy = topicSnippets.replacePolicyAsync();
    assertTrue(policy.getBindings().get(Role.viewer()).contains(Identity.allAuthenticatedUsers()));
    assertTrue(topicSnippets.delete());
    assertFalse(topicSnippets.deleteAsync());
  }
}

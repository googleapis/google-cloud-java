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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.pubsub.PubSub;
import com.google.cloud.pubsub.PubSubOptions;
import com.google.cloud.pubsub.Subscription;
import com.google.cloud.pubsub.SubscriptionInfo;
import com.google.cloud.pubsub.Topic;
import com.google.cloud.pubsub.TopicInfo;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSubscriptionSnippets {

  private static final String TOPIC =
      "it-subscription-snippets-topic-" + UUID.randomUUID().toString();
  private static final String SUBSCRIPTION =
      "it-subscription-snippets-subscription-" + UUID.randomUUID().toString();

  private static PubSub pubsub;
  private static Topic topic;
  private static Subscription subscription;

  @BeforeClass
  public static void beforeClass() {
    pubsub = PubSubOptions.getDefaultInstance().getService();
    topic = pubsub.create(TopicInfo.of(TOPIC));
    subscription = pubsub.create(SubscriptionInfo.of(TOPIC, SUBSCRIPTION));
  }

  @AfterClass
  public static void afterClass() throws Exception {
    if (pubsub != null) {
      topic.delete();
      subscription.delete();
      pubsub.close();
    }
  }

  @Test
  public void testPushConfig() throws ExecutionException, InterruptedException {
    SubscriptionSnippets subscriptionSnippets = new SubscriptionSnippets(subscription);
    String endpoint = "https://" + pubsub.getOptions().getProjectId() + ".appspot.com/push";
    subscriptionSnippets.replacePushConfig(endpoint);
    Subscription updatedSubscription = pubsub.getSubscription(SUBSCRIPTION);
    assertEquals(endpoint, updatedSubscription.getPushConfig().getPushEndpoint());
    subscriptionSnippets.replacePushConfigToPull();
    updatedSubscription = pubsub.getSubscription(SUBSCRIPTION);
    assertNull(updatedSubscription.getPushConfig());
    subscriptionSnippets.replacePushConfigAsync(endpoint);
    updatedSubscription = pubsub.getSubscription(SUBSCRIPTION);
    assertEquals(endpoint, updatedSubscription.getPushConfig().getPushEndpoint());
    subscriptionSnippets.replacePushConfigToPullAsync();
    updatedSubscription = pubsub.getSubscription(SUBSCRIPTION);
    assertNull(updatedSubscription.getPushConfig());
  }

  @Test
  public void testPolicy() throws ExecutionException, InterruptedException {
    SubscriptionSnippets subscriptionSnippets = new SubscriptionSnippets(subscription);
    Policy policy = subscriptionSnippets.getPolicy();
    assertNotNull(policy);
    assertEquals(policy, subscriptionSnippets.getPolicyAsync());
    policy = subscriptionSnippets.replacePolicy();
    assertTrue(policy.getBindings().get(Role.viewer()).contains(Identity.allAuthenticatedUsers()));
    policy = subscription.replacePolicy(policy.toBuilder()
        .removeIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build());
    assertFalse(policy.getBindings().containsKey(Role.viewer()));
    policy = subscriptionSnippets.replacePolicyAsync();
    assertTrue(policy.getBindings().get(Role.viewer()).contains(Identity.allAuthenticatedUsers()));
    assertTrue(subscriptionSnippets.delete());
    assertFalse(subscriptionSnippets.deleteAsync());
  }
}

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
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SubscriptionInfoTest {

  private static final TopicId TOPIC = TopicId.of("project", "topic");
  private static final String NAME = "subscription";
  private static final String ENDPOINT = "https://example.com/push";
  private static final PushConfig PUSH_CONFIG = PushConfig.of(ENDPOINT);
  private static final int ACK_DEADLINE = 42;
  private static final SubscriptionInfo SUBSCRIPTION_INFO = SubscriptionInfo.builder(TOPIC, NAME)
      .pushConfig(PUSH_CONFIG)
      .ackDeadLineSeconds(ACK_DEADLINE)
      .build();

  @Test
  public void testToBuilder() {
    compareSubscriptionInfo(SUBSCRIPTION_INFO, SUBSCRIPTION_INFO.toBuilder().build());
    SubscriptionInfo subscriptionInfo = SUBSCRIPTION_INFO.toBuilder()
        .topic("newTopic")
        .name("newSubscription")
        .build();
    assertEquals(TopicId.of("newTopic"), subscriptionInfo.topic());
    assertEquals("newSubscription", subscriptionInfo.name());
    subscriptionInfo = subscriptionInfo.toBuilder().name(NAME).topic(TOPIC).build();
    compareSubscriptionInfo(SUBSCRIPTION_INFO, subscriptionInfo);
  }

  @Test
  public void testBuilder() {
    assertEquals(TOPIC, SUBSCRIPTION_INFO.topic());
    assertEquals(NAME, SUBSCRIPTION_INFO.name());
    assertEquals(PUSH_CONFIG, SUBSCRIPTION_INFO.pushConfig());
    assertEquals(ACK_DEADLINE, SUBSCRIPTION_INFO.ackDeadlineSeconds());
    SubscriptionInfo subscriptionInfo = SubscriptionInfo.builder("topic", "subscription").build();
    assertEquals(TopicId.of("topic"), subscriptionInfo.topic());
    assertEquals(NAME, subscriptionInfo.name());
    assertNull(subscriptionInfo.pushConfig());
    assertEquals(0, subscriptionInfo.ackDeadlineSeconds());
    subscriptionInfo = SubscriptionInfo.builder("topic", "subscription")
        .topic("project", "topic").build();
    assertEquals(TOPIC, subscriptionInfo.topic());
    assertEquals(NAME, subscriptionInfo.name());
    assertNull(subscriptionInfo.pushConfig());
    assertEquals(0, subscriptionInfo.ackDeadlineSeconds());
    subscriptionInfo = SubscriptionInfo.builder("topic", "subscription")
        .topic(TOPIC).build();
    assertEquals(TOPIC, subscriptionInfo.topic());
    assertEquals(NAME, subscriptionInfo.name());
    assertNull(subscriptionInfo.pushConfig());
    assertEquals(0, subscriptionInfo.ackDeadlineSeconds());
  }

  @Test
  public void testOf() {
    SubscriptionInfo subscriptionInfo = SubscriptionInfo.of(TOPIC, NAME);
    assertEquals(TOPIC, subscriptionInfo.topic());
    assertEquals(NAME, subscriptionInfo.name());
    assertNull(subscriptionInfo.pushConfig());
    assertEquals(0, subscriptionInfo.ackDeadlineSeconds());
    subscriptionInfo = SubscriptionInfo.of("topic", NAME);
    assertEquals(TopicId.of("topic"), subscriptionInfo.topic());
    assertEquals(NAME, subscriptionInfo.name());
    assertNull(subscriptionInfo.pushConfig());
    assertEquals(0, subscriptionInfo.ackDeadlineSeconds());
    subscriptionInfo = SubscriptionInfo.of(TOPIC, NAME, ENDPOINT);
    assertEquals(TOPIC, subscriptionInfo.topic());
    assertEquals(NAME, subscriptionInfo.name());
    assertEquals(PushConfig.of(ENDPOINT), subscriptionInfo.pushConfig());
    assertEquals(0, subscriptionInfo.ackDeadlineSeconds());
    subscriptionInfo = SubscriptionInfo.of("topic", NAME, ENDPOINT);
    assertEquals(TopicId.of("topic"), subscriptionInfo.topic());
    assertEquals(NAME, subscriptionInfo.name());
    assertEquals(PushConfig.of(ENDPOINT), subscriptionInfo.pushConfig());
    assertEquals(0, subscriptionInfo.ackDeadlineSeconds());
  }

  @Test
  public void testToAndFromPb() {
    compareSubscriptionInfo(SUBSCRIPTION_INFO,
        SubscriptionInfo.fromPb(SUBSCRIPTION_INFO.toPb("project")));
    SubscriptionInfo subscriptionInfo = SubscriptionInfo.of(TOPIC, NAME);
    compareSubscriptionInfo(subscriptionInfo,
        SubscriptionInfo.fromPb(subscriptionInfo.toPb("project")));
    subscriptionInfo = SubscriptionInfo.of("topic", NAME);
    compareSubscriptionInfo(SubscriptionInfo.of(TOPIC, NAME),
        SubscriptionInfo.fromPb(subscriptionInfo.toPb("project")));
    subscriptionInfo = SubscriptionInfo.of(TOPIC, NAME, ENDPOINT);
    compareSubscriptionInfo(subscriptionInfo,
        SubscriptionInfo.fromPb(subscriptionInfo.toPb("project")));
    subscriptionInfo = SubscriptionInfo.of("topic", NAME, ENDPOINT);
    compareSubscriptionInfo(SubscriptionInfo.of(TOPIC, NAME, ENDPOINT),
        SubscriptionInfo.fromPb(subscriptionInfo.toPb("project")));
  }

  private void compareSubscriptionInfo(SubscriptionInfo expected, SubscriptionInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.topic(), value.topic());
    assertEquals(expected.name(), value.name());
    assertEquals(expected.pushConfig(), value.pushConfig());
    assertEquals(expected.ackDeadlineSeconds(), value.ackDeadlineSeconds());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}

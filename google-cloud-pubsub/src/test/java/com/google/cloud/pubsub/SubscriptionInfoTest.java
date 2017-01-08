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

import com.google.pubsub.v1.PushConfig;
import org.junit.Test;

public class SubscriptionInfoTest {

  private static final TopicId TOPIC = TopicId.of("project", "topic");
  private static final String NAME = "subscription";
  private static final String ENDPOINT = "https://example.com/push";
  private static final PushConfig PUSH_CONFIG =
      PushConfig.newBuilder().setPushEndpoint(ENDPOINT).build();
  private static final int ACK_DEADLINE = 42;
  private static final SubscriptionInfo SUBSCRIPTION_INFO = SubscriptionInfo.newBuilder(TOPIC, NAME)
      .setPushConfig(PUSH_CONFIG)
      .setAckDeadLineSeconds(ACK_DEADLINE)
      .build();
  private static final SubscriptionInfo DEPRECATED_SUBSCRIPTION_INFO =
      SubscriptionInfo.builder(TOPIC, NAME)
          .pushConfig(PUSH_CONFIG)
          .ackDeadLineSeconds(ACK_DEADLINE)
          .build();

  @Test
  public void testToBuilder() {
    compareSubscriptionInfo(SUBSCRIPTION_INFO, SUBSCRIPTION_INFO.toBuilder().build());
    SubscriptionInfo subscriptionInfo = SUBSCRIPTION_INFO.toBuilder()
        .setTopic("newTopic")
        .setName("newSubscription")
        .build();
    assertEquals(TopicId.of("newTopic"), subscriptionInfo.getTopic());
    assertEquals("newSubscription", subscriptionInfo.getName());
    subscriptionInfo = subscriptionInfo.toBuilder().setName(NAME).setTopic(TOPIC).build();
    compareSubscriptionInfo(SUBSCRIPTION_INFO, subscriptionInfo);
  }

  @Test
  public void testBuilder() {
    assertEquals(TOPIC, SUBSCRIPTION_INFO.getTopic());
    assertEquals(NAME, SUBSCRIPTION_INFO.getName());
    assertEquals(PUSH_CONFIG, SUBSCRIPTION_INFO.getPushConfig());
    assertEquals(ACK_DEADLINE, SUBSCRIPTION_INFO.getAckDeadlineSeconds());
    SubscriptionInfo subscriptionInfo =
        SubscriptionInfo.newBuilder("topic", "subscription").build();
    assertEquals(TopicId.of("topic"), subscriptionInfo.getTopic());
    assertEquals(NAME, subscriptionInfo.getName());
    assertNull(subscriptionInfo.getPushConfig());
    assertEquals(0, subscriptionInfo.getAckDeadlineSeconds());
    subscriptionInfo = SubscriptionInfo.newBuilder("topic", "subscription")
        .setTopic("project", "topic").build();
    assertEquals(TOPIC, subscriptionInfo.getTopic());
    assertEquals(NAME, subscriptionInfo.getName());
    assertNull(subscriptionInfo.getPushConfig());
    assertEquals(0, subscriptionInfo.getAckDeadlineSeconds());
    subscriptionInfo = SubscriptionInfo.newBuilder("topic", "subscription")
        .setTopic(TOPIC).build();
    assertEquals(TOPIC, subscriptionInfo.getTopic());
    assertEquals(NAME, subscriptionInfo.getName());
    assertNull(subscriptionInfo.getPushConfig());
    assertEquals(0, subscriptionInfo.getAckDeadlineSeconds());
  }

  @Test
  public void testBuilderDeprecated() {
    assertEquals(TOPIC, DEPRECATED_SUBSCRIPTION_INFO.topic());
    assertEquals(NAME, DEPRECATED_SUBSCRIPTION_INFO.name());
    assertEquals(PUSH_CONFIG, DEPRECATED_SUBSCRIPTION_INFO.pushConfig());
    assertEquals(ACK_DEADLINE, DEPRECATED_SUBSCRIPTION_INFO.ackDeadlineSeconds());
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
    assertEquals(TOPIC, subscriptionInfo.getTopic());
    assertEquals(NAME, subscriptionInfo.getName());
    assertNull(subscriptionInfo.getPushConfig());
    assertEquals(0, subscriptionInfo.getAckDeadlineSeconds());
    subscriptionInfo = SubscriptionInfo.of("topic", NAME);
    assertEquals(TopicId.of("topic"), subscriptionInfo.getTopic());
    assertEquals(NAME, subscriptionInfo.getName());
    assertNull(subscriptionInfo.getPushConfig());
    assertEquals(0, subscriptionInfo.getAckDeadlineSeconds());
    subscriptionInfo = SubscriptionInfo.of(TOPIC, NAME, ENDPOINT);
    assertEquals(TOPIC, subscriptionInfo.getTopic());
    assertEquals(NAME, subscriptionInfo.getName());
    assertEquals(
        PushConfig.newBuilder().setPushEndpoint(ENDPOINT).build(),
        subscriptionInfo.getPushConfig());
    assertEquals(0, subscriptionInfo.getAckDeadlineSeconds());
    subscriptionInfo = SubscriptionInfo.of("topic", NAME, ENDPOINT);
    assertEquals(TopicId.of("topic"), subscriptionInfo.getTopic());
    assertEquals(NAME, subscriptionInfo.getName());
    assertEquals(
        PushConfig.newBuilder().setPushEndpoint(ENDPOINT).build(),
        subscriptionInfo.getPushConfig());
    assertEquals(0, subscriptionInfo.getAckDeadlineSeconds());
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
    com.google.pubsub.v1.Subscription subscription = SUBSCRIPTION_INFO.toPb("project");
    subscriptionInfo =
        SubscriptionInfo.fromPb(subscription.toBuilder().setTopic("_deleted-topic_").build());
    assertEquals(TopicId.deletedTopic(), subscriptionInfo.getTopic());
    assertEquals(NAME, subscriptionInfo.getName());
    assertEquals(PUSH_CONFIG, subscriptionInfo.getPushConfig());
    assertEquals(ACK_DEADLINE, subscriptionInfo.getAckDeadlineSeconds());
  }

  private void compareSubscriptionInfo(SubscriptionInfo expected, SubscriptionInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getTopic(), value.getTopic());
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getPushConfig(), value.getPushConfig());
    assertEquals(expected.getAckDeadlineSeconds(), value.getAckDeadlineSeconds());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}

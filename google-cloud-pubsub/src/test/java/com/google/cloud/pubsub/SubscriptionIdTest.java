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

import org.junit.Test;

public class SubscriptionIdTest {

  private static final String PROJECT = "project";
  private static final String NAME = "subscription";
  private static final String TOPIC_PB = "projects/project/subscriptions/subscription";
  private static final SubscriptionId SUBSCRIPTION_ID = new SubscriptionId(PROJECT, NAME);

  @Test
  public void testConstructor() {
    assertEquals(PROJECT, SUBSCRIPTION_ID.project());
    assertEquals(NAME, SUBSCRIPTION_ID.subscription());
  }

  @Test
  public void testToAndFromPb() {
    SubscriptionId subscriptionId = SubscriptionId.fromPb(TOPIC_PB);
    compareSubscriptionId(SUBSCRIPTION_ID, subscriptionId);
    assertEquals(PROJECT, subscriptionId.project());
    assertEquals(NAME, subscriptionId.subscription());
  }

  private void compareSubscriptionId(SubscriptionId expected, SubscriptionId value) {
    assertEquals(expected, value);
    assertEquals(expected.project(), value.project());
    assertEquals(expected.subscription(), value.subscription());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}

/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.pubsub.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HedgeTokenBucketTest {

  @Test
  public void testInitialState() {
    HedgeTokenBucket bucket = new HedgeTokenBucket(10, 0.5f);
    assertEquals(10.0f, bucket.getTokens(), 0.0001f);
  }

  @Test
  public void testAcquire() {
    HedgeTokenBucket bucket = new HedgeTokenBucket(10, 0.5f);
    assertTrue(bucket.tryAcquire());
    assertEquals(9.0f, bucket.getTokens(), 0.0001f);
  }

  @Test
  public void testAcquireUntilEmpty() {
    HedgeTokenBucket bucket = new HedgeTokenBucket(2, 0.5f);
    assertTrue(bucket.tryAcquire());
    assertTrue(bucket.tryAcquire());
    assertFalse(bucket.tryAcquire());
    assertEquals(0.0f, bucket.getTokens(), 0.0001f);
  }

  @Test
  public void testRefill() {
    HedgeTokenBucket bucket = new HedgeTokenBucket(2, 0.5f);
    assertTrue(bucket.tryAcquire()); // 1.0 left
    assertTrue(bucket.tryAcquire()); // 0.0 left

    bucket.refill(); // 0.5 tokens
    assertFalse(bucket.tryAcquire()); // needs 1.0

    bucket.refill(); // 1.0 tokens
    assertTrue(bucket.tryAcquire()); // succeeds, 0.0 left
  }

  @Test
  public void testRefillCap() {
    HedgeTokenBucket bucket = new HedgeTokenBucket(2, 0.5f);
    bucket.refill(); // already at max (2)
    assertEquals(2.0f, bucket.getTokens(), 0.0001f);
  }
}

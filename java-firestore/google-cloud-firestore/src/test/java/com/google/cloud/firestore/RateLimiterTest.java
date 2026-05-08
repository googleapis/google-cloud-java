/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.firestore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RateLimiterTest {
  private RateLimiter limiter;

  @Before
  public void before() {
    limiter =
        new RateLimiter(
            /* initialCapacity= */ 500,
            /* multiplier= */ 1.5,
            /* multiplierMillis= */ 5 * 60 * 1000,
            /* maximumCapacity= */ 1000000,
            /* startTime= */ new Date(0).getTime());
  }

  @Test
  public void processRequestsFromCapacity() {
    assertTrue(limiter.tryMakeRequest(250, new Date(0).getTime()));
    assertTrue(limiter.tryMakeRequest(250, new Date(0).getTime()));

    // Once tokens have been used, further requests should fail.
    assertFalse(limiter.tryMakeRequest(1, new Date(0).getTime()));

    // Tokens will only refill up to max capacity.
    assertFalse(limiter.tryMakeRequest(501, new Date(1 * 1000).getTime()));
    assertTrue(limiter.tryMakeRequest(500, new Date(1 * 1000).getTime()));

    // Tokens will refill incrementally based on number of ms elapsed.
    assertFalse(limiter.tryMakeRequest(250, new Date(1 * 1000 + 499).getTime()));
    assertTrue(limiter.tryMakeRequest(249, new Date(1 * 1000 + 500).getTime()));

    // Scales with multiplier.
    assertFalse(limiter.tryMakeRequest(751, new Date((5 * 60 - 1) * 1000).getTime()));
    assertFalse(limiter.tryMakeRequest(751, new Date(5 * 60 * 1000).getTime()));
    assertTrue(limiter.tryMakeRequest(750, new Date(5 * 60 * 1000).getTime()));

    // Tokens will never exceed capacity.
    assertFalse(limiter.tryMakeRequest(751, new Date((5 * 60 + 3) * 1000).getTime()));

    // Rejects requests made before lastRefillTime.
    try {
      limiter.tryMakeRequest(751, new Date((5 * 60 + 2) * 1000).getTime());
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Request time should not be before the last token refill time", e.getMessage());
    }
  }

  @Test
  public void calculatesMsForNextRequest() {
    // Should return 0 if there are enough tokens for the request to be made.
    long timestamp = new Date(0).getTime();
    assertEquals(0, limiter.getNextRequestDelayMs(500, timestamp));

    // Should factor in remaining tokens when calculating the time.
    assertTrue(limiter.tryMakeRequest(250, timestamp));
    assertEquals(500, limiter.getNextRequestDelayMs(500, timestamp));

    // Once tokens have been used, should calculate time before next request.
    timestamp = new Date(1 * 1000).getTime();
    assertTrue(limiter.tryMakeRequest(500, timestamp));
    assertEquals(200, limiter.getNextRequestDelayMs(100, timestamp));
    assertEquals(500, limiter.getNextRequestDelayMs(250, timestamp));
    assertEquals(1000, limiter.getNextRequestDelayMs(500, timestamp));
    assertEquals(-1, limiter.getNextRequestDelayMs(501, timestamp));

    // Scales with multiplier.
    timestamp = new Date(5 * 60 * 1000).getTime();
    assertTrue(limiter.tryMakeRequest(750, timestamp));
    assertEquals(334, limiter.getNextRequestDelayMs(250, timestamp));
    assertEquals(667, limiter.getNextRequestDelayMs(500, timestamp));
    assertEquals(1000, limiter.getNextRequestDelayMs(750, timestamp));
    assertEquals(-1, limiter.getNextRequestDelayMs(751, timestamp));
  }

  @Test
  public void calculatesMaxOperations() {
    assertEquals(500, limiter.calculateCapacity(new Date(0).getTime()));
    assertEquals(750, limiter.calculateCapacity(new Date(5 * 60 * 1000).getTime()));
    assertEquals(1125, limiter.calculateCapacity(new Date(10 * 60 * 1000).getTime()));
    assertEquals(1687, limiter.calculateCapacity(new Date(15 * 60 * 1000).getTime()));
    assertEquals(738945, limiter.calculateCapacity(new Date(90 * 60 * 1000).getTime()));

    // Check that maximum rate limit is enforced.
    assertEquals(1000000, limiter.calculateCapacity(new Date(1000 * 60 * 1000).getTime()));
  }
}

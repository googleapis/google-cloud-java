/*
 * Copyright 2025 Google LLC
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.pubsub.v1.SubscriberShutdownSettings.ShutdownMode;
import java.time.Duration;
import org.junit.Test;

public class SubscriberShutdownSettingsTest {

  @Test
  public void testDefaultSettings() {
    SubscriberShutdownSettings settings = SubscriberShutdownSettings.newBuilder().build();

    assertNotNull(settings);
    assertEquals(ShutdownMode.WAIT_FOR_PROCESSING, settings.getMode());
    assertTrue(settings.getTimeout().isNegative()); // Indefinite timeout
  }

  @Test
  public void testWaitForProcessingWithCustomTimeout() {
    Duration customTimeout = Duration.ofSeconds(30);
    SubscriberShutdownSettings settings =
        SubscriberShutdownSettings.newBuilder()
            .setMode(ShutdownMode.WAIT_FOR_PROCESSING)
            .setTimeout(customTimeout)
            .build();

    assertNotNull(settings);
    assertEquals(ShutdownMode.WAIT_FOR_PROCESSING, settings.getMode());
    assertEquals(customTimeout, settings.getTimeout());
  }

  @Test
  public void testNackImmediatelyWithDefaultTimeout() {
    SubscriberShutdownSettings settings =
        SubscriberShutdownSettings.newBuilder().setMode(ShutdownMode.NACK_IMMEDIATELY).build();

    assertNotNull(settings);
    assertEquals(ShutdownMode.NACK_IMMEDIATELY, settings.getMode());
    assertTrue(settings.getTimeout().isNegative()); // Indefinite timeout
  }

  @Test
  public void testNackImmediatelyWithCustomTimeout() {
    Duration customTimeout = Duration.ofSeconds(10);
    SubscriberShutdownSettings settings =
        SubscriberShutdownSettings.newBuilder()
            .setMode(ShutdownMode.NACK_IMMEDIATELY)
            .setTimeout(customTimeout)
            .build();

    assertNotNull(settings);
    assertEquals(ShutdownMode.NACK_IMMEDIATELY, settings.getMode());
    assertEquals(customTimeout, settings.getTimeout());
  }

  @Test
  public void testZeroTimeout() {
    Duration zeroTimeout = Duration.ZERO;
    SubscriberShutdownSettings settings =
        SubscriberShutdownSettings.newBuilder()
            .setMode(ShutdownMode.WAIT_FOR_PROCESSING)
            .setTimeout(zeroTimeout)
            .build();

    assertNotNull(settings);
    assertEquals(ShutdownMode.WAIT_FOR_PROCESSING, settings.getMode());
    assertEquals(zeroTimeout, settings.getTimeout());
    assertTrue(settings.getTimeout().isZero());
  }

  @Test(expected = NullPointerException.class)
  public void testNullModeThrowsException() {
    SubscriberShutdownSettings.newBuilder().setMode(null).build();
  }

  @Test(expected = NullPointerException.class)
  public void testNullTimeoutThrowsException() {
    SubscriberShutdownSettings.newBuilder().setTimeout(null).build();
  }
}

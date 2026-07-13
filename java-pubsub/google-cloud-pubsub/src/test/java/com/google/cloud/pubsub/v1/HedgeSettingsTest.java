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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.time.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HedgeSettingsTest {

  @Test
  public void testDefaultSettings() {
    HedgeSettings settings = HedgeSettings.newBuilder().build();
    assertNotNull(settings);
    assertEquals(Duration.ofMillis(100), settings.getHedgeDelay());
    assertEquals(100, settings.getMaxTokens());
    assertEquals(0.1f, settings.getRefill(), 0.0001f);
  }

  @Test
  public void testCustomDelay() {
    Duration customDelay = Duration.ofMillis(50);
    HedgeSettings settings = HedgeSettings.newBuilder().setHedgeDelay(customDelay).build();
    assertNotNull(settings);
    assertEquals(customDelay, settings.getHedgeDelay());
  }

  @Test
  public void testNegativeDelayThrows() {
    assertThrows(
        IllegalArgumentException.class,
        () -> HedgeSettings.newBuilder().setHedgeDelay(Duration.ofMillis(-10)));
  }

  @Test
  public void testZeroDelayThrows() {
    assertThrows(
        IllegalArgumentException.class,
        () -> HedgeSettings.newBuilder().setHedgeDelay(Duration.ZERO));
  }

  @Test
  public void testNullDelayThrows() {
    assertThrows(
        NullPointerException.class,
        () -> HedgeSettings.newBuilder().setHedgeDelay(null));
  }
}

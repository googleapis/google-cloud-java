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
public class HedgingSettingsTest {

  @Test
  public void testDefaultSettings() {
    HedgingSettings settings = HedgingSettings.newBuilder().build();
    assertNotNull(settings);
    assertEquals(Duration.ofMillis(1000), settings.getHedgeDelay());
    assertEquals(50, settings.getMaxTokens());
    assertEquals(0.1f, settings.getRefillRatio(), 0.0001f);
  }

  @Test
  public void testCustomDelay() {
    Duration customDelay = Duration.ofMillis(200);
    HedgingSettings settings = HedgingSettings.newBuilder().setHedgeDelay(customDelay).build();
    assertNotNull(settings);
    assertEquals(customDelay, settings.getHedgeDelay());
  }

  @Test
  public void testDelayTooSmallThrows() {
    assertThrows(
        IllegalArgumentException.class,
        () -> HedgingSettings.newBuilder().setHedgeDelay(Duration.ofMillis(99)));
  }

  @Test
  public void testDelayTooLargeThrows() {
    assertThrows(
        IllegalArgumentException.class,
        () -> HedgingSettings.newBuilder().setHedgeDelay(Duration.ofMillis(10001)));
  }

  @Test
  public void testNullDelayThrows() {
    assertThrows(
        NullPointerException.class, () -> HedgingSettings.newBuilder().setHedgeDelay(null));
  }

  @Test
  public void testCustomMaxTokens() {
    HedgingSettings settings = HedgingSettings.newBuilder().setMaxTokens(10).build();
    assertEquals(10, settings.getMaxTokens());
  }

  @Test
  public void testNegativeMaxTokensThrows() {
    assertThrows(
        IllegalArgumentException.class, () -> HedgingSettings.newBuilder().setMaxTokens(-5));
  }

  @Test
  public void testZeroMaxTokensThrows() {
    assertThrows(
        IllegalArgumentException.class, () -> HedgingSettings.newBuilder().setMaxTokens(0));
  }

  @Test
  public void testMaxTokensTooLargeThrows() {
    assertThrows(
        IllegalArgumentException.class, () -> HedgingSettings.newBuilder().setMaxTokens(251));
  }

  @Test
  public void testCustomRefill() {
    HedgingSettings settings = HedgingSettings.newBuilder().setRefillRatio(0.15f).build();
    assertEquals(0.15f, settings.getRefillRatio(), 0.0001f);
  }

  @Test
  public void testNegativeRefillThrows() {
    assertThrows(
        IllegalArgumentException.class, () -> HedgingSettings.newBuilder().setRefillRatio(-0.1f));
  }

  @Test
  public void testZeroRefillThrows() {
    assertThrows(
        IllegalArgumentException.class, () -> HedgingSettings.newBuilder().setRefillRatio(0.0f));
  }

  @Test
  public void testRefillTooLargeThrows() {
    assertThrows(
        IllegalArgumentException.class, () -> HedgingSettings.newBuilder().setRefillRatio(0.21f));
  }

  @Test
  public void testRefillTooSmallThrows() {
    assertThrows(
        IllegalArgumentException.class, () -> HedgingSettings.newBuilder().setRefillRatio(0.0009f));
  }

  @Test
  public void testMinimumRefillValid() {
    HedgingSettings settings = HedgingSettings.newBuilder().setRefillRatio(0.001f).build();
    assertEquals(0.001f, settings.getRefillRatio(), 0.0001f);
  }
}

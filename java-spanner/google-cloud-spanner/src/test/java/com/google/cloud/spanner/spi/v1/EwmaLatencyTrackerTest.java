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

package com.google.cloud.spanner.spi.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.time.Duration;
import java.util.function.LongSupplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EwmaLatencyTrackerTest {

  @Test
  public void testInitialization() {
    EwmaLatencyTracker tracker = new EwmaLatencyTracker(Duration.ofSeconds(10), new FakeClock());
    tracker.update(Duration.ofNanos(100 * 1000));
    assertEquals(100.0, tracker.getScore(), 0.001);
  }

  @Test
  public void testUninitializedScore() {
    EwmaLatencyTracker tracker = new EwmaLatencyTracker();
    assertEquals(Double.MAX_VALUE, tracker.getScore(), 0.001);
  }

  @Test
  public void testOverflowScore() {
    EwmaLatencyTracker tracker = new EwmaLatencyTracker(Duration.ofSeconds(10), new FakeClock());
    tracker.update(Duration.ofSeconds(Long.MAX_VALUE));
    assertEquals((double) Long.MAX_VALUE, tracker.getScore(), 0.001);
  }

  @Test
  public void testEwmaCalculation() {
    double alpha = 0.5;
    EwmaLatencyTracker tracker = new EwmaLatencyTracker(alpha, new FakeClock());

    tracker.update(Duration.ofNanos(100 * 1000)); // Initial score = 100
    assertEquals(100.0, tracker.getScore(), 0.001);

    tracker.update(Duration.ofNanos(200 * 1000)); // Score = 0.5 * 200 + 0.5 * 100 = 150
    assertEquals(150.0, tracker.getScore(), 0.001);

    tracker.update(Duration.ofNanos(300 * 1000)); // Score = 0.5 * 300 + 0.5 * 150 = 225
    assertEquals(225.0, tracker.getScore(), 0.001);
  }

  @Test
  public void testDefaultDecayUsesTimeBasedAlpha() {
    FakeClock clock = new FakeClock();
    EwmaLatencyTracker tracker = new EwmaLatencyTracker(Duration.ofSeconds(10), clock);
    tracker.update(Duration.ofNanos(100 * 1000));
    clock.advance(Duration.ofSeconds(10));
    tracker.update(Duration.ofNanos(200 * 1000));

    double alpha = 1.0 - Math.exp(-1.0);
    double expected = alpha * 200 + (1.0 - alpha) * 100;
    assertEquals(expected, tracker.getScore(), 0.001);
  }

  @Test
  public void testRecordError() {
    EwmaLatencyTracker tracker = new EwmaLatencyTracker(0.5, new FakeClock());
    tracker.update(Duration.ofNanos(100 * 1000));

    tracker.recordError(Duration.ofNanos(10000 * 1000)); // Score = 0.5 * 10000 + 0.5 * 100 = 5050
    assertEquals(5050.0, tracker.getScore(), 0.001);
  }

  @Test
  public void testInvalidAlpha() {
    assertThrows(IllegalArgumentException.class, () -> new EwmaLatencyTracker(0.0));
    assertThrows(IllegalArgumentException.class, () -> new EwmaLatencyTracker(1.1));
    assertThrows(IllegalArgumentException.class, () -> new EwmaLatencyTracker(-0.1));
  }

  @Test
  public void testAlphaOne() {
    EwmaLatencyTracker tracker = new EwmaLatencyTracker(1.0, new FakeClock());
    tracker.update(Duration.ofNanos(100 * 1000));
    assertEquals(100.0, tracker.getScore(), 0.001);

    tracker.update(Duration.ofNanos(200 * 1000));
    assertEquals(200.0, tracker.getScore(), 0.001);
  }

  private static final class FakeClock implements LongSupplier {
    private long currentNanos;

    @Override
    public long getAsLong() {
      return currentNanos;
    }

    void advance(Duration duration) {
      currentNanos += duration.toNanos();
    }
  }
}

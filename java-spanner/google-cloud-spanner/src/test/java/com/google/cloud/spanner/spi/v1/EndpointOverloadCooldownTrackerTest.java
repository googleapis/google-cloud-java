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

import static com.google.common.truth.Truth.assertThat;

import io.grpc.Status;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EndpointOverloadCooldownTrackerTest {

  private static final String ADDRESS = "server:1234";

  private final MutableClock clock = new MutableClock();
  private final EndpointOverloadCooldownTracker tracker =
      new EndpointOverloadCooldownTracker(
          Duration.ofSeconds(10),
          Duration.ofMinutes(1),
          Duration.ofMinutes(10),
          clock,
          ignored -> 0L);

  @Test
  public void hintedResourceExhaustedHonorsServerDelay() {
    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));

    assertThat(tracker.isCoolingDown(ADDRESS)).isTrue();
    clock.advance(Duration.ofMillis(99));
    assertThat(tracker.isCoolingDown(ADDRESS)).isTrue();
    clock.advance(Duration.ofMillis(1));
    assertThat(tracker.isCoolingDown(ADDRESS)).isFalse();
  }

  @Test
  public void zeroRetryDelayUsesMinimumHintedCooldown() {
    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ZERO);

    clock.advance(Duration.ofMillis(99));
    assertThat(tracker.isCoolingDown(ADDRESS)).isTrue();
    clock.advance(Duration.ofMillis(1));
    assertThat(tracker.isCoolingDown(ADDRESS)).isFalse();
  }

  @Test
  public void hintedResourceExhaustedAddsBoundedPositiveJitter() {
    EndpointOverloadCooldownTracker jitteredTracker =
        new EndpointOverloadCooldownTracker(
            Duration.ofSeconds(10),
            Duration.ofMinutes(1),
            Duration.ofMinutes(10),
            clock,
            bound -> bound - 1L);

    jitteredTracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));

    clock.advance(Duration.ofMillis(124));
    assertThat(jitteredTracker.isCoolingDown(ADDRESS)).isTrue();
    clock.advance(Duration.ofMillis(1));
    assertThat(jitteredTracker.isCoolingDown(ADDRESS)).isFalse();
  }

  @Test
  public void hintedResourceExhaustedEscalatesOnlyToShortClientCap() {
    for (int i = 0; i < 20; i++) {
      tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    }

    assertThat(tracker.getState(ADDRESS).overloadFailures)
        .isEqualTo(EndpointOverloadCooldownTracker.DEFAULT_MAX_TIER);
    clock.advance(Duration.ofMillis(1999));
    assertThat(tracker.isCoolingDown(ADDRESS)).isTrue();
    clock.advance(Duration.ofMillis(1));
    assertThat(tracker.isCoolingDown(ADDRESS)).isFalse();
  }

  @Test
  public void unhintedResourceExhaustedKeepsLongBackoff() {
    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, null);
    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, null);

    clock.advance(Duration.ofMillis(9999));
    assertThat(tracker.isCoolingDown(ADDRESS)).isTrue();
    clock.advance(Duration.ofMillis(1));
    assertThat(tracker.isCoolingDown(ADDRESS)).isFalse();
  }

  @Test
  public void threeSuccessesRepairEachLaneWithoutShorteningActiveDeadline() {
    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    tracker.recordFailure(ADDRESS, Status.Code.UNAVAILABLE, null);
    Instant overloadUntil = tracker.getState(ADDRESS).overloadUntil;
    Instant unavailableUntil = tracker.getState(ADDRESS).unavailableUntil;

    tracker.recordSuccess(ADDRESS);
    tracker.recordSuccess(ADDRESS);
    tracker.recordSuccess(ADDRESS);

    EndpointOverloadCooldownTracker.CooldownState repaired = tracker.getState(ADDRESS);
    assertThat(repaired.overloadFailures).isEqualTo(1);
    assertThat(repaired.unavailableFailures).isEqualTo(0);
    assertThat(repaired.overloadUntil).isEqualTo(overloadUntil);
    assertThat(repaired.unavailableUntil).isEqualTo(unavailableUntil);
  }

  @Test
  public void trackedFailureResetsSuccessRepairProgress() {
    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    tracker.recordSuccess(ADDRESS);
    tracker.recordSuccess(ADDRESS);

    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));

    assertThat(tracker.getState(ADDRESS).successesTowardRepair).isEqualTo(0);
  }

  @Test
  public void unavailableAndResourceExhaustedUseIndependentLanes() {
    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    tracker.recordFailure(ADDRESS, Status.Code.UNAVAILABLE, null);

    EndpointOverloadCooldownTracker.CooldownState state = tracker.getState(ADDRESS);
    assertThat(state.overloadFailures).isEqualTo(1);
    assertThat(state.unavailableFailures).isEqualTo(1);
    clock.advance(Duration.ofMillis(100));
    assertThat(tracker.isCoolingDown(ADDRESS)).isTrue();
    clock.advance(Duration.ofMillis(4900));
    assertThat(tracker.isCoolingDown(ADDRESS)).isFalse();
  }

  @Test
  public void unavailableIgnoresShortCooldownHints() {
    tracker.recordFailure(ADDRESS, Status.Code.UNAVAILABLE, Duration.ofHours(1));

    clock.advance(Duration.ofMillis(4999));
    assertThat(tracker.isCoolingDown(ADDRESS)).isTrue();
    clock.advance(Duration.ofMillis(1));
    assertThat(tracker.isCoolingDown(ADDRESS)).isFalse();
  }

  @Test
  public void idleStateResetsAfterTenMinutes() {
    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));

    clock.advance(Duration.ofMinutes(10));
    assertThat(tracker.isCoolingDown(ADDRESS)).isFalse();
    assertThat(tracker.getState(ADDRESS)).isNull();

    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    assertThat(tracker.getState(ADDRESS).overloadFailures).isEqualTo(1);
  }

  @Test
  public void failureAfterIdleWindowResetsBothLanesWithoutPriorLookup() {
    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    tracker.recordFailure(ADDRESS, Status.Code.UNAVAILABLE, null);
    tracker.recordFailure(ADDRESS, Status.Code.UNAVAILABLE, null);
    clock.advance(Duration.ofMinutes(10));

    tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));

    assertThat(tracker.getState(ADDRESS).overloadFailures).isEqualTo(1);
    assertThat(tracker.getState(ADDRESS).unavailableFailures).isEqualTo(0);
  }

  @Test
  public void hintedOverloadProbeWaitsForServerDelayAndReservesAddress() {
    for (int i = 0; i < EndpointOverloadCooldownTracker.DEFAULT_MAX_TIER; i++) {
      tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    }

    clock.advance(Duration.ofMillis(99));
    assertThat(tracker.tryReserveProbe(ADDRESS)).isFalse();
    clock.advance(Duration.ofMillis(1));
    assertThat(tracker.tryReserveProbe(ADDRESS)).isTrue();
    assertThat(tracker.tryReserveProbe(ADDRESS)).isFalse();
    clock.advance(Duration.ofMillis(249));
    assertThat(tracker.tryReserveProbe(ADDRESS)).isFalse();
    clock.advance(Duration.ofMillis(1));
    assertThat(tracker.tryReserveProbe(ADDRESS)).isTrue();
  }

  @Test
  public void unavailableLanePreventsEarlyOverloadProbe() {
    for (int i = 0; i < EndpointOverloadCooldownTracker.DEFAULT_MAX_TIER; i++) {
      tracker.recordFailure(ADDRESS, Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    }
    tracker.recordFailure(ADDRESS, Status.Code.UNAVAILABLE, null);

    clock.advance(Duration.ofMillis(100));
    assertThat(tracker.tryReserveProbe(ADDRESS)).isFalse();
  }

  @Test
  public void untrackedStatusAndEmptyAddressDoNothing() {
    tracker.recordFailure(ADDRESS, Status.Code.ABORTED, Duration.ofMillis(100));
    tracker.recordFailure("", Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    tracker.recordSuccess("");

    assertThat(tracker.isCoolingDown(ADDRESS)).isFalse();
    assertThat(tracker.getState(ADDRESS)).isNull();
  }

  private static final class MutableClock extends Clock {
    private Instant now = Instant.ofEpochSecond(100);

    @Override
    public ZoneId getZone() {
      return ZoneOffset.UTC;
    }

    @Override
    public Clock withZone(ZoneId zone) {
      return this;
    }

    @Override
    public Instant instant() {
      return now;
    }

    private void advance(Duration duration) {
      now = now.plus(duration);
    }
  }
}

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

import com.google.common.annotations.VisibleForTesting;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.LongUnaryOperator;

/**
 * Tracks short-lived endpoint cooldowns after routed {@code RESOURCE_EXHAUSTED} failures.
 *
 * <p>This allows later requests to try a different replica instead of immediately routing back to
 * the same overloaded endpoint.
 */
final class EndpointOverloadCooldownTracker {

  @VisibleForTesting static final Duration DEFAULT_INITIAL_COOLDOWN = Duration.ofSeconds(10);
  @VisibleForTesting static final Duration DEFAULT_MAX_COOLDOWN = Duration.ofMinutes(1);
  @VisibleForTesting static final Duration DEFAULT_RESET_AFTER = Duration.ofMinutes(10);

  @VisibleForTesting
  static final class CooldownState {
    private final int consecutiveFailures;
    private final Instant cooldownUntil;
    private final Instant lastFailureAt;

    private CooldownState(int consecutiveFailures, Instant cooldownUntil, Instant lastFailureAt) {
      this.consecutiveFailures = consecutiveFailures;
      this.cooldownUntil = cooldownUntil;
      this.lastFailureAt = lastFailureAt;
    }
  }

  private final ConcurrentHashMap<String, CooldownState> entries = new ConcurrentHashMap<>();
  private final Duration initialCooldown;
  private final Duration maxCooldown;
  private final Duration resetAfter;
  private final Clock clock;
  private final LongUnaryOperator randomLong;

  EndpointOverloadCooldownTracker() {
    this(
        DEFAULT_INITIAL_COOLDOWN,
        DEFAULT_MAX_COOLDOWN,
        DEFAULT_RESET_AFTER,
        Clock.systemUTC(),
        bound -> ThreadLocalRandom.current().nextLong(bound));
  }

  @VisibleForTesting
  EndpointOverloadCooldownTracker(
      Duration initialCooldown,
      Duration maxCooldown,
      Duration resetAfter,
      Clock clock,
      LongUnaryOperator randomLong) {
    Duration resolvedInitial =
        (initialCooldown == null || initialCooldown.isZero() || initialCooldown.isNegative())
            ? DEFAULT_INITIAL_COOLDOWN
            : initialCooldown;
    Duration resolvedMax =
        (maxCooldown == null || maxCooldown.isZero() || maxCooldown.isNegative())
            ? DEFAULT_MAX_COOLDOWN
            : maxCooldown;
    if (resolvedMax.compareTo(resolvedInitial) < 0) {
      resolvedMax = resolvedInitial;
    }
    this.initialCooldown = resolvedInitial;
    this.maxCooldown = resolvedMax;
    this.resetAfter =
        (resetAfter == null || resetAfter.isZero() || resetAfter.isNegative())
            ? DEFAULT_RESET_AFTER
            : resetAfter;
    this.clock = clock == null ? Clock.systemUTC() : clock;
    this.randomLong =
        randomLong == null ? bound -> ThreadLocalRandom.current().nextLong(bound) : randomLong;
  }

  boolean isCoolingDown(String address) {
    if (address == null || address.isEmpty()) {
      return false;
    }
    Instant now = clock.instant();
    CooldownState state = entries.get(address);
    if (state == null) {
      return false;
    }
    if (state.cooldownUntil.isAfter(now)) {
      return true;
    }
    if (Duration.between(state.lastFailureAt, now).compareTo(resetAfter) < 0) {
      return false;
    }
    entries.remove(address, state);
    CooldownState current = entries.get(address);
    return current != null && current.cooldownUntil.isAfter(now);
  }

  void recordFailure(String address) {
    if (address == null || address.isEmpty()) {
      return;
    }
    Instant now = clock.instant();
    entries.compute(
        address,
        (ignored, state) -> {
          int consecutiveFailures = 1;
          if (state != null
              && Duration.between(state.lastFailureAt, now).compareTo(resetAfter) < 0) {
            consecutiveFailures = state.consecutiveFailures + 1;
          }
          Duration cooldown = cooldownForFailures(consecutiveFailures);
          return new CooldownState(consecutiveFailures, now.plus(cooldown), now);
        });
  }

  private Duration cooldownForFailures(int failures) {
    Duration cooldown = initialCooldown;
    for (int i = 1; i < failures; i++) {
      if (cooldown.compareTo(maxCooldown.dividedBy(2)) > 0) {
        cooldown = maxCooldown;
        break;
      }
      cooldown = cooldown.multipliedBy(2);
    }
    long cooldownMillis = Math.max(1L, cooldown.toMillis());
    long floorMillis = Math.max(1L, cooldownMillis / 2L);
    long rangeSize = Math.max(1L, cooldownMillis - floorMillis + 1L);
    return Duration.ofMillis(floorMillis + randomLong.applyAsLong(rangeSize));
  }

  @VisibleForTesting
  CooldownState getState(String address) {
    return entries.get(address);
  }
}

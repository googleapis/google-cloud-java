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
import io.grpc.Status;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import javax.annotation.Nullable;

/**
 * Tracks short-lived endpoint cooldowns after routed overload or availability failures.
 *
 * <p>Server-hinted overloads and connection failures use separate escalation lanes because a short
 * load-shed response must not weaken protection for an unavailable endpoint.
 */
final class EndpointOverloadCooldownTracker implements Predicate<String> {

  @VisibleForTesting static final Duration DEFAULT_INITIAL_COOLDOWN = Duration.ofSeconds(10);
  @VisibleForTesting static final Duration DEFAULT_MAX_COOLDOWN = Duration.ofMinutes(1);
  @VisibleForTesting static final Duration DEFAULT_RESET_AFTER = Duration.ofMinutes(10);
  @VisibleForTesting static final int DEFAULT_SUCCESSES_PER_REPAIR = 3;
  @VisibleForTesting static final Duration DEFAULT_MIN_HINTED_COOLDOWN = Duration.ofMillis(100);
  @VisibleForTesting static final Duration DEFAULT_MAX_HINTED_CLIENT_FLOOR = Duration.ofSeconds(2);
  @VisibleForTesting static final Duration DEFAULT_MAX_HINTED_JITTER = Duration.ofMillis(500);
  @VisibleForTesting static final int DEFAULT_MAX_TIER = 6;

  private static final Duration MIN_PROBE_RESERVATION = Duration.ofMillis(250);
  private static final Duration MAX_PROBE_RESERVATION = Duration.ofMillis(500);

  @VisibleForTesting
  static final class CooldownState {
    final int overloadFailures;
    final int unavailableFailures;
    final int successesTowardRepair;
    final Instant overloadUntil;
    final Instant unavailableUntil;
    final Instant overloadProbeNotBefore;
    final Instant probeReservedUntil;
    @Nullable final Instant lastOverloadFailureAt;
    @Nullable final Instant lastUnavailableFailureAt;

    private CooldownState(
        int overloadFailures,
        int unavailableFailures,
        int successesTowardRepair,
        Instant overloadUntil,
        Instant unavailableUntil,
        Instant overloadProbeNotBefore,
        Instant probeReservedUntil,
        @Nullable Instant lastOverloadFailureAt,
        @Nullable Instant lastUnavailableFailureAt) {
      this.overloadFailures = overloadFailures;
      this.unavailableFailures = unavailableFailures;
      this.successesTowardRepair = successesTowardRepair;
      this.overloadUntil = overloadUntil;
      this.unavailableUntil = unavailableUntil;
      this.overloadProbeNotBefore = overloadProbeNotBefore;
      this.probeReservedUntil = probeReservedUntil;
      this.lastOverloadFailureAt = lastOverloadFailureAt;
      this.lastUnavailableFailureAt = lastUnavailableFailureAt;
    }
  }

  private static final class HintedCooldown {
    final Duration cooldown;
    final Duration probeDelay;

    private HintedCooldown(Duration cooldown, Duration probeDelay) {
      this.cooldown = cooldown;
      this.probeDelay = probeDelay;
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

  @Override
  public boolean test(String address) {
    return isCoolingDown(address);
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
    if (state.overloadUntil.isAfter(now) || state.unavailableUntil.isAfter(now)) {
      return true;
    }
    if (!isIdle(state, now)) {
      return false;
    }
    entries.remove(address, state);
    CooldownState current = entries.get(address);
    return current != null
        && (current.overloadUntil.isAfter(now) || current.unavailableUntil.isAfter(now));
  }

  void recordFailure(String address) {
    recordFailure(address, Status.Code.RESOURCE_EXHAUSTED, null);
  }

  void recordFailure(String address, Status.Code statusCode, @Nullable Duration serverRetryDelay) {
    if (address == null
        || address.isEmpty()
        || (statusCode != Status.Code.RESOURCE_EXHAUSTED
            && statusCode != Status.Code.UNAVAILABLE)) {
      return;
    }
    Instant now = clock.instant();
    entries.compute(
        address,
        (ignored, state) -> {
          CooldownState current = state == null || isIdle(state, now) ? emptyState(now) : state;
          if (statusCode == Status.Code.RESOURCE_EXHAUSTED) {
            int failures =
                nextFailureTier(current.overloadFailures, current.lastOverloadFailureAt, now);
            Duration cooldown;
            Duration probeDelay;
            if (validRetryDelay(serverRetryDelay)) {
              HintedCooldown hinted = hintedOverloadCooldown(failures, serverRetryDelay);
              cooldown = hinted.cooldown;
              probeDelay = hinted.probeDelay;
            } else {
              cooldown = cooldownForFailures(failures);
              probeDelay = cooldown;
            }
            return new CooldownState(
                failures,
                current.unavailableFailures,
                0,
                later(current.overloadUntil, now.plus(cooldown)),
                current.unavailableUntil,
                later(current.overloadProbeNotBefore, now.plus(probeDelay)),
                current.probeReservedUntil,
                now,
                current.lastUnavailableFailureAt);
          }
          int failures =
              nextFailureTier(current.unavailableFailures, current.lastUnavailableFailureAt, now);
          return new CooldownState(
              current.overloadFailures,
              failures,
              0,
              current.overloadUntil,
              later(current.unavailableUntil, now.plus(cooldownForFailures(failures))),
              current.overloadProbeNotBefore,
              current.probeReservedUntil,
              current.lastOverloadFailureAt,
              now);
        });
  }

  void recordSuccess(String address) {
    if (address == null || address.isEmpty()) {
      return;
    }
    Instant now = clock.instant();
    entries.computeIfPresent(
        address,
        (ignored, state) -> {
          if (isIdle(state, now)) {
            return null;
          }
          int successes = state.successesTowardRepair + 1;
          if (successes < DEFAULT_SUCCESSES_PER_REPAIR) {
            return copyWithTiersAndSuccesses(
                state, state.overloadFailures, state.unavailableFailures, successes);
          }
          int overloadFailures = Math.max(0, state.overloadFailures - 1);
          int unavailableFailures = Math.max(0, state.unavailableFailures - 1);
          if (overloadFailures == 0
              && unavailableFailures == 0
              && !state.overloadUntil.isAfter(now)
              && !state.unavailableUntil.isAfter(now)) {
            return null;
          }
          return copyWithTiersAndSuccesses(state, overloadFailures, unavailableFailures, 0);
        });
  }

  boolean tryReserveProbe(String address) {
    if (address == null || address.isEmpty()) {
      return false;
    }
    Instant now = clock.instant();
    AtomicBoolean reserved = new AtomicBoolean();
    entries.computeIfPresent(
        address,
        (ignored, state) -> {
          if (!state.overloadUntil.isAfter(now)
              || state.unavailableUntil.isAfter(now)
              || state.overloadProbeNotBefore.isAfter(now)
              || state.probeReservedUntil.isAfter(now)) {
            return state;
          }
          long minMillis = MIN_PROBE_RESERVATION.toMillis();
          long rangeMillis =
              MAX_PROBE_RESERVATION.toMillis() - MIN_PROBE_RESERVATION.toMillis() + 1L;
          Duration reservation = Duration.ofMillis(minMillis + randomLong.applyAsLong(rangeMillis));
          reserved.set(true);
          return new CooldownState(
              state.overloadFailures,
              state.unavailableFailures,
              state.successesTowardRepair,
              state.overloadUntil,
              state.unavailableUntil,
              state.overloadProbeNotBefore,
              now.plus(reservation),
              state.lastOverloadFailureAt,
              state.lastUnavailableFailureAt);
        });
    return reserved.get();
  }

  @Nullable
  Instant getLastOverloadFailureAt(String address) {
    CooldownState state = entries.get(address);
    return state == null ? null : state.lastOverloadFailureAt;
  }

  private CooldownState emptyState(Instant now) {
    return new CooldownState(0, 0, 0, now, now, now, now, null, null);
  }

  private CooldownState copyWithTiersAndSuccesses(
      CooldownState state, int overloadFailures, int unavailableFailures, int successes) {
    return new CooldownState(
        overloadFailures,
        unavailableFailures,
        successes,
        state.overloadUntil,
        state.unavailableUntil,
        state.overloadProbeNotBefore,
        state.probeReservedUntil,
        state.lastOverloadFailureAt,
        state.lastUnavailableFailureAt);
  }

  private boolean isRecent(@Nullable Instant lastFailureAt, Instant now) {
    return lastFailureAt != null && Duration.between(lastFailureAt, now).compareTo(resetAfter) < 0;
  }

  private boolean isIdle(CooldownState state, Instant now) {
    return !state.overloadUntil.isAfter(now)
        && !state.unavailableUntil.isAfter(now)
        && !isRecent(state.lastOverloadFailureAt, now)
        && !isRecent(state.lastUnavailableFailureAt, now);
  }

  private int nextFailureTier(int previousFailures, @Nullable Instant lastFailureAt, Instant now) {
    if (previousFailures == 0 || !isRecent(lastFailureAt, now)) {
      return 1;
    }
    return Math.min(DEFAULT_MAX_TIER, previousFailures + 1);
  }

  private static boolean validRetryDelay(@Nullable Duration retryDelay) {
    // A present zero delay uses the 100 ms floor; an absent hint uses unhinted backoff.
    return retryDelay != null && !retryDelay.isNegative();
  }

  private HintedCooldown hintedOverloadCooldown(int failures, Duration serverRetryDelay) {
    Duration serverFloor =
        serverRetryDelay.compareTo(DEFAULT_MIN_HINTED_COOLDOWN) < 0
            ? DEFAULT_MIN_HINTED_COOLDOWN
            : serverRetryDelay;
    Duration clientFloor = DEFAULT_MIN_HINTED_COOLDOWN;
    for (int i = 1;
        i < failures && clientFloor.compareTo(DEFAULT_MAX_HINTED_CLIENT_FLOOR) < 0;
        i++) {
      clientFloor = min(clientFloor.multipliedBy(2), DEFAULT_MAX_HINTED_CLIENT_FLOOR);
    }
    Duration base = serverFloor.compareTo(clientFloor) >= 0 ? serverFloor : clientFloor;
    Duration jitterLimit = min(base.dividedBy(4), DEFAULT_MAX_HINTED_JITTER);
    long jitterRangeMillis = jitterLimit.toMillis() + 1L;
    Duration jitter = Duration.ofMillis(randomLong.applyAsLong(jitterRangeMillis));
    return new HintedCooldown(base.plus(jitter), serverFloor.plus(jitter));
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

  private static Duration min(Duration first, Duration second) {
    return first.compareTo(second) <= 0 ? first : second;
  }

  private static Instant later(Instant first, Instant second) {
    return first.isAfter(second) ? first : second;
  }

  @VisibleForTesting
  CooldownState getState(String address) {
    return entries.get(address);
  }
}

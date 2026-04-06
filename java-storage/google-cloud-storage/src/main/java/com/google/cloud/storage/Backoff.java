/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static java.time.Duration.ZERO;
import static java.util.Objects.requireNonNull;

import com.google.api.gax.retrying.RetrySettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Encapsulated class to track a timeout and calculate a backoff.
 *
 * <p>Error tracking is explicitly not tracked here. This class only tracks elapsed duration and
 * timeout and whether there is budget for backoff.
 *
 * <p>This class does not use a clock, instead everything is tracked as durations provided by the
 * user. This has the advantage that tests of it and anything that depends on it are able to be 100%
 * reproducible.
 *
 * <p>This class also allows for a jittering algorithm to be provided to it, rather than being hard
 * coded against a random number generator like {@link ThreadLocalRandom}.
 *
 * <p>This class is not thread safe.
 */
final class Backoff {

  private final Duration initialBackoff;
  private final Duration maxBackoff;
  private final Duration timeout;
  private final double retryDelayMultiplier;
  private final Jitterer jitterer;

  private Duration cumulativeBackoff;
  private Duration previousBackoff;

  private Backoff(
      Duration initialBackoff,
      double backoffDelayMultiplier,
      Duration maxBackoff,
      Duration timeout,
      Jitterer jitterer) {
    this.initialBackoff = initialBackoff;
    this.maxBackoff = maxBackoff;
    this.timeout = timeout;
    this.jitterer = jitterer;
    this.retryDelayMultiplier = backoffDelayMultiplier;
    this.cumulativeBackoff = ZERO;
    this.previousBackoff = ZERO;
  }

  /**
   * Compute the next backoff given the provide {@code elapsed} duration between any previous
   * invocation and this one.
   *
   * <p>If there is remaining backoff budget, a backoff will be computed and returned as a {@link
   * BackoffDuration}. If the backoff budget doesn't have enough to allow for another backoff an
   * {@link BackoffResults#EXHAUSTED} will be returned.
   *
   * <p>{@code EXHAUSTED} can happen in the following circumstances
   *
   * <ol>
   *   <li>If the existing {@link #cumulativeBackoff} + {@code elapsed} is >= {@link #timeout}
   * </ol>
   */
  BackoffResult nextBackoff(Duration elapsed) {
    checkArgument(
        Durations.gtEq(elapsed, ZERO), "elapsed must be >= PT0S (%s >= %s)", elapsed, ZERO);
    Duration cumulativeAndElapsed = cumulativeBackoff.plus(elapsed);
    cumulativeBackoff = cumulativeAndElapsed;
    if (Durations.gtEq(cumulativeAndElapsed, timeout)) {
      return BackoffResults.EXHAUSTED;
    }
    Duration nextDelay =
        Duration.ofNanos(Math.round(previousBackoff.toNanos() * retryDelayMultiplier));
    if (Durations.eq(nextDelay, ZERO)) {
      nextDelay = initialBackoff;
    }
    Duration nextBackoffWithJitter = jitterer.jitter(nextDelay);
    Duration remainingUtilTimeout = timeout.minus(cumulativeAndElapsed);
    Duration cappedBackoff = Durations.min(nextBackoffWithJitter, maxBackoff, remainingUtilTimeout);
    previousBackoff = cappedBackoff;

    return BackoffDuration.of(cappedBackoff);
  }

  /**
   * Reset all state.
   *
   * <p>After calling this method, backoff durations will reset to their initial values.
   */
  void reset() {
    cumulativeBackoff = ZERO;
    previousBackoff = ZERO;
  }

  Duration getCumulativeBackoff() {
    return cumulativeBackoff;
  }

  Duration getTimeout() {
    return timeout;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Backoff)) {
      return false;
    }
    Backoff backoff = (Backoff) o;
    return Double.compare(retryDelayMultiplier, backoff.retryDelayMultiplier) == 0
        && Objects.equals(initialBackoff, backoff.initialBackoff)
        && Objects.equals(maxBackoff, backoff.maxBackoff)
        && Objects.equals(timeout, backoff.timeout)
        && Objects.equals(jitterer, backoff.jitterer)
        && Objects.equals(cumulativeBackoff, backoff.cumulativeBackoff);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        initialBackoff, maxBackoff, timeout, retryDelayMultiplier, jitterer, cumulativeBackoff);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("previousBackoff", previousBackoff)
        .add("cumulativeBackoff", cumulativeBackoff)
        .add("initialBackoff", initialBackoff)
        .add("maxBackoff", maxBackoff)
        .add("timeout", timeout)
        .add("retryDelayMultiplier", retryDelayMultiplier)
        .add("jitterer", jitterer)
        .toString();
  }

  /** Convenience method to create a Backoff from RetrySettings. */
  static Backoff.Builder from(RetrySettings retrySettings) {
    return newBuilder()
        .setInitialBackoff(retrySettings.getInitialRetryDelayDuration())
        .setRetryDelayMultiplier(retrySettings.getRetryDelayMultiplier())
        .setMaxBackoff(retrySettings.getMaxRetryDelayDuration())
        .setTimeout(retrySettings.getTotalTimeoutDuration());
  }

  static Builder newBuilder() {
    return new Builder();
  }

  static final class Builder {
    private Duration initialBackoff;
    private Duration maxBackoff;
    private Duration timeout;
    private double retryDelayMultiplier;
    private Jitterer jitterer;

    private Builder() {}

    Builder setInitialBackoff(Duration initialBackoff) {
      this.initialBackoff = initialBackoff;
      return this;
    }

    Builder setMaxBackoff(Duration maxBackoff) {
      this.maxBackoff = maxBackoff;
      return this;
    }

    Builder setTimeout(Duration timeout) {
      this.timeout = timeout;
      return this;
    }

    Builder setRetryDelayMultiplier(double retryDelayMultiplier) {
      this.retryDelayMultiplier = retryDelayMultiplier;
      return this;
    }

    Builder setJitterer(Jitterer jitterer) {
      this.jitterer = jitterer;
      return this;
    }

    Backoff build() {
      checkState(retryDelayMultiplier >= 1.0, "retryDelayMultiplier must be >= 1.0");
      Duration effectiveTimeout = requireNonNull(timeout, "timeout must be non null");
      if (Durations.ltEq(effectiveTimeout, ZERO)) {
        effectiveTimeout = Durations.EFFECTIVE_INFINITY;
      }
      return new Backoff(
          requireNonNull(initialBackoff, "initialBackoff must be non null"),
          retryDelayMultiplier,
          requireNonNull(maxBackoff, "maxBackoff must be non null"),
          effectiveTimeout,
          requireNonNull(jitterer, "jitterer must be non null"));
    }
  }

  interface BackoffResult {
    String errorString();
  }

  enum BackoffResults implements BackoffResult {
    EXHAUSTED;

    @Override
    public String errorString() {
      return name();
    }
  }

  static final class BackoffDuration implements BackoffResult {
    private final Duration duration;

    private BackoffDuration(Duration duration) {
      this.duration = duration;
    }

    Duration getDuration() {
      return duration;
    }

    @Override
    public String errorString() {
      return duration.toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof BackoffDuration)) {
        return false;
      }
      BackoffDuration that = (BackoffDuration) o;
      return Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(duration);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("duration", duration).toString();
    }

    static BackoffDuration of(Duration duration) {
      return new BackoffDuration(duration);
    }
  }

  /** Simple API to allow for the definition of a Jittering algorithm. */
  @FunctionalInterface
  interface Jitterer {
    Duration jitter(Duration baseline);

    static Jitterer threadLocalRandom() {
      return ThreadLocalRandomJitterer.INSTANCE;
    }

    @VisibleForTesting
    static Jitterer noJitter() {
      return NoJitter.INSTANCE;
    }
  }

  private static final class ThreadLocalRandomJitterer implements Jitterer {
    private static final ThreadLocalRandomJitterer INSTANCE = new ThreadLocalRandomJitterer();

    @Override
    public Duration jitter(Duration baseline) {
      if (Durations.gt(baseline, ZERO)) {
        long nanos = baseline.toNanos();
        long randNanos = ThreadLocalRandom.current().nextLong(nanos);
        return baseline.plusNanos(randNanos);
      }
      return baseline;
    }
  }

  private static final class NoJitter implements Jitterer {
    private static final NoJitter INSTANCE = new NoJitter();

    @Override
    public Duration jitter(Duration baseline) {
      return baseline;
    }
  }
}

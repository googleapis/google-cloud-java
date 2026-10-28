/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.internal.middleware;

import com.google.bigtable.v2.SessionMutateRowsResponse;
import com.google.bigtable.v2.SessionMutateRowsResponse.RateLimitInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.math.LongMath;
import com.google.protobuf.util.Durations;
import io.grpc.Status;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Non-blocking conditional rate limiter for {@code SessionMutateRows}, driven by server-returned
 * {@link RateLimitInfo} and overload errors.
 *
 * <p>Mirrors the behavior of {@code RateLimitingServerStreamingCallable} on the classic path,
 * including smooth-bursty permit reservation (up to 1 second of stored permits), QPS bounds {@code
 * [0.1, 100_000]}, factor bounds {@code [0.7, 1.3]}, period-gated updates/disabling, and {@code
 * 0.7x} backoff on {@code DEADLINE_EXCEEDED}, {@code UNAVAILABLE}, and {@code RESOURCE_EXHAUSTED},
 * while returning reservation delays instead of blocking threads.
 */
public final class SessionMutateRowsRateLimiter {
  private static final Logger logger =
      Logger.getLogger(SessionMutateRowsRateLimiter.class.getName());

  static final double DEFAULT_QPS = 10.0;
  static final Duration DEFAULT_PERIOD = Duration.ofSeconds(10);
  static final double MIN_QPS = 0.1;
  static final double MAX_QPS = 100_000.0;
  static final double MIN_FACTOR = 0.7;
  static final double MAX_FACTOR = 1.3;
  private static final double MAX_BURST_SECONDS = 1.0;

  private final Ticker ticker;
  private final Object lock = new Object();

  private boolean enabled = false;
  private double rate;
  private double stableIntervalNanos;
  private double maxPermits;
  private double storedPermits;
  private long nextFreeTicketNanos;
  private long nextRateUpdateNanos;

  public SessionMutateRowsRateLimiter() {
    this(DEFAULT_QPS, Ticker.systemTicker());
  }

  public SessionMutateRowsRateLimiter(double defaultQps, Ticker ticker) {
    Preconditions.checkArgument(defaultQps > 0.0, "defaultQps must be positive");
    this.ticker = Preconditions.checkNotNull(ticker, "ticker");
    long nowNanos = ticker.read();
    this.rate = defaultQps;
    this.stableIntervalNanos = TimeUnit.SECONDS.toNanos(1L) / defaultQps;
    this.maxPermits = MAX_BURST_SECONDS * defaultQps;
    this.storedPermits = 0.0;
    this.nextFreeTicketNanos = nowNanos;
    this.nextRateUpdateNanos = nowNanos;
    logger.info(
        "Batch write flow control: session rate limiter initialized (disabled) with rate of "
            + defaultQps
            + " QPS.");
  }

  /**
   * Reserves a permit without blocking if the wait does not exceed {@code maxWait}.
   *
   * @return the non-negative delay to wait before sending the request, or {@link Optional#empty()}
   *     if the required wait exceeds {@code maxWait} (in which case no permit is consumed).
   */
  public Optional<Duration> tryAcquireDelay(Duration maxWait) {
    synchronized (lock) {
      if (!enabled) {
        return Optional.of(Duration.ZERO);
      }
      long nowNanos = ticker.read();
      resyncLocked(nowNanos);
      long waitNanos = Math.max(0L, nextFreeTicketNanos - nowNanos);
      if (maxWait.isNegative() || waitNanos > maxWait.toNanos()) {
        return Optional.empty();
      }
      double storedPermitsToSpend = Math.min(1.0, storedPermits);
      double freshPermits = 1.0 - storedPermitsToSpend;
      long freshWaitNanos = (long) (freshPermits * stableIntervalNanos);
      nextFreeTicketNanos = LongMath.saturatedAdd(nextFreeTicketNanos, freshWaitNanos);
      storedPermits -= storedPermitsToSpend;
      return Optional.of(Duration.ofNanos(waitNanos));
    }
  }

  /** Updates limiter state and CSM metrics from a {@link SessionMutateRowsResponse}. */
  public void onResponse(SessionMutateRowsResponse response, VRpcTracer tracer) {
    if (hasValidRateLimitInfo(response)) {
      enable();
      RateLimitInfo info = response.getRateLimitInfo();
      updateQps(
          info.getFactor(),
          Duration.ofSeconds(Durations.toSeconds(info.getPeriod())),
          Status.Code.OK,
          tracer);
    } else {
      tryDisable();
    }
  }

  /** Updates limiter state and CSM metrics when an attempt closes with an overload status. */
  public void onResult(VRpcResult result, VRpcTracer tracer) {
    if (result.getStatus().isOk()) {
      return;
    }
    Status.Code code = result.getStatus().getCode();
    if (code == Status.Code.DEADLINE_EXCEEDED
        || code == Status.Code.UNAVAILABLE
        || code == Status.Code.RESOURCE_EXHAUSTED) {
      updateQps(MIN_FACTOR, DEFAULT_PERIOD, code, tracer);
    }
  }

  private static boolean hasValidRateLimitInfo(SessionMutateRowsResponse response) {
    if (!response.hasRateLimitInfo()) {
      return false;
    }
    RateLimitInfo info = response.getRateLimitInfo();
    return info.getFactor() > 0 && info.getPeriod().getSeconds() > 0;
  }

  private void enable() {
    boolean wasEnabled;
    synchronized (lock) {
      wasEnabled = enabled;
      enabled = true;
    }
    if (!wasEnabled) {
      logger.info("Batch write flow control: session rate limiter is enabled.");
    }
  }

  private void tryDisable() {
    boolean wasEnabled = false;
    synchronized (lock) {
      long nowNanos = ticker.read();
      if (nowNanos > nextRateUpdateNanos) {
        wasEnabled = enabled;
        enabled = false;
      }
    }
    if (wasEnabled) {
      logger.info("Batch write flow control: session rate limiter is disabled.");
    }
  }

  private void updateQps(
      double factor, Duration period, Status.Code statusCode, VRpcTracer tracer) {
    double cappedFactor = Math.min(Math.max(factor, MIN_FACTOR), MAX_FACTOR);
    double oldRate;
    double newRate;
    boolean applied;

    synchronized (lock) {
      long nowNanos = ticker.read();
      if (nowNanos < nextRateUpdateNanos) {
        oldRate = rate;
        newRate = rate;
        applied = false;
      } else {
        oldRate = rate;
        newRate = Math.min(Math.max(oldRate * cappedFactor, MIN_QPS), MAX_QPS);
        setRateLocked(newRate, nowNanos);
        nextRateUpdateNanos =
            LongMath.saturatedAdd(nowNanos, TimeUnit.SECONDS.toNanos(period.getSeconds()));
        applied = true;
      }
    }

    if (!applied) {
      tracer.recordBatchWriteFlowControlFactor(cappedFactor, statusCode, false);
      return;
    }

    logger.info(
        "Batch write flow control: updated max rate from "
            + oldRate
            + " to "
            + newRate
            + " applied factor "
            + cappedFactor
            + " with period "
            + period.getSeconds()
            + " seconds. Status="
            + statusCode);
    tracer.recordBatchWriteFlowControlTargetQps(newRate);
    tracer.recordBatchWriteFlowControlFactor(cappedFactor, statusCode, true);
  }

  private void resyncLocked(long nowNanos) {
    if (nowNanos > nextFreeTicketNanos) {
      double newPermits = (nowNanos - nextFreeTicketNanos) / stableIntervalNanos;
      storedPermits = Math.min(maxPermits, storedPermits + newPermits);
      nextFreeTicketNanos = nowNanos;
    }
  }

  private void setRateLocked(double newRate, long nowNanos) {
    resyncLocked(nowNanos);
    this.rate = newRate;
    this.stableIntervalNanos = TimeUnit.SECONDS.toNanos(1L) / newRate;
    double oldMaxPermits = this.maxPermits;
    this.maxPermits = MAX_BURST_SECONDS * newRate;
    this.storedPermits =
        (oldMaxPermits == 0.0) ? 0.0 : this.storedPermits * this.maxPermits / oldMaxPermits;
  }

  @VisibleForTesting
  public boolean isEnabled() {
    synchronized (lock) {
      return enabled;
    }
  }

  @VisibleForTesting
  public double getRate() {
    synchronized (lock) {
      return rate;
    }
  }

  @VisibleForTesting
  void setEnabled(boolean enabled) {
    synchronized (lock) {
      this.enabled = enabled;
    }
  }

  @VisibleForTesting
  void setRate(double newRate) {
    synchronized (lock) {
      setRateLocked(newRate, ticker.read());
    }
  }
}

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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.LongSupplier;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/**
 * Implementation of {@link LatencyTracker} using Exponentially Weighted Moving Average (EWMA).
 *
 * <p>By default, this tracker uses a time-decayed EWMA: $S_{i+1} = \alpha(\Delta t) * new\_latency
 * + (1 - \alpha(\Delta t)) * S_i$, where $\alpha(\Delta t) = 1 - e^{-\Delta t / \tau}$.
 *
 * <p>A fixed-alpha constructor is retained for focused tests.
 */
@InternalApi
@BetaApi
public class EwmaLatencyTracker implements LatencyTracker {

  public static final double DEFAULT_ALPHA = 0.05;
  public static final Duration DEFAULT_DECAY_TIME = Duration.ofSeconds(10);

  @Nullable private final Double fixedAlpha;
  private final long tauNanos;
  private final LongSupplier nanoTimeSupplier;
  private final Object lock = new Object();

  @GuardedBy("lock")
  private double score;

  @GuardedBy("lock")
  private boolean initialized = false;

  @GuardedBy("lock")
  private long lastUpdatedAtNanos;

  /** Creates a new tracker with Envoy-style time-based decay and a 10-second decay window. */
  public EwmaLatencyTracker() {
    this(DEFAULT_DECAY_TIME, System::nanoTime);
  }

  /**
   * Creates a new tracker with the specified alpha value.
   *
   * @param alpha the smoothing factor, must be in the range (0, 1]
   */
  public EwmaLatencyTracker(double alpha) {
    this(alpha, System::nanoTime);
  }

  @VisibleForTesting
  EwmaLatencyTracker(Duration decayTime, LongSupplier nanoTimeSupplier) {
    Preconditions.checkArgument(
        decayTime != null && !decayTime.isZero() && !decayTime.isNegative(),
        "decayTime must be > 0");
    this.fixedAlpha = null;
    this.tauNanos = decayTime.toNanos();
    this.nanoTimeSupplier = nanoTimeSupplier;
  }

  @VisibleForTesting
  EwmaLatencyTracker(double alpha, LongSupplier nanoTimeSupplier) {
    Preconditions.checkArgument(alpha > 0.0 && alpha <= 1.0, "alpha must be in (0, 1]");
    this.fixedAlpha = alpha;
    this.tauNanos = 0L;
    this.nanoTimeSupplier = nanoTimeSupplier;
  }

  @Override
  public double getScore() {
    synchronized (lock) {
      return initialized ? score : Double.MAX_VALUE;
    }
  }

  @Override
  public void update(Duration latency) {
    long latencyMicros;
    try {
      latencyMicros = TimeUnit.MICROSECONDS.convert(latency.toNanos(), TimeUnit.NANOSECONDS);
    } catch (ArithmeticException e) {
      // Duration is too large to fit in nanoseconds (292+ years).
      // Use Long.MAX_VALUE to give it the lowest possible priority.
      latencyMicros = Long.MAX_VALUE;
    }
    long nowNanos = nanoTimeSupplier.getAsLong();
    synchronized (lock) {
      if (!initialized) {
        score = latencyMicros;
        initialized = true;
        lastUpdatedAtNanos = nowNanos;
      } else {
        double alpha = fixedAlpha != null ? fixedAlpha : calculateTimeBasedAlpha(nowNanos);
        score = alpha * latencyMicros + (1 - alpha) * score;
        lastUpdatedAtNanos = nowNanos;
      }
    }
  }

  @Override
  public void recordError(Duration penalty) {
    // Treat the error as a sample with high latency (penalty)
    update(penalty);
  }

  private double calculateTimeBasedAlpha(long nowNanos) {
    long deltaNanos = nowNanos - lastUpdatedAtNanos;
    if (deltaNanos <= 0L) {
      // Concurrent or future samples get full weight
      return 1.0;
    }
    double alpha = 1.0 - Math.exp(-(double) deltaNanos / (double) tauNanos);
    return Math.min(1.0, Math.max(0.0, alpha));
  }
}

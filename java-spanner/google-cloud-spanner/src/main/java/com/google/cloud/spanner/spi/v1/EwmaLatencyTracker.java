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
import com.google.common.base.Preconditions;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/**
 * Implementation of {@link LatencyTracker} using Exponentially Weighted Moving Average (EWMA).
 *
 * <p>Formula: $S_{i+1} = \alpha * new\_latency + (1 - \alpha) * S_i$
 *
 * <p>This class is thread-safe.
 */
@InternalApi
@BetaApi
public class EwmaLatencyTracker implements LatencyTracker {

  public static final double DEFAULT_ALPHA = 0.05;

  private final double alpha;
  private final Object lock = new Object();

  @GuardedBy("lock")
  private double score;

  @GuardedBy("lock")
  private boolean initialized = false;

  /** Creates a new tracker with the default alpha value of 0.05. */
  public EwmaLatencyTracker() {
    this(DEFAULT_ALPHA);
  }

  /**
   * Creates a new tracker with the specified alpha value.
   *
   * @param alpha the smoothing factor, must be in the range (0, 1]
   */
  public EwmaLatencyTracker(double alpha) {
    Preconditions.checkArgument(alpha > 0.0 && alpha <= 1.0, "alpha must be in (0, 1]");
    this.alpha = alpha;
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
    synchronized (lock) {
      if (!initialized) {
        score = latencyMicros;
        initialized = true;
      } else {
        score = alpha * latencyMicros + (1 - alpha) * score;
      }
    }
  }

  @Override
  public void recordError(Duration penalty) {
    // Treat the error as a sample with high latency (penalty)
    update(penalty);
  }
}

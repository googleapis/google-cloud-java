/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.gax.batching.FlowController;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Records stats used in dynamic flow control, the decaying average of recorded latencies and the
 * last timestamp when the thresholds in {@link FlowController} are updated.
 */
final class DynamicFlowControlStats {

  private static final double DEFAULT_DECAY_CONSTANT = 0.015; // Biased to the past 5 minutes

  private AtomicLong lastAdjustedTimestampMs;
  private DecayingAverage meanLatency;

  DynamicFlowControlStats() {
    this(DEFAULT_DECAY_CONSTANT);
  }

  DynamicFlowControlStats(double decayConstant) {
    this.lastAdjustedTimestampMs = new AtomicLong(0);
    this.meanLatency = new DecayingAverage(decayConstant);
  }

  void updateLatency(long latency) {
    updateLatency(latency, System.currentTimeMillis());
  }

  @VisibleForTesting
  void updateLatency(long latency, long timestampMs) {
    meanLatency.update(latency, timestampMs);
  }

  double getMeanLatency() {
    return getMeanLatency(System.currentTimeMillis());
  }

  @VisibleForTesting
  double getMeanLatency(long timestampMs) {
    return meanLatency.getMean(timestampMs);
  }

  public long getLastAdjustedTimestampMs() {
    return lastAdjustedTimestampMs.get();
  }

  boolean setLastAdjustedTimestampMs(long last, long now) {
    return lastAdjustedTimestampMs.compareAndSet(last, now);
  }

  private class DecayingAverage {
    private double decayConstant;
    private double mean;
    private double weightedCount;
    private AtomicLong lastUpdateTimeInSecond;

    DecayingAverage(double decayConstant) {
      this.decayConstant = decayConstant;
      this.mean = 0.0;
      this.weightedCount = 0.0;
      this.lastUpdateTimeInSecond = new AtomicLong(0);
    }

    synchronized void update(long value, long timestampMs) {
      long now = TimeUnit.MILLISECONDS.toSeconds(timestampMs);
      Preconditions.checkArgument(
          now >= lastUpdateTimeInSecond.get(), "can't update an event in the past");
      if (lastUpdateTimeInSecond.get() == 0) {
        lastUpdateTimeInSecond.set(now);
        mean = value;
        weightedCount = 1;
      } else {
        long prev = lastUpdateTimeInSecond.getAndSet(now);
        long elapsed = now - prev;
        double alpha = getAlpha(elapsed);
        // Exponential moving average = weightedSum / weightedCount, where
        // weightedSum(n) = value + alpha * weightedSum(n - 1)
        // weightedCount(n) = 1 + alpha * weightedCount(n - 1)
        // Using weighted count in case the sum overflows
        mean =
            mean * ((weightedCount * alpha) / (weightedCount * alpha + 1))
                + value / (weightedCount * alpha + 1);
        weightedCount = weightedCount * alpha + 1;
      }
    }

    double getMean(long timestampMs) {
      long timestampSecs = TimeUnit.MILLISECONDS.toSeconds(timestampMs);
      long elapsed = timestampSecs - lastUpdateTimeInSecond.get();
      return mean * getAlpha(Math.max(0, elapsed));
    }

    private double getAlpha(long elapsedSecond) {
      return Math.exp(-decayConstant * elapsedSecond);
    }
  }
}

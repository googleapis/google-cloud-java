/*
 * Copyright 2016 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.core;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * Distribution records values from {@code 0} (inclusive) to {@code endValue} (exclusive) and
 * computes their percentiles.
 *
 * <p>Methods may be called concurrently.
 */
public class Distribution {

  private final AtomicLongArray buckets;
  private final AtomicInteger count = new AtomicInteger(0);

  public Distribution(int endValue) {
    Preconditions.checkArgument(endValue > 0);
    buckets = new AtomicLongArray(endValue);
  }

  // TODO(pongad): remove this when google-cloud-java no longer calls it.
  @Deprecated
  public long getNthPercentile(double percentile) {
    return getPercentile(percentile);
  }

  /**
   * Get the percentile of recorded values. If called concurrently with {@link #record(int)}, the
   * result is an approximate.
   */
  public int getPercentile(double percentile) {
    // NOTE: This implementation uses the nearest-rank method.
    // https://en.wikipedia.org/wiki/Percentile#The_nearest-rank_method
    //
    // If called concurrently with record, this implementation biases low.
    // Since we read count before iterating the array, more elements might have been recorded
    // and we might not iterate far enough to be fair.
    // Still, this probably won't matter greatly in practice.

    Preconditions.checkArgument(percentile > 0.0);
    Preconditions.checkArgument(percentile <= 100.0);

    long targetRank = (long) Math.ceil(percentile * count.get() / 100);
    long rank = 0;
    for (int i = 0; i < buckets.length(); i++) {
      rank += buckets.get(i);
      if (rank >= targetRank) {
        return i;
      }
    }
    return buckets.length();
  }

  /**
   * Records a new value.
   *
   * <p>The value must not be negative. To help with distributions with long tails, if the given
   * value is greater than or equal to {@code endValue}, the value {@code endValue-1} is recorded
   * instead.
   */
  public void record(int value) {
    Preconditions.checkArgument(value >= 0);
    if (value >= buckets.length()) {
      value = buckets.length() - 1;
    }
    buckets.incrementAndGet(value);
    count.incrementAndGet();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("endValue", buckets.length())
        .add("count", count.get())
        .toString();
  }
}

/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.pubsub;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Takes measurements and stores them in linear buckets from 0 to totalBuckets - 1, along with 
 * utilities to calculate percentiles for analysis of results.
 */
public class Distribution {

  private final AtomicLong[] bucketCounts;
  private long count = 0;
  private double mean = 0;
  private double sumOfSquaredDeviation = 0;

  public Distribution(int totalBuckets) {
    Preconditions.checkArgument(totalBuckets > 0);
    bucketCounts = new AtomicLong[totalBuckets];
    for (int i = 0; i < totalBuckets; ++i) {
      bucketCounts[i] = new AtomicLong();
    }
  }

  /**
   * Get the bucket that records values up to the given percentile.
   */
  public long getNthPercentile(double percentile) {
    Preconditions.checkArgument(percentile > 0.0);
    Preconditions.checkArgument(percentile <= 100.0);

    long[] bucketCounts = getBucketCounts();
    long total = 0;
    for (long count : bucketCounts) {
      total += count;
    }

    if (total == 0) {
      return 0;
    }
    long count = (long) Math.ceil(total * percentile / 100.0);
    for (int i = 0; i < bucketCounts.length; i++) {
      count -= bucketCounts[i];
      if (count <= 0) {
        return i;
      }
    }
    return 0;
  }

  /**
   * Resets (sets to 0) the recorded values.
   */
  public synchronized void reset() {
    for (AtomicLong element : bucketCounts) {
      element.set(0);
    }
    count = 0;
    mean = 0;
    sumOfSquaredDeviation = 0;
  }

  /**
   * Numbers of values recorded.
   */
  public long getCount() {
    return count;
  }

  /**
   * Square deviations of the recorded values.
   */
  public double getSumOfSquareDeviations() {
    return sumOfSquaredDeviation;
  }

  /**
   * Mean of the recorded values.
   */
  public double getMean() {
    return mean;
  }

  /**
   * Gets the accumulated count of every bucket of the distribution.
   */
  public long[] getBucketCounts() {
    long[] counts = new long[bucketCounts.length];
    for (int i = 0; i < counts.length; i++) {
      counts[i] = bucketCounts[i].longValue();
    }
    return counts;
  }

  /**
   * Make a copy of the distribution.
   */
  public synchronized Distribution copy() {
    Distribution distributionCopy = new Distribution(bucketCounts.length);
    distributionCopy.count = count;
    distributionCopy.mean = mean;
    distributionCopy.sumOfSquaredDeviation = sumOfSquaredDeviation;
    System.arraycopy(bucketCounts, 0, distributionCopy.bucketCounts, 0, bucketCounts.length);
    return distributionCopy;
  }

  /**
   * Record a new value.
   */
  public void record(int bucket) {
    Preconditions.checkArgument(bucket >= 0);

    synchronized (this) {
      count++;
      double dev = bucket - mean;
      mean += dev / count;
      sumOfSquaredDeviation += dev * (bucket - mean);
    }

    if (bucket >= bucketCounts.length) {
      // Account for bucket overflow, records everything that is equals or greater of the last
      // bucket.
      bucketCounts[bucketCounts.length - 1].incrementAndGet();
      return;
    }

   bucketCounts[bucket].incrementAndGet();
  }
  
  @Override
  public String toString() {
    ToStringHelper helper = MoreObjects.toStringHelper(Distribution.class); 
    helper.add("bucketCounts", bucketCounts);
    helper.add("count", count);
    helper.add("mean", mean);
    helper.add("sumOfSquaredDeviation", sumOfSquaredDeviation);
    return helper.toString();
  }
}

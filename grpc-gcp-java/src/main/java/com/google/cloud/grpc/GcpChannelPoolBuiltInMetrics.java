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

package com.google.cloud.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Process-wide reader of the channel pool metrics that a Google Cloud client library sends to its
 * built-in metrics pipeline.
 *
 * <p>There is one instance per built-in metrics {@link Meter}. Every pool configured with that
 * meter joins it, and a single callback, registered once, reads the active and draining channel
 * counts of all live pools whenever metrics are collected. Counts of pools with the same attributes
 * are added up, so several pools in one process are reported correctly. Reading the real pool sizes
 * at collection time means the values cannot drift.
 *
 * <p>A pool leaves on shutdown. Pools are held weakly, so a pool that is never shut down does not
 * stay reachable because of these metrics.
 */
final class GcpChannelPoolBuiltInMetrics {

  /** Pool index values above this number are all reported as {@link #POOL_INDEX_OTHER}. */
  static final int MAX_POOL_INDEX = 10;

  static final String POOL_INDEX_OTHER = "other";

  private static final AtomicInteger lastPoolIndex = new AtomicInteger();

  @GuardedBy("REGISTRIES")
  private static final Map<Meter, GcpChannelPoolBuiltInMetrics> REGISTRIES = new WeakHashMap<>();

  @GuardedBy("this")
  private final Set<GcpManagedChannel> pools = Collections.newSetFromMap(new WeakHashMap<>());

  private GcpChannelPoolBuiltInMetrics() {}

  /**
   * Returns the next pool index for this process: "1" to "10" in order, then "other". Indexes are
   * never reused, so the data of a closed pool is never mixed with a newer pool. The cap keeps the
   * number of time series bounded for applications that create many clients.
   */
  static String nextPoolIndex() {
    int index = lastPoolIndex.updateAndGet(i -> Math.min(i + 1, MAX_POOL_INDEX + 1));
    return index > MAX_POOL_INDEX ? POOL_INDEX_OTHER : Integer.toString(index);
  }

  @VisibleForTesting
  static void resetPoolIndexForTest() {
    lastPoolIndex.set(0);
  }

  /** Returns the reader for {@code meter}, registering its instruments on first use. */
  static GcpChannelPoolBuiltInMetrics forMeter(Meter meter) {
    synchronized (REGISTRIES) {
      GcpChannelPoolBuiltInMetrics metrics = REGISTRIES.get(meter);
      if (metrics == null) {
        metrics = new GcpChannelPoolBuiltInMetrics();
        metrics.registerInstruments(meter);
        REGISTRIES.put(meter, metrics);
      }
      return metrics;
    }
  }

  private void registerInstruments(Meter meter) {
    // An asynchronous up-down counter, not a gauge: the value is a total number of channels, which
    // stays meaningful when attributes are dropped and the values are added up.
    meter
        .upDownCounterBuilder(GcpMetricsConstants.METRIC_CHANNEL_POOL_CHANNEL_COUNT)
        .setDescription("The number of channels in the pool, by state.")
        .setUnit(GcpMetricsConstants.COUNT)
        .buildWithCallback(this::reportChannelCounts);
  }

  synchronized void add(GcpManagedChannel pool) {
    pools.add(pool);
  }

  synchronized void remove(GcpManagedChannel pool) {
    pools.remove(pool);
  }

  @VisibleForTesting
  synchronized int size() {
    return pools.size();
  }

  private void reportChannelCounts(ObservableLongMeasurement measurement) {
    List<GcpManagedChannel> snapshot;
    synchronized (this) {
      snapshot = new ArrayList<>(pools);
    }
    Map<Attributes, Long> totals = new HashMap<>();
    for (GcpManagedChannel pool : snapshot) {
      pool.addBuiltInChannelCounts(totals);
    }
    totals.forEach((attributes, count) -> measurement.record(count, attributes));
  }
}

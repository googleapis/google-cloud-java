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
 * Process-wide singleton reader of built-in channel pool metrics for a {@link Meter}. All channel
 * pools configured with that meter register with this shared instance (retrieved via {@link
 * #forMeter(Meter)}).
 *
 * <p>Whenever metrics are collected, a single callback samples the current sizes of the active and
 * draining channel lists across all registered pools. Channel counts from pools with identical
 * attributes are summed together so they do not overwrite each other. Reading the live collections
 * directly on each export—rather than maintaining an incremental running counter—guarantees that
 * reported counts never desynchronize from the actual number of channels.
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
   * Returns a process-unique pool index: sequentially from "1" to "10", and "other" thereafter.
   *
   * <p>Indices are never reused. Capping the index bounds metric cardinality in Cloud Monitoring
   * when applications create multiple channel pools.
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
      if (pool != null) {
        pool.addBuiltInChannelCounts(totals);
      }
    }
    totals.forEach((attributes, count) -> measurement.record(count, attributes));
  }
}

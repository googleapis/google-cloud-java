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
import com.google.common.base.Ticker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/** Shared process-local latency scores for routed Spanner endpoints. */
final class EndpointLatencyRegistry {
  private static final String GLOBAL_SCOPE = "__global__";

  static final Duration DEFAULT_ERROR_PENALTY = Duration.ofSeconds(10);
  static final Duration DEFAULT_RTT = Duration.ofMillis(10);
  static final double DEFAULT_PENALTY_VALUE = 1_000_000.0;
  @VisibleForTesting static final Duration TRACKER_EXPIRE_AFTER_ACCESS = Duration.ofMinutes(10);
  @VisibleForTesting static final long MAX_TRACKERS = 100_000L;

  private static volatile Cache<TrackerKey, LatencyTracker> TRACKERS =
      newTrackerCache(Ticker.systemTicker());
  private static final ConcurrentHashMap<String, AtomicInteger> INFLIGHT_REQUESTS =
      new ConcurrentHashMap<>();

  private EndpointLatencyRegistry() {}

  static boolean hasScore(
      @javax.annotation.Nullable String databaseScope,
      long operationUid,
      String endpointLabelOrAddress) {
    TrackerKey trackerKey = trackerKey(databaseScope, operationUid, endpointLabelOrAddress);
    return trackerKey != null && TRACKERS.getIfPresent(trackerKey) != null;
  }

  static double getSelectionCost(
      @javax.annotation.Nullable String databaseScope,
      long operationUid,
      String endpointLabelOrAddress) {
    TrackerKey trackerKey = trackerKey(databaseScope, operationUid, endpointLabelOrAddress);
    if (trackerKey == null) {
      return Double.MAX_VALUE;
    }
    double activeRequests = getInflight(endpointLabelOrAddress);
    LatencyTracker tracker = TRACKERS.getIfPresent(trackerKey);
    if (tracker != null) {
      return tracker.getScore() * (activeRequests + 1.0);
    }
    if (activeRequests > 0.0) {
      return DEFAULT_PENALTY_VALUE + activeRequests;
    }
    return defaultRttMicros() * (activeRequests + 1.0);
  }

  static void recordLatency(
      @javax.annotation.Nullable String databaseScope,
      long operationUid,
      String endpointLabelOrAddress,
      Duration latency) {
    TrackerKey trackerKey = trackerKey(databaseScope, operationUid, endpointLabelOrAddress);
    if (trackerKey == null || latency == null) {
      return;
    }
    getOrCreateTracker(trackerKey).update(latency);
  }

  static void recordError(
      @javax.annotation.Nullable String databaseScope,
      long operationUid,
      String endpointLabelOrAddress) {
    recordError(databaseScope, operationUid, endpointLabelOrAddress, DEFAULT_ERROR_PENALTY);
  }

  static void recordError(
      @javax.annotation.Nullable String databaseScope,
      long operationUid,
      String endpointLabelOrAddress,
      Duration penalty) {
    TrackerKey trackerKey = trackerKey(databaseScope, operationUid, endpointLabelOrAddress);
    if (trackerKey == null || penalty == null) {
      return;
    }
    getOrCreateTracker(trackerKey).recordError(penalty);
  }

  static void beginRequest(String endpointLabelOrAddress) {
    String address = normalizeAddress(endpointLabelOrAddress);
    if (address == null) {
      return;
    }
    INFLIGHT_REQUESTS.computeIfAbsent(address, ignored -> new AtomicInteger()).incrementAndGet();
  }

  static void finishRequest(String endpointLabelOrAddress) {
    String address = normalizeAddress(endpointLabelOrAddress);
    if (address == null) {
      return;
    }
    AtomicInteger counter = INFLIGHT_REQUESTS.get(address);
    if (counter == null) {
      return;
    }
    counter.updateAndGet(current -> current > 0 ? current - 1 : 0);
  }

  static int getInflight(String endpointLabelOrAddress) {
    String address = normalizeAddress(endpointLabelOrAddress);
    if (address == null) {
      return 0;
    }
    AtomicInteger counter = INFLIGHT_REQUESTS.get(address);
    return counter == null ? 0 : Math.max(0, counter.get());
  }

  @VisibleForTesting
  static void clear() {
    TRACKERS.invalidateAll();
    INFLIGHT_REQUESTS.clear();
  }

  @VisibleForTesting
  static void useTrackerTicker(Ticker ticker) {
    TRACKERS = newTrackerCache(ticker);
  }

  @VisibleForTesting
  static String normalizeAddress(String endpointLabelOrAddress) {
    if (endpointLabelOrAddress == null || endpointLabelOrAddress.isEmpty()) {
      return null;
    }
    return endpointLabelOrAddress;
  }

  @VisibleForTesting
  static TrackerKey trackerKey(
      @javax.annotation.Nullable String databaseScope,
      long operationUid,
      String endpointLabelOrAddress) {
    String address = normalizeAddress(endpointLabelOrAddress);
    if (operationUid <= 0 || address == null) {
      return null;
    }
    return new TrackerKey(normalizeScope(databaseScope), operationUid, address);
  }

  private static long defaultRttMicros() {
    return DEFAULT_RTT.toNanos() / 1_000L;
  }

  private static String normalizeScope(@javax.annotation.Nullable String databaseScope) {
    return (databaseScope == null || databaseScope.isEmpty()) ? GLOBAL_SCOPE : databaseScope;
  }

  private static LatencyTracker getOrCreateTracker(TrackerKey trackerKey) {
    try {
      return TRACKERS.get(trackerKey, EwmaLatencyTracker::new);
    } catch (ExecutionException e) {
      throw new IllegalStateException("Failed to create latency tracker", e);
    }
  }

  private static Cache<TrackerKey, LatencyTracker> newTrackerCache(Ticker ticker) {
    return CacheBuilder.newBuilder()
        .maximumSize(MAX_TRACKERS)
        .expireAfterAccess(TRACKER_EXPIRE_AFTER_ACCESS.toNanos(), TimeUnit.NANOSECONDS)
        .ticker(ticker)
        .build();
  }

  @VisibleForTesting
  static final class TrackerKey {
    private final String databaseScope;
    private final long operationUid;
    private final String address;

    private TrackerKey(String databaseScope, long operationUid, String address) {
      this.databaseScope = databaseScope;
      this.operationUid = operationUid;
      this.address = address;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) {
        return true;
      }
      if (!(other instanceof TrackerKey)) {
        return false;
      }
      TrackerKey that = (TrackerKey) other;
      return operationUid == that.operationUid
          && Objects.equals(databaseScope, that.databaseScope)
          && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
      return Objects.hash(databaseScope, operationUid, address);
    }

    @Override
    public String toString() {
      return databaseScope + ":" + operationUid + "@" + address;
    }
  }
}

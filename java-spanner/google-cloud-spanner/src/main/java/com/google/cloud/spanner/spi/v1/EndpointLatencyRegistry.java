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
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/** Shared process-local latency scores for routed Spanner endpoints. */
final class EndpointLatencyRegistry {

  static final Duration DEFAULT_ERROR_PENALTY = Duration.ofSeconds(10);
  static final Duration DEFAULT_RTT = Duration.ofMillis(10);
  static final double DEFAULT_PENALTY_VALUE = 1_000_000.0;

  private static final ConcurrentHashMap<TrackerKey, LatencyTracker> TRACKERS =
      new ConcurrentHashMap<>();
  private static final ConcurrentHashMap<String, AtomicInteger> INFLIGHT_REQUESTS =
      new ConcurrentHashMap<>();

  private EndpointLatencyRegistry() {}

  static boolean hasScore(long operationUid, String endpointLabelOrAddress) {
    TrackerKey trackerKey = trackerKey(operationUid, endpointLabelOrAddress);
    return trackerKey != null && TRACKERS.containsKey(trackerKey);
  }

  static double getSelectionCost(long operationUid, String endpointLabelOrAddress) {
    TrackerKey trackerKey = trackerKey(operationUid, endpointLabelOrAddress);
    if (trackerKey == null) {
      return Double.MAX_VALUE;
    }
    double activeRequests = getInflight(endpointLabelOrAddress);
    LatencyTracker tracker = TRACKERS.get(trackerKey);
    if (tracker != null) {
      return tracker.getScore() * (activeRequests + 1.0);
    }
    if (activeRequests > 0.0) {
      return DEFAULT_PENALTY_VALUE + activeRequests;
    }
    return defaultRttMicros() * (activeRequests + 1.0);
  }

  static void recordLatency(long operationUid, String endpointLabelOrAddress, Duration latency) {
    TrackerKey trackerKey = trackerKey(operationUid, endpointLabelOrAddress);
    if (trackerKey == null || latency == null) {
      return;
    }
    TRACKERS.computeIfAbsent(trackerKey, ignored -> new EwmaLatencyTracker()).update(latency);
  }

  static void recordError(long operationUid, String endpointLabelOrAddress) {
    recordError(operationUid, endpointLabelOrAddress, DEFAULT_ERROR_PENALTY);
  }

  static void recordError(long operationUid, String endpointLabelOrAddress, Duration penalty) {
    TrackerKey trackerKey = trackerKey(operationUid, endpointLabelOrAddress);
    if (trackerKey == null || penalty == null) {
      return;
    }
    TRACKERS.computeIfAbsent(trackerKey, ignored -> new EwmaLatencyTracker()).recordError(penalty);
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
    int updated = counter.decrementAndGet();
    if (updated <= 0) {
      INFLIGHT_REQUESTS.remove(address, counter);
    }
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
    TRACKERS.clear();
    INFLIGHT_REQUESTS.clear();
  }

  @VisibleForTesting
  static String normalizeAddress(String endpointLabelOrAddress) {
    if (endpointLabelOrAddress == null || endpointLabelOrAddress.isEmpty()) {
      return null;
    }
    return endpointLabelOrAddress;
  }

  @VisibleForTesting
  static TrackerKey trackerKey(long operationUid, String endpointLabelOrAddress) {
    String address = normalizeAddress(endpointLabelOrAddress);
    if (operationUid <= 0 || address == null) {
      return null;
    }
    return new TrackerKey(operationUid, address);
  }

  private static long defaultRttMicros() {
    return DEFAULT_RTT.toNanos() / 1_000L;
  }

  @VisibleForTesting
  static final class TrackerKey {
    private final long operationUid;
    private final String address;

    private TrackerKey(long operationUid, String address) {
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
      return operationUid == that.operationUid && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
      return Objects.hash(operationUid, address);
    }

    @Override
    public String toString() {
      return operationUid + "@" + address;
    }
  }
}

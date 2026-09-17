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

import com.google.cloud.spanner.XGoogSpannerRequestId;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/**
 * Associates an in-flight request with the endpoint that location-aware routing selected for it, so
 * that {@link HeaderInterceptor} can attribute the observed latency back to that endpoint.
 *
 * <p>Entries are keyed by {@link XGoogSpannerRequestId#getLogicalRequestKey()}, which is stable
 * across all attempts of the same logical RPC. Callers pass that key directly rather than the
 * {@code x-goog-spanner-request-id} header value: every call site either holds the parsed {@link
 * XGoogSpannerRequestId} (it is carried in the gRPC {@code CallOptions}) or has already derived the
 * key from it, so re-parsing the header string here would be pure overhead on the per-RPC path.
 */
final class RequestIdTargetTracker {
  @VisibleForTesting static final long MAX_TRACKED_TARGETS = 1_000_000L;

  @VisibleForTesting
  static final int TARGET_CACHE_CONCURRENCY =
      Math.max(4, Runtime.getRuntime().availableProcessors());

  private static final Cache<String, RoutingTarget> TARGETS =
      CacheBuilder.newBuilder()
          .concurrencyLevel(TARGET_CACHE_CONCURRENCY)
          .maximumSize(MAX_TRACKED_TARGETS)
          .expireAfterWrite(10, TimeUnit.MINUTES)
          .build();

  /**
   * Whether a routing target has ever been recorded. Location-aware routing is the only producer of
   * entries and is disabled unless the instance type is {@code OMNI}, so for most clients this
   * cache stays empty for the lifetime of the process. Checking this flag first lets the per-RPC
   * lookup and removal return immediately instead of probing the cache.
   *
   * <p>The flag only ever transitions from {@code false} to {@code true}, and every RPC reads it
   * from whichever thread it happens to run on. It is therefore written only when it is not already
   * set, so that recording a target does not repeatedly invalidate the cache line that all those
   * readers share. Visibility of the entries themselves does not depend on this flag; {@link Cache}
   * provides its own guarantees.
   */
  private static volatile boolean tracking;

  private RequestIdTargetTracker() {}

  static void record(
      @Nullable String logicalRequestKey,
      @Nullable String databaseScope,
      @Nullable String targetEndpoint,
      long operationUid,
      boolean preferLeader) {
    if (logicalRequestKey == null
        || logicalRequestKey.isEmpty()
        || targetEndpoint == null
        || targetEndpoint.isEmpty()) {
      return;
    }
    TARGETS.put(
        logicalRequestKey,
        new RoutingTarget(databaseScope, targetEndpoint, operationUid, preferLeader));
    if (!tracking) {
      tracking = true;
    }
  }

  @Nullable
  static RoutingTarget get(@Nullable XGoogSpannerRequestId requestId) {
    String logicalRequestKey = trackingKey(requestId);
    return logicalRequestKey == null ? null : TARGETS.getIfPresent(logicalRequestKey);
  }

  static void remove(@Nullable XGoogSpannerRequestId requestId) {
    removeLogicalKey(trackingKey(requestId));
  }

  static void removeLogicalKey(@Nullable String logicalRequestKey) {
    if (!tracking || logicalRequestKey == null || logicalRequestKey.isEmpty()) {
      return;
    }
    TARGETS.invalidate(logicalRequestKey);
  }

  /**
   * Returns the cache key for {@code requestId}, or {@code null} if the key cannot be derived or
   * nothing is being tracked. Deriving the key allocates a string, so it is skipped entirely while
   * the cache is known to be empty.
   */
  @Nullable
  private static String trackingKey(@Nullable XGoogSpannerRequestId requestId) {
    return tracking && requestId != null ? requestId.getLogicalRequestKey() : null;
  }

  @VisibleForTesting
  static boolean isTracking() {
    return tracking;
  }

  @VisibleForTesting
  static void clear() {
    TARGETS.invalidateAll();
    tracking = false;
  }

  static final class RoutingTarget {
    @Nullable final String databaseScope;
    final String targetEndpoint;
    final long operationUid;
    final boolean preferLeader;

    private RoutingTarget(
        @Nullable String databaseScope,
        String targetEndpoint,
        long operationUid,
        boolean preferLeader) {
      this.databaseScope = databaseScope;
      this.targetEndpoint = targetEndpoint;
      this.operationUid = operationUid;
      this.preferLeader = preferLeader;
    }
  }
}

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

  private RequestIdTargetTracker() {}

  static void record(
      String requestId,
      @Nullable String databaseScope,
      String targetEndpoint,
      long operationUid,
      boolean preferLeader) {
    String trackingKey = normalizeRequestKey(requestId);
    if (trackingKey == null || targetEndpoint == null || targetEndpoint.isEmpty()) {
      return;
    }
    TARGETS.put(
        trackingKey, new RoutingTarget(databaseScope, targetEndpoint, operationUid, preferLeader));
  }

  @Nullable
  static RoutingTarget get(String requestId) {
    String trackingKey = normalizeRequestKey(requestId);
    if (trackingKey == null) {
      return null;
    }
    return TARGETS.getIfPresent(trackingKey);
  }

  static void remove(String requestId) {
    String trackingKey = normalizeRequestKey(requestId);
    if (trackingKey == null) {
      return;
    }
    TARGETS.invalidate(trackingKey);
  }

  @VisibleForTesting
  static void clear() {
    TARGETS.invalidateAll();
  }

  @VisibleForTesting
  static String normalizeRequestKey(String requestId) {
    if (requestId == null || requestId.isEmpty()) {
      return null;
    }
    try {
      return XGoogSpannerRequestId.of(requestId).getLogicalRequestKey();
    } catch (IllegalStateException e) {
      return requestId;
    }
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

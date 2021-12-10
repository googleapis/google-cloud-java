/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import com.google.api.core.BetaApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import io.opencensus.stats.Stats;
import io.opencensus.stats.View;
import io.opencensus.stats.ViewManager;

@BetaApi
public class RpcViews {
  @VisibleForTesting
  private static final ImmutableSet<View> BIGTABLE_CLIENT_VIEWS_SET =
      ImmutableSet.of(
          RpcViewConstants.BIGTABLE_OP_LATENCY_VIEW,
          RpcViewConstants.BIGTABLE_COMPLETED_OP_VIEW,
          RpcViewConstants.BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY_VIEW,
          RpcViewConstants.BIGTABLE_ATTEMPT_LATENCY_VIEW,
          RpcViewConstants.BIGTABLE_ATTEMPTS_PER_OP_VIEW,
          RpcViewConstants.BIGTABLE_BATCH_THROTTLED_TIME_VIEW);

  private static final ImmutableSet<View> GFE_VIEW_SET =
      ImmutableSet.of(
          RpcViewConstants.BIGTABLE_GFE_LATENCY_VIEW,
          RpcViewConstants.BIGTABLE_GFE_HEADER_MISSING_COUNT_VIEW);

  private static boolean gfeMetricsRegistered = false;

  /** Registers all Bigtable specific views. */
  public static void registerBigtableClientViews() {
    registerBigtableClientViews(Stats.getViewManager());
  }

  /**
   * Register views for GFE metrics, including gfe_latency and gfe_header_missing_count. gfe_latency
   * measures the latency between Google's network receives an RPC and reads back the first byte of
   * the response. gfe_header_missing_count is a counter of the number of RPC responses without a
   * server-timing header.
   */
  public static void registerBigtableClientGfeViews() {
    registerBigtableClientGfeViews(Stats.getViewManager());
  }

  @VisibleForTesting
  static void registerBigtableClientViews(ViewManager viewManager) {
    for (View view : BIGTABLE_CLIENT_VIEWS_SET) {
      viewManager.registerView(view);
    }
  }

  @VisibleForTesting
  static void registerBigtableClientGfeViews(ViewManager viewManager) {
    for (View view : GFE_VIEW_SET) {
      viewManager.registerView(view);
    }
    gfeMetricsRegistered = true;
  }

  static boolean isGfeMetricsRegistered() {
    return gfeMetricsRegistered;
  }

  @VisibleForTesting
  static void setGfeMetricsRegistered(boolean gfeMetricsRegistered) {
    RpcViews.gfeMetricsRegistered = gfeMetricsRegistered;
  }
}

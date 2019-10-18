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
  static final ImmutableSet<View> BIGTABLE_CLIENT_VIEWS_SET =
      ImmutableSet.of(
          RpcViewConstants.BIGTABLE_OP_LATENCY_VIEW,
          RpcViewConstants.BIGTABLE_CLIENT_COMPLETED_OP_VIEW,
          RpcViewConstants.BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY_VIEW,
          RpcViewConstants.BIGTABLE_ROWS_READ_PER_OP_VIEW,
          RpcViewConstants.BIGTABLE_MUTATE_ROWS_ENTRIES_PER_BATCH_VIEW);

  /**
   * Registers all Bigtable specific views.
   *
   * <p>It is recommended to call this method and {@link
   * io.opencensus.contrib.grpc.metrics.RpcViews#registerClientGrpcViews()} before doing any RPC
   * call to avoid missing stats.
   */
  public static void registerBigtableClientViews() {
    registerBigtableClientViews(Stats.getViewManager());
  }

  @VisibleForTesting
  static void registerBigtableClientViews(ViewManager viewManager) {
    for (View view : BIGTABLE_CLIENT_VIEWS_SET) {
      viewManager.registerView(view);
    }
  }
}

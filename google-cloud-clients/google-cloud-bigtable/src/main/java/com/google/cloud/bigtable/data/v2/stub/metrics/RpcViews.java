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
          RpcViewConstants.BIGTABLE_OP_ROUNDTRIP_LATENCY_VIEW,
          RpcViewConstants.BIGTABLE_CLIENT_COMPLETED_OP_VIEW,
          RpcViewConstants.BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY_VIEW,
          RpcViewConstants.BIGTABLE_ROWS_READ_PER_OP_VIEW,
          RpcViewConstants.BIGTABLE_MUTATE_ROWS_ENTRIES_PER_BATCH_VIEW
      );

  /**
   * Registers all Bigtable specific views.
   *
   * <p>It is recommended to call this method and
   * {@link io.opencensus.contrib.grpc.metrics.RpcViews#registerClientGrpcViews()} before doing any
   * RPC call to avoid missing stats.
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

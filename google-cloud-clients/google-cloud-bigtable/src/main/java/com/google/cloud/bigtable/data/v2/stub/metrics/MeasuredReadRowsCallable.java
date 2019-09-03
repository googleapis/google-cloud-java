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

import com.google.api.core.ApiClock;
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.common.base.Preconditions;
import io.opencensus.stats.MeasureMap;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.TagContext;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * This callable will instrument ReadRows invocations using Opencensus stats.
 *
 * <p>Recorded stats:
 *
 * <dl>
 *   <dt>{@link RpcMeasureConstants#BIGTABLE_OP_LATENCY}
 *   <dd>the total time it took the operation across all of its retry attempts to complete.
 *   <dt>{@link RpcMeasureConstants#BIGTABLE_ROWS_READ_PER_OP}
 *   <dd>the number of rows received across all of the retries for each invocation.
 *   <dt>{@link RpcMeasureConstants#BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY}
 *   <dd>the amount of time it took the caller to receive the first row.
 * </dl>
 *
 * <p>For internal use only.
 */
@InternalApi
public class MeasuredReadRowsCallable<RowT> extends ServerStreamingCallable<Query, RowT> {
  private final ServerStreamingCallable<Query, RowT> innerCallable;

  private final TagValue methodName;
  private final TagContext parentCtx;

  private final Tagger tagger;
  private final StatsRecorder stats;
  private final ApiClock clock;

  public MeasuredReadRowsCallable(
      @Nonnull ServerStreamingCallable<Query, RowT> innerCallable,
      @Nonnull String methodName,
      @Nonnull Tagger tagger,
      @Nonnull StatsRecorder stats,
      @Nonnull ApiClock clock) {
    this.innerCallable = Preconditions.checkNotNull(innerCallable, "innerCallable");
    this.methodName = TagValue.create(Preconditions.checkNotNull(methodName, "methodName"));
    this.tagger = Preconditions.checkNotNull(tagger, "tagger");
    this.parentCtx = tagger.getCurrentTagContext();
    this.stats = Preconditions.checkNotNull(stats, "stats");
    this.clock = Preconditions.checkNotNull(clock, "clock");
  }

  @Override
  public void call(Query request, ResponseObserver<RowT> outerObserver, ApiCallContext context) {
    innerCallable.call(request, new MeasuredResponseObserver(outerObserver), context);
  }

  private class MeasuredResponseObserver implements ResponseObserver<RowT> {
    private final ResponseObserver<RowT> outerResponseObserver;

    private final long operationStart;
    private Long firstRowReceivedAt = null;
    private long rowsRead = 0;

    private MeasuredResponseObserver(@Nonnull ResponseObserver<RowT> outerResponseObserver) {
      this.outerResponseObserver =
          Preconditions.checkNotNull(outerResponseObserver, "outerResponseObserver");
      this.operationStart = clock.nanoTime();
    }

    @Override
    public void onStart(StreamController controller) {
      outerResponseObserver.onStart(controller);
    }

    @Override
    public void onResponse(RowT row) {
      if (firstRowReceivedAt == null) {
        firstRowReceivedAt = clock.nanoTime();
      }
      rowsRead++;
      outerResponseObserver.onResponse(row);
    }

    @Override
    public void onError(Throwable t) {
      recordStats(t);
      outerResponseObserver.onError(t);
    }

    @Override
    public void onComplete() {
      recordStats(null);
      outerResponseObserver.onComplete();
    }

    private void recordStats(@Nullable Throwable error) {
      long now = clock.nanoTime();
      long elapsed = TimeUnit.NANOSECONDS.toMillis(now - operationStart);

      MeasureMap measures =
          stats
              .newMeasureMap()
              .put(RpcMeasureConstants.BIGTABLE_OP_LATENCY, elapsed)
              .put(RpcMeasureConstants.BIGTABLE_ROWS_READ_PER_OP, rowsRead);

      if (firstRowReceivedAt != null) {
        long firstRowLatency = TimeUnit.NANOSECONDS.toMillis(firstRowReceivedAt - operationStart);
        measures.put(RpcMeasureConstants.BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY, firstRowLatency);
      }

      measures.record(
          tagger
              .toBuilder(parentCtx)
              .putLocal(RpcMeasureConstants.BIGTABLE_OP, methodName)
              .putLocal(RpcMeasureConstants.BIGTABLE_STATUS, Util.extractStatus(error))
              .build());
    }
  }
}

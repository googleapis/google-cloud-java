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
import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.common.util.concurrent.MoreExecutors;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.TagContext;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@InternalApi
public class MeasuredMutateRowsCallable extends UnaryCallable<MutateRowsRequest, Void> {
  private final UnaryCallable<MutateRowsRequest, Void> innerCallable;
  private final TagValue methodName;
  private final TagContext parentCtx;
  private final Tagger tagger;
  private final StatsRecorder stats;
  private final ApiClock clock;

  @InternalApi
  public MeasuredMutateRowsCallable(
      UnaryCallable<MutateRowsRequest, Void> innerCallable,
      String methodName,
      Tagger tagger, StatsRecorder stats, ApiClock clock) {
    this.innerCallable = innerCallable;
    this.methodName = TagValue.create(methodName);
    this.parentCtx = tagger.getCurrentTagContext();
    this.tagger = tagger;
    this.stats = stats;
    this.clock = clock;
  }

  @Override
  public ApiFuture<Void> futureCall(final MutateRowsRequest request, ApiCallContext context) {
    final ApiFuture<Void> future = innerCallable.futureCall(request, context);
    future.addListener(new StatsRecordingRunnable(future, request.getEntriesCount()), MoreExecutors.directExecutor());
    return future;
  }

  private class StatsRecordingRunnable implements Runnable {
    private final Future<?> operationFuture;
    private final long numEntries;
    private final long operationStart;

    private StatsRecordingRunnable(Future<?> operationFuture, long numEntries) {
      this.operationFuture = operationFuture;
      this.numEntries = numEntries;
      this.operationStart = clock.nanoTime();
    }

    @Override
    public void run() {
      long elapsed = TimeUnit.NANOSECONDS.toMillis(clock.nanoTime() - operationStart);

      stats.newMeasureMap()
          .put(RpcMeasureConstants.BIGTABLE_OP_ROUNDTRIP_LATENCY, elapsed)
          .put(RpcMeasureConstants.BIGTABLE_MUTATE_ROWS_ENTRIES_PER_BATCH, numEntries)
          .record(
              tagger.toBuilder(parentCtx)
                  .putLocal(RpcMeasureConstants.BIGTABLE_OP, methodName)
                  .putLocal(RpcMeasureConstants.BIGTABLE_STATUS, Util.extractStatus(operationFuture))
                  .build()
          );
    }
  }
}

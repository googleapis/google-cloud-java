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
import io.opencensus.stats.MeasureMap;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.TagContext;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@InternalApi
public class MeasuredReadRowsCallable<RequestT, RowT> extends ServerStreamingCallable<RequestT, RowT> {
  private final ServerStreamingCallable<RequestT, RowT> innerCallable;

  private final TagValue methodName;
  private final TagContext parentCtx;

  private final Tagger tagger;
  private final StatsRecorder stats;
  private final ApiClock clock;

  public MeasuredReadRowsCallable(
      ServerStreamingCallable<RequestT, RowT> innerCallable, String methodName,
      Tagger tagger, StatsRecorder stats, ApiClock clock) {
    this.innerCallable = innerCallable;
    this.methodName = TagValue.create(methodName);
    this.parentCtx = tagger.getCurrentTagContext();
    this.tagger = tagger;
    this.stats = stats;
    this.clock = clock;
  }

  @Override
  public void call(RequestT request, ResponseObserver<RowT> outerObserver, ApiCallContext context) {
    innerCallable.call(request, new MeasuredResponseObserver(outerObserver), context);
  }

  private class MeasuredResponseObserver implements ResponseObserver<RowT> {
    private final ResponseObserver<RowT> outerResponseObserver;

    private final long operationStart;
    private Long firstRowReceivedAt = null;
    private long rowsRead = 0;

    private MeasuredResponseObserver(
        ResponseObserver<RowT> outerResponseObserver) {
      this.outerResponseObserver = outerResponseObserver;
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

      MeasureMap measures = stats.newMeasureMap()
          .put(RpcMeasureConstants.BIGTABLE_OP_ROUNDTRIP_LATENCY, elapsed)
          .put(RpcMeasureConstants.BIGTABLE_ROWS_READ_PER_OP, rowsRead);

      if (firstRowReceivedAt != null) {
        long firstRowLatency = TimeUnit.NANOSECONDS.toMillis(now - firstRowReceivedAt);
        measures.put(RpcMeasureConstants.BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY, firstRowLatency);
      }

      measures.record(
          tagger.toBuilder(parentCtx)
              .putLocal(RpcMeasureConstants.BIGTABLE_OP, methodName)
              .putLocal(RpcMeasureConstants.BIGTABLE_STATUS, Util.extractStatus(error))
              .build()
      );
    }
  }
}

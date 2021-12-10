/*
 * Copyright 2020 Google LLC
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

import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.api.gax.tracing.SpanName;
import com.google.common.base.Stopwatch;
import io.opencensus.stats.MeasureMap;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.TagContext;
import io.opencensus.tags.TagContextBuilder;
import io.opencensus.tags.TagKey;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

class MetricsTracer extends BigtableTracer {

  private final OperationType operationType;

  private final Tagger tagger;
  private final StatsRecorder stats;

  // Tags
  private final TagContext parentContext;
  private final SpanName spanName;
  private final Map<TagKey, TagValue> statsAttributes;

  // Operation level metrics
  private final AtomicBoolean opFinished = new AtomicBoolean();
  private final Stopwatch operationTimer = Stopwatch.createStarted();
  private final Stopwatch firstResponsePerOpTimer = Stopwatch.createStarted();
  private long operationResponseCount = 0;

  // Attempt level metrics
  private int attemptCount = 0;
  private Stopwatch attemptTimer;
  private long attemptResponseCount = 0;

  private volatile int attempt = 0;

  MetricsTracer(
      OperationType operationType,
      Tagger tagger,
      StatsRecorder stats,
      SpanName spanName,
      Map<TagKey, TagValue> statsAttributes) {
    this.operationType = operationType;
    this.tagger = tagger;
    this.stats = stats;
    this.parentContext = tagger.getCurrentTagContext();
    this.spanName = spanName;
    this.statsAttributes = statsAttributes;
  }

  @Override
  public Scope inScope() {
    return new Scope() {
      @Override
      public void close() {}
    };
  }

  @Override
  public void operationSucceeded() {
    recordOperationCompletion(null);
  }

  @Override
  public void operationCancelled() {
    recordOperationCompletion(new CancellationException());
  }

  @Override
  public void operationFailed(Throwable throwable) {
    recordOperationCompletion(throwable);
  }

  private void recordOperationCompletion(@Nullable Throwable throwable) {
    if (!opFinished.compareAndSet(false, true)) {
      return;
    }
    operationTimer.stop();

    long elapsed = operationTimer.elapsed(TimeUnit.MILLISECONDS);

    MeasureMap measures =
        stats
            .newMeasureMap()
            .put(RpcMeasureConstants.BIGTABLE_OP_LATENCY, elapsed)
            .put(RpcMeasureConstants.BIGTABLE_OP_ATTEMPT_COUNT, attemptCount);

    if (operationType == OperationType.ServerStreaming
        && spanName.getMethodName().equals("ReadRows")) {
      measures.put(
          RpcMeasureConstants.BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY,
          firstResponsePerOpTimer.elapsed(TimeUnit.MILLISECONDS));
    }

    TagContextBuilder tagCtx =
        newTagCtxBuilder()
            .putLocal(RpcMeasureConstants.BIGTABLE_STATUS, Util.extractStatus(throwable));

    measures.record(tagCtx.build());
  }

  @Override
  public void connectionSelected(String s) {
    // noop: cardinality for connection ids is too high to use as tags
  }

  @Override
  public void attemptStarted(int attemptNumber) {
    attempt = attemptNumber;
    attemptCount++;
    attemptTimer = Stopwatch.createStarted();
    attemptResponseCount = 0;
  }

  @Override
  public void attemptSucceeded() {
    recordAttemptCompletion(null);
  }

  @Override
  public void attemptCancelled() {
    recordAttemptCompletion(new CancellationException());
  }

  @Override
  public void attemptFailed(Throwable throwable, Duration duration) {
    recordAttemptCompletion(throwable);
  }

  @Override
  public void attemptFailedRetriesExhausted(Throwable throwable) {
    recordAttemptCompletion(throwable);
  }

  @Override
  public void attemptPermanentFailure(Throwable throwable) {
    recordAttemptCompletion(throwable);
  }

  private void recordAttemptCompletion(@Nullable Throwable throwable) {
    MeasureMap measures =
        stats
            .newMeasureMap()
            .put(
                RpcMeasureConstants.BIGTABLE_ATTEMPT_LATENCY,
                attemptTimer.elapsed(TimeUnit.MILLISECONDS));

    TagContextBuilder tagCtx =
        newTagCtxBuilder()
            .putLocal(RpcMeasureConstants.BIGTABLE_STATUS, Util.extractStatus(throwable));

    measures.record(tagCtx.build());
  }

  @Override
  public void lroStartFailed(Throwable throwable) {
    // noop
  }

  @Override
  public void lroStartSucceeded() {
    // noop
  }

  @Override
  public void responseReceived() {
    if (firstResponsePerOpTimer.isRunning()) {
      firstResponsePerOpTimer.stop();
    }
    attemptResponseCount++;
    operationResponseCount++;
  }

  @Override
  public void requestSent() {
    // noop: no operations are client streaming
  }

  @Override
  public void batchRequestSent(long elementCount, long requestSize) {
    // noop
  }

  @Override
  public int getAttempt() {
    return attempt;
  }

  @Override
  public void recordGfeMetadata(@Nullable Long latency, @Nullable Throwable throwable) {
    MeasureMap measures = stats.newMeasureMap();
    if (latency != null) {
      measures
          .put(RpcMeasureConstants.BIGTABLE_GFE_LATENCY, latency)
          .put(RpcMeasureConstants.BIGTABLE_GFE_HEADER_MISSING_COUNT, 0L);
    } else {
      measures.put(RpcMeasureConstants.BIGTABLE_GFE_HEADER_MISSING_COUNT, 1L);
    }
    measures.record(
        newTagCtxBuilder()
            .putLocal(RpcMeasureConstants.BIGTABLE_STATUS, Util.extractStatus(throwable))
            .build());
  }

  @Override
  public void batchRequestThrottled(long totalThrottledMs) {
    MeasureMap measures =
        stats
            .newMeasureMap()
            .put(RpcMeasureConstants.BIGTABLE_BATCH_THROTTLED_TIME, totalThrottledMs);
    measures.record(newTagCtxBuilder().build());
  }

  private TagContextBuilder newTagCtxBuilder() {
    TagContextBuilder tagCtx =
        tagger
            .toBuilder(parentContext)
            .putLocal(RpcMeasureConstants.BIGTABLE_OP, TagValue.create(spanName.toString()));

    // Copy client level tags in
    for (Entry<TagKey, TagValue> entry : statsAttributes.entrySet()) {
      tagCtx.putLocal(entry.getKey(), entry.getValue());
    }

    return tagCtx;
  }
}

/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.tracing;

import static com.google.api.gax.tracing.ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE;

import com.google.api.gax.rpc.StatusCode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * This class computes golden signal metrics that can be observed in the lifecycle of an RPC
 * operation. The responsibility of recording metrics should delegate to {@link
 * GoldenSignalsMetricsRecorder}, hence this class should not have any knowledge about the
 * observability framework (e.g. OpenTelemetry).
 */
class GoldenSignalsMetricsTracer implements ApiTracer {
  private final Stopwatch clientRequestTimer;
  private final GoldenSignalsMetricsRecorder metricsRecorder;
  private final Map<String, Object> attributes;

  GoldenSignalsMetricsTracer(
      GoldenSignalsMetricsRecorder metricsRecorder, ApiTracerContext apiTracerContext) {
    this.clientRequestTimer = Stopwatch.createStarted();
    this.metricsRecorder = metricsRecorder;
    this.attributes = apiTracerContext.getMetricsAttributes();
  }

  @VisibleForTesting
  GoldenSignalsMetricsTracer(
      GoldenSignalsMetricsRecorder metricsRecorder,
      ApiTracerContext apiTracerContext,
      Ticker ticker) {
    this.clientRequestTimer = Stopwatch.createStarted(ticker);
    this.metricsRecorder = metricsRecorder;
    this.attributes = new HashMap<>(apiTracerContext.getMetricsAttributes());
  }

  /**
   * The concept of "operation" and "client request" are the same. They both represent the total
   * time taken for a logical client request, including any retries, backoff, and
   * pre/post-processing
   */
  @Override
  public void operationSucceeded() {
    attributes.put(RPC_RESPONSE_STATUS_ATTRIBUTE, StatusCode.Code.OK.toString());
    metricsRecorder.recordOperationLatency(
        clientRequestTimer.elapsed(TimeUnit.NANOSECONDS) / 1_000_000_000.0, attributes);
  }

  @Override
  public void operationCancelled() {
    attributes.put(RPC_RESPONSE_STATUS_ATTRIBUTE, StatusCode.Code.CANCELLED.toString());
    metricsRecorder.recordOperationLatency(
        clientRequestTimer.elapsed(TimeUnit.NANOSECONDS) / 1_000_000_000.0, attributes);
  }

  @Override
  public void operationFailed(Throwable error) {
    attributes.put(RPC_RESPONSE_STATUS_ATTRIBUTE, ObservabilityUtils.extractStatus(error));
    metricsRecorder.recordOperationLatency(
        clientRequestTimer.elapsed(TimeUnit.NANOSECONDS) / 1_000_000_000.0, attributes);
  }
}

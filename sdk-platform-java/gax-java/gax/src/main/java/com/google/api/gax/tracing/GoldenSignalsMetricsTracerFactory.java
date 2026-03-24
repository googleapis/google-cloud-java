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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import io.opentelemetry.api.OpenTelemetry;

/**
 * A {@link ApiTracerFactory} to build instances of {@link GoldenSignalsMetricsTracer}.
 *
 * <p>This class is expected to be initialized once during client initialization.
 */
@BetaApi
@InternalApi
public class GoldenSignalsMetricsTracerFactory implements ApiTracerFactory {

  private ApiTracerContext clientLevelTracerContext;
  private final OpenTelemetry openTelemetry;
  private GoldenSignalsMetricsRecorder metricsRecorder;

  public GoldenSignalsMetricsTracerFactory(OpenTelemetry openTelemetry) {
    this.openTelemetry = openTelemetry;
    this.clientLevelTracerContext = ApiTracerContext.empty();
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, SpanName spanName, OperationType operationType) {
    if (metricsRecorder == null) {
      // This should never happen, in case it happens, create a no-op api tracer to not block
      // regular requests.
      return new BaseApiTracer();
    }
    return new GoldenSignalsMetricsTracer(metricsRecorder, clientLevelTracerContext);
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, ApiTracerContext methodLevelTracerContext) {
    if (metricsRecorder == null) {
      // This should never happen, in case it happens, create a no-op api tracer to not block
      // regular requests.
      return new BaseApiTracer();
    }
    ApiTracerContext mergedTracerContext = clientLevelTracerContext.merge(methodLevelTracerContext);
    return new GoldenSignalsMetricsTracer(metricsRecorder, mergedTracerContext);
  }

  @Override
  public ApiTracerFactory withContext(ApiTracerContext context) {
    this.clientLevelTracerContext = context;
    this.metricsRecorder =
        new GoldenSignalsMetricsRecorder(
            openTelemetry, clientLevelTracerContext.libraryMetadata().artifactName());
    return this;
  }
}

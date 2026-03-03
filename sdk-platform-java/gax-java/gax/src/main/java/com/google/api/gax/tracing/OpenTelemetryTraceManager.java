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
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanKind;
import java.util.Map;

/**
 * OpenTelemetry implementation of managing traces. This implementation collects the measurements
 * related to the lifecyle of an RPC.
 */
@BetaApi
@InternalApi
public class OpenTelemetryTraceManager implements TraceManager {
  private final io.opentelemetry.api.trace.Tracer tracer;

  public OpenTelemetryTraceManager(OpenTelemetry openTelemetry) {
    this.tracer = openTelemetry.getTracer("gax-java");
  }

  @Override
  public Span createSpan(String name, Map<String, String> attributes) {
    SpanBuilder spanBuilder = tracer.spanBuilder(name);

    // Attempt spans are of the CLIENT kind
    spanBuilder.setSpanKind(SpanKind.CLIENT);

    if (attributes != null) {
      attributes.forEach((k, v) -> spanBuilder.setAttribute(k, v));
    }

    io.opentelemetry.api.trace.Span span = spanBuilder.startSpan();

    return new OtelSpan(span);
  }

  private static class OtelSpan implements Span {
    private final io.opentelemetry.api.trace.Span span;

    private OtelSpan(io.opentelemetry.api.trace.Span span) {
      this.span = span;
    }

    @Override
    public void end() {
      span.end();
    }
  }
}

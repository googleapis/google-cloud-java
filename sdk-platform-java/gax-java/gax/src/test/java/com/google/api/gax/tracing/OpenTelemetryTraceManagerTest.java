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

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableMap;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.Tracer;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OpenTelemetryTraceManagerTest {
  @Mock private OpenTelemetry openTelemetry;
  @Mock private Tracer tracer;
  @Mock private SpanBuilder spanBuilder;
  @Mock private Span span;

  private OpenTelemetryTraceManager recorder;

  @BeforeEach
  void setUp() {
    when(openTelemetry.getTracer(anyString())).thenReturn(tracer);
    recorder = new OpenTelemetryTraceManager(openTelemetry);
  }

  @Test
  void testCreateSpan_operation_isInternal() {
    String spanName = "operation-span";
    when(tracer.spanBuilder(spanName)).thenReturn(spanBuilder);
    when(spanBuilder.setSpanKind(SpanKind.CLIENT)).thenReturn(spanBuilder);
    when(spanBuilder.startSpan()).thenReturn(span);

    recorder.createSpan(spanName, null);

    verify(spanBuilder).setSpanKind(SpanKind.CLIENT);
  }

  @Test
  void testCreateSpan_attempt_isClient() {
    String spanName = "attempt-span";

    when(tracer.spanBuilder(spanName)).thenReturn(spanBuilder);
    when(spanBuilder.setSpanKind(SpanKind.CLIENT)).thenReturn(spanBuilder);
    when(spanBuilder.startSpan()).thenReturn(span);

    recorder.createSpan(spanName, null);

    verify(spanBuilder).setSpanKind(SpanKind.CLIENT);
  }

  @Test
  void testCreateSpan_recordsSpan() {
    String spanName = "test-span";
    Map<String, String> attributes = ImmutableMap.of("key1", "value1");

    when(tracer.spanBuilder(spanName)).thenReturn(spanBuilder);
    when(spanBuilder.setSpanKind(SpanKind.CLIENT)).thenReturn(spanBuilder);
    when(spanBuilder.setAttribute("key1", "value1")).thenReturn(spanBuilder);
    when(spanBuilder.startSpan()).thenReturn(span);

    TraceManager.Span handle = recorder.createSpan(spanName, attributes);
    handle.end();

    verify(span).end();
  }
}

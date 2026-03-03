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

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.LibraryMetadata;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class SpanTracerFactoryTest {

  @Test
  void testNewTracer_createsOpenTelemetryTracingTracer() {
    TraceManager recorder = mock(TraceManager.class);
    when(recorder.createSpan(anyString(), anyMap())).thenReturn(mock(TraceManager.Span.class));

    SpanTracerFactory factory = new SpanTracerFactory(recorder);
    ApiTracer tracer =
        factory.newTracer(
            null, SpanName.of("service", "method"), ApiTracerFactory.OperationType.Unary);
    assertThat(tracer).isInstanceOf(SpanTracer.class);
  }

  @Test
  void testNewTracer_addsAttributes() {
    TraceManager recorder = mock(TraceManager.class);
    TraceManager.Span attemptHandle = mock(TraceManager.Span.class);
    when(recorder.createSpan(anyString(), anyMap())).thenReturn(attemptHandle);

    ApiTracerFactory factory = new SpanTracerFactory(recorder, ApiTracerContext.empty());
    factory =
        factory.withContext(
            ApiTracerContext.newBuilder()
                .setLibraryMetadata(LibraryMetadata.empty())
                .setServerAddress("test-address")
                .build());
    ApiTracer tracer =
        factory.newTracer(
            null, SpanName.of("service", "method"), ApiTracerFactory.OperationType.Unary);

    tracer.attemptStarted(null, 1);

    ArgumentCaptor<Map<String, String>> attributesCaptor = ArgumentCaptor.forClass(Map.class);
    verify(recorder, atLeastOnce()).createSpan(anyString(), attributesCaptor.capture());

    Map<String, String> attemptAttributes = attributesCaptor.getValue();
    assertThat(attemptAttributes).containsEntry("server.address", "test-address");
  }

  @Test
  void testWithContext_addsInferredAttributes() {
    TraceManager recorder = mock(TraceManager.class);
    TraceManager.Span attemptHandle = mock(TraceManager.Span.class);
    when(recorder.createSpan(anyString(), anyMap())).thenReturn(attemptHandle);

    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(LibraryMetadata.empty())
            .setServerAddress("example.com")
            .build();

    SpanTracerFactory factory = new SpanTracerFactory(recorder);
    ApiTracerFactory factoryWithContext = factory.withContext(context);

    ApiTracer tracer =
        factoryWithContext.newTracer(
            null, SpanName.of("service", "method"), ApiTracerFactory.OperationType.Unary);

    tracer.attemptStarted(null, 1);

    ArgumentCaptor<Map<String, String>> attributesCaptor = ArgumentCaptor.forClass(Map.class);
    verify(recorder, atLeastOnce()).createSpan(anyString(), attributesCaptor.capture());

    Map<String, String> attemptAttributes = attributesCaptor.getValue();
    assertThat(attemptAttributes)
        .containsEntry(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE, "example.com");
  }

  @Test
  void testWithContext_noEndpointContext_doesNotAddAttributes() {
    TraceManager recorder = mock(TraceManager.class);
    TraceManager.Span attemptHandle = mock(TraceManager.Span.class);
    when(recorder.createSpan(anyString(), anyMap())).thenReturn(attemptHandle);

    ApiTracerContext context = ApiTracerContext.empty();

    SpanTracerFactory factory = new SpanTracerFactory(recorder);
    ApiTracerFactory factoryWithContext = factory.withContext(context);

    ApiTracer tracer =
        factoryWithContext.newTracer(
            null, SpanName.of("service", "method"), ApiTracerFactory.OperationType.Unary);

    tracer.attemptStarted(null, 1);

    ArgumentCaptor<Map<String, String>> attributesCaptor = ArgumentCaptor.forClass(Map.class);
    verify(recorder, atLeastOnce()).createSpan(anyString(), attributesCaptor.capture());

    Map<String, String> attemptAttributes = attributesCaptor.getValue();
    assertThat(attemptAttributes)
        .doesNotContainKey(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE);
  }
}

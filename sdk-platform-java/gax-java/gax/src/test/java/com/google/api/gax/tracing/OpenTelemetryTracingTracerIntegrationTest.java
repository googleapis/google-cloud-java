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

import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.tracing.ApiTracerContext.Transport;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpenTelemetryTracingTracerIntegrationTest {

  private static final String FULL_METHOD_NAME = "google.fake.v1.FakeService/FakeMethod";
  private static final LibraryMetadata LIBRARY_METADATA =
      LibraryMetadata.newBuilder()
          .setRepository("googleapis/google-cloud-java")
          .setArtifactName("google-cloud-fake")
          .setVersion("1.0.0")
          .build();
  private static final ApiTracerContext TRACER_CONTEXT =
      ApiTracerContext.newBuilder()
          .setFullMethodName(FULL_METHOD_NAME)
          .setTransport(Transport.GRPC)
          .setLibraryMetadata(LIBRARY_METADATA)
          .setOperationType(OperationType.Unary)
          .build();

  private InMemorySpanExporter spanExporter;
  private SdkTracerProvider tracerProvider;
  private OpenTelemetrySdk openTelemetrySdk;
  private Tracer tracer;
  private ApiTracerFactory tracingFactory;

  @BeforeEach
  void setUp() {
    spanExporter = InMemorySpanExporter.create();
    tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    openTelemetrySdk = OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
    tracer = openTelemetrySdk.getTracer("test-tracer");
    tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk).withContext(TRACER_CONTEXT);
  }

  @AfterEach
  void tearDown() {
    tracerProvider.close();
  }

  @Test
  void testAttemptSpan_linkedToParentContextFromCallingThread() {
    Span parentSpan = tracer.spanBuilder("application-parent-operation").startSpan();
    ApiTracer apiTracer;
    try (Scope scope = parentSpan.makeCurrent()) {
      apiTracer = tracingFactory.newTracer(BaseApiTracer.getInstance(), TRACER_CONTEXT);
    }

    apiTracer.attemptStarted(new Object(), 0);
    apiTracer.attemptSucceeded();
    apiTracer.operationSucceeded();
    parentSpan.end();

    List<SpanData> finishedSpans = spanExporter.getFinishedSpanItems();
    assertThat(finishedSpans).hasSize(2);

    SpanData attemptSpan =
        finishedSpans.stream()
            .filter(s -> s.getName().equals(FULL_METHOD_NAME))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Attempt span not found"));
    SpanData rootSpan =
        finishedSpans.stream()
            .filter(s -> s.getName().equals("application-parent-operation"))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Parent span not found"));

    assertThat(attemptSpan.getKind()).isEqualTo(SpanKind.CLIENT);
    assertThat(attemptSpan.getParentSpanId()).isEqualTo(rootSpan.getSpanContext().getSpanId());
    assertThat(attemptSpan.getSpanContext().getTraceId())
        .isEqualTo(rootSpan.getSpanContext().getTraceId());
  }

  @Test
  void testAttemptSpan_withoutParentContext_hasNoParent() {
    ApiTracer apiTracer = tracingFactory.newTracer(BaseApiTracer.getInstance(), TRACER_CONTEXT);

    apiTracer.attemptStarted(new Object(), 0);
    apiTracer.attemptSucceeded();
    apiTracer.operationSucceeded();

    List<SpanData> finishedSpans = spanExporter.getFinishedSpanItems();
    assertThat(finishedSpans).hasSize(1);

    SpanData attemptSpan = finishedSpans.get(0);
    assertThat(attemptSpan.getName()).isEqualTo(FULL_METHOD_NAME);
    assertThat(attemptSpan.getParentSpanContext().isValid()).isFalse();
  }

  @Test
  void testSequentialAttempts_closesPreviousAttemptSpanAndLinksAllToParent() {
    Span parentSpan = tracer.spanBuilder("application-parent-operation").startSpan();
    ApiTracer apiTracer;
    try (Scope scope = parentSpan.makeCurrent()) {
      apiTracer = tracingFactory.newTracer(BaseApiTracer.getInstance(), TRACER_CONTEXT);
    }

    // Start attempt 0 (e.g. transient failure without explicit endAttempt before retry)
    apiTracer.attemptStarted(new Object(), 0);

    // Start attempt 1 - should automatically end attempt 0
    apiTracer.attemptStarted(new Object(), 1);
    assertThat(spanExporter.getFinishedSpanItems()).hasSize(1);
    SpanData attempt0Span = spanExporter.getFinishedSpanItems().get(0);
    assertThat(attempt0Span.getParentSpanId()).isEqualTo(parentSpan.getSpanContext().getSpanId());

    // Complete attempt 1 and operation
    apiTracer.attemptSucceeded();
    apiTracer.operationSucceeded();
    parentSpan.end();

    List<SpanData> finishedSpans = spanExporter.getFinishedSpanItems();
    assertThat(finishedSpans).hasSize(3); // attempt 0, attempt 1, parent

    SpanData attempt1Span =
        finishedSpans.stream()
            .filter(
                s ->
                    s.getName().equals(FULL_METHOD_NAME)
                        && !s.getSpanContext()
                            .getSpanId()
                            .equals(attempt0Span.getSpanContext().getSpanId()))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Attempt 1 span not found"));

    assertThat(attempt1Span.getParentSpanId()).isEqualTo(parentSpan.getSpanContext().getSpanId());
    assertThat(attempt1Span.getSpanContext().getTraceId())
        .isEqualTo(parentSpan.getSpanContext().getTraceId());
  }

  @Test
  void testOperationFailed_endsActiveAttemptSpanWithErrorAttributes() {
    Span parentSpan = tracer.spanBuilder("application-parent-operation").startSpan();
    ApiTracer apiTracer;
    try (Scope scope = parentSpan.makeCurrent()) {
      apiTracer = tracingFactory.newTracer(BaseApiTracer.getInstance(), TRACER_CONTEXT);
    }

    apiTracer.attemptStarted(new Object(), 0);
    // Operation fails while attempt was still in flight
    apiTracer.operationFailed(new RuntimeException("network timeout"));
    parentSpan.end();

    List<SpanData> finishedSpans = spanExporter.getFinishedSpanItems();
    assertThat(finishedSpans).hasSize(2);

    SpanData attemptSpan =
        finishedSpans.stream()
            .filter(s -> s.getName().equals(FULL_METHOD_NAME))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Attempt span not found"));

    assertThat(attemptSpan.getParentSpanId()).isEqualTo(parentSpan.getSpanContext().getSpanId());
    assertThat(
            attemptSpan
                .getAttributes()
                .get(AttributeKey.stringKey(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE)))
        .isEqualTo("network timeout");
  }

  @Test
  void testAttemptStarted_afterOperationCompleted_doesNotEmitNewSpan() {
    ApiTracer apiTracer = tracingFactory.newTracer(BaseApiTracer.getInstance(), TRACER_CONTEXT);

    apiTracer.operationSucceeded();

    // Any attempts started after operation completed must be ignored
    apiTracer.attemptStarted(new Object(), 0);

    assertThat(spanExporter.getFinishedSpanItems()).isEmpty();
  }
}

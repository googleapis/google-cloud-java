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
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
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
    // Verifies that when an application trace parent exists, the operation span (T3)
    // links to the application parent, and the attempt span (T4) links to the operation span.
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
    assertThat(finishedSpans).hasSize(3); // root, operation, attempt

    SpanData attemptSpan =
        finishedSpans.stream()
            .filter(s -> s.getKind() == SpanKind.CLIENT)
            .findFirst()
            .orElseThrow(() -> new AssertionError("Attempt span not found"));
    SpanData operationSpan =
        finishedSpans.stream()
            .filter(s -> s.getKind() == SpanKind.INTERNAL)
            .findFirst()
            .orElseThrow(() -> new AssertionError("Operation span not found"));
    SpanData rootSpan =
        finishedSpans.stream()
            .filter(s -> s.getName().equals("application-parent-operation"))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Parent span not found"));

    assertThat(attemptSpan.getKind()).isEqualTo(SpanKind.CLIENT);
    assertThat(attemptSpan.getParentSpanId()).isEqualTo(operationSpan.getSpanContext().getSpanId());
    assertThat(operationSpan.getParentSpanId()).isEqualTo(rootSpan.getSpanContext().getSpanId());
    assertThat(attemptSpan.getSpanContext().getTraceId())
        .isEqualTo(rootSpan.getSpanContext().getTraceId());
    assertThat(operationSpan.getSpanContext().getTraceId())
        .isEqualTo(rootSpan.getSpanContext().getTraceId());
  }

  @Test
  void testAttemptSpan_withoutParentContext_hasNoParent() {
    // Verifies that without an external parent context, the operation span acts as root
    // and the attempt span is a child of the operation span.
    ApiTracer apiTracer = tracingFactory.newTracer(BaseApiTracer.getInstance(), TRACER_CONTEXT);

    apiTracer.attemptStarted(new Object(), 0);
    apiTracer.attemptSucceeded();
    apiTracer.operationSucceeded();

    List<SpanData> finishedSpans = spanExporter.getFinishedSpanItems();
    assertThat(finishedSpans).hasSize(2); // operation, attempt

    SpanData attemptSpan =
        finishedSpans.stream()
            .filter(s -> s.getKind() == SpanKind.CLIENT)
            .findFirst()
            .orElseThrow(() -> new AssertionError("Attempt span not found"));
    SpanData operationSpan =
        finishedSpans.stream()
            .filter(s -> s.getKind() == SpanKind.INTERNAL)
            .findFirst()
            .orElseThrow(() -> new AssertionError("Operation span not found"));

    assertThat(operationSpan.getParentSpanContext().isValid()).isFalse();
    assertThat(attemptSpan.getParentSpanId()).isEqualTo(operationSpan.getSpanContext().getSpanId());
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

    // Complete attempt 1 and operation
    apiTracer.attemptSucceeded();
    apiTracer.operationSucceeded();
    parentSpan.end();

    List<SpanData> finishedSpans = spanExporter.getFinishedSpanItems();
    assertThat(finishedSpans).hasSize(4); // attempt 0, attempt 1, operation, parent

    SpanData operationSpan =
        finishedSpans.stream()
            .filter(s -> s.getKind() == SpanKind.INTERNAL)
            .findFirst()
            .orElseThrow(() -> new AssertionError("Operation span not found"));

    assertThat(attempt0Span.getParentSpanId())
        .isEqualTo(operationSpan.getSpanContext().getSpanId());

    SpanData attempt1Span =
        finishedSpans.stream()
            .filter(
                s ->
                    s.getKind() == SpanKind.CLIENT
                        && !s.getSpanContext()
                            .getSpanId()
                            .equals(attempt0Span.getSpanContext().getSpanId()))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Attempt 1 span not found"));

    assertThat(attempt1Span.getParentSpanId())
        .isEqualTo(operationSpan.getSpanContext().getSpanId());
    assertThat(operationSpan.getParentSpanId()).isEqualTo(parentSpan.getSpanContext().getSpanId());
    assertThat(attempt1Span.getSpanContext().getTraceId())
        .isEqualTo(parentSpan.getSpanContext().getTraceId());
  }

  @Test
  void testOperationFailed_endsActiveAttemptSpanWithErrorAttributes() {
    // Verifies that when the operation fails permanently while an attempt is in-flight,
    // both the attempt span and the operation span end with the error status and message.
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
    assertThat(finishedSpans).hasSize(3); // parent, operation, attempt

    SpanData attemptSpan =
        finishedSpans.stream()
            .filter(s -> s.getKind() == SpanKind.CLIENT)
            .findFirst()
            .orElseThrow(() -> new AssertionError("Attempt span not found"));
    SpanData operationSpan =
        finishedSpans.stream()
            .filter(s -> s.getKind() == SpanKind.INTERNAL)
            .findFirst()
            .orElseThrow(() -> new AssertionError("Operation span not found"));

    assertThat(attemptSpan.getParentSpanId()).isEqualTo(operationSpan.getSpanContext().getSpanId());
    assertThat(operationSpan.getParentSpanId()).isEqualTo(parentSpan.getSpanContext().getSpanId());
    assertThat(
            attemptSpan
                .getAttributes()
                .get(AttributeKey.stringKey(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE)))
        .isEqualTo("network timeout");
  }

  @Test
  void testAttemptStarted_afterOperationCompleted_doesNotEmitNewSpan() {
    // Verifies that after operation completion, subsequent attemptStarted calls
    // do not create orphan attempt spans.
    ApiTracer apiTracer = tracingFactory.newTracer(BaseApiTracer.getInstance(), TRACER_CONTEXT);

    apiTracer.operationSucceeded();

    // Any attempts started after operation completed must be ignored
    apiTracer.attemptStarted(new Object(), 0);

    // Only the operation span was emitted and ended
    List<SpanData> finishedSpans = spanExporter.getFinishedSpanItems();
    assertThat(finishedSpans).hasSize(1);
    assertThat(finishedSpans.get(0).getKind()).isEqualTo(SpanKind.INTERNAL);
  }

  @Test
  void testRetrySucceeds_operationAggregatesSuccessAttributes() {
    // Verifies that when a transient failure is retried and succeeds:
    // 1. Exactly one overall INTERNAL operation span (T3) is created.
    // 2. Both attempt spans (T4) have the operation span as their parent.
    // 3. The operation span aggregates the successful status (OK) from the final attempt.
    ApiTracer apiTracer = tracingFactory.newTracer(BaseApiTracer.getInstance(), TRACER_CONTEXT);

    // Attempt 0 fails with transient error
    apiTracer.attemptStarted(new Object(), 0);
    apiTracer.attemptFailedDuration(new RuntimeException("transient 503"), Duration.ofMillis(10));

    // Attempt 1 succeeds
    apiTracer.attemptStarted(new Object(), 1);
    apiTracer.attemptSucceeded();
    apiTracer.operationSucceeded();

    List<SpanData> finishedSpans = spanExporter.getFinishedSpanItems();
    assertThat(finishedSpans).hasSize(3); // attempt 0, attempt 1, operation

    List<SpanData> internalSpans =
        finishedSpans.stream()
            .filter(s -> s.getKind() == SpanKind.INTERNAL)
            .collect(Collectors.toList());
    assertThat(internalSpans).hasSize(1);
    SpanData operationSpan = internalSpans.get(0);

    List<SpanData> attemptSpans =
        finishedSpans.stream()
            .filter(s -> s.getKind() == SpanKind.CLIENT)
            .collect(Collectors.toList());
    assertThat(attemptSpans).hasSize(2);

    for (SpanData attempt : attemptSpans) {
      assertThat(attempt.getParentSpanId()).isEqualTo(operationSpan.getSpanContext().getSpanId());
    }

    assertThat(operationSpan.getStatus().getStatusCode())
        .isEqualTo(io.opentelemetry.api.trace.StatusCode.UNSET);
    assertThat(
            operationSpan
                .getAttributes()
                .get(AttributeKey.stringKey(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
        .isEqualTo("OK");
    assertThat(
            operationSpan
                .getAttributes()
                .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
        .isNull();
  }

  @Test
  void testRetriesExhausted_operationAggregatesFailureAttributes() {
    // Verifies that when retries are exhausted:
    // 1. Exactly one overall INTERNAL operation span (T3) is created.
    // 2. Both attempt spans (T4) have the operation span as their parent.
    // 3. The operation span aggregates the final ERROR status and error attributes.
    ApiTracer apiTracer = tracingFactory.newTracer(BaseApiTracer.getInstance(), TRACER_CONTEXT);

    // Attempt 0 fails with transient error
    apiTracer.attemptStarted(new Object(), 0);
    apiTracer.attemptFailedDuration(new RuntimeException("transient 503"), Duration.ofMillis(10));

    // Attempt 1 fails and exhausts retries
    apiTracer.attemptStarted(new Object(), 1);
    RuntimeException finalError = new RuntimeException("unavailable: retries exhausted");
    apiTracer.attemptFailedRetriesExhausted(finalError);
    apiTracer.operationFailed(finalError);

    List<SpanData> finishedSpans = spanExporter.getFinishedSpanItems();
    assertThat(finishedSpans).hasSize(3); // attempt 0, attempt 1, operation

    List<SpanData> internalSpans =
        finishedSpans.stream()
            .filter(s -> s.getKind() == SpanKind.INTERNAL)
            .collect(Collectors.toList());
    assertThat(internalSpans).hasSize(1);
    SpanData operationSpan = internalSpans.get(0);

    List<SpanData> attemptSpans =
        finishedSpans.stream()
            .filter(s -> s.getKind() == SpanKind.CLIENT)
            .collect(Collectors.toList());
    assertThat(attemptSpans).hasSize(2);

    for (SpanData attempt : attemptSpans) {
      assertThat(attempt.getParentSpanId()).isEqualTo(operationSpan.getSpanContext().getSpanId());
    }

    assertThat(operationSpan.getStatus().getStatusCode())
        .isEqualTo(io.opentelemetry.api.trace.StatusCode.ERROR);
    assertThat(
            operationSpan
                .getAttributes()
                .get(AttributeKey.stringKey(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE)))
        .isEqualTo("unavailable: retries exhausted");
    assertThat(
            operationSpan
                .getAttributes()
                .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
        .isNotNull();
  }
}

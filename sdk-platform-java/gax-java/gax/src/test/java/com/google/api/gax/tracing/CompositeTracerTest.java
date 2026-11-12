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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.LibraryMetadata;
import com.google.common.collect.ImmutableMap;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

class CompositeTracerTest {

  private ApiTracer child1;
  private ApiTracer child2;
  private CompositeTracer compositeTracer;

  @BeforeEach
  void setUp() {
    child1 = mock(ApiTracer.class, Mockito.withSettings().withoutAnnotations());
    child2 = mock(ApiTracer.class, Mockito.withSettings().withoutAnnotations());
    compositeTracer = new CompositeTracer(Arrays.asList(child1, child2));
  }

  @Test
  void testInScope_lifoOrder() {
    ApiTracer.Scope scope1 =
        mock(ApiTracer.Scope.class, Mockito.withSettings().withoutAnnotations());
    ApiTracer.Scope scope2 =
        mock(ApiTracer.Scope.class, Mockito.withSettings().withoutAnnotations());

    when(child1.inScope()).thenReturn(scope1);
    when(child2.inScope()).thenReturn(scope2);

    ApiTracer.Scope compositeScope = compositeTracer.inScope();
    compositeScope.close();

    verify(child1).inScope();
    verify(child2).inScope();

    InOrder inOrder = inOrder(scope2, scope1);
    inOrder.verify(scope2).close();
    inOrder.verify(scope1).close();
  }

  @Test
  void testInScope_childInScopeThrows() {
    ApiTracer.Scope scope1 =
        mock(ApiTracer.Scope.class, Mockito.withSettings().withoutAnnotations());
    RuntimeException exception = new RuntimeException("Runtime Error");

    when(child1.inScope()).thenReturn(scope1);
    when(child2.inScope()).thenThrow(exception);

    RuntimeException thrown = assertThrows(RuntimeException.class, () -> compositeTracer.inScope());

    assertEquals(exception, thrown);
    verify(child1).inScope();
    verify(child2).inScope();
    verify(scope1).close();
  }

  @Test
  void testInScope_childScopeCloseThrows() {
    ApiTracer.Scope scope1 =
        mock(ApiTracer.Scope.class, Mockito.withSettings().withoutAnnotations());
    ApiTracer.Scope scope2 =
        mock(ApiTracer.Scope.class, Mockito.withSettings().withoutAnnotations());

    RuntimeException exception2 = new RuntimeException("Scope 2 close Error");
    RuntimeException exception1 = new RuntimeException("Scope 1 close Error");

    when(child1.inScope()).thenReturn(scope1);
    when(child2.inScope()).thenReturn(scope2);

    doThrow(exception2).when(scope2).close();
    doThrow(exception1).when(scope1).close();

    ApiTracer.Scope compositeScope = compositeTracer.inScope();

    RuntimeException thrown = assertThrows(RuntimeException.class, () -> compositeScope.close());

    assertEquals(exception2, thrown);
    assertTrue(Arrays.asList(thrown.getSuppressed()).contains(exception1));

    InOrder inOrder = inOrder(scope2, scope1);
    inOrder.verify(scope2).close();
    inOrder.verify(scope1).close();
  }

  @Test
  void testOperationSucceeded() {
    compositeTracer.operationSucceeded();
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).operationSucceeded();
    inOrder.verify(child1).operationSucceeded();
  }

  @Test
  void testOperationCancelled() {
    compositeTracer.operationCancelled();
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).operationCancelled();
    inOrder.verify(child1).operationCancelled();
  }

  @Test
  void testOperationFailed() {
    Throwable error = new RuntimeException("test error");
    compositeTracer.operationFailed(error);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).operationFailed(error);
    inOrder.verify(child1).operationFailed(error);
  }

  @Test
  void testCompletionMethods_enterAndCloseScopeAroundChildren() {
    ApiTracer.Scope scope1 =
        mock(ApiTracer.Scope.class, Mockito.withSettings().withoutAnnotations());
    ApiTracer.Scope scope2 =
        mock(ApiTracer.Scope.class, Mockito.withSettings().withoutAnnotations());
    when(child1.inScope()).thenReturn(scope1);
    when(child2.inScope()).thenReturn(scope2);

    Throwable error = new RuntimeException("test error");
    compositeTracer.operationFailed(error);

    InOrder inOrder = inOrder(child1, child2, scope1, scope2);
    inOrder.verify(child1).inScope();
    inOrder.verify(child2).inScope();
    inOrder.verify(child2).operationFailed(error);
    inOrder.verify(child1).operationFailed(error);
    inOrder.verify(scope2).close();
    inOrder.verify(scope1).close();
  }

  @Test
  void testConnectionSelected() {
    String id = "connection_id_1";
    compositeTracer.connectionSelected(id);
    verify(child1).connectionSelected(id);
    verify(child2).connectionSelected(id);
  }

  @Test
  @SuppressWarnings("deprecation")
  void testAttemptStartedDeprecated() {
    compositeTracer.attemptStarted(2);
    verify(child1).attemptStarted(2);
    verify(child2).attemptStarted(2);
  }

  @Test
  void testAttemptStarted() {
    Object request = new Object();
    compositeTracer.attemptStarted(request, 3);
    verify(child1).attemptStarted(request, 3);
    verify(child2).attemptStarted(request, 3);
  }

  @Test
  void testAttemptSucceeded() {
    compositeTracer.attemptSucceeded();
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).attemptSucceeded();
    inOrder.verify(child1).attemptSucceeded();
  }

  @Test
  void testAttemptCancelled() {
    compositeTracer.attemptCancelled();
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).attemptCancelled();
    inOrder.verify(child1).attemptCancelled();
  }

  @Test
  @SuppressWarnings("deprecation")
  void testAttemptFailedDeprecated() {
    Throwable error = new RuntimeException("test error");
    org.threeten.bp.Duration delay = org.threeten.bp.Duration.ofSeconds(1);
    compositeTracer.attemptFailed(error, delay);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).attemptFailed(error, delay);
    inOrder.verify(child1).attemptFailed(error, delay);
  }

  @Test
  void testAttemptFailedDuration() {
    Throwable error = new RuntimeException("test error");
    java.time.Duration delay = java.time.Duration.ofSeconds(1);
    compositeTracer.attemptFailedDuration(error, delay);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).attemptFailedDuration(error, delay);
    inOrder.verify(child1).attemptFailedDuration(error, delay);
  }

  @Test
  void testAttemptFailedRetriesExhausted() {
    Throwable error = new RuntimeException("test error");
    compositeTracer.attemptFailedRetriesExhausted(error);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).attemptFailedRetriesExhausted(error);
    inOrder.verify(child1).attemptFailedRetriesExhausted(error);
  }

  @Test
  void testAttemptPermanentFailure() {
    Throwable error = new RuntimeException("test error");
    compositeTracer.attemptPermanentFailure(error);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).attemptPermanentFailure(error);
    inOrder.verify(child1).attemptPermanentFailure(error);
  }

  @Test
  void testLroStartFailed() {
    Throwable error = new RuntimeException("test error");
    compositeTracer.lroStartFailed(error);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).lroStartFailed(error);
    inOrder.verify(child1).lroStartFailed(error);
  }

  @Test
  void testLroStartSucceeded() {
    compositeTracer.lroStartSucceeded();
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).lroStartSucceeded();
    inOrder.verify(child1).lroStartSucceeded();
  }

  @Test
  void testResponseReceived() {
    compositeTracer.responseReceived();
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).responseReceived();
    inOrder.verify(child1).responseReceived();
  }

  @Test
  void testResponseHeadersReceived() {
    Map<String, Object> headers = ImmutableMap.<String, Object>of("testHeader", "testValue");
    compositeTracer.responseHeadersReceived(headers);
    InOrder inOrder = inOrder(child2, child1);
    inOrder.verify(child2).responseHeadersReceived(headers);
    inOrder.verify(child1).responseHeadersReceived(headers);
  }

  @Test
  void testRequestSent() {
    compositeTracer.requestSent();
    verify(child1).requestSent();
    verify(child2).requestSent();
  }

  @Test
  void testBatchRequestSent() {
    compositeTracer.batchRequestSent(10L, 100L);
    verify(child1).batchRequestSent(10L, 100L);
    verify(child2).batchRequestSent(10L, 100L);
  }

  @Test
  void testInjectTraceContext() {
    java.util.Map<String, String> carrier = new java.util.HashMap<>();
    compositeTracer.injectTraceContext(carrier);
    InOrder inOrder = inOrder(child1, child2);
    inOrder.verify(child1).injectTraceContext(carrier);
    inOrder.verify(child2).injectTraceContext(carrier);
  }

  @Test
  void testRequestUrlResolved() {
    compositeTracer.requestUrlResolved("the-url");
    InOrder inOrder = inOrder(child1, child2);
    inOrder.verify(child1).requestUrlResolved("the-url");
    inOrder.verify(child2).requestUrlResolved("the-url");
  }

  @Test
  void testNestedCompositeTracer_crossThreadScopingAndMetricsExemplars() throws Exception {
    InMemorySpanExporter spanExporter = InMemorySpanExporter.create();
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();

    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder()
            .setTracerProvider(tracerProvider)
            .setMeterProvider(meterProvider)
            .build();

    List<SpanContext> attemptLogContexts = new CopyOnWriteArrayList<>();
    List<SpanContext> operationLogContexts = new CopyOnWriteArrayList<>();

    ApiTracerFactory captureLoggingFactory =
        new BaseApiTracerFactory() {
          @Override
          public ApiTracer newTracer(ApiTracer parent, ApiTracerContext context) {
            return new BaseApiTracer() {
              @Override
              public void attemptFailedDuration(Throwable error, Duration delay) {
                attemptLogContexts.add(Span.current().getSpanContext());
              }

              @Override
              public void attemptFailedRetriesExhausted(Throwable error) {
                attemptLogContexts.add(Span.current().getSpanContext());
              }

              @Override
              public void operationFailed(Throwable error) {
                operationLogContexts.add(Span.current().getSpanContext());
              }
            };
          }
        };

    // Exact nested structure from ClientContext when user configures Metrics + Tracing
    // and GOOGLE_SDK_JAVA_LOGGING is enabled:
    // Composite(Logging, Composite(Metrics, Tracing))
    ApiTracerFactory nestedFactory =
        new CompositeTracerFactory(
            Arrays.asList(
                captureLoggingFactory,
                new CompositeTracerFactory(
                    Arrays.asList(
                        new OpenTelemetryMetricsFactory(openTelemetry),
                        new OpenTelemetryTracingFactory(openTelemetry)))));

    ApiTracerContext clientContext =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(
                LibraryMetadata.newBuilder()
                    .setArtifactName("gax-test-lib")
                    .setVersion("1.0.0")
                    .build())
            .setServiceName("echo")
            .setServerAddress("localhost")
            .setServerPort(7469)
            .setTransport(ApiTracerContext.Transport.GRPC)
            .setFullMethodName("google.showcase.v1beta1.Echo/Echo")
            .build();

    ApiTracerFactory initializedFactory = nestedFactory.withContext(clientContext);

    // Thread A initiates operation and attempt 0
    ApiTracer tracer = initializedFactory.newTracer(new BaseApiTracer(), clientContext);
    tracer.attemptStarted(new Object(), 0);
    assertThat(Span.current().getSpanContext().isValid()).isFalse();

    // Thread B handles attempt 0 failure, retries attempt 1, exhausts retries, and fails operation
    AtomicBoolean threadBCleanAfterCallbacks = new AtomicBoolean(false);
    Thread threadB =
        new Thread(
            () -> {
              RuntimeException err = new RuntimeException("transient failure");
              tracer.attemptFailedDuration(err, Duration.ofMillis(10));
              boolean cleanAfterAttempt0 = !Span.current().getSpanContext().isValid();

              tracer.attemptStarted(new Object(), 1);
              tracer.attemptFailedRetriesExhausted(err);
              boolean cleanAfterAttempt1 = !Span.current().getSpanContext().isValid();

              tracer.operationFailed(err);
              boolean cleanAfterOperation = !Span.current().getSpanContext().isValid();

              threadBCleanAfterCallbacks.set(
                  cleanAfterAttempt0 && cleanAfterAttempt1 && cleanAfterOperation);
            });
    threadB.start();
    threadB.join();

    assertThat(threadBCleanAfterCallbacks.get()).isTrue();
    assertThat(Span.current().getSpanContext().isValid()).isFalse();

    List<SpanData> exportedSpans = spanExporter.getFinishedSpanItems();
    // 2 attempt spans + 1 operation span
    assertThat(exportedSpans).hasSize(3);
    SpanData attempt0Span = exportedSpans.get(0);
    SpanData attempt1Span = exportedSpans.get(1);
    SpanData operationSpan = exportedSpans.get(2);

    // L4 attempt logs captured exact T4 attempt spans
    assertThat(attemptLogContexts).hasSize(2);
    assertThat(attemptLogContexts.get(0).getSpanId()).isEqualTo(attempt0Span.getSpanId());
    assertThat(attemptLogContexts.get(0).getTraceId()).isEqualTo(operationSpan.getTraceId());
    assertThat(attemptLogContexts.get(1).getSpanId()).isEqualTo(attempt1Span.getSpanId());

    // L3 operation log captured exact T3 operation span
    assertThat(operationLogContexts).hasSize(1);
    assertThat(operationLogContexts.get(0).getSpanId()).isEqualTo(operationSpan.getSpanId());
    assertThat(operationLogContexts.get(0).getTraceId()).isEqualTo(operationSpan.getTraceId());

    // M1 metric recorded with sampled exemplar linked to T3 operation span
    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).hasSize(1);
    HistogramPointData point =
        metrics.iterator().next().getHistogramData().getPoints().iterator().next();
    assertThat(point.getExemplars()).hasSize(1);
    DoubleExemplarData exemplar = point.getExemplars().get(0);
    assertThat(exemplar.getSpanContext().getTraceId()).isEqualTo(operationSpan.getTraceId());
    assertThat(exemplar.getSpanContext().getSpanId()).isEqualTo(operationSpan.getSpanId());
  }
}

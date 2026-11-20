/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute.v1;

import static com.google.common.truth.Truth.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertThrows;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.HttpJsonStatusCode;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.CompositeTracerFactory;
import com.google.api.gax.tracing.ObservabilityAttributes;
import com.google.api.gax.tracing.OpenTelemetryMetricsFactory;
import com.google.api.gax.tracing.OpenTelemetryTracingFactory;
import com.google.cloud.compute.v1.stub.HttpJsonInstancesStub;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 * Validates OpenTelemetry traces (T3/T4 span hierarchy and parent context propagation), golden
 * signal metrics and exemplars, and actionable error logging correlation on the Compute GAPIC
 * client using an in-memory mock transport.
 */
public class ComputeObservabilityValidationTest {
  private static final String PROJECT = "test-project";
  private static final String ZONE = "us-central1-a";
  private static final String EXPECTED_OPERATION_SPAN_NAME =
      "google.cloud.compute.v1.Instances.List";
  private static final String EXPECTED_URL_TEMPLATE =
      "compute/v1/projects/{project=*}/zones/{zone=*}/instances";
  private static final String EXPECTED_ATTEMPT_SPAN_NAME = "GET " + EXPECTED_URL_TEMPLATE;
  private static final String CLIENT_REQUEST_DURATION_METRIC = "gcp.client.request.duration";

  private MockHttpService mockService;
  private InMemorySpanExporter spanExporter;
  private InMemoryMetricReader metricReader;
  private OpenTelemetrySdk openTelemetrySdk;
  private Tracer appTracer;
  private InstancesClient client;
  private SpanCapturingAppender testAppender;
  private Logger loggingTracerLogger;
  private Level previousLogLevel;

  /** Initializes mock HTTP service, in-memory OTel SDK, Compute client, and log appender. */
  @Before
  public void setUp() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonInstancesStub.getMethodDescriptors(), InstancesSettings.getDefaultEndpoint());

    spanExporter = InMemorySpanExporter.create();
    metricReader = InMemoryMetricReader.create();
    openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder()
                    .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
                    .build())
            .setMeterProvider(SdkMeterProvider.builder().registerMetricReader(metricReader).build())
            .build();
    appTracer = openTelemetrySdk.getTracer("compute-validation-test");

    // ClientContext automatically wraps this factory in an outer CompositeTracerFactory with
    // LoggingTracerFactory when GOOGLE_SDK_JAVA_LOGGING=true is set by maven-surefire-plugin.
    ApiTracerFactory tracerFactory =
        new CompositeTracerFactory(
            ImmutableList.of(
                new OpenTelemetryMetricsFactory(openTelemetrySdk),
                new OpenTelemetryTracingFactory(openTelemetrySdk)));

    InstancesSettings.Builder settingsBuilder =
        InstancesSettings.newBuilder()
            .setTransportChannelProvider(
                InstancesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create());
    settingsBuilder.getStubSettingsBuilder().setTracerFactory(tracerFactory);
    client = InstancesClient.create(settingsBuilder.build());

    testAppender = new SpanCapturingAppender();
    testAppender.start();
    loggingTracerLogger =
        (Logger) LoggerFactory.getLogger("com.google.api.gax.tracing.LoggingTracer");
    previousLogLevel = loggingTracerLogger.getLevel();
    loggingTracerLogger.setLevel(Level.DEBUG);
    loggingTracerLogger.addAppender(testAppender);
  }

  /** Tears down client, OTel SDK, mock service, and log appender. */
  @After
  public void tearDown() throws InterruptedException {
    if (loggingTracerLogger != null && testAppender != null) {
      loggingTracerLogger.detachAppender(testAppender);
      loggingTracerLogger.setLevel(previousLogLevel);
    }
    if (client != null) {
      client.shutdownNow();
      client.awaitTermination(5, TimeUnit.SECONDS);
    }
    if (openTelemetrySdk != null) {
      openTelemetrySdk.close();
    }
    if (mockService != null) {
      mockService.reset();
    }
  }

  /**
   * Verifies that a successful Compute RPC propagates the parent trace context into T3/T4 spans,
   * records golden signal metrics with a T3 exemplar, and emits no error logs.
   */
  @Test
  public void testComputeSuccess_tracesMetricsAndExemplarCorrelation() {
    mockService.addResponse(InstanceList.newBuilder().setId("list-1").build());

    Span rootSpan = appTracer.spanBuilder("app-root-span").startSpan();
    SpanContext rootSpanContext = rootSpan.getSpanContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
      client.list(PROJECT, ZONE);
    } finally {
      rootSpan.end();
    }

    await()
        .atMost(Duration.ofSeconds(5))
        .until(() -> spanExporter.getFinishedSpanItems().size() >= 3);

    SpanData operationSpan = findSpanByKind(SpanKind.INTERNAL, EXPECTED_OPERATION_SPAN_NAME);
    SpanData attemptSpan = findSpanByKind(SpanKind.CLIENT, EXPECTED_ATTEMPT_SPAN_NAME);

    assertThat(operationSpan.getTraceId()).isEqualTo(rootSpanContext.getTraceId());
    assertThat(operationSpan.getParentSpanId()).isEqualTo(rootSpanContext.getSpanId());
    assertThat(operationSpan.getStatus().getStatusCode()).isNotEqualTo(StatusCode.ERROR);
    assertCommonComputeAttributes(operationSpan.getAttributes(), 200L);

    assertThat(attemptSpan.getTraceId()).isEqualTo(rootSpanContext.getTraceId());
    assertThat(attemptSpan.getParentSpanId()).isEqualTo(operationSpan.getSpanId());
    assertThat(attemptSpan.getStatus().getStatusCode()).isNotEqualTo(StatusCode.ERROR);
    assertCommonComputeAttributes(attemptSpan.getAttributes(), 200L);
    assertThat(
            attemptSpan
                .getAttributes()
                .get(AttributeKey.stringKey(ObservabilityAttributes.HTTP_METHOD_ATTRIBUTE)))
        .isEqualTo("GET");

    assertDurationMetricAndExemplar(200L, operationSpan.getSpanContext());
    assertThat(testAppender.events).isEmpty();
    assertThat(Span.current().getSpanContext().isValid()).isFalse();
  }

  /**
   * Verifies that a failing Compute RPC records error attributes on T3/T4 spans, attaches the T3
   * span as the duration metric exemplar, and correlates L4 (DEBUG) and L3 (ERROR) logs with the
   * active attempt and operation spans respectively.
   */
  @Test
  public void testComputeError_tracesMetricsExemplarAndActionableErrorLogs() {
    ApiException invalidArgumentException =
        ApiExceptionFactory.createException(
            new IOException("Invalid argument"), HttpJsonStatusCode.of(400), false);
    mockService.addException(invalidArgumentException);

    Span rootSpan = appTracer.spanBuilder("app-root-span").startSpan();
    SpanContext rootSpanContext = rootSpan.getSpanContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
      assertThrows(ApiException.class, () -> client.list(PROJECT, ZONE));
    } finally {
      rootSpan.end();
    }

    await()
        .atMost(Duration.ofSeconds(5))
        .until(
            () ->
                spanExporter.getFinishedSpanItems().size() >= 3
                    && testAppender.events.stream().anyMatch(e -> e.getLevel() == Level.DEBUG)
                    && testAppender.events.stream().anyMatch(e -> e.getLevel() == Level.ERROR));

    SpanData operationSpan = findSpanByKind(SpanKind.INTERNAL, EXPECTED_OPERATION_SPAN_NAME);
    SpanData attemptSpan = findSpanByKind(SpanKind.CLIENT, EXPECTED_ATTEMPT_SPAN_NAME);

    assertThat(operationSpan.getTraceId()).isEqualTo(rootSpanContext.getTraceId());
    assertThat(operationSpan.getParentSpanId()).isEqualTo(rootSpanContext.getSpanId());
    assertThat(operationSpan.getStatus().getStatusCode()).isEqualTo(StatusCode.ERROR);
    assertCommonComputeAttributes(operationSpan.getAttributes(), 400L);
    assertThat(
            operationSpan
                .getAttributes()
                .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
        .isEqualTo("400");

    assertThat(attemptSpan.getTraceId()).isEqualTo(rootSpanContext.getTraceId());
    assertThat(attemptSpan.getParentSpanId()).isEqualTo(operationSpan.getSpanId());
    assertThat(attemptSpan.getStatus().getStatusCode()).isEqualTo(StatusCode.ERROR);
    assertCommonComputeAttributes(attemptSpan.getAttributes(), 400L);

    assertDurationMetricAndExemplar(400L, operationSpan.getSpanContext());

    ILoggingEvent debugEvent = findLogEventByLevel(Level.DEBUG);
    ILoggingEvent errorEvent = findLogEventByLevel(Level.ERROR);
    assertThat(testAppender.eventSpanContexts.get(debugEvent))
        .isEqualTo(attemptSpan.getSpanContext());
    assertThat(testAppender.eventSpanContexts.get(errorEvent))
        .isEqualTo(operationSpan.getSpanContext());
    assertThat(Span.current().getSpanContext().isValid()).isFalse();
  }

  /** Finds an exported span matching the given {@link SpanKind} and name. */
  private SpanData findSpanByKind(SpanKind kind, String expectedName) {
    return spanExporter.getFinishedSpanItems().stream()
        .filter(span -> span.getKind() == kind && expectedName.equals(span.getName()))
        .findFirst()
        .orElseThrow(() -> new AssertionError("Expected " + kind + " span named " + expectedName));
  }

  /** Finds the first captured log event with the given {@link Level}. */
  private ILoggingEvent findLogEventByLevel(Level level) {
    return testAppender.events.stream()
        .filter(event -> event.getLevel() == level)
        .findFirst()
        .orElseThrow(() -> new AssertionError("Expected log event with level " + level));
  }

  /** Asserts standard Compute HTTP/JSON observability attributes on a span. */
  private void assertCommonComputeAttributes(Attributes attributes, long expectedStatusCode) {
    assertThat(
            attributes.get(
                AttributeKey.stringKey(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE)))
        .isEqualTo("http");
    assertThat(
            attributes.get(
                AttributeKey.stringKey(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE)))
        .isEqualTo("compute");
    assertThat(attributes.get(AttributeKey.stringKey(ObservabilityAttributes.URL_DOMAIN_ATTRIBUTE)))
        .isEqualTo("compute.googleapis.com");
    assertThat(attributes.get(AttributeKey.stringKey(ObservabilityAttributes.REPO_ATTRIBUTE)))
        .isEqualTo("googleapis/google-cloud-java");
    assertThat(
            attributes.get(
                AttributeKey.stringKey(ObservabilityAttributes.HTTP_URL_TEMPLATE_ATTRIBUTE)))
        .isEqualTo(EXPECTED_URL_TEMPLATE);
    assertThat(
            attributes.get(
                AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE)))
        .isEqualTo(expectedStatusCode);
  }

  /** Asserts golden signal duration metric attributes and T3 span exemplar correlation. */
  private void assertDurationMetricAndExemplar(
      long expectedStatusCode, SpanContext expectedOperationSpanContext) {
    MetricData durationMetric =
        metricReader.collectAllMetrics().stream()
            .filter(metric -> CLIENT_REQUEST_DURATION_METRIC.equals(metric.getName()))
            .findFirst()
            .orElseThrow(
                () -> new AssertionError("Expected metric " + CLIENT_REQUEST_DURATION_METRIC));

    HistogramPointData point =
        durationMetric.getHistogramData().getPoints().stream()
            .findFirst()
            .orElseThrow(() -> new AssertionError("Expected histogram data point"));
    Attributes metricAttributes = point.getAttributes();
    assertThat(
            metricAttributes.get(
                AttributeKey.stringKey(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE)))
        .isEqualTo("http");
    assertThat(
            metricAttributes.get(
                AttributeKey.stringKey(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE)))
        .isEqualTo("compute");
    assertThat(
            metricAttributes.get(
                AttributeKey.stringKey(ObservabilityAttributes.URL_TEMPLATE_ATTRIBUTE)))
        .isEqualTo(EXPECTED_URL_TEMPLATE);
    assertThat(
            metricAttributes.get(
                AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE)))
        .isEqualTo(expectedStatusCode);

    assertThat(point.getExemplars()).isNotEmpty();
    ExemplarData exemplar = point.getExemplars().get(0);
    assertThat(exemplar.getSpanContext()).isEqualTo(expectedOperationSpanContext);
  }

  /**
   * Logback appender that captures events along with the active OpenTelemetry {@link SpanContext}.
   */
  private static class SpanCapturingAppender extends AppenderBase<ILoggingEvent> {
    private final List<ILoggingEvent> events = new CopyOnWriteArrayList<>();
    private final Map<ILoggingEvent, SpanContext> eventSpanContexts = new ConcurrentHashMap<>();

    /** Records each logging event and the active span context on the emitting thread. */
    @Override
    protected void append(ILoggingEvent eventObject) {
      eventSpanContexts.put(eventObject, Span.current().getSpanContext());
      events.add(eventObject);
    }
  }
}

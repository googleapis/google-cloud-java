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

package com.google.cloud.compute.v1.integration;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.CompositeTracerFactory;
import com.google.api.gax.tracing.LoggingTracerFactory;
import com.google.api.gax.tracing.ObservabilityAttributes;
import com.google.api.gax.tracing.OpenTelemetryMetricsFactory;
import com.google.api.gax.tracing.OpenTelemetryTracingFactory;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.compute.v1.InstancesClient;
import com.google.cloud.compute.v1.InstancesSettings;
import com.google.cloud.trace.v1.TraceServiceClient;
import com.google.cloud.trace.v1.TraceServiceSettings;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.TraceSpan;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.TraceFlags;
import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.event.KeyValuePair;

/**
 * Integration tests for Compute observability "golden signals". Validates that traces, metrics, and
 * actionable error logs are correctly recorded and exported.
 */
public class ITComputeGoldenSignals extends BaseTest {
  private static final Logger logger =
      (Logger) LoggerFactory.getLogger(ITComputeGoldenSignals.class);
  private static final String TELEMETRY_ENDPOINT = "https://telemetry.googleapis.com";

  private OpenTelemetrySdk openTelemetrySdk;
  private TraceServiceClient traceClient;
  private String rootSpanName;
  private Tracer tracer;
  private CompositeTracerFactory compositeFactory;
  private InMemoryMetricReader metricReader;
  private TestAppender testAppender;

  @Before
  public void setUp() throws Exception {
    rootSpanName = "ComputeRootSpan-" + generateRandomHexString(8);

    GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
    credentials.refreshIfExpired();
    String token = credentials.getAccessToken().getTokenValue();

    OtlpGrpcSpanExporter spanExporter =
        OtlpGrpcSpanExporter.builder()
            .setEndpoint(TELEMETRY_ENDPOINT)
            .addHeader("Authorization", "Bearer " + token)
            .addHeader("x-goog-user-project", DEFAULT_PROJECT)
            .build();

    BatchSpanProcessor spanProcessor = BatchSpanProcessor.builder(spanExporter).build();

    Resource resource =
        Resource.getDefault()
            .merge(
                Resource.create(
                    Attributes.of(AttributeKey.stringKey("gcp.project_id"), DEFAULT_PROJECT)));

    metricReader = InMemoryMetricReader.create();
    openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder()
                    .addSpanProcessor(spanProcessor)
                    .setResource(resource)
                    .build())
            .setMeterProvider(
                SdkMeterProvider.builder()
                    .registerMetricReader(metricReader)
                    .setResource(resource)
                    .build())
            .build();

    tracer = openTelemetrySdk.getTracer("testing-compute");

    // Configure TraceServiceClient with retry settings
    TraceServiceSettings.Builder settingsBuilder = TraceServiceSettings.newBuilder();
    settingsBuilder
        .getTraceSettings()
        .setRetrySettings(
            RetrySettings.newBuilder()
                .setTotalTimeoutDuration(Duration.ofSeconds(60))
                .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
                .setMaxRpcTimeoutDuration(Duration.ofSeconds(10))
                .build())
        .setRetryableCodes(StatusCode.Code.NOT_FOUND);

    settingsBuilder
        .getStubSettingsBuilder()
        .setTracerFactory(com.google.api.gax.tracing.BaseApiTracerFactory.getInstance());

    traceClient = TraceServiceClient.create(settingsBuilder.build());

    // Combine tracers using CompositeTracerFactory
    List<ApiTracerFactory> factories =
        Arrays.asList(
            new OpenTelemetryTracingFactory(openTelemetrySdk),
            new OpenTelemetryMetricsFactory(openTelemetrySdk),
            new LoggingTracerFactory());
    compositeFactory = new CompositeTracerFactory(factories);

    // Initialize and attach TestAppender
    testAppender = new TestAppender();
    testAppender.start();
    Logger loggingTracerLogger =
        (Logger) LoggerFactory.getLogger("com.google.api.gax.tracing.LoggingTracer");
    loggingTracerLogger.addAppender(testAppender);
    loggingTracerLogger.setLevel(ch.qos.logback.classic.Level.DEBUG);
  }

  @After
  public void tearDown() throws Exception {
    if (testAppender != null) {
      testAppender.clearEvents();
    }
    if (traceClient != null) {
      traceClient.close();
    }
    if (openTelemetrySdk != null) {
      openTelemetrySdk.close();
    }
    if (testAppender != null) {
      ((Logger) LoggerFactory.getLogger("ROOT")).detachAppender(testAppender);
    }
  }

  /**
   * Creates a root span with a specific trace ID to simulate an external parent context. This helps
   * verify that the library correctly creates child spans that inherit the parent's trace ID.
   *
   * @param traceId The trace ID to use for the root span.
   * @return The created root span.
   */
  private Span createRootSpan(String traceId) {
    SpanContext customSpanContext =
        SpanContext.create(
            traceId, generateRandomHexString(16), TraceFlags.getSampled(), TraceState.getDefault());
    return tracer
        .spanBuilder(rootSpanName)
        .setParent(Context.root().with(Span.wrap(customSpanContext)))
        .startSpan();
  }

  /**
   * Tests that a successful compute operation generates traces that are correctly exported to Cloud
   * Trace.
   */
  @Test
  public void testComputeOperationTracing() throws Exception {
    String localTraceId = generateRandomHexString(32);
    Span rootSpan = createRootSpan(localTraceId);

    try (Scope scope = rootSpan.makeCurrent()) {
      InstancesSettings.Builder settingsBuilder = InstancesSettings.newBuilder();
      settingsBuilder.getStubSettingsBuilder().setTracerFactory(compositeFactory);

      try (InstancesClient client = InstancesClient.create(settingsBuilder.build())) {
        logger.info("Listing instances in project: " + DEFAULT_PROJECT + " zone: " + DEFAULT_ZONE);
        client.list(DEFAULT_PROJECT, DEFAULT_ZONE);
      }
    } finally {
      rootSpan.end();
    }

    openTelemetrySdk.getSdkTracerProvider().forceFlush();
    fetchAndValidateTrace(localTraceId, false);
    validateMetrics();
    validateLogging(false);
  }

  /** Tests that a failed compute operation generates traces with error attributes. */
  @Test
  public void testComputeOperationTracing_Error() throws Exception {
    String localTraceId = generateRandomHexString(32);
    Span rootSpan = createRootSpan(localTraceId);

    try (Scope scope = rootSpan.makeCurrent()) {
      InstancesSettings.Builder settingsBuilder = InstancesSettings.newBuilder();
      settingsBuilder.getStubSettingsBuilder().setTracerFactory(compositeFactory);

      try (InstancesClient client = InstancesClient.create(settingsBuilder.build())) {
        logger.info("Triggering error by listing instances in invalid project...");
        client.list("invalid-project-" + UUID.randomUUID().toString(), DEFAULT_ZONE);
        fail("Expected exception not thrown");
      } catch (Exception e) {
        logger.info("Caught expected exception: " + e.getMessage());
      }
    } finally {
      rootSpan.end();
    }

    openTelemetrySdk.getSdkTracerProvider().forceFlush();
    fetchAndValidateTrace(localTraceId, true);
    validateMetrics();
    validateLogging(true);
  }

  private void fetchAndValidateTrace(String traceId, boolean expectError) throws Exception {
    Trace trace = traceClient.getTrace(DEFAULT_PROJECT, traceId);
    assertThat(trace).isNotNull();

    for (TraceSpan span : trace.getSpansList()) {
      logger.info("Verifying attributes for span: " + span.getName());

      // Skip root span as it's manually created and doesn't have RPC attributes.
      if (span.getName().contains("ComputeRootSpan")) {
        continue;
      }

      // Assert RPC span name pattern {method} {url template}
      assertThat(span.getName())
          .isEqualTo("GET compute/v1/projects/{project=*}/zones/{zone=*}/instances");

      // Compute uses HTTP/REST, so we check for rpc.system.name and other HTTP attributes
      assertThat(span.getLabelsMap().get(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE))
          .isEqualTo("http");
      assertThat(span.getLabelsMap().get(ObservabilityAttributes.URL_DOMAIN_ATTRIBUTE))
          .isEqualTo("compute.googleapis.com");
      assertThat(span.getLabelsMap().get(ObservabilityAttributes.HTTP_METHOD_ATTRIBUTE))
          .isEqualTo("GET");
      assertThat(span.getLabelsMap().get(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE))
          .isEqualTo("compute");
      assertThat(span.getLabelsMap().get(ObservabilityAttributes.REPO_ATTRIBUTE))
          .isEqualTo("googleapis/google-cloud-java");
      assertThat(span.getLabelsMap().get(ObservabilityAttributes.HTTP_URL_TEMPLATE_ATTRIBUTE))
          .isEqualTo("compute/v1/projects/{project=*}/zones/{zone=*}/instances");
      String expectedDestinationResource;
      if (expectError) {
        expectedDestinationResource = "//compute.googleapis.com/projects/invalid-project-";
      } else {
        expectedDestinationResource =
            "//compute.googleapis.com/projects/" + DEFAULT_PROJECT + "/zones/us-central1-a";
      }
      assertThat(span.getLabelsMap().get(ObservabilityAttributes.DESTINATION_RESOURCE_ID_ATTRIBUTE))
          .startsWith(expectedDestinationResource);

      // These might fail if not supported in HTTP/REST yet
      assertThat(span.getLabelsMap()).containsKey(ObservabilityAttributes.HTTP_URL_FULL_ATTRIBUTE);

      if (expectError) {
        assertThat(span.getLabelsMap().get(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE))
            .isEqualTo("404");
      } else {
        assertThat(span.getLabelsMap().get(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE))
            .isEqualTo("200");
      }

      if (expectError) {
        // Verify error attributes
        assertThat(span.getLabelsMap()).containsKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE);
        assertThat(span.getLabelsMap())
            .containsKey(ObservabilityAttributes.EXCEPTION_TYPE_ATTRIBUTE);
        assertThat(span.getLabelsMap())
            .containsKey(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE);
      }
    }
  }

  private void validateMetrics() {
    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    logger.info("Collected " + metrics.size() + " metrics");

    // GoldenSignalsMetricsRecorder.CLIENT_REQUEST_DURATION_METRIC_NAME is package-private
    String expectedMetricName = "gcp.client.request.duration";

    MetricData durationMetric =
        metrics.stream()
            .filter(m -> m.getName().equals(expectedMetricName))
            .findFirst()
            .orElseThrow(
                () -> new AssertionError("Duration metric not found: " + expectedMetricName));

    logger.info("Found duration metric: " + durationMetric.getName());

    // Assert that we have at least one point
    assertThat(durationMetric.getHistogramData().getPoints()).isNotEmpty();

    io.opentelemetry.api.common.Attributes attributes =
        durationMetric.getHistogramData().getPoints().iterator().next().getAttributes();
    assertThat(
            attributes.get(
                AttributeKey.stringKey(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE)))
        .isEqualTo("http");
    assertThat(
            attributes.get(
                AttributeKey.stringKey(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE)))
        .isEqualTo("compute");
    assertThat(
            attributes.get(AttributeKey.stringKey(ObservabilityAttributes.URL_TEMPLATE_ATTRIBUTE)))
        .isEqualTo("compute/v1/projects/{project=*}/zones/{zone=*}/instances");
  }

  private void validateLogging(boolean expectError) {
    List<ILoggingEvent> computeEvents = new ArrayList<>();
    for (ILoggingEvent event : testAppender.events) {
      if (event.getKeyValuePairs() == null) {
        continue;
      }
      Map<String, String> mdc = new HashMap<>();
      for (KeyValuePair kvp : event.getKeyValuePairs()) {
        mdc.put(kvp.key, String.valueOf(kvp.value));
      }
      if (!"compute".equals(mdc.get("gcp.client.service"))) {
        continue;
      }
      computeEvents.add(event);
    }

    if (expectError) {
      assertThat(computeEvents).isNotEmpty();
      ILoggingEvent event = computeEvents.get(computeEvents.size() - 1);
      if (event.getKeyValuePairs() == null) {
        fail("Expected log event to have key value pairs");
      }
      Map<String, String> mdc = new HashMap<>();
      for (KeyValuePair kvp : event.getKeyValuePairs()) {
        mdc.put(kvp.key, String.valueOf(kvp.value));
      }

      assertThat(mdc).containsEntry(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE, "http");
      assertThat(mdc)
          .containsEntry(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE, "compute");
      assertThat(mdc)
          .containsEntry(ObservabilityAttributes.REPO_ATTRIBUTE, "googleapis/google-cloud-java");
      assertThat(mdc).containsEntry(ObservabilityAttributes.HTTP_METHOD_ATTRIBUTE, "GET");
      assertThat(mdc).containsKey("url.template");
      assertThat(mdc).containsKey(ObservabilityAttributes.EXCEPTION_MESSAGE_ATTRIBUTE);
    } else {
      if (!computeEvents.isEmpty()) {
        logger.info("Captured " + computeEvents.size() + " unexpected compute log events:");
        for (ILoggingEvent event : computeEvents) {
          logger.info("Event: " + event.getMessage() + ", Extracted: " + event.getKeyValuePairs());
        }
      }
      assertThat(computeEvents).isEmpty();
    }
  }

  public static class TestAppender extends AppenderBase<ILoggingEvent> {
    public List<ILoggingEvent> events = new ArrayList<>();

    @Override
    protected void append(ILoggingEvent eventObject) {
      events.add(eventObject);
    }

    public void clearEvents() {
      events.clear();
    }
  }

  private String generateRandomHexString(int length) {
    return UUID.randomUUID().toString().replace("-", "").substring(0, length);
  }
}

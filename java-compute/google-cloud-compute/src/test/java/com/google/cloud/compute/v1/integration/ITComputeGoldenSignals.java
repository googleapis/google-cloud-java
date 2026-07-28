/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute.v1.integration;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.BaseApiTracerFactory;
import com.google.api.gax.tracing.CompositeTracerFactory;
import com.google.api.gax.tracing.ObservabilityAttributes;
import com.google.api.gax.tracing.OpenTelemetryMetricsFactory;
import com.google.api.gax.tracing.OpenTelemetryTracingFactory;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.compute.v1.InstancesClient;
import com.google.cloud.compute.v1.InstancesSettings;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.cloud.trace.v1.TraceServiceClient;
import com.google.cloud.trace.v1.TraceServiceSettings;
import com.google.common.base.Stopwatch;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.TraceSpan;
import com.google.monitoring.v3.ListTimeSeriesRequest;
import com.google.monitoring.v3.ListTimeSeriesResponse;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeInterval;
import com.google.monitoring.v3.TimeSeries;
import com.google.protobuf.util.Timestamps;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.TraceFlags;
import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporter;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
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
  private static final String CLIENT_REQUEST_DURATION_METRIC = "gcp.client.request.duration";
  private static final String CLOUD_AVAILABILITY_ZONE = "cloud.availability_zone";
  private static final String CLOUD_REGION = "cloud.region";
  private static final String TEST_AVAILABILITY_ZONE = "us-central1-a";
  private static final String TEST_REGION = "us-central1";
  private static final String INSTANCE_NAME = "compute-test-instance";
  private static final String SERVICE_NAME_PREFIX = "compute-golden-signals-test-";
  // Test run ID used to isolate metrics in parallel CI runs.
  private static final String METRIC_FILTER_TEMPLATE =
      "metric.type=\"prometheus.googleapis.com/%s/histogram\" AND"
          + " resource.type=\"prometheus_target\" AND resource.labels.job=\""
          + SERVICE_NAME_PREFIX
          + "%s\"";

  private OpenTelemetrySdk openTelemetrySdk;
  private TraceServiceClient traceClient;
  private String rootSpanName;
  private String testRunId;
  private Tracer tracer;
  private CompositeTracerFactory compositeFactory;
  private InMemoryMetricReader inMemoryReader;
  private TestAppender testAppender;

  @Before
  public void setUp() throws Exception {

    rootSpanName = "ComputeRootSpan-" + generateRandomHexString(8);
    testRunId = generateRandomHexString(8);

    GoogleCredentials credentials =
        GoogleCredentials.getApplicationDefault()
            .createScoped(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"));
    // We explicitly refresh the credentials here to guarantee a valid token is extracted.
    // The standard OTLP exporter does not automatically manage OAuth token lifecycles
    // when they are passed as static header strings.
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
                    Attributes.builder()
                        .put("gcp.project_id", DEFAULT_PROJECT)
                        .put("test_run_id", testRunId)
                        .put("instance", INSTANCE_NAME)
                        .put("service.name", SERVICE_NAME_PREFIX + testRunId)
                        .put(CLOUD_AVAILABILITY_ZONE, TEST_AVAILABILITY_ZONE)
                        .put(CLOUD_REGION, TEST_REGION)
                        .build()));

    inMemoryReader = InMemoryMetricReader.create();
    // Note: The standard OTel OTLP exporter does not support passing GoogleCredentials directly.
    OtlpGrpcMetricExporter metricExporter =
        OtlpGrpcMetricExporter.builder()
            .setEndpoint(TELEMETRY_ENDPOINT)
            .addHeader("Authorization", "Bearer " + token)
            .addHeader("x-goog-user-project", DEFAULT_PROJECT)
            .build();
    PeriodicMetricReader exportedMetricsReader =
        PeriodicMetricReader.builder(metricExporter).build();

    openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder()
                    .addSpanProcessor(spanProcessor)
                    .setResource(resource)
                    .build())
            .setMeterProvider(
                SdkMeterProvider.builder()
                    .registerMetricReader(inMemoryReader)
                    .registerMetricReader(exportedMetricsReader)
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
                .setTotalTimeoutDuration(Duration.ofMinutes(5))
                .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
                .setMaxRpcTimeoutDuration(Duration.ofSeconds(10))
                .build())
        .setRetryableCodes(
            StatusCode.Code.NOT_FOUND, StatusCode.Code.INTERNAL, StatusCode.Code.DEADLINE_EXCEEDED);

    settingsBuilder.getStubSettingsBuilder().setTracerFactory(BaseApiTracerFactory.getInstance());

    traceClient = TraceServiceClient.create(settingsBuilder.build());

    // Combine tracers using CompositeTracerFactory
    List<ApiTracerFactory> factories =
        Arrays.asList(
            new OpenTelemetryTracingFactory(openTelemetrySdk),
            new OpenTelemetryMetricsFactory(openTelemetrySdk));
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
      ((Logger) LoggerFactory.getLogger("com.google.api.gax.tracing.LoggingTracer"))
          .detachAppender(testAppender);
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
    openTelemetrySdk.getSdkMeterProvider().forceFlush();
    fetchAndValidateTrace(localTraceId, false);
    verifyMetrics(false);
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
        client.list("invalid-project-id", DEFAULT_ZONE);
        fail("Expected exception not thrown");
      } catch (Exception e) {
        logger.info("Caught expected exception: " + e.getMessage());
      }
    } finally {
      rootSpan.end();
    }

    openTelemetrySdk.getSdkTracerProvider().forceFlush();
    openTelemetrySdk.getSdkMeterProvider().forceFlush();

    fetchAndValidateTrace(localTraceId, true);
    verifyMetrics(true);
    validateLogging(true);
  }

  private void fetchAndValidateTrace(String traceId, boolean expectError) throws Exception {
    Trace trace = null;
    try {
      trace = traceClient.getTrace(DEFAULT_PROJECT, traceId);
    } catch (Exception e) {
      logger.error(
          "Exception occurred while fetching trace for project: "
              + DEFAULT_PROJECT
              + ", traceId: "
              + traceId,
          e);
      throw e;
    }
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
        expectedDestinationResource = "//compute.googleapis.com/projects/invalid-project-id";
      } else {
        expectedDestinationResource =
            "//compute.googleapis.com/projects/" + DEFAULT_PROJECT + "/zones/us-central1-a";
      }
      assertThat(span.getLabelsMap().get(ObservabilityAttributes.DESTINATION_RESOURCE_ID_ATTRIBUTE))
          .startsWith(expectedDestinationResource);

      String expectedUrl;
      if (expectError) {
        expectedUrl =
            "https://compute.googleapis.com:443/compute/v1/projects/invalid-project-id/zones/us-central1-a/instances";
      } else {
        expectedUrl =
            "https://compute.googleapis.com:443/compute/v1/projects/"
                + DEFAULT_PROJECT
                + "/zones/us-central1-a/instances";
      }
      assertThat(span.getLabelsMap().get(ObservabilityAttributes.HTTP_URL_FULL_ATTRIBUTE))
          .isEqualTo(expectedUrl);

      if (expectError) {
        assertThat(span.getLabelsMap().get(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE))
            .isEqualTo("404");
        // Verify error attributes
        assertThat(span.getLabelsMap().get(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE))
            .isEqualTo("404");
        assertThat(span.getLabelsMap().get(ObservabilityAttributes.EXCEPTION_TYPE_ATTRIBUTE))
            .contains("NotFoundException");
        assertThat(span.getLabelsMap().get(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE))
            .contains("was not found");
      } else {
        assertThat(span.getLabelsMap().get(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE))
            .isEqualTo("200");
      }
    }
  }

  private void validateMetrics(boolean expectError) {
    Collection<MetricData> metrics = inMemoryReader.collectAllMetrics();
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

    // New assertions
    String expectedStatus = expectError ? "404" : "200";

    assertThat(
            attributes.get(
                AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE)))
        .isEqualTo(Long.valueOf(expectedStatus));

    assertThat(attributes.get(AttributeKey.stringKey(ObservabilityAttributes.REPO_ATTRIBUTE)))
        .isEqualTo("googleapis/google-cloud-java");
  }

  private void validateMetricsInCloudMonitoring(boolean expectError) throws Exception {
    MetricServiceClient metricClient = MetricServiceClient.create();
    try {
      // Use filter for the specific metric and project, isolated by testRunId
      String filter =
          String.format(METRIC_FILTER_TEMPLATE, CLIENT_REQUEST_DURATION_METRIC, testRunId);

      ProjectName name = ProjectName.of(DEFAULT_PROJECT);

      Instant start = Instant.now().minus(Duration.ofMinutes(5));
      Instant end = Instant.now().plus(Duration.ofMinutes(5));

      TimeInterval interval =
          TimeInterval.newBuilder()
              .setStartTime(Timestamps.fromMillis(start.toEpochMilli()))
              .setEndTime(Timestamps.fromMillis(end.toEpochMilli()))
              .build();

      ListTimeSeriesRequest request =
          ListTimeSeriesRequest.newBuilder()
              .setName(name.toString())
              .setFilter(filter)
              .setInterval(interval)
              .setView(ListTimeSeriesRequest.TimeSeriesView.FULL)
              .build();

      TimeSeries targetTs = pollForTimeSeries(metricClient, request);

      assertThat(targetTs).isNotNull();
      logger.info("Found target metrics in Cloud Monitoring!");

      TimeSeries ts = targetTs;
      Map<String, String> metricLabels = ts.getMetric().getLabelsMap();
      logger.info("Metric labels from Cloud Monitoring: " + metricLabels);

      String expectedStatus = expectError ? "404" : "200";

      // Verify attributes (Prometheus metrics retain dots in keys)
      assertThat(metricLabels.get(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE))
          .isEqualTo("compute");
      assertThat(metricLabels.get(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE))
          .isEqualTo("http");
      assertThat(metricLabels.get(ObservabilityAttributes.URL_DOMAIN_ATTRIBUTE))
          .isEqualTo("compute.googleapis.com");
      assertThat(metricLabels.get(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE))
          .isEqualTo("compute.googleapis.com");
      assertThat(metricLabels.get(ObservabilityAttributes.REPO_ATTRIBUTE))
          .isEqualTo("googleapis/google-cloud-java");

      assertThat(metricLabels.get(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE))
          .isEqualTo(expectedStatus);

      if (metricLabels.containsKey("url_template")) {
        assertThat(metricLabels.get("url_template")).startsWith("/compute/v1/projects/");
      }

    } finally {
      metricClient.close();
    }
  }

  private TimeSeries pollForTimeSeries(
      MetricServiceClient metricClient, ListTimeSeriesRequest request) throws InterruptedException {

    long initialSleepMs = Duration.ofMinutes(3).toMillis();
    logger.info(
        "Sleeping for " + (initialSleepMs / 1000) + " seconds to allow metrics ingestion...");
    Thread.sleep(initialSleepMs);

    Stopwatch metricsPollingStopwatch = Stopwatch.createStarted();
    Duration totalTimeout = Duration.ofMinutes(5);
    Duration pollInterval = Duration.ofSeconds(30);
    TimeSeries targetTs = null;

    while (metricsPollingStopwatch.elapsed().compareTo(totalTimeout) < 0) {
      try {
        ListTimeSeriesResponse response = metricClient.listTimeSeriesCallable().call(request);
        for (TimeSeries ts : response.getTimeSeriesList()) {
          Map<String, String> resourceLabels = ts.getResource().getLabelsMap();
          if ((SERVICE_NAME_PREFIX + testRunId).equals(resourceLabels.get("job"))) {
            targetTs = ts;
            break;
          }
        }
        if (targetTs != null) {
          break;
        }
      } catch (NotFoundException e) {
        logger.info("Metric not found yet (NotFoundException): " + e.getMessage());
      } catch (StatusRuntimeException e) {
        if (e.getStatus().getCode() == Status.Code.NOT_FOUND) {
          logger.info("Metric not found yet (gRPC NOT_FOUND): " + e.getMessage());
        } else {
          logger.error(
              "Encountered unexpected StatusRuntimeException while polling for metrics", e);
          throw e;
        }
      }
      logger.info("Waiting for metrics in Cloud Monitoring, retrying in 30 seconds...");
      Thread.sleep(pollInterval.toMillis());
    }
    return targetTs;
  }

  private void verifyMetrics(boolean expectError) throws Exception {
    validateMetrics(expectError);
    validateMetricsInCloudMonitoring(expectError);
  }

  private void validateLogging(boolean expectError) {

    List<ILoggingEvent> computeEvents = new ArrayList<>();
    for (ILoggingEvent event : testAppender.events) {
      Map<String, String> mdc = new HashMap<>();
      if (event.getKeyValuePairs() != null) {
        for (KeyValuePair kvp : event.getKeyValuePairs()) {
          mdc.put(kvp.key, String.valueOf(kvp.value));
        }
      } else if (event.getMDCPropertyMap() != null) {
        mdc.putAll(event.getMDCPropertyMap());
      } else {
        logger.warn("Found log without KV pairs nor MDC Property Map: " + event);
        continue;
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
    public List<ILoggingEvent> events = new CopyOnWriteArrayList<>();

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

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

package com.google.showcase.v1beta1.it.logging;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.CompositeTracerFactory;
import com.google.api.gax.tracing.LoggingTracerFactory;
import com.google.api.gax.tracing.ObservabilityAttributes;
import com.google.api.gax.tracing.OpenTelemetryMetricsFactory;
import com.google.api.gax.tracing.OpenTelemetryTracingFactory;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Any;
import com.google.rpc.ErrorInfo;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import com.google.showcase.v1beta1.stub.EchoStubSettings;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanKind;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.event.KeyValuePair;

public class ITActionableErrorsLogging {

  private static EchoClient grpcClient;
  private static EchoClient httpjsonClient;
  private TestAppender testAppender;

  @BeforeAll
  static void createClients() throws Exception {
    grpcClient =
        TestClientInitializer.createGrpcEchoClientOpentelemetry(new LoggingTracerFactory());
    httpjsonClient =
        TestClientInitializer.createHttpJsonEchoClientOpentelemetry(new LoggingTracerFactory());
  }

  @AfterAll
  static void destroyClients() throws InterruptedException {
    grpcClient.close();
    httpjsonClient.close();

    grpcClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    httpjsonClient.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  private TestAppender setupTestLogger(String loggerName, Level level) {
    TestAppender appender = new TestAppender();
    appender.start();
    Logger logger = (Logger) LoggerFactory.getLogger(loggerName);
    logger.setLevel(level);
    logger.addAppender(appender);
    return appender;
  }

  @BeforeEach
  void setupTestLogger() {
    testAppender = setupTestLogger("com.google.api.gax.tracing.LoggingTracer", Level.DEBUG);
    testAppender.clearEvents();
  }

  @AfterEach
  void teardownTestLogger() {
    if (testAppender != null) {
      testAppender.stop();
      Logger logger = (Logger) LoggerFactory.getLogger("com.google.api.gax.tracing.LoggingTracer");
      logger.detachAppender(testAppender);
      testAppender.clearEvents();
    }
  }

  /**
   * Polls asynchronously until an ERROR logging event is appended or timeout is reached.
   *
   * <p>Logging of operation failure in TraceFinisher occurs asynchronously on a background executor
   * thread, so Awaitility is used to prevent test flakiness and race conditions.
   *
   * @return the first {@link ILoggingEvent} with ERROR level
   */
  private ILoggingEvent getErrorLoggingEvent() {
    Awaitility.await()
        .atMost(Duration.ofSeconds(5))
        .until(() -> testAppender.events.stream().anyMatch(e -> e.getLevel() == Level.ERROR));
    return testAppender.events.stream()
        .filter(event -> event.getLevel() == Level.ERROR)
        .findFirst()
        .orElseThrow(
            () -> new AssertionError("Expected an ERROR log event in: " + testAppender.events));
  }

  private Map<String, Object> getKvps(ILoggingEvent loggingEvent) {
    Map<String, Object> map = new HashMap<>();
    if (loggingEvent.getKeyValuePairs() != null) {
      for (KeyValuePair kvp : loggingEvent.getKeyValuePairs()) {
        map.put(kvp.key, kvp.value);
      }
    }
    return map;
  }

  private EchoRequest buildErrorRequest() {
    ErrorInfo errorInfo =
        ErrorInfo.newBuilder()
            .setReason("TEST_REASON")
            .setDomain("test.googleapis.com")
            .putMetadata("test_metadata", "test_value")
            .build();
    Status status =
        Status.newBuilder()
            .setCode(3) // INVALID_ARGUMENT
            .setMessage("This is a test error")
            .addDetails(Any.pack(errorInfo))
            .build();
    return EchoRequest.newBuilder().setError(status).build();
  }

  @Test
  void testHttpJson_logEmittedForLowLevelRequestFailure() throws Exception {
    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(409); // ABORTED
                response.setContentType("application/json");
                String jsonError =
                    "{\n"
                        + "  \"error\": {\n"
                        + "    \"code\": 409,\n"
                        + "    \"message\": \"This is a mock JSON error generated by the"
                        + " server\",\n"
                        + "    \"status\": \"ABORTED\",\n"
                        + "    \"details\": [\n"
                        + "      {\n"
                        + "        \"@type\": \"type.googleapis.com/google.rpc.ErrorInfo\",\n"
                        + "        \"reason\": \"mock_error_reason\",\n"
                        + "        \"domain\": \"mock.googleapis.com\",\n"
                        + "        \"metadata\": {\"mock_key\": \"mock_value\"}\n"
                        + "      }\n"
                        + "    ]\n"
                        + "  }\n"
                        + "}";
                response.setContent(jsonError);
                return response;
              }
            };
          }
        };

    EchoSettings httpJsonEchoSettings =
        EchoSettings.newHttpJsonBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockTransport)
                    .setEndpoint(TestClientInitializer.DEFAULT_HTTPJSON_ENDPOINT)
                    .build())
            .build();

    com.google.showcase.v1beta1.stub.EchoStubSettings echoStubSettings =
        (com.google.showcase.v1beta1.stub.EchoStubSettings)
            httpJsonEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(new LoggingTracerFactory())
                .build();
    com.google.showcase.v1beta1.stub.EchoStub stub = echoStubSettings.createStub();
    EchoClient mockHttpJsonClient = EchoClient.create(stub);
    try {
      EchoRequest request = EchoRequest.newBuilder().build();
      assertThrows(ApiException.class, () -> mockHttpJsonClient.echo(request));

      ILoggingEvent loggingEvent = getErrorLoggingEvent();
      assertThat(loggingEvent.getLevel()).isEqualTo(Level.ERROR);

      assertThat(loggingEvent.getMessage())
          .contains("This is a mock JSON error generated by the server");

      Map<String, Object> kvps = getKvps(loggingEvent);
      assertThat(kvps).containsEntry(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE, "http");
      assertThat(kvps).containsEntry(ObservabilityAttributes.HTTP_METHOD_ATTRIBUTE, "POST");
      assertThat(kvps)
          .containsEntry(ObservabilityAttributes.HTTP_URL_TEMPLATE_ATTRIBUTE, "v1beta1/echo:echo");
      assertThat(kvps)
          .containsEntry(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE, "ABORTED");
      assertThat(kvps)
          .containsEntry(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE, "mock_error_reason");
      assertThat(kvps)
          .containsEntry(ObservabilityAttributes.ERROR_DOMAIN_ATTRIBUTE, "mock.googleapis.com");
      assertThat(kvps)
          .containsEntry(
              ObservabilityAttributes.ERROR_METADATA_ATTRIBUTE_PREFIX + "mock_key", "mock_value");
    } finally {
      mockHttpJsonClient.close();
      mockHttpJsonClient.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  @Test
  void testHttpJson_noLogEmittedForSuccess() {
    testAppender.clearEvents();
    EchoRequest request = EchoRequest.newBuilder().setContent("Success").build();
    httpjsonClient.echo(request);
    assertThat(testAppender.events.size()).isEqualTo(0);
  }

  @Test
  void testHttpJson_clientLevelFailureAttributes() throws Exception {
    com.google.showcase.v1beta1.stub.EchoStubSettings.Builder stubSettingsBuilder =
        com.google.showcase.v1beta1.stub.EchoStubSettings.newHttpJsonBuilder();
    stubSettingsBuilder
        .echoSettings()
        .setRetrySettings(
            com.google.api.gax.retrying.RetrySettings.newBuilder().setMaxAttempts(1).build());
    stubSettingsBuilder.setTracerFactory(new LoggingTracerFactory());
    stubSettingsBuilder.setCredentialsProvider(NoCredentialsProvider.create());
    stubSettingsBuilder.setEndpoint("localhost:1");

    com.google.showcase.v1beta1.stub.EchoStub stub = stubSettingsBuilder.build().createStub();
    EchoClient client = EchoClient.create(stub);
    try {
      assertThrows(ApiException.class, () -> client.echo(EchoRequest.newBuilder().build()));
      ILoggingEvent loggingEvent = getErrorLoggingEvent();
      assertThat(loggingEvent.getLevel()).isEqualTo(Level.ERROR);
      assertThat(loggingEvent.getMessage()).isNotEmpty();
      Map<String, Object> kvps = getKvps(loggingEvent);
      assertThat(kvps).containsEntry(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE, "http");
    } finally {
      client.shutdownNow();
      client.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  @Test
  void testGrpc_logEmittedForLowLevelRequestFailure() {
    EchoRequest request = buildErrorRequest();
    assertThrows(ApiException.class, () -> grpcClient.echo(request));

    ILoggingEvent loggingEvent = getErrorLoggingEvent();
    assertThat(loggingEvent.getLevel()).isEqualTo(Level.ERROR);
    assertThat(loggingEvent.getMessage()).contains("This is a test error");

    Map<String, Object> kvps = getKvps(loggingEvent);
    assertThat(kvps).containsEntry(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE, "grpc");
    assertThat(kvps)
        .containsEntry(
            ObservabilityAttributes.GRPC_RPC_METHOD_ATTRIBUTE, "google.showcase.v1beta1.Echo/Echo");
    assertThat(kvps)
        .containsEntry(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE, "INVALID_ARGUMENT");
    assertThat(kvps).containsEntry(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE, "TEST_REASON");
    assertThat(kvps)
        .containsEntry(ObservabilityAttributes.ERROR_DOMAIN_ATTRIBUTE, "test.googleapis.com");
    assertThat(kvps)
        .containsEntry(
            ObservabilityAttributes.ERROR_METADATA_ATTRIBUTE_PREFIX + "test_metadata",
            "test_value");
  }

  @Test
  void testGrpc_noLogEmittedForSuccess() {
    testAppender.clearEvents();
    EchoRequest request = EchoRequest.newBuilder().setContent("Success").build();
    grpcClient.echo(request);
    assertThat(testAppender.events.size()).isEqualTo(0);
  }

  @Test
  void testGrpc_clientLevelFailureAttributes() throws Exception {
    com.google.showcase.v1beta1.stub.EchoStubSettings.Builder stubSettingsBuilder =
        com.google.showcase.v1beta1.stub.EchoStubSettings.newBuilder();
    stubSettingsBuilder
        .echoSettings()
        .setRetrySettings(
            com.google.api.gax.retrying.RetrySettings.newBuilder().setMaxAttempts(1).build());
    stubSettingsBuilder.setTracerFactory(new LoggingTracerFactory());
    stubSettingsBuilder.setCredentialsProvider(NoCredentialsProvider.create());
    stubSettingsBuilder.setEndpoint("localhost:1");

    com.google.showcase.v1beta1.stub.EchoStub stub = stubSettingsBuilder.build().createStub();
    EchoClient client = EchoClient.create(stub);
    try {
      assertThrows(ApiException.class, () -> client.echo(EchoRequest.newBuilder().build()));
      ILoggingEvent loggingEvent = getErrorLoggingEvent();
      assertThat(loggingEvent.getLevel()).isEqualTo(Level.ERROR);
      assertThat(loggingEvent.getMessage()).isNotEmpty();
      Map<String, Object> kvps = getKvps(loggingEvent);
      assertThat(kvps).containsEntry(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE, "grpc");
    } finally {
      client.shutdownNow();
      client.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  /**
   * Builds a nested {@link CompositeTracerFactory} mirroring {@code ClientContext}: an outer {@link
   * LoggingTracerFactory} paired with an inner {@link CompositeTracerFactory} combining
   * OpenTelemetry metrics and tracing.
   *
   * @param openTelemetry the {@link OpenTelemetry} instance for metrics and tracing factories
   * @return a configured {@link ApiTracerFactory}
   */
  private ApiTracerFactory createNestedObservabilityTracerFactory(OpenTelemetry openTelemetry) {
    CompositeTracerFactory innerFactory =
        new CompositeTracerFactory(
            ImmutableList.of(
                new OpenTelemetryMetricsFactory(openTelemetry),
                new OpenTelemetryTracingFactory(openTelemetry)));
    return new CompositeTracerFactory(ImmutableList.of(new LoggingTracerFactory(), innerFactory));
  }

  /**
   * Asserts that attempt-level DEBUG logs correlate with the CLIENT attempt span, operation-level
   * ERROR logs and metric exemplars correlate with the INTERNAL operation span, and no active span
   * leaks onto the calling thread.
   *
   * @param spanExporter the exporter holding finished spans
   * @param metricReader the reader holding recorded golden signal metrics
   * @return the {@link SpanContext} of the exported attempt span
   */
  private SpanContext assertObservabilitySpanCorrelation(
      InMemorySpanExporter spanExporter, InMemoryMetricReader metricReader) {
    Awaitility.await()
        .atMost(Duration.ofSeconds(5))
        .until(
            () ->
                testAppender.events.stream().anyMatch(e -> e.getLevel() == Level.DEBUG)
                    && testAppender.events.stream().anyMatch(e -> e.getLevel() == Level.ERROR)
                    && spanExporter.getFinishedSpanItems().size() >= 2);

    List<SpanData> finishedSpans = spanExporter.getFinishedSpanItems();
    SpanData attemptSpanData =
        finishedSpans.stream()
            .filter(span -> span.getKind() == SpanKind.CLIENT)
            .findFirst()
            .orElseThrow(() -> new AssertionError("Expected CLIENT attempt span"));
    SpanData operationSpanData =
        finishedSpans.stream()
            .filter(span -> span.getKind() == SpanKind.INTERNAL)
            .findFirst()
            .orElseThrow(() -> new AssertionError("Expected INTERNAL operation span"));
    assertThat(attemptSpanData.getParentSpanId()).isEqualTo(operationSpanData.getSpanId());

    ILoggingEvent debugEvent =
        testAppender.events.stream()
            .filter(event -> event.getLevel() == Level.DEBUG)
            .findFirst()
            .orElseThrow(() -> new AssertionError("Expected DEBUG attempt failure log"));
    ILoggingEvent errorEvent =
        testAppender.events.stream()
            .filter(event -> event.getLevel() == Level.ERROR)
            .findFirst()
            .orElseThrow(() -> new AssertionError("Expected ERROR operation failure log"));

    assertThat(testAppender.eventSpanContexts.get(debugEvent))
        .isEqualTo(attemptSpanData.getSpanContext());
    assertThat(testAppender.eventSpanContexts.get(errorEvent))
        .isEqualTo(operationSpanData.getSpanContext());

    // Collect metrics once after Awaitility completes because InMemoryMetricReader resets its
    // ExemplarReservoir on each collection.
    MetricData durationMetric =
        metricReader.collectAllMetrics().stream()
            .filter(metric -> metric.getName().equals("gcp.client.request.duration"))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Expected gcp.client.request.duration metric"));
    HistogramPointData point =
        durationMetric.getHistogramData().getPoints().stream()
            .findFirst()
            .orElseThrow(() -> new AssertionError("Expected histogram data point"));
    assertThat(point.getExemplars()).isNotEmpty();
    ExemplarData exemplar = point.getExemplars().get(0);
    assertThat(exemplar.getSpanContext()).isEqualTo(operationSpanData.getSpanContext());

    assertThat(Span.current().getSpanContext().isValid()).isFalse();
    return attemptSpanData.getSpanContext();
  }

  /**
   * Verifies that for a failing HTTP/JSON RPC, attempt DEBUG logs capture the attempt span and
   * operation ERROR logs and metric exemplars capture the operation span without leaking an active
   * scope onto the calling thread.
   */
  @Test
  void testHttpJson_spanContextCapturedInScopeDuringErrorLog() throws Exception {
    InMemorySpanExporter spanExporter = InMemorySpanExporter.create();
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();

    try (SdkTracerProvider tracerProvider =
            SdkTracerProvider.builder()
                .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
                .build();
        SdkMeterProvider meterProvider =
            SdkMeterProvider.builder().registerMetricReader(metricReader).build()) {
      OpenTelemetry openTelemetry =
          OpenTelemetrySdk.builder()
              .setTracerProvider(tracerProvider)
              .setMeterProvider(meterProvider)
              .build();

      EchoSettings httpJsonEchoSettings =
          EchoSettings.newHttpJsonBuilder()
              .setCredentialsProvider(NoCredentialsProvider.create())
              .setTransportChannelProvider(
                  EchoSettings.defaultHttpJsonTransportProviderBuilder()
                      .setHttpTransport(
                          new MockHttpTransport() {
                            @Override
                            public LowLevelHttpRequest buildRequest(String method, String url) {
                              return new MockLowLevelHttpRequest() {
                                @Override
                                public LowLevelHttpResponse execute() {
                                  MockLowLevelHttpResponse response =
                                      new MockLowLevelHttpResponse();
                                  response.setStatusCode(409);
                                  response.setContentType("application/json");
                                  response.setContent(
                                      "{\"error\": {\"code\": 409, \"message\": \"Aborted"
                                          + " failure\", \"status\": \"ABORTED\"}}");
                                  return response;
                                }
                              };
                            }
                          })
                      .setEndpoint(TestClientInitializer.DEFAULT_HTTPJSON_ENDPOINT)
                      .build())
              .build();

      EchoStubSettings echoStubSettings =
          (EchoStubSettings)
              httpJsonEchoSettings.getStubSettings().toBuilder()
                  .setTracerFactory(createNestedObservabilityTracerFactory(openTelemetry))
                  .build();

      EchoClient client = EchoClient.create(echoStubSettings.createStub());
      try {
        assertThrows(ApiException.class, () -> client.echo(EchoRequest.newBuilder().build()));
        assertObservabilitySpanCorrelation(spanExporter, metricReader);
      } finally {
        client.shutdownNow();
        client.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
      }
    }
  }

  /**
   * Verifies that for a failing gRPC RPC, downstream gRPC {@link ClientInterceptor}s and attempt
   * DEBUG logs capture the attempt span, while operation ERROR logs and metric exemplars capture
   * the operation span.
   */
  @Test
  void testGrpc_spanContextCapturedInScopeDuringErrorLogAndDownstreamInterceptor()
      throws Exception {
    InMemorySpanExporter spanExporter = InMemorySpanExporter.create();
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    List<SpanContext> downstreamGrpcContexts = new CopyOnWriteArrayList<>();

    ClientInterceptor contextCapturingInterceptor =
        new ClientInterceptor() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
              MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
            downstreamGrpcContexts.add(Span.current().getSpanContext());
            return next.newCall(method, callOptions);
          }
        };

    try (SdkTracerProvider tracerProvider =
            SdkTracerProvider.builder()
                .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
                .build();
        SdkMeterProvider meterProvider =
            SdkMeterProvider.builder().registerMetricReader(metricReader).build()) {
      OpenTelemetry openTelemetry =
          OpenTelemetrySdk.builder()
              .setTracerProvider(tracerProvider)
              .setMeterProvider(meterProvider)
              .build();

      EchoSettings grpcEchoSettings =
          EchoSettings.newBuilder()
              .setCredentialsProvider(NoCredentialsProvider.create())
              .setTransportChannelProvider(
                  EchoSettings.defaultGrpcTransportProviderBuilder()
                      .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                      .setInterceptorProvider(() -> ImmutableList.of(contextCapturingInterceptor))
                      .build())
              .setEndpoint(TestClientInitializer.DEFAULT_GRPC_ENDPOINT)
              .build();

      EchoStubSettings echoStubSettings =
          (EchoStubSettings)
              grpcEchoSettings.getStubSettings().toBuilder()
                  .setTracerFactory(createNestedObservabilityTracerFactory(openTelemetry))
                  .build();

      EchoClient client = EchoClient.create(echoStubSettings.createStub());
      try {
        EchoRequest request = buildErrorRequest();
        assertThrows(ApiException.class, () -> client.echo(request));

        SpanContext attemptSpanContext =
            assertObservabilitySpanCorrelation(spanExporter, metricReader);
        assertThat(downstreamGrpcContexts).contains(attemptSpanContext);
      } finally {
        client.shutdownNow();
        client.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
      }
    }
  }
}

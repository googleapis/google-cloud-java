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
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.tracing.LoggingTracerFactory;
import com.google.api.gax.tracing.ObservabilityAttributes;
import com.google.protobuf.Any;
import com.google.rpc.ErrorInfo;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
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
    org.slf4j.Logger logger = LoggerFactory.getLogger(loggerName);
    ((ch.qos.logback.classic.Logger) logger).setLevel(level);
    ((ch.qos.logback.classic.Logger) logger).addAppender(appender);
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
    }
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

    EchoRequest request = EchoRequest.newBuilder().build();
    assertThrows(ApiException.class, () -> mockHttpJsonClient.echo(request));

    assertThat(testAppender.events.size()).isAtLeast(1);
    ILoggingEvent loggingEvent = testAppender.events.get(testAppender.events.size() - 1);

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

    mockHttpJsonClient.close();
    mockHttpJsonClient.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  @Test
  void testHttpJson_noLogEmittedForSuccess() {
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
            com.google.api.gax.retrying.RetrySettings.newBuilder()
                .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(0))
                .setTotalTimeoutDuration(java.time.Duration.ofMillis(0))
                .setMaxAttempts(1)
                .build());
    stubSettingsBuilder.setTracerFactory(new LoggingTracerFactory());
    stubSettingsBuilder.setCredentialsProvider(NoCredentialsProvider.create());
    stubSettingsBuilder.setEndpoint("localhost:1");

    try (com.google.showcase.v1beta1.stub.EchoStub stub = stubSettingsBuilder.build().createStub();
        EchoClient client = EchoClient.create(stub)) {
      assertThrows(ApiException.class, () -> client.echo(EchoRequest.newBuilder().build()));
      assertThat(testAppender.events.size()).isAtLeast(1);
      ILoggingEvent loggingEvent = testAppender.events.get(testAppender.events.size() - 1);
      Map<String, Object> kvps = getKvps(loggingEvent);
      assertThat(kvps).containsEntry(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE, "http");
    }
  }

  @Test
  void testGrpc_logEmittedForLowLevelRequestFailure() {
    EchoRequest request = buildErrorRequest();
    assertThrows(ApiException.class, () -> grpcClient.echo(request));

    assertThat(testAppender.events.size()).isAtLeast(1);
    ILoggingEvent loggingEvent = testAppender.events.get(testAppender.events.size() - 1);
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
            com.google.api.gax.retrying.RetrySettings.newBuilder()
                .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(0))
                .setTotalTimeoutDuration(java.time.Duration.ofMillis(0))
                .setMaxAttempts(1)
                .build());
    stubSettingsBuilder.setTracerFactory(new LoggingTracerFactory());
    stubSettingsBuilder.setCredentialsProvider(NoCredentialsProvider.create());
    stubSettingsBuilder.setEndpoint("localhost:1");

    try (com.google.showcase.v1beta1.stub.EchoStub stub = stubSettingsBuilder.build().createStub();
        EchoClient client = EchoClient.create(stub)) {
      assertThrows(ApiException.class, () -> client.echo(EchoRequest.newBuilder().build()));
      assertThat(testAppender.events.size()).isAtLeast(1);
      ILoggingEvent loggingEvent = testAppender.events.get(testAppender.events.size() - 1);
      Map<String, Object> kvps = getKvps(loggingEvent);
      assertThat(kvps).containsEntry(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE, "grpc");
    }
  }

  @Test
  void testHttpJson_spanContextCapturedInScopeDuringErrorLog() throws Exception {
    io.opentelemetry.sdk.trace.SdkTracerProvider tracerProvider =
        io.opentelemetry.sdk.trace.SdkTracerProvider.builder().build();
    io.opentelemetry.api.OpenTelemetry openTelemetry =
        io.opentelemetry.sdk.OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
    com.google.api.gax.tracing.OpenTelemetryTracingFactory otelFactory =
        new com.google.api.gax.tracing.OpenTelemetryTracingFactory(openTelemetry);
    com.google.api.gax.tracing.CompositeTracerFactory compositeTracerFactory =
        new com.google.api.gax.tracing.CompositeTracerFactory(
            com.google.common.collect.ImmutableList.of(otelFactory, new LoggingTracerFactory()));

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
                                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                                response.setStatusCode(409);
                                response.setContentType("application/json");
                                response.setContent(
                                    "{\"error\": {\"code\": 409, \"message\": \"Aborted"
                                        + " failure\"}}");
                                return response;
                              }
                            };
                          }
                        })
                    .setEndpoint(TestClientInitializer.DEFAULT_HTTPJSON_ENDPOINT)
                    .build())
            .build();

    com.google.showcase.v1beta1.stub.EchoStubSettings echoStubSettings =
        (com.google.showcase.v1beta1.stub.EchoStubSettings)
            httpJsonEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(compositeTracerFactory)
                .build();

    try (EchoClient client = EchoClient.create(echoStubSettings.createStub())) {
      assertThrows(ApiException.class, () -> client.echo(EchoRequest.newBuilder().build()));

      assertThat(testAppender.events.size()).isAtLeast(1);
      assertThat(testAppender.eventSpanContexts.size()).isAtLeast(1);
      io.opentelemetry.api.trace.SpanContext capturedContext =
          testAppender.eventSpanContexts.get(testAppender.eventSpanContexts.size() - 1);

      // Verify that the log was emitted while the attempt span was made current by LoggingTracer
      assertThat(capturedContext.isValid()).isTrue();
      assertThat(capturedContext.getTraceId()).isNotEmpty();
      assertThat(capturedContext.getSpanId()).isNotEmpty();

      // Verify that after the call, the current thread has no active span leak
      assertThat(io.opentelemetry.api.trace.Span.current().getSpanContext().isValid()).isFalse();
    }
  }

  @Test
  void testGrpc_spanContextCapturedInScopeDuringErrorLog() throws Exception {
    io.opentelemetry.sdk.trace.SdkTracerProvider tracerProvider =
        io.opentelemetry.sdk.trace.SdkTracerProvider.builder().build();
    io.opentelemetry.api.OpenTelemetry openTelemetry =
        io.opentelemetry.sdk.OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
    com.google.api.gax.tracing.OpenTelemetryTracingFactory otelFactory =
        new com.google.api.gax.tracing.OpenTelemetryTracingFactory(openTelemetry);
    com.google.api.gax.tracing.CompositeTracerFactory compositeTracerFactory =
        new com.google.api.gax.tracing.CompositeTracerFactory(
            com.google.common.collect.ImmutableList.of(otelFactory, new LoggingTracerFactory()));

    EchoSettings grpcEchoSettings =
        EchoSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(io.grpc.ManagedChannelBuilder::usePlaintext)
                    .build())
            .setEndpoint(TestClientInitializer.DEFAULT_GRPC_ENDPOINT)
            .build();

    com.google.showcase.v1beta1.stub.EchoStubSettings echoStubSettings =
        (com.google.showcase.v1beta1.stub.EchoStubSettings)
            grpcEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(compositeTracerFactory)
                .build();

    try (EchoClient client = EchoClient.create(echoStubSettings.createStub())) {
      EchoRequest request = buildErrorRequest();
      assertThrows(ApiException.class, () -> client.echo(request));

      assertThat(testAppender.events.size()).isAtLeast(1);
      assertThat(testAppender.eventSpanContexts.size()).isAtLeast(1);
      io.opentelemetry.api.trace.SpanContext capturedContext =
          testAppender.eventSpanContexts.get(testAppender.eventSpanContexts.size() - 1);

      // Verify that the log was emitted while the attempt span was made current by LoggingTracer
      assertThat(capturedContext.isValid()).isTrue();
      assertThat(capturedContext.getTraceId()).isNotEmpty();
      assertThat(capturedContext.getSpanId()).isNotEmpty();

      // Verify that after the call, the current thread has no active span leak
      assertThat(io.opentelemetry.api.trace.Span.current().getSpanContext().isValid()).isFalse();
    }
  }
}

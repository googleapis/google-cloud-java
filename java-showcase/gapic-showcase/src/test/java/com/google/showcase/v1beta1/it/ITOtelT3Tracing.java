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

package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.tracing.ObservabilityAttributes;
import com.google.api.gax.tracing.OpenTelemetryTracingFactory;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.BlockRequest;
import com.google.showcase.v1beta1.BlockResponse;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.stub.EchoStub;
import com.google.showcase.v1beta1.stub.EchoStubSettings;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.threeten.bp.Duration;

/** Integration tests for Feature 1 (F1.1–F1.8): Client-level T3 tracing across HTTP and gRPC. */
class ITOtelT3Tracing {
  private static final String SHOWCASE_SERVER_ADDRESS = "localhost";
  private static final long SHOWCASE_SERVER_PORT = 7469;
  private static final String SHOWCASE_GRPC_ENDPOINT =
      String.format("%s:%s", SHOWCASE_SERVER_ADDRESS, SHOWCASE_SERVER_PORT);
  private static final String SHOWCASE_HTTPJSON_ENDPOINT =
      String.format("http://%s:%s", SHOWCASE_SERVER_ADDRESS, SHOWCASE_SERVER_PORT);
  private static final String SHOWCASE_SERVICE_NAME = "showcase";

  private InMemorySpanExporter spanExporter;
  private OpenTelemetrySdk openTelemetrySdk;

  @BeforeEach
  void setUp() {
    spanExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    openTelemetrySdk = OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
  }

  @AfterEach
  void tearDown() {
    if (openTelemetrySdk != null) {
      openTelemetrySdk.close();
    }
  }

  // F1.1: HTTP no traces emitted unless enabled.
  @Test
  void testTracingDisabled_httpjson() throws Exception {
    EchoSettings settings = createEchoSettings(true);
    try (EchoClient client = EchoClient.create(settings)) {
      client.echo(EchoRequest.newBuilder().setContent("test-f1-1").build());
      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isEmpty();
    }
  }

  // F1.2: HTTP T3 success case name and attributes conform to requirements.
  @Test
  void testT3Success_httpjson() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);
    EchoSettings settings = createEchoSettings(true);
    EchoStub stub = createStubWithServiceName(settings, tracingFactory);

    try (EchoClient client = EchoClient.create(stub)) {
      client.echo(EchoRequest.newBuilder().setContent("test-f1-2").build());

      List<SpanData> spans = waitAndCollectSpans(2);
      assertThat(spans).isNotEmpty();

      SpanData t3Span =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.INTERNAL)
              .findFirst()
              .orElseThrow(() -> new AssertionError("T3 INTERNAL span not found in: " + spans));

      assertThat(t3Span.getKind()).isEqualTo(SpanKind.INTERNAL);
      assertThat(t3Span.getName()).isNotEmpty();
      assertThat(t3Span.getStatus().getStatusCode()).isEqualTo(StatusCode.UNSET);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE)))
          .isEqualTo("http");
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_ADDRESS);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.longKey(ObservabilityAttributes.SERVER_PORT_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_PORT);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(
                      AttributeKey.stringKey(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVICE_NAME);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(
                      AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo(200L);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.HTTP_URL_TEMPLATE_ATTRIBUTE)))
          .isEqualTo("v1beta1/echo:echo");
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
          .isNull();
    }
  }

  // F1.3: HTTP T3 server failures case name and attributes conform to requirements.
  @Test
  void testT3ServerFailure_httpjson() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);
    EchoSettings settings = createEchoSettings(true);
    EchoStub stub = createStubWithServiceName(settings, tracingFactory);

    try (EchoClient client = EchoClient.create(stub)) {
      EchoRequest request =
          EchoRequest.newBuilder()
              .setError(
                  Status.newBuilder()
                      .setCode(Code.INVALID_ARGUMENT.getNumber())
                      .setMessage("Server-side failure message")
                      .build())
              .build();

      assertThrows(ApiException.class, () -> client.echo(request));

      List<SpanData> spans = waitAndCollectSpans(2);
      assertThat(spans).isNotEmpty();

      SpanData t3Span =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.INTERNAL)
              .findFirst()
              .orElseThrow(() -> new AssertionError("T3 INTERNAL span not found in: " + spans));

      assertThat(t3Span.getStatus().getStatusCode()).isEqualTo(StatusCode.ERROR);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(
                      AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE)))
          .isAtLeast(400L);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE)))
          .isNotEmpty();
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
          .isNotNull();
    }
  }

  // F1.4: HTTP T3 client failures case name and attributes conform to requirements.
  @Test
  void testT3ClientFailure_httpjson() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);
    EchoSettings settings = createEchoSettings(true);
    // Configure 50ms timeout for blockCallable
    EchoStubSettings.Builder builder =
        (EchoStubSettings.Builder) settings.getStubSettings().toBuilder();
    builder.setTracerFactory(tracingFactory);
    builder.blockSettings().setSimpleTimeoutNoRetries(Duration.ofMillis(1000L));
    EchoStub stub = new ExtendedEchoStubSettings(builder).createStub();

    try (EchoClient client = EchoClient.create(stub)) {
      BlockRequest request =
          BlockRequest.newBuilder()
              .setSuccess(BlockResponse.newBuilder().setContent("content").build())
              .setResponseDelay(com.google.protobuf.Duration.newBuilder().setSeconds(5).build())
              .build();

      assertThrows(Exception.class, () -> client.block(request));

      List<SpanData> spans = waitAndCollectSpans(2);
      assertThat(spans).isNotEmpty();

      SpanData t3Span =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.INTERNAL)
              .findFirst()
              .orElseThrow(() -> new AssertionError("T3 INTERNAL span not found in: " + spans));

      assertThat(t3Span.getStatus().getStatusCode()).isEqualTo(StatusCode.ERROR);
      // In GAX, client timeout ApiException maps to HTTP 504
      assertThat(
              t3Span
                  .getAttributes()
                  .get(
                      AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo(504L);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE)))
          .isNotEmpty();
      String errorType =
          t3Span
              .getAttributes()
              .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE));
      assertThat(errorType).isNotNull();
    }
  }

  // F1.5: gRPC no traces emitted unless enabled.
  @Test
  void testTracingDisabled_grpc() throws Exception {
    EchoSettings settings = createEchoSettings(false);
    try (EchoClient client = EchoClient.create(settings)) {
      client.echo(EchoRequest.newBuilder().setContent("test-f1-5").build());
      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isEmpty();
    }
  }

  // F1.6: gRPC T3 success case name and attributes conform to requirements.
  @Test
  void testT3Success_grpc() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);
    EchoSettings settings = createEchoSettings(false);
    EchoStub stub = createStubWithServiceName(settings, tracingFactory);

    try (EchoClient client = EchoClient.create(stub)) {
      client.echo(EchoRequest.newBuilder().setContent("test-f1-6").build());

      List<SpanData> spans = waitAndCollectSpans(2);
      assertThat(spans).isNotEmpty();

      SpanData t3Span =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.INTERNAL)
              .findFirst()
              .orElseThrow(() -> new AssertionError("T3 INTERNAL span not found in: " + spans));

      assertThat(t3Span.getKind()).isEqualTo(SpanKind.INTERNAL);
      assertThat(t3Span.getName()).isEqualTo("google.showcase.v1beta1.Echo/Echo");
      assertThat(t3Span.getStatus().getStatusCode()).isEqualTo(StatusCode.UNSET);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE)))
          .isEqualTo("grpc");
      assertThat(
              t3Span
                  .getAttributes()
                  .get(
                      AttributeKey.stringKey(
                          ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("OK");
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_ADDRESS);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.longKey(ObservabilityAttributes.SERVER_PORT_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_PORT);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(
                      AttributeKey.stringKey(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVICE_NAME);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
          .isNull();
    }
  }

  // F1.7: gRPC T3 server failures case name and attributes conform to requirements.
  @Test
  void testT3ServerFailure_grpc() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);
    EchoSettings settings = createEchoSettings(false);
    EchoStub stub = createStubWithServiceName(settings, tracingFactory);

    try (EchoClient client = EchoClient.create(stub)) {
      EchoRequest request =
          EchoRequest.newBuilder()
              .setError(
                  Status.newBuilder()
                      .setCode(Code.INVALID_ARGUMENT.getNumber())
                      .setMessage("Server-side failure message")
                      .build())
              .build();

      assertThrows(ApiException.class, () -> client.echo(request));

      List<SpanData> spans = waitAndCollectSpans(2);
      assertThat(spans).isNotEmpty();

      SpanData t3Span =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.INTERNAL)
              .findFirst()
              .orElseThrow(() -> new AssertionError("T3 INTERNAL span not found in: " + spans));

      assertThat(t3Span.getStatus().getStatusCode()).isEqualTo(StatusCode.ERROR);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(
                      AttributeKey.stringKey(
                          ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("INVALID_ARGUMENT");
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE)))
          .isNotEmpty();
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
          .isNotNull();
    }
  }

  // F1.8: gRPC T3 client failures case name and attributes conform to requirements.
  @Test
  void testT3ClientFailure_grpc() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);
    EchoSettings settings = createEchoSettings(false);
    EchoStubSettings.Builder builder =
        (EchoStubSettings.Builder) settings.getStubSettings().toBuilder();
    builder.setTracerFactory(tracingFactory);
    builder.blockSettings().setSimpleTimeoutNoRetries(Duration.ofMillis(1000L));
    EchoStub stub = new ExtendedEchoStubSettings(builder).createStub();

    try (EchoClient client = EchoClient.create(stub)) {
      BlockRequest request =
          BlockRequest.newBuilder()
              .setSuccess(BlockResponse.newBuilder().setContent("content").build())
              .setResponseDelay(com.google.protobuf.Duration.newBuilder().setSeconds(5).build())
              .build();

      assertThrows(Exception.class, () -> client.block(request));

      List<SpanData> spans = waitAndCollectSpans(2);
      assertThat(spans).isNotEmpty();

      SpanData t3Span =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.INTERNAL)
              .findFirst()
              .orElseThrow(() -> new AssertionError("T3 INTERNAL span not found in: " + spans));

      assertThat(t3Span.getStatus().getStatusCode()).isEqualTo(StatusCode.ERROR);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(
                      AttributeKey.stringKey(
                          ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("DEADLINE_EXCEEDED");
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE)))
          .isNotEmpty();
      String errorType =
          t3Span
              .getAttributes()
              .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE));
      assertThat(errorType).isNotNull();
    }
  }

  private List<SpanData> waitAndCollectSpans(int minSpans) {
    Awaitility.await()
        .atMost(5, TimeUnit.SECONDS)
        .until(() -> spanExporter.getFinishedSpanItems().size() >= minSpans);
    return spanExporter.getFinishedSpanItems();
  }

  private EchoSettings createEchoSettings(boolean isHttpJson) throws Exception {
    if (isHttpJson) {
      return EchoSettings.newHttpJsonBuilder()
          .setCredentialsProvider(NoCredentialsProvider.create())
          .setTransportChannelProvider(
              EchoSettings.defaultHttpJsonTransportProviderBuilder()
                  .setHttpTransport(
                      new NetHttpTransport.Builder().doNotValidateCertificate().build())
                  .build())
          .setEndpoint(SHOWCASE_HTTPJSON_ENDPOINT)
          .build();
    } else {
      return EchoSettings.newBuilder()
          .setCredentialsProvider(NoCredentialsProvider.create())
          .setTransportChannelProvider(
              EchoSettings.defaultGrpcTransportProviderBuilder()
                  .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                  .build())
          .setEndpoint(SHOWCASE_GRPC_ENDPOINT)
          .build();
    }
  }

  private EchoStub createStubWithServiceName(
      EchoSettings settings, OpenTelemetryTracingFactory tracingFactory) throws IOException {
    EchoStubSettings.Builder builder =
        (EchoStubSettings.Builder) settings.getStubSettings().toBuilder();
    builder.setTracerFactory(tracingFactory);
    return new ExtendedEchoStubSettings(builder).createStub();
  }

  private static class ExtendedEchoStubSettings extends EchoStubSettings {
    protected ExtendedEchoStubSettings(EchoStubSettings.Builder builder) throws IOException {
      super(builder);
    }

    @Override
    public String getServiceName() {
      return SHOWCASE_SERVICE_NAME;
    }
  }
}

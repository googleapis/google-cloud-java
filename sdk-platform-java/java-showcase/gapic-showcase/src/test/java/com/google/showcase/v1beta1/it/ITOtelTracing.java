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
import static org.junit.Assert.assertThrows;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnavailableException;
import com.google.api.gax.tracing.ObservabilityAttributes;
import com.google.api.gax.tracing.SpanTracer;
import com.google.api.gax.tracing.SpanTracerFactory;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoResponse;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import com.google.showcase.v1beta1.stub.EchoStub;
import com.google.showcase.v1beta1.stub.EchoStubSettings;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ITOtelTracing {
  private static final String SHOWCASE_SERVER_ADDRESS = "localhost";
  private static final long SHOWCASE_SERVER_PORT = 7469;
  private static final String SHOWCASE_REPO = "googleapis/sdk-platform-java";
  private static final String SHOWCASE_ARTIFACT = "com.google.cloud:gapic-showcase";
  private static final String SHOWCASE_USER_URL = "http://localhost:7469/v1beta1/echo:echo";

  private InMemorySpanExporter spanExporter;
  private OpenTelemetrySdk openTelemetrySdk;

  @BeforeEach
  void setup() {
    spanExporter = InMemorySpanExporter.create();

    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();

    openTelemetrySdk =
        OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).buildAndRegisterGlobal();
  }

  @AfterEach
  void tearDown() {
    if (openTelemetrySdk != null) {
      openTelemetrySdk.close();
    }
    GlobalOpenTelemetry.resetForTest();
  }

  @Test
  void testTracing_successfulEcho_grpc() throws Exception {
    SpanTracerFactory tracingFactory = new SpanTracerFactory(openTelemetrySdk);

    try (EchoClient client =
        TestClientInitializer.createGrpcEchoClientOpentelemetry(tracingFactory)) {

      client.echo(EchoRequest.newBuilder().setContent("tracing-test").build());

      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isNotEmpty();

      SpanData attemptSpan =
          spans.stream()
              .filter(span -> span.getName().equals("google.showcase.v1beta1.Echo/Echo"))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Incorrect span name"));
      assertThat(attemptSpan.getKind()).isEqualTo(SpanKind.CLIENT);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(SpanTracer.LANGUAGE_ATTRIBUTE)))
          .isEqualTo(SpanTracer.DEFAULT_LANGUAGE);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_ADDRESS);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.longKey(ObservabilityAttributes.SERVER_PORT_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_PORT);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.REPO_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_REPO);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.ARTIFACT_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_ARTIFACT);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE)))
          .isEqualTo("grpc");
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.GRPC_RPC_METHOD_ATTRIBUTE)))
          .isEqualTo("google.showcase.v1beta1.Echo/Echo");
      assertThat(attemptSpan.getInstrumentationScopeInfo().getName()).isEqualTo(SHOWCASE_ARTIFACT);
      // {x-version-update-end}
    }
  }

  @Test
  void testTracing_successfulEcho_httpjson() throws Exception {
    SpanTracerFactory tracingFactory = new SpanTracerFactory(openTelemetrySdk);

    try (EchoClient client =
        TestClientInitializer.createHttpJsonEchoClientOpentelemetry(tracingFactory)) {

      client.echo(EchoRequest.newBuilder().setContent("tracing-test").build());

      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isNotEmpty();

      SpanData attemptSpan =
          spans.stream()
              .filter(span -> span.getName().equals("POST v1beta1/echo:echo"))
              .findFirst()
              .orElseThrow(
                  () -> new AssertionError("Attempt span 'POST v1beta1/echo:echo' not found"));
      assertThat(attemptSpan.getKind()).isEqualTo(SpanKind.CLIENT);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(SpanTracer.LANGUAGE_ATTRIBUTE)))
          .isEqualTo(SpanTracer.DEFAULT_LANGUAGE);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_ADDRESS);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.longKey(ObservabilityAttributes.SERVER_PORT_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_PORT);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.REPO_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_REPO);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.ARTIFACT_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_ARTIFACT);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.HTTP_METHOD_ATTRIBUTE)))
          .isEqualTo("POST");
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.HTTP_URL_TEMPLATE_ATTRIBUTE)))
          .isEqualTo("v1beta1/echo:echo");
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.HTTP_URL_FULL_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_USER_URL);
      EchoResponse fetchedEcho = EchoResponse.newBuilder().setContent("tracing-test").build();
      long expectedMagnitude = computeExpectedHttpJsonResponseSize(fetchedEcho);
      Long observedMagnitude =
          attemptSpan
              .getAttributes()
              .get(AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_BODY_SIZE));
      assertThat(observedMagnitude).isNotNull();
      assertThat(observedMagnitude).isAtLeast((long) (expectedMagnitude * (1 - 0.15)));
      assertThat(attemptSpan.getInstrumentationScopeInfo().getName()).isEqualTo(SHOWCASE_ARTIFACT);
    }
  }

  private long computeExpectedHttpJsonResponseSize(Message message)
      throws InvalidProtocolBufferException {
    String jsonPayload = com.google.protobuf.util.JsonFormat.printer().print(message);
    return jsonPayload.getBytes(StandardCharsets.UTF_8).length;
  }

  @Test
  void testTracing_retry_grpc() throws Exception {
    final int attempts = 5;
    final StatusCode.Code statusCode = StatusCode.Code.UNAVAILABLE;
    // A custom EchoClient is used in this test because retries have jitter, and we
    // cannot
    // predict the number of attempts that are scheduled for an RPC invocation
    // otherwise.
    // The custom retrySettings limit to a set number of attempts before the call
    // gives up.
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setTotalTimeout(org.threeten.bp.Duration.ofMillis(5000L))
            .setMaxAttempts(attempts)
            .build();

    EchoStubSettings.Builder grpcEchoSettingsBuilder = EchoStubSettings.newBuilder();
    grpcEchoSettingsBuilder
        .echoSettings()
        .setRetrySettings(retrySettings)
        .setRetryableCodes(statusCode);
    EchoSettings grpcEchoSettings = EchoSettings.create(grpcEchoSettingsBuilder.build());
    grpcEchoSettings =
        grpcEchoSettings.toBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(EchoSettings.defaultGrpcTransportProviderBuilder().build())
            .setEndpoint("localhost:7469")
            .build();

    SpanTracerFactory tracingFactory = new SpanTracerFactory(openTelemetrySdk);

    EchoStubSettings echoStubSettings =
        (EchoStubSettings)
            grpcEchoSettings.getStubSettings().toBuilder().setTracerFactory(tracingFactory).build();
    EchoStub stub = echoStubSettings.createStub();
    EchoClient grpcClient = EchoClient.create(stub);

    EchoRequest echoRequest =
        EchoRequest.newBuilder()
            .setError(Status.newBuilder().setCode(statusCode.ordinal()).build())
            .build();

    assertThrows(UnavailableException.class, () -> grpcClient.echo(echoRequest));

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertThat(spans).hasSize(attempts); // Expect exactly one span for the successful retry

    // This single span represents the successful retry, which has resend_count=1
    // The first attempt has no resend_count. The subsequent retries will have a
    // resend_count,
    // starting from 1.
    List<Long> resendCounts =
        spans.stream()
            .map(
                span ->
                    (Long)
                        span.getAttributes()
                            .asMap()
                            .get(
                                AttributeKey.longKey(
                                    ObservabilityAttributes.GRPC_RESEND_COUNT_ATTRIBUTE)))
            .filter(java.util.Objects::nonNull)
            .sorted()
            .collect(java.util.stream.Collectors.toList());

    List<Long> expectedCounts =
        java.util.stream.LongStream.range(1, attempts)
            .boxed()
            .collect(java.util.stream.Collectors.toList());
    assertThat(resendCounts).containsExactlyElementsIn(expectedCounts).inOrder();
  }

  @Test
  void testTracing_retry_httpjson() throws Exception {
    final int attempts = 5;
    final StatusCode.Code statusCode = StatusCode.Code.UNAVAILABLE;
    // A custom EchoClient is used in this test because retries have jitter, and we
    // cannot
    // predict the number of attempts that are scheduled for an RPC invocation
    // otherwise.
    // The custom retrySettings limit to a set number of attempts before the call
    // gives up.
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setTotalTimeout(org.threeten.bp.Duration.ofMillis(5000L))
            .setMaxAttempts(attempts)
            .build();

    EchoStubSettings.Builder httpJsonEchoSettingsBuilder = EchoStubSettings.newHttpJsonBuilder();
    httpJsonEchoSettingsBuilder
        .echoSettings()
        .setRetrySettings(retrySettings)
        .setRetryableCodes(statusCode);
    EchoSettings httpJsonEchoSettings = EchoSettings.create(httpJsonEchoSettingsBuilder.build());
    httpJsonEchoSettings =
        httpJsonEchoSettings.toBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setEndpoint("http://localhost:7469")
                    .build())
            .build();

    SpanTracerFactory tracingFactory = new SpanTracerFactory(openTelemetrySdk);

    EchoStubSettings echoStubSettings =
        (EchoStubSettings)
            httpJsonEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(tracingFactory)
                .build();
    EchoStub stub = echoStubSettings.createStub();
    EchoClient httpClient = EchoClient.create(stub);

    EchoRequest echoRequest =
        EchoRequest.newBuilder()
            .setError(Status.newBuilder().setCode(statusCode.ordinal()).build())
            .build();

    assertThrows(UnavailableException.class, () -> httpClient.echo(echoRequest));

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertThat(spans).hasSize(attempts); // Expect exactly one span for the successful retry

    // This single span represents the successful retry, which has resend_count=1
    // The first attempt has no resend_count. The subsequent retries will have a
    // resend_count,
    // starting from 1.
    List<Long> resendCounts =
        spans.stream()
            .map(
                span ->
                    (Long)
                        span.getAttributes()
                            .asMap()
                            .get(
                                AttributeKey.longKey(
                                    ObservabilityAttributes.HTTP_RESEND_COUNT_ATTRIBUTE)))
            .filter(java.util.Objects::nonNull)
            .sorted()
            .collect(java.util.stream.Collectors.toList());

    List<Long> expectedCounts =
        java.util.stream.LongStream.range(1, attempts)
            .boxed()
            .collect(java.util.stream.Collectors.toList());
    assertThat(resendCounts).containsExactlyElementsIn(expectedCounts).inOrder();
  }
}

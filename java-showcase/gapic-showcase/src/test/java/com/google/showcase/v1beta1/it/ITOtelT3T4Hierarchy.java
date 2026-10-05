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
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.tracing.ObservabilityAttributes;
import com.google.api.gax.tracing.OpenTelemetryTracingFactory;
import com.google.common.collect.ImmutableSet;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.AttemptSequenceRequest;
import com.google.showcase.v1beta1.CreateSequenceRequest;
import com.google.showcase.v1beta1.Sequence;
import com.google.showcase.v1beta1.SequenceServiceClient;
import com.google.showcase.v1beta1.SequenceServiceSettings;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import com.google.showcase.v1beta1.stub.SequenceServiceStubSettings;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.io.IOException;
import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Integration tests for Feature 2 (F2.1–F2.4): T3/T4 Span Hierarchy and Retry Aggregation. */
class ITOtelT3T4Hierarchy {
  private static final String SHOWCASE_SERVER_ADDRESS = "localhost";
  private static final long SHOWCASE_SERVER_PORT = 7469;
  private static final String SHOWCASE_GRPC_ENDPOINT =
      String.format("%s:%s", SHOWCASE_SERVER_ADDRESS, SHOWCASE_SERVER_PORT);
  private static final String SHOWCASE_HTTPJSON_ENDPOINT =
      String.format("http://%s:%s", SHOWCASE_SERVER_ADDRESS, SHOWCASE_SERVER_PORT);
  private static final String SHOWCASE_SERVICE_NAME = "showcase";

  private InMemorySpanExporter spanExporter;
  private OpenTelemetrySdk openTelemetrySdk;
  private SequenceServiceClient setupGrpcClient;
  private SequenceServiceClient setupHttpJsonClient;

  @BeforeEach
  void setUp() throws Exception {
    spanExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    openTelemetrySdk =
        OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).buildAndRegisterGlobal();

    setupGrpcClient = TestClientInitializer.createGrpcSequenceClient();
    setupHttpJsonClient = TestClientInitializer.createHttpJsonSequenceClient();
  }

  @AfterEach
  void tearDown() {
    if (setupGrpcClient != null) {
      setupGrpcClient.close();
    }
    if (setupHttpJsonClient != null) {
      setupHttpJsonClient.close();
    }
    if (openTelemetrySdk != null) {
      openTelemetrySdk.close();
    }
    GlobalOpenTelemetry.resetForTest();
  }

  // F2.1: HTTP T3/T4 retry succeeds (1 T3 span, 2 T4 child spans)
  @Test
  void testHttpJson_retrySucceeds() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);

    // Sequence: attempt 1 -> UNAVAILABLE, attempt 2 -> OK
    Sequence sequence =
        Sequence.newBuilder()
            .addResponses(
                Sequence.Response.newBuilder()
                    .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                    .build())
            .addResponses(
                Sequence.Response.newBuilder()
                    .setStatus(Status.newBuilder().setCode(Code.OK.getNumber()).build())
                    .build())
            .build();
    Sequence createdSequence =
        setupHttpJsonClient.createSequence(
            CreateSequenceRequest.newBuilder().setSequence(sequence).build());

    // Flush spans created by setup client call
    spanExporter.reset();

    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(50L))
            .setRetryDelayMultiplier(1.5)
            .setMaxRetryDelayDuration(Duration.ofMillis(200L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(1000L))
            .setMaxRpcTimeoutDuration(Duration.ofMillis(1000L))
            .setTotalTimeoutDuration(Duration.ofMillis(3000L))
            .setMaxAttempts(3)
            .build();

    try (SequenceServiceClient client =
        createSequenceClient(
            true, tracingFactory, retrySettings, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {
      client.attemptSequence(
          AttemptSequenceRequest.newBuilder().setName(createdSequence.getName()).build());

      List<SpanData> spans = waitAndCollectSpans(3);
      SpanData t3Span =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.INTERNAL)
              .findFirst()
              .orElseThrow(() -> new AssertionError("T3 INTERNAL span not found in: " + spans));

      List<SpanData> t4Spans =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.CLIENT)
              .sorted(Comparator.comparingLong(SpanData::getStartEpochNanos))
              .collect(Collectors.toList());

      assertThat(t4Spans).hasSize(2);

      // Verify T3/T4 Parentage: both T4 child spans have parent_span_id == T3.span_id
      for (SpanData t4 : t4Spans) {
        assertThat(t4.getParentSpanId()).isEqualTo(t3Span.getSpanId());
      }

      // Verify T3 retry aggregation on success
      assertThat(t3Span.getStatus().getStatusCode())
          .isEqualTo(io.opentelemetry.api.trace.StatusCode.UNSET);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
          .isNull();
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
                  .get(
                      AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo(200L);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.HTTP_URL_TEMPLATE_ATTRIBUTE)))
          .isNotEmpty();
    }
  }

  // F2.2: HTTP T3/T4 retries exhausted
  @Test
  void testHttpJson_retriesExhausted() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);

    // Sequence: 3 UNAVAILABLE responses
    Sequence sequence =
        Sequence.newBuilder()
            .addResponses(
                Sequence.Response.newBuilder()
                    .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                    .build())
            .addResponses(
                Sequence.Response.newBuilder()
                    .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                    .build())
            .addResponses(
                Sequence.Response.newBuilder()
                    .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                    .build())
            .build();
    Sequence createdSequence =
        setupHttpJsonClient.createSequence(
            CreateSequenceRequest.newBuilder().setSequence(sequence).build());

    spanExporter.reset();

    // maxAttempts = 2 will exhaust retries after 2 attempts
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(50L))
            .setRetryDelayMultiplier(1.5)
            .setMaxRetryDelayDuration(Duration.ofMillis(200L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(1000L))
            .setMaxRpcTimeoutDuration(Duration.ofMillis(1000L))
            .setTotalTimeoutDuration(Duration.ofMillis(3000L))
            .setMaxAttempts(2)
            .build();

    try (SequenceServiceClient client =
        createSequenceClient(
            true, tracingFactory, retrySettings, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {
      assertThrows(
          ApiException.class,
          () ->
              client.attemptSequence(
                  AttemptSequenceRequest.newBuilder().setName(createdSequence.getName()).build()));

      List<SpanData> spans = waitAndCollectSpans(3);
      SpanData t3Span =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.INTERNAL)
              .findFirst()
              .orElseThrow(() -> new AssertionError("T3 INTERNAL span not found in: " + spans));

      List<SpanData> t4Spans =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.CLIENT)
              .sorted(Comparator.comparingLong(SpanData::getStartEpochNanos))
              .collect(Collectors.toList());

      assertThat(t4Spans).hasSize(2);

      // Verify T3/T4 Parentage: all T4 child spans have parent_span_id == T3.span_id
      for (SpanData t4 : t4Spans) {
        assertThat(t4.getParentSpanId()).isEqualTo(t3Span.getSpanId());
      }

      // Verify T3 attributes on retries exhausted
      assertThat(t3Span.getStatus().getStatusCode())
          .isEqualTo(io.opentelemetry.api.trace.StatusCode.ERROR);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(
                      AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo(503L);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(
                      AttributeKey.stringKey(
                          ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("UNAVAILABLE");
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

  // F2.3: gRPC T3/T4 retry succeeds
  @Test
  void testGrpc_retrySucceeds() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);

    // Sequence: attempt 1 -> UNAVAILABLE, attempt 2 -> OK
    Sequence sequence =
        Sequence.newBuilder()
            .addResponses(
                Sequence.Response.newBuilder()
                    .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                    .build())
            .addResponses(
                Sequence.Response.newBuilder()
                    .setStatus(Status.newBuilder().setCode(Code.OK.getNumber()).build())
                    .build())
            .build();
    Sequence createdSequence =
        setupGrpcClient.createSequence(
            CreateSequenceRequest.newBuilder().setSequence(sequence).build());

    spanExporter.reset();

    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(50L))
            .setRetryDelayMultiplier(1.5)
            .setMaxRetryDelayDuration(Duration.ofMillis(200L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(1000L))
            .setMaxRpcTimeoutDuration(Duration.ofMillis(1000L))
            .setTotalTimeoutDuration(Duration.ofMillis(3000L))
            .setMaxAttempts(3)
            .build();

    try (SequenceServiceClient client =
        createSequenceClient(
            false, tracingFactory, retrySettings, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {
      client.attemptSequence(
          AttemptSequenceRequest.newBuilder().setName(createdSequence.getName()).build());

      List<SpanData> spans = waitAndCollectSpans(3);
      SpanData t3Span =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.INTERNAL)
              .findFirst()
              .orElseThrow(() -> new AssertionError("T3 INTERNAL span not found in: " + spans));

      List<SpanData> t4Spans =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.CLIENT)
              .sorted(Comparator.comparingLong(SpanData::getStartEpochNanos))
              .collect(Collectors.toList());

      assertThat(t4Spans).hasSize(2);

      // Verify T3/T4 Parentage: both T4 child spans have parent_span_id == T3.span_id
      for (SpanData t4 : t4Spans) {
        assertThat(t4.getParentSpanId()).isEqualTo(t3Span.getSpanId());
      }

      // Verify T3 retry aggregation on success
      assertThat(t3Span.getStatus().getStatusCode())
          .isEqualTo(io.opentelemetry.api.trace.StatusCode.UNSET);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
          .isNull();
      assertThat(
              t3Span
                  .getAttributes()
                  .get(
                      AttributeKey.stringKey(
                          ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("OK");
    }
  }

  // F2.4: gRPC T3/T4 retries exhausted
  @Test
  void testGrpc_retriesExhausted() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);

    // Sequence: 3 UNAVAILABLE responses
    Sequence sequence =
        Sequence.newBuilder()
            .addResponses(
                Sequence.Response.newBuilder()
                    .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                    .build())
            .addResponses(
                Sequence.Response.newBuilder()
                    .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                    .build())
            .addResponses(
                Sequence.Response.newBuilder()
                    .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                    .build())
            .build();
    Sequence createdSequence =
        setupGrpcClient.createSequence(
            CreateSequenceRequest.newBuilder().setSequence(sequence).build());

    spanExporter.reset();

    // maxAttempts = 2 will exhaust retries after 2 attempts
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(50L))
            .setRetryDelayMultiplier(1.5)
            .setMaxRetryDelayDuration(Duration.ofMillis(200L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(1000L))
            .setMaxRpcTimeoutDuration(Duration.ofMillis(1000L))
            .setTotalTimeoutDuration(Duration.ofMillis(3000L))
            .setMaxAttempts(2)
            .build();

    try (SequenceServiceClient client =
        createSequenceClient(
            false, tracingFactory, retrySettings, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {
      assertThrows(
          ApiException.class,
          () ->
              client.attemptSequence(
                  AttemptSequenceRequest.newBuilder().setName(createdSequence.getName()).build()));

      List<SpanData> spans = waitAndCollectSpans(3);
      SpanData t3Span =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.INTERNAL)
              .findFirst()
              .orElseThrow(() -> new AssertionError("T3 INTERNAL span not found in: " + spans));

      List<SpanData> t4Spans =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.CLIENT)
              .sorted(Comparator.comparingLong(SpanData::getStartEpochNanos))
              .collect(Collectors.toList());

      assertThat(t4Spans).hasSize(2);

      // Verify T3/T4 Parentage: all T4 child spans have parent_span_id == T3.span_id
      for (SpanData t4 : t4Spans) {
        assertThat(t4.getParentSpanId()).isEqualTo(t3Span.getSpanId());
      }

      // Verify T3 attributes on retries exhausted
      assertThat(t3Span.getStatus().getStatusCode())
          .isEqualTo(io.opentelemetry.api.trace.StatusCode.ERROR);
      assertThat(
              t3Span
                  .getAttributes()
                  .get(
                      AttributeKey.stringKey(
                          ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("UNAVAILABLE");
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

  private List<SpanData> waitAndCollectSpans(int minSpans) {
    Awaitility.await()
        .atMost(Duration.ofSeconds(5))
        .until(() -> spanExporter.getFinishedSpanItems().size() >= minSpans);
    return spanExporter.getFinishedSpanItems();
  }

  private SequenceServiceClient createSequenceClient(
      boolean isHttpJson,
      OpenTelemetryTracingFactory tracingFactory,
      RetrySettings retrySettings,
      Set<StatusCode.Code> retryableCodes)
      throws Exception {
    SequenceServiceSettings.Builder settingsBuilder =
        isHttpJson
            ? SequenceServiceSettings.newHttpJsonBuilder()
            : SequenceServiceSettings.newBuilder();

    settingsBuilder
        .attemptSequenceSettings()
        .setRetrySettings(retrySettings)
        .setRetryableCodes(retryableCodes);

    settingsBuilder.setCredentialsProvider(NoCredentialsProvider.create());

    if (isHttpJson) {
      settingsBuilder
          .setTransportChannelProvider(
              SequenceServiceSettings.defaultHttpJsonTransportProviderBuilder()
                  .setHttpTransport(
                      new NetHttpTransport.Builder().doNotValidateCertificate().build())
                  .build())
          .setEndpoint(SHOWCASE_HTTPJSON_ENDPOINT);
    } else {
      settingsBuilder
          .setTransportChannelProvider(
              SequenceServiceSettings.defaultGrpcTransportProviderBuilder()
                  .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                  .build())
          .setEndpoint(SHOWCASE_GRPC_ENDPOINT);
    }

    SequenceServiceStubSettings.Builder stubSettingsBuilder =
        settingsBuilder.getStubSettingsBuilder();
    stubSettingsBuilder.setTracerFactory(tracingFactory);
    return SequenceServiceClient.create(
        new ExtendedSequenceServiceStubSettings(stubSettingsBuilder).createStub());
  }

  private static class ExtendedSequenceServiceStubSettings extends SequenceServiceStubSettings {
    protected ExtendedSequenceServiceStubSettings(SequenceServiceStubSettings.Builder builder)
        throws IOException {
      super(builder);
    }

    @Override
    public String getServiceName() {
      return SHOWCASE_SERVICE_NAME;
    }
  }
}

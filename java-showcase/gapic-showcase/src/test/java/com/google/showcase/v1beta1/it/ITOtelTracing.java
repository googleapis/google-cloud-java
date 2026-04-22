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

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnavailableException;
import com.google.api.gax.tracing.ObservabilityAttributes;
import com.google.api.gax.tracing.OpenTelemetryTracingFactory;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoResponse;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.GetUserRequest;
import com.google.showcase.v1beta1.IdentityClient;
import com.google.showcase.v1beta1.IdentitySettings;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import com.google.showcase.v1beta1.stub.EchoStub;
import com.google.showcase.v1beta1.stub.EchoStubSettings;
import com.google.showcase.v1beta1.stub.IdentityStub;
import com.google.showcase.v1beta1.stub.IdentityStubSettings;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ITOtelTracing {
  private static final String SHOWCASE_SERVER_ADDRESS = "localhost";
  private static final long SHOWCASE_SERVER_PORT = 7469;
  private static final String SHOWCASE_GRPC_ENDPOINT =
      String.format("%s:%s", SHOWCASE_SERVER_ADDRESS, SHOWCASE_SERVER_PORT);
  private static final String SHOWCASE_HTTPJSON_ENDPOINT =
      String.format("http://%s:%s", SHOWCASE_SERVER_ADDRESS, SHOWCASE_SERVER_PORT);
  private static final String SHOWCASE_REPO = "googleapis/google-cloud-java";
  private static final String SHOWCASE_ARTIFACT = "com.google.cloud:gapic-showcase";
  private static final String SHOWCASE_USER_URL = "http://localhost:7469/v1beta1/echo:echo";

  // Attribute Keys
  private static final AttributeKey<String> RPC_SYSTEM_KEY =
      AttributeKey.stringKey(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE);
  private static final AttributeKey<String> RPC_RESPONSE_STATUS_KEY =
      AttributeKey.stringKey(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE);
  private static final AttributeKey<Long> HTTP_RESPONSE_STATUS_KEY =
      AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE);
  private static final AttributeKey<String> REPO_KEY =
      AttributeKey.stringKey(ObservabilityAttributes.REPO_ATTRIBUTE);
  private static final AttributeKey<String> ERROR_TYPE_KEY =
      AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE);
  private static final AttributeKey<String> EXCEPTION_TYPE_KEY =
      AttributeKey.stringKey(ObservabilityAttributes.EXCEPTION_TYPE_ATTRIBUTE);
  private static final AttributeKey<String> STATUS_MESSAGE_KEY =
      AttributeKey.stringKey(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE);
  private static final AttributeKey<String> DESTINATION_RESOURCE_ID_KEY =
      AttributeKey.stringKey(ObservabilityAttributes.DESTINATION_RESOURCE_ID_ATTRIBUTE);

  // Expected Values
  private static final String VALUE_GRPC = "grpc";
  private static final String VALUE_HTTP = "http";
  private static final String VALUE_OK = "OK";
  private static final String VALUE_TEST_USER = "//showcase.googleapis.com/users/test-user";
  private static final String VALUE_UNAVAILABLE = "UNAVAILABLE";
  private static final String VALUE_UNAVAILABLE_EXCEPTION = "UnavailableException";
  private static final String VALUE_SERVICE_UNAVAILABLE = "Service Unavailable";
  private static final String SPAN_NAME_ECHO_GRPC = "google.showcase.v1beta1.Echo/Echo";
  private static final String SPAN_NAME_ECHO_HTTP = "POST v1beta1/echo:echo";
  private static final String SPAN_NAME_GET_USER_GRPC = "google.showcase.v1beta1.Identity/GetUser";
  private static final String SPAN_NAME_GET_USER_HTTP = "GET v1beta1/{name=users/*}";

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
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);

    EchoSettings grpcEchoSettings = createEchoSettings(false);
    EchoStub stub = createStubWithServiceName(grpcEchoSettings, tracingFactory);

    try (EchoClient client = EchoClient.create(stub)) {

      client.echo(EchoRequest.newBuilder().setContent("tracing-test").build());

      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isNotEmpty();

      SpanData attemptSpan =
          spans.stream()
              .filter(span -> span.getName().equals(SPAN_NAME_ECHO_GRPC))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Incorrect span name"));
      assertThat(attemptSpan.getKind()).isEqualTo(SpanKind.CLIENT);
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
      assertThat(attemptSpan.getAttributes().get(RPC_SYSTEM_KEY)).isEqualTo(VALUE_GRPC);
      assertThat(attemptSpan.getAttributes().get(RPC_RESPONSE_STATUS_KEY)).isEqualTo(VALUE_OK);
      assertThat(attemptSpan.getAttributes().get(REPO_KEY)).isEqualTo(SHOWCASE_REPO);

      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(
                      AttributeKey.stringKey(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE)))
          .isEqualTo("showcase");
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.GRPC_RPC_METHOD_ATTRIBUTE)))
          .isEqualTo("google.showcase.v1beta1.Echo/Echo");
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.URL_DOMAIN_ATTRIBUTE)))
          .isEqualTo("showcase.googleapis.com");
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
          .isNull();
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE)))
          .isNull();
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.EXCEPTION_TYPE_ATTRIBUTE)))
          .isNull();
      assertThat(attemptSpan.getInstrumentationScopeInfo().getName()).isEqualTo(SHOWCASE_ARTIFACT);
    }
  }

  @Test
  void testTracing_successfulEcho_httpjson() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);

    EchoSettings httpJsonEchoSettings = createEchoSettings(true);
    EchoStub stub = createStubWithServiceName(httpJsonEchoSettings, tracingFactory);

    try (EchoClient client = EchoClient.create(stub)) {

      client.echo(EchoRequest.newBuilder().setContent("tracing-test").build());

      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isNotEmpty();

      SpanData attemptSpan =
          spans.stream()
              .filter(span -> span.getName().equals(SPAN_NAME_ECHO_HTTP))
              .findFirst()
              .orElseThrow(
                  () -> new AssertionError("Attempt span 'POST v1beta1/echo:echo' not found"));
      assertThat(attemptSpan.getKind()).isEqualTo(SpanKind.CLIENT);
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
      assertThat(attemptSpan.getAttributes().get(RPC_SYSTEM_KEY)).isEqualTo(VALUE_HTTP);
      assertThat(attemptSpan.getAttributes().get(HTTP_RESPONSE_STATUS_KEY)).isEqualTo(200L);
      assertThat(attemptSpan.getAttributes().get(REPO_KEY)).isEqualTo(SHOWCASE_REPO);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(
                      AttributeKey.stringKey(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE)))
          .isEqualTo("showcase");
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
                  .get(AttributeKey.stringKey(ObservabilityAttributes.URL_DOMAIN_ATTRIBUTE)))
          .isEqualTo("showcase.googleapis.com");
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.HTTP_URL_FULL_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_USER_URL);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
          .isNull();
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE)))
          .isNull();
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.EXCEPTION_TYPE_ATTRIBUTE)))
          .isNull();
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
  void testTracing_successfulIdentityGetUser_grpc() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);

    IdentitySettings grpcIdentitySettings = createIdentitySettings(false);
    IdentityStub stub = createIdentityStubWithServiceName(grpcIdentitySettings, tracingFactory);

    try (IdentityClient client = IdentityClient.create(stub)) {

      try {
        client.getUser(GetUserRequest.newBuilder().setName("users/test-user").build());
      } catch (Exception e) {
        // Ignored, the showcase server may not have this user, but trace is still
        // generated.
      }

      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isNotEmpty();

      SpanData attemptSpan =
          spans.stream()
              .filter(span -> span.getName().equals(SPAN_NAME_GET_USER_GRPC))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Incorrect span name"));
      assertThat(attemptSpan.getAttributes().get(DESTINATION_RESOURCE_ID_KEY))
          .isEqualTo(VALUE_TEST_USER);
    }
  }

  @Test
  void testTracing_successfulIdentityGetUser_httpjson() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);

    IdentitySettings httpJsonIdentitySettings = createIdentitySettings(true);
    IdentityStub stub = createIdentityStubWithServiceName(httpJsonIdentitySettings, tracingFactory);

    try (IdentityClient client = IdentityClient.create(stub)) {

      try {
        client.getUser(GetUserRequest.newBuilder().setName("users/test-user").build());
      } catch (Exception e) {
        // Ignored, the showcase server may not have this user, but trace is still
        // generated.
      }

      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).isNotEmpty();

      SpanData attemptSpan =
          spans.stream()
              .filter(span -> span.getName().equals(SPAN_NAME_GET_USER_HTTP))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Incorrect span name"));
      assertThat(attemptSpan.getAttributes().get(DESTINATION_RESOURCE_ID_KEY))
          .isEqualTo(VALUE_TEST_USER);
    }
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
            .setEndpoint(SHOWCASE_GRPC_ENDPOINT)
            .build();

    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);

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
    final StatusCode.Code statusCode = StatusCode.Code.INVALID_ARGUMENT;
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
                    .setEndpoint(SHOWCASE_HTTPJSON_ENDPOINT)
                    .build())
            .build();

    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);

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

    assertThrows(InvalidArgumentException.class, () -> httpClient.echo(echoRequest));

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

  private SpanData getErrorSpan() {
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertThat(spans).isNotEmpty();

    SpanData errorSpan =
        spans.stream()
            .filter(
                span ->
                    span.getAttributes()
                            .get(
                                AttributeKey.stringKey(
                                    ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE))
                        != null)
            .findFirst()
            .orElseThrow(() -> new AssertionError("Span with error.type not found"));
    return errorSpan;
  }

  @Test
  void testTracing_failedEcho_grpc_recordsErrorAttributes() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);

    ClientInterceptor interceptor =
        new ClientInterceptor() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
              MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
            return new ClientCall<ReqT, RespT>() {
              @Override
              public void start(Listener<RespT> responseListener, Metadata headers) {
                responseListener.onClose(io.grpc.Status.UNAVAILABLE, new Metadata());
              }

              @Override
              public void request(int numMessages) {}

              @Override
              public void cancel(String message, Throwable cause) {}

              @Override
              public void halfClose() {}

              @Override
              public void sendMessage(ReqT message) {}
            };
          }
        };

    TransportChannelProvider transportChannelProvider =
        EchoSettings.defaultGrpcTransportProviderBuilder()
            .setChannelConfigurator(io.grpc.ManagedChannelBuilder::usePlaintext)
            .setInterceptorProvider(() -> ImmutableList.of(interceptor))
            .build();

    try (EchoClient client =
        TestClientInitializer.createGrpcEchoClientOpentelemetry(
            tracingFactory, transportChannelProvider)) {

      EchoRequest echoRequest = EchoRequest.newBuilder().build();

      assertThrows(UnavailableException.class, () -> client.echo(echoRequest));
      SpanData errorSpan = getErrorSpan();
      assertThat(errorSpan.getAttributes().get(ERROR_TYPE_KEY)).isEqualTo(VALUE_UNAVAILABLE);
      assertThat(errorSpan.getAttributes().get(EXCEPTION_TYPE_KEY))
          .isEqualTo("com.google.api.gax.rpc.UnavailableException");
      assertThat(errorSpan.getAttributes().get(STATUS_MESSAGE_KEY))
          .isEqualTo("io.grpc.StatusRuntimeException: UNAVAILABLE");
    }
  }

  @Test
  void testTracing_failedEcho_httpjson_recordsErrorAttributes() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);

    HttpTransport mockTransport =
        new HttpTransport() {
          @Override
          protected com.google.api.client.http.LowLevelHttpRequest buildRequest(
              String method, String url) {
            return new com.google.api.client.http.LowLevelHttpRequest() {
              @Override
              public void addHeader(String name, String value) {}

              @Override
              public com.google.api.client.http.LowLevelHttpResponse execute() {
                return new com.google.api.client.http.LowLevelHttpResponse() {
                  @Override
                  public InputStream getContent() {
                    return new ByteArrayInputStream("{}".getBytes());
                  }

                  @Override
                  public String getContentEncoding() {
                    return null;
                  }

                  @Override
                  public long getContentLength() {
                    return 2;
                  }

                  @Override
                  public String getContentType() {
                    return "application/json";
                  }

                  @Override
                  public String getStatusLine() {
                    return "HTTP/1.1 503 Service Unavailable";
                  }

                  @Override
                  public int getStatusCode() {
                    return 503;
                  }

                  @Override
                  public String getReasonPhrase() {
                    return "Service Unavailable";
                  }

                  @Override
                  public int getHeaderCount() {
                    return 0;
                  }

                  @Override
                  public String getHeaderName(int index) {
                    return null;
                  }

                  @Override
                  public String getHeaderValue(int index) {
                    return null;
                  }
                };
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

    EchoStubSettings echoStubSettings =
        (EchoStubSettings)
            httpJsonEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(tracingFactory)
                .build();

    try (EchoClient client = EchoClient.create(echoStubSettings.createStub())) {
      EchoRequest echoRequest = EchoRequest.newBuilder().build();

      assertThrows(UnavailableException.class, () -> client.echo(echoRequest));
      SpanData errorSpan = getErrorSpan();
      assertThat(errorSpan.getAttributes().get(ERROR_TYPE_KEY)).isEqualTo("503");
      assertThat(errorSpan.getAttributes().get(EXCEPTION_TYPE_KEY))
          .isEqualTo("com.google.api.gax.rpc.UnavailableException");
      assertThat(errorSpan.getAttributes().get(STATUS_MESSAGE_KEY))
          .isEqualTo(VALUE_SERVICE_UNAVAILABLE);
    }
  }

  @Test
  void testTracing_statusCodes_grpc() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);
    EchoRequest errorRequest =
        EchoRequest.newBuilder()
            .setError(
                Status.newBuilder().setCode(StatusCode.Code.INVALID_ARGUMENT.ordinal()).build())
            .build();
    EchoRequest successRequest = EchoRequest.newBuilder().setContent("tracing-test").build();

    try (EchoClient grpcClient =
        TestClientInitializer.createGrpcEchoClientOpentelemetry(tracingFactory)) {

      grpcClient.echo(successRequest);
      assertThrows(
          com.google.api.gax.rpc.InvalidArgumentException.class,
          () -> grpcClient.echo(errorRequest));

      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).hasSize(2);

      SpanData grpcSuccessSpan = spans.get(0);
      assertThat(
              grpcSuccessSpan
                  .getAttributes()
                  .get(
                      AttributeKey.stringKey(
                          ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("OK");

      SpanData grpcErrorSpan = spans.get(1);
      assertThat(
              grpcErrorSpan
                  .getAttributes()
                  .get(
                      AttributeKey.stringKey(
                          ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("INVALID_ARGUMENT");
    }
  }

  @Test
  void testTracing_statusCodes_httpjson() throws Exception {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);
    EchoRequest errorRequest =
        EchoRequest.newBuilder()
            .setError(
                Status.newBuilder().setCode(StatusCode.Code.INVALID_ARGUMENT.ordinal()).build())
            .build();
    EchoRequest successRequest = EchoRequest.newBuilder().setContent("tracing-test").build();

    try (EchoClient httpClient =
        TestClientInitializer.createHttpJsonEchoClientOpentelemetry(tracingFactory)) {

      httpClient.echo(successRequest);
      assertThrows(
          com.google.api.gax.rpc.InvalidArgumentException.class,
          () -> httpClient.echo(errorRequest));

      List<SpanData> spans = spanExporter.getFinishedSpanItems();
      assertThat(spans).hasSize(2);

      SpanData httpSuccessSpan = spans.get(0);
      assertThat(
              httpSuccessSpan
                  .getAttributes()
                  .get(
                      AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo(200L);

      SpanData httpErrorSpan = spans.get(1);
      assertThat(
              httpErrorSpan
                  .getAttributes()
                  .get(
                      AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo((long) StatusCode.Code.INVALID_ARGUMENT.getHttpStatusCode());
    }
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

  private IdentityStub createIdentityStubWithServiceName(
      IdentitySettings settings, OpenTelemetryTracingFactory tracingFactory) throws IOException {
    IdentityStubSettings.Builder builder =
        (IdentityStubSettings.Builder) settings.getStubSettings().toBuilder();
    builder.setTracerFactory(tracingFactory);
    return new ExtendedIdentityStubSettings(builder).createStub();
  }

  private IdentitySettings createIdentitySettings(boolean isHttpJson) throws Exception {
    if (isHttpJson) {
      return IdentitySettings.newHttpJsonBuilder()
          .setCredentialsProvider(NoCredentialsProvider.create())
          .setTransportChannelProvider(
              IdentitySettings.defaultHttpJsonTransportProviderBuilder()
                  .setHttpTransport(
                      new NetHttpTransport.Builder().doNotValidateCertificate().build())
                  .build())
          .setEndpoint(SHOWCASE_HTTPJSON_ENDPOINT)
          .build();
    } else {
      return IdentitySettings.newBuilder()
          .setCredentialsProvider(NoCredentialsProvider.create())
          .setTransportChannelProvider(
              IdentitySettings.defaultGrpcTransportProviderBuilder()
                  .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                  .build())
          .setEndpoint(SHOWCASE_GRPC_ENDPOINT)
          .build();
    }
  }

  /** Custom wrapper to set a service name for showcase clients, which lack one by default. */
  private static class ExtendedEchoStubSettings extends EchoStubSettings {
    protected ExtendedEchoStubSettings(EchoStubSettings.Builder builder) throws IOException {
      super(builder);
    }

    @Override
    public String getServiceName() {
      return "showcase";
    }
  }

  private static class ExtendedIdentityStubSettings extends IdentityStubSettings {
    protected ExtendedIdentityStubSettings(IdentityStubSettings.Builder builder)
        throws IOException {
      super(builder);
    }

    @Override
    public String getServiceName() {
      return "showcase";
    }
  }
}

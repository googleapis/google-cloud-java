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

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.RestSerializationException;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnavailableException;
import com.google.api.gax.tracing.ObservabilityAttributes;
import com.google.api.gax.tracing.SpanTracerFactory;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableList;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import com.google.showcase.v1beta1.stub.EchoStubSettings;
import com.google.api.client.http.HttpTransport;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.Metadata;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.BindException;
import java.net.NoRouteToHostException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.nio.channels.UnresolvedAddressException;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLHandshakeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ITOtelErrorType {
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

  private void verifyErrorTypeAttribute(String expectedErrorType) {
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

    assertThat(
            errorSpan
                .getAttributes()
                .get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
        .isEqualTo(expectedErrorType);
  }

  private EchoClient createInterceptorClient(Throwable toThrow) throws IOException {
    SpanTracerFactory tracingFactory = new SpanTracerFactory(openTelemetrySdk);

    ClientInterceptor interceptor =
        new ClientInterceptor() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
              MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
            if (toThrow instanceof RuntimeException) {
              throw (RuntimeException) toThrow;
            } else {
              throw new RuntimeException(toThrow);
            }
          }
        };

    EchoSettings grpcEchoSettings =
        EchoSettings.newBuilder()
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .setInterceptorProvider(() -> ImmutableList.of(interceptor))
                    .build())
            .setEndpoint(TestClientInitializer.DEFAULT_GRPC_ENDPOINT)
            .build();

    EchoStubSettings.Builder echoStubSettingsBuilder =
        (EchoStubSettings.Builder) grpcEchoSettings.getStubSettings().toBuilder();
    echoStubSettingsBuilder.setTracerFactory(tracingFactory);

    return EchoClient.create(echoStubSettingsBuilder.build().createStub());
  }

  @Test
  void testTracing_failedEcho_grpc_recordsErrorType() throws Exception {
    SpanTracerFactory tracingFactory = new SpanTracerFactory(openTelemetrySdk);

    ClientInterceptor interceptor =
        new ClientInterceptor() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
              MethodDescriptor<ReqT, RespT> method,
              CallOptions callOptions,
              Channel next) {
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

      EchoRequest echoRequest =
          EchoRequest.newBuilder()
              .setError(Status.newBuilder().setCode(com.google.rpc.Code.UNAVAILABLE.ordinal()).build())
              .build();

      assertThrows(UnavailableException.class, () -> client.echo(echoRequest));
      verifyErrorTypeAttribute("UNAVAILABLE");
    }

  }


  @Test
  void testTracing_failedEcho_httpjson_recordsErrorType() throws Exception {
    SpanTracerFactory tracingFactory = new SpanTracerFactory(openTelemetrySdk);

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
      EchoRequest echoRequest =
          EchoRequest.newBuilder()
              .setError(Status.newBuilder().setCode(com.google.rpc.Code.UNAVAILABLE.ordinal()).build())
              .build();


      assertThrows(UnavailableException.class, () -> client.echo(echoRequest));
      verifyErrorTypeAttribute("503");
    }
  }


  @Test
  void testTracing_clientConnectionError_ConnectException_grpc() throws Exception {
    int port;
    try (ServerSocket socket = new ServerSocket(0)) {
      port = socket.getLocalPort();
    }

    SpanTracerFactory tracingFactory = new SpanTracerFactory(openTelemetrySdk);
    EchoSettings grpcEchoSettings =
        EchoSettings.newBuilder()
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .setEndpoint("localhost:" + port)
            .build();

    EchoStubSettings.Builder echoStubSettingsBuilder =
        (EchoStubSettings.Builder) grpcEchoSettings.getStubSettings().toBuilder();
    echoStubSettingsBuilder.setTracerFactory(tracingFactory);
    echoStubSettingsBuilder
        .echoSettings()
        .setRetrySettings(
            echoStubSettingsBuilder.echoSettings().getRetrySettings().toBuilder()
                .setMaxAttempts(1)
                .build());

    try (EchoClient client = EchoClient.create(echoStubSettingsBuilder.build().createStub())) {
      assertThrows(
          UnavailableException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
      verifyErrorTypeAttribute("CLIENT_CONNECTION_ERROR");
    }
  }

  @Test
  void testTracing_clientConnectionError_UnknownHost_grpc() throws Exception {
    SpanTracerFactory tracingFactory = new SpanTracerFactory(openTelemetrySdk);
    EchoSettings grpcEchoSettings =
        EchoSettings.newBuilder()
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .setEndpoint("this.is.a.bogus.host.name:7469")
            .build();

    EchoStubSettings.Builder echoStubSettingsBuilder =
        (EchoStubSettings.Builder) grpcEchoSettings.getStubSettings().toBuilder();
    echoStubSettingsBuilder.setTracerFactory(tracingFactory);
    echoStubSettingsBuilder
        .echoSettings()
        .setRetrySettings(
            echoStubSettingsBuilder.echoSettings().getRetrySettings().toBuilder()
                .setMaxAttempts(1)
                .build());

    try (EchoClient client = EchoClient.create(echoStubSettingsBuilder.build().createStub())) {
      assertThrows(
          UnavailableException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
      verifyErrorTypeAttribute("CLIENT_CONNECTION_ERROR");
    }
  }

  @Test
  void testTracing_clientConnectionError_SSLHandshakeException_grpc() throws Exception {
    try (EchoClient client =
        createInterceptorClient(new SSLHandshakeException("Mock SSL failure"))) {
      assertThrows(
          RuntimeException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
      verifyErrorTypeAttribute("CLIENT_CONNECTION_ERROR");
    }
  }

  @Test
  void testTracing_clientConnectionError_UnresolvedAddressException_grpc() throws Exception {
    try (EchoClient client = createInterceptorClient(new UnresolvedAddressException())) {
      assertThrows(
          RuntimeException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
      verifyErrorTypeAttribute("CLIENT_CONNECTION_ERROR");
    }
  }

  @Test
  void testTracing_clientConnectionError_NoRouteToHostException_grpc() throws Exception {
    try (EchoClient client = createInterceptorClient(new NoRouteToHostException())) {
      assertThrows(
          RuntimeException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
      verifyErrorTypeAttribute("CLIENT_CONNECTION_ERROR");
    }
  }

  @Test
  void testTracing_clientConnectionError_BindException_grpc() throws Exception {
    try (EchoClient client = createInterceptorClient(new BindException())) {
      assertThrows(
          RuntimeException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
      verifyErrorTypeAttribute("CLIENT_CONNECTION_ERROR");
    }
  }

  @Test
  void testTracing_clientTimeout_SocketTimeoutException_grpc() throws Exception {
    try (EchoClient client = createInterceptorClient(new SocketTimeoutException())) {
      assertThrows(
          RuntimeException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
      verifyErrorTypeAttribute("CLIENT_TIMEOUT");
    }
  }

  @Test
  void testTracing_clientTimeout_DeadlineExceededException_grpc() throws Exception {
    SpanTracerFactory tracingFactory = new SpanTracerFactory(openTelemetrySdk);

    try (ServerSocket serverSocket = new ServerSocket(0)) {
      int port = serverSocket.getLocalPort();
      Thread serverThread =
          new Thread(
              () -> {
                try {
                  try (Socket ignored = serverSocket.accept()) {
                    Thread.sleep(1000);
                  }
                } catch (Exception ignored) {
                }
              });
      serverThread.start();

      EchoSettings grpcEchoSettings =
          EchoSettings.newBuilder()
              .setTransportChannelProvider(
                  EchoSettings.defaultGrpcTransportProviderBuilder()
                      .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                      .build())
              .setEndpoint("localhost:" + port)
              .build();

      EchoStubSettings.Builder echoStubSettingsBuilder =
          (EchoStubSettings.Builder) grpcEchoSettings.getStubSettings().toBuilder();
      echoStubSettingsBuilder.setTracerFactory(tracingFactory);
      echoStubSettingsBuilder
          .echoSettings()
          .setRetrySettings(
              echoStubSettingsBuilder.echoSettings().getRetrySettings().toBuilder()
                  .setTotalTimeoutDuration(Duration.ofMillis(100))
                  .setInitialRpcTimeoutDuration(Duration.ofMillis(100))
                  .setMaxRpcTimeoutDuration(Duration.ofMillis(100))
                  .setMaxAttempts(1)
                  .build());

      try (EchoClient client = EchoClient.create(echoStubSettingsBuilder.build().createStub())) {
        assertThrows(
            DeadlineExceededException.class,
            () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
        verifyErrorTypeAttribute("CLIENT_TIMEOUT");
      } finally {
        serverThread.join();
      }
    }
  }

  @Test
  void testTracing_clientAuthenticationError_GeneralSecurityException_grpc() throws Exception {
    try (EchoClient client = createInterceptorClient(new GeneralSecurityException("Mock auth failure"))) {
      assertThrows(
          Exception.class, () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
      verifyErrorTypeAttribute("CLIENT_AUTHENTICATION_ERROR");
    }
  }



  @Test
  void testTracing_clientAuthenticationError_FileNotFoundException_grpc() throws Exception {
    try (EchoClient client = createInterceptorClient(new FileNotFoundException("Key not found"))) {
      assertThrows(
          RuntimeException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
      // Wrapping non-RuntimeExceptions in RuntimeException during interceptCall()
      // means the simple class name of the exception being recorded is "RuntimeException"
      verifyErrorTypeAttribute("RuntimeException");
    }
  }

  @Test
  void testTracing_clientRequestError_IllegalArgumentException_grpc() throws Exception {
    try (EchoClient client =
        createInterceptorClient(new IllegalArgumentException("Mock request error"))) {
      assertThrows(
          IllegalArgumentException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
      verifyErrorTypeAttribute("CLIENT_REQUEST_ERROR");

      SpanData errorSpan =
          spanExporter.getFinishedSpanItems().stream()
              .filter(
                  span ->
                      span.getAttributes()
                              .get(
                                  AttributeKey.stringKey(
                                      ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE))
                          != null)
              .findFirst()
              .orElseThrow(() -> new AssertionError("Span with error.type not found"));

      assertThat(
              errorSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.EXCEPTION_TYPE_ATTRIBUTE)))
          .isEqualTo("java.lang.IllegalArgumentException");
      assertThat(
              errorSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE)))
          .isEqualTo("Mock request error");
    }
  }

  @Test
  void testTracing_clientRedirectError_grpc() throws Exception {
    try (EchoClient client = createInterceptorClient(new RuntimeException("Too many redirects"))) {
      assertThrows(
          RuntimeException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
      // Heuristic mapping of "redirect" in message has been removed.
      // Expected result is now the simple class name of the exception.
      verifyErrorTypeAttribute("RuntimeException");
    }
  }

  @Test
  void testTracing_clientUnknownError_grpc() throws Exception {
    // Creating a custom exception class whose name contains "Unknown"
    class MyUnknownException extends RuntimeException {}
    try (EchoClient client = createInterceptorClient(new MyUnknownException())) {
      assertThrows(
          RuntimeException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
      // Heuristic mapping of "Unknown" in class name has been removed.
      // Expected result is now the simple class name of the exception.
      verifyErrorTypeAttribute("MyUnknownException");
    }
  }

  @Test
  void testTracing_clientRequestError_RestSerializationException_httpjson() throws Exception {
    try (EchoClient client =
        createInterceptorClient(new RestSerializationException("failed to serialize", null))) {
      assertThrows(
          RuntimeException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("test").build()));
      // RestSerializationException is not handled due to ambiguity (serialization vs
      // deserialization).
      // Expected result is now its simple class name.
      verifyErrorTypeAttribute("RestSerializationException");
    }
  }
}

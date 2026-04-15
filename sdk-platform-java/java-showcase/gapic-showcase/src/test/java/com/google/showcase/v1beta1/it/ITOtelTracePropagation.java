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

package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.ForwardingHttpJsonClientCall;
import com.google.api.gax.httpjson.HttpJsonCallOptions;
import com.google.api.gax.httpjson.HttpJsonChannel;
import com.google.api.gax.httpjson.HttpJsonClientCall;
import com.google.api.gax.httpjson.HttpJsonClientInterceptor;
import com.google.api.gax.httpjson.HttpJsonMetadata;
import com.google.api.gax.tracing.OpenTelemetryTracingFactory;
import com.google.common.collect.ImmutableList;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ITOtelTracePropagation {
  private static final Metadata.Key<String> TRACEPARENT_GRPC_HEADER_KEY =
      Metadata.Key.of("traceparent", Metadata.ASCII_STRING_MARSHALLER);
  private static final String TRACEPARENT_HTTP_HEADER_KEY = "traceparent";

  private static InMemorySpanExporter spanExporter;
  private static OpenTelemetrySdk openTelemetrySdk;

  private static class GrpcResponseCapturingClientInterceptor implements ClientInterceptor {
    private Metadata requestHeaders;
    private Metadata responseTrailers;

    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> interceptCall(
        MethodDescriptor<RequestT, ResponseT> method, final CallOptions callOptions, Channel next) {
      ClientCall<RequestT, ResponseT> call = next.newCall(method, callOptions);
      return new ForwardingClientCall.SimpleForwardingClientCall<RequestT, ResponseT>(call) {
        @Override
        public void start(ClientCall.Listener<ResponseT> responseListener, Metadata headers) {
          requestHeaders = headers;
          ClientCall.Listener<ResponseT> forwardingResponseListener =
              new ForwardingClientCallListener.SimpleForwardingClientCallListener<ResponseT>(
                  responseListener) {
                @Override
                public void onClose(io.grpc.Status status, Metadata trailers) {
                  responseTrailers = trailers;
                  super.onClose(status, trailers);
                }
              };
          super.start(forwardingResponseListener, headers);
        }
      };
    }
  }

  private static class HttpJsonResponseCapturingClientInterceptor
      implements HttpJsonClientInterceptor {
    private HttpJsonMetadata requestHeaders;

    @Override
    public <RequestT, ResponseT> HttpJsonClientCall<RequestT, ResponseT> interceptCall(
        ApiMethodDescriptor<RequestT, ResponseT> method,
        HttpJsonCallOptions callOptions,
        HttpJsonChannel next) {
      HttpJsonClientCall<RequestT, ResponseT> call = next.newCall(method, callOptions);
      return new ForwardingHttpJsonClientCall.SimpleForwardingHttpJsonClientCall<
          RequestT, ResponseT>(call) {
        @Override
        public void start(Listener<ResponseT> responseListener, HttpJsonMetadata headers) {
          requestHeaders = headers;
          super.start(responseListener, headers);
        }
      };
    }
  }

  private static GrpcResponseCapturingClientInterceptor grpcInterceptor;
  private static HttpJsonResponseCapturingClientInterceptor httpJsonInterceptor;

  private static EchoClient grpcClient;
  private static EchoClient httpJsonClient;

  @BeforeAll
  static void setup() throws Exception {
    spanExporter = InMemorySpanExporter.create();

    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();

    openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(tracerProvider)
            .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
            .buildAndRegisterGlobal();

    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);

    // Create gRPC Interceptor and Client
    grpcInterceptor = new GrpcResponseCapturingClientInterceptor();
    grpcClient =
        TestClientInitializer.createGrpcEchoClientOpentelemetry(
            tracingFactory,
            EchoSettings.defaultGrpcTransportProviderBuilder()
                .setChannelConfigurator(io.grpc.ManagedChannelBuilder::usePlaintext)
                .setInterceptorProvider(() -> ImmutableList.of(grpcInterceptor))
                .build());

    // Create HttpJson Interceptor and Client
    httpJsonInterceptor = new HttpJsonResponseCapturingClientInterceptor();
    EchoSettings httpJsonEchoSettings =
        EchoSettings.newHttpJsonBuilder()
            .setCredentialsProvider(com.google.api.gax.core.NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setEndpoint(TestClientInitializer.DEFAULT_HTTPJSON_ENDPOINT)
                    .setInterceptorProvider(() -> ImmutableList.of(httpJsonInterceptor))
                    .build())
            .build();

    com.google.showcase.v1beta1.stub.EchoStubSettings echoStubSettings =
        (com.google.showcase.v1beta1.stub.EchoStubSettings)
            httpJsonEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(tracingFactory)
                .build();
    com.google.showcase.v1beta1.stub.EchoStub stub = echoStubSettings.createStub();
    httpJsonClient = EchoClient.create(stub);
  }

  @BeforeEach
  void cleanUp() {
    spanExporter.reset();
    grpcInterceptor.requestHeaders = null;
    httpJsonInterceptor.requestHeaders = null;
  }

  @AfterAll
  static void tearDown() throws InterruptedException {
    grpcClient.close();
    httpJsonClient.close();

    grpcClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    httpJsonClient.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);

    if (openTelemetrySdk != null) {
      openTelemetrySdk.close();
    }
    GlobalOpenTelemetry.resetForTest();
  }

  @Test
  void testTracePropagation_grpc() {
    EchoRequest request = EchoRequest.newBuilder().setContent("test-grpc-propagation").build();
    grpcClient.echo(request);

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertThat(spans).isNotEmpty();

    SpanData attemptSpan =
        spans.stream()
            .filter(span -> span.getName().equals("google.showcase.v1beta1.Echo/Echo"))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Attempt span not found"));

    String expectedTraceId = attemptSpan.getSpanContext().getTraceId();
    String expectedSpanId = attemptSpan.getSpanContext().getSpanId();
    String expectedTraceFlags = attemptSpan.getSpanContext().getTraceFlags().asHex();
    String expectedTraceparent =
        "00-" + expectedTraceId + "-" + expectedSpanId + "-" + expectedTraceFlags;

    String headerValue = grpcInterceptor.requestHeaders.get(TRACEPARENT_GRPC_HEADER_KEY);
    assertThat(headerValue).isNotNull();
    assertThat(headerValue).isEqualTo(expectedTraceparent);
  }

  @Test
  void testTracePropagation_httpjson() {
    EchoRequest request = EchoRequest.newBuilder().setContent("test-http-propagation").build();
    httpJsonClient.echo(request);

    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertThat(spans).isNotEmpty();

    // The T4 CLIENT span generated by ApiTracer (OpenTelemetryTracingTracer)
    SpanData attemptSpan =
        spans.stream()
            .filter(span -> span.getName().equals("POST v1beta1/echo:echo"))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Attempt span not found"));

    String expectedTraceId = attemptSpan.getSpanContext().getTraceId();
    String expectedSpanId = attemptSpan.getSpanContext().getSpanId();
    String expectedTraceFlags = attemptSpan.getSpanContext().getTraceFlags().asHex();
    String expectedTraceparent =
        "00-" + expectedTraceId + "-" + expectedSpanId + "-" + expectedTraceFlags;

    assertThat(httpJsonInterceptor.requestHeaders).isNotNull();
    Map<String, Object> headers = httpJsonInterceptor.requestHeaders.getHeaders();
    String expectedHttpHeaderKey = TRACEPARENT_HTTP_HEADER_KEY;
    assertThat(headers).containsKey(expectedHttpHeaderKey);

    Object headerVal = headers.get(expectedHttpHeaderKey);
    if (headerVal instanceof List) {
      @SuppressWarnings("unchecked")
      List<String> traceparentHeaders = (List<String>) headerVal;
      assertThat(traceparentHeaders).hasSize(1);
      assertThat(traceparentHeaders.get(0)).isEqualTo(expectedTraceparent);
    } else {
      assertThat(String.valueOf(headerVal)).isEqualTo(expectedTraceparent);
    }
  }
}

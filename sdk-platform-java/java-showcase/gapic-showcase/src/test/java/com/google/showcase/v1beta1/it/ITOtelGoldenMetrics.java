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
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertThrows;

import com.google.api.client.http.HttpTransport;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnavailableException;
import com.google.api.gax.tracing.ObservabilityAttributes;
import com.google.api.gax.tracing.OpenTelemetryMetricsFactory;
import com.google.common.collect.ImmutableList;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import com.google.showcase.v1beta1.stub.EchoStubSettings;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Collection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ITOtelGoldenMetrics {
  private static final String SHOWCASE_SERVER_ADDRESS = "localhost";
  private static final long SHOWCASE_SERVER_PORT = 7469;
  private static final String SHOWCASE_ARTIFACT = "com.google.cloud:gapic-showcase";

  private InMemoryMetricReader metricReader;
  private OpenTelemetrySdk openTelemetrySdk;

  @BeforeEach
  void setup() {
    metricReader = InMemoryMetricReader.create();

    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();

    openTelemetrySdk = OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();
  }

  @AfterEach
  void tearDown() {
    if (openTelemetrySdk != null) {
      openTelemetrySdk.close();
    }
  }

  @Test
  void testMetrics_successfulEcho_grpc() throws Exception {
    OpenTelemetryMetricsFactory tracerFactory = new OpenTelemetryMetricsFactory(openTelemetrySdk);

    try (EchoClient client =
        TestClientInitializer.createGrpcEchoClientOpentelemetry(tracerFactory)) {

      client.echo(EchoRequest.newBuilder().setContent("metrics-test").build());

      // The end of an operation is tracked in a separate thread.
      // Add a small sleep to make sure the tracking is completed.
      // This is implemented by adding a TraceFinisher to ApiFuture as a callback in
      // TracedUnaryCallable,
      // which could be executed in a different thread.
      Thread.sleep(100);
      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      assertThat(metrics).isNotEmpty();

      MetricData durationMetric =
          metrics.stream()
              .filter(m -> m.getName().equals("gcp.client.request.duration"))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Duration metric not found"));

      assertThat(durationMetric.getInstrumentationScopeInfo().getName())
          .isEqualTo(SHOWCASE_ARTIFACT);

      io.opentelemetry.api.common.Attributes attributes =
          durationMetric.getHistogramData().getPoints().iterator().next().getAttributes();

      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_ADDRESS);
      assertThat(
              attributes.get(AttributeKey.longKey(ObservabilityAttributes.SERVER_PORT_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_PORT);
      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE)))
          .isEqualTo("grpc");
      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE)))
          .isEqualTo("showcase");
      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.GRPC_RPC_METHOD_ATTRIBUTE)))
          .isEqualTo("google.showcase.v1beta1.Echo/Echo");
      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("OK");
    }
  }

  @Test
  void testMetrics_failedEcho_grpc_recordsErrorType() throws Exception {
    OpenTelemetryMetricsFactory tracerFactory = new OpenTelemetryMetricsFactory(openTelemetrySdk);

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
            tracerFactory, transportChannelProvider)) {

      assertThrows(
          UnavailableException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("metrics-test").build()));

      Thread.sleep(100);
      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      assertThat(metrics).isNotEmpty();

      MetricData durationMetric =
          metrics.stream()
              .filter(m -> m.getName().equals("gcp.client.request.duration"))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Duration metric not found"));

      io.opentelemetry.api.common.Attributes attributes =
          durationMetric.getHistogramData().getPoints().iterator().next().getAttributes();

      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("UNAVAILABLE");
      assertThat(
              attributes.get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
          .isEqualTo("UNAVAILABLE");
    }
  }

  @Test
  void testMetrics_successfulEcho_httpjson() throws Exception {
    OpenTelemetryMetricsFactory tracerFactory = new OpenTelemetryMetricsFactory(openTelemetrySdk);

    try (EchoClient client =
        TestClientInitializer.createHttpJsonEchoClientOpentelemetry(tracerFactory)) {

      client.echo(EchoRequest.newBuilder().setContent("metrics-test").build());

      Thread.sleep(100);
      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      assertThat(metrics).isNotEmpty();

      MetricData durationMetric =
          metrics.stream()
              .filter(m -> m.getName().equals("gcp.client.request.duration"))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Duration metric not found"));

      assertThat(durationMetric.getInstrumentationScopeInfo().getName())
          .isEqualTo(SHOWCASE_ARTIFACT);

      io.opentelemetry.api.common.Attributes attributes =
          durationMetric.getHistogramData().getPoints().iterator().next().getAttributes();

      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_ADDRESS);
      assertThat(
              attributes.get(AttributeKey.longKey(ObservabilityAttributes.SERVER_PORT_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_PORT);
      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE)))
          .isEqualTo("http");
      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE)))
          .isEqualTo("showcase");
      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("OK");
      assertThat(
              attributes.get(
                  AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo(200L);
      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.URL_TEMPLATE_ATTRIBUTE)))
          .isEqualTo("v1beta1/echo:echo");
      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.GRPC_RPC_METHOD_ATTRIBUTE)))
          .isEqualTo("google.showcase.v1beta1.Echo/Echo");
    }
  }

  @Test
  void testMetrics_failedEcho_httpjson_recordsErrorType() throws Exception {
    OpenTelemetryMetricsFactory tracerFactory = new OpenTelemetryMetricsFactory(openTelemetrySdk);

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
                .setTracerFactory(tracerFactory)
                .build();

    try (EchoClient client = EchoClient.create(echoStubSettings.createStub())) {
      assertThrows(
          UnavailableException.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("metrics-test").build()));

      Thread.sleep(100);
      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      assertThat(metrics).isNotEmpty();

      MetricData durationMetric =
          metrics.stream()
              .filter(m -> m.getName().equals("gcp.client.request.duration"))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Duration metric not found"));

      io.opentelemetry.api.common.Attributes attributes =
          durationMetric.getHistogramData().getPoints().iterator().next().getAttributes();

      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("UNAVAILABLE");
      assertThat(
              attributes.get(
                  AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo(503L);
      assertThat(
              attributes.get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
          .isEqualTo("503");
    }
  }

  @Test
  void testMetrics_clientTimeout_grpc() throws Exception {
    OpenTelemetryMetricsFactory tracerFactory = new OpenTelemetryMetricsFactory(openTelemetrySdk);

    // Using 1ms as 0ms might be rejected by some validation or trigger immediate failure before
    // metrics
    RetrySettings zeroRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeoutDuration(Duration.ofMillis(1))
            .setMaxRpcTimeoutDuration(Duration.ofMillis(1))
            .setTotalTimeoutDuration(Duration.ofMillis(1))
            .setMaxAttempts(1)
            .build();

    try (EchoClient client =
        TestClientInitializer.createGrpcEchoClientOpentelemetryWithRetrySettings(
            tracerFactory, zeroRetrySettings)) {

      assertThrows(
          Exception.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("metrics-test").build()));

      Thread.sleep(100);
      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      assertThat(metrics).isNotEmpty();

      MetricData durationMetric =
          metrics.stream()
              .filter(m -> m.getName().equals("gcp.client.request.duration"))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Duration metric not found"));

      io.opentelemetry.api.common.Attributes attributes =
          durationMetric.getHistogramData().getPoints().iterator().next().getAttributes();

      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("DEADLINE_EXCEEDED");
      assertThat(
              attributes.get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
          .isEqualTo("DEADLINE_EXCEEDED");
    }
  }

  @Test
  void testMetrics_clientTimeout_httpjson() throws Exception {
    OpenTelemetryMetricsFactory tracerFactory = new OpenTelemetryMetricsFactory(openTelemetrySdk);

    RetrySettings zeroRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeoutDuration(Duration.ofMillis(1))
            .setMaxRpcTimeoutDuration(Duration.ofMillis(1))
            .setTotalTimeoutDuration(Duration.ofMillis(1))
            .setMaxAttempts(1)
            .build();

    try (EchoClient client =
        TestClientInitializer.createHttpJsonEchoClientOpentelemetryWithRetrySettings(
            tracerFactory, zeroRetrySettings)) {

      assertThrows(
          Exception.class,
          () -> client.echo(EchoRequest.newBuilder().setContent("metrics-test").build()));

      Thread.sleep(100);
      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      assertThat(metrics).isNotEmpty();

      MetricData durationMetric =
          metrics.stream()
              .filter(m -> m.getName().equals("gcp.client.request.duration"))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Duration metric not found"));

      io.opentelemetry.api.common.Attributes attributes =
          durationMetric.getHistogramData().getPoints().iterator().next().getAttributes();

      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("DEADLINE_EXCEEDED");
      assertThat(
              attributes.get(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE)))
          .isEqualTo("504");
    }
  }

  @Test
  void testMetrics_retryShouldResultInOneMetric_grpc() throws Exception {
    OpenTelemetryMetricsFactory tracerFactory = new OpenTelemetryMetricsFactory(openTelemetrySdk);

    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeoutDuration(Duration.ofMillis(5000L))
            .setMaxRpcTimeoutDuration(Duration.ofMillis(5000L))
            .setTotalTimeoutDuration(Duration.ofMillis(5000L))
            .setMaxAttempts(3)
            .build();

    java.util.concurrent.atomic.AtomicInteger attemptCount =
        new java.util.concurrent.atomic.AtomicInteger(0);

    ClientInterceptor interceptor =
        new ClientInterceptor() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
              MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
            int attempt = attemptCount.incrementAndGet();
            if (attempt <= 2) {
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
            } else {
              return next.newCall(method, callOptions);
            }
          }
        };

    java.util.Set<StatusCode.Code> retryableCodes =
        java.util.Collections.singleton(StatusCode.Code.UNAVAILABLE);

    try (EchoClient client =
        TestClientInitializer.createGrpcEchoClientOpentelemetry(
            tracerFactory, retrySettings, retryableCodes, ImmutableList.of(interceptor))) {

      client.echo(EchoRequest.newBuilder().setContent("metrics-test").build());

      assertThat(attemptCount.get()).isEqualTo(3);

      Thread.sleep(100);
      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      assertThat(metrics).hasSize(1);

      MetricData durationMetric =
          metrics.stream()
              .filter(m -> m.getName().equals("gcp.client.request.duration"))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Duration metric not found"));

      assertThat(durationMetric.getHistogramData().getPoints()).hasSize(1);

      io.opentelemetry.api.common.Attributes attributes =
          durationMetric.getHistogramData().getPoints().iterator().next().getAttributes();

      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("OK");
    }
  }

  @Test
  void testMetrics_retryShouldResultInOneMetric_httpjson() throws Exception {
    OpenTelemetryMetricsFactory tracerFactory = new OpenTelemetryMetricsFactory(openTelemetrySdk);

    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeoutDuration(Duration.ofMillis(5000L))
            .setMaxRpcTimeoutDuration(Duration.ofMillis(5000L))
            .setTotalTimeoutDuration(Duration.ofMillis(5000L))
            .setMaxAttempts(3)
            .build();

    java.util.concurrent.atomic.AtomicInteger requestCount =
        new java.util.concurrent.atomic.AtomicInteger(0);

    HttpTransport mockTransport =
        new HttpTransport() {
          @Override
          protected com.google.api.client.http.LowLevelHttpRequest buildRequest(
              String method, String url) {
            int currentCount = requestCount.incrementAndGet();
            return new com.google.api.client.http.LowLevelHttpRequest() {
              @Override
              public void addHeader(String name, String value) {}

              @Override
              public com.google.api.client.http.LowLevelHttpResponse execute() {
                if (currentCount <= 2) {
                  return new com.google.api.client.http.LowLevelHttpResponse() {
                    @Override
                    public InputStream getContent() {
                      return new ByteArrayInputStream("{}".getBytes(UTF_8));
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
                } else {
                  return new com.google.api.client.http.LowLevelHttpResponse() {
                    @Override
                    public InputStream getContent() {
                      return new ByteArrayInputStream(
                          "{\"content\":\"metrics-test\"}".getBytes(UTF_8));
                    }

                    @Override
                    public String getContentEncoding() {
                      return null;
                    }

                    @Override
                    public long getContentLength() {
                      return 24;
                    }

                    @Override
                    public String getContentType() {
                      return "application/json";
                    }

                    @Override
                    public String getStatusLine() {
                      return "HTTP/1.1 200 OK";
                    }

                    @Override
                    public int getStatusCode() {
                      return 200;
                    }

                    @Override
                    public String getReasonPhrase() {
                      return "OK";
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
              }
            };
          }
        };

    java.util.Set<StatusCode.Code> retryableCodes =
        java.util.Collections.singleton(StatusCode.Code.UNAVAILABLE);

    try (EchoClient client =
        TestClientInitializer.createHttpJsonEchoClientOpentelemetry(
            tracerFactory, retrySettings, retryableCodes, mockTransport)) {

      client.echo(EchoRequest.newBuilder().setContent("metrics-test").build());

      assertThat(requestCount.get()).isEqualTo(3);

      Thread.sleep(100);
      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      assertThat(metrics).hasSize(1);

      MetricData durationMetric =
          metrics.stream()
              .filter(m -> m.getName().equals("gcp.client.request.duration"))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Duration metric not found"));

      assertThat(durationMetric.getHistogramData().getPoints()).hasSize(1);

      io.opentelemetry.api.common.Attributes attributes =
          durationMetric.getHistogramData().getPoints().iterator().next().getAttributes();

      assertThat(
              attributes.get(
                  AttributeKey.stringKey(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE)))
          .isEqualTo("OK");
    }
  }
}

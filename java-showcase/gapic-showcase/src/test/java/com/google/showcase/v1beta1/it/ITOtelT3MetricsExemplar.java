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

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.CompositeTracerFactory;
import com.google.api.gax.tracing.OpenTelemetryMetricsFactory;
import com.google.api.gax.tracing.OpenTelemetryTracingFactory;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.stub.EchoStub;
import com.google.showcase.v1beta1.stub.EchoStubSettings;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.ExemplarFilter;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Integration tests for Feature 3 (F3.1–F3.2): T3 Tracing and M3 Metrics Exemplar Correlation. */
class ITOtelT3MetricsExemplar {
  private static final String SHOWCASE_SERVER_ADDRESS = "localhost";
  private static final long SHOWCASE_SERVER_PORT = 7469;
  private static final String SHOWCASE_GRPC_ENDPOINT =
      String.format("%s:%s", SHOWCASE_SERVER_ADDRESS, SHOWCASE_SERVER_PORT);
  private static final String SHOWCASE_HTTPJSON_ENDPOINT =
      String.format("http://%s:%s", SHOWCASE_SERVER_ADDRESS, SHOWCASE_SERVER_PORT);
  private static final String SHOWCASE_SERVICE_NAME = "showcase";

  private InMemorySpanExporter spanExporter;
  private InMemoryMetricReader metricReader;
  private OpenTelemetrySdk openTelemetrySdk;

  @BeforeEach
  void setUp() {
    spanExporter = InMemorySpanExporter.create();
    metricReader = InMemoryMetricReader.create();

    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();

    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder()
            .registerMetricReader(metricReader)
            .setExemplarFilter(ExemplarFilter.traceBased())
            .build();

    openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(tracerProvider)
            .setMeterProvider(meterProvider)
            .buildAndRegisterGlobal();
  }

  @AfterEach
  void tearDown() {
    if (openTelemetrySdk != null) {
      openTelemetrySdk.close();
    }
    GlobalOpenTelemetry.resetForTest();
  }

  // F3.1: HTTP M3 metric records T3 span as exemplar
  @Test
  void testHttpJson_m3ExemplarMatchesT3Span() throws Exception {
    ApiTracerFactory compositeTracerFactory = createCompositeTracerFactory();
    EchoSettings settings = createEchoSettings(true);
    EchoStub stub = createStubWithServiceName(settings, compositeTracerFactory);

    try (EchoClient client = EchoClient.create(stub)) {
      client.echo(EchoRequest.newBuilder().setContent("exemplar-test-http").build());

      List<SpanData> spans = waitAndCollectSpans(2);
      SpanData t3Span =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.INTERNAL)
              .findFirst()
              .orElseThrow(() -> new AssertionError("T3 INTERNAL span not found in: " + spans));

      Collection<MetricData> metrics = waitAndCollectMetrics();
      MetricData durationMetric =
          metrics.stream()
              .filter(m -> m.getName().equals("gcp.client.request.duration"))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Duration metric not found in: " + metrics));

      HistogramPointData point = durationMetric.getHistogramData().getPoints().iterator().next();
      List<ExemplarData> exemplars = new ArrayList<>(point.getExemplars());
      assertThat(exemplars).isNotEmpty();

      ExemplarData exemplar = exemplars.get(0);
      assertThat(exemplar.getSpanContext().getTraceId()).isEqualTo(t3Span.getTraceId());
      assertThat(exemplar.getSpanContext().getSpanId()).isEqualTo(t3Span.getSpanId());
    }
  }

  // F3.2: gRPC M3 metric records T3 span as exemplar
  @Test
  void testGrpc_m3ExemplarMatchesT3Span() throws Exception {
    ApiTracerFactory compositeTracerFactory = createCompositeTracerFactory();
    EchoSettings settings = createEchoSettings(false);
    EchoStub stub = createStubWithServiceName(settings, compositeTracerFactory);

    try (EchoClient client = EchoClient.create(stub)) {
      client.echo(EchoRequest.newBuilder().setContent("exemplar-test-grpc").build());

      List<SpanData> spans = waitAndCollectSpans(2);
      SpanData t3Span =
          spans.stream()
              .filter(s -> s.getKind() == SpanKind.INTERNAL)
              .findFirst()
              .orElseThrow(() -> new AssertionError("T3 INTERNAL span not found in: " + spans));

      Collection<MetricData> metrics = waitAndCollectMetrics();
      MetricData durationMetric =
          metrics.stream()
              .filter(m -> m.getName().equals("gcp.client.request.duration"))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Duration metric not found in: " + metrics));

      HistogramPointData point = durationMetric.getHistogramData().getPoints().iterator().next();
      List<ExemplarData> exemplars = new ArrayList<>(point.getExemplars());
      assertThat(exemplars).isNotEmpty();

      ExemplarData exemplar = exemplars.get(0);
      assertThat(exemplar.getSpanContext().getTraceId()).isEqualTo(t3Span.getTraceId());
      assertThat(exemplar.getSpanContext().getSpanId()).isEqualTo(t3Span.getSpanId());
    }
  }

  private CompositeTracerFactory createCompositeTracerFactory() {
    OpenTelemetryTracingFactory tracingFactory = new OpenTelemetryTracingFactory(openTelemetrySdk);
    OpenTelemetryMetricsFactory metricsFactory = new OpenTelemetryMetricsFactory(openTelemetrySdk);
    return new CompositeTracerFactory(Arrays.asList(tracingFactory, metricsFactory));
  }

  private List<SpanData> waitAndCollectSpans(int minSpans) {
    Awaitility.await()
        .atMost(Duration.ofSeconds(5))
        .until(() -> spanExporter.getFinishedSpanItems().size() >= minSpans);
    return spanExporter.getFinishedSpanItems();
  }

  private Collection<MetricData> waitAndCollectMetrics() {
    java.util.concurrent.atomic.AtomicReference<Collection<MetricData>> holder =
        new java.util.concurrent.atomic.AtomicReference<>();
    Awaitility.await()
        .atMost(Duration.ofSeconds(5))
        .until(
            () -> {
              Collection<MetricData> metrics = metricReader.collectAllMetrics();
              if (metrics.isEmpty()) {
                return false;
              }
              for (MetricData md : metrics) {
                if (md.getName().equals("gcp.client.request.duration")) {
                  for (HistogramPointData p : md.getHistogramData().getPoints()) {
                    if (!p.getExemplars().isEmpty()) {
                      holder.set(metrics);
                      return true;
                    }
                  }
                }
              }
              return false;
            });
    return holder.get();
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

  private EchoStub createStubWithServiceName(EchoSettings settings, ApiTracerFactory tracerFactory)
      throws IOException {
    EchoStubSettings.Builder builder =
        (EchoStubSettings.Builder) settings.getStubSettings().toBuilder();
    builder.setTracerFactory(tracerFactory);
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

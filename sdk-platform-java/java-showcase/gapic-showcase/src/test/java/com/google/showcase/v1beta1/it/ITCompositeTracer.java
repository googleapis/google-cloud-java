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

import com.google.api.gax.tracing.CompositeTracerFactory;
import com.google.api.gax.tracing.ObservabilityAttributes;
import com.google.api.gax.tracing.OpenTelemetryMetricsFactory;
import com.google.api.gax.tracing.OpenTelemetryTracingFactory;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ITCompositeTracer {
  private static final String SHOWCASE_SERVER_ADDRESS = "localhost";
  private static final String SHOWCASE_ARTIFACT = "com.google.cloud:gapic-showcase";

  private InMemorySpanExporter spanExporter;
  private InMemoryMetricReader metricReader;
  private OpenTelemetrySdk openTelemetrySdk;

  @BeforeEach
  void setup() {
    spanExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();

    metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();

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

  private CompositeTracerFactory createCompositeTracerFactory() {
    OpenTelemetryTracingFactory openTelemetryTracingFactory =
        new OpenTelemetryTracingFactory(openTelemetrySdk);
    OpenTelemetryMetricsFactory metricsTracerFactory =
        new OpenTelemetryMetricsFactory(openTelemetrySdk);

    return new CompositeTracerFactory(
        Arrays.asList(openTelemetryTracingFactory, metricsTracerFactory));
  }

  @Test
  void testCompositeTracer() throws Exception {
    try (EchoClient client =
        TestClientInitializer.createGrpcEchoClientOpentelemetry(createCompositeTracerFactory())) {

      client.echo(EchoRequest.newBuilder().setContent("composite-tracing-test").build());

      // Verify Span name and one basic attribute server.address
      List<SpanData> actualSpans = spanExporter.getFinishedSpanItems();
      assertThat(actualSpans).isNotEmpty();

      SpanData attemptSpan =
          actualSpans.stream()
              .filter(span -> span.getName().equals("google.showcase.v1beta1.Echo/Echo"))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Incorrect span name"));
      assertThat(attemptSpan.getInstrumentationScopeInfo().getName()).isEqualTo(SHOWCASE_ARTIFACT);
      assertThat(
              attemptSpan
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_ADDRESS);

      Thread.sleep(100);
      // Verify metric name and one basic attribute server.address
      Collection<MetricData> actualMetrics = metricReader.collectAllMetrics();

      assertThat(actualMetrics).isNotEmpty();
      MetricData metricData =
          actualMetrics.stream()
              .filter(metricData1 -> metricData1.getName().equals("gcp.client.request.duration"))
              .findFirst()
              .orElseThrow(() -> new AssertionError("Incorrect metric name"));
      assertThat(metricData.getInstrumentationScopeInfo().getName()).isEqualTo(SHOWCASE_ARTIFACT);

      assertThat(
              metricData
                  .getHistogramData()
                  .getPoints()
                  .iterator()
                  .next()
                  .getAttributes()
                  .get(AttributeKey.stringKey(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE)))
          .isEqualTo(SHOWCASE_SERVER_ADDRESS);
    }
  }
}

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
package com.google.api.gax.tracing;

import static com.google.api.gax.tracing.GoldenSignalsMetricsRecorder.BOUNDARIES;
import static com.google.api.gax.tracing.GoldenSignalsMetricsRecorder.CLIENT_REQUEST_DURATION_METRIC_DESCRIPTION;
import static com.google.api.gax.tracing.GoldenSignalsMetricsRecorder.CLIENT_REQUEST_DURATION_METRIC_NAME;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMap;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GoldenSignalsMetricsRecorderTest {
  private static final String ARTIFACT_NAME = "test-library";
  private static final String ATTRIBUTE_1 = "attribute_1";
  private static final String VALUE_1 = "value_1";

  private InMemoryMetricReader metricReader;

  private GoldenSignalsMetricsRecorder recorder;

  @BeforeEach
  void setUp() {
    metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();
    recorder = new GoldenSignalsMetricsRecorder(openTelemetry, ARTIFACT_NAME);
  }

  @Test
  void recordOperationLatency_shouldRecordMeterInfo() {
    recorder.recordOperationLatency(0.012, ImmutableMap.of(ATTRIBUTE_1, VALUE_1));

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).hasSize(1);
    MetricData metricData = metrics.iterator().next();

    assertThat(metricData.getName()).isEqualTo(CLIENT_REQUEST_DURATION_METRIC_NAME);
    assertThat(metricData.getDescription()).isEqualTo(CLIENT_REQUEST_DURATION_METRIC_DESCRIPTION);
    assertThat(metricData.getUnit()).isEqualTo("s");
    assertThat(metricData.getInstrumentationScopeInfo().getName()).isEqualTo(ARTIFACT_NAME);
  }

  @Test
  void recordOperationLatency_shouldRecordWithBoundaries() {
    recorder.recordOperationLatency(0.012, ImmutableMap.of(ATTRIBUTE_1, VALUE_1));

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).hasSize(1);
    MetricData metricData = metrics.iterator().next();

    assertThat(metricData.getHistogramData().getPoints().iterator().next().getBoundaries())
        .isEqualTo(BOUNDARIES);
  }

  @Test
  void recordOperationLatency_shouldRecordMetrics() {
    recorder.recordOperationLatency(0.012, ImmutableMap.of(ATTRIBUTE_1, VALUE_1));

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).hasSize(1);
    MetricData metricData = metrics.iterator().next();

    assertThat(metricData.getHistogramData().getPoints()).hasSize(1);
    assertThat(metricData.getHistogramData().getPoints().iterator().next().getMax()).isNonZero();
  }

  @Test
  void recordOperationLatency_shouldRecordMetricAttributes() {
    recorder.recordOperationLatency(0.012, ImmutableMap.of(ATTRIBUTE_1, VALUE_1));

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).hasSize(1);
    MetricData metricData = metrics.iterator().next();

    assertThat(metricData.getHistogramData().getPoints().iterator().next().getAttributes())
        .isEqualTo(Attributes.of(AttributeKey.stringKey(ATTRIBUTE_1), VALUE_1));
  }
}

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

import static com.google.api.gax.tracing.ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.testing.FakeTicker;
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

class GoldenSignalsMetricsTracerTest {
  private static final String ARTIFACT_NAME = "test-library";
  public static final int TEST_REQUEST_DURATION_NANO = 2345698;
  public static final double EXPECTED_REQUEST_DURATION_SECOND = 2345698 / 1_000_000_000.0;

  private InMemoryMetricReader metricReader;

  private GoldenSignalsMetricsTracer tracer;

  private FakeTicker ticker;

  @BeforeEach
  void setUp() {
    metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();
    ticker = new FakeTicker();
    tracer =
        new GoldenSignalsMetricsTracer(
            new GoldenSignalsMetricsRecorder(openTelemetry, ARTIFACT_NAME),
            ApiTracerContext.empty(),
            ticker);
  }

  @Test
  void operationSucceeded_shouldRecordsDuration() {
    ticker.advance(TEST_REQUEST_DURATION_NANO);
    tracer.operationSucceeded();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).hasSize(1);
    MetricData metricData = metrics.iterator().next();

    assertThat(metricData.getHistogramData().getPoints()).hasSize(1);
    assertThat(metricData.getHistogramData().getPoints().iterator().next().getMax())
        .isEqualTo(EXPECTED_REQUEST_DURATION_SECOND);
  }

  @Test
  void operationSucceeded_shouldRecordsOKStatus() {
    tracer.operationSucceeded();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).hasSize(1);
    MetricData metricData = metrics.iterator().next();

    assertThat(metricData.getHistogramData().getPoints()).hasSize(1);
    assertThat(metricData.getHistogramData().getPoints().iterator().next().getAttributes())
        .isEqualTo(
            Attributes.of(
                AttributeKey.stringKey(RPC_RESPONSE_STATUS_ATTRIBUTE),
                StatusCode.Code.OK.toString()));
  }

  @Test
  void operationCancelled_shouldRecordsDuration() {
    ticker.advance(TEST_REQUEST_DURATION_NANO);
    tracer.operationCancelled();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).hasSize(1);
    MetricData metricData = metrics.iterator().next();

    assertThat(metricData.getHistogramData().getPoints()).hasSize(1);
    assertThat(metricData.getHistogramData().getPoints().iterator().next().getMax())
        .isEqualTo(EXPECTED_REQUEST_DURATION_SECOND);
  }

  @Test
  void operationCancelled_shouldRecordsOKStatus() {
    tracer.operationCancelled();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).hasSize(1);
    MetricData metricData = metrics.iterator().next();

    assertThat(metricData.getHistogramData().getPoints()).hasSize(1);
    assertThat(metricData.getHistogramData().getPoints().iterator().next().getAttributes())
        .isEqualTo(
            Attributes.of(
                AttributeKey.stringKey(RPC_RESPONSE_STATUS_ATTRIBUTE),
                StatusCode.Code.CANCELLED.toString()));
  }

  @Test
  void operationFailed_shouldRecordsDuration() {
    ticker.advance(TEST_REQUEST_DURATION_NANO);
    ApiException error =
        new ApiException("test error", null, new FakeStatusCode(StatusCode.Code.INTERNAL), false);
    tracer.operationFailed(error);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).hasSize(1);
    MetricData metricData = metrics.iterator().next();

    assertThat(metricData.getHistogramData().getPoints()).hasSize(1);
    assertThat(metricData.getHistogramData().getPoints().iterator().next().getMax())
        .isEqualTo(EXPECTED_REQUEST_DURATION_SECOND);
  }

  @Test
  void operationFailed_shouldRecordsOKStatus() {
    ApiException error =
        new ApiException("test error", null, new FakeStatusCode(StatusCode.Code.INTERNAL), false);
    tracer.operationFailed(error);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).hasSize(1);
    MetricData metricData = metrics.iterator().next();

    assertThat(metricData.getHistogramData().getPoints()).hasSize(1);
    assertThat(metricData.getHistogramData().getPoints().iterator().next().getAttributes())
        .isEqualTo(
            Attributes.of(
                AttributeKey.stringKey(RPC_RESPONSE_STATUS_ATTRIBUTE),
                StatusCode.Code.INTERNAL.toString()));
  }
}

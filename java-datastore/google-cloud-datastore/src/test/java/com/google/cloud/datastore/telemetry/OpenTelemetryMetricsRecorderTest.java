/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.datastore.telemetry;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.StatusCode;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OpenTelemetryMetricsRecorderTest {

  private InMemoryMetricReader metricReader;
  private OpenTelemetryMetricsRecorder recorder;

  @Before
  public void setUp() {
    metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();
    recorder = new OpenTelemetryMetricsRecorder(openTelemetry);
  }

  @Test
  public void recordTransactionLatency_recordsHistogramWithAttributes() {
    Map<String, String> attributes = new HashMap<>();
    attributes.put(TelemetryConstants.ATTRIBUTES_KEY_STATUS, StatusCode.Code.OK.toString());
    attributes.put(
        TelemetryConstants.ATTRIBUTES_KEY_METHOD, TelemetryConstants.METHOD_TRANSACTION_COMMIT);

    recorder.recordTransactionLatency(150.0, attributes);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    MetricData latencyMetric =
        metrics.stream()
            .filter(m -> m.getName().equals(TelemetryConstants.METRIC_NAME_TRANSACTION_LATENCY))
            .findFirst()
            .orElse(null);

    assertThat(latencyMetric).isNotNull();
    assertThat(latencyMetric.getDescription()).isEqualTo("Total latency of transaction operations");
    assertThat(latencyMetric.getUnit()).isEqualTo("ms");

    HistogramPointData point =
        latencyMetric.getHistogramData().getPoints().stream().findFirst().orElse(null);
    assertThat(point).isNotNull();
    assertThat(point.getSum()).isEqualTo(150.0);
    assertThat(point.getCount()).isEqualTo(1);
    assertThat(
            point
                .getAttributes()
                .get(AttributeKey.stringKey(TelemetryConstants.ATTRIBUTES_KEY_STATUS)))
        .isEqualTo(StatusCode.Code.OK.toString());
    assertThat(
            point
                .getAttributes()
                .get(AttributeKey.stringKey(TelemetryConstants.ATTRIBUTES_KEY_METHOD)))
        .isEqualTo(TelemetryConstants.METHOD_TRANSACTION_COMMIT);
  }

  @Test
  public void recordTransactionAttemptCount_recordsCounterWithAttributes() {
    Map<String, String> attributes = new HashMap<>();
    attributes.put(TelemetryConstants.ATTRIBUTES_KEY_STATUS, StatusCode.Code.ABORTED.toString());
    attributes.put(
        TelemetryConstants.ATTRIBUTES_KEY_METHOD, TelemetryConstants.METHOD_TRANSACTION_COMMIT);

    recorder.recordTransactionAttemptCount(1, attributes);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    MetricData attemptMetric =
        metrics.stream()
            .filter(
                m -> m.getName().equals(TelemetryConstants.METRIC_NAME_TRANSACTION_ATTEMPT_COUNT))
            .findFirst()
            .orElse(null);

    assertThat(attemptMetric).isNotNull();
    assertThat(attemptMetric.getDescription())
        .isEqualTo("Number of attempts to commit a transaction");

    LongPointData point =
        attemptMetric.getLongSumData().getPoints().stream().findFirst().orElse(null);
    assertThat(point).isNotNull();
    assertThat(point.getValue()).isEqualTo(1);
    assertThat(
            point
                .getAttributes()
                .get(AttributeKey.stringKey(TelemetryConstants.ATTRIBUTES_KEY_STATUS)))
        .isEqualTo(StatusCode.Code.ABORTED.toString());
    assertThat(
            point
                .getAttributes()
                .get(AttributeKey.stringKey(TelemetryConstants.ATTRIBUTES_KEY_METHOD)))
        .isEqualTo(TelemetryConstants.METHOD_TRANSACTION_COMMIT);
  }

  @Test
  public void recordTransactionAttemptCount_multipleAttempts_accumulates() {
    Map<String, String> abortedAttributes = new HashMap<>();
    abortedAttributes.put(
        TelemetryConstants.ATTRIBUTES_KEY_STATUS, StatusCode.Code.ABORTED.toString());
    abortedAttributes.put(
        TelemetryConstants.ATTRIBUTES_KEY_METHOD, TelemetryConstants.METHOD_TRANSACTION_COMMIT);

    Map<String, String> okAttributes = new HashMap<>();
    okAttributes.put(TelemetryConstants.ATTRIBUTES_KEY_STATUS, StatusCode.Code.OK.toString());
    okAttributes.put(
        TelemetryConstants.ATTRIBUTES_KEY_METHOD, TelemetryConstants.METHOD_TRANSACTION_COMMIT);

    // Simulate a retry scenario: first attempt ABORTED, second attempt OK
    recorder.recordTransactionAttemptCount(1, abortedAttributes);
    recorder.recordTransactionAttemptCount(1, okAttributes);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    MetricData attemptMetric =
        metrics.stream()
            .filter(
                m -> m.getName().equals(TelemetryConstants.METRIC_NAME_TRANSACTION_ATTEMPT_COUNT))
            .findFirst()
            .orElse(null);

    assertThat(attemptMetric).isNotNull();

    // There should be two data points — one for ABORTED and one for OK
    assertThat(attemptMetric.getLongSumData().getPoints()).hasSize(2);
  }

  @Test
  public void recordTransactionLatency_nullAttributes() {
    recorder.recordTransactionLatency(100.0, null);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).isNotEmpty();
  }

  @Test
  public void recordAttemptLatency_recordsHistogramWithAttributes() {
    Map<String, String> attributes = new HashMap<>();
    attributes.put(TelemetryConstants.ATTRIBUTES_KEY_STATUS, StatusCode.Code.OK.toString());
    attributes.put(TelemetryConstants.ATTRIBUTES_KEY_METHOD, TelemetryConstants.METHOD_LOOKUP);

    recorder.recordAttemptLatency(42.0, attributes);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    MetricData metric =
        metrics.stream()
            .filter(m -> m.getName().equals(TelemetryConstants.METRIC_NAME_ATTEMPT_LATENCY))
            .findFirst()
            .orElse(null);

    assertThat(metric).isNotNull();
    assertThat(metric.getDescription()).isEqualTo("Latency of a single RPC attempt");
    assertThat(metric.getUnit()).isEqualTo("ms");

    HistogramPointData point =
        metric.getHistogramData().getPoints().stream().findFirst().orElse(null);
    assertThat(point).isNotNull();
    assertThat(point.getSum()).isEqualTo(42.0);
    assertThat(point.getCount()).isEqualTo(1);
    assertThat(
            point
                .getAttributes()
                .get(AttributeKey.stringKey(TelemetryConstants.ATTRIBUTES_KEY_METHOD)))
        .isEqualTo(TelemetryConstants.METHOD_LOOKUP);
  }

  @Test
  public void recordAttemptCount_recordsCounterWithAttributes() {
    Map<String, String> attributes = new HashMap<>();
    attributes.put(TelemetryConstants.ATTRIBUTES_KEY_STATUS, StatusCode.Code.OK.toString());
    attributes.put(TelemetryConstants.ATTRIBUTES_KEY_METHOD, TelemetryConstants.METHOD_COMMIT);

    recorder.recordAttemptCount(1, attributes);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    MetricData metric =
        metrics.stream()
            .filter(m -> m.getName().equals(TelemetryConstants.METRIC_NAME_ATTEMPT_COUNT))
            .findFirst()
            .orElse(null);

    assertThat(metric).isNotNull();
    assertThat(metric.getDescription()).isEqualTo("Number of RPC attempts");

    LongPointData point = metric.getLongSumData().getPoints().stream().findFirst().orElse(null);
    assertThat(point).isNotNull();
    assertThat(point.getValue()).isEqualTo(1);
  }

  @Test
  public void recordOperationLatency_recordsHistogramWithAttributes() {
    Map<String, String> attributes = new HashMap<>();
    attributes.put(TelemetryConstants.ATTRIBUTES_KEY_STATUS, StatusCode.Code.OK.toString());
    attributes.put(TelemetryConstants.ATTRIBUTES_KEY_METHOD, TelemetryConstants.METHOD_RUN_QUERY);

    recorder.recordOperationLatency(200.0, attributes);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    MetricData metric =
        metrics.stream()
            .filter(m -> m.getName().equals(TelemetryConstants.METRIC_NAME_OPERATION_LATENCY))
            .findFirst()
            .orElse(null);

    assertThat(metric).isNotNull();
    assertThat(metric.getDescription())
        .isEqualTo("Total latency of an operation including retries");
    assertThat(metric.getUnit()).isEqualTo("ms");

    HistogramPointData point =
        metric.getHistogramData().getPoints().stream().findFirst().orElse(null);
    assertThat(point).isNotNull();
    assertThat(point.getSum()).isEqualTo(200.0);
    assertThat(point.getCount()).isEqualTo(1);
  }

  @Test
  public void recordOperationCount_recordsCounterWithAttributes() {
    Map<String, String> attributes = new HashMap<>();
    attributes.put(TelemetryConstants.ATTRIBUTES_KEY_STATUS, StatusCode.Code.OK.toString());
    attributes.put(
        TelemetryConstants.ATTRIBUTES_KEY_METHOD, TelemetryConstants.METHOD_ALLOCATE_IDS);

    recorder.recordOperationCount(1, attributes);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    MetricData metric =
        metrics.stream()
            .filter(m -> m.getName().equals(TelemetryConstants.METRIC_NAME_OPERATION_COUNT))
            .findFirst()
            .orElse(null);

    assertThat(metric).isNotNull();
    assertThat(metric.getDescription()).isEqualTo("Number of operations");

    LongPointData point = metric.getLongSumData().getPoints().stream().findFirst().orElse(null);
    assertThat(point).isNotNull();
    assertThat(point.getValue()).isEqualTo(1);
  }
}

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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNotNull;

import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for the custom-export metric views registered with {@link
 * SpannerMetrics#configureMeterProviderBuilder}.
 */
@RunWith(JUnit4.class)
public class BuiltInMetricsCustomViewsTest {

  private static Map<String, String> recordedAttributes() {
    Map<String, String> attributes = new HashMap<>();
    attributes.put(BuiltInMetricsConstant.METHOD_KEY.getKey(), "Spanner.ExecuteSql");
    attributes.put(BuiltInMetricsConstant.STATUS_KEY.getKey(), "OK");
    attributes.put(BuiltInMetricsConstant.DATABASE_KEY.getKey(), "test-database");
    attributes.put(BuiltInMetricsConstant.CLIENT_NAME_KEY.getKey(), "spanner-java/test");
    attributes.put("some_attribute_that_is_not_allowed", "should-be-filtered");
    return attributes;
  }

  private static MetricData getMetric(InMemoryMetricReader reader, String name) {
    Collection<MetricData> metrics = reader.collectAllMetrics();
    return metrics.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
  }

  @Test
  public void customViewsRenameInstrumentsIntoCustomNamespace() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProviderBuilder meterProviderBuilder =
        SdkMeterProvider.builder().registerMetricReader(reader);
    SpannerMetrics.configureMeterProviderBuilder(meterProviderBuilder);
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProviderBuilder.build()).build();
    BuiltInMetricsRecorder recorder =
        new BuiltInMetricsRecorder(openTelemetry, BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME);

    recorder.recordAttemptLatency(5.0, recordedAttributes());
    recorder.recordAttemptCount(1, recordedAttributes());
    recorder.recordOperationLatency(6.0, recordedAttributes());
    recorder.recordOperationCount(1, recordedAttributes());

    // Renamed metric names in the custom namespace.
    assertNotNull(
        getMetric(
            reader,
            BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME
                + "/"
                + BuiltInMetricsConstant.ATTEMPT_LATENCIES_NAME));
    assertNotNull(
        getMetric(
            reader,
            BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME
                + "/"
                + BuiltInMetricsConstant.OPERATION_LATENCIES_NAME));
    assertNotNull(
        getMetric(
            reader,
            BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME
                + "/"
                + BuiltInMetricsConstant.ATTEMPT_COUNT_NAME));
    assertNotNull(
        getMetric(
            reader,
            BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME
                + "/"
                + BuiltInMetricsConstant.OPERATION_COUNT_NAME));

    // The reserved Cloud Monitoring namespace never appears on the custom path.
    for (MetricData metric : reader.collectAllMetrics()) {
      assertThat(metric.getName()).doesNotContain("spanner.googleapis.com");
    }
  }

  @Test
  public void customViewsApplySpannerHistogramBuckets() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProviderBuilder meterProviderBuilder =
        SdkMeterProvider.builder().registerMetricReader(reader);
    SpannerMetrics.configureMeterProviderBuilder(meterProviderBuilder);
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProviderBuilder.build()).build();
    BuiltInMetricsRecorder recorder =
        new BuiltInMetricsRecorder(openTelemetry, BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME);

    recorder.recordAttemptLatency(5.0, recordedAttributes());

    MetricData attemptLatencies =
        getMetric(
            reader,
            BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME
                + "/"
                + BuiltInMetricsConstant.ATTEMPT_LATENCIES_NAME);
    assertNotNull(attemptLatencies);
    HistogramPointData point = attemptLatencies.getHistogramData().getPoints().iterator().next();
    assertThat(point.getBoundaries()).isEqualTo(BuiltInMetricsConstant.BUCKET_BOUNDARIES);
  }

  @Test
  public void customViewsFilterUnknownAttributes() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProviderBuilder meterProviderBuilder =
        SdkMeterProvider.builder().registerMetricReader(reader);
    SpannerMetrics.configureMeterProviderBuilder(meterProviderBuilder);
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProviderBuilder.build()).build();
    BuiltInMetricsRecorder recorder =
        new BuiltInMetricsRecorder(openTelemetry, BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME);

    recorder.recordAttemptLatency(5.0, recordedAttributes());

    MetricData attemptLatencies =
        getMetric(
            reader,
            BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME
                + "/"
                + BuiltInMetricsConstant.ATTEMPT_LATENCIES_NAME);
    assertNotNull(attemptLatencies);
    HistogramPointData point = attemptLatencies.getHistogramData().getPoints().iterator().next();
    assertThat(point.getAttributes().get(BuiltInMetricsConstant.METHOD_KEY))
        .isEqualTo("Spanner.ExecuteSql");
    assertThat(
            point
                .getAttributes()
                .get(
                    io.opentelemetry.api.common.AttributeKey.stringKey(
                        "some_attribute_that_is_not_allowed")))
        .isNull();
  }

  @Test
  public void customViewsExcludeGrpcGcpFallbackViews() {
    // grpc-gcp DirectPath-fallback metrics are only recorded on the Cloud Monitoring path, so the
    // custom-export views must not include them.
    assertThat(
            BuiltInMetricsConstant.getCustomExportViews().keySet().stream()
                .anyMatch(
                    selector ->
                        BuiltInMetricsConstant.GRPC_GCP_METER_NAME.equals(selector.getMeterName())))
        .isFalse();
    assertThat(
            BuiltInMetricsConstant.getAllViews().keySet().stream()
                .anyMatch(
                    selector ->
                        BuiltInMetricsConstant.GRPC_GCP_METER_NAME.equals(selector.getMeterName())))
        .isTrue();
  }
}

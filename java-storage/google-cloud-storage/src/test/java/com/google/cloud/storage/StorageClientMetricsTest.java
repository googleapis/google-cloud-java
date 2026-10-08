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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.Test;

public final class StorageClientMetricsTest {

  @Test
  public void standardMetrics_initializedWithoutDebug() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();

    StorageClientMetrics metrics = StorageClientMetrics.create(provider, false);

    assertThat(metrics.getRpcClientCallDuration()).isNotNull();
    assertThat(metrics.getHttpClientRequestDuration()).isNotNull();
    assertThat(metrics.getGcpClientRequestDuration()).isNotNull();
    assertThat(metrics.getOperations()).isNotNull();
    assertThat(metrics.getAttempts()).isNotNull();
    assertThat(metrics.getErrors()).isNotNull();
    assertThat(metrics.getOperationTtfb()).isNotNull();
    assertThat(metrics.getRequestBodySize()).isNotNull();
    assertThat(metrics.getResponseBodySize()).isNotNull();

    // Standard client attributes
    assertThat(metrics.getClientAttributes()).isNotNull();
    assertThat(metrics.getClientAttributes().get(StorageClientMetrics.KEY_GCP_CLIENT_SERVICE))
        .isEqualTo("storage");
    assertThat(metrics.getClientAttributes().get(StorageClientMetrics.KEY_GCP_CLIENT_VERSION))
        .isEqualTo(StorageOptions.version());
    assertThat(metrics.getClientAttributes().get(StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT))
        .isEqualTo("com.google.cloud:google-cloud-storage");
    assertThat(metrics.getClientAttributes().get(StorageClientMetrics.KEY_GCP_CLIENT_INSTANCE_ID))
        .isNotEmpty();

    // Debug instruments should be null
    assertThat(metrics.getRequestActive()).isNull();
    assertThat(metrics.getServerDuration()).isNull();
    assertThat(metrics.getServerUnreached()).isNull();
    assertThat(metrics.getStallDuration()).isNull();
    assertThat(metrics.getNetworkBytesSent()).isNull();
    assertThat(metrics.getNetworkBytesReceived()).isNull();
    assertThat(metrics.getCredentialRefreshDuration()).isNull();
  }

  @Test
  public void debugMetrics_initializedWhenEnabled() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();

    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true);

    assertThat(metrics.getRpcClientCallDuration()).isNotNull();
    assertThat(metrics.getHttpClientRequestDuration()).isNotNull();
    assertThat(metrics.getGcpClientRequestDuration()).isNotNull();
    assertThat(metrics.getOperations()).isNotNull();
    assertThat(metrics.getAttempts()).isNotNull();
    assertThat(metrics.getErrors()).isNotNull();
    assertThat(metrics.getOperationTtfb()).isNotNull();
    assertThat(metrics.getRequestBodySize()).isNotNull();
    assertThat(metrics.getResponseBodySize()).isNotNull();

    // Debug instruments should be present
    assertThat(metrics.getRequestActive()).isNotNull();
    assertThat(metrics.getServerDuration()).isNotNull();
    assertThat(metrics.getServerUnreached()).isNotNull();
    assertThat(metrics.getStallDuration()).isNotNull();
    assertThat(metrics.getNetworkBytesSent()).isNotNull();
    assertThat(metrics.getNetworkBytesReceived()).isNotNull();
    assertThat(metrics.getCredentialRefreshDuration()).isNotNull();
  }

  @Test
  public void inMemoryMetricReader_verifiesViewsAndBoundaries() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProviderBuilder providerBuilder =
        SdkMeterProvider.builder().registerMetricReader(reader);
    OpenTelemetryBootstrappingUtils.registerClientViews(providerBuilder);
    SdkMeterProvider provider = providerBuilder.build();

    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true);

    // Record data for each instrument
    metrics.getRpcClientCallDuration().record(0.123);
    metrics.getHttpClientRequestDuration().record(0.234);
    metrics.getGcpClientRequestDuration().record(0.345);
    metrics.getOperationTtfb().record(0.045);
    metrics.getServerDuration().record(0.012);
    metrics.getStallDuration().record(0.010);
    metrics.getNetworkBytesSent().add(1024 * 256);
    metrics.getNetworkBytesReceived().add(1024 * 512);
    metrics.getCredentialRefreshDuration().record(0.080);

    metrics.getRequestBodySize().record(1024 * 512);
    metrics.getResponseBodySize().record(1024 * 1024);

    metrics.getOperations().add(1);
    metrics.getAttempts().add(2);
    metrics.getErrors().add(1);
    metrics.getRequestActive().add(1);
    metrics.getServerUnreached().add(1);

    Collection<MetricData> collectedMetrics = reader.collectAllMetrics();
    Map<String, MetricData> metricsMap =
        collectedMetrics.stream()
            .collect(Collectors.toMap(MetricData::getName, Function.identity()));

    List<Double> expectedLatencyBoundaries =
        OpenTelemetryBootstrappingUtils.latencyHistogramBoundaries();
    List<Double> expectedSizeBoundaries = OpenTelemetryBootstrappingUtils.sizeHistogramBoundaries();

    // Verify standard latency histograms have custom latency boundaries and slash names
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION.replace(".", "/"),
        expectedLatencyBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_HTTP_CLIENT_REQUEST_DURATION.replace(".", "/"),
        expectedLatencyBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_CLIENT_REQUEST_DURATION.replace(".", "/"),
        expectedLatencyBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATION_TTFB.replace(".", "/"),
        expectedLatencyBoundaries);

    // Verify debug latency histograms have custom latency boundaries and slash names
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_SERVER_DURATION.replace(".", "/"),
        expectedLatencyBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_STALL_DURATION.replace(".", "/"),
        expectedLatencyBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_AUTH_CREDENTIAL_REFRESH_DURATION.replace(
            ".", "/"),
        expectedLatencyBoundaries);

    // Verify size histograms have custom size boundaries and slash names
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE.replace(".", "/"),
        expectedSizeBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE.replace(".", "/"),
        expectedSizeBoundaries);

    // Verify counter metrics
    assertThat(metricsMap).containsKey(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS);
    assertThat(metricsMap).containsKey(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(metricsMap).containsKey(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS);
    assertThat(metricsMap)
        .containsKey(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_ACTIVE);
    assertThat(metricsMap)
        .containsKey(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_SERVER_UNREACHED);
    assertThat(metricsMap)
        .containsKey(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_NETWORK_BYTES_SENT);
    assertThat(metricsMap)
        .containsKey(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_NETWORK_BYTES_RECEIVED);
  }

  @Test
  public void latencyHistogram_recordsSecondsScaleValuesIntoExpectedBuckets() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProviderBuilder providerBuilder =
        SdkMeterProvider.builder().registerMetricReader(reader);
    OpenTelemetryBootstrappingUtils.registerClientViews(providerBuilder);
    SdkMeterProvider provider = providerBuilder.build();

    StorageClientMetrics metrics = StorageClientMetrics.create(provider, false);
    metrics.getGcpClientRequestDuration().record(0.003);
    metrics.getGcpClientRequestDuration().record(1.2);
    metrics.getGcpClientRequestDuration().record(45.0);

    Collection<MetricData> collectedMetrics = reader.collectAllMetrics();
    Map<String, MetricData> metricsMap =
        collectedMetrics.stream()
            .collect(Collectors.toMap(MetricData::getName, Function.identity()));

    String metricViewName =
        StorageClientMetrics.METRIC_GCP_CLIENT_REQUEST_DURATION.replace(".", "/");
    assertThat(metricsMap).containsKey(metricViewName);

    MetricData metricData = metricsMap.get(metricViewName);
    HistogramPointData pointData = metricData.getHistogramData().getPoints().iterator().next();

    List<Double> boundaries = pointData.getBoundaries();
    List<Long> counts = pointData.getCounts();

    int index003 = findBucketIndex(boundaries, 0.003);
    int index12 = findBucketIndex(boundaries, 1.2);
    int index45 = findBucketIndex(boundaries, 45.0);

    // Verify bucket index for 0.003s is 2 (between 0.002s and 0.004s)
    assertThat(index003).isEqualTo(2);
    assertThat(boundaries.get(index003 - 1)).isEqualTo(0.002);
    assertThat(boundaries.get(index003)).isEqualTo(0.004);
    assertThat(counts.get(index003)).isEqualTo(1L);

    // Verify 1.2s lands in its expected bucket
    assertThat(boundaries.get(index12)).isEqualTo(1.2);
    assertThat(boundaries.get(index12 - 1)).isLessThan(1.2);
    assertThat(counts.get(index12)).isEqualTo(1L);

    // Verify 45.0s lands in its expected bucket
    assertThat(boundaries.get(index45)).isAtLeast(45.0);
    assertThat(boundaries.get(index45 - 1)).isLessThan(45.0);
    assertThat(counts.get(index45)).isEqualTo(1L);

    // Total count across all buckets must be 3
    long totalRecorded = counts.stream().mapToLong(Long::longValue).sum();
    assertThat(totalRecorded).isEqualTo(3L);
  }

  @Test
  public void attachClientAttributes_mergesAdditionalAttributes() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, "test-instance", false);

    Attributes extra =
        Attributes.of(
            AttributeKey.stringKey("custom.key"),
            "custom.value",
            StorageClientMetrics.KEY_GCP_CLIENT_SERVICE,
            "override-service");

    Attributes merged = metrics.attachClientAttributes(extra);

    assertThat(merged.get(StorageClientMetrics.KEY_GCP_CLIENT_INSTANCE_ID))
        .isEqualTo("test-instance");
    assertThat(merged.get(StorageClientMetrics.KEY_GCP_CLIENT_VERSION))
        .isEqualTo(StorageOptions.version());
    assertThat(merged.get(StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT))
        .isEqualTo("com.google.cloud:google-cloud-storage");
    assertThat(merged.get(AttributeKey.stringKey("custom.key"))).isEqualTo("custom.value");
    assertThat(merged.get(StorageClientMetrics.KEY_GCP_CLIENT_SERVICE))
        .isEqualTo("override-service");

    // Null or empty handling
    assertThat(metrics.attachClientAttributes(null))
        .isSameInstanceAs(metrics.getClientAttributes());
    assertThat(metrics.attachClientAttributes(Attributes.empty()))
        .isSameInstanceAs(metrics.getClientAttributes());
  }

  @Test
  public void clientAttributesBuilder_containsBaseClientAttributes() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, "test-instance", false);

    Attributes built = metrics.clientAttributesBuilder().build();
    assertThat(built).isEqualTo(metrics.getClientAttributes());
  }

  private static int findBucketIndex(List<Double> boundaries, double value) {
    for (int i = 0; i < boundaries.size(); i++) {
      if (value <= boundaries.get(i)) {
        return i;
      }
    }
    return boundaries.size();
  }

  private static void assertHistogramBoundaries(
      Map<String, MetricData> metricsMap, String metricName, List<Double> expectedBoundaries) {
    assertThat(metricsMap).containsKey(metricName);
    MetricData metricData = metricsMap.get(metricName);
    HistogramPointData pointData = metricData.getHistogramData().getPoints().iterator().next();
    assertThat(pointData.getBoundaries()).isEqualTo(expectedBoundaries);
  }
}

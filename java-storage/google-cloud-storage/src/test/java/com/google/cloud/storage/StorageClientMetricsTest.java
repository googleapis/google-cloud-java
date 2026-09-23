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

    // Debug instruments should be null
    assertThat(metrics.getRequestActive()).isNull();
    assertThat(metrics.getGfeDuration()).isNull();
    assertThat(metrics.getGfeHeaderMissing()).isNull();
    assertThat(metrics.getStallDuration()).isNull();
    assertThat(metrics.getNetworkBytesSent()).isNull();
    assertThat(metrics.getNetworkBytesReceived()).isNull();
    assertThat(metrics.getDnsLookupDuration()).isNull();
    assertThat(metrics.getTcpConnectDuration()).isNull();
    assertThat(metrics.getTlsHandshakeDuration()).isNull();
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
    assertThat(metrics.getGfeDuration()).isNotNull();
    assertThat(metrics.getGfeHeaderMissing()).isNotNull();
    assertThat(metrics.getStallDuration()).isNotNull();
    assertThat(metrics.getNetworkBytesSent()).isNotNull();
    assertThat(metrics.getNetworkBytesReceived()).isNotNull();
    assertThat(metrics.getDnsLookupDuration()).isNotNull();
    assertThat(metrics.getTcpConnectDuration()).isNotNull();
    assertThat(metrics.getTlsHandshakeDuration()).isNotNull();
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
    metrics.getGfeDuration().record(0.012);
    metrics.getStallDuration().record(0.010);
    metrics.getNetworkBytesSent().record(1024 * 256);
    metrics.getNetworkBytesReceived().record(1024 * 512);
    metrics.getDnsLookupDuration().record(0.005);
    metrics.getTcpConnectDuration().record(0.015);
    metrics.getTlsHandshakeDuration().record(0.025);
    metrics.getCredentialRefreshDuration().record(0.080);

    metrics.getRequestBodySize().record(1024 * 512);
    metrics.getResponseBodySize().record(1024 * 1024);

    metrics.getOperations().add(1);
    metrics.getAttempts().add(2);
    metrics.getErrors().add(1);
    metrics.getRequestActive().add(1);
    metrics.getGfeHeaderMissing().add(1);

    Collection<MetricData> collectedMetrics = reader.collectAllMetrics();
    Map<String, MetricData> metricsMap =
        collectedMetrics.stream()
            .collect(Collectors.toMap(MetricData::getName, Function.identity()));

    List<Double> expectedLatencyBoundaries =
        OpenTelemetryBootstrappingUtils.latencyHistogramBoundaries();
    List<Double> expectedSizeBoundaries = OpenTelemetryBootstrappingUtils.sizeHistogramBoundaries();

    // Verify standard latency histograms have custom latency boundaries
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION,
        expectedLatencyBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_HTTP_CLIENT_REQUEST_DURATION,
        expectedLatencyBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_CLIENT_REQUEST_DURATION,
        expectedLatencyBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATION_TTFB,
        expectedLatencyBoundaries);

    // Verify debug latency histograms have custom latency boundaries
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_GFE_DURATION,
        expectedLatencyBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_STALL_DURATION,
        expectedLatencyBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_NETWORK_DNS_LOOKUP_DURATION,
        expectedLatencyBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_NETWORK_TCP_CONNECT_DURATION,
        expectedLatencyBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_NETWORK_TLS_HANDSHAKE_DURATION,
        expectedLatencyBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_AUTH_CREDENTIAL_REFRESH_DURATION,
        expectedLatencyBoundaries);

    // Verify size histograms have custom size boundaries
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE,
        expectedSizeBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE,
        expectedSizeBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_NETWORK_BYTES_SENT,
        expectedSizeBoundaries);
    assertHistogramBoundaries(
        metricsMap,
        StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_NETWORK_BYTES_RECEIVED,
        expectedSizeBoundaries);

    // Verify counter metrics
    assertThat(metricsMap).containsKey(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS);
    assertThat(metricsMap).containsKey(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(metricsMap).containsKey(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS);
    assertThat(metricsMap)
        .containsKey(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_ACTIVE);
    assertThat(metricsMap)
        .containsKey(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_GFE_HEADER_MISSING);
  }

  private static void assertHistogramBoundaries(
      Map<String, MetricData> metricsMap, String metricName, List<Double> expectedBoundaries) {
    assertThat(metricsMap).containsKey(metricName);
    MetricData metricData = metricsMap.get(metricName);
    HistogramPointData pointData = metricData.getHistogramData().getPoints().iterator().next();
    assertThat(pointData.getBoundaries()).isEqualTo(expectedBoundaries);
  }
}

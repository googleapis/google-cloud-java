/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.grpc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.grpc.GcpManagedChannelOptions.GcpMetricsOptions;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GcpMultiEndpointChannelOtelMetricsTest {

  private GcpMultiEndpointChannel channel;

  @After
  public void tearDown() {
    if (channel != null) {
      channel.shutdown();
    }
  }

  @Test
  public void emitsOtelEndpointSwitchMetric() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(reader).build();
    OpenTelemetry otel = OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    GcpMetricsOptions metricsOptions =
        GcpMetricsOptions.newBuilder()
            .withOpenTelemetryMeter(otel.getMeter("grpc-gcp-me-test"))
            .withNamePrefix("test/me/")
            .build();

    GcpManagedChannelOptions gcpOptions =
        GcpManagedChannelOptions.newBuilder().withMetricsOptions(metricsOptions).build();

    List<String> endpoints = Arrays.asList("localhost:12345", "localhost:23456");
    GcpMultiEndpointOptions meOpts =
        GcpMultiEndpointOptions.newBuilder(endpoints).withName("default").build();

    channel = new GcpMultiEndpointChannel(Arrays.asList(meOpts), /* apiConfig= */ null, gcpOptions);

    Collection<MetricData> metrics = reader.collectAllMetrics();
    assertNotNull(metrics);
    List<MetricData> endpointSwitch =
        metrics.stream()
            .filter(
                m -> m.getName().equals("test/me/" + GcpMetricsConstants.METRIC_ENDPOINT_SWITCH))
            .collect(Collectors.toList());
    assertTrue(!endpointSwitch.isEmpty());

    MetricData m = endpointSwitch.get(0);
    boolean hasFallback =
        m.getLongGaugeData().getPoints().stream()
            .anyMatch(
                p ->
                    p.getAttributes().asMap().values().contains(GcpMetricsConstants.TYPE_FALLBACK));
    boolean hasRecover =
        m.getLongGaugeData().getPoints().stream()
            .anyMatch(
                p -> p.getAttributes().asMap().values().contains(GcpMetricsConstants.TYPE_RECOVER));
    boolean hasReplace =
        m.getLongGaugeData().getPoints().stream()
            .anyMatch(
                p -> p.getAttributes().asMap().values().contains(GcpMetricsConstants.TYPE_REPLACE));
    assertTrue(hasFallback && hasRecover && hasReplace);
  }
}

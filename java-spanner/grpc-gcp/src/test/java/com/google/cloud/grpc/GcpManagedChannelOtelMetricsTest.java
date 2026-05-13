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

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GcpManagedChannelOtelMetricsTest {

  private ManagedChannel channelToShutdown;

  @After
  public void tearDown() {
    if (channelToShutdown != null) {
      channelToShutdown.shutdownNow();
      try {
        channelToShutdown.awaitTermination(2, TimeUnit.SECONDS);
      } catch (InterruptedException ignored) {
      }
    }
  }

  @Test
  public void emitsOtelMetricsWhenMeterProvided() {
    InMemoryMetricReader inMemoryMetricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(inMemoryMetricReader).build();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    GcpManagedChannelOptions.GcpMetricsOptions metricsOptions =
        GcpManagedChannelOptions.GcpMetricsOptions.newBuilder()
            .withOpenTelemetryMeter(openTelemetry.getMeter("grpc-gcp-test"))
            .withNamePrefix("test/grpc-gcp/")
            .build();

    GcpManagedChannelOptions options =
        GcpManagedChannelOptions.newBuilder()
            .withMetricsOptions(metricsOptions)
            .withChannelPoolOptions(
                GcpManagedChannelOptions.GcpChannelPoolOptions.newBuilder()
                    .setMaxSize(1)
                    .setMinSize(1)
                    .build())
            .build();

    ManagedChannelBuilder<?> builder =
        ManagedChannelBuilder.forAddress("localhost", 0).usePlaintext();
    GcpManagedChannel gcpChannel = new GcpManagedChannel(builder, /* apiConfig= */ null, options);
    this.channelToShutdown = gcpChannel;

    // Trigger metrics collection callback at least once.
    inMemoryMetricReader.collectAllMetrics();

    Collection<MetricData> metrics = inMemoryMetricReader.collectAllMetrics();
    assertNotNull(metrics);
    List<String> names = metrics.stream().map(MetricData::getName).collect(Collectors.toList());

    assertTrue(
        names.stream()
            .anyMatch(n -> n.equals("test/grpc-gcp/" + GcpMetricsConstants.METRIC_NUM_CHANNELS)));
    assertTrue(
        names.stream()
            .anyMatch(
                n -> n.equals("test/grpc-gcp/" + GcpMetricsConstants.METRIC_MIN_READY_CHANNELS)));
    assertTrue(
        names.stream()
            .anyMatch(
                n -> n.equals("test/grpc-gcp/" + GcpMetricsConstants.METRIC_MAX_READY_CHANNELS)));
  }
}

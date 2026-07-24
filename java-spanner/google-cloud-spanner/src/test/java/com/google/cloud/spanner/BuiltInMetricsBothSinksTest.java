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

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * End-to-end proof of the additive dual-export semantics: a non-OMNI client with a custom sink AND
 * the Cloud Monitoring (GCM) sink enabled records the app-layer built-in metrics into BOTH
 * OpenTelemetry instances at once, each in its own namespace, with no cross-contamination.
 *
 * <p>The reserved-namespace GCM OpenTelemetry is injected in-memory (it is normally backed by the
 * live Cloud Monitoring exporter), and {@code jmh.enabled} lifts the {@code NoCredentials} guard so
 * the GCM app-layer tracer is created just as it would be with real credentials.
 */
@RunWith(JUnit4.class)
public class BuiltInMetricsBothSinksTest extends AbstractMockServerTest {
  private static final Statement SELECT1 = Statement.of("SELECT 1");

  private String previousJmhEnabled;

  @Before
  public void enableCloudMonitoringGuard() {
    // usesNoCredentials() returns false when jmh.enabled=true, so the GCM app-layer tracer is
    // created even though the client uses NoCredentials against the mock server.
    previousJmhEnabled = System.getProperty("jmh.enabled");
    System.setProperty("jmh.enabled", "true");
    BuiltInMetricsProvider.INSTANCE.reset();
  }

  @After
  public void restore() {
    BuiltInMetricsProvider.INSTANCE.reset();
    if (previousJmhEnabled == null) {
      System.clearProperty("jmh.enabled");
    } else {
      System.setProperty("jmh.enabled", previousJmhEnabled);
    }
  }

  private static OpenTelemetrySdk gcmOpenTelemetry(InMemoryMetricReader reader) {
    SdkMeterProviderBuilder meterProviderBuilder =
        SdkMeterProvider.builder().registerMetricReader(reader);
    // Reserved-namespace views: rename raw instruments to spanner.googleapis.com/internal/client/*.
    BuiltInMetricsConstant.getAllViews().forEach(meterProviderBuilder::registerView);
    return OpenTelemetrySdk.builder().setMeterProvider(meterProviderBuilder.build()).build();
  }

  private static OpenTelemetrySdk customOpenTelemetry(InMemoryMetricReader reader) {
    SdkMeterProviderBuilder meterProviderBuilder =
        SdkMeterProvider.builder().registerMetricReader(reader);
    // Custom-namespace views: rename raw instruments to spanner/client/*.
    SpannerMetrics.configureMeterProviderBuilder(meterProviderBuilder);
    return OpenTelemetrySdk.builder().setMeterProvider(meterProviderBuilder.build()).build();
  }

  private Spanner createSpanner(OpenTelemetry customSink) {
    return SpannerOptions.newBuilder()
        .setProjectId("my-project")
        .setHost(String.format("http://localhost:%d", getPort()))
        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
        .setCredentials(NoCredentials.getInstance())
        .setSessionPoolOption(SessionPoolOptions.newBuilder().setFailOnSessionLeak().build())
        .setClientMetricsProvider(CustomOpenTelemetryMetricsProvider.create(customSink))
        .build()
        .getService();
  }

  private static void executeSelect1(Spanner spanner) {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("my-project", "my-instance", "my-database"));
    try (ResultSet resultSet = client.singleUse().executeQuery(SELECT1)) {
      assertThat(resultSet.next()).isTrue();
      assertThat(resultSet.getLong(0)).isEqualTo(1L);
    }
  }

  private static MetricData getMetric(InMemoryMetricReader reader, String name) {
    Collection<MetricData> metrics = reader.collectAllMetrics();
    return metrics.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
  }

  private static long operationCount(InMemoryMetricReader reader, String meterName) {
    MetricData metric =
        getMetric(reader, meterName + "/" + BuiltInMetricsConstant.OPERATION_COUNT_NAME);
    assertThat(metric).isNotNull();
    return metric.getLongSumData().getPoints().stream().mapToLong(point -> point.getValue()).sum();
  }

  @Test
  public void bothSinksRecordAppLayerMetricsInTheirOwnNamespaces() {
    InMemoryMetricReader gcmReader = InMemoryMetricReader.create();
    InMemoryMetricReader customReader = InMemoryMetricReader.create();
    BuiltInMetricsProvider.INSTANCE.setOpenTelemetry(gcmOpenTelemetry(gcmReader));

    try (Spanner spanner = createSpanner(customOpenTelemetry(customReader))) {
      executeSelect1(spanner);
    }

    // Both sinks recorded the operation, each in its own namespace.
    assertThat(operationCount(gcmReader, BuiltInMetricsConstant.METER_NAME)).isGreaterThan(0L);
    assertThat(operationCount(customReader, BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME))
        .isGreaterThan(0L);

    // No cross-contamination: the reserved names never land on the custom sink, and the custom
    // names never land on the GCM sink.
    for (MetricData metric : customReader.collectAllMetrics()) {
      assertThat(metric.getName()).doesNotContain("spanner.googleapis.com");
    }
    for (MetricData metric : gcmReader.collectAllMetrics()) {
      assertThat(metric.getName())
          .doesNotContain(BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME + "/");
    }
  }
}

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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration test (mock server) for {@link CustomOpenTelemetryMetricsProvider}: built-in metrics
 * are recorded on the caller-provided OpenTelemetry with the {@code spanner/client/} names, and
 * nothing is recorded for {@link NoopMetricsProvider} or the coerced OMNI default.
 */
@RunWith(JUnit4.class)
public class BuiltInMetricsCustomOpenTelemetryTest extends AbstractMockServerTest {
  private static final Statement SELECT1 = Statement.of("SELECT 1");

  @After
  public void resetGcmSingleton() {
    // A cloud custom+enabled client now also activates the Cloud Monitoring sink (additive
    // semantics), which initializes the process-wide singleton via the gRPC layer. Reset it so the
    // state does not leak into other tests sharing the JVM fork.
    BuiltInMetricsProvider.INSTANCE.reset();
  }

  private Spanner createSpanner(MetricsProvider metricsProvider) {
    return spannerBuilder(metricsProvider).build().getService();
  }

  private SpannerOptions.Builder spannerBuilder(MetricsProvider metricsProvider) {
    return SpannerOptions.newBuilder()
        .setProjectId("my-project")
        .setHost(String.format("http://localhost:%d", getPort()))
        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
        .setCredentials(NoCredentials.getInstance())
        .setSessionPoolOption(SessionPoolOptions.newBuilder().setFailOnSessionLeak().build())
        .setClientMetricsProvider(metricsProvider);
  }

  private static OpenTelemetrySdk createOpenTelemetry(InMemoryMetricReader metricReader) {
    SdkMeterProviderBuilder meterProviderBuilder =
        SdkMeterProvider.builder().registerMetricReader(metricReader);
    SpannerMetrics.configureMeterProviderBuilder(meterProviderBuilder);
    return OpenTelemetrySdk.builder().setMeterProvider(meterProviderBuilder.build()).build();
  }

  private static void executeSelect1(Spanner spanner) {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("my-project", "my-instance", "my-database"));
    try (ResultSet resultSet = client.singleUse().executeQuery(SELECT1)) {
      assertTrue(resultSet.next());
      assertThat(resultSet.getLong(0)).isEqualTo(1L);
    }
  }

  private static MetricData getMetric(InMemoryMetricReader reader, String name) {
    Collection<MetricData> metrics = reader.collectAllMetrics();
    return metrics.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
  }

  @Test
  public void builtInMetricsAreRecordedOnCustomOpenTelemetry() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    try (Spanner spanner =
        createSpanner(
            CustomOpenTelemetryMetricsProvider.create(createOpenTelemetry(metricReader)))) {
      executeSelect1(spanner);
    }

    MetricData operationCount =
        getMetric(
            metricReader,
            BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME
                + "/"
                + BuiltInMetricsConstant.OPERATION_COUNT_NAME);
    assertNotNull(operationCount);
    assertThat(
            operationCount.getLongSumData().getPoints().stream()
                .anyMatch(
                    point ->
                        point.getValue() > 0
                            && "Spanner.ExecuteStreamingSql"
                                .equals(
                                    point.getAttributes().get(BuiltInMetricsConstant.METHOD_KEY))
                            && "OK"
                                .equals(
                                    point.getAttributes().get(BuiltInMetricsConstant.STATUS_KEY))
                            && "my-database"
                                .equals(
                                    point.getAttributes().get(BuiltInMetricsConstant.DATABASE_KEY))
                            && point.getAttributes().get(BuiltInMetricsConstant.CLIENT_NAME_KEY)
                                != null))
        .isTrue();

    MetricData attemptLatencies =
        getMetric(
            metricReader,
            BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME
                + "/"
                + BuiltInMetricsConstant.ATTEMPT_LATENCIES_NAME);
    assertNotNull(attemptLatencies);

    // A default cloud client never produces the endpoint label, even on the custom sink.
    assertThat(
            attemptLatencies.getHistogramData().getPoints().stream()
                .allMatch(
                    point ->
                        point.getAttributes().get(BuiltInMetricsConstant.ENDPOINT_KEY) == null))
        .isTrue();

    // The reserved Cloud Monitoring names never appear on the custom sink.
    for (MetricData metric : metricReader.collectAllMetrics()) {
      assertThat(metric.getName()).doesNotContain("spanner.googleapis.com");
    }
  }

  @Test
  public void noMetricsAreRecordedForNoopProvider() {
    InMemoryMetricReader noopReader = InMemoryMetricReader.create();
    // The OpenTelemetry instance exists, but the provider is Noop: nothing may be recorded.
    OpenTelemetrySdk unusedOpenTelemetry = createOpenTelemetry(noopReader);

    try (Spanner noopSpanner = createSpanner(NoopMetricsProvider.INSTANCE)) {
      executeSelect1(noopSpanner);
    }

    assertThat(noopReader.collectAllMetrics()).isEmpty();
  }

  @Test
  public void gcmSingletonIsNotInitializedByCustomOnlyClient() {
    // With the Cloud Monitoring sink disabled, a custom-sink client must not create or modify the
    // process-wide Cloud Monitoring OpenTelemetry singleton (custom sink only, no GCM).
    BuiltInMetricsProvider.INSTANCE.reset();
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    try (Spanner spanner =
        spannerBuilder(CustomOpenTelemetryMetricsProvider.create(createOpenTelemetry(metricReader)))
            .setBuiltInMetricsEnabled(false)
            .build()
            .getService()) {
      executeSelect1(spanner);
    }
    assertNull(BuiltInMetricsProvider.INSTANCE.getOpenTelemetry());
  }
}

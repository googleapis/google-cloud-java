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
import static org.junit.Assert.assertTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration test (mock server) for the {@code endpoint} label on the location-aware fastpath:
 * with the experimental location API enabled and a {@link CustomOpenTelemetryMetricsProvider},
 * attempt metrics carry the endpoint the attempt was routed to; a regular cloud client never
 * produces the label.
 */
@RunWith(JUnit4.class)
public class LocationAwareEndpointMetricsTest extends AbstractMockServerTest {
  private static final Statement SELECT1 = Statement.of("SELECT 1");

  @After
  public void resetEnvironment() {
    SpannerOptions.useDefaultEnvironment();
  }

  private Spanner createSpanner(boolean enableLocationApi, InMemoryMetricReader metricReader) {
    if (enableLocationApi) {
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Override
            public boolean isEnableLocationApi() {
              return true;
            }
          });
    } else {
      SpannerOptions.useDefaultEnvironment();
    }
    try {
      SdkMeterProviderBuilder meterProviderBuilder =
          SdkMeterProvider.builder().registerMetricReader(metricReader);
      SpannerMetrics.configureMeterProviderBuilder(meterProviderBuilder);
      OpenTelemetrySdk openTelemetry =
          OpenTelemetrySdk.builder().setMeterProvider(meterProviderBuilder.build()).build();
      return SpannerOptions.newBuilder()
          .setProjectId("my-project")
          .setHost(String.format("http://localhost:%d", getPort()))
          .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
          .setCredentials(NoCredentials.getInstance())
          .setSessionPoolOption(SessionPoolOptions.newBuilder().setFailOnSessionLeak().build())
          .setClientMetricsProvider(CustomOpenTelemetryMetricsProvider.create(openTelemetry))
          .build()
          .getService();
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  private static void executeSelect1(Spanner spanner) {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("my-project", "my-instance", "my-database"));
    try (ResultSet resultSet = client.singleUse().executeQuery(SELECT1)) {
      assertTrue(resultSet.next());
    }
  }

  private static MetricData getMetric(InMemoryMetricReader reader, String name) {
    Collection<MetricData> metrics = reader.collectAllMetrics();
    return metrics.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
  }

  @Test
  public void attemptMetricsCarryEndpointLabelOnFastpath() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    try (Spanner spanner = createSpanner(/* enableLocationApi= */ true, metricReader)) {
      executeSelect1(spanner);
    }

    MetricData attemptLatencies =
        getMetric(
            metricReader,
            BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME
                + "/"
                + BuiltInMetricsConstant.ATTEMPT_LATENCIES_NAME);
    assertNotNull(attemptLatencies);
    HistogramPointData queryPoint =
        attemptLatencies.getHistogramData().getPoints().stream()
            .filter(
                point ->
                    "Spanner.ExecuteStreamingSql"
                        .equals(point.getAttributes().get(BuiltInMetricsConstant.METHOD_KEY)))
            .findFirst()
            .orElse(null);
    assertNotNull(queryPoint);
    String endpoint = queryPoint.getAttributes().get(BuiltInMetricsConstant.ENDPOINT_KEY);
    assertNotNull(endpoint);
    // Without any routing information from the server, the attempt is routed to the default
    // endpoint of the mock server.
    assertThat(endpoint).contains(String.valueOf(getPort()));
  }

  @Test
  public void cloudClientNeverProducesEndpointLabel() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    try (Spanner spanner = createSpanner(/* enableLocationApi= */ false, metricReader)) {
      executeSelect1(spanner);
    }

    MetricData attemptLatencies =
        getMetric(
            metricReader,
            BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME
                + "/"
                + BuiltInMetricsConstant.ATTEMPT_LATENCIES_NAME);
    assertNotNull(attemptLatencies);
    assertThat(
            attemptLatencies.getHistogramData().getPoints().stream()
                .allMatch(
                    point ->
                        point.getAttributes().get(BuiltInMetricsConstant.ENDPOINT_KEY) == null))
        .isTrue();
  }
}

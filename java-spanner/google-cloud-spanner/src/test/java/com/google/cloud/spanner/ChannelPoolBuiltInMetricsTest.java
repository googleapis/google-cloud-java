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

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.cloud.NoCredentials;
import com.google.cloud.grpc.GcpManagedChannel;
import com.google.cloud.spanner.SpannerOptions.CallContextConfigurator;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.spi.v1.GapicSpannerRpc;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ChannelPoolBuiltInMetricsTest extends AbstractMockServerTest {
  private static final String CHANNEL_COUNT =
      BuiltInMetricsConstant.METER_NAME + "/channel_pool/channel_count";
  private static final String CHANNEL_LOAD =
      BuiltInMetricsConstant.METER_NAME + "/channel_pool/channel_load";
  private static final int NUM_CHANNELS = 4;

  private String previousJmhEnabled;
  private InMemoryMetricReader builtInReader;

  @Before
  public void setUp() {
    previousJmhEnabled = System.getProperty("jmh.enabled");
    System.setProperty("jmh.enabled", "true");
    BuiltInMetricsProvider.INSTANCE.reset();
    builtInReader = InMemoryMetricReader.create();
    SdkMeterProviderBuilder meterProviderBuilder =
        SdkMeterProvider.builder().registerMetricReader(builtInReader);
    BuiltInMetricsConstant.getAllViews().forEach(meterProviderBuilder::registerView);
    BuiltInMetricsProvider.INSTANCE.setOpenTelemetry(
        OpenTelemetrySdk.builder().setMeterProvider(meterProviderBuilder.build()).build());
  }

  @After
  public void tearDown() {
    SpannerOptions.useDefaultEnvironment();
    BuiltInMetricsProvider.INSTANCE.reset();
    if (previousJmhEnabled == null) {
      System.clearProperty("jmh.enabled");
    } else {
      System.setProperty("jmh.enabled", previousJmhEnabled);
    }
  }

  @Test
  public void channelCountIsReportedForTheDataPoolOnly() {
    try (Spanner spanner = createOptions().build().getService()) {
      executeSelect1(spanner);

      List<LongPointData> active = activeChannelCountPoints();
      assertThat(active).hasSize(1);
      assertThat(active.get(0).getValue()).isEqualTo(NUM_CHANNELS);
      assertThat(active.get(0).getAttributes().get(BuiltInMetricsConstant.LANE_KEY))
          .isEqualTo(BuiltInMetricsConstant.LANE_CLOUDPATH);
      assertThat(active.get(0).getAttributes().get(BuiltInMetricsConstant.POOL_MODE_KEY))
          .isEqualTo("static");
      assertThat(active.get(0).getAttributes().get(BuiltInMetricsConstant.POOL_INDEX_KEY))
          .isNotNull();
    }
  }

  @Test
  public void channelPoolMetricsAreNotReportedWithoutCredentials() {
    System.clearProperty("jmh.enabled");
    try (Spanner spanner = createOptions().build().getService()) {
      executeSelect1(spanner);

      assertThat(channelCountPoints()).isEmpty();
      assertThat(channelLoadPoints()).isEmpty();
    }
  }

  @Test
  public void channelLoadIsReportedWithTheDatabaseOfTheCall() {
    try (Spanner spanner = createOptions().build().getService()) {
      executeSelect1(spanner);

      List<HistogramPointData> points = channelLoadPoints();
      assertThat(points).hasSize(1);
      HistogramPointData point = points.get(0);
      assertThat(point.getAttributes().get(BuiltInMetricsConstant.PROJECT_ID_KEY))
          .isEqualTo("my-project");
      assertThat(point.getAttributes().get(BuiltInMetricsConstant.INSTANCE_ID_KEY))
          .isEqualTo("my-instance");
      assertThat(point.getAttributes().get(BuiltInMetricsConstant.DATABASE_KEY))
          .isEqualTo("my-database");
      assertThat(point.getAttributes().get(BuiltInMetricsConstant.LANE_KEY))
          .isEqualTo(BuiltInMetricsConstant.LANE_CLOUDPATH);
      assertThat(point.getAttributes().get(BuiltInMetricsConstant.POOL_MODE_KEY))
          .isEqualTo("static");
      assertThat(point.getCount()).isAtLeast(1);
      assertThat(point.getBoundaries())
          .containsExactly(
              1.0, 2.0, 3.0, 5.0, 8.0, 12.0, 16.0, 20.0, 25.0, 30.0, 40.0, 50.0, 75.0, 100.0, 150.0,
              200.0)
          .inOrder();
    }
  }

  @Test
  public void applicationCannotChangeTheChannelLoadAttributes() {
    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            GrpcCallContext grpcContext = (GrpcCallContext) context;
            return grpcContext.withCallOptions(
                grpcContext
                    .getCallOptions()
                    .withOption(
                        GcpManagedChannel.BUILT_IN_METRICS_ATTRIBUTES_KEY,
                        Attributes.of(BuiltInMetricsConstant.PROJECT_ID_KEY, "other-project")));
          }
        };
    try (Spanner spanner =
        createOptions().setCallContextConfigurator(configurator).build().getService()) {
      executeSelect1(spanner);

      assertThat(
              channelLoadPoints().stream()
                  .map(point -> point.getAttributes().get(BuiltInMetricsConstant.PROJECT_ID_KEY))
                  .collect(Collectors.toList()))
          .containsExactly("my-project");
    }
  }

  @Test
  public void directPathFallbackReportsOneDataPoolPerLane() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
    GapicSpannerRpc rpc = new GapicSpannerRpc(createDirectPathFallbackOptions());
    try {
      List<LongPointData> active = activeChannelCountPoints();
      assertThat(
              active.stream()
                  .map(point -> point.getAttributes().get(BuiltInMetricsConstant.LANE_KEY))
                  .collect(Collectors.toList()))
          .containsExactly(
              BuiltInMetricsConstant.LANE_DIRECTPATH, BuiltInMetricsConstant.LANE_CLOUDPATH);
      assertThat(active.stream().map(LongPointData::getValue).collect(Collectors.toList()))
          .containsExactly((long) NUM_CHANNELS, (long) NUM_CHANNELS);
      assertThat(
              active.stream()
                  .map(point -> point.getAttributes().get(BuiltInMetricsConstant.POOL_INDEX_KEY))
                  .distinct()
                  .count())
          .isEqualTo(1);
    } finally {
      rpc.shutdown();
    }
  }

  @Test
  public void directPathFallbackRecoveryReportsOneDataPoolWithoutLane() {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public boolean isEnableGcpFallbackRecovery() {
            return true;
          }
        });
    GapicSpannerRpc rpc = new GapicSpannerRpc(createDirectPathFallbackOptions());
    try {
      List<LongPointData> active = activeChannelCountPoints();
      assertThat(active).hasSize(1);
      assertThat(active.get(0).getValue()).isEqualTo(NUM_CHANNELS);
      assertThat(active.get(0).getAttributes().get(BuiltInMetricsConstant.LANE_KEY)).isNull();
    } finally {
      rpc.shutdown();
    }
  }

  @Test
  public void channelPoolMetricsAreNotReportedWhenDisabledWithEnvironmentVariable() {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public boolean isEnableChannelPoolBuiltInMetrics() {
            return false;
          }
        });
    try (Spanner spanner = createOptions().build().getService()) {
      executeSelect1(spanner);

      assertThat(channelCountPoints()).isEmpty();
      assertThat(channelLoadPoints()).isEmpty();
    }
  }

  @Test
  public void channelPoolMetricsAreNotReportedWhenBuiltInMetricsAreDisabled() {
    try (Spanner spanner = createOptions().setBuiltInMetricsEnabled(false).build().getService()) {
      executeSelect1(spanner);

      assertThat(channelCountPoints()).isEmpty();
      assertThat(channelLoadPoints()).isEmpty();
    }
  }

  @Test
  public void channelPoolMetricsAreNotReportedWithTheEmulator() {
    mockInstanceAdmin.addResponse(ListInstanceConfigsResponse.getDefaultInstance());
    try (Spanner spanner =
        createOptions().setEmulatorHost("localhost:" + getPort()).build().getService()) {
      executeSelect1(spanner);

      assertThat(channelCountPoints()).isEmpty();
      assertThat(channelLoadPoints()).isEmpty();
    }
  }

  private SpannerOptions.Builder createOptions() {
    return SpannerOptions.newBuilder()
        .setProjectId("my-project")
        .setHost(String.format("http://localhost:%d", getPort()))
        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
        .setCredentials(NoCredentials.getInstance())
        .enableGrpcGcpExtension()
        .disableDynamicChannelPool()
        .setNumChannels(NUM_CHANNELS);
  }

  private SpannerOptions createDirectPathFallbackOptions() {
    return SpannerOptions.newBuilder()
        .setProjectId("my-project")
        .setEnableDirectAccess(true)
        .setHost("http://localhost:1")
        .setCredentials(NoCredentials.getInstance())
        .enableGrpcGcpExtension()
        .disableDynamicChannelPool()
        .setNumChannels(NUM_CHANNELS)
        .build();
  }

  private static void executeSelect1(Spanner spanner) {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("my-project", "my-instance", "my-database"));
    try (ResultSet resultSet = client.singleUse().executeQuery(SELECT1_STATEMENT)) {
      assertThat(resultSet.next()).isTrue();
    }
  }

  private List<LongPointData> channelCountPoints() {
    return builtInReader.collectAllMetrics().stream()
        .filter(metric -> metric.getName().equals(CHANNEL_COUNT))
        .flatMap(metric -> metric.getLongSumData().getPoints().stream())
        .collect(Collectors.toList());
  }

  private List<LongPointData> activeChannelCountPoints() {
    return channelCountPoints().stream()
        .filter(
            point -> "active".equals(point.getAttributes().get(BuiltInMetricsConstant.STATE_KEY)))
        .collect(Collectors.toList());
  }

  private List<HistogramPointData> channelLoadPoints() {
    return builtInReader.collectAllMetrics().stream()
        .filter(metric -> metric.getName().equals(CHANNEL_LOAD))
        .flatMap(metric -> metric.getHistogramData().getPoints().stream())
        .collect(Collectors.toList());
  }
}

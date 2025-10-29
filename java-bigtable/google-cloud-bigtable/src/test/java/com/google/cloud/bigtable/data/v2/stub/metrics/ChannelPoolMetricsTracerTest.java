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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.OUTSTANDING_RPCS_PER_CHANNEL_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.PER_CONNECTION_ERROR_COUNT_NAME;
import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.google.cloud.bigtable.gaxx.grpc.BigtableChannelObserver;
import com.google.cloud.bigtable.gaxx.grpc.BigtableChannelPoolObserver;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class ChannelPoolMetricsTracerTest {

  @Rule public final MockitoRule mockito = MockitoJUnit.rule();

  private InMemoryMetricReader metricReader;
  @Mock private ScheduledExecutorService mockScheduler;
  private ArgumentCaptor<Runnable> runnableCaptor;

  private ChannelPoolMetricsTracer tracker;
  private Attributes baseAttributes;

  @Mock private BigtableChannelPoolObserver mockInsightsProvider;
  @Mock private BigtableChannelObserver mockInsight1;
  @Mock private BigtableChannelObserver mockInsight2;

  @Before
  public void setUp() {
    metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    baseAttributes = Attributes.builder().build();

    tracker = new ChannelPoolMetricsTracer(openTelemetry, baseAttributes);

    runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
    // Configure mockScheduler to capture the runnable when tracker.start() is called
    when(mockScheduler.scheduleAtFixedRate(runnableCaptor.capture(), anyLong(), anyLong(), any()))
        .then((Answer<ScheduledFuture<?>>) invocation -> Mockito.mock(ScheduledFuture.class));

    // Default stubbing for insights provider
    List<BigtableChannelObserver> defaultInsights = ImmutableList.of(mockInsight1, mockInsight2);
    when(mockInsightsProvider.getChannelInfos()).thenAnswer(invocation -> defaultInsights);
    // Default stubbing for observer methods
    when(mockInsight1.getOutstandingUnaryRpcs()).thenReturn(0);
    when(mockInsight1.getOutstandingStreamingRpcs()).thenReturn(0);
    when(mockInsight1.getAndResetErrorCount()).thenReturn(0L);
    when(mockInsight1.getAndResetSuccessCount()).thenReturn(0L);
    when(mockInsight2.getOutstandingUnaryRpcs()).thenReturn(0);
    when(mockInsight2.getOutstandingStreamingRpcs()).thenReturn(0);
    when(mockInsight2.getAndResetErrorCount()).thenReturn(0L);
    when(mockInsight2.getAndResetSuccessCount()).thenReturn(0L);
    when(mockInsight1.isAltsChannel()).thenReturn(false);
    when(mockInsight2.isAltsChannel()).thenReturn(false);
  }

  /** Helper to run the captured ChannelPoolMetricsTracer task. */
  void runTrackerTask() {
    List<Runnable> capturedRunnables = runnableCaptor.getAllValues();
    assertThat(capturedRunnables).hasSize(1); // Expect only one task scheduled
    Runnable trackerRunnable = capturedRunnables.get(0);
    assertThat(trackerRunnable).isInstanceOf(ChannelPoolMetricsTracer.class);
    trackerRunnable.run();
  }

  private Attributes getExpectedErrorAttributes() {
    return Attributes.builder().build();
  }

  private static Attributes getExpectedRpcAttributes(String lbPolicy, boolean streaming) {
    return Attributes.builder()
        .put(AttributeKey.stringKey("transport_type"), "CLOUDPATH")
        .put(AttributeKey.stringKey("lb_policy"), lbPolicy)
        .put(AttributeKey.booleanKey("streaming"), streaming)
        .build();
  }

  private static Optional<MetricData> getMetricData(
      Collection<MetricData> metrics, String metricName) {
    return metrics.stream().filter(m -> m.getName().equals(metricName)).findFirst();
  }

  private static HistogramPointData getPointForStreaming(
      Collection<HistogramPointData> points, boolean streaming) {
    return points.stream()
        .filter(
            p ->
                Boolean.TRUE.equals(p.getAttributes().get(AttributeKey.booleanKey("streaming")))
                    == streaming)
        .findFirst()
        .orElseThrow(
            () -> new AssertionError("Missing HistogramPointData for streaming=" + streaming));
  }

  /** Helper to create expected Attributes for assertions. */
  private static Attributes getExpectedAttributes(String lbPolicy, boolean streaming) {
    return Attributes.builder()
        .put(AttributeKey.stringKey("transport_type"), "grpc")
        .put(AttributeKey.stringKey("lb_policy"), lbPolicy)
        .put(AttributeKey.booleanKey("streaming"), streaming)
        .build();
  }

  @Test
  public void testSingleRun() {
    // Arrange
    tracker.registerChannelInsightsProvider(mockInsightsProvider);
    tracker.registerLoadBalancingStrategy("LEAST_IN_FLIGHT");
    tracker.start(mockScheduler);

    // Outstanding RPCs
    when(mockInsight1.getOutstandingUnaryRpcs()).thenReturn(5);
    when(mockInsight1.getOutstandingStreamingRpcs()).thenReturn(2);
    when(mockInsight2.getOutstandingUnaryRpcs()).thenReturn(10);
    when(mockInsight2.getOutstandingStreamingRpcs()).thenReturn(8);
    // Error Counts
    when(mockInsight1.getAndResetErrorCount()).thenReturn(1L);
    when(mockInsight1.getAndResetSuccessCount()).thenReturn(9L);
    when(mockInsight2.getAndResetErrorCount()).thenReturn(3L);
    when(mockInsight2.getAndResetSuccessCount()).thenReturn(7L);

    runTrackerTask();

    // Assert
    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).hasSize(2);

    // Assert Outstanding RPCs metric
    Optional<MetricData> rpcMetricDataOpt =
        getMetricData(metrics, OUTSTANDING_RPCS_PER_CHANNEL_NAME);
    assertThat(rpcMetricDataOpt.isPresent()).isTrue();
    MetricData rpcMetricData = rpcMetricDataOpt.get();
    Collection<HistogramPointData> rpcPoints = rpcMetricData.getHistogramData().getPoints();
    assertThat(rpcPoints).hasSize(2); // One for streaming=false, one for streaming=true

    HistogramPointData unaryPoint = getPointForStreaming(rpcPoints, false);
    assertThat(unaryPoint.getAttributes())
        .isEqualTo(getExpectedRpcAttributes("LEAST_IN_FLIGHT", false));
    assertThat(unaryPoint.getCount()).isEqualTo(2);
    assertThat(unaryPoint.getSum()).isWithin(1e-9).of(15.0); // 5 + 10

    HistogramPointData streamingPoint = getPointForStreaming(rpcPoints, true);
    assertThat(streamingPoint.getAttributes())
        .isEqualTo(getExpectedRpcAttributes("LEAST_IN_FLIGHT", true));
    assertThat(streamingPoint.getCount()).isEqualTo(2);
    assertThat(streamingPoint.getSum()).isWithin(1e-9).of(10.0); // 2 + 8

    // Assert Error Count metric
    Optional<MetricData> errorMetricDataOpt =
        getMetricData(metrics, PER_CONNECTION_ERROR_COUNT_NAME);
    assertThat(errorMetricDataOpt.isPresent()).isTrue();
    MetricData errorMetricData = errorMetricDataOpt.get();
    Collection<HistogramPointData> errorPoints = errorMetricData.getHistogramData().getPoints();
    assertThat(errorPoints).hasSize(1);

    HistogramPointData errorPoint = errorPoints.iterator().next();
    assertThat(errorPoint.getAttributes()).isEqualTo(getExpectedErrorAttributes());
    assertThat(errorPoint.getCount()).isEqualTo(2); // Two insights
    assertThat(errorPoint.getSum()).isWithin(1e-9).of(4.0); // 1 + 3
  }

  @Test
  public void testMultipleRuns() {
    // Arrange
    tracker.registerChannelInsightsProvider(mockInsightsProvider);
    tracker.registerLoadBalancingStrategy("ROUND_ROBIN");
    tracker.start(mockScheduler);

    // First run
    when(mockInsight1.getOutstandingUnaryRpcs()).thenReturn(1);
    when(mockInsight1.getOutstandingStreamingRpcs()).thenReturn(2);
    when(mockInsight2.getOutstandingUnaryRpcs()).thenReturn(3);
    when(mockInsight2.getOutstandingStreamingRpcs()).thenReturn(4);
    when(mockInsight1.getAndResetErrorCount()).thenReturn(1L);
    when(mockInsight1.getAndResetSuccessCount()).thenReturn(1L);
    when(mockInsight2.getAndResetErrorCount()).thenReturn(0L);
    when(mockInsight2.getAndResetSuccessCount()).thenReturn(2L);
    runTrackerTask();

    // Second run - values change
    when(mockInsight1.getOutstandingUnaryRpcs()).thenReturn(10);
    when(mockInsight1.getOutstandingStreamingRpcs()).thenReturn(20);
    when(mockInsight2.getOutstandingUnaryRpcs()).thenReturn(30);
    when(mockInsight2.getOutstandingStreamingRpcs()).thenReturn(40);
    when(mockInsight1.getAndResetErrorCount()).thenReturn(5L);
    when(mockInsight1.getAndResetSuccessCount()).thenReturn(5L);
    when(mockInsight2.getAndResetErrorCount()).thenReturn(2L);
    when(mockInsight2.getAndResetSuccessCount()).thenReturn(8L);
    runTrackerTask();

    // Assert cumulative metrics
    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).hasSize(2);

    // Assert Outstanding RPCs
    Optional<MetricData> rpcMetricDataOpt =
        getMetricData(metrics, OUTSTANDING_RPCS_PER_CHANNEL_NAME);
    assertThat(rpcMetricDataOpt.isPresent()).isTrue();
    Collection<HistogramPointData> rpcPoints =
        rpcMetricDataOpt.get().getHistogramData().getPoints();
    assertThat(rpcPoints).hasSize(2);

    HistogramPointData unaryPoint = getPointForStreaming(rpcPoints, false);
    assertThat(unaryPoint.getCount()).isEqualTo(4); // 2 insights * 2 runs
    assertThat(unaryPoint.getSum()).isWithin(1e-9).of(44.0); // (1 + 3) + (10 + 30)

    HistogramPointData streamingPoint = getPointForStreaming(rpcPoints, true);
    assertThat(streamingPoint.getCount()).isEqualTo(4); // 2 insights * 2 runs
    assertThat(streamingPoint.getSum()).isWithin(1e-9).of(66.0); // (2 + 4) + (20 + 40)

    // Assert Error Counts
    Optional<MetricData> errorMetricDataOpt =
        getMetricData(metrics, PER_CONNECTION_ERROR_COUNT_NAME);
    assertThat(errorMetricDataOpt.isPresent()).isTrue();
    Collection<HistogramPointData> errorPoints =
        errorMetricDataOpt.get().getHistogramData().getPoints();
    assertThat(errorPoints).hasSize(1);

    HistogramPointData errorPoint = errorPoints.iterator().next();
    assertThat(errorPoint.getAttributes()).isEqualTo(getExpectedErrorAttributes());
    assertThat(errorPoint.getCount()).isEqualTo(4); // 2 insights * 2 runs
    assertThat(errorPoint.getSum()).isWithin(1e-9).of(8.0); // (1 + 0) + (5 + 2)
  }

  @Test
  public void testErrorMetricsOnlyRecordedForAllChannels() {
    // Arrange
    tracker.registerChannelInsightsProvider(mockInsightsProvider);
    tracker.start(mockScheduler);

    // Insight 1: Active (has successes)
    when(mockInsight1.getAndResetErrorCount()).thenReturn(0L);
    when(mockInsight1.getAndResetSuccessCount()).thenReturn(5L);
    // Insight 2: Inactive
    when(mockInsight2.getAndResetErrorCount()).thenReturn(0L);
    when(mockInsight2.getAndResetSuccessCount()).thenReturn(0L);

    runTrackerTask();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    Optional<MetricData> errorMetricDataOpt =
        getMetricData(metrics, PER_CONNECTION_ERROR_COUNT_NAME);
    assertThat(errorMetricDataOpt.isPresent()).isTrue();
    Collection<HistogramPointData> errorPoints =
        errorMetricDataOpt.get().getHistogramData().getPoints();
    assertThat(errorPoints).hasSize(1);

    HistogramPointData errorPoint = errorPoints.iterator().next();
    assertThat(errorPoint.getAttributes()).isEqualTo(getExpectedErrorAttributes());
    assertThat(errorPoint.getCount()).isEqualTo(2); // both channel recorded
    assertThat(errorPoint.getSum()).isWithin(1e-9).of(0.0); // Recorded 0 errors
  }

  @Test
  public void testDefaultLbPolicy() {
    // Arrange: Only register insights provider, not LB strategy
    tracker.registerChannelInsightsProvider(mockInsightsProvider);
    tracker.start(mockScheduler);
    runTrackerTask();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    Optional<MetricData> rpcMetricDataOpt =
        getMetricData(metrics, OUTSTANDING_RPCS_PER_CHANNEL_NAME);
    assertThat(rpcMetricDataOpt.isPresent()).isTrue();
    Collection<HistogramPointData> points = rpcMetricDataOpt.get().getHistogramData().getPoints();

    points.forEach(
        point ->
            assertThat(point.getAttributes().asMap())
                .containsEntry(AttributeKey.stringKey("lb_policy"), "ROUND_ROBIN"));
  }

  @Test
  public void testNoMetricsIfChannelInsightsProviderInactive() {
    tracker.start(mockScheduler);
    runTrackerTask();
    assertThat(metricReader.collectAllMetrics()).isEmpty();
  }

  @Test
  public void testNoMetricsIfChannelInsightsEmpty() {
    tracker.registerChannelInsightsProvider(mockInsightsProvider);
    when(mockInsightsProvider.getChannelInfos()).thenReturn(ImmutableList.of());
    tracker.start(mockScheduler);
    runTrackerTask();
    assertThat(metricReader.collectAllMetrics()).isEmpty();
  }

  @Test
  public void testNoMetricsIfChannelInsightsNull() {
    tracker.registerChannelInsightsProvider(mockInsightsProvider);
    when(mockInsightsProvider.getChannelInfos()).thenReturn(null);
    tracker.start(mockScheduler);
    runTrackerTask();
    assertThat(metricReader.collectAllMetrics()).isEmpty();
  }
}

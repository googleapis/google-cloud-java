/*
 * Copyright 2026 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.awaitility.Awaitility.await;

import com.google.cloud.grpc.GcpManagedChannel.ChannelRef;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpMetricsOptions;
import com.google.cloud.grpc.fallback.GcpFallbackChannel;
import com.google.cloud.grpc.fallback.GcpFallbackChannelOptions;
import com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.ManagedChannel;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class GcpChannelPoolBuiltInMetricsTest {
  private static final String CHANNEL_COUNT = GcpMetricsConstants.METRIC_CHANNEL_POOL_CHANNEL_COUNT;
  private static final AttributeKey<String> LANE = AttributeKey.stringKey("lane");
  private static final Attributes CLOUDPATH = Attributes.of(LANE, "cloudpath");
  private static final Attributes DIRECTPATH = Attributes.of(LANE, "directpath");

  private final ExecutorService executor = MoreExecutors.newDirectExecutorService();
  private final List<ManagedChannel> pools = new ArrayList<>();
  private SdkMeterProvider meterProvider;
  private InMemoryMetricReader reader;
  private Meter meter;

  @Before
  public void setUp() {
    reader = InMemoryMetricReader.create();
    meterProvider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    meter = meterProvider.get("grpc-gcp");
  }

  @After
  public void tearDown() {
    for (ManagedChannel pool : pools) {
      pool.shutdownNow();
    }
    executor.shutdownNow();
  }

  @Test
  public void staticPoolReportsActiveAndDrainingCounts() {
    newStaticPool(3, CLOUDPATH);

    assertThat(collectChannelCounts())
        .containsExactly(
            attributes("cloudpath", "static", "active"), 3L,
            attributes("cloudpath", "static", "draining"), 0L);
  }

  @Test
  public void channelCountIsReportedAsNonMonotonicSumWithCountUnit() {
    newStaticPool(1, CLOUDPATH);

    MetricData metric = findChannelCountMetric(reader.collectAllMetrics());
    assertThat(metric).isNotNull();
    assertThat(metric.getLongSumData().isMonotonic()).isFalse();
    assertThat(metric.getUnit()).isEqualTo("1");
  }

  @Test
  public void dynamicPoolReportsScaleDownAsDrainingUntilChannelsClose() {
    GcpManagedChannel pool = newDynamicPool(CLOUDPATH);
    // Start the fake clock after the channels were created, so their last activity is in the past.
    AtomicLong clock = new AtomicLong(System.nanoTime());
    pool.setNanoClock(clock::get);
    assertThat(collectChannelCounts())
        .containsExactly(
            attributes("cloudpath", "dynamic", "active"), 4L,
            attributes("cloudpath", "dynamic", "draining"), 0L);

    // Three low-load checks in a row remove two channels (maxScaleDownChannels).
    pool.checkScaleDown();
    pool.checkScaleDown();
    pool.checkScaleDown();
    assertThat(collectChannelCounts())
        .containsExactly(
            attributes("cloudpath", "dynamic", "active"), 2L,
            attributes("cloudpath", "dynamic", "draining"), 2L);

    // A drained channel closes once it has been idle for the grace period.
    ChannelRef draining = pool.removedChannelRefs.iterator().next();
    pool.finishDrain(draining);
    clock.addAndGet(Duration.ofMinutes(1).plusNanos(1).toNanos());
    pool.finishDrain(draining);
    assertThat(collectChannelCounts())
        .containsExactly(
            attributes("cloudpath", "dynamic", "active"), 2L,
            attributes("cloudpath", "dynamic", "draining"), 1L);
  }

  @Test
  public void poolsWithSameAttributesAddUp() {
    newStaticPool(2, CLOUDPATH);
    newStaticPool(3, CLOUDPATH);

    assertThat(collectChannelCounts())
        .containsExactly(
            attributes("cloudpath", "static", "active"), 5L,
            attributes("cloudpath", "static", "draining"), 0L);
  }

  @Test
  public void poolsWithDifferentAttributesAreReportedSeparately() {
    newStaticPool(2, DIRECTPATH);
    newStaticPool(3, CLOUDPATH);

    assertThat(collectChannelCounts())
        .containsExactly(
            attributes("directpath", "static", "active"), 2L,
            attributes("directpath", "static", "draining"), 0L,
            attributes("cloudpath", "static", "active"), 3L,
            attributes("cloudpath", "static", "draining"), 0L);
  }

  @Test
  public void shutDownPoolIsNoLongerReported() {
    GcpManagedChannel first = newStaticPool(2, DIRECTPATH);
    GcpManagedChannel second = newStaticPool(3, CLOUDPATH);

    first.shutdownNow();
    assertThat(collectChannelCounts())
        .containsExactly(
            attributes("cloudpath", "static", "active"), 3L,
            attributes("cloudpath", "static", "draining"), 0L);

    second.shutdown();
    assertThat(collectChannelCounts()).isEmpty();
    assertThat(GcpChannelPoolBuiltInMetrics.forMeter(meter).size()).isEqualTo(0);
  }

  @Test
  public void allPoolsShareOneReaderPerMeter() {
    newStaticPool(1, CLOUDPATH);
    newStaticPool(1, CLOUDPATH);
    newStaticPool(1, DIRECTPATH);

    GcpChannelPoolBuiltInMetrics metrics = GcpChannelPoolBuiltInMetrics.forMeter(meter);
    assertThat(GcpChannelPoolBuiltInMetrics.forMeter(meter)).isSameInstanceAs(metrics);
    assertThat(metrics.size()).isEqualTo(3);
    List<MetricData> channelCountMetrics =
        reader.collectAllMetrics().stream()
            .filter(metric -> metric.getName().equals(CHANNEL_COUNT))
            .collect(Collectors.toList());
    assertThat(channelCountMetrics).hasSize(1);
    assertThat(channelCountMetrics.get(0).getLongSumData().getPoints()).hasSize(4);
  }

  @Test
  public void poolWithoutBuiltInMeterReportsNoChannelCount() {
    // The application's own OpenTelemetry meter gets the existing pool metrics only.
    GcpMetricsOptions metricsOptions =
        GcpMetricsOptions.newBuilder().withOpenTelemetryMeter(meter).build();
    newPool(GcpChannelPoolOptions.newBuilder().setMaxSize(2).setMinSize(2).build(), metricsOptions);

    List<String> names =
        reader.collectAllMetrics().stream().map(MetricData::getName).collect(Collectors.toList());
    assertThat(names).isNotEmpty();
    assertThat(names).doesNotContain(CHANNEL_COUNT);
  }

  @Test
  public void metricsOptionsCopyBuiltInSettings() {
    GcpMetricsOptions defaults = GcpMetricsOptions.newBuilder().build();
    assertThat(defaults.getBuiltInMetricsMeter()).isNull();
    assertThat(defaults.getBuiltInMetricsAttributes()).isEqualTo(Attributes.empty());

    GcpMetricsOptions options =
        GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, CLOUDPATH).build();
    GcpMetricsOptions copy = GcpMetricsOptions.newBuilder(options).build();
    assertThat(copy.getBuiltInMetricsMeter()).isSameInstanceAs(meter);
    assertThat(copy.getBuiltInMetricsAttributes()).isEqualTo(CLOUDPATH);
  }

  @Test
  public void poolIndexCountsUpToTenThenReportsOther() {
    GcpChannelPoolBuiltInMetrics.resetPoolIndexForTest();
    List<String> indexes = new ArrayList<>();
    for (int i = 0; i < 12; i++) {
      indexes.add(GcpMetricsOptions.nextBuiltInMetricsPoolIndex());
    }

    assertThat(indexes)
        .containsExactly("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "other", "other")
        .inOrder();
  }

  @Test
  public void poolIndexIsNotReusedAfterPoolShutdown() {
    GcpChannelPoolBuiltInMetrics.resetPoolIndexForTest();
    String first = GcpMetricsOptions.nextBuiltInMetricsPoolIndex();
    GcpManagedChannel pool =
        newStaticPool(1, Attributes.of(AttributeKey.stringKey("pool_index"), first));
    pool.shutdownNow();

    assertThat(GcpMetricsOptions.nextBuiltInMetricsPoolIndex()).isEqualTo("2");
  }

  @Test
  public void poolIndexIsUniqueAcrossThreads() throws Exception {
    GcpChannelPoolBuiltInMetrics.resetPoolIndexForTest();
    ExecutorService threads = Executors.newFixedThreadPool(8);
    try {
      List<Future<String>> futures = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
        futures.add(threads.submit(GcpMetricsOptions::nextBuiltInMetricsPoolIndex));
      }
      List<String> indexes = new ArrayList<>();
      for (Future<String> future : futures) {
        indexes.add(future.get());
      }
      assertThat(indexes).containsExactly("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    } finally {
      threads.shutdownNow();
    }
  }

  @Test
  public void customerAndBuiltInMetricsStaySeparateWhenBothAreConfigured() {
    InMemoryMetricReader customerReader = InMemoryMetricReader.create();
    Meter customerMeter =
        SdkMeterProvider.builder().registerMetricReader(customerReader).build().get("customer");
    newPool(
        GcpChannelPoolOptions.newBuilder().setMaxSize(2).setMinSize(2).build(),
        GcpMetricsOptions.newBuilder()
            .withOpenTelemetryMeter(customerMeter)
            .withNamePrefix("customer/")
            .withBuiltInMetrics(meter, CLOUDPATH)
            .build());

    // The application's own metrics are unchanged and do not include channel_count.
    List<String> customerNames =
        customerReader.collectAllMetrics().stream()
            .map(MetricData::getName)
            .collect(Collectors.toList());
    assertThat(customerNames).contains("customer/" + GcpMetricsConstants.METRIC_NUM_CHANNELS);
    assertThat(customerNames).contains("customer/" + GcpMetricsConstants.METRIC_MAX_ACTIVE_STREAMS);
    assertThat(customerNames).doesNotContain(CHANNEL_COUNT);
    assertThat(customerNames).doesNotContain("customer/" + CHANNEL_COUNT);

    // The built-in pipeline gets channel_count only.
    List<String> builtInNames =
        reader.collectAllMetrics().stream().map(MetricData::getName).collect(Collectors.toList());
    assertThat(builtInNames).containsExactly(CHANNEL_COUNT);
    assertThat(collectChannelCounts())
        .containsExactly(
            attributes("cloudpath", "static", "active"), 2L,
            attributes("cloudpath", "static", "draining"), 0L);
  }

  @Test
  public void fallbackChannelKeepsItsMetricsWhenItsPoolsReportChannelCount() {
    // Built the way the Spanner client builds DirectPath with fallback: one pool per path inside
    // a fallback channel, all recording to the same built-in pipeline. A short evaluation period
    // makes the fallback channel report its current channel quickly.
    GcpFallbackChannel fallbackChannel =
        new GcpFallbackChannel(
            GcpFallbackChannelOptions.newBuilder()
                .setEnableFallback(true)
                .setPeriod(Duration.ofMillis(50))
                .setGcpFallbackOpenTelemetry(
                    GcpFallbackOpenTelemetry.newBuilder()
                        .withSdk(OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build())
                        .build())
                .build(),
            poolBuilder(2, DIRECTPATH),
            poolBuilder(3, CLOUDPATH));
    pools.add(fallbackChannel);

    // The fallback channel's own metric is still reported.
    await()
        .atMost(Duration.ofSeconds(5))
        .until(
            () ->
                reader.collectAllMetrics().stream()
                    .anyMatch(metric -> metric.getName().equals("eef.current_channel")));
    // Each path's pool reports its channels under its own lane.
    assertThat(collectChannelCounts())
        .containsExactly(
            attributes("directpath", "static", "active"), 2L,
            attributes("directpath", "static", "draining"), 0L,
            attributes("cloudpath", "static", "active"), 3L,
            attributes("cloudpath", "static", "draining"), 0L);
  }

  @Test
  public void poolsCreatedConcurrentlyShareOneReader() throws Exception {
    ExecutorService threads = Executors.newFixedThreadPool(8);
    try {
      List<Future<GcpManagedChannel>> futures = new ArrayList<>();
      for (int i = 0; i < 8; i++) {
        futures.add(threads.submit(() -> newStaticPool(1, CLOUDPATH)));
      }
      for (Future<GcpManagedChannel> future : futures) {
        future.get();
      }
    } finally {
      threads.shutdownNow();
    }

    assertThat(GcpChannelPoolBuiltInMetrics.forMeter(meter).size()).isEqualTo(8);
    List<MetricData> channelCountMetrics =
        reader.collectAllMetrics().stream()
            .filter(metric -> metric.getName().equals(CHANNEL_COUNT))
            .collect(Collectors.toList());
    assertThat(channelCountMetrics).hasSize(1);
    assertThat(channelCounts(channelCountMetrics.get(0)))
        .containsExactly(
            attributes("cloudpath", "static", "active"), 8L,
            attributes("cloudpath", "static", "draining"), 0L);
  }

  @Test
  public void poolsOnDifferentMetersAreReportedSeparately() {
    InMemoryMetricReader otherReader = InMemoryMetricReader.create();
    Meter otherMeter =
        SdkMeterProvider.builder().registerMetricReader(otherReader).build().get("grpc-gcp");
    newStaticPool(2, CLOUDPATH);
    newPool(
        GcpChannelPoolOptions.newBuilder().setMaxSize(3).setMinSize(3).build(),
        GcpMetricsOptions.newBuilder().withBuiltInMetrics(otherMeter, CLOUDPATH).build());

    assertThat(GcpChannelPoolBuiltInMetrics.forMeter(otherMeter))
        .isNotSameInstanceAs(GcpChannelPoolBuiltInMetrics.forMeter(meter));
    assertThat(collectChannelCounts())
        .containsEntry(attributes("cloudpath", "static", "active"), 2L);
    assertThat(channelCounts(findChannelCountMetric(otherReader.collectAllMetrics())))
        .containsEntry(attributes("cloudpath", "static", "active"), 3L);
  }

  @Test
  public void callerAttributesCannotOverridePoolModeOrState() {
    newStaticPool(
        2,
        CLOUDPATH.toBuilder()
            .put(GcpMetricsConstants.POOL_MODE_LABEL, "wrong")
            .put(GcpMetricsConstants.STATE_LABEL, "wrong")
            .build());

    assertThat(collectChannelCounts())
        .containsExactly(
            attributes("cloudpath", "static", "active"), 2L,
            attributes("cloudpath", "static", "draining"), 0L);
  }

  @Test
  public void staticPoolGrowingOnDemandIsCounted() {
    GcpManagedChannel pool =
        newPool(
            GcpChannelPoolOptions.newBuilder().setMaxSize(3).setMinSize(1).build(),
            GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, CLOUDPATH).build());
    assertThat(collectChannelCounts())
        .containsEntry(attributes("cloudpath", "static", "active"), 1L);

    pool.createNewChannel();
    pool.createNewChannel();

    assertThat(collectChannelCounts())
        .containsEntry(attributes("cloudpath", "static", "active"), 3L);
  }

  @Test
  public void scaledUpChannelIsCountedOnlyAfterPriming() {
    SettableFuture<Void> primeFuture = SettableFuture.create();
    AtomicReference<ManagedChannel> primingChannel = new AtomicReference<>();
    GcpChannelPrimer primer =
        channel -> {
          primingChannel.set(channel);
          return primeFuture;
        };
    GcpManagedChannel pool =
        newPool(
            GcpChannelPoolOptions.newBuilder()
                .setInitSize(2)
                .setMinSize(1)
                .setMaxSize(3)
                .setDynamicScaling(1, 3, Duration.ofSeconds(30))
                .setScaleUpCooldown(Duration.ofNanos(1))
                .setMaxScaleUpPercent(30)
                .setChannelPrimer(primer)
                .setChannelPrimeTimeout(Duration.ofSeconds(5))
                .build(),
            GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, CLOUDPATH).build());
    assertThat(collectChannelCounts())
        .containsEntry(attributes("cloudpath", "dynamic", "active"), 2L);

    // A busy channel triggers a scale-up. The new channel is being primed and not counted yet.
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(6);
    hot.activeStreamsCountIncr();
    await().atMost(Duration.ofSeconds(5)).until(() -> primingChannel.get() != null);
    assertThat(collectChannelCounts())
        .containsEntry(attributes("cloudpath", "dynamic", "active"), 2L);

    // Once priming succeeds, the channel joins the pool and is counted.
    primeFuture.set(null);
    await().atMost(Duration.ofSeconds(5)).until(() -> pool.getNumberOfChannels() == 3);
    assertThat(collectChannelCounts())
        .containsEntry(attributes("cloudpath", "dynamic", "active"), 3L);
  }

  @Test
  public void manyPoolsCreatedAndClosedLeaveNothingBehind() {
    for (int i = 0; i < 1000; i++) {
      newStaticPool(1, CLOUDPATH).shutdownNow();
    }

    assertThat(GcpChannelPoolBuiltInMetrics.forMeter(meter).size()).isEqualTo(0);
    assertThat(collectChannelCounts()).isEmpty();
  }

  @Test
  public void poolsCreatedAndClosedWhileMetricsAreCollected() throws Exception {
    GcpManagedChannel longLived = newStaticPool(2, DIRECTPATH);
    ExecutorService churn = Executors.newSingleThreadExecutor();
    AtomicBoolean stop = new AtomicBoolean();
    try {
      Future<?> churnTask =
          churn.submit(
              () -> {
                while (!stop.get()) {
                  newStaticPool(1, CLOUDPATH).shutdownNow();
                }
              });
      // Collecting while pools join and leave must neither fail nor misreport the stable pool.
      for (int i = 0; i < 200; i++) {
        assertThat(collectChannelCounts())
            .containsEntry(attributes("directpath", "static", "active"), 2L);
      }
      stop.set(true);
      churnTask.get();
    } finally {
      stop.set(true);
      churn.shutdownNow();
    }

    assertThat(GcpChannelPoolBuiltInMetrics.forMeter(meter).size()).isEqualTo(1);
    longLived.shutdownNow();
    assertThat(collectChannelCounts()).isEmpty();
  }

  private GcpManagedChannelBuilder poolBuilder(int size, Attributes poolAttributes) {
    return GcpManagedChannelBuilder.forDelegateBuilder(
            new GcpManagedChannelTest.FakeManagedChannelBuilder(
                () -> new GcpManagedChannelTest.FakeManagedChannel(executor)))
        .withOptions(
            GcpManagedChannelOptions.newBuilder()
                .withChannelPoolOptions(
                    GcpChannelPoolOptions.newBuilder().setMaxSize(size).setMinSize(size).build())
                .withMetricsOptions(
                    GcpMetricsOptions.newBuilder()
                        .withBuiltInMetrics(meter, poolAttributes)
                        .build())
                .build());
  }

  private GcpManagedChannel newStaticPool(int size, Attributes poolAttributes) {
    return newPool(
        GcpChannelPoolOptions.newBuilder().setMaxSize(size).setMinSize(size).build(),
        GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, poolAttributes).build());
  }

  private GcpManagedChannel newDynamicPool(Attributes poolAttributes) {
    return newPool(
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(4)
            .setMinSize(2)
            .setMaxSize(4)
            .setDynamicScaling(10, 20, Duration.ofMinutes(1))
            .setScaleDownConsecutiveLowLoadChecks(3)
            .setMaxScaleDownChannels(2)
            .setDrainIdleGrace(Duration.ofMinutes(1))
            .build(),
        GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, poolAttributes).build());
  }

  private GcpManagedChannel newPool(
      GcpChannelPoolOptions poolOptions, GcpMetricsOptions metricsOptions) {
    GcpManagedChannel pool =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(
                    new GcpManagedChannelTest.FakeManagedChannelBuilder(
                        () -> new GcpManagedChannelTest.FakeManagedChannel(executor)))
                .withOptions(
                    GcpManagedChannelOptions.newBuilder()
                        .withChannelPoolOptions(poolOptions)
                        .withMetricsOptions(metricsOptions)
                        .build())
                .build();
    pools.add(pool);
    return pool;
  }

  private Map<Attributes, Long> collectChannelCounts() {
    return channelCounts(findChannelCountMetric(reader.collectAllMetrics()));
  }

  private static Map<Attributes, Long> channelCounts(MetricData metric) {
    Map<Attributes, Long> counts = new HashMap<>();
    if (metric != null) {
      for (LongPointData point : metric.getLongSumData().getPoints()) {
        counts.put(point.getAttributes(), point.getValue());
      }
    }
    return ImmutableMap.copyOf(counts);
  }

  private static MetricData findChannelCountMetric(Iterable<MetricData> metrics) {
    for (MetricData metric : metrics) {
      if (metric.getName().equals(CHANNEL_COUNT)) {
        return metric;
      }
    }
    return null;
  }

  private static Attributes attributes(String lane, String poolMode, String state) {
    return Attributes.builder()
        .put(LANE, lane)
        .put(GcpMetricsConstants.POOL_MODE_LABEL, poolMode)
        .put(GcpMetricsConstants.STATE_LABEL, state)
        .build();
  }
}

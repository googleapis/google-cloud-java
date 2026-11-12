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
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.grpc.GcpManagedChannel.ChannelAffinityRef;
import com.google.cloud.grpc.GcpManagedChannel.ChannelRef;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpMetricsOptions;
import com.google.cloud.grpc.fallback.GcpFallbackChannel;
import com.google.cloud.grpc.fallback.GcpFallbackChannelOptions;
import com.google.cloud.grpc.proto.AffinityConfig;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class GcpChannelPoolChannelLoadTest {
  private static final String CHANNEL_LOAD = GcpMetricsConstants.METRIC_CHANNEL_POOL_CHANNEL_LOAD;
  private static final AttributeKey<String> LANE = AttributeKey.stringKey("lane");
  private static final AttributeKey<String> DATABASE = AttributeKey.stringKey("database");
  private static final AttributeKey<String> POOL_MODE =
      AttributeKey.stringKey(GcpMetricsConstants.POOL_MODE_LABEL);
  private static final Attributes CLOUDPATH = Attributes.of(LANE, "cloudpath");
  private static final Attributes DIRECTPATH = Attributes.of(LANE, "directpath");

  private static final MethodDescriptor<String, String> METHOD =
      MethodDescriptor.<String, String>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("test/method")
          .setRequestMarshaller(new FakeMarshaller<>())
          .setResponseMarshaller(new FakeMarshaller<>())
          .build();

  private final ExecutorService executor = MoreExecutors.newDirectExecutorService();
  private final List<ManagedChannel> pools = new CopyOnWriteArrayList<>();
  private final List<FakeCall<?, ?>> startedCalls = new CopyOnWriteArrayList<>();
  private final List<SdkMeterProvider> meterProviders = new ArrayList<>();
  private InMemoryMetricReader reader;
  private Meter meter;

  @Before
  public void setUp() {
    reader = InMemoryMetricReader.create();
    meter = newMeterProvider(reader).get("grpc-gcp");
  }

  @After
  public void tearDown() {
    for (ManagedChannel pool : pools) {
      pool.shutdownNow();
    }
    for (SdkMeterProvider provider : meterProviders) {
      provider.close();
    }
    executor.shutdownNow();
  }

  private SdkMeterProvider newMeterProvider(InMemoryMetricReader metricReader) {
    SdkMeterProvider provider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    meterProviders.add(provider);
    return provider;
  }

  @Test
  public void nothingIsRecordedWithoutBuiltInMetrics() {
    GcpManagedChannel pool = newPool(staticPoolOptions(1), GcpMetricsOptions.newBuilder().build());

    pool.newCall(METHOD, CallOptions.DEFAULT);

    assertThat(findChannelLoadMetric()).isNull();
  }

  @Test
  public void recordsChannelLoadIncludingTheNewRequest() {
    GcpManagedChannel pool = newStaticPool(1);

    for (int i = 0; i < 3; i++) {
      pool.newCall(METHOD, CallOptions.DEFAULT);
    }

    HistogramPointData point = onlyPoint();
    assertThat(point.getCount()).isEqualTo(3);
    assertThat(point.getSum()).isEqualTo(1 + 2 + 3);
    assertThat(point.getMin()).isEqualTo(1);
    assertThat(point.getMax()).isEqualTo(3);
  }

  @Test
  public void usesChannelLoadBucketsAndCountUnit() {
    newStaticPool(1).newCall(METHOD, CallOptions.DEFAULT);

    MetricData metric = findChannelLoadMetric();
    assertThat(metric.getUnit()).isEqualTo("1");
    assertThat(onlyPoint().getBoundaries())
        .containsExactly(
            1.0, 2.0, 4.0, 8.0, 12.0, 15.0, 20.0, 25.0, 30.0, 40.0, 50.0, 75.0, 100.0, 150.0, 200.0)
        .inOrder();
  }

  @Test
  public void hasPoolAttributesAndPoolModeButNoPoolIndexOrState() {
    GcpManagedChannel pool =
        newPool(
            staticPoolOptions(1),
            GcpMetricsOptions.newBuilder()
                .withBuiltInMetrics(meter, CLOUDPATH)
                .withBuiltInMetricsPoolIndex("1")
                .build());

    pool.newCall(METHOD, CallOptions.DEFAULT);

    assertThat(onlyPoint().getAttributes())
        .isEqualTo(Attributes.of(LANE, "cloudpath", POOL_MODE, "static"));
  }

  @Test
  public void poolsWithTheSameMeterAndAttributesShareOneSeries() {
    GcpManagedChannel first = newStaticPool(1);
    GcpManagedChannel second = newStaticPool(1);

    first.newCall(METHOD, CallOptions.DEFAULT);
    second.newCall(METHOD, CallOptions.DEFAULT);
    second.newCall(METHOD, CallOptions.DEFAULT);

    HistogramPointData point = onlyPoint();
    assertThat(point.getCount()).isEqualTo(3);
    assertThat(point.getSum()).isEqualTo(1 + 1 + 2);
  }

  @Test
  public void dynamicPoolReportsDynamicPoolMode() {
    GcpManagedChannel pool =
        newPool(
            GcpChannelPoolOptions.newBuilder()
                .setInitSize(2)
                .setMinSize(1)
                .setMaxSize(4)
                .setDynamicScaling(10, 20, Duration.ofMinutes(1))
                .build(),
            GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, CLOUDPATH).build());

    pool.newCall(METHOD, CallOptions.DEFAULT);

    assertThat(onlyPoint().getAttributes())
        .isEqualTo(Attributes.of(LANE, "cloudpath", POOL_MODE, "dynamic"));
  }

  @Test
  public void addsPerCallAttributes() {
    GcpManagedChannel pool = newStaticPool(2);
    Attributes db1 = Attributes.of(DATABASE, "db1");
    Attributes db2 = Attributes.of(DATABASE, "db2");

    pool.newCall(METHOD, withCallAttributes(db1));
    pool.newCall(METHOD, withCallAttributes(db1));
    pool.newCall(METHOD, withCallAttributes(db2));

    assertThat(countsBy(DATABASE)).containsExactly("db1", 2L, "db2", 1L);
  }

  @Test
  public void perCallAttributesCannotOverridePoolAttributes() {
    GcpManagedChannel pool = newStaticPool(1);

    pool.newCall(
        METHOD,
        withCallAttributes(
            Attributes.of(LANE, "directpath", POOL_MODE, "dynamic", DATABASE, "db1")));

    assertThat(onlyPoint().getAttributes())
        .isEqualTo(Attributes.of(LANE, "cloudpath", POOL_MODE, "static", DATABASE, "db1"));
  }

  @Test
  public void stickyCallsAreRecorded() {
    GcpManagedChannel pool = newStaticPool(3);
    ChannelAffinityRef ref = new ChannelAffinityRef();
    CallOptions sticky =
        CallOptions.DEFAULT.withOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY, ref);

    pool.newCall(METHOD, sticky);
    pool.newCall(METHOD, sticky);

    HistogramPointData point = onlyPoint();
    assertThat(point.getCount()).isEqualTo(2);
    assertThat(point.getMax()).isEqualTo(2);
  }

  @Test
  public void callThatCannotBeCreatedIsNotRecorded() {
    GcpManagedChannel pool =
        (GcpManagedChannel)
            poolBuilder(
                    () -> new ThrowingChannel(executor),
                    staticPoolOptions(1),
                    GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, CLOUDPATH).build())
                .build();
    pools.add(pool);

    assertThrows(IllegalStateException.class, () -> pool.newCall(METHOD, CallOptions.DEFAULT));
    GcpClientCall<String, String> call =
        new GcpClientCall<>(
            pool,
            METHOD,
            CallOptions.DEFAULT,
            AffinityConfig.newBuilder().setCommand(AffinityConfig.Command.BIND).build());
    assertThrows(IllegalStateException.class, () -> call.sendMessage("request"));

    assertThat(findChannelLoadMetric()).isNull();
  }

  @Test
  public void failedRecordDoesNotFailTheCallOrLeakTheCount() {
    LongHistogram histogram = mock(LongHistogram.class);
    doThrow(new IllegalStateException("cannot record"))
        .when(histogram)
        .record(anyLong(), any(Attributes.class));
    Meter throwingMeter = mock(Meter.class, RETURNS_DEEP_STUBS);
    when(throwingMeter
            .histogramBuilder(anyString())
            .setDescription(anyString())
            .setUnit(anyString())
            .ofLongs()
            .setExplicitBucketBoundariesAdvice(anyList())
            .build())
        .thenReturn(histogram);
    GcpManagedChannel pool =
        newPool(
            staticPoolOptions(1),
            GcpMetricsOptions.newBuilder().withBuiltInMetrics(throwingMeter, CLOUDPATH).build());

    start(pool.newCall(METHOD, CallOptions.DEFAULT));
    lastStartedCall().finish(Status.OK);

    verify(histogram).record(anyLong(), any(Attributes.class));
    assertThat(pool.channelRefs.get(0).getActiveStreamsCount()).isEqualTo(0);
  }

  @Test
  public void callsWithAffinityConfigAreRecordedWhenTheChannelIsPicked() {
    GcpManagedChannel pool = newStaticPool(1);
    GcpClientCall<String, String> call =
        new GcpClientCall<>(
            pool,
            METHOD,
            withCallAttributes(Attributes.of(DATABASE, "db1")),
            AffinityConfig.newBuilder().setCommand(AffinityConfig.Command.BIND).build());
    call.start(new ClientCall.Listener<String>() {}, new Metadata());
    assertThat(findChannelLoadMetric()).isNull();

    call.sendMessage("request");

    HistogramPointData point = onlyPoint();
    assertThat(point.getCount()).isEqualTo(1);
    assertThat(point.getAttributes().get(DATABASE)).isEqualTo("db1");
  }

  @Test
  public void mergedAttributesCacheIsBounded() {
    GcpManagedChannel pool = newStaticPool(1);
    int databases = GcpManagedChannel.MAX_CACHED_CHANNEL_LOAD_ATTRIBUTES + 50;

    for (int i = 0; i < databases; i++) {
      pool.newCall(METHOD, withCallAttributes(Attributes.of(DATABASE, "db" + i)));
    }

    assertThat(pool.builtInChannelLoadAttributesCacheSize())
        .isEqualTo(GcpManagedChannel.MAX_CACHED_CHANNEL_LOAD_ATTRIBUTES);
    Map<String, Long> counts = countsBy(DATABASE);
    assertThat(counts).hasSize(databases);
    assertThat(counts).containsEntry("db" + (databases - 1), 1L);
  }

  @Test
  public void errorPenaltyIsNotAddedToTheRecordedLoad() {
    GcpManagedChannel pool =
        newPool(
            GcpChannelPoolOptions.newBuilder()
                .setInitSize(2)
                .setMinSize(1)
                .setMaxSize(4)
                .setDynamicScaling(10, 20, Duration.ofMinutes(1))
                .setErrorPenaltyStep(5)
                .setErrorPenaltyDuration(Duration.ofMinutes(10))
                .build(),
            GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, CLOUDPATH).build());
    CallOptions sticky =
        CallOptions.DEFAULT.withOption(
            GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY, new ChannelAffinityRef());
    start(pool.newCall(METHOD, sticky));
    lastStartedCall().finish(Status.UNAVAILABLE);
    assertThat(pool.channelRefs.stream().anyMatch(ref -> ref.currentErrorPenalty() > 0)).isTrue();

    pool.newCall(METHOD, sticky);

    HistogramPointData point = onlyPoint();
    assertThat(point.getCount()).isEqualTo(2);
    assertThat(point.getMax()).isEqualTo(1);
  }

  @Test
  public void requestOnADrainingChannelIsRecorded() {
    GcpManagedChannel pool =
        newPool(
            GcpChannelPoolOptions.newBuilder()
                .setInitSize(4)
                .setMinSize(2)
                .setMaxSize(4)
                .setDynamicScaling(10, 20, Duration.ofMinutes(1))
                .setScaleDownConsecutiveLowLoadChecks(3)
                .setMaxScaleDownChannels(2)
                .setDrainIdleGrace(Duration.ofMinutes(1))
                .build(),
            GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, CLOUDPATH).build());
    ChannelAffinityRef ref = new ChannelAffinityRef();
    CallOptions sticky =
        CallOptions.DEFAULT.withOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY, ref);
    pool.newCall(METHOD, sticky);
    ChannelRef pinned =
        pool.channelRefs.stream().filter(c -> c.getActiveStreamsCount() == 1).findFirst().get();
    for (ChannelRef other : pool.channelRefs) {
      if (other != pinned) {
        other.setActiveStreamsForTest(2);
      }
    }
    pool.checkScaleDown();
    pool.checkScaleDown();
    pool.checkScaleDown();
    assertThat(pool.removedChannelRefs).contains(pinned);

    pool.newCall(METHOD, sticky);

    assertThat(pinned.getActiveStreamsCount()).isEqualTo(2);
    HistogramPointData point = onlyPoint();
    assertThat(point.getCount()).isEqualTo(2);
    assertThat(point.getMax()).isEqualTo(2);
  }

  @Test
  public void loadGoesDownWhenRequestsFinish() {
    GcpManagedChannel pool = newStaticPool(1);

    start(pool.newCall(METHOD, CallOptions.DEFAULT));
    start(pool.newCall(METHOD, CallOptions.DEFAULT));
    for (FakeCall<?, ?> call : startedCalls) {
      call.finish(Status.OK);
    }
    pool.newCall(METHOD, CallOptions.DEFAULT);

    HistogramPointData point = onlyPoint();
    assertThat(point.getCount()).isEqualTo(3);
    assertThat(point.getSum()).isEqualTo(1 + 2 + 1);
    assertThat(point.getMax()).isEqualTo(2);
  }

  @Test
  public void concurrentRequestsAreAllRecorded() throws Exception {
    GcpManagedChannel pool = newStaticPool(4);
    int threads = 8;
    int requestsPerThread = 1_000;
    ExecutorService workers = Executors.newFixedThreadPool(threads);
    try {
      List<Future<?>> futures = new ArrayList<>();
      for (int t = 0; t < threads; t++) {
        futures.add(
            workers.submit(
                () -> {
                  for (int i = 0; i < requestsPerThread; i++) {
                    pool.newCall(METHOD, CallOptions.DEFAULT);
                  }
                }));
      }
      for (Future<?> future : futures) {
        future.get(5, TimeUnit.SECONDS);
      }
    } finally {
      workers.shutdownNow();
    }

    assertThat(onlyPoint().getCount()).isEqualTo(threads * requestsPerThread);
  }

  @Test
  public void concurrentNewDatabasesKeepTheCacheBounded() throws Exception {
    GcpManagedChannel pool = newStaticPool(4);
    int threads = 8;
    int databases = 300;
    ExecutorService workers = Executors.newFixedThreadPool(threads);
    try {
      List<Future<?>> futures = new ArrayList<>();
      for (int t = 0; t < threads; t++) {
        futures.add(
            workers.submit(
                () -> {
                  for (int i = 0; i < databases; i++) {
                    pool.newCall(METHOD, withCallAttributes(Attributes.of(DATABASE, "db" + i)));
                  }
                }));
      }
      for (Future<?> future : futures) {
        future.get(5, TimeUnit.SECONDS);
      }
    } finally {
      workers.shutdownNow();
    }

    assertThat(pool.builtInChannelLoadAttributesCacheSize())
        .isAtLeast(GcpManagedChannel.MAX_CACHED_CHANNEL_LOAD_ATTRIBUTES);
    assertThat(pool.builtInChannelLoadAttributesCacheSize())
        .isAtMost(GcpManagedChannel.MAX_CACHED_CHANNEL_LOAD_ATTRIBUTES + threads);
    Map<String, Long> counts = countsBy(DATABASE);
    assertThat(counts).hasSize(databases);
    assertThat(counts.values().stream().mapToLong(Long::longValue).sum())
        .isEqualTo((long) threads * databases);
  }

  @Test
  public void fallbackMovesTheLoadToTheCloudPathLane() {
    GcpFallbackChannel fallbackChannel =
        new GcpFallbackChannel(
            GcpFallbackChannelOptions.newBuilder()
                .setEnableFallback(true)
                .setPeriod(Duration.ofMillis(50))
                .setMinFailedCalls(1)
                .setErrorRateThreshold(0.5f)
                .build(),
            poolBuilder(
                staticPoolOptions(1),
                GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, DIRECTPATH).build()),
            poolBuilder(
                staticPoolOptions(1),
                GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, CLOUDPATH).build()));
    pools.add(fallbackChannel);

    start(fallbackChannel.newCall(METHOD, CallOptions.DEFAULT));
    assertThat(countsBy(LANE)).containsExactly("directpath", 1L);
    lastStartedCall().finish(Status.UNAVAILABLE);
    await().atMost(Duration.ofSeconds(5)).until(fallbackChannel::isInFallbackMode);

    fallbackChannel.newCall(METHOD, CallOptions.DEFAULT);

    assertThat(countsBy(LANE)).containsExactly("directpath", 1L, "cloudpath", 1L);
  }

  @Test
  public void customerMeterDoesNotGetChannelLoad() {
    InMemoryMetricReader customerReader = InMemoryMetricReader.create();
    Meter customerMeter = newMeterProvider(customerReader).get("customer");
    GcpManagedChannel pool =
        newPool(
            staticPoolOptions(1),
            GcpMetricsOptions.newBuilder()
                .withOpenTelemetryMeter(customerMeter)
                .withBuiltInMetrics(meter, CLOUDPATH)
                .build());

    pool.newCall(METHOD, CallOptions.DEFAULT);

    assertThat(onlyPoint().getCount()).isEqualTo(1);
    assertThat(
            customerReader.collectAllMetrics().stream()
                .map(MetricData::getName)
                .filter(name -> name.contains("channel_load"))
                .collect(Collectors.toList()))
        .isEmpty();
  }

  @Test
  public void poolsWithDifferentLanesReportSeparateSeries() {
    GcpManagedChannel cloudPath = newStaticPool(1);
    GcpManagedChannel directPath =
        newPool(
            staticPoolOptions(1),
            GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, DIRECTPATH).build());

    cloudPath.newCall(METHOD, CallOptions.DEFAULT);
    directPath.newCall(METHOD, CallOptions.DEFAULT);
    directPath.newCall(METHOD, CallOptions.DEFAULT);

    assertThat(countsBy(LANE)).containsExactly("cloudpath", 1L, "directpath", 2L);
  }

  @Test
  public void equalCallAttributesShareOneCacheEntry() {
    GcpManagedChannel pool = newStaticPool(1);

    pool.newCall(METHOD, withCallAttributes(Attributes.of(DATABASE, "db1")));
    pool.newCall(METHOD, withCallAttributes(Attributes.of(DATABASE, "db1")));

    assertThat(pool.builtInChannelLoadAttributesCacheSize()).isEqualTo(1);
    assertThat(countsBy(DATABASE)).containsExactly("db1", 2L);
  }

  @Test
  public void requestOnANewStaticPoolChannelIsRecorded() {
    GcpManagedChannel pool =
        newPool(
            GcpChannelPoolOptions.newBuilder()
                .setMinSize(1)
                .setMaxSize(3)
                .setConcurrentStreamsLowWatermark(1)
                .build(),
            GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, CLOUDPATH).build());

    pool.newCall(METHOD, CallOptions.DEFAULT);
    pool.newCall(METHOD, CallOptions.DEFAULT);

    assertThat(pool.channelRefs).hasSize(2);
    HistogramPointData point = onlyPoint();
    assertThat(point.getCount()).isEqualTo(2);
    assertThat(point.getMax()).isEqualTo(1);
  }

  @Test
  public void emptyCallAttributesUseThePoolAttributes() {
    GcpManagedChannel pool = newStaticPool(1);

    pool.newCall(METHOD, withCallAttributes(Attributes.empty()));

    assertThat(onlyPoint().getAttributes())
        .isEqualTo(Attributes.of(LANE, "cloudpath", POOL_MODE, "static"));
    assertThat(pool.builtInChannelLoadAttributesCacheSize()).isEqualTo(0);
  }

  @Test
  public void differentMetersKeepSeparateTotals() {
    InMemoryMetricReader otherReader = InMemoryMetricReader.create();
    Meter otherMeter = newMeterProvider(otherReader).get("grpc-gcp");
    GcpManagedChannel first = newStaticPool(1);
    GcpManagedChannel second =
        newPool(
            staticPoolOptions(1),
            GcpMetricsOptions.newBuilder().withBuiltInMetrics(otherMeter, CLOUDPATH).build());

    first.newCall(METHOD, CallOptions.DEFAULT);
    second.newCall(METHOD, CallOptions.DEFAULT);
    second.newCall(METHOD, CallOptions.DEFAULT);

    assertThat(onlyPoint().getCount()).isEqualTo(1);
    MetricData other = findChannelLoadMetric(otherReader);
    assertThat(other).isNotNull();
    assertThat(other.getHistogramData().getPoints()).hasSize(1);
    assertThat(other.getHistogramData().getPoints().iterator().next().getCount()).isEqualTo(2);
  }

  private static CallOptions withCallAttributes(Attributes attributes) {
    return CallOptions.DEFAULT.withOption(
        GcpManagedChannel.BUILT_IN_METRICS_ATTRIBUTES_KEY, attributes);
  }

  private static GcpChannelPoolOptions staticPoolOptions(int size) {
    return GcpChannelPoolOptions.newBuilder().setMaxSize(size).setMinSize(size).build();
  }

  private GcpManagedChannel newStaticPool(int size) {
    return newPool(
        staticPoolOptions(size),
        GcpMetricsOptions.newBuilder().withBuiltInMetrics(meter, CLOUDPATH).build());
  }

  private GcpManagedChannel newPool(
      GcpChannelPoolOptions poolOptions, GcpMetricsOptions metricsOptions) {
    GcpManagedChannel pool = (GcpManagedChannel) poolBuilder(poolOptions, metricsOptions).build();
    pools.add(pool);
    return pool;
  }

  private GcpManagedChannelBuilder poolBuilder(
      GcpChannelPoolOptions poolOptions, GcpMetricsOptions metricsOptions) {
    return poolBuilder(
        () -> new NoopCallChannel(executor, startedCalls), poolOptions, metricsOptions);
  }

  private GcpManagedChannelBuilder poolBuilder(
      Supplier<? extends ManagedChannel> channelFactory,
      GcpChannelPoolOptions poolOptions,
      GcpMetricsOptions metricsOptions) {
    return GcpManagedChannelBuilder.forDelegateBuilder(
            new GcpManagedChannelTest.FakeManagedChannelBuilder(channelFactory))
        .withOptions(
            GcpManagedChannelOptions.newBuilder()
                .withChannelPoolOptions(poolOptions)
                .withMetricsOptions(metricsOptions)
                .build());
  }

  private static void start(ClientCall<String, String> call) {
    call.start(new ClientCall.Listener<String>() {}, new Metadata());
  }

  private FakeCall<?, ?> lastStartedCall() {
    return startedCalls.get(startedCalls.size() - 1);
  }

  private MetricData findChannelLoadMetric() {
    return findChannelLoadMetric(reader);
  }

  private static MetricData findChannelLoadMetric(InMemoryMetricReader metricReader) {
    for (MetricData metric : metricReader.collectAllMetrics()) {
      if (metric.getName().equals(CHANNEL_LOAD)) {
        return metric;
      }
    }
    return null;
  }

  private HistogramPointData onlyPoint() {
    MetricData metric = findChannelLoadMetric();
    assertThat(metric).isNotNull();
    List<HistogramPointData> points = new ArrayList<>(metric.getHistogramData().getPoints());
    assertThat(points).hasSize(1);
    return points.get(0);
  }

  private Map<String, Long> countsBy(AttributeKey<String> key) {
    MetricData metric = findChannelLoadMetric();
    assertThat(metric).isNotNull();
    Map<String, Long> counts = new HashMap<>();
    for (HistogramPointData point : metric.getHistogramData().getPoints()) {
      counts.put(point.getAttributes().get(key), point.getCount());
    }
    return counts;
  }

  private static final class NoopCallChannel extends GcpManagedChannelTest.FakeManagedChannel {
    private final List<FakeCall<?, ?>> startedCalls;

    NoopCallChannel(ExecutorService executor, List<FakeCall<?, ?>> startedCalls) {
      super(executor);
      this.startedCalls = startedCalls;
    }

    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
      return new FakeCall<>(startedCalls);
    }
  }

  private static final class ThrowingChannel extends GcpManagedChannelTest.FakeManagedChannel {
    ThrowingChannel(ExecutorService executor) {
      super(executor);
    }

    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
      throw new IllegalStateException("cannot create call");
    }
  }

  private static final class FakeCall<RequestT, ResponseT> extends ClientCall<RequestT, ResponseT> {
    private final List<FakeCall<?, ?>> startedCalls;
    private Listener<ResponseT> listener;

    FakeCall(List<FakeCall<?, ?>> startedCalls) {
      this.startedCalls = startedCalls;
    }

    @Override
    public void start(Listener<ResponseT> responseListener, Metadata headers) {
      listener = responseListener;
      startedCalls.add(this);
    }

    void finish(Status status) {
      listener.onClose(status, new Metadata());
    }

    @Override
    public void request(int numMessages) {}

    @Override
    public void cancel(String message, Throwable cause) {}

    @Override
    public void halfClose() {}

    @Override
    public void sendMessage(RequestT message) {}
  }

  private static class FakeMarshaller<T> implements MethodDescriptor.Marshaller<T> {
    @Override
    public InputStream stream(T value) {
      return null;
    }

    @Override
    public T parse(InputStream stream) {
      return null;
    }
  }
}

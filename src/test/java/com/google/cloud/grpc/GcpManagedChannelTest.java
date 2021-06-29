/*
 * Copyright 2019 Google LLC
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
import static org.junit.Assert.assertEquals;

import com.google.cloud.grpc.GcpManagedChannel.ChannelRef;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpMetricsOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpResiliencyOptions;
import com.google.cloud.grpc.MetricRegistryTestUtils.FakeMetricRegistry;
import com.google.cloud.grpc.MetricRegistryTestUtils.MetricsRecord;
import com.google.cloud.grpc.MetricRegistryTestUtils.PointWithFunction;
import com.google.cloud.grpc.proto.AffinityConfig;
import com.google.cloud.grpc.proto.ApiConfig;
import com.google.cloud.grpc.proto.ChannelPoolConfig;
import com.google.cloud.grpc.proto.MethodConfig;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.TransactionSelector;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.opencensus.metrics.LabelKey;
import io.opencensus.metrics.LabelValue;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for GcpManagedChannel. */
@RunWith(JUnit4.class)
public final class GcpManagedChannelTest {

  private static final String TARGET = "localhost";
  private static final String API_FILE = "apiconfig.json";
  private static final String EMPTY_METHOD_FILE = "empty_method.json";
  private static final String EMPTY_CHANNEL_FILE = "empty_channel.json";

  private static final int MAX_CHANNEL = 10;
  private static final int MAX_STREAM = 100;

  private GcpManagedChannel gcpChannel;
  private ManagedChannelBuilder builder;

  /** Close and delete all the channelRefs inside a gcpchannel. */
  private void resetGcpChannel() {
    gcpChannel.shutdownNow();
    gcpChannel.channelRefs.clear();
  }

  @Before
  public void setUpChannel() {
    builder = ManagedChannelBuilder.forAddress(TARGET, 443);
    gcpChannel = (GcpManagedChannel) GcpManagedChannelBuilder.forDelegateBuilder(builder).build();
  }

  @After
  public void shutdown() throws Exception {
    gcpChannel.shutdownNow();
  }

  @Test
  public void testLoadApiConfigFile() throws Exception {
    resetGcpChannel();
    File configFile =
        new File(GcpManagedChannelTest.class.getClassLoader().getResource(API_FILE).getFile());
    gcpChannel =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder)
                .withApiConfigJsonFile(configFile)
                .build();
    assertEquals(0, gcpChannel.channelRefs.size());
    assertEquals(3, gcpChannel.getMaxSize());
    assertEquals(2, gcpChannel.getStreamsLowWatermark());
    assertEquals(3, gcpChannel.methodToAffinity.size());
  }

  @Test
  public void testLoadApiConfigString() throws Exception {
    resetGcpChannel();
    InputStream inputStream =
        GcpManagedChannelTest.class.getClassLoader().getResourceAsStream(API_FILE);
    StringBuilder sb = new StringBuilder();

    for (int ch; (ch = inputStream.read()) != -1; ) {
      sb.append((char) ch);
    }
    gcpChannel =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder)
                .withApiConfigJsonString(sb.toString())
                .build();
    assertEquals(0, gcpChannel.channelRefs.size());
    assertEquals(3, gcpChannel.getMaxSize());
    assertEquals(2, gcpChannel.getStreamsLowWatermark());
    assertEquals(3, gcpChannel.methodToAffinity.size());
  }

  @Test
  public void testGetChannelRefInitialization() throws Exception {
    // Should not have a managedchannel by default.
    assertEquals(0, gcpChannel.channelRefs.size());
    // But once requested it's there.
    assertEquals(0, gcpChannel.getChannelRef(null).getAffinityCount());
    // The state of this channel is idle.
    assertEquals(ConnectivityState.IDLE, gcpChannel.getState(false));
    assertEquals(1, gcpChannel.channelRefs.size());
  }

  @Test
  public void testGetChannelRefPickUpSmallest() throws Exception {
    // All channels have max number of streams
    resetGcpChannel();
    for (int i = 0; i < 5; i++) {
      ManagedChannel channel = builder.build();
      gcpChannel.channelRefs.add(gcpChannel.new ChannelRef(channel, i, i, MAX_STREAM));
    }
    assertEquals(5, gcpChannel.channelRefs.size());
    assertEquals(0, gcpChannel.getChannelRef(null).getAffinityCount());
    assertEquals(6, gcpChannel.channelRefs.size());

    // Add more channels, the smallest stream value is -1 with idx 6.
    int[] streams = new int[] {-1, 5, 7, 1};
    for (int i = 6; i < 10; i++) {
      ManagedChannel channel = builder.build();
      gcpChannel.channelRefs.add(gcpChannel.new ChannelRef(channel, i, i, streams[i - 6]));
    }
    assertEquals(10, gcpChannel.channelRefs.size());
    assertEquals(6, gcpChannel.getChannelRef(null).getAffinityCount());
  }

  @Test
  public void testGetChannelRefMaxSize() throws Exception {
    resetGcpChannel();
    for (int i = 0; i < MAX_CHANNEL; i++) {
      ManagedChannel channel = builder.build();
      gcpChannel.channelRefs.add(gcpChannel.new ChannelRef(channel, i, i, MAX_STREAM));
    }
    assertEquals(MAX_CHANNEL, gcpChannel.channelRefs.size());
    assertEquals(MAX_STREAM, gcpChannel.getChannelRef(null).getActiveStreamsCount());
    assertEquals(MAX_CHANNEL, gcpChannel.channelRefs.size());
  }

  @Test
  public void testBindUnbindKey() throws Exception {
    // Initialize the channel and bind the key, check the affinity count.
    ChannelRef cf1 = gcpChannel.new ChannelRef(builder.build(), 1, 0, 5);
    ChannelRef cf2 = gcpChannel.new ChannelRef(builder.build(), 1, 0, 4);
    gcpChannel.channelRefs.add(cf1);
    gcpChannel.channelRefs.add(cf2);
    gcpChannel.bind(cf1, Arrays.asList("key1"));
    gcpChannel.bind(cf2, Arrays.asList("key2"));
    gcpChannel.bind(cf2, Arrays.asList("key3"));
    // Binding the same key to the same channel should not increase affinity count.
    gcpChannel.bind(cf1, Arrays.asList("key1"));
    assertEquals(1, gcpChannel.channelRefs.get(0).getAffinityCount());
    assertEquals(2, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(3, gcpChannel.affinityKeyToChannelRef.size());
    // Binding the same key to a different channel should alter affinity counts accordingly.
    gcpChannel.bind(cf1, Arrays.asList("key3"));
    assertEquals(2, gcpChannel.channelRefs.get(0).getAffinityCount());
    assertEquals(1, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(3, gcpChannel.affinityKeyToChannelRef.size());

    // Unbind the affinity key.
    gcpChannel.unbind(Arrays.asList("key1"));
    assertEquals(1, gcpChannel.channelRefs.get(0).getAffinityCount());
    assertEquals(1, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(2, gcpChannel.affinityKeyToChannelRef.size());
    gcpChannel.unbind(Arrays.asList("key1"));
    assertEquals(1, gcpChannel.channelRefs.get(0).getAffinityCount());
    assertEquals(1, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(2, gcpChannel.affinityKeyToChannelRef.size());
    gcpChannel.unbind(Arrays.asList("key2"));
    assertEquals(1, gcpChannel.channelRefs.get(0).getAffinityCount());
    assertEquals(0, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(1, gcpChannel.affinityKeyToChannelRef.size());
    gcpChannel.unbind(Arrays.asList("key3"));
    assertEquals(0, gcpChannel.channelRefs.get(0).getAffinityCount());
    assertEquals(0, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(0, gcpChannel.affinityKeyToChannelRef.size());
  }

  @Test
  public void testGetKeysFromRequest() throws Exception {
    String expected = "thisisaname";
    TransactionSelector selector = TransactionSelector.getDefaultInstance();
    PartitionReadRequest req =
        PartitionReadRequest.newBuilder()
            .setSession(expected)
            .setTable("jenny")
            .setTransaction(selector)
            .addColumns("users")
            .build();
    List<String> result = gcpChannel.getKeysFromMessage(req, "session");
    assertEquals(expected, result.get(0));
    result = gcpChannel.getKeysFromMessage(req, "fakesession");
    assertEquals(0, result.size());
  }

  @Test
  public void testParseGoodJsonFile() throws Exception {
    File configFile =
        new File(GcpManagedChannelTest.class.getClassLoader().getResource(API_FILE).getFile());
    ApiConfig apiconfig =
        GcpManagedChannelBuilder.forDelegateBuilder(builder)
            .withApiConfigJsonFile(configFile)
            .apiConfig;
    ChannelPoolConfig expectedChannel =
        ChannelPoolConfig.newBuilder().setMaxSize(3).setMaxConcurrentStreamsLowWatermark(2).build();
    Assert.assertEquals(expectedChannel, apiconfig.getChannelPool());

    assertEquals(3, apiconfig.getMethodCount());
    MethodConfig.Builder expectedMethod1 = MethodConfig.newBuilder();
    expectedMethod1.addName("google.spanner.v1.Spanner/CreateSession");
    expectedMethod1.setAffinity(
        AffinityConfig.newBuilder()
            .setAffinityKey("name")
            .setCommand(AffinityConfig.Command.BIND)
            .build());
    assertEquals(expectedMethod1.build(), apiconfig.getMethod(0));
    MethodConfig.Builder expectedMethod2 = MethodConfig.newBuilder();
    expectedMethod2.addName("google.spanner.v1.Spanner/GetSession");
    expectedMethod2.setAffinity(
        AffinityConfig.newBuilder()
            .setAffinityKey("name")
            .setCommand(AffinityConfig.Command.BOUND)
            .build());
    assertEquals(expectedMethod2.build(), apiconfig.getMethod(1));
    MethodConfig.Builder expectedMethod3 = MethodConfig.newBuilder();
    expectedMethod3.addName("google.spanner.v1.Spanner/DeleteSession");
    expectedMethod3.setAffinity(
        AffinityConfig.newBuilder()
            .setAffinityKey("name")
            .setCommand(AffinityConfig.Command.UNBIND)
            .build());
    assertEquals(expectedMethod3.build(), apiconfig.getMethod(2));
  }

  @Test
  public void testParseEmptyMethodJsonFile() {
    File configFile =
        new File(
            GcpManagedChannelTest.class.getClassLoader().getResource(EMPTY_METHOD_FILE).getFile());
    ApiConfig apiconfig =
        GcpManagedChannelBuilder.forDelegateBuilder(builder)
            .withApiConfigJsonFile(configFile)
            .apiConfig;
    ChannelPoolConfig expectedChannel =
        ChannelPoolConfig.newBuilder()
            .setMaxSize(5)
            .setIdleTimeout(1000)
            .setMaxConcurrentStreamsLowWatermark(5)
            .build();
    Assert.assertEquals(expectedChannel, apiconfig.getChannelPool());

    assertEquals(0, apiconfig.getMethodCount());
  }

  @Test
  public void testParseEmptyChannelJsonFile() {
    File configFile =
        new File(
            GcpManagedChannelTest.class.getClassLoader().getResource(EMPTY_CHANNEL_FILE).getFile());
    ApiConfig apiconfig =
        GcpManagedChannelBuilder.forDelegateBuilder(builder)
            .withApiConfigJsonFile(configFile)
            .apiConfig;
    Assert.assertEquals(ChannelPoolConfig.getDefaultInstance(), apiconfig.getChannelPool());

    assertEquals(3, apiconfig.getMethodCount());
    MethodConfig.Builder expectedMethod1 = MethodConfig.newBuilder();
    expectedMethod1.addName("/google.spanner.v1.Spanner/CreateSession");
    expectedMethod1.setAffinity(
        AffinityConfig.newBuilder()
            .setAffinityKey("name")
            .setCommand(AffinityConfig.Command.BIND)
            .build());
    assertEquals(expectedMethod1.build(), apiconfig.getMethod(0));
    MethodConfig.Builder expectedMethod2 = MethodConfig.newBuilder();
    expectedMethod2.addName("/google.spanner.v1.Spanner/GetSession").addName("additional name");
    expectedMethod2.setAffinity(
        AffinityConfig.newBuilder()
            .setAffinityKey("name")
            .setCommand(AffinityConfig.Command.BOUND)
            .build());
    assertEquals(expectedMethod2.build(), apiconfig.getMethod(1));
    assertEquals(MethodConfig.getDefaultInstance(), apiconfig.getMethod(2));
  }

  @Test
  public void testMetrics() {
    final FakeMetricRegistry fakeRegistry = new FakeMetricRegistry();
    final String prefix = "some/prefix/";
    final List<LabelKey> labelKeys =
        Arrays.asList(LabelKey.create("key_a", ""), LabelKey.create("key_b", ""));
    final List<LabelValue> labelValues =
        Arrays.asList(LabelValue.create("val_a"), LabelValue.create("val_b"));
    final GcpManagedChannel pool =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder)
                .withApiConfig(
                    ApiConfig.newBuilder()
                        .setChannelPool(
                            ChannelPoolConfig.newBuilder()
                                .setMaxConcurrentStreamsLowWatermark(1)
                                .build())
                        .build())
                .withOptions(
                    GcpManagedChannelOptions.newBuilder()
                        .withMetricsOptions(
                            GcpMetricsOptions.newBuilder()
                                .withMetricRegistry(fakeRegistry)
                                .withNamePrefix(prefix)
                                .withLabels(labelKeys, labelValues)
                                .build())
                        .build())
                .build();

    List<LabelKey> expectedLabelKeys = new ArrayList<>();
    expectedLabelKeys.addAll(labelKeys);
    expectedLabelKeys.add(
        LabelKey.create(GcpMetricsConstants.POOL_INDEX_LABEL, GcpMetricsConstants.POOL_INDEX_DESC));
    List<LabelValue> expectedLabelValues = new ArrayList<>();
    expectedLabelValues.addAll(labelValues);
    int currentIndex = GcpManagedChannel.channelPoolIndex.get();
    expectedLabelValues.add(LabelValue.create(String.format("pool-%d", currentIndex)));

    try {
      // Let's fill five channels with some fake streams.
      int[] streams = new int[] {3, 2, 5, 7, 1};
      for (int count : streams) {
        ChannelRef ref = pool.getChannelRef(null);
        for (int j = 0; j < count; j++) {
          ref.activeStreamsCountIncr();
        }
      }

      MetricsRecord record = fakeRegistry.pollRecord();
      assertThat(record.getMetrics().size()).isEqualTo(25);

      List<PointWithFunction> numChannels =
          record.getMetrics().get(prefix + GcpMetricsConstants.METRIC_MAX_CHANNELS);
      assertThat(numChannels.size()).isEqualTo(1);
      assertThat(numChannels.get(0).value()).isEqualTo(5L);
      assertThat(numChannels.get(0).keys()).isEqualTo(expectedLabelKeys);
      assertThat(numChannels.get(0).values()).isEqualTo(expectedLabelValues);

      List<PointWithFunction> maxAllowedChannels =
          record.getMetrics().get(prefix + GcpMetricsConstants.METRIC_MAX_ALLOWED_CHANNELS);
      assertThat(maxAllowedChannels.size()).isEqualTo(1);
      assertThat(maxAllowedChannels.get(0).value()).isEqualTo(MAX_CHANNEL);
      assertThat(maxAllowedChannels.get(0).keys()).isEqualTo(expectedLabelKeys);
      assertThat(maxAllowedChannels.get(0).values()).isEqualTo(expectedLabelValues);

      List<PointWithFunction> minActiveStreams =
          record.getMetrics().get(prefix + GcpMetricsConstants.METRIC_MIN_ACTIVE_STREAMS);
      assertThat(minActiveStreams.size()).isEqualTo(1);
      assertThat(minActiveStreams.get(0).value()).isEqualTo(0L);
      assertThat(minActiveStreams.get(0).keys()).isEqualTo(expectedLabelKeys);
      assertThat(minActiveStreams.get(0).values()).isEqualTo(expectedLabelValues);

      List<PointWithFunction> maxActiveStreams =
          record.getMetrics().get(prefix + GcpMetricsConstants.METRIC_MAX_ACTIVE_STREAMS);
      assertThat(maxActiveStreams.size()).isEqualTo(1);
      assertThat(maxActiveStreams.get(0).value()).isEqualTo(7L);
      assertThat(maxActiveStreams.get(0).keys()).isEqualTo(expectedLabelKeys);
      assertThat(maxActiveStreams.get(0).values()).isEqualTo(expectedLabelValues);

      List<PointWithFunction> totalActiveStreams =
          record.getMetrics().get(prefix + GcpMetricsConstants.METRIC_MAX_TOTAL_ACTIVE_STREAMS);
      assertThat(totalActiveStreams.size()).isEqualTo(1);
      assertThat(totalActiveStreams.get(0).value())
          .isEqualTo(Arrays.stream(streams).asLongStream().sum());
      assertThat(totalActiveStreams.get(0).keys()).isEqualTo(expectedLabelKeys);
      assertThat(totalActiveStreams.get(0).values()).isEqualTo(expectedLabelValues);
    } finally {
      pool.shutdownNow();
    }
  }

  @Test
  public void testUnresponsiveDetection() throws InterruptedException {
    final FakeMetricRegistry fakeRegistry = new FakeMetricRegistry();
    // Creating a pool with unresponsive connection detection for 100 ms, 3 dropped requests.
    final GcpManagedChannel pool =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder)
                .withOptions(
                    GcpManagedChannelOptions.newBuilder()
                        .withResiliencyOptions(
                            GcpResiliencyOptions.newBuilder()
                                .withUnresponsiveConnectionDetection(100, 3)
                                .build())
                        .withMetricsOptions(
                            GcpMetricsOptions.newBuilder().withMetricRegistry(fakeRegistry).build())
                        .build())
                .build();
    final AtomicInteger idleCounter = new AtomicInteger();
    ManagedChannel channel = new FakeIdleCountingManagedChannel(idleCounter);
    ChannelRef chRef = pool.new ChannelRef(channel, 0);
    assertEquals(0, idleCounter.get());

    TimeUnit.MILLISECONDS.sleep(105);

    // Report 3 deadline exceeded errors after 100 ms.
    long startNanos = System.nanoTime();
    final Status deStatus = Status.fromCode(Code.DEADLINE_EXCEEDED);
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    assertEquals(0, idleCounter.get());
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    assertEquals(0, idleCounter.get());
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    // Reconnected after 3rd deadline exceeded.
    assertEquals(1, idleCounter.get());

    MetricsRecord record = fakeRegistry.pollRecord();
    List<PointWithFunction> metric =
        record.getMetrics().get(GcpMetricsConstants.METRIC_NUM_UNRESPONSIVE_DETECTIONS);
    assertThat(metric.size()).isEqualTo(1);
    assertThat(metric.get(0).value()).isEqualTo(1L);
    metric = record.getMetrics().get(GcpMetricsConstants.METRIC_MIN_UNRESPONSIVE_DROPPED_CALLS);
    assertThat(metric.size()).isEqualTo(1);
    assertThat(metric.get(0).value()).isEqualTo(3L);
    metric = record.getMetrics().get(GcpMetricsConstants.METRIC_MAX_UNRESPONSIVE_DROPPED_CALLS);
    assertThat(metric.size()).isEqualTo(1);
    assertThat(metric.get(0).value()).isEqualTo(3L);
    metric = record.getMetrics().get(GcpMetricsConstants.METRIC_MIN_UNRESPONSIVE_DETECTION_TIME);
    assertThat(metric.size()).isEqualTo(1);
    assertThat(metric.get(0).value()).isAtLeast(100L);
    metric = record.getMetrics().get(GcpMetricsConstants.METRIC_MAX_UNRESPONSIVE_DETECTION_TIME);
    assertThat(metric.size()).isEqualTo(1);
    assertThat(metric.get(0).value()).isAtLeast(100L);

    // Any message from the server must reset the dropped requests count and timestamp.
    TimeUnit.MILLISECONDS.sleep(105);
    startNanos = System.nanoTime();
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    assertEquals(1, idleCounter.get());
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    assertEquals(1, idleCounter.get());
    // A message received from the server.
    chRef.messageReceived();
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    // No idle increment expected because dropped requests count and timestamp were reset.
    assertEquals(1, idleCounter.get());

    // Any non-deadline exceeded response must reset the dropped requests count and timestamp.
    TimeUnit.MILLISECONDS.sleep(105);
    startNanos = System.nanoTime();
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    assertEquals(1, idleCounter.get());
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    assertEquals(1, idleCounter.get());
    // Response with UNAVAILABLE status received from the server.
    final Status unavailableStatus = Status.fromCode(Code.UNAVAILABLE);
    chRef.activeStreamsCountDecr(startNanos, unavailableStatus, false);
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    // No idle increment expected because dropped requests count and timestamp were reset.
    assertEquals(1, idleCounter.get());

    // Even if dropped requests count is reached, it must also respect 100 ms configured.
    startNanos = System.nanoTime();
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    assertEquals(1, idleCounter.get());
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    assertEquals(1, idleCounter.get());
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    // Even it's third deadline exceeded no idle increment is expected because 100ms has not pass.
    assertEquals(1, idleCounter.get());

    TimeUnit.MILLISECONDS.sleep(105);
    // Any subsequent deadline exceeded after 100ms must trigger the reconnect.
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    assertEquals(2, idleCounter.get());
  }

  class FakeIdleCountingManagedChannel extends ManagedChannel {
    private AtomicInteger idleCounter;

    FakeIdleCountingManagedChannel(AtomicInteger idleCounter) {
      this.idleCounter = idleCounter;
    }

    @Override
    public void enterIdle() {
      idleCounter.incrementAndGet();
    }

    @Override
    public ConnectivityState getState(boolean requestConnection) {
      return ConnectivityState.IDLE;
    }

    @Override
    public void notifyWhenStateChanged(ConnectivityState source, Runnable callback) {}

    @Override
    public ManagedChannel shutdown() {
      return null;
    }

    @Override
    public boolean isShutdown() {
      return false;
    }

    @Override
    public boolean isTerminated() {
      return false;
    }

    @Override
    public ManagedChannel shutdownNow() {
      return null;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
      return false;
    }

    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
      return null;
    }

    @Override
    public String authority() {
      return null;
    }
  }
}

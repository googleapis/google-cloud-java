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

import static com.google.cloud.grpc.GcpManagedChannel.getKeysFromMessage;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.grpc.GcpManagedChannel.ChannelRef;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpMetricsOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpResiliencyOptions;
import com.google.cloud.grpc.MetricRegistryTestUtils.FakeMetricRegistry;
import com.google.cloud.grpc.MetricRegistryTestUtils.MetricsRecord;
import com.google.cloud.grpc.MetricRegistryTestUtils.PointWithFunction;
import com.google.cloud.grpc.proto.AffinityConfig;
import com.google.cloud.grpc.proto.ApiConfig;
import com.google.cloud.grpc.proto.ChannelPoolConfig;
import com.google.cloud.grpc.proto.MethodConfig;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
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
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
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
  private static final Logger testLogger = Logger.getLogger(GcpManagedChannel.class.getName());

  private final List<LogRecord> logRecords = new LinkedList<>();

  private String lastLogMessage() {
    return lastLogMessage(1);
  }

  private String lastLogMessage(int nthFromLast) {
    return logRecords.get(logRecords.size() - nthFromLast).getMessage();
  }

  private Level lastLogLevel() {
    return lastLogLevel(1);
  }

  private Level lastLogLevel(int nthFromLast) {
    return logRecords.get(logRecords.size() - nthFromLast).getLevel();
  }

  private final Handler testLogHandler =
      new Handler() {
        @Override
        public synchronized void publish(LogRecord record) {
          logRecords.add(record);
        }

        @Override
        public void flush() {}

        @Override
        public void close() throws SecurityException {}
      };

  private GcpManagedChannel gcpChannel;
  private ManagedChannelBuilder<?> builder;

  /** Close and delete all the channelRefs inside a gcpchannel. */
  private void resetGcpChannel() {
    gcpChannel.shutdownNow();
    gcpChannel.channelRefs.clear();
  }

  @Before
  public void setUpChannel() {
    testLogger.addHandler(testLogHandler);
    builder = ManagedChannelBuilder.forAddress(TARGET, 443);
    gcpChannel = (GcpManagedChannel) GcpManagedChannelBuilder.forDelegateBuilder(builder).build();
  }

  @After
  public void shutdown() {
    gcpChannel.shutdownNow();
    testLogger.removeHandler(testLogHandler);
    testLogger.setLevel(Level.INFO);
    logRecords.clear();
  }

  @Test
  public void testLoadApiConfigFile() {
    resetGcpChannel();
    final URL resource = GcpManagedChannelTest.class.getClassLoader().getResource(API_FILE);
    assertNotNull(resource);
    File configFile = new File(resource.getFile());
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

    assertNotNull(inputStream);
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
  public void testUsesPoolOptions() {
    resetGcpChannel();
    GcpChannelPoolOptions poolOptions =
        GcpChannelPoolOptions.newBuilder()
            .setMaxSize(5)
            .setMinSize(2)
            .setConcurrentStreamsLowWatermark(50)
            .build();
    GcpManagedChannelOptions options =
        GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(poolOptions).build();
    gcpChannel =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder).withOptions(options).build();
    assertEquals(2, gcpChannel.channelRefs.size());
    assertEquals(5, gcpChannel.getMaxSize());
    assertEquals(2, gcpChannel.getMinSize());
    assertEquals(50, gcpChannel.getStreamsLowWatermark());
  }

  @Test
  public void testPoolOptionsOverrideApiConfig() {
    resetGcpChannel();
    final URL resource = GcpManagedChannelTest.class.getClassLoader().getResource(API_FILE);
    assertNotNull(resource);
    File configFile = new File(resource.getFile());
    GcpChannelPoolOptions poolOptions =
        GcpChannelPoolOptions.newBuilder()
            .setMaxSize(5)
            .setConcurrentStreamsLowWatermark(50)
            .build();
    GcpManagedChannelOptions options =
        GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(poolOptions).build();
    gcpChannel =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder)
                .withApiConfigJsonFile(configFile)
                .withOptions(options)
                .build();
    assertEquals(0, gcpChannel.channelRefs.size());
    assertEquals(5, gcpChannel.getMaxSize());
    assertEquals(50, gcpChannel.getStreamsLowWatermark());
    assertEquals(3, gcpChannel.methodToAffinity.size());
  }

  @Test
  public void testGetChannelRefInitialization() {
    // Watch debug messages.
    testLogger.setLevel(Level.FINER);

    final int currentIndex = GcpManagedChannel.channelPoolIndex.get();
    final String poolIndex = String.format("pool-%d", currentIndex);

    // Initial log messages count.
    int logCount = logRecords.size();

    // Should not have a managedchannel by default.
    assertEquals(0, gcpChannel.channelRefs.size());
    // But once requested it's there.
    assertEquals(0, gcpChannel.getChannelRef(null).getAffinityCount());

    assertThat(logRecords.size()).isEqualTo(logCount + 2);
    assertThat(lastLogMessage()).isEqualTo(poolIndex + ": Channel 0 created.");
    assertThat(lastLogLevel()).isEqualTo(Level.FINER);
    assertThat(logRecords.get(logRecords.size() - 2).getMessage())
        .isEqualTo(poolIndex + ": Channel 0 state change detected: null -> IDLE");
    assertThat(logRecords.get(logRecords.size() - 2).getLevel()).isEqualTo(Level.FINER);

    // The state of this channel is idle.
    assertEquals(ConnectivityState.IDLE, gcpChannel.getState(false));
    assertEquals(1, gcpChannel.channelRefs.size());
  }

  @Test
  public void testGetChannelRefInitializationWithMinSize() throws InterruptedException {
    resetGcpChannel();
    GcpChannelPoolOptions poolOptions =
        GcpChannelPoolOptions.newBuilder().setMaxSize(5).setMinSize(2).build();
    GcpManagedChannelOptions options =
        GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(poolOptions).build();
    gcpChannel =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder).withOptions(options).build();
    // Should have 2 channels since the beginning.
    assertThat(gcpChannel.channelRefs.size()).isEqualTo(2);
    TimeUnit.MILLISECONDS.sleep(50);
    // The connection establishment must have been started on these two channels.
    assertThat(gcpChannel.getState(false))
        .isAnyOf(
            ConnectivityState.CONNECTING,
            ConnectivityState.READY,
            ConnectivityState.TRANSIENT_FAILURE);
    assertThat(gcpChannel.channelRefs.get(0).getChannel().getState(false))
        .isAnyOf(
            ConnectivityState.CONNECTING,
            ConnectivityState.READY,
            ConnectivityState.TRANSIENT_FAILURE);
    assertThat(gcpChannel.channelRefs.get(1).getChannel().getState(false))
        .isAnyOf(
            ConnectivityState.CONNECTING,
            ConnectivityState.READY,
            ConnectivityState.TRANSIENT_FAILURE);
  }

  @Test
  public void testGetChannelRefPickUpSmallest() {
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

  private void assertFallbacksMetric(
      FakeMetricRegistry fakeRegistry, long successes, long failures) {
    MetricsRecord record = fakeRegistry.pollRecord();
    List<PointWithFunction<?>> metric =
        record.getMetrics().get(GcpMetricsConstants.METRIC_NUM_FALLBACKS);
    assertThat(metric.size()).isEqualTo(2);
    assertThat(metric.get(0).value()).isEqualTo(successes);
    assertThat(metric.get(0).values().get(0))
        .isEqualTo(LabelValue.create(GcpMetricsConstants.RESULT_SUCCESS));
    assertThat(metric.get(1).value()).isEqualTo(failures);
    assertThat(metric.get(1).values().get(0))
        .isEqualTo(LabelValue.create(GcpMetricsConstants.RESULT_ERROR));
  }

  @Test
  public void testGetChannelRefWithFallback() {
    // Watch debug messages.
    testLogger.setLevel(Level.FINEST);

    final FakeMetricRegistry fakeRegistry = new FakeMetricRegistry();

    final int maxSize = 3;
    final int lowWatermark = 2;

    // Creating a pool with fallback, max size and low watermark above.
    final GcpManagedChannel pool =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder)
                .withApiConfig(
                    ApiConfig.newBuilder()
                        .setChannelPool(
                            ChannelPoolConfig.newBuilder()
                                .setMaxSize(maxSize)
                                .setMaxConcurrentStreamsLowWatermark(lowWatermark)
                                .build())
                        .build())
                .withOptions(
                    GcpManagedChannelOptions.newBuilder()
                        .withResiliencyOptions(
                            GcpResiliencyOptions.newBuilder().setNotReadyFallback(true).build())
                        .withMetricsOptions(
                            GcpMetricsOptions.newBuilder().withMetricRegistry(fakeRegistry).build())
                        .build())
                .build();

    final int currentIndex = GcpManagedChannel.channelPoolIndex.get();
    final String poolIndex = String.format("pool-%d", currentIndex);

    // Creates the first channel with 0 id.
    assertEquals(0, pool.getNumberOfChannels());
    ChannelRef chRef = pool.getChannelRef(null);
    assertEquals(0, chRef.getId());
    assertEquals(1, pool.getNumberOfChannels());

    // The 0 channel is ready by default, so the subsequent request for a channel should return
    // the 0 channel again if its active streams (currently 0) are less than the low watermark.
    chRef = pool.getChannelRef(null);
    assertEquals(0, chRef.getId());
    assertEquals(1, pool.getNumberOfChannels());

    // Let's simulate the non-ready state for the 0 channel.
    pool.processChannelStateChange(0, ConnectivityState.CONNECTING);
    int logCount = logRecords.size();
    // Now request for a channel should return a newly created channel because our current channel
    // is not ready, and we haven't reached the pool's max size.
    chRef = pool.getChannelRef(null);
    assertEquals(1, chRef.getId());
    assertEquals(2, pool.getNumberOfChannels());
    // This was a fallback from non-ready channel 0 to the newly created channel 1.
    assertThat(logRecords.size()).isEqualTo(logCount + 3);
    assertThat(lastLogMessage()).isEqualTo(poolIndex + ": Fallback to newly created channel 1");
    assertThat(lastLogLevel()).isEqualTo(Level.FINEST);
    assertFallbacksMetric(fakeRegistry, 1, 0);

    // Adding one active stream to channel 1.
    pool.channelRefs.get(1).activeStreamsCountIncr();
    logCount = logRecords.size();
    // Having 0 active streams on channel 0 and 1 active streams on channel one with the default
    // settings would return channel 0 for the next channel request. But having fallback enabled and
    // channel 0 not ready it should return channel 1 instead.
    chRef = pool.getChannelRef(null);
    assertEquals(1, chRef.getId());
    assertEquals(2, pool.getNumberOfChannels());
    // This was the second fallback from non-ready channel 0 to the channel 1.
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogMessage()).isEqualTo(poolIndex + ": Picking fallback channel: 0 -> 1");
    assertThat(lastLogLevel()).isEqualTo(Level.FINEST);
    assertFallbacksMetric(fakeRegistry, 2, 0);

    // Now let's have channel 0 still as not ready but bring channel 1 streams to low watermark.
    for (int i = 0; i < lowWatermark - 1; i++) {
      pool.channelRefs.get(1).activeStreamsCountIncr();
    }
    // Having one non-ready channel and another channel reached the low watermark should create a
    // new channel for the next channel request if we haven't reached max size.
    chRef = pool.getChannelRef(null);
    assertEquals(2, chRef.getId());
    assertEquals(3, pool.getNumberOfChannels());

    // Now we reached max pool size. Let's bring channel 2 to the low watermark and channel 1 to the
    // low watermark + 1 streams.
    for (int i = 0; i < lowWatermark; i++) {
      pool.channelRefs.get(2).activeStreamsCountIncr();
    }
    pool.channelRefs.get(1).activeStreamsCountIncr();
    // As we reached max size and cannot create new channels and having ready channels with low
    // watermark and low watermark + 1 streams, the best channel for the next channel request with
    // the fallback enabled is the channel 2 with low watermark streams because it's the least busy
    // ready channel.
    assertEquals(lowWatermark + 1, pool.channelRefs.get(1).getActiveStreamsCount());
    assertEquals(lowWatermark, pool.channelRefs.get(2).getActiveStreamsCount());
    chRef = pool.getChannelRef(null);
    assertEquals(2, chRef.getId());
    assertEquals(3, pool.getNumberOfChannels());
    // This was the third fallback from non-ready channel 0 to the channel 2.
    assertFallbacksMetric(fakeRegistry, 3, 0);

    // Let's bring channel 1 to max streams and mark channel 2 as not ready.
    for (int i = 0; i < MAX_STREAM - lowWatermark; i++) {
      pool.channelRefs.get(2).activeStreamsCountIncr();
    }
    pool.processChannelStateChange(1, ConnectivityState.CONNECTING);
    assertEquals(MAX_STREAM, pool.channelRefs.get(2).getActiveStreamsCount());

    // Now we have two non-ready channels and one overloaded.
    // Even when fallback enabled there is no good candidate at this time, the next channel request
    // should return a channel with the lowest streams count regardless of its readiness state.
    // In our case it is channel 0.
    logCount = logRecords.size();
    chRef = pool.getChannelRef(null);
    assertEquals(0, chRef.getId());
    assertEquals(3, pool.getNumberOfChannels());
    // This will also count as a failed fallback because we couldn't find a ready and non-overloaded
    // channel.
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogMessage()).isEqualTo(poolIndex + ": Failed to find fallback for channel 0");
    assertThat(lastLogLevel()).isEqualTo(Level.FINEST);
    assertFallbacksMetric(fakeRegistry, 3, 1);

    // Let's have an affinity key and bind it to channel 0.
    final String key = "ABC";
    pool.bind(pool.channelRefs.get(0), Collections.singletonList(key));
    logCount = logRecords.size();

    // Channel 0 is not ready currently and the fallback enabled should look for a fallback but we
    // still don't have a good channel because channel 1 is not ready and channel 2 is overloaded.
    // The getChannelRef should return the original channel 0 and report a failed fallback.
    chRef = pool.getChannelRef(key);
    assertEquals(0, chRef.getId());
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogMessage()).isEqualTo(poolIndex + ": Failed to find fallback for channel 0");
    assertThat(lastLogLevel()).isEqualTo(Level.FINEST);
    assertFallbacksMetric(fakeRegistry, 3, 2);

    // Let's return channel 1 to a ready state.
    pool.processChannelStateChange(1, ConnectivityState.READY);
    logCount = logRecords.size();
    // Now we have a fallback candidate.
    // The getChannelRef should return the channel 1 and report a successful fallback.
    chRef = pool.getChannelRef(key);
    assertEquals(1, chRef.getId());
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogMessage()).isEqualTo(poolIndex + ": Setting fallback channel: 0 -> 1");
    assertThat(lastLogLevel()).isEqualTo(Level.FINEST);
    assertFallbacksMetric(fakeRegistry, 4, 2);

    // Let's briefly bring channel 2 to ready state.
    pool.processChannelStateChange(2, ConnectivityState.READY);
    logCount = logRecords.size();
    // Now we have a better fallback candidate (fewer streams on channel 2). But this time we
    // already used channel 1 as a fallback, and we should stick to it instead of returning the
    // original channel.
    // The getChannelRef should return the channel 1 and report a successful fallback.
    chRef = pool.getChannelRef(key);
    assertEquals(1, chRef.getId());
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogMessage()).isEqualTo(poolIndex + ": Using fallback channel: 0 -> 1");
    assertThat(lastLogLevel()).isEqualTo(Level.FINEST);
    assertFallbacksMetric(fakeRegistry, 5, 2);
    pool.processChannelStateChange(2, ConnectivityState.CONNECTING);

    // Let's bring channel 1 back to connecting state.
    pool.processChannelStateChange(1, ConnectivityState.CONNECTING);
    logCount = logRecords.size();
    // Now we don't have a good fallback candidate again. But this time we already used channel 1
    // as a fallback and we should stick to it instead of returning the original channel.
    // The getChannelRef should return the channel 1 and report a failed fallback.
    chRef = pool.getChannelRef(key);
    assertEquals(1, chRef.getId());
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogMessage()).isEqualTo(poolIndex + ": Failed to find fallback for channel 0");
    assertThat(lastLogLevel()).isEqualTo(Level.FINEST);
    assertFallbacksMetric(fakeRegistry, 5, 3);

    // Finally, we bring both channel 1 and channel 0 to the ready state and we should get the
    // original channel 0 for the key without any fallbacks happening.
    pool.processChannelStateChange(1, ConnectivityState.READY);
    pool.processChannelStateChange(0, ConnectivityState.READY);
    logCount = logRecords.size();
    chRef = pool.getChannelRef(key);
    assertEquals(0, chRef.getId());
    assertThat(logRecords.size()).isEqualTo(logCount);
    assertFallbacksMetric(fakeRegistry, 5, 3);
  }

  @Test
  public void testGetChannelRefMaxSize() {
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
  public void testBindUnbindKey() {
    // Watch debug messages.
    testLogger.setLevel(Level.FINEST);

    final int currentIndex = GcpManagedChannel.channelPoolIndex.get();
    final String poolIndex = String.format("pool-%d", currentIndex);

    // Initialize the channel and bind the key, check the affinity count.
    ChannelRef cf1 = gcpChannel.new ChannelRef(builder.build(), 1, 0, 5);
    ChannelRef cf2 = gcpChannel.new ChannelRef(builder.build(), 2, 0, 4);
    gcpChannel.channelRefs.add(cf1);
    gcpChannel.channelRefs.add(cf2);

    gcpChannel.bind(cf1, Collections.singletonList("key1"));

    // Initial log messages count.
    int logCount = logRecords.size();

    gcpChannel.bind(cf2, Collections.singletonList("key2"));

    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogMessage()).isEqualTo(poolIndex + ": Binding 1 key(s) to channel 2: [key2]");
    assertThat(lastLogLevel()).isEqualTo(Level.FINEST);

    gcpChannel.bind(cf2, Collections.singletonList("key3"));
    // Binding the same key to the same channel should not increase affinity count.
    gcpChannel.bind(cf1, Collections.singletonList("key1"));
    assertEquals(1, gcpChannel.channelRefs.get(0).getAffinityCount());
    assertEquals(2, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(3, gcpChannel.affinityKeyToChannelRef.size());
    // Binding the same key to a different channel should alter affinity counts accordingly.
    gcpChannel.bind(cf1, Collections.singletonList("key3"));
    assertEquals(2, gcpChannel.channelRefs.get(0).getAffinityCount());
    assertEquals(1, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(3, gcpChannel.affinityKeyToChannelRef.size());

    logCount = logRecords.size();

    // Unbind the affinity key.
    gcpChannel.unbind(Collections.singletonList("key1"));
    assertEquals(1, gcpChannel.channelRefs.get(0).getAffinityCount());
    assertEquals(1, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(2, gcpChannel.affinityKeyToChannelRef.size());
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogMessage()).isEqualTo(poolIndex + ": Unbinding key key1 from channel 1.");
    assertThat(lastLogLevel()).isEqualTo(Level.FINEST);
    gcpChannel.unbind(Collections.singletonList("key1"));
    assertEquals(1, gcpChannel.channelRefs.get(0).getAffinityCount());
    assertEquals(1, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(2, gcpChannel.affinityKeyToChannelRef.size());
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogMessage()).isEqualTo(poolIndex + ": Unbinding key key1 but it wasn't bound.");
    assertThat(lastLogLevel()).isEqualTo(Level.FINEST);
    gcpChannel.unbind(Collections.singletonList("key2"));
    assertEquals(1, gcpChannel.channelRefs.get(0).getAffinityCount());
    assertEquals(0, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(1, gcpChannel.affinityKeyToChannelRef.size());
    gcpChannel.unbind(Collections.singletonList("key3"));
    assertEquals(0, gcpChannel.channelRefs.get(0).getAffinityCount());
    assertEquals(0, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(0, gcpChannel.affinityKeyToChannelRef.size());
  }

  @Test
  public void testUsingKeyWithoutBinding() {
    // Initialize the channel and bind the key, check the affinity count.
    ChannelRef cf1 = gcpChannel.new ChannelRef(builder.build(), 1, 0, 5);
    ChannelRef cf2 = gcpChannel.new ChannelRef(builder.build(), 2, 0, 4);
    gcpChannel.channelRefs.add(cf1);
    gcpChannel.channelRefs.add(cf2);

    final String key = "non-binded-key";
    ChannelRef channelRef = gcpChannel.getChannelRef(key);
    // Should bind on the fly to the least busy channel, which is 2.
    assertThat(channelRef.getId()).isEqualTo(2);

    cf1.activeStreamsCountDecr(System.nanoTime(), Status.OK, true);
    cf1.activeStreamsCountDecr(System.nanoTime(), Status.OK, true);
    channelRef = gcpChannel.getChannelRef(key);
    // Even after channel 1 now has less active streams (3) the channel 2 is still mapped for the
    // same key.
    assertThat(channelRef.getId()).isEqualTo(2);
  }

  @Test
  public void testGetKeysFromRequest() {
    String expected = "thisisaname";
    TransactionSelector selector = TransactionSelector.getDefaultInstance();
    PartitionReadRequest req =
        PartitionReadRequest.newBuilder()
            .setSession(expected)
            .setTable("jenny")
            .setTransaction(selector)
            .addColumns("users")
            .build();
    List<String> result = getKeysFromMessage(req, "session");
    assertEquals(expected, result.get(0));
    result = getKeysFromMessage(req, "fakesession");
    assertEquals(0, result.size());
  }

  @Test
  public void testParseGoodJsonFile() {
    final URL resource = GcpManagedChannelTest.class.getClassLoader().getResource(API_FILE);
    assertNotNull(resource);
    File configFile = new File(resource.getFile());
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
    final URL resource =
        GcpManagedChannelTest.class.getClassLoader().getResource(EMPTY_METHOD_FILE);
    assertNotNull(resource);
    File configFile = new File(resource.getFile());
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
    final URL resource =
        GcpManagedChannelTest.class.getClassLoader().getResource(EMPTY_CHANNEL_FILE);
    assertNotNull(resource);
    File configFile = new File(resource.getFile());
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
    // Watch debug messages.
    testLogger.setLevel(Level.FINE);
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

    final int currentIndex = GcpManagedChannel.channelPoolIndex.get();
    final String poolIndex = String.format("pool-%d", currentIndex);

    // Logs metrics options.
    assertThat(logRecords.get(logRecords.size() - 2).getLevel()).isEqualTo(Level.FINE);
    assertThat(logRecords.get(logRecords.size() - 2).getMessage())
        .startsWith(
            poolIndex
                + ": Metrics options: {namePrefix: \"some/prefix/\", labels: "
                + "[key_a: \"val_a\", key_b: \"val_b\"],");

    assertThat(lastLogLevel()).isEqualTo(Level.INFO);
    assertThat(lastLogMessage()).isEqualTo(poolIndex + ": Metrics enabled.");

    List<LabelKey> expectedLabelKeys = new ArrayList<>(labelKeys);
    expectedLabelKeys.add(
        LabelKey.create(GcpMetricsConstants.POOL_INDEX_LABEL, GcpMetricsConstants.POOL_INDEX_DESC));
    List<LabelValue> expectedLabelValues = new ArrayList<>(labelValues);
    expectedLabelValues.add(LabelValue.create(poolIndex));

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

      // Initial log messages count.
      int logCount = logRecords.size();

      List<PointWithFunction<?>> numChannels =
          record.getMetrics().get(prefix + GcpMetricsConstants.METRIC_MAX_CHANNELS);
      assertThat(numChannels.size()).isEqualTo(1);
      assertThat(numChannels.get(0).value()).isEqualTo(5L);
      assertThat(numChannels.get(0).keys()).isEqualTo(expectedLabelKeys);
      assertThat(numChannels.get(0).values()).isEqualTo(expectedLabelValues);
      assertThat(logRecords.size()).isEqualTo(++logCount);
      assertThat(lastLogLevel()).isEqualTo(Level.FINE);
      assertThat(lastLogMessage())
          .isEqualTo(poolIndex + ": stat: " + GcpMetricsConstants.METRIC_MAX_CHANNELS + " = 5");

      List<PointWithFunction<?>> maxAllowedChannels =
          record.getMetrics().get(prefix + GcpMetricsConstants.METRIC_MAX_ALLOWED_CHANNELS);
      assertThat(maxAllowedChannels.size()).isEqualTo(1);
      assertThat(maxAllowedChannels.get(0).value()).isEqualTo(MAX_CHANNEL);
      assertThat(maxAllowedChannels.get(0).keys()).isEqualTo(expectedLabelKeys);
      assertThat(maxAllowedChannels.get(0).values()).isEqualTo(expectedLabelValues);
      assertThat(logRecords.size()).isEqualTo(++logCount);
      assertThat(lastLogLevel()).isEqualTo(Level.FINE);
      assertThat(lastLogMessage())
          .isEqualTo(
              poolIndex + ": stat: " + GcpMetricsConstants.METRIC_MAX_ALLOWED_CHANNELS + " = 10");

      List<PointWithFunction<?>> minActiveStreams =
          record.getMetrics().get(prefix + GcpMetricsConstants.METRIC_MIN_ACTIVE_STREAMS);
      assertThat(minActiveStreams.size()).isEqualTo(1);
      assertThat(minActiveStreams.get(0).value()).isEqualTo(0L);
      assertThat(minActiveStreams.get(0).keys()).isEqualTo(expectedLabelKeys);
      assertThat(minActiveStreams.get(0).values()).isEqualTo(expectedLabelValues);
      assertThat(logRecords.size()).isEqualTo(++logCount);
      assertThat(lastLogLevel()).isEqualTo(Level.FINE);
      assertThat(lastLogMessage())
          .isEqualTo(
              poolIndex + ": stat: " + GcpMetricsConstants.METRIC_MIN_ACTIVE_STREAMS + " = 0");

      List<PointWithFunction<?>> maxActiveStreams =
          record.getMetrics().get(prefix + GcpMetricsConstants.METRIC_MAX_ACTIVE_STREAMS);
      assertThat(maxActiveStreams.size()).isEqualTo(1);
      assertThat(maxActiveStreams.get(0).value()).isEqualTo(7L);
      assertThat(maxActiveStreams.get(0).keys()).isEqualTo(expectedLabelKeys);
      assertThat(maxActiveStreams.get(0).values()).isEqualTo(expectedLabelValues);
      assertThat(logRecords.size()).isEqualTo(++logCount);
      assertThat(lastLogLevel()).isEqualTo(Level.FINE);
      assertThat(lastLogMessage())
          .isEqualTo(
              poolIndex + ": stat: " + GcpMetricsConstants.METRIC_MAX_ACTIVE_STREAMS + " = 7");

      List<PointWithFunction<?>> totalActiveStreams =
          record.getMetrics().get(prefix + GcpMetricsConstants.METRIC_MAX_TOTAL_ACTIVE_STREAMS);
      assertThat(totalActiveStreams.size()).isEqualTo(1);
      long totalStreamsExpected = Arrays.stream(streams).asLongStream().sum();
      assertThat(totalActiveStreams.get(0).value()).isEqualTo(totalStreamsExpected);
      assertThat(totalActiveStreams.get(0).keys()).isEqualTo(expectedLabelKeys);
      assertThat(totalActiveStreams.get(0).values()).isEqualTo(expectedLabelValues);
      assertThat(logRecords.size()).isEqualTo(++logCount);
      assertThat(lastLogLevel()).isEqualTo(Level.FINE);
      assertThat(lastLogMessage())
          .isEqualTo(
              poolIndex
                  + ": stat: "
                  + GcpMetricsConstants.METRIC_MAX_TOTAL_ACTIVE_STREAMS
                  + " = "
                  + totalStreamsExpected);
    } finally {
      pool.shutdownNow();
    }
  }

  @Test
  public void testLogMetrics() throws InterruptedException {
    // Watch debug messages.
    testLogger.setLevel(Level.FINE);

    final GcpManagedChannel pool =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder)
                .withOptions(
                    GcpManagedChannelOptions.newBuilder()
                        .withChannelPoolOptions(
                            GcpChannelPoolOptions.newBuilder()
                                .setMaxSize(5)
                                .setConcurrentStreamsLowWatermark(3)
                                .build())
                        .withMetricsOptions(
                            GcpMetricsOptions.newBuilder().withNamePrefix("prefix").build())
                        .withResiliencyOptions(
                            GcpResiliencyOptions.newBuilder()
                                .setNotReadyFallback(true)
                                .withUnresponsiveConnectionDetection(100, 2)
                                .build())
                        .build())
                .build();

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    try {
      final int currentIndex = GcpManagedChannel.channelPoolIndex.get();
      final String poolIndex = String.format("pool-%d", currentIndex);

      int[] streams = new int[] {3, 2, 5, 7, 1};
      int[] keyCount = new int[] {2, 3, 1, 1, 4};
      int[] okCalls = new int[] {2, 2, 8, 2, 3};
      int[] errCalls = new int[] {1, 1, 2, 2, 1};
      List<FakeManagedChannel> channels = new ArrayList<>();
      for (int i = 0; i < streams.length; i++) {
        FakeManagedChannel channel = new FakeManagedChannel(executorService);
        channels.add(channel);
        ChannelRef ref = pool.new ChannelRef(channel, i);
        pool.channelRefs.add(ref);

        // Simulate channel connecting.
        channel.setState(ConnectivityState.CONNECTING);
        TimeUnit.MILLISECONDS.sleep(10);

        // For the last one...
        if (i == streams.length - 1) {
          // This will be a couple of successful fallbacks.
          pool.getChannelRef(null);
          pool.getChannelRef(null);
          // Bring down all other channels.
          for (int j = 0; j < i; j++) {
            channels.get(j).setState(ConnectivityState.CONNECTING);
          }
          TimeUnit.MILLISECONDS.sleep(100);
          // And this will be a failed fallback (no ready channels).
          pool.getChannelRef(null);

          // Simulate unresponsive connection.
          long startNanos = System.nanoTime();
          final Status deStatus = Status.fromCode(Code.DEADLINE_EXCEEDED);
          ref.activeStreamsCountIncr();
          ref.activeStreamsCountDecr(startNanos, deStatus, false);
          ref.activeStreamsCountIncr();
          ref.activeStreamsCountDecr(startNanos, deStatus, false);

          // Simulate unresponsive connection with more dropped calls.
          startNanos = System.nanoTime();
          ref.activeStreamsCountIncr();
          ref.activeStreamsCountDecr(startNanos, deStatus, false);
          ref.activeStreamsCountIncr();
          ref.activeStreamsCountDecr(startNanos, deStatus, false);
          TimeUnit.MILLISECONDS.sleep(110);
          ref.activeStreamsCountIncr();
          ref.activeStreamsCountDecr(startNanos, deStatus, false);
        }

        channel.setState(ConnectivityState.READY);

        for (int j = 0; j < streams[i]; j++) {
          ref.activeStreamsCountIncr();
        }
        // Bind affinity keys.
        final List<String> keys = new ArrayList<>();
        for (int j = 0; j < keyCount[i]; j++) {
          keys.add("key-" + i + "-" + j);
        }
        pool.bind(ref, keys);
        // Simulate successful calls.
        for (int j = 0; j < okCalls[i]; j++) {
          ref.activeStreamsCountDecr(0, Status.OK, false);
          ref.activeStreamsCountIncr();
        }
        // Simulate failed calls.
        for (int j = 0; j < errCalls[i]; j++) {
          ref.activeStreamsCountDecr(0, Status.UNAVAILABLE, false);
          ref.activeStreamsCountIncr();
        }
      }

      logRecords.clear();

      pool.logMetrics();

      List<Object> messages =
          Arrays.asList(logRecords.stream().map(LogRecord::getMessage).toArray());

      assertThat(messages).contains(poolIndex + ": Active streams counts: [3, 2, 5, 7, 1]");
      assertThat(messages).contains(poolIndex + ": Affinity counts: [2, 3, 1, 1, 4]");

      assertThat(messages).contains(poolIndex + ": stat: min_ready_channels = 0");
      assertThat(messages).contains(poolIndex + ": stat: max_ready_channels = 4");
      assertThat(messages).contains(poolIndex + ": stat: max_channels = 5");
      assertThat(messages).contains(poolIndex + ": stat: max_allowed_channels = 5");
      assertThat(messages).contains(poolIndex + ": stat: num_channel_disconnect = 4");
      assertThat(messages).contains(poolIndex + ": stat: num_channel_connect = 5");
      assertThat(
              messages
                  .stream()
                  .filter(
                      o ->
                          o.toString()
                              .matches(poolIndex + ": stat: min_channel_readiness_time = \\d\\d+"))
                  .count())
          .isEqualTo(1);
      assertThat(
              messages
                  .stream()
                  .filter(
                      o ->
                          o.toString()
                              .matches(poolIndex + ": stat: avg_channel_readiness_time = \\d\\d+"))
                  .count())
          .isEqualTo(1);
      assertThat(
              messages
                  .stream()
                  .filter(
                      o ->
                          o.toString()
                              .matches(poolIndex + ": stat: max_channel_readiness_time = \\d\\d+"))
                  .count())
          .isEqualTo(1);
      assertThat(messages).contains(poolIndex + ": stat: min_active_streams_per_channel = 0");
      assertThat(messages).contains(poolIndex + ": stat: max_active_streams_per_channel = 7");
      assertThat(messages).contains(poolIndex + ": stat: min_total_active_streams = 0");
      assertThat(messages).contains(poolIndex + ": stat: max_total_active_streams = 18");
      assertThat(messages).contains(poolIndex + ": stat: min_affinity_per_channel = 0");
      assertThat(messages).contains(poolIndex + ": stat: max_affinity_per_channel = 4");
      assertThat(messages).contains(poolIndex + ": stat: num_affinity = 11");
      assertThat(messages).contains(poolIndex + ": Ok calls: [2, 2, 8, 2, 3]");
      assertThat(messages).contains(poolIndex + ": Failed calls: [1, 1, 2, 2, 6]");
      assertThat(messages).contains(poolIndex + ": stat: min_calls_per_channel_ok = 2");
      assertThat(messages).contains(poolIndex + ": stat: min_calls_per_channel_err = 1");
      assertThat(messages).contains(poolIndex + ": stat: max_calls_per_channel_ok = 8");
      assertThat(messages).contains(poolIndex + ": stat: max_calls_per_channel_err = 6");
      assertThat(messages).contains(poolIndex + ": stat: num_calls_completed_ok = 17");
      assertThat(messages).contains(poolIndex + ": stat: num_calls_completed_err = 12");
      assertThat(messages).contains(poolIndex + ": stat: num_fallbacks_ok = 2");
      assertThat(messages).contains(poolIndex + ": stat: num_fallbacks_fail = 1");
      assertThat(messages).contains(poolIndex + ": stat: num_unresponsive_detections = 2");
      assertThat(
              messages
                  .stream()
                  .filter(
                      o ->
                          o.toString()
                              .matches(
                                  poolIndex + ": stat: min_unresponsive_detection_time = 1\\d\\d"))
                  .count())
          .isEqualTo(1);
      assertThat(
              messages
                  .stream()
                  .filter(
                      o ->
                          o.toString()
                              .matches(
                                  poolIndex + ": stat: max_unresponsive_detection_time = 1\\d\\d"))
                  .count())
          .isEqualTo(1);
      assertThat(messages).contains(poolIndex + ": stat: min_unresponsive_dropped_calls = 2");
      assertThat(messages).contains(poolIndex + ": stat: max_unresponsive_dropped_calls = 3");

      assertThat(logRecords.size()).isEqualTo(34);
      logRecords.forEach(
          logRecord ->
              assertThat(logRecord.getLevel()).named(logRecord.getMessage()).isEqualTo(Level.FINE));

      logRecords.clear();

      // Next call should update minimums that was 0 previously (e.g., min_ready_channels,
      // min_active_streams_per_channel, min_total_active_streams...).
      pool.logMetrics();

      messages = Arrays.asList(logRecords.stream().map(LogRecord::getMessage).toArray());

      assertThat(messages).contains(poolIndex + ": Active streams counts: [3, 2, 5, 7, 1]");
      assertThat(messages).contains(poolIndex + ": Affinity counts: [2, 3, 1, 1, 4]");

      assertThat(messages).contains(poolIndex + ": stat: min_ready_channels = 1");
      assertThat(messages).contains(poolIndex + ": stat: max_ready_channels = 1");
      assertThat(messages).contains(poolIndex + ": stat: max_channels = 5");
      assertThat(messages).contains(poolIndex + ": stat: max_allowed_channels = 5");
      assertThat(messages).contains(poolIndex + ": stat: num_channel_disconnect = 0");
      assertThat(messages).contains(poolIndex + ": stat: num_channel_connect = 0");
      assertThat(messages).contains(poolIndex + ": stat: min_channel_readiness_time = 0");
      assertThat(messages).contains(poolIndex + ": stat: avg_channel_readiness_time = 0");
      assertThat(messages).contains(poolIndex + ": stat: max_channel_readiness_time = 0");
      assertThat(messages).contains(poolIndex + ": stat: min_active_streams_per_channel = 1");
      assertThat(messages).contains(poolIndex + ": stat: max_active_streams_per_channel = 7");
      assertThat(messages).contains(poolIndex + ": stat: min_total_active_streams = 18");
      assertThat(messages).contains(poolIndex + ": stat: max_total_active_streams = 18");
      assertThat(messages).contains(poolIndex + ": stat: min_affinity_per_channel = 1");
      assertThat(messages).contains(poolIndex + ": stat: max_affinity_per_channel = 4");
      assertThat(messages).contains(poolIndex + ": stat: num_affinity = 11");
      assertThat(messages).contains(poolIndex + ": Ok calls: [0, 0, 0, 0, 0]");
      assertThat(messages).contains(poolIndex + ": Failed calls: [0, 0, 0, 0, 0]");
      assertThat(messages).contains(poolIndex + ": stat: min_calls_per_channel_ok = 0");
      assertThat(messages).contains(poolIndex + ": stat: min_calls_per_channel_err = 0");
      assertThat(messages).contains(poolIndex + ": stat: max_calls_per_channel_ok = 0");
      assertThat(messages).contains(poolIndex + ": stat: max_calls_per_channel_err = 0");
      assertThat(messages).contains(poolIndex + ": stat: num_calls_completed_ok = 0");
      assertThat(messages).contains(poolIndex + ": stat: num_calls_completed_err = 0");
      assertThat(messages).contains(poolIndex + ": stat: num_fallbacks_ok = 0");
      assertThat(messages).contains(poolIndex + ": stat: num_fallbacks_fail = 0");
      assertThat(messages).contains(poolIndex + ": stat: num_unresponsive_detections = 0");
      assertThat(messages).contains(poolIndex + ": stat: min_unresponsive_detection_time = 0");
      assertThat(messages).contains(poolIndex + ": stat: max_unresponsive_detection_time = 0");
      assertThat(messages).contains(poolIndex + ": stat: min_unresponsive_dropped_calls = 0");
      assertThat(messages).contains(poolIndex + ": stat: max_unresponsive_dropped_calls = 0");

      assertThat(logRecords.size()).isEqualTo(34);

    } finally {
      pool.shutdownNow();
      executorService.shutdownNow();
    }
  }

  @Test
  public void testUnresponsiveDetection() throws InterruptedException {
    // Watch debug messages.
    testLogger.setLevel(Level.FINER);
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
    int currentIndex = GcpManagedChannel.channelPoolIndex.get();
    String poolIndex = String.format("pool-%d", currentIndex);
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

    // Initial log messages count.
    int logCount = logRecords.size();

    MetricsRecord record = fakeRegistry.pollRecord();
    List<PointWithFunction<?>> metric =
        record.getMetrics().get(GcpMetricsConstants.METRIC_NUM_UNRESPONSIVE_DETECTIONS);
    assertThat(metric.size()).isEqualTo(1);
    assertThat(metric.get(0).value()).isEqualTo(1L);
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogLevel()).isEqualTo(Level.FINE);
    assertThat(lastLogMessage())
        .isEqualTo(
            poolIndex
                + ": stat: "
                + GcpMetricsConstants.METRIC_NUM_UNRESPONSIVE_DETECTIONS
                + " = 1");

    metric = record.getMetrics().get(GcpMetricsConstants.METRIC_MIN_UNRESPONSIVE_DROPPED_CALLS);
    assertThat(metric.size()).isEqualTo(1);
    assertThat(metric.get(0).value()).isEqualTo(3L);
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogLevel()).isEqualTo(Level.FINE);
    assertThat(lastLogMessage())
        .isEqualTo(
            poolIndex
                + ": stat: "
                + GcpMetricsConstants.METRIC_MIN_UNRESPONSIVE_DROPPED_CALLS
                + " = 3");

    metric = record.getMetrics().get(GcpMetricsConstants.METRIC_MAX_UNRESPONSIVE_DROPPED_CALLS);
    assertThat(metric.size()).isEqualTo(1);
    assertThat(metric.get(0).value()).isEqualTo(3L);
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogLevel()).isEqualTo(Level.FINE);
    assertThat(lastLogMessage())
        .isEqualTo(
            poolIndex
                + ": stat: "
                + GcpMetricsConstants.METRIC_MAX_UNRESPONSIVE_DROPPED_CALLS
                + " = 3");

    metric = record.getMetrics().get(GcpMetricsConstants.METRIC_MIN_UNRESPONSIVE_DETECTION_TIME);
    assertThat(metric.size()).isEqualTo(1);
    assertThat(metric.get(0).value()).isAtLeast(100L);
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogLevel()).isEqualTo(Level.FINE);
    assertThat(lastLogMessage())
        .matches(
            poolIndex
                + ": stat: "
                + GcpMetricsConstants.METRIC_MIN_UNRESPONSIVE_DETECTION_TIME
                + " = 1\\d\\d");

    metric = record.getMetrics().get(GcpMetricsConstants.METRIC_MAX_UNRESPONSIVE_DETECTION_TIME);
    assertThat(metric.size()).isEqualTo(1);
    assertThat(metric.get(0).value()).isAtLeast(100L);
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogLevel()).isEqualTo(Level.FINE);
    assertThat(lastLogMessage())
        .matches(
            poolIndex
                + ": stat: "
                + GcpMetricsConstants.METRIC_MAX_UNRESPONSIVE_DETECTION_TIME
                + " = 1\\d\\d");

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
    // Any subsequent deadline exceeded after 100ms must trigger the reconnection.
    chRef.activeStreamsCountDecr(startNanos, deStatus, false);
    assertEquals(2, idleCounter.get());
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogMessage())
        .matches(
            poolIndex
                + ": Channel 0 connection is unresponsive for 1\\d\\d ms and 4 deadline "
                + "exceeded calls. Forcing channel to idle state.");
    assertThat(lastLogLevel()).isEqualTo(Level.FINER);

    // The cumulative num_unresponsive_detections metric must become 2.
    metric = record.getMetrics().get(GcpMetricsConstants.METRIC_NUM_UNRESPONSIVE_DETECTIONS);
    assertThat(metric.size()).isEqualTo(1);
    assertThat(metric.get(0).value()).isEqualTo(2L);
    assertThat(logRecords.size()).isEqualTo(++logCount);
    // But the log metric count the detections since previous report for num_unresponsive_detections
    // in the logs. It is always delta in the logs, not cumulative.
    assertThat(lastLogMessage())
        .isEqualTo(
            poolIndex
                + ": stat: "
                + GcpMetricsConstants.METRIC_NUM_UNRESPONSIVE_DETECTIONS
                + " = 1");
    assertThat(lastLogLevel()).isEqualTo(Level.FINE);
    // If we log it again the cumulative metric value must remain unchanged.
    metric = record.getMetrics().get(GcpMetricsConstants.METRIC_NUM_UNRESPONSIVE_DETECTIONS);
    assertThat(metric.size()).isEqualTo(1);
    assertThat(metric.get(0).value()).isEqualTo(2L);
    assertThat(logRecords.size()).isEqualTo(++logCount);
    assertThat(lastLogLevel()).isEqualTo(Level.FINE);
    // But in the log it must post 0.
    assertThat(lastLogMessage())
        .isEqualTo(
            poolIndex
                + ": stat: "
                + GcpMetricsConstants.METRIC_NUM_UNRESPONSIVE_DETECTIONS
                + " = 0");
  }

  @Test
  public void testStateNotifications() throws InterruptedException {
    final AtomicBoolean immediateCallbackCalled = new AtomicBoolean();
    // Test callback is called when state doesn't match.
    gcpChannel.notifyWhenStateChanged(
        ConnectivityState.SHUTDOWN, () -> immediateCallbackCalled.set(true));

    TimeUnit.MILLISECONDS.sleep(2);

    assertThat(immediateCallbackCalled.get()).isTrue();

    // Subscribe for notification when leaving IDLE state.
    final AtomicReference<ConnectivityState> newState = new AtomicReference<>();

    final Runnable callback =
        new Runnable() {
          @Override
          public void run() {
            ConnectivityState state = gcpChannel.getState(false);
            newState.set(state);
            if (state.equals(ConnectivityState.IDLE)) {
              gcpChannel.notifyWhenStateChanged(ConnectivityState.IDLE, this);
            }
          }
        };

    gcpChannel.notifyWhenStateChanged(ConnectivityState.IDLE, callback);

    // Init connection to move out of the IDLE state.
    ConnectivityState currentState = gcpChannel.getState(true);
    // Make sure it was IDLE;
    assertThat(currentState).isEqualTo(ConnectivityState.IDLE);

    TimeUnit.MILLISECONDS.sleep(25);

    assertThat(newState.get())
        .isAnyOf(ConnectivityState.CONNECTING, ConnectivityState.TRANSIENT_FAILURE);
  }

  @Test
  public void testParallelStateNotifications() throws InterruptedException {
    AtomicReference<Throwable> exception = new AtomicReference<>();

    ExecutorService grpcExecutor =
        Executors.newCachedThreadPool(
            new ThreadFactoryBuilder()
                .setUncaughtExceptionHandler((t, e) -> exception.set(e))
                .build());

    ManagedChannelBuilder<?> builder = ManagedChannelBuilder.forAddress(TARGET, 443);
    GcpManagedChannel pool =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder)
                .executor(grpcExecutor)
                .withOptions(
                    GcpManagedChannelOptions.newBuilder()
                        .withChannelPoolOptions(
                            GcpChannelPoolOptions.newBuilder().setMaxSize(1).build())
                        .build())
                .build();

    // Pre-populate with a fake channel to control state changes.
    FakeManagedChannel channel = new FakeManagedChannel(grpcExecutor);
    ChannelRef ref = pool.new ChannelRef(channel, 0);
    pool.channelRefs.add(ref);

    // Always re-subscribe for notification to have constant callbacks flowing.
    final Runnable callback =
        new Runnable() {
          @Override
          public void run() {
            ConnectivityState state = pool.getState(false);
            pool.notifyWhenStateChanged(state, this);
          }
        };

    // Update channels state and subscribe for pool state changes in parallel.
    final ExecutorService executor =
        Executors.newCachedThreadPool(
            new ThreadFactoryBuilder().setNameFormat("gcp-mc-test-%d").build());

    for (int i = 0; i < 300; i++) {
      executor.execute(
          () -> {
            ConnectivityState currentState = pool.getState(true);
            pool.notifyWhenStateChanged(currentState, callback);
          });
      executor.execute(
          () -> {
            channel.setState(ConnectivityState.IDLE);
            channel.setState(ConnectivityState.CONNECTING);
          });
    }

    executor.shutdown();
    //noinspection StatementWithEmptyBody
    while (!executor.awaitTermination(10, TimeUnit.MILLISECONDS)) {}

    channel.setState(ConnectivityState.SHUTDOWN);
    pool.shutdownNow();

    // Make sure no exceptions were raised in callbacks.
    assertThat(exception.get()).isNull();

    grpcExecutor.shutdown();
  }

  @Test
  public void testParallelGetChannelRefWontExceedMaxSize() throws InterruptedException {
    resetGcpChannel();
    GcpChannelPoolOptions poolOptions =
        GcpChannelPoolOptions.newBuilder()
            .setMaxSize(2)
            .setConcurrentStreamsLowWatermark(0)
            .build();
    GcpManagedChannelOptions options =
        GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(poolOptions).build();
    gcpChannel =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder).withOptions(options).build();

    assertThat(gcpChannel.getNumberOfChannels()).isEqualTo(0);
    assertThat(gcpChannel.getStreamsLowWatermark()).isEqualTo(0);

    for (int i = 0; i < gcpChannel.getMaxSize() - 1; i++) {
      gcpChannel.getChannelRef(null);
    }

    assertThat(gcpChannel.getNumberOfChannels()).isEqualTo(gcpChannel.getMaxSize() - 1);

    Runnable requestChannel = () -> gcpChannel.getChannelRef(null);

    int requestCount = gcpChannel.getMaxSize() * 3;
    ExecutorService exec = Executors.newFixedThreadPool(requestCount);
    for (int i = 0; i < requestCount; i++) {
      exec.execute(requestChannel);
    }
    exec.shutdown();
    exec.awaitTermination(100, TimeUnit.MILLISECONDS);

    assertThat(gcpChannel.getNumberOfChannels()).isEqualTo(gcpChannel.getMaxSize());
  }

  @Test
  public void testParallelGetChannelRefWontExceedMaxSizeFromTheStart() throws InterruptedException {
    resetGcpChannel();
    GcpChannelPoolOptions poolOptions =
        GcpChannelPoolOptions.newBuilder()
            .setMaxSize(2)
            .setConcurrentStreamsLowWatermark(0)
            .build();
    GcpManagedChannelOptions options =
        GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(poolOptions).build();
    gcpChannel =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder).withOptions(options).build();

    assertThat(gcpChannel.getNumberOfChannels()).isEqualTo(0);
    assertThat(gcpChannel.getStreamsLowWatermark()).isEqualTo(0);

    Runnable requestChannel = () -> gcpChannel.getChannelRef(null);

    int requestCount = gcpChannel.getMaxSize() * 3;
    ExecutorService exec = Executors.newFixedThreadPool(requestCount);
    for (int i = 0; i < requestCount; i++) {
      exec.execute(requestChannel);
    }
    exec.shutdown();
    exec.awaitTermination(100, TimeUnit.MILLISECONDS);

    assertThat(gcpChannel.getNumberOfChannels()).isEqualTo(gcpChannel.getMaxSize());
  }

  @Test
  public void testAffinityKeysCleanup() throws InterruptedException {
    // Creating a pool with affinity keys cleanup options.
    final GcpManagedChannel pool =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(builder)
                .withOptions(
                    GcpManagedChannelOptions.newBuilder()
                        .withChannelPoolOptions(
                            GcpChannelPoolOptions.newBuilder()
                                .setMinSize(3)
                                .setMaxSize(3)
                                .setAffinityKeyLifetime(Duration.ofMillis(200))
                                .build())
                        .build())
                .build();

    final String liveKey = "live-key";
    ChannelRef ch0 = pool.getChannelRef(liveKey);
    assertThat(ch0.getId()).isEqualTo(0);
    ch0.activeStreamsCountIncr();
    ch0.activeStreamsCountIncr();

    ChannelRef ch1 = pool.getChannelRef(null);
    assertThat(ch1.getId()).isEqualTo(1);
    ch1.activeStreamsCountIncr();

    final String expKey = "expiring-key";
    ChannelRef ch2 = pool.getChannelRef(expKey);
    // Should bind on the fly to the least busy channel, which is 2.
    assertThat(ch2.getId()).isEqualTo(2);
    ch2.activeStreamsCountIncr();
    ch2.activeStreamsCountIncr();
    ch2.activeStreamsCountIncr();

    assertThat(pool.affinityKeyToChannelRef.keySet().size()).isEqualTo(2);
    assertThat(pool.affinityKeyToChannelRef.get(liveKey)).isEqualTo(ch0);
    assertThat(pool.affinityKeyToChannelRef.get(expKey)).isEqualTo(ch2);

    // Still picks channel 2 because of affinity even though it is the busiest.
    assertThat(pool.getChannelRef(expKey).getId()).isEqualTo(2);

    // Halfway through affinity lifetime we use the live key again.
    TimeUnit.MILLISECONDS.sleep(100);
    ch0 = pool.getChannelRef(liveKey);
    // Make sure affinity still works.
    assertThat(ch0.getId()).isEqualTo(0);

    // Wait the remaining time and check that there is still affinity for the live key
    // but no affinity for the expired key.

    TimeUnit.MILLISECONDS.sleep(150);

    assertThat(pool.affinityKeyToChannelRef.keySet().size()).isEqualTo(1);
    assertThat(pool.affinityKeyToChannelRef.get(liveKey)).isEqualTo(ch0);
    assertThat(pool.affinityKeyLastUsed.get(expKey)).isNull();

    // Should pick channel 1 as least busy because the affinity key was cleaned up.
    assertThat(pool.getChannelRef(expKey).getId()).isEqualTo(1);

    // Make sure affinity key gets cleaned up on unbind.
    pool.unbind(Collections.singletonList(expKey));
    assertThat(pool.affinityKeyLastUsed.size()).isEqualTo(1);
    assertThat(pool.affinityKeyLastUsed.get(expKey)).isNull();
  }

  static class FakeManagedChannel extends ManagedChannel {
    private ConnectivityState state = ConnectivityState.IDLE;
    private Runnable stateCallback;
    private final ExecutorService exec;

    FakeManagedChannel(ExecutorService exec) {
      this.exec = exec;
    }

    @Override
    public void enterIdle() {}

    @Override
    public ConnectivityState getState(boolean requestConnection) {
      return state;
    }

    public void setState(ConnectivityState state) {
      if (state.equals(this.state)) {
        return;
      }
      this.state = state;
      if (stateCallback != null) {
        exec.execute(stateCallback);
        stateCallback = null;
      }
    }

    @Override
    public void notifyWhenStateChanged(ConnectivityState source, Runnable callback) {
      if (!source.equals(state)) {
        exec.execute(callback);
        return;
      }
      stateCallback = callback;
    }

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
    public boolean awaitTermination(long timeout, TimeUnit unit) {
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

  static class FakeIdleCountingManagedChannel extends ManagedChannel {
    private final AtomicInteger idleCounter;

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
    public boolean awaitTermination(long timeout, TimeUnit unit) {
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

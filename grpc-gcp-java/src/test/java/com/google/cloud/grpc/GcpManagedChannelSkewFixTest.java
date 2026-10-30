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

import com.google.cloud.grpc.GcpManagedChannel.ChannelAffinityRef;
import com.google.cloud.grpc.GcpManagedChannel.ChannelRef;
import com.google.cloud.grpc.GcpManagedChannelOptions.ChannelPickStrategy;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpResiliencyOptions;
import com.google.cloud.grpc.proto.ApiConfig;
import com.google.common.util.concurrent.MoreExecutors;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class GcpManagedChannelSkewFixTest {
  private final ExecutorService executor = MoreExecutors.newDirectExecutorService();
  private GcpManagedChannel pool;

  @After
  public void tearDown() {
    if (pool != null) {
      pool.shutdownNow();
    }
    executor.shutdownNow();
  }

  @Test
  public void scaleDownRequiresThreeConsecutiveLowLoadChecks() {
    pool = newPool(6, 1);
    reserveOneStreamPerChannel();

    pool.checkScaleDown();
    pool.checkScaleDown();
    assertThat(pool.getNumberOfChannels()).isEqualTo(6);

    pool.checkScaleDown();
    assertThat(pool.getNumberOfChannels()).isEqualTo(4);
  }

  @Test
  public void scaleDownRemovesAtMostTwoChannelsPerCheck() {
    pool = newPool(48, 2);
    reserveOneStreamPerChannel();

    pool.checkScaleDown();
    pool.checkScaleDown();
    pool.checkScaleDown();

    assertThat(pool.getNumberOfChannels()).isEqualTo(46);
    assertThat(pool.removedChannelRefs).hasSize(2);
  }

  @Test
  public void powerOfTwoSamplesWithReplacementAndKeepsFirstTie() {
    pool = newPool(2, 2);
    ChannelRef first = pool.channelRefs.get(0);
    ChannelRef second = pool.channelRefs.get(1);
    AtomicInteger sample = new AtomicInteger();
    int[] indexes = {0, 1, 1, 0};
    pool.setCandidateIndexPickerForTest(ignored -> indexes[sample.getAndIncrement()]);

    assertThat(pool.pickFromCandidates(pool.channelRefs)).isSameInstanceAs(first);
    assertThat(pool.pickFromCandidates(pool.channelRefs)).isSameInstanceAs(second);
  }

  @Test
  public void pickFromCandidates_concurrentScaleDownShrink_doesNotThrowIndexOutOfBounds() {
    pool = newPool(2, 1);
    AtomicBoolean shrunk = new AtomicBoolean();
    pool.setCandidateIndexPickerForTest(
        size -> {
          if (shrunk.compareAndSet(false, true)) {
            pool.channelRefs.remove(size - 1);
          }
          return size - 1;
        });

    assertThat(pool.pickFromCandidates(pool.channelRefs)).isNotNull();
  }

  @Test
  public void pickLeastBusyNoFallback_linearScan_skipsInactiveChannels() {
    pool = newPool(2, 2, ChannelPickStrategy.LINEAR_SCAN);
    ChannelRef inactive = pool.channelRefs.get(0);
    ChannelRef active = pool.channelRefs.get(1);
    inactive.deactivateForTest();

    assertThat(pool.getChannelRef(null)).isSameInstanceAs(active);
  }

  @Test
  public void roundRobin_skipsInactiveChannels() {
    pool = newPool(2, 2);
    ChannelRef active = pool.channelRefs.get(0);
    pool.channelRefs.get(1).deactivateForTest();

    assertThat(pool.getChannelRefRoundRobin()).isSameInstanceAs(active);
  }

  @Test
  public void roundRobin_dynamicEmptyPool_createsFirstChannel() {
    GcpChannelPoolOptions options =
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(0)
            .setMinSize(0)
            .setMaxSize(2)
            .setDynamicScaling(10, 20, Duration.ofMinutes(1))
            .build();
    pool =
        (GcpManagedChannel)
            GcpManagedChannelBuilder.forDelegateBuilder(
                    new GcpManagedChannelTest.FakeManagedChannelBuilder(
                        () -> new GcpManagedChannelTest.FakeManagedChannel(executor)))
                .withOptions(
                    GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(options).build())
                .build();

    assertThat(pool.channelRefs).isEmpty();
    assertThat(pool.getChannelRefRoundRobin()).isNotNull();
    assertThat(pool.channelRefs).hasSize(1);
  }

  @Test
  public void fallbackPicker_skipsInactiveChannels() {
    pool = newPoolWithFallback();
    ChannelRef inactive = pool.channelRefs.get(0);
    ChannelRef active = pool.channelRefs.get(1);
    inactive.deactivateForTest();
    pool.fallbackMapForTest().put(active.getId(), new java.util.concurrent.ConcurrentHashMap<>());

    assertThat(pool.getChannelRef(null)).isSameInstanceAs(active);
  }

  @Test
  public void activeStreamExtrema_skipInactiveChannels() {
    pool = newPool(2, 2);
    ChannelRef inactive = pool.channelRefs.get(0);
    ChannelRef active = pool.channelRefs.get(1);
    inactive.setActiveStreamsForTest(99);
    active.setActiveStreamsForTest(3);
    inactive.deactivateForTest();

    assertThat(pool.getMinActiveStreams()).isEqualTo(3);
    assertThat(pool.getMaxActiveStreams()).isEqualTo(3);
  }

  @Test
  public void dynamicPowerOfTwoPickDoesNotReadLegacyWatermarkLoad() {
    GcpChannelPoolOptions options =
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(2)
            .setMinSize(2)
            .setMaxSize(4)
            .setDynamicScaling(10, 20, Duration.ofMinutes(1))
            .setChannelPickStrategy(ChannelPickStrategy.POWER_OF_TWO)
            .build();
    pool =
        new GcpManagedChannel(
            new GcpManagedChannelTest.FakeManagedChannelBuilder(
                () -> new GcpManagedChannelTest.FakeManagedChannel(executor)),
            ApiConfig.getDefaultInstance(),
            GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(options).build()) {
          @Override
          public int getMaxActiveStreams() {
            throw new AssertionError("legacy watermark load must be lazy");
          }
        };

    assertThat(pool.getChannelRef(null)).isNotNull();
  }

  @Test
  public void affinityReferenceStaysStickyUntilDelegateShutdown() {
    pool = newPool(4, 2);
    reserveOneStreamPerChannel();
    ChannelRef victim = pool.channelRefs.get(0);
    ChannelAffinityRef handle = new ChannelAffinityRef();
    handle.setChannelIdForTest(victim.getId());

    pool.checkScaleDown();
    pool.checkScaleDown();
    pool.checkScaleDown();
    assertThat(pool.getChannelRefByAffinityRef(handle)).isSameInstanceAs(victim);

    victim.getChannel().shutdownNow();
    assertThat(pool.getChannelRefByAffinityRef(handle)).isNotSameInstanceAs(victim);
  }

  private GcpManagedChannel newPool(int initial, int minimum) {
    return newPool(initial, minimum, ChannelPickStrategy.POWER_OF_TWO);
  }

  private GcpManagedChannel newPool(
      int initial, int minimum, ChannelPickStrategy channelPickStrategy) {
    GcpChannelPoolOptions options =
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(initial)
            .setMinSize(minimum)
            .setMaxSize(initial)
            .setDynamicScaling(10, 20, Duration.ofMinutes(1))
            .setScaleDownConsecutiveLowLoadChecks(3)
            .setMaxScaleDownChannels(2)
            .setChannelPickStrategy(channelPickStrategy)
            .build();
    return (GcpManagedChannel)
        GcpManagedChannelBuilder.forDelegateBuilder(
                new GcpManagedChannelTest.FakeManagedChannelBuilder(
                    () -> new GcpManagedChannelTest.FakeManagedChannel(executor)))
            .withOptions(
                GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(options).build())
            .build();
  }

  private GcpManagedChannel newPoolWithFallback() {
    GcpChannelPoolOptions options =
        GcpChannelPoolOptions.newBuilder().setInitSize(2).setMinSize(2).setMaxSize(2).build();
    return (GcpManagedChannel)
        GcpManagedChannelBuilder.forDelegateBuilder(
                new GcpManagedChannelTest.FakeManagedChannelBuilder(
                    () -> new GcpManagedChannelTest.FakeManagedChannel(executor)))
            .withOptions(
                GcpManagedChannelOptions.newBuilder()
                    .withChannelPoolOptions(options)
                    .withResiliencyOptions(
                        GcpResiliencyOptions.newBuilder().setNotReadyFallback(true).build())
                    .build())
            .build();
  }

  private void reserveOneStreamPerChannel() {
    for (ChannelRef channelRef : pool.channelRefs) {
      channelRef.activeStreamsCountIncr();
    }
  }
}

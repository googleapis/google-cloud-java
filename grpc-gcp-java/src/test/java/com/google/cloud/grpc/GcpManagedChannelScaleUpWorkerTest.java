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
import com.google.common.util.concurrent.MoreExecutors;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class GcpManagedChannelScaleUpWorkerTest {
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
  public void scaleUpAddsAtMostThirtyPercent() {
    pool = newPool(10, 30);
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(99);

    hot.activeStreamsCountIncr();

    await().atMost(Duration.ofSeconds(5)).until(() -> pool.getNumberOfChannels() == 13);
  }

  @Test
  public void scaleUpUsesTwoChannelFloorForSmallPool() {
    pool = newPool(1, 5);
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(9);

    hot.activeStreamsCountIncr();

    await().atMost(Duration.ofSeconds(5)).until(() -> pool.getNumberOfChannels() == 3);
  }

  @Test
  public void hottestChannelCanSignalBeforePoolAverageCrossesLimit() {
    pool = newPool(4, 8);
    pool.channelRefs.get(0).setActiveStreamsForTest(5);
    pool.channelRefs.get(1).setActiveStreamsForTest(3);
    pool.channelRefs.get(2).setActiveStreamsForTest(2);
    pool.channelRefs.get(3).setActiveStreamsForTest(2);

    pool.channelRefs.get(0).activeStreamsCountIncr();

    await().atMost(Duration.ofSeconds(5)).until(() -> pool.getNumberOfChannels() == 5);
  }

  @Test
  public void poolAverageCanSignalWhenSelectedChannelIsBelowMaximum() {
    pool = newPool(2, 4);
    ChannelRef selected = pool.channelRefs.get(0);
    pool.channelRefs.get(1).setActiveStreamsForTest(12);

    selected.activeStreamsCountIncr();

    await().atMost(Duration.ofSeconds(5)).until(() -> pool.getNumberOfChannels() == 4);
  }

  @Test
  public void scaleUpBuildsOffCallerThread() {
    AtomicInteger builds = new AtomicInteger();
    AtomicReference<String> scaleUpThread = new AtomicReference<>();
    GcpManagedChannelTest.FakeManagedChannelBuilder delegate =
        new GcpManagedChannelTest.FakeManagedChannelBuilder(
            () -> {
              if (builds.incrementAndGet() > 2) {
                scaleUpThread.set(Thread.currentThread().getName());
              }
              return new GcpManagedChannelTest.FakeManagedChannel(executor);
            });
    pool = newPool(2, 4, delegate);
    String callerThread = Thread.currentThread().getName();

    for (int i = 0; i < 7; i++) {
      pool.channelRefs.get(0).activeStreamsCountIncr();
    }

    await().atMost(Duration.ofSeconds(5)).until(() -> scaleUpThread.get() != null);
    assertThat(scaleUpThread.get()).isNotEqualTo(callerThread);
  }

  @Test
  public void burstSignalsCoalesceWhileWorkerIsBusy() throws Exception {
    AtomicInteger builds = new AtomicInteger();
    CountDownLatch buildStarted = new CountDownLatch(1);
    CountDownLatch releaseBuild = new CountDownLatch(1);
    GcpManagedChannelTest.FakeManagedChannelBuilder delegate =
        new GcpManagedChannelTest.FakeManagedChannelBuilder(
            () -> {
              if (builds.incrementAndGet() == 3) {
                buildStarted.countDown();
                try {
                  releaseBuild.await(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
                }
              }
              return new GcpManagedChannelTest.FakeManagedChannel(executor);
            });
    pool = newPool(2, 10, delegate);
    AtomicLong clock = new AtomicLong(1);
    pool.setNanoClock(clock::get);
    ChannelRef hot = pool.channelRefs.get(0);
    for (int i = 0; i < 7; i++) {
      hot.activeStreamsCountIncr();
    }
    assertThat(buildStarted.await(5, TimeUnit.SECONDS)).isTrue();

    for (int i = 7; i < 30; i++) {
      hot.activeStreamsCountIncr();
    }
    clock.incrementAndGet();
    releaseBuild.countDown();

    await().atMost(Duration.ofSeconds(5)).until(() -> pool.getNumberOfChannels() == 5);
    await()
        .during(Duration.ofMillis(100))
        .atMost(Duration.ofSeconds(1))
        .until(() -> pool.getNumberOfChannels() == 5);
  }

  @Test
  public void buildExceptionClosesPartialBatchAndFutureSignalStillScales() {
    AtomicInteger builds = new AtomicInteger();
    AtomicLong clock = new AtomicLong(1);
    AtomicReference<GcpManagedChannelTest.FakeManagedChannel> partialBuild =
        new AtomicReference<>();
    GcpManagedChannelTest.FakeManagedChannelBuilder delegate =
        new GcpManagedChannelTest.FakeManagedChannelBuilder(
            () -> {
              int build = builds.incrementAndGet();
              if (build == 3) {
                GcpManagedChannelTest.FakeManagedChannel channel =
                    new GcpManagedChannelTest.FakeManagedChannel(executor);
                partialBuild.set(channel);
                return channel;
              }
              if (build == 4) {
                throw new AssertionError("build failed");
              }
              return new GcpManagedChannelTest.FakeManagedChannel(executor);
            });
    pool = newPool(2, 6, delegate);
    pool.setNanoClock(clock::get);
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(9);

    hot.activeStreamsCountIncr();

    await().atMost(Duration.ofSeconds(5)).until(() -> builds.get() == 4);
    await().atMost(Duration.ofSeconds(5)).until(() -> partialBuild.get().isShutdown());
    clock.incrementAndGet();
    hot.activeStreamsCountIncr();
    await().atMost(Duration.ofSeconds(5)).until(() -> pool.getNumberOfChannels() == 4);
  }

  @Test
  public void scaleUpCooldownIsHonored() {
    AtomicLong clock = new AtomicLong(100);
    pool = newPool(2, 6, Duration.ofNanos(10));
    pool.setNanoClock(clock::get);
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(20);

    hot.activeStreamsCountIncr();
    await().atMost(Duration.ofSeconds(5)).until(() -> pool.getNumberOfChannels() == 4);

    hot.activeStreamsCountIncr();
    await()
        .during(Duration.ofMillis(100))
        .atMost(Duration.ofSeconds(1))
        .until(() -> pool.getNumberOfChannels() == 4);

    clock.addAndGet(11);
    hot.activeStreamsCountIncr();
    await().atMost(Duration.ofSeconds(5)).until(() -> pool.getNumberOfChannels() == 6);
  }

  @Test
  public void scaleUpClampsToMaxSize() {
    pool = newPool(4, 5);
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(30);

    hot.activeStreamsCountIncr();

    await().atMost(Duration.ofSeconds(5)).until(() -> pool.getNumberOfChannels() == 5);
  }

  @Test
  public void scaleUpCountsOnlyActiveChannels() {
    pool = newPool(2, 5);
    ChannelRef hot = pool.channelRefs.get(0);
    pool.channelRefs.get(1).deactivateForTest();
    hot.setActiveStreamsForTest(6);

    hot.activeStreamsCountIncr();

    await().atMost(Duration.ofSeconds(1)).until(() -> pool.getNumberOfChannels() == 4);
  }

  @Test
  public void shutdownDuringScaleUpClosesUnpublishedChannel() throws Exception {
    AtomicInteger builds = new AtomicInteger();
    CountDownLatch buildStarted = new CountDownLatch(1);
    CountDownLatch releaseBuild = new CountDownLatch(1);
    AtomicReference<GcpManagedChannelTest.FakeManagedChannel> unpublished = new AtomicReference<>();
    GcpManagedChannelTest.FakeManagedChannelBuilder delegate =
        new GcpManagedChannelTest.FakeManagedChannelBuilder(
            () -> {
              if (builds.incrementAndGet() == 3) {
                GcpManagedChannelTest.FakeManagedChannel channel =
                    new GcpManagedChannelTest.FakeManagedChannel(executor);
                unpublished.set(channel);
                buildStarted.countDown();
                try {
                  releaseBuild.await(5, TimeUnit.SECONDS);
                } catch (InterruptedException failure) {
                  Thread.currentThread().interrupt();
                }
                return channel;
              }
              return new GcpManagedChannelTest.FakeManagedChannel(executor);
            });
    pool = newPool(2, 3, delegate);
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(9);
    hot.activeStreamsCountIncr();
    assertThat(buildStarted.await(5, TimeUnit.SECONDS)).isTrue();

    pool.shutdownNow();
    releaseBuild.countDown();

    await().atMost(Duration.ofSeconds(5)).until(() -> unpublished.get().isShutdown());
    assertThat(pool.getNumberOfChannels()).isEqualTo(2);
  }

  @Test
  public void shutdownDuringScaleUpClosesChannelPublishingUnderPoolMonitor() throws Exception {
    AtomicInteger builds = new AtomicInteger();
    CountDownLatch publishing = new CountDownLatch(1);
    CountDownLatch releasePublish = new CountDownLatch(1);
    AtomicReference<GcpManagedChannelTest.FakeManagedChannel> publishingChannel =
        new AtomicReference<>();
    GcpManagedChannelTest.FakeManagedChannelBuilder delegate =
        new GcpManagedChannelTest.FakeManagedChannelBuilder(
            () -> {
              if (builds.incrementAndGet() == 3) {
                GcpManagedChannelTest.FakeManagedChannel channel =
                    new GcpManagedChannelTest.FakeManagedChannel(executor) {
                      @Override
                      public io.grpc.ConnectivityState getState(boolean requestConnection) {
                        publishing.countDown();
                        try {
                          releasePublish.await(5, TimeUnit.SECONDS);
                        } catch (InterruptedException failure) {
                          Thread.currentThread().interrupt();
                        }
                        return super.getState(requestConnection);
                      }
                    };
                publishingChannel.set(channel);
                return channel;
              }
              return new GcpManagedChannelTest.FakeManagedChannel(executor);
            });
    pool = newPool(2, 3, delegate);
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(9);
    hot.activeStreamsCountIncr();
    assertThat(publishing.await(5, TimeUnit.SECONDS)).isTrue();

    AtomicReference<Thread> shutdownThread = new AtomicReference<>();
    ExecutorService shutdownExecutor =
        Executors.newSingleThreadExecutor(
            command -> {
              Thread thread = new Thread(command);
              shutdownThread.set(thread);
              return thread;
            });
    try {
      Future<?> shutdown = shutdownExecutor.submit(pool::shutdown);
      await()
          .atMost(Duration.ofSeconds(5))
          .until(
              () ->
                  shutdownThread.get() != null
                      && shutdownThread.get().getState() == Thread.State.BLOCKED);
      releasePublish.countDown();
      shutdown.get(5, TimeUnit.SECONDS);
      await().atMost(Duration.ofSeconds(5)).until(() -> publishingChannel.get().isShutdown());
      assertThat(pool.channelRefs).hasSize(3);
      assertThat(
              pool.channelRefs.stream()
                  .allMatch(channelRef -> channelRef.getChannel().isShutdown()))
          .isTrue();
    } finally {
      releasePublish.countDown();
      shutdownExecutor.shutdownNow();
    }
  }

  @Test
  public void removedChannelReadersTolerateConcurrentMutation() throws Exception {
    pool = newPool(2, 3);
    ChannelRef removed = pool.channelRefs.get(0);
    ExecutorService mutator = Executors.newSingleThreadExecutor();
    AtomicReference<Throwable> failure = new AtomicReference<>();
    CountDownLatch started = new CountDownLatch(1);
    Future<?> mutation =
        mutator.submit(
            () -> {
              started.countDown();
              try {
                for (int i = 0; i < 200; i++) {
                  pool.removedChannelRefs.add(removed);
                  pool.removedChannelRefs.remove(removed);
                }
              } catch (Throwable throwable) {
                failure.set(throwable);
              }
            });
    try {
      assertThat(started.await(1, TimeUnit.SECONDS)).isTrue();
      for (int i = 0; i < 200; i++) {
        pool.isShutdown();
        pool.isTerminated();
        pool.awaitTermination(0, TimeUnit.NANOSECONDS);
      }
      await().atMost(Duration.ofSeconds(1)).until(mutation::isDone);
      assertThat(failure.get()).isNull();
    } finally {
      mutator.shutdownNow();
    }
  }

  private GcpManagedChannel newPool(int initial, int maximum) {
    return newPool(initial, maximum, Duration.ofNanos(1));
  }

  private GcpManagedChannel newPool(int initial, int maximum, Duration scaleUpCooldown) {
    return newPool(
        initial,
        maximum,
        new GcpManagedChannelTest.FakeManagedChannelBuilder(
            () -> new GcpManagedChannelTest.FakeManagedChannel(executor)),
        scaleUpCooldown);
  }

  private GcpManagedChannel newPool(
      int initial, int maximum, GcpManagedChannelTest.FakeManagedChannelBuilder delegate) {
    return newPool(initial, maximum, delegate, Duration.ofNanos(1));
  }

  private GcpManagedChannel newPool(
      int initial,
      int maximum,
      GcpManagedChannelTest.FakeManagedChannelBuilder delegate,
      Duration scaleUpCooldown) {
    GcpChannelPoolOptions options =
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(initial)
            .setMinSize(initial)
            .setMaxSize(maximum)
            .setDynamicScaling(2, 5, Duration.ofMinutes(1))
            .setScaleUpCooldown(scaleUpCooldown)
            .setMaxScaleUpPercent(30)
            .build();
    return (GcpManagedChannel)
        GcpManagedChannelBuilder.forDelegateBuilder(delegate)
            .withOptions(
                GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(options).build())
            .build();
  }
}

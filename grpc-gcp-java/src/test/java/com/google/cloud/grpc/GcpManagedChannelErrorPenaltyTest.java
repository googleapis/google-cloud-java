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

import com.google.cloud.grpc.GcpManagedChannel.ChannelRef;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Status;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
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
public final class GcpManagedChannelErrorPenaltyTest {
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
  public void retryableErrorsAddBoundedDecayingPickerLoad() {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool(2, 2, 2, 20, 10, Duration.ofSeconds(10));
    pool.setNanoClock(clock::get);
    ChannelRef penalized = pool.channelRefs.get(0);
    ChannelRef healthy = pool.channelRefs.get(1);
    healthy.setActiveStreamsForTest(12);

    completeWithError(penalized, clock.get(), Status.UNAVAILABLE);
    completeWithError(penalized, clock.get(), Status.RESOURCE_EXHAUSTED);
    assertThat(penalized.currentErrorPenalty()).isEqualTo(20);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(20);

    AtomicInteger sample = new AtomicInteger();
    pool.setCandidateIndexPickerForTest(ignored -> sample.getAndIncrement() % 2);
    assertThat(pool.pickFromCandidates(pool.channelRefs)).isSameInstanceAs(healthy);

    int previousPenalty = penalized.currentErrorPenalty();
    clock.addAndGet(Duration.ofSeconds(2).toNanos());
    assertThat(penalized.currentErrorPenalty()).isEqualTo(16);
    assertThat(penalized.currentErrorPenalty()).isAtMost(previousPenalty);
    previousPenalty = penalized.currentErrorPenalty();

    clock.addAndGet(Duration.ofSeconds(3).toNanos());
    assertThat(penalized.currentErrorPenalty()).isEqualTo(10);
    assertThat(penalized.currentErrorPenalty()).isAtMost(previousPenalty);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(20);

    sample.set(0);
    assertThat(pool.pickFromCandidates(pool.channelRefs)).isSameInstanceAs(penalized);
    pool.setCandidateIndexPickerForTest(ignored -> 1);
    assertThat(pool.pickFromCandidates(pool.channelRefs)).isSameInstanceAs(healthy);

    previousPenalty = penalized.currentErrorPenalty();
    clock.addAndGet(Duration.ofSeconds(4).toNanos());
    assertThat(penalized.currentErrorPenalty()).isEqualTo(2);
    assertThat(penalized.currentErrorPenalty()).isAtMost(previousPenalty);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(20);

    clock.addAndGet(Duration.ofSeconds(1).toNanos());
    assertThat(penalized.currentErrorPenalty()).isEqualTo(0);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(0);
  }

  @Test
  public void linearDecayHandlesMultiplicationOverflow() {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool(2, Integer.MAX_VALUE, Integer.MAX_VALUE, Duration.ofNanos(Long.MAX_VALUE));
    pool.setNanoClock(clock::get);
    ChannelRef channel = pool.channelRefs.get(0);
    completeWithError(channel, clock.get(), Status.UNAVAILABLE);

    clock.addAndGet(Long.MAX_VALUE / 2);

    assertThat(channel.currentErrorPenalty()).isEqualTo(1_073_741_824);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(Integer.MAX_VALUE);

    clock.addAndGet(Long.MAX_VALUE - Long.MAX_VALUE / 2 - 1);
    assertThat(channel.currentErrorPenalty()).isEqualTo(1);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(Integer.MAX_VALUE);

    clock.incrementAndGet();
    assertThat(channel.currentErrorPenalty()).isEqualTo(0);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(0);
  }

  @Test
  public void retryableErrorDuringDecayRestoresAccumulatedPenalty() {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool(2, 10, 5, Duration.ofSeconds(10));
    pool.setNanoClock(clock::get);
    ChannelRef channel = pool.channelRefs.get(0);
    completeWithError(channel, clock.get(), Status.UNAVAILABLE);
    clock.addAndGet(Duration.ofSeconds(5).toNanos());
    assertThat(channel.currentErrorPenalty()).isEqualTo(3);

    completeWithError(channel, clock.get(), Status.UNAVAILABLE);

    assertThat(channel.currentErrorPenalty()).isEqualTo(10);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(10);
  }

  @Test
  public void penaltyStepSaturatesWithoutIntegerOverflow() {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool(2, Integer.MAX_VALUE, Integer.MAX_VALUE, Duration.ofSeconds(5));
    pool.setNanoClock(clock::get);
    ChannelRef channel = pool.channelRefs.get(0);

    completeWithError(channel, clock.get(), Status.UNAVAILABLE);
    completeWithError(channel, clock.get(), Status.RESOURCE_EXHAUSTED);

    assertThat(channel.currentErrorPenalty()).isEqualTo(Integer.MAX_VALUE);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(Integer.MAX_VALUE);
  }

  @Test
  public void pickerLoadSaturatesWithoutIntegerOverflow() {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool(2, Integer.MAX_VALUE, Integer.MAX_VALUE, Duration.ofSeconds(5));
    pool.setNanoClock(clock::get);
    ChannelRef channel = pool.channelRefs.get(0);
    completeWithError(channel, clock.get(), Status.UNAVAILABLE);
    channel.setActiveStreamsForTest(1);

    assertThat(channel.getPickerLoad()).isEqualTo(Integer.MAX_VALUE);
  }

  @Test
  public void aggregatePenaltyUsesLongWithoutOverflow() {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool(2, Integer.MAX_VALUE, Integer.MAX_VALUE, Duration.ofSeconds(5));
    pool.setNanoClock(clock::get);

    completeWithError(pool.channelRefs.get(0), clock.get(), Status.UNAVAILABLE);
    completeWithError(pool.channelRefs.get(1), clock.get(), Status.UNAVAILABLE);

    assertThat(totalErrorPenaltyLoad()).isEqualTo(2L * Integer.MAX_VALUE);
  }

  @Test
  public void expiredPenaltyReplacementUsesOneNetAggregateDelta() {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool(2, 10, 5, Duration.ofSeconds(5));
    pool.setNanoClock(clock::get);
    ChannelRef channel = pool.channelRefs.get(0);
    completeWithError(channel, clock.get(), Status.UNAVAILABLE);
    completeWithError(channel, clock.get(), Status.UNAVAILABLE);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(10);

    clock.addAndGet(Duration.ofSeconds(6).toNanos());
    completeWithError(channel, clock.get(), Status.UNAVAILABLE);

    assertThat(channel.currentErrorPenalty()).isEqualTo(5);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(5);
  }

  @Test
  public void concurrentExpirySubtractsAggregateExactlyOnce() throws Exception {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool();
    pool.setNanoClock(clock::get);
    ChannelRef channel = pool.channelRefs.get(0);
    completeWithError(channel, clock.get(), Status.UNAVAILABLE);
    clock.addAndGet(Duration.ofSeconds(6).toNanos());
    CountDownLatch start = new CountDownLatch(1);
    ExecutorService readers = Executors.newFixedThreadPool(8);
    try {
      List<Future<Integer>> results = new ArrayList<>();
      for (int i = 0; i < 100; i++) {
        results.add(
            readers.submit(
                () -> {
                  start.await();
                  return channel.currentErrorPenalty();
                }));
      }
      start.countDown();
      for (Future<Integer> result : results) {
        assertThat(result.get()).isEqualTo(0);
      }
      assertThat(totalErrorPenaltyLoad()).isEqualTo(0);
    } finally {
      start.countDown();
      readers.shutdownNow();
    }
  }

  @Test
  public void nonRetryableErrorsAddNoPenalty() {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool();
    pool.setNanoClock(clock::get);
    ChannelRef channel = pool.channelRefs.get(0);

    completeWithError(channel, clock.get(), Status.OK);
    completeWithError(channel, clock.get(), Status.INTERNAL);
    completeWithError(channel, clock.get(), Status.DEADLINE_EXCEEDED);
    completeWithError(channel, clock.get(), Status.CANCELLED);

    assertThat(channel.currentErrorPenalty()).isEqualTo(0);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(0);
  }

  @Test
  public void negativeAndZeroDurationRejected() {
    assertThrows(
        IllegalArgumentException.class,
        () -> GcpChannelPoolOptions.newBuilder().setErrorPenaltyDuration(Duration.ofSeconds(-1)));
    assertThrows(
        IllegalArgumentException.class,
        () -> GcpChannelPoolOptions.newBuilder().setErrorPenaltyDuration(Duration.ZERO));
  }

  @Test
  public void penaltyContributesToScaleUpSignal() {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool(2, 2, 3, 2, 2, Duration.ofSeconds(5));
    pool.setNanoClock(clock::get);
    ChannelRef channel = pool.channelRefs.get(0);
    channel.activeStreamsCountIncr();
    channel.activeStreamsCountIncr();

    channel.activeStreamsCountDecr(clock.get(), Status.UNAVAILABLE, false);

    await().atMost(Duration.ofSeconds(5)).until(() -> pool.getNumberOfChannels() == 3);
  }

  @Test
  public void fullyPenalizedIdlePoolTriggersOneBoundedScaleUp() {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool(2, 2, 6, 2, 2, Duration.ofMinutes(1));
    pool.setNanoClock(clock::get);
    ChannelRef first = pool.channelRefs.get(0);
    ChannelRef second = pool.channelRefs.get(1);

    completeWithError(first, clock.get(), Status.UNAVAILABLE);
    completeWithError(second, clock.get(), Status.UNAVAILABLE);

    await().atMost(Duration.ofSeconds(5)).until(() -> pool.getNumberOfChannels() == 4);
    assertThat(first.getActiveStreamsCount()).isEqualTo(0);
    assertThat(second.getActiveStreamsCount()).isEqualTo(0);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(4);

    clock.addAndGet(Duration.ofSeconds(30).toNanos());
    assertThat(first.currentErrorPenalty()).isEqualTo(1);
    assertThat(second.currentErrorPenalty()).isEqualTo(1);
    first.activeStreamsCountIncr();
    first.activeStreamsCountDecr(clock.get(), Status.OK, false);
    await()
        .during(Duration.ofMillis(200))
        .atMost(Duration.ofSeconds(2))
        .until(() -> pool.getNumberOfChannels() == 4);

    clock.addAndGet(Duration.ofSeconds(30).toNanos());
    assertThat(first.currentErrorPenalty()).isEqualTo(0);
    assertThat(second.currentErrorPenalty()).isEqualTo(0);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(0);
    second.activeStreamsCountIncr();
    second.activeStreamsCountDecr(clock.get(), Status.OK, false);
    await()
        .during(Duration.ofMillis(200))
        .atMost(Duration.ofSeconds(2))
        .until(() -> pool.getNumberOfChannels() == 4);
  }

  @Test
  public void scaleDownClearsRemovedChannelPenalty() {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool(1, 10, 5, Duration.ofSeconds(5));
    pool.setNanoClock(clock::get);
    ChannelRef removed = pool.channelRefs.get(0);
    completeWithError(removed, clock.get(), Status.UNAVAILABLE);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(5);

    pool.checkScaleDown();
    pool.checkScaleDown();
    pool.checkScaleDown();

    assertThat(removed.isActive()).isFalse();
    assertThat(removed.currentErrorPenalty()).isEqualTo(0);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(0);
  }

  @Test
  public void rpcCompletionAfterScaleDownDoesNotLeakPenalty() throws Exception {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool(1, 10, 5, Duration.ofSeconds(5));
    pool.setNanoClock(clock::get);
    ChannelRef victim = pool.channelRefs.get(0);
    victim.activeStreamsCountIncr();
    CountDownLatch completionStarted = new CountDownLatch(1);
    AtomicReference<Thread> completionThread = new AtomicReference<>();
    ExecutorService completionExecutor =
        Executors.newSingleThreadExecutor(
            command -> {
              Thread thread = new Thread(command, "penalty-completion");
              completionThread.set(thread);
              return thread;
            });
    try {
      Future<?> completion;
      synchronized (victim) {
        completion =
            completionExecutor.submit(
                () -> {
                  completionStarted.countDown();
                  victim.activeStreamsCountDecr(clock.get(), Status.UNAVAILABLE, false);
                });
        await().atMost(Duration.ofSeconds(5)).until(() -> completionStarted.getCount() == 0);
        await()
            .atMost(Duration.ofSeconds(5))
            .until(
                () ->
                    completionThread.get() != null
                        && completionThread.get().getState() == Thread.State.BLOCKED);

        pool.checkScaleDown();
        pool.checkScaleDown();
        pool.checkScaleDown();

        assertThat(victim.isActive()).isFalse();
        assertThat(pool.channelRefs).doesNotContain(victim);
        assertThat(totalErrorPenaltyLoad()).isEqualTo(0);
      }

      completion.get(5, TimeUnit.SECONDS);
      assertThat(victim.currentErrorPenalty()).isEqualTo(0);
      assertThat(totalErrorPenaltyLoad()).isEqualTo(0);

      clock.addAndGet(Duration.ofHours(1).toNanos());
      pool.checkScaleDown();
      assertThat(totalErrorPenaltyLoad()).isEqualTo(0);
    } finally {
      completionExecutor.shutdownNow();
    }
  }

  @Test
  public void leastLoadedActiveChannelReadsClockOncePerScan() throws Exception {
    AtomicLong clockReads = new AtomicLong();
    pool = newPool(4, 2, 4, 10, 5, Duration.ofSeconds(5));
    pool.setNanoClock(
        () -> {
          clockReads.incrementAndGet();
          return 1_000;
        });
    ChannelRef penalized = pool.channelRefs.get(0);
    completeWithError(penalized, 1_000, Status.UNAVAILABLE);
    for (ChannelRef channelRef : pool.channelRefs) {
      if (channelRef != penalized) {
        channelRef.setActiveStreamsForTest(10);
      }
    }
    clockReads.set(0);
    Method leastLoaded =
        GcpManagedChannel.class.getDeclaredMethod("leastLoadedActiveChannel", List.class);
    leastLoaded.setAccessible(true);

    leastLoaded.invoke(pool, pool.channelRefs);

    assertThat(clockReads.get()).isEqualTo(1);
  }

  @Test
  public void powerOfTwoReadsClockOncePerPick() {
    AtomicLong clockReads = new AtomicLong();
    pool = newPool();
    pool.setNanoClock(
        () -> {
          clockReads.incrementAndGet();
          return 1_000;
        });
    completeWithError(pool.channelRefs.get(0), 1_000, Status.UNAVAILABLE);
    completeWithError(pool.channelRefs.get(1), 1_000, Status.UNAVAILABLE);
    AtomicInteger sample = new AtomicInteger();
    pool.setCandidateIndexPickerForTest(ignored -> sample.getAndIncrement() % 2);
    clockReads.set(0);

    pool.pickFromCandidates(pool.channelRefs);

    assertThat(clockReads.get()).isEqualTo(1);
  }

  @Test
  public void pickerAndScaleUpReadsDoNotClearPenaltyUnderPoolMonitor() throws Exception {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool(2, 2, 3, 10, 5, Duration.ofSeconds(5));
    pool.setNanoClock(clock::get);
    ChannelRef channel = pool.channelRefs.get(0);
    ChannelRef other = pool.channelRefs.get(1);
    completeWithError(channel, clock.get(), Status.UNAVAILABLE);
    clock.addAndGet(Duration.ofSeconds(6).toNanos());
    channel.deactivateForTest();
    other.deactivateForTest();
    Field active = ChannelRef.class.getDeclaredField("active");
    active.setAccessible(true);
    AtomicInteger sample = new AtomicInteger();
    pool.setCandidateIndexPickerForTest(
        ignored -> {
          int index = sample.getAndIncrement();
          if (index == 0) {
            try {
              active.setBoolean(channel, true);
              active.setBoolean(other, true);
            } catch (IllegalAccessException failure) {
              throw new AssertionError(failure);
            }
          }
          return index % 2;
        });
    Method pickerLoad =
        GcpManagedChannel.class.getDeclaredMethod("pickerLoad", List.class, long.class);
    pickerLoad.setAccessible(true);

    synchronized (pool) {
      assertThat((long) pickerLoad.invoke(pool, pool.channelRefs, clock.get())).isEqualTo(0);
      assertThat(totalErrorPenaltyLoad()).isEqualTo(5);
      pool.getChannelRefRoundRobin();
      assertThat(totalErrorPenaltyLoad()).isEqualTo(5);
      channel.activeStreamsCountIncr();
      assertThat(totalErrorPenaltyLoad()).isEqualTo(5);
      channel.activeStreamsCountDecr(clock.get(), Status.OK, false);
    }

    assertThat(channel.currentErrorPenalty()).isEqualTo(0);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(0);
  }

  @Test
  public void clearedExpirySentinelWinsWithNegativeClock() throws Exception {
    pool = newPool();
    pool.setNanoClock(() -> -1);
    ChannelRef channel = pool.channelRefs.get(0);
    Field penaltyLoad = ChannelRef.class.getDeclaredField("errorPenaltyLoad");
    penaltyLoad.setAccessible(true);
    penaltyLoad.setInt(channel, 5);
    Field expiresAt = ChannelRef.class.getDeclaredField("errorPenaltyExpiresAtNanos");
    expiresAt.setAccessible(true);
    expiresAt.setLong(channel, 0);

    assertThat(channel.currentErrorPenalty()).isEqualTo(0);
    assertThat(channel.getPickerLoad()).isEqualTo(0);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(0);
  }

  @Test
  public void appliedPenaltyAvoidsClearedExpirySentinel() {
    long durationNanos = Duration.ofSeconds(5).toNanos();
    AtomicLong clock = new AtomicLong(-durationNanos);
    pool = newPool();
    pool.setNanoClock(clock::get);
    ChannelRef channel = pool.channelRefs.get(0);

    completeWithError(channel, clock.get(), Status.UNAVAILABLE);

    assertThat(channel.currentErrorPenalty()).isEqualTo(5);
    assertThat(channel.getPickerLoad()).isEqualTo(5);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(5);

    clock.set(0);
    assertThat(channel.currentErrorPenalty()).isEqualTo(1);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(5);

    clock.set(1);
    assertThat(channel.currentErrorPenalty()).isEqualTo(0);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(0);
  }

  @Test
  public void zeroPenaltyStepDisablesPenalties() {
    AtomicLong clock = new AtomicLong(1);
    pool = newPool(2, 10, 0, Duration.ofSeconds(5));
    pool.setNanoClock(clock::get);
    ChannelRef channel = pool.channelRefs.get(0);

    completeWithError(channel, clock.get(), Status.UNAVAILABLE);

    assertThat(channel.currentErrorPenalty()).isEqualTo(0);
    assertThat(totalErrorPenaltyLoad()).isEqualTo(0);
  }

  private GcpManagedChannel newPool() {
    return newPool(2, 10, 5, Duration.ofSeconds(5));
  }

  private GcpManagedChannel newPool(
      int minimum, int maximumRpc, int penaltyStep, Duration penaltyDuration) {
    return newPool(2, minimum, 2, maximumRpc, penaltyStep, penaltyDuration);
  }

  private GcpManagedChannel newPool(
      int initial,
      int minimum,
      int maximum,
      int maximumRpc,
      int penaltyStep,
      Duration penaltyDuration) {
    GcpChannelPoolOptions options =
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(initial)
            .setMinSize(minimum)
            .setMaxSize(maximum)
            .setDynamicScaling(1, maximumRpc, Duration.ofMinutes(1))
            .setErrorPenaltyStep(penaltyStep)
            .setErrorPenaltyDuration(penaltyDuration)
            .build();
    return (GcpManagedChannel)
        GcpManagedChannelBuilder.forDelegateBuilder(
                new GcpManagedChannelTest.FakeManagedChannelBuilder(
                    () -> new GcpManagedChannelTest.FakeManagedChannel(executor)))
            .withOptions(
                GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(options).build())
            .build();
  }

  private static void completeWithError(ChannelRef channel, long now, Status status) {
    channel.activeStreamsCountIncr();
    channel.activeStreamsCountDecr(now, status, false);
  }

  private long totalErrorPenaltyLoad() {
    try {
      Field field = GcpManagedChannel.class.getDeclaredField("totalErrorPenaltyLoad");
      field.setAccessible(true);
      return ((AtomicLong) field.get(pool)).get();
    } catch (ReflectiveOperationException failure) {
      throw new AssertionError(failure);
    }
  }
}

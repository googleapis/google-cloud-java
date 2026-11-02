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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.grpc.GcpManagedChannel.ChannelRef;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class GcpManagedChannelDrainingTest {
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
  public void idleDrainedChannelWaitsForGraceBeforeClose() {
    AtomicLong clock = new AtomicLong(System.nanoTime());
    pool = newPool(Duration.ofMinutes(1));
    clock.set(System.nanoTime());
    pool.setNanoClock(clock::get);

    scaleDown();
    ChannelRef draining = pool.removedChannelRefs.iterator().next();
    pool.finishDrain(draining);
    assertThat(draining.getChannel().isShutdown()).isFalse();

    clock.addAndGet(Duration.ofMinutes(1).plusNanos(1).toNanos());
    pool.finishDrain(draining);
    assertThat(draining.getChannel().isShutdown()).isTrue();
  }

  @Test
  public void activeDrainedChannelClosesAfterFinalStream() {
    pool = newPool(Duration.ZERO);
    ChannelRef victim = pool.channelRefs.get(0);
    victim.activeStreamsCountIncr();
    for (int i = 1; i < pool.channelRefs.size(); i++) {
      pool.channelRefs.get(i).setActiveStreamsForTest(2);
    }

    scaleDown();
    assertThat(pool.removedChannelRefs).contains(victim);
    assertThat(victim.getChannel().isShutdown()).isFalse();

    victim.activeStreamsCountDecr(System.nanoTime(), Status.OK, false);
    await().atMost(Duration.ofSeconds(5)).until(() -> victim.getChannel().isShutdown());
  }

  @Test
  public void scaledUpPoolBuildsFreshChannelWhileRemovedChannelDrains() {
    pool = newPool(Duration.ofMinutes(1));
    ChannelRef victim = pool.channelRefs.get(0);
    ((GcpManagedChannelTest.FakeManagedChannel) victim.getChannel())
        .setState(io.grpc.ConnectivityState.READY);

    scaleDown();
    assertThat(pool.removedChannelRefs).contains(victim);

    ChannelRef fresh = pool.createNewChannel();
    pool.finishDrain(victim);

    assertThat(fresh).isNotSameInstanceAs(victim);
    assertThat(pool.channelRefs).contains(fresh);
    assertThat(pool.channelRefs).doesNotContain(victim);
    assertThat(pool.removedChannelRefs).contains(victim);
    assertThat(victim.isActive()).isFalse();
    assertThat(victim.getChannel().isShutdown()).isFalse();
  }

  @Test
  public void scaleDownPrefersChannelWithFewerAffinitiesWhenLoadsTie() {
    pool = newPool(Duration.ofMinutes(1));
    ChannelRef affiliated = pool.channelRefs.get(0);
    pool.bind(affiliated, Collections.singletonList("session"));

    scaleDown();

    assertThat(pool.channelRefs).contains(affiliated);
    assertThat(pool.removedChannelRefs).doesNotContain(affiliated);
    assertThat(affiliated.getAffinityCount()).isEqualTo(1);
  }

  @Test
  public void finishDrainShutsDelegateDownOutsidePoolMonitor() {
    AtomicLong clock = new AtomicLong(System.nanoTime());
    AtomicReference<GcpManagedChannel> poolReference = new AtomicReference<>();
    pool =
        newPool(
            Duration.ofMinutes(1), () -> new LockCheckingManagedChannel(executor, poolReference));
    poolReference.set(pool);
    clock.set(System.nanoTime());
    pool.setNanoClock(clock::get);

    scaleDown();
    ChannelRef draining = pool.removedChannelRefs.iterator().next();
    LockCheckingManagedChannel delegate = (LockCheckingManagedChannel) draining.getChannel();
    clock.addAndGet(Duration.ofMinutes(1).plusNanos(1).toNanos());

    pool.finishDrain(draining);

    assertThat(delegate.isShutdown()).isTrue();
    assertThat(delegate.shutdownWithPoolMonitorHeld.get()).isFalse();
  }

  @Test
  public void rejectedDrainScheduleShutsDelegatesDownOutsidePoolMonitor() {
    AtomicReference<GcpManagedChannel> poolReference = new AtomicReference<>();
    List<LockCheckingManagedChannel> delegates = new CopyOnWriteArrayList<>();
    pool =
        newPool(
            Duration.ofMinutes(1),
            () -> {
              LockCheckingManagedChannel delegate =
                  new LockCheckingManagedChannel(executor, poolReference);
              delegates.add(delegate);
              return delegate;
            });
    poolReference.set(pool);
    ScheduledThreadPoolExecutor rejectingScheduler = new ScheduledThreadPoolExecutor(1);
    rejectingScheduler.shutdown();
    pool.setDrainSchedulerForTest(rejectingScheduler);

    scaleDown();

    int shutdownCount = 0;
    for (LockCheckingManagedChannel delegate : delegates) {
      if (delegate.isShutdown()) {
        shutdownCount++;
        assertThat(delegate.shutdownWithPoolMonitorHeld.get()).isFalse();
      }
    }
    assertThat(shutdownCount).isEqualTo(2);
    assertThat(pool.removedChannelRefs).isEmpty();
  }

  @Test
  public void staleDrainTaskCannotActOnBehalfOfNewerTask() {
    ScheduledExecutorService scheduler = mock(ScheduledExecutorService.class);
    List<Runnable> tasks = new ArrayList<>();
    when(scheduler.schedule(any(Runnable.class), anyLong(), any(TimeUnit.class)))
        .thenAnswer(
            invocation -> {
              tasks.add(invocation.getArgument(0));
              return mock(ScheduledFuture.class);
            });
    pool = newPool(Duration.ZERO);
    pool.setDrainSchedulerForTest(scheduler);
    scaleDown();
    assertThat(tasks).hasSize(2);
    ChannelRef draining = pool.removedChannelRefs.iterator().next();

    pool.scheduleDrain(draining);
    assertThat(tasks).hasSize(3);
    assertThat(pool.drainTaskCountForTest()).isEqualTo(2);

    tasks.get(0).run();
    tasks.get(1).run();

    assertThat(draining.getChannel().isShutdown()).isFalse();
    assertThat(pool.removedChannelRefs).contains(draining);
    assertThat(pool.drainTaskCountForTest()).isEqualTo(1);

    tasks.get(2).run();

    assertThat(draining.getChannel().isShutdown()).isTrue();
    assertThat(pool.removedChannelRefs).doesNotContain(draining);
    assertThat(pool.drainTaskCountForTest()).isEqualTo(0);
  }

  @Test
  public void inlineDrainTaskFinishesAfterItsFutureIsPublished() {
    ScheduledExecutorService scheduler = mock(ScheduledExecutorService.class);
    when(scheduler.schedule(any(Runnable.class), anyLong(), any(TimeUnit.class)))
        .thenAnswer(
            invocation -> {
              invocation.<Runnable>getArgument(0).run();
              return mock(ScheduledFuture.class);
            });
    pool = newPool(Duration.ZERO);
    pool.setDrainSchedulerForTest(scheduler);

    scaleDown();

    assertThat(pool.removedChannelRefs).isEmpty();
    assertThat(pool.drainTaskCountForTest()).isEqualTo(0);
  }

  @Test
  public void affinityKeyRebindsAwayFromDrainingChannel() {
    pool = newPool(Duration.ofMinutes(1));
    ChannelRef victim = pool.channelRefs.get(0);
    pool.bind(victim, Collections.singletonList("session"));
    for (int i = 1; i < pool.channelRefs.size(); i++) {
      pool.channelRefs.get(i).setActiveStreamsForTest(1);
    }

    scaleDown();

    assertThat(pool.getChannelRef("session")).isNotSameInstanceAs(victim);
    assertThat(pool.affinityKeyToChannelRef.get("session").isActive()).isTrue();
  }

  @Test
  public void powerOfTwoUsesCandidateRetryBoundBeforeFullScan() {
    pool = newPool(Duration.ofMinutes(1));
    List<ChannelRef> candidates = new CopyOnWriteArrayList<>(pool.channelRefs);
    int initialSize = candidates.size();
    ChannelRef firstInactive = candidates.get(0);
    ChannelRef secondInactive = candidates.get(1);
    ChannelRef fallback = candidates.get(2);
    firstInactive.deactivateForTest();
    secondInactive.deactivateForTest();
    AtomicBoolean shrunk = new AtomicBoolean();
    AtomicInteger nextSample = new AtomicInteger();
    pool.setCandidateIndexPickerForTest(
        bound -> {
          if (shrunk.compareAndSet(false, true)) {
            candidates.remove(firstInactive);
            candidates.remove(secondInactive);
          }
          nextSample.incrementAndGet();
          return 0;
        });

    assertThat(pool.pickFromCandidates(candidates)).isSameInstanceAs(fallback);
    assertThat(nextSample.get()).isEqualTo(4 * initialSize);
  }

  @Test
  public void pickerRetriesWhenChannelDeactivatesBeforeValidation() {
    pool = newPool(Duration.ofMinutes(1));
    AtomicReference<ChannelRef> deactivated = new AtomicReference<>();
    pool.setPickerValidationHookForTest(
        candidate -> {
          deactivated.set(candidate);
          candidate.deactivateForTest();
          pool.channelRefs.remove(candidate);
          pool.removedChannelRefs.add(candidate);
        });

    ChannelRef picked = pool.getChannelRef(null);
    picked.activeStreamsCountIncr();

    assertThat(picked).isNotSameInstanceAs(deactivated.get());
    assertThat(pool.channelRefs).doesNotContain(deactivated.get());
    assertThat(deactivated.get().getActiveStreamsCount()).isEqualTo(0);
    assertThat(picked.getActiveStreamsCount()).isEqualTo(1);
  }

  private void scaleDown() {
    pool.checkScaleDown();
    pool.checkScaleDown();
    pool.checkScaleDown();
  }

  private GcpManagedChannel newPool(Duration drainIdleGrace) {
    return newPool(drainIdleGrace, () -> new GcpManagedChannelTest.FakeManagedChannel(executor));
  }

  private GcpManagedChannel newPool(
      Duration drainIdleGrace, Supplier<? extends ManagedChannel> channelFactory) {
    GcpChannelPoolOptions options =
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(4)
            .setMinSize(2)
            .setMaxSize(4)
            .setDynamicScaling(10, 20, Duration.ofMinutes(1))
            .setScaleDownConsecutiveLowLoadChecks(3)
            .setMaxScaleDownChannels(2)
            .setDrainIdleGrace(drainIdleGrace)
            .build();
    return (GcpManagedChannel)
        GcpManagedChannelBuilder.forDelegateBuilder(
                new GcpManagedChannelTest.FakeManagedChannelBuilder(channelFactory))
            .withOptions(
                GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(options).build())
            .build();
  }

  private static final class LockCheckingManagedChannel
      extends GcpManagedChannelTest.FakeManagedChannel {
    private final AtomicReference<GcpManagedChannel> poolReference;
    private final AtomicBoolean shutdownWithPoolMonitorHeld = new AtomicBoolean();

    private LockCheckingManagedChannel(
        ExecutorService executor, AtomicReference<GcpManagedChannel> poolReference) {
      super(executor);
      this.poolReference = poolReference;
    }

    @Override
    public ManagedChannel shutdown() {
      GcpManagedChannel currentPool = poolReference.get();
      shutdownWithPoolMonitorHeld.set(currentPool != null && Thread.holdsLock(currentPool));
      return super.shutdown();
    }
  }
}

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

import com.google.cloud.grpc.GcpManagedChannel.ChannelAffinityRef;
import com.google.cloud.grpc.GcpManagedChannel.ChannelRef;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpResiliencyOptions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.ConnectivityState;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
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

/** Dynamic channel pool behavior tests. */
@RunWith(JUnit4.class)
public final class GcpManagedChannelDynamicPoolTest {
  private final ExecutorService stateExecutor = Executors.newSingleThreadExecutor();
  private GcpManagedChannel pool;

  @After
  public void tearDown() {
    if (pool != null) {
      pool.shutdownNow();
    }
    stateExecutor.shutdownNow();
  }

  @Test
  public void hotChannelAloneSignalsScaleUpAfterCallIsCounted() throws Exception {
    pool = newPool(2, 2, 4, 2, 5, Duration.ofSeconds(30), builder());
    ChannelRef hot = pool.channelRefs.get(0);

    for (int i = 0; i < 7; i++) {
      hot.activeStreamsCountIncr();
    }

    awaitCondition(() -> pool.getNumberOfChannels() == 3);
    assertThat(pool.channelRefs.get(1).getActiveStreamsCount()).isEqualTo(0);
  }

  @Test
  public void poolAverageSignalsScaleUpWhenSelectedChannelIsBelowMaximum() throws Exception {
    pool = newPool(2, 2, 4, 2, 5, Duration.ofSeconds(30), builder());
    ChannelRef selected = pool.channelRefs.get(0);
    pool.channelRefs.get(1).setActiveStreamsForTest(12);

    selected.activeStreamsCountIncr();

    assertThat(selected.getPickerLoad()).isAtMost(5);
    awaitCondition(() -> pool.getNumberOfChannels() == 4);
  }

  @Test
  public void scaleUpBuildsOnBackgroundWorkerNotCallerThread() throws Exception {
    AtomicReference<String> scaleUpThread = new AtomicReference<>();
    AtomicInteger builds = new AtomicInteger();
    GcpManagedChannelTest.FakeManagedChannelBuilder delegate =
        new GcpManagedChannelTest.FakeManagedChannelBuilder(
            () -> {
              if (builds.incrementAndGet() > 2) {
                scaleUpThread.set(Thread.currentThread().getName());
              }
              return new GcpManagedChannelTest.FakeManagedChannel(stateExecutor);
            });
    pool = newPool(2, 2, 4, 2, 5, Duration.ofSeconds(30), delegate);
    String callerThread = Thread.currentThread().getName();

    for (int i = 0; i < 7; i++) {
      pool.channelRefs.get(0).activeStreamsCountIncr();
    }

    awaitCondition(() -> scaleUpThread.get() != null);
    assertThat(scaleUpThread.get()).startsWith("gcp-mc-bg-");
    assertThat(scaleUpThread.get()).isNotEqualTo(callerThread);
  }

  @Test
  public void successfulPrimerDelaysPublicationAndRunsOnBackgroundWorker() throws Exception {
    SettableFuture<Void> primeFuture = SettableFuture.create();
    AtomicReference<String> primerThread = new AtomicReference<>();
    AtomicReference<GcpManagedChannelTest.FakeManagedChannel> primingChannel =
        new AtomicReference<>();
    GcpChannelPrimer primer =
        channel -> {
          primerThread.set(Thread.currentThread().getName());
          primingChannel.set((GcpManagedChannelTest.FakeManagedChannel) channel);
          return primeFuture;
        };
    pool = newPrimedPool(primer, Duration.ofSeconds(5), builder());
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(6);

    hot.activeStreamsCountIncr();

    awaitCondition(() -> primingChannel.get() != null);
    awaitCondition(() -> !pool.scaleUpWorkerRunningForTest());
    assertThat(pool.inFlightPrimeCountForTest()).isEqualTo(1);
    assertThat(pool.getNumberOfChannels()).isEqualTo(2);
    assertThat(primerThread.get()).startsWith("gcp-mc-bg-");
    primeFuture.set(null);
    awaitCondition(() -> pool.getNumberOfChannels() == 3);
  }

  @Test
  public void scaleUpStartsAllChannelPrimersConcurrently() throws Exception {
    CountDownLatch allPrimersStarted = new CountDownLatch(3);
    List<SettableFuture<Void>> primeFutures = new CopyOnWriteArrayList<>();
    GcpChannelPrimer primer =
        channel -> {
          SettableFuture<Void> future = SettableFuture.create();
          primeFutures.add(future);
          allPrimersStarted.countDown();
          return future;
        };
    pool = newPrimedPool(10, 13, primer, Duration.ofSeconds(5), 1, builder());
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(99);

    hot.activeStreamsCountIncr();

    assertThat(allPrimersStarted.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(pool.inFlightPrimeCountForTest()).isEqualTo(3);
    assertThat(pool.getNumberOfChannels()).isEqualTo(10);
    primeFutures.forEach(future -> future.set(null));
    awaitCondition(() -> pool.inFlightPrimeCountForTest() == 0);
    awaitCondition(() -> pool.getNumberOfChannels() == 13);
    assertThat(pool.getNumberOfChannels()).isEqualTo(13);
  }

  @Test
  public void primedChannelIsPublishedBeforeRestOfBatchCompletes() throws Exception {
    CountDownLatch allPrimersStarted = new CountDownLatch(3);
    List<SettableFuture<Void>> primeFutures = new CopyOnWriteArrayList<>();
    Map<SettableFuture<Void>, GcpManagedChannelTest.FakeManagedChannel> primingChannels =
        new java.util.concurrent.ConcurrentHashMap<>();
    GcpChannelPrimer primer =
        channel -> {
          SettableFuture<Void> future = SettableFuture.create();
          primingChannels.put(future, (GcpManagedChannelTest.FakeManagedChannel) channel);
          primeFutures.add(future);
          allPrimersStarted.countDown();
          return future;
        };
    pool = newPrimedPool(10, 13, primer, Duration.ofSeconds(5), 1, builder());
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(99);

    hot.activeStreamsCountIncr();

    assertThat(allPrimersStarted.await(5, TimeUnit.SECONDS)).isTrue();
    SettableFuture<Void> firstFuture = primeFutures.get(0);
    GcpManagedChannelTest.FakeManagedChannel firstChannel = primingChannels.get(firstFuture);
    firstFuture.set(null);
    awaitCondition(() -> pool.getNumberOfChannels() == 11);
    assertThat(
            pool.channelRefs.stream()
                .anyMatch(channelRef -> channelRef.getChannel() == firstChannel))
        .isTrue();
    assertThat(pool.inFlightPrimeCountForTest()).isEqualTo(2);
    assertThat(primeFutures.get(1).isDone()).isFalse();
    assertThat(primeFutures.get(2).isDone()).isFalse();
    primeFutures.get(1).set(null);
    primeFutures.get(2).set(null);
    awaitCondition(() -> pool.inFlightPrimeCountForTest() == 0);
    awaitCondition(() -> pool.getNumberOfChannels() == 13);
  }

  @Test
  public void failedPrimeDoesNotDelayOtherChannels() throws Exception {
    CountDownLatch allPrimersStarted = new CountDownLatch(3);
    List<SettableFuture<Void>> primeFutures = new CopyOnWriteArrayList<>();
    GcpChannelPrimer primer =
        channel -> {
          SettableFuture<Void> future = SettableFuture.create();
          primeFutures.add(future);
          allPrimersStarted.countDown();
          return future;
        };
    pool = newPrimedPool(10, 13, primer, Duration.ofSeconds(5), 1, builder());
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(99);

    hot.activeStreamsCountIncr();

    assertThat(allPrimersStarted.await(5, TimeUnit.SECONDS)).isTrue();
    primeFutures.get(0).setException(new IllegalStateException("prime failed"));
    primeFutures.get(1).set(null);
    primeFutures.get(2).set(null);
    awaitCondition(() -> pool.scaleUpPrimeFailuresForTest() == 1);
    awaitCondition(() -> pool.inFlightPrimeCountForTest() == 0);
    awaitCondition(() -> pool.getNumberOfChannels() == 12);
    assertThat(pool.scaleUpPrimeFailuresForTest()).isEqualTo(1);
  }

  @Test
  public void timedOutPrimeDoesNotDelayOtherChannels() throws Exception {
    CountDownLatch allPrimersStarted = new CountDownLatch(3);
    List<SettableFuture<Void>> primeFutures = new CopyOnWriteArrayList<>();
    GcpChannelPrimer primer =
        channel -> {
          SettableFuture<Void> future = SettableFuture.create();
          primeFutures.add(future);
          allPrimersStarted.countDown();
          return future;
        };
    pool = newPrimedPool(10, 13, primer, Duration.ofSeconds(1), 1, builder());
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(99);

    hot.activeStreamsCountIncr();

    assertThat(allPrimersStarted.await(5, TimeUnit.SECONDS)).isTrue();
    primeFutures.get(1).set(null);
    primeFutures.get(2).set(null);
    awaitCondition(() -> pool.getNumberOfChannels() == 12);
    assertThat(primeFutures.get(0).isDone()).isFalse();
    assertThat(pool.inFlightPrimeCountForTest()).isEqualTo(1);
    awaitCondition(() -> pool.scaleUpPrimeFailuresForTest() == 1);
    awaitCondition(() -> pool.inFlightPrimeCountForTest() == 0);
  }

  @Test
  public void shutdownClosesEveryUnpublishedPrimingChannel() throws Exception {
    CountDownLatch allPrimersStarted = new CountDownLatch(3);
    List<GcpManagedChannelTest.FakeManagedChannel> primingChannels = new CopyOnWriteArrayList<>();
    List<SettableFuture<Void>> primeFutures = new CopyOnWriteArrayList<>();
    GcpChannelPrimer primer =
        channel -> {
          primingChannels.add((GcpManagedChannelTest.FakeManagedChannel) channel);
          SettableFuture<Void> future = SettableFuture.create();
          primeFutures.add(future);
          allPrimersStarted.countDown();
          return future;
        };
    pool = newPrimedPool(10, 13, primer, Duration.ofSeconds(5), 1, builder());
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(99);
    hot.activeStreamsCountIncr();
    assertThat(allPrimersStarted.await(5, TimeUnit.SECONDS)).isTrue();

    pool.shutdownNow();

    awaitCondition(() -> pool.inFlightPrimeCountForTest() == 0);
    assertThat(primingChannels).hasSize(3);
    assertThat(primingChannels.stream().allMatch(channel -> channel.isShutdown())).isTrue();
    assertThat(primeFutures.stream().allMatch(Future::isCancelled)).isTrue();
    assertThat(pool.getNumberOfChannels()).isEqualTo(10);
  }

  @Test
  public void failedPrimerRejectsChannelAndLaterScaleUpStillWorks() throws Exception {
    AtomicInteger primeCalls = new AtomicInteger();
    AtomicReference<GcpManagedChannelTest.FakeManagedChannel> rejected = new AtomicReference<>();
    GcpChannelPrimer primer =
        channel -> {
          if (primeCalls.incrementAndGet() == 1) {
            rejected.set((GcpManagedChannelTest.FakeManagedChannel) channel);
            return Futures.immediateFailedFuture(new IllegalStateException("prime failed"));
          }
          return Futures.immediateVoidFuture();
        };
    pool = newPrimedPool(primer, Duration.ofSeconds(5), 1, builder());
    AtomicLong clock = new AtomicLong(1);
    pool.setNanoClock(clock::get);
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(6);

    hot.activeStreamsCountIncr();

    awaitCondition(() -> pool.scaleUpPrimeFailuresForTest() == 1);
    assertThat(pool.getNumberOfChannels()).isEqualTo(2);
    awaitCondition(() -> rejected.get() != null && rejected.get().isShutdown());
    awaitCondition(() -> !pool.scaleUpWorkerRunningForTest());
    clock.incrementAndGet();
    hot.activeStreamsCountIncr();
    awaitCondition(() -> pool.getNumberOfChannels() == 3);
    assertThat(primeCalls.get()).isEqualTo(2);
  }

  @Test
  public void primerTimeoutRejectsAndClosesChannel() throws Exception {
    SettableFuture<Void> neverCompletes = SettableFuture.create();
    AtomicReference<GcpManagedChannelTest.FakeManagedChannel> rejected = new AtomicReference<>();
    GcpChannelPrimer primer =
        channel -> {
          rejected.set((GcpManagedChannelTest.FakeManagedChannel) channel);
          return neverCompletes;
        };
    pool = newPrimedPool(primer, Duration.ofMillis(20), 1, builder());
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(6);

    hot.activeStreamsCountIncr();

    awaitCondition(() -> pool.scaleUpPrimeFailuresForTest() == 1);
    assertThat(pool.getNumberOfChannels()).isEqualTo(2);
    awaitCondition(() -> rejected.get() != null && rejected.get().isShutdown());
  }

  @Test
  public void primerRetriesUntilSuccess() throws Exception {
    AtomicInteger primeCalls = new AtomicInteger();
    GcpChannelPrimer primer =
        channel ->
            primeCalls.incrementAndGet() < 3
                ? Futures.immediateFailedFuture(new IllegalStateException("prime failed"))
                : Futures.immediateVoidFuture();
    pool = newPrimedPool(primer, Duration.ofSeconds(5), 3, builder());
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(6);

    hot.activeStreamsCountIncr();

    awaitCondition(() -> pool.getNumberOfChannels() == 3);
    assertThat(primeCalls.get()).isEqualTo(3);
    assertThat(pool.scaleUpPrimeFailuresForTest()).isEqualTo(0);
  }

  @Test
  public void primerRetriesExhaustedRejectsChannel() throws Exception {
    AtomicInteger primeCalls = new AtomicInteger();
    AtomicReference<GcpManagedChannelTest.FakeManagedChannel> rejected = new AtomicReference<>();
    GcpChannelPrimer primer =
        channel -> {
          rejected.set((GcpManagedChannelTest.FakeManagedChannel) channel);
          primeCalls.incrementAndGet();
          return Futures.immediateFailedFuture(new IllegalStateException("prime failed"));
        };
    pool = newPrimedPool(primer, Duration.ofSeconds(5), 3, builder());
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(6);

    hot.activeStreamsCountIncr();

    awaitCondition(() -> pool.scaleUpPrimeFailuresForTest() == 1);
    assertThat(primeCalls.get()).isEqualTo(3);
    assertThat(pool.getNumberOfChannels()).isEqualTo(2);
    awaitCondition(() -> rejected.get() != null && rejected.get().isShutdown());
  }

  @Test
  public void primerBackoffIsCappedForManyAttempts() {
    List<Long> backoffs = new CopyOnWriteArrayList<>();

    for (int attempt = 0; attempt < 49; attempt++) {
      backoffs.add(GcpManagedChannel.primeBackoffMillisForTest(attempt));
    }

    assertThat(backoffs).hasSize(49);
    assertThat(backoffs.stream().mapToLong(Long::longValue).max().orElse(0)).isAtMost(5_000L);
    assertThat(backoffs.stream().mapToLong(Long::longValue).sum()).isEqualTo(221_300L);
  }

  @Test
  public void reusableDrainingChannelSkipsPrimer() throws Exception {
    AtomicInteger primeCalls = new AtomicInteger();
    GcpChannelPrimer primer =
        channel -> {
          primeCalls.incrementAndGet();
          return Futures.immediateVoidFuture();
        };
    pool = newPrimedPool(primer, Duration.ofSeconds(5), builder());
    for (ChannelRef ref : pool.channelRefs) {
      ((GcpManagedChannelTest.FakeManagedChannel) ref.getChannel())
          .setState(ConnectivityState.READY);
    }
    awaitCondition(() -> pool.readyChannelCountForTest() == 2);
    pool.checkScaleDown();
    assertThat(pool.getNumberOfChannels()).isEqualTo(1);

    ChannelRef active = pool.channelRefs.get(0);
    active.setActiveStreamsForTest(3);
    active.activeStreamsCountIncr();

    awaitCondition(() -> pool.getNumberOfChannels() == 2);
    assertThat(primeCalls.get()).isEqualTo(0);
  }

  @Test
  public void keyedBindCompletesWhileScaleUpDelegateBuildIsBlocked() throws Exception {
    AtomicInteger builds = new AtomicInteger();
    CountDownLatch scaleUpBuildStarted = new CountDownLatch(1);
    CountDownLatch releaseScaleUpBuild = new CountDownLatch(1);
    ExecutorService binder = Executors.newSingleThreadExecutor();
    GcpManagedChannelTest.FakeManagedChannelBuilder delegate =
        new GcpManagedChannelTest.FakeManagedChannelBuilder(
            () -> {
              if (builds.incrementAndGet() > 2) {
                scaleUpBuildStarted.countDown();
                try {
                  releaseScaleUpBuild.await(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
                }
              }
              return new GcpManagedChannelTest.FakeManagedChannel(stateExecutor);
            });
    try {
      pool = newPool(2, 2, 4, 2, 5, Duration.ofSeconds(30), delegate);
      for (int i = 0; i < 7; i++) {
        pool.channelRefs.get(0).activeStreamsCountIncr();
      }
      awaitCondition(() -> scaleUpBuildStarted.getCount() == 0);

      Future<?> bind =
          binder.submit(() -> pool.bind(pool.channelRefs.get(0), Collections.singletonList("key")));
      await().atMost(Duration.ofSeconds(1)).until(bind::isDone);
      assertThat(pool.affinityKeyToChannelRef).containsKey("key");
    } finally {
      releaseScaleUpBuild.countDown();
      binder.shutdownNow();
    }
  }

  @Test
  public void inactiveMappingCleanupIsAtomicWithConcurrentBind() throws Exception {
    AtomicLong clock = new AtomicLong(1);
    pool = affinityPool(Duration.ofNanos(1), builder());
    pool.setNanoClock(clock::get);
    ChannelRef inactive = pool.channelRefs.get(0);
    ChannelRef rebound = pool.channelRefs.get(1);
    String key = "session";
    pool.bind(inactive, Collections.singletonList(key));
    inactive.deactivateForTest();

    CountDownLatch mappingRemoved = new CountDownLatch(1);
    CountDownLatch bindAttempted = new CountDownLatch(1);
    AtomicReference<Thread> bindingThread = new AtomicReference<>();
    pool.setInactiveMappingRemovedHookForTest(
        () -> {
          mappingRemoved.countDown();
          try {
            assertThat(bindAttempted.await(5, TimeUnit.SECONDS)).isTrue();
            // Binding must wait for inactive cleanup to remove the matching timestamp.
            await()
                .atMost(Duration.ofSeconds(5))
                .until(() -> bindingThread.get().getState() == Thread.State.BLOCKED);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
          }
        });
    ExecutorService callers = Executors.newFixedThreadPool(2);
    try {
      Future<ChannelRef> resolver = callers.submit(() -> pool.getChannelRef(key));
      assertThat(mappingRemoved.await(5, TimeUnit.SECONDS)).isTrue();
      Future<?> binder =
          callers.submit(
              () -> {
                bindingThread.set(Thread.currentThread());
                bindAttempted.countDown();
                pool.bind(rebound, Collections.singletonList(key));
              });

      resolver.get(5, TimeUnit.SECONDS);
      binder.get(5, TimeUnit.SECONDS);
      boolean hasMapping = pool.affinityKeyToChannelRef.containsKey(key);
      boolean hasLastUsed = pool.affinityKeyLastUsed.containsKey(key);
      assertThat(hasMapping).isEqualTo(hasLastUsed);
      assertThat(hasMapping).isTrue();

      clock.addAndGet(2);
      pool.cleanupAffinityKeys();
      assertThat(pool.affinityKeyToChannelRef).doesNotContainKey(key);
      assertThat(pool.affinityKeyLastUsed).doesNotContainKey(key);
    } finally {
      callers.shutdownNow();
    }
  }

  @Test
  public void shutdownPoolPickerCompletesWithUnavailable() throws Exception {
    ExecutorService picker = Executors.newSingleThreadExecutor();
    try {
      pool = newPool(0, 0, 2, 1, 3, Duration.ofSeconds(30), builder());
      pool.shutdownNow();

      Future<ChannelRef> pick = picker.submit(() -> pool.getChannelRef(null));
      await().atMost(Duration.ofSeconds(1)).until(pick::isDone);
      try {
        pick.get();
        throw new AssertionError("picker unexpectedly returned a channel");
      } catch (ExecutionException expected) {
        assertThat(expected.getCause()).isInstanceOf(StatusRuntimeException.class);
        assertThat(((StatusRuntimeException) expected.getCause()).getStatus().getCode())
            .isEqualTo(Status.Code.UNAVAILABLE);
      }
    } finally {
      picker.shutdownNow();
    }
  }

  @Test
  public void failedScaleUpBuildDoesNotKillFutureScaleUps() throws Exception {
    AtomicInteger builds = new AtomicInteger();
    GcpManagedChannelTest.FakeManagedChannelBuilder delegate =
        new GcpManagedChannelTest.FakeManagedChannelBuilder(
            () -> {
              if (builds.incrementAndGet() == 3) {
                throw new IllegalStateException("one build failure");
              }
              return new GcpManagedChannelTest.FakeManagedChannel(stateExecutor);
            });
    pool = newPool(2, 2, 4, 2, 5, Duration.ofSeconds(30), delegate);
    AtomicLong clock = new AtomicLong(1);
    pool.setNanoClock(clock::get);
    ChannelRef hot = pool.channelRefs.get(0);

    for (int i = 0; i < 7; i++) {
      hot.activeStreamsCountIncr();
    }
    awaitCondition(() -> builds.get() == 3);
    awaitCondition(() -> !pool.scaleUpWorkerRunningForTest());
    clock.incrementAndGet();
    hot.activeStreamsCountIncr();

    awaitCondition(() -> pool.getNumberOfChannels() == 3);
    assertThat(builds.get()).isAtLeast(4);
  }

  @Test
  public void shutdownReturnsWhileScaleUpBuildIsBlockedAndClosesSurplus() throws Exception {
    AtomicInteger builds = new AtomicInteger();
    AtomicReference<GcpManagedChannelTest.FakeManagedChannel> surplus = new AtomicReference<>();
    CountDownLatch scaleUpBuildStarted = new CountDownLatch(1);
    CountDownLatch releaseScaleUpBuild = new CountDownLatch(1);
    ExecutorService shutdownExecutor = Executors.newSingleThreadExecutor();
    GcpManagedChannelTest.FakeManagedChannelBuilder delegate =
        new GcpManagedChannelTest.FakeManagedChannelBuilder(
            () -> {
              if (builds.incrementAndGet() > 2) {
                scaleUpBuildStarted.countDown();
                try {
                  releaseScaleUpBuild.await(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
                }
                GcpManagedChannelTest.FakeManagedChannel channel =
                    new GcpManagedChannelTest.FakeManagedChannel(stateExecutor);
                surplus.set(channel);
                return channel;
              }
              return new GcpManagedChannelTest.FakeManagedChannel(stateExecutor);
            });
    try {
      pool = newPool(2, 2, 4, 2, 5, Duration.ofSeconds(30), delegate);
      for (int i = 0; i < 7; i++) {
        pool.channelRefs.get(0).activeStreamsCountIncr();
      }
      awaitCondition(() -> scaleUpBuildStarted.getCount() == 0);

      Future<?> shutdown = shutdownExecutor.submit(pool::shutdownNow);
      await().atMost(Duration.ofSeconds(1)).until(shutdown::isDone);
      assertThat(pool.getNumberOfChannels()).isEqualTo(2);

      releaseScaleUpBuild.countDown();
      awaitCondition(() -> surplus.get() != null && surplus.get().isShutdown());
      assertThat(pool.getNumberOfChannels()).isEqualTo(2);
    } finally {
      releaseScaleUpBuild.countDown();
      shutdownExecutor.shutdownNow();
    }
  }

  @Test
  public void burstSignalsCoalesceWhileScaleUpWorkerIsBusy() throws Exception {
    AtomicInteger builds = new AtomicInteger();
    CountDownLatch scaleUpBuildStarted = new CountDownLatch(1);
    CountDownLatch releaseScaleUpBuild = new CountDownLatch(1);
    GcpManagedChannelTest.FakeManagedChannelBuilder delegate =
        new GcpManagedChannelTest.FakeManagedChannelBuilder(
            () -> {
              if (builds.incrementAndGet() == 3) {
                scaleUpBuildStarted.countDown();
                try {
                  releaseScaleUpBuild.await(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
                }
              }
              return new GcpManagedChannelTest.FakeManagedChannel(stateExecutor);
            });
    pool = newPool(2, 2, 10, 2, 5, Duration.ofSeconds(30), delegate);
    AtomicLong clock = new AtomicLong(1);
    pool.setNanoClock(clock::get);
    ChannelRef hot = pool.channelRefs.get(0);
    for (int i = 0; i < 7; i++) {
      hot.activeStreamsCountIncr();
    }
    assertThat(scaleUpBuildStarted.await(5, TimeUnit.SECONDS)).isTrue();

    for (int i = 7; i < 30; i++) {
      hot.activeStreamsCountIncr();
    }
    clock.incrementAndGet();
    releaseScaleUpBuild.countDown();

    // First handling adds one; the single buffered follow-up adds two.
    awaitCondition(() -> pool.getNumberOfChannels() == 5);
    await()
        .during(Duration.ofMillis(100))
        .atMost(Duration.ofSeconds(1))
        .until(() -> pool.getNumberOfChannels() == 5);
  }

  @Test
  public void removedChannelsDrainThenShutdown() throws Exception {
    pool = newPool(2, 1, 2, 1, 3, Duration.ofMillis(20), Duration.ofMillis(30), builder());
    long startNanos = System.nanoTime();
    for (ChannelRef ref : pool.channelRefs) {
      ref.activeStreamsCountIncr();
    }

    awaitCondition(() -> pool.getNumberOfChannels() == 1);
    assertThat(pool.removedChannelRefs).hasSize(1);
    ChannelRef draining = pool.removedChannelRefs.iterator().next();
    assertThat(draining.getChannel().isShutdown()).isFalse();
    draining.activeStreamsCountDecr(startNanos, Status.OK, false);
    awaitCondition(() -> pool.removedChannelRefs.isEmpty() && pool.channelIdMapSizeForTest() == 1);
  }

  @Test
  public void concurrentDrainSchedulingKeepsOneTaskPerChannel() throws Exception {
    pool = newPool(1, 1, 1, 1, 3, Duration.ofSeconds(30), Duration.ofMinutes(1), builder());
    ChannelRef draining = pool.channelRefs.get(0);
    draining.deactivateForTest();
    CountDownLatch schedulersReady = new CountDownLatch(2);
    CountDownLatch start = new CountDownLatch(1);
    ExecutorService schedulers = Executors.newFixedThreadPool(2);
    try {
      Future<?> first =
          schedulers.submit(
              () -> {
                schedulersReady.countDown();
                start.await();
                pool.scheduleDrain(draining);
                return null;
              });
      Future<?> second =
          schedulers.submit(
              () -> {
                schedulersReady.countDown();
                start.await();
                pool.scheduleDrain(draining);
                return null;
              });
      assertThat(schedulersReady.await(5, TimeUnit.SECONDS)).isTrue();
      start.countDown();
      first.get(5, TimeUnit.SECONDS);
      second.get(5, TimeUnit.SECONDS);

      assertThat(pool.drainTaskCountForTest()).isEqualTo(1);
    } finally {
      schedulers.shutdownNow();
    }
  }

  @Test
  public void errorPenaltyAccumulatesDecaysAndBiasesPicker() {
    AtomicLong clock = new AtomicLong(1_000_000_000L);
    pool = newPool(2, 2, 2, 2, 10, Duration.ofSeconds(30), builder());
    pool.setNanoClock(clock::get);
    ChannelRef penalized = pool.channelRefs.get(0);
    ChannelRef healthy = pool.channelRefs.get(1);

    penalized.activeStreamsCountIncr();
    penalized.activeStreamsCountDecr(clock.get(), Status.UNAVAILABLE, false);
    assertThat(penalized.currentErrorPenalty()).isEqualTo(5);
    assertThat(pool.pickLessBusy(penalized, healthy)).isSameInstanceAs(healthy);

    penalized.activeStreamsCountIncr();
    penalized.activeStreamsCountDecr(clock.get(), Status.RESOURCE_EXHAUSTED, false);
    assertThat(penalized.currentErrorPenalty()).isEqualTo(10);

    penalized.activeStreamsCountIncr();
    penalized.activeStreamsCountDecr(clock.get(), Status.UNAVAILABLE, false);
    assertThat(penalized.currentErrorPenalty()).isEqualTo(10);

    clock.addAndGet(Duration.ofSeconds(6).toNanos());
    assertThat(penalized.currentErrorPenalty()).isEqualTo(0);
    assertThat(pool.pickLessBusy(penalized, healthy)).isSameInstanceAs(penalized);
  }

  @Test
  public void powerOfTwoTieKeepsFirstSample() {
    pool = newPool(2, 2, 2, 2, 5, Duration.ofSeconds(30), builder());
    ChannelRef first = pool.channelRefs.get(0);
    ChannelRef second = pool.channelRefs.get(1);

    assertThat(pool.pickLessBusy(first, second)).isSameInstanceAs(first);
    assertThat(pool.pickLessBusy(second, first)).isSameInstanceAs(second);
  }

  @Test
  public void powerOfTwoUsesCandidateRetryBoundBeforeFullScan() {
    pool = newPool(4, 4, 4, 2, 5, Duration.ofSeconds(30), builder());
    pool.channelRefs.get(0).deactivateForTest();
    pool.channelRefs.get(1).deactivateForTest();
    ChannelRef leastLoaded = pool.channelRefs.get(2);
    ChannelRef finalSample = pool.channelRefs.get(3);
    finalSample.setActiveStreamsForTest(10);
    int[] samples = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3};
    AtomicInteger nextSample = new AtomicInteger();
    pool.setCandidateIndexPickerForTest(bound -> samples[nextSample.getAndIncrement()]);

    ChannelRef picked = pool.pickFromCandidates(pool.channelRefs);

    assertThat(picked).isSameInstanceAs(finalSample);
    assertThat(picked).isNotSameInstanceAs(leastLoaded);
    assertThat(nextSample.get()).isEqualTo(4 * pool.channelRefs.size());
  }

  @Test
  public void pickerRetriesWhenChannelDeactivatesBeforeValidation() {
    pool = newPool(2, 2, 2, 2, 5, Duration.ofSeconds(30), builder());
    AtomicReference<ChannelRef> deactivated = new AtomicReference<>();
    pool.setPickerValidationHookForTest(
        candidate -> {
          deactivated.set(candidate);
          candidate.deactivateForTest();
        });

    ChannelRef picked = pool.getChannelRef(null);
    picked.activeStreamsCountIncr();

    assertThat(picked).isNotSameInstanceAs(deactivated.get());
    assertThat(deactivated.get().getActiveStreamsCount()).isEqualTo(0);
    assertThat(picked.getActiveStreamsCount()).isEqualTo(1);
  }

  @Test
  public void fallbackUsesChannelIdMapAfterPoolHasIndexGap() {
    pool = fallbackPool(3, 100);
    ChannelRef removed = pool.channelRefs.get(0);
    ChannelRef mapped = pool.channelRefs.get(1);
    ChannelRef fallback = pool.channelRefs.get(2);
    String key = "session";
    pool.bind(mapped, Collections.singletonList(key));
    pool.processChannelStateChange(mapped.getId(), ConnectivityState.TRANSIENT_FAILURE);
    pool.fallbackMapForTest().get(mapped.getId()).put(key, fallback.getId());
    pool.channelRefs.remove(removed);

    assertThat(pool.getChannelRef(key)).isSameInstanceAs(fallback);
  }

  @Test
  public void fallbackEligibilityUsesConfiguredWatermark() {
    pool = fallbackPool(2, 1);
    ChannelRef mapped = pool.channelRefs.get(0);
    ChannelRef atWatermark = pool.channelRefs.get(1);
    String key = "session";
    pool.bind(mapped, Collections.singletonList(key));
    atWatermark.activeStreamsCountIncr();
    pool.processChannelStateChange(mapped.getId(), ConnectivityState.TRANSIENT_FAILURE);

    assertThat(pool.getChannelRef(key)).isSameInstanceAs(mapped);
  }

  @Test
  public void scaleDownUnbindsAffinityAndUpdatesAggregateCount() throws Exception {
    pool = newPool(2, 1, 2, 1, 3, Duration.ofMillis(20), Duration.ofSeconds(5), builder());
    ChannelRef victim = pool.channelRefs.get(0);
    String key = "session";
    pool.bind(victim, Collections.singletonList(key));
    pool.channelRefs.get(1).activeStreamsCountIncr();

    awaitCondition(() -> pool.getNumberOfChannels() == 1);
    assertThat(pool.affinityKeyToChannelRef).doesNotContainKey(key);
    assertThat(pool.affinityKeyLastUsed).doesNotContainKey(key);
    assertThat(victim.getAffinityCount()).isEqualTo(0);
    assertThat(pool.totalAffinityCountForTest()).isEqualTo(0);
  }

  @Test
  public void readyAccountingRemainsExactWhenDrainingChannelIsReused() throws Exception {
    pool = newPool(2, 1, 2, 1, 3, Duration.ofSeconds(30), Duration.ofSeconds(5), builder());
    for (ChannelRef ref : pool.channelRefs) {
      ((GcpManagedChannelTest.FakeManagedChannel) ref.getChannel())
          .setState(ConnectivityState.READY);
    }
    awaitCondition(() -> pool.readyChannelCountForTest() == 2);
    pool.checkScaleDown();
    assertThat(pool.getNumberOfChannels()).isEqualTo(1);
    assertThat(pool.readyChannelCountForTest()).isEqualTo(1);

    ChannelRef active = pool.channelRefs.get(0);
    for (int i = 0; i < 4; i++) {
      active.activeStreamsCountIncr();
    }
    awaitCondition(() -> pool.getNumberOfChannels() == 2);
    assertThat(pool.readyChannelCountForTest()).isEqualTo(2);
  }

  @Test
  public void dynamicPoolWithZeroInitialSizeCreatesFirstChannelWithoutDivision() {
    pool = newPool(0, 0, 2, 1, 3, Duration.ofSeconds(30), builder());

    assertThat(pool.getChannelRef(null)).isNotNull();
    assertThat(pool.getNumberOfChannels()).isEqualTo(1);
  }

  @Test
  public void oneScaleDownCheckRemovesAtMostConfiguredLimit() throws Exception {
    pool = newPool(6, 1, 6, 1, 3, Duration.ofSeconds(30), builder());

    pool.checkScaleDown();

    assertThat(pool.getNumberOfChannels()).isEqualTo(4);
    assertThat(pool.removedChannelRefs).hasSize(2);
  }

  @Test
  public void scaleUpEventAddsAtMostThirtyPercentWithTwoChannelMinimum() throws Exception {
    pool =
        newPool(
            10,
            10,
            30,
            2,
            5,
            Duration.ofSeconds(30),
            Duration.ofMinutes(1),
            Duration.ofMinutes(1),
            builder());
    ChannelRef hot = pool.channelRefs.get(0);

    hot.setActiveStreamsForTest(99);
    hot.activeStreamsCountIncr();

    awaitCondition(() -> pool.getNumberOfChannels() == 13);
    await()
        .during(Duration.ofMillis(100))
        .atMost(Duration.ofSeconds(1))
        .until(() -> pool.getNumberOfChannels() == 13);

    pool.shutdownNow();
    pool = newPool(1, 1, 5, 2, 5, Duration.ofSeconds(30), builder());
    hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(99);
    hot.activeStreamsCountIncr();
    awaitCondition(() -> pool.getNumberOfChannels() == 3);

    pool.shutdownNow();
    pool = newPool(1, 1, 2, 2, 5, Duration.ofSeconds(30), builder());
    hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(99);
    hot.activeStreamsCountIncr();
    awaitCondition(() -> pool.getNumberOfChannels() == 2);
  }

  @Test
  public void scaleDownRequiresConfiguredConsecutiveLowLoadChecks() throws Exception {
    pool =
        newPool(
            6,
            1,
            6,
            1,
            3,
            Duration.ofSeconds(30),
            Duration.ofMinutes(1),
            Duration.ZERO,
            3,
            builder());

    pool.checkScaleDown();
    pool.checkScaleDown();
    assertThat(pool.getNumberOfChannels()).isEqualTo(6);

    pool.checkScaleDown();
    assertThat(pool.getNumberOfChannels()).isEqualTo(4);
  }

  @Test
  public void drainingChannelsAreSkippedByPowerOfTwoAndRoundRobin() throws Exception {
    pool = newPool(4, 2, 4, 1, 3, Duration.ofSeconds(30), builder());
    pool.checkScaleDown();
    assertThat(pool.removedChannelRefs).hasSize(2);

    for (int i = 0; i < 200; i++) {
      assertThat(pool.removedChannelRefs).doesNotContain(pool.getChannelRef(null));
      assertThat(pool.removedChannelRefs).doesNotContain(pool.getChannelRefRoundRobin());
    }
  }

  @Test
  public void idleDrainWaitsForGraceBeforeClosing() {
    AtomicLong clock = new AtomicLong(System.nanoTime());
    pool = newPool(0, 0, 2, 1, 3, Duration.ofSeconds(30), Duration.ofMinutes(1), builder());
    pool.setNanoClock(clock::get);
    pool.createNewChannel();
    pool.createNewChannel();
    pool.checkScaleDown();
    ChannelRef draining = pool.removedChannelRefs.iterator().next();

    pool.finishDrain(draining);
    assertThat(draining.getChannel().isShutdown()).isFalse();

    clock.addAndGet(Duration.ofMinutes(1).plusNanos(1).toNanos());
    pool.finishDrain(draining);
    assertThat(draining.getChannel().isShutdown()).isTrue();
  }

  @Test
  public void affinityReferenceReResolvesAwayFromDrainingChannel() throws Exception {
    pool = newPool(4, 2, 4, 1, 3, Duration.ofSeconds(30), builder());
    ChannelRef victim = pool.channelRefs.get(0);
    ChannelAffinityRef handle = new ChannelAffinityRef();
    handle.setChannelIdForTest(victim.getId());

    pool.checkScaleDown();

    ChannelRef resolved = pool.getChannelRefByAffinityRef(handle);
    assertThat(resolved).isNotSameInstanceAs(victim);
    assertThat(resolved.isActive()).isTrue();
  }

  @Test
  public void removedHandlesRebindWithoutHerdingOntoLateCreatedChannel() throws Exception {
    pool = newPool(8, 8, 9, 2, 5, Duration.ofSeconds(30), builder());
    AtomicLong clock = new AtomicLong(System.nanoTime() + Duration.ofMinutes(1).toNanos());
    pool.setNanoClock(clock::get);
    ChannelRef lateCreated = pool.createNewChannel();
    ChannelRef removed = pool.channelRefs.get(0);
    pool.channelRefs.remove(removed);
    removed.deactivateForTest();
    pool.removedChannelRefs.add(removed);

    int[] picksById = new int[9];
    for (int i = 0; i < 10_000; i++) {
      ChannelAffinityRef handle = new ChannelAffinityRef();
      handle.setChannelIdForTest(removed.getId());
      picksById[pool.getChannelRefByAffinityRef(handle).getId()]++;
    }

    // Old warmth-biased P2 made the newest channel win about 25% of these eight-way rebinds.
    assertThat(picksById[lateCreated.getId()]).isLessThan(2_000);
    for (ChannelRef active : pool.channelRefs) {
      assertThat(picksById[active.getId()]).isGreaterThan(0);
    }
  }

  private GcpManagedChannelTest.FakeManagedChannelBuilder builder() {
    return new GcpManagedChannelTest.FakeManagedChannelBuilder(
        () -> new GcpManagedChannelTest.FakeManagedChannel(stateExecutor));
  }

  private GcpManagedChannel newPool(
      int initial,
      int minimum,
      int maximum,
      int minRpc,
      int maxRpc,
      Duration scaleDownInterval,
      GcpManagedChannelTest.FakeManagedChannelBuilder delegate) {
    return newPool(
        initial,
        minimum,
        maximum,
        minRpc,
        maxRpc,
        scaleDownInterval,
        Duration.ofMinutes(1),
        Duration.ofNanos(1),
        delegate);
  }

  private GcpManagedChannel newPool(
      int initial,
      int minimum,
      int maximum,
      int minRpc,
      int maxRpc,
      Duration scaleDownInterval,
      Duration drainIdleGrace,
      GcpManagedChannelTest.FakeManagedChannelBuilder delegate) {
    return newPool(
        initial,
        minimum,
        maximum,
        minRpc,
        maxRpc,
        scaleDownInterval,
        drainIdleGrace,
        Duration.ofNanos(1),
        delegate);
  }

  private GcpManagedChannel newPool(
      int initial,
      int minimum,
      int maximum,
      int minRpc,
      int maxRpc,
      Duration scaleDownInterval,
      Duration drainIdleGrace,
      Duration scaleUpCooldown,
      GcpManagedChannelTest.FakeManagedChannelBuilder delegate) {
    return newPool(
        initial,
        minimum,
        maximum,
        minRpc,
        maxRpc,
        scaleDownInterval,
        drainIdleGrace,
        scaleUpCooldown,
        1,
        delegate);
  }

  private GcpManagedChannel newPool(
      int initial,
      int minimum,
      int maximum,
      int minRpc,
      int maxRpc,
      Duration scaleDownInterval,
      Duration drainIdleGrace,
      Duration scaleUpCooldown,
      int consecutiveLowLoadChecks,
      GcpManagedChannelTest.FakeManagedChannelBuilder delegate) {
    GcpChannelPoolOptions poolOptions =
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(initial)
            .setMinSize(minimum)
            .setMaxSize(maximum)
            .setDynamicScaling(minRpc, maxRpc, scaleDownInterval)
            .setScaleUpCooldown(scaleUpCooldown)
            .setScaleDownConsecutiveLowLoadChecks(consecutiveLowLoadChecks)
            .setMaxScaleUpPercent(30)
            .setMaxScaleDownChannels(2)
            .setDrainIdleGrace(drainIdleGrace)
            .setErrorPenaltyDuration(Duration.ofSeconds(5))
            .build();
    return (GcpManagedChannel)
        GcpManagedChannelBuilder.forDelegateBuilder(delegate)
            .withOptions(
                GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(poolOptions).build())
            .build();
  }

  private GcpManagedChannel fallbackPool(int size, int watermark) {
    GcpChannelPoolOptions poolOptions =
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(size)
            .setMinSize(size)
            .setMaxSize(size)
            .setConcurrentStreamsLowWatermark(watermark)
            .build();
    return (GcpManagedChannel)
        GcpManagedChannelBuilder.forDelegateBuilder(builder())
            .withOptions(
                GcpManagedChannelOptions.newBuilder()
                    .withChannelPoolOptions(poolOptions)
                    .withResiliencyOptions(
                        GcpResiliencyOptions.newBuilder().setNotReadyFallback(true).build())
                    .build())
            .build();
  }

  private GcpManagedChannel affinityPool(
      Duration affinityKeyLifetime, GcpManagedChannelTest.FakeManagedChannelBuilder delegate) {
    GcpChannelPoolOptions poolOptions =
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(2)
            .setMinSize(2)
            .setMaxSize(2)
            .setAffinityKeyLifetime(affinityKeyLifetime)
            .build();
    return (GcpManagedChannel)
        GcpManagedChannelBuilder.forDelegateBuilder(delegate)
            .withOptions(
                GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(poolOptions).build())
            .build();
  }

  private GcpManagedChannel newPrimedPool(
      int initial,
      int maximum,
      GcpChannelPrimer primer,
      Duration primeTimeout,
      int primeMaxAttempts,
      GcpManagedChannelTest.FakeManagedChannelBuilder delegate) {
    GcpChannelPoolOptions poolOptions =
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(initial)
            .setMinSize(1)
            .setMaxSize(maximum)
            .setDynamicScaling(1, 3, Duration.ofSeconds(30))
            .setScaleUpCooldown(Duration.ofNanos(1))
            .setScaleDownConsecutiveLowLoadChecks(1)
            .setMaxScaleUpPercent(30)
            .setMaxScaleDownChannels(2)
            .setDrainIdleGrace(Duration.ofMinutes(1))
            .setChannelPrimer(primer)
            .setChannelPrimeTimeout(primeTimeout)
            .setChannelPrimeMaxAttempts(primeMaxAttempts)
            .build();
    return (GcpManagedChannel)
        GcpManagedChannelBuilder.forDelegateBuilder(delegate)
            .withOptions(
                GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(poolOptions).build())
            .build();
  }

  private GcpManagedChannel newPrimedPool(
      GcpChannelPrimer primer,
      Duration primeTimeout,
      GcpManagedChannelTest.FakeManagedChannelBuilder delegate) {
    return newPrimedPool(primer, primeTimeout, 3, delegate);
  }

  private GcpManagedChannel newPrimedPool(
      GcpChannelPrimer primer,
      Duration primeTimeout,
      int primeMaxAttempts,
      GcpManagedChannelTest.FakeManagedChannelBuilder delegate) {
    GcpChannelPoolOptions poolOptions =
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(2)
            .setMinSize(1)
            .setMaxSize(3)
            .setDynamicScaling(1, 3, Duration.ofSeconds(30))
            .setScaleUpCooldown(Duration.ofNanos(1))
            .setScaleDownConsecutiveLowLoadChecks(1)
            .setMaxScaleUpPercent(30)
            .setMaxScaleDownChannels(2)
            .setDrainIdleGrace(Duration.ofMinutes(1))
            .setChannelPrimer(primer)
            .setChannelPrimeTimeout(primeTimeout)
            .setChannelPrimeMaxAttempts(primeMaxAttempts)
            .build();
    return (GcpManagedChannel)
        GcpManagedChannelBuilder.forDelegateBuilder(delegate)
            .withOptions(
                GcpManagedChannelOptions.newBuilder().withChannelPoolOptions(poolOptions).build())
            .build();
  }

  private static void awaitCondition(java.util.concurrent.Callable<Boolean> condition) {
    await().atMost(Duration.ofSeconds(5)).until(condition);
  }
}

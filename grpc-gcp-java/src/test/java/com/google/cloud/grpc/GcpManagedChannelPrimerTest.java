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
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.ConnectivityState;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
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

/** Channel-primer behavior tests. */
@RunWith(JUnit4.class)
public final class GcpManagedChannelPrimerTest {
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
    assertThat(primerThread.get()).startsWith("gcp-mc-prime-");
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
  public void secondScaleUpCountsChannelsStillPriming() throws Exception {
    AtomicInteger builtChannels = new AtomicInteger();
    List<SettableFuture<Void>> primeFutures = new CopyOnWriteArrayList<>();
    GcpManagedChannelTest.FakeManagedChannelBuilder delegate =
        new GcpManagedChannelTest.FakeManagedChannelBuilder(
            () -> {
              builtChannels.incrementAndGet();
              return new GcpManagedChannelTest.FakeManagedChannel(stateExecutor);
            });
    GcpChannelPrimer primer =
        channel -> {
          SettableFuture<Void> future = SettableFuture.create();
          primeFutures.add(future);
          return future;
        };
    pool = newPrimedPool(2, 4, primer, Duration.ofSeconds(5), 1, delegate);
    AtomicLong clock = new AtomicLong(1);
    pool.setNanoClock(clock::get);
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(6);

    hot.activeStreamsCountIncr();
    awaitCondition(() -> primeFutures.size() == 2);
    awaitCondition(() -> !pool.scaleUpWorkerRunningForTest());
    assertThat(pool.inFlightPrimeCountForTest()).isEqualTo(2);

    clock.incrementAndGet();
    hot.activeStreamsCountIncr();
    awaitCondition(() -> !pool.scaleUpWorkerRunningForTest());

    assertThat(builtChannels.get()).isEqualTo(4);
    assertThat(primeFutures).hasSize(2);
    assertThat(pool.getNumberOfChannels() + pool.inFlightPrimeCountForTest()).isEqualTo(4);
    primeFutures.forEach(future -> future.set(null));
    awaitCondition(() -> pool.getNumberOfChannels() == 4);
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
  public void primerTimeoutIncludesBlockingInvocation() throws Exception {
    CountDownLatch primerEntered = new CountDownLatch(1);
    CountDownLatch releasePrimer = new CountDownLatch(1);
    SettableFuture<Void> lateFuture = SettableFuture.create();
    AtomicInteger primeCalls = new AtomicInteger();
    AtomicReference<String> primerThread = new AtomicReference<>();
    AtomicReference<GcpManagedChannelTest.FakeManagedChannel> rejected = new AtomicReference<>();
    GcpChannelPrimer primer =
        channel -> {
          if (primeCalls.incrementAndGet() > 1) {
            return Futures.immediateVoidFuture();
          }
          primerThread.set(Thread.currentThread().getName());
          rejected.set((GcpManagedChannelTest.FakeManagedChannel) channel);
          primerEntered.countDown();
          boolean interrupted = false;
          while (true) {
            try {
              releasePrimer.await();
              break;
            } catch (InterruptedException failure) {
              interrupted = true;
            }
          }
          if (interrupted) {
            Thread.currentThread().interrupt();
          }
          return lateFuture;
        };
    pool = newPrimedPool(primer, Duration.ofMillis(20), 3, builder());
    AtomicLong clock = new AtomicLong(1);
    pool.setNanoClock(clock::get);
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(6);

    hot.activeStreamsCountIncr();

    assertThat(primerEntered.await(5, TimeUnit.SECONDS)).isTrue();
    try {
      // A primer blocked inside prime() fails at the timeout and is not retried: nothing can stop
      // the running call and a fresh attempt would overlap it on the same channel.
      awaitCondition(() -> pool.scaleUpPrimeFailuresForTest() == 1);
      awaitCondition(() -> pool.inFlightPrimeCountForTest() == 0);
      assertThat(pool.getNumberOfChannels()).isEqualTo(2);
      awaitCondition(() -> rejected.get() != null && rejected.get().isShutdown());
      assertThat(primeCalls.get()).isEqualTo(1);
      // The blocked call holds a primer thread, never one of the shared scheduler's threads.
      assertThat(primerThread.get()).startsWith("gcp-mc-prime-");
      awaitCondition(() -> !pool.scaleUpWorkerRunningForTest());
      // While the call is still blocked it keeps its scale-up slot, so the pool (2 of 3) does not
      // build another delegate and hand it to the same stuck primer.
      assertThat(pool.abandonedPrimeCountForTest()).isEqualTo(1);
      clock.incrementAndGet();
      hot.activeStreamsCountIncr();
      awaitCondition(() -> !pool.scaleUpWorkerRunningForTest());
      assertThat(primeCalls.get()).isEqualTo(1);
      assertThat(pool.inFlightPrimeCountForTest()).isEqualTo(0);
    } finally {
      releasePrimer.countDown();
    }

    // Once the blocked call returns, its late future is cancelled without publishing, the slot is
    // released, and the next scale-up primes a fresh delegate.
    awaitCondition(lateFuture::isCancelled);
    awaitCondition(() -> pool.abandonedPrimeCountForTest() == 0);
    assertThat(pool.getNumberOfChannels()).isEqualTo(2);
    assertThat(pool.inFlightPrimeCountForTest()).isEqualTo(0);
    clock.incrementAndGet();
    hot.activeStreamsCountIncr();
    awaitCondition(() -> pool.getNumberOfChannels() == 3);
    assertThat(primeCalls.get()).isEqualTo(2);
    assertThat(pool.scaleUpPrimeFailuresForTest()).isEqualTo(1);
  }

  @Test
  public void throwingAndNullPrimersRejectChannels() throws Exception {
    AtomicInteger primeCalls = new AtomicInteger();
    GcpChannelPrimer primer =
        channel -> {
          if (primeCalls.incrementAndGet() == 1) {
            throw new IllegalStateException("prime threw");
          }
          return null;
        };
    pool = newPrimedPool(primer, Duration.ofSeconds(5), 1, builder());
    AtomicLong clock = new AtomicLong(1);
    pool.setNanoClock(clock::get);
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(6);

    hot.activeStreamsCountIncr();
    awaitCondition(() -> pool.scaleUpPrimeFailuresForTest() == 1);
    awaitCondition(() -> !pool.scaleUpWorkerRunningForTest());
    clock.incrementAndGet();
    hot.activeStreamsCountIncr();

    awaitCondition(() -> pool.scaleUpPrimeFailuresForTest() == 2);
    assertThat(primeCalls.get()).isEqualTo(2);
    assertThat(pool.inFlightPrimeCountForTest()).isEqualTo(0);
    assertThat(pool.getNumberOfChannels()).isEqualTo(2);
  }

  @Test
  public void successfulPrimeIsDiscardedWhenPoolAlreadyAtMaximum() throws Exception {
    SettableFuture<Void> primeFuture = SettableFuture.create();
    AtomicReference<GcpManagedChannelTest.FakeManagedChannel> primingChannel =
        new AtomicReference<>();
    GcpChannelPrimer primer =
        channel -> {
          primingChannel.set((GcpManagedChannelTest.FakeManagedChannel) channel);
          return primeFuture;
        };
    pool = newPrimedPool(primer, Duration.ofSeconds(5), 1, builder());
    ChannelRef hot = pool.channelRefs.get(0);
    hot.setActiveStreamsForTest(6);

    hot.activeStreamsCountIncr();
    awaitCondition(() -> primingChannel.get() != null);
    pool.createNewChannel();
    assertThat(pool.getNumberOfChannels()).isEqualTo(3);
    primeFuture.set(null);

    awaitCondition(() -> pool.inFlightPrimeCountForTest() == 0);
    awaitCondition(() -> primingChannel.get().isShutdown());
    assertThat(pool.getNumberOfChannels()).isEqualTo(3);
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
  public void scaledChannelAfterDrainRunsPrimer() throws Exception {
    AtomicInteger primeCalls = new AtomicInteger();
    GcpChannelPrimer primer =
        channel -> {
          primeCalls.incrementAndGet();
          return Futures.immediateVoidFuture();
        };
    pool = newPrimedPool(primer, Duration.ofSeconds(5), builder());
    assertThat(primeCalls.get()).isEqualTo(0);
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
    assertThat(primeCalls.get()).isEqualTo(1);
  }

  private GcpManagedChannelTest.FakeManagedChannelBuilder builder() {
    return new GcpManagedChannelTest.FakeManagedChannelBuilder(
        () -> new GcpManagedChannelTest.FakeManagedChannel(stateExecutor));
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

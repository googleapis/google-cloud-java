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

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.ManagedChannel;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Direct {@link GcpChannelPrimeController} tests for the interleavings a pool-level test cannot
 * force: they hand the controller a scheduler whose timers never fire on their own, so a test can
 * run the timeout of an attempt at a moment of its choosing.
 */
@RunWith(JUnit4.class)
public final class GcpChannelPrimeControllerTest {
  private final ExecutorService stateExecutor = Executors.newSingleThreadExecutor();
  private final RecordingScheduler scheduler = new RecordingScheduler();
  private final Object lock = new Object();
  private final FakePool pool = new FakePool(lock);

  @After
  public void tearDown() {
    scheduler.shutdownNow();
    stateExecutor.shutdownNow();
  }

  @Test
  public void poolCallbacksObserveTheLockContract() throws Exception {
    AtomicInteger primeCalls = new AtomicInteger();
    GcpChannelPrimer primer =
        channel ->
            primeCalls.incrementAndGet() == 1
                ? Futures.immediateFailedFuture(new IllegalStateException("prime failed"))
                : Futures.immediateVoidFuture();
    GcpChannelPrimeController controller = newController(primer, 1);

    controller.startPrime(newChannel());
    awaitCondition(() -> pool.failures.size() == 1);
    controller.startPrime(newChannel());
    awaitCondition(() -> pool.published.size() == 1);

    assertThat(pool.lockViolations).isEmpty();
    assertThat(pool.abandonReports.get()).isEqualTo(0);
    synchronized (lock) {
      assertThat(controller.inFlightCount()).isEqualTo(0);
    }
  }

  @Test
  public void timeoutAfterPrimeReturnsCancelsTheLateFutureAndRetries() throws Exception {
    CountDownLatch primerEntered = new CountDownLatch(1);
    CountDownLatch releasePrimer = new CountDownLatch(1);
    SettableFuture<Void> lateFuture = SettableFuture.create();
    AtomicInteger primeCalls = new AtomicInteger();
    AtomicReference<Thread> primerThread = new AtomicReference<>();
    GcpChannelPrimer primer =
        channel -> {
          if (primeCalls.incrementAndGet() > 1) {
            return Futures.immediateVoidFuture();
          }
          primerThread.set(Thread.currentThread());
          primerEntered.countDown();
          awaitUninterruptibly(releasePrimer);
          return lateFuture;
        };
    GcpChannelPrimeController controller = newController(primer, 3);
    FakeChannel channel = newChannel();

    controller.startPrime(channel);
    assertThat(primerEntered.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(scheduler.tasks).hasSize(1);
    Runnable timeout = scheduler.tasks.get(0);

    try {
      synchronized (lock) {
        // prime() returns while this thread holds the pool lock, so the primer thread parks on
        // the monitor before it can record the returned future.
        releasePrimer.countDown();
        awaitCondition(() -> primerThread.get().getState() == Thread.State.BLOCKED);
        // The timeout wins that race. prime() has returned, so this is an ordinary timed-out
        // attempt: it must not be abandoned without a retry.
        timeout.run();
        assertThat(controller.abandonedCount()).isEqualTo(0);
        assertThat(controller.inFlightCount()).isEqualTo(1);
      }
    } finally {
      releasePrimer.countDown();
    }

    // The primer thread then sees the attempt has moved on and cancels the late future.
    awaitCondition(lateFuture::isCancelled);
    assertThat(pool.abandonReports.get()).isEqualTo(0);
    assertThat(pool.failures).isEmpty();
    assertThat(channel.isShutdown()).isFalse();
    awaitCondition(() -> scheduler.tasks.size() == 2);
    Runnable retry = scheduler.tasks.get(1);

    retry.run();

    awaitCondition(() -> pool.published.size() == 1);
    assertThat(pool.published.get(0)).isSameInstanceAs(channel);
    assertThat(primeCalls.get()).isEqualTo(2);
    assertThat(pool.lockViolations).isEmpty();
  }

  @Test
  public void timeoutBeforePrimeEntryRefusesTheExpiredAttempt() throws Exception {
    CountDownLatch timeoutArmed = new CountDownLatch(1);
    AtomicInteger primeCalls = new AtomicInteger();
    AtomicReference<Thread> primerThread = new AtomicReference<>();
    GcpChannelPrimer primer =
        channel -> {
          primeCalls.incrementAndGet();
          return Futures.immediateVoidFuture();
        };
    GcpChannelPrimeController controller = newController(primer, 1);
    FakeChannel channel = newChannel();
    // Arming the timeout is the primer thread's last step under the pool lock before it enters
    // prime(). Park it there with the lock released, exactly as if it had been descheduled between
    // dropping the lock and entering prime(), until the test lets it go.
    scheduler.onSchedule =
        () -> {
          primerThread.set(Thread.currentThread());
          timeoutArmed.countDown();
          synchronized (lock) {
            while (!scheduler.releaseParkedThread) {
              awaitUninterruptibly(lock);
            }
          }
        };

    controller.startPrime(channel);
    assertThat(timeoutArmed.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(scheduler.tasks).hasSize(1);
    // The timeout wins that race: it runs to completion, releasing the slot and closing the
    // channel, before the primer thread gets to move on.
    scheduler.execute(scheduler.tasks.get(0));
    awaitCondition(() -> pool.failures.size() == 1);
    assertThat(channel.isShutdown()).isTrue();
    synchronized (lock) {
      assertThat(controller.inFlightCount()).isEqualTo(0);
      assertThat(controller.abandonedCount()).isEqualTo(0);
      scheduler.releaseParkedThread = true;
      lock.notifyAll();
    }

    // The primer thread then finds its attempt expired and returns to the pool without ever
    // calling prime(): idle pool threads wait on a timed poll, unlike a parked or blocked primer.
    awaitCondition(
        () -> {
          Thread.State state = primerThread.get().getState();
          return state == Thread.State.TIMED_WAITING || state == Thread.State.TERMINATED;
        });
    assertThat(primeCalls.get()).isEqualTo(0);
    assertThat(pool.failures).hasSize(1);
    assertThat(pool.abandonReports.get()).isEqualTo(0);
    assertThat(pool.published).isEmpty();
    assertThat(scheduler.tasks).hasSize(1);
    synchronized (lock) {
      assertThat(controller.primingCount()).isEqualTo(0);
    }
    assertThat(pool.lockViolations).isEmpty();
  }

  @Test
  public void timeoutWhileBlockedInPrimeAbandonsAndReportsOutsideTheLock() throws Exception {
    CountDownLatch primerEntered = new CountDownLatch(1);
    CountDownLatch releasePrimer = new CountDownLatch(1);
    SettableFuture<Void> lateFuture = SettableFuture.create();
    GcpChannelPrimer primer =
        channel -> {
          primerEntered.countDown();
          awaitUninterruptibly(releasePrimer);
          return lateFuture;
        };
    GcpChannelPrimeController controller = newController(primer, 3);
    FakeChannel channel = newChannel();

    controller.startPrime(channel);
    assertThat(primerEntered.await(5, TimeUnit.SECONDS)).isTrue();
    try {
      scheduler.tasks.get(0).run();

      assertThat(pool.abandonReports.get()).isEqualTo(1);
      assertThat(pool.failures).hasSize(1);
      assertThat(channel.isShutdown()).isTrue();
      assertThat(scheduler.tasks).hasSize(1);
      synchronized (lock) {
        assertThat(controller.abandonedCount()).isEqualTo(1);
        assertThat(controller.inFlightCount()).isEqualTo(0);
      }
    } finally {
      releasePrimer.countDown();
    }
    awaitCondition(lateFuture::isCancelled);
    synchronized (lock) {
      assertThat(controller.abandonedCount()).isEqualTo(0);
    }
    assertThat(pool.lockViolations).isEmpty();
  }

  @Test
  public void timeoutWhileBlockedInPrimeDuringShutdownDoesNotReportAbandoning() throws Exception {
    CountDownLatch primerEntered = new CountDownLatch(1);
    CountDownLatch releasePrimer = new CountDownLatch(1);
    SettableFuture<Void> lateFuture = SettableFuture.create();
    GcpChannelPrimer primer =
        channel -> {
          primerEntered.countDown();
          awaitUninterruptibly(releasePrimer);
          return lateFuture;
        };
    GcpChannelPrimeController controller = newController(primer, 3);
    FakeChannel channel = newChannel();

    controller.startPrime(channel);
    assertThat(primerEntered.await(5, TimeUnit.SECONDS)).isTrue();
    try {
      pool.shuttingDown = true;
      scheduler.tasks.get(0).run();

      assertThat(pool.abandonReports.get()).isEqualTo(0);
      assertThat(pool.failures).isEmpty();
      assertThat(channel.isShutdown()).isTrue();
      synchronized (lock) {
        assertThat(controller.abandonedCount()).isEqualTo(0);
        assertThat(controller.inFlightCount()).isEqualTo(0);
      }
    } finally {
      releasePrimer.countDown();
    }
    awaitCondition(lateFuture::isCancelled);
    assertThat(pool.lockViolations).isEmpty();
  }

  private GcpChannelPrimeController newController(GcpChannelPrimer primer, int maxAttempts) {
    return new GcpChannelPrimeController(
        lock, pool, primer, TimeUnit.SECONDS.toNanos(5), maxAttempts, scheduler);
  }

  private FakeChannel newChannel() {
    return new FakeChannel(stateExecutor);
  }

  private static void awaitCondition(Callable<Boolean> condition) {
    await().atMost(Duration.ofSeconds(5)).until(condition);
  }

  private static void awaitUninterruptibly(CountDownLatch latch) {
    boolean interrupted = false;
    while (true) {
      try {
        latch.await();
        break;
      } catch (InterruptedException failure) {
        interrupted = true;
      }
    }
    if (interrupted) {
      Thread.currentThread().interrupt();
    }
  }

  /**
   * One {@link Object#wait()} on {@code monitor}, which the caller must hold; may wake spuriously.
   */
  private static void awaitUninterruptibly(Object monitor) {
    try {
      monitor.wait();
    } catch (InterruptedException failure) {
      Thread.currentThread().interrupt();
    }
  }

  private static final class FakeChannel extends GcpManagedChannelTest.FakeManagedChannel {
    FakeChannel(ExecutorService exec) {
      super(exec);
    }
  }

  /** Records every pool callback together with whether it honored its lock contract. */
  private static final class FakePool implements GcpChannelPrimeController.Pool {
    private final Object lock;
    volatile boolean shuttingDown;
    volatile boolean full;
    final List<ManagedChannel> published = new CopyOnWriteArrayList<>();
    final List<Throwable> failures = new CopyOnWriteArrayList<>();
    final AtomicInteger abandonReports = new AtomicInteger();
    final List<String> lockViolations = new CopyOnWriteArrayList<>();

    FakePool(Object lock) {
      this.lock = lock;
    }

    @Override
    public boolean isShuttingDown() {
      expectLock("isShuttingDown", true);
      return shuttingDown;
    }

    @Override
    public boolean isFull() {
      expectLock("isFull", true);
      return full;
    }

    @Override
    public void addPrimedChannel(ManagedChannel channel) {
      expectLock("addPrimedChannel", true);
      published.add(channel);
    }

    @Override
    public void reportPrimeFailure(Throwable failure) {
      expectLock("reportPrimeFailure", false);
      failures.add(failure);
    }

    @Override
    public void reportPrimeAbandoned() {
      expectLock("reportPrimeAbandoned", false);
      abandonReports.incrementAndGet();
    }

    private void expectLock(String method, boolean held) {
      if (Thread.holdsLock(lock) != held) {
        lockViolations.add(
            method + (held ? " called without the pool lock" : " called under the pool lock"));
      }
    }
  }

  /**
   * Runs immediate work on a real thread but only records delayed tasks, leaving it to the test to
   * run a timeout or retry at the moment under test.
   */
  private static final class RecordingScheduler implements ScheduledExecutorService {
    private final ScheduledExecutorService delegate = Executors.newSingleThreadScheduledExecutor();
    final List<Runnable> tasks = new CopyOnWriteArrayList<>();
    // Runs on the scheduling thread once a delayed task is recorded, so a test can park that
    // thread at the moment it arms a timeout.
    @Nullable volatile Runnable onSchedule;
    // Guarded by the test's pool lock: set under it and announced with notifyAll().
    boolean releaseParkedThread;

    @Override
    public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
      tasks.add(command);
      Runnable hook = onSchedule;
      if (hook != null) {
        hook.run();
      }
      return delegate.schedule(() -> {}, 365, TimeUnit.DAYS);
    }

    @Override
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
      throw new UnsupportedOperationException();
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(
        Runnable command, long initialDelay, long period, TimeUnit unit) {
      throw new UnsupportedOperationException();
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(
        Runnable command, long initialDelay, long delay, TimeUnit unit) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void execute(Runnable command) {
      delegate.execute(command);
    }

    @Override
    public void shutdown() {
      delegate.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
      return delegate.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
      return delegate.isShutdown();
    }

    @Override
    public boolean isTerminated() {
      return delegate.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
      return delegate.awaitTermination(timeout, unit);
    }

    @Override
    public <T> java.util.concurrent.Future<T> submit(Callable<T> task) {
      return delegate.submit(task);
    }

    @Override
    public <T> java.util.concurrent.Future<T> submit(Runnable task, T result) {
      return delegate.submit(task, result);
    }

    @Override
    public java.util.concurrent.Future<?> submit(Runnable task) {
      return delegate.submit(task);
    }

    @Override
    public <T> List<java.util.concurrent.Future<T>> invokeAll(
        java.util.Collection<? extends Callable<T>> tasks) throws InterruptedException {
      return delegate.invokeAll(tasks);
    }

    @Override
    public <T> List<java.util.concurrent.Future<T>> invokeAll(
        java.util.Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
        throws InterruptedException {
      return delegate.invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(java.util.Collection<? extends Callable<T>> tasks)
        throws InterruptedException, java.util.concurrent.ExecutionException {
      return delegate.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(
        java.util.Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
        throws InterruptedException,
            java.util.concurrent.ExecutionException,
            java.util.concurrent.TimeoutException {
      return delegate.invokeAny(tasks, timeout, unit);
    }
  }
}

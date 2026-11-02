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

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import io.grpc.ManagedChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeoutException;
import java.util.function.LongUnaryOperator;
import javax.annotation.Nullable;

/**
 * Primes channels built by dynamic scale-up before they are published to the pool: each channel
 * gets a bounded number of {@link GcpChannelPrimer#prime} attempts, each under a timeout and with
 * backoff between them, and joins the pool only once an attempt succeeds.
 *
 * <p>All state is guarded by the pool's own monitor, passed in as {@code lock}, so publishing a
 * primed channel and shutting the pool down cannot race each other.
 */
final class GcpChannelPrimeController {

  /** The pool-side operations priming needs but cannot own. */
  interface Pool {
    /** Whether the pool has started shutting down. Called with the pool lock held. */
    boolean isShuttingDown();

    /**
     * Whether the pool already holds its maximum number of channels. Called with the pool lock
     * held.
     */
    boolean isFull();

    /** Publishes a successfully primed channel. Called with the pool lock held. */
    void addPrimedChannel(ManagedChannel channel);

    /** Records a channel rejected because priming failed. Called without the pool lock. */
    void reportPrimeFailure(Throwable failure);

    /**
     * Reports a prime abandoned without retry because its {@code prime()} call was still blocked at
     * the timeout: the channel is closed, but the call keeps occupying a primer thread and a
     * scale-up slot until it returns. Called without the pool lock, before {@link
     * #reportPrimeFailure} for the same channel.
     */
    void reportPrimeAbandoned();
  }

  static final class PendingPrime {
    private final ManagedChannel channel;
    private int attempt = -1;
    // The attempt is in its invocation phase: prime() has been dispatched and its returned future,
    // if any, has not been recorded yet.
    private boolean invoking;
    // The primer thread is inside primer.prime() right now. Set by that thread under the lock as
    // the last step before the call, once it has confirmed the attempt is still live, and cleared
    // without the lock as soon as the call returns, so the timeout can tell a call that has
    // already returned (recorded under the lock only later) from one that is still blocked.
    private volatile boolean insidePrime;
    private boolean finished;
    @Nullable private ListenableFuture<Void> future;
    @Nullable private ScheduledFuture<?> timeoutTask;
    @Nullable private ScheduledFuture<?> retryTask;

    private PendingPrime(ManagedChannel channel) {
      this.channel = channel;
    }
  }

  // Primer invocations run here so a primer that blocks inside prime() occupies a thread of its
  // own instead of starving the shared scheduler that drives scale-up, draining, and timeouts.
  private static final ExecutorService SHARED_PRIME_SERVICE =
      Executors.newCachedThreadPool(GcpThreadFactory.newThreadFactory("gcp-mc-prime-%d"));

  // The owning pool instance: every mutation below is made while synchronized on it.
  private final Object lock;
  private final Pool pool;
  private final GcpChannelPrimer primer;
  private final long timeoutNanos;
  private final int maxAttempts;
  private final ScheduledExecutorService scheduler;

  @GuardedBy("lock")
  private final Set<PendingPrime> pendingPrimes = new HashSet<>();

  // Primes whose prime() call was still blocked at its timeout. Each one still holds a primer
  // thread and its closed delegate until the call returns, so it keeps occupying a scale-up slot:
  // a primer that never returns can pin at most maxSize slots, never one thread per event.
  @GuardedBy("lock")
  private final Set<PendingPrime> abandonedPrimes = new HashSet<>();

  /**
   * @param lock the pool instance whose monitor guards this controller's state
   * @param pool the pool operations priming needs
   * @param scheduler runs timeouts, retries, and future callbacks
   */
  GcpChannelPrimeController(
      Object lock,
      Pool pool,
      GcpChannelPrimer primer,
      long timeoutNanos,
      int maxAttempts,
      ScheduledExecutorService scheduler) {
    this.lock = lock;
    this.pool = pool;
    this.primer = primer;
    this.timeoutNanos = timeoutNanos;
    this.maxAttempts = maxAttempts;
    this.scheduler = scheduler;
  }

  /**
   * The number of scale-up slots priming still occupies: channels being primed plus abandoned
   * primes whose blocked prime() call has not returned yet.
   */
  @GuardedBy("lock")
  int primingCount() {
    return pendingPrimes.size() + abandonedPrimes.size();
  }

  @GuardedBy("lock")
  int inFlightCount() {
    return pendingPrimes.size();
  }

  @GuardedBy("lock")
  int abandonedCount() {
    return abandonedPrimes.size();
  }

  /** Starts bounded asynchronous priming without holding the scale-up worker. */
  void startPrime(ManagedChannel channel) {
    PendingPrime pendingPrime = new PendingPrime(channel);
    synchronized (lock) {
      if (pool.isShuttingDown()) {
        channel.shutdownNow();
        return;
      }
      pendingPrimes.add(pendingPrime);
    }
    submitPrimeAttempt(pendingPrime, 0);
  }

  /**
   * Finishes every pending prime and releases the abandoned slots as part of pool shutdown. The
   * returned primes are still running; pass them to {@link #cancel} once the pool lock is released.
   */
  @GuardedBy("lock")
  List<PendingPrime> detachAll() {
    List<PendingPrime> primesToCancel = new ArrayList<>(pendingPrimes);
    primesToCancel.forEach(this::finishPendingPrime);
    // Abandoned delegates are already closed; no further scale-up can consult their slots.
    abandonedPrimes.clear();
    return primesToCancel;
  }

  /** Stops the work of primes returned by {@link #detachAll} and closes their channels. */
  void cancel(List<PendingPrime> pendingPrimes, boolean force) {
    for (PendingPrime pendingPrime : pendingPrimes) {
      if (pendingPrime.future != null) {
        pendingPrime.future.cancel(true);
      }
      if (pendingPrime.timeoutTask != null) {
        pendingPrime.timeoutTask.cancel(false);
      }
      if (pendingPrime.retryTask != null) {
        pendingPrime.retryTask.cancel(false);
      }
      if (force) {
        pendingPrime.channel.shutdownNow();
      } else {
        pendingPrime.channel.shutdown();
      }
    }
  }

  private void submitPrimeAttempt(PendingPrime pendingPrime, int attempt) {
    try {
      SHARED_PRIME_SERVICE.execute(() -> startPrimeAttempt(pendingPrime, attempt));
    } catch (RejectedExecutionException failure) {
      rejectPendingPrime(pendingPrime, failure);
    }
  }

  private void startPrimeAttempt(PendingPrime pendingPrime, int attempt) {
    Throwable schedulingFailure = null;
    synchronized (lock) {
      if (pendingPrime.finished) {
        return;
      }
      if (pool.isShuttingDown()) {
        finishPendingPrime(pendingPrime);
        pendingPrime.channel.shutdownNow();
        return;
      }
      pendingPrime.attempt = attempt;
      pendingPrime.invoking = true;
      pendingPrime.future = null;
      pendingPrime.retryTask = null;
      // The timeout is armed before prime() runs so it bounds the whole attempt, including a
      // primer that blocks instead of returning a future.
      try {
        pendingPrime.timeoutTask =
            scheduler.schedule(
                () ->
                    finishPrimeFailure(
                        pendingPrime,
                        attempt,
                        null,
                        new TimeoutException("Channel priming timed out"),
                        true),
                timeoutNanos,
                NANOSECONDS);
      } catch (RejectedExecutionException failure) {
        schedulingFailure = failure;
      }
    }
    if (schedulingFailure != null) {
      finishPrimeFailure(pendingPrime, attempt, null, schedulingFailure, false);
      return;
    }

    // The lock was released between arming the timeout and getting here, so the timeout (or a
    // shutdown) may already have finished this attempt and released its slot. Such a prime() call
    // would run untracked, so confirm the attempt is still live and mark it as inside prime()
    // under the same lock hold: a timeout that fires from now on sees insidePrime and abandons.
    synchronized (lock) {
      if (!isCurrentPrimeAttempt(pendingPrime, attempt, null)) {
        // Whoever finished the attempt owns the channel and the outcome.
        return;
      }
      pendingPrime.insidePrime = true;
    }

    ListenableFuture<Void> future;
    try {
      try {
        future = primer.prime(pendingPrime.channel);
      } finally {
        pendingPrime.insidePrime = false;
      }
      if (future == null) {
        throw new NullPointerException("Channel primer returned null");
      }
    } catch (Throwable failure) {
      synchronized (lock) {
        abandonedPrimes.remove(pendingPrime);
      }
      finishPrimeFailure(pendingPrime, attempt, null, failure, false);
      return;
    }

    boolean cancelFuture = false;
    boolean closeChannel = false;
    synchronized (lock) {
      abandonedPrimes.remove(pendingPrime);
      if (pendingPrime.finished
          || pendingPrime.attempt != attempt
          || !pendingPrime.invoking
          || pool.isShuttingDown()) {
        // The attempt timed out or the pool shut down while prime() was still running.
        cancelFuture = true;
        closeChannel = pendingPrime.finished || pool.isShuttingDown();
      } else {
        pendingPrime.invoking = false;
        pendingPrime.future = future;
      }
    }
    if (cancelFuture) {
      future.cancel(true);
      if (closeChannel) {
        pendingPrime.channel.shutdownNow();
      }
      return;
    }

    Futures.addCallback(
        future,
        new FutureCallback<Void>() {
          @Override
          public void onSuccess(@Nullable Void unused) {
            finishPrimeSuccess(pendingPrime, attempt, future);
          }

          @Override
          public void onFailure(Throwable failure) {
            finishPrimeFailure(pendingPrime, attempt, future, failure, false);
          }
        },
        scheduler);
  }

  private void finishPrimeSuccess(
      PendingPrime pendingPrime, int attempt, ListenableFuture<Void> future) {
    boolean surplus;
    synchronized (lock) {
      if (!isCurrentPrimeAttempt(pendingPrime, attempt, future)) {
        return;
      }
      cancelPrimeTimeout(pendingPrime);
      pendingPrime.future = null;
      finishPendingPrime(pendingPrime);
      surplus = pool.isShuttingDown() || pool.isFull();
      if (!surplus) {
        pool.addPrimedChannel(pendingPrime.channel);
      }
    }
    if (surplus) {
      pendingPrime.channel.shutdownNow();
    }
  }

  /**
   * Records a failed attempt. {@code future} identifies the attempt when the failure came from the
   * primer's future; {@code null} matches whichever phase the attempt is in, which is what the
   * timeout, a thrown {@code prime()}, and a scheduling rejection need. {@code timedOut} cancels a
   * still-running future and, when the primer is still blocked inside {@code prime()}, ends the
   * prime without a retry: nothing can stop that call and a fresh attempt would overlap it. A
   * timeout that fires before the primer thread entered {@code prime()} is an ordinary timed-out
   * attempt as well: the thread then sees the attempt is no longer live and never calls {@code
   * prime()} for it. A timeout that fires after {@code prime()} returned but before its future was
   * recorded is likewise ordinary: the worker cancels the late future and the attempt is retried.
   */
  private void finishPrimeFailure(
      PendingPrime pendingPrime,
      int attempt,
      @Nullable ListenableFuture<Void> future,
      Throwable failure,
      boolean timedOut) {
    boolean finalFailure = false;
    boolean publishFailure = false;
    boolean reportAbandoned = false;
    ListenableFuture<Void> futureToCancel = null;
    synchronized (lock) {
      if (!isCurrentPrimeAttempt(pendingPrime, attempt, future)) {
        return;
      }
      boolean shuttingDown = pool.isShuttingDown();
      boolean blockedInPrimer = timedOut && pendingPrime.invoking && pendingPrime.insidePrime;
      futureToCancel = timedOut ? pendingPrime.future : null;
      pendingPrime.invoking = false;
      pendingPrime.future = null;
      cancelPrimeTimeout(pendingPrime);
      if (blockedInPrimer || shuttingDown || attempt + 1 >= maxAttempts) {
        finishPendingPrime(pendingPrime);
        if (blockedInPrimer && !shuttingDown) {
          abandonedPrimes.add(pendingPrime);
          reportAbandoned = true;
        }
        finalFailure = true;
        publishFailure = !shuttingDown;
      } else {
        long delayMillis = backoffMillis(attempt);
        try {
          pendingPrime.retryTask =
              scheduler.schedule(
                  () -> submitPrimeAttempt(pendingPrime, attempt + 1), delayMillis, MILLISECONDS);
        } catch (RejectedExecutionException rejected) {
          failure.addSuppressed(rejected);
          finishPendingPrime(pendingPrime);
          finalFailure = true;
          publishFailure = true;
        }
      }
    }
    if (futureToCancel != null) {
      futureToCancel.cancel(true);
    }
    if (finalFailure) {
      pendingPrime.channel.shutdownNow();
      if (reportAbandoned) {
        pool.reportPrimeAbandoned();
      }
      if (publishFailure) {
        pool.reportPrimeFailure(failure);
      }
    }
  }

  private void rejectPendingPrime(PendingPrime pendingPrime, Throwable failure) {
    boolean publishFailure;
    synchronized (lock) {
      if (pendingPrime.finished) {
        return;
      }
      finishPendingPrime(pendingPrime);
      publishFailure = !pool.isShuttingDown();
    }
    pendingPrime.channel.shutdownNow();
    if (publishFailure) {
      pool.reportPrimeFailure(failure);
    }
  }

  @GuardedBy("lock")
  private boolean isCurrentPrimeAttempt(
      PendingPrime pendingPrime, int attempt, @Nullable ListenableFuture<Void> future) {
    if (pendingPrime.finished || pendingPrime.attempt != attempt) {
      return false;
    }
    if (future == null) {
      // Any live phase of this attempt: still inside prime(), or waiting on its future.
      return pendingPrime.invoking || pendingPrime.future != null;
    }
    return pendingPrime.future == future;
  }

  @GuardedBy("lock")
  private void cancelPrimeTimeout(PendingPrime pendingPrime) {
    if (pendingPrime.timeoutTask != null) {
      pendingPrime.timeoutTask.cancel(false);
      pendingPrime.timeoutTask = null;
    }
  }

  @GuardedBy("lock")
  private void finishPendingPrime(PendingPrime pendingPrime) {
    if (!pendingPrime.finished) {
      pendingPrime.finished = true;
      pendingPrimes.remove(pendingPrime);
    }
  }

  private static final long MAX_BACKOFF_MILLIS = 5000L;

  /**
   * Exponential backoff base for the given retry attempt, capped at {@link #MAX_BACKOFF_MILLIS}.
   */
  @VisibleForTesting
  static long baseBackoffMillis(int attempt) {
    return Math.min(100L << Math.min(attempt, 12), MAX_BACKOFF_MILLIS);
  }

  /**
   * Retry delay with equal jitter: half the exponential base plus a random share of the other half,
   * so concurrent prime retries across channels do not fire in lockstep.
   */
  static long backoffMillis(int attempt) {
    return backoffMillis(attempt, bound -> ThreadLocalRandom.current().nextLong(bound));
  }

  /**
   * @param random returns a uniformly distributed value in {@code [0, bound)} for a positive bound
   */
  @VisibleForTesting
  static long backoffMillis(int attempt, LongUnaryOperator random) {
    long base = baseBackoffMillis(attempt);
    long half = base / 2;
    long jitter = half > 0 ? random.applyAsLong(half) : 0L;
    return Math.min(half + jitter, MAX_BACKOFF_MILLIS);
  }
}

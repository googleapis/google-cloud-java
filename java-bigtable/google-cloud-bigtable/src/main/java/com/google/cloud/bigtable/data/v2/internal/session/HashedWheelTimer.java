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
package com.google.cloud.bigtable.data.v2.internal.session;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * {@link BigtableTimer} backed by a single-thread hashed wheel — same algorithm as Netty's {@code
 * HashedWheelTimer} but with no Netty dependency. Tick = {@value #TICK_DURATION_MS} ms, {@value
 * #TICKS_PER_WHEEL} buckets, so one full rotation is ~5 s.
 *
 * <p>Insert is O(1): the new {@link Timeout} is enqueued onto an MPSC pending queue and bucketed by
 * the tick thread on the next tick. Cancel is O(1): a single state CAS marks the entry cancelled,
 * and the worker unlinks it the next time the bucket is swept (so a cancelled entry holds memory
 * for at most one wheel rotation).
 *
 * <p>The worker thread only advances the wheel and hops fires to the caller-supplied {@link
 * Executor}; user code never runs on the tick thread.
 */
public final class HashedWheelTimer implements BigtableTimer {
  private static final Logger LOG = Logger.getLogger(HashedWheelTimer.class.getName());

  static final long TICK_DURATION_MS = 10;
  static final int TICKS_PER_WHEEL = 512; // must be a power of two
  private static final long TICK_DURATION_NANOS = TimeUnit.MILLISECONDS.toNanos(TICK_DURATION_MS);
  private static final int MASK = TICKS_PER_WHEEL - 1;
  // Bound transfers per tick so a sustained insert flood can't starve bucket processing.
  private static final int MAX_PENDING_TRANSFERS_PER_TICK = 100_000;

  private final HashedWheelBucket[] wheel = new HashedWheelBucket[TICKS_PER_WHEEL];
  private final Queue<HashedWheelTimeout> pendingTimeouts = new ConcurrentLinkedQueue<>();
  private final Set<Runnable> stopHooks = ConcurrentHashMap.newKeySet();

  private final Thread worker;
  private final long startNanos;

  private volatile boolean stopped = false;

  public HashedWheelTimer(String name) {
    for (int i = 0; i < TICKS_PER_WHEEL; i++) {
      wheel[i] = new HashedWheelBucket();
    }
    this.startNanos = System.nanoTime();
    this.worker =
        new ThreadFactoryBuilder()
            .setNameFormat(name + "-%d")
            .setDaemon(true)
            .build()
            .newThread(this::workerLoop);
    this.worker.start();
  }

  @Override
  public Timeout newTimeout(Runnable task, Executor executor, long delay, TimeUnit unit) {
    if (stopped) {
      throw new IllegalStateException("timer stopped");
    }
    long delayNanos = Math.max(0L, unit.toNanos(delay));
    long deadlineNanos = (System.nanoTime() - startNanos) + delayNanos;
    HashedWheelTimeout timeout = new HashedWheelTimeout(task, executor, deadlineNanos);
    pendingTimeouts.add(timeout);
    return timeout;
  }

  @Override
  public Registration onStop(Runnable hook) {
    if (stopped) {
      throw new IllegalStateException("timer stopped");
    }
    stopHooks.add(hook);
    return () -> stopHooks.remove(hook);
  }

  @Override
  public void stop() {
    if (stopped) {
      return;
    }
    stopped = true;
    Set<Runnable> hooks = new HashSet<>(stopHooks);
    stopHooks.clear();
    for (Runnable hook : hooks) {
      try {
        hook.run();
      } catch (Throwable t) {
        LOG.log(Level.WARNING, "stop hook threw; continuing", t);
      }
    }
    worker.interrupt();
  }

  private void workerLoop() {
    long tick = 0;
    while (!stopped) {
      if (waitForNextTick(tick) < 0) {
        return;
      }
      transferPending(tick);
      wheel[(int) (tick & MASK)].expireTimeouts();
      tick++;
    }
  }

  // Returns elapsed nanos since startNanos at wake, or -1 if the timer was stopped.
  private long waitForNextTick(long tick) {
    long targetNanos = (tick + 1) * TICK_DURATION_NANOS;
    while (true) {
      long elapsed = System.nanoTime() - startNanos;
      long sleepNanos = targetNanos - elapsed;
      if (sleepNanos <= 0) {
        return elapsed;
      }
      if (stopped) {
        return -1;
      }
      long sleepMs = (sleepNanos + 999_999L) / 1_000_000L;
      try {
        Thread.sleep(sleepMs);
      } catch (InterruptedException e) {
        if (stopped) {
          return -1;
        }
        // Spurious interrupt; recompute and keep sleeping.
      }
    }
  }

  private void transferPending(long tick) {
    for (int i = 0; i < MAX_PENDING_TRANSFERS_PER_TICK; i++) {
      HashedWheelTimeout t = pendingTimeouts.poll();
      if (t == null) {
        return;
      }
      if (t.isCancelled()) {
        continue;
      }
      long calculated = t.deadlineNanos / TICK_DURATION_NANOS;
      t.remainingRounds = Math.max(0L, (calculated - tick) / TICKS_PER_WHEEL);
      // If the deadline is already past, place the entry in the current bucket so it fires now.
      long ticksTarget = Math.max(calculated, tick);
      wheel[(int) (ticksTarget & MASK)].add(t);
    }
  }

  // Bucket: singly-traversed doubly-linked list, mutated only on the worker thread.
  private static final class HashedWheelBucket {
    private HashedWheelTimeout head;
    private HashedWheelTimeout tail;

    void add(HashedWheelTimeout t) {
      t.bucket = this;
      if (head == null) {
        head = tail = t;
      } else {
        tail.next = t;
        t.prev = tail;
        tail = t;
      }
    }

    void expireTimeouts() {
      HashedWheelTimeout t = head;
      while (t != null) {
        HashedWheelTimeout next = t.next;
        if (t.isCancelled()) {
          unlink(t);
        } else if (t.remainingRounds <= 0) {
          unlink(t);
          t.expire();
        } else {
          t.remainingRounds--;
        }
        t = next;
      }
    }

    private void unlink(HashedWheelTimeout t) {
      HashedWheelTimeout p = t.prev;
      HashedWheelTimeout n = t.next;
      if (p != null) {
        p.next = n;
      }
      if (n != null) {
        n.prev = p;
      }
      if (t == head) {
        head = n;
      }
      if (t == tail) {
        tail = p;
      }
      t.prev = null;
      t.next = null;
      t.bucket = null;
    }
  }

  private static final class HashedWheelTimeout implements Timeout {
    private static final int STATE_INIT = 0;
    private static final int STATE_CANCELLED = 1;
    private static final int STATE_EXPIRED = 2;

    private static final AtomicIntegerFieldUpdater<HashedWheelTimeout> STATE_UPDATER =
        AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimeout.class, "state");

    private final Runnable task;
    private final Executor executor;
    final long deadlineNanos;

    volatile int state = STATE_INIT;
    // Worker-thread only:
    long remainingRounds;
    HashedWheelTimeout next;
    HashedWheelTimeout prev;
    HashedWheelBucket bucket;

    HashedWheelTimeout(Runnable task, Executor executor, long deadlineNanos) {
      this.task = task;
      this.executor = executor;
      this.deadlineNanos = deadlineNanos;
    }

    @Override
    public boolean cancel() {
      return STATE_UPDATER.compareAndSet(this, STATE_INIT, STATE_CANCELLED);
    }

    @Override
    public boolean isCancelled() {
      return state == STATE_CANCELLED;
    }

    void expire() {
      if (!STATE_UPDATER.compareAndSet(this, STATE_INIT, STATE_EXPIRED)) {
        // Lost a race with cancel() between transferPending and this sweep.
        return;
      }
      try {
        executor.execute(task);
      } catch (Throwable t) {
        LOG.log(Level.WARNING, "executor.execute threw; dropping task", t);
      }
    }
  }
}

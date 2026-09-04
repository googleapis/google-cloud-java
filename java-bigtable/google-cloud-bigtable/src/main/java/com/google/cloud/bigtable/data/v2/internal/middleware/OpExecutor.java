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

package com.google.cloud.bigtable.data.v2.internal.middleware;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/**
 * Per-op serializing executor that tracks which thread is currently draining it, so callers can
 * assert they are running inside the executor (analogous to {@code
 * SynchronizationContext#throwIfNotInThisSynchronizationContext}).
 *
 * <p>{@link #runInline} executes synchronously on the caller thread when the executor is idle, or
 * falls back to a queued submission when busy. Use it to avoid the queue+drain round-trip for the
 * first task of a fresh op executor (e.g. the start() dispatch).
 *
 * <p>If a task throws, the registered {@link UncaughtExceptionHandler} is invoked on the same task
 * thread (still inside the drain wrapper, so {@link #throwIfNotInThisExecutor} still passes). This
 * is the last-resort recovery point for the op chain — without it, an exception inside a callback
 * is silently dropped and the caller's listener never sees a terminal close. The handler's own
 * throws propagate (caught by the backing executor in production; surfaced to the calling thread
 * when the backing is {@link MoreExecutors#directExecutor()}, which is what makes fail-fast test
 * handlers like {@code t -> throw new AssertionError(t)} work).
 */
public final class OpExecutor implements Executor {

  public interface UncaughtExceptionHandler {
    void uncaught(Throwable t);
  }

  private final Executor backing;
  private final UncaughtExceptionHandler handler;

  // queue is the lock. runningThread is volatile (not @GuardedBy): throwIfNotInThisExecutor()
  // reads it lock-free; writes happen inside synchronized(queue) to piggy-back the memory barrier.
  @GuardedBy("queue")
  private final ArrayDeque<Runnable> queue = new ArrayDeque<>();

  @GuardedBy("queue")
  private boolean drainScheduled = false;

  private volatile Thread runningThread;

  public OpExecutor(Executor backing, UncaughtExceptionHandler handler) {
    this.backing = backing;
    this.handler = handler;
  }

  @Override
  public void execute(Runnable r) {
    synchronized (queue) {
      queue.add(r);
      if (!drainScheduled && runningThread == null) {
        scheduleDrainLocked();
      }
    }
  }

  /**
   * Runs {@code r} synchronously on the caller thread if this executor is idle, otherwise queues it
   * for later drain on the backing executor. Either way, FIFO ordering with other tasks is
   * preserved.
   */
  public void runInline(Runnable r) {
    synchronized (queue) {
      if (drainScheduled || runningThread != null || !queue.isEmpty()) {
        queue.add(r);
        // Same guard as execute(): if another thread is running inline, don't schedule a drain —
        // its finally block will schedule one when the queue is non-empty. Scheduling here would
        // let drain() run concurrently with the inline task, breaking serialization.
        if (!drainScheduled && runningThread == null) {
          scheduleDrainLocked();
        }
        return;
      }
      runningThread = Thread.currentThread();
    }
    try {
      try {
        r.run();
      } catch (Throwable t) {
        handler.uncaught(t);
      }
    } finally {
      synchronized (queue) {
        runningThread = null;
        if (!queue.isEmpty() && !drainScheduled) {
          scheduleDrainLocked();
        }
      }
    }
  }

  // Schedule a drain on the backing executor. If the backing throws (e.g.
  // RejectedExecutionException
  // during shutdown), reset drainScheduled before propagating so the next execute() can retry
  // instead of wedging the executor with no drainer.
  @GuardedBy("queue")
  private void scheduleDrainLocked() {
    drainScheduled = true;
    try {
      backing.execute(this::drain);
    } catch (Throwable t) {
      drainScheduled = false;
      throw t;
    }
  }

  private void drain() {
    // If the loop exits abruptly (only reachable if handler.uncaught itself throws), reset
    // drainScheduled before propagating so a subsequent execute() reschedules instead of
    // queueing into a wedged executor. Symmetric with scheduleDrainLocked's reset on backing
    // throw.
    try {
      while (true) {
        Runnable r;
        synchronized (queue) {
          r = queue.poll();
          if (r == null) {
            drainScheduled = false;
            return;
          }
          runningThread = Thread.currentThread();
        }
        try {
          try {
            r.run();
          } catch (Throwable t) {
            handler.uncaught(t);
          }
        } finally {
          synchronized (queue) {
            runningThread = null;
          }
        }
      }
    } catch (Throwable t) {
      synchronized (queue) {
        drainScheduled = false;
      }
      throw t;
    }
  }

  public void throwIfNotInThisExecutor() {
    if (Thread.currentThread() != runningThread) {
      throw new IllegalStateException("Not running on this op executor");
    }
  }
}

/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1beta2;

import com.google.api.core.ApiClock;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;

/**
 * Fake implementation of {@link ScheduledExecutorService} that allows tests control the reference
 * time of the executor and decide when to execute any outstanding task.
 */
public class FakeScheduledExecutorService extends AbstractExecutorService
    implements ScheduledExecutorService {
  private static final Logger LOG = Logger.getLogger(FakeScheduledExecutorService.class.getName());

  private final AtomicBoolean shutdown = new AtomicBoolean(false);
  private final PriorityQueue<PendingCallable<?>> pendingCallables = new PriorityQueue<>();
  private final FakeClock clock = new FakeClock();
  private final Deque<Duration> expectedWorkQueue = new LinkedList<>();

  public ApiClock getClock() {
    return clock;
  }

  @Override
  public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
    return schedulePendingCallable(
        new PendingCallable<>(
            Duration.ofMillis(unit.toMillis(delay)), command, PendingCallableType.NORMAL));
  }

  @Override
  public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
    return schedulePendingCallable(
        new PendingCallable<>(
            Duration.ofMillis(unit.toMillis(delay)), callable, PendingCallableType.NORMAL));
  }

  @Override
  public ScheduledFuture<?> scheduleAtFixedRate(
      Runnable command, long initialDelay, long period, TimeUnit unit) {
    return schedulePendingCallable(
        new PendingCallable<>(
            Duration.ofMillis(unit.toMillis(initialDelay)),
            command,
            PendingCallableType.FIXED_RATE));
  }

  @Override
  public ScheduledFuture<?> scheduleWithFixedDelay(
      Runnable command, long initialDelay, long delay, TimeUnit unit) {
    return schedulePendingCallable(
        new PendingCallable<>(
            Duration.ofMillis(unit.toMillis(initialDelay)),
            command,
            PendingCallableType.FIXED_DELAY));
  }

  /**
   * This will advance the reference time of the executor and execute (in the same thread) any
   * outstanding callable which execution time has passed.
   */
  public void advanceTime(Duration toAdvance) {
    LOG.info(
        "Advance to time to:"
            + Instant.ofEpochMilli(clock.millisTime() + toAdvance.toMillis()).toString());
    clock.advance(toAdvance.toMillis(), TimeUnit.MILLISECONDS);
    work();
  }

  private void work() {
    for (; ; ) {
      PendingCallable<?> callable = null;
      Instant cmpTime = Instant.ofEpochMilli(clock.millisTime());
      if (!pendingCallables.isEmpty()) {
        LOG.info(
            "Going to call: Current time: "
                + cmpTime.toString()
                + " Scheduled time: "
                + pendingCallables.peek().getScheduledTime().toString()
                + " Creation time:"
                + pendingCallables.peek().getCreationTime().toString());
      }
      synchronized (pendingCallables) {
        if (pendingCallables.isEmpty()
            || pendingCallables.peek().getScheduledTime().isAfter(cmpTime)) {
          break;
        }
        callable = pendingCallables.poll();
      }
      if (callable != null) {
        try {
          callable.call();
        } catch (Exception e) {
          // We ignore any callable exception, which should be set to the future but not relevant to
          // advanceTime.
        }
      }
    }

    synchronized (pendingCallables) {
      if (shutdown.get() && pendingCallables.isEmpty()) {
        pendingCallables.notifyAll();
      }
    }
  }

  @Override
  public void shutdown() {
    if (shutdown.getAndSet(true)) {
      throw new IllegalStateException("This executor has been shutdown already");
    }
  }

  @Override
  public List<Runnable> shutdownNow() {
    if (shutdown.getAndSet(true)) {
      throw new IllegalStateException("This executor has been shutdown already");
    }
    List<Runnable> pending = new ArrayList<>();
    for (final PendingCallable<?> pendingCallable : pendingCallables) {
      pending.add(
          new Runnable() {
            @Override
            public void run() {
              pendingCallable.call();
            }
          });
    }
    synchronized (pendingCallables) {
      pendingCallables.notifyAll();
      pendingCallables.clear();
    }
    return pending;
  }

  @Override
  public boolean isShutdown() {
    return shutdown.get();
  }

  @Override
  public boolean isTerminated() {
    return pendingCallables.isEmpty();
  }

  @Override
  public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
    synchronized (pendingCallables) {
      if (pendingCallables.isEmpty()) {
        return true;
      }
      LOG.info("Wating on pending callables" + pendingCallables.size());
      pendingCallables.wait(unit.toMillis(timeout));
      return pendingCallables.isEmpty();
    }
  }

  @Override
  public void execute(Runnable command) {
    if (shutdown.get()) {
      throw new IllegalStateException("This executor has been shutdown");
    }
    command.run();
  }

  <V> ScheduledFuture<V> schedulePendingCallable(PendingCallable<V> callable) {
    LOG.info(
        "Schedule pending callable called " + callable.delay + " " + callable.getScheduledTime());
    if (shutdown.get()) {
      throw new IllegalStateException("This executor has been shutdown");
    }
    synchronized (pendingCallables) {
      pendingCallables.add(callable);
    }
    work();
    synchronized (expectedWorkQueue) {
      // We compare by the callable delay in order decide when to remove expectations from the
      // expected work queue, i.e. only the expected work that matches the delay of the scheduled
      // callable is removed from the queue.
      if (!expectedWorkQueue.isEmpty() && expectedWorkQueue.peek().equals(callable.delay)) {
        expectedWorkQueue.poll();
      }
      expectedWorkQueue.notifyAll();
    }

    return callable.getScheduledFuture();
  }

  enum PendingCallableType {
    NORMAL,
    FIXED_RATE,
    FIXED_DELAY
  }

  /** Class that saves the state of an scheduled pending callable. */
  class PendingCallable<T> implements Comparable<PendingCallable<T>> {
    Instant creationTime = Instant.ofEpochMilli(clock.millisTime());
    Duration delay;
    Callable<T> pendingCallable;
    SettableFuture<T> future = SettableFuture.create();
    AtomicBoolean cancelled = new AtomicBoolean(false);
    AtomicBoolean done = new AtomicBoolean(false);
    PendingCallableType type;

    PendingCallable(Duration delay, final Runnable runnable, PendingCallableType type) {
      pendingCallable =
          new Callable<T>() {
            @Override
            public T call() {
              runnable.run();
              return null;
            }
          };
      this.type = type;
      this.delay = delay;
    }

    PendingCallable(Duration delay, Callable<T> callable, PendingCallableType type) {
      pendingCallable = callable;
      this.type = type;
      this.delay = delay;
    }

    private Instant getScheduledTime() {
      return creationTime.plus(delay);
    }

    private Instant getCreationTime() {
      return creationTime;
    }

    ScheduledFuture<T> getScheduledFuture() {
      return new ScheduledFuture<T>() {
        @Override
        public long getDelay(TimeUnit unit) {
          return unit.convert(
              getScheduledTime().toEpochMilli() - clock.millisTime(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
          return Ints.saturatedCast(
              getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
          synchronized (this) {
            cancelled.set(true);
            return !done.get();
          }
        }

        @Override
        public boolean isCancelled() {
          return cancelled.get();
        }

        @Override
        public boolean isDone() {
          return done.get();
        }

        @Override
        public T get() throws InterruptedException, ExecutionException {
          return future.get();
        }

        @Override
        public T get(long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {
          return future.get(timeout, unit);
        }
      };
    }

    T call() {
      T result = null;
      synchronized (this) {
        if (cancelled.get()) {
          return null;
        }
        try {
          result = pendingCallable.call();
          future.set(result);
        } catch (Exception e) {
          future.setException(e);
        } finally {
          switch (type) {
            case NORMAL:
              done.set(true);
              break;
            case FIXED_DELAY:
              this.creationTime = Instant.ofEpochMilli(clock.millisTime());
              schedulePendingCallable(this);
              break;
            case FIXED_RATE:
              this.creationTime = this.creationTime.plus(delay);
              schedulePendingCallable(this);
              break;
            default:
              // Nothing to do
          }
        }
      }
      return result;
    }

    @Override
    public int compareTo(PendingCallable<T> other) {
      return getScheduledTime().compareTo(other.getScheduledTime());
    }
  }
}

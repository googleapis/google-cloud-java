/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsub;

import com.google.cloud.Clock;
import com.google.cloud.pubsub.FakeClock;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.MutableDateTime;

/**
 * Fake implementation of {@link ScheduledExecutorService} that allows tests control the reference
 * time of the executor and decide when to execute any outstanding task.
 */
public class FakeScheduledExecutorService extends AbstractExecutorService
    implements ScheduledExecutorService {

  private final AtomicBoolean shutdown = new AtomicBoolean(false);
  private final PriorityQueue<PendingCallable<?>> pendingCallables = new PriorityQueue<>();
  private final ExecutorService delegate = Executors.newSingleThreadExecutor();
  private final FakeClock clock = new FakeClock();

  public Clock getClock() {
    return clock;
  }

  @Override
  public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
    return schedulePendingCallable(
        new PendingCallable<>(
            new Duration(unit.toMillis(delay)), command, PendingCallableType.NORMAL));
  }

  @Override
  public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
    return schedulePendingCallable(
        new PendingCallable<>(
            new Duration(unit.toMillis(delay)), callable, PendingCallableType.NORMAL));
  }

  @Override
  public ScheduledFuture<?> scheduleAtFixedRate(
      Runnable command, long initialDelay, long period, TimeUnit unit) {
    return schedulePendingCallable(
        new PendingCallable<>(
            new Duration(unit.toMillis(initialDelay)), command, PendingCallableType.FIXED_RATE));
  }

  @Override
  public ScheduledFuture<?> scheduleWithFixedDelay(
      Runnable command, long initialDelay, long delay, TimeUnit unit) {
    return schedulePendingCallable(
        new PendingCallable<>(
            new Duration(unit.toMillis(initialDelay)), command, PendingCallableType.FIXED_DELAY));
  }

  public void tick(long time, TimeUnit unit) {
    advanceTime(Duration.millis(unit.toMillis(time)));
  }

  /**
   * This will advance the reference time of the executor and execute (in the same thread) any
   * outstanding callable which execution time has passed.
   */
  public void advanceTime(Duration toAdvance) {
    clock.advance(toAdvance.getMillis(), TimeUnit.MILLISECONDS);
    DateTime cmpTime = new DateTime(clock.millis());

    synchronized (pendingCallables) {
      while (!pendingCallables.isEmpty()
          && pendingCallables.peek().getScheduledTime().compareTo(cmpTime) <= 0) {
        try {
          pendingCallables.poll().call();
          if (shutdown.get() && pendingCallables.isEmpty()) {
            pendingCallables.notifyAll();
          }
        } catch (Exception e) {
          // We ignore any callable exception, which should be set to the future but not relevant to
          // advanceTime.
        }
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
      pendingCallables.wait(unit.toMillis(timeout));
      return pendingCallables.isEmpty();
    }
  }

  @Override
  public void execute(Runnable command) {
    if (shutdown.get()) {
      throw new IllegalStateException("This executor has been shutdown");
    }
    delegate.execute(command);
  }

  <V> ScheduledFuture<V> schedulePendingCallable(PendingCallable<V> callable) {
    if (shutdown.get()) {
      throw new IllegalStateException("This executor has been shutdown");
    }
    synchronized (pendingCallables) {
      pendingCallables.add(callable);
    }
    return callable.getScheduledFuture();
  }

  static enum PendingCallableType {
    NORMAL,
    FIXED_RATE,
    FIXED_DELAY
  }

  /** Class that saves the state of an scheduled pending callable. */
  class PendingCallable<T> implements Comparable<PendingCallable<T>> {
    DateTime creationTime = new DateTime(clock.millis());
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
            public T call() throws Exception {
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

    private DateTime getScheduledTime() {
      return creationTime.plus(delay);
    }

    ScheduledFuture<T> getScheduledFuture() {
      return new ScheduledFuture<T>() {
        @Override
        public long getDelay(TimeUnit unit) {
          return unit.convert(getScheduledTime().getMillis() - clock.millis(), TimeUnit.MILLISECONDS);
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
              this.creationTime = new DateTime(clock.millis());
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

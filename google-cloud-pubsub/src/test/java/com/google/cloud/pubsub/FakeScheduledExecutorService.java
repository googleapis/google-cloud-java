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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * A ScheduledExecutorService to help with testing.
 */
class FakeScheduledExecutorService extends ScheduledThreadPoolExecutor {
  private final FakeClock clock;
  private final List<FakeScheduledFuture> futures = new ArrayList<>();

  public FakeScheduledExecutorService(int corePoolSize, FakeClock clock) {
    super(corePoolSize);
    this.clock = clock;
  }

  public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
    synchronized (this) {
      long runAtMillis = clock.millis() + unit.toMillis(delay);
      FakeScheduledFuture scheduledFuture =
          new FakeScheduledFuture(command, delay, unit, runAtMillis);
      futures.add(scheduledFuture);
      return scheduledFuture;
    }
  }

  public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
    throw new UnsupportedOperationException(
        "FakeScheduledExecutorService.schedule(Callable, long, TimeUnit) not supported");
  }

  public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period,
      TimeUnit unit) {
    throw new UnsupportedOperationException(
        "FakeScheduledExecutorService.scheduleAtFixedRate not supported");
  }

  public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay,
      TimeUnit unit) {
    throw new UnsupportedOperationException(
        "FakeScheduledExecutorService.scheduleAtFixedRate not supported");
  }

  public void tick(long time, TimeUnit unit) {
    List<FakeScheduledFuture> runnablesToGo = new ArrayList<>();
    synchronized (this) {
      clock.advance(time, unit);
      Iterator<FakeScheduledFuture> iter = futures.iterator();
      while (iter.hasNext()) {
        FakeScheduledFuture scheduledFuture = iter.next();
        if (scheduledFuture.runAtMillis <= clock.millis()) {
          runnablesToGo.add(scheduledFuture);
          iter.remove();
        }
      }
    }
    for (FakeScheduledFuture scheduledFuture : runnablesToGo) {
      scheduledFuture.run();
    }
  }

  private boolean cancel(FakeScheduledFuture toCancel) {
    synchronized (this) {
      Iterator<FakeScheduledFuture> iter = futures.iterator();
      while (iter.hasNext()) {
        FakeScheduledFuture scheduledFuture = iter.next();
        if (scheduledFuture == toCancel) {
          iter.remove();
          return true;
        }
      }
      return false;
    }
  }

  private class FakeScheduledFuture implements ScheduledFuture<Object> {
    final Callable<Object> callable;
    final long delay;
    final TimeUnit unit;
    final long runAtMillis;

    volatile boolean isDone;
    volatile boolean isCancelled;
    volatile Exception exception;
    volatile Object result;

    FakeScheduledFuture(Runnable runnable, long delay, TimeUnit unit, long runAtMillis) {
      this.callable = Executors.callable(runnable);
      this.delay = delay;
      this.unit = unit;
      this.runAtMillis = runAtMillis;
    }

    @Override
    public long getDelay(TimeUnit requestedUnit) {
      return unit.convert(delay, requestedUnit);
    }

    @Override
    public int compareTo(Delayed other) {
      return Long.compare(getDelay(TimeUnit.MILLISECONDS), other.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public boolean cancel(boolean var1) {
      if (isCancelled) {
        return isCancelled;
      }
      isCancelled = FakeScheduledExecutorService.this.cancel(this);
      return isCancelled;
    }

    @Override
    public boolean isCancelled() {
      return isCancelled;
    }

    @Override
    public boolean isDone() {
      return isDone;
    }

    @Override
    public Object get() throws InterruptedException, ExecutionException {
      if (!isDone()) {
        throw new UnsupportedOperationException("FakeScheduledFuture: blocking get not supported");
      }

      if (exception != null) {
        throw new ExecutionException(exception);
      }

      return result;
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException,
        TimeoutException {
      return get();
    }

    public void run() {
      if (isDone()) {
        throw new UnsupportedOperationException("FakeScheduledFuture already done.");
      }

      try {
        result = callable.call();
      } catch (Exception e) {
        exception = e;
      }

      isDone = true;
    }
  }
}

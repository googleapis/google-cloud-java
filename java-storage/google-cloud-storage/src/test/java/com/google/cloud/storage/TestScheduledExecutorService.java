/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.storage;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * "Test" {@link ScheduledExecutorService} that integrated with {@link TestApiClock} to provide
 * "instant" time advancement for any invocation of {@link #schedule(Runnable, long, TimeUnit)}
 *
 * <p>All other methods will throw {@link UnsupportedOperationException} if invoked.
 */
final class TestScheduledExecutorService implements ScheduledExecutorService {

  private final TestApiClock clock;

  TestScheduledExecutorService(TestApiClock clock) {
    this.clock = clock;
  }

  @Override
  public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
    Duration nanos = Duration.ofNanos(unit.toNanos(delay));
    clock.advance(nanos);
    command.run();
    return new ScheduledFuture<Object>() {
      @Override
      public long getDelay(TimeUnit unit) {
        throw new UnsupportedOperationException();
      }

      @Override
      public int compareTo(Delayed o) {
        throw new UnsupportedOperationException();
      }

      @Override
      public boolean cancel(boolean mayInterruptIfRunning) {
        throw new UnsupportedOperationException();
      }

      @Override
      public boolean isCancelled() {
        throw new UnsupportedOperationException();
      }

      @Override
      public boolean isDone() {
        return true;
      }

      @Override
      public Object get() throws InterruptedException, ExecutionException {
        return null;
      }

      @Override
      public Object get(long timeout, TimeUnit unit)
          throws InterruptedException, ExecutionException, TimeoutException {
        throw new UnsupportedOperationException();
      }
    };
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
  public void shutdown() {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<Runnable> shutdownNow() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isShutdown() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isTerminated() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
    throw new UnsupportedOperationException();
  }

  @Override
  public <T> Future<T> submit(Callable<T> task) {
    throw new UnsupportedOperationException();
  }

  @Override
  public <T> Future<T> submit(Runnable task, T result) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Future<?> submit(Runnable task) {
    throw new UnsupportedOperationException();
  }

  @Override
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
      throws InterruptedException {
    throw new UnsupportedOperationException();
  }

  @Override
  public <T> List<Future<T>> invokeAll(
      Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
      throws InterruptedException {
    throw new UnsupportedOperationException();
  }

  @Override
  public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
      throws InterruptedException, ExecutionException {
    throw new UnsupportedOperationException();
  }

  @Override
  public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
      throws InterruptedException, ExecutionException, TimeoutException {
    throw new UnsupportedOperationException();
  }

  @Override
  public void execute(Runnable command) {
    throw new UnsupportedOperationException();
  }
}

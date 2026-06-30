/*
 * Copyright 2025 Google LLC
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

import static java.util.Objects.requireNonNull;

import com.google.api.client.util.Sleeper;
import com.google.api.core.ApiClock;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.cloud.storage.Backoff.BackoffResult;
import com.google.cloud.storage.Backoff.Jitterer;
import com.google.cloud.storage.Retrying.RetryingDependencies;
import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.checkerframework.checker.nullness.qual.NonNull;

@InternalApi
@InternalExtensionOnly
interface RetryContext {

  boolean inBackoff();

  void reset();

  <T extends Throwable> void recordError(T t, OnSuccess onSuccess, OnFailure<T> onFailure);

  static RetryContext of(
      ScheduledExecutorService scheduledExecutorService,
      RetryingDependencies retryingDependencies,
      ResultRetryAlgorithm<?> algorithm,
      Jitterer jitterer) {
    return new DefaultRetryContext(
        scheduledExecutorService, retryingDependencies, algorithm, jitterer);
  }

  static RetryContext neverRetry() {
    return new DefaultRetryContext(
        directScheduledExecutorService(),
        RetryingDependencies.attemptOnce(),
        Retrying.neverRetry(),
        Jitterer.threadLocalRandom());
  }

  static RetryContextProvider providerFrom(
      ScheduledExecutorService scheduledExecutorService,
      RetryingDependencies deps,
      ResultRetryAlgorithm<?> alg) {
    return () -> of(scheduledExecutorService, deps, alg, Jitterer.threadLocalRandom());
  }

  static ScheduledExecutorService directScheduledExecutorService() {
    return DirectScheduledExecutorService.INSTANCE;
  }

  @FunctionalInterface
  interface RetryContextProvider {
    RetryContext create();
  }

  @FunctionalInterface
  interface OnSuccess {
    void onSuccess();
  }

  @FunctionalInterface
  interface OnFailure<T extends Throwable> {
    void onFailure(T t);
  }

  /**
   * Define a custom exception which can carry a comment about the budget exhaustion, so we can
   * include it as a suppressed exception, but don't fill in any stack frames. This is a throwable
   * only because it is the only way we can include it into an exception that will by default print
   * with the exception stacktrace.
   *
   * @see Throwable#addSuppressed(Throwable)
   */
  final class RetryBudgetExhaustedComment extends Throwable {
    RetryBudgetExhaustedComment(String comment) {
      super(
          comment,
          /* cause= */ null,
          /* enableSuppression= */ true,
          /* writableStackTrace= */ false);
    }
  }

  final class BackoffComment extends Throwable {
    private BackoffComment(String message) {
      super(
          message,
          /* cause= */ null,
          /* enableSuppression= */ true,
          /* writableStackTrace= */ false);
    }

    static BackoffComment fromResult(BackoffResult result) {
      return new BackoffComment(
          String.format("backing off %s before next attempt", result.errorString()));
    }

    static BackoffComment of(String message) {
      return new BackoffComment(message);
    }
  }

  final class InterruptedBackoffComment extends Throwable {
    InterruptedBackoffComment(@NonNull String message) {
      super(
          requireNonNull(message, "message must be non null"),
          /* cause= */ null,
          /* enableSuppression= */ true,
          /* writableStackTrace= */ false);
    }
  }

  final class DirectScheduledExecutorService implements ScheduledExecutorService {
    private static final DirectScheduledExecutorService INSTANCE =
        new DirectScheduledExecutorService(Sleeper.DEFAULT, NanoClock.getDefaultClock());

    private static final Comparator<Delayed> COMP =
        Comparator.comparingLong(delay -> delay.getDelay(TimeUnit.NANOSECONDS));
    private final Sleeper sleeper;
    private final ApiClock apiClock;

    private DirectScheduledExecutorService(Sleeper sleeper, ApiClock apiClock) {
      this.sleeper = sleeper;
      this.apiClock = apiClock;
    }

    @Override
    public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
      return new DirectScheduledFuture(unit, delay, command);
    }

    // <editor-fold desc="UnsupportedOperations">
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
      command.run();
    }

    // </editor-fold>

    private final class DirectScheduledFuture implements ScheduledFuture<Object> {

      private final long origDelayNs;
      private final long beginNs;
      private final ApiFuture<Object> delegate;

      public DirectScheduledFuture(TimeUnit unit, long delay, Runnable command) {
        origDelayNs = unit.toNanos(delay);
        beginNs = apiClock.nanoTime();
        delegate =
            ApiFutures.transformAsync(
                ApiFutures.immediateFuture(null),
                ignore -> {
                  sleeper.sleep(unit.toMillis(delay));
                  command.run();
                  return ApiFutures.immediateFuture(null);
                },
                MoreExecutors.directExecutor());
      }

      @Override
      public long getDelay(TimeUnit unit) {
        long nowNs = apiClock.nanoTime();
        return Longs.max(0L, (nowNs - beginNs) - origDelayNs);
      }

      @Override
      public int compareTo(Delayed o) {
        return COMP.compare(this, o);
      }

      @Override
      public boolean cancel(boolean mayInterruptIfRunning) {
        return delegate.cancel(mayInterruptIfRunning);
      }

      @Override
      public boolean isCancelled() {
        return delegate.isCancelled();
      }

      @Override
      public boolean isDone() {
        return delegate.isDone();
      }

      @Override
      public Object get() throws InterruptedException, ExecutionException {
        return delegate.get();
      }

      @Override
      public Object get(long timeout, TimeUnit unit)
          throws InterruptedException, ExecutionException, TimeoutException {
        return delegate.get(timeout, unit);
      }
    }
  }
}

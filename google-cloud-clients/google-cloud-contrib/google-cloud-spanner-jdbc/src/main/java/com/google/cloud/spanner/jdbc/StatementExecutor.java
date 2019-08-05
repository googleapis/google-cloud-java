/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import com.google.cloud.spanner.jdbc.ReadOnlyStalenessUtil.DurationValueGetter;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.protobuf.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * {@link StatementExecutor} is responsible for executing statements on a {@link Connection}.
 * Statements are executed using a separate executor to allow timeouts and cancellation of
 * statements.
 */
class StatementExecutor {

  /** Simple holder class for statement timeout that allows us to pass the value by reference. */
  static class StatementTimeout {
    /**
     * Only {@link TimeUnit#NANOSECONDS}, {@link TimeUnit#MICROSECONDS}, {@link
     * TimeUnit#MILLISECONDS} and {@link TimeUnit#SECONDS} may be used to specify a statement
     * timeout.
     */
    static boolean isValidTimeoutUnit(TimeUnit unit) {
      return unit == TimeUnit.NANOSECONDS
          || unit == TimeUnit.MICROSECONDS
          || unit == TimeUnit.MILLISECONDS
          || unit == TimeUnit.SECONDS;
    }

    /** The statement timeout. */
    private Duration duration = null;

    /** Creates a {@link StatementTimeout} that will never timeout. */
    @VisibleForTesting
    static StatementTimeout nullTimeout() {
      return new StatementTimeout();
    }

    /** Creates a {@link StatementTimeout} with the given duration. */
    @VisibleForTesting
    static StatementTimeout of(long timeout, TimeUnit unit) {
      Preconditions.checkArgument(timeout > 0L);
      Preconditions.checkArgument(isValidTimeoutUnit(unit));
      StatementTimeout res = new StatementTimeout();
      res.duration = ReadOnlyStalenessUtil.createDuration(timeout, unit);
      return res;
    }

    /**
     * Does this {@link StatementTimeout} have an actual timeout (i.e. it will eventually timeout).
     */
    boolean hasTimeout() {
      return duration != null;
    }

    void clearTimeoutValue() {
      this.duration = null;
    }

    void setTimeoutValue(long timeout, TimeUnit unit) {
      Preconditions.checkArgument(timeout > 0L);
      Preconditions.checkArgument(isValidTimeoutUnit(unit));
      this.duration = ReadOnlyStalenessUtil.createDuration(timeout, unit);
    }

    long getTimeoutValue(TimeUnit unit) {
      Preconditions.checkArgument(isValidTimeoutUnit(unit));
      return duration == null ? 0L : ReadOnlyStalenessUtil.durationToUnits(duration, unit);
    }

    /**
     * Returns the {@link TimeUnit} with the least precision that could be used to represent this
     * {@link StatementTimeout} without loss of precision.
     */
    TimeUnit getAppropriateTimeUnit() {
      ConnectionPreconditions.checkState(
          duration != null, "This StatementTimeout has no timeout value");
      return ReadOnlyStalenessUtil.getAppropriateTimeUnit(
          new DurationValueGetter() {
            @Override
            public long getDuration(TimeUnit unit) {
              return StatementTimeout.this.getTimeoutValue(unit);
            }

            @Override
            public boolean hasDuration() {
              return StatementTimeout.this.hasTimeout();
            }
          });
    }
  }

  /**
   * Use a {@link ThreadFactory} that produces daemon threads and sets recognizable name on the
   * threads.
   */
  private static final ThreadFactory THREAD_FACTORY =
      new ThreadFactoryBuilder()
          .setDaemon(true)
          .setNameFormat("connection-executor-%d")
          .setThreadFactory(MoreExecutors.platformThreadFactory())
          .build();

  /** Creates an {@link ExecutorService} for a {@link StatementExecutor}. */
  private static ExecutorService createExecutorService() {
    return MoreExecutors.getExitingExecutorService(
        new ThreadPoolExecutor(
            1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), THREAD_FACTORY));
  }

  private ExecutorService executor = createExecutorService();

  /**
   * Interceptors that should be invoked before or after a statement is executed can be registered
   * for a connection. This are added to this list. The interceptors are intended for test usage.
   */
  private final List<StatementExecutionInterceptor> interceptors;

  @VisibleForTesting
  StatementExecutor() {
    this.interceptors = Collections.emptyList();
  }

  StatementExecutor(List<StatementExecutionInterceptor> interceptors) {
    this.interceptors = Collections.unmodifiableList(interceptors);
  }

  /**
   * Recreates this {@link StatementExecutor} and its {@link ExecutorService}. This can be necessary
   * if a statement times out or is cancelled, and it cannot be guaranteed that the statement
   * execution can be terminated. In order to prevent the single threaded {@link ExecutorService} to
   * continue to block on the timed out/cancelled statement, a new {@link ExecutorService} is
   * created.
   */
  void recreate() {
    executor.shutdown();
    executor = createExecutorService();
  }

  /**
   * Shutdown this executor now and do not wait for any statement that is being executed to finish.
   */
  List<Runnable> shutdownNow() {
    return executor.shutdownNow();
  }

  /** Execute a statement on this {@link StatementExecutor}. */
  <T> Future<T> submit(Callable<T> callable) {
    return executor.submit(callable);
  }

  /**
   * Invoke the interceptors that have been registered for this {@link StatementExecutor} for the
   * given step.
   */
  void invokeInterceptors(
      ParsedStatement statement, StatementExecutionStep step, UnitOfWork transaction) {
    for (StatementExecutionInterceptor interceptor : interceptors) {
      interceptor.intercept(statement, step, transaction);
    }
  }
}

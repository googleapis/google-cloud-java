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

package com.google.cloud.spanner.connection;

import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_USE_VIRTUAL_THREADS;

import com.google.api.core.ApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.cloud.spanner.ThreadFactoryUtil;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.ReadOnlyStalenessUtil.DurationValueGetter;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Duration;
import io.opentelemetry.context.Context;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
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
    private volatile Duration duration = null;

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

    java.time.Duration asDuration() {
      if (!hasTimeout()) {
        return java.time.Duration.ZERO;
      }
      TimeUnit unit = getAppropriateTimeUnit();
      switch (unit) {
        case DAYS:
          return java.time.Duration.ofDays(getTimeoutValue(unit));
        case HOURS:
          return java.time.Duration.ofHours(getTimeoutValue(unit));
        case MICROSECONDS:
          return java.time.Duration.of(getTimeoutValue(unit), ChronoUnit.MICROS);
        case MILLISECONDS:
          return java.time.Duration.ofMillis(getTimeoutValue(unit));
        case MINUTES:
          return java.time.Duration.ofMinutes(getTimeoutValue(unit));
        case NANOSECONDS:
          return java.time.Duration.ofNanos(getTimeoutValue(unit));
        case SECONDS:
          return java.time.Duration.ofSeconds(getTimeoutValue(unit));
        default:
          throw new IllegalStateException("invalid time unit: " + unit);
      }
    }
  }

  /**
   * Use a {@link ThreadFactory} that produces daemon or virtual threads and sets a recognizable
   * name on the threads.
   */
  private static final ThreadFactory DEFAULT_VIRTUAL_THREAD_FACTORY =
      ThreadFactoryUtil.createVirtualOrPlatformDaemonThreadFactory("connection-executor", true);

  /**
   * Use a {@link ThreadFactory} that produces daemon threads and sets a recognizable name on the
   * threads.
   */
  private static final ThreadFactory DEFAULT_DAEMON_THREAD_FACTORY =
      ThreadFactoryUtil.createVirtualOrPlatformDaemonThreadFactory("connection-executor", false);

  /** Creates an {@link ExecutorService} for a {@link StatementExecutor}. */
  private static ListeningExecutorService createExecutorService(StatementExecutorType type) {
    if (type == StatementExecutorType.DIRECT_EXECUTOR) {
      return MoreExecutors.newDirectExecutorService();
    }
    return MoreExecutors.listeningDecorator(
        Context.taskWrapping(
            new ThreadPoolExecutor(
                1,
                1,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                type == StatementExecutorType.VIRTUAL_THREAD
                    ? DEFAULT_VIRTUAL_THREAD_FACTORY
                    : DEFAULT_DAEMON_THREAD_FACTORY)));
  }

  private final ListeningExecutorService executor;

  /**
   * Interceptors that should be invoked before or after a statement is executed can be registered
   * for a connection. These are added to this list. The interceptors are intended for test usage.
   */
  private final List<StatementExecutionInterceptor> interceptors;

  /** The executor type that is used for statements that are executed on a connection. */
  public enum StatementExecutorType {
    /**
     * Use a platform thread per connection. This allows async execution of statements, but costs
     * more resources than the other options.
     */
    PLATFORM_THREAD,
    /**
     * Use a virtual thread per connection. This allows async execution of statements. Virtual
     * threads are only supported on Java 21 and higher.
     */
    VIRTUAL_THREAD,
    /**
     * Use the calling thread for execution. This does not support async execution of statements.
     * This option is used by drivers that do not support async execution, such as JDBC and
     * PGAdapter.
     */
    DIRECT_EXECUTOR,
  }

  @VisibleForTesting
  StatementExecutor() {
    this(
        DEFAULT_USE_VIRTUAL_THREADS
            ? StatementExecutorType.VIRTUAL_THREAD
            : StatementExecutorType.PLATFORM_THREAD,
        Collections.emptyList());
  }

  StatementExecutor(StatementExecutorType type, List<StatementExecutionInterceptor> interceptors) {
    this.executor = createExecutorService(type);
    this.interceptors = Collections.unmodifiableList(interceptors);
  }

  void shutdown() {
    executor.shutdown();
  }

  /**
   * Shutdown this executor now and do not wait for any statement that is being executed to finish.
   */
  void shutdownNow() {
    executor.shutdownNow();
  }

  /** Execute a statement on this {@link StatementExecutor}. */
  <T> ApiFuture<T> submit(Callable<T> callable) {
    return new ListenableFutureToApiFuture<>(executor.submit(callable));
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

/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery.jdbc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** Lightweight MDC implementation for the BigQuery JDBC driver using InheritableThreadLocal. */
class BigQueryJdbcMdc {
  private static final InheritableThreadLocal<String> currentConnectionId =
      new InheritableThreadLocal<>();

  /** Sets the current connection context on the executing thread. */
  static MdcCloseable registerInstance(String connectionId) {
    if (connectionId != null) {
      currentConnectionId.set(connectionId);
    }
    return () -> clear();
  }

  /**
   * Returns the connection ID carried by any registered active connection on the current thread.
   */
  static String getConnectionId() {
    return currentConnectionId.get();
  }

  static void clear() {
    currentConnectionId.remove();
  }

  /**
   * Creates a new fixed thread pool ExecutorService that automatically propagates MDC connection
   * context from the submitting thread to the executing thread.
   */
  static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
    return new MdcThreadPoolExecutor(
        nThreads,
        nThreads,
        0L,
        TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<>(),
        new MdcThreadFactory(threadFactory));
  }

  /**
   * Creates a new fixed thread pool ExecutorService that automatically propagates MDC connection
   * context from the submitting thread to the executing thread.
   */
  static ExecutorService newFixedThreadPool(int nThreads) {
    return newFixedThreadPool(nThreads, Executors.defaultThreadFactory());
  }

  private static class MdcThreadFactory implements ThreadFactory {
    private final ThreadFactory delegate;

    public MdcThreadFactory(ThreadFactory delegate) {
      this.delegate = delegate;
    }

    @Override
    public Thread newThread(Runnable r) {
      return delegate.newThread(
          () -> {
            clear();
            r.run();
          });
    }
  }

  private static class MdcThreadPoolExecutor extends ThreadPoolExecutor {

    public MdcThreadPoolExecutor(
        int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime,
        TimeUnit unit,
        BlockingQueue<Runnable> workQueue,
        ThreadFactory threadFactory) {
      super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    @Override
    public void execute(Runnable command) {
      if (command == null) {
        throw new NullPointerException();
      }
      if (command instanceof MdcFutureTask) {
        super.execute(command);
      } else {
        super.execute(wrap(command));
      }
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
      return new MdcFutureTask<>(runnable, value, getConnectionId());
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
      return new MdcFutureTask<>(callable, getConnectionId());
    }

    private static Runnable wrap(Runnable runnable) {
      String connectionId = getConnectionId();
      return () -> {
        try (MdcCloseable mdc = registerInstance(connectionId)) {
          runnable.run();
        }
      };
    }
  }

  private static class MdcFutureTask<V> extends FutureTask<V> {
    private final String connectionId;

    public MdcFutureTask(Runnable runnable, V result, String connectionId) {
      super(runnable, result);
      this.connectionId = connectionId;
    }

    public MdcFutureTask(Callable<V> callable, String connectionId) {
      super(callable);
      this.connectionId = connectionId;
    }

    @Override
    public void run() {
      try (MdcCloseable mdc = registerInstance(connectionId)) {
        super.run();
      }
    }
  }

  /**
   * Functional interface that extends AutoCloseable to avoid throwing checked exceptions in
   * try-with-resources.
   */
  @FunctionalInterface
  interface MdcCloseable extends AutoCloseable {
    @Override
    void close();
  }
}

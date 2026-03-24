/*
 * Copyright 2016 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.core;

import com.google.auto.value.AutoValue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * InstantiatingChannelProvider is an ExecutorProvider which constructs a new
 * ScheduledExecutorService every time getExecutor() is called.
 */
@AutoValue
public abstract class InstantiatingExecutorProvider implements ExecutorProvider {
  private static final Logger LOGGER =
      Logger.getLogger(InstantiatingExecutorProvider.class.getName());

  // Thread factory to use to create our worker threads
  private static final ThreadFactory DEFAULT_THREAD_FACTORY =
      new ThreadFactory() {
        private final AtomicInteger threadCount = new AtomicInteger();

        @Override
        public Thread newThread(Runnable runnable) {
          Thread thread = new Thread(runnable);
          thread.setName("Gax-" + threadCount.incrementAndGet());
          thread.setDaemon(true);
          return thread;
        }
      };
  private static final int MIN_THREAD_AMOUNT = 4;
  // Attempt to choose a reasonable default core pool multiplier for IO Bound operations
  private static final int IO_THREAD_MULTIPLIER = 50;

  // Package-private constructor prevents others from subclassing.
  InstantiatingExecutorProvider() {}

  @Override
  public ScheduledExecutorService getExecutor() {
    return new ScheduledThreadPoolExecutor(getExecutorThreadCount(), getThreadFactory());
  }

  @Override
  public boolean shouldAutoClose() {
    return true;
  }

  /** The number of threads used by the executor created by this ExecutorProvider. */
  public abstract int getExecutorThreadCount();

  /** Return a thread-factory to create gax processing threads so we can name them appropriately */
  public abstract ThreadFactory getThreadFactory();

  public abstract Builder toBuilder();

  // Used for CPU Bound tasks as the thread count is at max the number of processors
  // Thread count minimum is at least `MIN_CPU_AMOUNT`
  public static Builder newBuilder() {
    int numCpus = Runtime.getRuntime().availableProcessors();
    int numThreads = Math.max(MIN_THREAD_AMOUNT, numCpus);

    return new AutoValue_InstantiatingExecutorProvider.Builder()
        .setExecutorThreadCount(numThreads)
        .setThreadFactory(DEFAULT_THREAD_FACTORY);
  }

  // Used for IO Bound tasks as the thread count scales with the number of processors
  // Thread count minimum is at least `MIN_CPU_AMOUNT` * `IO_THREAD_MULTIPLIER`
  public static Builder newIOBuilder() {
    int numCpus = Runtime.getRuntime().availableProcessors();
    int numThreads = IO_THREAD_MULTIPLIER * Math.max(MIN_THREAD_AMOUNT, numCpus);
    LOGGER.log(
        Level.CONFIG, String.format("Thread Pool for requests has Core Pool Size: %d", numThreads));

    return new AutoValue_InstantiatingExecutorProvider.Builder()
        .setExecutorThreadCount(numThreads)
        .setThreadFactory(DEFAULT_THREAD_FACTORY);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setExecutorThreadCount(int value);

    public abstract int getExecutorThreadCount();

    public abstract Builder setThreadFactory(ThreadFactory value);

    public abstract ThreadFactory getThreadFactory();

    public abstract InstantiatingExecutorProvider build();
  }
}

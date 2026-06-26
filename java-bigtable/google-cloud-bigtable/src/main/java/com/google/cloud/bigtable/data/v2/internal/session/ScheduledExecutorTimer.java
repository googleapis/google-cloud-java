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
package com.google.cloud.bigtable.data.v2.internal.session;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * {@link BigtableTimer} backed by a single-threaded {@link ScheduledExecutorService}.
 *
 * <p>Each {@code newTimeout} schedules a wrapper that hops to the caller-supplied {@link Executor}.
 * Cancel delegates to {@link ScheduledFuture#cancel(boolean)} with {@code mayInterruptIfRunning =
 * false}.
 */
public final class ScheduledExecutorTimer implements BigtableTimer {
  private static final Logger LOG = Logger.getLogger(ScheduledExecutorTimer.class.getName());

  private final ScheduledExecutorService scheduler;
  private final Set<Runnable> stopHooks = ConcurrentHashMap.newKeySet();

  private volatile boolean stopped = false;

  public ScheduledExecutorTimer(String name) {
    this.scheduler =
        Executors.newSingleThreadScheduledExecutor(
            new ThreadFactoryBuilder().setNameFormat(name + "-%d").setDaemon(true).build());
  }

  @Override
  public Timeout newTimeout(Runnable task, Executor executor, long delay, TimeUnit unit) {
    if (stopped) {
      throw new IllegalStateException("timer stopped");
    }
    ScheduledFuture<?> future =
        scheduler.schedule(
            () -> {
              try {
                executor.execute(task);
              } catch (Throwable t) {
                LOG.log(Level.WARNING, "executor.execute threw; dropping task", t);
              }
            },
            delay,
            unit);
    return new FutureTimeout(future);
  }

  @Override
  public Registration onStop(Runnable hook) {
    if (stopped) {
      throw new IllegalStateException("timer stopped");
    }
    stopHooks.add(hook);
    return () -> stopHooks.remove(hook);
  }

  @Override
  public void stop() {
    if (stopped) {
      return;
    }
    stopped = true;
    Set<Runnable> hooks = new HashSet<>(stopHooks);
    stopHooks.clear();
    for (Runnable hook : hooks) {
      try {
        hook.run();
      } catch (Throwable t) {
        LOG.log(Level.WARNING, "stop hook threw; continuing", t);
      }
    }
    scheduler.shutdownNow();
  }

  private static final class FutureTimeout implements Timeout {
    private final ScheduledFuture<?> future;

    FutureTimeout(ScheduledFuture<?> future) {
      this.future = future;
    }

    @Override
    public boolean cancel() {
      return future.cancel(false);
    }

    @Override
    public boolean isCancelled() {
      return future.isCancelled();
    }
  }
}

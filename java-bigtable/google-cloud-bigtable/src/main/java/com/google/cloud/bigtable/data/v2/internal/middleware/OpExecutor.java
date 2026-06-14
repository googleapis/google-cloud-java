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

package com.google.cloud.bigtable.data.v2.internal.middleware;

import java.util.concurrent.Executor;

/**
 * Per-op serializing executor. Wraps a delegate {@link Executor} (typically a per-call {@code
 * SerializingExecutor} over the user-callback pool) and tracks which thread is currently running a
 * task, so callers can assert they are on the executor (analogous to {@code
 * SynchronizationContext#throwIfNotInThisSynchronizationContext}).
 *
 * <p>If a task throws, the registered {@link UncaughtExceptionHandler} is invoked — this is the
 * last-resort recovery point for the chain. Without it, a throw from a user-installed tracer or a
 * listener callback would silently drop and the caller's future would never complete.
 */
public final class OpExecutor implements Executor {

  public interface UncaughtExceptionHandler {
    void uncaught(Throwable t);
  }

  private final Executor backing;
  private final UncaughtExceptionHandler handler;
  private volatile Thread runningThread;

  public OpExecutor(Executor backing, UncaughtExceptionHandler handler) {
    this.backing = backing;
    this.handler = handler;
  }

  @Override
  public void execute(Runnable r) {
    backing.execute(
        () -> {
          Thread prev = runningThread;
          runningThread = Thread.currentThread();
          try {
            r.run();
          } catch (Throwable t) {
            handler.uncaught(t);
          } finally {
            runningThread = prev;
          }
        });
  }

  public void throwIfNotInThisExecutor() {
    if (Thread.currentThread() != runningThread) {
      throw new IllegalStateException("Not running on this op executor");
    }
  }
}

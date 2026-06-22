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
 * Per-op serializing executor. Wraps a delegate {@link Executor} and tracks which thread is
 * currently running a task, so callers can assert they are on the executor (analogous to {@code
 * SynchronizationContext#throwIfNotInThisSynchronizationContext}).
 *
 * <p>Backing executor evolves over the refactor — for now it is the per-call {@link
 * io.grpc.SynchronizationContext} that {@link VOperationImpl} constructs. Later commits swap it for
 * a {@code SerializingExecutor} over the user-callback pool, and eventually a tailored inline
 * queue.
 */
public final class OpExecutor implements Executor {

  private final Executor backing;
  private volatile Thread runningThread;

  public OpExecutor(Executor backing) {
    this.backing = backing;
  }

  @Override
  public void execute(Runnable r) {
    backing.execute(
        () -> {
          Thread prev = runningThread;
          runningThread = Thread.currentThread();
          try {
            r.run();
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

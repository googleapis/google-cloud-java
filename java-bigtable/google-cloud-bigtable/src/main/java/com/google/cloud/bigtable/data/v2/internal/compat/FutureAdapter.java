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
package com.google.cloud.bigtable.data.v2.internal.compat;

import com.google.api.core.ApiFuture;
import io.grpc.Context.CancellableContext;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nonnull;

public class FutureAdapter<V> implements ApiFuture<V> {
  private final CompletableFuture<V> inner;
  private final CancellableContext ambientCtx;

  public FutureAdapter(CompletableFuture<V> inner, CancellableContext ambientCtx) {
    this.inner = inner;
    this.ambientCtx = ambientCtx;

    CompletableFuture<V> ignored = inner.whenComplete((ignored1, ignored2) -> ambientCtx.close());
  }

  @Override
  public void addListener(Runnable listener, Executor executor) {
    @SuppressWarnings("UnusedVariable")
    CompletableFuture<V> ignored = inner.whenCompleteAsync((v, t) -> listener.run(), executor);
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    boolean wasCancelled = inner.cancel(mayInterruptIfRunning);
    ambientCtx.cancel(new CancellationException("Operation Future was cancelled by the end user"));
    return wasCancelled;
  }

  @Override
  public boolean isCancelled() {
    return inner.isCancelled();
  }

  @Override
  public boolean isDone() {
    return inner.isDone();
  }

  @Override
  public V get() throws InterruptedException, ExecutionException {
    return inner.get();
  }

  @Override
  public V get(long timeout, @Nonnull TimeUnit unit)
      throws InterruptedException, ExecutionException, TimeoutException {
    return inner.get(timeout, unit);
  }
}

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
package com.google.cloud.bigtable.data.v2.internal.compat.ops;

import com.google.cloud.bigtable.data.v2.internal.compat.Util;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.Closeable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * Lazily-loaded map from target IDs to per-target handles (TableAsync / AuthorizedViewAsync /
 * MaterializedViewAsync, each holding a SessionPool), backed by a Guava {@link LoadingCache}.
 * Centralizes the conversion from Guava's {@link UncheckedExecutionException} (which wraps any
 * loader throw) into the appropriate shape for each call site: a raw {@link RuntimeException} for
 * sync inspections, or a failed {@link CompletableFuture} for async ops.
 *
 * <p>The most common loader failure is {@link IllegalStateException} from {@code
 * Client.openTableAsync} after {@code Client.close}; without unwrapping, callers see {@code
 * UncheckedExecutionException} instead of the documented exception type and async callers see a
 * thrown exception instead of a failed future.
 */
public class SessionPoolMap<K, V extends Closeable> {
  private final LoadingCache<K, V> cache;

  public SessionPoolMap(Function<K, V> loader) {
    this.cache = Util.createSessionMap(loader);
  }

  /** Returns the cached value, loading on miss. Loader throws surface as the original cause. */
  public V get(K key) {
    try {
      return cache.getUnchecked(key);
    } catch (UncheckedExecutionException e) {
      Throwable cause = e.getCause() != null ? e.getCause() : e;
      if (cause instanceof RuntimeException) throw (RuntimeException) cause;
      if (cause instanceof Error) throw (Error) cause;
      throw new RuntimeException(cause);
    }
  }

  /**
   * Looks up the cached value and applies {@code op}. Both the lookup (e.g. {@link
   * IllegalStateException} from a closed Client) and a synchronous throw from {@code op.apply}
   * (e.g. NPE on malformed input, RejectedExecutionException during shutdown) are converted to a
   * failed future so callers consistently observe failures through the future surface.
   */
  public <R> CompletableFuture<R> apply(K key, Function<V, CompletableFuture<R>> op) {
    V v;
    try {
      v = get(key);
    } catch (Exception e) {
      CompletableFuture<R> f = new CompletableFuture<>();
      f.completeExceptionally(e);
      return f;
    }
    try {
      return op.apply(v);
    } catch (Throwable t) {
      CompletableFuture<R> f = new CompletableFuture<>();
      f.completeExceptionally(t);
      return f;
    }
  }

  /** Evicts all entries, triggering Closeable.close on each via the cache's removal listener. */
  public void invalidateAll() {
    cache.invalidateAll();
  }
}

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

import com.google.cloud.bigtable.data.v2.internal.api.AuthorizedViewAsync;
import com.google.cloud.bigtable.data.v2.internal.api.Client;
import com.google.cloud.bigtable.data.v2.internal.api.MaterializedViewAsync;
import com.google.cloud.bigtable.data.v2.internal.api.TableAsync;
import com.google.cloud.bigtable.data.v2.internal.compat.Util;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.MaterializedViewId;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.Closeable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * Shared registry of per-target session-pool handles, partitioned by target ID type and {@link
 * SessionKey.Permission}. Callers that request the same {@code (id, permission)} pair share a
 * single handle regardless of which shim operation they belong to — e.g., a future
 * CheckAndMutateRowShim and ReadModifyWriteRowShim both using {@link
 * SessionKey.Permission#READ_WRITE} on the same table will get the same {@link TableAsync} and
 * therefore the same session pool.
 *
 * <p>Backed by Guava {@link LoadingCache}. Centralizes conversion from {@link
 * UncheckedExecutionException} (which wraps any loader throw) into the appropriate shape for each
 * call site: a raw {@link RuntimeException} for sync inspections, or a failed {@link
 * CompletableFuture} for async ops.
 *
 * <p>Lifecycle: created once per {@code ShimImpl}, closed via {@link #invalidateAll()} when the
 * shim closes.
 */
public class SessionPoolMap {
  private final LoadingCache<SessionKey<TableId>, TableAsync> tables;
  private final LoadingCache<SessionKey<AuthorizedViewId>, AuthorizedViewAsync> authViews;
  private final LoadingCache<SessionKey<MaterializedViewId>, MaterializedViewAsync> matViews;

  public SessionPoolMap(Client client) {
    tables =
        Util.createSessionMap(
            key ->
                client.openTableAsync(key.id().getTableId(), key.permission().tablePermission()));
    authViews =
        Util.createSessionMap(
            key ->
                client.openAuthorizedViewAsync(
                    key.id().getTableId(),
                    key.id().getAuthorizedViewId(),
                    key.permission().authViewPermission()));
    matViews =
        Util.createSessionMap(
            key ->
                client.openMaterializedViewAsync(
                    key.id().getMaterializedViewId(), key.permission().matViewPermission()));
  }

  // --- get (loading lookup — opens the pool if not already cached) ---

  /** Returns the cached handle, opening the pool on first use. Loader throws surface as-is. */
  public TableAsync get(TableId id, SessionKey.Permission p) {
    return getUnchecked(tables, SessionKey.of(id, p));
  }

  public AuthorizedViewAsync get(AuthorizedViewId id, SessionKey.Permission p) {
    return getUnchecked(authViews, SessionKey.of(id, p));
  }

  public MaterializedViewAsync get(MaterializedViewId id, SessionKey.Permission p) {
    return getUnchecked(matViews, SessionKey.of(id, p));
  }

  // --- apply (for call() — opens the pool lazily on first use) ---

  /**
   * Looks up the cached handle and applies {@code op}. Both the lookup (e.g. {@link
   * IllegalStateException} from a closed Client) and a synchronous throw from {@code op.apply} are
   * converted to a failed future so callers consistently observe failures through the future
   * surface.
   */
  public <R> CompletableFuture<R> apply(
      TableId id, SessionKey.Permission p, Function<TableAsync, CompletableFuture<R>> op) {
    return applyUnchecked(tables, SessionKey.of(id, p), op);
  }

  public <R> CompletableFuture<R> apply(
      AuthorizedViewId id,
      SessionKey.Permission p,
      Function<AuthorizedViewAsync, CompletableFuture<R>> op) {
    return applyUnchecked(authViews, SessionKey.of(id, p), op);
  }

  public <R> CompletableFuture<R> apply(
      MaterializedViewId id,
      SessionKey.Permission p,
      Function<MaterializedViewAsync, CompletableFuture<R>> op) {
    return applyUnchecked(matViews, SessionKey.of(id, p), op);
  }

  /** Evicts all entries, triggering Closeable.close on each via the cache's removal listener. */
  public void invalidateAll() {
    try {
      tables.invalidateAll();
    } finally {
      try {
        authViews.invalidateAll();
      } finally {
        matViews.invalidateAll();
      }
    }
  }

  private static <K, V extends Closeable> V getUnchecked(LoadingCache<K, V> cache, K key) {
    try {
      return cache.getUnchecked(key);
    } catch (UncheckedExecutionException e) {
      Throwable cause = e.getCause() != null ? e.getCause() : e;
      if (cause instanceof RuntimeException) throw (RuntimeException) cause;
      if (cause instanceof Error) throw (Error) cause;
      throw new RuntimeException(cause);
    }
  }

  private static <K, V extends Closeable, R> CompletableFuture<R> applyUnchecked(
      LoadingCache<K, V> cache, K key, Function<V, CompletableFuture<R>> op) {
    V v;
    try {
      v = getUnchecked(cache, key);
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
}

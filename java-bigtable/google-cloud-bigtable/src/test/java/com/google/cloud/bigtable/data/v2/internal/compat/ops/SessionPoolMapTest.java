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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.Closeable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class SessionPoolMapTest {

  // Minimal Closeable value type — tracks how many times close() was called so invalidateAll's
  // removal-listener wiring is observable from tests.
  private static final class CountingHandle implements Closeable {
    final AtomicInteger closeCount = new AtomicInteger();

    @Override
    public void close() {
      closeCount.incrementAndGet();
    }
  }

  @Test
  void get_unwrapsLoaderRuntimeException() {
    // Production trigger: Client.openTableAsync throws IllegalStateException after Client.close.
    // The Guava LoadingCache wraps it in UncheckedExecutionException; SessionPoolMap.get must
    // surface the original IllegalStateException so callers can pattern-match on it.
    SessionPoolMap<String, CountingHandle> map =
        new SessionPoolMap<>(
            key -> {
              throw new IllegalStateException("Client is closed");
            });

    IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> map.get("k"));
    assertThat(thrown).hasMessageThat().isEqualTo("Client is closed");
  }

  @Test
  void apply_convertsLoaderThrowToFailedFuture() throws Exception {
    // The async surface must not throw — callers wire onFailure handlers on the returned future.
    SessionPoolMap<String, CountingHandle> map =
        new SessionPoolMap<>(
            key -> {
              throw new IllegalStateException("Client is closed");
            });

    CompletableFuture<String> result =
        map.apply("k", v -> CompletableFuture.completedFuture("unreached"));

    assertThat(result.isCompletedExceptionally()).isTrue();
    ExecutionException ee =
        assertThrows(ExecutionException.class, () -> result.get(1, TimeUnit.SECONDS));
    assertThat(ee).hasCauseThat().isInstanceOf(IllegalStateException.class);
    assertThat(ee).hasCauseThat().hasMessageThat().isEqualTo("Client is closed");
  }

  @Test
  void apply_convertsOpSyncThrowToFailedFuture() throws Exception {
    // op.apply may throw synchronously (NPE on malformed input, REE during shutdown, any
    // RuntimeException from the wrapped call chain). The async surface must not propagate
    // the throw — same contract as the loader-throw path above.
    CountingHandle handle = new CountingHandle();
    SessionPoolMap<String, CountingHandle> map = new SessionPoolMap<>(key -> handle);

    CompletableFuture<String> result =
        map.apply(
            "k",
            v -> {
              throw new IllegalStateException("op blew up");
            });

    assertThat(result.isCompletedExceptionally()).isTrue();
    ExecutionException ee =
        assertThrows(ExecutionException.class, () -> result.get(1, TimeUnit.SECONDS));
    assertThat(ee).hasCauseThat().isInstanceOf(IllegalStateException.class);
    assertThat(ee).hasCauseThat().hasMessageThat().isEqualTo("op blew up");
  }

  @Test
  void apply_happyPathInvokesOp() throws Exception {
    CountingHandle handle = new CountingHandle();
    SessionPoolMap<String, CountingHandle> map = new SessionPoolMap<>(key -> handle);

    CompletableFuture<String> result = map.apply("k", v -> CompletableFuture.completedFuture("ok"));

    assertThat(result.get(1, TimeUnit.SECONDS)).isEqualTo("ok");
  }

  @Test
  void invalidateAll_closesCachedValues() {
    CountingHandle handle = new CountingHandle();
    SessionPoolMap<String, CountingHandle> map = new SessionPoolMap<>(key -> handle);

    // Populate the cache so invalidateAll has something to evict.
    map.get("k");
    assertThat(handle.closeCount.get()).isEqualTo(0);

    map.invalidateAll();
    assertThat(handle.closeCount.get()).isEqualTo(1);
  }
}

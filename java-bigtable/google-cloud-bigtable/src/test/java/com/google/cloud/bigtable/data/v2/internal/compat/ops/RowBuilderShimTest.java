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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.Row;
import com.google.cloud.bigtable.data.v2.models.RowAdapter;
import io.grpc.Deadline;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RowBuilderShimTest {

  private UnaryShim<String, String> inner;
  private RowAdapter<String> adapter;
  private RowBuilderShim<String, String, String> shim;

  @BeforeEach
  @SuppressWarnings("unchecked")
  void setUp() {
    inner = mock(UnaryShim.class);
    adapter = mock(RowAdapter.class);
    shim = new RowBuilderShim<>(inner, adapter, r -> Row.getDefaultInstance());
  }

  @Test
  void supports_delegatesToInner() {
    when(inner.supports("req")).thenReturn(true);
    assertThat(shim.supports("req")).isTrue();

    when(inner.supports("req")).thenReturn(false);
    assertThat(shim.supports("req")).isFalse();
  }

  @Test
  void call_delegatesAndAppliesAdapter() throws Exception {
    Row protoRow = Row.getDefaultInstance();
    CompletableFuture<String> innerFuture = CompletableFuture.completedFuture("proto-resp");
    when(inner.call(any(), any())).thenReturn(innerFuture);
    when(adapter.buildRowFromProto(protoRow)).thenReturn("built-row");

    RowBuilderShim<String, String, String> shimWithExtractor =
        new RowBuilderShim<>(inner, adapter, r -> protoRow);

    String result =
        shimWithExtractor
            .call("req", Deadline.after(1, java.util.concurrent.TimeUnit.SECONDS))
            .get();

    assertThat(result).isEqualTo("built-row");
    verify(adapter).buildRowFromProto(protoRow);
  }

  @Test
  void call_nullRowFromExtractor_returnsNull() throws Exception {
    CompletableFuture<String> innerFuture = CompletableFuture.completedFuture("proto-resp");
    when(inner.call(any(), any())).thenReturn(innerFuture);
    when(adapter.buildRowFromProto(null)).thenReturn(null);

    RowBuilderShim<String, String, String> shimWithNullExtractor =
        new RowBuilderShim<>(inner, adapter, r -> null);

    String result =
        shimWithNullExtractor
            .call("req", Deadline.after(1, java.util.concurrent.TimeUnit.SECONDS))
            .get();

    assertThat(result).isNull();
    verify(adapter).buildRowFromProto(null);
  }

  @Test
  void close_delegatesToInner() throws IOException {
    shim.close();
    verify(inner).close();
  }
}

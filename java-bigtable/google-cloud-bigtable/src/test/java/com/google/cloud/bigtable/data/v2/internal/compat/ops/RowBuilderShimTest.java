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
import com.google.cloud.bigtable.data.v2.models.DefaultRowAdapter;
import com.google.cloud.bigtable.data.v2.models.RowAdapter;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import io.grpc.Deadline;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RowBuilderShimTest {

  private UnaryShim<String, String> inner;
  private RowAdapter<String> adapter;
  private RowAdapter.RowBuilder<String> rowBuilder;
  private RowBuilderShim<String, String, String> shim;

  @BeforeEach
  @SuppressWarnings("unchecked")
  void setUp() {
    inner = mock(UnaryShim.class);
    adapter = mock(RowAdapter.class);
    rowBuilder = mock(RowAdapter.RowBuilder.class);
    when(adapter.createRowBuilder()).thenReturn(rowBuilder);
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
    Row protoRow = Row.newBuilder().setKey(ByteString.copyFromUtf8("row-key")).build();
    CompletableFuture<String> innerFuture = CompletableFuture.completedFuture("proto-resp");
    when(inner.call(any(), any())).thenReturn(innerFuture);
    when(rowBuilder.finishRow()).thenReturn("built-row");

    RowBuilderShim<String, String, String> shimWithExtractor =
        new RowBuilderShim<>(inner, adapter, r -> protoRow);

    String result = shimWithExtractor.call("req", Deadline.after(1, TimeUnit.SECONDS)).get();

    assertThat(result).isEqualTo("built-row");
    verify(adapter).createRowBuilder();
    verify(rowBuilder).startRow(ByteString.copyFromUtf8("row-key"));
    verify(rowBuilder).finishRow();
  }

  @Test
  void call_nullRowFromExtractor_returnsNull() throws Exception {
    CompletableFuture<String> innerFuture = CompletableFuture.completedFuture("proto-resp");
    when(inner.call(any(), any())).thenReturn(innerFuture);

    RowBuilderShim<String, String, String> shimWithNullExtractor =
        new RowBuilderShim<>(inner, adapter, r -> null);

    String result = shimWithNullExtractor.call("req", Deadline.after(1, TimeUnit.SECONDS)).get();

    assertThat(result).isNull();
  }

  @Test
  void close_delegatesToInner() throws IOException {
    shim.close();
    verify(inner).close();
  }

  @Test
  void buildRowFromProto_nullInput_returnsNull() {
    assertThat(RowBuilderShim.buildRowFromProto(new DefaultRowAdapter(), null)).isNull();
  }

  @Test
  void buildRowFromProto_emptyRow_returnsRowWithKey() {
    Row proto = Row.newBuilder().setKey(ByteString.copyFromUtf8("key")).build();

    com.google.cloud.bigtable.data.v2.models.Row row =
        RowBuilderShim.buildRowFromProto(new DefaultRowAdapter(), proto);

    assertThat(row)
        .isEqualTo(
            com.google.cloud.bigtable.data.v2.models.Row.create(
                ByteString.copyFromUtf8("key"), ImmutableList.of()));
  }

  @Test
  void buildRowFromProto_multipleFamiliesAndCells_roundTrips() {
    ByteString key = ByteString.copyFromUtf8("key");
    ByteString col = ByteString.copyFromUtf8("col");
    ByteString val1 = ByteString.copyFromUtf8("val1");
    ByteString val2 = ByteString.copyFromUtf8("val2");

    Row proto =
        Row.newBuilder()
            .setKey(key)
            .addFamilies(
                com.google.bigtable.v2.Family.newBuilder()
                    .setName("f1")
                    .addColumns(
                        com.google.bigtable.v2.Column.newBuilder()
                            .setQualifier(col)
                            .addCells(
                                com.google.bigtable.v2.Cell.newBuilder()
                                    .setTimestampMicros(1_000)
                                    .setValue(val1)
                                    .addLabels("lbl"))))
            .addFamilies(
                com.google.bigtable.v2.Family.newBuilder()
                    .setName("f2")
                    .addColumns(
                        com.google.bigtable.v2.Column.newBuilder()
                            .setQualifier(col)
                            .addCells(
                                com.google.bigtable.v2.Cell.newBuilder()
                                    .setTimestampMicros(2_000)
                                    .setValue(val2)
                                    .addLabels("lbl"))))
            .build();

    com.google.cloud.bigtable.data.v2.models.Row row =
        RowBuilderShim.buildRowFromProto(new DefaultRowAdapter(), proto);

    assertThat(row)
        .isEqualTo(
            com.google.cloud.bigtable.data.v2.models.Row.create(
                key,
                ImmutableList.of(
                    RowCell.create("f1", col, 1_000, ImmutableList.of("lbl"), val1),
                    RowCell.create("f2", col, 2_000, ImmutableList.of("lbl"), val2))));
  }
}

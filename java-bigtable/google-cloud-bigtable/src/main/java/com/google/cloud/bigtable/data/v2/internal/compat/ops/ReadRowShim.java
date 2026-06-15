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

import com.google.bigtable.v2.Cell;
import com.google.bigtable.v2.Column;
import com.google.bigtable.v2.Family;
import com.google.bigtable.v2.SessionReadRowResponse;
import com.google.cloud.bigtable.data.v2.models.DefaultRowAdapter;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowAdapter;
import com.google.cloud.bigtable.data.v2.models.RowAdapter.RowBuilder;
import io.grpc.Deadline;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * Stateless wrapper around {@link ReadRowShimInner}. It primary purpose is to pair a {@link
 * RowAdapter} with a stateful {@link ReadRowShimInner}.
 */
public class ReadRowShim<RowT> implements UnaryShim<Query, RowT> {
  private static final RowAdapter<Row> DEFAULT_ADAPTER = new DefaultRowAdapter();

  private final ReadRowShimInner inner;
  private final RowAdapter<RowT> adapter;

  public static ReadRowShim<Row> createDefault(ReadRowShimInner inner) {
    return new ReadRowShim<>(inner, DEFAULT_ADAPTER);
  }

  public ReadRowShim(ReadRowShimInner inner, RowAdapter<RowT> adapter) {
    this.inner = inner;
    this.adapter = adapter;
  }

  @Override
  public boolean supports(Query request) {
    return inner.supports(request);
  }

  @Override
  public CompletableFuture<RowT> call(Query request, Deadline deadline) {
    CompletableFuture<SessionReadRowResponse> f = inner.call(request, deadline);
    return f.thenApply(r -> buildRow(adapter.createRowBuilder(), r));
  }

  @Override
  public void close() throws IOException {
    inner.close();
  }

  private static <T> T buildRow(RowBuilder<T> adapter, SessionReadRowResponse input) {
    if (!input.hasRow()) {
      return null;
    }
    com.google.bigtable.v2.Row protoRow = input.getRow();

    adapter.startRow(protoRow.getKey());

    for (Family family : protoRow.getFamiliesList()) {
      for (Column column : family.getColumnsList()) {
        for (Cell cell : column.getCellsList()) {
          adapter.startCell(
              family.getName(),
              column.getQualifier(),
              cell.getTimestampMicros(),
              cell.getLabelsList(),
              0);
          adapter.cellValue(cell.getValue());
          adapter.finishCell();
        }
      }
    }
    return adapter.finishRow();
  }
}

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
import com.google.bigtable.v2.Row;
import com.google.cloud.bigtable.data.v2.models.RowAdapter;
import io.grpc.Deadline;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * Generic {@link UnaryShim} adapter that pairs an inner proto-response shim with a {@link
 * RowAdapter}. Delegates {@code supports()} and the RPC to the inner shim, then extracts a {@link
 * Row} proto from the response via {@code rowExtractor} (null when no row) and converts it to the
 * user type via {@link #buildRowFromProto}.
 */
public class RowBuilderShim<ReqT, ProtoRespT, RowT> implements UnaryShim<ReqT, RowT> {

  private final UnaryShim<ReqT, ProtoRespT> inner;
  private final RowAdapter<RowT> adapter;
  private final Function<ProtoRespT, Row> rowExtractor;

  public RowBuilderShim(
      UnaryShim<ReqT, ProtoRespT> inner,
      RowAdapter<RowT> adapter,
      Function<ProtoRespT, Row> rowExtractor) {
    this.inner = inner;
    this.adapter = adapter;
    this.rowExtractor = rowExtractor;
  }

  @Override
  public boolean supports(ReqT request) {
    return inner.supports(request);
  }

  @Override
  public CompletableFuture<RowT> call(ReqT request, Deadline deadline) {
    return inner
        .call(request, deadline)
        .thenApply(r -> buildRowFromProto(adapter, rowExtractor.apply(r)));
  }

  @Override
  public void close() throws IOException {
    inner.close();
  }

  static <RowT> RowT buildRowFromProto(RowAdapter<RowT> adapter, Row protoRow) {
    if (protoRow == null) {
      return null;
    }
    RowAdapter.RowBuilder<RowT> builder = adapter.createRowBuilder();
    builder.startRow(protoRow.getKey());
    for (Family family : protoRow.getFamiliesList()) {
      for (Column column : family.getColumnsList()) {
        for (Cell cell : column.getCellsList()) {
          builder.startCell(
              family.getName(),
              column.getQualifier(),
              cell.getTimestampMicros(),
              cell.getLabelsList(),
              0);
          builder.cellValue(cell.getValue());
          builder.finishCell();
        }
      }
    }
    return builder.finishRow();
  }
}

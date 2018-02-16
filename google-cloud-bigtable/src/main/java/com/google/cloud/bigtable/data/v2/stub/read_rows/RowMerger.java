/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.read_rows;

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.cloud.bigtable.data.v2.wrappers.RowAdapter.RowBuilder;
import com.google.cloud.bigtable.gaxx.reframing.Reframer;
import com.google.common.base.Preconditions;

/**
 * An implementation of a {@link Reframer} that feeds the row merging {@link StateMachine}.
 *
 * <p>{@link com.google.cloud.bigtable.gaxx.reframing.ReframingResponseObserver} pushes {@link
 * ReadRowsResponse.CellChunk}s into this class and pops fully merged logical rows.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 *
 * <p>Package-private for internal use.
 */
@InternalApi
class RowMerger<RowT> implements Reframer<RowT, ReadRowsResponse> {
  private final StateMachine<RowT> stateMachine;
  private ReadRowsResponse buffer;
  private int nextChunk;
  private RowT nextRow;

  RowMerger(RowBuilder<RowT> rowBuilder) {
    stateMachine = new StateMachine<>(rowBuilder);

    nextChunk = 0;
    buffer = ReadRowsResponse.getDefaultInstance();
  }

  @Override
  public void push(ReadRowsResponse response) {
    Preconditions.checkState(
        buffer.getChunksCount() <= nextChunk, "Previous response not fully consumed");

    buffer = response;
    nextChunk = 0;

    // If the server sends a scan heartbeat, wrap it in a synthetic row that will be be filtered out
    // after the resume logic.
    if (!response.getLastScannedRowKey().isEmpty()) {
      stateMachine.handleLastScannedRow(response.getLastScannedRowKey());
      nextRow = stateMachine.consumeRow();
    }
  }

  @Override
  public boolean hasFullFrame() {
    return nextRow != null || readNextRow();
  }

  @Override
  public boolean hasPartialFrame() {
    return hasFullFrame() || stateMachine.isRowInProgress();
  }

  @Override
  public RowT pop() {
    RowT row = nextRow;
    nextRow = null;
    return row;
  }

  private boolean readNextRow() {
    while (nextChunk < buffer.getChunksCount()) {
      if (stateMachine.handleChunk(buffer.getChunks(nextChunk++))) {
        nextRow = stateMachine.consumeRow();
        return true;
      }
    }
    return false;
  }
}

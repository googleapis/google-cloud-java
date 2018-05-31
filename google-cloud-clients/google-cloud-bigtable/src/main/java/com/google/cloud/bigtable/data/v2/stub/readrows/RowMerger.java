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
package com.google.cloud.bigtable.data.v2.stub.readrows;

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.cloud.bigtable.data.v2.models.RowAdapter.RowBuilder;
import com.google.cloud.bigtable.gaxx.reframing.Reframer;
import com.google.common.base.Preconditions;

/**
 * An implementation of a {@link Reframer} that feeds the row merging {@link StateMachine}.
 *
 * <p>{@link com.google.cloud.bigtable.gaxx.reframing.ReframingResponseObserver} pushes {@link
 * com.google.bigtable.v2.ReadRowsResponse.CellChunk}s into this class and pops fully merged logical
 * rows. Example usage:
 *
 * <pre>{@code
 * RowMerger<Row> rowMerger = new RowMerger<>(myRowBuilder);
 *
 * while(responseIterator.hasNext()) {
 *   ReadRowsResponse response = responseIterator.next();
 *
 *   if (rowMerger.hasFullFrame()) {
 *     Row row = rowMerger.pop();
 *     // Do something with row.
 *   } else {
 *     rowMerger.push(response);
 *   }
 * }
 *
 * if (rowMerger.hasPartialFrame()) {
 *   throw new RuntimeException("Incomplete stream");
 * }
 *
 * }</pre>
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 *
 * <p>Package-private for internal use.
 *
 * @see com.google.cloud.bigtable.gaxx.reframing.ReframingResponseObserver for more details
 */
@InternalApi
public class RowMerger<RowT> implements Reframer<RowT, ReadRowsResponse> {
  private final StateMachine<RowT> stateMachine;
  private ReadRowsResponse buffer;
  private int nextChunk;
  private RowT nextRow;

  public RowMerger(RowBuilder<RowT> rowBuilder) {
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

    // If the server sends a scan heartbeat, notify the StateMachine. It will generate a synthetic
    // row marker. See RowAdapter for more info.
    if (!response.getLastScannedRowKey().isEmpty()) {
      stateMachine.handleLastScannedRow(response.getLastScannedRowKey());
    }
  }

  @Override
  public boolean hasFullFrame() {
    // Check if there an assembled row to consume
    if (nextRow != null) {
      return true;
    }

    // Otherwise try to assemble a new row (readNextRow will set nextRow)
    boolean newRowCompleted = readNextRow();
    return newRowCompleted;
  }

  @Override
  public boolean hasPartialFrame() {
    // Check if any of the buffers in this class contain data.
    // `hasFullFrame()` will check if `nextRow` has a row ready to go or if chunks in `buffer` can
    // be used to create a new `nextRow`
    if (hasFullFrame()) {
      return true;
    }

    // If an assembled is still not available, then that means `buffer` has been fully consumed.
    // The last place to check is the StateMachine buffer, to see if its holding on to an incomplete
    // row.
    return stateMachine.isRowInProgress();
  }

  @Override
  public RowT pop() {
    RowT row = nextRow;
    nextRow = null;
    return row;
  }

  private boolean readNextRow() {
    // StateMachine might have a complete row already from receiving a scan marker.
    if (stateMachine.hasCompleteRow()) {
      nextRow = stateMachine.consumeRow();
      return true;
    }

    while (nextChunk < buffer.getChunksCount()) {
      stateMachine.handleChunk(buffer.getChunks(nextChunk++));

      if (stateMachine.hasCompleteRow()) {
        nextRow = stateMachine.consumeRow();
        return true;
      }
    }
    return false;
  }
}

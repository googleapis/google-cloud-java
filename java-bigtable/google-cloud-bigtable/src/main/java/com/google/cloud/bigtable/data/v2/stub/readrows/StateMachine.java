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

import com.google.bigtable.v2.ReadRowsResponse.CellChunk;
import com.google.cloud.bigtable.data.v2.internal.ByteStringComparator;
import com.google.cloud.bigtable.data.v2.models.RowAdapter.RowBuilder;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.EvictingQueue;
import com.google.protobuf.ByteString;
import java.util.List;

/**
 * A state machine to merge {@link com.google.bigtable.v2.ReadRowsResponse.CellChunk}s from a
 * ReadRows response stream. Building of the actual row object is delegated to a {@link RowBuilder}.
 * This class is not thread safe.
 *
 * <p>The inputs are:
 *
 * <ul>
 *   <li>CellChunks that must be merged to form logical rows
 *   <li>Last scanned row notifications from the server to signal a more efficient resume point
 *   <li>Row consumption events that reset the state machine for the next row
 * </ul>
 *
 * <p>The outputs are:
 *
 * <ul>
 *   <li>Logical rows that were constructed using the {@link RowBuilder}
 *   <li>Special marker rows that represent resumption points that were sent by last scanned row
 *       notifications.
 * </ul>
 *
 * <p>Expected Usage:
 *
 * <pre>{@code
 * StateMachine stateMachine = new StateMachine<>(myRowAdapter);
 * while(responseIterator.hasNext()) {
 *   ReadRowsResponse response = responseIterator.next();
 *   if (!response.getLastScannedRowKey().isEmpty()) {
 *     stateMachine.handleLastScannedRow(response.getLastScannedRowKey());
 *   }
 *
 *   for(CellChunk chunk : response.getChunksList()) {
 *     boolean hasCompleteRow = stateMachine.handleChunk(chunk);
 *     if (hasCompleteRow) {
 *       MyRow row = stateMachine.consumeRow();
 *
 *       if (myRowAdapter.isScanMarkerRow(row) {
 *         // do something with marker
 *       } else {
 *         // do something with row
 *       }
 *     }
 *   }
 * }
 * }</pre>
 *
 * <p>Package-private for internal use.
 *
 * @param <RowT> The type of row the adapter will build
 */
final class StateMachine<RowT> {
  private final RowBuilder<RowT> adapter;
  private State currentState;
  private ByteString lastCompleteRowKey;

  // debug stats
  private int numScannedNotifications = 0;
  private int numRowsCommitted = 0;
  private int numChunksProcessed = 0;
  private int numCellsInRow = 0;
  private int numCellsInLastRow = 0;
  private EvictingQueue<ByteString> lastSeenKeys = EvictingQueue.create(5);

  // Track current cell attributes: protocol omits them when they are repeated
  private ByteString rowKey;
  private String familyName;
  private ByteString qualifier;
  private long timestamp;
  private List<String> labels;
  private long expectedCellSize;
  private long remainingCellBytes;

  private RowT completeRow;

  /**
   * Initialize a new state machine that's ready for a new row.
   *
   * @param adapter The adapter that will build the final row.
   */
  StateMachine(RowBuilder<RowT> adapter) {
    this.adapter = adapter;
    reset();
  }

  /**
   * Handle last scanned row events from the server.
   *
   * <p>The server might return the row key of the last row it has scanned. The client can use this
   * to construct a more efficient retry request if needed: any row keys or portions of ranges less
   * than this row key can be dropped from the request. The retry logic is implemented downstream
   * from the logical rows produced by this class. To communicate this information to the retry
   * logic, the state machine will encode the last scanned keys as scan marker rows using {@link
   * RowBuilder#createScanMarkerRow(ByteString)}. It is the responsibility of the retry logic to
   * filter out these marker before delivering the results to the user.
   *
   * <p>The scan marker must be immediately consumed before any more events are processed.
   *
   * <dl>
   *   <dt>Valid states:
   *   <dd>{@link StateMachine#AWAITING_NEW_ROW}
   *   <dt>Resulting states:
   *   <dd>{@link StateMachine#AWAITING_ROW_CONSUME}
   * </dl>
   */
  void handleLastScannedRow(ByteString key) {
    try {
      numScannedNotifications++;
      currentState = currentState.handleLastScannedRow(key);
    } catch (RuntimeException e) {
      currentState = null;
      throw e;
    }
  }

  /**
   * Feeds a new chunk into the sate machine. If the chunk is invalid, the state machine will throw
   * an exception and should not be used for further input.
   *
   * <dl>
   *   <dt>Valid states:
   *   <dd>{@link StateMachine#AWAITING_NEW_ROW}
   *   <dd>{@link StateMachine#AWAITING_NEW_CELL}
   *   <dd>{@link StateMachine#AWAITING_CELL_VALUE}
   *   <dt>Resulting states:
   *   <dd>{@link StateMachine#AWAITING_NEW_CELL}
   *   <dd>{@link StateMachine#AWAITING_CELL_VALUE}
   *   <dd>{@link StateMachine#AWAITING_ROW_CONSUME}
   * </dl>
   *
   * @param chunk The new chunk to process.
   * @throws InvalidInputException When the chunk is not applicable to the current state.
   * @throws IllegalStateException When the internal state is inconsistent
   */
  void handleChunk(CellChunk chunk) {
    try {
      numChunksProcessed++;
      currentState = currentState.handleChunk(chunk);
    } catch (RuntimeException e) {
      currentState = null;
      throw e;
    }
  }

  /**
   * Returns the last completed row and transitions to awaiting a new row.
   *
   * @return The last completed row.
   * @throws IllegalStateException If the last chunk did not complete a row.
   */
  RowT consumeRow() {
    Preconditions.checkState(currentState == AWAITING_ROW_CONSUME, "No row to consume");
    RowT row = completeRow;
    reset();
    return row;
  }

  /** Checks if there is a complete to bew consumed. */
  boolean hasCompleteRow() {
    return currentState == AWAITING_ROW_CONSUME;
  }
  /**
   * Checks if the state machine is in the middle of processing a row.
   *
   * @return True If there is a row in progress.
   */
  boolean isRowInProgress() {
    return currentState != AWAITING_NEW_ROW;
  }

  private void reset() {
    currentState = AWAITING_NEW_ROW;
    rowKey = null;
    familyName = null;
    qualifier = null;
    timestamp = 0;
    labels = null;
    expectedCellSize = 0;
    remainingCellBytes = 0;
    completeRow = null;
    numCellsInRow = 0;

    adapter.reset();
  }

  /**
   * Base class for all of the state machine's internal states.
   *
   * <p>Each state can consume 2 events: lastScannedRowKey and a chunk. By default, the default
   * implementation will just throw an IllegalStateException unless the subclass adds explicit
   * handling for the event by overriding {@link #handleLastScannedRow(ByteString)} or {@link
   * #handleChunk(CellChunk)}.
   */
  abstract static class State {
    /**
     * Accepts the last row key scanned by the server. And set its as the last complete row. This
     * row should be treated specially because it doesn't actually contain data.
     *
     * @throws IllegalStateException If the subclass can't handle last scanned row events.
     */
    State handleLastScannedRow(ByteString rowKey) {
      throw new IllegalStateException();
    }

    /**
     * Accepts a new chunk and transitions to the next state.
     *
     * @param chunk The new chunk to process.
     * @return The next state.
     * @throws IllegalStateException If the subclass can't handle chunks.
     * @throws InvalidInputException If the subclass determines that this chunk is invalid.
     */
    State handleChunk(CellChunk chunk) {
      throw new IllegalStateException();
    }
  }

  /**
   * The default state when the state machine is awaiting a chunk to start a new row. It will notify
   * the adapter of the new row and delegate to the AWAITING_NEW_CELL state to process the first
   * Cell in the Chunk. Exit states: same as AWAITING_NEW_CELL
   */
  private final State AWAITING_NEW_ROW =
      new State() {
        @Override
        State handleLastScannedRow(ByteString rowKey) {
          completeRow = adapter.createScanMarkerRow(rowKey);
          lastCompleteRowKey = rowKey;
          return AWAITING_ROW_CONSUME;
        }

        @Override
        State handleChunk(CellChunk chunk) {
          validate(!chunk.getResetRow(), "AWAITING_NEW_ROW: can't reset");
          validate(!chunk.getRowKey().isEmpty(), "AWAITING_NEW_ROW: rowKey missing");
          validate(chunk.hasFamilyName(), "AWAITING_NEW_ROW: family missing");
          validate(chunk.hasQualifier(), "AWAITING_NEW_ROW: qualifier missing");
          if (lastCompleteRowKey != null) {
            validate(
                ByteStringComparator.INSTANCE.compare(lastCompleteRowKey, chunk.getRowKey()) < 0,
                "AWAITING_NEW_ROW: key must be strictly increasing");
          }

          rowKey = chunk.getRowKey();
          adapter.startRow(rowKey);

          // The first chunk signals both the start of a new row and the start of a new cell, so
          // force the chunk processing in the AWAITING_CELL_VALUE.
          return AWAITING_NEW_CELL.handleChunk(chunk);
        }
      };

  /**
   * A state that represents a cell boundary in a row. It will notify the adapter of new cell. Valid
   * exit states: all of them depending on the chunk.
   */
  private final State AWAITING_NEW_CELL =
      new State() {
        /**
         * Processes the next chunk.
         *
         * @param chunk The new chunk to process.
         * @return AWAITING_NEW_CELL if the chunk completed a Cell, AWAITING_CELL_VALUE if the chunk
         *     left a partial Cell.
         */
        @Override
        State handleChunk(CellChunk chunk) {
          // Handle row level logic
          if (chunk.getResetRow()) {
            return handleResetChunk(chunk);
          }

          if (!chunk.getRowKey().isEmpty()) {
            validate(
                rowKey.equals(chunk.getRowKey()), "AWAITING_NEW_CELL: row keys must not change");
          }

          // Update cell identifier buffers
          if (chunk.hasFamilyName()) {
            familyName = chunk.getFamilyName().getValue();
            validate(chunk.hasQualifier(), "AWAITING_NEW_CELL: has familyName, but no qualifier");
          }
          if (chunk.hasQualifier()) {
            qualifier = chunk.getQualifier().getValue();
          }
          timestamp = chunk.getTimestampMicros();
          labels = chunk.getLabelsList();

          // Update value expectations
          validate(chunk.getValueSize() >= 0, "AWAITING_NEW_CELL: valueSize can't be negative");

          boolean isSplit = chunk.getValueSize() > 0;
          if (isSplit) {
            validate(
                !chunk.getCommitRow(),
                "AWAITING_NEW_CELL: can't commit when valueSize indicates more data");
            validate(
                !chunk.getValue().isEmpty(),
                "AWAITING_NEW_CELL: must have data when valueSize promises more data in the next chunk");

            expectedCellSize = chunk.getValueSize();
            remainingCellBytes = expectedCellSize - chunk.getValue().size();
          } else {
            expectedCellSize = chunk.getValue().size();
            remainingCellBytes = 0;
          }

          // Start building cell
          adapter.startCell(familyName, qualifier, timestamp, labels, expectedCellSize);
          adapter.cellValue(chunk.getValue());

          // Transitions
          if (isSplit) {
            return AWAITING_CELL_VALUE;
          }
          adapter.finishCell();
          numCellsInRow++;

          if (!chunk.getCommitRow()) {
            return AWAITING_NEW_CELL;
          }

          return handleCommit();
        }
      };

  /**
   * A state that represents a cell's value continuation. Notifies the adapter to append more data
   * to the cell's value. Valid exit states: all of them depending on the chunk.
   */
  private final State AWAITING_CELL_VALUE =
      new State() {
        @Override
        State handleChunk(CellChunk chunk) {
          if (chunk.getResetRow()) {
            return handleResetChunk(chunk);
          }

          boolean isLast = chunk.getValueSize() == 0;

          validate(!chunk.hasFamilyName(), "AWAITING_CELL_VALUE: can't have a family");
          validate(!chunk.hasQualifier(), "AWAITING_CELL_VALUE: can't have a qualifier");
          validate(chunk.getTimestampMicros() == 0, "AWAITING_CELL_VALUE: can't have a timestamp");
          validate(chunk.getLabelsCount() == 0, "AWAITING_CELL_VALUE: can't have labels");
          if (isLast) {
            long missingBytes = remainingCellBytes - chunk.getValue().size();
            validate(
                missingBytes == 0,
                "AWAITING_CELL_VALUE: terminal cell is missing " + missingBytes + " bytes");
          } else {
            validate(
                expectedCellSize == chunk.getValueSize(),
                "AWAITING_CELL_VALUE: valueSizes should be identical for nonterminal chunks");
            validate(
                !chunk.getCommitRow(),
                "AWAITING_CELL_VALUE: can't commit with a nonterminal chunk");
          }
          remainingCellBytes -= chunk.getValue().size();
          adapter.cellValue(chunk.getValue());

          // Transitions
          if (!isLast) {
            return AWAITING_CELL_VALUE;
          }
          adapter.finishCell();
          numCellsInRow++;

          if (!chunk.getCommitRow()) {
            return AWAITING_NEW_CELL;
          }

          return handleCommit();
        }
      };

  /**
   * A state that represents a completed row. It prevents new rows from being read until the current
   * one has been consumed. Valid exit states: AWAITING_NEW_ROW.
   */
  private static final State AWAITING_ROW_CONSUME =
      new State() {
        @Override
        State handleChunk(CellChunk chunk) {
          throw new IllegalStateException("AWAITING_ROW_CONSUME: Skipping completed row");
        }
      };

  // Helpers ------------------------
  /**
   * Handles a special CellChunk that is marked with the reset flag. Will drop all buffers and
   * transition to the {@link #AWAITING_NEW_ROW} state.
   */
  private State handleResetChunk(CellChunk cellChunk) {
    validate(cellChunk.getRowKey().isEmpty(), "Reset chunks can't have row keys");
    validate(!cellChunk.hasFamilyName(), "Reset chunks can't have families");
    validate(!cellChunk.hasQualifier(), "Reset chunks can't have qualifiers");
    validate(cellChunk.getTimestampMicros() == 0, "Reset chunks can't have timestamps");
    validate(cellChunk.getValueSize() == 0, "Reset chunks can't have value sizes");
    validate(cellChunk.getValue().isEmpty(), "Reset chunks can't have values");

    reset();
    return currentState; // AWAITING_NEW_ROW
  }

  private State handleCommit() {
    validate(remainingCellBytes == 0, "Can't commit with remaining bytes");
    completeRow = adapter.finishRow();
    lastCompleteRowKey = rowKey;

    lastSeenKeys.add(rowKey);
    numRowsCommitted++;
    numCellsInLastRow = numCellsInRow;
    return AWAITING_ROW_CONSUME;
  }

  private void validate(boolean condition, String message) {
    if (!condition) {
      throw new InvalidInputException(
          message
              + ". numScannedNotifications: "
              + numScannedNotifications
              + ", numRowsCommitted: "
              + numRowsCommitted
              + ", numChunksProcessed: "
              + numChunksProcessed
              + ", numCellsInRow: "
              + numCellsInRow
              + ", numCellsInLastRow: "
              + numCellsInLastRow
              + ", rowKey: "
              + rowKey
              + ", last5Keys: "
              + Joiner.on(",").join(lastSeenKeys));
    }
  }

  static class InvalidInputException extends RuntimeException {
    InvalidInputException(String message) {
      super(message);
    }
  }
}

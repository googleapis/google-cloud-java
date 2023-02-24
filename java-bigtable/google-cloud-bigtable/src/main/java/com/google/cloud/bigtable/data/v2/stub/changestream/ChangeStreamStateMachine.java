/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.changestream;

import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.bigtable.v2.ReadChangeStreamResponse.DataChange.Type;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecordAdapter.ChangeStreamRecordBuilder;
import com.google.cloud.bigtable.data.v2.models.Range.TimestampRange;
import com.google.common.base.Preconditions;
import org.threeten.bp.Instant;

/**
 * A state machine to produce change stream records from a stream of {@link
 * ReadChangeStreamResponse}. A change stream record can be a Heartbeat, a CloseStream or a
 * ChangeStreamMutation.
 *
 * <p>There could be two types of chunking for a ChangeStreamMutation:
 *
 * <ul>
 *   <li>Non-SetCell chunking. For example, a ChangeStreamMutation has two mods, DeleteFamily and
 *       DeleteColumn. DeleteFamily is sent in the first {@link ReadChangeStreamResponse} and
 *       DeleteColumn is sent in the second {@link ReadChangeStreamResponse}.
 *   <li>{@link ReadChangeStreamResponse.MutationChunk} has a chunked {@link
 *       com.google.bigtable.v2.Mutation.SetCell} mutation. For example, a logical mutation has one
 *       big {@link Mutation.SetCell} mutation which is chunked into two {@link
 *       ReadChangeStreamResponse}s. The first {@link ReadChangeStreamResponse.DataChange} has the
 *       first half of the cell value, and the second {@link ReadChangeStreamResponse.DataChange}
 *       has the second half.
 * </ul>
 *
 * This state machine handles both types of chunking.
 *
 * <p>Building of the actual change stream record object is delegated to a {@link
 * ChangeStreamRecordBuilder}. This class is not thread safe.
 *
 * <p>The inputs are:
 *
 * <ul>
 *   <li>{@link ReadChangeStreamResponse.Heartbeat}s.
 *   <li>{@link ReadChangeStreamResponse.CloseStream}s.
 *   <li>{@link ReadChangeStreamResponse.DataChange}s, that must be merged to a
 *       ChangeStreamMutation.
 *   <li>ChangeStreamRecord consumption events that reset the state machine for the next change
 *       stream record.
 * </ul>
 *
 * <p>The outputs are:
 *
 * <ul>
 *   <li>Heartbeat records.
 *   <li>CloseStream records.
 *   <li>ChangeStreamMutation records.
 * </ul>
 *
 * <p>Expected Usage:
 *
 * <pre>{@code
 * ChangeStreamStateMachine changeStreamStateMachine = new ChangeStreamStateMachine<>(myChangeStreamRecordAdapter);
 * while(responseIterator.hasNext()) {
 *   ReadChangeStreamResponse response = responseIterator.next();
 *   switch (response.getStreamRecordCase()) {
 *     case HEARTBEAT:
 *       changeStreamStateMachine.handleHeartbeat(response.getHeartbeat());
 *       break;
 *     case CLOSE_STREAM:
 *       changeStreamStateMachine.handleCloseStream(response.getCloseStream());
 *       break;
 *     case DATA_CHANGE:
 *       changeStreamStateMachine.handleDataChange(response.getDataChange());
 *       break;
 *     case STREAMRECORD_NOT_SET:
 *       throw new IllegalStateException("Illegal stream record.");
 *   }
 *   if (changeStreamStateMachine.hasCompleteChangeStreamRecord()) {
 *       MyChangeStreamRecord = changeStreamStateMachine.consumeChangeStreamRecord();
 *       // do something with the change stream record.
 *   }
 * }
 * }</pre>
 *
 * <p>Package-private for internal use.
 *
 * @param <ChangeStreamRecordT> The type of row the adapter will build
 */
final class ChangeStreamStateMachine<ChangeStreamRecordT> {
  private final ChangeStreamRecordBuilder<ChangeStreamRecordT> builder;
  private State currentState;
  // debug stats
  private int numHeartbeats = 0;
  private int numCloseStreams = 0;
  private int numDataChanges = 0;
  private int numNonCellMods = 0;
  private int numCellChunks = 0; // 1 for non-chunked cell.
  /**
   * Expected total size of a chunked SetCell value, given by the {@link
   * ReadChangeStreamResponse.MutationChunk.ChunkInfo}. This value should be the same for all chunks
   * of a SetCell.
   */
  private int expectedTotalSizeOfChunkedSetCell = 0;

  private int actualTotalSizeOfChunkedSetCell = 0;
  private ChangeStreamRecordT completeChangeStreamRecord;

  /**
   * Initialize a new state machine that's ready for a new change stream record.
   *
   * @param builder The builder that will build the final change stream record.
   */
  ChangeStreamStateMachine(ChangeStreamRecordBuilder<ChangeStreamRecordT> builder) {
    this.builder = builder;
    reset();
  }

  /**
   * Handle heartbeat events from the server.
   *
   * <dl>
   *   <dt>Valid states:
   *   <dd>{@link ChangeStreamStateMachine#AWAITING_NEW_STREAM_RECORD}
   *   <dt>Resulting states:
   *   <dd>{@link ChangeStreamStateMachine#AWAITING_STREAM_RECORD_CONSUME}
   * </dl>
   */
  void handleHeartbeat(ReadChangeStreamResponse.Heartbeat heartbeat) {
    try {
      numHeartbeats++;
      currentState = currentState.handleHeartbeat(heartbeat);
    } catch (RuntimeException e) {
      currentState = ERROR;
      throw e;
    }
  }

  /**
   * Handle CloseStream events from the server.
   *
   * <dl>
   *   <dt>Valid states:
   *   <dd>{@link ChangeStreamStateMachine#AWAITING_NEW_STREAM_RECORD}
   *   <dt>Resulting states:
   *   <dd>{@link ChangeStreamStateMachine#AWAITING_STREAM_RECORD_CONSUME}
   * </dl>
   */
  void handleCloseStream(ReadChangeStreamResponse.CloseStream closeStream) {
    try {
      numCloseStreams++;
      currentState = currentState.handleCloseStream(closeStream);
    } catch (RuntimeException e) {
      currentState = ERROR;
      throw e;
    }
  }

  /**
   * Feeds a new dataChange into the state machine. If the dataChange is invalid, the state machine
   * will throw an exception and should not be used for further input.
   *
   * <dl>
   *   <dt>Valid states:
   *   <dd>{@link ChangeStreamStateMachine#AWAITING_NEW_STREAM_RECORD}
   *   <dd>{@link ChangeStreamStateMachine#AWAITING_NEW_DATA_CHANGE}
   *   <dt>Resulting states:
   *   <dd>{@link ChangeStreamStateMachine#AWAITING_NEW_DATA_CHANGE}
   *   <dd>{@link ChangeStreamStateMachine#AWAITING_STREAM_RECORD_CONSUME}
   * </dl>
   *
   * @param dataChange The new chunk to process.
   * @throws ChangeStreamStateMachine.InvalidInputException When the chunk is not applicable to the
   *     current state.
   * @throws IllegalStateException When the internal state is inconsistent
   */
  void handleDataChange(ReadChangeStreamResponse.DataChange dataChange) {
    try {
      numDataChanges++;
      currentState = currentState.handleDataChange(dataChange);
    } catch (RuntimeException e) {
      currentState = ERROR;
      throw e;
    }
  }

  /**
   * Returns the completed change stream record and transitions to {@link
   * ChangeStreamStateMachine#AWAITING_NEW_STREAM_RECORD}.
   *
   * @return The completed change stream record.
   * @throws IllegalStateException If the last dataChange did not complete a change stream record.
   */
  ChangeStreamRecordT consumeChangeStreamRecord() {
    Preconditions.checkState(
        completeChangeStreamRecord != null, "No change stream record to consume.");
    Preconditions.checkState(
        currentState == AWAITING_STREAM_RECORD_CONSUME,
        "Change stream record is not ready to consume: " + currentState);
    ChangeStreamRecordT changeStreamRecord = completeChangeStreamRecord;
    reset();
    return changeStreamRecord;
  }

  /** Checks if there is a complete change stream record to be consumed. */
  boolean hasCompleteChangeStreamRecord() {
    return completeChangeStreamRecord != null && currentState == AWAITING_STREAM_RECORD_CONSUME;
  }
  /**
   * Checks if the state machine is in the middle of processing a change stream record.
   *
   * @return True If there is a change stream record in progress.
   */
  boolean isChangeStreamRecordInProgress() {
    return currentState != AWAITING_NEW_STREAM_RECORD;
  }

  private void reset() {
    currentState = AWAITING_NEW_STREAM_RECORD;
    numHeartbeats = 0;
    numCloseStreams = 0;
    numDataChanges = 0;
    numNonCellMods = 0;
    numCellChunks = 0;
    expectedTotalSizeOfChunkedSetCell = 0;
    actualTotalSizeOfChunkedSetCell = 0;
    completeChangeStreamRecord = null;

    builder.reset();
  }

  /**
   * Base class for all the state machine's internal states.
   *
   * <p>Each state can consume 3 events: Heartbeat, CloseStream and a Mod. By default, the default
   * implementation will just throw an IllegalStateException unless the subclass adds explicit
   * handling for these events.
   */
  abstract static class State {
    /**
     * Accepts a Heartbeat by the server. And completes the current change stream record.
     *
     * @throws IllegalStateException If the subclass can't handle heartbeat events.
     */
    ChangeStreamStateMachine.State handleHeartbeat(ReadChangeStreamResponse.Heartbeat heartbeat) {
      throw new IllegalStateException();
    }

    /**
     * Accepts a CloseStream by the server. And completes the current change stream record.
     *
     * @throws IllegalStateException If the subclass can't handle CloseStream events.
     */
    ChangeStreamStateMachine.State handleCloseStream(
        ReadChangeStreamResponse.CloseStream closeStream) {
      throw new IllegalStateException();
    }

    /**
     * Accepts a new DataChange and transitions to the next state. A DataChange can have multiple
     * mods, where each mod could be a DeleteFamily, a DeleteColumn, or a SetCell.
     *
     * @param dataChange The DataChange that holds the new mod to process.
     * @return The next state.
     * @throws IllegalStateException If the subclass can't handle the DataChange.
     * @throws ChangeStreamStateMachine.InvalidInputException If the subclass determines that this
     *     dataChange is invalid.
     */
    ChangeStreamStateMachine.State handleDataChange(
        ReadChangeStreamResponse.DataChange dataChange) {
      throw new IllegalStateException();
    }
  }

  /**
   * The default state when the state machine is awaiting a ReadChangeStream response to start a new
   * change stream record. It will notify the builder of the new change stream record and transits
   * to one of the following states:
   *
   * <dl>
   *   <dd>{@link ChangeStreamStateMachine#AWAITING_STREAM_RECORD_CONSUME}, in case of a Heartbeat
   *       or a CloseStream.
   *   <dd>Same as {@link ChangeStreamStateMachine#AWAITING_NEW_DATA_CHANGE}, depending on the
   *       DataChange.
   * </dl>
   */
  private final State AWAITING_NEW_STREAM_RECORD =
      new State() {
        @Override
        State handleHeartbeat(ReadChangeStreamResponse.Heartbeat heartbeat) {
          validate(
              completeChangeStreamRecord == null,
              "AWAITING_NEW_STREAM_RECORD: Existing ChangeStreamRecord not consumed yet.");
          completeChangeStreamRecord = builder.onHeartbeat(heartbeat);
          return AWAITING_STREAM_RECORD_CONSUME;
        }

        @Override
        State handleCloseStream(ReadChangeStreamResponse.CloseStream closeStream) {
          validate(
              completeChangeStreamRecord == null,
              "AWAITING_NEW_STREAM_RECORD: Existing ChangeStreamRecord not consumed yet.");
          completeChangeStreamRecord = builder.onCloseStream(closeStream);
          return AWAITING_STREAM_RECORD_CONSUME;
        }

        @Override
        State handleDataChange(ReadChangeStreamResponse.DataChange dataChange) {
          validate(
              completeChangeStreamRecord == null,
              "AWAITING_NEW_STREAM_RECORD: Existing ChangeStreamRecord not consumed yet.");
          validate(
              !dataChange.getRowKey().isEmpty(),
              "AWAITING_NEW_STREAM_RECORD: First data change missing rowKey.");
          validate(
              dataChange.hasCommitTimestamp(),
              "AWAITING_NEW_STREAM_RECORD: First data change missing commit timestamp.");
          validate(
              dataChange.getChunksCount() > 0,
              "AWAITING_NEW_STREAM_RECORD: First data change missing mods.");
          if (dataChange.getType() == Type.GARBAGE_COLLECTION) {
            validate(
                dataChange.getSourceClusterId().isEmpty(),
                "AWAITING_NEW_STREAM_RECORD: GC mutation shouldn't have source cluster id.");
            builder.startGcMutation(
                dataChange.getRowKey(),
                Instant.ofEpochSecond(
                    dataChange.getCommitTimestamp().getSeconds(),
                    dataChange.getCommitTimestamp().getNanos()),
                dataChange.getTiebreaker());
          } else if (dataChange.getType() == Type.USER) {
            validate(
                !dataChange.getSourceClusterId().isEmpty(),
                "AWAITING_NEW_STREAM_RECORD: User initiated data change missing source cluster id.");
            builder.startUserMutation(
                dataChange.getRowKey(),
                dataChange.getSourceClusterId(),
                Instant.ofEpochSecond(
                    dataChange.getCommitTimestamp().getSeconds(),
                    dataChange.getCommitTimestamp().getNanos()),
                dataChange.getTiebreaker());
          } else {
            validate(false, "AWAITING_NEW_STREAM_RECORD: Unexpected type: " + dataChange.getType());
          }
          return AWAITING_NEW_DATA_CHANGE.handleDataChange(dataChange);
        }
      };

  /**
   * A state to handle the next DataChange.
   *
   * <dl>
   *   <dt>Valid exit states:
   *   <dd>{@link ChangeStreamStateMachine#AWAITING_NEW_DATA_CHANGE}. All mods from the current
   *       DataChange are added, and we have more DataChange to expect.
   *   <dd>{@link ChangeStreamStateMachine#AWAITING_STREAM_RECORD_CONSUME}. Current DataChange is
   *       the last DataChange of the current logical mutation.
   * </dl>
   */
  private final State AWAITING_NEW_DATA_CHANGE =
      new State() {
        @Override
        State handleHeartbeat(ReadChangeStreamResponse.Heartbeat heartbeat) {
          throw new IllegalStateException(
              "AWAITING_NEW_DATA_CHANGE: Can't handle a Heartbeat in the middle of building a ChangeStreamMutation.");
        }

        @Override
        State handleCloseStream(ReadChangeStreamResponse.CloseStream closeStream) {
          throw new IllegalStateException(
              "AWAITING_NEW_DATA_CHANGE: Can't handle a CloseStream in the middle of building a ChangeStreamMutation.");
        }

        @Override
        State handleDataChange(ReadChangeStreamResponse.DataChange dataChange) {
          // Iterate over all mods.
          for (int index = 0; index < dataChange.getChunksCount(); ++index) {
            ReadChangeStreamResponse.MutationChunk chunk = dataChange.getChunks(index);
            Mutation mod = chunk.getMutation();
            // Case 1: SetCell
            if (mod.hasSetCell()) {
              Mutation.SetCell setCell = chunk.getMutation().getSetCell();
              // Case 1_1: Current SetCell is NOT chunked, in which case there is no ChunkInfo.
              if (!chunk.hasChunkInfo()) {
                builder.startCell(
                    setCell.getFamilyName(),
                    setCell.getColumnQualifier(),
                    setCell.getTimestampMicros());
                numCellChunks++;
                builder.cellValue(setCell.getValue());
                builder.finishCell();
                continue;
              } else {
                // Case 1_2: This chunk is from a chunked SetCell, which must be one of the
                // following:
                // Case 1_2_1: The first chunk of a chunked SetCell. For example: SetCell_chunk_1
                // in
                // [ReadChangeStreamResponse1: {..., SetCell_chunk_1}, ReadChangeStreamResponse2:
                // {SetCell_chunk_2, ...}].
                // Case 1_2_2: A non-first chunk from a chunked SetCell. For example:
                // SetCell_chunk_2 in
                // [ReadChangeStreamResponse1: {..., SetCell_chunk_1}, ReadChangeStreamResponse2:
                // {SetCell_chunk_2, ...}]. Note that in this case this chunk must be the first
                // chunk for the current DataChange, because a SetCell can NOT be chunked within
                // the same DataChange, i.e. there is no such DataChange as
                // [ReadChangeStreamResponse: {SetCell_chunk_1, SetCell_chunk_2}].
                if (chunk.getChunkInfo().getChunkedValueOffset() == 0) {
                  // Case 1_2_1
                  validate(
                      chunk.getChunkInfo().getChunkedValueSize() > 0,
                      "AWAITING_NEW_DATA_CHANGE: First chunk of a chunked cell must have a positive chunked value size.");
                  expectedTotalSizeOfChunkedSetCell = chunk.getChunkInfo().getChunkedValueSize();
                  actualTotalSizeOfChunkedSetCell = 0;
                  builder.startCell(
                      setCell.getFamilyName(),
                      setCell.getColumnQualifier(),
                      setCell.getTimestampMicros());
                } else {
                  // Case 1_2_2
                  validate(
                      index == 0,
                      "AWAITING_NEW_DATA_CHANGE: Non-first chunked SetCell must be the first mod of a DataChange.");
                }
                // Concatenate the cell value of this mod into the builder.
                validate(
                    chunk.getChunkInfo().getChunkedValueSize() == expectedTotalSizeOfChunkedSetCell,
                    "AWAITING_NEW_DATA_CHANGE: Chunked cell value size must be the same for all chunks.");
                numCellChunks++;
                builder.cellValue(setCell.getValue());
                actualTotalSizeOfChunkedSetCell += setCell.getValue().size();
                // If it's the last chunk of the chunked SetCell, finish the cell.
                if (chunk.getChunkInfo().getLastChunk()) {
                  builder.finishCell();
                  validate(
                      actualTotalSizeOfChunkedSetCell == expectedTotalSizeOfChunkedSetCell,
                      "Chunked value size in ChunkInfo doesn't match the actual total size. "
                          + "Expected total size: "
                          + expectedTotalSizeOfChunkedSetCell
                          + "; actual total size: "
                          + actualTotalSizeOfChunkedSetCell);
                  continue;
                } else {
                  // If this is not the last chunk of a chunked SetCell, then this must be the last
                  // mod of the current response, and we're expecting the rest of the chunked cells
                  // in the following ReadChangeStream response.
                  validate(
                      index == dataChange.getChunksCount() - 1,
                      "AWAITING_NEW_DATA_CHANGE: Current mod is a chunked SetCell "
                          + "but not the last chunk, but it's not the last mod of the current response.");
                  return AWAITING_NEW_DATA_CHANGE;
                }
              }
            }
            // Case 2: DeleteFamily
            if (mod.hasDeleteFromFamily()) {
              numNonCellMods++;
              builder.deleteFamily(mod.getDeleteFromFamily().getFamilyName());
              continue;
            }
            // Case 3: DeleteCell
            if (mod.hasDeleteFromColumn()) {
              numNonCellMods++;
              builder.deleteCells(
                  mod.getDeleteFromColumn().getFamilyName(),
                  mod.getDeleteFromColumn().getColumnQualifier(),
                  TimestampRange.create(
                      mod.getDeleteFromColumn().getTimeRange().getStartTimestampMicros(),
                      mod.getDeleteFromColumn().getTimeRange().getEndTimestampMicros()));
              continue;
            }
            throw new IllegalStateException("AWAITING_NEW_DATA_CHANGE: Unexpected mod type");
          }

          // After adding all mods from this DataChange to the state machine, finish the current
          // logical mutation, or wait for the next DataChange response.
          return checkAndFinishMutationIfNeeded(dataChange);
        }
      };

  /**
   * A state that represents a completed change stream record. It prevents new change stream records
   * from being read until the current one has been consumed. The caller is supposed to consume the
   * change stream record by calling {@link ChangeStreamStateMachine#consumeChangeStreamRecord()}
   * which will reset the state to {@link ChangeStreamStateMachine#AWAITING_NEW_STREAM_RECORD}.
   */
  private final State AWAITING_STREAM_RECORD_CONSUME =
      new State() {
        @Override
        State handleHeartbeat(ReadChangeStreamResponse.Heartbeat heartbeat) {
          throw new IllegalStateException(
              "AWAITING_STREAM_RECORD_CONSUME: Skipping completed change stream record.");
        }

        @Override
        State handleCloseStream(ReadChangeStreamResponse.CloseStream closeStream) {
          throw new IllegalStateException(
              "AWAITING_STREAM_RECORD_CONSUME: Skipping completed change stream record.");
        }

        @Override
        State handleDataChange(ReadChangeStreamResponse.DataChange dataChange) {
          throw new IllegalStateException(
              "AWAITING_STREAM_RECORD_CONSUME: Skipping completed change stream record.");
        }
      };

  /**
   * A state that represents a broken state of the state machine. Any method called on this state
   * will get an exception.
   */
  private final State ERROR =
      new State() {
        @Override
        State handleHeartbeat(ReadChangeStreamResponse.Heartbeat heartbeat) {
          throw new IllegalStateException("ERROR: Failed to handle Heartbeat.");
        }

        @Override
        State handleCloseStream(ReadChangeStreamResponse.CloseStream closeStream) {
          throw new IllegalStateException("ERROR: Failed to handle CloseStream.");
        }

        @Override
        State handleDataChange(ReadChangeStreamResponse.DataChange dataChange) {
          throw new IllegalStateException("ERROR: Failed to handle DataChange.");
        }
      };

  /**
   * Check if we should continue handling DataChanges in the following responses or wrap up. There
   * are 2 cases:
   *
   * <ul>
   *   <li>1) dataChange.done == true -> current change stream mutation is complete. Wrap it up and
   *       return {@link ChangeStreamStateMachine#AWAITING_STREAM_RECORD_CONSUME}.
   *   <li>2) dataChange.done != true -> current change stream mutation isn't complete. Return
   *       {@link ChangeStreamStateMachine#AWAITING_NEW_DATA_CHANGE} to wait for more mods in the
   *       next ReadChangeStreamResponse.
   * </ul>
   */
  private State checkAndFinishMutationIfNeeded(ReadChangeStreamResponse.DataChange dataChange) {
    // This function is called when all the mods in this DataChange have been handled. We should
    // finish up the logical mutation or wait for more mods in the next ReadChangeStreamResponse,
    // depending on whether the current response is the last response for the logical mutation.
    if (dataChange.getDone()) {
      // Case 1: Current change stream mutation is complete.
      validate(!dataChange.getToken().isEmpty(), "Last data change missing token");
      validate(dataChange.hasEstimatedLowWatermark(), "Last data change missing lowWatermark");
      completeChangeStreamRecord =
          builder.finishChangeStreamMutation(
              dataChange.getToken(),
              Instant.ofEpochSecond(
                  dataChange.getEstimatedLowWatermark().getSeconds(),
                  dataChange.getEstimatedLowWatermark().getNanos()));
      return AWAITING_STREAM_RECORD_CONSUME;
    }
    // Case 2: The current DataChange itself is chunked, so wait for the next
    // ReadChangeStreamResponse. Note that we should wait for the new data change instead
    // of for the new change stream record since the current record hasn't finished yet.
    return AWAITING_NEW_DATA_CHANGE;
  }

  private void validate(boolean condition, String message) {
    if (!condition) {
      throw new ChangeStreamStateMachine.InvalidInputException(
          message
              + ". numHeartbeats: "
              + numHeartbeats
              + ", numCloseStreams: "
              + numCloseStreams
              + ", numDataChanges: "
              + numDataChanges
              + ", numNonCellMods: "
              + numNonCellMods
              + ", numCellChunks: "
              + numCellChunks
              + ", expectedTotalSizeOfChunkedSetCell: "
              + expectedTotalSizeOfChunkedSetCell
              + ", actualTotalSizeOfChunkedSetCell: "
              + actualTotalSizeOfChunkedSetCell);
    }
  }

  static class InvalidInputException extends RuntimeException {
    InvalidInputException(String message) {
      super(message);
    }
  }
}

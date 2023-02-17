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
package com.google.cloud.bigtable.data.v2.models;

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.cloud.bigtable.data.v2.models.Range.TimestampRange;
import com.google.protobuf.ByteString;
import javax.annotation.Nonnull;
import org.threeten.bp.Instant;

/**
 * An extension point that allows end users to plug in a custom implementation of logical change
 * stream records. This is useful in cases where the user would like to apply advanced client side
 * filtering(for example, only keep DeleteFamily in the mutations). This adapter acts like a factory
 * for a SAX style change stream record builder.
 */
@InternalApi("Intended for use by the BigtableIO in apache/beam only.")
public interface ChangeStreamRecordAdapter<ChangeStreamRecordT> {
  /** Creates a new instance of a {@link ChangeStreamRecordBuilder}. */
  ChangeStreamRecordBuilder<ChangeStreamRecordT> createChangeStreamRecordBuilder();

  /** Checks if the given change stream record is a Heartbeat. */
  @InternalApi("Intended for use by the BigtableIO in apache/beam only.")
  boolean isHeartbeat(ChangeStreamRecordT record);

  /**
   * Get the token from the given Heartbeat record. If the given record is not a Heartbeat, it will
   * throw an Exception.
   */
  @InternalApi("Intended for use by the BigtableIO in apache/beam only.")
  String getTokenFromHeartbeat(ChangeStreamRecordT heartbeatRecord);

  /** Checks if the given change stream record is a ChangeStreamMutation. */
  @InternalApi("Intended for use by the BigtableIO in apache/beam only.")
  boolean isChangeStreamMutation(ChangeStreamRecordT record);

  /**
   * Get the token from the given ChangeStreamMutation record. If the given record is not a
   * ChangeStreamMutation, it will throw an Exception.
   */
  @InternalApi("Intended for use by the BigtableIO in apache/beam only.")
  String getTokenFromChangeStreamMutation(ChangeStreamRecordT record);

  /**
   * A SAX style change stream record factory. It is responsible for creating one of the three types
   * of change stream record: heartbeat, close stream, and a change stream mutation.
   *
   * <p>State management is handled external to the implementation of this class:
   *
   * <ol>
   *   Case 1: Heartbeat
   *   <li>Exactly 1 {@code onHeartbeat}.
   * </ol>
   *
   * <ol>
   *   Case 2: CloseStream
   *   <li>Exactly 1 {@code onCloseStream}.
   * </ol>
   *
   * <ol>
   *   Case 3: ChangeStreamMutation. A change stream mutation consists of one or more mods, where
   *   the SetCells might be chunked. There are 3 different types of mods that a ReadChangeStream
   *   response can have:
   *   <li>DeleteFamily -> Exactly 1 {@code deleteFamily}
   *   <li>DeleteCell -> Exactly 1 {@code deleteCell}
   *   <li>SetCell -> Exactly 1 {@code startCell}, At least 1 {@code CellValue}, Exactly 1 {@code
   *       finishCell}.
   * </ol>
   *
   * <p>The whole flow of constructing a ChangeStreamMutation is:
   *
   * <ol>
   *   <li>Exactly 1 {@code startUserMutation} or {@code startGcMutation}.
   *   <li>At least 1 DeleteFamily/DeleteCell/SetCell mods.
   *   <li>Exactly 1 {@code finishChangeStreamMutation}.
   * </ol>
   *
   * <p>Note: For a non-chunked SetCell, only 1 {@code CellValue} will be called. For a chunked
   * SetCell, more than 1 {@code CellValue}s will be called.
   *
   * <p>Note: DeleteRow's won't appear in data changes since they'll be converted to multiple
   * DeleteFamily's.
   */
  interface ChangeStreamRecordBuilder<ChangeStreamRecordT> {
    /**
     * Called to create a heartbeat. This will be called at most once. If called, the current change
     * stream record must not include any data changes or close stream messages.
     */
    ChangeStreamRecordT onHeartbeat(ReadChangeStreamResponse.Heartbeat heartbeat);

    /**
     * Called to create a close stream message. This will be called at most once. If called, the
     * current change stream record must not include any data changes or heartbeats.
     */
    ChangeStreamRecordT onCloseStream(ReadChangeStreamResponse.CloseStream closeStream);

    /**
     * Called to start a new user initiated ChangeStreamMutation. This will be called at most once.
     * If called, the current change stream record must not include any close stream message or
     * heartbeat.
     */
    void startUserMutation(
        @Nonnull ByteString rowKey,
        @Nonnull String sourceClusterId,
        Instant commitTimestamp,
        int tieBreaker);

    /**
     * Called to start a new Garbage Collection ChangeStreamMutation. This will be called at most
     * once. If called, the current change stream record must not include any close stream message
     * or heartbeat.
     */
    void startGcMutation(@Nonnull ByteString rowKey, Instant commitTimestamp, int tieBreaker);

    /** Called to add a DeleteFamily mod. */
    void deleteFamily(@Nonnull String familyName);

    /** Called to add a DeleteCell mod. */
    void deleteCells(
        @Nonnull String familyName,
        @Nonnull ByteString qualifier,
        @Nonnull TimestampRange timestampRange);

    /**
     * Called to start a SetCell.
     *
     * <ol>
     *   In case of a non-chunked cell, the following order is guaranteed:
     *   <li>Exactly 1 {@code startCell}.
     *   <li>Exactly 1 {@code cellValue}.
     *   <li>Exactly 1 {@code finishCell}.
     * </ol>
     *
     * <ol>
     *   In case of a chunked cell, the following order is guaranteed:
     *   <li>Exactly 1 {@code startCell}.
     *   <li>At least 2 {@code cellValue}.
     *   <li>Exactly 1 {@code finishCell}.
     * </ol>
     */
    void startCell(String family, ByteString qualifier, long timestampMicros);

    /**
     * Called once per non-chunked cell, or at least twice per chunked cell to concatenate the cell
     * value.
     */
    void cellValue(ByteString value);

    /** Called once per cell to signal the end of the value (unless reset). */
    void finishCell();

    /** Called once per stream record to signal that all mods have been processed (unless reset). */
    ChangeStreamRecordT finishChangeStreamMutation(
        @Nonnull String token, Instant estimatedLowWatermark);

    /** Called when the current in progress change stream record should be dropped */
    void reset();
  }
}

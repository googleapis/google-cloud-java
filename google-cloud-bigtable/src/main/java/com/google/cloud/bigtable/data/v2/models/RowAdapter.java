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
package com.google.cloud.bigtable.data.v2.models;

import com.google.protobuf.ByteString;
import java.util.List;

/**
 * An extension point that allows end users to plug in a custom implementation of logical rows. This
 * useful in cases where the user would like to apply advanced client side filtering of cells. This
 * adapter acts like a factory for a SAX style row builder.
 */
public interface RowAdapter<RowT> {
  /** Creates a new instance of a {@link RowBuilder}. */
  RowBuilder<RowT> createRowBuilder();

  /**
   * Checks if the given row is a special marker row. Please the documentation for {@link
   * RowBuilder} for more information
   */
  boolean isScanMarkerRow(RowT row);

  ByteString getKey(RowT row);

  /**
   * A SAX style row factory. It is responsible for creating two types of rows: standard data rows
   * and special marker rows. Marker rows are emitted when skipping lots of rows due to filters. The
   * server notifies the client of the last row it skipped to help client resume in case of error.
   *
   * <p>State management is handled external to the implementation of this class and guarantees the
   * following order:
   *
   * <ol>
   *   <li>Exactly 1 {@code startRow} for each row.
   *   <li>Exactly 1 {@code startCell} for each cell.
   *   <li>At least 1 {@code cellValue} for each cell.
   *   <li>Exactly 1 {@code finishCell} for each cell.
   *   <li>Exactly 1 {@code finishRow} for each row.
   * </ol>
   *
   * {@code createScanMarkerRow} can be called one or more times between {@code finishRow} and
   * {@code startRow}. {@code reset} can be called at any point and can be invoked multiple times in
   * a row.
   */
  interface RowBuilder<RowT> {
    /** Called to start a new row. This will be called once per row. */
    void startRow(ByteString key);

    /** Called to start a new cell in a row. */
    void startCell(
        String family, ByteString qualifier, long timestamp, List<String> labels, long size);

    /** Called multiple times per cell to concatenate the cell value. */
    void cellValue(ByteString value);

    /** Called once per cell to signal the end of the value (unless reset). */
    void finishCell();

    /** Called once per row to signal that all cells have been processed (unless reset). */
    RowT finishRow();

    /** Called when the current in progress row should be dropped */
    void reset();

    /** Creates a special row to mark server progress before any data is received */
    RowT createScanMarkerRow(ByteString key);
  }
}

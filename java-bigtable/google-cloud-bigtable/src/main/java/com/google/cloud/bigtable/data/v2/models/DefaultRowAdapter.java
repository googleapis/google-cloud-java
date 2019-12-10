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

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.Cell;
import com.google.bigtable.v2.Column;
import com.google.bigtable.v2.Family;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Default implementation of a {@link RowAdapter} that uses {@link Row}s to represent logical rows.
 */
public class DefaultRowAdapter implements RowAdapter<Row> {
  /** {@inheritDoc} */
  @Override
  public boolean isScanMarkerRow(Row row) {
    return row.getCells().isEmpty();
  }

  /** {@inheritDoc} */
  @Override
  public RowBuilder<Row> createRowBuilder() {
    return new DefaultRowBuilder();
  }

  /** {@inheritDoc} */
  @Override
  public ByteString getKey(Row row) {
    return row.getKey();
  }

  /**
   * Helper to convert a proto Row to a model Row.
   *
   * <p>For internal use only.
   */
  @InternalApi
  public Row createRowFromProto(com.google.bigtable.v2.Row row) {
    RowBuilder<Row> builder = createRowBuilder();
    builder.startRow(row.getKey());

    for (Family family : row.getFamiliesList()) {
      for (Column column : family.getColumnsList()) {
        for (Cell cell : column.getCellsList()) {
          builder.startCell(
              family.getName(),
              column.getQualifier(),
              cell.getTimestampMicros(),
              cell.getLabelsList(),
              cell.getValue().size());
          builder.cellValue(cell.getValue());
          builder.finishCell();
        }
      }
    }

    return builder.finishRow();
  }

  /** {@inheritDoc} */
  public class DefaultRowBuilder implements RowBuilder<Row> {
    private ByteString currentKey;
    private TreeMap<String, ImmutableList.Builder<RowCell>> cellsByFamily;
    private ImmutableList.Builder<RowCell> currentFamilyCells;
    private String previousFamily;
    private int totalCellCount;

    private String family;
    private ByteString qualifier;
    private List<String> labels;
    private long timestamp;
    private ByteString value;

    public DefaultRowBuilder() {
      reset();
    }

    /** {@inheritDoc} */
    @Override
    public Row createScanMarkerRow(ByteString key) {
      return Row.create(key, ImmutableList.<RowCell>of());
    }

    /** {@inheritDoc} */
    @Override
    public void startRow(ByteString key) {
      currentKey = key;
    }

    /** {@inheritDoc} */
    @Override
    public void startCell(
        String family, ByteString qualifier, long timestamp, List<String> labels, long size) {
      this.family = family;
      this.qualifier = qualifier;
      this.timestamp = timestamp;
      this.labels = labels;
      this.value = ByteString.EMPTY;
    }

    /** {@inheritDoc} */
    @Override
    public void cellValue(ByteString value) {
      this.value = this.value.concat(value);
    }

    /** {@inheritDoc} */
    @Override
    public void finishCell() {
      if (!Objects.equals(family, previousFamily)) {
        previousFamily = family;
        currentFamilyCells = ImmutableList.builder();
        cellsByFamily.put(family, currentFamilyCells);
      }

      RowCell rowCell = RowCell.create(family, qualifier, timestamp, labels, value);
      currentFamilyCells.add(rowCell);
      totalCellCount++;
    }

    /** {@inheritDoc} */
    @Override
    public Row finishRow() {
      final ImmutableList<RowCell> sortedCells;

      // Optimization: If there are no cells, then just return the static empty list.
      if (cellsByFamily.size() == 0) {
        sortedCells = ImmutableList.of();
      } else if (cellsByFamily.size() == 1) {
        // Optimization: If there is a single family, avoid copies and return that one list.
        sortedCells = currentFamilyCells.build();
      } else {
        // Normal path: concatenate the cells order by family.
        // TODO: use builderWithExpectedSize(totalCellCount) when it stabilizes
        ImmutableList.Builder<RowCell> sortedCellsBuilder = ImmutableList.builder();

        for (ImmutableList.Builder<RowCell> familyCells : cellsByFamily.values()) {
          sortedCellsBuilder.addAll(familyCells.build());
        }
        sortedCells = sortedCellsBuilder.build();
      }

      return Row.create(currentKey, sortedCells);
    }

    /** {@inheritDoc} */
    @Override
    public void reset() {
      currentKey = null;

      cellsByFamily = new TreeMap<>();
      currentFamilyCells = null;
      previousFamily = null;
      totalCellCount = 0;

      family = null;
      qualifier = null;
      labels = null;
      timestamp = 0;
      value = null;
    }
  }
}

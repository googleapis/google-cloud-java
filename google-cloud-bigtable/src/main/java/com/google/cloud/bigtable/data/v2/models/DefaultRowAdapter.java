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

import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.util.List;

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

  /** {@inheritDoc} */
  public class DefaultRowBuilder implements RowBuilder<Row> {
    private ByteString currentKey;
    private ImmutableList.Builder<RowCell> cells;
    private String family;
    private ByteString qualifier;
    private List<String> labels;
    private long timestamp;
    private ByteString value;

    /** {@inheritDoc} */
    @Override
    public Row createScanMarkerRow(ByteString key) {
      return Row.create(key, ImmutableList.<RowCell>of());
    }

    /** {@inheritDoc} */
    @Override
    public void startRow(ByteString key) {
      currentKey = key;
      cells = ImmutableList.builder();
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
      cells.add(RowCell.create(family, qualifier, timestamp, labels, value));
    }

    /** {@inheritDoc} */
    @Override
    public Row finishRow() {
      return Row.create(currentKey, cells.build());
    }

    /** {@inheritDoc} */
    @Override
    public void reset() {
      currentKey = null;
      cells = null;
      family = null;
      qualifier = null;
      labels = null;
      timestamp = 0;
      value = null;
    }
  }
}

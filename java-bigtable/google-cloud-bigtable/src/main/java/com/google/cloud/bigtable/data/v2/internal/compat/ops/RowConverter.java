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
import com.google.cloud.bigtable.data.v2.models.RowAdapter.RowBuilder;

class RowConverter {

  private RowConverter() {}

  static <T> T buildRow(RowBuilder<T> builder, Row protoRow) {
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

/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.InternalApi;
import com.google.cloud.bigtable.data.v2.models.sql.ColumnMetadata;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is an internal helper to share the index to column name lookup and the handling of ambiguous
 * columns described below for Rows and Structs
 */
@InternalApi
public abstract class ColumnToIndexMapper {
  // It is valid for a select query to return columns with the same name. This marker is used
  // internally in the client to designate that getting a value by column name is invalid and will
  // be converted into an exception.
  private static final int AMBIGUOUS_FIELD_MARKER = -1;

  private Map<String, Integer> columnNameMapping;

  protected ColumnToIndexMapper(List<? extends ColumnMetadata> columns) {
    columnNameMapping = buildColumnNameMapping(columns);
  }

  public int getColumnIndex(String columnName) {
    Integer index = columnNameMapping.get(columnName);
    if (index == null) {
      throw new IllegalArgumentException("Column name not found: " + columnName);
    }
    int unboxedIndex = index;
    if (unboxedIndex == AMBIGUOUS_FIELD_MARKER) {
      throw new IllegalArgumentException(
          "Ambiguous column name: " + columnName + ". Same name is used for multiple columns.");
    }
    return unboxedIndex;
  }

  private Map<String, Integer> buildColumnNameMapping(List<? extends ColumnMetadata> columns) {
    HashMap<String, Integer> mapping = new HashMap<>(columns.size());
    for (int i = 0; i < columns.size(); i++) {
      String columnName = columns.get(i).name();
      if (mapping.containsKey(columnName)) {
        mapping.put(columnName, AMBIGUOUS_FIELD_MARKER);
      } else {
        mapping.put(columnName, i);
      }
    }
    return ImmutableMap.copyOf(mapping);
  }
}

/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.cloud.bigquery.jdbc.BigQueryBaseArray.isArray;
import static com.google.cloud.bigquery.jdbc.BigQueryBaseStruct.isStruct;

import com.google.api.core.InternalApi;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Schema;

/**
 * Package-private parser for BigQuery rows into lightweight Object[] buffers.
 *
 * <p>This class extracts cell data into compact primitive row arrays ({@code Object[]}), bypassing
 * intermediate {@link FieldValueList} / {@link FieldValue} POJO allocations for primitive scalar
 * columns to drastically reduce JVM heap overhead and GC pause times.
 */
@InternalApi
class BigQueryJsonStreamParser {
  private final FieldList fieldList;
  private final boolean[] isComplexColumn;

  BigQueryJsonStreamParser(Schema schema) {
    this.fieldList = schema == null ? null : schema.getFields();
    if (this.fieldList != null) {
      int size = this.fieldList.size();
      this.isComplexColumn = new boolean[size];
      for (int i = 0; i < size; i++) {
        Field field = this.fieldList.get(i);
        this.isComplexColumn[i] = isArray(field) || isStruct(field);
      }
    } else {
      this.isComplexColumn = new boolean[0];
    }
  }

  BigQueryJsonStreamParser(FieldList fieldList) {
    this.fieldList = fieldList;
    if (this.fieldList != null) {
      int size = this.fieldList.size();
      this.isComplexColumn = new boolean[size];
      for (int i = 0; i < size; i++) {
        Field field = this.fieldList.get(i);
        this.isComplexColumn[i] = isArray(field) || isStruct(field);
      }
    } else {
      this.isComplexColumn = new boolean[0];
    }
  }

  /**
   * Unpacks a {@link FieldValueList} row into a lightweight {@code Object[]} array, extracting raw
   * string/primitive values and immediately discarding {@link FieldValueList} references to reduce
   * heap memory pressure.
   */
  public Object[] unpackRow(FieldValueList fieldValueList) {
    if (fieldValueList == null) {
      return null;
    }
    int size = fieldValueList.size();
    Object[] row = new Object[size];
    for (int i = 0; i < size; i++) {
      FieldValue fv = fieldValueList.get(i);
      if (fv == null || fv.isNull()) {
        row[i] = null;
      } else if (i < isComplexColumn.length && isComplexColumn[i]) {
        // Retain FieldValue wrapper for complex ARRAY / STRUCT types
        row[i] = fv;
      } else {
        // Extract raw scalar string representation for primitives
        Object val = fv.getValue();
        row[i] = val == null ? null : val.toString();
      }
    }
    return row;
  }
}

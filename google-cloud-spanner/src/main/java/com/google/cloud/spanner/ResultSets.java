/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import com.google.cloud.ByteArray;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.spanner.v1.ResultSetStats;
import java.util.List;

/** Utility methods for working with {@link com.google.cloud.spanner.ResultSet}. */
public final class ResultSets {

  private ResultSets() {}

  /**
   * Creates a pre-populated {@link com.google.cloud.spanner.ResultSet}
   *
   * @param type row type of the rows in the returned {@link com.google.cloud.spanner.ResultSet}
   * @param rows the rows in the returned {@link com.google.cloud.spanner.ResultSet}.
   */
  public static ResultSet forRows(Type type, Iterable<Struct> rows) {
    return new PrePopulatedResultSet(type, rows);
  }

  private static class PrePopulatedResultSet implements ResultSet {
    private final List<Struct> rows;
    private final Type type;
    private int index = -1;
    private boolean closed = false;

    PrePopulatedResultSet(Type type, Iterable<Struct> rows) {
      Preconditions.checkNotNull(rows);
      Preconditions.checkNotNull(type);
      Preconditions.checkArgument(type.getCode() == Type.Code.STRUCT);
      this.type = type;
      this.rows = rows instanceof List<?> ? (List<Struct>) rows : Lists.newArrayList(rows);
      for (Struct row : rows) {
        Preconditions.checkArgument(row.getType().equals(type));
      }
    }

    @Override
    public boolean next() throws SpannerException {
      return ++index < rows.size();
    }

    @Override
    public Struct getCurrentRowAsStruct() {
      Preconditions.checkState(!closed, "ResultSet is closed");
      Preconditions.checkElementIndex(index, rows.size(), "All rows have been yielded");
      return rows.get(index);
    }

    @Override
    public void close() {
      closed = true;
    }

    @Override
    public Type getType() {
      Preconditions.checkState(index >= 0, "Must be preceded by a next() call");
      return type;
    }

    @Override
    public ResultSetStats getStats() {
      throw new UnsupportedOperationException(
          "ResultSetStats are available only for results returned from analyzeQuery() calls");
    }

    @Override
    public int getColumnCount() {
      return getType().getStructFields().size();
    }

    @Override
    public int getColumnIndex(String columnName) {
      return getType().getFieldIndex(columnName);
    }

    @Override
    public Type getColumnType(int columnIndex) {
      return getType().getStructFields().get(columnIndex).getType();
    }

    @Override
    public Type getColumnType(String columnName) {
      for (Type.StructField field : getType().getStructFields()) {
        if (field.getName() == columnName) {
          return field.getType();
        }
      }
      return null;
    }

    @Override
    public boolean isNull(int columnIndex) {
      return getCurrentRowAsStruct().isNull(columnIndex);
    }

    @Override
    public boolean isNull(String columnName) {
      return getCurrentRowAsStruct().isNull(columnName);
    }

    @Override
    public boolean getBoolean(int columnIndex) {
      return getCurrentRowAsStruct().getBoolean(columnIndex);
    }

    @Override
    public boolean getBoolean(String columnName) {
      return getCurrentRowAsStruct().getBoolean(columnName);
    }

    @Override
    public long getLong(int columnIndex) {
      return getCurrentRowAsStruct().getLong(columnIndex);
    }

    @Override
    public long getLong(String columnName) {
      return getCurrentRowAsStruct().getLong(columnName);
    }

    @Override
    public double getDouble(int columnIndex) {
      return getCurrentRowAsStruct().getDouble(columnIndex);
    }

    @Override
    public double getDouble(String columnName) {
      return getCurrentRowAsStruct().getDouble(columnName);
    }

    @Override
    public String getString(int columnIndex) {
      return getCurrentRowAsStruct().getString(columnIndex);
    }

    @Override
    public String getString(String columnName) {
      return getCurrentRowAsStruct().getString(columnName);
    }

    @Override
    public ByteArray getBytes(int columnIndex) {
      return getCurrentRowAsStruct().getBytes(columnIndex);
    }

    @Override
    public ByteArray getBytes(String columnName) {
      return getCurrentRowAsStruct().getBytes(columnName);
    }

    @Override
    public Timestamp getTimestamp(int columnIndex) {
      return getCurrentRowAsStruct().getTimestamp(columnIndex);
    }

    @Override
    public Timestamp getTimestamp(String columnName) {
      return getCurrentRowAsStruct().getTimestamp(columnName);
    }

    @Override
    public Date getDate(int columnIndex) {
      return getCurrentRowAsStruct().getDate(columnIndex);
    }

    @Override
    public Date getDate(String columnName) {
      return getCurrentRowAsStruct().getDate(columnName);
    }

    @Override
    public boolean[] getBooleanArray(int columnIndex) {
      return getCurrentRowAsStruct().getBooleanArray(columnIndex);
    }

    @Override
    public boolean[] getBooleanArray(String columnName) {
      return getCurrentRowAsStruct().getBooleanArray(columnName);
    }

    @Override
    public List<Boolean> getBooleanList(int columnIndex) {
      return getCurrentRowAsStruct().getBooleanList(columnIndex);
    }

    @Override
    public List<Boolean> getBooleanList(String columnName) {
      return getCurrentRowAsStruct().getBooleanList(columnName);
    }

    @Override
    public long[] getLongArray(int columnIndex) {
      return getCurrentRowAsStruct().getLongArray(columnIndex);
    }

    @Override
    public long[] getLongArray(String columnName) {
      return getCurrentRowAsStruct().getLongArray(columnName);
    }

    @Override
    public List<Long> getLongList(int columnIndex) {
      return getCurrentRowAsStruct().getLongList(columnIndex);
    }

    @Override
    public List<Long> getLongList(String columnName) {
      return getCurrentRowAsStruct().getLongList(columnName);
    }

    @Override
    public double[] getDoubleArray(int columnIndex) {
      return getCurrentRowAsStruct().getDoubleArray(columnIndex);
    }

    @Override
    public double[] getDoubleArray(String columnName) {
      return getCurrentRowAsStruct().getDoubleArray(columnName);
    }

    @Override
    public List<Double> getDoubleList(int columnIndex) {
      return getCurrentRowAsStruct().getDoubleList(columnIndex);
    }

    @Override
    public List<Double> getDoubleList(String columnName) {
      return getCurrentRowAsStruct().getDoubleList(columnName);
    }

    @Override
    public List<String> getStringList(int columnIndex) {
      return getCurrentRowAsStruct().getStringList(columnIndex);
    }

    @Override
    public List<String> getStringList(String columnName) {
      return getCurrentRowAsStruct().getStringList(columnName);
    }

    @Override
    public List<ByteArray> getBytesList(int columnIndex) {
      return getCurrentRowAsStruct().getBytesList(columnIndex);
    }

    @Override
    public List<ByteArray> getBytesList(String columnName) {
      return getCurrentRowAsStruct().getBytesList(columnName);
    }

    @Override
    public List<Timestamp> getTimestampList(int columnIndex) {
      return getCurrentRowAsStruct().getTimestampList(columnIndex);
    }

    @Override
    public List<Timestamp> getTimestampList(String columnName) {
      return getCurrentRowAsStruct().getTimestampList(columnName);
    }

    @Override
    public List<Date> getDateList(int columnIndex) {
      return getCurrentRowAsStruct().getDateList(columnIndex);
    }

    @Override
    public List<Date> getDateList(String columnName) {
      return getCurrentRowAsStruct().getDateList(columnName);
    }

    @Override
    public List<Struct> getStructList(int columnIndex) {
      return getCurrentRowAsStruct().getStructList(columnIndex);
    }

    @Override
    public List<Struct> getStructList(String columnName) {
      return getCurrentRowAsStruct().getStructList(columnName);
    }
  }
}

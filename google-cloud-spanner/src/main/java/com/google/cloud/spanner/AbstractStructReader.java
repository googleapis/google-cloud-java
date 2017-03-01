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

import static com.google.common.base.Preconditions.checkState;

import com.google.cloud.ByteArray;
import java.util.List;

/**
 * Base class for assisting {@link StructReader} implementations.
 *
 * <p>This class implements the majority of the {@code StructReader} interface, leaving subclasses
 * to implement core data access via the {@code getTypeNameInternal()} methods. {@code
 * AbstractStructReader} guarantees that these will only be called for non-{@code NULL} columns of a
 * type appropriate for the method.
 */
public abstract class AbstractStructReader implements StructReader {
  protected abstract boolean getBooleanInternal(int columnIndex);

  protected abstract long getLongInternal(int columnIndex);

  protected abstract double getDoubleInternal(int columnIndex);

  protected abstract String getStringInternal(int columnIndex);

  protected abstract ByteArray getBytesInternal(int columnIndex);

  protected abstract Timestamp getTimestampInternal(int columnIndex);

  protected abstract Date getDateInternal(int columnIndex);

  protected abstract boolean[] getBooleanArrayInternal(int columnIndex);

  protected abstract List<Boolean> getBooleanListInternal(int columnIndex);

  protected abstract long[] getLongArrayInternal(int columnIndex);

  protected abstract List<Long> getLongListInternal(int columnIndex);

  protected abstract double[] getDoubleArrayInternal(int columnIndex);

  protected abstract List<Double> getDoubleListInternal(int columnIndex);

  protected abstract List<String> getStringListInternal(int columnIndex);

  protected abstract List<ByteArray> getBytesListInternal(int columnIndex);

  protected abstract List<Timestamp> getTimestampListInternal(int columnIndex);

  protected abstract List<Date> getDateListInternal(int columnIndex);

  protected abstract List<Struct> getStructListInternal(int columnIndex);

  @Override
  public int getColumnCount() {
    return getType().getStructFields().size();
  }

  @Override
  public Type getColumnType(int columnIndex) {
    return getType().getStructFields().get(columnIndex).getType();
  }

  @Override
  public Type getColumnType(String columnName) {
    return getType().getStructFields().get(getColumnIndex(columnName)).getType();
  }

  @Override
  public boolean isNull(String columnName) {
    return isNull(getColumnIndex(columnName));
  }

  @Override
  public boolean getBoolean(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.bool(), columnIndex);
    return getBooleanInternal(columnIndex);
  }

  @Override
  public boolean getBoolean(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.bool(), columnName);
    return getBooleanInternal(columnIndex);
  }

  @Override
  public long getLong(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.int64(), columnIndex);
    return getLongInternal(columnIndex);
  }

  @Override
  public long getLong(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.int64(), columnName);
    return getLongInternal(columnIndex);
  }

  @Override
  public double getDouble(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.float64(), columnIndex);
    return getDoubleInternal(columnIndex);
  }

  @Override
  public double getDouble(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.float64(), columnName);
    return getDoubleInternal(columnIndex);
  }

  @Override
  public String getString(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.string(), columnIndex);
    return getStringInternal(columnIndex);
  }

  @Override
  public String getString(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.string(), columnName);
    return getStringInternal(columnIndex);
  }

  @Override
  public ByteArray getBytes(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.bytes(), columnIndex);
    return getBytesInternal(columnIndex);
  }

  @Override
  public ByteArray getBytes(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.bytes(), columnName);
    return getBytesInternal(columnIndex);
  }

  @Override
  public Timestamp getTimestamp(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.timestamp(), columnIndex);
    return getTimestampInternal(columnIndex);
  }

  @Override
  public Timestamp getTimestamp(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.timestamp(), columnName);
    return getTimestampInternal(columnIndex);
  }

  @Override
  public Date getDate(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.date(), columnIndex);
    return getDateInternal(columnIndex);
  }

  @Override
  public Date getDate(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.date(), columnName);
    return getDateInternal(columnIndex);
  }

  @Override
  public boolean[] getBooleanArray(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.bool()), columnIndex);
    return getBooleanArrayInternal(columnIndex);
  }

  @Override
  public boolean[] getBooleanArray(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.bool()), columnName);
    return getBooleanArrayInternal(columnIndex);
  }

  @Override
  public List<Boolean> getBooleanList(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.bool()), columnIndex);
    return getBooleanListInternal(columnIndex);
  }

  @Override
  public List<Boolean> getBooleanList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.bool()), columnName);
    return getBooleanListInternal(columnIndex);
  }

  @Override
  public long[] getLongArray(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.int64()), columnIndex);
    return getLongArrayInternal(columnIndex);
  }

  @Override
  public long[] getLongArray(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.int64()), columnName);
    return getLongArrayInternal(columnIndex);
  }

  @Override
  public List<Long> getLongList(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.int64()), columnIndex);
    return getLongListInternal(columnIndex);
  }

  @Override
  public List<Long> getLongList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.int64()), columnName);
    return getLongListInternal(columnIndex);
  }

  @Override
  public double[] getDoubleArray(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.float64()), columnIndex);
    return getDoubleArrayInternal(columnIndex);
  }

  @Override
  public double[] getDoubleArray(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.float64()), columnName);
    return getDoubleArrayInternal(columnIndex);
  }

  @Override
  public List<Double> getDoubleList(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.float64()), columnIndex);
    return getDoubleListInternal(columnIndex);
  }

  @Override
  public List<Double> getDoubleList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.float64()), columnName);
    return getDoubleListInternal(columnIndex);
  }

  @Override
  public List<String> getStringList(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.string()), columnIndex);
    return getStringListInternal(columnIndex);
  }

  @Override
  public List<String> getStringList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.string()), columnName);
    return getStringListInternal(columnIndex);
  }

  @Override
  public List<ByteArray> getBytesList(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.bytes()), columnIndex);
    return getBytesListInternal(columnIndex);
  }

  @Override
  public List<ByteArray> getBytesList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.bytes()), columnName);
    return getBytesListInternal(columnIndex);
  }

  @Override
  public List<Timestamp> getTimestampList(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.timestamp()), columnIndex);
    return getTimestampListInternal(columnIndex);
  }

  @Override
  public List<Timestamp> getTimestampList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.timestamp()), columnName);
    return getTimestampListInternal(columnIndex);
  }

  @Override
  public List<Date> getDateList(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.date()), columnIndex);
    return getDateListInternal(columnIndex);
  }

  @Override
  public List<Date> getDateList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.date()), columnName);
    return getDateListInternal(columnIndex);
  }

  @Override
  public List<Struct> getStructList(int columnIndex) {
    checkNonNullArrayOfStruct(columnIndex, columnIndex);
    return getStructListInternal(columnIndex);
  }

  @Override
  public List<Struct> getStructList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullArrayOfStruct(columnIndex, columnName);
    return getStructListInternal(columnIndex);
  }

  @Override
  public int getColumnIndex(String columnName) {
    // Use the Type instance for field name lookup.  Type instances are naturally shared by the
    // ResultSet, all Structs corresponding to rows in the read, and all Structs corresponding to
    // the values of ARRAY<STRUCT<...>> columns in the read, so this is the best location to
    // amortize lookup costs.
    return getType().getFieldIndex(columnName);
  }

  private void checkNonNullOfType(int columnIndex, Type expectedType, Object columnNameForError) {
    Type actualType = getColumnType(columnIndex);
    checkState(
        expectedType.equals(actualType),
        "Column %s is not of correct type: expected %s but was %s",
        columnNameForError,
        expectedType,
        actualType);
    checkNonNull(columnIndex, columnNameForError);
  }

  private void checkNonNullArrayOfStruct(int columnIndex, Object columnNameForError) {
    Type actualType = getColumnType(columnIndex);
    checkState(
        actualType.getCode() == Type.Code.ARRAY
            && actualType.getArrayElementType().getCode() == Type.Code.STRUCT,
        "Column %s is not of correct type: expected ARRAY<STRUCT<...>> but was %s",
        columnNameForError,
        actualType);
    checkNonNull(columnIndex, columnNameForError);
  }

  private void checkNonNull(int columnIndex, Object columnNameForError) {
    if (isNull(columnIndex)) {
      throw new NullPointerException("Column " + columnNameForError + " contains NULL value");
    }
  }
}

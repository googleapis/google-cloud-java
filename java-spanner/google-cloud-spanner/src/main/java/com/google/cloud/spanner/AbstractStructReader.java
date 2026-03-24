/*
 * Copyright 2017 Google LLC
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
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Type.Code;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ProtocolMessageEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

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

  protected float getFloatInternal(int columnIndex) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected abstract double getDoubleInternal(int columnIndex);

  protected abstract BigDecimal getBigDecimalInternal(int columnIndex);

  protected abstract String getStringInternal(int columnIndex);

  protected String getJsonInternal(int columnIndex) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected String getPgJsonbInternal(int columnIndex) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected abstract ByteArray getBytesInternal(int columnIndex);

  protected abstract Timestamp getTimestampInternal(int columnIndex);

  protected abstract Date getDateInternal(int columnIndex);

  protected UUID getUuidInternal(int columnIndex) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected Interval getIntervalInternal(int columnIndex) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected <T extends AbstractMessage> T getProtoMessageInternal(int columnIndex, T message) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected <T extends ProtocolMessageEnum> T getProtoEnumInternal(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected <T extends AbstractMessage> List<T> getProtoMessageListInternal(
      int columnIndex, T message) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected <T extends ProtocolMessageEnum> List<T> getProtoEnumListInternal(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected Value getValueInternal(int columnIndex) {
    throw new UnsupportedOperationException("method should be overwritten");
  }

  protected abstract boolean[] getBooleanArrayInternal(int columnIndex);

  protected abstract List<Boolean> getBooleanListInternal(int columnIndex);

  protected abstract long[] getLongArrayInternal(int columnIndex);

  protected abstract List<Long> getLongListInternal(int columnIndex);

  protected float[] getFloatArrayInternal(int columnIndex) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected List<Float> getFloatListInternal(int columnIndex) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected abstract double[] getDoubleArrayInternal(int columnIndex);

  protected abstract List<Double> getDoubleListInternal(int columnIndex);

  protected abstract List<BigDecimal> getBigDecimalListInternal(int columnIndex);

  protected abstract List<String> getStringListInternal(int columnIndex);

  protected List<String> getJsonListInternal(int columnIndex) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected List<String> getPgJsonbListInternal(int columnIndex) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected abstract List<ByteArray> getBytesListInternal(int columnIndex);

  protected abstract List<Timestamp> getTimestampListInternal(int columnIndex);

  protected abstract List<Date> getDateListInternal(int columnIndex);

  protected List<UUID> getUuidListInternal(int columnIndex) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected List<Interval> getIntervalListInternal(int columnIndex) {
    throw new UnsupportedOperationException("Not implemented");
  }

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
    checkNonNullOfCodes(
        columnIndex, Arrays.asList(Code.ENUM, Code.PG_OID, Code.INT64), columnIndex);
    return getLongInternal(columnIndex);
  }

  @Override
  public long getLong(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfCodes(columnIndex, Arrays.asList(Code.ENUM, Code.PG_OID, Code.INT64), columnName);
    return getLongInternal(columnIndex);
  }

  @Override
  public float getFloat(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.float32(), columnIndex);
    return getFloatInternal(columnIndex);
  }

  @Override
  public float getFloat(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.float32(), columnName);
    return getFloatInternal(columnIndex);
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
  public BigDecimal getBigDecimal(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.numeric(), columnIndex);
    return getBigDecimalInternal(columnIndex);
  }

  @Override
  public BigDecimal getBigDecimal(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.numeric(), columnName);
    return getBigDecimalInternal(columnIndex);
  }

  @Override
  public String getString(int columnIndex) {
    checkNonNullOfTypes(
        columnIndex,
        Arrays.asList(Type.string(), Type.pgNumeric()),
        columnIndex,
        "STRING, NUMERIC");
    return getStringInternal(columnIndex);
  }

  @Override
  public String getString(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfTypes(
        columnIndex, Arrays.asList(Type.string(), Type.pgNumeric()), columnName, "STRING, NUMERIC");
    return getStringInternal(columnIndex);
  }

  @Override
  public String getJson(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.json(), columnIndex);
    return getJsonInternal(columnIndex);
  }

  @Override
  public String getJson(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.json(), columnName);
    return getJsonInternal(columnIndex);
  }

  @Override
  public String getPgJsonb(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.pgJsonb(), columnIndex);
    return getPgJsonbInternal(columnIndex);
  }

  @Override
  public String getPgJsonb(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.pgJsonb(), columnName);
    return getPgJsonbInternal(columnIndex);
  }

  @Override
  public ByteArray getBytes(int columnIndex) {
    checkNonNullOfCodes(columnIndex, Arrays.asList(Code.PROTO, Code.BYTES), columnIndex);
    return getBytesInternal(columnIndex);
  }

  @Override
  public ByteArray getBytes(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfCodes(columnIndex, Arrays.asList(Code.PROTO, Code.BYTES), columnName);
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
  public UUID getUuid(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.uuid(), columnIndex);
    return getUuidInternal(columnIndex);
  }

  @Override
  public UUID getUuid(String columnName) {
    final int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.uuid(), columnName);
    return getUuidInternal(columnIndex);
  }

  @Override
  public Interval getInterval(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.interval(), columnIndex);
    return getIntervalInternal(columnIndex);
  }

  @Override
  public Interval getInterval(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.interval(), columnName);
    return getIntervalInternal(columnIndex);
  }

  @Override
  public <T extends ProtocolMessageEnum> T getProtoEnum(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    checkNonNullOfCodes(columnIndex, Arrays.asList(Code.ENUM, Code.INT64), columnIndex);
    return getProtoEnumInternal(columnIndex, method);
  }

  @Override
  public <T extends ProtocolMessageEnum> T getProtoEnum(
      String columnName, Function<Integer, ProtocolMessageEnum> method) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfCodes(columnIndex, Arrays.asList(Code.ENUM, Code.INT64), columnName);
    return getProtoEnumInternal(columnIndex, method);
  }

  @Override
  public <T extends AbstractMessage> T getProtoMessage(int columnIndex, T message) {
    checkNonNullOfCodes(columnIndex, Arrays.asList(Code.PROTO, Code.BYTES), columnIndex);
    return getProtoMessageInternal(columnIndex, message);
  }

  @Override
  public <T extends AbstractMessage> T getProtoMessage(String columnName, T message) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfCodes(columnIndex, Arrays.asList(Code.PROTO, Code.BYTES), columnName);
    return getProtoMessageInternal(columnIndex, message);
  }

  @Override
  public Value getValue(int columnIndex) {
    return getValueInternal(columnIndex);
  }

  @Override
  public Value getValue(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    return getValueInternal(columnIndex);
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
    checkNonNullOfCodes(columnIndex, Collections.singletonList(Code.ARRAY), columnIndex);
    checkArrayElementType(
        columnIndex, Arrays.asList(Code.ENUM, Code.PG_OID, Code.INT64), columnIndex);
    return getLongArrayInternal(columnIndex);
  }

  @Override
  public long[] getLongArray(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfCodes(columnIndex, Collections.singletonList(Code.ARRAY), columnName);
    checkArrayElementType(
        columnIndex, Arrays.asList(Code.ENUM, Code.PG_OID, Code.INT64), columnName);
    return getLongArrayInternal(columnIndex);
  }

  @Override
  public List<Long> getLongList(int columnIndex) {
    checkNonNullOfCodes(columnIndex, Collections.singletonList(Code.ARRAY), columnIndex);
    checkArrayElementType(
        columnIndex, Arrays.asList(Code.ENUM, Code.PG_OID, Code.INT64), columnIndex);
    return getLongListInternal(columnIndex);
  }

  @Override
  public List<Long> getLongList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfCodes(columnIndex, Collections.singletonList(Code.ARRAY), columnName);
    checkArrayElementType(
        columnIndex, Arrays.asList(Code.ENUM, Code.PG_OID, Code.INT64), columnName);
    return getLongListInternal(columnIndex);
  }

  @Override
  public float[] getFloatArray(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.float32()), columnIndex);
    return getFloatArrayInternal(columnIndex);
  }

  @Override
  public float[] getFloatArray(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.float32()), columnName);
    return getFloatArrayInternal(columnIndex);
  }

  @Override
  public List<Float> getFloatList(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.float32()), columnIndex);
    return getFloatListInternal(columnIndex);
  }

  @Override
  public List<Float> getFloatList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.float32()), columnName);
    return getFloatListInternal(columnIndex);
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
  public List<BigDecimal> getBigDecimalList(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.numeric()), columnIndex);
    return getBigDecimalListInternal(columnIndex);
  }

  @Override
  public List<BigDecimal> getBigDecimalList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.numeric()), columnName);
    return getBigDecimalListInternal(columnIndex);
  }

  @Override
  public List<String> getStringList(int columnIndex) {
    checkNonNullOfTypes(
        columnIndex,
        Arrays.asList(Type.array(Type.string()), Type.array(Type.pgNumeric())),
        columnIndex,
        "ARRAY<STRING>, ARRAY<NUMERIC>");
    return getStringListInternal(columnIndex);
  }

  @Override
  public List<String> getStringList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfTypes(
        columnIndex,
        Arrays.asList(Type.array(Type.string()), Type.array(Type.pgNumeric())),
        columnName,
        "ARRAY<STRING>, ARRAY<NUMERIC>");
    return getStringListInternal(columnIndex);
  }

  @Override
  public List<String> getJsonList(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.json()), columnIndex);
    return getJsonListInternal(columnIndex);
  }

  @Override
  public List<String> getJsonList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.json()), columnName);
    return getJsonListInternal(columnIndex);
  }

  @Override
  public List<String> getPgJsonbList(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.pgJsonb()), columnIndex);
    return getPgJsonbListInternal(columnIndex);
  }

  @Override
  public List<String> getPgJsonbList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.pgJsonb()), columnName);
    return getPgJsonbListInternal(columnIndex);
  }

  @Override
  public List<ByteArray> getBytesList(int columnIndex) {
    checkNonNullOfCodes(columnIndex, Collections.singletonList(Code.ARRAY), columnIndex);
    checkArrayElementType(columnIndex, Arrays.asList(Code.PROTO, Code.BYTES), columnIndex);
    return getBytesListInternal(columnIndex);
  }

  @Override
  public List<ByteArray> getBytesList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfCodes(columnIndex, Collections.singletonList(Code.ARRAY), columnName);
    checkArrayElementType(columnIndex, Arrays.asList(Code.PROTO, Code.BYTES), columnName);
    return getBytesListInternal(columnIndex);
  }

  @Override
  public <T extends AbstractMessage> List<T> getProtoMessageList(int columnIndex, T message) {
    checkNonNullOfCodes(columnIndex, Collections.singletonList(Code.ARRAY), columnIndex);
    checkArrayElementType(columnIndex, Arrays.asList(Code.PROTO, Code.BYTES), columnIndex);
    return getProtoMessageListInternal(columnIndex, message);
  }

  @Override
  public <T extends AbstractMessage> List<T> getProtoMessageList(String columnName, T message) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfCodes(columnIndex, Collections.singletonList(Code.ARRAY), columnName);
    checkArrayElementType(columnIndex, Arrays.asList(Code.PROTO, Code.BYTES), columnName);
    return getProtoMessageListInternal(columnIndex, message);
  }

  @Override
  public <T extends ProtocolMessageEnum> List<T> getProtoEnumList(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    checkNonNullOfCodes(columnIndex, Collections.singletonList(Code.ARRAY), columnIndex);
    checkArrayElementType(columnIndex, Arrays.asList(Code.ENUM, Code.INT64), columnIndex);
    return getProtoEnumListInternal(columnIndex, method);
  }

  @Override
  public <T extends ProtocolMessageEnum> List<T> getProtoEnumList(
      String columnName, Function<Integer, ProtocolMessageEnum> method) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfCodes(columnIndex, Collections.singletonList(Code.ARRAY), columnName);
    checkArrayElementType(columnIndex, Arrays.asList(Code.ENUM, Code.INT64), columnName);
    return getProtoEnumListInternal(columnIndex, method);
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
  public List<UUID> getUuidList(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.uuid()), columnIndex);
    return getUuidListInternal(columnIndex);
  }

  @Override
  public List<UUID> getUuidList(String columnName) {
    final int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.uuid()), columnName);
    return getUuidListInternal(columnIndex);
  }

  @Override
  public List<Interval> getIntervalList(int columnIndex) {
    checkNonNullOfType(columnIndex, Type.array(Type.interval()), columnIndex);
    return getIntervalListInternal(columnIndex);
  }

  @Override
  public List<Interval> getIntervalList(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, Type.array(Type.interval()), columnName);
    return getIntervalListInternal(columnIndex);
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

  protected void checkNonNull(int columnIndex, Object columnNameForError) {
    if (isNull(columnIndex)) {
      throw new NullPointerException("Column " + columnNameForError + " contains NULL value");
    }
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

  /** Checks if the value at {@code columnIndex} is one of {@code expectedCode} */
  private void checkNonNullOfCodes(
      int columnIndex, List<Code> expectedCodes, Object columnNameForError) {
    Type actualType = getColumnType(columnIndex);
    checkState(
        expectedCodes.contains(actualType.getCode()),
        "Column %s is not of correct type code: expected one of [%s] but was %s",
        columnNameForError,
        expectedCodes,
        actualType);
    checkNonNull(columnIndex, columnNameForError);
  }

  private void checkArrayElementType(
      int columnIndex, List<Code> expectedCodes, Object columnNameForError) {
    Type arrayElementType = getColumnType(columnIndex).getArrayElementType();
    checkState(
        expectedCodes.contains(arrayElementType.getCode()),
        "Array element for Column %s is not of correct type code: expected one of [%s] but was %s",
        columnNameForError,
        expectedCodes,
        Type.array(arrayElementType));
  }

  private void checkNonNullOfTypes(
      int columnIndex,
      List<Type> expectedTypes,
      Object columnNameForError,
      String expectedTypeNames) {
    Type actualType = getColumnType(columnIndex);
    checkState(
        expectedTypes.contains(actualType),
        "Column %s is not of correct type: expected one of [%s] but was %s",
        columnNameForError,
        expectedTypeNames,
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
}

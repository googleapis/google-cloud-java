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
import com.google.bigtable.v2.Value;
import com.google.bigtable.v2.Value.KindCase;
import com.google.cloud.Date;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.models.sql.Struct;
import com.google.cloud.bigtable.data.v2.models.sql.StructReader;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.Instant;

@InternalApi
public abstract class AbstractProtoStructReader implements StructReader {

  abstract List<Value> values();

  // Force subclasses to override equals and hashcode. We need this for tests.
  public abstract boolean equals(Object other);

  public abstract int hashCode();

  /**
   * @param columnName name of the column
   * @return the index of the column named {@code columnName}
   * @throws IllegalArgumentException if there is not exactly one column with the given name
   */
  public abstract int getColumnIndex(String columnName);

  /**
   * @param columnIndex index of the column
   * @return the type of the column at the given index
   */
  public abstract SqlType<?> getColumnType(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the type of the column with the given name
   * @throws IllegalArgumentException if there is not exactly one column with the given name
   */
  public SqlType<?> getColumnType(String columnName) {
    return getColumnType(getColumnIndex(columnName));
  }

  @Override
  public boolean isNull(int columnIndex) {
    Value value = values().get(columnIndex);
    return value.getKindCase().equals(KindCase.KIND_NOT_SET);
  }

  @Override
  public boolean isNull(String columnName) {
    return isNull(getColumnIndex(columnName));
  }

  @Override
  public ByteString getBytes(int columnIndex) {
    checkNonNullOfType(columnIndex, SqlType.bytes(), columnIndex);
    Value value = values().get(columnIndex);
    return value.getBytesValue();
  }

  @Override
  public ByteString getBytes(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, SqlType.bytes(), columnName);
    Value value = values().get(columnIndex);
    return value.getBytesValue();
  }

  @Override
  public String getString(int columnIndex) {
    checkNonNullOfType(columnIndex, SqlType.string(), columnIndex);
    Value value = values().get(columnIndex);
    return value.getStringValue();
  }

  @Override
  public String getString(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, SqlType.string(), columnName);
    Value value = values().get(columnIndex);
    return value.getStringValue();
  }

  @Override
  public long getLong(int columnIndex) {
    checkNonNullOfType(columnIndex, SqlType.int64(), columnIndex);
    Value value = values().get(columnIndex);
    return value.getIntValue();
  }

  @Override
  public long getLong(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, SqlType.int64(), columnName);
    Value value = values().get(columnIndex);
    return value.getIntValue();
  }

  @Override
  public double getDouble(int columnIndex) {
    checkNonNullOfType(columnIndex, SqlType.float64(), columnIndex);
    Value value = values().get(columnIndex);
    return value.getFloatValue();
  }

  @Override
  public double getDouble(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, SqlType.float64(), columnName);
    Value value = values().get(columnIndex);
    return value.getFloatValue();
  }

  @Override
  public float getFloat(int columnIndex) {
    checkNonNullOfType(columnIndex, SqlType.float32(), columnIndex);
    Value value = values().get(columnIndex);
    return (float) value.getFloatValue();
  }

  @Override
  public float getFloat(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, SqlType.float32(), columnName);
    Value value = values().get(columnIndex);
    return (float) value.getFloatValue();
  }

  @Override
  public boolean getBoolean(int columnIndex) {
    checkNonNullOfType(columnIndex, SqlType.bool(), columnIndex);
    Value value = values().get(columnIndex);
    return value.getBoolValue();
  }

  @Override
  public boolean getBoolean(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, SqlType.bool(), columnName);
    Value value = values().get(columnIndex);
    return value.getBoolValue();
  }

  @Override
  public Instant getTimestamp(int columnIndex) {
    checkNonNullOfType(columnIndex, SqlType.timestamp(), columnIndex);
    Value value = values().get(columnIndex);
    return toInstant(value.getTimestampValue());
  }

  @Override
  public Instant getTimestamp(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, SqlType.timestamp(), columnName);
    Value value = values().get(columnIndex);
    return toInstant(value.getTimestampValue());
  }

  @Override
  public Date getDate(int columnIndex) {
    checkNonNullOfType(columnIndex, SqlType.date(), columnIndex);
    Value value = values().get(columnIndex);
    return fromProto(value.getDateValue());
  }

  @Override
  public Date getDate(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, SqlType.date(), columnName);
    Value value = values().get(columnIndex);
    return fromProto(value.getDateValue());
  }

  @Override
  public Struct getStruct(int columnIndex) {
    checkNonNullOfType(columnIndex, SqlType.struct(), columnIndex);
    Value value = values().get(columnIndex);
    SqlType.Struct schema = (SqlType.Struct) getColumnType(columnIndex);
    // A struct value is represented as an array
    return ProtoStruct.create(schema, value.getArrayValue());
  }

  @Override
  public Struct getStruct(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullOfType(columnIndex, SqlType.struct(), columnName);
    Value value = values().get(columnIndex);
    SqlType.Struct schema = (SqlType.Struct) getColumnType(columnIndex);
    // A struct value is represented as an array
    return ProtoStruct.create(schema, value.getArrayValue());
  }

  @Override
  public <ElemType> List<ElemType> getList(int columnIndex, SqlType.Array<ElemType> arrayType) {
    // Note it is important that we use the actualType to decode bc user passed struct types
    // won't have schemas
    SqlType<?> actualType = getColumnType(columnIndex);
    checkNonNullOfType(columnIndex, arrayType, actualType, columnIndex);
    Value value = values().get(columnIndex);
    return (List<ElemType>) decodeValue(value, actualType);
  }

  @Override
  public <ElemType> List<ElemType> getList(String columnName, SqlType.Array<ElemType> arrayType) {
    int columnIndex = getColumnIndex(columnName);
    // Note it is important that we use the actualType to decode bc user passed struct types
    // won't have schemas
    SqlType<?> actualType = getColumnType(columnIndex);
    checkNonNullOfType(columnIndex, arrayType, actualType, columnName);
    Value value = values().get(columnIndex);
    return (List<ElemType>) decodeValue(value, actualType);
  }

  @Override
  public <K, V> Map<K, V> getMap(int columnIndex, SqlType.Map<K, V> mapType) {
    // Note it is important that we use the actualType to decode bc user passed struct types
    // won't have schemas
    SqlType<?> actualType = getColumnType(columnIndex);
    checkNonNullOfType(columnIndex, mapType, actualType, columnIndex);
    Value value = values().get(columnIndex);
    return (Map<K, V>) decodeValue(value, actualType);
  }

  @Override
  public <K, V> Map<K, V> getMap(String columnName, SqlType.Map<K, V> mapType) {
    int columnIndex = getColumnIndex(columnName);
    // Note it is important that we use the actualType to decode bc user passed struct types
    // won't have schemas
    SqlType<?> actualType = getColumnType(columnIndex);
    checkNonNullOfType(columnIndex, mapType, actualType, columnName);
    Value value = values().get(columnIndex);
    return (Map<K, V>) decodeValue(value, actualType);
  }

  Object decodeValue(Value value, SqlType<?> type) {
    if (value.getKindCase().equals(KindCase.KIND_NOT_SET)) {
      return null;
    }
    switch (type.getCode()) {
      case BYTES:
        return value.getBytesValue();
      case STRING:
        return value.getStringValue();
      case INT64:
        return value.getIntValue();
      case FLOAT64:
      case FLOAT32:
        return value.getFloatValue();
      case BOOL:
        return value.getBoolValue();
      case TIMESTAMP:
        return toInstant(value.getTimestampValue());
      case DATE:
        return fromProto(value.getDateValue());
      case STRUCT:
        SqlType.Struct schema = (SqlType.Struct) type;
        // A struct value is represented as an array
        return ProtoStruct.create(schema, value.getArrayValue());
      case ARRAY:
        ArrayList<Object> listBuilder = new ArrayList<>();
        SqlType.Array<?> arrayType = (SqlType.Array<?>) type;
        SqlType<?> elemType = arrayType.getElementType();
        for (Value elem : value.getArrayValue().getValuesList()) {
          listBuilder.add(decodeValue(elem, elemType));
        }
        // We use unmodifiableList instead of guava ImmutableList to allow null elements
        return Collections.unmodifiableList(listBuilder);
      case MAP:
        HashMap<Object, Object> mapBuilder = new HashMap<>();
        SqlType.Map<?, ?> mapType = (SqlType.Map<?, ?>) type;
        SqlType<?> keyType = mapType.getKeyType();
        SqlType<?> valType = mapType.getValueType();
        // A map value is represented as an array of k, v tuples where the tuple is a nested array
        for (Value entry : value.getArrayValue().getValuesList()) {
          Object key = decodeValue(entry.getArrayValue().getValues(0), keyType);
          Object val = decodeValue(entry.getArrayValue().getValues(1), valType);
          mapBuilder.put(key, val);
        }
        // We use unmodifiableMap instead of guava ImmutableMap to allow null keys & values
        return Collections.unmodifiableMap(mapBuilder);
      default:
        // We should have already thrown an exception in the SqlRowMerger
        throw new IllegalStateException("Unrecognized type: " + type);
    }
  }

  private void checkNonNullOfType(
      int columnIndex, SqlType<?> expectedType, Object columnNameForError) {
    SqlType<?> actualType = getColumnType(columnIndex);
    checkNonNullOfType(columnIndex, expectedType, actualType, columnNameForError);
  }

  private void checkNonNullOfType(
      int columnIndex, SqlType<?> expectedType, SqlType<?> actualType, Object columnNameForError) {
    Preconditions.checkState(
        SqlType.typesMatch(expectedType, actualType),
        "Column %s is not of correct type: expected %s but was %s",
        columnNameForError,
        expectedType.toString(),
        actualType.toString());
    if (isNull(columnIndex)) {
      throw new NullPointerException("Column " + columnNameForError + " contains NULL value");
    }
  }

  private Instant toInstant(Timestamp timestamp) {
    return Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
  }

  private Date fromProto(com.google.type.Date proto) {
    return Date.fromYearMonthDay(proto.getYear(), proto.getMonth(), proto.getDay());
  }
}

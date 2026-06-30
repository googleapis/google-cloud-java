/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.ValueBinder;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Message;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.rpc.Code;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/** Implementation of java.sql.Array for Google Cloud Spanner */
class JdbcArray implements Array {
  private static final String FREE_EXCEPTION =
      "free() has been called, array is no longer available";

  private final JdbcDataType type;
  private Object data;
  private boolean freed = false;

  /**
   * Create a JDBC {@link Array} from the given type name and array elements.
   *
   * @param typeName The Google Cloud Spanner type name to be used as the base type of the array.
   * @param elements The elements to store in the array.
   * @return the initialized {@link Array}.
   * @throws SQLException if the type name is not a valid Cloud Spanner type or if the contents of
   *     the elements array is not compatible with the base type of the array.
   */
  static JdbcArray createArray(String typeName, Object[] elements) throws SQLException {
    if (typeName != null) {
      for (JdbcDataType type : JdbcDataType.values()) {
        if (type.matches(typeName)) {
          return new JdbcArray(type, elements);
        }
      }
    }
    throw JdbcSqlExceptionFactory.of(
        "Data type " + typeName + " is unknown", Code.INVALID_ARGUMENT);
  }

  /**
   * Create a JDBC {@link Array} from the given type name and list.
   *
   * @param type The Google Cloud Spanner type to be used as the base type of the array.
   * @param elements The elements to store in the array.
   * @return the initialized {@link Array}.
   */
  static JdbcArray createArray(JdbcDataType type, List<?> elements) {
    return new JdbcArray(type, elements);
  }

  private JdbcArray(JdbcDataType type, Object[] elements) throws SQLException {
    this.type = type;
    if (elements != null) {
      if ((type.getCode() == Type.Code.PROTO
              && AbstractMessage[].class.isAssignableFrom(elements.getClass()))
          || (type.getCode() == Type.Code.ENUM
              && ProtocolMessageEnum[].class.isAssignableFrom(elements.getClass()))) {
        this.data =
            java.lang.reflect.Array.newInstance(
                elements.getClass().getComponentType(), elements.length);
        System.arraycopy(elements, 0, this.data, 0, elements.length);
      } else if (type == JdbcDataType.INT64 && requiresWideningToLong(elements)) {
        // Convert Byte[], Short[], and Integer[] to Long[] for INT64 type
        // since Spanner only supports ARRAY<INT64>
        this.data = convertToLongArray(elements);
      } else {
        this.data = java.lang.reflect.Array.newInstance(type.getJavaClass(), elements.length);
        try {
          System.arraycopy(elements, 0, this.data, 0, elements.length);
        } catch (Exception e) {
          throw JdbcSqlExceptionFactory.of(
              "Could not copy array elements. Make sure the supplied array only contains elements of class "
                  + type.getJavaClass().getName(),
              Code.UNKNOWN,
              e);
        }
      }
    }
  }

  private static boolean requiresWideningToLong(Object[] elements) {
    Class<?> componentType = elements.getClass().getComponentType();
    return componentType == Byte.class
        || componentType == Short.class
        || componentType == Integer.class;
  }

  private static Long[] convertToLongArray(Object[] elements) {
    Long[] longElements = new Long[elements.length];
    for (int i = 0; i < elements.length; i++) {
      if (elements[i] != null) {
        longElements[i] = ((Number) elements[i]).longValue();
      }
    }
    return longElements;
  }

  private JdbcArray(JdbcDataType type, List<?> elements) {
    this.type = type;
    if (elements != null) {
      this.data = java.lang.reflect.Array.newInstance(type.getJavaClass(), elements.size());
      elements.toArray((Object[]) data);
    }
  }

  private void checkFree() throws SQLException {
    if (freed) {
      throw JdbcSqlExceptionFactory.of(FREE_EXCEPTION, Code.FAILED_PRECONDITION);
    }
  }

  @Override
  public String getBaseTypeName() throws SQLException {
    checkFree();
    return type.getTypeName();
  }

  @Override
  public int getBaseType() throws SQLException {
    checkFree();
    return type.getSqlType();
  }

  @Override
  public Object getArray() throws SQLException {
    checkFree();
    return data;
  }

  @Override
  public Object getArray(Map<String, Class<?>> map) throws SQLException {
    checkFree();
    return data;
  }

  @Override
  public Object getArray(long index, int count) throws SQLException {
    checkFree();
    return getArray(index, count, null);
  }

  @Override
  public Object getArray(long index, int count, Map<String, Class<?>> map) throws SQLException {
    checkFree();
    if (this.data != null) {
      Object res;
      if ((this.type.getCode() == Type.Code.PROTO
              && AbstractMessage[].class.isAssignableFrom(this.data.getClass()))
          || (this.type.getCode() == Type.Code.ENUM
              && ProtocolMessageEnum[].class.isAssignableFrom(this.data.getClass()))) {
        res = java.lang.reflect.Array.newInstance(this.data.getClass().getComponentType(), count);
      } else {
        res = java.lang.reflect.Array.newInstance(this.type.getJavaClass(), count);
      }
      System.arraycopy(this.data, (int) index - 1, res, 0, count);
      return res;
    }
    return null;
  }

  private static final String RESULTSET_WITH_TYPE_MAPPING_NOT_SUPPORTED =
      "Getting a ResultSet with a custom type mapping from an array is not supported";

  @Override
  public ResultSet getResultSet() throws SQLException {
    return getResultSet(1L, Integer.MAX_VALUE);
  }

  @Override
  public ResultSet getResultSet(Map<String, Class<?>> map) throws SQLException {
    throw new SQLFeatureNotSupportedException(RESULTSET_WITH_TYPE_MAPPING_NOT_SUPPORTED);
  }

  @Override
  public ResultSet getResultSet(long startIndex, int count) throws SQLException {
    JdbcPreconditions.checkArgument(
        startIndex + count - 1L <= Integer.MAX_VALUE,
        String.format("End index cannot exceed %d", Integer.MAX_VALUE));
    JdbcPreconditions.checkArgument(startIndex >= 1L, "Start index must be >= 1");
    JdbcPreconditions.checkArgument(count >= 0, "Count must be >= 0");
    checkFree();
    Type spannerTypeForProto = getSpannerTypeForProto();
    Type spannerType =
        spannerTypeForProto == null ? this.type.getSpannerType() : spannerTypeForProto;

    ImmutableList.Builder<Struct> rows = ImmutableList.builder();
    int added = 0;
    if (this.data != null) {
      // Note that array index in JDBC is base-one.
      for (int index = (int) startIndex;
          added < count && index <= ((Object[]) this.data).length;
          index++) {
        Object value = ((Object[]) this.data)[index - 1];
        ValueBinder<Struct.Builder> binder =
            Struct.newBuilder().set("INDEX").to(index).set("VALUE");
        Struct.Builder builder;
        switch (this.type.getCode()) {
          case BOOL:
            builder = binder.to((Boolean) value);
            break;
          case BYTES:
            builder = binder.to(ByteArray.copyFrom((byte[]) value));
            break;
          case PROTO:
            if (value == null && AbstractMessage[].class.isAssignableFrom(this.data.getClass())) {
              builder = binder.to((ByteArray) null, spannerType.getProtoTypeFqn());
            } else if (value instanceof AbstractMessage) {
              builder = binder.to((AbstractMessage) value);
            } else {
              builder = binder.to(value != null ? ByteArray.copyFrom((byte[]) value) : null);
            }
            break;
          case DATE:
            builder = binder.to(JdbcTypeConverter.toGoogleDate((Date) value));
            break;
          case FLOAT32:
            builder = binder.to((Float) value);
            break;
          case FLOAT64:
            builder = binder.to((Double) value);
            break;
          case INT64:
            builder = binder.to((Long) value);
            break;
          case ENUM:
            if (value == null
                && ProtocolMessageEnum[].class.isAssignableFrom(this.data.getClass())) {
              builder = binder.to((Long) null, spannerType.getProtoTypeFqn());
            } else if (value instanceof ProtocolMessageEnum) {
              builder = binder.to((ProtocolMessageEnum) value);
            } else {
              builder = binder.to((Long) value);
            }
            break;
          case NUMERIC:
            builder = binder.to((BigDecimal) value);
            break;
          case STRING:
            builder = binder.to((String) value);
            break;
          case JSON:
            builder = binder.to(Value.json((String) value));
            break;
          case PG_JSONB:
            builder = binder.to(Value.pgJsonb((String) value));
            break;
          case TIMESTAMP:
            builder = binder.to(JdbcTypeConverter.toGoogleTimestamp((Timestamp) value));
            break;
          case ARRAY:
          case STRUCT:
          default:
            throw new SQLFeatureNotSupportedException(
                String.format(
                    "Array of type %s cannot be converted to a ResultSet",
                    this.type.getCode().name()));
        }
        rows.add(builder.build());
        added++;
        if (added == count) {
          break;
        }
      }
    }

    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("INDEX", Type.int64()), StructField.of("VALUE", spannerType)),
            rows.build()));
  }

  // Returns null if the type is not a PROTO or ENUM
  private Type getSpannerTypeForProto() throws SQLException {
    Type spannerType = null;
    if (this.data != null) {
      if (this.type.getCode() == Type.Code.PROTO
          && AbstractMessage[].class.isAssignableFrom(this.data.getClass())) {
        spannerType = createSpannerProtoType();
      } else if (this.type.getCode() == Type.Code.ENUM
          && ProtocolMessageEnum[].class.isAssignableFrom(this.data.getClass())) {
        spannerType = createSpannerProtoEnumType();
      }
    }
    return spannerType;
  }

  private Type createSpannerProtoType() throws SQLException {
    Class<?> componentType = this.data.getClass().getComponentType();
    try {
      Message.Builder builder =
          (Message.Builder) componentType.getMethod("newBuilder").invoke(null);
      Descriptor msgDescriptor = builder.getDescriptorForType();
      return Type.proto(msgDescriptor.getFullName());
    } catch (Exception e) {
      throw JdbcSqlExceptionFactory.of(
          "Error occurred when getting proto message descriptor from data", Code.UNKNOWN, e);
    }
  }

  private Type createSpannerProtoEnumType() throws SQLException {
    Class<?> componentType = this.data.getClass().getComponentType();
    try {
      Descriptors.EnumDescriptor enumDescriptor =
          (Descriptors.EnumDescriptor) componentType.getMethod("getDescriptor").invoke(null);
      return Type.protoEnum(enumDescriptor.getFullName());
    } catch (Exception e) {
      throw JdbcSqlExceptionFactory.of(
          "Error occurred when getting proto enum descriptor from data", Code.UNKNOWN, e);
    }
  }

  @Override
  public ResultSet getResultSet(long index, int count, Map<String, Class<?>> map)
      throws SQLException {
    throw new SQLFeatureNotSupportedException(RESULTSET_WITH_TYPE_MAPPING_NOT_SUPPORTED);
  }

  @Override
  public void free() {
    this.freed = true;
    this.data = null;
  }

  @Override
  public String toString() {
    if (data == null) {
      return "null";
    }
    boolean first = true;
    StringBuilder builder = new StringBuilder("{");
    for (Object o : (Object[]) data) {
      if (!first) {
        builder.append(",");
      }
      first = false;
      if (o == null) {
        builder.append("null");
      } else {
        builder.append(o);
      }
    }
    builder.append("}");
    return builder.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof JdbcArray)) return false;
    JdbcArray array = (JdbcArray) other;
    return this.type == array.type
        && Arrays.deepEquals((Object[]) this.data, (Object[]) array.data);
  }

  @Override
  public int hashCode() {
    return this.type.hashCode() ^ Arrays.deepHashCode((Object[]) data);
  }
}

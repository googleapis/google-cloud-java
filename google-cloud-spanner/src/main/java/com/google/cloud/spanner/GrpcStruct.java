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
import com.google.cloud.Date;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;

import java.util.*;

import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;
import static com.google.common.base.Preconditions.checkArgument;

class GrpcStruct extends Struct {
  private final Type type;
  private final List<Object> rowData;

  GrpcStruct(Type type, List<Object> rowData) {
    this.type = type;
    this.rowData = rowData;
  }

  static com.google.cloud.spanner.Value valueFromTypedProto(com.google.protobuf.Value proto) {
    if (proto.getKindCase() != Value.KindCase.LIST_VALUE && proto.getListValue().getValuesCount()
            != 2) {
      throw new AssertionError("Expected a list of two elements: type and value");
    }
    Type type;
    try {
      type = Type.fromProto(
              com.google.spanner.v1.Type.parseFrom(
                      proto.getListValue().getValues(0).getStringValueBytes()));
    } catch (InvalidProtocolBufferException e) {
      throw new AssertionError("Expected serialized type.");
    }
    return asSpannerValue(type, proto.getListValue().getValues(1));
  }

  static Object fromTypedProto(com.google.protobuf.Value proto) {
    if (proto.getKindCase() != Value.KindCase.LIST_VALUE && proto.getListValue().getValuesCount()
            != 2) {
      throw new AssertionError("Expected a list of two elements: type and value");
    }
    Type type;
    try {
      type = Type.fromProto(
              com.google.spanner.v1.Type.parseFrom(
                      proto.getListValue().getValues(0).getStringValueBytes()));
    } catch (InvalidProtocolBufferException e) {
      throw new AssertionError("Expected serialized type.");
    }
    return decodeValue(type, proto.getListValue().getValues(1));
  }

  static com.google.cloud.spanner.Value asSpannerValue(
          Type fieldType, com.google.protobuf.Value proto) {
    Object value = decodeValue(fieldType, proto);
    switch (fieldType.getCode()) {
      case BOOL:
        return com.google.cloud.spanner.Value.bool((Boolean) value);
      case INT64:
        return com.google.cloud.spanner.Value.int64((Long) value);
      case FLOAT64:
        return com.google.cloud.spanner.Value.float64((Double) value);
      case STRING:
        return com.google.cloud.spanner.Value.string((String) value);
      case BYTES:
        return com.google.cloud.spanner.Value.bytes((ByteArray) value);
      case TIMESTAMP:
        return com.google.cloud.spanner.Value.timestamp(
                (com.google.cloud.Timestamp) value);
      case DATE:
        return com.google.cloud.spanner.Value.date(
                (com.google.cloud.Date) value);
      case ARRAY:
        Type elementType = fieldType.getArrayElementType();
        switch (elementType.getCode()) {
          case BOOL:
            return com.google.cloud.spanner.Value.boolArray((Iterable<Boolean>) value);
          case INT64:
            return com.google.cloud.spanner.Value.int64Array((Iterable<Long>) value);
          case FLOAT64:
            return com.google.cloud.spanner.Value.float64Array((Iterable<Double>) value);
          case STRING:
            return com.google.cloud.spanner.Value.stringArray((Iterable<String>) value);
          case BYTES:
            return com.google.cloud.spanner.Value.bytesArray((Iterable<ByteArray>) value);
          case TIMESTAMP:
            return com.google.cloud.spanner.Value.timestampArray(
                    (Iterable<com.google.cloud.Timestamp>) value);
          case DATE:
            return com.google.cloud.spanner.Value.dateArray(
                    (Iterable<com.google.cloud.Date>) value);

          case STRUCT:
            List<Type.StructField> fields = elementType.getStructFields();
            return com.google.cloud.spanner.Value.structArray(
                    fields, (Iterable<Struct>) value);
          default:
            throw new AssertionError(
                    "Unhandled type code: " + elementType.getCode());
        }
      case STRUCT: // Not a legal top-level field type.
      default:
        throw new AssertionError("Unhandled type code: " + fieldType.getCode());
    }
  }

  static Object decodeValue(Type fieldType, com.google.protobuf.Value proto) {
    if (proto.getKindCase() == Value.KindCase.NULL_VALUE) {
      return null;
    }
    switch (fieldType.getCode()) {
      case BOOL:
        checkType(fieldType, proto, Value.KindCase.BOOL_VALUE);
        return proto.getBoolValue();
      case INT64:
        checkType(fieldType, proto, Value.KindCase.STRING_VALUE);
        return Long.parseLong(proto.getStringValue());
      case FLOAT64:
        return valueProtoToFloat64(proto);
      case STRING:
        checkType(fieldType, proto, Value.KindCase.STRING_VALUE);
        return proto.getStringValue();
      case BYTES:
        checkType(fieldType, proto, Value.KindCase.STRING_VALUE);
        return ByteArray.fromBase64(proto.getStringValue());
      case TIMESTAMP:
        checkType(fieldType, proto, Value.KindCase.STRING_VALUE);
        return com.google.cloud.Timestamp.parseTimestamp(proto.getStringValue());
      case DATE:
        checkType(fieldType, proto, Value.KindCase.STRING_VALUE);
        return Date.parseDate(proto.getStringValue());
      case ARRAY:
        checkType(fieldType, proto, Value.KindCase.LIST_VALUE);
        ListValue listValue = proto.getListValue();
        return decodeArrayValue(fieldType.getArrayElementType(), listValue);
      case STRUCT: // Not a legal top-level field type.
      default:
        throw new AssertionError("Unhandled type code: " + fieldType.getCode());
    }
  }

  private static Object decodeArrayValue(Type elementType, ListValue listValue) {
    switch (elementType.getCode()) {
      case BOOL:
        // Use a view: element conversion is virtually free.
        return Lists.transform(
            listValue.getValuesList(),
            new Function<Value, Boolean>() {
              @Override
              public Boolean apply(Value input) {
                return input.getKindCase() == Value.KindCase.NULL_VALUE
                    ? null
                    : input.getBoolValue();
              }
            });
      case INT64:
        // For int64/float64 types, use custom containers.  These avoid wrapper object
        // creation for non-null arrays.
        return new Int64Array(listValue);
      case FLOAT64:
        return new Float64Array(listValue);
      case STRING:
        return Lists.transform(
            listValue.getValuesList(),
            new Function<Value, String>() {
              @Override
              public String apply(Value input) {
                return input.getKindCase() == Value.KindCase.NULL_VALUE
                    ? null
                    : input.getStringValue();
              }
            });
      case BYTES:
        {
          // Materialize list: element conversion is expensive and should happen only once.
          ArrayList<ByteArray> list = new ArrayList<>(listValue.getValuesCount());
          for (Value value : listValue.getValuesList()) {
            list.add(
                value.getKindCase() == Value.KindCase.NULL_VALUE
                    ? null
                    : ByteArray.fromBase64(value.getStringValue()));
          }
          return list;
        }
      case TIMESTAMP:
        {
          // Materialize list: element conversion is expensive and should happen only once.
          ArrayList<com.google.cloud.Timestamp> list = new ArrayList<>(listValue.getValuesCount());
          for (Value value : listValue.getValuesList()) {
            list.add(
                value.getKindCase() == Value.KindCase.NULL_VALUE
                    ? null
                    : com.google.cloud.Timestamp.parseTimestamp(value.getStringValue()));
          }
          return list;
        }
      case DATE:
        {
          // Materialize list: element conversion is expensive and should happen only once.
          ArrayList<Date> list = new ArrayList<>(listValue.getValuesCount());
          for (Value value : listValue.getValuesList()) {
            list.add(
                value.getKindCase() == Value.KindCase.NULL_VALUE
                    ? null
                    : Date.parseDate(value.getStringValue()));
          }
          return list;
        }

      case STRUCT:
        {
          ArrayList<Struct> list = new ArrayList<>(listValue.getValuesCount());
          for (Value value : listValue.getValuesList()) {
            if (value.getKindCase() == Value.KindCase.NULL_VALUE) {
              list.add(null);
            } else {
              List<Type.StructField> fieldTypes = elementType.getStructFields();
              List<Object> fields = new ArrayList<>(fieldTypes.size());
              ListValue structValues = value.getListValue();
              checkArgument(
                  structValues.getValuesCount() == fieldTypes.size(),
                  "Size mismatch between type descriptor and actual values.");
              for (int i = 0; i < fieldTypes.size(); ++i) {
                fields.add(decodeValue(fieldTypes.get(i).getType(), structValues.getValues(i)));
              }
              list.add(new GrpcStruct(elementType, fields));
            }
          }
          return list;
        }
      default:
        throw new AssertionError("Unhandled type code: " + elementType.getCode());
    }
  }

  private static void checkType(Type fieldType, Value proto, Value.KindCase expected) {
    if (proto.getKindCase() != expected) {
      throw newSpannerException(
          ErrorCode.INTERNAL,
          "Invalid value for column type "
              + fieldType
              + " expected "
              + expected
              + " but was "
              + proto.getKindCase());
    }
  }

  private static double valueProtoToFloat64(com.google.protobuf.Value proto) {
    if (proto.getKindCase() == Value.KindCase.STRING_VALUE) {
      switch (proto.getStringValue()) {
        case "-Infinity":
          return Double.NEGATIVE_INFINITY;
        case "Infinity":
          return Double.POSITIVE_INFINITY;
        case "NaN":
          return Double.NaN;
        default:
          // Fall-through to handling below to produce an error.
      }
    }
    if (proto.getKindCase() != Value.KindCase.NUMBER_VALUE) {
      throw newSpannerException(
          ErrorCode.INTERNAL,
          "Invalid value for column type "
              + Type.float64()
              + " expected NUMBER_VALUE or STRING_VALUE with value one of"
              + " \"Infinity\", \"-Infinity\", or \"NaN\" but was "
              + proto.getKindCase()
              + (proto.getKindCase() == Value.KindCase.STRING_VALUE
                  ? " with value \"" + proto.getStringValue() + "\""
                  : ""));
    }
    return proto.getNumberValue();
  }

  private static NullPointerException throwNotNull(int columnIndex) {
    throw new NullPointerException(
        "Cannot call array getter for column " + columnIndex + " with null elements");
  }

  boolean consumeRow(Iterator<com.google.protobuf.Value> iterator) {
    rowData.clear();
    if (!iterator.hasNext()) {
      return false;
    }
    for (Type.StructField fieldType : getType().getStructFields()) {
      if (!iterator.hasNext()) {
        throw newSpannerException(
            ErrorCode.INTERNAL,
            "Invalid value stream: end of stream reached before row is complete");
      }
      com.google.protobuf.Value value = iterator.next();
      rowData.add(decodeValue(fieldType.getType(), value));
    }
    return true;
  }

  Struct immutableCopy() {
    return new GrpcStruct(type, new ArrayList<>(rowData));
  }

  @Override
  public Type getType() {
    return type;
  }

  @Override
  public boolean isNull(int columnIndex) {
    return rowData.get(columnIndex) == null;
  }

  @Override
  protected boolean getBooleanInternal(int columnIndex) {
    return (Boolean) rowData.get(columnIndex);
  }

  @Override
  protected long getLongInternal(int columnIndex) {
    return (Long) rowData.get(columnIndex);
  }

  @Override
  protected double getDoubleInternal(int columnIndex) {
    return (Double) rowData.get(columnIndex);
  }

  @Override
  protected String getStringInternal(int columnIndex) {
    return (String) rowData.get(columnIndex);
  }

  @Override
  protected ByteArray getBytesInternal(int columnIndex) {
    return (ByteArray) rowData.get(columnIndex);
  }

  @Override
  protected com.google.cloud.Timestamp getTimestampInternal(int columnIndex) {
    return (com.google.cloud.Timestamp) rowData.get(columnIndex);
  }

  @Override
  protected Date getDateInternal(int columnIndex) {
    return (Date) rowData.get(columnIndex);
  }

  @Override
  protected boolean[] getBooleanArrayInternal(int columnIndex) {
    @SuppressWarnings("unchecked") // We know ARRAY<BOOL> produces a List<Boolean>.
    List<Boolean> values = (List<Boolean>) rowData.get(columnIndex);
    boolean[] r = new boolean[values.size()];
    for (int i = 0; i < values.size(); ++i) {
      if (values.get(i) == null) {
        throw throwNotNull(columnIndex);
      }
      r[i] = values.get(i);
    }
    return r;
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<BOOL> produces a List<Boolean>.
  protected List<Boolean> getBooleanListInternal(int columnIndex) {
    return Collections.unmodifiableList((List<Boolean>) rowData.get(columnIndex));
  }

  @Override
  protected long[] getLongArrayInternal(int columnIndex) {
    return getLongListInternal(columnIndex).toPrimitiveArray(columnIndex);
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<INT64> produces an Int64Array.
  protected Int64Array getLongListInternal(int columnIndex) {
    return (Int64Array) rowData.get(columnIndex);
  }

  @Override
  protected double[] getDoubleArrayInternal(int columnIndex) {
    return getDoubleListInternal(columnIndex).toPrimitiveArray(columnIndex);
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<FLOAT64> produces a Float64Array.
  protected Float64Array getDoubleListInternal(int columnIndex) {
    return (Float64Array) rowData.get(columnIndex);
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<STRING> produces a List<String>.
  protected List<String> getStringListInternal(int columnIndex) {
    return Collections.unmodifiableList((List<String>) rowData.get(columnIndex));
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<BYTES> produces a List<ByteArray>.
  protected List<ByteArray> getBytesListInternal(int columnIndex) {
    return Collections.unmodifiableList((List<ByteArray>) rowData.get(columnIndex));
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<TIMESTAMP> produces a List<Timestamp>.
  protected List<com.google.cloud.Timestamp> getTimestampListInternal(int columnIndex) {
    return Collections.unmodifiableList(
        (List<com.google.cloud.Timestamp>) rowData.get(columnIndex));
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<DATE> produces a List<Date>.
  protected List<Date> getDateListInternal(int columnIndex) {
    return Collections.unmodifiableList((List<Date>) rowData.get(columnIndex));
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<STRUCT<...>> produces a List<STRUCT>.
  protected List<Struct> getStructListInternal(int columnIndex) {
    return Collections.unmodifiableList((List<Struct>) rowData.get(columnIndex));
  }

  /**
   * Memory-optimized base class for {@code ARRAY<INT64>} and {@code ARRAY<FLOAT64>} types. Both of
   * these involve conversions from the type yielded by JSON parsing, which are {@code String} and
   * {@code BigDecimal} respectively. Rather than construct new wrapper objects for each array
   * element, we use primitive arrays and a {@code BitSet} to track nulls.
   */
  private abstract static class PrimitiveArray<T, A> extends AbstractList<T> {
    private final A data;
    private final BitSet nulls;
    private final int size;

    PrimitiveArray(ListValue protoList) {
      this.size = protoList.getValuesCount();
      A data = newArray(size);
      BitSet nulls = new BitSet(size);
      for (int i = 0; i < protoList.getValuesCount(); ++i) {
        if (protoList.getValues(i).getKindCase() == Value.KindCase.NULL_VALUE) {
          nulls.set(i);
        } else {
          setProto(data, i, protoList.getValues(i));
        }
      }
      this.data = data;
      this.nulls = nulls;
    }

    PrimitiveArray(A data, BitSet nulls, int size) {
      this.data = data;
      this.nulls = nulls;
      this.size = size;
    }

    abstract A newArray(int size);

    abstract void setProto(A array, int i, com.google.protobuf.Value protoValue);

    abstract T get(A array, int i);

    @Override
    public T get(int index) {
      if (index < 0 || index >= size) {
        throw new ArrayIndexOutOfBoundsException("index=" + index + " size=" + size);
      }
      return nulls.get(index) ? null : get(data, index);
    }

    @Override
    public int size() {
      return size;
    }

    A toPrimitiveArray(int columnIndex) {
      if (nulls.length() > 0) {
        throw throwNotNull(columnIndex);
      }
      A r = newArray(size);
      System.arraycopy(data, 0, r, 0, size);
      return r;
    }
  }

  private static class Int64Array extends PrimitiveArray<Long, long[]> {
    Int64Array(ListValue protoList) {
      super(protoList);
    }

    Int64Array(long[] data, BitSet nulls) {
      super(data, nulls, data.length);
    }

    @Override
    long[] newArray(int size) {
      return new long[size];
    }

    @Override
    void setProto(long[] array, int i, com.google.protobuf.Value protoValue) {
      array[i] = Long.parseLong(protoValue.getStringValue());
    }

    @Override
    Long get(long[] array, int i) {
      return array[i];
    }
  }

  private static class Float64Array extends PrimitiveArray<Double, double[]> {
    Float64Array(ListValue protoList) {
      super(protoList);
    }

    Float64Array(double[] data, BitSet nulls) {
      super(data, nulls, data.length);
    }

    @Override
    double[] newArray(int size) {
      return new double[size];
    }

    @Override
    void setProto(double[] array, int i, com.google.protobuf.Value protoValue) {
      array[i] = valueProtoToFloat64(protoValue);
    }

    @Override
    Double get(double[] array, int i) {
      return array[i];
    }
  }
}

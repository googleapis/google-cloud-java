/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.spanner.AbstractResultSet.throwNotNull;
import static com.google.cloud.spanner.AbstractResultSet.valueProtoToFloat32;
import static com.google.cloud.spanner.AbstractResultSet.valueProtoToFloat64;
import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbstractResultSet.Float32Array;
import com.google.cloud.spanner.AbstractResultSet.Float64Array;
import com.google.cloud.spanner.AbstractResultSet.Int64Array;
import com.google.cloud.spanner.AbstractResultSet.LazyByteArray;
import com.google.cloud.spanner.Type.Code;
import com.google.cloud.spanner.Type.StructField;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.io.CharSource;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.Value.KindCase;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Collectors;

class GrpcStruct extends Struct implements Serializable {
  private static final com.google.protobuf.Value NULL_VALUE =
      com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();

  private final Type type;
  private final List<Object> rowData;
  private final DecodeMode decodeMode;
  private final BitSet colDecoded;
  private final AtomicBoolean rowDecoded;

  /**
   * Builds an immutable version of this struct using {@link Struct#newBuilder()} which is used as a
   * serialization proxy.
   */
  private Object writeReplace() {
    Builder builder = Struct.newBuilder();
    List<Type.StructField> structFields = getType().getStructFields();
    for (int i = 0; i < structFields.size(); i++) {
      Type.StructField field = structFields.get(i);
      String fieldName = field.getName();
      ensureDecoded(i);
      Object value = rowData.get(i);
      Type fieldType = field.getType();
      switch (fieldType.getCode()) {
        case BOOL:
          builder.set(fieldName).to((Boolean) value);
          break;
        case INT64:
          builder.set(fieldName).to((Long) value);
          break;
        case FLOAT64:
          builder.set(fieldName).to((Double) value);
          break;
        case FLOAT32:
          builder.set(fieldName).to((Float) value);
          break;
        case NUMERIC:
          builder.set(fieldName).to((BigDecimal) value);
          break;
        case PG_NUMERIC:
          builder.set(fieldName).to((String) value);
          break;
        case STRING:
          builder.set(fieldName).to((String) value);
          break;
        case JSON:
          builder.set(fieldName).to(Value.json((String) value));
          break;
        case PROTO:
          builder
              .set(fieldName)
              .to(
                  Value.protoMessage(
                      value == null ? null : ((LazyByteArray) value).getByteArray(),
                      fieldType.getProtoTypeFqn()));
          break;
        case ENUM:
          builder.set(fieldName).to(Value.protoEnum((Long) value, fieldType.getProtoTypeFqn()));
          break;
        case PG_JSONB:
          builder.set(fieldName).to(Value.pgJsonb((String) value));
          break;
        case PG_OID:
          builder.set(fieldName).to(Value.pgOid((Long) value));
          break;
        case BYTES:
          builder
              .set(fieldName)
              .to(
                  Value.bytesFromBase64(
                      value == null ? null : ((LazyByteArray) value).getBase64String()));
          break;
        case TIMESTAMP:
          builder.set(fieldName).to((Timestamp) value);
          break;
        case DATE:
          builder.set(fieldName).to((Date) value);
          break;
        case UUID:
          builder.set(fieldName).to((UUID) value);
          break;
        case INTERVAL:
          builder.set(fieldName).to((Interval) value);
          break;
        case ARRAY:
          final Type elementType = fieldType.getArrayElementType();
          switch (elementType.getCode()) {
            case BOOL:
              builder.set(fieldName).toBoolArray((Iterable<Boolean>) value);
              break;
            case INT64:
            case ENUM:
              builder.set(fieldName).toInt64Array((Iterable<Long>) value);
              break;
            case FLOAT64:
              builder.set(fieldName).toFloat64Array((Iterable<Double>) value);
              break;
            case FLOAT32:
              builder.set(fieldName).toFloat32Array((Iterable<Float>) value);
              break;
            case NUMERIC:
              builder.set(fieldName).toNumericArray((Iterable<BigDecimal>) value);
              break;
            case PG_NUMERIC:
              builder.set(fieldName).toPgNumericArray((Iterable<String>) value);
              break;
            case STRING:
              builder.set(fieldName).toStringArray((Iterable<String>) value);
              break;
            case JSON:
              builder.set(fieldName).toJsonArray((Iterable<String>) value);
              break;
            case PG_JSONB:
              builder.set(fieldName).toPgJsonbArray((Iterable<String>) value);
              break;
            case PG_OID:
              builder.set(fieldName).toPgOidArray((Iterable<Long>) value);
              break;
            case BYTES:
            case PROTO:
              builder
                  .set(fieldName)
                  .toBytesArrayFromBase64(
                      value == null
                          ? null
                          : ((List<LazyByteArray>) value)
                              .stream()
                                  .map(
                                      element -> element == null ? null : element.getBase64String())
                                  .collect(Collectors.toList()));
              break;
            case TIMESTAMP:
              builder.set(fieldName).toTimestampArray((Iterable<Timestamp>) value);
              break;
            case DATE:
              builder.set(fieldName).toDateArray((Iterable<Date>) value);
              break;
            case UUID:
              builder.set(fieldName).toUuidArray((Iterable<UUID>) value);
              break;
            case INTERVAL:
              builder.set(fieldName).toIntervalArray((Iterable<Interval>) value);
              break;
            case STRUCT:
              builder.set(fieldName).toStructArray(elementType, (Iterable<Struct>) value);
              break;
            default:
              throw new AssertionError("Unhandled array type code: " + elementType);
          }
          break;
        case STRUCT:
          if (value == null) {
            builder.set(fieldName).to(fieldType, null);
          } else {
            builder.set(fieldName).to((Struct) value);
          }
          break;
        default:
          throw new AssertionError("Unhandled type code: " + fieldType.getCode());
      }
    }
    return builder.build();
  }

  GrpcStruct(Type type, List<Object> rowData, DecodeMode decodeMode) {
    this(
        type,
        rowData,
        decodeMode,
        /* rowDecoded= */ false,
        /* colDecoded= */ decodeMode == DecodeMode.LAZY_PER_COL
            ? new BitSet(type.getStructFields().size())
            : null);
  }

  private GrpcStruct(
      Type type,
      List<Object> rowData,
      DecodeMode decodeMode,
      boolean rowDecoded,
      BitSet colDecoded) {
    this.type = type;
    this.rowData = rowData;
    this.decodeMode = decodeMode;
    this.rowDecoded = new AtomicBoolean(rowDecoded);
    this.colDecoded = colDecoded;
  }

  @Override
  public String toString() {
    return this.rowData.toString();
  }

  boolean consumeRow(Iterator<com.google.protobuf.Value> iterator) {
    synchronized (rowData) {
      rowData.clear();
      if (decodeMode == DecodeMode.LAZY_PER_ROW) {
        rowDecoded.set(false);
      } else if (decodeMode == DecodeMode.LAZY_PER_COL) {
        colDecoded.clear();
      }
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
        if (decodeMode == DecodeMode.DIRECT) {
          rowData.add(decodeValue(fieldType.getType(), value));
        } else {
          rowData.add(value);
        }
      }
      return true;
    }
  }

  private static Object decodeValue(Type fieldType, com.google.protobuf.Value proto) {
    if (proto.getKindCase() == KindCase.NULL_VALUE) {
      return null;
    }
    switch (fieldType.getCode()) {
      case BOOL:
        checkType(fieldType, proto, KindCase.BOOL_VALUE);
        return proto.getBoolValue();
      case INT64:
      case PG_OID:
      case ENUM:
        checkType(fieldType, proto, KindCase.STRING_VALUE);
        return Long.parseLong(proto.getStringValue());
      case FLOAT64:
        return valueProtoToFloat64(proto);
      case FLOAT32:
        return valueProtoToFloat32(proto);
      case NUMERIC:
        checkType(fieldType, proto, KindCase.STRING_VALUE);
        return new BigDecimal(proto.getStringValue());
      case PG_NUMERIC:
      case STRING:
      case JSON:
      case PG_JSONB:
        checkType(fieldType, proto, KindCase.STRING_VALUE);
        return proto.getStringValue();
      case BYTES:
      case PROTO:
        checkType(fieldType, proto, KindCase.STRING_VALUE);
        return new LazyByteArray(proto.getStringValue());
      case TIMESTAMP:
        checkType(fieldType, proto, KindCase.STRING_VALUE);
        return Timestamp.parseTimestamp(proto.getStringValue());
      case DATE:
        checkType(fieldType, proto, KindCase.STRING_VALUE);
        return Date.parseDate(proto.getStringValue());
      case UUID:
        checkType(fieldType, proto, KindCase.STRING_VALUE);
        return UUID.fromString(proto.getStringValue());
      case INTERVAL:
        checkType(fieldType, proto, KindCase.STRING_VALUE);
        return Interval.parseFromString(proto.getStringValue());
      case ARRAY:
        checkType(fieldType, proto, KindCase.LIST_VALUE);
        ListValue listValue = proto.getListValue();
        return decodeArrayValue(fieldType.getArrayElementType(), listValue);
      case STRUCT:
        checkType(fieldType, proto, KindCase.LIST_VALUE);
        ListValue structValue = proto.getListValue();
        return decodeStructValue(fieldType, structValue);
      case UNRECOGNIZED:
        return proto;
      default:
        throw new AssertionError("Unhandled type code: " + fieldType.getCode());
    }
  }

  private static Struct decodeStructValue(Type structType, ListValue structValue) {
    List<Type.StructField> fieldTypes = structType.getStructFields();
    checkArgument(
        structValue.getValuesCount() == fieldTypes.size(),
        "Size mismatch between type descriptor and actual values.");
    List<Object> fields = new ArrayList<>(fieldTypes.size());
    List<com.google.protobuf.Value> fieldValues = structValue.getValuesList();
    for (int i = 0; i < fieldTypes.size(); ++i) {
      fields.add(decodeValue(fieldTypes.get(i).getType(), fieldValues.get(i)));
    }
    return new GrpcStruct(structType, fields, DecodeMode.DIRECT);
  }

  static Object decodeArrayValue(Type elementType, ListValue listValue) {
    switch (elementType.getCode()) {
      case INT64:
      case PG_OID:
      case ENUM:
        // For int64/float64/float32/enum types, use custom containers.
        // These avoid wrapper object creation for non-null arrays.
        return new Int64Array(listValue);
      case FLOAT64:
        return new Float64Array(listValue);
      case FLOAT32:
        return new Float32Array(listValue);
      case BOOL:
      case NUMERIC:
      case PG_NUMERIC:
      case STRING:
      case JSON:
      case PG_JSONB:
      case BYTES:
      case TIMESTAMP:
      case DATE:
      case UUID:
      case INTERVAL:
      case STRUCT:
      case PROTO:
        return Lists.transform(listValue.getValuesList(), input -> decodeValue(elementType, input));
      default:
        throw new AssertionError("Unhandled type code: " + elementType.getCode());
    }
  }

  private static void checkType(
      Type fieldType, com.google.protobuf.Value proto, KindCase expected) {
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

  Struct immutableCopy() {
    synchronized (rowData) {
      return new GrpcStruct(
          type,
          this.decodeMode == DecodeMode.DIRECT
              ? new ArrayList<>(rowData)
              : Collections.synchronizedList(new ArrayList<>(rowData)),
          this.decodeMode,
          this.rowDecoded.get(),
          this.colDecoded == null ? null : (BitSet) this.colDecoded.clone());
    }
  }

  @Override
  public Type getType() {
    return type;
  }

  @Override
  public boolean isNull(int columnIndex) {
    if (decodeMode == DecodeMode.LAZY_PER_ROW || decodeMode == DecodeMode.LAZY_PER_COL) {
      synchronized (rowData) {
        if ((decodeMode == DecodeMode.LAZY_PER_ROW && !rowDecoded.get())
            || (decodeMode == DecodeMode.LAZY_PER_COL && !colDecoded.get(columnIndex))) {
          return ((com.google.protobuf.Value) rowData.get(columnIndex)).hasNullValue();
        }
        return rowData.get(columnIndex) == null;
      }
    }
    return rowData.get(columnIndex) == null;
  }

  @Override
  protected <T extends AbstractMessage> T getProtoMessageInternal(int columnIndex, T message) {
    Preconditions.checkNotNull(
        message,
        "Proto message may not be null. Use MyProtoClass.getDefaultInstance() as a parameter"
            + " value.");
    ensureDecoded(columnIndex);
    try {
      return (T)
          message.toBuilder()
              .mergeFrom(
                  Base64.getDecoder()
                      .wrap(
                          CharSource.wrap(
                                  ((LazyByteArray) rowData.get(columnIndex)).getBase64String())
                              .asByteSource(StandardCharsets.UTF_8)
                              .openStream()))
              .build();
    } catch (IOException ioException) {
      throw SpannerExceptionFactory.asSpannerException(ioException);
    }
  }

  @Override
  protected <T extends ProtocolMessageEnum> T getProtoEnumInternal(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    Preconditions.checkNotNull(
        method, "Method may not be null. Use 'MyProtoEnum::forNumber' as a parameter value.");
    return (T) method.apply((int) getLongInternal(columnIndex));
  }

  @Override
  protected boolean getBooleanInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (Boolean) rowData.get(columnIndex);
  }

  @Override
  protected long getLongInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (Long) rowData.get(columnIndex);
  }

  @Override
  protected double getDoubleInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (Double) rowData.get(columnIndex);
  }

  @Override
  protected float getFloatInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (Float) rowData.get(columnIndex);
  }

  @Override
  protected BigDecimal getBigDecimalInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (BigDecimal) rowData.get(columnIndex);
  }

  @Override
  protected String getStringInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (String) rowData.get(columnIndex);
  }

  @Override
  protected String getJsonInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (String) rowData.get(columnIndex);
  }

  @Override
  protected String getPgJsonbInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (String) rowData.get(columnIndex);
  }

  @Override
  protected ByteArray getBytesInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return getLazyBytesInternal(columnIndex).getByteArray();
  }

  LazyByteArray getLazyBytesInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (LazyByteArray) rowData.get(columnIndex);
  }

  @Override
  protected Timestamp getTimestampInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (Timestamp) rowData.get(columnIndex);
  }

  @Override
  protected Date getDateInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (Date) rowData.get(columnIndex);
  }

  @Override
  protected UUID getUuidInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (UUID) rowData.get(columnIndex);
  }

  @Override
  protected Interval getIntervalInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (Interval) rowData.get(columnIndex);
  }

  private boolean isUnrecognizedType(int columnIndex) {
    return type.getStructFields().get(columnIndex).getType().getCode() == Code.UNRECOGNIZED;
  }

  boolean canGetProtoValue(int columnIndex) {
    synchronized (rowData) {
      return isUnrecognizedType(columnIndex)
          || (decodeMode == DecodeMode.LAZY_PER_ROW && !rowDecoded.get())
          || (decodeMode == DecodeMode.LAZY_PER_COL && !colDecoded.get(columnIndex));
    }
  }

  protected com.google.protobuf.Value getProtoValueInternal(int columnIndex) {
    synchronized (rowData) {
      checkProtoValueSupported(columnIndex);
      return (com.google.protobuf.Value) rowData.get(columnIndex);
    }
  }

  private void checkProtoValueSupported(int columnIndex) {
    // Unrecognized types are returned as protobuf values.
    if (isUnrecognizedType(columnIndex)) {
      return;
    }
    Preconditions.checkState(
        decodeMode != DecodeMode.DIRECT,
        "Getting proto value is not supported when DecodeMode#DIRECT is used.");
    Preconditions.checkState(
        !(decodeMode == DecodeMode.LAZY_PER_ROW && rowDecoded.get()),
        "Getting proto value after the row has been decoded is not supported.");
    Preconditions.checkState(
        !(decodeMode == DecodeMode.LAZY_PER_COL && colDecoded.get(columnIndex)),
        "Getting proto value after the column has been decoded is not supported.");
  }

  private void ensureDecoded(int columnIndex) {
    if (decodeMode == DecodeMode.LAZY_PER_ROW) {
      synchronized (rowData) {
        if (!rowDecoded.get()) {
          for (int i = 0; i < rowData.size(); i++) {
            rowData.set(
                i,
                decodeValue(
                    type.getStructFields().get(i).getType(),
                    (com.google.protobuf.Value) rowData.get(i)));
          }
        }
        rowDecoded.set(true);
      }
    } else if (decodeMode == DecodeMode.LAZY_PER_COL) {
      boolean decoded;
      Object value;
      synchronized (rowData) {
        decoded = colDecoded.get(columnIndex);
        value = rowData.get(columnIndex);
      }
      if (!decoded) {
        // Use the column as a lock during decoding to ensure that we decode once (mostly), but also
        // that multiple different columns can be decoded in parallel if requested.
        synchronized (type.getStructFields().get(columnIndex)) {
          // Note: It can be that we decode the value twice if two threads request this at the same
          // time, but the synchronization on rowData above and below makes sure that we always get
          // and set a consistent value (and only set it once).
          if (!colDecoded.get(columnIndex)) {
            value =
                decodeValue(
                    type.getStructFields().get(columnIndex).getType(),
                    (com.google.protobuf.Value) value);
            decoded = true;
          }
        }
        if (decoded) {
          synchronized (rowData) {
            rowData.set(columnIndex, value);
            colDecoded.set(columnIndex);
          }
        }
      }
    }
  }

  @Override
  protected Value getValueInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    final List<Type.StructField> structFields = getType().getStructFields();
    final StructField structField = structFields.get(columnIndex);
    final Type columnType = structField.getType();
    final boolean isNull = rowData.get(columnIndex) == null;
    switch (columnType.getCode()) {
      case BOOL:
        return Value.bool(isNull ? null : getBooleanInternal(columnIndex));
      case INT64:
        return Value.int64(isNull ? null : getLongInternal(columnIndex));
      case ENUM:
        return Value.protoEnum(
            isNull ? null : getLongInternal(columnIndex), columnType.getProtoTypeFqn());
      case NUMERIC:
        return Value.numeric(isNull ? null : getBigDecimalInternal(columnIndex));
      case PG_NUMERIC:
        return Value.pgNumeric(isNull ? null : getStringInternal(columnIndex));
      case FLOAT64:
        return Value.float64(isNull ? null : getDoubleInternal(columnIndex));
      case FLOAT32:
        return Value.float32(isNull ? null : getFloatInternal(columnIndex));
      case STRING:
        return Value.string(isNull ? null : getStringInternal(columnIndex));
      case JSON:
        return Value.json(isNull ? null : getJsonInternal(columnIndex));
      case PG_JSONB:
        return Value.pgJsonb(isNull ? null : getPgJsonbInternal(columnIndex));
      case PG_OID:
        return Value.pgOid(isNull ? null : getLongInternal(columnIndex));
      case BYTES:
        return Value.internalBytes(isNull ? null : getLazyBytesInternal(columnIndex));
      case PROTO:
        return Value.protoMessage(
            isNull ? null : getBytesInternal(columnIndex), columnType.getProtoTypeFqn());
      case TIMESTAMP:
        return Value.timestamp(isNull ? null : getTimestampInternal(columnIndex));
      case DATE:
        return Value.date(isNull ? null : getDateInternal(columnIndex));
      case UUID:
        return Value.uuid(isNull ? null : getUuidInternal(columnIndex));
      case INTERVAL:
        return Value.interval(isNull ? null : getIntervalInternal(columnIndex));
      case STRUCT:
        return Value.struct(isNull ? null : getStructInternal(columnIndex));
      case UNRECOGNIZED:
        return Value.unrecognized(
            isNull ? NULL_VALUE : getProtoValueInternal(columnIndex), columnType);
      case ARRAY:
        final Type elementType = columnType.getArrayElementType();
        switch (elementType.getCode()) {
          case BOOL:
            return Value.boolArray(isNull ? null : getBooleanListInternal(columnIndex));
          case INT64:
            return Value.int64Array(isNull ? null : getLongListInternal(columnIndex));
          case NUMERIC:
            return Value.numericArray(isNull ? null : getBigDecimalListInternal(columnIndex));
          case PG_NUMERIC:
            return Value.pgNumericArray(isNull ? null : getStringListInternal(columnIndex));
          case FLOAT64:
            return Value.float64Array(isNull ? null : getDoubleListInternal(columnIndex));
          case FLOAT32:
            return Value.float32Array(isNull ? null : getFloatListInternal(columnIndex));
          case STRING:
            return Value.stringArray(isNull ? null : getStringListInternal(columnIndex));
          case JSON:
            return Value.jsonArray(isNull ? null : getJsonListInternal(columnIndex));
          case PG_JSONB:
            return Value.pgJsonbArray(isNull ? null : getPgJsonbListInternal(columnIndex));
          case PG_OID:
            return Value.pgOidArray(isNull ? null : getLongListInternal(columnIndex));
          case BYTES:
            return Value.bytesArray(isNull ? null : getBytesListInternal(columnIndex));
          case PROTO:
            return Value.protoMessageArray(
                isNull ? null : getBytesListInternal(columnIndex), elementType.getProtoTypeFqn());
          case ENUM:
            return Value.protoEnumArray(
                isNull ? null : getLongListInternal(columnIndex), elementType.getProtoTypeFqn());
          case TIMESTAMP:
            return Value.timestampArray(isNull ? null : getTimestampListInternal(columnIndex));
          case DATE:
            return Value.dateArray(isNull ? null : getDateListInternal(columnIndex));
          case UUID:
            return Value.uuidArray(isNull ? null : getUuidListInternal(columnIndex));
          case INTERVAL:
            return Value.intervalArray(isNull ? null : getIntervalListInternal(columnIndex));
          case STRUCT:
            return Value.structArray(
                elementType, isNull ? null : getStructListInternal(columnIndex));
          default:
            throw new IllegalArgumentException(
                "Invalid array value type " + this.type.getArrayElementType());
        }
      default:
        throw new IllegalArgumentException("Invalid value type " + this.type);
    }
  }

  @Override
  protected Struct getStructInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (Struct) rowData.get(columnIndex);
  }

  @Override
  protected boolean[] getBooleanArrayInternal(int columnIndex) {
    ensureDecoded(columnIndex);
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
    ensureDecoded(columnIndex);
    return Collections.unmodifiableList((List<Boolean>) rowData.get(columnIndex));
  }

  @Override
  protected long[] getLongArrayInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return getLongListInternal(columnIndex).toPrimitiveArray(columnIndex);
  }

  @Override
  protected Int64Array getLongListInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (Int64Array) rowData.get(columnIndex);
  }

  @Override
  protected double[] getDoubleArrayInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return getDoubleListInternal(columnIndex).toPrimitiveArray(columnIndex);
  }

  @Override
  protected Float64Array getDoubleListInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (Float64Array) rowData.get(columnIndex);
  }

  @Override
  protected float[] getFloatArrayInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return getFloatListInternal(columnIndex).toPrimitiveArray(columnIndex);
  }

  @Override
  protected Float32Array getFloatListInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (Float32Array) rowData.get(columnIndex);
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<NUMERIC> produces a List<BigDecimal>.
  protected List<BigDecimal> getBigDecimalListInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return (List<BigDecimal>) rowData.get(columnIndex);
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<STRING> produces a List<String>.
  protected List<String> getStringListInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return Collections.unmodifiableList((List<String>) rowData.get(columnIndex));
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<JSON> produces a List<String>.
  protected List<String> getJsonListInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return Collections.unmodifiableList((List<String>) rowData.get(columnIndex));
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<PROTO> produces a List<ByteArray>.
  protected <T extends AbstractMessage> List<T> getProtoMessageListInternal(
      int columnIndex, T message) {
    Preconditions.checkNotNull(
        message,
        "Proto message may not be null. Use MyProtoClass.getDefaultInstance() as a parameter"
            + " value.");
    ensureDecoded(columnIndex);

    List<LazyByteArray> bytesArray = (List<LazyByteArray>) rowData.get(columnIndex);

    try {
      List<T> protoMessagesList = new ArrayList<>(bytesArray.size());
      for (LazyByteArray protoMessageBytes : bytesArray) {
        if (protoMessageBytes == null) {
          protoMessagesList.add(null);
        } else {
          protoMessagesList.add(
              (T)
                  message.toBuilder()
                      .mergeFrom(
                          Base64.getDecoder()
                              .wrap(
                                  CharSource.wrap(protoMessageBytes.getBase64String())
                                      .asByteSource(StandardCharsets.UTF_8)
                                      .openStream()))
                      .build());
        }
      }
      return protoMessagesList;
    } catch (IOException ioException) {
      throw SpannerExceptionFactory.asSpannerException(ioException);
    }
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<ENUM> produces a List<Long>.
  protected <T extends ProtocolMessageEnum> List<T> getProtoEnumListInternal(
      int columnIndex, Function<Integer, ProtocolMessageEnum> method) {
    Preconditions.checkNotNull(
        method, "Method may not be null. Use 'MyProtoEnum::forNumber' as a parameter value.");
    ensureDecoded(columnIndex);

    List<Long> enumIntArray = (List<Long>) rowData.get(columnIndex);
    List<T> protoEnumList = new ArrayList<>(enumIntArray.size());
    for (Long enumIntValue : enumIntArray) {
      if (enumIntValue == null) {
        protoEnumList.add(null);
      } else {
        protoEnumList.add((T) method.apply(enumIntValue.intValue()));
      }
    }

    return protoEnumList;
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<JSONB> produces a List<String>.
  protected List<String> getPgJsonbListInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return Collections.unmodifiableList((List<String>) rowData.get(columnIndex));
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<BYTES> produces a List<LazyByteArray>.
  protected List<ByteArray> getBytesListInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return Lists.transform(
        (List<LazyByteArray>) rowData.get(columnIndex), l -> l == null ? null : l.getByteArray());
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<TIMESTAMP> produces a List<Timestamp>.
  protected List<Timestamp> getTimestampListInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return Collections.unmodifiableList((List<Timestamp>) rowData.get(columnIndex));
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<DATE> produces a List<Date>.
  protected List<Date> getDateListInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return Collections.unmodifiableList((List<Date>) rowData.get(columnIndex));
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<UUID> produces a List<UUID>.
  protected List<UUID> getUuidListInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return Collections.unmodifiableList((List<UUID>) rowData.get(columnIndex));
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<Interval> produces a List<Interval>.
  protected List<Interval> getIntervalListInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return Collections.unmodifiableList((List<Interval>) rowData.get(columnIndex));
  }

  @Override
  @SuppressWarnings("unchecked") // We know ARRAY<STRUCT<...>> produces a List<STRUCT>.
  protected List<Struct> getStructListInternal(int columnIndex) {
    ensureDecoded(columnIndex);
    return Collections.unmodifiableList((List<Struct>) rowData.get(columnIndex));
  }
}

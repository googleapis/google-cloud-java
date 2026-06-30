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

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.ProtocolMessageEnum;
import java.math.BigDecimal;
import java.util.UUID;
import javax.annotation.Nullable;

/**
 * An interface for binding a {@link Value} in some context. Users of the Cloud Spanner client
 * library never create a {@code ValueBinder} directly; instead this interface is returned from
 * other parts of the library involved in {@code Value} construction. For example, {@link
 * Mutation.WriteBuilder#set(String)} returns a binder to bind a column value, and {@code
 * Statement#bind(String)} returns a binder to bind a parameter to a value.
 *
 * <p>{@code ValueBinder} subclasses typically carry state and are therefore not thread-safe,
 * although the core implementation itself is thread-safe.
 *
 * @param <R> The context which is used to bind the {@link Value}.
 */
public abstract class ValueBinder<R> {
  /**
   * Intentionally package-protected constructor; only the Cloud Spanner library can create
   * instances.
   */
  ValueBinder() {}

  /**
   * Subclasses should implement this method to handle value binding.
   *
   * <p>This method is intentionally package-protected rather than protected; the internal API is
   * subject to change.
   *
   * @param value the newly bound value
   * @return the object to return from the bind call ({@code to(...)}
   */
  abstract R handle(Value value);

  /** Binds a {@link Value} */
  public R to(Value value) {
    return handle(value);
  }

  /** Binds to {@code Value.bool(value)} */
  public R to(boolean value) {
    return handle(Value.bool(value));
  }

  /** Binds to {@code Value.bool(value)} */
  public R to(@Nullable Boolean value) {
    return handle(Value.bool(value));
  }

  /** Binds to {@code Value.int64(value)} */
  public R to(long value) {
    return handle(Value.int64(value));
  }

  /** Binds to {@code Value.int64(value)} */
  public R to(@Nullable Long value) {
    return handle(Value.int64(value));
  }

  /** Binds to {@code Value.float32(value)} */
  public R to(float value) {
    return handle(Value.float32(value));
  }

  /** Binds to {@code Value.float32(value)} */
  public R to(@Nullable Float value) {
    return handle(Value.float32(value));
  }

  /** Binds to {@code Value.float64(value)} */
  public R to(double value) {
    return handle(Value.float64(value));
  }

  /** Binds to {@code Value.float64(value)} */
  public R to(@Nullable Double value) {
    return handle(Value.float64(value));
  }

  /** Binds to {@code Value.numeric(value)} */
  public R to(BigDecimal value) {
    return handle(Value.numeric(value));
  }

  /** Binds to {@code Value.string(value)} */
  public R to(@Nullable String value) {
    return handle(Value.string(value));
  }

  /** Binds to {@code Value.protoMessage(value)} */
  public R to(AbstractMessage m) {
    return handle(Value.protoMessage(m));
  }

  /** Binds to {@code Value.protoMessage(value, protoType)} */
  public R to(@Nullable ByteArray v, String protoTypFqn) {
    return handle(Value.protoMessage(v, protoTypFqn));
  }

  /** Binds to {@code Value.protoMessage(value, descriptor)} */
  public R to(@Nullable ByteArray v, Descriptor descriptor) {
    return handle(Value.protoMessage(v, descriptor));
  }

  /** Binds to {@code Value.protoEnum(value)} */
  public R to(ProtocolMessageEnum value) {
    return handle(Value.protoEnum(value));
  }

  /** Binds to {@code Value.protoEnum(value, protoType)} */
  public R to(@Nullable Long v, String protoTypFqn) {
    return handle(Value.protoEnum(v, protoTypFqn));
  }

  /** Binds to {@code Value.protoEnum(value, enumDescriptor)} */
  public R to(@Nullable Long v, EnumDescriptor enumDescriptor) {
    return handle(Value.protoEnum(v, enumDescriptor));
  }

  /** Binds to {@code Value.protoEnum(value, protoType)} */
  public R to(long v, String protoTypFqn) {
    return handle(Value.protoEnum(v, protoTypFqn));
  }

  /**
   * Binds to {@code Value.bytes(value)}. Use {@link #to(Value)} in combination with {@link
   * Value#bytesFromBase64(String)} if you already have the value that you want to bind in base64
   * format. This prevents unnecessary decoding and encoding of base64 strings.
   */
  public R to(@Nullable ByteArray value) {
    return handle(Value.bytes(value));
  }

  /** Binds to {@code Value.timestamp(value)} */
  public R to(@Nullable Timestamp value) {
    return handle(Value.timestamp(value));
  }

  /** Binds to {@code Value.date(value)} */
  public R to(@Nullable Date value) {
    return handle(Value.date(value));
  }

  /** Binds to {@code Value.uuid(value)} */
  public R to(@Nullable UUID value) {
    return handle(Value.uuid(value));
  }

  /** Binds to {@code Value.interval(value)} */
  public R to(@Nullable Interval value) {
    return handle(Value.interval(value));
  }

  /** Binds a non-{@code NULL} struct value to {@code Value.struct(value)} */
  public R to(Struct value) {
    return handle(Value.struct(value));
  }

  /**
   * Binds a nullable {@code Struct} reference with given {@code Type} to {@code
   * Value.struct(type,value}
   */
  public R to(Type type, @Nullable Struct value) {
    return handle(Value.struct(type, value));
  }

  /** Binds to {@code Value.boolArray(values)} */
  public R toBoolArray(@Nullable boolean[] values) {
    return handle(Value.boolArray(values));
  }

  /** Binds to {@code Value.boolArray(values, int, pos)} */
  public R toBoolArray(@Nullable boolean[] values, int pos, int length) {
    return handle(Value.boolArray(values, pos, length));
  }

  /** Binds to {@code Value.boolArray(values)} */
  public R toBoolArray(@Nullable Iterable<Boolean> values) {
    return handle(Value.boolArray(values));
  }

  /** Binds to {@code Value.int64Array(values)} */
  public R toInt64Array(@Nullable long[] values) {
    return handle(Value.int64Array(values));
  }

  /** Binds to {@code Value.int64Array(values, pos, length)} */
  public R toInt64Array(@Nullable long[] values, int pos, int length) {
    return handle(Value.int64Array(values, pos, length));
  }

  /** Binds to {@code Value.int64Array(values)} */
  public R toInt64Array(@Nullable Iterable<Long> values) {
    return handle(Value.int64Array(values));
  }

  /** Binds to {@code Value.float32Array(values)} */
  public R toFloat32Array(@Nullable float[] values) {
    return handle(Value.float32Array(values));
  }

  /** Binds to {@code Value.float32Array(values, pos, length)} */
  public R toFloat32Array(@Nullable float[] values, int pos, int length) {
    return handle(Value.float32Array(values, pos, length));
  }

  /** Binds to {@code Value.float32Array(values)} */
  public R toFloat32Array(@Nullable Iterable<Float> values) {
    return handle(Value.float32Array(values));
  }

  /** Binds to {@code Value.float64Array(values)} */
  public R toFloat64Array(@Nullable double[] values) {
    return handle(Value.float64Array(values));
  }

  /** Binds to {@code Value.float64Array(values, pos, length)} */
  public R toFloat64Array(@Nullable double[] values, int pos, int length) {
    return handle(Value.float64Array(values, pos, length));
  }

  /** Binds to {@code Value.float64Array(values)} */
  public R toFloat64Array(@Nullable Iterable<Double> values) {
    return handle(Value.float64Array(values));
  }

  /** Binds to {@code Value.numericArray(values)} */
  public R toNumericArray(@Nullable Iterable<BigDecimal> values) {
    return handle(Value.numericArray(values));
  }

  /** Binds to {@code Value.pgNumericArray(values)} */
  public R toPgNumericArray(@Nullable Iterable<String> values) {
    return handle(Value.pgNumericArray(values));
  }

  /** Binds to {@code Value.stringArray(values)} */
  public R toStringArray(@Nullable Iterable<String> values) {
    return handle(Value.stringArray(values));
  }

  /** Binds to {@code Value.jsonArray(values)} */
  public R toJsonArray(@Nullable Iterable<String> values) {
    return handle(Value.jsonArray(values));
  }

  /** Binds to {@code Value.jsonbArray(values)} */
  public R toPgJsonbArray(@Nullable Iterable<String> values) {
    return handle(Value.pgJsonbArray(values));
  }

  /** Binds to {@code Value.pgOidArray(values)} */
  public R toPgOidArray(@Nullable long[] values) {
    return handle(Value.pgOidArray(values));
  }

  /** Binds to {@code Value.pgOidArray(values, pos, length)} */
  public R toPgOidArray(@Nullable long[] values, int pos, int length) {
    return handle(Value.pgOidArray(values, pos, length));
  }

  /** Binds to {@code Value.pgOidArray(values)} */
  public R toPgOidArray(@Nullable Iterable<Long> values) {
    return handle(Value.pgOidArray(values));
  }

  /** Binds to {@code Value.bytesArray(values)} */
  public R toBytesArray(@Nullable Iterable<ByteArray> values) {
    return handle(Value.bytesArray(values));
  }

  /**
   * Binds to {@code Value.bytesArray(values)}. The given strings must be valid base64 encoded
   * strings. Use this method instead of {@link #toBytesArray(Iterable)} if you already have the
   * values in base64 format to prevent unnecessary decoding and encoding to/from base64.
   */
  public R toBytesArrayFromBase64(@Nullable Iterable<String> valuesAsBase64Strings) {
    return handle(Value.bytesArrayFromBase64(valuesAsBase64Strings));
  }

  /** Binds to {@code Value.timestampArray(values)} */
  public R toTimestampArray(@Nullable Iterable<Timestamp> values) {
    return handle(Value.timestampArray(values));
  }

  /** Binds to {@code Value.protoMessageArray(values, descriptor)} */
  public R toProtoMessageArray(@Nullable Iterable<AbstractMessage> values, Descriptor descriptor) {
    return handle(Value.protoMessageArray(values, descriptor));
  }

  /** Binds to {@code Value.protoMessageArray(values, protoTypeFq)} */
  public R toProtoMessageArray(@Nullable Iterable<ByteArray> values, String protoTypeFq) {
    return handle(Value.protoMessageArray(values, protoTypeFq));
  }

  /** Binds to {@code Value.protoEnumArray(values, descriptor)} */
  public R toProtoEnumArray(
      @Nullable Iterable<ProtocolMessageEnum> values, EnumDescriptor descriptor) {
    return handle(Value.protoEnumArray(values, descriptor));
  }

  /** Binds to {@code Value.protoEnumArray(values, protoTypeFq)} */
  public R toProtoEnumArray(@Nullable Iterable<Long> values, String protoTypeFq) {
    return handle(Value.protoEnumArray(values, protoTypeFq));
  }

  /** Binds to {@code Value.dateArray(values)} */
  public R toDateArray(@Nullable Iterable<Date> values) {
    return handle(Value.dateArray(values));
  }

  /** Binds to {@code Value.uuidArray(values)} */
  public R toUuidArray(@Nullable Iterable<UUID> values) {
    return handle(Value.uuidArray(values));
  }

  /** Binds to {@code Value.intervalArray(values)} */
  public R toIntervalArray(@Nullable Iterable<Interval> values) {
    return handle(Value.intervalArray(values));
  }

  /** Binds to {@code Value.structArray(fieldTypes, values)} */
  public R toStructArray(Type elementType, @Nullable Iterable<Struct> values) {
    return handle(Value.structArray(elementType, values));
  }
}

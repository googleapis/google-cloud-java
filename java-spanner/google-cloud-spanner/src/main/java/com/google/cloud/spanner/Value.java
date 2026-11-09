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

import static com.google.cloud.spanner.SpannerTypeConverter.atUTC;
import static com.google.cloud.spanner.SpannerTypeConverter.convertLocalDateToSpannerDate;
import static com.google.cloud.spanner.SpannerTypeConverter.convertToISO8601;
import static com.google.cloud.spanner.SpannerTypeConverter.convertToTypedIterable;
import static com.google.cloud.spanner.SpannerTypeConverter.createUntypedArrayValue;
import static com.google.cloud.spanner.SpannerTypeConverter.createUntypedIterableValue;
import static com.google.cloud.spanner.SpannerTypeConverter.createUntypedStringValue;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbstractResultSet.LazyByteArray;
import com.google.cloud.spanner.Type.Code;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.io.CharSource;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.Value.KindCase;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/**
 * Represents a value to be consumed by the Cloud Spanner API. A value can be {@code NULL} or
 * non-{@code NULL}; regardless, values always have an associated type.
 *
 * <p>The {@code Value} API is optimized for construction, since this is the majority use-case when
 * using this class with the Cloud Spanner libraries. The factory method signatures and internal
 * representations are design to minimize memory usage and object creation while still maintaining
 * the immutability contract of this class. In particular, arrays of primitive types can be
 * constructed without requiring boxing into collections of wrapper types. The getters in this class
 * are intended primarily for test purposes, and so do not share the same performance
 * characteristics; in particular, getters for array types may be expensive.
 *
 * <p>{@code Value} instances are immutable.
 */
@Immutable
public abstract class Value implements Serializable {

  /**
   * Placeholder value to be passed to a mutation to make Cloud Spanner store the commit timestamp
   * in that column. The commit timestamp is the timestamp corresponding to when Cloud Spanner
   * commits the transaction containing the mutation.
   *
   * <p>Note that this particular timestamp instance has no semantic meaning. In particular the
   * value of seconds and nanoseconds in this timestamp are meaningless. This placeholder can only
   * be used for columns that have set the option "(allow_commit_timestamp=true)" in the schema.
   *
   * <p>When reading the value stored in such a column, the value returned is an actual timestamp
   * corresponding to the commit time of the transaction, which has no relation to this placeholder.
   *
   * @see <a href="https://cloud.google.com/spanner/docs/transactions#rw_transaction_semantics">
   *     Transaction Semantics</a>
   */
  public static final Timestamp COMMIT_TIMESTAMP = Timestamp.ofTimeMicroseconds(0L);

  static final com.google.protobuf.Value NULL_PROTO =
      com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();

  /** Constant to specify a PG Numeric NaN value. */
  public static final String NAN = "NaN";

  private static final int MAX_DEBUG_STRING_LENGTH = 36;
  private static final String ELLIPSIS = "...";
  private static final String NULL_STRING = "NULL";
  private static final char LIST_SEPARATOR = ',';
  private static final char LIST_OPEN = '[';
  private static final char LIST_CLOSE = ']';
  private static final long serialVersionUID = -5289864325087675338L;

  /**
   * Returns a {@link Value} that wraps the given proto value. This can be used to construct a value
   * without a specific type, and let the backend infer the type based on the statement where it is
   * used.
   *
   * @param value the non-null proto value (a {@link NullValue} is allowed)
   */
  public static Value untyped(com.google.protobuf.Value value) {
    return new ProtoBackedValueImpl(Preconditions.checkNotNull(value), null);
  }

  /** Returns a generic Value backed by a protobuf value. This is used for unrecognized types. */
  static Value unrecognized(com.google.protobuf.Value value, Type type) {
    Preconditions.checkArgument(
        type.getCode() == Code.UNRECOGNIZED
            || type.getCode() == Code.ARRAY
                && type.getArrayElementType().getCode() == Code.UNRECOGNIZED);
    return new ProtoBackedValueImpl(Preconditions.checkNotNull(value), type);
  }

  /**
   * Returns a {@code BOOL} value.
   *
   * @param v the value, which may be null
   */
  public static Value bool(@Nullable Boolean v) {
    return new BoolImpl(v == null, v == null ? false : v);
  }

  /** Returns a {@code BOOL} value. */
  public static Value bool(boolean v) {
    return new BoolImpl(false, v);
  }

  /**
   * Returns an {@code INT64} value.
   *
   * @param v the value, which may be null
   */
  public static Value int64(@Nullable Long v) {
    return new Int64Impl(v == null, v == null ? 0 : v);
  }

  /** Returns an {@code INT64} value. */
  public static Value int64(long v) {
    return new Int64Impl(false, v);
  }

  /**
   * Returns a {@code FLOAT32} value.
   *
   * @param v the value, which may be null
   */
  public static Value float32(@Nullable Float v) {
    return new Float32Impl(v == null, v == null ? 0 : v);
  }

  /** Returns a {@code FLOAT32} value. */
  public static Value float32(float v) {
    return new Float32Impl(false, v);
  }

  /**
   * Returns a {@code FLOAT64} value.
   *
   * @param v the value, which may be null
   */
  public static Value float64(@Nullable Double v) {
    return new Float64Impl(v == null, v == null ? 0 : v);
  }

  /** Returns a {@code FLOAT64} value. */
  public static Value float64(double v) {
    return new Float64Impl(false, v);
  }

  /**
   * Returns a {@code NUMERIC} value. The valid value range for the whole component of the {@link
   * BigDecimal} is from -9,999,999,999,999,999,999,999,999 to +9,999,999,999,999,999,999,999,999
   * (both inclusive), i.e. the max length of the whole component is 29 digits. The max length of
   * the fractional part is 9 digits. Trailing zeros in the fractional part are not considered and
   * will be lost, as Cloud Spanner does not preserve the precision of a numeric value.
   *
   * <p>If you set a numeric value of a record to for example 0.10, Cloud Spanner will return this
   * value as 0.1 in subsequent queries. Use {@link BigDecimal#stripTrailingZeros()} to compare
   * inserted values with retrieved values if your application might insert numeric values with
   * trailing zeros.
   *
   * @param v the value, which may be null
   */
  public static Value numeric(@Nullable BigDecimal v) {
    if (v != null) {
      // Cloud Spanner does not preserve the precision, so 0.1 is considered equal to 0.10.
      BigDecimal test = v.stripTrailingZeros();
      if (test.scale() > 9) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.OUT_OF_RANGE,
            String.format(
                "Max scale for a numeric is 9. The requested numeric has scale %d", test.scale()));
      }
      if (test.precision() - test.scale() > 29) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.OUT_OF_RANGE,
            String.format(
                "Max precision for the whole component of a numeric is 29. The requested numeric"
                    + " has a whole component with precision %d",
                test.precision() - test.scale()));
      }
    }
    return new NumericImpl(v == null, v);
  }

  /**
   * Returns a {@code PG NUMERIC} value. This value has flexible precision and scale which is
   * specified in the Database DDL. This value also supports {@code NaNs}, which can be specified
   * with {@code Value.pgNumeric(Value.NAN)} or simply as {@code Value.pgNumeric("NaN")}.
   *
   * <p>Note that this flavour of numeric is different than Spanner numerics ({@link
   * Value#numeric(BigDecimal)}). It should be used only for handling numerics in the PostgreSQL
   * dialect.
   *
   * @param v the value, which may be null
   */
  public static Value pgNumeric(@Nullable String v) {
    return new PgNumericImpl(v == null, v);
  }

  /**
   * Returns a {@code STRING} value.
   *
   * @param v the value, which may be null
   */
  public static Value string(@Nullable String v) {
    return new StringImpl(v == null, v);
  }

  /**
   * Returns a {@code JSON} value.
   *
   * @param v the value, which may be null
   */
  public static Value json(@Nullable String v) {
    return new JsonImpl(v == null, v);
  }

  /**
   * Returns a {@code INTERVAL} value.
   *
   * @param interval the value, which may be null
   */
  public static Value interval(@Nullable Interval interval) {
    return new IntervalImpl(interval == null, interval);
  }

  /**
   * Returns a {@code PG JSONB} value.
   *
   * @param v the value, which may be null
   */
  public static Value pgJsonb(@Nullable String v) {
    return new PgJsonbImpl(v == null, v);
  }

  /**
   * Returns an {@code PG_OID} value.
   *
   * @param v the value, which may be null
   */
  public static Value pgOid(@Nullable Long v) {
    return new PgOidImpl(v == null, v == null ? 0 : v);
  }

  /** Returns an {@code PG_OID} value. */
  public static Value pgOid(long v) {
    return new PgOidImpl(false, v);
  }

  /**
   * Return a {@code PROTO} value for not null proto messages.
   *
   * @param v Not null Proto message.
   */
  public static Value protoMessage(AbstractMessage v) {
    Preconditions.checkNotNull(
        v, "Use protoMessage((ByteArray) null, MyProtoClass.getDescriptor()) for null values.");
    return protoMessage(
        ByteArray.copyFrom(v.toByteArray()), v.getDescriptorForType().getFullName());
  }

  /**
   * Return a {@code PROTO} value
   *
   * @param v Serialized Proto Array, which may be null.
   * @param protoTypeFqn Fully qualified name of proto representing the proto definition. Use static
   *     method from proto class {@code MyProtoClass.getDescriptor().getFullName()}
   */
  public static Value protoMessage(@Nullable ByteArray v, String protoTypeFqn) {
    return new ProtoMessageImpl(v == null, v, protoTypeFqn);
  }

  /**
   * Return a {@code PROTO} value
   *
   * @param v Serialized Proto Array, which may be null.
   * @param descriptor Proto Type Descriptor, use static method from proto class {@code
   *     MyProtoClass.getDescriptor()}.
   */
  public static Value protoMessage(@Nullable ByteArray v, Descriptor descriptor) {
    Preconditions.checkNotNull(descriptor, "descriptor can't be null.");
    return protoMessage(v, descriptor.getFullName());
  }

  /**
   * Return a {@code ENUM} value for not null proto messages.
   *
   * @param v Proto Enum, which may be null.
   */
  public static Value protoEnum(ProtocolMessageEnum v) {
    Preconditions.checkNotNull(
        v, "Use protoEnum((Long) null, MyProtoEnum.getDescriptor()) for null values.");
    return protoEnum(v.getNumber(), v.getDescriptorForType().getFullName());
  }

  /**
   * Return a {@code ENUM} value.
   *
   * @param v Enum non-primitive Integer constant.
   * @param protoTypeFqn Fully qualified name of proto representing the enum definition. Use static
   *     method from proto class {@code MyProtoEnum.getDescriptor().getFullName()}
   */
  public static Value protoEnum(@Nullable Long v, String protoTypeFqn) {
    return new ProtoEnumImpl(v == null, v, protoTypeFqn);
  }

  /**
   * Return a {@code ENUM} value.
   *
   * @param v Enum non-primitive Integer constant.
   * @param enumDescriptor Enum Type Descriptor. Use static method from proto class {@code *
   *     MyProtoEnum.getDescriptor()}.
   */
  public static Value protoEnum(@Nullable Long v, EnumDescriptor enumDescriptor) {
    Preconditions.checkNotNull(enumDescriptor, "descriptor can't be null.");
    return protoEnum(v, enumDescriptor.getFullName());
  }

  /**
   * Return a {@code ENUM} value.
   *
   * @param v Enum integer primitive constant.
   * @param protoTypeFqn Fully qualified name of proto representing the enum definition. Use static
   *     method from proto class {@code MyProtoEnum.getDescriptor().getFullName()}
   */
  public static Value protoEnum(long v, String protoTypeFqn) {
    return new ProtoEnumImpl(false, v, protoTypeFqn);
  }

  /**
   * e Returns a {@code BYTES} value. Returns a {@code BYTES} value.
   *
   * @param v the value, which may be null
   */
  public static Value bytes(@Nullable ByteArray v) {
    return new LazyBytesImpl(v == null, v);
  }

  /**
   * Returns a {@code BYTES} value.
   *
   * @param base64String the value in Base64 encoding, which may be null. This value must be a valid
   *     base64 string.
   */
  public static Value bytesFromBase64(@Nullable String base64String) {
    return new LazyBytesImpl(
        base64String == null, base64String == null ? null : new LazyByteArray(base64String));
  }

  static Value internalBytes(@Nullable LazyByteArray bytes) {
    return new LazyBytesImpl(bytes == null, bytes);
  }

  /** Returns a {@code TIMESTAMP} value. */
  public static Value timestamp(@Nullable Timestamp v) {
    return new TimestampImpl(v == null, v == Value.COMMIT_TIMESTAMP, v);
  }

  /**
   * Returns a {@code DATE} value. The range [1678-01-01, 2262-01-01) is the legal interval for
   * cloud spanner dates. A write to a date column is rejected if the value is outside of that
   * interval.
   */
  public static Value date(@Nullable Date v) {
    return new DateImpl(v == null, v);
  }

  public static Value uuid(@Nullable UUID v) {
    return new UuidImpl(v == null, v);
  }

  /** Returns a non-{@code NULL} {#code STRUCT} value. */
  public static Value struct(Struct v) {
    Preconditions.checkNotNull(v, "Illegal call to create a NULL struct value.");
    return new StructImpl(v);
  }

  /**
   * Returns a {@code STRUCT} value of {@code Type} type.
   *
   * @param type the type of the {@code STRUCT} value
   * @param v the struct {@code STRUCT} value. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. If non-{@code null}, {@link Struct#getType()} must match
   *     type.
   */
  public static Value struct(Type type, @Nullable Struct v) {
    if (v == null) {
      Preconditions.checkArgument(
          type.getCode() == Code.STRUCT,
          "Illegal call to create a NULL struct with a non-struct type.");
      return new StructImpl(type);
    } else {
      Preconditions.checkArgument(
          type.equals(v.getType()), "Mismatch between struct value and type.");
      return new StructImpl(v);
    }
  }

  /**
   * Returns an {@code ARRAY<BOOL>} value.
   *
   * @param v the source of element values, which may be null to produce a value for which {@code
   *     isNull()} is {@code true}
   */
  public static Value boolArray(@Nullable boolean[] v) {
    return boolArray(v, 0, v == null ? 0 : v.length);
  }

  /**
   * Returns an {@code ARRAY<BOOL>} value that takes its elements from a region of an array.
   *
   * @param v the source of element values, which may be null to produce a value for which {@code
   *     isNull()} is {@code true}
   * @param pos the start position of {@code v} to copy values from. Ignored if {@code v} is {@code
   *     null}.
   * @param length the number of values to copy from {@code v}. Ignored if {@code v} is {@code
   *     null}.
   */
  public static Value boolArray(@Nullable boolean[] v, int pos, int length) {
    return boolArrayFactory.create(v, pos, length);
  }

  /**
   * Returns an {@code ARRAY<BOOL>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value boolArray(@Nullable Iterable<Boolean> v) {
    // TODO(user): Consider memory optimizing boolArray() to use BitSet instead of boolean[].
    return boolArrayFactory.create(v);
  }

  /**
   * Returns an {@code ARRAY<INT64>} value.
   *
   * @param v the source of element values, which may be null to produce a value for which {@code
   *     isNull()} is {@code true}
   */
  public static Value int64Array(@Nullable long[] v) {
    return int64Array(v, 0, v == null ? 0 : v.length);
  }

  /**
   * Returns an {@code ARRAY<INT64>} value that takes its elements from a region of an array.
   *
   * @param v the source of element values, which may be null to produce a value for which {@code
   *     isNull()} is {@code true}
   * @param pos the start position of {@code v} to copy values from. Ignored if {@code v} is {@code
   *     null}.
   * @param length the number of values to copy from {@code v}. Ignored if {@code v} is {@code
   *     null}.
   */
  public static Value int64Array(@Nullable long[] v, int pos, int length) {
    return int64ArrayFactory.create(v, pos, length);
  }

  /**
   * Returns an {@code ARRAY<INT64>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value int64Array(@Nullable Iterable<Long> v) {
    return int64ArrayFactory.create(v);
  }

  /**
   * Returns an {@code ARRAY<FLOAT32>} value.
   *
   * @param v the source of element values, which may be null to produce a value for which {@code
   *     isNull()} is {@code true}
   */
  public static Value float32Array(@Nullable float[] v) {
    return float32Array(v, 0, v == null ? 0 : v.length);
  }

  /**
   * Returns an {@code ARRAY<FLOAT32>} value that takes its elements from a region of an array.
   *
   * @param v the source of element values, which may be null to produce a value for which {@code
   *     isNull()} is {@code true}
   * @param pos the start position of {@code v} to copy values from. Ignored if {@code v} is {@code
   *     null}.
   * @param length the number of values to copy from {@code v}. Ignored if {@code v} is {@code
   *     null}.
   */
  public static Value float32Array(@Nullable float[] v, int pos, int length) {
    return float32ArrayFactory.create(v, pos, length);
  }

  /**
   * Returns an {@code ARRAY<FLOAT32>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value float32Array(@Nullable Iterable<Float> v) {
    return float32ArrayFactory.create(v);
  }

  /**
   * Returns an {@code ARRAY<FLOAT64>} value.
   *
   * @param v the source of element values, which may be null to produce a value for which {@code
   *     isNull()} is {@code true}
   */
  public static Value float64Array(@Nullable double[] v) {
    return float64Array(v, 0, v == null ? 0 : v.length);
  }

  /**
   * Returns an {@code ARRAY<FLOAT64>} value that takes its elements from a region of an array.
   *
   * @param v the source of element values, which may be null to produce a value for which {@code
   *     isNull()} is {@code true}
   * @param pos the start position of {@code v} to copy values from. Ignored if {@code v} is {@code
   *     null}.
   * @param length the number of values to copy from {@code v}. Ignored if {@code v} is {@code
   *     null}.
   */
  public static Value float64Array(@Nullable double[] v, int pos, int length) {
    return float64ArrayFactory.create(v, pos, length);
  }

  /**
   * Returns an {@code ARRAY<FLOAT64>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value float64Array(@Nullable Iterable<Double> v) {
    return float64ArrayFactory.create(v);
  }

  /**
   * Returns an {@code ARRAY<NUMERIC>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value numericArray(@Nullable Iterable<BigDecimal> v) {
    return new NumericArrayImpl(v == null, v == null ? null : immutableCopyOf(v));
  }

  /**
   * Returns an {@code ARRAY<PG_NUMERIC>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}. Individual
   *     elements may be {@code "NaN"} or {@link Value#NAN}.
   */
  public static Value pgNumericArray(@Nullable Iterable<String> v) {
    return new PgNumericArrayImpl(v == null, v == null ? null : immutableCopyOf(v));
  }

  /**
   * Returns an {@code ARRAY<STRING>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value stringArray(@Nullable Iterable<String> v) {
    return new StringArrayImpl(v == null, v == null ? null : immutableCopyOf(v));
  }

  /**
   * Returns an {@code ARRAY<JSON>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value jsonArray(@Nullable Iterable<String> v) {
    return new JsonArrayImpl(v == null, v == null ? null : immutableCopyOf(v));
  }

  /**
   * Returns an {@code ARRAY<JSONB>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value pgJsonbArray(@Nullable Iterable<String> v) {
    return new PgJsonbArrayImpl(v == null, v == null ? null : immutableCopyOf(v));
  }

  /**
   * Returns an {@code ARRAY<PG_OID>} value.
   *
   * @param v the source of element values, which may be null to produce a value for which {@code
   *     isNull()} is {@code true}
   */
  public static Value pgOidArray(@Nullable long[] v) {
    return pgOidArray(v, 0, v == null ? 0 : v.length);
  }

  /**
   * Returns an {@code ARRAY<PG_OID>} value that takes its elements from a region of an array.
   *
   * @param v the source of element values, which may be null to produce a value for which {@code
   *     isNull()} is {@code true}
   * @param pos the start position of {@code v} to copy values from. Ignored if {@code v} is {@code
   *     null}.
   * @param length the number of values to copy from {@code v}. Ignored if {@code v} is {@code
   *     null}.
   */
  public static Value pgOidArray(@Nullable long[] v, int pos, int length) {
    return pgOidArrayFactory.create(v, pos, length);
  }

  /**
   * Returns an {@code ARRAY<PG_OID>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value pgOidArray(@Nullable Iterable<Long> v) {
    return pgOidArrayFactory.create(v);
  }

  /**
   * Returns an {@code ARRAY<PROTO>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   * @param descriptor Proto Type Descriptor, use static method from proto class {@code
   *     MyProtoClass.getDescriptor()}.
   */
  public static Value protoMessageArray(
      @Nullable Iterable<AbstractMessage> v, Descriptor descriptor) {
    if (v == null) {
      return new ProtoMessageArrayImpl(true, null, descriptor.getFullName());
    }

    List<ByteArray> serializedArray = new ArrayList<>();
    v.forEach(
        (message) -> {
          if (message != null) {
            serializedArray.add(ByteArray.copyFrom(message.toByteArray()));
          } else {
            serializedArray.add(null);
          }
        });

    return new ProtoMessageArrayImpl(false, serializedArray, descriptor.getFullName());
  }

  /**
   * Returns an {@code ARRAY<PROTO>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   * @param protoTypeFqn Fully qualified name of proto representing the proto definition. Use static
   *     method from proto class {@code MyProtoClass.getDescriptor().getFullName()}
   */
  public static Value protoMessageArray(@Nullable Iterable<ByteArray> v, String protoTypeFqn) {
    return new ProtoMessageArrayImpl(
        v == null, v != null ? immutableCopyOf(v) : null, protoTypeFqn);
  }

  /**
   * Returns an {@code ARRAY<ENUM>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   * @param descriptor Proto Type Descriptor, use static method from proto class {@code
   *     MyProtoClass.getDescriptor()}.
   */
  public static Value protoEnumArray(
      @Nullable Iterable<ProtocolMessageEnum> v, EnumDescriptor descriptor) {
    if (v == null) {
      return new ProtoEnumArrayImpl(true, null, descriptor.getFullName());
    }

    List<Long> enumConstValues = new ArrayList<>();
    v.forEach(
        (protoEnum) -> {
          if (protoEnum != null) {
            enumConstValues.add((long) protoEnum.getNumber());
          } else {
            enumConstValues.add(null);
          }
        });

    return new ProtoEnumArrayImpl(false, enumConstValues, descriptor.getFullName());
  }

  /**
   * Returns an {@code ARRAY<ENUM>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   * @param protoTypeFqn Fully qualified name of proto representing the enum definition. Use static
   *     method from proto class {@code MyProtoEnum.getDescriptor().getFullName()}
   */
  public static Value protoEnumArray(@Nullable Iterable<Long> v, String protoTypeFqn) {
    return new ProtoEnumArrayImpl(v == null, v != null ? immutableCopyOf(v) : null, protoTypeFqn);
  }

  /**
   * Returns an {@code ARRAY<BYTES>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value bytesArray(@Nullable Iterable<ByteArray> v) {
    return new LazyBytesArrayImpl(v == null, v == null ? null : byteArraysToLazyByteArrayList(v));
  }

  private static List<LazyByteArray> byteArraysToLazyByteArrayList(Iterable<ByteArray> byteArrays) {
    List<LazyByteArray> list = new ArrayList<>();
    for (ByteArray byteArray : byteArrays) {
      list.add(byteArray == null ? null : new LazyByteArray(byteArray));
    }
    return Collections.unmodifiableList(list);
  }

  /**
   * Returns an {@code ARRAY<BYTES>} value.
   *
   * @param base64Strings the source of element values. This may be {@code null} to produce a value
   *     for which {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   *     Non-null values must be a valid Base64 string.
   */
  public static Value bytesArrayFromBase64(@Nullable Iterable<String> base64Strings) {
    return new LazyBytesArrayImpl(
        base64Strings == null,
        base64Strings == null ? null : base64StringsToLazyByteArrayList(base64Strings));
  }

  private static List<LazyByteArray> base64StringsToLazyByteArrayList(
      Iterable<String> base64Strings) {
    List<LazyByteArray> list = new ArrayList<>();
    for (String base64 : base64Strings) {
      list.add(base64 == null ? null : new LazyByteArray(base64));
    }
    return Collections.unmodifiableList(list);
  }

  /**
   * Returns an {@code ARRAY<TIMESTAMP>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value timestampArray(@Nullable Iterable<Timestamp> v) {
    return new TimestampArrayImpl(v == null, v == null ? null : immutableCopyOf(v));
  }

  /**
   * Returns an {@code ARRAY<DATE>} value. The range [1678-01-01, 2262-01-01) is the legal interval
   * for cloud spanner dates. A write to a date column is rejected if the value is outside of that
   * interval.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value dateArray(@Nullable Iterable<Date> v) {
    return new DateArrayImpl(v == null, v == null ? null : immutableCopyOf(v));
  }

  /**
   * Returns an {@code ARRAY<UUID>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value uuidArray(@Nullable Iterable<UUID> v) {
    return new UuidArrayImpl(v == null, v == null ? null : immutableCopyOf(v));
  }

  /**
   * Returns an {@code ARRAY<Interval>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value intervalArray(@Nullable Iterable<Interval> v) {
    return new IntervalArrayImpl(v == null, v == null ? null : immutableCopyOf(v));
  }

  /**
   * Returns an {@code ARRAY<STRUCT<...>>} value.
   *
   * @param elementType
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value structArray(Type elementType, @Nullable Iterable<Struct> v) {
    if (v == null) {
      Preconditions.checkArgument(
          elementType.getCode() == Code.STRUCT,
          "Illegal call to create a NULL array-of-struct with a non-struct element type.");
      return new StructArrayImpl(elementType, null);
    }
    List<Struct> values = immutableCopyOf(v);
    for (Struct value : values) {
      if (value != null) {
        Preconditions.checkArgument(
            value.getType().equals(elementType),
            "Members of v must have type %s (found %s)",
            elementType,
            value.getType());
      }
    }
    return new StructArrayImpl(elementType, values);
  }

  private Value() {}

  static Value toValue(Object value) {
    if (value == null) {
      return Value.untyped(NULL_PROTO);
    }
    if (value instanceof Value) {
      return (Value) value;
    }
    if (value instanceof Boolean) {
      return Value.bool((Boolean) value);
    }
    if (value instanceof Long || value instanceof Integer) {
      return createUntypedStringValue(String.valueOf(value));
    }
    if (value instanceof Float) {
      return Value.float32((Float) value);
    }
    if (value instanceof Double) {
      return Value.float64((Double) value);
    }
    if (value instanceof BigDecimal) {
      return Value.numeric((BigDecimal) value);
    }
    if (value instanceof ByteArray) {
      return Value.bytes((ByteArray) value);
    }
    if (value instanceof byte[]) {
      return Value.bytes(ByteArray.copyFrom((byte[]) value));
    }
    if (value instanceof Date) {
      return Value.date((Date) value);
    }
    if (value instanceof UUID) {
      return Value.uuid((UUID) value);
    }
    if (value instanceof LocalDate) {
      return Value.date(convertLocalDateToSpannerDate((LocalDate) value));
    }
    if (value instanceof LocalDateTime) {
      return createUntypedStringValue(convertToISO8601(atUTC((LocalDateTime) value)));
    }
    if (value instanceof OffsetDateTime) {
      return createUntypedStringValue(convertToISO8601(atUTC((OffsetDateTime) value)));
    }
    if (value instanceof ZonedDateTime) {
      return createUntypedStringValue(convertToISO8601(atUTC((ZonedDateTime) value)));
    }
    if (value instanceof ProtocolMessageEnum) {
      return Value.protoEnum((ProtocolMessageEnum) value);
    }
    if (value instanceof AbstractMessage) {
      return Value.protoMessage((AbstractMessage) value);
    }
    if (value instanceof Interval) {
      return Value.interval((Interval) value);
    }
    if (value instanceof Struct) {
      return Value.struct((Struct) value);
    }
    if (value instanceof Timestamp) {
      return Value.timestamp((Timestamp) value);
    }
    if (value instanceof Iterable<?>) {
      Iterator<?> iterator = ((Iterable<?>) value).iterator();
      if (!iterator.hasNext()) {
        return createUntypedArrayValue(Stream.empty());
      }
      Object object = iterator.next();
      if (object instanceof Boolean) {
        return Value.boolArray(convertToTypedIterable((Boolean) object, iterator));
      }
      if (object instanceof Integer) {
        return createUntypedIterableValue((Integer) object, iterator, String::valueOf);
      }
      if (object instanceof Long) {
        return createUntypedIterableValue((Long) object, iterator, String::valueOf);
      }
      if (object instanceof Float) {
        return Value.float32Array(convertToTypedIterable((Float) object, iterator));
      }
      if (object instanceof Double) {
        return Value.float64Array(convertToTypedIterable((Double) object, iterator));
      }
      if (object instanceof BigDecimal) {
        return Value.numericArray(convertToTypedIterable((BigDecimal) object, iterator));
      }
      if (object instanceof ByteArray) {
        return Value.bytesArray(convertToTypedIterable((ByteArray) object, iterator));
      }
      if (object instanceof byte[]) {
        return Value.bytesArray(
            SpannerTypeConverter.convertToTypedIterable(
                ByteArray::copyFrom, (byte[]) object, iterator));
      }
      if (object instanceof Interval) {
        return Value.intervalArray(convertToTypedIterable((Interval) object, iterator));
      }
      if (object instanceof Timestamp) {
        return Value.timestampArray(convertToTypedIterable((Timestamp) object, iterator));
      }
      if (object instanceof Date) {
        return Value.dateArray(convertToTypedIterable((Date) object, iterator));
      }
      if (object instanceof UUID) {
        return Value.uuidArray(convertToTypedIterable((UUID) object, iterator));
      }
      if (object instanceof LocalDate) {
        return Value.dateArray(
            SpannerTypeConverter.convertToTypedIterable(
                SpannerTypeConverter::convertLocalDateToSpannerDate, (LocalDate) object, iterator));
      }
      if (object instanceof LocalDateTime) {
        return createUntypedIterableValue(
            (LocalDateTime) object, iterator, val -> convertToISO8601(atUTC(val)));
      }
      if (object instanceof OffsetDateTime) {
        return createUntypedIterableValue(
            (OffsetDateTime) object, iterator, val -> convertToISO8601(atUTC(val)));
      }
      if (object instanceof ZonedDateTime) {
        return createUntypedIterableValue(
            (ZonedDateTime) object, iterator, val -> convertToISO8601(atUTC(val)));
      }
    }

    // array and primitive array
    if (value instanceof Boolean[]) {
      return Value.boolArray(Arrays.asList((Boolean[]) value));
    }
    if (value instanceof boolean[]) {
      return Value.boolArray((boolean[]) value);
    }
    if (value instanceof Float[]) {
      return Value.float32Array(Arrays.asList((Float[]) value));
    }
    if (value instanceof float[]) {
      return Value.float32Array((float[]) value);
    }
    if (value instanceof Double[]) {
      return Value.float64Array(Arrays.asList((Double[]) value));
    }
    if (value instanceof double[]) {
      return Value.float64Array((double[]) value);
    }
    if (value instanceof Long[]) {
      return createUntypedArrayValue(Arrays.stream((Long[]) value));
    }
    if (value instanceof long[]) {
      return createUntypedArrayValue(Arrays.stream((long[]) value).boxed());
    }
    if (value instanceof Integer[]) {
      return createUntypedArrayValue(Arrays.stream((Integer[]) value));
    }
    if (value instanceof int[]) {
      return createUntypedArrayValue(Arrays.stream((int[]) value).boxed());
    }

    return createUntypedStringValue(value);
  }

  /** Returns the type of this value. This will return a type even if {@code isNull()} is true. */
  public abstract Type getType();

  /** Returns {@code true} if this instance represents a {@code NULL} value. */
  public abstract boolean isNull();

  /**
   * Returns the value of a {@code BOOL}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract boolean getBool();

  /**
   * Returns the value of a {@code INT64}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract long getInt64();

  /**
   * Returns the value of a {@code FLOAT32}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract float getFloat32();

  /**
   * Returns the value of a {@code FLOAT64}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract double getFloat64();

  /**
   * Returns the value of a {@code NUMERIC}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract BigDecimal getNumeric();

  /**
   * Returns the value of a {@code STRING}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract String getString();

  /**
   * Returns the value of a {@code JSON}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public String getJson() {
    throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Returns the value of a {@code JSONB}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public String getPgJsonb() {
    throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Returns the value of a {@code PROTO}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public <T extends AbstractMessage> T getProtoMessage(T m) {
    throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Returns the value of a {@code ENUM}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public <T extends ProtocolMessageEnum> T getProtoEnum(
      Function<Integer, ProtocolMessageEnum> method) {
    throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Returns the value of a {@code BYTES}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract ByteArray getBytes();

  /**
   * Returns the value of a {@code TIMESTAMP}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type or
   *     {@link #isCommitTimestamp()}.
   */
  public abstract Timestamp getTimestamp();

  /** Returns true if this is a commit timestamp value. */
  public abstract boolean isCommitTimestamp();

  /**
   * Returns the value of a {@code DATE}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract Date getDate();

  /**
   * Returns the value of a {@code UUID}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract UUID getUuid();

  /**
   * Returns the value of a {@code INTERVAL}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract Interval getInterval();

  /**
   * Returns the value of a {@code STRUCT}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract Struct getStruct();

  /**
   * Returns the value of an {@code ARRAY<BOOL>}-typed instance. While the returned list itself will
   * never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<Boolean> getBoolArray();

  /**
   * Returns the value of an {@code ARRAY<INT64>}-typed instance. While the returned list itself
   * will never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<Long> getInt64Array();

  /**
   * Returns the value of an {@code ARRAY<FLOAT32>}-typed instance. While the returned list itself
   * will never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<Float> getFloat32Array();

  /**
   * Returns the value of an {@code ARRAY<FLOAT64>}-typed instance. While the returned list itself
   * will never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<Double> getFloat64Array();

  /**
   * Returns the value of an {@code ARRAY<NUMERIC>}-typed instance. While the returned list itself
   * will never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<BigDecimal> getNumericArray();

  /**
   * Returns the value of an {@code ARRAY<STRING>}-typed instance. While the returned list itself
   * will never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<String> getStringArray();

  /**
   * Returns the value of an {@code ARRAY<JSON>}-typed instance. While the returned list itself will
   * never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public List<String> getJsonArray() {
    throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Returns the value of an {@code ARRAY<JSONB>}-typed instance. While the returned list itself
   * will never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public List<String> getPgJsonbArray() {
    throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Returns the value of an {@code ARRAY<PROTO>}-typed instance. While the returned list itself
   * will never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public <T extends AbstractMessage> List<T> getProtoMessageArray(T m) {
    throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Returns the value of an {@code ARRAY<ENUM>}-typed instance. While the returned list itself will
   * never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public <T extends ProtocolMessageEnum> List<T> getProtoEnumArray(
      Function<Integer, ProtocolMessageEnum> method) {
    throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Returns the value of an {@code ARRAY<BYTES>}-typed instance. While the returned list itself
   * will never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<ByteArray> getBytesArray();

  /**
   * Returns the value of an {@code ARRAY<TIMESTAMP>}-typed instance. While the returned list itself
   * will never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<Timestamp> getTimestampArray();

  /**
   * Returns the value of an {@code ARRAY<DATE>}-typed instance. While the returned list itself will
   * never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<Date> getDateArray();

  /**
   * Returns the value of an {@code ARRAY<UUID>}-typed instance. While the returned list itself will
   * never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<UUID> getUuidArray();

  /**
   * Returns the value of an {@code ARRAY<INTERVAL>}-typed instance. While the returned list itself
   * will never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<Interval> getIntervalArray();

  /**
   * Returns the value of an {@code ARRAY<STRUCT<...>>}-typed instance. While the returned list
   * itself will never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<Struct> getStructArray();

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    toString(b);
    return b.toString();
  }

  /**
   * Returns this value as a raw string representation. This is guaranteed to work for all values,
   * regardless of the underlying data type, and is guaranteed not to be truncated.
   *
   * <p>Returns the string "NULL" for null values.
   */
  @Nonnull
  public String getAsString() {
    return toString();
  }

  /**
   * Returns this value as a list of raw string representations. This is guaranteed to work for all
   * values, regardless of the underlying data type, and the strings are guaranteed not to be
   * truncated. The method returns a singleton list for non-array values and a list containing as
   * many elements as there are in the array for array values. This method can be used instead of
   * the {@link #getAsString()} method if you need to quote the individual elements in an array.
   *
   * <p>Returns the string "NULL" for null values.
   */
  @Nonnull
  public ImmutableList<String> getAsStringList() {
    return ImmutableList.of(toString());
  }

  // END OF PUBLIC API.

  static com.google.protobuf.Value toProto(Value value) {
    return value == null ? NULL_PROTO : value.toProto();
  }

  /**
   * Appends a string representation of this value to the given builder. The string representation
   * can be truncated.
   */
  abstract void toString(StringBuilder b);

  abstract com.google.protobuf.Value toProto();

  private static <T> List<T> immutableCopyOf(Iterable<T> v) {
    ArrayList<T> copy = new ArrayList<>();
    Iterables.addAll(copy, v);
    return Collections.unmodifiableList(copy);
  }

  private abstract static class PrimitiveArrayValueFactory<A, T> {
    Value create(A v, int pos, int length) {
      if (v == null) {
        return newValue(true, null, null);
      }
      A copy = newArray(length);
      System.arraycopy(v, pos, copy, 0, length);
      return newValue(false, null, copy);
    }

    Value create(@Nullable Iterable<T> v) {
      if (v == null) {
        return newValue(true, null, null);
      }
      Collection<T> values;
      if (v instanceof Collection) {
        values = (Collection<T>) v;
      } else {
        // The wrapper objects already exist (or would be created in our iterator below), and we
        // need to do the same amount of array buffering to come up with a backing array of the
        // correct size; it is as CPU-efficient to simply copy into an ArrayList (except in the rare
        // case where the underlying ArrayList buffer is exactly the size of the data - in that
        // case, we incur an additional buffer copy over managing the array ourselves).  Note that
        // this simpler strategy does use more memory for booleans though as Boolean[] uses more
        // memory than a boolean[] of the same size.
        values = Lists.newArrayList(v);
      }
      BitSet nulls = null;
      A arr = newArray(values.size());
      int i = 0;
      for (T element : values) {
        if (element == null) {
          if (nulls == null) {
            nulls = new BitSet();
          }
          nulls.set(i);
        } else {
          set(arr, i, element);
        }
        ++i;
      }
      return newValue(false, nulls, arr);
    }

    abstract A newArray(int size);

    abstract void set(A arr, int i, T value);

    abstract Value newValue(boolean isNull, BitSet nulls, A values);
  }

  private static final PrimitiveArrayValueFactory<long[], Long> int64ArrayFactory =
      new PrimitiveArrayValueFactory<long[], Long>() {
        @Override
        long[] newArray(int size) {
          return new long[size];
        }

        @Override
        void set(long[] arr, int i, Long value) {
          arr[i] = value;
        }

        @Override
        Value newValue(boolean isNull, BitSet nulls, long[] values) {
          return new Int64ArrayImpl(isNull, nulls, values);
        }
      };

  private static final PrimitiveArrayValueFactory<long[], Long> pgOidArrayFactory =
      new PrimitiveArrayValueFactory<long[], Long>() {
        @Override
        long[] newArray(int size) {
          return new long[size];
        }

        @Override
        void set(long[] arr, int i, Long value) {
          arr[i] = value;
        }

        @Override
        Value newValue(boolean isNull, BitSet nulls, long[] values) {
          return new PgOidArrayImpl(isNull, nulls, values);
        }
      };

  private static final PrimitiveArrayValueFactory<float[], Float> float32ArrayFactory =
      new PrimitiveArrayValueFactory<float[], Float>() {
        @Override
        float[] newArray(int size) {
          return new float[size];
        }

        @Override
        void set(float[] arr, int i, Float value) {
          arr[i] = value;
        }

        @Override
        Value newValue(boolean isNull, BitSet nulls, float[] values) {
          return new Float32ArrayImpl(isNull, nulls, values);
        }
      };
  private static final PrimitiveArrayValueFactory<double[], Double> float64ArrayFactory =
      new PrimitiveArrayValueFactory<double[], Double>() {
        @Override
        double[] newArray(int size) {
          return new double[size];
        }

        @Override
        void set(double[] arr, int i, Double value) {
          arr[i] = value;
        }

        @Override
        Value newValue(boolean isNull, BitSet nulls, double[] values) {
          return new Float64ArrayImpl(isNull, nulls, values);
        }
      };
  private static final PrimitiveArrayValueFactory<boolean[], Boolean> boolArrayFactory =
      new PrimitiveArrayValueFactory<boolean[], Boolean>() {
        @Override
        boolean[] newArray(int size) {
          return new boolean[size];
        }

        @Override
        void set(boolean[] arr, int i, Boolean value) {
          arr[i] = value;
        }

        @Override
        Value newValue(boolean isNull, BitSet nulls, boolean[] values) {
          return new BoolArrayImpl(isNull, nulls, values);
        }
      };

  /** Template class for {@code Value} implementations. */
  private abstract static class AbstractValue extends Value {
    private final boolean isNull;
    private final Type type;

    private AbstractValue(boolean isNull, Type type) {
      this.isNull = isNull;
      this.type = type;
    }

    @Override
    public Type getType() {
      return type;
    }

    @Override
    public final boolean isNull() {
      return isNull;
    }

    @Override
    public boolean isCommitTimestamp() {
      return false;
    }

    @Override
    public boolean getBool() {
      throw defaultGetter(Type.bool());
    }

    @Override
    public long getInt64() {
      throw defaultGetter(Type.int64());
    }

    @Override
    public float getFloat32() {
      throw defaultGetter(Type.float32());
    }

    @Override
    public double getFloat64() {
      throw defaultGetter(Type.float64());
    }

    @Override
    public BigDecimal getNumeric() {
      throw defaultGetter(Type.numeric());
    }

    @Override
    public String getString() {
      throw defaultGetter(Type.string());
    }

    @Override
    public String getJson() {
      throw defaultGetter(Type.json());
    }

    @Override
    public String getPgJsonb() {
      throw defaultGetter(Type.pgJsonb());
    }

    @Override
    public ByteArray getBytes() {
      throw defaultGetter(Type.bytes());
    }

    @Override
    public Timestamp getTimestamp() {
      throw defaultGetter(Type.timestamp());
    }

    @Override
    public Date getDate() {
      throw defaultGetter(Type.date());
    }

    @Override
    public UUID getUuid() {
      throw defaultGetter(Type.uuid());
    }

    @Override
    public Interval getInterval() {
      throw defaultGetter(Type.interval());
    }

    @Override
    public Struct getStruct() {
      if (getType().getCode() != Type.Code.STRUCT) {
        throw new IllegalStateException(
            "Illegal call to getter of incorrect type. Expected: STRUCT<...> actual: " + getType());
      }
      throw new AssertionError("Should have been overridden");
    }

    @Override
    public List<Boolean> getBoolArray() {
      throw defaultGetter(Type.array(Type.bool()));
    }

    @Override
    public List<Long> getInt64Array() {
      throw defaultGetter(Type.array(Type.int64()));
    }

    @Override
    public List<Float> getFloat32Array() {
      throw defaultGetter(Type.array(Type.float32()));
    }

    @Override
    public List<Double> getFloat64Array() {
      throw defaultGetter(Type.array(Type.float64()));
    }

    @Override
    public List<BigDecimal> getNumericArray() {
      throw defaultGetter(Type.array(Type.numeric()));
    }

    @Override
    public List<String> getStringArray() {
      throw defaultGetter(Type.array(Type.string()));
    }

    @Override
    public List<String> getJsonArray() {
      throw defaultGetter(Type.array(Type.json()));
    }

    @Override
    public List<String> getPgJsonbArray() {
      throw defaultGetter(Type.array(Type.pgJsonb()));
    }

    @Override
    public List<ByteArray> getBytesArray() {
      throw defaultGetter(Type.array(Type.bytes()));
    }

    @Override
    public List<Timestamp> getTimestampArray() {
      throw defaultGetter(Type.array(Type.timestamp()));
    }

    @Override
    public List<Date> getDateArray() {
      throw defaultGetter(Type.array(Type.date()));
    }

    @Override
    public List<UUID> getUuidArray() {
      throw defaultGetter(Type.array(Type.uuid()));
    }

    @Override
    public List<Interval> getIntervalArray() {
      throw defaultGetter(Type.array(Type.interval()));
    }

    @Override
    public List<Struct> getStructArray() {
      if (getType().getCode() != Type.Code.ARRAY
          || getType().getArrayElementType().getCode() != Type.Code.STRUCT) {
        throw new IllegalStateException(
            "Illegal call to getter of incorrect type.  Expected: ARRAY<STRUCT<...>> actual: "
                + getType());
      }
      throw new AssertionError("Should have been overridden");
    }

    @Override
    final void toString(StringBuilder b) {
      // TODO(user): Truncate long arrays.
      if (isNull()) {
        b.append(NULL_STRING);
      } else {
        valueToString(b);
      }
    }

    /**
     * Appends a representation of {@code this} to {@code b}. {@code this} is guaranteed to
     * represent a non-null value. This value could be truncated if the underlying value is long.
     */
    abstract void valueToString(StringBuilder b);

    @Override
    final com.google.protobuf.Value toProto() {
      return isNull() ? NULL_PROTO : valueToProto();
    }

    /**
     * Returns a proto representation of this value. {@code this} is guaranteed to represent a
     * non-null value.
     */
    abstract com.google.protobuf.Value valueToProto();

    @Override
    public final boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      AbstractValue that = (AbstractValue) o;
      if (!Objects.equals(getType(), that.getType()) || isNull != that.isNull) {
        return false;
      }

      return isNull || valueEquals(that);
    }

    /**
     * Returns true if {@code v} has the same value as {@code this}. {@code v} is guaranteed to have
     * the same Java class as {@code this}, and both {@code this} and {@code v} are guaranteed to
     * represent a non-null values.
     */
    abstract boolean valueEquals(Value v);

    @Override
    public final int hashCode() {
      Type typeToHash = getType();
      int valueHash = isNull ? 0 : valueHash();

      /**
       * We are relaxing equality values here, making sure that Double.NaNs and Float.NaNs are equal
       * to each other. This is because our Cloud Spanner Import / Export template in Apache Beam
       * uses the mutation equality to check for modifications before committing. We noticed that
       * when NaNs where used the template would always indicate a modification was present, when it
       * turned out not to be the case.
       *
       * <p>With FLOAT32 being introduced, we want to ensure the backward compatibility of the NaN
       * equality checks that existed for FLOAT64. We're promoting the type to FLOAT64 while
       * calculating the type hash when the value is a NaN. We're doing a similar type promotion
       * while calculating valueHash of Float32 type. Note that this is not applicable for composite
       * types containing FLOAT32.
       */
      if (type != null
          && type.getCode() == Type.Code.FLOAT32
          && !isNull
          && Float.isNaN(getFloat32())) {
        typeToHash = Type.float64();
      }

      int result = Objects.hash(typeToHash, isNull);
      if (!isNull) {
        result = 31 * result + valueHash;
      }
      return result;
    }

    /**
     * Returns a hash code for the underlying value. {@code this} is guaranteed to represent a
     * non-null value.
     */
    abstract int valueHash();

    private AssertionError defaultGetter(Type expectedType) {
      checkType(expectedType);
      throw new AssertionError("Should have been overridden");
    }

    final void checkType(Type expected) {
      if (!getType().equals(expected)) {
        throw new IllegalStateException(
            "Illegal call to getter of incorrect type.  Expected: "
                + expected
                + " actual: "
                + getType());
      }
    }

    final void checkNotNull() {
      Preconditions.checkState(!isNull(), "Illegal call to getter of null value.");
    }
  }

  /**
   * This {@link Value} implementation is backed by a generic protobuf Value instance. It is used
   * for untyped Values that are created by users, and for values with an unrecognized types that
   * coming from the backend.
   */
  private static class ProtoBackedValueImpl extends AbstractValue {
    private final com.google.protobuf.Value value;

    private ProtoBackedValueImpl(com.google.protobuf.Value value, @Nullable Type type) {
      super(value.hasNullValue(), type);
      this.value = value;
    }

    @Override
    public boolean getBool() {
      checkNotNull();
      Preconditions.checkState(value.hasBoolValue(), "This value does not contain a bool value");
      return value.getBoolValue();
    }

    @Override
    public String getString() {
      checkNotNull();
      Preconditions.checkState(
          value.hasStringValue(), "This value does not contain a string value");
      return value.getStringValue();
    }

    @Override
    public double getFloat64() {
      checkNotNull();
      Preconditions.checkState(
          value.hasNumberValue(), "This value does not contain a number value");
      return value.getNumberValue();
    }

    @Nonnull
    @Override
    public String getAsString() {
      switch (value.getKindCase()) {
        case NULL_VALUE:
          return NULL_STRING;
        case NUMBER_VALUE:
          return Double.toString(value.getNumberValue());
        case STRING_VALUE:
          return value.getStringValue();
        case BOOL_VALUE:
          return Boolean.toString(value.getBoolValue());
        case LIST_VALUE:
          return value.getListValue().getValuesList().stream()
              .map(element -> Value.untyped(element).getAsString())
              .collect(Collectors.joining(",", "[", "]"));
        case STRUCT_VALUE:
          throw new IllegalArgumentException(
              "Struct value with unrecognized type is not supported");
        case KIND_NOT_SET:
        default:
          throw new IllegalArgumentException("Kind of value is not set or unknown");
      }
    }

    @Nonnull
    @Override
    public ImmutableList<String> getAsStringList() {
      if (value.getKindCase() == KindCase.LIST_VALUE) {
        ImmutableList.Builder<String> builder = ImmutableList.builder();
        value.getListValue().getValuesList().stream()
            .map(v -> Value.untyped(v).getAsString())
            .forEach(builder::add);
        return builder.build();
      }
      return ImmutableList.of(getAsString());
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value);
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      return value;
    }

    @Override
    boolean valueEquals(Value v) {
      return ((ProtoBackedValueImpl) v).value.equals(value);
    }

    @Override
    int valueHash() {
      return value.hashCode();
    }
  }

  private static class BoolImpl extends AbstractValue {
    private final boolean value;

    private BoolImpl(boolean isNull, boolean value) {
      super(isNull, Type.bool());
      this.value = value;
    }

    @Override
    public boolean getBool() {
      checkNotNull();
      return value;
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      return com.google.protobuf.Value.newBuilder().setBoolValue(value).build();
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value);
    }

    @Override
    boolean valueEquals(Value v) {
      return ((BoolImpl) v).value == value;
    }

    @Override
    int valueHash() {
      return Boolean.valueOf(value).hashCode();
    }
  }

  private static class Int64Impl extends AbstractValue {
    private final long value;

    private Int64Impl(boolean isNull, long value) {
      super(isNull, Type.int64());
      this.value = value;
    }

    @Override
    public long getInt64() {
      checkNotNull();
      return value;
    }

    @Override
    public <T extends ProtocolMessageEnum> T getProtoEnum(
        Function<Integer, ProtocolMessageEnum> method) {
      Preconditions.checkNotNull(
          method, "Method may not be null. Use 'MyProtoEnum::forNumber' as a parameter value.");
      checkNotNull();
      return (T) method.apply((int) value);
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      return com.google.protobuf.Value.newBuilder().setStringValue(Long.toString(value)).build();
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value);
    }

    @Override
    boolean valueEquals(Value v) {
      return ((Int64Impl) v).value == value;
    }

    @Override
    int valueHash() {
      return Long.valueOf(value).hashCode();
    }
  }

  private static class Float32Impl extends AbstractValue {
    private final float value;

    private Float32Impl(boolean isNull, float value) {
      super(isNull, Type.float32());
      this.value = value;
    }

    @Override
    public float getFloat32() {
      checkNotNull();
      return value;
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      return com.google.protobuf.Value.newBuilder().setNumberValue(value).build();
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value);
    }

    @Override
    boolean valueEquals(Value v) {
      // NaN == NaN always returns false, so we need a custom check.
      if (Float.isNaN(this.value)) {
        return Float.isNaN(((Float32Impl) v).value);
      }
      return ((Float32Impl) v).value == value;
    }

    @Override
    int valueHash() {
      // For backward compatibility of NaN equality checks with Float64 NaNs.
      // Refer the comment in `Value.hashCode()` for more details.
      if (!isNull() && Float.isNaN(value)) {
        return Double.valueOf(Double.NaN).hashCode();
      }
      return Float.valueOf(value).hashCode();
    }
  }

  private static class Float64Impl extends AbstractValue {
    private final double value;

    private Float64Impl(boolean isNull, double value) {
      super(isNull, Type.float64());
      this.value = value;
    }

    @Override
    public double getFloat64() {
      checkNotNull();
      return value;
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      return com.google.protobuf.Value.newBuilder().setNumberValue(value).build();
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value);
    }

    @Override
    boolean valueEquals(Value v) {
      // NaN == NaN always returns false, so we need a custom check.
      if (Double.isNaN(this.value)) {
        return Double.isNaN(((Float64Impl) v).value);
      }
      return ((Float64Impl) v).value == value;
    }

    @Override
    int valueHash() {
      return Double.valueOf(value).hashCode();
    }
  }

  abstract static class AbstractObjectValue<T> extends AbstractValue {
    final T value;

    private AbstractObjectValue(boolean isNull, Type type, T value) {
      super(isNull, type);
      this.value = value;
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      return com.google.protobuf.Value.newBuilder().setStringValue(value.toString()).build();
    }

    @SuppressWarnings("unchecked")
    @Override
    boolean valueEquals(Value v) {
      return ((AbstractObjectValue<T>) v).value.equals(value);
    }

    @Override
    int valueHash() {
      return value.hashCode();
    }
  }

  private static class DateImpl extends AbstractObjectValue<Date> {

    private DateImpl(boolean isNull, Date value) {
      super(isNull, Type.date(), value);
    }

    @Override
    public Date getDate() {
      checkNotNull();
      return value;
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value);
    }
  }

  private static class UuidImpl extends AbstractObjectValue<UUID> {

    private UuidImpl(boolean isNull, UUID value) {
      super(isNull, Type.uuid(), value);
    }

    @Override
    public UUID getUuid() {
      checkNotNull();
      return value;
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value);
    }
  }

  private static class IntervalImpl extends AbstractObjectValue<Interval> {

    private IntervalImpl(boolean isNull, Interval value) {
      super(isNull, Type.interval(), value);
    }

    @Override
    public Interval getInterval() {
      checkNotNull();
      return value;
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value.toISO8601());
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      return com.google.protobuf.Value.newBuilder().setStringValue(value.toISO8601()).build();
    }

    @Nonnull
    @Override
    public String getAsString() {
      return isNull() ? NULL_STRING : value.toISO8601();
    }
  }

  private static class StringImpl extends AbstractObjectValue<String> {

    private StringImpl(boolean isNull, @Nullable String value) {
      super(isNull, Type.string(), value);
    }

    @Override
    public String getString() {
      checkNotNull();
      return value;
    }

    @Nonnull
    @Override
    public String getAsString() {
      return isNull() ? NULL_STRING : value;
    }

    @Override
    void valueToString(StringBuilder b) {
      if (value.length() > MAX_DEBUG_STRING_LENGTH) {
        b.append(value, 0, MAX_DEBUG_STRING_LENGTH - ELLIPSIS.length()).append(ELLIPSIS);
      } else {
        b.append(value);
      }
    }
  }

  private static class JsonImpl extends AbstractObjectValue<String> {

    private JsonImpl(boolean isNull, @Nullable String value) {
      super(isNull, Type.json(), value);
    }

    @Override
    public String getJson() {
      checkNotNull();
      return value;
    }

    @Nonnull
    @Override
    public String getAsString() {
      return isNull() ? NULL_STRING : value;
    }

    @Override
    public String getString() {
      return getJson();
    }

    @Override
    void valueToString(StringBuilder b) {
      if (value.length() > MAX_DEBUG_STRING_LENGTH) {
        b.append(value, 0, MAX_DEBUG_STRING_LENGTH - ELLIPSIS.length()).append(ELLIPSIS);
      } else {
        b.append(value);
      }
    }
  }

  private static class PgJsonbImpl extends AbstractObjectValue<String> {

    private PgJsonbImpl(boolean isNull, @Nullable String value) {
      super(isNull, Type.pgJsonb(), value);
    }

    @Override
    public String getPgJsonb() {
      checkNotNull();
      return value;
    }

    @Nonnull
    @Override
    public String getAsString() {
      return isNull() ? NULL_STRING : value;
    }

    @Override
    public String getString() {
      return getPgJsonb();
    }

    @Override
    void valueToString(StringBuilder b) {
      if (value.length() > MAX_DEBUG_STRING_LENGTH) {
        b.append(value, 0, MAX_DEBUG_STRING_LENGTH - ELLIPSIS.length()).append(ELLIPSIS);
      } else {
        b.append(value);
      }
    }
  }

  private static class PgOidImpl extends AbstractValue {
    private final long value;

    private PgOidImpl(boolean isNull, long value) {
      super(isNull, Type.pgOid());
      this.value = value;
    }

    @Override
    public long getInt64() {
      checkNotNull();
      return value;
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      return com.google.protobuf.Value.newBuilder().setStringValue(Long.toString(value)).build();
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value);
    }

    @Override
    boolean valueEquals(Value v) {
      return ((PgOidImpl) v).value == value;
    }

    @Override
    int valueHash() {
      return Long.valueOf(value).hashCode();
    }
  }

  private static class LazyBytesImpl extends AbstractObjectValue<LazyByteArray> {

    private LazyBytesImpl(boolean isNull, LazyByteArray value) {
      super(isNull, Type.bytes(), value);
    }

    private LazyBytesImpl(boolean isNull, ByteArray value) {
      super(isNull, Type.bytes(), value == null ? null : new LazyByteArray(value));
    }

    @Override
    public ByteArray getBytes() {
      checkNotNull();
      return value.getByteArray();
    }

    @Override
    public <T extends AbstractMessage> T getProtoMessage(T m) {
      Preconditions.checkNotNull(
          m,
          "Proto message may not be null. Use MyProtoClass.getDefaultInstance() as a parameter"
              + " value.");
      checkNotNull();
      try {
        return (T)
            m.toBuilder()
                .mergeFrom(
                    Base64.getDecoder()
                        .wrap(
                            CharSource.wrap(value.getBase64String())
                                .asByteSource(StandardCharsets.UTF_8)
                                .openStream()))
                .build();
      } catch (IOException ioException) {
        throw SpannerExceptionFactory.asSpannerException(ioException);
      }
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      return com.google.protobuf.Value.newBuilder().setStringValue(value.getBase64String()).build();
    }

    @Nonnull
    @Override
    public String getAsString() {
      return value == null ? NULL_STRING : value.getBase64String();
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value == null ? null : value.toString());
    }
  }

  private static class ProtoMessageImpl extends AbstractObjectValue<ByteArray> {

    private ProtoMessageImpl(boolean isNull, ByteArray serializedProtoArray, String protoTypeFqn) {
      super(isNull, Type.proto(protoTypeFqn), serializedProtoArray);
    }

    @Override
    public ByteArray getBytes() {
      checkNotNull();
      return value;
    }

    @Override
    public <T extends AbstractMessage> T getProtoMessage(T m) {
      Preconditions.checkNotNull(
          m,
          "Proto message may not be null. Use MyProtoClass.getDefaultInstance() as a parameter"
              + " value.");
      checkNotNull();
      try {
        return (T) m.toBuilder().mergeFrom(value.toByteArray()).build();
      } catch (InvalidProtocolBufferException e) {
        throw SpannerExceptionFactory.asSpannerException(e);
      }
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      String base64EncodedString = value.toBase64();
      return com.google.protobuf.Value.newBuilder().setStringValue(base64EncodedString).build();
    }

    @Nonnull
    @Override
    public String getAsString() {
      return value == null ? NULL_STRING : value.toBase64();
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value.toBase64());
    }
  }

  private static class ProtoEnumImpl extends AbstractObjectValue<Long> {

    private ProtoEnumImpl(boolean isNull, Long enumValue, String protoTypeFqn) {
      super(isNull, Type.protoEnum(protoTypeFqn), enumValue);
    }

    @Override
    public long getInt64() {
      checkNotNull();
      return value;
    }

    @Override
    public <T extends ProtocolMessageEnum> T getProtoEnum(
        Function<Integer, ProtocolMessageEnum> method) {
      Preconditions.checkNotNull(
          method, "Method may not be null. Use 'MyProtoEnum::forNumber' as a parameter value.");
      checkNotNull();
      return (T) method.apply(value.intValue());
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value.toString());
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      return com.google.protobuf.Value.newBuilder().setStringValue(Long.toString(value)).build();
    }
  }

  private static class TimestampImpl extends AbstractObjectValue<Timestamp> {

    private static final String COMMIT_TIMESTAMP_STRING = "spanner.commit_timestamp()";
    private final boolean isCommitTimestamp;

    private TimestampImpl(boolean isNull, boolean isCommitTimestamp, Timestamp value) {
      super(isNull, Type.timestamp(), value);
      this.isCommitTimestamp = isCommitTimestamp;
    }

    @Override
    public Timestamp getTimestamp() {
      checkNotNull();
      Preconditions.checkState(!isCommitTimestamp, "Commit timestamp value");
      return value;
    }

    @Override
    public boolean isCommitTimestamp() {
      return isCommitTimestamp;
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      if (isCommitTimestamp) {
        return com.google.protobuf.Value.newBuilder()
            .setStringValue(COMMIT_TIMESTAMP_STRING)
            .build();
      }
      return super.valueToProto();
    }

    @Override
    void valueToString(StringBuilder b) {
      if (isCommitTimestamp()) {
        b.append(COMMIT_TIMESTAMP_STRING);
      } else {
        b.append(value);
      }
    }

    @Override
    boolean valueEquals(Value v) {
      if (isCommitTimestamp) {
        return v.isCommitTimestamp();
      }
      if (v.isCommitTimestamp()) {
        return isCommitTimestamp;
      }
      return ((TimestampImpl) v).value.equals(value);
    }

    @Override
    int valueHash() {
      if (isCommitTimestamp) {
        return Objects.hashCode(isCommitTimestamp);
      }
      return value.hashCode();
    }
  }

  private static class NumericImpl extends AbstractObjectValue<BigDecimal> {

    private NumericImpl(boolean isNull, BigDecimal value) {
      super(isNull, Type.numeric(), value);
    }

    @Override
    public BigDecimal getNumeric() {
      checkNotNull();
      return value;
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value);
    }
  }

  private static class PgNumericImpl extends AbstractObjectValue<String> {
    private BigDecimal valueAsBigDecimal;
    private NumberFormatException bigDecimalConversionError;
    private Double valueAsDouble;
    private NumberFormatException doubleConversionError;

    private PgNumericImpl(boolean isNull, String value) {
      super(isNull, Type.pgNumeric(), value);
    }

    @Override
    public String getString() {
      checkNotNull();
      return value;
    }

    @Override
    public BigDecimal getNumeric() {
      checkNotNull();
      if (bigDecimalConversionError != null) {
        throw bigDecimalConversionError;
      }
      if (valueAsBigDecimal == null) {
        try {
          valueAsBigDecimal = new BigDecimal(value);
        } catch (NumberFormatException e) {
          bigDecimalConversionError = e;
          throw e;
        }
      }
      return valueAsBigDecimal;
    }

    @Override
    public double getFloat64() {
      checkNotNull();
      if (doubleConversionError != null) {
        throw doubleConversionError;
      }
      if (valueAsDouble == null) {
        try {
          valueAsDouble = Double.parseDouble(value);
        } catch (NumberFormatException e) {
          doubleConversionError = e;
          throw e;
        }
      }
      return valueAsDouble;
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value);
    }
  }

  private abstract static class PrimitiveArrayImpl<T> extends AbstractValue {
    private final BitSet nulls;

    private PrimitiveArrayImpl(boolean isNull, Type elementType, BitSet nulls) {
      super(isNull, Type.array(elementType));
      this.nulls = nulls;
    }

    boolean isElementNull(int i) {
      return nulls != null && nulls.get(i);
    }

    List<T> getArray() {
      checkNotNull();
      List<T> r = new ArrayList<>(size());
      for (int i = 0; i < size(); ++i) {
        r.add(isElementNull(i) ? null : getValue(i));
      }
      return r;
    }

    abstract int size();

    abstract T getValue(int i);

    abstract com.google.protobuf.Value getValueAsProto(int i);

    @Nonnull
    @Override
    public ImmutableList<String> getAsStringList() {
      ImmutableList.Builder<String> builder = ImmutableList.builder();
      for (int i = 0; i < size(); i++) {
        builder.add(isElementNull(i) ? NULL_STRING : String.valueOf(getValue(i)));
      }
      return builder.build();
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(LIST_OPEN);
      for (int i = 0; i < size(); ++i) {
        if (i > 0) {
          b.append(LIST_SEPARATOR);
        }
        if (nulls != null && nulls.get(i)) {
          b.append(NULL_STRING);
        } else {
          b.append(getValue(i));
        }
      }
      b.append(LIST_CLOSE);
    }

    @Override
    int valueHash() {
      return 31 * Objects.hashCode(nulls) + arrayHash();
    }

    abstract int arrayHash();

    @Override
    com.google.protobuf.Value valueToProto() {
      ListValue.Builder list = ListValue.newBuilder();
      for (int i = 0; i < size(); ++i) {
        if (isElementNull(i)) {
          list.addValues(NULL_PROTO);
        } else {
          list.addValues(getValueAsProto(i));
        }
      }
      return com.google.protobuf.Value.newBuilder().setListValue(list).build();
    }
  }

  private static class BoolArrayImpl extends PrimitiveArrayImpl<Boolean> {
    private final boolean[] values;

    private BoolArrayImpl(boolean isNull, BitSet nulls, boolean[] values) {
      super(isNull, Type.bool(), nulls);
      this.values = values;
    }

    @Override
    public List<Boolean> getBoolArray() {
      return getArray();
    }

    @Override
    boolean valueEquals(Value v) {
      BoolArrayImpl that = (BoolArrayImpl) v;
      return Arrays.equals(values, that.values);
    }

    @Override
    int size() {
      return values.length;
    }

    @Override
    Boolean getValue(int i) {
      return values[i];
    }

    @Override
    com.google.protobuf.Value getValueAsProto(int i) {
      return com.google.protobuf.Value.newBuilder().setBoolValue(values[i]).build();
    }

    @Override
    int arrayHash() {
      return Arrays.hashCode(values);
    }
  }

  private static class Int64ArrayImpl extends PrimitiveArrayImpl<Long> {
    private final long[] values;

    private Int64ArrayImpl(boolean isNull, BitSet nulls, long[] values) {
      super(isNull, Type.int64(), nulls);
      this.values = values;
    }

    @Override
    public List<Long> getInt64Array() {
      return getArray();
    }

    @Override
    public <T extends ProtocolMessageEnum> List<T> getProtoEnumArray(
        Function<Integer, ProtocolMessageEnum> method) {
      Preconditions.checkNotNull(
          method, "Method may not be null. Use 'MyProtoEnum::forNumber' as a parameter value.");
      checkNotNull();

      List<T> protoEnumList = new ArrayList<>();
      for (Long enumIntValue : values) {
        if (enumIntValue == null) {
          protoEnumList.add(null);
        } else {
          protoEnumList.add((T) method.apply(enumIntValue.intValue()));
        }
      }
      return protoEnumList;
    }

    @Override
    boolean valueEquals(Value v) {
      Int64ArrayImpl that = (Int64ArrayImpl) v;
      return Arrays.equals(values, that.values);
    }

    @Override
    int size() {
      return values.length;
    }

    @Override
    Long getValue(int i) {
      return values[i];
    }

    @Override
    com.google.protobuf.Value getValueAsProto(int i) {
      return com.google.protobuf.Value.newBuilder()
          .setStringValue(Long.toString(values[i]))
          .build();
    }

    @Override
    int arrayHash() {
      return Arrays.hashCode(values);
    }
  }

  private static class Float32ArrayImpl extends PrimitiveArrayImpl<Float> {
    private final float[] values;

    private Float32ArrayImpl(boolean isNull, BitSet nulls, float[] values) {
      super(isNull, Type.float32(), nulls);
      this.values = values;
    }

    @Override
    public List<Float> getFloat32Array() {
      return getArray();
    }

    @Override
    boolean valueEquals(Value v) {
      Float32ArrayImpl that = (Float32ArrayImpl) v;
      return Arrays.equals(values, that.values);
    }

    @Override
    int size() {
      return values.length;
    }

    @Override
    Float getValue(int i) {
      return values[i];
    }

    @Override
    com.google.protobuf.Value getValueAsProto(int i) {
      return com.google.protobuf.Value.newBuilder().setNumberValue(values[i]).build();
    }

    @Override
    int arrayHash() {
      return Arrays.hashCode(values);
    }
  }

  private static class Float64ArrayImpl extends PrimitiveArrayImpl<Double> {
    private final double[] values;

    private Float64ArrayImpl(boolean isNull, BitSet nulls, double[] values) {
      super(isNull, Type.float64(), nulls);
      this.values = values;
    }

    @Override
    public List<Double> getFloat64Array() {
      return getArray();
    }

    @Override
    boolean valueEquals(Value v) {
      Float64ArrayImpl that = (Float64ArrayImpl) v;
      return Arrays.equals(values, that.values);
    }

    @Override
    int size() {
      return values.length;
    }

    @Override
    Double getValue(int i) {
      return values[i];
    }

    @Override
    com.google.protobuf.Value getValueAsProto(int i) {
      return com.google.protobuf.Value.newBuilder().setNumberValue(values[i]).build();
    }

    @Override
    int arrayHash() {
      return Arrays.hashCode(values);
    }
  }

  abstract static class AbstractArrayValue<T> extends AbstractObjectValue<List<T>> {

    private AbstractArrayValue(boolean isNull, Type elementType, @Nullable List<T> values) {
      super(isNull, Type.array(elementType), values);
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      ListValue.Builder list = ListValue.newBuilder();
      for (T element : value) {
        if (element == null) {
          list.addValues(NULL_PROTO);
        } else {
          list.addValuesBuilder().setStringValue(elementToString(element));
        }
      }
      return com.google.protobuf.Value.newBuilder().setListValue(list).build();
    }

    @Nonnull
    @Override
    public ImmutableList<String> getAsStringList() {
      ImmutableList.Builder<String> builder = ImmutableList.builder();
      for (T element : value) {
        builder.add(element == null ? NULL_STRING : elementToString(element));
      }
      return builder.build();
    }

    String elementToString(T element) {
      return element.toString();
    }

    abstract void appendElement(StringBuilder b, T element);

    @Override
    void valueToString(StringBuilder b) {
      b.append(LIST_OPEN);
      for (int i = 0; i < value.size(); ++i) {
        if (i > 0) {
          b.append(LIST_SEPARATOR);
        }
        T v = value.get(i);
        if (v == null) {
          b.append(NULL_STRING);
        } else {
          appendElement(b, v);
        }
      }
      b.append(LIST_CLOSE);
    }
  }

  private static class StringArrayImpl extends AbstractArrayValue<String> {

    private StringArrayImpl(boolean isNull, @Nullable List<String> values) {
      super(isNull, Type.string(), values);
    }

    @Override
    public List<String> getStringArray() {
      checkNotNull();
      return value;
    }

    @Override
    void appendElement(StringBuilder b, String element) {
      b.append(element);
    }
  }

  private static class JsonArrayImpl extends AbstractArrayValue<String> {

    private JsonArrayImpl(boolean isNull, @Nullable List<String> values) {
      super(isNull, Type.json(), values);
    }

    @Override
    public List<String> getJsonArray() {
      checkNotNull();
      return value;
    }

    @Override
    public List<String> getStringArray() {
      return getJsonArray();
    }

    @Override
    void appendElement(StringBuilder b, String element) {
      b.append(element);
    }
  }

  private static class PgJsonbArrayImpl extends AbstractArrayValue<String> {

    private PgJsonbArrayImpl(boolean isNull, @Nullable List<String> values) {
      super(isNull, Type.pgJsonb(), values);
    }

    @Override
    public List<String> getPgJsonbArray() {
      checkNotNull();
      return value;
    }

    @Override
    public List<String> getStringArray() {
      return this.getPgJsonbArray();
    }

    @Override
    void appendElement(StringBuilder b, String element) {
      b.append(element);
    }
  }

  private static class PgOidArrayImpl extends PrimitiveArrayImpl<Long> {
    private final long[] values;

    private PgOidArrayImpl(boolean isNull, BitSet nulls, long[] values) {
      super(isNull, Type.pgOid(), nulls);
      this.values = values;
    }

    @Override
    public List<Long> getInt64Array() {
      return getArray();
    }

    @Override
    boolean valueEquals(Value v) {
      PgOidArrayImpl that = (PgOidArrayImpl) v;
      return Arrays.equals(values, that.values);
    }

    @Override
    int size() {
      return values.length;
    }

    @Override
    Long getValue(int i) {
      return values[i];
    }

    @Override
    com.google.protobuf.Value getValueAsProto(int i) {
      return com.google.protobuf.Value.newBuilder()
          .setStringValue(Long.toString(values[i]))
          .build();
    }

    @Override
    int arrayHash() {
      return Arrays.hashCode(values);
    }
  }

  private static class LazyBytesArrayImpl extends AbstractArrayValue<LazyByteArray> {
    private transient AbstractLazyInitializer<List<ByteArray>> bytesArray = defaultInitializer();

    private LazyBytesArrayImpl(boolean isNull, @Nullable List<LazyByteArray> values) {
      super(isNull, Type.bytes(), values);
    }

    private AbstractLazyInitializer<List<ByteArray>> defaultInitializer() {
      return new AbstractLazyInitializer<List<ByteArray>>() {
        @Override
        protected List<ByteArray> initialize() {
          return value.stream()
              .map(element -> element == null ? null : element.getByteArray())
              .collect(Collectors.toList());
        }
      };
    }

    private void readObject(java.io.ObjectInputStream in)
        throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      bytesArray = defaultInitializer();
    }

    @Override
    public List<ByteArray> getBytesArray() {
      checkNotNull();
      try {
        return bytesArray.get();
      } catch (Exception e) {
        throw SpannerExceptionFactory.asSpannerException(e);
      }
    }

    @Override
    public <T extends AbstractMessage> List<T> getProtoMessageArray(T m) {
      Preconditions.checkNotNull(
          m,
          "Proto message may not be null. Use MyProtoClass.getDefaultInstance() as a parameter"
              + " value.");
      checkNotNull();
      try {
        List<T> protoMessagesList = new ArrayList<>(value.size());
        for (LazyByteArray protoMessageBytes : value) {
          if (protoMessageBytes == null) {
            protoMessagesList.add(null);
          } else {
            protoMessagesList.add(
                (T)
                    m.toBuilder()
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
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    String elementToString(LazyByteArray element) {
      return element.getBase64String();
    }

    @Override
    void appendElement(StringBuilder b, LazyByteArray element) {
      b.append(elementToString(element));
    }
  }

  private static class TimestampArrayImpl extends AbstractArrayValue<Timestamp> {

    private TimestampArrayImpl(boolean isNull, @Nullable List<Timestamp> values) {
      super(isNull, Type.timestamp(), values);
    }

    @Override
    public List<Timestamp> getTimestampArray() {
      checkNotNull();
      return value;
    }

    @Override
    void appendElement(StringBuilder b, Timestamp element) {
      b.append(element);
    }
  }

  private static class ProtoMessageArrayImpl extends AbstractArrayValue<ByteArray> {

    private ProtoMessageArrayImpl(
        boolean isNull, @Nullable List<ByteArray> values, String protoTypeFqn) {
      super(isNull, Type.proto(protoTypeFqn), values);
    }

    @Override
    public List<ByteArray> getBytesArray() {
      return value;
    }

    @Override
    public <T extends AbstractMessage> List<T> getProtoMessageArray(T m) {
      Preconditions.checkNotNull(
          m,
          "Proto message may not be null. Use MyProtoClass.getDefaultInstance() as a parameter"
              + " value.");
      checkNotNull();
      try {
        List<T> protoMessagesList = new ArrayList<>(value.size());
        for (ByteArray protoMessageBytes : value) {
          if (protoMessageBytes == null) {
            protoMessagesList.add(null);
          } else {
            protoMessagesList.add(
                (T) m.toBuilder().mergeFrom(protoMessageBytes.toByteArray()).build());
          }
        }
        return protoMessagesList;
      } catch (InvalidProtocolBufferException e) {
        throw SpannerExceptionFactory.asSpannerException(e);
      }
    }

    @Override
    String elementToString(ByteArray element) {
      return element.toBase64();
    }

    @Override
    void appendElement(StringBuilder b, ByteArray element) {
      b.append(element.toBase64());
    }
  }

  private static class ProtoEnumArrayImpl extends AbstractArrayValue<Long> {

    private ProtoEnumArrayImpl(boolean isNull, @Nullable List<Long> values, String protoTypeFqn) {
      super(isNull, Type.protoEnum(protoTypeFqn), values);
    }

    @Override
    public List<Long> getInt64Array() {
      return value;
    }

    @Override
    public <T extends ProtocolMessageEnum> List<T> getProtoEnumArray(
        Function<Integer, ProtocolMessageEnum> method) {
      Preconditions.checkNotNull(
          method, "Method may not be null. Use 'MyProtoEnum::forNumber' as a parameter value.");
      checkNotNull();

      List<T> protoEnumList = new ArrayList<>();
      for (Long enumIntValue : value) {
        if (enumIntValue == null) {
          protoEnumList.add(null);
        } else {
          protoEnumList.add((T) method.apply(enumIntValue.intValue()));
        }
      }
      return protoEnumList;
    }

    @Override
    String elementToString(Long element) {
      return Long.toString(element);
    }

    @Override
    void appendElement(StringBuilder b, Long element) {
      b.append(element);
    }
  }

  private static class DateArrayImpl extends AbstractArrayValue<Date> {

    private DateArrayImpl(boolean isNull, @Nullable List<Date> values) {
      super(isNull, Type.date(), values);
    }

    @Override
    public List<Date> getDateArray() {
      checkNotNull();
      return value;
    }

    @Override
    void appendElement(StringBuilder b, Date element) {
      b.append(element);
    }
  }

  private static class UuidArrayImpl extends AbstractArrayValue<UUID> {

    private UuidArrayImpl(boolean isNull, @Nullable List<UUID> values) {
      super(isNull, Type.uuid(), values);
    }

    @Override
    public List<UUID> getUuidArray() {
      checkNotNull();
      return value;
    }

    @Override
    void appendElement(StringBuilder b, UUID element) {
      b.append(element);
    }
  }

  private static class IntervalArrayImpl extends AbstractArrayValue<Interval> {

    private IntervalArrayImpl(boolean isNull, @Nullable List<Interval> values) {
      super(isNull, Type.interval(), values);
    }

    @Override
    public List<Interval> getIntervalArray() {
      checkNotNull();
      return value;
    }

    @Override
    void appendElement(StringBuilder b, Interval element) {
      b.append(element.toISO8601());
    }

    @Override
    String elementToString(Interval element) {
      return element.toISO8601();
    }
  }

  private static class NumericArrayImpl extends AbstractArrayValue<BigDecimal> {

    private NumericArrayImpl(boolean isNull, @Nullable List<BigDecimal> values) {
      super(isNull, Type.numeric(), values);
    }

    @Override
    public List<BigDecimal> getNumericArray() {
      checkNotNull();
      return value;
    }

    @Override
    void appendElement(StringBuilder b, BigDecimal element) {
      b.append(element);
    }
  }

  private static class PgNumericArrayImpl extends AbstractArrayValue<String> {

    private List<BigDecimal> valuesAsBigDecimal;
    private NumberFormatException bigDecimalConversionError;
    private List<Double> valuesAsDouble;
    private NumberFormatException doubleConversionError;

    private PgNumericArrayImpl(boolean isNull, @Nullable List<String> values) {
      super(isNull, Type.pgNumeric(), values);
    }

    @Override
    public List<String> getStringArray() {
      checkNotNull();
      return value;
    }

    @Override
    public List<BigDecimal> getNumericArray() {
      checkNotNull();
      if (bigDecimalConversionError != null) {
        throw bigDecimalConversionError;
      }
      if (valuesAsBigDecimal == null) {
        try {
          valuesAsBigDecimal =
              value.stream()
                  .map(v -> v == null ? null : new BigDecimal(v))
                  .collect(Collectors.toList());
        } catch (NumberFormatException e) {
          bigDecimalConversionError = e;
          throw e;
        }
      }
      return valuesAsBigDecimal;
    }

    @Override
    public List<Double> getFloat64Array() {
      checkNotNull();
      if (doubleConversionError != null) {
        throw doubleConversionError;
      }
      if (valuesAsDouble == null) {
        try {
          valuesAsDouble =
              value.stream()
                  .map(v -> v == null ? null : Double.valueOf(v))
                  .collect(Collectors.toList());
        } catch (NumberFormatException e) {
          doubleConversionError = e;
          throw e;
        }
      }
      return valuesAsDouble;
    }

    @Override
    void appendElement(StringBuilder b, String element) {
      b.append(element);
    }
  }

  private static class StructImpl extends AbstractObjectValue<Struct> {

    // Constructor for non-NULL struct values.
    private StructImpl(Struct value) {
      super(false, value.getType(), value);
    }

    // Constructor for NULL struct values.
    private StructImpl(Type structType) {
      super(true, structType, null);
    }

    @Override
    public Struct getStruct() {
      checkNotNull();
      return value;
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(value);
    }

    @Override
    int valueHash() {
      return value.hashCode();
    }

    @Override
    boolean valueEquals(Value v) {
      return ((StructImpl) v).value.equals(value);
    }

    private Value getValue(int fieldIndex) {
      Type fieldType = value.getColumnType(fieldIndex);
      switch (fieldType.getCode()) {
        case BOOL:
          return Value.bool(value.getBoolean(fieldIndex));
        case INT64:
          return Value.int64(value.getLong(fieldIndex));
        case STRING:
          return Value.string(value.getString(fieldIndex));
        case JSON:
          return Value.json(value.getJson(fieldIndex));
        case PG_JSONB:
          return Value.pgJsonb(value.getPgJsonb(fieldIndex));
        case BYTES:
          return Value.bytes(value.getBytes(fieldIndex));
        case FLOAT32:
          return Value.float32(value.getFloat(fieldIndex));
        case FLOAT64:
          return Value.float64(value.getDouble(fieldIndex));
        case NUMERIC:
          return Value.numeric(value.getBigDecimal(fieldIndex));
        case PG_NUMERIC:
          return Value.pgNumeric(value.getString(fieldIndex));
        case PG_OID:
          return Value.pgOid(value.getLong(fieldIndex));
        case DATE:
          return Value.date(value.getDate(fieldIndex));
        case UUID:
          return Value.uuid(value.getUuid(fieldIndex));
        case TIMESTAMP:
          return Value.timestamp(value.getTimestamp(fieldIndex));
        case INTERVAL:
          return Value.interval(value.getInterval(fieldIndex));
        case PROTO:
          return Value.protoMessage(value.getBytes(fieldIndex), fieldType.getProtoTypeFqn());
        case ENUM:
          return Value.protoEnum(value.getLong(fieldIndex), fieldType.getProtoTypeFqn());
        case STRUCT:
          return Value.struct(value.getStruct(fieldIndex));
        case ARRAY:
          {
            Type elementType = fieldType.getArrayElementType();
            switch (elementType.getCode()) {
              case BOOL:
                return Value.boolArray(value.getBooleanList(fieldIndex));
              case INT64:
              case ENUM:
                return Value.int64Array(value.getLongList(fieldIndex));
              case STRING:
                return Value.stringArray(value.getStringList(fieldIndex));
              case JSON:
                return Value.jsonArray(value.getJsonList(fieldIndex));
              case PG_JSONB:
                return Value.pgJsonbArray(value.getPgJsonbList(fieldIndex));
              case PG_OID:
                return Value.pgOidArray(value.getLongList(fieldIndex));
              case BYTES:
              case PROTO:
                return Value.bytesArray(value.getBytesList(fieldIndex));
              case FLOAT32:
                return Value.float32Array(value.getFloatList(fieldIndex));
              case FLOAT64:
                return Value.float64Array(value.getDoubleList(fieldIndex));
              case NUMERIC:
                return Value.numericArray(value.getBigDecimalList(fieldIndex));
              case PG_NUMERIC:
                return Value.pgNumericArray(value.getStringList(fieldIndex));
              case DATE:
                return Value.dateArray(value.getDateList(fieldIndex));
              case UUID:
                return Value.uuidArray(value.getUuidList(fieldIndex));
              case TIMESTAMP:
                return Value.timestampArray(value.getTimestampList(fieldIndex));
              case INTERVAL:
                return Value.intervalArray(value.getIntervalList(fieldIndex));
              case STRUCT:
                return Value.structArray(elementType, value.getStructList(fieldIndex));
              case ARRAY:
                throw new UnsupportedOperationException(
                    "ARRAY<ARRAY...> field types are not "
                        + "supported inside STRUCT-typed values.");
              default:
                throw new IllegalArgumentException(
                    "Unrecognized array element type : " + fieldType);
            }
          }
        default:
          throw new IllegalArgumentException("Unrecognized field type : " + fieldType);
      }
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      checkNotNull();
      ListValue.Builder struct = ListValue.newBuilder();
      for (int fieldIndex = 0; fieldIndex < value.getColumnCount(); ++fieldIndex) {
        if (value.isNull(fieldIndex)) {
          struct.addValues(NULL_PROTO);
        } else {
          struct.addValues(getValue(fieldIndex).toProto());
        }
      }
      return com.google.protobuf.Value.newBuilder().setListValue(struct).build();
    }
  }

  private static class StructArrayImpl extends AbstractArrayValue<Struct> {
    private static final Joiner joiner = Joiner.on(LIST_SEPARATOR).useForNull(NULL_STRING);

    private StructArrayImpl(Type elementType, @Nullable List<Struct> values) {
      super(values == null, elementType, values);
    }

    @Override
    public List<Struct> getStructArray() {
      checkNotNull();
      return value;
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      ListValue.Builder list = ListValue.newBuilder();
      for (Struct element : value) {
        if (element == null) {
          list.addValues(NULL_PROTO);
        } else {
          list.addValues(Value.struct(element).toProto());
        }
      }
      return com.google.protobuf.Value.newBuilder().setListValue(list).build();
    }

    @Override
    void appendElement(StringBuilder b, Struct element) {
      b.append(element);
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(LIST_OPEN);
      joiner.appendTo(b, value);
      b.append(LIST_CLOSE);
    }

    @Override
    boolean valueEquals(Value v) {
      return ((StructArrayImpl) v).value.equals(value);
    }

    @Override
    int valueHash() {
      return value.hashCode();
    }
  }
}

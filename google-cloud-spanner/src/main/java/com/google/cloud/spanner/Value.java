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
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
public abstract class Value {
  private static final int MAX_DEBUG_STRING_LENGTH = 32;
  private static final String ELLIPSIS = "...";
  private static final String NULL_STRING = "NULL";
  private static final char LIST_SEPERATOR = ',';
  private static final char LIST_OPEN = '[';
  private static final char LIST_CLOSE = ']';

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
   * Returns a {@code STRING} value.
   *
   * @param v the value, which may be null
   */
  public static Value string(@Nullable String v) {
    return new StringImpl(v == null, v);
  }

  /**
   * Returns a {@code BYTES} value.
   *
   * @param v the value, which may be null
   */
  public static Value bytes(@Nullable ByteArray v) {
    return new BytesImpl(v == null, v);
  }

  /** Returns a {@code TIMESTAMP} value. */
  public static Value timestamp(@Nullable Timestamp v) {
    return new TimestampImpl(v == null, v);
  }

  /** Returns a {@code DATE} value. */
  public static Value date(@Nullable Date v) {
    return new DateImpl(v == null, v);
  }

  // TODO(user): Implement struct()/structArray().

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
   * Returns an {@code ARRAY<STRING>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value stringArray(@Nullable Iterable<String> v) {
    return new StringArrayImpl(v == null, v == null ? null : immutableCopyOf(v));
  }

  /**
   * Returns an {@code ARRAY<BYTES>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value bytesArray(@Nullable Iterable<ByteArray> v) {
    return new BytesArrayImpl(v == null, v == null ? null : immutableCopyOf(v));
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
   * Returns an {@code ARRAY<DATE>} value.
   *
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  public static Value dateArray(@Nullable Iterable<Date> v) {
    return new DateArrayImpl(v == null, v == null ? null : immutableCopyOf(v));
  }

  private Value() {}

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
   * Returns the value of a {@code FLOAT64}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract double getFloat64();

  /**
   * Returns the value of a {@code STRING}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract String getString();

  /**
   * Returns the value of a {@code BYTES}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract ByteArray getBytes();

  /**
   * Returns the value of a {@code TIMESTAMP}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract Timestamp getTimestamp();

  /**
   * Returns the value of a {@code DATE}-typed instance.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract Date getDate();

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
   * Returns the value of an {@code ARRAY<FLOAT64>}-typed instance. While the returned list itself
   * will never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<Double> getFloat64Array();

  /**
   * Returns the value of an {@code ARRAY<STRING>}-typed instance. While the returned list itself
   * will never be {@code null}, elements of that list may be null.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  public abstract List<String> getStringArray();

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

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    toString(b);
    return b.toString();
  }

  // END OF PUBLIC API.

  /**
   * Returns an {@code ARRAY<STRUCT<...>>} value.
   *
   * <p>This method is intentionally not in the public API for Value: {@code ARRAY<STRUCT<...>>}
   * values are not accepted by the backend.
   *
   * @param fieldTypes the types of the fields in the array elements. All non-null elements must
   *     conform to this type.
   * @param v the source of element values. This may be {@code null} to produce a value for which
   *     {@code isNull()} is {@code true}. Individual elements may also be {@code null}.
   */
  static Value structArray(Iterable<Type.StructField> fieldTypes, @Nullable Iterable<Struct> v) {
    Type elementType = Type.struct(fieldTypes);
    if (v == null) {
      return new StructArrayImpl(elementType, null);
    }
    List<Struct> values = immutableCopyOf(v);
    for (Struct value : values) {
      if (value != null && !value.getType().equals(elementType)) {
        throw new IllegalArgumentException(
            "Members of v must have type " + elementType + " (found " + value.getType() + ")");
      }
    }
    return new StructArrayImpl(elementType, values);
  }

  /**
   * Returns the value of an {@code ARRAY<STRUCT<...>>}-typed instance. While the returned list
   * itself will never be {@code null}, elements of that list may be null.
   *
   * <p>This method is intentionally not in the public API for Value: {@code ARRAY<STRUCT<...>>}
   * values are not accepted by the backend.
   *
   * @throws IllegalStateException if {@code isNull()} or the value is not of the expected type
   */
  abstract List<Struct> getStructArray();

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
    static final com.google.protobuf.Value NULL_PROTO =
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();

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
    public boolean getBool() {
      throw defaultGetter(Type.bool());
    }

    @Override
    public long getInt64() {
      throw defaultGetter(Type.int64());
    }

    @Override
    public double getFloat64() {
      throw defaultGetter(Type.float64());
    }

    @Override
    public String getString() {
      throw defaultGetter(Type.string());
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
    public List<Boolean> getBoolArray() {
      throw defaultGetter(Type.array(Type.bool()));
    }

    @Override
    public List<Long> getInt64Array() {
      throw defaultGetter(Type.array(Type.int64()));
    }

    @Override
    public List<Double> getFloat64Array() {
      throw defaultGetter(Type.array(Type.float64()));
    }

    @Override
    public List<String> getStringArray() {
      throw defaultGetter(Type.array(Type.string()));
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
    List<Struct> getStructArray() {
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
     * represent a non-null value.
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
      if (!getType().equals(that.getType()) || isNull != that.isNull) {
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
      int result = Objects.hash(getType(), isNull);
      if (!isNull) {
        result = 31 * result + valueHash();
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

  private static class BoolImpl extends AbstractValue {
    private final boolean value;

    private BoolImpl(boolean isNull, boolean value) {
      super(isNull, Type.bool());
      this.value = value;
    }

    @Override
    public boolean getBool() {
      checkType(Type.bool());
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
      checkType(Type.int64());
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
      return ((Int64Impl) v).value == value;
    }

    @Override
    int valueHash() {
      return Long.valueOf(value).hashCode();
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
      checkType(Type.float64());
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

  private static class StringImpl extends AbstractObjectValue<String> {

    private StringImpl(boolean isNull, @Nullable String value) {
      super(isNull, Type.string(), value);
    }

    @Override
    public String getString() {
      checkType(Type.string());
      checkNotNull();
      return value;
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

  private static class BytesImpl extends AbstractObjectValue<ByteArray> {

    private BytesImpl(boolean isNull, ByteArray value) {
      super(isNull, Type.bytes(), value);
    }

    @Override
    public ByteArray getBytes() {
      checkType(Type.bytes());
      checkNotNull();
      return value;
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      return com.google.protobuf.Value.newBuilder()
          .setStringValue(ByteArrays.toBase64(value))
          .build();
    }

    @Override
    void valueToString(StringBuilder b) {
      ByteArrays.appendToString(value, b, MAX_DEBUG_STRING_LENGTH);
    }
  }

  private static class TimestampImpl extends AbstractObjectValue<Timestamp> {

    private TimestampImpl(boolean isNull, Timestamp value) {
      super(isNull, Type.timestamp(), value);
    }

    @Override
    public Timestamp getTimestamp() {
      checkType(Type.timestamp());
      checkNotNull();
      return value;
    }

    @Override
    void valueToString(StringBuilder b) {
      value.toString(b);
    }
  }

  private static class DateImpl extends AbstractObjectValue<Date> {

    private DateImpl(boolean isNull, Date value) {
      super(isNull, Type.date(), value);
    }

    @Override
    public Date getDate() {
      checkType(Type.date());
      checkNotNull();
      return value;
    }

    @Override
    void valueToString(StringBuilder b) {
      value.toString(b);
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
      checkType(getType());
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

    @Override
    void valueToString(StringBuilder b) {
      b.append(LIST_OPEN);
      for (int i = 0; i < size(); ++i) {
        if (i > 0) {
          b.append(LIST_SEPERATOR);
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

    String elementToString(T element) {
      return element.toString();
    }

    abstract void appendElement(StringBuilder b, T element);

    @Override
    void valueToString(StringBuilder b) {
      b.append(LIST_OPEN);
      for (int i = 0; i < value.size(); ++i) {
        if (i > 0) {
          b.append(LIST_SEPERATOR);
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
      checkType(getType());
      checkNotNull();
      return value;
    }

    @Override
    void appendElement(StringBuilder b, String element) {
      b.append(element);
    }
  }

  private static class BytesArrayImpl extends AbstractArrayValue<ByteArray> {
    private BytesArrayImpl(boolean isNull, @Nullable List<ByteArray> values) {
      super(isNull, Type.bytes(), values);
    }

    @Override
    public List<ByteArray> getBytesArray() {
      checkType(getType());
      checkNotNull();
      return value;
    }

    @Override
    String elementToString(ByteArray element) {
      return ByteArrays.toBase64(element);
    }

    @Override
    void appendElement(StringBuilder b, ByteArray element) {
      ByteArrays.appendToString(element, b, MAX_DEBUG_STRING_LENGTH);
    }
  }

  private static class TimestampArrayImpl extends AbstractArrayValue<Timestamp> {

    private TimestampArrayImpl(boolean isNull, @Nullable List<Timestamp> values) {
      super(isNull, Type.timestamp(), values);
    }

    @Override
    public List<Timestamp> getTimestampArray() {
      checkType(getType());
      checkNotNull();
      return value;
    }

    @Override
    void appendElement(StringBuilder b, Timestamp element) {
      element.toString(b);
    }
  }

  private static class DateArrayImpl extends AbstractArrayValue<Date> {

    private DateArrayImpl(boolean isNull, @Nullable List<Date> values) {
      super(isNull, Type.date(), values);
    }

    @Override
    public List<Date> getDateArray() {
      checkType(getType());
      checkNotNull();
      return value;
    }

    @Override
    void appendElement(StringBuilder b, Date element) {
      element.toString(b);
    }
  }

  private static class StructArrayImpl extends AbstractValue {
    private static final Joiner joiner = Joiner.on(LIST_SEPERATOR).useForNull(NULL_STRING);

    private final List<Struct> values;

    private StructArrayImpl(Type elementType, @Nullable List<Struct> values) {
      super(values == null, Type.array(elementType));
      this.values = values;
    }

    @Override
    public List<Struct> getStructArray() {
      checkType(getType());
      checkNotNull();
      return values;
    }

    @Override
    com.google.protobuf.Value valueToProto() {
      throw new UnsupportedOperationException("ARRAY<STRUCT<...>> cannot be serialized to proto");
    }

    @Override
    void valueToString(StringBuilder b) {
      b.append(LIST_OPEN);
      joiner.appendTo(b, values);
      b.append(LIST_CLOSE);
    }

    @Override
    boolean valueEquals(Value v) {
      return ((StructArrayImpl) v).values.equals(values);
    }

    @Override
    int valueHash() {
      return values.hashCode();
    }
  }
}

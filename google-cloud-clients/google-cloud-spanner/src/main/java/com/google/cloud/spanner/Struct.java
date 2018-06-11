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

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Type.Code;
import com.google.cloud.spanner.Type.StructField;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Longs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.concurrent.Immutable;

/**
 * Represents a non-{@code NULL} value of {@link Type.Code#STRUCT}. Such values are a tuple of named
 * and typed columns, where individual columns may be null. Individual rows from a read or query
 * operation can be considered as structs; {@link ResultSet#getCurrentRowAsStruct()} allows an
 * immutable struct to be created from the row that the result set is currently positioned over.
 *
 * <p>{@code Struct} instances are immutable.
 *
 * <p>This class does not support representing typed {@code NULL} {@code Struct} values.
 *
 * <p>However, struct values <em>inside</em> SQL queries are always typed and can be externally
 * supplied to a query only in the form of struct/array-of-struct query parameter values for which
 * typed {@code NULL} struct values can be specified in the following ways:
 *
 * <p>1. As a standalone {@code NULL} struct value or as a nested struct field value, constructed
 * using {@link ValueBinder#to(Type, Struct)} or {@link Value#struct(Type, Struct)}.
 *
 * <p>2. As as a null {@code Struct} reference representing a {@code NULL} struct typed element
 * value inside an array/list of '{@code Struct}' references, that is used to construct an
 * array-of-struct value using {@link Value#structArray(Type, Iterable)} or {@link
 * ValueBinder#toStructArray(Type, Iterable)}. In this case, the type of the {@code NULL} struct
 * value is assumed to be the same as the explicitly specified struct element type of the
 * array/list.
 */
@Immutable
public abstract class Struct extends AbstractStructReader implements Serializable {
  // Only implementations within the package are allowed.
  Struct() {}

  /** Returns a builder for creating a non-{@code NULL} {@code Struct} instance. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Builder for constructing non-{@code NULL} {@code Struct} instances. */
  public static final class Builder {
    private final List<Type.StructField> types = new ArrayList<>();
    private final List<Value> values = new ArrayList<>();
    private final ValueBinder<Builder> binder;
    private String currentField;

    private Builder() {
      this.binder =
          new ValueBinder<Builder>() {
            @Override
            Builder handle(Value value) {
              checkBindingInProgress(true);
              addInternal(currentField, value);
              currentField = null;
              return Builder.this;
            }
          };
    }

    /**
     * Returns a binder to set the value of a new field in the struct named {@code fieldName}.
     *
     * @param fieldName name of the field to set. Can be empty or the same as an existing field name
     *     in the {@code STRUCT}
     */
    public ValueBinder<Builder> set(String fieldName) {
      checkBindingInProgress(false);
      currentField = checkNotNull(fieldName);
      return binder;
    }

    /** Adds a new unnamed field {@code fieldName} with the given value. */
    public Builder add(Value value) {
      checkBindingInProgress(false);
      addInternal("", value);
      return this;
    }

    public Struct build() {
      checkBindingInProgress(false);
      return new ValueListStruct(types, values);
    }

    private void addInternal(String fieldName, Value value) {
      types.add(Type.StructField.of(fieldName, value.getType()));
      values.add(value);
    }

    private void checkBindingInProgress(boolean expectInProgress) {
      if (expectInProgress) {
        checkState(currentField != null, "No binding currently active");
      } else if (currentField != null) {
        throw new IllegalStateException("Incomplete binding for column " + currentField);
      }
    }
  }

  /**
   * TODO(user) : Consider moving these methods to the StructReader interface once STRUCT-typed
   * columns are supported in {@link ResultSet}.
   */

  /* Public methods for accessing struct-typed fields */
  public Struct getStruct(int columnIndex) {
    checkNonNullStruct(columnIndex, columnIndex);
    return getStructInternal(columnIndex);
  }

  public Struct getStruct(String columnName) {
    int columnIndex = getColumnIndex(columnName);
    checkNonNullStruct(columnIndex, columnName);
    return getStructInternal(columnIndex);
  }

  /* Sub-classes must implement this method */
  protected abstract Struct getStructInternal(int columnIndex);

  private void checkNonNullStruct(int columnIndex, Object columnNameForError) {
    Type actualType = getColumnType(columnIndex);
    checkState(
        actualType.getCode() == Code.STRUCT,
        "Column %s is not of correct type: expected STRUCT<...> but was %s",
        columnNameForError,
        actualType);
    checkNonNull(columnIndex, columnNameForError);
  }

  /** Default implementation for value structs produced by {@link Builder}. */
  private static class ValueListStruct extends Struct {
    private final Type type;
    private final List<Value> values;

    private ValueListStruct(Iterable<StructField> types, Iterable<Value> values) {
      this.type = Type.struct(types);
      this.values = ImmutableList.copyOf(values);
    }

    @Override
    protected boolean getBooleanInternal(int columnIndex) {
      return values.get(columnIndex).getBool();
    }

    @Override
    protected long getLongInternal(int columnIndex) {
      return values.get(columnIndex).getInt64();
    }

    @Override
    protected double getDoubleInternal(int columnIndex) {
      return values.get(columnIndex).getFloat64();
    }

    @Override
    protected String getStringInternal(int columnIndex) {
      return values.get(columnIndex).getString();
    }

    @Override
    protected ByteArray getBytesInternal(int columnIndex) {
      return values.get(columnIndex).getBytes();
    }

    @Override
    protected Timestamp getTimestampInternal(int columnIndex) {
      return values.get(columnIndex).getTimestamp();
    }

    @Override
    protected Date getDateInternal(int columnIndex) {
      return values.get(columnIndex).getDate();
    }

    @Override
    protected Struct getStructInternal(int columnIndex) {
      return values.get(columnIndex).getStruct();
    }

    @Override
    protected boolean[] getBooleanArrayInternal(int columnIndex) {
      return Booleans.toArray(getBooleanListInternal(columnIndex));
    }

    @Override
    protected List<Boolean> getBooleanListInternal(int columnIndex) {
      return values.get(columnIndex).getBoolArray();
    }

    @Override
    protected long[] getLongArrayInternal(int columnIndex) {
      return Longs.toArray(getLongListInternal(columnIndex));
    }

    @Override
    protected List<Long> getLongListInternal(int columnIndex) {
      return values.get(columnIndex).getInt64Array();
    }

    @Override
    protected double[] getDoubleArrayInternal(int columnIndex) {
      return Doubles.toArray(getDoubleListInternal(columnIndex));
    }

    @Override
    protected List<Double> getDoubleListInternal(int columnIndex) {
      return values.get(columnIndex).getFloat64Array();
    }

    @Override
    protected List<String> getStringListInternal(int columnIndex) {
      return values.get(columnIndex).getStringArray();
    }

    @Override
    protected List<ByteArray> getBytesListInternal(int columnIndex) {
      return values.get(columnIndex).getBytesArray();
    }

    @Override
    protected List<Timestamp> getTimestampListInternal(int columnIndex) {
      return values.get(columnIndex).getTimestampArray();
    }

    @Override
    protected List<Date> getDateListInternal(int columnIndex) {
      return values.get(columnIndex).getDateArray();
    }

    @Override
    protected List<Struct> getStructListInternal(int columnIndex) {
      return values.get(columnIndex).getStructArray();
    }

    @Override
    public Type getType() {
      return type;
    }

    @Override
    public boolean isNull(int columnIndex) {
      return values.get(columnIndex).isNull();
    }

    @Override
    public String toString() {
      // TODO(user): Consider pulling a generic toString() up to Struct.
      return values.toString();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Struct)) {
      return false;
    }

    Struct that = (Struct) o;

    if (!getType().equals(that.getType())) {
      return false;
    }
    for (int i = 0; i < getColumnCount(); ++i) {
      if (!Objects.equals(getAsObject(i), that.getAsObject(i))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = getType().hashCode();
    for (int i = 0; i < getColumnCount(); ++i) {
      result = 31 * result + Objects.hashCode(getAsObject(i));
    }
    return result;
  }

  private Object getAsObject(int columnIndex) {
    Type type = getColumnType(columnIndex);
    if (isNull(columnIndex)) {
      return null;
    }
    switch (type.getCode()) {
      case BOOL:
        return getBooleanInternal(columnIndex);
      case INT64:
        return getLongInternal(columnIndex);
      case FLOAT64:
        return getDoubleInternal(columnIndex);
      case STRING:
        return getStringInternal(columnIndex);
      case BYTES:
        return getBytesInternal(columnIndex);
      case TIMESTAMP:
        return getTimestampInternal(columnIndex);
      case DATE:
        return getDateInternal(columnIndex);
      case STRUCT:
        return getStructInternal(columnIndex);
      case ARRAY:
        switch (type.getArrayElementType().getCode()) {
          case BOOL:
            return getBooleanListInternal(columnIndex);
          case INT64:
            return getLongListInternal(columnIndex);
          case FLOAT64:
            return getDoubleListInternal(columnIndex);
          case STRING:
            return getStringListInternal(columnIndex);
          case BYTES:
            return getBytesListInternal(columnIndex);
          case TIMESTAMP:
            return getTimestampListInternal(columnIndex);
          case DATE:
            return getDateListInternal(columnIndex);
          case STRUCT:
            return getStructListInternal(columnIndex);
          default:
            throw new AssertionError("Invalid type " + type);
        }
      default:
        throw new AssertionError("Invalid type " + type);
    }
  }
}

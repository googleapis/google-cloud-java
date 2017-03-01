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

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.cloud.ByteArray;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/**
 * Represents a value of {@link Type.Code#STRUCT}. Such values are a tuple of named and typed
 * columns, where individual columns may be null. Individual rows from a read or query operation can
 * be considered as structs; {@link ResultSet#getCurrentRowAsStruct()} allows an immutable struct to
 * be created from the row that the result set is currently positioned over.
 *
 * <p>{@code Struct} instances are immutable.
 */
@Immutable
public abstract class Struct extends AbstractStructReader {
  // Only implementations within the package are allowed.
  Struct() {}

  /**
   * Returns a builder for creating a {@code Struct} instance. This is intended mainly for test
   * purposes: the library implementation is typically responsible for creating {@code Struct}
   * instances.
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Builder for {@code Struct} instances. */
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

    /** Returns a binder to set the value of a new field in the struct named {@code fieldName}. */
    public ValueBinder<Builder> set(String fieldName) {
      checkBindingInProgress(false);
      currentField = checkNotNull(fieldName);
      return binder;
    }

    /** Adds a new field named {@code fieldName} with the given value. */
    public Builder add(String fieldName, Value value) {
      checkBindingInProgress(false);
      addInternal(fieldName, value);
      return this;
    }

    /**
     * Adds a new field of type {@code ARRAY<STRUCT<fieldTypes>>} named {@code fieldName} with the
     * given element values. {@code elements} may be null, as may any member of {@code elements}.
     * All non-null members of {@code elements} must be of type {@code STRUCT<fieldTypes>}
     */
    public Builder add(
        String fieldName,
        Iterable<Type.StructField> fieldTypes,
        @Nullable Iterable<Struct> elements) {
      return add(fieldName, Value.structArray(fieldTypes, elements));
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

  /** Default implementation for test value structs produced by {@link Builder}. */
  private static class ValueListStruct extends Struct {
    private final Type type;
    private final List<Value> values;

    private ValueListStruct(List<Type.StructField> types, List<Value> values) {
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

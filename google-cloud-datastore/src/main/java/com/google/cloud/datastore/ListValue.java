/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud.datastore;

import static com.google.datastore.v1.Value.ARRAY_VALUE_FIELD_NUMBER;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * A Google Cloud Datastore list value. A list value is a list of {@link Value} objects.
 */
public final class ListValue extends Value<List<? extends Value<?>>> {

  private static final long serialVersionUID = -5461475706792576395L;

  static final BaseMarshaller<List<? extends Value<?>>, ListValue, Builder> MARSHALLER =
      new BaseMarshaller<List<? extends Value<?>>, ListValue, Builder>() {

        private static final long serialVersionUID = -3193794036327640106L;

        @Override
        public int getProtoFieldId() {
          return ARRAY_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(List<? extends Value<?>> values) {
          return builder().set(values);
        }

        @Override
        protected List<Value<?>> getValue(com.google.datastore.v1.Value from) {
          List<Value<?>> properties = new ArrayList<>(from.getArrayValue().getValuesCount());
          for (com.google.datastore.v1.Value valuePb : from.getArrayValue().getValuesList()) {
            properties.add(Value.fromPb(valuePb));
          }
          return properties;
        }

        @Override
        protected void setValue(ListValue from, com.google.datastore.v1.Value.Builder to) {
          List<com.google.datastore.v1.Value> propertiesPb = new ArrayList<com.google.datastore.v1.Value>();
          for (Value<?> property : from.get()) {
            propertiesPb.add(property.toPb());
          }
          to.setArrayValue(com.google.datastore.v1.ArrayValue.newBuilder()
              .addAllValues(propertiesPb));
        }
      };

  public static final class Builder extends
      Value.BaseBuilder<List<? extends Value<?>>, ListValue, Builder> {

    private ImmutableList.Builder<Value<?>> listBuilder = ImmutableList.builder();

    private Builder() {
      super(ValueType.LIST);
    }

    private void addValueHelper(Value<?> value) {
      // see datastore.proto definition for list_value
      Preconditions.checkArgument(value.type() != ValueType.LIST, "Cannot contain another list");
      listBuilder.add(value);
    }

    /**
     * Adds the provided values to the {@code ListValue} builder.
     */
    public Builder addValue(Value<?> first, Value<?>... other) {
      addValueHelper(first);
      for (Value<?> value : other) {
        addValueHelper(value);
      }
      return this;
    }

    /**
     * Adds the provided string values to the {@code ListValue} builder.
     */
    public Builder addValue(String first, String... other) {
      listBuilder.add(StringValue.of(first));
      for (String value : other) {
        listBuilder.add(StringValue.of(value));
      }
      return this;
    }

    /**
     * Adds the provided long values to the {@code ListValue} builder.
     */
    public Builder addValue(long first, long... other) {
      listBuilder.add(LongValue.of(first));
      for (long value : other) {
        listBuilder.add(LongValue.of(value));
      }
      return this;
    }

    /**
     * Adds the provided double values to the {@code ListValue} builder.
     */
    public Builder addValue(double first, double... other) {
      listBuilder.add(DoubleValue.of(first));
      for (double value : other) {
        listBuilder.add(DoubleValue.of(value));
      }
      return this;
    }

    /**
     * Adds the provided boolean values to the {@code ListValue} builder.
     */
    public Builder addValue(boolean first, boolean... other) {
      listBuilder.add(BooleanValue.of(first));
      for (boolean value : other) {
        listBuilder.add(BooleanValue.of(value));
      }
      return this;
    }

    /**
     * Adds the provided {@code DateTime} values to the {@code ListValue} builder.
     */
    public Builder addValue(DateTime first, DateTime... other) {
      listBuilder.add(DateTimeValue.of(first));
      for (DateTime value : other) {
        listBuilder.add(DateTimeValue.of(value));
      }
      return this;
    }

    /**
     * Adds the provided {@code LatLng} values to the {@code ListValue} builder.
     */
    public Builder addValue(LatLng first, LatLng... other) {
      listBuilder.add(LatLngValue.of(first));
      for (LatLng value : other) {
        listBuilder.add(LatLngValue.of(value));
      }
      return this;
    }

    /**
     * Adds the provided {@code Key} values to the {@code ListValue} builder.
     */
    public Builder addValue(Key first, Key... other) {
      listBuilder.add(KeyValue.of(first));
      for (Key value : other) {
        listBuilder.add(KeyValue.of(value));
      }
      return this;
    }

    /**
     * Adds the provided {@code FullEntity} values to the {@code ListValue} builder.
     */
    public Builder addValue(FullEntity<?> first, FullEntity<?>... other) {
      listBuilder.add(EntityValue.of(first));
      for (FullEntity<?> value : other) {
        listBuilder.add(EntityValue.of(value));
      }
      return this;
    }

    /**
     * Adds the provided {@code Blob} values to the {@code ListValue} builder.
     */
    public Builder addValue(Blob first, Blob... other) {
      listBuilder.add(BlobValue.of(first));
      for (Blob value : other) {
        listBuilder.add(BlobValue.of(value));
      }
      return this;
    }

    /**
     * Sets the list of values of this {@code ListValue} builder to {@code values}. The provided
     * list is copied.
     *
     * @see com.google.cloud.datastore.Value.BaseBuilder#set(java.lang.Object)
     */
    @Override
    public Builder set(List<? extends Value<?>> values) {
      listBuilder = ImmutableList.builder();
      for (Value<?> value : values) {
        addValue(value);
      }
      return this;
    }

    @Override
    public List<? extends Value<?>> get() {
      return listBuilder.build();
    }

    /**
     * Creates a {@code ListValue} object.
     */
    @Override
    public ListValue build() {
      return new ListValue(this);
    }
  }

  public ListValue(List<? extends Value<?>> values) {
    this(builder().set(values));
  }

  public ListValue(Value<?> first, Value<?>... other) {
    this(new Builder().addValue(first, other));
  }

  private ListValue(Builder builder) {
    super(builder);
  }

  /**
   * Returns a builder for the list value object.
   */
  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  /**
   * Creates a {@code ListValue} object given a list of {@code Value} objects.
   */
  public static ListValue of(List<? extends Value<?>> values) {
    return new ListValue(values);
  }

  /**
   * Creates a {@code ListValue} object given a number of {@code Value} objects.
   */
  public static ListValue of(Value<?> first, Value<?>... other) {
    return new ListValue(first, other);
  }

  /**
   * Creates a {@code ListValue} object given a number of string values.
   */
  public static ListValue of(String first, String... other) {
    return builder().addValue(first, other).build();
  }

  /**
   * Creates a {@code ListValue} object given a number of long values.
   */
  public static ListValue of(long first, long... other) {
    return builder().addValue(first, other).build();
  }

  /**
   * Creates a {@code ListValue} object given a number of double values.
   */
  public static ListValue of(double first, double... other) {
    return builder().addValue(first, other).build();
  }

  /**
   * Creates a {@code ListValue} object given a number of boolean values.
   */
  public static ListValue of(boolean first, boolean... other) {
    return builder().addValue(first, other).build();
  }

  /**
   * Creates a {@code ListValue} object given a number of {@code DateTime} values.
   */
  public static ListValue of(DateTime first, DateTime... other) {
    return builder().addValue(first, other).build();
  }

  /**
   * Creates a {@code ListValue} object given a number of {@code LatLng} values.
   */
  public static ListValue of(LatLng first, LatLng... other) {
    return builder().addValue(first, other).build();
  }

  /**
   * Creates a {@code ListValue} object given a number of {@code Key} values.
   */
  public static ListValue of(Key first, Key... other) {
    return builder().addValue(first, other).build();
  }

  /**
   * Creates a {@code ListValue} object given a number of {@code FullEntity} values.
   */
  public static ListValue of(FullEntity<?> first, FullEntity<?>... other) {
    return builder().addValue(first, other).build();
  }

  /**
   * Creates a {@code ListValue} object given a number of {@code Blob} values.
   */
  public static ListValue of(Blob first, Blob... other) {
    return builder().addValue(first, other).build();
  }

  /**
   * Returns a builder for {@code ListValue} objects.
   */
  public static Builder builder() {
    return new Builder();
  }
}

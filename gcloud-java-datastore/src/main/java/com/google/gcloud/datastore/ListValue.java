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

package com.google.gcloud.datastore;

import static com.google.datastore.v1beta3.Value.ARRAY_VALUE_FIELD_NUMBER;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

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
        protected List<Value<?>> getValue(com.google.datastore.v1beta3.Value from) {
          List<Value<?>> properties = new ArrayList<>(from.getArrayValue().getValuesCount());
          for (com.google.datastore.v1beta3.Value valuePb : from.getArrayValue().getValuesList()) {
            properties.add(Value.fromPb(valuePb));
          }
          return properties;
        }

        @Override
        protected void setValue(ListValue from, com.google.datastore.v1beta3.Value.Builder to) {
          List<com.google.datastore.v1beta3.Value> propertiesPb =
              new ArrayList<com.google.datastore.v1beta3.Value>();
          for (Value<?> property : from.get()) {
            propertiesPb.add(property.toPb());
          }
          to.setArrayValue(com.google.datastore.v1beta3.ArrayValue.newBuilder()
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

    public Builder addValue(Value<?> first, Value<?>... other) {
      addValueHelper(first);
      for (Value<?> value : other) {
        addValueHelper(value);
      }
      return this;
    }

    /**
     * Copy the list of values.
     *
     * @see com.google.gcloud.datastore.Value.BaseBuilder#set(java.lang.Object)
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

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static ListValue of(List<? extends Value<?>> values) {
    return new ListValue(values);
  }

  public static ListValue of(Value<?> first, Value<?>... other) {
    return new ListValue(first, other);
  }

  public static Builder builder() {
    return new Builder();
  }
}

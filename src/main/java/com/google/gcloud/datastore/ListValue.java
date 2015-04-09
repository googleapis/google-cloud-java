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

import static com.google.api.services.datastore.DatastoreV1.Value.LIST_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;
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
          return LIST_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(List<? extends Value<?>> values) {
          return builder().set(values);
        }

        @Override
        protected List<Value<?>> getValue(DatastoreV1.Value from) {
          List<Value<?>> properties = new ArrayList<>(from.getListValueCount());
          for (DatastoreV1.Value valuePb : from.getListValueList()) {
            properties.add(Value.fromPb(valuePb));
          }
          return properties;
        }

        @Override
        protected void setValue(ListValue from, DatastoreV1.Value.Builder to) {
          for (Value<?> property : from.get()) {
            to.addListValue(property.toPb());
          }
        }
      };

  public static final class Builder extends
      Value.BaseBuilder<List<? extends Value<?>>, ListValue, Builder> {

    private ImmutableList.Builder<Value<?>> listBuilder = ImmutableList.builder();

    private Builder() {
      super(ValueType.LIST);
    }

    public Builder addValue(Value<?> value) {
      // see datastore_v1.proto definition for list_value
      Preconditions.checkArgument(value.type() != ValueType.LIST, "Cannot contain another list");
      listBuilder.add(value);
      return this;
    }

    public Builder addValue(Value<?> first, Value<?>... other) {
      addValue(first);
      for (Value<?> value : other) {
        addValue(value);
      }
      return this;
    }

    @Override
    public Builder indexed(boolean indexed) {
      // see issue #26
      throw DatastoreServiceException.throwInvalidRequest("ListValue can't specify index");
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
      Preconditions.checkState(!get().isEmpty(), "value list could not be empty");
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

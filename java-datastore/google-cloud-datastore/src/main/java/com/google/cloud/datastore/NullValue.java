/*
 * Copyright 2015 Google LLC
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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.datastore.v1.Value.NULL_VALUE_FIELD_NUMBER;

public final class NullValue extends Value<Void> {

  private static final long serialVersionUID = 2089084567599008130L;

  static final BaseMarshaller<Void, NullValue, Builder> MARSHALLER =
      new BaseMarshaller<Void, NullValue, Builder>() {

        private static final long serialVersionUID = 6997769137212338027L;

        @Override
        public Builder newBuilder(Void value) {
          return NullValue.newBuilder();
        }

        @Override
        public int getProtoFieldId() {
          return NULL_VALUE_FIELD_NUMBER;
        }

        @Override
        protected Void getValue(com.google.datastore.v1.Value from) {
          return null;
        }

        @Override
        protected void setValue(NullValue from, com.google.datastore.v1.Value.Builder to) {
          to.setNullValue(com.google.protobuf.NullValue.NULL_VALUE);
        }
      };

  public static final class Builder extends Value.BaseBuilder<Void, NullValue, Builder> {

    private Builder() {
      super(ValueType.NULL);
    }

    @Override
    public NullValue build() {
      return new NullValue(this);
    }

    @Override
    public Builder set(Void value) {
      checkArgument(value == null, "Only null values are allowed");
      return this;
    }
  }

  public NullValue() {
    this(newBuilder());
  }

  private NullValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static NullValue of() {
    return new NullValue();
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}

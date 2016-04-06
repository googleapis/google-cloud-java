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

import static com.google.datastore.v1beta3.Value.INTEGER_VALUE_FIELD_NUMBER;

public final class LongValue extends Value<Long> {

  private static final long serialVersionUID = -8552854340400546861L;

  static final BaseMarshaller<Long, LongValue, Builder> MARSHALLER =
      new BaseMarshaller<Long, LongValue, Builder>() {

        private static final long serialVersionUID = 2137414214660959845L;

        @Override
        public int getProtoFieldId() {
          return INTEGER_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(Long value) {
          return builder(value);
        }

        @Override
        protected Long getValue(com.google.datastore.v1beta3.Value from) {
          return from.getIntegerValue();
        }

        @Override
        protected void setValue(LongValue from, com.google.datastore.v1beta3.Value.Builder to) {
          to.setIntegerValue(from.get());
        }
      };

  public static final class Builder extends Value.BaseBuilder<Long, LongValue, Builder> {

    private Builder() {
      super(ValueType.LONG);
    }

    @Override
    public LongValue build() {
      return new LongValue(this);
    }
  }

  public LongValue(long value) {
    this(builder(value));
  }

  private LongValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static LongValue of(long value) {
    return new LongValue(value);
  }

  public static Builder builder(long value) {
    return new Builder().set(value);
  }
}

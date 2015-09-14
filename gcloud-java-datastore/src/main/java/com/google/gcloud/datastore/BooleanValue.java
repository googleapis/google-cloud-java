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

import static com.google.datastore.v1beta3.Value.BOOLEAN_VALUE_FIELD_NUMBER;

public final class BooleanValue extends Value<Boolean> {

  private static final long serialVersionUID = -542649497897250340L;

  static final BaseMarshaller<Boolean, BooleanValue, Builder> MARSHALLER =
      new BaseMarshaller<Boolean, BooleanValue, Builder>() {

        private static final long serialVersionUID = 7080467411349092522L;

        @Override
        public int getProtoFieldId() {
          return BOOLEAN_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(Boolean value) {
          return builder(value);
        }

        @Override
        protected Boolean getValue(com.google.datastore.v1beta3.Value from) {
          return from.getBooleanValue();
        }

        @Override
        protected void setValue(BooleanValue from, com.google.datastore.v1beta3.Value.Builder to) {
          to.setBooleanValue(from.get());
        }
      };

  public static final class Builder extends Value.BaseBuilder<Boolean, BooleanValue, Builder> {

    private Builder() {
      super(ValueType.BOOLEAN);
    }

    @Override
    public BooleanValue build() {
      return new BooleanValue(this);
    }
  }

  public BooleanValue(boolean value) {
    this(builder(value));
  }

  private BooleanValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static BooleanValue of(boolean value) {
    return new BooleanValue(value);
  }

  public static Builder builder(boolean value) {
    return new Builder().set(value);
  }
}

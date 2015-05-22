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

import static com.google.api.services.datastore.DatastoreV1.Value.DOUBLE_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;

public final class DoubleValue extends Value<Double> {

  private static final long serialVersionUID = -5096238337676649540L;

  static final BaseMarshaller<Double, DoubleValue, Builder> MARSHALLER =
      new BaseMarshaller<Double, DoubleValue, Builder>() {

        private static final long serialVersionUID = 3935522813529400538L;

        @Override
        public int getProtoFieldId() {
          return DOUBLE_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(Double value) {
          return builder(value);
        }

        @Override
        protected Double getValue(DatastoreV1.Value from) {
          return from.getDoubleValue();
        }

        @Override
        protected void setValue(DoubleValue from, DatastoreV1.Value.Builder to) {
          to.setDoubleValue(from.get());
        }
      };

  public static final class Builder extends Value.BaseBuilder<Double, DoubleValue, Builder> {

    public Builder() {
      super(ValueType.DOUBLE);
    }

    @Override
    public DoubleValue build() {
      return new DoubleValue(this);
    }
  }

  public DoubleValue(double value) {
    this(builder(value));
  }

  private DoubleValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static DoubleValue of(double value) {
    return new DoubleValue(value);
  }

  public static Builder builder(double value) {
    return new Builder().set(value);
  }
}

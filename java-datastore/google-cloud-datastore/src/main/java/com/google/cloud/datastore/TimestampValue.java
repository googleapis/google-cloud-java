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

import static com.google.datastore.v1.Value.TIMESTAMP_VALUE_FIELD_NUMBER;

import com.google.cloud.Timestamp;

public final class TimestampValue extends Value<Timestamp> {

  private static final long serialVersionUID = -8502433575902990648L;

  static final BaseMarshaller<Timestamp, TimestampValue, Builder> MARSHALLER =
      new BaseMarshaller<Timestamp, TimestampValue, Builder>() {

        private static final long serialVersionUID = -5789520029958113745L;

        @Override
        public int getProtoFieldId() {
          return TIMESTAMP_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(Timestamp value) {
          return TimestampValue.newBuilder(value);
        }

        @Override
        protected Timestamp getValue(com.google.datastore.v1.Value from) {
          return Timestamp.fromProto(from.getTimestampValue());
        }

        @Override
        protected void setValue(TimestampValue from, com.google.datastore.v1.Value.Builder to) {
          to.setTimestampValue(from.get().toProto());
        }
      };

  public static final class Builder extends Value.BaseBuilder<Timestamp, TimestampValue, Builder> {

    private Builder() {
      super(ValueType.TIMESTAMP);
    }

    @Override
    public TimestampValue build() {
      return new TimestampValue(this);
    }
  }

  public TimestampValue(Timestamp timestamp) {
    this(newBuilder(timestamp));
  }

  private TimestampValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static TimestampValue of(Timestamp timestamp) {
    return new TimestampValue(timestamp);
  }

  public static Builder newBuilder(Timestamp timestamp) {
    return new Builder().set(timestamp);
  }
}

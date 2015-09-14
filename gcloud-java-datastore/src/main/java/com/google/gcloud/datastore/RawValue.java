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

public final class RawValue extends Value<com.google.datastore.v1beta3.Value> {

  private static final long serialVersionUID = -3359604598651897941L;

  static final BaseMarshaller<com.google.datastore.v1beta3.Value, RawValue, Builder> MARSHALLER =
      new BaseMarshaller<com.google.datastore.v1beta3.Value, RawValue, Builder>() {

        private static final long serialVersionUID = 5320642719486106244L;

        @Override
        public Builder newBuilder(com.google.datastore.v1beta3.Value value) {
          return builder(value);
        }

        @Override
        public int getProtoFieldId() {
          return 0;
        }

        @Override
        protected com.google.datastore.v1beta3.Value getValue(com.google.datastore.v1beta3.Value from) {
          return from;
        }

        @Override
        protected void setValue(RawValue from, com.google.datastore.v1beta3.Value.Builder to) {
          to.mergeFrom(from.get());
        }
      };

  public static final class Builder
      extends Value.BaseBuilder<com.google.datastore.v1beta3.Value, RawValue, Builder> {

    private Builder() {
      super(ValueType.RAW_VALUE);
    }

    @Override
    public RawValue build() {
      return new RawValue(this);
    }
  }

  private RawValue(Builder builder) {
    super(builder);
  }

  RawValue(com.google.datastore.v1beta3.Value valuePb) {
    this(builder(valuePb));
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  static RawValue of(com.google.datastore.v1beta3.Value valuePb) {
    return new RawValue(valuePb);
  }

  static Builder builder(com.google.datastore.v1beta3.Value valuePb) {
    Builder builder = new Builder();
    builder.excludeFromIndexes(valuePb.getExcludeFromIndexes());
    builder.meaning(valuePb.getMeaning());
    builder.set(valuePb);
    return builder;
  }
}

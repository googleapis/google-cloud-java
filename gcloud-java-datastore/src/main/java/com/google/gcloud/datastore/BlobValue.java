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

import static com.google.datastore.v1beta3.Value.BLOB_VALUE_FIELD_NUMBER;

public final class BlobValue extends Value<Blob> {

  private static final long serialVersionUID = -5096238337676649540L;

  static final BaseMarshaller<Blob, BlobValue, Builder> MARSHALLER =
      new BaseMarshaller<Blob, BlobValue, Builder>() {

        private static final long serialVersionUID = -823515687083612387L;

        @Override
        public int getProtoFieldId() {
          return BLOB_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(Blob value) {
          return builder(value);
        }

        @Override
        protected Blob getValue(com.google.datastore.v1beta3.Value from) {
          return new Blob(from.getBlobValue());
        }

        @Override
        protected void setValue(BlobValue from, com.google.datastore.v1beta3.Value.Builder to) {
          to.setBlobValue(from.get().byteString());
        }
      };

  public static final class Builder extends Value.BaseBuilder<Blob, BlobValue, Builder> {

    private Builder() {
      super(ValueType.BLOB);
    }

    @Override
    public BlobValue build() {
      return new BlobValue(this);
    }
  }

  public BlobValue(Blob blob) {
    this(builder(blob));
  }

  private BlobValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static BlobValue of(Blob blob) {
    return new BlobValue(blob);
  }

  public static Builder builder(Blob blob) {
    return new Builder().set(blob);
  }
}

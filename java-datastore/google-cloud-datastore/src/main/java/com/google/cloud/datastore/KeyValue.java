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

import static com.google.datastore.v1.Value.KEY_VALUE_FIELD_NUMBER;

public final class KeyValue extends Value<Key> {

  private static final long serialVersionUID = 571775607775319610L;

  static final BaseMarshaller<Key, KeyValue, Builder> MARSHALLER =
      new BaseMarshaller<Key, KeyValue, Builder>() {

        private static final long serialVersionUID = -4653913699919198594L;

        @Override
        public int getProtoFieldId() {
          return KEY_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(Key key) {
          return KeyValue.newBuilder(key);
        }

        @Override
        protected Key getValue(com.google.datastore.v1.Value from) {
          return Key.fromPb(from.getKeyValue());
        }

        @Override
        protected void setValue(KeyValue from, com.google.datastore.v1.Value.Builder to) {
          to.setKeyValue(from.get().toPb());
        }
      };

  public static final class Builder extends Value.BaseBuilder<Key, KeyValue, Builder> {

    public Builder() {
      super(ValueType.KEY);
    }

    @Override
    public KeyValue build() {
      return new KeyValue(this);
    }
  }

  public KeyValue(Key key) {
    this(newBuilder(key));
  }

  private KeyValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static KeyValue of(Key key) {
    return new KeyValue(key);
  }

  public static Builder newBuilder(Key key) {
    return new Builder().set(key);
  }
}

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

import static com.google.datastore.v1beta3.Value.ENTITY_VALUE_FIELD_NUMBER;

public class EntityValue extends Value<FullEntity<?>> {

  private static final long serialVersionUID = -5461475706792576395L;

  static final BaseMarshaller<FullEntity<?>, EntityValue, Builder> MARSHALLER =
      new BaseMarshaller<FullEntity<?>, EntityValue, Builder>() {

        private static final long serialVersionUID = 2355075086076070931L;

        @Override
        public int getProtoFieldId() {
          return ENTITY_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(FullEntity<?> value) {
          return builder(value);
        }

        @Override
        protected FullEntity<?> getValue(com.google.datastore.v1beta3.Value from) {
          return FullEntity.fromPb(from.getEntityValue());
        }

        @Override
        protected void setValue(EntityValue from, com.google.datastore.v1beta3.Value.Builder to) {
          to.setEntityValue(from.get().toPb());
        }
      };

  public static final class Builder extends Value.BaseBuilder<FullEntity<?>, EntityValue, Builder> {

    private Builder() {
      super(ValueType.ENTITY);
    }

    @Override
    public EntityValue build() {
      return new EntityValue(this);
    }
  }

  public EntityValue(FullEntity<?> entity) {
    this(builder(entity));
  }

  private EntityValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static EntityValue of(FullEntity<?> entity) {
    return new EntityValue(entity);
  }

  public static Builder builder(FullEntity<?> entity) {
    return new Builder().set(entity);
  }
}

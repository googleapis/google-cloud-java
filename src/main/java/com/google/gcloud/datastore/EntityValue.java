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

import static com.google.api.services.datastore.DatastoreV1.Value.ENTITY_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;

public class EntityValue extends Value<PartialEntity> {

  private static final long serialVersionUID = -5461475706792576395L;

  static final BaseMarshaller<PartialEntity, EntityValue, Builder> MARSHALLER =
      new BaseMarshaller<PartialEntity, EntityValue, Builder>() {

        private static final long serialVersionUID = 2355075086076070931L;

        @Override
        public int getProtoFieldId() {
          return ENTITY_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(PartialEntity value) {
          return builder(value);
        }

        @Override
        protected PartialEntity getValue(DatastoreV1.Value from) {
          return PartialEntity.fromPb(from.getEntityValue());
        }

        @Override
        protected void setValue(EntityValue from, DatastoreV1.Value.Builder to) {
          to.setEntityValue(from.get().toPb());
        }
      };

  public static final class Builder extends Value.BaseBuilder<PartialEntity, EntityValue, Builder> {

    private Builder() {
      super(Type.ENTITY);
    }

    @Override
    public Builder indexed(boolean indexed) {
      // see issue #25
      Preconditions.checkArgument(!indexed, "EntityValue can't be indexed");
      return super.indexed(indexed);
    }

    @Override
    public EntityValue build() {
      return new EntityValue(this);
    }
  }

  public EntityValue(PartialEntity entity) {
    this(builder(entity));
  }

  private EntityValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static EntityValue of(PartialEntity entity) {
    return new EntityValue(entity);
  }

  public static Builder builder(PartialEntity entity) {
    return new Builder().set(entity).indexed(false);
  }
}

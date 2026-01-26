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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Preconditions;

/**
 * An entity is the Google Cloud Datastore persistent data object for a specific key. An entity will
 * always have a complete {@link Key}.
 */
public final class Entity extends FullEntity<Key> {

  private static final long serialVersionUID = 2312315289215899118L;

  public static final class Builder extends BaseEntity.Builder<Key, Builder> {

    private Builder() {}

    private Builder(Key key) {
      super(checkNotNull(key));
    }

    private Builder(Entity entity) {
      super(entity);
    }

    private Builder(Key key, FullEntity<?> entity) {
      setProperties(entity.getProperties());
      setKey(key);
    }

    @Override
    public Builder setKey(Key key) {
      super.setKey(checkNotNull(key));
      return this;
    }

    @Override
    public Entity build() {
      Preconditions.checkState(key() != null);
      return new Entity(this);
    }
  }

  Entity(Builder builder) {
    super(builder);
  }

  Entity(FullEntity<Key> from) {
    super(from);
    Preconditions.checkArgument(from.getKey() != null);
  }

  static Entity convert(FullEntity<Key> from) {
    if (from instanceof Entity) {
      return (Entity) from;
    }
    return new Entity(from);
  }

  public static Builder newBuilder(Key key) {
    return new Builder(key);
  }

  public static Builder newBuilder(Entity copyFrom) {
    return new Builder(copyFrom);
  }

  public static Builder newBuilder(Key key, FullEntity<?> copyFrom) {
    return new Builder(key, copyFrom);
  }

  public static Entity fromPb(com.google.datastore.v1.Entity entityPb) {
    return new Builder().fill(entityPb).build();
  }

  /**
   * Returns the size in bytes of the protobuf form of the provided entity.
   *
   * @param entity object whose size is measured.
   */
  public static int calculateSerializedSize(BaseEntity<? extends IncompleteKey> entity) {
    checkNotNull(entity);
    return entity.toPb().getSerializedSize();
  }
}

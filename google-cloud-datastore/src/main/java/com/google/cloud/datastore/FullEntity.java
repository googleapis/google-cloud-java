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

package com.google.cloud.datastore;

/**
 * A full entity is a {@link BaseEntity} that holds all the properties associated with a
 * Datastore entity (as opposed to {@link ProjectionEntity}).
 */
public class FullEntity<K extends IncompleteKey> extends BaseEntity<K> {

  private static final long serialVersionUID = -2075539363782670624L;

  public static class Builder<K extends IncompleteKey> extends BaseEntity.Builder<K, Builder<K>> {

    Builder() {
    }

    Builder(K key) {
      super(key);
    }

    Builder(FullEntity<K> entity) {
      super(entity);
    }

    @Override
    public FullEntity<K> build() {
      return new FullEntity<>(this);
    }
  }

  FullEntity(BaseEntity.Builder<K, ?> builder) {
    super(builder);
  }

  FullEntity(FullEntity<K> from) {
    super(from);
  }

  @Deprecated
  public static Builder<IncompleteKey> builder() {
    return newBuilder();
  }

  public static Builder<IncompleteKey> newBuilder() {
    return new Builder<>();
  }

  @Deprecated
  public static <K extends IncompleteKey> Builder<K> builder(K key) {
    return newBuilder(key);
  }

  public static <K extends IncompleteKey> Builder<K> newBuilder(K key) {
    return new Builder<>(key);
  }

  @Deprecated
  public static <K extends IncompleteKey> Builder<K> builder(FullEntity<K> copyFrom) {
    return newBuilder(copyFrom);
  }

  public static <K extends IncompleteKey> Builder<K> newBuilder(FullEntity<K> copyFrom) {
    return new Builder<>(copyFrom);
  }

  static FullEntity<?> fromPb(com.google.datastore.v1.Entity entityPb) {
    return new Builder<>().fill(entityPb).build();
  }
}

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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableSortedMap;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Objects;

/**
 * An entity is the Google Cloud Datastore persistent data object.
 * An entity holds one or more properties, represented by a name (as {@link String})
 * and a value (as {@link Value}), and is associated with a {@link Key}.
 * For a list of possible values see {@link Value.Type}.
 * This class is immutable.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/entities">Google Cloud Datastore Entities, Properties, and Keys</a>
 */
public final class Entity<K extends IncompleteKey> extends BaseEntity {

  private static final long serialVersionUID = 432961565733066915L;

  private final K key;

  public static final class Builder<K extends IncompleteKey>
      extends BaseEntity.Builder<Builder<K>> {

    private K key;

    private Builder() {
    }

    private Builder(K key) {
      this.key = checkNotNull(key);
    }

    private Builder(Entity<K> entity) {
      super(entity);
      key = entity.key();
    }

    private Builder(K key, BaseEntity entity) {
      super(entity);
      this.key = checkNotNull(key);
    }

    public Builder<K> key(K key) {
      this.key = checkNotNull(key);
      return this;
    }

    @Override
    public Entity<K> build() {
      return new Entity<>(key, ImmutableSortedMap.copyOf(properties));
    }
  }

  Entity(K key, ImmutableSortedMap<String, Value<?>> properties) {
    super(properties);
    this.key = key;
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, properties());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Entity)) {
      return false;
    }
    Entity other = (Entity) obj;
    return Objects.equals(key, other.key)
        && Objects.equals(properties(), other.properties());
  }

  @Override
  protected void populateEntityBuilder(DatastoreV1.Entity.Builder entityPb) {
    if (key != null) {
      entityPb.setKey(key.toPb());
    }
  }

  public boolean hasKey() {
    return key != null;
  }

  /**
   * Returns the entity's key.
   * Entity<Key> will always have a key where as Entity<IncompleteKey> may or may not have a key.
   */
  public K key() {
    return key;
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Entity.parseFrom(bytesPb));
  }

  static Entity fromPb(DatastoreV1.Entity entityPb) {
    ImmutableSortedMap.Builder<String, Value<?>> properties =
        ImmutableSortedMap.naturalOrder();
    for (DatastoreV1.Property property : entityPb.getPropertyList()) {
      properties.put(property.getName(), Value.fromPb(property.getValue()));
    }
    IncompleteKey key = null;
    if (entityPb.hasKey()) {
      key = IncompleteKey.fromPb(entityPb.getKey());
    }
    return new Entity<>(key, properties.build());
  }

  public static Builder<IncompleteKey> builder() {
    return new Builder<>();
  }

  public static <K extends IncompleteKey> Builder<K> builder(K key) {
    return new Builder<>(key);
  }

  public static <K extends IncompleteKey> Builder<K> builder(Entity<K> copyFrom) {
    return new Builder<>(copyFrom);
  }

  public static <K extends IncompleteKey> Builder<K> builder(K key, Entity<?> copyFrom) {
    return new Builder<>(key, copyFrom);
  }
}

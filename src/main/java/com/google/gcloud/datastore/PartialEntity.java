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

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableSortedMap;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Objects;

/**
 * A partial entity holds one or more properties, represented by a name (as {@link String})
 * and a value (as {@link Value}).
 * For a list of possible values see {@link Value.Type}.
 * A partial entity also can be associated with a key (partial or full).
 * This class is immutable.
 */
public class PartialEntity extends BaseEntity {

  private static final long serialVersionUID = 6492561268709192891L;

  private final transient IncompleteKey key;

  public static class Builder extends BaseEntity.Builder<Builder> {

    private IncompleteKey key;

    private Builder() {
    }

    private Builder(PartialEntity entity) {
      super(entity);
      key = entity.key();
    }

    public Builder key(IncompleteKey key) {
      this.key = key;
      return this;
    }

    @Override
    public PartialEntity build() {
      return new PartialEntity(key, ImmutableSortedMap.copyOf(properties));
    }
  }

  protected PartialEntity(IncompleteKey key, ImmutableSortedMap<String, Value<?>> properties) {
    super(properties);
    this.key = key;
  }

  public boolean hasKey() {
    return key != null;
  }

  /**
   * Returns the key for this entity or {@code null} if it does not have one.
   */
  public IncompleteKey key() {
    return key;
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
    if (!(obj instanceof PartialEntity)) {
      return false;
    }
    PartialEntity other = (PartialEntity) obj;
    return Objects.equals(key, other.key)
        && Objects.equals(properties(), other.properties());
  }

  @Override
  protected void populateEntityBuilder(DatastoreV1.Entity.Builder entityPb) {
    if (key != null) {
      entityPb.setKey(key.toPb());
    }
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Entity.parseFrom(bytesPb));
  }

  static PartialEntity fromPb(DatastoreV1.Entity entityPb) {
    ImmutableSortedMap.Builder<String, Value<?>> properties =
        ImmutableSortedMap.naturalOrder();
    for (DatastoreV1.Property property : entityPb.getPropertyList()) {
      properties.put(property.getName(), Value.fromPb(property.getValue()));
    }
    IncompleteKey incompleteKey = null;
    if (entityPb.hasKey()) {
      incompleteKey = IncompleteKey.fromPb(entityPb.getKey());
      if (incompleteKey instanceof Key) {
        return new Entity((Key) incompleteKey, properties.build());
      }
    }
    return new PartialEntity(incompleteKey, properties.build());
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(IncompleteKey key) {
    return new Builder().key(key);
  }

  public static Builder builder(PartialEntity copyFrom) {
    return new Builder(copyFrom);
  }
}

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
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Objects;

/**
 * A projection entity is a result of a Google Cloud Datastore projection query.
 * A projection entity holds one or more properties, represented by a name (as {@link String})
 * and a value (as {@link Value}), and may have a {@link Key}.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/projectionqueries">Google Cloud Datastore projection queries</a>
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/entities">Google Cloud Datastore Entities, Properties, and Keys</a>
 */
public final class ProjectionEntity extends BaseEntity {

  private static final long serialVersionUID = 432961565733066915L;

  private final Key key;

  static final class Builder extends BaseEntity.Builder<Builder> {

    private Key key;

    private Builder() {
    }

    private Builder(ProjectionEntity entity) {
      super(entity);
      key = entity.key();
    }

    public Builder key(Key key) {
      this.key = key;
      return this;
    }

    @Override
    public ProjectionEntity build() {
      return new ProjectionEntity(key, ImmutableSortedMap.copyOf(properties));
    }
  }

  ProjectionEntity(Key key, ImmutableSortedMap<String, Value<?>> properties) {
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
    if (!(obj instanceof ProjectionEntity)) {
      return false;
    }
    ProjectionEntity other = (ProjectionEntity) obj;
    return Objects.equals(key, other.key)
        && Objects.equals(properties(), other.properties());
  }

  public boolean hasKey() {
    return key() != null;
  }

  /**
   * Returns the associated {@link Key} or null if it does not have one.
   */
  public Key key() {
    return key;
  }

  @SuppressWarnings("unchecked")
  @Override
  public DateTime getDateTime(String name) {
    Value<?> value = getValue(name);
    if (value.hasMeaning() && value.meaning() == 18 && value instanceof LongValue) {
      return new DateTime(getLong(name));
    }
    return ((Value<DateTime>) value).get();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Blob getBlob(String name) {
    Value<?> value = getValue(name);
    if (value.hasMeaning() && value.meaning() == 18 && value instanceof StringValue) {
      return new Blob(ByteString.copyFromUtf8(getString(name)), false);
    }
    return ((Value<Blob>) value).get();
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Entity.parseFrom(bytesPb));
  }

  static ProjectionEntity fromPb(DatastoreV1.Entity entityPb) {
    ImmutableSortedMap.Builder<String, Value<?>> properties =
        ImmutableSortedMap.naturalOrder();
    for (DatastoreV1.Property property : entityPb.getPropertyList()) {
      properties.put(property.getName(), Value.fromPb(property.getValue()));
    }
    Key key = null;
    if (entityPb.hasKey()) {
      key = Key.fromPb(entityPb.getKey());
    }
    return new ProjectionEntity(key, properties.build());
  }


  public static Builder builder(ProjectionEntity copyFrom) {
    return new Builder(copyFrom);
  }

  @Override
  protected void populateEntityBuilder(DatastoreV1.Entity.Builder entityPb) {
    if (key != null) {
      entityPb.setKey(key.toPb());
    }
  }
}

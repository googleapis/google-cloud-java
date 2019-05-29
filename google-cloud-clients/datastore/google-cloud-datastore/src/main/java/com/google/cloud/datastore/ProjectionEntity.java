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

import com.google.cloud.Timestamp;
import com.google.protobuf.ByteString;

/**
 * A projection entity is a result of a Google Cloud Datastore projection query. A projection entity
 * holds one or more properties, represented by a name (as {@link String}) and a value (as {@link
 * Value}), and may have a {@link Key}.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/projectionqueries">Google Cloud
 *     Datastore projection queries</a>
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/entities">Google Cloud Datastore
 *     Entities, Properties, and Keys</a>
 */
public final class ProjectionEntity extends BaseEntity<Key> {

  private static final long serialVersionUID = -3399517537444851544L;

  public static final class Builder extends BaseEntity.Builder<Key, Builder> {

    Builder() {}

    private Builder(ProjectionEntity entity) {
      super(entity);
    }

    @Override
    public ProjectionEntity build() {
      return new ProjectionEntity(this);
    }
  }

  ProjectionEntity(Builder builder) {
    super(builder);
  }

  @SuppressWarnings({"unchecked", "deprecation"})
  @Override
  public Timestamp getTimestamp(String name) {
    Value<?> value = getValue(name);
    if (value.getMeaning() == 18 && value instanceof LongValue) {
      return Timestamp.ofTimeMicroseconds(getLong(name));
    }
    return ((Value<Timestamp>) value).get();
  }

  @SuppressWarnings({"unchecked", "deprecation"})
  @Override
  public Blob getBlob(String name) {
    Value<?> value = getValue(name);
    if (value.getMeaning() == 18 && value instanceof StringValue) {
      return new Blob(ByteString.copyFromUtf8(getString(name)));
    }
    return ((Value<Blob>) value).get();
  }

  static ProjectionEntity fromPb(com.google.datastore.v1.Entity entityPb) {
    return new Builder().fill(entityPb).build();
  }

  public static Builder newBuilder(ProjectionEntity copyFrom) {
    return new Builder(copyFrom);
  }
}

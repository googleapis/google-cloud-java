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

/**
 * An implementation of a Google Cloud Datastore entity query that can be constructed by providing
 * all the specific query elements.
 *
 * @see <a href="https://cloud.google.com/appengine/docs/java/datastore/queries">Datastore
 *     queries</a>
 */
public final class EntityQuery extends StructuredQuery<Entity> {

  private static final long serialVersionUID = -4748310327736758820L;

  /** A {@code EntityQuery} builder for queries that return {@link Entity} results. */
  public static final class Builder extends StructuredQuery.BuilderImpl<Entity, Builder> {

    Builder(EntityQuery query) {
      super(query);
    }

    Builder() {
      super(ResultType.ENTITY);
    }

    @Override
    Builder mergeFrom(com.google.datastore.v1.Query queryPb) {
      super.mergeFrom(queryPb);
      clearProjection();
      clearDistinctOn();
      return this;
    }

    @Override
    public EntityQuery build() {
      return new EntityQuery(this);
    }
  }

  EntityQuery(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }
}

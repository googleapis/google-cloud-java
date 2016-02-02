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

/**
 * An implementation of a Google Cloud Datastore projection entity query that can be constructed by
 * providing all the specific query elements.
 *
 * @see <a href="https://cloud.google.com/appengine/docs/java/datastore/queries">Datastore
 *     queries</a>
 */
public final class ProjectionEntityQuery extends StructuredQuery<ProjectionEntity> {

  private static final long serialVersionUID = 5488451194542425391L;

  /**
   * A {@code ProjectionEntityQuery} builder for queries that return {@link ProjectionEntity}
   * results.
   */
  public static final class Builder extends StructuredQuery.BuilderImpl<ProjectionEntity, Builder> {

    Builder(ProjectionEntityQuery query) {
      super(query);
    }

    Builder() {
      super(ResultType.PROJECTION_ENTITY);
    }

    /**
     * Clears the projection clause.
     */
    @Override
    public Builder clearProjection() {
      super.clearProjection();
      return this;
    }

    /**
     * Sets the query's projection clause (clearing any previously specified Projection settings).
     */
    @Override
    public Builder projection(String projection, String... others) {
      super.projection(projection, others);
      return this;
    }

    /**
     * Adds one or more projections to the existing projection clause.
     */
    @Override
    public Builder addProjection(String projection, String... others) {
      super.addProjection(projection, others);
      return this;
    }

    /**
     * Clears the group by clause.
     */
    @Override
    public Builder clearDistinctOn() {
      super.clearDistinctOn();
      return this;
    }

    /**
     * Sets the query's group by clause (clearing any previously specified GroupBy settings).
     */
    @Override
    public Builder distinctOn(String property, String... others) {
      super.distinctOn(property, others);
      return this;
    }

    /**
     * Adds one or more properties to the existing group by clause.
     */
    @Override
    public Builder addDistinctOn(String property, String... others) {
      super.addDistinctOn(property, others);
      return this;
    }

    @Override
    public ProjectionEntityQuery build() {
      return new ProjectionEntityQuery(this);
    }
  }

  ProjectionEntityQuery(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }
}

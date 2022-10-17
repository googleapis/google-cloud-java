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

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Map;

/**
 * A Google Cloud Datastore query. For usage examples see {@link GqlQuery}, {@link StructuredQuery}
 * and {@link AggregationQuery}.
 *
 * <p>Note that queries require proper indexing. See <a
 * href="https://cloud.google.com/datastore/docs/tools/indexconfig">Cloud Datastore Index
 * Configuration</a> for help configuring indexes.
 *
 * @param <V> the type of the values returned by this query.
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/queries">Datastore Queries</a>
 */
public abstract class Query<V> implements Serializable {

  private static final long serialVersionUID = 7967659059395653941L;

  private final String namespace;

  /**
   * This class represents the expected type of the result. ENTITY: A full entity represented by
   * {@link Entity}. PROJECTION_ENTITY: A projection entity, represented by {@link
   * ProjectionEntity}. KEY: An entity's {@link Key}.
   */
  public abstract static class ResultType<V> implements Serializable {

    private static final long serialVersionUID = 2104157695425806623L;
    private static final Map<com.google.datastore.v1.EntityResult.ResultType, ResultType<?>>
        PB_TO_INSTANCE = Maps.newEnumMap(com.google.datastore.v1.EntityResult.ResultType.class);

    static final ResultType<?> UNKNOWN =
        new ResultType<Object>(null, Object.class) {

          private static final long serialVersionUID = 1602329532153860907L;

          @Override
          Object convert(com.google.datastore.v1.Entity entityPb) {
            if (entityPb.getPropertiesMap().isEmpty()) {
              if (!entityPb.hasKey()) {
                return null;
              }
              return Key.fromPb(entityPb.getKey());
            }
            return ProjectionEntity.fromPb(entityPb);
          }
        };

    public static final ResultType<Entity> ENTITY =
        new ResultType<Entity>(com.google.datastore.v1.EntityResult.ResultType.FULL, Entity.class) {

          private static final long serialVersionUID = 7712959777507168274L;

          @Override
          Entity convert(com.google.datastore.v1.Entity entityPb) {
            return Entity.fromPb(entityPb);
          }
        };

    public static final ResultType<Key> KEY =
        new ResultType<Key>(com.google.datastore.v1.EntityResult.ResultType.KEY_ONLY, Key.class) {

          private static final long serialVersionUID = -8514289244104446252L;

          @Override
          Key convert(com.google.datastore.v1.Entity entityPb) {
            return Key.fromPb(entityPb.getKey());
          }
        };

    public static final ResultType<ProjectionEntity> PROJECTION_ENTITY =
        new ResultType<ProjectionEntity>(
            com.google.datastore.v1.EntityResult.ResultType.PROJECTION, ProjectionEntity.class) {

          private static final long serialVersionUID = -7591409419690650246L;

          @Override
          ProjectionEntity convert(com.google.datastore.v1.Entity entityPb) {
            return ProjectionEntity.fromPb(entityPb);
          }
        };

    private final Class<V> resultClass;
    private final com.google.datastore.v1.EntityResult.ResultType queryType;

    private ResultType(
        com.google.datastore.v1.EntityResult.ResultType queryType, Class<V> resultClass) {
      this.queryType = queryType;
      this.resultClass = resultClass;
      if (queryType != null) {
        PB_TO_INSTANCE.put(queryType, this);
      }
    }

    public Class<V> resultClass() {
      return resultClass;
    }

    @Override
    public int hashCode() {
      return resultClass.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof ResultType)) {
        return false;
      }
      ResultType<?> other = (ResultType<?>) obj;
      return resultClass.equals(other.resultClass);
    }

    @Override
    public String toString() {
      ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
      toStringHelper.add("queryType", queryType);
      toStringHelper.add("resultClass", resultClass);
      return toStringHelper.toString();
    }

    boolean isAssignableFrom(ResultType<?> otherResultType) {
      return resultClass.isAssignableFrom(otherResultType.resultClass);
    }

    abstract V convert(com.google.datastore.v1.Entity entityPb);

    static ResultType<?> fromPb(com.google.datastore.v1.EntityResult.ResultType typePb) {
      return MoreObjects.firstNonNull(PB_TO_INSTANCE.get(typePb), UNKNOWN);
    }
  }

  Query(String namespace) {
    this.namespace = namespace;
  }

  public String getNamespace() {
    return namespace;
  }

  ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this).add("namespace", namespace);
  }

  /**
   * Returns a new {@link GqlQuery} builder.
   *
   * <p>Example of creating and running a GQL query.
   *
   * <pre>{@code
   * String kind = "my_kind";
   * String gqlQuery = "select * from " + kind;
   * Query<?> query = Query.newGqlQueryBuilder(gqlQuery).build();
   * QueryResults<?> results = datastore.run(query);
   * // Use results
   * }</pre>
   *
   * @see <a href="https://cloud.google.com/datastore/docs/apis/gql/gql_reference">GQL Reference</a>
   */
  public static GqlQuery.Builder<?> newGqlQueryBuilder(String gql) {
    return newGqlQueryBuilder(ResultType.UNKNOWN, gql);
  }

  /**
   * Returns a new {@link GqlQuery} builder.
   *
   * <p>Example of creating and running a typed GQL query.
   *
   * <pre>{@code
   * String kind = "my_kind";
   * String gqlQuery = "select * from " + kind;
   * Query<Entity> query = Query.newGqlQueryBuilder(Query.ResultType.ENTITY, gqlQuery).build();
   * QueryResults<Entity> results = datastore.run(query);
   * // Use results
   * }</pre>
   *
   * @see <a href="https://cloud.google.com/datastore/docs/apis/gql/gql_reference">GQL Reference</a>
   */
  public static <V> GqlQuery.Builder<V> newGqlQueryBuilder(ResultType<V> resultType, String gql) {
    return new GqlQuery.Builder<>(resultType, gql);
  }

  /**
   * Returns a new {@link StructuredQuery} builder for full (complete entities) queries.
   *
   * <p>Example of creating and running an entity query.
   *
   * <pre>{@code
   * String kind = "my_kind";
   * Query<Entity> query = Query.newEntityQueryBuilder().setKind(kind).build();
   * QueryResults<Entity> results = datastore.run(query);
   * // Use results
   * }</pre>
   */
  public static EntityQuery.Builder newEntityQueryBuilder() {
    return new EntityQuery.Builder();
  }

  /**
   * Returns a new {@link StructuredQuery} builder for key only queries.
   *
   * <p>Example of creating and running a key query.
   *
   * <pre>{@code
   * String kind = "my_kind";
   * Query<Key> query = Query.newKeyQueryBuilder().setKind(kind).build();
   * QueryResults<Key> results = datastore.run(query);
   * // Use results
   * }</pre>
   */
  public static KeyQuery.Builder newKeyQueryBuilder() {
    return new KeyQuery.Builder();
  }

  /**
   * Returns a new {@link StructuredQuery} builder for projection queries.
   *
   * <p>Example of creating and running a projection entity query.
   *
   * <pre>{@code
   * String kind = "my_kind";
   * String property = "my_property";
   * Query<ProjectionEntity> query = Query.newProjectionEntityQueryBuilder()
   *     .setKind(kind)
   *     .addProjection(property)
   *     .build();
   * QueryResults<ProjectionEntity> results = datastore.run(query);
   * // Use results
   * }</pre>
   */
  public static ProjectionEntityQuery.Builder newProjectionEntityQueryBuilder() {
    return new ProjectionEntityQuery.Builder();
  }

  /**
   * Returns a new {@link AggregationQuery} builder.
   *
   * <p>Example of creating and running an {@link AggregationQuery}.
   *
   * <p>{@link StructuredQuery} example:
   *
   * <pre>{@code
   * EntityQuery selectAllQuery = Query.newEntityQueryBuilder()
   *    .setKind("Task")
   *    .build();
   * AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
   *    .addAggregation(count().as("total_count"))
   *    .over(selectAllQuery)
   *    .build();
   * AggregationResults aggregationResults = datastore.runAggregation(aggregationQuery);
   * // Use aggregationResults
   * }</pre>
   *
   * <h4>{@link GqlQuery} example:</h4>
   *
   * <pre>{@code
   * GqlQuery<?> selectAllGqlQuery = Query.newGqlQueryBuilder(
   *         "AGGREGATE COUNT(*) AS total_count OVER(SELECT * FROM Task)"
   *     )
   *     .setAllowLiteral(true)
   *     .build();
   * AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
   *     .over(selectAllGqlQuery)
   *     .build();
   * AggregationResults aggregationResults = datastore.runAggregation(aggregationQuery);
   * // Use aggregationResults
   * }</pre>
   */
  public static AggregationQuery.Builder newAggregationQueryBuilder() {
    return new AggregationQuery.Builder();
  }
}

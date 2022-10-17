/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.datastore;

import static com.google.cloud.datastore.AggregationQuery.Mode.GQL;
import static com.google.cloud.datastore.AggregationQuery.Mode.STRUCTURED;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.core.BetaApi;
import com.google.cloud.datastore.aggregation.Aggregation;
import com.google.cloud.datastore.aggregation.AggregationBuilder;
import java.util.HashSet;
import java.util.Set;

/**
 * An implementation of a Google Cloud Datastore Query that returns {@link AggregationResults}, It
 * can be constructed by providing a nested query ({@link StructuredQuery} or {@link GqlQuery}) to
 * run the aggregations on and a set of {@link Aggregation}.
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
 * for (AggregationResult aggregationResult : aggregationResults) {
 *     System.out.println(aggregationResult.get("total_count"));
 * }
 * }</pre>
 *
 * <h4>{@link GqlQuery} example:</h4>
 *
 * <pre>{@code
 * GqlQuery<?> selectAllGqlQuery = Query.newGqlQueryBuilder(
 *         "AGGREGATE COUNT(*) AS total_count, COUNT_UP_TO(100) AS count_upto_100 OVER(SELECT * FROM Task)"
 *     )
 *     .setAllowLiteral(true)
 *     .build();
 * AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
 *     .over(selectAllGqlQuery)
 *     .build();
 * AggregationResults aggregationResults = datastore.runAggregation(aggregationQuery);
 * for (AggregationResult aggregationResult : aggregationResults) {
 *   System.out.println(aggregationResult.get("total_count"));
 *   System.out.println(aggregationResult.get("count_upto_100"));
 * }
 * }</pre>
 *
 * @see <a href="https://cloud.google.com/appengine/docs/java/datastore/queries">Datastore
 *     queries</a>
 */
@BetaApi
public class AggregationQuery extends Query<AggregationResults> {

  private Set<Aggregation> aggregations;
  private StructuredQuery<?> nestedStructuredQuery;
  private final Mode mode;
  private GqlQuery<?> nestedGqlQuery;

  AggregationQuery(
      String namespace, Set<Aggregation> aggregations, StructuredQuery<?> nestedQuery) {
    super(namespace);
    checkArgument(
        !aggregations.isEmpty(),
        "At least one aggregation is required for an aggregation query to run");
    this.aggregations = aggregations;
    this.nestedStructuredQuery = nestedQuery;
    this.mode = STRUCTURED;
  }

  AggregationQuery(String namespace, GqlQuery<?> gqlQuery) {
    super(namespace);
    this.nestedGqlQuery = gqlQuery;
    this.mode = GQL;
  }

  /** Returns the {@link Aggregation}(s) for this Query. */
  public Set<Aggregation> getAggregations() {
    return aggregations;
  }

  /**
   * Returns the underlying {@link StructuredQuery for this Query}. Returns null if created with
   * {@link GqlQuery}
   */
  public StructuredQuery<?> getNestedStructuredQuery() {
    return nestedStructuredQuery;
  }

  /**
   * Returns the underlying {@link GqlQuery for this Query}. Returns null if created with {@link
   * StructuredQuery}
   */
  public GqlQuery<?> getNestedGqlQuery() {
    return nestedGqlQuery;
  }

  /** Returns the {@link Mode} for this query. */
  public Mode getMode() {
    return mode;
  }

  public static class Builder {

    private String namespace;
    private Mode mode;
    private final Set<Aggregation> aggregations;
    private StructuredQuery<?> nestedStructuredQuery;
    private GqlQuery<?> nestedGqlQuery;

    public Builder() {
      this.aggregations = new HashSet<>();
    }

    public Builder setNamespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    public Builder addAggregation(AggregationBuilder<?> aggregationBuilder) {
      this.aggregations.add(aggregationBuilder.build());
      return this;
    }

    public Builder addAggregation(Aggregation aggregation) {
      this.aggregations.add(aggregation);
      return this;
    }

    public Builder over(StructuredQuery<?> nestedQuery) {
      this.nestedStructuredQuery = nestedQuery;
      this.mode = STRUCTURED;
      return this;
    }

    public Builder over(GqlQuery<?> nestedQuery) {
      this.nestedGqlQuery = nestedQuery;
      this.mode = GQL;
      return this;
    }

    public AggregationQuery build() {
      boolean nestedQueryProvided = nestedGqlQuery != null || nestedStructuredQuery != null;
      checkArgument(
          nestedQueryProvided, "Nested query is required for an aggregation query to run");

      if (mode == GQL) {
        return new AggregationQuery(namespace, nestedGqlQuery);
      }
      return new AggregationQuery(namespace, aggregations, nestedStructuredQuery);
    }
  }

  public enum Mode {
    STRUCTURED,
    GQL,
  }
}

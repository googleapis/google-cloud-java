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
import static com.google.cloud.datastore.StructuredQuery.PropertyFilter.eq;
import static com.google.cloud.datastore.aggregation.Aggregation.count;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.google.cloud.datastore.aggregation.CountAggregation;
import com.google.common.collect.ImmutableSet;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AggregationQueryTest {

  private static final String KIND = "Task";
  private static final String NAMESPACE = "ns";
  private static final EntityQuery COMPLETED_TASK_QUERY =
      Query.newEntityQueryBuilder()
          .setNamespace(NAMESPACE)
          .setKind(KIND)
          .setFilter(eq("done", true))
          .setLimit(100)
          .build();

  @Rule public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void testAggregations() {
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .setNamespace(NAMESPACE)
            .addAggregation(new CountAggregation("total"))
            .over(COMPLETED_TASK_QUERY)
            .build();

    assertThat(aggregationQuery.getNamespace()).isEqualTo(NAMESPACE);
    assertThat(aggregationQuery.getAggregations())
        .isEqualTo(ImmutableSet.of(count().as("total").build()));
    assertThat(aggregationQuery.getNestedStructuredQuery()).isEqualTo(COMPLETED_TASK_QUERY);
    assertThat(aggregationQuery.getMode()).isEqualTo(STRUCTURED);
  }

  @Test
  public void testAggregationBuilderWithMoreThanOneAggregations() {
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .setNamespace(NAMESPACE)
            .addAggregation(count().as("total"))
            .addAggregation(count().as("new_total"))
            .over(COMPLETED_TASK_QUERY)
            .build();

    assertThat(aggregationQuery.getNamespace()).isEqualTo(NAMESPACE);
    assertThat(aggregationQuery.getAggregations())
        .isEqualTo(ImmutableSet.of(count().as("total").build(), count().as("new_total").build()));
    assertThat(aggregationQuery.getNestedStructuredQuery()).isEqualTo(COMPLETED_TASK_QUERY);
    assertThat(aggregationQuery.getMode()).isEqualTo(STRUCTURED);
  }

  @Test
  public void testAggregationBuilderWithDuplicateAggregations() {
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .setNamespace(NAMESPACE)
            .addAggregation(count().as("total"))
            .addAggregation(count().as("total"))
            .over(COMPLETED_TASK_QUERY)
            .build();

    assertThat(aggregationQuery.getNamespace()).isEqualTo(NAMESPACE);
    assertThat(aggregationQuery.getAggregations())
        .isEqualTo(ImmutableSet.of(count().as("total").build()));
    assertThat(aggregationQuery.getNestedStructuredQuery()).isEqualTo(COMPLETED_TASK_QUERY);
    assertThat(aggregationQuery.getMode()).isEqualTo(STRUCTURED);
  }

  @Test
  public void testAggregationQueryBuilderWithoutNamespace() {
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .addAggregation(count().as("total"))
            .over(COMPLETED_TASK_QUERY)
            .build();

    assertNull(aggregationQuery.getNamespace());
    assertThat(aggregationQuery.getAggregations())
        .isEqualTo(ImmutableSet.of(count().as("total").build()));
    assertThat(aggregationQuery.getNestedStructuredQuery()).isEqualTo(COMPLETED_TASK_QUERY);
    assertThat(aggregationQuery.getMode()).isEqualTo(STRUCTURED);
  }

  @Test
  public void testAggregationQueryBuilderWithoutNestedQuery() {
    assertThrows(
        "Nested query is required for an aggregation query to run",
        IllegalArgumentException.class,
        () ->
            Query.newAggregationQueryBuilder()
                .setNamespace(NAMESPACE)
                .addAggregation(count().as("total"))
                .build());
  }

  @Test
  public void testAggregationQueryBuilderWithoutAggregation() {
    assertThrows(
        "At least one aggregation is required for an aggregation query to run",
        IllegalArgumentException.class,
        () ->
            Query.newAggregationQueryBuilder()
                .setNamespace(NAMESPACE)
                .over(COMPLETED_TASK_QUERY)
                .build());
  }

  @Test
  public void testAggregationQueryBuilderWithGqlQuery() {
    GqlQuery<?> gqlQuery = Query.newGqlQueryBuilder("SELECT * FROM Task WHERE done = true").build();

    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder().setNamespace(NAMESPACE).over(gqlQuery).build();

    assertThat(aggregationQuery.getNestedGqlQuery()).isEqualTo(gqlQuery);
    assertThat(aggregationQuery.getMode()).isEqualTo(GQL);
  }

  @Test
  public void testAggregationQueryBuilderWithoutProvidingAnyNestedQuery() {
    assertThrows(
        "Nested query is required for an aggregation query to run",
        IllegalArgumentException.class,
        () -> Query.newAggregationQueryBuilder().setNamespace(NAMESPACE).build());
  }
}

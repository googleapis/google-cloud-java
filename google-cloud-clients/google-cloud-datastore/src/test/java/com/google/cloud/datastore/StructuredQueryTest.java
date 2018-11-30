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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.datastore.Query.ResultType;
import com.google.cloud.datastore.StructuredQuery.CompositeFilter;
import com.google.cloud.datastore.StructuredQuery.Filter;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class StructuredQueryTest {

  private static final String NAMESPACE = "ns";
  private static final String KIND = "k";
  private static final Cursor START_CURSOR = Cursor.copyFrom(new byte[] {1, 2});
  private static final Cursor END_CURSOR = Cursor.copyFrom(new byte[] {10});
  private static final int OFFSET = 42;
  private static final Integer LIMIT = 43;
  private static final Filter FILTER =
      CompositeFilter.and(PropertyFilter.gt("p1", 10), PropertyFilter.eq("a", "v"));
  private static final OrderBy ORDER_BY_1 = OrderBy.asc("p2");
  private static final OrderBy ORDER_BY_2 = OrderBy.desc("p3");
  private static final List<OrderBy> ORDER_BY = ImmutableList.of(ORDER_BY_1, ORDER_BY_2);
  private static final String PROJECTION1 = "p4";
  private static final String PROJECTION2 = "p5";
  private static final List<String> PROJECTION = ImmutableList.of(PROJECTION1, PROJECTION2);
  private static final String DISTINCT_ON1 = "p6";
  private static final String DISTINCT_ON2 = "p7";
  private static final List<String> DISTINCT_ON = ImmutableList.of(DISTINCT_ON1, DISTINCT_ON2);
  private static final EntityQuery ENTITY_QUERY =
      Query.newEntityQueryBuilder()
          .setNamespace(NAMESPACE)
          .setKind(KIND)
          .setStartCursor(START_CURSOR)
          .setEndCursor(END_CURSOR)
          .setOffset(OFFSET)
          .setLimit(LIMIT)
          .setFilter(FILTER)
          .setOrderBy(ORDER_BY_1, ORDER_BY_2)
          .build();
  private static final KeyQuery KEY_QUERY =
      Query.newKeyQueryBuilder()
          .setNamespace(NAMESPACE)
          .setKind(KIND)
          .setStartCursor(START_CURSOR)
          .setEndCursor(END_CURSOR)
          .setOffset(OFFSET)
          .setLimit(LIMIT)
          .setFilter(FILTER)
          .setOrderBy(ORDER_BY_1, ORDER_BY_2)
          .build();
  private static final ProjectionEntityQuery PROJECTION_QUERY =
      Query.newProjectionEntityQueryBuilder()
          .setNamespace(NAMESPACE)
          .setKind(KIND)
          .setStartCursor(START_CURSOR)
          .setEndCursor(END_CURSOR)
          .setOffset(OFFSET)
          .setLimit(LIMIT)
          .setFilter(FILTER)
          .setOrderBy(ORDER_BY_1, ORDER_BY_2)
          .setProjection(PROJECTION1, PROJECTION2)
          .setDistinctOn(DISTINCT_ON1, DISTINCT_ON2)
          .build();

  @Test
  public void testEntityQueryBuilder() {
    compareBaseBuilderFields(ENTITY_QUERY);
    assertTrue(ENTITY_QUERY.getProjection().isEmpty());
    assertTrue(ENTITY_QUERY.getDistinctOn().isEmpty());
  }

  @Test
  public void testKeyQueryBuilder() {
    compareBaseBuilderFields(KEY_QUERY);
    assertEquals(ImmutableList.of(StructuredQuery.KEY_PROPERTY_NAME), KEY_QUERY.getProjection());
    assertTrue(KEY_QUERY.getDistinctOn().isEmpty());
  }

  @Test
  public void testProjectionEntityQueryBuilder() {
    compareBaseBuilderFields(PROJECTION_QUERY);
    assertEquals(PROJECTION, PROJECTION_QUERY.getProjection());
    assertEquals(DISTINCT_ON, PROJECTION_QUERY.getDistinctOn());
  }

  private void compareBaseBuilderFields(StructuredQuery<?> query) {
    assertEquals(NAMESPACE, query.getNamespace());
    assertEquals(KIND, query.getKind());
    assertEquals(START_CURSOR, query.getStartCursor());
    assertEquals(END_CURSOR, query.getEndCursor());
    assertEquals(OFFSET, query.getOffset());
    assertEquals(LIMIT, query.getLimit());
    assertEquals(FILTER, query.getFilter());
    assertEquals(ORDER_BY, query.getOrderBy());
  }

  @Test
  public void mergeFrom() {
    compareMergedQuery(
        ENTITY_QUERY, new EntityQuery.Builder().mergeFrom(ENTITY_QUERY.toPb()).build());
    compareMergedQuery(KEY_QUERY, new KeyQuery.Builder().mergeFrom(KEY_QUERY.toPb()).build());
    compareMergedQuery(
        PROJECTION_QUERY,
        new ProjectionEntityQuery.Builder().mergeFrom(PROJECTION_QUERY.toPb()).build());
  }

  private void compareMergedQuery(StructuredQuery<?> expected, StructuredQuery<?> actual) {
    assertEquals(expected.getKind(), actual.getKind());
    assertEquals(expected.getStartCursor(), actual.getStartCursor());
    assertEquals(expected.getEndCursor(), actual.getEndCursor());
    assertEquals(expected.getOffset(), actual.getOffset());
    assertEquals(expected.getLimit(), actual.getLimit());
    assertEquals(expected.getFilter(), actual.getFilter());
    assertEquals(expected.getOrderBy(), actual.getOrderBy());
    assertEquals(expected.getProjection(), actual.getProjection());
    assertEquals(expected.getDistinctOn(), actual.getDistinctOn());
  }

  @Test
  public void testToAndFromPb() {
    assertEquals(
        ENTITY_QUERY,
        StructuredQuery.fromPb(
            ResultType.ENTITY, ENTITY_QUERY.getNamespace(), ENTITY_QUERY.toPb()));
    assertEquals(
        KEY_QUERY,
        StructuredQuery.fromPb(ResultType.KEY, KEY_QUERY.getNamespace(), KEY_QUERY.toPb()));
    assertEquals(
        PROJECTION_QUERY,
        StructuredQuery.fromPb(
            ResultType.PROJECTION_ENTITY,
            PROJECTION_QUERY.getNamespace(),
            PROJECTION_QUERY.toPb()));
  }

  @Test
  public void testToBuilder() {
    List<StructuredQuery<?>> queries =
        ImmutableList.<StructuredQuery<?>>of(ENTITY_QUERY, KEY_QUERY, PROJECTION_QUERY);
    for (StructuredQuery<?> query : queries) {
      assertEquals(query, query.toBuilder().build());
    }
  }

  @Test
  public void testKeyOnly() {
    assertTrue(KEY_QUERY.isKeyOnly());
    assertFalse(ENTITY_QUERY.isKeyOnly());
    assertFalse(PROJECTION_QUERY.isKeyOnly());
  }
}

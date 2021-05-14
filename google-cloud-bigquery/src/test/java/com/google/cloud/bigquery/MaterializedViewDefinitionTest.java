/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

public class MaterializedViewDefinitionTest {

  private static final String MATERIALIZED_VIEW_QUERY = "MATERIALIZED_VIEW_QUERY";
  private static final Long LAST_REFRESH_TIME = 1580302008L;
  private static final Boolean ENABLE_REFRESH = false;
  private static final Long REFRESH_INTERVAL_MS = 60000L;
  private static final Schema SCHEMA = Schema.of();
  private static final TimePartitioning TIME_PARTITIONING =
      TimePartitioning.of(TimePartitioning.Type.DAY, 42);
  private static final Clustering CLUSTERING =
      Clustering.newBuilder().setFields(ImmutableList.of("Foo", "Bar")).build();
  private static final MaterializedViewDefinition MATERIALIZED_VIEW_DEFINITION =
      MaterializedViewDefinition.newBuilder()
          .setSchema(SCHEMA)
          .setQuery(MATERIALIZED_VIEW_QUERY)
          .setLastRefreshTime(LAST_REFRESH_TIME)
          .setEnableRefresh(ENABLE_REFRESH)
          .setRefreshIntervalMs(REFRESH_INTERVAL_MS)
          .setClustering(CLUSTERING)
          .setTimePartitioning(TIME_PARTITIONING)
          .build();

  @Test
  public void testToBuilder() {
    compareMaterializedView(
        MATERIALIZED_VIEW_DEFINITION, MATERIALIZED_VIEW_DEFINITION.toBuilder().build());
    MaterializedViewDefinition materializedViewDefinition =
        MATERIALIZED_VIEW_DEFINITION.toBuilder().setQuery("NEW QUERY").build();
    assertEquals("NEW QUERY", materializedViewDefinition.getQuery());
    materializedViewDefinition =
        materializedViewDefinition.toBuilder().setQuery(MATERIALIZED_VIEW_QUERY).build();
    compareMaterializedView(MATERIALIZED_VIEW_DEFINITION, materializedViewDefinition);
  }

  @Test
  public void testToBuilderIncomplete() {
    TableDefinition materializedViewDefinition =
        MaterializedViewDefinition.of(MATERIALIZED_VIEW_QUERY);
    assertEquals(materializedViewDefinition, materializedViewDefinition.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(MATERIALIZED_VIEW_QUERY, MATERIALIZED_VIEW_DEFINITION.getQuery());
    assertEquals(TableDefinition.Type.MATERIALIZED_VIEW, MATERIALIZED_VIEW_DEFINITION.getType());
    assertEquals(LAST_REFRESH_TIME, MATERIALIZED_VIEW_DEFINITION.getLastRefreshTime());
    MaterializedViewDefinition materializedViewDefinition =
        MaterializedViewDefinition.newBuilder()
            .setSchema(SCHEMA)
            .setQuery(MATERIALIZED_VIEW_QUERY)
            .setLastRefreshTime(LAST_REFRESH_TIME)
            .setEnableRefresh(ENABLE_REFRESH)
            .setRefreshIntervalMs(REFRESH_INTERVAL_MS)
            .setClustering(CLUSTERING)
            .setTimePartitioning(TIME_PARTITIONING)
            .build();
    assertEquals(MATERIALIZED_VIEW_DEFINITION, materializedViewDefinition);
  }

  @Test
  public void testToAndFromPb() {
    MaterializedViewDefinition materializedViewDefinition =
        MATERIALIZED_VIEW_DEFINITION.toBuilder().build();
    assertTrue(
        TableDefinition.fromPb(materializedViewDefinition.toPb())
            instanceof MaterializedViewDefinition);
    compareMaterializedView(
        materializedViewDefinition,
        TableDefinition.<MaterializedViewDefinition>fromPb(materializedViewDefinition.toPb()));
  }

  private void compareMaterializedView(
      MaterializedViewDefinition expected, MaterializedViewDefinition actual) {
    assertEquals(expected.getType(), actual.getType());
    assertEquals(expected.getSchema(), actual.getSchema());
    assertEquals(expected.getQuery(), actual.getQuery());
    assertEquals(expected.getLastRefreshTime(), actual.getLastRefreshTime());
    assertEquals(expected.getEnableRefresh(), actual.getEnableRefresh());
    assertEquals(expected.getRefreshIntervalMs(), actual.getRefreshIntervalMs());
    assertEquals(expected.getClustering(), actual.getClustering());
    assertEquals(expected.getTimePartitioning(), actual.getTimePartitioning());
    assertEquals(expected.toString(), actual.toString());
    assertEquals(expected.hashCode(), actual.hashCode());
    assertEquals(expected, actual);
  }
}

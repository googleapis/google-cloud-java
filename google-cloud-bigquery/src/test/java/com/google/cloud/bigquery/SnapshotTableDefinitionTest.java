/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
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

import org.junit.Test;

public class SnapshotTableDefinitionTest {

  private static final TableId BASE_TABLE_ID = TableId.of("DATASET_NAME", "BASE_TABLE_NAME");
  private static final String SNAPSHOT_TIME = "2021-05-19T11:32:26.553Z";
  private static final SnapshotTableDefinition SNAPSHOTTABLE_DEFINITION =
      SnapshotTableDefinition.newBuilder()
          .setBaseTableId(BASE_TABLE_ID)
          .setSnapshotTime(SNAPSHOT_TIME)
          .build();

  @Test
  public void testToBuilder() {
    compareSnapshotTableDefinition(
        SNAPSHOTTABLE_DEFINITION, SNAPSHOTTABLE_DEFINITION.toBuilder().build());
    SnapshotTableDefinition snapshotTableDefinition =
        SNAPSHOTTABLE_DEFINITION.toBuilder().setSnapshotTime("2021-05-20T11:32:26.553Z").build();
    assertEquals("2021-05-20T11:32:26.553Z", snapshotTableDefinition.getSnapshotTime());
  }

  @Test
  public void testBuilder() {
    assertEquals(TableDefinition.Type.SNAPSHOT, SNAPSHOTTABLE_DEFINITION.getType());
    assertEquals(BASE_TABLE_ID, SNAPSHOTTABLE_DEFINITION.getBaseTableId());
    assertEquals(SNAPSHOT_TIME, SNAPSHOTTABLE_DEFINITION.getSnapshotTime());
    SnapshotTableDefinition snapshotTableDefinition =
        SnapshotTableDefinition.newBuilder()
            .setBaseTableId(BASE_TABLE_ID)
            .setSnapshotTime(SNAPSHOT_TIME)
            .build();
    assertEquals(SNAPSHOTTABLE_DEFINITION, snapshotTableDefinition);
  }

  @Test
  public void testToAndFromPb() {
    SnapshotTableDefinition snapshotTableDefinition = SNAPSHOTTABLE_DEFINITION.toBuilder().build();
    assertTrue(
        TableDefinition.fromPb(snapshotTableDefinition.toPb()) instanceof SnapshotTableDefinition);
    compareSnapshotTableDefinition(
        snapshotTableDefinition,
        TableDefinition.<SnapshotTableDefinition>fromPb(snapshotTableDefinition.toPb()));
  }

  private void compareSnapshotTableDefinition(
      SnapshotTableDefinition expected, SnapshotTableDefinition value) {
    assertEquals(expected, value);
    assertEquals(expected.getBaseTableId(), value.getBaseTableId());
    assertEquals(expected.getSnapshotTime(), value.getSnapshotTime());
  }
}

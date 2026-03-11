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

package com.google.cloud.bigquery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TableIdTest {

  private static final TableId TABLE = TableId.of("dataset", "table");
  private static final TableId TABLE_COMPLETE = TableId.of("project", "dataset", "table");
  private static final String TABLE_IAM_RESOURCE_NAME =
      "projects/project/datasets/dataset/tables/table";

  @Test
  void testOf() {
    assertEquals(null, TABLE.getProject());
    assertEquals("dataset", TABLE.getDataset());
    assertEquals("table", TABLE.getTable());
    assertEquals("project", TABLE_COMPLETE.getProject());
    assertEquals("dataset", TABLE_COMPLETE.getDataset());
    assertEquals("table", TABLE_COMPLETE.getTable());
    assertEquals(TABLE_IAM_RESOURCE_NAME, TABLE_COMPLETE.getIAMResourceName());
  }

  @Test
  void testEquals() {
    compareTableIds(TABLE, TableId.of("dataset", "table"));
    compareTableIds(TABLE_COMPLETE, TableId.of("project", "dataset", "table"));
  }

  @Test
  void testToPbAndFromPb() {
    compareTableIds(TABLE, TableId.fromPb(TABLE.toPb()));
    compareTableIds(TABLE_COMPLETE, TableId.fromPb(TABLE_COMPLETE.toPb()));
  }

  @Test
  void testSetProjectId() {
    TableId differentProjectTable = TableId.of("differentProject", "dataset", "table");
    assertEquals(differentProjectTable, TABLE.setProjectId("differentProject"));
  }

  private void compareTableIds(TableId expected, TableId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), value.getProject());
    assertEquals(expected.getDataset(), value.getDataset());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}

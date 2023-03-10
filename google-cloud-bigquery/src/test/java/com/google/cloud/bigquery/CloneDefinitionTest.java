/*
 * Copyright 2023 Google LLC
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

public class CloneDefinitionTest {
  private static final TableId BASE_TABLE_ID = TableId.of("DATASET_NAME", "BASE_TABLE_NAME");
  private static final String CLONE_TIME = "2021-05-19T11:32:26.553Z";
  private static final CloneDefinition CLONETABLE_DEFINITION =
      CloneDefinition.newBuilder().setBaseTableId(BASE_TABLE_ID).setCloneTime(CLONE_TIME).build();

  @Test
  public void testToBuilder() {
    compareCloneTableDefinition(CLONETABLE_DEFINITION, CLONETABLE_DEFINITION.toBuilder().build());
    CloneDefinition cloneTableDefinition =
        CLONETABLE_DEFINITION.toBuilder().setCloneTime("2021-05-20T11:32:26.553Z").build();
    assertEquals("2021-05-20T11:32:26.553Z", cloneTableDefinition.getCloneTime());
  }

  @Test
  public void testBuilder() {
    assertEquals(BASE_TABLE_ID, CLONETABLE_DEFINITION.getBaseTableId());
    assertEquals(CLONE_TIME, CLONETABLE_DEFINITION.getCloneTime());
    CloneDefinition cloneDefinition =
        CloneDefinition.newBuilder().setBaseTableId(BASE_TABLE_ID).setCloneTime(CLONE_TIME).build();
    assertEquals(CLONETABLE_DEFINITION, cloneDefinition);
  }

  @Test
  public void testToAndFromPb() {
    CloneDefinition cloneDefinition = CLONETABLE_DEFINITION.toBuilder().build();
    assertTrue(CloneDefinition.fromPb(cloneDefinition.toPb()) instanceof CloneDefinition);
    compareCloneTableDefinition(cloneDefinition, CloneDefinition.fromPb(cloneDefinition.toPb()));
  }

  private void compareCloneTableDefinition(CloneDefinition expected, CloneDefinition value) {
    assertEquals(expected.getBaseTableId(), value.getBaseTableId());
    assertEquals(expected.getCloneTime(), value.getCloneTime());
  }
}

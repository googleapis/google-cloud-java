/*
 * Copyright 2019 Google LLC
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

import org.junit.Test;

public class RoutineIdTest {

  public static final RoutineId ROUTINE = RoutineId.of("dataset", "routine");
  public static final RoutineId ROUTINE_COMPLETE = RoutineId.of("project", "dataset", "routine");

  @Test
  public void testOf() {
    assertEquals(null, ROUTINE.getProject());
    assertEquals("dataset", ROUTINE.getDataset());
    assertEquals("routine", ROUTINE.getRoutine());

    assertEquals("project", ROUTINE_COMPLETE.getProject());
    assertEquals("dataset", ROUTINE_COMPLETE.getDataset());
    assertEquals("routine", ROUTINE_COMPLETE.getRoutine());
  }

  @Test
  public void testEquals() {
    compareRoutineIds(ROUTINE, RoutineId.of("dataset", "routine"));
    compareRoutineIds(ROUTINE_COMPLETE, RoutineId.of("project", "dataset", "routine"));
  }

  @Test
  public void testToPbAndFromPb() {
    compareRoutineIds(ROUTINE, RoutineId.fromPb(ROUTINE.toPb()));
    compareRoutineIds(ROUTINE_COMPLETE, RoutineId.fromPb(ROUTINE_COMPLETE.toPb()));
  }

  @Test
  public void testSetProjectId() {
    RoutineId differentProjectTable = RoutineId.of("differentProject", "dataset", "routine");
    assertEquals(differentProjectTable, ROUTINE.setProjectId("differentProject"));
  }

  private void compareRoutineIds(RoutineId expected, RoutineId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), value.getProject());
    assertEquals(expected.getDataset(), value.getDataset());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}

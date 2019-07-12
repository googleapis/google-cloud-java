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

public class RoutineArgumentTest {

  private static final String NAME = "foo";
  private static final String KIND = "SCALAR_FUNCTION";
  private static final String MODE = "IN";
  private static final StandardSQLDataType DATA_TYPE =
      StandardSQLDataType.newBuilder("STRING").build();
  private static final RoutineArgument ARGUMENT =
      RoutineArgument.newBuilder()
          .setName(NAME)
          .setKind(KIND)
          .setMode(MODE)
          .setDataType(DATA_TYPE)
          .build();

  @Test
  public void testToBuilder() {
    compareRoutineArguments(ARGUMENT, ARGUMENT.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(NAME, ARGUMENT.getName());
    assertEquals(KIND, ARGUMENT.getKind());
    assertEquals(MODE, ARGUMENT.getMode());
    assertEquals(DATA_TYPE, ARGUMENT.getDataType());
  }

  @Test
  public void testToPbAndFromPb() {
    compareRoutineArguments(ARGUMENT, RoutineArgument.fromPb(ARGUMENT.toPb()));
  }

  public void compareRoutineArguments(RoutineArgument expected, RoutineArgument value) {
    assertEquals(expected, value);
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getKind(), value.getKind());
    assertEquals(expected.getMode(), value.getMode());
    assertEquals(expected.getDataType(), value.getDataType());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}

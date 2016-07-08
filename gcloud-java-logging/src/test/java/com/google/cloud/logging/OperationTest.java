/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.logging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OperationTest {

  private static final String ID = "id";
  private static final String PRODUCER = "producer";
  private static final Boolean FIRST = true;
  private static final Boolean LAST = false;
  private static final Operation OPERATION = Operation.builder(ID, PRODUCER)
      .first(FIRST)
      .last(LAST)
      .build();

  @Test
  public void testBuilder() {
    assertEquals(ID, OPERATION.id());
    assertEquals(PRODUCER, OPERATION.producer());
    assertTrue(OPERATION.first());
    assertFalse(OPERATION.last());
  }

  @Test
  public void testToBuilder() {
    compareLogOperation(OPERATION, OPERATION.toBuilder().build());
    Operation operation = OPERATION.toBuilder()
        .id("newId")
        .producer("newProducer")
        .first(false)
        .last(true)
        .build();
    assertEquals("newId", operation.id());
    assertEquals("newProducer", operation.producer());
    assertFalse(operation.first());
    assertTrue(operation.last());
    operation = operation.toBuilder()
        .id(ID)
        .producer(PRODUCER)
        .first(FIRST)
        .last(LAST)
        .build();
    compareLogOperation(OPERATION, operation);
  }

  @Test
  public void testOf() {
    Operation operation = Operation.of(ID, PRODUCER);
    assertEquals(ID, operation.id());
    assertEquals(PRODUCER, operation.producer());
    assertFalse(operation.first());
    assertFalse(operation.last());
  }

  @Test
  public void testToAndFromPb() {
    compareLogOperation(OPERATION, Operation.fromPb(OPERATION.toPb()));
    Operation operation = Operation.of(ID, PRODUCER);
    compareLogOperation(operation, Operation.fromPb(operation.toPb()));
  }

  private void compareLogOperation(Operation expected, Operation value) {
    assertEquals(expected, value);
    assertEquals(expected.id(), value.id());
    assertEquals(expected.producer(), value.producer());
    assertEquals(expected.first(), value.first());
    assertEquals(expected.last(), value.last());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}

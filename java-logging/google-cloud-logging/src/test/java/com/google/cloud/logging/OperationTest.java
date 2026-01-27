/*
 * Copyright 2016 Google LLC
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
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OperationTest {

  private static final String ID = "id";
  private static final String PRODUCER = "producer";
  private static final Boolean FIRST = true;
  private static final Boolean LAST = false;
  private static final Operation OPERATION =
      Operation.newBuilder(ID, PRODUCER).setFirst(FIRST).setLast(LAST).build();

  @Test
  public void testBuilder() {
    assertEquals(ID, OPERATION.getId());
    assertEquals(PRODUCER, OPERATION.getProducer());
    assertTrue(OPERATION.first());
    assertFalse(OPERATION.last());
  }

  @Test
  public void testToBuilder() {
    compareLogOperation(OPERATION, OPERATION.toBuilder().build());
    Operation operation =
        OPERATION.toBuilder()
            .setId("newId")
            .setProducer("newProducer")
            .setFirst(false)
            .setLast(true)
            .build();
    assertEquals("newId", operation.getId());
    assertEquals("newProducer", operation.getProducer());
    assertFalse(operation.first());
    assertTrue(operation.last());
    operation =
        operation.toBuilder().setId(ID).setProducer(PRODUCER).setFirst(FIRST).setLast(LAST).build();
    compareLogOperation(OPERATION, operation);
  }

  @Test
  public void testOf() {
    Operation operation = Operation.of(ID, PRODUCER);
    assertEquals(ID, operation.getId());
    assertEquals(PRODUCER, operation.getProducer());
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
    assertEquals(expected.getId(), value.getId());
    assertEquals(expected.getProducer(), value.getProducer());
    assertEquals(expected.first(), value.first());
    assertEquals(expected.last(), value.last());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}

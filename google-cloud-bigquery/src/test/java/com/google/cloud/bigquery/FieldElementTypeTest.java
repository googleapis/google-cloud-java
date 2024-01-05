/*
 * Copyright 2024 Google LLC
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

public class FieldElementTypeTest {
  private static final FieldElementType FIELD_ELEMENT_TYPE =
      FieldElementType.newBuilder().setType("DATE").build();

  @Test
  public void testToBuilder() {
    compareFieldElementType(FIELD_ELEMENT_TYPE, FIELD_ELEMENT_TYPE.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals("DATE", FIELD_ELEMENT_TYPE.getType());
  }

  @Test
  public void testFromAndPb() {
    assertEquals(FIELD_ELEMENT_TYPE, FieldElementType.fromPb(FIELD_ELEMENT_TYPE.toPb()));
  }

  private void compareFieldElementType(FieldElementType expected, FieldElementType value) {
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}

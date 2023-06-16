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

public class ColumnReferenceTest {
  private static final ColumnReference COLUMN_REFERENCE =
      ColumnReference.newBuilder()
          .setReferencingColumn("column1")
          .setReferencedColumn("column2")
          .build();

  @Test
  public void testToBuilder() {
    compareColumnReferenceDefinition(COLUMN_REFERENCE, COLUMN_REFERENCE.toBuilder().build());
    ColumnReference columnReference =
        COLUMN_REFERENCE
            .toBuilder()
            .setReferencingColumn("col1")
            .setReferencedColumn("col2")
            .build();
    assertEquals("col1", columnReference.getReferencingColumn());
    assertEquals("col2", columnReference.getReferencedColumn());
  }

  @Test
  public void testBuilder() {
    assertEquals("column1", COLUMN_REFERENCE.getReferencingColumn());
    assertEquals("column2", COLUMN_REFERENCE.getReferencedColumn());
    ColumnReference columnReference =
        COLUMN_REFERENCE
            .newBuilder()
            .setReferencingColumn("column1")
            .setReferencedColumn("column2")
            .build();
    assertEquals(COLUMN_REFERENCE, columnReference);
  }

  @Test
  public void testToAndFromPb() {
    ColumnReference columnReference = COLUMN_REFERENCE.toBuilder().build();
    assertTrue(ColumnReference.fromPb(columnReference.toPb()) instanceof ColumnReference);
    compareColumnReferenceDefinition(
        columnReference, ColumnReference.fromPb(columnReference.toPb()));
  }

  private void compareColumnReferenceDefinition(ColumnReference expected, ColumnReference value) {
    assertEquals(expected.getReferencingColumn(), value.getReferencingColumn());
    assertEquals(expected.getReferencedColumn(), value.getReferencedColumn());
  }
}

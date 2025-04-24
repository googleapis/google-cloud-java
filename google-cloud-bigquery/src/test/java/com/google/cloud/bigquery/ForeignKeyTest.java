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

import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

public class ForeignKeyTest {
  private static final TableId TABLE_ID = TableId.of("project", "dataset", "table");

  private static final ColumnReference COLUMN_REFERENCE =
      ColumnReference.newBuilder()
          .setReferencingColumn("column1")
          .setReferencedColumn("column2")
          .build();
  private static final ForeignKey FOREIGN_KEY =
      ForeignKey.newBuilder()
          .setName("foreign_key")
          .setReferencedTable(TABLE_ID)
          .setColumnReferences(Collections.singletonList(COLUMN_REFERENCE))
          .build();

  @Test
  public void testToBuilder() {
    compareForeignKeyDefinition(FOREIGN_KEY, FOREIGN_KEY.toBuilder().build());
    TableId referencedTable = TableId.of("project1", "dataset1", "table1");
    ArrayList<ColumnReference> columnReferences = new ArrayList<>();
    columnReferences.add(
        ColumnReference.newBuilder()
            .setReferencingColumn("from")
            .setReferencedColumn("to")
            .build());
    columnReferences.add(
        ColumnReference.newBuilder()
            .setReferencingColumn("from2")
            .setReferencedColumn("to2")
            .build());
    ForeignKey foreignKey =
        FOREIGN_KEY.toBuilder()
            .setName("test")
            .setReferencedTable(referencedTable)
            .setColumnReferences(columnReferences)
            .build();
    assertEquals("test", foreignKey.getName());
    assertEquals(referencedTable, foreignKey.getReferencedTable());
    assertEquals(columnReferences, foreignKey.getColumnReferences());
  }

  @Test
  public void testBuilder() {
    assertEquals("foreign_key", FOREIGN_KEY.getName());
    assertEquals(TABLE_ID, FOREIGN_KEY.getReferencedTable());
    assertEquals(Collections.singletonList(COLUMN_REFERENCE), FOREIGN_KEY.getColumnReferences());
    ForeignKey foreignKey =
        FOREIGN_KEY
            .newBuilder()
            .setName("foreign_key")
            .setReferencedTable(TABLE_ID)
            .setColumnReferences(Collections.singletonList(COLUMN_REFERENCE))
            .build();
    assertEquals(FOREIGN_KEY, foreignKey);
  }

  @Test
  public void testToAndFromPb() {
    ForeignKey foreignKey = FOREIGN_KEY.toBuilder().build();
    assertTrue(ForeignKey.fromPb(foreignKey.toPb()) instanceof ForeignKey);
    compareForeignKeyDefinition(foreignKey, ForeignKey.fromPb(foreignKey.toPb()));
  }

  private void compareForeignKeyDefinition(ForeignKey expected, ForeignKey value) {
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getReferencedTable(), value.getReferencedTable());
    assertEquals(expected.getColumnReferences(), value.getColumnReferences());
  }
}

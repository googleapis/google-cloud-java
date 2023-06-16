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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class TableConstraintsTest {
  private static final List<String> COLUMNS_PK = Arrays.asList("column1", "column2");
  private static final PrimaryKey PRIMARY_KEY =
      PrimaryKey.newBuilder().setColumns(COLUMNS_PK).build();
  private static final TableId TABLE_ID_PK = TableId.of("project", "dataset", "table");

  private static final ColumnReference COLUMN_REFERENCE =
      ColumnReference.newBuilder()
          .setReferencingColumn("column1")
          .setReferencedColumn("column2")
          .build();
  private static final ForeignKey FOREIGN_KEY =
      ForeignKey.newBuilder()
          .setName("foreign_key")
          .setReferencedTable(TABLE_ID_PK)
          .setColumnReferences(Collections.singletonList(COLUMN_REFERENCE))
          .build();

  private static final TableConstraints TABLE_CONSTRAINTS =
      TableConstraints.newBuilder()
          .setPrimaryKey(PRIMARY_KEY)
          .setForeignKeys(Collections.singletonList(FOREIGN_KEY))
          .build();

  @Test
  public void testToBuilder() {
    compareTableConstraintsDefinition(TABLE_CONSTRAINTS, TABLE_CONSTRAINTS.toBuilder().build());
    List<String> columnsPk = Arrays.asList("col1", "col2", "col3");
    PrimaryKey primaryKey = PrimaryKey.newBuilder().setColumns(columnsPk).build();
    TableId referencedTable = TableId.of("project1", "dataset1", "table1");
    TableId referencedTable2 = TableId.of("project2", "dataset2", "table2");
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
    ForeignKey foreignKey1 =
        ForeignKey.newBuilder()
            .setName("test")
            .setReferencedTable(referencedTable)
            .setColumnReferences(columnReferences)
            .build();
    ForeignKey foreignKey2 =
        ForeignKey.newBuilder()
            .setName("test")
            .setReferencedTable(referencedTable2)
            .setColumnReferences(columnReferences)
            .build();

    TableConstraints tableConstraints =
        TABLE_CONSTRAINTS
            .toBuilder()
            .setForeignKeys(Arrays.asList(foreignKey1, foreignKey2))
            .setPrimaryKey(primaryKey)
            .build();
    assertEquals(Arrays.asList(foreignKey1, foreignKey2), tableConstraints.getForeignKeys());
    assertEquals(primaryKey, tableConstraints.getPrimaryKey());
  }

  @Test
  public void testBuilder() {
    assertEquals(Collections.singletonList(FOREIGN_KEY), TABLE_CONSTRAINTS.getForeignKeys());
    assertEquals(PRIMARY_KEY, TABLE_CONSTRAINTS.getPrimaryKey());
    TableConstraints tableConstraints =
        TABLE_CONSTRAINTS
            .newBuilder()
            .setForeignKeys(Collections.singletonList(FOREIGN_KEY))
            .setPrimaryKey(PRIMARY_KEY)
            .build();
    assertEquals(TABLE_CONSTRAINTS, tableConstraints);
  }

  @Test
  public void testToAndFromPb() {
    TableConstraints tableConstraints = TABLE_CONSTRAINTS.toBuilder().build();
    assertTrue(TableConstraints.fromPb(tableConstraints.toPb()) instanceof TableConstraints);
    compareTableConstraintsDefinition(
        tableConstraints, TableConstraints.fromPb(tableConstraints.toPb()));
  }

  private void compareTableConstraintsDefinition(
      TableConstraints expected, TableConstraints value) {
    assertEquals(expected.getForeignKeys(), value.getForeignKeys());
    assertEquals(expected.getPrimaryKey(), value.getPrimaryKey());
  }
}

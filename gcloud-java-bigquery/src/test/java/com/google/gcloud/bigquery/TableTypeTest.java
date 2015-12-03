/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TableTypeTest {

  private static final Field FIELD_SCHEMA1 =
      Field.builder("StringField", Field.Type.string())
          .mode(Field.Mode.NULLABLE)
          .description("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.builder("IntegerField", Field.Type.integer())
          .mode(Field.Mode.REPEATED)
          .description("FieldDescription2")
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.builder("RecordField", Field.Type.record(FIELD_SCHEMA1, FIELD_SCHEMA2))
          .mode(Field.Mode.REQUIRED)
          .description("FieldDescription3")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA1, FIELD_SCHEMA2, FIELD_SCHEMA3);
  private static final String VIEW_QUERY = "VIEW QUERY";
  private static final ExternalDataConfiguration CONFIGURATION = ExternalDataConfiguration
      .builder(ImmutableList.of("URI"), TABLE_SCHEMA, FormatOptions.datastoreBackup())
      .compression("ZIP")
      .ignoreUnknownValues(true)
      .maxBadRecords(42)
      .build();
  private static List<UserDefinedFunction> FUNCTIONS = ImmutableList.of(
      UserDefinedFunction.inline("Function"), UserDefinedFunction.fromUri("URI"));
  private static final TableType TABLE = TableType.table(TABLE_SCHEMA);
  private static final TableType.View VIEW = TableType.view(VIEW_QUERY);
  private static final TableType.View VIEW_WITH_FUNCTIONS = TableType.view(VIEW_QUERY, FUNCTIONS);
  private static final TableType.ExternalTable EXTERNAL = TableType.externalTable(CONFIGURATION);

  @Test
  public void testConstructor() {
    TableType table = new TableType(TableType.Type.TABLE, TABLE_SCHEMA);
    assertEquals(TableType.Type.TABLE, table.type());
    assertEquals(TABLE_SCHEMA, table.schema());
    TableType.View view = new TableType.View(VIEW_QUERY);
    assertEquals(TableType.Type.VIEW, view.type());
    assertEquals(null, view.schema());
    assertEquals(VIEW_QUERY, view.query());
    assertEquals(null, view.userDefinedFunctions());
    view = new TableType.View(VIEW_QUERY, FUNCTIONS);
    assertEquals(TableType.Type.VIEW, view.type());
    assertEquals(null, view.schema());
    assertEquals(VIEW_QUERY, view.query());
    assertEquals(FUNCTIONS, view.userDefinedFunctions());
    view = new TableType.View(TABLE_SCHEMA, VIEW_QUERY, FUNCTIONS);
    assertEquals(TableType.Type.VIEW, view.type());
    assertEquals(TABLE_SCHEMA, view.schema());
    assertEquals(VIEW_QUERY, view.query());
    assertEquals(FUNCTIONS, view.userDefinedFunctions());
    TableType.ExternalTable extern = new TableType.ExternalTable(CONFIGURATION);
    assertEquals(TableType.Type.EXTERNAL, extern.type());
    assertEquals(null, extern.schema());
    assertEquals(CONFIGURATION, extern.configuration());
    extern = new TableType.ExternalTable(TABLE_SCHEMA, CONFIGURATION);
    assertEquals(TableType.Type.EXTERNAL, extern.type());
    assertEquals(TABLE_SCHEMA, extern.schema());
    assertEquals(CONFIGURATION, extern.configuration());
  }

  @Test
  public void testFactoryMethods() {
    TableType table = TableType.table(TABLE_SCHEMA);
    assertEquals(TableType.Type.TABLE, table.type());
    assertEquals(TABLE_SCHEMA, table.schema());
    TableType.View view = TableType.view(VIEW_QUERY);
    assertEquals(TableType.Type.VIEW, view.type());
    assertEquals(null, view.schema());
    assertEquals(VIEW_QUERY, view.query());
    assertEquals(null, view.userDefinedFunctions());
    view = TableType.view(VIEW_QUERY, FUNCTIONS);
    assertEquals(TableType.Type.VIEW, view.type());
    assertEquals(null, view.schema());
    assertEquals(VIEW_QUERY, view.query());
    assertEquals(FUNCTIONS, view.userDefinedFunctions());
    TableType.ExternalTable extern = TableType.externalTable(CONFIGURATION);
    assertEquals(TableType.Type.EXTERNAL, extern.type());
    assertEquals(null, extern.schema());
    assertEquals(CONFIGURATION, extern.configuration());
  }

  @Test
  public void testEquals() {
    assertEquals(new TableType(TableType.Type.TABLE, TABLE_SCHEMA), TableType.table(TABLE_SCHEMA));
    assertEquals(new TableType.View(VIEW_QUERY), TableType.view(VIEW_QUERY));
    assertEquals(new TableType.View(VIEW_QUERY, FUNCTIONS), TableType.view(VIEW_QUERY, FUNCTIONS));
    assertEquals(new TableType.ExternalTable(CONFIGURATION),
        TableType.externalTable(CONFIGURATION));
    assertEquals(new TableType(TableType.Type.TABLE, TABLE_SCHEMA).hashCode(),
        TableType.table(TABLE_SCHEMA).hashCode());
    assertEquals(new TableType.View(VIEW_QUERY).hashCode(),
        TableType.view(VIEW_QUERY).hashCode());
    assertEquals(new TableType.View(VIEW_QUERY, FUNCTIONS).hashCode(),
        TableType.view(VIEW_QUERY, FUNCTIONS).hashCode());
    assertEquals(new TableType.ExternalTable(CONFIGURATION).hashCode(),
        TableType.externalTable(CONFIGURATION).hashCode());
  }
}

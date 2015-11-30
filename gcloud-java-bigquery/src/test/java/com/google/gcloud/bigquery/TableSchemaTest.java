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

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class TableSchemaTest {

  private static final FieldSchema FIELD_SCHEMA1 =
      FieldSchema.builder("StringField", FieldSchema.Type.STRING)
      .mode(FieldSchema.Mode.NULLABLE)
      .description("FieldDescription1")
      .build();
  private static final FieldSchema FIELD_SCHEMA2 =
      FieldSchema.builder("IntegerField", FieldSchema.Type.INTEGER)
      .mode(FieldSchema.Mode.REPEATED)
      .description("FieldDescription2")
      .build();
  private static final FieldSchema FIELD_SCHEMA3 =
      FieldSchema.builder("RecordField", ImmutableList.of(FIELD_SCHEMA1, FIELD_SCHEMA2))
      .mode(FieldSchema.Mode.REQUIRED)
      .description("FieldDescription3")
      .build();
  private static final List<FieldSchema> FIELDS = ImmutableList.of(FIELD_SCHEMA1, FIELD_SCHEMA2,
      FIELD_SCHEMA3);
  private static final TableSchema TABLE_SCHEMA = TableSchema.builder().fields(FIELDS).build();

  @Test
  public void testToBuilder() {
    compareTableSchema(TABLE_SCHEMA, TABLE_SCHEMA.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(FIELDS, TABLE_SCHEMA.fields());
    TableSchema tableSchema = TABLE_SCHEMA.toBuilder()
        .fields(ImmutableList.of(FIELD_SCHEMA1, FIELD_SCHEMA2))
        .addField(FIELD_SCHEMA3)
        .build();
    compareTableSchema(TABLE_SCHEMA, tableSchema);
  }

  @Test
  public void testOf() {
    compareTableSchema(TABLE_SCHEMA, TableSchema.of(FIELDS));
  }

  @Test
  public void testToAndFromPb() {
    compareTableSchema(TABLE_SCHEMA, TableSchema.fromPb(TABLE_SCHEMA.toPb()));
  }

  private void compareTableSchema(TableSchema expected, TableSchema value) {
    assertEquals(expected, value);
    assertEquals(expected.fields(), value.fields());
  }
}

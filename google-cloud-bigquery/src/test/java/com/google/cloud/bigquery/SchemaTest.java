/*
 * Copyright 2015 Google LLC
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

import com.google.api.services.bigquery.model.TableSchema;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class SchemaTest {

  private static PolicyTags POLICY_TAGS =
      PolicyTags.newBuilder().setNames(ImmutableList.of("someTag")).build();

  private static final Field FIELD_SCHEMA1 =
      Field.newBuilder("StringField", LegacySQLTypeName.STRING)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("FieldDescription1")
          .setPrecision(20L)
          .setScale(20L)
          .setMaxLength(10L)
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.newBuilder("IntegerField", LegacySQLTypeName.INTEGER)
          .setMode(Field.Mode.REPEATED)
          .setDescription("FieldDescription2")
          .setPolicyTags(POLICY_TAGS)
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.newBuilder("RecordField", LegacySQLTypeName.RECORD, FIELD_SCHEMA1, FIELD_SCHEMA2)
          .setMode(Field.Mode.REQUIRED)
          .setDescription("FieldDescription3")
          .build();

  private static final List<Field> FIELDS =
      ImmutableList.of(FIELD_SCHEMA1, FIELD_SCHEMA2, FIELD_SCHEMA3);
  private static final Schema TABLE_SCHEMA = Schema.of(FIELDS);

  @Test
  public void testOf() {
    compareTableSchema(TABLE_SCHEMA, Schema.of(FIELDS));
  }

  @Test
  public void testToAndFromPb() {
    compareTableSchema(TABLE_SCHEMA, Schema.fromPb(TABLE_SCHEMA.toPb()));
  }

  private void compareTableSchema(Schema expected, Schema value) {
    assertEquals(expected, value);
    assertEquals(expected.getFields(), value.getFields());
  }

  @Test
  public void testEmptySchema() {
    TableSchema tableSchema = new TableSchema();
    Schema schema = Schema.fromPb(tableSchema);
    assertEquals(0, schema.getFields().size());
  }
}

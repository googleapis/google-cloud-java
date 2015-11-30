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

public class FieldSchemaTest {

  private static final String FIELD_NAME1 = "StringField";
  private static final String FIELD_NAME2 = "IntegerField";
  private static final String FIELD_NAME3 = "RecordField";
  private static final FieldSchema.Type FIELD_TYPE1 = FieldSchema.Type.STRING;
  private static final FieldSchema.Type FIELD_TYPE2 = FieldSchema.Type.INTEGER;
  private static final FieldSchema.Type FIELD_TYPE3 = FieldSchema.Type.RECORD;
  private static final FieldSchema.Mode FIELD_MODE1 = FieldSchema.Mode.NULLABLE;
  private static final FieldSchema.Mode FIELD_MODE2 = FieldSchema.Mode.REPEATED;
  private static final FieldSchema.Mode FIELD_MODE3 = FieldSchema.Mode.REQUIRED;
  private static final String FIELD_DESCRIPTION1 = "FieldDescription1";
  private static final String FIELD_DESCRIPTION2 = "FieldDescription2";
  private static final String FIELD_DESCRIPTION3 = "FieldDescription3";
  private static final FieldSchema FIELD_SCHEMA1 = FieldSchema.builder(FIELD_NAME1, FIELD_TYPE1)
      .mode(FIELD_MODE1)
      .description(FIELD_DESCRIPTION1)
      .build();
  private static final FieldSchema FIELD_SCHEMA2 = FieldSchema.builder(FIELD_NAME2, FIELD_TYPE2)
      .mode(FIELD_MODE2)
      .description(FIELD_DESCRIPTION2)
      .build();
  private static final FieldSchema FIELD_SCHEMA3 = FieldSchema
      .builder(FIELD_NAME3, ImmutableList.of(FIELD_SCHEMA1, FIELD_SCHEMA2))
      .mode(FIELD_MODE3)
      .description(FIELD_DESCRIPTION3)
      .build();

  @Test
  public void testToBuilder() {
    compareFieldSchemas(FIELD_SCHEMA1, FIELD_SCHEMA1.toBuilder().build());
    compareFieldSchemas(FIELD_SCHEMA2, FIELD_SCHEMA2.toBuilder().build());
    compareFieldSchemas(FIELD_SCHEMA3, FIELD_SCHEMA3.toBuilder().build());
    FieldSchema fieldSchema = FIELD_SCHEMA1.toBuilder()
        .description("New Description")
        .build();
    assertEquals("New Description", fieldSchema.description());
    fieldSchema = fieldSchema.toBuilder().description(FIELD_DESCRIPTION1).build();
    compareFieldSchemas(FIELD_SCHEMA1, fieldSchema);
  }

  @Test
  public void testToBuilderIncomplete() {
    FieldSchema fieldSchema = FieldSchema.of(FIELD_NAME1, FIELD_TYPE1);
    compareFieldSchemas(fieldSchema, fieldSchema.toBuilder().build());
    fieldSchema = FieldSchema.of(FIELD_NAME2, ImmutableList.of(FIELD_SCHEMA1, FIELD_SCHEMA2));
    compareFieldSchemas(fieldSchema, fieldSchema.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(FIELD_NAME1, FIELD_SCHEMA1.name());
    assertEquals(FIELD_TYPE1, FIELD_SCHEMA1.type());
    assertEquals(FIELD_MODE1, FIELD_SCHEMA1.mode());
    assertEquals(FIELD_DESCRIPTION1, FIELD_SCHEMA1.description());
    assertEquals(null, FIELD_SCHEMA1.fields());
    assertEquals(FIELD_NAME3, FIELD_SCHEMA3.name());
    assertEquals(FIELD_TYPE3, FIELD_SCHEMA3.type());
    assertEquals(FIELD_MODE3, FIELD_SCHEMA3.mode());
    assertEquals(FIELD_DESCRIPTION3, FIELD_SCHEMA3.description());
    assertEquals(ImmutableList.of(FIELD_SCHEMA1, FIELD_SCHEMA2), FIELD_SCHEMA3.fields());
  }

  @Test
  public void testToAndFromPb() {
    compareFieldSchemas(FIELD_SCHEMA1, FieldSchema.fromPb(FIELD_SCHEMA1.toPb()));
    compareFieldSchemas(FIELD_SCHEMA2, FieldSchema.fromPb(FIELD_SCHEMA2.toPb()));
    compareFieldSchemas(FIELD_SCHEMA3, FieldSchema.fromPb(FIELD_SCHEMA3.toPb()));
    FieldSchema fieldSchema = FieldSchema.builder(FIELD_NAME1, FIELD_TYPE1).build();
    compareFieldSchemas(fieldSchema, FieldSchema.fromPb(fieldSchema.toPb()));
  }

  private void compareFieldSchemas(FieldSchema expected, FieldSchema value) {
    assertEquals(expected, value);
    assertEquals(expected.name(), value.name());
    assertEquals(expected.type(), value.type());
    assertEquals(expected.mode(), value.mode());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.fields(), value.fields());
  }
}

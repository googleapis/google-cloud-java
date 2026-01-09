/*
 * Copyright 2017 Google LLC
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FieldListTest {
  private static final String FIELD_NAME1 = "StringField";
  private static final String FIELD_NAME2 = "IntegerField";
  private static final String FIELD_NAME3 = "RecordField";
  private static final String FIELD_NAME_CASE_INSENSITIVE1 = "stringfield";
  private static final String FIELD_NAME_CASE_INSENSITIVE2 = "integerfield";
  private static final String FIELD_NAME_CASE_INSENSITIVE3 = "recordfield";
  private static final String FIELD_NAME_CASE_INSENSITIVE4 = "stRingfiEld";
  private static final String FIELD_NAME_CASE_INSENSITIVE5 = "inTeGerField";
  private static final String FIELD_NAME_CASE_INSENSITIVE6 = "recOrdfieLd";
  private static final String FIELD_NAME4 = "NonExistentField";
  private static final LegacySQLTypeName FIELD_TYPE1 = LegacySQLTypeName.STRING;
  private static final LegacySQLTypeName FIELD_TYPE2 = LegacySQLTypeName.INTEGER;
  private static final LegacySQLTypeName FIELD_TYPE3 = LegacySQLTypeName.RECORD;
  private static final Field.Mode FIELD_MODE1 = Field.Mode.NULLABLE;
  private static final Field.Mode FIELD_MODE2 = Field.Mode.REPEATED;
  private static final Field.Mode FIELD_MODE3 = Field.Mode.REQUIRED;
  private static final String FIELD_DESCRIPTION1 = "FieldDescription1";
  private static final String FIELD_DESCRIPTION2 = "FieldDescription2";
  private static final String FIELD_DESCRIPTION3 = "FieldDescription3";

  private final Field fieldSchema1 =
      Field.newBuilder(FIELD_NAME1, FIELD_TYPE1)
          .setMode(FIELD_MODE1)
          .setDescription(FIELD_DESCRIPTION1)
          .build();
  private final Field fieldSchema2 =
      Field.newBuilder(FIELD_NAME2, FIELD_TYPE2)
          .setMode(FIELD_MODE2)
          .setDescription(FIELD_DESCRIPTION2)
          .build();

  private final Field fieldSchema3 =
      Field.newBuilder(FIELD_NAME3, FIELD_TYPE3, fieldSchema1, fieldSchema2)
          .setMode(FIELD_MODE3)
          .setDescription(FIELD_DESCRIPTION3)
          .build();

  private final FieldList fieldsSchema = FieldList.of(fieldSchema1, fieldSchema2, fieldSchema3);

  @Test
  void testGetByName() {
    assertEquals(fieldSchema1, fieldsSchema.get(FIELD_NAME1));
    assertEquals(fieldSchema2, fieldsSchema.get(FIELD_NAME2));
    assertEquals(fieldSchema3, fieldsSchema.get(FIELD_NAME3));
    assertEquals(fieldSchema1, fieldsSchema.get(FIELD_NAME_CASE_INSENSITIVE1));
    assertEquals(fieldSchema2, fieldsSchema.get(FIELD_NAME_CASE_INSENSITIVE2));
    assertEquals(fieldSchema3, fieldsSchema.get(FIELD_NAME_CASE_INSENSITIVE3));
    assertEquals(fieldSchema1, fieldsSchema.get(FIELD_NAME_CASE_INSENSITIVE4));
    assertEquals(fieldSchema2, fieldsSchema.get(FIELD_NAME_CASE_INSENSITIVE5));
    assertEquals(fieldSchema3, fieldsSchema.get(FIELD_NAME_CASE_INSENSITIVE6));

    assertEquals(3, fieldsSchema.size());

    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> fieldsSchema.get(FIELD_NAME4));
    assertNotNull(exception);
  }

  @Test
  void testGetByIndex() {
    assertEquals(fieldSchema1, fieldsSchema.get(0));
    assertEquals(fieldSchema2, fieldsSchema.get(1));
    assertEquals(fieldSchema3, fieldsSchema.get(2));

    assertEquals(3, fieldsSchema.size());

    IndexOutOfBoundsException exception =
        assertThrows(IndexOutOfBoundsException.class, () -> fieldsSchema.get(4));
    assertNotNull(exception);
  }

  @Test
  void testGetRecordSchema() {
    assertEquals(2, fieldSchema3.getSubFields().size());
    assertEquals(fieldSchema1, fieldSchema3.getSubFields().get(FIELD_NAME1));
    assertEquals(fieldSchema2, fieldSchema3.getSubFields().get(FIELD_NAME2));
    assertEquals(fieldSchema1, fieldSchema3.getSubFields().get(FIELD_NAME_CASE_INSENSITIVE1));
    assertEquals(fieldSchema2, fieldSchema3.getSubFields().get(FIELD_NAME_CASE_INSENSITIVE2));
    assertEquals(fieldSchema1, fieldSchema3.getSubFields().get(FIELD_NAME_CASE_INSENSITIVE4));
    assertEquals(fieldSchema2, fieldSchema3.getSubFields().get(FIELD_NAME_CASE_INSENSITIVE5));
    assertEquals(0, fieldSchema3.getSubFields().getIndex(FIELD_NAME1));
    assertEquals(1, fieldSchema3.getSubFields().getIndex(FIELD_NAME2));
    assertEquals(0, fieldSchema3.getSubFields().getIndex(FIELD_NAME_CASE_INSENSITIVE1));
    assertEquals(1, fieldSchema3.getSubFields().getIndex(FIELD_NAME_CASE_INSENSITIVE2));
    assertEquals(0, fieldSchema3.getSubFields().getIndex(FIELD_NAME_CASE_INSENSITIVE4));
    assertEquals(1, fieldSchema3.getSubFields().getIndex(FIELD_NAME_CASE_INSENSITIVE5));
    assertEquals(fieldSchema1, fieldSchema3.getSubFields().get(0));
    assertEquals(fieldSchema2, fieldSchema3.getSubFields().get(1));
  }

  @Test
  void testToAndFromPb() {
    assertEquals(fieldsSchema, FieldList.of(fieldSchema1, fieldSchema2, fieldSchema3));
    assertNotEquals(fieldsSchema, FieldList.of(fieldSchema1, fieldSchema3));

    assertEquals(fieldsSchema, FieldList.fromPb(fieldsSchema.toPb()));
  }
}

/*
 * Copyright 2026 Google LLC
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.bigquery.Field.Mode;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.types.DateUnit;
import org.apache.arrow.vector.types.FloatingPointPrecision;
import org.apache.arrow.vector.types.TimeUnit;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.junit.jupiter.api.Test;

public class ArrowPojoUtilsTest {

  @Test
  public void testArrowSchemaToBigQuerySchema_Primitives() {
    Field intField = new Field("int_col", FieldType.nullable(new ArrowType.Int(64, true)), null);
    Field strField = new Field("str_col", FieldType.notNullable(new ArrowType.Utf8()), null);
    Field boolField = new Field("bool_col", FieldType.nullable(new ArrowType.Bool()), null);
    Field bytesField = new Field("bytes_col", FieldType.nullable(new ArrowType.Binary()), null);
    Field floatField =
        new Field(
            "float_col",
            FieldType.nullable(new ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE)),
            null);
    Field decimalField =
        new Field("num_col", FieldType.nullable(new ArrowType.Decimal(38, 9, 128)), null);
    Field dateField =
        new Field("date_col", FieldType.nullable(new ArrowType.Date(DateUnit.DAY)), null);
    Field timeField =
        new Field(
            "time_col", FieldType.nullable(new ArrowType.Time(TimeUnit.MICROSECOND, 64)), null);
    Field tsField =
        new Field(
            "ts_col",
            FieldType.nullable(new ArrowType.Timestamp(TimeUnit.MICROSECOND, "UTC")),
            null);

    Schema arrowSchema =
        new Schema(
            ImmutableList.of(
                intField,
                strField,
                boolField,
                bytesField,
                floatField,
                decimalField,
                dateField,
                timeField,
                tsField));

    com.google.cloud.bigquery.Schema bqSchema =
        ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema);

    assertEquals(9, bqSchema.getFields().size());
    assertEquals(LegacySQLTypeName.INTEGER, bqSchema.getFields().get(0).getType());
    assertEquals(Mode.NULLABLE, bqSchema.getFields().get(0).getMode());

    assertEquals(LegacySQLTypeName.STRING, bqSchema.getFields().get(1).getType());
    assertEquals(Mode.REQUIRED, bqSchema.getFields().get(1).getMode());

    assertEquals(LegacySQLTypeName.BOOLEAN, bqSchema.getFields().get(2).getType());
    assertEquals(LegacySQLTypeName.BYTES, bqSchema.getFields().get(3).getType());
    assertEquals(LegacySQLTypeName.FLOAT, bqSchema.getFields().get(4).getType());
    assertEquals(LegacySQLTypeName.NUMERIC, bqSchema.getFields().get(5).getType());
    assertEquals(LegacySQLTypeName.DATE, bqSchema.getFields().get(6).getType());
    assertEquals(LegacySQLTypeName.TIME, bqSchema.getFields().get(7).getType());
    assertEquals(LegacySQLTypeName.TIMESTAMP, bqSchema.getFields().get(8).getType());
  }

  @Test
  public void testArrowSchemaToBigQuerySchema_NestedStruct() {
    Field innerInt = new Field("id", FieldType.nullable(new ArrowType.Int(32, true)), null);
    Field innerStr = new Field("name", FieldType.nullable(new ArrowType.Utf8()), null);
    Field structField =
        new Field(
            "person",
            FieldType.nullable(new ArrowType.Struct()),
            ImmutableList.of(innerInt, innerStr));

    Schema arrowSchema = new Schema(ImmutableList.of(structField));
    com.google.cloud.bigquery.Schema bqSchema =
        ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema);

    assertEquals(1, bqSchema.getFields().size());
    com.google.cloud.bigquery.Field personField = bqSchema.getFields().get(0);
    assertEquals("person", personField.getName());
    assertEquals(LegacySQLTypeName.RECORD, personField.getType());
    assertEquals(2, personField.getSubFields().size());
    assertEquals("id", personField.getSubFields().get(0).getName());
    assertEquals(LegacySQLTypeName.INTEGER, personField.getSubFields().get(0).getType());
    assertEquals("name", personField.getSubFields().get(1).getName());
    assertEquals(LegacySQLTypeName.STRING, personField.getSubFields().get(1).getType());
  }

  @Test
  public void testArrowSchemaToBigQuerySchema_ListPrimitives() {
    Field itemField = new Field("item", FieldType.notNullable(new ArrowType.Utf8()), null);
    Field listField =
        new Field("tags", FieldType.nullable(new ArrowType.List()), ImmutableList.of(itemField));

    Schema arrowSchema = new Schema(ImmutableList.of(listField));
    com.google.cloud.bigquery.Schema bqSchema =
        ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema);

    assertEquals(1, bqSchema.getFields().size());
    com.google.cloud.bigquery.Field tagsField = bqSchema.getFields().get(0);
    assertEquals("tags", tagsField.getName());
    assertEquals(LegacySQLTypeName.STRING, tagsField.getType());
    assertEquals(Mode.REPEATED, tagsField.getMode());
  }

  @Test
  public void testArrowSchemaToBigQuerySchema_ListOfStruct() {
    Field innerKey = new Field("key", FieldType.nullable(new ArrowType.Utf8()), null);
    Field innerVal = new Field("value", FieldType.nullable(new ArrowType.Int(64, true)), null);
    Field structField =
        new Field(
            "item",
            FieldType.nullable(new ArrowType.Struct()),
            ImmutableList.of(innerKey, innerVal));
    Field listField =
        new Field(
            "entries", FieldType.nullable(new ArrowType.List()), ImmutableList.of(structField));

    Schema arrowSchema = new Schema(ImmutableList.of(listField));
    com.google.cloud.bigquery.Schema bqSchema =
        ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema);

    assertEquals(1, bqSchema.getFields().size());
    com.google.cloud.bigquery.Field entriesField = bqSchema.getFields().get(0);
    assertEquals("entries", entriesField.getName());
    assertEquals(LegacySQLTypeName.RECORD, entriesField.getType());
    assertEquals(Mode.REPEATED, entriesField.getMode());
    assertEquals(2, entriesField.getSubFields().size());
    assertEquals("key", entriesField.getSubFields().get(0).getName());
    assertEquals("value", entriesField.getSubFields().get(1).getName());
  }

  @Test
  public void testArrowSchemaToBigQuerySchema_EmptyListThrowsException() {
    Field emptyList =
        new Field("empty_list", FieldType.nullable(new ArrowType.List()), ImmutableList.of());
    Schema arrowSchema = new Schema(ImmutableList.of(emptyList));

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema));
    assertTrue(thrown.getMessage().contains("must have at least one child field"));
  }

  @Test
  public void testArrowSchemaToBigQuerySchema_UnsupportedTypeThrowsException() {
    Field unsupportedField =
        new Field("unsupported", FieldType.nullable(new ArrowType.Null()), null);
    Schema arrowSchema = new Schema(ImmutableList.of(unsupportedField));

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema));
    assertTrue(thrown.getMessage().contains("Unsupported Arrow type"));
  }

  @Test
  public void testCreateVectors_Success() {
    try (BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE)) {
      Field intField = new Field("int_col", FieldType.nullable(new ArrowType.Int(32, true)), null);
      Field strField = new Field("str_col", FieldType.nullable(new ArrowType.Utf8()), null);
      Schema arrowSchema = new Schema(ImmutableList.of(intField, strField));

      List<FieldVector> vectors = ArrowPojoUtils.createVectors(arrowSchema, allocator);
      assertEquals(2, vectors.size());
      assertEquals("int_col", vectors.get(0).getName());
      assertEquals("str_col", vectors.get(1).getName());

      for (FieldVector v : vectors) {
        v.close();
      }
    }
  }
}

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

import java.util.ArrayList;
import java.util.List;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.Schema;

/** Internal helper for Apache Arrow Schema/Field conversions. */
final class ArrowPojoUtils {

  private ArrowPojoUtils() {}

  static com.google.cloud.bigquery.Schema arrowSchemaToBigQuerySchema(Object arrowSchemaObj) {
    Schema arrowSchema = (Schema) arrowSchemaObj;
    List<com.google.cloud.bigquery.Field> fields = new ArrayList<>();
    for (Field arrowField : arrowSchema.getFields()) {
      fields.add(arrowFieldToBigQueryField(arrowField));
    }
    return com.google.cloud.bigquery.Schema.of(fields);
  }

  static com.google.cloud.bigquery.Field arrowFieldToBigQueryField(Field arrowField) {
    String name = arrowField.getName();
    ArrowType type = arrowField.getType();
    com.google.cloud.bigquery.Field.Builder builder;

    if (type instanceof ArrowType.List) {
      if (arrowField.getChildren().isEmpty()) {
        throw new IllegalArgumentException(
            "Arrow List field must have at least one child field: " + name);
      }
      Field innerField = arrowField.getChildren().get(0);
      LegacySQLTypeName innerType = arrowTypeToLegacySQLTypeName(innerField.getType());
      builder = com.google.cloud.bigquery.Field.newBuilder(name, innerType);
      builder.setMode(com.google.cloud.bigquery.Field.Mode.REPEATED);
      if (!innerField.getChildren().isEmpty()) {
        List<com.google.cloud.bigquery.Field> subFields = new ArrayList<>();
        for (Field childField : innerField.getChildren()) {
          subFields.add(arrowFieldToBigQueryField(childField));
        }
        builder.setType(LegacySQLTypeName.RECORD, FieldList.of(subFields));
      }
    } else {
      LegacySQLTypeName bqType = arrowTypeToLegacySQLTypeName(type);
      builder = com.google.cloud.bigquery.Field.newBuilder(name, bqType);
      if (arrowField.isNullable()) {
        builder.setMode(com.google.cloud.bigquery.Field.Mode.NULLABLE);
      } else {
        builder.setMode(com.google.cloud.bigquery.Field.Mode.REQUIRED);
      }
      if (!arrowField.getChildren().isEmpty()) {
        List<com.google.cloud.bigquery.Field> subFields = new ArrayList<>();
        for (Field childField : arrowField.getChildren()) {
          subFields.add(arrowFieldToBigQueryField(childField));
        }
        builder.setType(LegacySQLTypeName.RECORD, FieldList.of(subFields));
      }
    }
    return builder.build();
  }

  static List<FieldVector> createVectors(Object arrowSchemaObj, BufferAllocator allocator) {
    Schema arrowSchema = (Schema) arrowSchemaObj;
    List<FieldVector> vectors = new ArrayList<>();
    for (Field field : arrowSchema.getFields()) {
      vectors.add(field.createVector(allocator));
    }
    return vectors;
  }

  private static LegacySQLTypeName arrowTypeToLegacySQLTypeName(ArrowType type) {
    switch (type.getTypeID()) {
      case Int:
        return LegacySQLTypeName.INTEGER;
      case FloatingPoint:
        return LegacySQLTypeName.FLOAT;
      case Utf8:
        return LegacySQLTypeName.STRING;
      case Bool:
        return LegacySQLTypeName.BOOLEAN;
      case Binary:
        return LegacySQLTypeName.BYTES;
      case Decimal:
        return LegacySQLTypeName.NUMERIC;
      case Timestamp:
        return LegacySQLTypeName.TIMESTAMP;
      case Date:
        return LegacySQLTypeName.DATE;
      case Time:
        return LegacySQLTypeName.TIME;
      case Struct:
        return LegacySQLTypeName.RECORD;
      default:
        throw new IllegalArgumentException("Unsupported Arrow type: " + type.getTypeID());
    }
  }
}

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

/** Internal helper for Apache Arrow Schema/Field conversions. */
final class ArrowPojoUtils {

  private ArrowPojoUtils() {}

  static Schema arrowSchemaToBigQuerySchema(Object arrowSchemaObj) {
    org.apache.arrow.vector.types.pojo.Schema arrowSchema =
        (org.apache.arrow.vector.types.pojo.Schema) arrowSchemaObj;
    List<Field> fields = new ArrayList<>();
    for (org.apache.arrow.vector.types.pojo.Field arrowField : arrowSchema.getFields()) {
      fields.add(arrowFieldToBigQueryField(arrowField));
    }
    return Schema.of(fields);
  }

  static Field arrowFieldToBigQueryField(Object arrowFieldObj) {
    org.apache.arrow.vector.types.pojo.Field arrowField =
        (org.apache.arrow.vector.types.pojo.Field) arrowFieldObj;
    String name = arrowField.getName();
    ArrowType type = arrowField.getType();
    Field.Builder builder;

    if (type instanceof ArrowType.List) {
      if (arrowField.getChildren().isEmpty()) {
        throw new IllegalArgumentException(
            "Arrow List field must have at least one child field: " + name);
      }
      org.apache.arrow.vector.types.pojo.Field innerField = arrowField.getChildren().get(0);
      LegacySQLTypeName innerType = arrowTypeToLegacySQLTypeName(innerField.getType());
      builder = Field.newBuilder(name, innerType);
      builder.setMode(Field.Mode.REPEATED);
      if (!innerField.getChildren().isEmpty()) {
        List<Field> subFields = new ArrayList<>();
        for (org.apache.arrow.vector.types.pojo.Field childField : innerField.getChildren()) {
          subFields.add(arrowFieldToBigQueryField(childField));
        }
        builder.setType(LegacySQLTypeName.RECORD, FieldList.of(subFields));
      }
    } else {
      LegacySQLTypeName bqType = arrowTypeToLegacySQLTypeName(type);
      builder = Field.newBuilder(name, bqType);
      if (arrowField.isNullable()) {
        builder.setMode(Field.Mode.NULLABLE);
      } else {
        builder.setMode(Field.Mode.REQUIRED);
      }
      if (!arrowField.getChildren().isEmpty()) {
        List<Field> subFields = new ArrayList<>();
        for (org.apache.arrow.vector.types.pojo.Field childField : arrowField.getChildren()) {
          subFields.add(arrowFieldToBigQueryField(childField));
        }
        builder.setType(LegacySQLTypeName.RECORD, FieldList.of(subFields));
      }
    }
    return builder.build();
  }

  static List<FieldVector> createVectors(Object arrowSchemaObj, BufferAllocator allocator) {
    org.apache.arrow.vector.types.pojo.Schema arrowSchema =
        (org.apache.arrow.vector.types.pojo.Schema) arrowSchemaObj;
    List<FieldVector> vectors = new ArrayList<>();
    for (org.apache.arrow.vector.types.pojo.Field field : arrowSchema.getFields()) {
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

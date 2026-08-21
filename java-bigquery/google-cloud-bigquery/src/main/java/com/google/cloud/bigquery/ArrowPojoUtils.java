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

import com.google.cloud.bigquery.Field.Mode;
import java.util.ArrayList;
import java.util.List;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.Schema;

/**
 * Internal helper utility for converting Apache Arrow POJO Schema and Field definitions into
 * BigQuery Veneer {@link Schema} and {@link com.google.cloud.bigquery.Field} models.
 */
final class ArrowPojoUtils {

  private ArrowPojoUtils() {}

  /**
   * Converts an Apache Arrow {@link Schema} into a BigQuery Veneer {@link Schema}.
   *
   * @param arrowSchema the Apache Arrow schema definition
   * @return the corresponding BigQuery Veneer Schema
   */
  static com.google.cloud.bigquery.Schema arrowSchemaToBigQuerySchema(Schema arrowSchema) {
    List<com.google.cloud.bigquery.Field> fields = new ArrayList<>();
    for (Field arrowField : arrowSchema.getFields()) {
      fields.add(arrowFieldToBigQueryField(arrowField));
    }
    return com.google.cloud.bigquery.Schema.of(fields);
  }

  /**
   * Recursively converts an Apache Arrow {@link Field} into a BigQuery Veneer {@link
   * com.google.cloud.bigquery.Field}.
   *
   * <p>Handles primitive types, repeated/list types, and nested struct/record types.
   *
   * @param arrowField the Apache Arrow field definition
   * @return the corresponding BigQuery Veneer Field
   * @throws IllegalArgumentException if an Arrow List field contains no child elements
   */
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
      if (!innerField.getChildren().isEmpty()) {
        List<com.google.cloud.bigquery.Field> subFields = new ArrayList<>();
        for (Field childField : innerField.getChildren()) {
          subFields.add(arrowFieldToBigQueryField(childField));
        }
        builder =
            com.google.cloud.bigquery.Field.newBuilder(
                name, LegacySQLTypeName.RECORD, FieldList.of(subFields));
      } else {
        LegacySQLTypeName innerType = arrowTypeToLegacySQLTypeName(innerField.getType());
        builder = com.google.cloud.bigquery.Field.newBuilder(name, innerType);
      }
      builder.setMode(Mode.REPEATED);
    } else {
      if (!arrowField.getChildren().isEmpty()) {
        List<com.google.cloud.bigquery.Field> subFields = new ArrayList<>();
        for (Field childField : arrowField.getChildren()) {
          subFields.add(arrowFieldToBigQueryField(childField));
        }
        builder =
            com.google.cloud.bigquery.Field.newBuilder(
                name, LegacySQLTypeName.RECORD, FieldList.of(subFields));
      } else {
        LegacySQLTypeName bqType = arrowTypeToLegacySQLTypeName(type);
        builder = com.google.cloud.bigquery.Field.newBuilder(name, bqType);
      }
      if (arrowField.isNullable()) {
        builder.setMode(Mode.NULLABLE);
      } else {
        builder.setMode(Mode.REQUIRED);
      }
    }
    return builder.build();
  }

  /**
   * Instantiates a list of {@link FieldVector} instances corresponding to the fields in the
   * provided Arrow schema using the specified allocator.
   *
   * <p>Guarantees exception-safe LIFO cleanup of already-allocated vectors if an allocation fails
   * halfway through.
   *
   * @param arrowSchema the Apache Arrow schema definition
   * @param allocator the buffer allocator to allocate vector memory from
   * @return the list of allocated FieldVector instances
   */
  static List<FieldVector> createVectors(Schema arrowSchema, BufferAllocator allocator) {
    List<FieldVector> vectors = new ArrayList<>();
    try {
      for (Field field : arrowSchema.getFields()) {
        vectors.add(field.createVector(allocator));
      }
      return vectors;
    } catch (Throwable t) {
      for (int i = vectors.size() - 1; i >= 0; i--) {
        try {
          vectors.get(i).close();
        } catch (Exception e) {
          t.addSuppressed(e);
        }
      }
      throw t;
    }
  }

  /**
   * Maps an Apache {@link ArrowType} to its corresponding BigQuery {@link LegacySQLTypeName}.
   *
   * @param type the Apache Arrow type
   * @return the matching BigQuery LegacySQLTypeName
   * @throws IllegalArgumentException if the Arrow type is unsupported
   */
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

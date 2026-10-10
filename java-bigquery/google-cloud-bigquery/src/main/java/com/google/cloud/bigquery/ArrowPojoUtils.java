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
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.jspecify.annotations.NullMarked;

/**
 * Internal helper utility for converting Apache Arrow POJO definitions (such as {@link
 * org.apache.arrow.vector.types.pojo.Schema}, {@link org.apache.arrow.vector.types.pojo.Field}, and
 * {@link ArrowType}) into BigQuery Veneer objects.
 *
 * <p>This class handles standard Java objects and metadata conversions. For operations involving
 * Arrow vectors, off-heap memory, or deserializing byte streams, use {@link ArrowDeserializer}.
 */
@NullMarked
final class ArrowPojoUtils {

  private ArrowPojoUtils() {}

  /**
   * Converts an Apache Arrow {@link org.apache.arrow.vector.types.pojo.Schema} into a BigQuery
   * Veneer {@link Schema}.
   *
   * @param arrowSchema the Apache Arrow schema definition
   * @return the corresponding BigQuery Veneer Schema
   */
  static Schema arrowSchemaToBigQuerySchema(org.apache.arrow.vector.types.pojo.Schema arrowSchema) {
    List<Field> fields = new ArrayList<>();
    for (org.apache.arrow.vector.types.pojo.Field arrowField : arrowSchema.getFields()) {
      fields.add(arrowFieldToBigQueryField(arrowField));
    }
    return Schema.of(fields);
  }

  /**
   * Recursively converts an Apache Arrow {@link org.apache.arrow.vector.types.pojo.Field} into a
   * BigQuery Veneer {@link Field}.
   *
   * <p>Handles primitive types, repeated/list types, and nested struct/record types.
   *
   * @param arrowField the Apache Arrow field definition
   * @return the corresponding BigQuery Veneer Field
   * @throws IllegalArgumentException if an Arrow List field contains no child elements
   */
  static Field arrowFieldToBigQueryField(org.apache.arrow.vector.types.pojo.Field arrowField) {
    String name = arrowField.getName();
    ArrowType type = arrowField.getType();
    Field.Builder builder;

    if (type instanceof ArrowType.List) {
      if (arrowField.getChildren().isEmpty()) {
        throw new IllegalArgumentException(
            "Arrow List field must have at least one child field: " + name);
      }
      org.apache.arrow.vector.types.pojo.Field innerField = arrowField.getChildren().get(0);
      if (innerField.getType() instanceof ArrowType.List) {
        throw new IllegalArgumentException(
            "Nested arrays (List of List) are not supported by BigQuery: " + name);
      }
      if (innerField.getType() instanceof ArrowType.Struct) {
        builder = Field.newBuilder(name, LegacySQLTypeName.RECORD, getSubFields(innerField));
      } else {
        LegacySQLTypeName innerType = arrowTypeToLegacySQLTypeName(innerField.getType());
        builder = Field.newBuilder(name, innerType);
      }
      builder.setMode(Mode.REPEATED);
    } else {
      if (type instanceof ArrowType.Struct) {
        builder = Field.newBuilder(name, LegacySQLTypeName.RECORD, getSubFields(arrowField));
      } else {
        LegacySQLTypeName bqType = arrowTypeToLegacySQLTypeName(type);
        builder = Field.newBuilder(name, bqType);
      }
      if (arrowField.isNullable()) {
        builder.setMode(Mode.NULLABLE);
      } else {
        builder.setMode(Mode.REQUIRED);
      }
    }
    return builder.build();
  }

  private static FieldList getSubFields(org.apache.arrow.vector.types.pojo.Field structField) {
    if (structField.getChildren().isEmpty()) {
      throw new IllegalArgumentException(
          "Arrow Struct field must have at least one child field: " + structField.getName());
    }
    List<Field> subFields = new ArrayList<>();
    for (org.apache.arrow.vector.types.pojo.Field childField : structField.getChildren()) {
      subFields.add(arrowFieldToBigQueryField(childField));
    }
    return FieldList.of(subFields);
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
        if (((ArrowType.Decimal) type).getPrecision() > 38) {
          return LegacySQLTypeName.BIGNUMERIC;
        }
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

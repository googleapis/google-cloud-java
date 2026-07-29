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

import com.google.common.collect.ImmutableList;
import com.google.common.io.BaseEncoding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.VectorLoader;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.complex.ListVector;
import org.apache.arrow.vector.complex.StructVector;
import org.apache.arrow.vector.ipc.ReadChannel;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.util.ByteArrayReadableSeekableByteChannel;

final class ArrowDeserializer {

  private ArrowDeserializer() {}

  static Schema arrowSchemaToBigQuerySchema(org.apache.arrow.vector.types.pojo.Schema arrowSchema) {
    List<com.google.cloud.bigquery.Field> fields = new ArrayList<>();
    for (Field arrowField : arrowSchema.getFields()) {
      fields.add(arrowFieldToBigQueryField(arrowField));
    }
    return Schema.of(fields);
  }

  private static com.google.cloud.bigquery.Field arrowFieldToBigQueryField(Field arrowField) {
    String name = arrowField.getName();
    ArrowType type = arrowField.getType();
    com.google.cloud.bigquery.Field.Builder builder;

    if (type instanceof ArrowType.List) {
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

  static List<FieldValueList> deserializeRecordBatch(
      byte[] recordBatchBytes, Schema schema, org.apache.arrow.vector.types.pojo.Schema arrowSchema)
      throws IOException {
    try (BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE)) {
      List<FieldVector> vectors = new ArrayList<>();
      for (Field field : arrowSchema.getFields()) {
        vectors.add(field.createVector(allocator));
      }
      try (VectorSchemaRoot root = new VectorSchemaRoot(vectors)) {
        VectorLoader loader = new VectorLoader(root);
        try (org.apache.arrow.vector.ipc.message.ArrowRecordBatch deserializedBatch =
            MessageSerializer.deserializeRecordBatch(
                new ReadChannel(new ByteArrayReadableSeekableByteChannel(recordBatchBytes)),
                allocator)) {
          loader.load(deserializedBatch);
          int rowCount = root.getRowCount();
          List<FieldValueList> rows = new ArrayList<>(rowCount);
          for (int i = 0; i < rowCount; i++) {
            rows.add(arrowRootToFieldValueList(root, i, schema));
          }
          return ImmutableList.copyOf(rows);
        }
      }
    }
  }

  static FieldValueList arrowRootToFieldValueList(
      VectorSchemaRoot root, int rowIndex, Schema schema) {
    List<FieldValue> fieldValues = new ArrayList<>();
    for (int colIndex = 0; colIndex < root.getFieldVectors().size(); colIndex++) {
      FieldVector vector = root.getVector(colIndex);
      com.google.cloud.bigquery.Field bqField = schema.getFields().get(colIndex);
      fieldValues.add(arrowVectorToFieldValue(vector, rowIndex, bqField));
    }
    return FieldValueList.of(fieldValues, schema.getFields());
  }

  private static FieldValue arrowVectorToFieldValue(
      FieldVector vector, int rowIndex, com.google.cloud.bigquery.Field bqField) {
    if (vector.isNull(rowIndex)) {
      return FieldValue.of(FieldValue.Attribute.PRIMITIVE, null);
    }

    // Handle repeated fields
    if (bqField.getMode() == com.google.cloud.bigquery.Field.Mode.REPEATED) {
      ListVector listVector = (ListVector) vector;
      FieldVector dataVector = (FieldVector) listVector.getDataVector();
      int start = listVector.getElementStartIndex(rowIndex);
      int end = listVector.getElementEndIndex(rowIndex);
      List<FieldValue> elements = new ArrayList<>(end - start);
      com.google.cloud.bigquery.Field elementBqField =
          com.google.cloud.bigquery.Field.newBuilder(bqField.getName(), bqField.getType())
              .setMode(com.google.cloud.bigquery.Field.Mode.NULLABLE)
              .build();
      for (int k = start; k < end; k++) {
        elements.add(arrowVectorToFieldValue(dataVector, k, elementBqField));
      }
      return FieldValue.of(
          FieldValue.Attribute.REPEATED, FieldValueList.of(elements, bqField.getSubFields()));
    }

    // Handle RECORD/STRUCT fields
    if (bqField.getType() == LegacySQLTypeName.RECORD) {
      StructVector structVector = (StructVector) vector;
      List<FieldValue> elements = new ArrayList<>(structVector.size());
      for (int colIndex = 0; colIndex < structVector.size(); colIndex++) {
        FieldVector childVector = (FieldVector) structVector.getChildByOrdinal(colIndex);
        com.google.cloud.bigquery.Field childBqField = bqField.getSubFields().get(colIndex);
        elements.add(arrowVectorToFieldValue(childVector, rowIndex, childBqField));
      }
      return FieldValue.of(
          FieldValue.Attribute.RECORD, FieldValueList.of(elements, bqField.getSubFields()));
    }

    // Handle primitive types - convert everything to String representations to match BQ standard
    Object value = vector.getObject(rowIndex);
    String stringVal;
    if (value instanceof byte[]) {
      stringVal = BaseEncoding.base64().encode((byte[]) value);
    } else if (bqField.getType() == LegacySQLTypeName.TIMESTAMP) {
      // Arrow timestamps are long values representing epoch micro/milli/nano seconds.
      // Standard BigQuery JSON returns timestamps as string of epoch seconds with micro precision
      // (e.g. "1408452095.220000").
      long micros = (long) value;
      // Convert to seconds with 6 decimal places of precision
      stringVal = String.format(Locale.US, "%.6f", micros / 1000000.0);
    } else {
      stringVal = String.valueOf(value);
    }

    return FieldValue.of(FieldValue.Attribute.PRIMITIVE, stringVal);
  }
}

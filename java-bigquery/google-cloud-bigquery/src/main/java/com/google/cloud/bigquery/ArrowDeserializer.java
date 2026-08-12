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

import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.io.BaseEncoding;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.TimeStampVector;
import org.apache.arrow.vector.VectorLoader;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.complex.ListVector;
import org.apache.arrow.vector.complex.StructVector;
import org.apache.arrow.vector.ipc.ReadChannel;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.util.ByteArrayReadableSeekableByteChannel;

/**
 * Internal helper utility for converting Apache Arrow schemas and record batches into BigQuery
 * Veneer objects.
 */
final class ArrowDeserializer {

  private static class AllocatorHolder {
    private static final BufferAllocator ALLOCATOR = new RootAllocator(Long.MAX_VALUE);
  }

  private static VectorSchemaRoot createVectorSchemaRoot(
      org.apache.arrow.vector.types.pojo.Schema arrowSchema, BufferAllocator allocator) {
    List<FieldVector> vectors = ArrowPojoUtils.createVectors(arrowSchema, allocator);
    try {
      return new VectorSchemaRoot(vectors);
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

  private ArrowDeserializer() {}

  /**
   * Deserializes a raw binary Arrow schema payload into an Apache Arrow Schema object.
   *
   * @param schemaBytes the raw binary Arrow schema payload
   * @return the deserialized Apache Arrow Schema object
   * @throws IOException if deserialization of the Arrow schema fails
   */
  static Object deserializeSchema(byte[] schemaBytes) throws IOException {
    return MessageSerializer.deserializeSchema(
        new ReadChannel(new ByteArrayReadableSeekableByteChannel(schemaBytes)));
  }

  /**
   * Serializes an Apache Arrow Schema object to its JSON string representation.
   *
   * @param arrowSchema the Apache Arrow schema object
   * @return the JSON string representation, or null if arrowSchema is null
   */
  static String arrowSchemaToJson(Object arrowSchema) {
    if (arrowSchema == null) {
      return null;
    }
    return ((org.apache.arrow.vector.types.pojo.Schema) arrowSchema).toJson();
  }

  static Object jsonToArrowSchema(String json) {
    if (json == null) {
      return null;
    }
    try {
      return org.apache.arrow.vector.types.pojo.Schema.fromJSON(json);
    } catch (IOException e) {
      throw new IllegalArgumentException("Invalid Arrow schema JSON", e);
    }
  }

  /**
   * Reads and decodes a batch of Arrow rows from the provided stream iterator into the row batch.
   *
   * @param iterator the stream iterator providing ReadRowsResponse messages
   * @param arrowSchemaPojo the Arrow schema pojo (or null if restoring from json)
   * @param arrowSchemaJson the Arrow schema JSON representation
   * @param schema the BigQuery target Schema
   * @param rowBatch the destination list for decoded rows
   * @param pageSize the maximum number of rows to decode in this batch
   * @param totalRowsReturned the running count of rows returned so far
   * @param maxResults the maximum total rows allowed across all pages
   * @return true if more rows are available in the stream and maxResults has not been reached
   * @throws IOException if deserialization fails
   */
  static boolean loadArrowRows(
      Iterator<ReadRowsResponse> iterator,
      Object arrowSchemaPojo,
      String arrowSchemaJson,
      Schema schema,
      List<FieldValueList> rowBatch,
      long pageSize,
      long totalRowsReturned,
      long maxResults)
      throws IOException {
    org.apache.arrow.vector.types.pojo.Schema arrowSchema =
        arrowSchemaPojo instanceof org.apache.arrow.vector.types.pojo.Schema
            ? (org.apache.arrow.vector.types.pojo.Schema) arrowSchemaPojo
            : (arrowSchemaJson != null
                ? org.apache.arrow.vector.types.pojo.Schema.fromJSON(arrowSchemaJson)
                : null);

    if (arrowSchema == null) {
      return false;
    }

    try (BufferAllocator childAllocator =
            AllocatorHolder.ALLOCATOR.newChildAllocator("loadArrowRows", 0, Long.MAX_VALUE);
        VectorSchemaRoot closedRoot = createVectorSchemaRoot(arrowSchema, childAllocator)) {
      VectorLoader loader = new VectorLoader(closedRoot);
      boolean hasMore = false;
      while (rowBatch.size() < pageSize
          && iterator.hasNext()
          && (totalRowsReturned + rowBatch.size() < maxResults)) {
        ReadRowsResponse response = iterator.next();
        if (response.hasArrowRecordBatch()) {
          com.google.cloud.bigquery.storage.v1.ArrowRecordBatch batch =
              response.getArrowRecordBatch();
          try (ReadChannel readChannel =
                  new ReadChannel(
                      Channels.newChannel(batch.getSerializedRecordBatch().newInput()));
              ArrowRecordBatch deserializedBatch =
                  MessageSerializer.deserializeRecordBatch(readChannel, childAllocator)) {
            loader.load(deserializedBatch);
            int batchRowCount = closedRoot.getRowCount();
            int i = 0;
            for (; i < batchRowCount; i++) {
              if (rowBatch.size() >= pageSize
                  || totalRowsReturned + rowBatch.size() >= maxResults) {
                break;
              }
              rowBatch.add(arrowRootToFieldValueList(closedRoot, i, schema));
            }
            if (i < batchRowCount && (totalRowsReturned + rowBatch.size() < maxResults)) {
              hasMore = true;
            }
            closedRoot.clear();
          }
        }
      }
      if (!hasMore) {
        hasMore = iterator.hasNext() && (totalRowsReturned + rowBatch.size() < maxResults);
      }
      return hasMore;
    }
  }

  /**
   * Converts an Apache Arrow Schema to a BigQuery Veneer {@link Schema}.
   *
   * @param arrowSchema the Apache Arrow schema to convert
   * @return the corresponding BigQuery Veneer Schema
   */
  static Schema arrowSchemaToBigQuerySchema(Object arrowSchema) {
    return ArrowPojoUtils.arrowSchemaToBigQuerySchema(
        (org.apache.arrow.vector.types.pojo.Schema) arrowSchema);
  }

  /**
   * Deserializes a raw binary Arrow record batch payload into a list of BigQuery {@link
   * FieldValueList} row objects.
   *
   * <p>Allocates off-heap memory within a local {@link RootAllocator} scope and closes all Arrow
   * vector resources before returning, guaranteeing that native memory is released.
   *
   * @param recordBatchBytes the raw binary Arrow record batch payload
   * @param schema the target BigQuery Schema
   * @param arrowSchema the Arrow schema describing the record batch structure
   * @return an immutable list of FieldValueList row objects
   * @throws IOException if deserialization of the Arrow record batch fails
   */
  static List<FieldValueList> deserializeRecordBatch(
      byte[] recordBatchBytes, Schema schema, org.apache.arrow.vector.types.pojo.Schema arrowSchema)
      throws IOException {
    try (BufferAllocator childAllocator =
            AllocatorHolder.ALLOCATOR.newChildAllocator(
                "deserializeRecordBatch", 0, Long.MAX_VALUE);
        VectorSchemaRoot closedRoot = createVectorSchemaRoot(arrowSchema, childAllocator);
        ByteArrayReadableSeekableByteChannel byteChannel =
            new ByteArrayReadableSeekableByteChannel(recordBatchBytes);
        ReadChannel readChannel = new ReadChannel(byteChannel);
        ArrowRecordBatch deserializedBatch =
            MessageSerializer.deserializeRecordBatch(readChannel, childAllocator)) {
      VectorLoader loader = new VectorLoader(closedRoot);
      loader.load(deserializedBatch);
      int rowCount = closedRoot.getRowCount();
      List<FieldValueList> rows = new ArrayList<>(rowCount);
      for (int i = 0; i < rowCount; i++) {
        rows.add(arrowRootToFieldValueList(closedRoot, i, schema));
      }
      return ImmutableList.copyOf(rows);
    }
  }

  /**
   * Extracts a single row at the specified index from a {@link VectorSchemaRoot} into a {@link
   * FieldValueList}.
   *
   * @param root the VectorSchemaRoot containing column vectors
   * @param rowIndex the 0-based row index to extract
   * @param schema the BigQuery schema corresponding to the vectors
   * @return the extracted FieldValueList row object
   * @throws IllegalArgumentException if vector count does not match schema field count
   */
  static FieldValueList arrowRootToFieldValueList(
      VectorSchemaRoot root, int rowIndex, Schema schema) {
    if (root.getFieldVectors().size() != schema.getFields().size()) {
      throw new IllegalArgumentException(
          String.format(
              "Schema mismatch: Arrow vector count (%d) does not match BigQuery schema field count (%d)",
              root.getFieldVectors().size(), schema.getFields().size()));
    }
    List<FieldValue> fieldValues = new ArrayList<>();
    for (int colIndex = 0; colIndex < root.getFieldVectors().size(); colIndex++) {
      FieldVector vector = root.getVector(colIndex);
      Field bqField = schema.getFields().get(colIndex);
      fieldValues.add(arrowVectorToFieldValue(vector, rowIndex, bqField));
    }
    return FieldValueList.of(fieldValues, schema.getFields());
  }

  /**
   * Converts a single cell value within a {@link FieldVector} to a BigQuery {@link FieldValue}.
   *
   * <p>Handles null values, repeated list vectors, nested struct vectors, and primitive type
   * conversions.
   *
   * @param vector the Arrow column vector
   * @param rowIndex the 0-based row index
   * @param bqField the corresponding BigQuery Field definition
   * @return the converted FieldValue object
   */
  private static FieldValue arrowVectorToFieldValue(
      FieldVector vector, int rowIndex, Field bqField) {
    if (vector.isNull(rowIndex)) {
      return FieldValue.of(FieldValue.Attribute.PRIMITIVE, null);
    }

    // Handle repeated fields
    if (bqField.getMode() == Field.Mode.REPEATED) {
      ListVector listVector = (ListVector) vector;
      FieldVector dataVector = (FieldVector) listVector.getDataVector();
      int start = listVector.getElementStartIndex(rowIndex);
      int end = listVector.getElementEndIndex(rowIndex);
      List<FieldValue> elements = new ArrayList<>(end - start);
      Field.Builder elementBuilder = Field.newBuilder(bqField.getName(), bqField.getType());
      if (bqField.getType() == LegacySQLTypeName.RECORD && bqField.getSubFields() != null) {
        elementBuilder.setType(LegacySQLTypeName.RECORD, bqField.getSubFields());
      }
      Field elementBqField = elementBuilder.setMode(Field.Mode.NULLABLE).build();
      for (int k = start; k < end; k++) {
        elements.add(arrowVectorToFieldValue(dataVector, k, elementBqField));
      }
      return FieldValue.of(
          FieldValue.Attribute.REPEATED, FieldValueList.of(elements, bqField.getSubFields()));
    }

    // Handle RECORD/STRUCT fields
    if (bqField.getType() == LegacySQLTypeName.RECORD) {
      StructVector structVector = (StructVector) vector;
      if (structVector.size() != bqField.getSubFields().size()) {
        throw new IllegalArgumentException(
            String.format(
                "Schema mismatch for field '%s': Arrow struct size (%d) does not match BigQuery subfields size (%d)",
                bqField.getName(), structVector.size(), bqField.getSubFields().size()));
      }
      List<FieldValue> elements = new ArrayList<>(structVector.size());
      for (int colIndex = 0; colIndex < structVector.size(); colIndex++) {
        FieldVector childVector = (FieldVector) structVector.getChildByOrdinal(colIndex);
        Field childBqField = bqField.getSubFields().get(colIndex);
        elements.add(arrowVectorToFieldValue(childVector, rowIndex, childBqField));
      }
      return FieldValue.of(
          FieldValue.Attribute.RECORD, FieldValueList.of(elements, bqField.getSubFields()));
    }

    // Handle primitive types
    String stringVal;
    if (bqField.getType() == LegacySQLTypeName.TIMESTAMP) {
      TimeStampVector tsVector = (TimeStampVector) vector;
      long rawVal = tsVector.get(rowIndex);
      ArrowType.Timestamp tsType = (ArrowType.Timestamp) vector.getField().getType();
      long micros;
      switch (tsType.getUnit()) {
        case SECOND:
          micros = rawVal * 1_000_000L;
          break;
        case MILLISECOND:
          micros = rawVal * 1_000L;
          break;
        case MICROSECOND:
          micros = rawVal;
          break;
        case NANOSECOND:
          micros = rawVal / 1_000L;
          break;
        default:
          micros = rawVal;
      }
      long seconds = micros / 1_000_000L;
      long remainingMicros = Math.abs(micros % 1_000_000L);
      if (micros < 0 && seconds == 0) {
        stringVal = String.format(Locale.US, "-0.%06d", remainingMicros);
      } else {
        stringVal = String.format(Locale.US, "%d.%06d", seconds, remainingMicros);
      }
    } else {
      Object value = vector.getObject(rowIndex);
      if (value instanceof byte[]) {
        stringVal = BaseEncoding.base64().encode((byte[]) value);
      } else {
        stringVal = String.valueOf(value);
      }
    }

    return FieldValue.of(FieldValue.Attribute.PRIMITIVE, stringVal);
  }
}

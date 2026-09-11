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
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.io.BaseEncoding;
import java.io.IOException;
import java.nio.channels.Channels;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.DateDayVector;
import org.apache.arrow.vector.DateMilliVector;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.TimeMicroVector;
import org.apache.arrow.vector.TimeMilliVector;
import org.apache.arrow.vector.TimeNanoVector;
import org.apache.arrow.vector.TimeSecVector;
import org.apache.arrow.vector.TimeStampVector;
import org.apache.arrow.vector.VectorLoader;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.complex.FixedSizeListVector;
import org.apache.arrow.vector.complex.LargeListVector;
import org.apache.arrow.vector.complex.ListVector;
import org.apache.arrow.vector.complex.StructVector;
import org.apache.arrow.vector.ipc.ReadChannel;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.util.ByteArrayReadableSeekableByteChannel;
import org.jspecify.annotations.NullMarked;

/**
 * Internal helper utility for managing Arrow vector memory and deserializing IPC record batches
 * into BigQuery Veneer objects.
 *
 * <p>This class handles Arrow vectors, {@link BufferAllocator} memory lifecycles, and byte stream
 * deserialization. For pure POJO schema and metadata conversions, use {@link ArrowPojoUtils}.
 */
@NullMarked
final class ArrowDeserializer {

  /** Lazy initialization holder for the root {@link BufferAllocator}. */
  private static class AllocatorHolder {
    private static final BufferAllocator ALLOCATOR = new RootAllocator(Long.MAX_VALUE);
  }

  /**
   * Creates a new child buffer allocator with the given name.
   *
   * @param name the child allocator name
   * @return a new child buffer allocator
   */
  static BufferAllocator createChildAllocator(String name) {
    return AllocatorHolder.ALLOCATOR.newChildAllocator(name, 0, Long.MAX_VALUE);
  }

  private ArrowDeserializer() {}

  /**
   * Deserializes a raw binary Arrow schema payload into an Apache Arrow Schema object.
   *
   * @param schemaBytes the raw binary Arrow schema payload
   * @return the deserialized Apache Arrow Schema object
   * @throws IOException if deserialization of the Arrow schema fails
   */
  static org.apache.arrow.vector.types.pojo.Schema deserializeSchema(byte[] schemaBytes)
      throws IOException {
    try (ByteArrayReadableSeekableByteChannel byteChannel =
            new ByteArrayReadableSeekableByteChannel(schemaBytes);
        ReadChannel readChannel = new ReadChannel(byteChannel)) {
      return MessageSerializer.deserializeSchema(readChannel);
    }
  }

  /**
   * Reads and decodes a batch of Arrow rows from the provided stream iterator into the row batch,
   * buffering any unconsumed rows that exceed the requested page size to prevent data loss across
   * page boundaries.
   *
   * @param iterator the stream iterator providing ReadRowsResponse messages
   * @param arrowSchema the Arrow schema POJO
   * @param schema the BigQuery target Schema
   * @param rowBatch the destination list for decoded rows
   * @param buffer queue holding unconsumed rows from preceding batches that crossed page boundaries
   * @param pageSize the maximum number of rows to decode in this batch
   * @param totalRowsReturned the running count of rows returned so far
   * @param maxResults the maximum total rows allowed across all pages
   * @return true if more rows are available in the stream and maxResults has not been reached
   * @throws IOException if deserialization fails
   */
  static boolean loadArrowRows(
      Iterator<ReadRowsResponse> iterator,
      org.apache.arrow.vector.types.pojo.Schema arrowSchema,
      Schema schema,
      List<FieldValueList> rowBatch,
      Queue<FieldValueList> buffer,
      long pageSize,
      long totalRowsReturned,
      long maxResults)
      throws IOException {
    if (arrowSchema == null) {
      throw new IllegalArgumentException("Arrow schema must not be null.");
    }

    // Step 1: Drain any leftover rows from previous batches before pulling new responses from the
    // stream.
    while (!buffer.isEmpty()
        && rowBatch.size() < pageSize
        && (totalRowsReturned + rowBatch.size() < maxResults)) {
      rowBatch.add(buffer.poll());
    }

    // If the page was completely filled from buffered rows or maxResults was reached, check if more
    // rows exist without pulling a new response from the stream.
    if (rowBatch.size() >= pageSize || (totalRowsReturned + rowBatch.size() >= maxResults)) {
      return !buffer.isEmpty()
          || (iterator.hasNext()
              && (totalRowsReturned + rowBatch.size() + buffer.size() < maxResults));
    }

    if (!iterator.hasNext()) {
      return false;
    }

    try (BufferAllocator childAllocator = createChildAllocator("loadArrowRows");
        VectorSchemaRoot root = VectorSchemaRoot.create(arrowSchema, childAllocator)) {
      VectorLoader loader = new VectorLoader(root);
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
            if (deserializedBatch == null) {
              throw new IOException(
                  "Failed to deserialize Arrow record batch: end of stream or empty batch.");
            }
            loader.load(deserializedBatch);
            int batchRowCount = root.getRowCount();
            // Step 2: Populate rowBatch up to pageSize. If the batch contains more rows than the
            // remaining page capacity, buffer the unconsumed rows for subsequent pages to prevent
            // data loss when the stream response crosses a page boundary.
            int i = 0;
            for (; i < batchRowCount; i++) {
              if (rowBatch.size() < pageSize
                  && (totalRowsReturned + rowBatch.size() < maxResults)) {
                rowBatch.add(arrowRootToFieldValueList(root, i, schema));
              } else if (totalRowsReturned + rowBatch.size() + buffer.size() < maxResults) {
                buffer.add(arrowRootToFieldValueList(root, i, schema));
              } else {
                break;
              }
            }
            if (i < batchRowCount && (totalRowsReturned + rowBatch.size() < maxResults)) {
              hasMore = true;
            }
            root.clear();
          }
        }
      }
      // Step 3: Determine if more rows are available either in the buffer, remaining unconsumed in
      // a batch, or remaining in the stream iterator.
      return hasMore
          || !buffer.isEmpty()
          || (iterator.hasNext()
              && (totalRowsReturned + rowBatch.size() + buffer.size() < maxResults));
    }
  }

  /**
   * Deserializes a raw binary Arrow record batch payload into a list of BigQuery {@link
   * FieldValueList} row objects.
   *
   * <p>Allocates off-heap memory within a local child allocator scope and closes all Arrow vector
   * resources before returning, guaranteeing that native memory is released.
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
    if (arrowSchema == null) {
      throw new IllegalArgumentException("Arrow schema must not be null.");
    }
    try (BufferAllocator childAllocator = createChildAllocator("deserializeRecordBatch");
        VectorSchemaRoot root = VectorSchemaRoot.create(arrowSchema, childAllocator);
        ByteArrayReadableSeekableByteChannel byteChannel =
            new ByteArrayReadableSeekableByteChannel(recordBatchBytes);
        ReadChannel readChannel = new ReadChannel(byteChannel);
        ArrowRecordBatch deserializedBatch =
            MessageSerializer.deserializeRecordBatch(readChannel, childAllocator)) {
      if (deserializedBatch == null) {
        throw new IOException(
            "Failed to deserialize Arrow record batch: end of stream or empty batch.");
      }
      VectorLoader loader = new VectorLoader(root);
      loader.load(deserializedBatch);
      int rowCount = root.getRowCount();
      List<FieldValueList> rows = new ArrayList<>(rowCount);
      for (int i = 0; i < rowCount; i++) {
        rows.add(arrowRootToFieldValueList(root, i, schema));
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
    if (bqField.getMode() == Field.Mode.REPEATED) {
      if (vector.isNull(rowIndex)) {
        return FieldValue.of(
            FieldValue.Attribute.REPEATED,
            FieldValueList.of(ImmutableList.of(), bqField.getSubFields()));
      }
    } else if (vector.isNull(rowIndex)) {
      if (bqField.getType() == LegacySQLTypeName.RECORD) {
        return FieldValue.of(FieldValue.Attribute.RECORD, null);
      }
      return FieldValue.of(FieldValue.Attribute.PRIMITIVE, null);
    }

    // Handle repeated fields
    if (bqField.getMode() == Field.Mode.REPEATED) {
      FieldVector dataVector;
      int start;
      int end;
      if (vector instanceof ListVector) {
        ListVector listVector = (ListVector) vector;
        dataVector = (FieldVector) listVector.getDataVector();
        start = listVector.getElementStartIndex(rowIndex);
        end = listVector.getElementEndIndex(rowIndex);
      } else if (vector instanceof LargeListVector) {
        LargeListVector largeListVector = (LargeListVector) vector;
        dataVector = (FieldVector) largeListVector.getDataVector();
        start = (int) largeListVector.getElementStartIndex(rowIndex);
        end = (int) largeListVector.getElementEndIndex(rowIndex);
      } else if (vector instanceof FixedSizeListVector) {
        FixedSizeListVector fixedListVector = (FixedSizeListVector) vector;
        dataVector = (FieldVector) fixedListVector.getDataVector();
        start = fixedListVector.getElementStartIndex(rowIndex);
        end = fixedListVector.getElementEndIndex(rowIndex);
      } else {
        throw new IllegalArgumentException(
            "Unsupported repeated vector type: " + vector.getClass().getName());
      }
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
      stringVal = formatTimestampMicros(micros);
    } else if (bqField.getType() == LegacySQLTypeName.DATE) {
      if (vector instanceof DateDayVector) {
        int days = ((DateDayVector) vector).get(rowIndex);
        stringVal = LocalDate.ofEpochDay(days).toString();
      } else if (vector instanceof DateMilliVector) {
        long millis = ((DateMilliVector) vector).get(rowIndex);
        stringVal = LocalDate.ofEpochDay(Math.floorDiv(millis, 86400000L)).toString();
      } else {
        stringVal = String.valueOf(vector.getObject(rowIndex));
      }
    } else if (bqField.getType() == LegacySQLTypeName.TIME) {
      if (vector instanceof TimeSecVector
          || vector instanceof TimeMilliVector
          || vector instanceof TimeMicroVector
          || vector instanceof TimeNanoVector) {
        long nanosOfDay;
        if (vector instanceof TimeSecVector) {
          nanosOfDay = ((TimeSecVector) vector).get(rowIndex) * 1_000_000_000L;
        } else if (vector instanceof TimeMilliVector) {
          nanosOfDay = ((TimeMilliVector) vector).get(rowIndex) * 1_000_000L;
        } else if (vector instanceof TimeMicroVector) {
          nanosOfDay = ((TimeMicroVector) vector).get(rowIndex) * 1_000L;
        } else {
          nanosOfDay = ((TimeNanoVector) vector).get(rowIndex);
        }
        stringVal =
            DateTimeFormatter.ISO_LOCAL_TIME.format(
                LocalTime.ofNanoOfDay((nanosOfDay / 1_000L) * 1_000L));
      } else {
        stringVal = String.valueOf(vector.getObject(rowIndex));
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

  /**
   * Formats an epoch timestamp in microseconds into BigQuery's decimal timestamp format: {@code
   * "<seconds>.<microseconds>"} with exactly 6 fractional digits (for example, {@code
   * "1408452095.220000"} or {@code "-0.000123"}).
   *
   * <p>This matches the decimal timestamp format returned by the BigQuery REST API and expected by
   * {@link FieldValue#getTimestampValue()}, which parses the string into a {@link
   * java.math.BigDecimal}. Uses {@link Strings#padStart} to avoid the performance overhead of
   * {@link String#format} during row deserialization.
   *
   * @param micros the timestamp value in microseconds since Unix epoch
   * @return the formatted timestamp string
   */
  @VisibleForTesting
  static String formatTimestampMicros(long micros) {
    long seconds = micros / 1_000_000L;
    long remainingMicros = Math.abs(micros % 1_000_000L);
    String fraction = Strings.padStart(Long.toString(remainingMicros), 6, '0');
    if (micros < 0 && seconds == 0) {
      return "-0." + fraction;
    }
    return seconds + "." + fraction;
  }
}

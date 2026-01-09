/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.cloud.bigquery.jdbc.BigQueryBaseArray.isArray;
import static com.google.cloud.bigquery.jdbc.BigQueryBaseStruct.isStruct;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.storage.v1.ArrowRecordBatch;
import com.google.cloud.bigquery.storage.v1.ArrowSchema;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.VectorLoader;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.ipc.ReadChannel;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.apache.arrow.vector.util.ByteArrayReadableSeekableByteChannel;
import org.apache.arrow.vector.util.JsonStringArrayList;
import org.apache.arrow.vector.util.JsonStringHashMap;

/** {@link ResultSet} Implementation for Arrow datasource (Using Storage Read APIs) */
class BigQueryArrowResultSet extends BigQueryBaseResultSet {
  private final long totalRows;
  // count of rows read by the current instance of ResultSet
  private long rowCount = 0;
  // IMP: This is a buffer of Arrow batches, the max size should be kept at min as
  // possible to avoid holding too much memory
  private final BlockingQueue<BigQueryArrowBatchWrapper> buffer;

  // TODO(neenu): See if it makes sense to have the nested batch represented by
  // 'JsonStringArrayList' directly
  // points to the nested batch of arrow record
  private final BigQueryArrowBatchWrapper currentNestedBatch;
  private final int fromIndex;
  private final int toIndexExclusive;

  // Acts as a cursor, resets to -1 when the `currentBatch` is processed. points to a
  // logical row in the columnar BigQueryBigQueryArrowBatchWrapper currentBatch
  private int currentBatchRowIndex = -1;
  private boolean hasReachedEnd = false;

  // Tracks the index of the nested element under process
  private int nestedRowIndex;

  private boolean afterLast = false;

  private ArrowDeserializer arrowDeserializer;
  BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE);
  // Decoder object will be reused to avoid re-allocation and too much garbage collection.
  private VectorSchemaRoot vectorSchemaRoot;
  private VectorLoader vectorLoader;
  // producer thread's reference
  private final Thread ownedThread;

  private BigQueryArrowResultSet(
      Schema schema,
      ArrowSchema arrowSchema,
      long totalRows,
      BigQueryStatement statement,
      BlockingQueue<BigQueryArrowBatchWrapper> buffer,
      BigQueryArrowBatchWrapper currentNestedBatch,
      boolean isNested,
      int fromIndex,
      int toIndexExclusive,
      Thread ownedThread,
      BigQuery bigQuery)
      throws SQLException {
    super(bigQuery, statement, schema, isNested);
    LOG.finest("++enter++");
    this.totalRows = totalRows;
    this.buffer = buffer;
    this.currentNestedBatch = currentNestedBatch;
    this.fromIndex = fromIndex;
    this.toIndexExclusive = toIndexExclusive;
    this.nestedRowIndex = fromIndex - 1;
    this.ownedThread = ownedThread;
    if (!isNested && arrowSchema != null) {
      try {
        this.arrowDeserializer = new ArrowDeserializer(arrowSchema);
      } catch (IOException ex) {
        throw new BigQueryJdbcException(ex);
      }
    }
  }

  /**
   * This method returns an instance of BigQueryArrowResultSet after adding it in the list of
   * ArrowResultSetFinalizer
   *
   * @return BigQueryArrowResultSet
   */
  static BigQueryArrowResultSet of(
      Schema schema,
      ArrowSchema arrowSchema,
      long totalRows,
      BigQueryStatement statement,
      BlockingQueue<BigQueryArrowBatchWrapper> buffer,
      Thread ownedThread,
      BigQuery bigQuery)
      throws SQLException {
    return new BigQueryArrowResultSet(
        schema,
        arrowSchema,
        totalRows,
        statement,
        buffer,
        null,
        false,
        -1,
        -1,
        ownedThread,
        bigQuery);
  }

  BigQueryArrowResultSet() throws SQLException {
    super(null, null, null, false);
    this.totalRows = 0;
    this.buffer = null;
    this.currentNestedBatch = null;
    this.fromIndex = 0;
    this.toIndexExclusive = 0;
    this.ownedThread = null;
    this.arrowDeserializer = null;
    this.vectorSchemaRoot = null;
    this.vectorLoader = null;
  }

  static BigQueryArrowResultSet getNestedResultSet(
      Schema schema, BigQueryArrowBatchWrapper nestedBatch, int fromIndex, int toIndexExclusive)
      throws SQLException {
    return new BigQueryArrowResultSet(
        schema, null, -1, null, null, nestedBatch, true, fromIndex, toIndexExclusive, null, null);
  }

  private class ArrowDeserializer implements AutoCloseable {

    /* Decoder object will be reused to avoid re-allocation and too much garbage collection. */
    private ArrowDeserializer(ArrowSchema arrowSchema) throws IOException {
      org.apache.arrow.vector.types.pojo.Schema schema =
          MessageSerializer.deserializeSchema(
              new org.apache.arrow.vector.ipc.ReadChannel(
                  new ByteArrayReadableSeekableByteChannel(
                      arrowSchema.getSerializedSchema().toByteArray())));
      List<FieldVector> vectors = new ArrayList<>();
      List<org.apache.arrow.vector.types.pojo.Field> fields = schema.getFields();
      for (org.apache.arrow.vector.types.pojo.Field field : fields) {
        vectors.add(field.createVector(allocator));
      }
      vectorSchemaRoot = new VectorSchemaRoot(vectors);
      vectorLoader = new VectorLoader(vectorSchemaRoot);
    }

    private void deserializeArrowBatch(ArrowRecordBatch batch) throws SQLException {
      LOG.finest("++enter++");
      try {
        if (vectorSchemaRoot != null) {
          // Clear vectorSchemaRoot before populating a new batch
          vectorSchemaRoot.clear();
        }
        org.apache.arrow.vector.ipc.message.ArrowRecordBatch deserializedBatch =
            MessageSerializer.deserializeRecordBatch(
                new ReadChannel(
                    new ByteArrayReadableSeekableByteChannel(
                        batch.getSerializedRecordBatch().toByteArray())),
                allocator);

        vectorLoader.load(deserializedBatch);
        // Release buffers from batch (they are still held in the vectors in root).
        deserializedBatch.close();
      } catch (RuntimeException | IOException ex) {
        throw new BigQueryJdbcException(ex);
      }
    }

    @Override
    public void close() {
      LOG.finest("++enter++");
      vectorSchemaRoot.close();
      allocator.close();
    }
  }

  @Override
  public boolean next() throws SQLException {
    checkClosed();
    if (this.isNested) {
      if (this.currentNestedBatch == null || this.currentNestedBatch.getNestedRecords() == null) {
        throw new IllegalStateException(
            "currentNestedBatch/JsonStringArrayList can not be null working with the nested record");
      }
      if (this.nestedRowIndex < (this.toIndexExclusive - 1)) {
        /* Check if there's a next record in the array which can be read */
        this.nestedRowIndex++;
        return true;
      }
      this.afterLast = true;
      return false;
    } else {
      /* Non nested */
      if (this.hasReachedEnd || this.isLast()) {
        this.afterLast = true;
        return false;
      }
      try {
        if (this.currentBatchRowIndex == -1
            || this.currentBatchRowIndex == (this.vectorSchemaRoot.getRowCount() - 1)) {
          /* Start of iteration or we have exhausted the current batch */
          // Advance the cursor. Potentially blocking operation.
          BigQueryArrowBatchWrapper batchWrapper = this.buffer.take();
          if (batchWrapper.isLast()) {
            /* Marks the end of the records */
            if (this.vectorSchemaRoot != null) {
              // IMP: To avoid memory leak: clear vectorSchemaRoot as it still holds
              // the last batch
              this.vectorSchemaRoot.clear();
            }
            this.hasReachedEnd = true;
            this.rowCount++;
            return false;
          }
          // Valid batch, process it
          ArrowRecordBatch arrowBatch = batchWrapper.getCurrentArrowBatch();
          // Populates vectorSchemaRoot
          this.arrowDeserializer.deserializeArrowBatch(arrowBatch);
          // Pointing to the first row in this fresh batch
          this.currentBatchRowIndex = 0;
          this.rowCount++;
          return true;
        }
        // There are rows left in the current batch.
        else if (this.currentBatchRowIndex < this.vectorSchemaRoot.getRowCount()) {
          this.currentBatchRowIndex++;
          this.rowCount++;
          return true;
        }
      } catch (InterruptedException | SQLException ex) {
        throw new BigQueryJdbcException(
            "Error occurred while advancing the cursor. This could happen when connection is closed while the next method is being called.",
            ex);
      }
    }
    return false;
  }

  private Object getObjectInternal(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    checkClosed();
    Object value;
    if (this.isNested) {
      // BigQuery doesn't support multidimensional arrays, so
      // just the default row num column (1) and the actual column (2) is supposed to be read
      if (!(columnIndex == 1 || columnIndex == 2)) {

        throw new IllegalArgumentException(
            "Column index is required to be 1 or 2 for nested arrays");
      }
      if (this.currentNestedBatch.getNestedRecords() == null) {
        throw new IllegalStateException("JsonStringArrayList cannot be null for nested records.");
      }
      // For Arrays the first column is Index, ref:
      // https://docs.oracle.com/javase/7/docs/api/java/sql/Array.html#getResultSet()
      if (columnIndex == 1) {
        return this.nestedRowIndex + 1;
      }
      // columnIndex = 2, return the data against the current nestedRowIndex
      else {
        value = this.currentNestedBatch.getNestedRecords().get(this.nestedRowIndex);
      }
    } else {
      // get the current column
      // SQL index to Java Index
      FieldVector currentColumn = this.vectorSchemaRoot.getVector(columnIndex - 1);
      // get the current row
      value = currentColumn.getObject(this.currentBatchRowIndex);
    }
    setWasNull(value);
    return value;
  }

  @Override
  public Object getObject(int columnIndex) throws SQLException {

    // columnIndex is SQL index starting at 1
    LOG.finest("++enter++");
    checkClosed();
    Object value = getObjectInternal(columnIndex);
    if (value == null) {
      return null;
    }

    if (this.isNested && columnIndex == 1) {
      return this.bigQueryTypeCoercer.coerceTo(Integer.class, value);
    }

    if (this.isNested && columnIndex == 2) {
      Field arrayField = this.schema.getFields().get(0);
      if (isStruct(arrayField)) {
        return new BigQueryArrowStruct(arrayField.getSubFields(), (JsonStringHashMap<?, ?>) value);
      }
      Class<?> targetClass =
          BigQueryJdbcTypeMappings.standardSQLToJavaTypeMapping.get(
              arrayField.getType().getStandardType());
      return this.bigQueryTypeCoercer.coerceTo(targetClass, value);
    }

    int fieldIndex = this.isNested ? 0 : columnIndex - 1;
    Field fieldSchema = this.schemaFieldList.get(fieldIndex);
    if (isArray(fieldSchema)) {
      JsonStringArrayList<?> originalList = (JsonStringArrayList<?>) value;
      StandardSQLTypeName elementTypeName = fieldSchema.getType().getStandardType();
      if (elementTypeName == StandardSQLTypeName.NUMERIC
          || elementTypeName == StandardSQLTypeName.BIGNUMERIC) {
        JsonStringArrayList<BigDecimal> newList = new JsonStringArrayList<>();
        for (Object item : originalList) {
          if (item != null) {
            newList.add(((BigDecimal) item).stripTrailingZeros());
          } else {
            newList.add(null);
          }
        }
        return new BigQueryArrowArray(fieldSchema, newList);
      } else if (elementTypeName == StandardSQLTypeName.RANGE) {
        JsonStringArrayList<String> newList = new JsonStringArrayList<>();
        for (Object item : originalList) {
          if (item != null) {
            JsonStringHashMap<?, ?> rangeMap = (JsonStringHashMap<?, ?>) item;
            Object start = rangeMap.get("start");
            Object end = rangeMap.get("end");

            Object representativeElement = (start != null) ? start : end;
            StandardSQLTypeName rangeElementType = getElementTypeFromValue(representativeElement);

            String formattedStart = formatRangeElement(start, rangeElementType);
            String formattedEnd = formatRangeElement(end, rangeElementType);

            newList.add(String.format("[%s, %s)", formattedStart, formattedEnd));
          } else {
            newList.add(null);
          }
        }
        return new BigQueryArrowArray(fieldSchema, newList);
      }
      return new BigQueryArrowArray(fieldSchema, originalList);
    } else if (isStruct(fieldSchema)) {
      return new BigQueryArrowStruct(fieldSchema.getSubFields(), (JsonStringHashMap<?, ?>) value);
    } else if (fieldSchema.getType().getStandardType() == StandardSQLTypeName.RANGE) {
      JsonStringHashMap<?, ?> rangeMap = (JsonStringHashMap<?, ?>) value;
      Object start = rangeMap.get("start");
      Object end = rangeMap.get("end");

      Object representativeElement = (start != null) ? start : end;
      StandardSQLTypeName elementType = getElementTypeFromValue(representativeElement);

      String formattedStart = formatRangeElement(start, elementType);
      String formattedEnd = formatRangeElement(end, elementType);

      return String.format("[%s, %s)", formattedStart, formattedEnd);
    } else {
      if ((fieldSchema.getType().getStandardType() == StandardSQLTypeName.NUMERIC
              || fieldSchema.getType().getStandardType() == StandardSQLTypeName.BIGNUMERIC)
          && value instanceof BigDecimal) {
        // The Arrow DecimalVector may return a BigDecimal with a larger scale than necessary.
        // Strip trailing zeros to match JSON API and CLI output
        return ((BigDecimal) value).stripTrailingZeros();
      }
      Class<?> targetClass =
          BigQueryJdbcTypeMappings.standardSQLToJavaTypeMapping.get(
              fieldSchema.getType().getStandardType());
      return this.bigQueryTypeCoercer.coerceTo(targetClass, value);
    }
  }

  private StandardSQLTypeName getElementTypeFromValue(Object element) {
    if (element == null) {
      return StandardSQLTypeName.STRING;
    }
    if (element instanceof Integer) {
      return StandardSQLTypeName.DATE;
    }
    if (element instanceof Long) {
      return StandardSQLTypeName.TIMESTAMP;
    }
    if (element instanceof LocalDateTime) {
      return StandardSQLTypeName.DATETIME;
    }
    return StandardSQLTypeName.STRING;
  }

  private String formatRangeElement(Object element, StandardSQLTypeName elementType) {
    if (element == null) {
      return "UNBOUNDED";
    }
    switch (elementType) {
      case DATE:
        // Arrow gives DATE as an Integer (days since epoch)
        Date date = this.bigQueryTypeCoercer.coerceTo(Date.class, (Integer) element);
        return date.toString();
      case DATETIME:
        // Arrow gives DATETIME as a LocalDateTime
        Timestamp dtTs =
            this.bigQueryTypeCoercer.coerceTo(Timestamp.class, (LocalDateTime) element);
        return this.bigQueryTypeCoercer.coerceTo(String.class, dtTs);
      case TIMESTAMP:
        // Arrow gives TIMESTAMP as a Long (microseconds since epoch)
        Timestamp ts = this.bigQueryTypeCoercer.coerceTo(Timestamp.class, (Long) element);
        return this.bigQueryTypeCoercer.coerceTo(String.class, ts);
      default:
        // Fallback for any other unexpected type
        return element.toString();
    }
  }

  @Override
  public void close() {
    LOG.fine(String.format("Closing BigqueryArrowResultSet %s.", this));
    this.isClosed = true;
    if (ownedThread != null && !ownedThread.isInterrupted()) {
      // interrupt the producer thread when result set is closed
      ownedThread.interrupt();
    }
    super.close();
  }

  @Override
  public boolean isBeforeFirst() throws SQLException {
    LOG.finest("++enter++");
    checkClosed();
    if (this.isNested) {
      return this.nestedRowIndex < this.fromIndex;
    } else {
      return this.rowCount == 0;
    }
  }

  @Override
  public boolean isAfterLast() throws SQLException {
    LOG.finest("++enter++");
    checkClosed();
    return this.afterLast;
  }

  @Override
  public boolean isFirst() throws SQLException {
    LOG.finest("++enter++");
    checkClosed();
    if (this.isNested) {
      return this.nestedRowIndex == this.fromIndex;
    } else {
      return this.rowCount == 1;
    }
  }

  @Override
  public boolean isLast() throws SQLException {
    LOG.finest("++enter++");
    checkClosed();
    if (this.isNested) {
      return this.nestedRowIndex == this.toIndexExclusive - 1;
    } else {
      return this.rowCount == this.totalRows;
    }
  }
}

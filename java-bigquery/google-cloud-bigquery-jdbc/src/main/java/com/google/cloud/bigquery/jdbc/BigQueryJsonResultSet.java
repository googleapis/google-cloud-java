/*
 * Copyright 2026 Google LLC
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
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;

/** {@link ResultSet} Implementation for JSON datasource (Using REST APIs) */
class BigQueryJsonResultSet extends BigQueryBaseResultSet {
  private final long totalRows;
  private final BlockingQueue<BigQueryFieldValueListWrapper> buffer;
  private boolean hasReachedEnd = false;
  // Points to the current record
  private BigQueryFieldValueListWrapper cursor;
  // Tracks the index of the nested element under process
  private int nestedRowIndex;
  private long rowCnt = 0;
  private boolean afterLast = false;
  private final int fromIndex;
  private final int toIndexExclusive;
  private final Thread[] ownedThreads;

  private BigQueryJsonResultSet(
      Schema schema,
      long totalRows,
      BlockingQueue<BigQueryFieldValueListWrapper> buffer,
      BigQueryStatement statement,
      boolean isNested,
      BigQueryFieldValueListWrapper cursor,
      int fromIndex,
      int toIndexExclusive,
      Thread[] ownedThreads,
      BigQuery bigQuery) {
    super(bigQuery, statement, schema, isNested);
    this.totalRows = totalRows;
    this.buffer = buffer;
    this.cursor = cursor;
    this.fromIndex = fromIndex;
    this.toIndexExclusive = toIndexExclusive;
    this.nestedRowIndex = fromIndex - 1;
    this.ownedThreads = ownedThreads;
  }

  /**
   * This method returns an instance of BigQueryJsonResultSet after adding it in the list of
   * JsonResultSetFinalizer
   *
   * @return BigQueryJsonResultSet
   */
  static BigQueryJsonResultSet of(
      Schema schema,
      long totalRows,
      BlockingQueue<BigQueryFieldValueListWrapper> buffer,
      BigQueryStatement statement,
      Thread[] ownedThreads,
      BigQuery bigQuery) {

    return new BigQueryJsonResultSet(
        schema, totalRows, buffer, statement, false, null, -1, -1, ownedThreads, bigQuery);
  }

  static BigQueryJsonResultSet of(
      Schema schema,
      long totalRows,
      BlockingQueue<BigQueryFieldValueListWrapper> buffer,
      BigQueryStatement statement,
      Thread[] ownedThreads) {

    return new BigQueryJsonResultSet(
        schema, totalRows, buffer, statement, false, null, -1, -1, ownedThreads, null);
  }

  BigQueryJsonResultSet() {
    super(null, null, null, false);
    totalRows = 0;
    buffer = null;
    fromIndex = 0;
    ownedThreads = new Thread[0];
    toIndexExclusive = 0;
  }

  //

  /**
   * Wrapper method which can be used for initialising the instance of BigQueryJsonResultSet for the
   * nested Records
   *
   * @param schema Table schema
   * @param cursor Points to the current record
   * @param fromIndex starting index under consideration
   * @param toIndexExclusive last index under consideration
   * @return The BigQueryJsonResultSet
   */
  static BigQueryJsonResultSet getNestedResultSet(
      Schema schema, BigQueryFieldValueListWrapper cursor, int fromIndex, int toIndexExclusive) {
    return new BigQueryJsonResultSet(
        schema,
        -1,
        null,
        null, /* statement will be null in case of nested java.sql.Result. */
        true,
        cursor,
        fromIndex,
        toIndexExclusive,
        null,
        null);
  }

  /* Advances the result set to the next row, returning false if no such row exists. Potentially blocking operation */
  public boolean next() throws SQLException {
    checkClosed();
    if (this.isNested) {
      // We are working with the nested record, the cursor would have been
      // populated.
      if (this.cursor == null || this.cursor.getArrayFieldValueList() == null) {
        throw new IllegalStateException(
            "Cursor/ArrayFieldValueList can not be null working with the nested record");
      }
      // Check if there's a next record in the array which can be read
      if (this.nestedRowIndex < (this.toIndexExclusive - 1)) {
        this.nestedRowIndex++;
        return true;
      }
      this.afterLast = true;
      return false;

    } else {
      // If end of stream is reached or we are past the last row i.e
      // rowcnt == totalRows (rowcnt starts at 0)
      // then we can simply return false
      if (this.hasReachedEnd || this.isLast()) {
        this.afterLast = true;
        return false;
      }
      try {
        // Advance the cursor,Potentially blocking operation
        this.cursor = this.buffer.take();
        this.rowCnt++;
        // Check for end of stream
        if (this.cursor.isLast()) {
          this.cursor = null;
          this.hasReachedEnd = true;
          return false;
        }
        // Cursor has been advanced
        return true;

      } catch (InterruptedException ex) {
        throw new BigQueryJdbcRuntimeException(
            "Error occurred while advancing the cursor. This could happen when connection is closed while we call the next method",
            ex);
      }
    }
  }

  @Override
  public Object getObject(int columnIndex) throws SQLException {
    // columnIndex is SQL index starting at 1
    checkClosed();
    LOG.finest("++enter++");
    FieldValue value = getObjectInternal(columnIndex);
    if (value == null || value.isNull()) {
      return null;
    }

    if (this.isNested && columnIndex == 1) {
      return this.bigQueryTypeCoercer.coerceTo(Integer.class, value);
    }

    if (this.isNested && columnIndex == 2) {
      Field arrayField = this.schema.getFields().get(0);
      if (isStruct(arrayField)) {
        return new BigQueryJsonStruct(arrayField.getSubFields(), value);
      }
      Class<?> targetClass =
          BigQueryJdbcTypeMappings.standardSQLToJavaTypeMapping.get(
              arrayField.getType().getStandardType());
      return this.bigQueryTypeCoercer.coerceTo(targetClass, value);
    }

    int extraIndex = this.isNested ? 2 : 1;
    Field fieldSchema = this.schemaFieldList.get(columnIndex - extraIndex);
    if (isArray(fieldSchema)) {
      return new BigQueryJsonArray(fieldSchema, value);
    } else if (isStruct(fieldSchema)) {
      return new BigQueryJsonStruct(fieldSchema.getSubFields(), value);
    } else {
      Class<?> targetClass =
          BigQueryJdbcTypeMappings.standardSQLToJavaTypeMapping.get(
              fieldSchema.getType().getStandardType());
      return this.bigQueryTypeCoercer.coerceTo(targetClass, value);
    }
  }

  /**
   * This method will be called by every other getter of this {@link java.sql.ResultSet}, including
   * {@link #getObject(int)} to get the value in its rawest form i.e. {@link FieldValue} to coerce
   * it further as required.
   *
   * @param columnIndex the first column is 1, the second is 2, ...
   * @return an instance of {@link FieldValue} represents value at <code>columnIndex</code> column.
   */
  private FieldValue getObjectInternal(int columnIndex) throws SQLException {
    checkClosed();
    LOG.finest("++enter++");
    FieldValue value;
    if (this.isNested) {
      boolean validIndexForNestedResultSet = columnIndex == 1 || columnIndex == 2;
      // BigQuery doesn't support multidimensional arrays, so just the default row
      // num column (1) and the actual column (2) is supposed to be read
      if (!validIndexForNestedResultSet) {
        throw new IllegalArgumentException(
            "Column index is required to be 1 or 2 for the nested arrays");
      }
      if (this.cursor.getArrayFieldValueList() == null
          || this.cursor.getArrayFieldValueList().get(this.nestedRowIndex) == null) {
        throw new IllegalStateException("ArrayFieldValueList cannot be null");
      }

      // For Arrays the first column is Index, ref:
      // https://docs.oracle.com/javase/7/docs/api/java/sql/Array.html#getResultSet()
      if (columnIndex == 1) {
        return FieldValue.of(Attribute.PRIMITIVE, Integer.toString(this.nestedRowIndex + 1));
      } else {
        // columnIndex = 2
        // This ignores the columnIndex, as there's just one column, and we have already incremented
        // the nestedRowIndex
        value = this.cursor.getArrayFieldValueList().get(this.nestedRowIndex);
      }
    }
    // non nested, return the value
    else {
      // SQL Index to 0 based index
      value = this.cursor.getFieldValueList().get(columnIndex - 1);
    }
    setWasNull(value.getValue());
    return value;
  }

  @Override
  public void close() {
    LOG.fine(String.format("Closing BigqueryJsonResultSet %s.", this));
    this.isClosed = true;
    if (ownedThreads != null) {
      for (Thread ownedThread : ownedThreads) {
        if (!ownedThread.isInterrupted()) {
          ownedThread.interrupt();
        }
      }
    }
    super.close();
  }

  @Override
  public boolean isBeforeFirst() throws SQLException {
    checkClosed();
    LOG.finest("++enter++");
    if (this.isNested) {
      return this.nestedRowIndex < this.fromIndex;
    } else {
      return this.cursor == null && this.rowCnt == 0;
    }
  }

  @Override
  public boolean isAfterLast() throws SQLException {
    checkClosed();
    LOG.finest("++enter++");
    return this.afterLast;
  }

  @Override
  public boolean isFirst() throws SQLException {
    checkClosed();
    LOG.finest("++enter++");
    if (this.isNested) {
      return this.nestedRowIndex == this.fromIndex;
    } else {
      return this.rowCnt == 1;
    }
  }

  @Override
  public boolean isLast() throws SQLException {
    checkClosed();
    LOG.finest("++enter++");
    if (this.isNested) {
      return this.nestedRowIndex == this.toIndexExclusive - 1;
    } else {
      return this.rowCnt == this.totalRows;
    }
  }
}

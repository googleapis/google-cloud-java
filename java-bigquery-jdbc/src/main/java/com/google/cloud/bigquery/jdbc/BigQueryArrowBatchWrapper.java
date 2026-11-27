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

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.storage.v1.ArrowRecordBatch;
import com.google.cloud.bigquery.storage.v1.ArrowSchema;
import com.google.common.annotations.VisibleForTesting;
import org.apache.arrow.vector.util.JsonStringArrayList;

/** This class acts as a facade layer and wraps Arrow's VectorSchemaRoot & JsonStringArrayList */
class BigQueryArrowBatchWrapper {
  // Reference to the current arrowBatch
  private final ArrowRecordBatch currentArrowBatch;
  // Arrow schema carried with this batch, set only when the source sent one (e.g. the first
  // ReadRowsResponse of a stream)
  private final ArrowSchema arrowSchema;
  // Rows the source reported for this message (ReadRowsResponse.row_count), or null when the
  // wrapper was not built from a stream message (markers, nested records)
  private final Long reportedRowCount;
  // Reference to the nested Records, set as null otherwise (Arrays)
  private final JsonStringArrayList nestedRecords;

  // Marks the end of the stream for the ResultSet
  private final boolean isLast;

  private final Throwable exception;

  private BigQueryArrowBatchWrapper(
      ArrowRecordBatch currentArrowBatch,
      ArrowSchema arrowSchema,
      Long reportedRowCount,
      JsonStringArrayList nestedRecords,
      boolean isLast,
      Throwable exception) {
    this.currentArrowBatch = currentArrowBatch;
    this.arrowSchema = arrowSchema;
    this.reportedRowCount = reportedRowCount;
    this.nestedRecords = nestedRecords;
    this.isLast = isLast;
    this.exception = exception;
  }

  /** Marks the end of the stream. It carries no data. */
  static BigQueryArrowBatchWrapper ofEndOfStream() {
    return new BigQueryArrowBatchWrapper(null, null, null, null, true, null);
  }

  /**
   * Wraps one stream message: its record batch, the schema sent with it, and the row count it
   * reports. The batch and the schema may each be null (a schema-only message carries no batch;
   * later messages carry no schema).
   */
  static BigQueryArrowBatchWrapper of(
      ArrowRecordBatch currentArrowBatch, ArrowSchema arrowSchema, long reportedRowCount) {
    return new BigQueryArrowBatchWrapper(
        currentArrowBatch, arrowSchema, reportedRowCount, null, false, null);
  }

  static BigQueryArrowBatchWrapper getNestedFieldValueListWrapper(
      JsonStringArrayList nestedRecords) {
    return new BigQueryArrowBatchWrapper(null, null, null, nestedRecords, false, null);
  }

  static BigQueryArrowBatchWrapper ofError(Throwable exception) {
    return new BigQueryArrowBatchWrapper(null, null, null, null, true, exception);
  }

  ArrowRecordBatch getCurrentArrowBatch() {
    return this.currentArrowBatch;
  }

  ArrowSchema getArrowSchema() {
    return this.arrowSchema;
  }

  /**
   * Rows the source reported for this message, or null if this wrapper was not built from a stream
   * message.
   */
  @VisibleForTesting
  Long getReportedRowCount() {
    return this.reportedRowCount;
  }

  /**
   * True if this stream message carries record batch data. A schema, statistics or throttling
   * update carries none.
   */
  boolean hasBatchData() {
    return this.currentArrowBatch != null
        && !this.currentArrowBatch.getSerializedRecordBatch().isEmpty();
  }

  /**
   * Checks what this wrapper can check about itself before its batch is decoded: without batch data
   * it holds no rows, so it must not report any.
   */
  void validate() throws BigQueryJdbcException {
    if (!hasBatchData()) {
      checkRowCount(0);
    }
  }

  /**
   * Fails unless this message reports exactly {@code actualRows}, the rows its record batch holds.
   * A wrapper that is not a stream message reports no count, so there is nothing to check.
   */
  void checkRowCount(int actualRows) throws BigQueryJdbcException {
    if (this.reportedRowCount == null || this.reportedRowCount == actualRows) {
      return;
    }
    throw new BigQueryJdbcException(
        String.format(
            "An Arrow stream message reported %d rows but its batch has %d.",
            this.reportedRowCount, actualRows));
  }

  JsonStringArrayList getNestedRecords() {
    return this.nestedRecords;
  }

  boolean isLast() {
    return this.isLast;
  }

  Throwable getException() {
    return this.exception;
  }
}

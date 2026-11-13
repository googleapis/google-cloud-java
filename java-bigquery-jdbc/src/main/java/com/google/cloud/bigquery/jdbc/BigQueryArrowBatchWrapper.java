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

import com.google.cloud.bigquery.storage.v1.ArrowRecordBatch;
import com.google.cloud.bigquery.storage.v1.ArrowSchema;
import org.apache.arrow.vector.util.JsonStringArrayList;

/** This class acts as a facade layer and wraps Arrow's VectorSchemaRoot & JsonStringArrayList */
class BigQueryArrowBatchWrapper {
  // Reference to the current arrowBatch
  private final ArrowRecordBatch currentArrowBatch;
  // Arrow schema carried with this batch, set only when the source sent one (e.g. the first
  // ReadRowsResponse of a stream)
  private final ArrowSchema arrowSchema;
  // Reference to the nested Records, set as null otherwise (Arrays)
  private final JsonStringArrayList nestedRecords;

  // Marks the end of the stream for the ResultSet
  private final boolean isLast;

  private final Throwable exception;

  private BigQueryArrowBatchWrapper(
      ArrowRecordBatch currentArrowBatch,
      ArrowSchema arrowSchema,
      JsonStringArrayList nestedRecords,
      boolean isLast,
      Throwable exception) {
    this.currentArrowBatch = currentArrowBatch;
    this.arrowSchema = arrowSchema;
    this.nestedRecords = nestedRecords;
    this.isLast = isLast;
    this.exception = exception;
  }

  static BigQueryArrowBatchWrapper of(ArrowRecordBatch currentArrowBatch, boolean... isLast) {
    boolean isLastFlag = isLast != null && isLast.length == 1 && isLast[0];
    return new BigQueryArrowBatchWrapper(currentArrowBatch, null, null, isLastFlag, null);
  }

  /**
   * Wraps a record batch together with the schema sent by the source. Either may be null (a
   * schema-only message carries no batch; later messages carry no schema).
   */
  static BigQueryArrowBatchWrapper of(ArrowRecordBatch currentArrowBatch, ArrowSchema arrowSchema) {
    return new BigQueryArrowBatchWrapper(currentArrowBatch, arrowSchema, null, false, null);
  }

  static BigQueryArrowBatchWrapper getNestedFieldValueListWrapper(
      JsonStringArrayList nestedRecords, boolean... isLast) {
    boolean isLastFlag = isLast != null && isLast.length == 1 && isLast[0];
    return new BigQueryArrowBatchWrapper(null, null, nestedRecords, isLastFlag, null);
  }

  static BigQueryArrowBatchWrapper ofError(Throwable exception) {
    return new BigQueryArrowBatchWrapper(null, null, null, true, exception);
  }

  ArrowRecordBatch getCurrentArrowBatch() {
    return this.currentArrowBatch;
  }

  ArrowSchema getArrowSchema() {
    return this.arrowSchema;
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

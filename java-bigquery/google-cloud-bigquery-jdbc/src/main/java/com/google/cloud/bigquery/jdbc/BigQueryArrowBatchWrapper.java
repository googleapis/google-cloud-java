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
import org.apache.arrow.vector.util.JsonStringArrayList;

/** This class acts as a facade layer and wraps Arrow's VectorSchemaRoot & JsonStringArrayList */
class BigQueryArrowBatchWrapper {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryArrowBatchWrapper.class.getName());
  // Reference to the current arrowBatch
  private final ArrowRecordBatch currentArrowBatch;
  // Reference to the nested Records, set as null otherwise (Arrays)
  private final JsonStringArrayList nestedRecords;

  // Marks the end of the stream for the ResultSet
  private final boolean isLast;

  private final Exception exception;

  private BigQueryArrowBatchWrapper(
      ArrowRecordBatch currentArrowBatch,
      JsonStringArrayList nestedRecords,
      boolean isLast,
      Exception exception) {
    this.currentArrowBatch = currentArrowBatch;
    this.nestedRecords = nestedRecords;
    this.isLast = isLast;
    this.exception = exception;
  }

  static BigQueryArrowBatchWrapper of(ArrowRecordBatch currentArrowBatch, boolean... isLast) {
    LOG.finest("++enter++");
    boolean isLastFlag = isLast != null && isLast.length == 1 && isLast[0];
    return new BigQueryArrowBatchWrapper(currentArrowBatch, null, isLastFlag, null);
  }

  static BigQueryArrowBatchWrapper getNestedFieldValueListWrapper(
      JsonStringArrayList nestedRecords, boolean... isLast) {
    LOG.finest("++enter++");
    boolean isLastFlag = isLast != null && isLast.length == 1 && isLast[0];
    return new BigQueryArrowBatchWrapper(null, nestedRecords, isLastFlag, null);
  }

  static BigQueryArrowBatchWrapper ofError(Exception exception) {
    LOG.finest("++enter++");
    return new BigQueryArrowBatchWrapper(null, null, true, exception);
  }

  ArrowRecordBatch getCurrentArrowBatch() {
    LOG.finest("++enter++");
    return this.currentArrowBatch;
  }

  JsonStringArrayList getNestedRecords() {
    LOG.finest("++enter++");
    return this.nestedRecords;
  }

  boolean isLast() {
    LOG.finest("++enter++");
    return this.isLast;
  }

  Exception getException() {
    return this.exception;
  }
}

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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.storage.v1.ArrowRecordBatch;
import com.google.protobuf.ByteString;
import org.apache.arrow.vector.util.JsonStringArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class BigQueryArrowBatchWrapperTest {

  // The wrapper only looks at whether the batch has bytes, so they don't have to decode.
  private static final ArrowRecordBatch BATCH_WITH_DATA =
      ArrowRecordBatch.newBuilder().setSerializedRecordBatch(ByteString.copyFromUtf8("x")).build();
  private static final ArrowRecordBatch BATCH_WITHOUT_DATA = ArrowRecordBatch.getDefaultInstance();

  @Test
  public void testHasBatchData() {
    assertThat(BigQueryArrowBatchWrapper.of(null, null, 0).hasBatchData()).isFalse();
    assertThat(BigQueryArrowBatchWrapper.of(BATCH_WITHOUT_DATA, null, 0).hasBatchData()).isFalse();
    assertThat(BigQueryArrowBatchWrapper.of(BATCH_WITH_DATA, null, 1).hasBatchData()).isTrue();
  }

  @Test
  public void testValidateRejectsRowsReportedWithoutBatchData() {
    assertRowCountMismatch(
        () -> BigQueryArrowBatchWrapper.of(null, null, 2).validate(),
        "reported 2 rows but its batch has 0");
    assertRowCountMismatch(
        () -> BigQueryArrowBatchWrapper.of(BATCH_WITHOUT_DATA, null, 2).validate(),
        "reported 2 rows but its batch has 0");
    assertRowCountMismatch(
        () -> BigQueryArrowBatchWrapper.of(null, null, -1).validate(),
        "reported -1 rows but its batch has 0");
  }

  @Test
  public void testValidateAcceptsNoRowsWithoutBatchData() {
    assertDoesNotThrow(() -> BigQueryArrowBatchWrapper.of(null, null, 0).validate());
    assertDoesNotThrow(() -> BigQueryArrowBatchWrapper.of(BATCH_WITHOUT_DATA, null, 0).validate());
  }

  @Test
  public void testValidateDoesNotCountTheRowsOfABatch() {
    // How many rows a batch holds is known only once it is decoded, so the deserializer checks it.
    assertDoesNotThrow(() -> BigQueryArrowBatchWrapper.of(BATCH_WITH_DATA, null, 5).validate());
  }

  @Test
  public void testCheckRowCount() {
    BigQueryArrowBatchWrapper message = BigQueryArrowBatchWrapper.of(BATCH_WITH_DATA, null, 2);

    assertDoesNotThrow(() -> message.checkRowCount(2));
    assertRowCountMismatch(() -> message.checkRowCount(3), "reported 2 rows but its batch has 3");
    assertRowCountMismatch(() -> message.checkRowCount(0), "reported 2 rows but its batch has 0");
  }

  @Test
  public void testWrappersThatAreNotStreamMessagesReportNoRowCount() {
    assertNothingToCheck(BigQueryArrowBatchWrapper.ofEndOfStream());
    assertNothingToCheck(BigQueryArrowBatchWrapper.ofError(new IllegalStateException("failed")));
    assertNothingToCheck(
        BigQueryArrowBatchWrapper.getNestedFieldValueListWrapper(new JsonStringArrayList<>()));
  }

  private static void assertNothingToCheck(BigQueryArrowBatchWrapper wrapper) {
    assertThat(wrapper.getReportedRowCount()).isNull();
    assertDoesNotThrow(wrapper::validate);
    assertDoesNotThrow(() -> wrapper.checkRowCount(3));
  }

  private static void assertRowCountMismatch(Executable check, String expected) {
    BigQueryJdbcException e = assertThrows(BigQueryJdbcException.class, check);
    assertThat(e.getMessage()).contains(expected);
  }
}

/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DmlStatsTest {

  private static final Long DELETED_ROW_COUNT = 10L;
  private static final Long INSERTED_ROW_COUNT = 20L;
  private static final Long UPDATED_ROW_COUNT = 30L;
  private static final DmlStats DML_STATS =
      DmlStats.newBuilder()
          .setDeletedRowCount(DELETED_ROW_COUNT)
          .setInsertedRowCount(INSERTED_ROW_COUNT)
          .setUpdatedRowCount(UPDATED_ROW_COUNT)
          .build();

  @Test
  public void testBuilder() {
    assertEquals(DELETED_ROW_COUNT, DML_STATS.getDeletedRowCount());
    assertEquals(UPDATED_ROW_COUNT, DML_STATS.getUpdatedRowCount());
    assertEquals(INSERTED_ROW_COUNT, DML_STATS.getInsertedRowCount());
  }

  @Test
  public void testToPbAndFromPb() {
    compareDmlStats(DML_STATS, DmlStats.fromPb(DML_STATS.toPb()));
  }

  private void compareDmlStats(DmlStats expected, DmlStats actual) {
    assertEquals(expected, actual);
    assertEquals(expected.hashCode(), actual.hashCode());
    assertEquals(expected.toString(), actual.toString());
    assertEquals(expected.getDeletedRowCount(), actual.getDeletedRowCount());
    assertEquals(expected.getInsertedRowCount(), actual.getInsertedRowCount());
    assertEquals(expected.getUpdatedRowCount(), actual.getUpdatedRowCount());
  }
}

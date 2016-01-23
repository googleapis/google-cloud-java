/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class InsertAllRequestTest {

  private static final Map<String, Object> CONTENT1 =
      ImmutableMap.<String, Object>of("key", "val1");
  private static final Map<String, Object> CONTENT2 =
      ImmutableMap.<String, Object>of("key", "val2");
  private static final List<InsertAllRequest.RowToInsert> ROWS =
      ImmutableList.of(InsertAllRequest.RowToInsert.of(CONTENT1),
          InsertAllRequest.RowToInsert.of(CONTENT2));
  private static final List<InsertAllRequest.RowToInsert> ROWS_WITH_ID =
      ImmutableList.of(InsertAllRequest.RowToInsert.of("id1", CONTENT1),
          InsertAllRequest.RowToInsert.of("id2", CONTENT2));
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final Schema TABLE_SCHEMA = Schema.of();
  private static final BaseTableInfo TABLE_INFO = TableInfo.of(TABLE_ID, TABLE_SCHEMA);
  private static final boolean SKIP_INVALID_ROWS = true;
  private static final boolean IGNORE_UNKNOWN_VALUES = false;
  private static final String TEMPLATE_SUFFIX = "templateSuffix";
  private static final InsertAllRequest INSERT_ALL_REQUEST1 = InsertAllRequest.builder(TABLE_ID)
      .addRow(CONTENT1)
      .addRow(CONTENT2)
      .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
      .skipInvalidRows(SKIP_INVALID_ROWS)
      .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST2 = InsertAllRequest.builder(TABLE_ID)
      .rows(ROWS)
      .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
      .skipInvalidRows(SKIP_INVALID_ROWS)
      .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST3 =
      InsertAllRequest.builder(TABLE_ID.dataset(), TABLE_ID.table())
          .rows(ROWS_WITH_ID)
          .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .skipInvalidRows(SKIP_INVALID_ROWS)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST4 =
      InsertAllRequest.builder(TABLE_ID, ROWS)
          .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .skipInvalidRows(SKIP_INVALID_ROWS)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST5 =
      InsertAllRequest.builder(TABLE_ID.dataset(), TABLE_ID.table(), ROWS_WITH_ID)
          .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .skipInvalidRows(SKIP_INVALID_ROWS)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST6 =
      InsertAllRequest.builder(TABLE_ID, ROWS.get(0), ROWS.get(1))
          .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .skipInvalidRows(SKIP_INVALID_ROWS)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST7 =
      InsertAllRequest.builder(TABLE_ID.dataset(), TABLE_ID.table(), ROWS_WITH_ID.get(0),
          ROWS_WITH_ID.get(1))
          .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .skipInvalidRows(SKIP_INVALID_ROWS)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST8 =
      InsertAllRequest.builder(TABLE_ID.dataset(), TABLE_ID.table())
          .addRow("id1", CONTENT1)
          .addRow("id2", CONTENT2)
          .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .skipInvalidRows(SKIP_INVALID_ROWS)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST9 = InsertAllRequest.builder(TABLE_INFO)
      .addRow("id1", CONTENT1)
      .addRow("id2", CONTENT2)
      .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
      .skipInvalidRows(SKIP_INVALID_ROWS)
      .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST10 = InsertAllRequest.builder(TABLE_INFO)
      .addRow("id1", CONTENT1)
      .addRow("id2", CONTENT2)
      .ignoreUnknownValues(true)
      .skipInvalidRows(false)
      .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST11 = InsertAllRequest.builder(TABLE_INFO)
      .addRow("id1", CONTENT1)
      .addRow("id2", CONTENT2)
      .ignoreUnknownValues(true)
      .skipInvalidRows(false)
      .templateSuffix(TEMPLATE_SUFFIX)
      .build();

  @Test
  public void testBuilder() {
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST1.table());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST2.table());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST3.table());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST4.table());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST5.table());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST6.table());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST7.table());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST8.table());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST9.table());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST10.table());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST11.table());
    assertEquals(ROWS, INSERT_ALL_REQUEST1.rows());
    assertEquals(ROWS, INSERT_ALL_REQUEST2.rows());
    assertEquals(ROWS, INSERT_ALL_REQUEST4.rows());
    assertEquals(ROWS, INSERT_ALL_REQUEST6.rows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST3.rows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST5.rows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST7.rows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST8.rows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST9.rows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST10.rows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST11.rows());
    assertEquals(SKIP_INVALID_ROWS, INSERT_ALL_REQUEST1.skipInvalidRows());
    assertEquals(SKIP_INVALID_ROWS, INSERT_ALL_REQUEST2.skipInvalidRows());
    assertEquals(SKIP_INVALID_ROWS, INSERT_ALL_REQUEST3.skipInvalidRows());
    assertEquals(SKIP_INVALID_ROWS, INSERT_ALL_REQUEST4.skipInvalidRows());
    assertEquals(SKIP_INVALID_ROWS, INSERT_ALL_REQUEST5.skipInvalidRows());
    assertEquals(SKIP_INVALID_ROWS, INSERT_ALL_REQUEST6.skipInvalidRows());
    assertEquals(SKIP_INVALID_ROWS, INSERT_ALL_REQUEST7.skipInvalidRows());
    assertEquals(SKIP_INVALID_ROWS, INSERT_ALL_REQUEST8.skipInvalidRows());
    assertEquals(SKIP_INVALID_ROWS, INSERT_ALL_REQUEST9.skipInvalidRows());
    assertFalse(INSERT_ALL_REQUEST10.skipInvalidRows());
    assertFalse(INSERT_ALL_REQUEST11.skipInvalidRows());
    assertEquals(IGNORE_UNKNOWN_VALUES, INSERT_ALL_REQUEST1.ignoreUnknownValues());
    assertEquals(IGNORE_UNKNOWN_VALUES, INSERT_ALL_REQUEST2.ignoreUnknownValues());
    assertEquals(IGNORE_UNKNOWN_VALUES, INSERT_ALL_REQUEST3.ignoreUnknownValues());
    assertEquals(IGNORE_UNKNOWN_VALUES, INSERT_ALL_REQUEST4.ignoreUnknownValues());
    assertEquals(IGNORE_UNKNOWN_VALUES, INSERT_ALL_REQUEST5.ignoreUnknownValues());
    assertEquals(IGNORE_UNKNOWN_VALUES, INSERT_ALL_REQUEST6.ignoreUnknownValues());
    assertEquals(IGNORE_UNKNOWN_VALUES, INSERT_ALL_REQUEST7.ignoreUnknownValues());
    assertEquals(IGNORE_UNKNOWN_VALUES, INSERT_ALL_REQUEST8.ignoreUnknownValues());
    assertEquals(IGNORE_UNKNOWN_VALUES, INSERT_ALL_REQUEST9.ignoreUnknownValues());
    assertTrue(INSERT_ALL_REQUEST10.ignoreUnknownValues());
    assertTrue(INSERT_ALL_REQUEST11.ignoreUnknownValues());
    assertNull(INSERT_ALL_REQUEST1.templateSuffix());
    assertNull(INSERT_ALL_REQUEST2.templateSuffix());
    assertNull(INSERT_ALL_REQUEST3.templateSuffix());
    assertNull(INSERT_ALL_REQUEST4.templateSuffix());
    assertNull(INSERT_ALL_REQUEST5.templateSuffix());
    assertNull(INSERT_ALL_REQUEST6.templateSuffix());
    assertNull(INSERT_ALL_REQUEST7.templateSuffix());
    assertNull(INSERT_ALL_REQUEST8.templateSuffix());
    assertNull(INSERT_ALL_REQUEST9.templateSuffix());
    assertNull(INSERT_ALL_REQUEST10.templateSuffix());
    assertEquals(TEMPLATE_SUFFIX, INSERT_ALL_REQUEST11.templateSuffix());
  }

  @Test
  public void testOf() {
    InsertAllRequest request = InsertAllRequest.of(TABLE_ID, ROWS);
    assertEquals(TABLE_ID, request.table());
    assertEquals(ROWS, request.rows());
    request = InsertAllRequest.of(TABLE_INFO, ROWS);
    assertEquals(TABLE_ID, request.table());
    assertEquals(ROWS, request.rows());
    request = InsertAllRequest.of(TABLE_ID.dataset(), TABLE_ID.table(), ROWS);
    assertEquals(TABLE_ID, request.table());
    assertEquals(ROWS, request.rows());
    request = InsertAllRequest.of(TABLE_ID.dataset(), TABLE_ID.table(), ROWS);
    assertEquals(TABLE_ID, request.table());
    assertEquals(ROWS, request.rows());
    request = InsertAllRequest.of(TABLE_ID, ROWS.get(0), ROWS.get(1));
    assertEquals(TABLE_ID, request.table());
    assertEquals(ROWS, request.rows());
    request = InsertAllRequest.of(TABLE_INFO, ROWS.get(0), ROWS.get(1));
    assertEquals(TABLE_ID, request.table());
    assertEquals(ROWS, request.rows());
    request = InsertAllRequest.of(TABLE_ID.dataset(), TABLE_ID.table(), ROWS.get(0), ROWS.get(1));
    assertEquals(TABLE_ID, request.table());
    assertEquals(ROWS, request.rows());
  }

  @Test
  public void testEquals() {
    compareInsertAllRequest(INSERT_ALL_REQUEST1, INSERT_ALL_REQUEST2);
    compareInsertAllRequest(INSERT_ALL_REQUEST2, INSERT_ALL_REQUEST4);
    compareInsertAllRequest(INSERT_ALL_REQUEST3, INSERT_ALL_REQUEST5);
    compareInsertAllRequest(INSERT_ALL_REQUEST4, INSERT_ALL_REQUEST6);
    compareInsertAllRequest(INSERT_ALL_REQUEST5, INSERT_ALL_REQUEST7);
    compareInsertAllRequest(INSERT_ALL_REQUEST7, INSERT_ALL_REQUEST8);
    compareInsertAllRequest(INSERT_ALL_REQUEST8, INSERT_ALL_REQUEST9);
    compareInsertAllRequest(INSERT_ALL_REQUEST10, INSERT_ALL_REQUEST10);
    compareInsertAllRequest(INSERT_ALL_REQUEST11, INSERT_ALL_REQUEST11);
  }

  private void compareInsertAllRequest(InsertAllRequest expected, InsertAllRequest value) {
    assertEquals(expected, value);
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.table(), value.table());
    assertEquals(expected.rows(), value.rows());
    assertEquals(expected.ignoreUnknownValues(), value.ignoreUnknownValues());
    assertEquals(expected.skipInvalidRows(), value.skipInvalidRows());
    assertEquals(expected.templateSuffix(), value.templateSuffix());
  }
}

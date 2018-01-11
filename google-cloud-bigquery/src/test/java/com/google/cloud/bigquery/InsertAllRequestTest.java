/*
 * Copyright 2015 Google LLC
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
  private static final TableDefinition TABLE_DEFINITION = StandardTableDefinition.of(TABLE_SCHEMA);
  private static final TableInfo TABLE_INFO = TableInfo.of(TABLE_ID, TABLE_DEFINITION);
  private static final boolean SKIP_INVALID_ROWS = true;
  private static final boolean IGNORE_UNKNOWN_VALUES = false;
  private static final String TEMPLATE_SUFFIX = "templateSuffix";
  private static final InsertAllRequest INSERT_ALL_REQUEST1 = InsertAllRequest.newBuilder(TABLE_ID)
      .addRow(CONTENT1)
      .addRow(CONTENT2)
      .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
      .setSkipInvalidRows(SKIP_INVALID_ROWS)
      .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST2 = InsertAllRequest.newBuilder(TABLE_ID)
      .setRows(ROWS)
      .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
      .setSkipInvalidRows(SKIP_INVALID_ROWS)
      .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST3 =
      InsertAllRequest.newBuilder(TABLE_ID.getDataset(), TABLE_ID.getTable())
          .setRows(ROWS_WITH_ID)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setSkipInvalidRows(SKIP_INVALID_ROWS)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST4 =
      InsertAllRequest.newBuilder(TABLE_ID, ROWS)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setSkipInvalidRows(SKIP_INVALID_ROWS)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST5 =
      InsertAllRequest.newBuilder(TABLE_ID.getDataset(), TABLE_ID.getTable(), ROWS_WITH_ID)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setSkipInvalidRows(SKIP_INVALID_ROWS)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST6 =
      InsertAllRequest.newBuilder(TABLE_ID, ROWS.get(0), ROWS.get(1))
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setSkipInvalidRows(SKIP_INVALID_ROWS)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST7 =
      InsertAllRequest.newBuilder(TABLE_ID.getDataset(), TABLE_ID.getTable(), ROWS_WITH_ID.get(0),
          ROWS_WITH_ID.get(1))
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setSkipInvalidRows(SKIP_INVALID_ROWS)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST8 =
      InsertAllRequest.newBuilder(TABLE_ID.getDataset(), TABLE_ID.getTable())
          .addRow("id1", CONTENT1)
          .addRow("id2", CONTENT2)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setSkipInvalidRows(SKIP_INVALID_ROWS)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST9 =
      InsertAllRequest.newBuilder(TABLE_INFO)
          .addRow("id1", CONTENT1)
          .addRow("id2", CONTENT2)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setSkipInvalidRows(SKIP_INVALID_ROWS)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST10 =
      InsertAllRequest.newBuilder(TABLE_INFO)
          .addRow("id1", CONTENT1)
          .addRow("id2", CONTENT2)
          .setIgnoreUnknownValues(true)
          .setSkipInvalidRows(false)
          .build();
  private static final InsertAllRequest INSERT_ALL_REQUEST11 =
      InsertAllRequest.newBuilder(TABLE_INFO)
          .addRow("id1", CONTENT1)
          .addRow("id2", CONTENT2)
          .setIgnoreUnknownValues(true)
          .setSkipInvalidRows(false)
          .setTemplateSuffix(TEMPLATE_SUFFIX)
          .build();

  @Test
  public void testBuilder() {
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST1.getTable());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST2.getTable());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST3.getTable());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST4.getTable());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST5.getTable());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST6.getTable());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST7.getTable());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST8.getTable());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST9.getTable());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST10.getTable());
    assertEquals(TABLE_ID, INSERT_ALL_REQUEST11.getTable());
    assertEquals(ROWS, INSERT_ALL_REQUEST1.getRows());
    assertEquals(ROWS, INSERT_ALL_REQUEST2.getRows());
    assertEquals(ROWS, INSERT_ALL_REQUEST4.getRows());
    assertEquals(ROWS, INSERT_ALL_REQUEST6.getRows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST3.getRows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST5.getRows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST7.getRows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST8.getRows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST9.getRows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST10.getRows());
    assertEquals(ROWS_WITH_ID, INSERT_ALL_REQUEST11.getRows());
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
    assertNull(INSERT_ALL_REQUEST1.getTemplateSuffix());
    assertNull(INSERT_ALL_REQUEST2.getTemplateSuffix());
    assertNull(INSERT_ALL_REQUEST3.getTemplateSuffix());
    assertNull(INSERT_ALL_REQUEST4.getTemplateSuffix());
    assertNull(INSERT_ALL_REQUEST5.getTemplateSuffix());
    assertNull(INSERT_ALL_REQUEST6.getTemplateSuffix());
    assertNull(INSERT_ALL_REQUEST7.getTemplateSuffix());
    assertNull(INSERT_ALL_REQUEST8.getTemplateSuffix());
    assertNull(INSERT_ALL_REQUEST9.getTemplateSuffix());
    assertNull(INSERT_ALL_REQUEST10.getTemplateSuffix());
    assertEquals(TEMPLATE_SUFFIX, INSERT_ALL_REQUEST11.getTemplateSuffix());
  }


  @Test
  public void testOf() {
    InsertAllRequest request = InsertAllRequest.of(TABLE_ID, ROWS);
    assertEquals(TABLE_ID, request.getTable());
    assertEquals(ROWS, request.getRows());
    request = InsertAllRequest.of(TABLE_INFO, ROWS);
    assertEquals(TABLE_ID, request.getTable());
    assertEquals(ROWS, request.getRows());
    request = InsertAllRequest.of(TABLE_ID.getDataset(), TABLE_ID.getTable(), ROWS);
    assertEquals(TABLE_ID, request.getTable());
    assertEquals(ROWS, request.getRows());
    request = InsertAllRequest.of(TABLE_ID.getDataset(), TABLE_ID.getTable(), ROWS);
    assertEquals(TABLE_ID, request.getTable());
    assertEquals(ROWS, request.getRows());
    request = InsertAllRequest.of(TABLE_ID, ROWS.get(0), ROWS.get(1));
    assertEquals(TABLE_ID, request.getTable());
    assertEquals(ROWS, request.getRows());
    request = InsertAllRequest.of(TABLE_INFO, ROWS.get(0), ROWS.get(1));
    assertEquals(TABLE_ID, request.getTable());
    assertEquals(ROWS, request.getRows());
    request =
        InsertAllRequest.of(TABLE_ID.getDataset(), TABLE_ID.getTable(), ROWS.get(0), ROWS.get(1));
    assertEquals(TABLE_ID, request.getTable());
    assertEquals(ROWS, request.getRows());
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
    assertEquals(expected.getTable(), value.getTable());
    assertEquals(expected.getRows(), value.getRows());
    assertEquals(expected.ignoreUnknownValues(), value.ignoreUnknownValues());
    assertEquals(expected.skipInvalidRows(), value.skipInvalidRows());
    assertEquals(expected.getTemplateSuffix(), value.getTemplateSuffix());
  }
}

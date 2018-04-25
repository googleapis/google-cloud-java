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

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

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
    assertThat(TABLE_ID).isEqualTo(INSERT_ALL_REQUEST1.getTable());
    assertThat(TABLE_ID).isEqualTo(INSERT_ALL_REQUEST2.getTable());
    assertThat(TABLE_ID).isEqualTo(INSERT_ALL_REQUEST3.getTable());
    assertThat(TABLE_ID).isEqualTo(INSERT_ALL_REQUEST4.getTable());
    assertThat(TABLE_ID).isEqualTo(INSERT_ALL_REQUEST5.getTable());
    assertThat(TABLE_ID).isEqualTo(INSERT_ALL_REQUEST6.getTable());
    assertThat(TABLE_ID).isEqualTo(INSERT_ALL_REQUEST7.getTable());
    assertThat(TABLE_ID).isEqualTo(INSERT_ALL_REQUEST8.getTable());
    assertThat(TABLE_ID).isEqualTo(INSERT_ALL_REQUEST9.getTable());
    assertThat(TABLE_ID).isEqualTo(INSERT_ALL_REQUEST10.getTable());
    assertThat(TABLE_ID).isEqualTo(INSERT_ALL_REQUEST11.getTable());
    assertThat(ROWS).isEqualTo(INSERT_ALL_REQUEST1.getRows());
    assertThat(ROWS).isEqualTo(INSERT_ALL_REQUEST2.getRows());
    assertThat(ROWS).isEqualTo(INSERT_ALL_REQUEST4.getRows());
    assertThat(ROWS).isEqualTo(INSERT_ALL_REQUEST6.getRows());
    assertThat(ROWS_WITH_ID).isEqualTo(INSERT_ALL_REQUEST3.getRows());
    assertThat(ROWS_WITH_ID).isEqualTo(INSERT_ALL_REQUEST5.getRows());
    assertThat(ROWS_WITH_ID).isEqualTo(INSERT_ALL_REQUEST7.getRows());
    assertThat(ROWS_WITH_ID).isEqualTo(INSERT_ALL_REQUEST8.getRows());
    assertThat(ROWS_WITH_ID).isEqualTo(INSERT_ALL_REQUEST9.getRows());
    assertThat(ROWS_WITH_ID).isEqualTo(INSERT_ALL_REQUEST10.getRows());
    assertThat(ROWS_WITH_ID).isEqualTo(INSERT_ALL_REQUEST11.getRows());
    assertThat(SKIP_INVALID_ROWS).isEqualTo(INSERT_ALL_REQUEST1.skipInvalidRows());
    assertThat(SKIP_INVALID_ROWS).isEqualTo(INSERT_ALL_REQUEST2.skipInvalidRows());
    assertThat(SKIP_INVALID_ROWS).isEqualTo(INSERT_ALL_REQUEST3.skipInvalidRows());
    assertThat(SKIP_INVALID_ROWS).isEqualTo(INSERT_ALL_REQUEST4.skipInvalidRows());
    assertThat(SKIP_INVALID_ROWS).isEqualTo(INSERT_ALL_REQUEST5.skipInvalidRows());
    assertThat(SKIP_INVALID_ROWS).isEqualTo(INSERT_ALL_REQUEST6.skipInvalidRows());
    assertThat(SKIP_INVALID_ROWS).isEqualTo(INSERT_ALL_REQUEST7.skipInvalidRows());
    assertThat(SKIP_INVALID_ROWS).isEqualTo(INSERT_ALL_REQUEST8.skipInvalidRows());
    assertThat(SKIP_INVALID_ROWS).isEqualTo(INSERT_ALL_REQUEST9.skipInvalidRows());
    assertThat(INSERT_ALL_REQUEST10.skipInvalidRows()).isFalse();
    assertThat(INSERT_ALL_REQUEST11.skipInvalidRows()).isFalse();
    assertThat(IGNORE_UNKNOWN_VALUES).isEqualTo(INSERT_ALL_REQUEST1.ignoreUnknownValues());
    assertThat(IGNORE_UNKNOWN_VALUES).isEqualTo(INSERT_ALL_REQUEST2.ignoreUnknownValues());
    assertThat(IGNORE_UNKNOWN_VALUES).isEqualTo(INSERT_ALL_REQUEST3.ignoreUnknownValues());
    assertThat(IGNORE_UNKNOWN_VALUES).isEqualTo(INSERT_ALL_REQUEST4.ignoreUnknownValues());
    assertThat(IGNORE_UNKNOWN_VALUES).isEqualTo(INSERT_ALL_REQUEST5.ignoreUnknownValues());
    assertThat(IGNORE_UNKNOWN_VALUES).isEqualTo(INSERT_ALL_REQUEST6.ignoreUnknownValues());
    assertThat(IGNORE_UNKNOWN_VALUES).isEqualTo(INSERT_ALL_REQUEST7.ignoreUnknownValues());
    assertThat(IGNORE_UNKNOWN_VALUES).isEqualTo(INSERT_ALL_REQUEST8.ignoreUnknownValues());
    assertThat(IGNORE_UNKNOWN_VALUES).isEqualTo(INSERT_ALL_REQUEST9.ignoreUnknownValues());
    assertThat(INSERT_ALL_REQUEST10.ignoreUnknownValues()).isTrue();
    assertThat(INSERT_ALL_REQUEST11.ignoreUnknownValues()).isTrue();
    assertThat(INSERT_ALL_REQUEST1.getTemplateSuffix()).isNull();
    assertThat(INSERT_ALL_REQUEST2.getTemplateSuffix()).isNull();
    assertThat(INSERT_ALL_REQUEST3.getTemplateSuffix()).isNull();
    assertThat(INSERT_ALL_REQUEST4.getTemplateSuffix()).isNull();
    assertThat(INSERT_ALL_REQUEST5.getTemplateSuffix()).isNull();
    assertThat(INSERT_ALL_REQUEST6.getTemplateSuffix()).isNull();
    assertThat(INSERT_ALL_REQUEST7.getTemplateSuffix()).isNull();
    assertThat(INSERT_ALL_REQUEST8.getTemplateSuffix()).isNull();
    assertThat(INSERT_ALL_REQUEST9.getTemplateSuffix()).isNull();
    assertThat(INSERT_ALL_REQUEST10.getTemplateSuffix()).isNull();
    assertThat(TEMPLATE_SUFFIX).isEqualTo(INSERT_ALL_REQUEST11.getTemplateSuffix());
  }


  @Test
  public void testOf() {
    InsertAllRequest request = InsertAllRequest.of(TABLE_ID, ROWS);
    assertThat(TABLE_ID).isEqualTo(request.getTable());
    assertThat(ROWS).isEqualTo(request.getRows());
    request = InsertAllRequest.of(TABLE_INFO, ROWS);
    assertThat(TABLE_ID).isEqualTo(request.getTable());
    assertThat(ROWS).isEqualTo(request.getRows());
    request = InsertAllRequest.of(TABLE_ID.getDataset(), TABLE_ID.getTable(), ROWS);
    assertThat(TABLE_ID).isEqualTo(request.getTable());
    assertThat(ROWS).isEqualTo(request.getRows());
    request = InsertAllRequest.of(TABLE_ID.getDataset(), TABLE_ID.getTable(), ROWS);
    assertThat(TABLE_ID).isEqualTo(request.getTable());
    assertThat(ROWS).isEqualTo(request.getRows());
    request = InsertAllRequest.of(TABLE_ID, ROWS.get(0), ROWS.get(1));
    assertThat(TABLE_ID).isEqualTo(request.getTable());
    assertThat(ROWS).isEqualTo(request.getRows());
    request = InsertAllRequest.of(TABLE_INFO, ROWS.get(0), ROWS.get(1));
    assertThat(TABLE_ID).isEqualTo(request.getTable());
    assertThat(ROWS).isEqualTo(request.getRows());
    request =
        InsertAllRequest.of(TABLE_ID.getDataset(), TABLE_ID.getTable(), ROWS.get(0), ROWS.get(1));
    assertThat(TABLE_ID).isEqualTo(request.getTable());
    assertThat(ROWS).isEqualTo(request.getRows());
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

  @Test(expected=UnsupportedOperationException.class)
  public void testImmutable() {
    InsertAllRequest.RowToInsert row = InsertAllRequest.RowToInsert.of(new HashMap<String,Object>());
    row.getContent().put("zip", "zap");
  }

  @Test
  public void testNullOK() {
    InsertAllRequest.RowToInsert row =
        InsertAllRequest.RowToInsert.of(Collections.singletonMap("foo", null));
    assertThat(row.getContent()).containsExactly("foo", null);
  }

  private void compareInsertAllRequest(InsertAllRequest expected, InsertAllRequest value) {
    assertThat(expected).isEqualTo(value);
    assertThat(expected.toString()).isEqualTo(value.toString());
    assertThat(expected.hashCode()).isEqualTo(value.hashCode());
    assertThat(expected.getTable()).isEqualTo(value.getTable());
    assertThat(expected.getRows()).isEqualTo(value.getRows());
    assertThat(expected.ignoreUnknownValues()).isEqualTo(value.ignoreUnknownValues());
    assertThat(expected.skipInvalidRows()).isEqualTo(value.skipInvalidRows());
    assertThat(expected.getTemplateSuffix()).isEqualTo(value.getTemplateSuffix());
  }
}

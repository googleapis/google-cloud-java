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

import com.google.api.client.util.Data;
import com.google.api.services.bigquery.model.TableCell;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TableRowTest {

  private static final FieldValue BOOL_VALUE = new FieldValue(FieldValue.Kind.PRIMITIVE, "false");
  private static final FieldValue INT_VALUE = new FieldValue(FieldValue.Kind.PRIMITIVE, "1");
  private static final FieldValue FLOAT_VALUE = new FieldValue(FieldValue.Kind.PRIMITIVE, "1.5");
  private static final FieldValue STRING_VALUE = new FieldValue(FieldValue.Kind.PRIMITIVE, "str");
  private static final FieldValue TIME_VALUE = new FieldValue(FieldValue.Kind.PRIMITIVE, "42");
  private static final List<FieldValue> ROW_VALUES =
      ImmutableList.of(BOOL_VALUE, INT_VALUE, FLOAT_VALUE, STRING_VALUE, TIME_VALUE);
  private static final TableRow TABLE_ROW1 = new TableRow.Builder()
      .addValue(BOOL_VALUE)
      .addValue(INT_VALUE)
      .addValue(FLOAT_VALUE)
      .addValue(STRING_VALUE)
      .addValue(TIME_VALUE)
      .build();
  private static final TableRow TABLE_ROW2 = new TableRow.Builder().values(ROW_VALUES).build();

  @Test
  public void testBuilder() {
    assertEquals(ROW_VALUES, TABLE_ROW1.values());
    assertEquals(ROW_VALUES, TABLE_ROW2.values());
  }

  @Test
  public void testEquals() {
    compareTableRow(TABLE_ROW1, TABLE_ROW2);
  }

  @Test
  public void testFromPb() {
    TableCell booleanField = new TableCell().setV("false");
    TableCell integerField = new TableCell().setV("1");
    TableCell floatField = new TableCell().setV("1.5");
    TableCell stringField = new TableCell().setV("str");
    TableCell timestampField = new TableCell().setV("42");
    com.google.api.services.bigquery.model.TableRow rowPb =
        new com.google.api.services.bigquery.model.TableRow();
    rowPb.setF(ImmutableList.of(booleanField, integerField, floatField, stringField,
        timestampField));
    compareTableRow(TABLE_ROW1, TableRow.fromPb(rowPb));
  }

  private void compareTableRow(TableRow expected, TableRow value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.values(), value.values());
  }
}

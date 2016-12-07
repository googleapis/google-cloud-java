/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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
import static org.junit.Assert.assertNull;

import java.util.List;
import org.junit.Test;

public class QueryParameterValueTest {

  @Test
  public void testBool() {
    QueryParameterValue value = QueryParameterValue.bool(true);
    assertEquals("true", value.getValue());
    assertEquals(StandardSQLTypeName.BOOL, value.getType());
    assertNull(value.getArrayType());
    assertNull(value.getArrayValues());
  }

  @Test
  public void testInt64() {
    QueryParameterValue value = QueryParameterValue.int64(8L);
    assertEquals("8", value.getValue());
    assertEquals(StandardSQLTypeName.INT64, value.getType());
    assertNull(value.getArrayType());
    assertNull(value.getArrayValues());
  }

  @Test
  public void testInt64FromInteger() {
    QueryParameterValue value = QueryParameterValue.int64(7);
    assertEquals("7", value.getValue());
    assertEquals(StandardSQLTypeName.INT64, value.getType());
    assertNull(value.getArrayType());
    assertNull(value.getArrayValues());
  }

  @Test
  public void testFloat64() {
    QueryParameterValue value = QueryParameterValue.float64(1.2);
    assertEquals("1.2", value.getValue());
    assertEquals(StandardSQLTypeName.FLOAT64, value.getType());
    assertNull(value.getArrayType());
    assertNull(value.getArrayValues());
  }

  @Test
  public void testFloat64FromFloat() {
    QueryParameterValue value = QueryParameterValue.float64(1.2f);
    assertEquals("1.2", value.getValue());
    assertEquals(StandardSQLTypeName.FLOAT64, value.getType());
    assertNull(value.getArrayType());
    assertNull(value.getArrayValues());
  }

  @Test
  public void testString() {
    QueryParameterValue value = QueryParameterValue.string("foo");
    assertEquals("foo", value.getValue());
    assertEquals(StandardSQLTypeName.STRING, value.getType());
    assertNull(value.getArrayType());
    assertNull(value.getArrayValues());
  }

  @Test
  public void testBytes() {
    QueryParameterValue value = QueryParameterValue.bytes(new byte[] {1, 3});
    assertEquals("AQM=", value.getValue());
    assertEquals(StandardSQLTypeName.BYTES, value.getType());
    assertNull(value.getArrayType());
    assertNull(value.getArrayValues());
  }

  @Test
  public void testBoolArray() {
    QueryParameterValue value = QueryParameterValue.array(new Boolean[] {true, false}, Boolean.class);
    assertNull(value.getValue());
    assertEquals(StandardSQLTypeName.ARRAY, value.getType());
    assertEquals(StandardSQLTypeName.BOOL, value.getArrayType());
    assertArrayDataEquals(new String[]{"true", "false"}, StandardSQLTypeName.BOOL, value.getArrayValues());
  }

  @Test
  public void testInt64Array() {
    QueryParameterValue value = QueryParameterValue.array(new Long[] {2L, 5L}, Long.class);
    assertNull(value.getValue());
    assertEquals(StandardSQLTypeName.ARRAY, value.getType());
    assertEquals(StandardSQLTypeName.INT64, value.getArrayType());
    assertArrayDataEquals(new String[]{"2", "5"}, StandardSQLTypeName.INT64, value.getArrayValues());
  }

  @Test
  public void testInt64ArrayFromIntegers() {
    QueryParameterValue value = QueryParameterValue.array(new Integer[] {2, 5}, Integer.class);
    assertNull(value.getValue());
    assertEquals(StandardSQLTypeName.ARRAY, value.getType());
    assertEquals(StandardSQLTypeName.INT64, value.getArrayType());
    assertArrayDataEquals(new String[]{"2", "5"}, StandardSQLTypeName.INT64, value.getArrayValues());
  }

  @Test
  public void testFloat64Array() {
    QueryParameterValue value = QueryParameterValue.array(new Double[] {2.6, 5.4}, Double.class);
    assertNull(value.getValue());
    assertEquals(StandardSQLTypeName.ARRAY, value.getType());
    assertEquals(StandardSQLTypeName.FLOAT64, value.getArrayType());
    assertArrayDataEquals(new String[]{"2.6", "5.4"}, StandardSQLTypeName.FLOAT64, value.getArrayValues());
  }

  @Test
  public void testFloat64ArrayFromFloats() {
    QueryParameterValue value = QueryParameterValue.array(new Float[] {2.6f, 5.4f}, Float.class);
    assertNull(value.getValue());
    assertEquals(StandardSQLTypeName.ARRAY, value.getType());
    assertEquals(StandardSQLTypeName.FLOAT64, value.getArrayType());
    assertArrayDataEquals(new String[]{"2.6", "5.4"}, StandardSQLTypeName.FLOAT64, value.getArrayValues());
  }

  @Test
  public void testStringArray() {
    QueryParameterValue value = QueryParameterValue.array(new String[] {"Ana", "Marv"}, String.class);
    assertNull(value.getValue());
    assertEquals(StandardSQLTypeName.ARRAY, value.getType());
    assertEquals(StandardSQLTypeName.STRING, value.getArrayType());
    assertArrayDataEquals(new String[]{"Ana", "Marv"}, StandardSQLTypeName.STRING, value.getArrayValues());
  }

  @Test
  public void testTimestampFromLong() {
    QueryParameterValue value = QueryParameterValue.timestamp(1408452095220000L);
    assertEquals("2014-08-19 12:41:35.220000+00:00", value.getValue());
    assertEquals(StandardSQLTypeName.TIMESTAMP, value.getType());
    assertNull(value.getArrayType());
    assertNull(value.getArrayValues());
  }

  @Test
  public void testTimestamp() {
    QueryParameterValue value = QueryParameterValue.timestamp("2014-08-19 12:41:35.220000+00:00");
    assertEquals("2014-08-19 12:41:35.220000+00:00", value.getValue());
    assertEquals(StandardSQLTypeName.TIMESTAMP, value.getType());
    assertNull(value.getArrayType());
    assertNull(value.getArrayValues());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTimestamp() {
    // missing the time
    QueryParameterValue.timestamp("2014-08-19");
  }

  @Test
  public void testDate() {
    QueryParameterValue value = QueryParameterValue.date("2014-08-19");
    assertEquals("2014-08-19", value.getValue());
    assertEquals(StandardSQLTypeName.DATE, value.getType());
    assertNull(value.getArrayType());
    assertNull(value.getArrayValues());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDate() {
    // not supposed to have the time
    QueryParameterValue.date("2014-08-19 12:41:35.220000");
  }

  @Test
  public void testTime() {
    QueryParameterValue value = QueryParameterValue.time("05:41:35.220000");
    assertEquals("05:41:35.220000", value.getValue());
    assertEquals(StandardSQLTypeName.TIME, value.getType());
    assertNull(value.getArrayType());
    assertNull(value.getArrayValues());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTime() {
    // not supposed to have the date
    QueryParameterValue.time("2014-08-19 12:41:35.220000");
  }

  @Test
  public void testDateTime() {
    QueryParameterValue value = QueryParameterValue.dateTime("2014-08-19 05:41:35.220000");
    assertEquals("2014-08-19 05:41:35.220000", value.getValue());
    assertEquals(StandardSQLTypeName.DATETIME, value.getType());
    assertNull(value.getArrayType());
    assertNull(value.getArrayValues());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDateTime() {
    // missing the time
    QueryParameterValue.dateTime("2014-08-19");
  }

  @Test
  public void testTimestampArrayFromLongs() {
    QueryParameterValue value =
        QueryParameterValue.array(new Long[] {1408452095220000L, 1481041545110000L}, StandardSQLTypeName.TIMESTAMP);
    assertNull(value.getValue());
    assertEquals(StandardSQLTypeName.ARRAY, value.getType());
    assertEquals(StandardSQLTypeName.TIMESTAMP, value.getArrayType());
    assertArrayDataEquals(
        new String[]{"2014-08-19 12:41:35.220000+00:00", "2016-12-06 16:25:45.110000+00:00"},
        StandardSQLTypeName.TIMESTAMP,
        value.getArrayValues());
  }

  @Test
  public void testTimestampArray() {
    QueryParameterValue value =
        QueryParameterValue.array(
            new String[] {"2014-08-19 12:41:35.220000+00:00", "2016-12-06 16:25:45.110000+00:00"},
            StandardSQLTypeName.TIMESTAMP);
    assertNull(value.getValue());
    assertEquals(StandardSQLTypeName.ARRAY, value.getType());
    assertEquals(StandardSQLTypeName.TIMESTAMP, value.getArrayType());
    assertArrayDataEquals(
        new String[]{"2014-08-19 12:41:35.220000+00:00", "2016-12-06 16:25:45.110000+00:00"},
        StandardSQLTypeName.TIMESTAMP,
        value.getArrayValues());
  }

  private static void assertArrayDataEquals(String[] expectedValues,
      StandardSQLTypeName expectedType, List<QueryParameterValue> actualValues) {
    assertEquals(expectedValues.length, actualValues.size());
    for (int i = 0; i < expectedValues.length; i++) {
      QueryParameterValue value = actualValues.get(i);
      assertEquals(expectedType, value.getType());
      assertEquals(expectedValues[i], value.getValue());
      assertNull(value.getArrayType());
      assertNull(value.getArrayValues());
    }
  }
}

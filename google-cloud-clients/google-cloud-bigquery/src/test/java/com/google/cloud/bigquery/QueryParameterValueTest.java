/*
 * Copyright 2016 Google LLC
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

import com.google.api.services.bigquery.model.QueryParameterType;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;

public class QueryParameterValueTest {

  @Test
  public void testBool() {
    QueryParameterValue value = QueryParameterValue.bool(true);
    assertThat(value.getValue()).isEqualTo("true");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.BOOL);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
  }

  @Test
  public void testInt64() {
    QueryParameterValue value = QueryParameterValue.int64(8L);
    assertThat(value.getValue()).isEqualTo("8");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.INT64);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
  }

  @Test
  public void testInt64FromInteger() {
    QueryParameterValue value = QueryParameterValue.int64(7);
    assertThat(value.getValue()).isEqualTo("7");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.INT64);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
  }

  @Test
  public void testFloat64() {
    QueryParameterValue value = QueryParameterValue.float64(1.2);
    assertThat(value.getValue()).isEqualTo("1.2");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.FLOAT64);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
  }

  @Test
  public void testFloat64FromFloat() {
    QueryParameterValue value = QueryParameterValue.float64(1.2f);
    assertThat(value.getValue()).isEqualTo("1.2");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.FLOAT64);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
  }

  @Test
  public void testNumeric() {
    QueryParameterValue value = QueryParameterValue.numeric(new BigDecimal("123.456"));
    assertThat(value.getValue()).isEqualTo("123.456");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.NUMERIC);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
  }

  @Test
  public void testString() {
    QueryParameterValue value = QueryParameterValue.string("foo");
    assertThat(value.getValue()).isEqualTo("foo");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.STRING);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
  }

  @Test
  public void testBytes() {
    QueryParameterValue value = QueryParameterValue.bytes(new byte[] {1, 3});
    assertThat(value.getValue()).isEqualTo("AQM=");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.BYTES);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
  }

  @Test
  public void testBoolArray() {
    QueryParameterValue value = QueryParameterValue.array(new Boolean[] {true, false}, Boolean.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.BOOL);
    assertArrayDataEquals(new String[]{"true", "false"}, StandardSQLTypeName.BOOL, value.getArrayValues());
  }

  @Test
  public void testInt64Array() {
    QueryParameterValue value = QueryParameterValue.array(new Long[] {2L, 5L}, Long.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.INT64);
    assertArrayDataEquals(new String[]{"2", "5"}, StandardSQLTypeName.INT64, value.getArrayValues());
  }

  @Test
  public void testInt64ArrayFromIntegers() {
    QueryParameterValue value = QueryParameterValue.array(new Integer[] {2, 5}, Integer.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.INT64);
    assertArrayDataEquals(new String[]{"2", "5"}, StandardSQLTypeName.INT64, value.getArrayValues());
  }

  @Test
  public void testFloat64Array() {
    QueryParameterValue value = QueryParameterValue.array(new Double[] {2.6, 5.4}, Double.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.FLOAT64);
    assertArrayDataEquals(new String[]{"2.6", "5.4"}, StandardSQLTypeName.FLOAT64, value.getArrayValues());
  }

  @Test
  public void testFloat64ArrayFromFloats() {
    QueryParameterValue value = QueryParameterValue.array(new Float[] {2.6f, 5.4f}, Float.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.FLOAT64);
    assertArrayDataEquals(new String[]{"2.6", "5.4"}, StandardSQLTypeName.FLOAT64, value.getArrayValues());
  }

  @Test
  public void testNumericArray() {
    QueryParameterValue value = QueryParameterValue.array(
        new BigDecimal[] {new BigDecimal("3.14"), new BigDecimal("1.59")}, BigDecimal.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.NUMERIC);
    assertArrayDataEquals(new String[]{"3.14", "1.59"}, StandardSQLTypeName.NUMERIC, value.getArrayValues());
  }

  @Test
  public void testStringArray() {
    QueryParameterValue value = QueryParameterValue.array(new String[] {"Ana", "Marv"}, String.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.STRING);
    assertArrayDataEquals(new String[]{"Ana", "Marv"}, StandardSQLTypeName.STRING, value.getArrayValues());
  }

  @Test
  public void testTimestampFromLong() {
    QueryParameterValue value = QueryParameterValue.timestamp(1408452095220000L);
    assertThat(value.getValue()).isEqualTo("2014-08-19 12:41:35.220000+00:00");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.TIMESTAMP);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
  }

  @Test
  public void testTimestamp() {
    QueryParameterValue value = QueryParameterValue.timestamp("2014-08-19 12:41:35.220000+00:00");
    assertThat(value.getValue()).isEqualTo("2014-08-19 12:41:35.220000+00:00");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.TIMESTAMP);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTimestamp() {
    // missing the time
    QueryParameterValue.timestamp("2014-08-19");
  }

  @Test
  public void testDate() {
    QueryParameterValue value = QueryParameterValue.date("2014-08-19");
    assertThat(value.getValue()).isEqualTo("2014-08-19");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.DATE);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDate() {
    // not supposed to have the time
    QueryParameterValue.date("2014-08-19 12:41:35.220000");
  }

  @Test
  public void testTime() {
    QueryParameterValue value = QueryParameterValue.time("05:41:35.220000");
    assertThat(value.getValue()).isEqualTo("05:41:35.220000");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.TIME);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTime() {
    // not supposed to have the date
    QueryParameterValue.time("2014-08-19 12:41:35.220000");
  }

  @Test
  public void testDateTime() {
    QueryParameterValue value = QueryParameterValue.dateTime("2014-08-19 05:41:35.220000");
    assertThat(value.getValue()).isEqualTo("2014-08-19 05:41:35.220000");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.DATETIME);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
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
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.TIMESTAMP);
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
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.TIMESTAMP);
    assertArrayDataEquals(
        new String[]{"2014-08-19 12:41:35.220000+00:00", "2016-12-06 16:25:45.110000+00:00"},
        StandardSQLTypeName.TIMESTAMP,
        value.getArrayValues());
  }

  @Test
  public void testFromEmptyArray() {
    QueryParameterType typePb =
        new QueryParameterType()
            .setType("ARRAY")
            .setArrayType(new QueryParameterType().setType("INT64"));
    // If the array is empty, the server sends us a null value, not a value with empty array.
    QueryParameterValue value = QueryParameterValue.fromPb(null, typePb);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.INT64);
    assertThat(value.getArrayValues()).isEmpty();
  }

  private static void assertArrayDataEquals(String[] expectedValues,
      StandardSQLTypeName expectedType, List<QueryParameterValue> actualValues) {
    assertThat(actualValues.size()).isEqualTo(expectedValues.length);
    for (int i = 0; i < expectedValues.length; i++) {
      QueryParameterValue value = actualValues.get(i);
      assertThat(value.getType()).isEqualTo(expectedType);
      assertThat(value.getValue()).isEqualTo(expectedValues[i]);
      assertThat(value.getArrayType()).isNull();
      assertThat(value.getArrayValues()).isNull();
    }
  }
}

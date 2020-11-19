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
import static org.threeten.bp.temporal.ChronoField.HOUR_OF_DAY;
import static org.threeten.bp.temporal.ChronoField.MINUTE_OF_HOUR;
import static org.threeten.bp.temporal.ChronoField.NANO_OF_SECOND;
import static org.threeten.bp.temporal.ChronoField.SECOND_OF_MINUTE;

import com.google.api.services.bigquery.model.QueryParameterType;
import com.google.common.collect.ImmutableMap;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.Jdk8Methods;

public class QueryParameterValueTest {

  private static final DateTimeFormatter TIMESTAMPFORMATTER =
      new DateTimeFormatterBuilder()
          .parseLenient()
          .append(DateTimeFormatter.ISO_LOCAL_DATE)
          .appendLiteral(' ')
          .appendValue(HOUR_OF_DAY, 2)
          .appendLiteral(':')
          .appendValue(MINUTE_OF_HOUR, 2)
          .optionalStart()
          .appendLiteral(':')
          .appendValue(SECOND_OF_MINUTE, 2)
          .optionalStart()
          .appendFraction(NANO_OF_SECOND, 6, 9, true)
          .optionalStart()
          .appendOffset("+HHMM", "+00:00")
          .optionalEnd()
          .toFormatter()
          .withZone(ZoneOffset.UTC);

  private static final QueryParameterValue QUERY_PARAMETER_VALUE =
      QueryParameterValue.newBuilder()
          .setType(StandardSQLTypeName.STRING)
          .setValue("test-string")
          .build();

  @Test
  public void testBuilder() {
    QueryParameterValue value = QUERY_PARAMETER_VALUE.toBuilder().build();
    assertThat(value).isEqualTo(QUERY_PARAMETER_VALUE);
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.STRING);
    assertThat(value.getValue()).isEqualTo("test-string");
    assertThat(value.toString()).isEqualTo(QUERY_PARAMETER_VALUE.toString());
    assertThat(value.hashCode()).isEqualTo(QUERY_PARAMETER_VALUE.hashCode());
    assertThat(value.equals(value)).isTrue();
    assertThat(QUERY_PARAMETER_VALUE).isNotEqualTo(StandardSQLTypeName.STRING);
  }

  @Test
  public void testTypeNullPointerException() {
    try {
      QUERY_PARAMETER_VALUE.toBuilder().setType(null).build();
      Assert.fail();
    } catch (NullPointerException ex) {
      assertThat(ex).isNotNull();
    }
  }

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
  public void testBigNumeric() {
    QueryParameterValue value =
        QueryParameterValue.bigNumeric(new BigDecimal("0.33333333333333333333333333333333333333"));
    QueryParameterValue value1 =
        QueryParameterValue.bigNumeric(new BigDecimal("0.50000000000000000000000000000000000000"));
    QueryParameterValue value2 =
        QueryParameterValue.bigNumeric(new BigDecimal("0.00000000500000000000000000000000000000"));
    QueryParameterValue value3 =
        QueryParameterValue.bigNumeric(new BigDecimal("-0.00000000500000000000000000000000000000"));
    QueryParameterValue value4 =
        QueryParameterValue.bigNumeric(
            new BigDecimal("0.33333333333333333333333333333333333333888888888888888"));
    QueryParameterValue value5 = QueryParameterValue.bigNumeric(new BigDecimal("1e-38"));
    QueryParameterValue value6 = QueryParameterValue.bigNumeric(new BigDecimal("-1e38"));
    QueryParameterValue value7 =
        QueryParameterValue.bigNumeric(
            new BigDecimal(
                "578960446186580977117854925043439539266.34992332820282019728792003956564819967"));
    QueryParameterValue value8 =
        QueryParameterValue.bigNumeric(
            new BigDecimal(
                "-578960446186580977117854925043439539266.34992332820282019728792003956564819968"));

    assertThat(value.getValue()).isEqualTo("0.33333333333333333333333333333333333333");
    assertThat(value1.getValue()).isEqualTo("0.50000000000000000000000000000000000000");
    assertThat(value2.getValue()).isEqualTo("5.00000000000000000000000000000E-9");
    assertThat(value3.getValue()).isEqualTo("-5.00000000000000000000000000000E-9");
    assertThat(value4.getValue())
        .isEqualTo("0.33333333333333333333333333333333333333888888888888888");
    assertThat(value5.getValue()).isEqualTo("1E-38");
    assertThat(value6.getValue()).isEqualTo("-1E+38");
    assertThat(value7.getValue())
        .isEqualTo(
            "578960446186580977117854925043439539266.34992332820282019728792003956564819967");
    assertThat(value8.getValue())
        .isEqualTo(
            "-578960446186580977117854925043439539266.34992332820282019728792003956564819968");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.BIGNUMERIC);
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
    QueryParameterValue value =
        QueryParameterValue.array(new Boolean[] {true, false}, Boolean.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.BOOL);
    assertArrayDataEquals(
        new String[] {"true", "false"}, StandardSQLTypeName.BOOL, value.getArrayValues());
  }

  @Test
  public void testInt64Array() {
    QueryParameterValue value = QueryParameterValue.array(new Long[] {2L, 5L}, Long.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.INT64);
    assertArrayDataEquals(
        new String[] {"2", "5"}, StandardSQLTypeName.INT64, value.getArrayValues());
  }

  @Test
  public void testInt64ArrayFromIntegers() {
    QueryParameterValue value = QueryParameterValue.array(new Integer[] {2, 5}, Integer.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.INT64);
    assertArrayDataEquals(
        new String[] {"2", "5"}, StandardSQLTypeName.INT64, value.getArrayValues());
  }

  @Test
  public void testFloat64Array() {
    QueryParameterValue value = QueryParameterValue.array(new Double[] {2.6, 5.4}, Double.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.FLOAT64);
    assertArrayDataEquals(
        new String[] {"2.6", "5.4"}, StandardSQLTypeName.FLOAT64, value.getArrayValues());
  }

  @Test
  public void testFloat64ArrayFromFloats() {
    QueryParameterValue value = QueryParameterValue.array(new Float[] {2.6f, 5.4f}, Float.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.FLOAT64);
    assertArrayDataEquals(
        new String[] {"2.6", "5.4"}, StandardSQLTypeName.FLOAT64, value.getArrayValues());
  }

  @Test
  public void testNumericArray() {
    QueryParameterValue value =
        QueryParameterValue.array(
            new BigDecimal[] {new BigDecimal("3.14"), new BigDecimal("1.59")}, BigDecimal.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.NUMERIC);
    assertArrayDataEquals(
        new String[] {"3.14", "1.59"}, StandardSQLTypeName.NUMERIC, value.getArrayValues());
  }

  @Test
  public void testStringArray() {
    QueryParameterValue value =
        QueryParameterValue.array(new String[] {"Ana", "Marv"}, String.class);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.STRING);
    assertArrayDataEquals(
        new String[] {"Ana", "Marv"}, StandardSQLTypeName.STRING, value.getArrayValues());
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
  public void testTimestampWithFormatter() {
    long timestampInMicroseconds = 1571068536842L * 1000 + 123;
    long microseconds = 1_000_000;
    long secs = Jdk8Methods.floorDiv(timestampInMicroseconds, microseconds);
    int nano = (int) Jdk8Methods.floorMod(timestampInMicroseconds, microseconds) * 1000;
    Instant instant = Instant.ofEpochSecond(secs, nano);
    String expected = TIMESTAMPFORMATTER.format(instant);
    assertThat(expected)
        .isEqualTo(QueryParameterValue.timestamp(timestampInMicroseconds).getValue());
  }

  @Test
  public void testTimestamp() {
    QueryParameterValue value = QueryParameterValue.timestamp("2014-08-19 12:41:35.220000+00:00");
    assertThat(value.getValue()).isEqualTo("2014-08-19 12:41:35.220000+00:00");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.TIMESTAMP);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
  }

  @Test
  public void testTimestampWithDateTimeFormatterBuilder() {
    QueryParameterValue value = QueryParameterValue.timestamp("2019-02-14 12:34:45.938993Z");
    assertThat(value.getValue()).isEqualTo("2019-02-14 12:34:45.938993Z");
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.TIMESTAMP);
    assertThat(value.getArrayType()).isNull();
    assertThat(value.getArrayValues()).isNull();
    QueryParameterValue value1 = QueryParameterValue.timestamp("2019-02-14 12:34:45.938993+0000");
    assertThat(value1.getValue()).isEqualTo("2019-02-14 12:34:45.938993+0000");
    assertThat(value1.getType()).isEqualTo(StandardSQLTypeName.TIMESTAMP);
    assertThat(value1.getArrayType()).isNull();
    assertThat(value1.getArrayValues()).isNull();
    QueryParameterValue value2 = QueryParameterValue.timestamp("2019-02-14 12:34:45.102+00:00");
    assertThat(value2.getValue()).isEqualTo("2019-02-14 12:34:45.102+00:00");
    assertThat(value2.getType()).isEqualTo(StandardSQLTypeName.TIMESTAMP);
    assertThat(value2.getArrayType()).isNull();
    assertThat(value2.getArrayValues()).isNull();
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

  @Test
  public void testStandardDate() throws ParseException {
    com.google.cloud.Date gcDate = com.google.cloud.Date.parseDate("2016-09-18");
    Date date = com.google.cloud.Date.toJavaUtilDate(gcDate);
    QueryParameterValue value = QueryParameterValue.of(date, Date.class);
    assertThat(value.getValue()).isEqualTo("2016-09-18");
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
        QueryParameterValue.array(
            new Long[] {1408452095220000L, 1481041545110000L}, StandardSQLTypeName.TIMESTAMP);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.TIMESTAMP);
    assertArrayDataEquals(
        new String[] {"2014-08-19 12:41:35.220000+00:00", "2016-12-06 16:25:45.110000+00:00"},
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
        new String[] {"2014-08-19 12:41:35.220000+00:00", "2016-12-06 16:25:45.110000+00:00"},
        StandardSQLTypeName.TIMESTAMP,
        value.getArrayValues());
  }

  @Test
  public void testTimestampArrayWithDateTimeFormatterBuilder() {
    QueryParameterValue value =
        QueryParameterValue.array(
            new String[] {
              "2019-02-14 12:34:45.938993Z",
              "2019-02-14 12:34:45.938993+0000",
              "2019-02-14 12:34:45.102+00:00"
            },
            StandardSQLTypeName.TIMESTAMP);
    assertThat(value.getValue()).isNull();
    assertThat(value.getType()).isEqualTo(StandardSQLTypeName.ARRAY);
    assertThat(value.getArrayType()).isEqualTo(StandardSQLTypeName.TIMESTAMP);
    assertArrayDataEquals(
        new String[] {
          "2019-02-14 12:34:45.938993Z",
          "2019-02-14 12:34:45.938993+0000",
          "2019-02-14 12:34:45.102+00:00"
        },
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

  @Test
  public void testStruct() {
    QueryParameterValue booleanField = QueryParameterValue.bool(true);
    QueryParameterValue integerField = QueryParameterValue.int64(15);
    QueryParameterValue stringField = QueryParameterValue.string("test-string");
    QueryParameterValue recordField =
        QueryParameterValue.struct(
            ImmutableMap.of(
                "booleanField",
                booleanField,
                "integerField",
                integerField,
                "stringField",
                stringField));
    com.google.api.services.bigquery.model.QueryParameterValue parameterValue =
        recordField.toValuePb();
    QueryParameterType parameterType = recordField.toTypePb();
    QueryParameterValue queryParameterValue =
        QueryParameterValue.fromPb(parameterValue, parameterType);
    assertThat(queryParameterValue).isEqualTo(recordField);
    assertThat(recordField.getValue()).isNull();
    assertThat(recordField.getType()).isEqualTo(StandardSQLTypeName.STRUCT);
    assertThat(recordField.getStructTypes()).isNotNull();
    assertThat(recordField.getStructValues()).isNotNull();
  }

  @Test
  public void testNestedStruct() {
    QueryParameterValue booleanField = QueryParameterValue.bool(true);
    QueryParameterValue integerField = QueryParameterValue.int64(15);
    QueryParameterValue stringField = QueryParameterValue.string("test-string");
    QueryParameterValue recordField =
        QueryParameterValue.struct(
            ImmutableMap.of(
                "booleanField",
                booleanField,
                "integerField",
                integerField,
                "stringField",
                stringField));
    Map<String, QueryParameterValue> structValue = new HashMap<>();
    structValue.put("bool", booleanField);
    structValue.put("int", integerField);
    structValue.put("string", stringField);
    structValue.put("struct", recordField);
    QueryParameterValue nestedRecordField = QueryParameterValue.struct(structValue);
    com.google.api.services.bigquery.model.QueryParameterValue parameterValue =
        nestedRecordField.toValuePb();
    QueryParameterType parameterType = nestedRecordField.toTypePb();
    QueryParameterValue queryParameterValue =
        QueryParameterValue.fromPb(parameterValue, parameterType);
    assertThat(queryParameterValue).isEqualTo(nestedRecordField);
    assertThat(nestedRecordField.getValue()).isNull();
    assertThat(nestedRecordField.getType()).isEqualTo(StandardSQLTypeName.STRUCT);
    assertThat(nestedRecordField.getStructTypes().get("struct").getType())
        .isEqualTo(StandardSQLTypeName.STRUCT);
    assertThat(nestedRecordField.getStructValues().get("struct").getStructValues())
        .containsAtLeastEntriesIn(recordField.getStructValues());
    assertThat(nestedRecordField.getStructTypes().size()).isEqualTo(structValue.size());
    assertThat(nestedRecordField.getStructValues().size()).isEqualTo(structValue.size());
  }

  private static void assertArrayDataEquals(
      String[] expectedValues,
      StandardSQLTypeName expectedType,
      List<QueryParameterValue> actualValues) {
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

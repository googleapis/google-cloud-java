/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.cloud.bigquery.FieldValue.Attribute.PRIMITIVE;
import static com.google.cloud.bigquery.FieldValue.Attribute.RANGE;
import static com.google.cloud.bigquery.FieldValue.Attribute.RECORD;
import static com.google.cloud.bigquery.FieldValue.Attribute.REPEATED;
import static com.google.cloud.bigquery.jdbc.BigQueryTypeCoercionUtility.INSTANCE;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.bigquery.FieldElementType;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Range;
import com.google.cloud.bigquery.exception.BigQueryJdbcCoercionException;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class FieldValueTypeBigQueryCoercionUtilityTest {
  private static final FieldValue STRING_VALUE = FieldValue.of(PRIMITIVE, "sample-string");
  private static final FieldValue INTEGER_VALUE = FieldValue.of(PRIMITIVE, "345");
  private static final FieldValue FLOAT_VALUE = FieldValue.of(PRIMITIVE, "345.21");
  private static final FieldValue SHORT_VALUE = FieldValue.of(PRIMITIVE, "345");
  private static final FieldValue LONG_VALUE = FieldValue.of(PRIMITIVE, "4374218905");
  private static final FieldValue DOUBLE_VALUE = FieldValue.of(PRIMITIVE, "56453.458393");
  private static final FieldValue BIG_DECIMAL_VALUE = FieldValue.of(PRIMITIVE, "56453.458393");
  private static final FieldValue BASE64_ENCODED_VALUE =
      FieldValue.of(PRIMITIVE, "SGVsbG8gV29ybGQK"); // Hello World!
  private static final FieldValue TIMESTAMP_VALUE = FieldValue.of(PRIMITIVE, "1408452095.22");
  private static final FieldValue DATE_VALUE = FieldValue.of(PRIMITIVE, "2023-03-13");
  private static final FieldValue TIME_VALUE = FieldValue.of(PRIMITIVE, "23:59:59");
  private static final FieldValue TIME_WITH_NANOSECOND_VALUE =
      FieldValue.of(PRIMITIVE, "23:59:59.99999");
  private static final FieldValue TRUE_VALUE = FieldValue.of(PRIMITIVE, "true");
  private static final FieldValue FALSE_VALUE = FieldValue.of(PRIMITIVE, "false");
  private static final FieldValue NULL_VALUE = FieldValue.of(PRIMITIVE, null);
  private static final FieldValue INTEGER_ARRAY =
      FieldValue.of(
          REPEATED,
          FieldValueList.of(
              ImmutableList.of(FieldValue.of(PRIMITIVE, 1), FieldValue.of(PRIMITIVE, 2))));
  private static final FieldValue RECORD_VALUE =
      FieldValue.of(
          RECORD, ImmutableList.of(INTEGER_VALUE, STRING_VALUE, TIME_VALUE, INTEGER_ARRAY));

  private static final Range RANGE_DATE =
      Range.newBuilder()
          .setType(FieldElementType.newBuilder().setType("DATE").build())
          .setStart("1970-01-02")
          .setEnd("1970-03-04")
          .build();

  private static final Range RANGE_DATETIME =
      Range.newBuilder()
          .setType(FieldElementType.newBuilder().setType("DATETIME").build())
          .setStart("2014-08-19 05:41:35.220000")
          .setEnd("2015-09-20 06:41:35.220000")
          .build();

  private static final Range RANGE_TIMESTAMP =
      Range.newBuilder()
          .setType(FieldElementType.newBuilder().setType("TIMESTAMP").build())
          .setStart("2014-08-19 12:41:35.220000+00:00")
          .setEnd("2015-09-20 13:41:35.220000+01:00")
          .build();

  private static final FieldValue RANGE_DATE_VALUE = FieldValue.of(RANGE, RANGE_DATE);
  private static final FieldValue RANGE_DATE_TIME_VALUE = FieldValue.of(RANGE, RANGE_DATETIME);
  private static final FieldValue RANGE_TIMESTAMP_VALUE = FieldValue.of(RANGE, RANGE_TIMESTAMP);

  @Test
  public void fieldValueToStringRangeDate() {
    String expectedRangeDate =
        String.format(
            "[%s, %s)",
            RANGE_DATE.getStart().getStringValue(), RANGE_DATE.getEnd().getStringValue());
    assertThat(INSTANCE.coerceTo(String.class, RANGE_DATE_VALUE)).isEqualTo(expectedRangeDate);
  }

  @Test
  public void rangeDateToString() {
    String expectedRangeDate =
        String.format(
            "[%s, %s)",
            RANGE_DATE.getStart().getStringValue(), RANGE_DATE.getEnd().getStringValue());
    assertThat(INSTANCE.coerceTo(String.class, RANGE_DATE)).isEqualTo(expectedRangeDate);
  }

  @Test
  public void fieldValueToStringRangeDatetime() {
    String expectedRangeDatetime =
        String.format(
            "[%s, %s)",
            RANGE_DATETIME.getStart().getStringValue(), RANGE_DATETIME.getEnd().getStringValue());
    assertThat(INSTANCE.coerceTo(String.class, RANGE_DATE_TIME_VALUE))
        .isEqualTo(expectedRangeDatetime);
  }

  @Test
  public void rangeDatetimeToString() {
    String expectedRangeDate =
        String.format(
            "[%s, %s)",
            RANGE_DATETIME.getStart().getStringValue(), RANGE_DATETIME.getEnd().getStringValue());
    assertThat(INSTANCE.coerceTo(String.class, RANGE_DATETIME)).isEqualTo(expectedRangeDate);
  }

  @Test
  public void fieldValueToStringRangeTimestamp() {
    String expectedRangeTimestamp =
        String.format(
            "[%s, %s)",
            RANGE_TIMESTAMP.getStart().getStringValue(), RANGE_TIMESTAMP.getEnd().getStringValue());
    assertThat(INSTANCE.coerceTo(String.class, RANGE_TIMESTAMP_VALUE))
        .isEqualTo(expectedRangeTimestamp);
  }

  @Test
  public void rangeTimestampToString() {
    String expectedRangeTimestamp =
        String.format(
            "[%s, %s)",
            RANGE_TIMESTAMP.getStart().getStringValue(), RANGE_TIMESTAMP.getEnd().getStringValue());
    assertThat(INSTANCE.coerceTo(String.class, RANGE_TIMESTAMP)).isEqualTo(expectedRangeTimestamp);
  }

  @Test
  public void fieldValueToString() {
    assertThat(INSTANCE.coerceTo(String.class, STRING_VALUE)).isEqualTo("sample-string");
  }

  @Test
  public void fieldValueToStringWhenNull() {
    assertThat(INSTANCE.coerceTo(String.class, null)).isNull();
  }

  @Test
  public void fieldValueToStringWhenInnerValueIsNull() {
    assertThat(INSTANCE.coerceTo(String.class, NULL_VALUE)).isNull();
  }

  @Test
  public void fieldValueToStringWhenInnerValueIsAnArray() {
    assertThat(INSTANCE.coerceTo(String.class, INTEGER_ARRAY))
        .isEqualTo(
            "[FieldValue{attribute=PRIMITIVE, value=1, useInt64Timestamps=false}, FieldValue{attribute=PRIMITIVE, value=2, useInt64Timestamps=false}]");
  }

  @Test
  public void fieldValueToInteger() {
    assertThat(INSTANCE.coerceTo(Integer.class, INTEGER_VALUE)).isEqualTo(345);
  }

  @Test
  public void fieldValueToIntegerWhenNull() {
    assertThat(INSTANCE.coerceTo(Integer.class, null)).isEqualTo(0);
  }

  @Test
  public void fieldValueToIntegerWhenInnerValueIsNull() {
    assertThat(INSTANCE.coerceTo(Integer.class, NULL_VALUE)).isEqualTo(0);
  }

  @Test
  public void fieldValueToFloat() {
    assertThat(INSTANCE.coerceTo(Float.class, FLOAT_VALUE)).isEqualTo(345.21f);
  }

  @Test
  public void fieldValueToFloatWhenNull() {
    assertThat(INSTANCE.coerceTo(Float.class, null)).isEqualTo(0f);
  }

  @Test
  public void fieldValueToFloatWhenInnerValueNull() {
    assertThat(INSTANCE.coerceTo(Float.class, NULL_VALUE)).isEqualTo(0f);
  }

  @Test
  public void fieldValueToShort() {
    assertThat(INSTANCE.coerceTo(Short.class, SHORT_VALUE)).isEqualTo((short) 345);
  }

  @Test
  public void fieldValueToShortWhenNull() {
    assertThat(INSTANCE.coerceTo(Short.class, null)).isEqualTo((short) 0);
  }

  @Test
  public void fieldValueToShortWhenInnerValueNull() {
    assertThat(INSTANCE.coerceTo(Short.class, NULL_VALUE)).isEqualTo((short) 0);
  }

  @Test
  public void fieldValueToLong() {
    assertThat(INSTANCE.coerceTo(Long.class, LONG_VALUE)).isEqualTo(4374218905L);
  }

  @Test
  public void fieldValueToLongWhenNull() {
    assertThat(INSTANCE.coerceTo(Long.class, null)).isEqualTo(0L);
  }

  @Test
  public void fieldValueToLongWhenInnerValueIsNull() {
    assertThat(INSTANCE.coerceTo(Long.class, NULL_VALUE)).isEqualTo(0L);
  }

  @Test
  public void fieldValueToDouble() {
    assertThat(INSTANCE.coerceTo(Double.class, DOUBLE_VALUE)).isEqualTo(56453.458393D);
  }

  @Test
  public void fieldValueToDoubleWhenNull() {
    assertThat(INSTANCE.coerceTo(Double.class, null)).isEqualTo(0D);
  }

  @Test
  public void fieldValueToDoubleWhenInnerValueIsNull() {
    assertThat(INSTANCE.coerceTo(Double.class, NULL_VALUE)).isEqualTo(0D);
  }

  @Test
  public void fieldValueToBigDecimal() {
    assertThat(INSTANCE.coerceTo(BigDecimal.class, BIG_DECIMAL_VALUE))
        .isEqualTo(new BigDecimal("56453.458393"));
  }

  @Test
  public void fieldValueToBigDecimalWhenNull() {
    assertThat(INSTANCE.coerceTo(BigDecimal.class, null)).isNull();
  }

  @Test
  public void fieldValueToBigDecimalWhenInnerValueIsNull() {
    assertThat(INSTANCE.coerceTo(BigDecimal.class, NULL_VALUE)).isNull();
  }

  @Test
  public void fieldValueToBoolean() {
    assertThat(INSTANCE.coerceTo(Boolean.class, TRUE_VALUE)).isTrue();
    assertThat(INSTANCE.coerceTo(Boolean.class, FALSE_VALUE)).isFalse();
  }

  @Test
  public void fieldValueToBooleanWhenNull() {
    assertThat(INSTANCE.coerceTo(Boolean.class, null)).isFalse();
  }

  @Test
  public void fieldValueToBooleanWhenInnerValueIsNull() {
    assertThat(INSTANCE.coerceTo(Boolean.class, NULL_VALUE)).isFalse();
  }

  @Test
  public void fieldValueToBytesArray() {
    assertThat(INSTANCE.coerceTo(byte[].class, BASE64_ENCODED_VALUE))
        .isEqualTo(new byte[] {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 10});
  }

  @Test
  public void fieldValueToBytesArrayWhenNull() {
    assertThat(INSTANCE.coerceTo(byte[].class, null)).isNull();
  }

  @Test
  public void fieldValueToBytesArrayWhenInnerValueIsNull() {
    assertThat(INSTANCE.coerceTo(byte[].class, NULL_VALUE)).isNull();
  }

  @Test
  public void fieldValueToTimestamp() {
    Instant instant = Instant.EPOCH.plus(TIMESTAMP_VALUE.getTimestampValue(), ChronoUnit.MICROS);
    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
    assertThat(INSTANCE.coerceTo(Timestamp.class, TIMESTAMP_VALUE))
        .isEqualTo(Timestamp.valueOf(localDateTime));
  }

  @Test
  public void fieldValueToTimestampWhenNull() {
    assertThat(INSTANCE.coerceTo(Timestamp.class, null)).isNull();
  }

  @Test
  public void fieldValueToTimestampWhenInnerValueIsNull() {
    assertThat(INSTANCE.coerceTo(Timestamp.class, NULL_VALUE)).isNull();
  }

  @Test
  public void fieldValueToTime() {
    LocalTime expectedTime = LocalTime.of(23, 59, 59);
    assertThat(INSTANCE.coerceTo(Time.class, TIME_VALUE))
        .isEqualTo(new Time(TimeUnit.NANOSECONDS.toMillis(expectedTime.toNanoOfDay())));
    LocalTime expectedTimeWithNanos = LocalTime.parse("23:59:59.99999");
    assertThat(INSTANCE.coerceTo(Time.class, TIME_WITH_NANOSECOND_VALUE))
        .isEqualTo(new Time(TimeUnit.NANOSECONDS.toMillis(expectedTimeWithNanos.toNanoOfDay())));
  }

  @Test
  public void fieldValueToTimeWhenNull() {
    assertThat(INSTANCE.coerceTo(Time.class, null)).isNull();
  }

  @Test
  public void fieldValueToTimeWhenInnerValueIsNull() {
    assertThat(INSTANCE.coerceTo(Time.class, NULL_VALUE)).isNull();
  }

  @Test
  public void fieldValueToTimeWithInvalidValue() {
    FieldValue invalidTime = FieldValue.of(PRIMITIVE, "99:99:99");

    BigQueryJdbcCoercionException coercionException =
        assertThrows(
            BigQueryJdbcCoercionException.class, () -> INSTANCE.coerceTo(Time.class, invalidTime));
    assertThat(coercionException.getCause()).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void fieldValueToDate() {
    LocalDate expectedDate = LocalDate.of(2023, 3, 13);
    assertThat(INSTANCE.coerceTo(Date.class, DATE_VALUE)).isEqualTo(Date.valueOf(expectedDate));
  }

  @Test
  public void fieldValueToDateWhenNull() {
    assertThat(INSTANCE.coerceTo(Date.class, null)).isNull();
  }

  @Test
  public void fieldValueToDateWhenInnerValueIsNull() {
    assertThat(INSTANCE.coerceTo(Date.class, NULL_VALUE)).isNull();
  }

  @Test
  public void fieldValueToObject() {
    assertThat(INSTANCE.coerceTo(Object.class, RECORD_VALUE))
        .isEqualTo(ImmutableList.of(INTEGER_VALUE, STRING_VALUE, TIME_VALUE, INTEGER_ARRAY));
  }

  @Test
  public void fieldValueToObjectWhenNull() {
    assertThat(INSTANCE.coerceTo(Object.class, null)).isNull();
  }

  @Test
  public void fieldValueToObjectWhenInnerValueIsNull() {
    assertThat(INSTANCE.coerceTo(Object.class, NULL_VALUE)).isNull();
  }
}

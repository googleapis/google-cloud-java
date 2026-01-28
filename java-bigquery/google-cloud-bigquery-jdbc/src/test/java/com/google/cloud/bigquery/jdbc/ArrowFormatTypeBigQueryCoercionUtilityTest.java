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

import static com.google.cloud.bigquery.jdbc.BigQueryTypeCoercionUtility.INSTANCE;
import static com.google.common.truth.Truth.assertThat;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;

import com.google.cloud.bigquery.FieldElementType;
import com.google.cloud.bigquery.Range;
import com.google.cloud.bigquery.jdbc.rules.TimeZoneRule;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import org.apache.arrow.vector.PeriodDuration;
import org.apache.arrow.vector.util.JsonStringArrayList;
import org.apache.arrow.vector.util.JsonStringHashMap;
import org.apache.arrow.vector.util.Text;
import org.junit.Rule;
import org.junit.Test;

public class ArrowFormatTypeBigQueryCoercionUtilityTest {

  @Rule public final TimeZoneRule timeZoneRule = new TimeZoneRule("UTC");

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

  @Test
  public void nullToString() {
    assertThat(INSTANCE.coerceTo(String.class, null)).isNull();
  }

  @Test
  public void JsonStringArrayListToString() {
    JsonStringArrayList<Integer> employeeList = new JsonStringArrayList<>();
    employeeList.add(1);
    employeeList.add(2);
    employeeList.add(3);

    assertThat(INSTANCE.coerceTo(String.class, employeeList)).isEqualTo("[1,2,3]");
  }

  @Test
  public void localDateTimeToTimestamp() {
    LocalDateTime localDatetime = LocalDateTime.of(1995, FEBRUARY, 23, 20, 15);

    assertThat(INSTANCE.coerceTo(Timestamp.class, localDatetime))
        .isEqualTo(Timestamp.valueOf(localDatetime));
  }

  @Test
  public void textToString() {
    Text text = new Text("Hello World!");

    assertThat(INSTANCE.coerceTo(String.class, text)).isEqualTo("Hello World!");
  }

  @Test
  public void nullToInteger() {
    assertThat(INSTANCE.coerceTo(Integer.class, null)).isEqualTo(0);
  }

  @Test
  public void textToInteger() {
    Text text = new Text("51423");

    assertThat(INSTANCE.coerceTo(Integer.class, text)).isEqualTo(51423);
  }

  @Test
  public void longToInteger() {
    assertThat(INSTANCE.coerceTo(Integer.class, 56L)).isEqualTo(56);
  }

  @Test
  public void bigDecimalToInteger() {
    assertThat(INSTANCE.coerceTo(Integer.class, new BigDecimal("56"))).isEqualTo(56);
  }

  @Test
  public void nullToLong() {
    assertThat(INSTANCE.coerceTo(Long.class, null)).isEqualTo(0L);
  }

  @Test
  public void bigDecimalToLong() {
    assertThat(INSTANCE.coerceTo(Long.class, new BigDecimal("56"))).isEqualTo(56L);
  }

  @Test
  public void nullToDouble() {
    assertThat(INSTANCE.coerceTo(Double.class, null)).isEqualTo(0D);
  }

  @Test
  public void bigDecimalToDouble() {
    assertThat(INSTANCE.coerceTo(Double.class, new BigDecimal("56"))).isEqualTo(56D);
  }

  @Test
  public void nullToBoolean() {
    assertThat(INSTANCE.coerceTo(Boolean.class, null)).isFalse();
  }

  @Test
  public void nullToByteArray() {
    assertThat(INSTANCE.coerceTo(byte[].class, null)).isNull();
  }

  @Test
  public void nullToTimestamp() {
    assertThat(INSTANCE.coerceTo(Timestamp.class, null)).isNull();
  }

  @Test
  public void longToTimestamp() {
    assertThat(INSTANCE.coerceTo(Timestamp.class, 1408452095220000L))
        .isEqualTo(new Timestamp(1408452095220L));
  }

  @Test
  public void nullToTime() {
    assertThat(INSTANCE.coerceTo(Time.class, null)).isNull();
  }

  @Test
  public void longToTime() {
    assertThat(INSTANCE.coerceTo(Time.class, 1408452095220000L))
        .isEqualTo(new Time(1408452095000L));
  }

  @Test
  public void nullToDate() {
    assertThat(INSTANCE.coerceTo(Date.class, null)).isNull();
  }

  @Test
  public void integerToDate() {
    LocalDate expectedDate = LocalDate.of(2022, JANUARY, 1);
    assertThat(INSTANCE.coerceTo(Date.class, 18993).toLocalDate()).isEqualTo(expectedDate);
  }

  @Test
  public void periodDurationToString() {
    Period period = Period.of(1, 3, 24);
    Duration duration = Duration.ofHours(3).plusMinutes(45).plusSeconds(23).plusNanos(123456000);
    PeriodDuration periodDuration = new PeriodDuration(period, duration);
    assertThat(INSTANCE.coerceTo(String.class, periodDuration)).isEqualTo("1-3 24 3:45:23.123456");

    Period period2 = Period.of(1, 6, -8);
    Duration duration2 = Duration.ofHours(9).plusMinutes(43).plusSeconds(23).plusNanos(123456000);
    PeriodDuration periodDuration2 = new PeriodDuration(period2, duration2);
    assertThat(INSTANCE.coerceTo(String.class, periodDuration2)).isEqualTo("1-6 -8 9:43:23.123456");
  }

  // Range tests

  @Test
  public void JsonStringHashMapToString() {
    JsonStringHashMap<String, String> employeeMap = new JsonStringHashMap<>();
    employeeMap.putIfAbsent("name1", "type1");
    employeeMap.putIfAbsent("name2", "type2");
    employeeMap.putIfAbsent("name3", "type3");

    assertThat(INSTANCE.coerceTo(String.class, employeeMap))
        .isEqualTo("{\"name1\":\"type1\",\"name2\":\"type2\",\"name3\":\"type3\"}");
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
  public void rangeDatetimeToString() {
    String expectedRangeDate =
        String.format(
            "[%s, %s)",
            RANGE_DATETIME.getStart().getStringValue(), RANGE_DATETIME.getEnd().getStringValue());
    assertThat(INSTANCE.coerceTo(String.class, RANGE_DATETIME)).isEqualTo(expectedRangeDate);
  }

  @Test
  public void rangeTimestampToString() {
    String expectedRangeTimestamp =
        String.format(
            "[%s, %s)",
            RANGE_TIMESTAMP.getStart().getStringValue(), RANGE_TIMESTAMP.getEnd().getStringValue());
    assertThat(INSTANCE.coerceTo(String.class, RANGE_TIMESTAMP)).isEqualTo(expectedRangeTimestamp);
  }
}

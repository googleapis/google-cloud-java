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

import static com.google.common.truth.Truth.assertThat;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;
import org.junit.jupiter.api.Test;

public class BigQueryTemporalUtilityTest {

  @Test
  public void testGetSafeCalendar() {
    // Null returns default Calendar
    Calendar defaultCal = BigQueryTemporalUtility.getSafeCalendar(null);
    assertThat(defaultCal).isNotNull();
    assertThat(defaultCal.getTimeZone()).isEqualTo(TimeZone.getDefault());

    // Non-null returns defensive clone
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
    cal.setTimeInMillis(123456789L);
    Calendar cloned = BigQueryTemporalUtility.getSafeCalendar(cal);
    assertThat(cloned).isNotSameInstanceAs(cal);
    assertThat(cloned.getTimeInMillis()).isEqualTo(123456789L);
    assertThat(cloned.getTimeZone().getID()).isEqualTo("Asia/Tokyo");

    cloned.setTimeInMillis(999999999L);
    assertThat(cal.getTimeInMillis()).isEqualTo(123456789L);
  }

  @Test
  public void testConvertDateWithCalendar() {
    Date date = Date.valueOf("2026-08-24");
    Calendar cal = Calendar.getInstance();

    // Null checks
    assertThat(BigQueryTemporalUtility.convertDateWithCalendar(null, cal)).isNull();
    assertThat(BigQueryTemporalUtility.convertDateWithCalendar(date, null)).isSameInstanceAs(date);

    // Same timezone fast-path
    Calendar sameZoneCal = Calendar.getInstance(TimeZone.getDefault());
    assertThat(BigQueryTemporalUtility.convertDateWithCalendar(date, sameZoneCal))
        .isSameInstanceAs(date);

    // Different timezone
    Calendar tokyoCal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
    Date result = BigQueryTemporalUtility.convertDateWithCalendar(date, tokyoCal);
    long expectedMillis =
        LocalDate.of(2026, 8, 24).atStartOfDay(ZoneId.of("Asia/Tokyo")).toInstant().toEpochMilli();
    assertThat(result.getTime()).isEqualTo(expectedMillis);
  }

  @Test
  public void testConvertDateToCalendar() {
    Date date = Date.valueOf("2026-08-24");
    Calendar cal = Calendar.getInstance();

    // Null checks
    assertThat(BigQueryTemporalUtility.convertDateToCalendar(null, cal)).isNull();
    assertThat(BigQueryTemporalUtility.convertDateToCalendar(date, null)).isSameInstanceAs(date);

    // Same timezone fast-path
    Calendar sameZoneCal = Calendar.getInstance(TimeZone.getDefault());
    assertThat(BigQueryTemporalUtility.convertDateToCalendar(date, sameZoneCal))
        .isSameInstanceAs(date);

    // Different timezone
    ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
    Calendar tokyoCal = Calendar.getInstance(TimeZone.getTimeZone(tokyoZone));
    long tokyoMidnightMillis =
        LocalDate.of(2026, 8, 24).atStartOfDay(tokyoZone).toInstant().toEpochMilli();
    Date result =
        BigQueryTemporalUtility.convertDateToCalendar(new Date(tokyoMidnightMillis), tokyoCal);
    long expectedSystemMillis =
        LocalDate.of(2026, 8, 24).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    assertThat(result.getTime()).isEqualTo(expectedSystemMillis);
  }

  @Test
  public void testCrossTimezoneDateRoundtrip() {
    // Writer in Los Angeles (UTC-7), Reader in Tokyo (UTC+9) across the date line
    ZoneId writeZone = ZoneId.of("America/Los_Angeles");
    ZoneId readZone = ZoneId.of("Asia/Tokyo");
    Calendar writeCal = Calendar.getInstance(TimeZone.getTimeZone(writeZone));
    Calendar readCal = Calendar.getInstance(TimeZone.getTimeZone(readZone));

    Date inputDate =
        new Date(LocalDate.of(2026, 8, 24).atStartOfDay(writeZone).toInstant().toEpochMilli());
    Date normalizedDate = BigQueryTemporalUtility.convertDateToCalendar(inputDate, writeCal);
    Date readDate = BigQueryTemporalUtility.convertDateWithCalendar(normalizedDate, readCal);

    Calendar verifyCal = Calendar.getInstance(TimeZone.getTimeZone(readZone));
    verifyCal.setTime(readDate);
    assertThat(verifyCal.get(Calendar.YEAR)).isEqualTo(2026);
    assertThat(verifyCal.get(Calendar.MONTH)).isEqualTo(Calendar.AUGUST);
    assertThat(verifyCal.get(Calendar.DAY_OF_MONTH)).isEqualTo(24);
  }

  @Test
  public void testConvertTimeWithCalendar() {
    Time time = Time.valueOf("15:30:45");
    Calendar cal = Calendar.getInstance();

    // Null checks
    assertThat(BigQueryTemporalUtility.convertTimeWithCalendar(null, cal)).isNull();
    assertThat(BigQueryTemporalUtility.convertTimeWithCalendar(time, null)).isSameInstanceAs(time);

    // Same timezone fast-path
    Calendar sameZoneCal = Calendar.getInstance(TimeZone.getDefault());
    assertThat(BigQueryTemporalUtility.convertTimeWithCalendar(time, sameZoneCal))
        .isSameInstanceAs(time);

    // Different timezone
    Calendar utcCal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    Time result = BigQueryTemporalUtility.convertTimeWithCalendar(time, utcCal);
    Calendar resultCal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    resultCal.setTime(result);
    assertThat(resultCal.get(Calendar.YEAR)).isEqualTo(1970);
    assertThat(resultCal.get(Calendar.MONTH)).isEqualTo(Calendar.JANUARY);
    assertThat(resultCal.get(Calendar.DAY_OF_MONTH)).isEqualTo(1);
    assertThat(resultCal.get(Calendar.HOUR_OF_DAY)).isEqualTo(15);
    assertThat(resultCal.get(Calendar.MINUTE)).isEqualTo(30);
    assertThat(resultCal.get(Calendar.SECOND)).isEqualTo(45);
  }

  @Test
  public void testConvertTimestampWithCalendar() {
    Timestamp ts = Timestamp.valueOf("2026-08-24 15:30:45.123456789");
    Calendar cal = Calendar.getInstance();

    // Null checks
    assertThat(BigQueryTemporalUtility.convertTimestampWithCalendar(null, cal)).isNull();
    assertThat(BigQueryTemporalUtility.convertTimestampWithCalendar(ts, null)).isSameInstanceAs(ts);

    // Same timezone fast-path
    Calendar sameZoneCal = Calendar.getInstance(TimeZone.getDefault());
    assertThat(BigQueryTemporalUtility.convertTimestampWithCalendar(ts, sameZoneCal))
        .isSameInstanceAs(ts);

    // Different timezone preserves wall-clock shift and nanoseconds
    Calendar tokyoCal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
    Timestamp result = BigQueryTemporalUtility.convertTimestampWithCalendar(ts, tokyoCal);
    Instant expectedInstant =
        LocalDateTime.of(2026, 8, 24, 15, 30, 45, 123456789)
            .atZone(ZoneId.of("Asia/Tokyo"))
            .toInstant();
    assertThat(result.getTime()).isEqualTo(expectedInstant.toEpochMilli());
    assertThat(result.getNanos()).isEqualTo(123456789);
  }

  @Test
  public void testBoxDateTimeAndDate() {
    Timestamp ts =
        BigQueryTemporalUtility.boxDateTime("2026-08-24 15:30:45.123456", ZoneId.of("UTC"));
    LocalDateTime ldt = LocalDateTime.of(2026, 8, 24, 15, 30, 45, 123456000);
    assertThat(ts).isEqualTo(Timestamp.from(ldt.atZone(ZoneId.of("UTC")).toInstant()));

    Date date = BigQueryTemporalUtility.boxDate("2026-08-24", ZoneId.of("UTC"));
    long expectedDateMillis =
        LocalDate.of(2026, 8, 24).atStartOfDay(ZoneId.of("UTC")).toInstant().toEpochMilli();
    assertThat(date.getTime()).isEqualTo(expectedDateMillis);
  }

  @Test
  public void testBoxTime() {
    // Null zone (modern JSR-310)
    Time timeWithoutZone = BigQueryTemporalUtility.boxTime("15:30:45", null);
    long expectedTimeMillis =
        LocalTime.of(15, 30, 45)
            .atDate(LocalDate.of(1970, 1, 1))
            .atZone(ZoneId.systemDefault())
            .toInstant()
            .toEpochMilli();
    assertThat(timeWithoutZone.getTime()).isEqualTo(expectedTimeMillis);

    // Explicit zone (legacy Calendar 1970 mode)
    Time timeWithZone = BigQueryTemporalUtility.boxTime("15:30:45.123", ZoneId.of("UTC"));
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    cal.setTime(timeWithZone);
    assertThat(cal.get(Calendar.YEAR)).isEqualTo(1970);
    assertThat(cal.get(Calendar.HOUR_OF_DAY)).isEqualTo(15);
    assertThat(cal.get(Calendar.MILLISECOND)).isEqualTo(123);
  }

  @Test
  public void testBoxTimestamp() {
    // Numeric float with fractional nanos from JSON API
    Timestamp numericTs = BigQueryTemporalUtility.boxTimestamp("1680174859.8202269");
    assertThat(numericTs.getTime()).isEqualTo(1680174859820L);
    assertThat(numericTs.getNanos()).isEqualTo(820226900);

    // ISO string with " UTC" suffix
    Timestamp utcSuffixTs = BigQueryTemporalUtility.boxTimestamp("2026-08-24 15:30:45.123456 UTC");
    assertThat(utcSuffixTs).isEqualTo(Timestamp.from(Instant.parse("2026-08-24T15:30:45.123456Z")));

    // ISO string with 'Z'
    Timestamp zTs = BigQueryTemporalUtility.boxTimestamp("2026-08-24T15:30:45.123456Z");
    assertThat(zTs).isEqualTo(Timestamp.from(Instant.parse("2026-08-24T15:30:45.123456Z")));
  }
}

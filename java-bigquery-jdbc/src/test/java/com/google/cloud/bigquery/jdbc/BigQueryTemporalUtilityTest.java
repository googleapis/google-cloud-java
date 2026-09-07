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
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
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

    // 12-digit picosecond DATETIME string safely truncated to nanoseconds
    Timestamp picosDt =
        BigQueryTemporalUtility.boxDateTime("2026-08-24 15:30:45.123456789012", ZoneId.of("UTC"));
    assertThat(picosDt.getNanos()).isEqualTo(123456789);
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

    // 12-digit picosecond TIME string safely truncated to nanoseconds
    Time picosTime = BigQueryTemporalUtility.boxTime("15:30:45.123456789012", null);
    assertThat(picosTime).isNotNull();
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

    // 12-digit picosecond strings safely truncated to nanoseconds
    Timestamp picosTs = BigQueryTemporalUtility.boxTimestamp("1680174859.820226912345");
    assertThat(picosTs.getNanos()).isEqualTo(820226912);

    Timestamp picosIsoTs =
        BigQueryTemporalUtility.boxTimestamp("2026-08-24T15:30:45.123456789012Z");
    assertThat(picosIsoTs.getNanos()).isEqualTo(123456789);
  }

  @Test
  public void testParseEpochDecimalToInstant() {
    // Standard positive epoch decimal
    Instant inst6 = BigQueryTemporalUtility.parseEpochDecimalToInstant("1680174859.820226");
    assertThat(inst6.getEpochSecond()).isEqualTo(1680174859L);
    assertThat(inst6.getNano()).isEqualTo(820226000);

    // 12-digit picosecond decimal: sub-nanoseconds truncated
    Instant inst12 = BigQueryTemporalUtility.parseEpochDecimalToInstant("1680174859.820226123456");
    assertThat(inst12.getEpochSecond()).isEqualTo(1680174859L);
    assertThat(inst12.getNano()).isEqualTo(820226123);

    // Pre-1970 negative epoch decimal (-0.123456)
    Instant negInst = BigQueryTemporalUtility.parseEpochDecimalToInstant("-0.123456");
    assertThat(negInst.getEpochSecond()).isEqualTo(-1L);
    assertThat(negInst.getNano()).isEqualTo(876544000);

    // Pre-1970 negative epoch decimal with 12 digits: sub-nanoseconds truncated towards zero
    Instant negInst12 = BigQueryTemporalUtility.parseEpochDecimalToInstant("-0.123456789012");
    assertThat(negInst12.getEpochSecond()).isEqualTo(-1L);
    assertThat(negInst12.getNano()).isEqualTo(876543211);

    // Scientific notation
    Instant sciInst = BigQueryTemporalUtility.parseEpochDecimalToInstant("1.6905474E9");
    assertThat(sciInst.getEpochSecond()).isEqualTo(1690547400L);
    assertThat(sciInst.getNano()).isEqualTo(0);

    // Sub-second rollover prevention
    Instant rolloverInst =
        BigQueryTemporalUtility.parseEpochDecimalToInstant("1680174859.9999999999");
    assertThat(rolloverInst.getEpochSecond()).isEqualTo(1680174859L);
    assertThat(rolloverInst.getNano()).isEqualTo(999999999);
  }

  @Test
  public void testParseEpochDecimalToInstantInvalid() {
    assertThrows(
        NumberFormatException.class,
        () -> BigQueryTemporalUtility.parseEpochDecimalToInstant("invalid_epoch"));
  }

  @Test
  public void testFormatTimestampStringWithPicosEnabled() throws BigQueryJdbcException {
    // 12-digit picosecond decimal
    String formatted12 =
        BigQueryTemporalUtility.formatTimestampString("1680174859.820226123456", true);
    assertThat(formatted12).isEqualTo("2023-03-30 11:14:19.820226123456");

    // 6-digit microsecond decimal padded with 6 zeros to 12 digits
    String formatted6 = BigQueryTemporalUtility.formatTimestampString("1680174859.820226", true);
    assertThat(formatted6).isEqualTo("2023-03-30 11:14:19.820226000000");

    // Pre-1970 negative epoch decimal with 12 digits
    String negFormatted = BigQueryTemporalUtility.formatTimestampString("-0.123456789012", true);
    assertThat(negFormatted).isEqualTo("1969-12-31 23:59:59.876543210988");
  }

  @Test
  public void testFormatTimestampStringWithPicosDisabled() throws BigQueryJdbcException {
    // 6-digit microsecond decimal
    String formatted6 = BigQueryTemporalUtility.formatTimestampString("1680174859.820226", false);
    assertThat(formatted6).isEqualTo("2023-03-30 11:14:19.820226");

    // 12-digit picosecond decimal truncated to 6 digits
    String formatted12 =
        BigQueryTemporalUtility.formatTimestampString("1680174859.820226123456", false);
    assertThat(formatted12).isEqualTo("2023-03-30 11:14:19.820226");

    // Rollover prevention: .9999999 must truncate to .999999 and not roll over to next second
    String rollover = BigQueryTemporalUtility.formatTimestampString("1680174859.9999999", false);
    assertThat(rollover).isEqualTo("2023-03-30 11:14:19.999999");
  }

  @Test
  public void testFormatTimestampStringFromIso() throws BigQueryJdbcException {
    // ISO string with 'Z' and 12-digit picoseconds, picos enabled
    String iso12 =
        BigQueryTemporalUtility.formatTimestampStringFromIso(
            "2050-12-25T15:30:55.123456789012Z", true);
    assertThat(iso12).isEqualTo("2050-12-25 15:30:55.123456789012");

    // ISO string with 'Z' and 12-digit picoseconds, picos disabled (truncated to 6 digits)
    String iso6 =
        BigQueryTemporalUtility.formatTimestampStringFromIso(
            "2050-12-25T15:30:55.123456789012Z", false);
    assertThat(iso6).isEqualTo("2050-12-25 15:30:55.123456");

    // String with " UTC" suffix
    String utcSuffix =
        BigQueryTemporalUtility.formatTimestampStringFromIso(
            "2026-08-24 15:30:45.123456 UTC", false);
    assertThat(utcSuffix).isEqualTo("2026-08-24 15:30:45.123456");

    String utcSuffixPicos =
        BigQueryTemporalUtility.formatTimestampStringFromIso(
            "2026-08-24 15:30:45.123456 UTC", true);
    assertThat(utcSuffixPicos).isEqualTo("2026-08-24 15:30:45.123456000000");

    // String without fraction
    String noFraction =
        BigQueryTemporalUtility.formatTimestampStringFromIso("2026-08-24 15:30:45", false);
    assertThat(noFraction).isEqualTo("2026-08-24 15:30:45.000000");

    // String with offset shifted across day boundary
    String dayBoundary =
        BigQueryTemporalUtility.formatTimestampStringFromIso(
            "2026-08-24T01:30:00.123456789012+05:00", true);
    assertThat(dayBoundary).isEqualTo("2026-08-23 20:30:00.123456789012");

    // String with space before timezone offset (both positive and negative offsets)
    String spaceBeforeOffset =
        BigQueryTemporalUtility.formatTimestampStringFromIso(
            "2026-08-24 15:30:45.123456789012 +02:00", true);
    assertThat(spaceBeforeOffset).isEqualTo("2026-08-24 13:30:45.123456789012");

    String negativeOffset =
        BigQueryTemporalUtility.formatTimestampStringFromIso(
            "2026-08-24 15:30:45.123456789012 -05:00", true);
    assertThat(negativeOffset).isEqualTo("2026-08-24 20:30:45.123456789012");
  }

  @Test
  public void testFormatTimestampStringFromIsoInvalid() {
    assertThrows(
        BigQueryJdbcException.class,
        () -> BigQueryTemporalUtility.formatTimestampStringFromIso("invalid-date-time", true));
  }

  @Test
  public void testFormatTimestampStringFromMicroseconds() {
    // Standard positive microseconds (picos=false)
    String formatted =
        BigQueryTemporalUtility.formatTimestampStringFromMicroseconds(1680174859820226L, false);
    assertThat(formatted).isEqualTo("2023-03-30 11:14:19.820226");

    // Standard positive microseconds with picos=true (padded to 12 digits)
    String formattedPicos =
        BigQueryTemporalUtility.formatTimestampStringFromMicroseconds(1680174859820226L, true);
    assertThat(formattedPicos).isEqualTo("2023-03-30 11:14:19.820226000000");

    // Pre-1970 negative microsecond (-1 microsecond)
    String negOne = BigQueryTemporalUtility.formatTimestampStringFromMicroseconds(-1L, false);
    assertThat(negOne).isEqualTo("1969-12-31 23:59:59.999999");
  }
}

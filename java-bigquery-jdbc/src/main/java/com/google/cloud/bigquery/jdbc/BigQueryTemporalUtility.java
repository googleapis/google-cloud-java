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

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;

/**
 * A highly optimized utility for bridging BigQuery's civil time and absolute time semantics to
 * legacy JDBC Date/Time/Timestamp classes using JSR-310 timezone anchoring.
 */
final class BigQueryTemporalUtility {

  private BigQueryTemporalUtility() {}

  /**
   * Converts a BigQuery civil DATETIME string into an absolute Timestamp by anchoring it to the
   * provided timezone (or JVM default if null).
   */
  public static Timestamp boxDateTime(String val, ZoneId zoneId) {
    ZoneId targetZone = zoneId != null ? zoneId : ZoneId.systemDefault();
    String isoString = val.replace(' ', 'T');
    return Timestamp.from(LocalDateTime.parse(isoString).atZone(targetZone).toInstant());
  }

  /**
   * Converts a BigQuery civil DATE string into an absolute Date by anchoring it to midnight of the
   * provided timezone (or JVM default if null).
   */
  public static Date boxDate(String val, ZoneId zoneId) {
    ZoneId targetZone = zoneId != null ? zoneId : ZoneId.systemDefault();
    return new Date(LocalDate.parse(val).atStartOfDay(targetZone).toInstant().toEpochMilli());
  }

  /**
   * Converts a BigQuery civil TIME string into an absolute Time. If a ZoneId is provided (e.g. from
   * the legacy JDBC 3.0 getTime(col, Calendar) API), this uses legacy Calendar manipulation to
   * strictly mimic older JVM historical DST quirks for 1970. If no ZoneId is provided (e.g. modern
   * JDBC 4.2 getObject(col, LocalTime.class)), this uses pure JSR-310 math which guarantees
   * perfectly accurate modern conversions.
   */
  public static Time boxTime(String val, ZoneId zoneId) {
    LocalTime localTime = LocalTime.parse(val);

    if (zoneId == null) {
      // JDBC 4.2 Modern API (no Calendar provided):
      // Use pure JSR-310 math for perfectly accurate modern conversions without Calendar quirks.
      return new Time(
          localTime
              .atDate(LocalDate.of(1970, 1, 1))
              .atZone(ZoneId.systemDefault())
              .toInstant()
              .toEpochMilli());
    }

    // Legacy JDBC 3.0 API (Calendar provided):
    // Use legacy Calendar manipulation to intentionally replicate old JVM historical DST quirks
    // for January 1, 1970, ensuring strict backwards compatibility for legacy ORMs.
    Calendar targetCal = Calendar.getInstance(java.util.TimeZone.getTimeZone(zoneId));
    targetCal.set(Calendar.YEAR, 1970);
    targetCal.set(Calendar.MONTH, Calendar.JANUARY);
    targetCal.set(Calendar.DAY_OF_MONTH, 1);
    targetCal.set(Calendar.HOUR_OF_DAY, localTime.getHour());
    targetCal.set(Calendar.MINUTE, localTime.getMinute());
    targetCal.set(Calendar.SECOND, localTime.getSecond());
    targetCal.set(Calendar.MILLISECOND, localTime.getNano() / 1_000_000);

    return new Time(targetCal.getTimeInMillis());
  }

  /**
   * Converts a BigQuery absolute TIMESTAMP string into a legacy Timestamp. Because it is absolute,
   * the Calendar timezone is explicitly ignored per JDBC 4.2 spec.
   */
  public static Timestamp boxTimestamp(String val) {
    // Check if the value is a numeric float string (e.g. "1680174859.8202269" from JSON API)
    try {
      if (val.indexOf('-') < 0
          || (val.startsWith("-")
              && val.indexOf('-', 1) < 0)) { // Quick check to ensure it's not a date string
        BigDecimal bd = new BigDecimal(val);
        long secondsLong = bd.longValue();
        int nanos = bd.remainder(BigDecimal.ONE).multiply(new BigDecimal(1_000_000_000)).intValue();
        Timestamp ts = new Timestamp(secondsLong * 1000L);
        ts.setNanos(nanos);
        return ts;
      }
    } catch (NumberFormatException ignored) {
    }

    String iso = val;
    // Handle the " UTC" suffix format
    if (iso.endsWith(" UTC")) {
      iso = iso.substring(0, iso.length() - 4) + "Z";
    }
    // Replace the date-time space separator with 'T' (e.g. 2023-10-01 12:00:00 ->
    // 2023-10-01T12:00:00)
    if (iso.length() > 10 && iso.charAt(10) == ' ') {
      iso = iso.substring(0, 10) + 'T' + iso.substring(11);
    }
    // If it doesn't have a timezone designator, assume UTC 'Z'
    if (!iso.endsWith("Z") && !iso.contains("+") && iso.lastIndexOf('-') <= 10) {
      iso = iso + "Z";
    }

    try {
      return Timestamp.from(Instant.parse(iso));
    } catch (java.time.format.DateTimeParseException e) {
      // Fallback for non-standard formats
      String fallback = val;
      if (fallback.indexOf('T') > 0) {
        fallback = fallback.replace('T', ' ');
      }
      return Timestamp.valueOf(fallback);
    }
  }

  /**
   * Converts milliseconds of the day to a local epoch millis anchored to 1970-01-01 in the given
   * timezone.
   */
  public static long getLocalMillis(long millisOfDay, ZoneId zoneId) {
    ZoneId targetZone = zoneId != null ? zoneId : ZoneId.systemDefault();
    return LocalTime.ofNanoOfDay(millisOfDay * 1_000_000L)
        .atDate(LocalDate.of(1970, 1, 1))
        .atZone(targetZone)
        .toInstant()
        .toEpochMilli();
  }

  /** Returns a defensively cloned Calendar instance or a new default Calendar if input is null. */
  static Calendar getSafeCalendar(Calendar cal) {
    if (cal == null) {
      return Calendar.getInstance();
    }
    Object cloned = cal.clone();
    if (cloned instanceof Calendar) {
      return (Calendar) cloned;
    }
    Calendar safeCal = Calendar.getInstance();
    if (cal.getTimeZone() != null) {
      safeCal.setTimeZone(cal.getTimeZone());
    }
    return safeCal;
  }

  /**
   * Converts a {@link Date} for reading/outbound operations (e.g., {@code getDate(..., Calendar)})
   * by shifting its wall-clock year, month, and day fields into the target {@link Calendar}'s
   * timezone per the JDBC specification.
   *
   * @param date the date in system-default time representation
   * @param cal the target Calendar containing the desired timezone
   * @return the adjusted Date starting at 00:00:00 in the target Calendar's timezone
   */
  static Date convertDateWithCalendar(Date date, Calendar cal) {
    if (date == null || cal == null) {
      return date;
    }
    ZoneId systemZone = ZoneId.systemDefault();
    ZoneId targetZone = cal.getTimeZone().toZoneId();
    if (systemZone.equals(targetZone)) {
      return date;
    }
    LocalDate localDate = date.toLocalDate();
    ZonedDateTime zdt = localDate.atStartOfDay(targetZone);
    return new Date(zdt.toInstant().toEpochMilli());
  }

  /**
   * Converts a {@link Date} for writing/inbound parameter setting operations (e.g., {@code
   * setDate(..., Calendar)}) by extracting its local date fields as interpreted in the target
   * {@link Calendar}'s timezone and normalizing them back into start-of-day in the system-default
   * timezone.
   *
   * @param date the date instant specified relative to the target Calendar
   * @param cal the Calendar containing the source timezone
   * @return the normalized Date starting at 00:00:00 in the system-default timezone
   */
  static Date convertDateToCalendar(Date date, Calendar cal) {
    if (date == null || cal == null) {
      return date;
    }
    ZoneId systemZone = ZoneId.systemDefault();
    ZoneId targetZone = cal.getTimeZone().toZoneId();
    if (systemZone.equals(targetZone)) {
      return date;
    }
    LocalDate localDate = Instant.ofEpochMilli(date.getTime()).atZone(targetZone).toLocalDate();
    ZonedDateTime zdt = localDate.atStartOfDay(systemZone);
    return new Date(zdt.toInstant().toEpochMilli());
  }

  /**
   * Converts a java.sql.Time by shifting its wall-clock hour, minute, second, and millisecond
   * fields into the target Calendar's timezone per JDBC specification.
   */
  static Time convertTimeWithCalendar(Time time, Calendar cal) {
    if (time == null || cal == null) {
      return time;
    }
    ZoneId systemZone = ZoneId.systemDefault();
    ZoneId targetZone = cal.getTimeZone().toZoneId();
    if (systemZone.equals(targetZone)) {
      return time;
    }
    Calendar defaultCal = Calendar.getInstance();
    defaultCal.setTime(time);

    Calendar targetCal = getSafeCalendar(cal);
    targetCal.set(Calendar.YEAR, 1970);
    targetCal.set(Calendar.MONTH, Calendar.JANUARY);
    targetCal.set(Calendar.DAY_OF_MONTH, 1);
    targetCal.set(Calendar.HOUR_OF_DAY, defaultCal.get(Calendar.HOUR_OF_DAY));
    targetCal.set(Calendar.MINUTE, defaultCal.get(Calendar.MINUTE));
    targetCal.set(Calendar.SECOND, defaultCal.get(Calendar.SECOND));
    targetCal.set(Calendar.MILLISECOND, defaultCal.get(Calendar.MILLISECOND));
    return new Time(targetCal.getTimeInMillis());
  }

  /**
   * Converts a java.sql.Timestamp by shifting its wall-clock fields into the target Calendar's
   * timezone per JDBC specification while preserving nanosecond precision.
   */
  static Timestamp convertTimestampWithCalendar(Timestamp timestamp, Calendar cal) {
    if (timestamp == null || cal == null) {
      return timestamp;
    }
    ZoneId systemZone = ZoneId.systemDefault();
    ZoneId targetZone = cal.getTimeZone().toZoneId();
    if (systemZone.equals(targetZone)) {
      return timestamp;
    }
    LocalDateTime ldt = timestamp.toLocalDateTime();
    ZonedDateTime zdt = ldt.atZone(targetZone);
    Timestamp adjustedTimestamp = Timestamp.from(zdt.toInstant());
    adjustedTimestamp.setNanos(timestamp.getNanos());
    return adjustedTimestamp;
  }
}

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

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * A highly optimized utility for bridging BigQuery's civil time and absolute time semantics to
 * legacy JDBC Date/Time/Timestamp classes using JSR-310 timezone anchoring and high-precision
 * temporal formatting.
 */
final class BigQueryTemporalUtility {

  private static final BigDecimal PICOS_PER_SECOND = new BigDecimal("1000000000000");
  private static final BigDecimal NANOS_PER_SECOND = new BigDecimal("1000000000");
  private static final BigDecimal MICROS_PER_SECOND = new BigDecimal("1000000");
  private static final DateTimeFormatter BASE_FORMATTER =
      DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.");
  static final String TIMESTAMP_PICOSECONDS_TYPE_NAME = "TIMESTAMP_PICOSECONDS";

  private BigQueryTemporalUtility() {}

  /**
   * Converts a BigQuery civil DATETIME string into an absolute Timestamp by anchoring it to the
   * provided timezone (or JVM default if null).
   */
  public static Timestamp boxDateTime(String val, ZoneId zoneId) {
    ZoneId targetZone = zoneId != null ? zoneId : ZoneId.systemDefault();
    String isoString = truncateIsoFractionToNanos(val.replace(' ', 'T'));
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
    LocalTime localTime = LocalTime.parse(truncateIsoFractionToNanos(val));

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
    Calendar targetCal = Calendar.getInstance(TimeZone.getTimeZone(zoneId));
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
        return Timestamp.from(parseEpochDecimalToInstant(val));
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

    // Truncate sub-nanosecond fraction (> 9 digits) to prevent Instant.parse failure
    iso = truncateIsoFractionToNanos(iso);

    try {
      return Timestamp.from(Instant.parse(iso));
    } catch (DateTimeParseException e) {
      // Fallback for non-standard formats
      String fallback = val;
      if (fallback.indexOf('T') > 0) {
        fallback = fallback.replace('T', ' ');
      }
      return Timestamp.valueOf(fallback);
    }
  }

  /**
   * Converts an epoch decimal string (seconds since 1970-01-01 00:00:00 UTC) into an {@link
   * Instant}, truncating sub-nanosecond precision towards zero to prevent rollover or overflow.
   */
  static Instant parseEpochDecimalToInstant(String epochDecimal) {
    if (epochDecimal == null) {
      return null;
    }

    BigDecimal bd = new BigDecimal(epochDecimal).setScale(9, RoundingMode.DOWN);
    BigDecimal secondsBd = bd.setScale(0, RoundingMode.FLOOR);
    BigDecimal fractionBd = bd.subtract(secondsBd);
    int nanos = fractionBd.multiply(NANOS_PER_SECOND).intValue();
    return Instant.ofEpochSecond(secondsBd.longValue(), nanos);
  }

  /**
   * Formats an epoch decimal string (seconds since epoch) into a standard UTC JDBC timestamp string
   * formatted as {@code yyyy-MM-dd HH:mm:ss.ffffff} (if {@code enableTimestampPicos} is false) or
   * {@code yyyy-MM-dd HH:mm:ss.ffffffffffff} (if {@code enableTimestampPicos} is true). Truncates
   * deterministically towards zero to prevent sub-second rollover.
   */
  static String formatTimestampStringFromEpochDecimal(
      String epochDecimal, boolean enableTimestampPicos) throws BigQueryJdbcException {
    if (epochDecimal == null) {
      return null;
    }

    if (epochDecimal.indexOf(':') >= 0) {
      return formatTimestampStringFromIso(epochDecimal, enableTimestampPicos);
    }

    int scale = enableTimestampPicos ? 12 : 6;
    BigDecimal bd;
    try {
      bd = new BigDecimal(epochDecimal).setScale(scale, RoundingMode.DOWN);
    } catch (NumberFormatException e) {
      try {
        return formatTimestampStringFromIso(epochDecimal, enableTimestampPicos);
      } catch (BigQueryJdbcException ignored) {
        throw new BigQueryJdbcException("Invalid timestamp value: " + epochDecimal, e);
      }
    }

    BigDecimal secondsBd = bd.setScale(0, RoundingMode.FLOOR);
    long epochSeconds = secondsBd.longValue();
    BigDecimal fractionBd = bd.subtract(secondsBd);
    BigDecimal multiplier = scale == 12 ? PICOS_PER_SECOND : MICROS_PER_SECOND;
    long fractionVal = fractionBd.multiply(multiplier).setScale(0, RoundingMode.DOWN).longValue();

    LocalDateTime dt = LocalDateTime.ofEpochSecond(epochSeconds, 0, ZoneOffset.UTC);
    StringBuilder sb = formatDateTimeBase(dt, scale);
    appendPadded(sb, fractionVal, scale);
    return sb.toString();
  }

  /**
   * Normalizes an ISO-8601 or civil timestamp string into a standard UTC JDBC timestamp string
   * formatted with 6 or 12 fractional digits according to {@code enableTimestampPicos}.
   */
  static String formatTimestampStringFromIso(String isoString, boolean enableTimestampPicos)
      throws BigQueryJdbcException {
    if (isoString == null) {
      return null;
    }

    // 1. Separate fractional seconds (which may exceed 9 digits) from the base timestamp
    int dotIdx = isoString.indexOf('.');
    String fraction = "";
    String remaining = isoString;
    if (dotIdx >= 0) {
      int endFraction = dotIdx + 1;
      while (endFraction < isoString.length() && Character.isDigit(isoString.charAt(endFraction))) {
        endFraction++;
      }
      fraction = isoString.substring(dotIdx + 1, endFraction);
      remaining = isoString.substring(0, dotIdx) + isoString.substring(endFraction);
    }

    // 2. Normalize UTC suffixes
    String offsetPart = null;
    if (remaining.endsWith(" UTC")) {
      remaining = remaining.substring(0, remaining.length() - 4);
    } else if (remaining.endsWith("Z")) {
      remaining = remaining.substring(0, remaining.length() - 1);
    }

    // 3. Extract timezone offset (+/-) if present in the time portion
    int sepIdx = remaining.indexOf('T');
    if (sepIdx < 0) {
      sepIdx = remaining.indexOf(' ');
    }
    if (sepIdx >= 0) {
      int plusIdx = remaining.indexOf('+', sepIdx);
      int minusIdx = remaining.indexOf('-', sepIdx);
      int offsetIdx =
          plusIdx >= 0 && minusIdx >= 0
              ? Math.min(plusIdx, minusIdx)
              : (plusIdx >= 0 ? plusIdx : minusIdx);
      if (offsetIdx >= 0) {
        offsetPart = remaining.substring(offsetIdx).trim();
        remaining = remaining.substring(0, offsetIdx);
      }
    }

    // 4. Ensure standard ISO LocalDateTime format (YYYY-MM-DDTHH:mm:ss)
    remaining = remaining.trim().replace(' ', 'T');
    if (remaining.indexOf('T') < 0) {
      remaining = remaining + "T00:00:00";
    }

    // 5. Parse base date-time and shift to UTC if timezone offset was present
    LocalDateTime utcDt;
    try {
      LocalDateTime ldt = LocalDateTime.parse(remaining);
      if (offsetPart != null) {
        ZoneOffset offset = ZoneOffset.of(offsetPart);
        utcDt = ldt.atOffset(offset).withOffsetSameInstant(ZoneOffset.UTC).toLocalDateTime();
      } else {
        utcDt = ldt;
      }
    } catch (DateTimeException e) {
      throw new BigQueryJdbcException("Invalid timestamp format: " + isoString, e);
    }

    // 6. Build the normalized JDBC timestamp string with the requested scale
    int scale = enableTimestampPicos ? 12 : 6;
    StringBuilder sb = formatDateTimeBase(utcDt, scale);
    if (fraction.length() >= scale) {
      sb.append(fraction, 0, scale);
    } else {
      sb.append(fraction);
      for (int i = fraction.length(); i < scale; i++) {
        sb.append('0');
      }
    }
    return sb.toString();
  }

  /**
   * Formats a microsecond timestamp (microseconds since 1970-01-01 00:00:00 UTC) into standard UTC
   * timestamp string with 6 or 12 fractional digits according to {@code enableTimestampPicos}.
   */
  static String formatTimestampStringFromMicroseconds(
      long microseconds, boolean enableTimestampPicos) {
    long epochSeconds = Math.floorDiv(microseconds, 1_000_000L);
    long microsOfSecond = Math.floorMod(microseconds, 1_000_000L);

    LocalDateTime dt = LocalDateTime.ofEpochSecond(epochSeconds, 0, ZoneOffset.UTC);
    int scale = enableTimestampPicos ? 12 : 6;
    StringBuilder sb = formatDateTimeBase(dt, scale);
    long fractionVal = enableTimestampPicos ? microsOfSecond * 1_000_000L : microsOfSecond;
    appendPadded(sb, fractionVal, scale);
    return sb.toString();
  }

  /**
   * Formats a timestamp value (which may be a {@link Long} epoch microsecond, an ISO-8601 string, a
   * {@link java.sql.Timestamp}, or an epoch decimal string) into a standard UTC JDBC timestamp
   * string with 6 or 12 fractional digits according to {@code enableTimestampPicos}.
   */
  static String formatTimestampValue(Object value, boolean enableTimestampPicos)
      throws BigQueryJdbcException {
    if (value == null) {
      return null;
    }
    if (value instanceof Long) {
      return formatTimestampStringFromMicroseconds((Long) value, enableTimestampPicos);
    }
    String str = value.toString();
    if (str.indexOf(':') >= 0) {
      return formatTimestampStringFromIso(str, enableTimestampPicos);
    }
    return formatTimestampStringFromEpochDecimal(str, enableTimestampPicos);
  }

  static boolean isPicosecondTimestamp(Field field) {
    return field != null
        && field.getType() != null
        && field.getType().getStandardType() == StandardSQLTypeName.TIMESTAMP
        && field.getTimestampPrecision() != null
        && field.getTimestampPrecision() > 6;
  }

  private static StringBuilder formatDateTimeBase(LocalDateTime dt, int scale) {
    StringBuilder sb = new StringBuilder(scale == 12 ? 32 : 26);
    BASE_FORMATTER.formatTo(dt, sb);
    return sb;
  }

  /**
   * Truncates sub-second fractional digits to at most 9 digits (nanoseconds) so that standard JDK
   * temporal parsers (which cap at nanosecond precision) can parse the string without throwing
   * {@link java.time.format.DateTimeParseException}. Any trailing timezone offset or suffix is
   * preserved intact.
   */
  private static String truncateIsoFractionToNanos(String iso) {
    int dotIdx = iso.indexOf('.');
    if (dotIdx < 0) {
      return iso;
    }

    int fractionStart = dotIdx + 1;
    int fractionEnd = fractionStart;
    while (fractionEnd < iso.length() && Character.isDigit(iso.charAt(fractionEnd))) {
      fractionEnd++;
    }

    int fractionDigits = fractionEnd - fractionStart;
    if (fractionDigits <= 9) {
      return iso;
    }

    // Retain the first 9 fractional digits and append any trailing suffix (e.g., 'Z' or offset)
    return iso.substring(0, fractionStart + 9) + iso.substring(fractionEnd);
  }

  /**
   * Appends a non-negative integer zero-padded to {@code width} digits directly into the {@link
   * StringBuilder} without intermediate string allocations.
   */
  private static void appendPadded(StringBuilder sb, long val, int width) {
    int end = sb.length() + width;
    sb.setLength(end);
    for (int i = end - 1; i >= end - width; i--) {
      sb.setCharAt(i, (char) ('0' + (val % 10)));
      val /= 10;
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
    return (Calendar) cal.clone();
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

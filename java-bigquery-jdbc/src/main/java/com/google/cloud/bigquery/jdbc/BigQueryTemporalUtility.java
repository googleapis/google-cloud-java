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

import com.google.common.base.Strings;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * A highly optimized utility for bridging BigQuery's civil time and absolute time semantics to
 * legacy JDBC Date/Time/Timestamp classes using JSR-310 timezone anchoring.
 */
final class BigQueryTemporalUtility {

  private static final DateTimeFormatter UTC_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC);

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
   * Truncates a BigQuery timestamp string to 9 fractional digits (nanoseconds) because
   * Instant.parse throws DateTimeParseException for >9 digits, and java.sql.Timestamp maxes out at
   * nanos anyway.
   */
  private static String truncateToNanoseconds(String iso) {
    int dotIdx = iso.indexOf('.');
    // Fast path: if there is no dot or at most 9 fractional digits after the dot, return as-is.
    if (dotIdx == -1 || iso.length() - dotIdx <= 10) {
      return iso;
    }

    int fractionEnd = dotIdx + 1;
    while (fractionEnd < iso.length() && Character.isDigit(iso.charAt(fractionEnd))) {
      fractionEnd++;
    }
    if (fractionEnd - dotIdx - 1 > 9) {
      return iso.substring(0, dotIdx + 10) + iso.substring(fractionEnd);
    }
    return iso;
  }

  /**
   * Converts a BigQuery absolute TIMESTAMP string into a legacy Timestamp. Because it is absolute,
   * the Calendar timezone is explicitly ignored per JDBC 4.2 spec.
   */
  public static Timestamp boxTimestamp(String val) {
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

    iso = truncateToNanoseconds(iso);

    try {
      return Timestamp.from(Instant.parse(iso));
    } catch (java.time.format.DateTimeParseException e) {
      // Fallback for non-standard formats
      return Timestamp.valueOf(truncateToNanoseconds(val));
    }
  }

  /**
   * Parses a numeric epoch decimal string (e.g. from BigQuery REST JSON) into a JSR-310 {@link
   * Instant}. Sub-nanosecond precision is deterministically truncated (floor/down) rather than
   * rounded to avoid boundary rollovers.
   */
  public static Instant parseEpochDecimalToInstant(String epochDecimal) {
    if (epochDecimal == null) {
      return null;
    }
    BigDecimal bd = new BigDecimal(epochDecimal);
    long seconds = bd.setScale(0, RoundingMode.FLOOR).longValue();
    long nanos =
        bd.subtract(BigDecimal.valueOf(seconds))
            .movePointRight(9)
            .setScale(0, RoundingMode.DOWN)
            .longValue();
    return Instant.ofEpochSecond(seconds, nanos);
  }

  /**
   * Formats a numeric epoch decimal string into standard SQL timestamp string format ("yyyy-MM-dd
   * HH:mm:ss.ffffff"). Sub-microsecond precision is deterministically truncated (down) to prevent
   * timestamp boundary rollovers.
   */
  public static String formatTimestampString(String epochDecimal) {
    return formatTimestampString(epochDecimal, false);
  }

  /**
   * Formats a numeric epoch decimal string into standard SQL timestamp string format ("yyyy-MM-dd
   * HH:mm:ss.ffffff[ffffff]"). Sub-microsecond / sub-picosecond precision is deterministically
   * truncated (down) to prevent timestamp boundary rollovers.
   */
  public static String formatTimestampString(String epochDecimal, boolean enableTimestampPicos) {
    if (epochDecimal == null) {
      return null;
    }

    BigDecimal bd = new BigDecimal(epochDecimal);
    long seconds = bd.setScale(0, RoundingMode.FLOOR).longValue();
    BigDecimal fractionalSeconds = bd.subtract(BigDecimal.valueOf(seconds));

    int originalScale = bd.scale() > 0 ? bd.scale() : 0;
    int scale = enableTimestampPicos ? Math.max(6, Math.min(12, originalScale)) : 6;

    String fraction =
        fractionalSeconds.setScale(scale, RoundingMode.DOWN).toPlainString().substring(2);

    Instant instant = Instant.ofEpochSecond(seconds);
    return UTC_FORMATTER.format(instant) + "." + fraction;
  }

  public static String formatTimestampStringFromMicroseconds(long microseconds) {
    long seconds = Math.floorDiv(microseconds, 1000000L);
    long micros = Math.floorMod(microseconds, 1000000L);

    String fraction = Strings.padStart(Long.toString(micros), 6, '0');
    Instant instant = Instant.ofEpochSecond(seconds);
    return UTC_FORMATTER.format(instant) + "." + fraction;
  }

  public static String formatTimestampStringFromIso(
      String isoString, boolean enableTimestampPicos) {
    if (isoString == null) {
      return null;
    }

    String s = isoString;
    if (s.endsWith(" UTC")) {
      s = s.substring(0, s.length() - 4);
    } else if (s.endsWith("Z")) {
      s = s.substring(0, s.length() - 1);
    }

    if (s.length() > 10 && s.charAt(10) == 'T') {
      s = s.substring(0, 10) + ' ' + s.substring(11);
    }

    int dotIdx = s.indexOf('.');
    if (dotIdx == -1) {
      return s + ".000000";
    }

    String base = s.substring(0, dotIdx);
    String fraction = s.substring(dotIdx + 1);

    int maxScale = enableTimestampPicos ? 12 : 6;
    if (fraction.length() > maxScale) {
      fraction = fraction.substring(0, maxScale);
    } else if (fraction.length() < 6) {
      fraction = Strings.padEnd(fraction, 6, '0');
    }

    return base + "." + fraction;
  }
}

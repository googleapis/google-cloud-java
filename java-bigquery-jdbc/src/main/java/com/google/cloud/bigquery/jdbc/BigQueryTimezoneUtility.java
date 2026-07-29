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

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * A highly optimized utility for bridging BigQuery's civil time and absolute time semantics to
 * legacy JDBC Date/Time/Timestamp classes using JSR-310 timezone anchoring.
 */
final class BigQueryTimezoneUtility {

  private BigQueryTimezoneUtility() {}

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
   * Converts a BigQuery civil TIME string into an absolute Time by anchoring it to Jan 1, 1970 of
   * the provided timezone (or JVM default if null).
   */
  public static Time boxTime(String val, ZoneId zoneId) {
    ZoneId targetZone = zoneId != null ? zoneId : ZoneId.systemDefault();
    return new Time(
        LocalTime.parse(val)
            .atDate(LocalDate.of(1970, 1, 1))
            .atZone(targetZone)
            .toInstant()
            .toEpochMilli());
  }

  /**
   * Converts a BigQuery absolute TIMESTAMP string into a legacy Timestamp. Because it is absolute,
   * the Calendar timezone is explicitly ignored per JDBC 4.2 spec.
   */
  public static Timestamp boxTimestamp(String val) {
    if (val.contains("T") || val.contains("Z")) {
      return Timestamp.from(Instant.parse(val));
    }
    return Timestamp.valueOf(val);
  }
}

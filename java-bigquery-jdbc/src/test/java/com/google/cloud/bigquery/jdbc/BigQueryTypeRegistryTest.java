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
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.apache.arrow.vector.PeriodDuration;
import org.junit.jupiter.api.Test;

public class BigQueryTypeRegistryTest {

  @Test
  public void testIntervalFormatting() throws Exception {
    Period p = Period.of(1, 2, 3);
    Duration d =
        Duration.ofHours(4).plusMinutes(5).plusSeconds(6).plusNanos(78000); // 78 microseconds
    PeriodDuration pd = new PeriodDuration(p, d);
    String result =
        BigQueryTypeRegistry.convert(pd, StandardSQLTypeName.INTERVAL, String.class, null);
    assertThat(result).isEqualTo("1-2 3 4:05:06.000078");
  }

  @Test
  public void testIntervalFormattingZeroMicroseconds() throws Exception {
    Period p = Period.of(0, 0, 0);
    Duration d = Duration.ofHours(1).plusMinutes(0).plusSeconds(0);
    PeriodDuration pd = new PeriodDuration(p, d);
    String result =
        BigQueryTypeRegistry.convert(pd, StandardSQLTypeName.INTERVAL, String.class, null);
    assertThat(result).isEqualTo("0-0 0 1:00:00");
  }

  @Test
  public void testIntervalFormattingNegativeDuration() throws Exception {
    Period p = Period.of(0, 0, 0);
    Duration d = Duration.ofHours(-1).minusMinutes(5).minusSeconds(6).minusNanos(78000);
    PeriodDuration pd = new PeriodDuration(p, d);
    String result =
        BigQueryTypeRegistry.convert(pd, StandardSQLTypeName.INTERVAL, String.class, null);
    assertThat(result).isEqualTo("0-0 0 -1:05:06.000078");
  }

  @Test
  public void testDateFormatting() throws Exception {
    LocalDate localDate = LocalDate.of(2026, 8, 24);
    assertThat(
            BigQueryTypeRegistry.convert(localDate, StandardSQLTypeName.DATE, String.class, null))
        .isEqualTo("2026-08-24");
    assertThat(BigQueryTypeRegistry.convert(localDate, StandardSQLTypeName.DATE, Date.class, null))
        .isEqualTo(Date.valueOf("2026-08-24"));
  }

  @Test
  public void testTimeFormatting() throws Exception {
    LocalTime localTime = LocalTime.of(15, 30, 45, 123456000); // 123.456 ms
    assertThat(
            BigQueryTypeRegistry.convert(localTime, StandardSQLTypeName.TIME, String.class, null))
        .isEqualTo("15:30:45.123456");
    assertThat(BigQueryTypeRegistry.convert(localTime, StandardSQLTypeName.TIME, Time.class, null))
        .isEqualTo(Time.valueOf("15:30:45"));
  }

  @Test
  public void testDatetimeFormatting() throws Exception {
    LocalDateTime localDateTime = LocalDateTime.of(2026, 8, 24, 15, 30, 45, 123456000);
    assertThat(
            BigQueryTypeRegistry.convert(
                localDateTime, StandardSQLTypeName.DATETIME, String.class, null))
        .isEqualTo("2026-08-24T15:30:45.123456");
    assertThat(
            BigQueryTypeRegistry.convert(
                localDateTime, StandardSQLTypeName.DATETIME, Timestamp.class, null))
        .isEqualTo(Timestamp.valueOf("2026-08-24 15:30:45.123456"));
  }

  @Test
  public void testTimestampFormatting() throws Exception {
    ZonedDateTime zonedDateTime =
        ZonedDateTime.of(2026, 8, 24, 15, 30, 45, 123456000, ZoneId.of("UTC"));
    assertThat(
            BigQueryTypeRegistry.convert(
                zonedDateTime, StandardSQLTypeName.TIMESTAMP, String.class, null))
        .isEqualTo("2026-08-24T15:30:45.123456Z[UTC]");
  }

  @Test
  public void testCoercionException() throws Exception {
    assertThrows(
        BigQueryJdbcException.class,
        () ->
            BigQueryTypeRegistry.convert(
                "bad_number", StandardSQLTypeName.INT64, Integer.class, null));
  }
}

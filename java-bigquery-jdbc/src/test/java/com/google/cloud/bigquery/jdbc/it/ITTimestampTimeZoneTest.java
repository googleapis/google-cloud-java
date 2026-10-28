/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.it;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.bigquery.QueryJobConfiguration;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Timestamp time zone behaviour under several JVM default zones. Write tests pass the parameter
 * straight into a server-side function, so each assertion shows exactly what BigQuery received.
 */
public class ITTimestampTimeZoneTest extends ITBase {

  private static final Instant REF = Instant.parse("2025-01-01T12:34:56.123Z");
  private static final String REF_UTC_STRING = "2025-01-01 12:34:56.123";
  private static final LocalDateTime DT_DIGITS = LocalDateTime.parse("2025-01-01T12:34:56.123");
  private static final LocalDate D_DIGITS = LocalDate.parse("2025-01-01");
  private static final LocalTime T_DIGITS = LocalTime.parse("12:34:56");
  private static final Instant TS_MIN = Instant.parse("0001-01-01T00:00:00Z");

  // Never one of the JVM zones under test, so the Calendar always differs from the JVM zone.
  private static final ZoneId CAL_ZONE = ZoneId.of("Asia/Tokyo");

  private static final String READ_SQL =
      // Pre-1582 and pre-standard-time values.
      "SELECT TIMESTAMP '0001-01-01 00:00:00 UTC' AS ts_min, DATETIME '0001-01-01 00:00:00' AS"
          + " dt_min, DATE '0001-01-01' AS d_min, DATETIME '1850-06-01 12:00:00' AS dt_1850,"
          + " DATE '1850-06-01' AS d_1850, DATE '1582-10-10' AS d_gap,"
          + " TIMESTAMP '2025-01-01 12:34:56.123 UTC' AS ts,"
          + " DATETIME '2025-01-01 12:34:56.123' AS dt,"
          + " DATE '2025-01-01' AS d,"
          + " TIME '12:34:56' AS t,"
          + " [TIMESTAMP '2025-01-01 12:34:56.123 UTC'] AS ts_array,"
          + " STRUCT(TIMESTAMP '2025-01-01 12:34:56.123 UTC' AS ts) AS ts_struct,"
          // REST API sends these as scientific notation ("1.0E-6", "-1.0E-6").
          + " TIMESTAMP '1970-01-01 00:00:00.000001 UTC' AS ts_post_epoch,"
          + " TIMESTAMP '1969-12-31 23:59:59.999999 UTC' AS ts_pre_epoch";

  // Same coercion as an INSERT into a TIMESTAMP column, for TIMESTAMP and STRING parameters.
  private static final String PROBE_TIMESTAMP = "SELECT UNIX_MILLIS(CAST(? AS TIMESTAMP))";

  private static final String PROBE_DATETIME = "SELECT CAST(CAST(? AS DATETIME) AS STRING)";
  private static final String PROBE_DATE = "SELECT CAST(CAST(? AS DATE) AS STRING)";
  private static final String PROBE_TIME = "SELECT CAST(CAST(? AS TIME) AS STRING)";

  private static final DateTimeFormatter TIME_DIGITS = DateTimeFormatter.ofPattern("HH:mm:ss");

  private static final String INSERT_TABLE = "JDBC_IT_TIMESTAMP_TZ_" + new Random().nextInt(99999);
  private static String DATASET;

  private TimeZone originalJvmZone;

  private static Stream<String> jvmZones() {
    return Stream.of("UTC", "America/New_York", "Asia/Kolkata", "Pacific/Auckland");
  }

  @BeforeAll
  public static void createInsertTable() throws InterruptedException {
    DATASET = ITBase.getSharedDataset();
    bigQuery.query(
        QueryJobConfiguration.of(
            String.format(
                "CREATE OR REPLACE TABLE `%s.%s.%s` (id INT64, ts TIMESTAMP, dt DATETIME)",
                DEFAULT_CATALOG, DATASET, INSERT_TABLE)));
  }

  @AfterAll
  public static void dropInsertTable() throws InterruptedException {
    if (DATASET != null) {
      bigQuery.query(
          QueryJobConfiguration.of(
              String.format(
                  "DROP TABLE IF EXISTS `%s.%s.%s`", DEFAULT_CATALOG, DATASET, INSERT_TABLE)));
    }
  }

  @BeforeEach
  public void saveJvmZone() {
    originalJvmZone = TimeZone.getDefault();
  }

  @AfterEach
  public void restoreJvmZone() {
    TimeZone.setDefault(originalJvmZone);
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testSetTimestamp_storesSameMoment(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        PreparedStatement ps = conn.prepareStatement(PROBE_TIMESTAMP)) {
      ps.setTimestamp(1, Timestamp.from(REF));
      assertEquals(REF, storedInstant(ps), label(zone, "setTimestamp must store the same moment"));
    }
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testSetObjectTimestamp_storesSameMoment(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        PreparedStatement ps = conn.prepareStatement(PROBE_TIMESTAMP)) {
      ps.setObject(1, Timestamp.from(REF));
      assertEquals(
          REF, storedInstant(ps), label(zone, "setObject(Timestamp) must store the same moment"));
    }
  }

  /** The Calendar cannot change the moment of a TIMESTAMP. */
  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testSetTimestampWithCalendar_storesSameMoment(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        PreparedStatement ps = conn.prepareStatement(PROBE_TIMESTAMP)) {
      assertAll(
          setTimestampWithCalendar(ps, zone, "UTC"),
          setTimestampWithCalendar(ps, zone, "Asia/Kolkata"),
          setTimestampWithCalendar(ps, zone, "Pacific/Auckland"),
          setTimestampWithCalendar(ps, zone, "America/Chicago"));
    }
  }

  private static Executable setTimestampWithCalendar(
      PreparedStatement ps, String zone, String calZone) {
    return () -> {
      ps.setTimestamp(1, Timestamp.from(REF), calendar(ZoneId.of(calZone)));
      assertEquals(
          REF,
          storedInstant(ps),
          label(zone, "setTimestamp(ts, cal=" + calZone + ") must store the same moment"));
    };
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testSetObjectInstant_storesSameMoment(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        PreparedStatement ps = conn.prepareStatement(PROBE_TIMESTAMP)) {
      ps.setObject(1, REF);
      assertEquals(
          REF, storedInstant(ps), label(zone, "setObject(Instant) must store the same moment"));
    }
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testSetObjectOffsetDateTime_storesSameMoment(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        PreparedStatement ps = conn.prepareStatement(PROBE_TIMESTAMP)) {
      ps.setObject(1, REF.atOffset(ZoneOffset.ofHoursMinutes(5, 30)));
      assertEquals(
          REF,
          storedInstant(ps),
          label(zone, "setObject(OffsetDateTime +05:30) must store the same moment"));
    }
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testSetObjectZonedDateTime_storesSameMoment(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        PreparedStatement ps = conn.prepareStatement(PROBE_TIMESTAMP)) {
      ps.setObject(1, REF.atZone(ZoneId.of("Asia/Kolkata")));
      assertEquals(
          REF,
          storedInstant(ps),
          label(zone, "setObject(ZonedDateTime Asia/Kolkata) must store the same moment"));
    }
  }

  /**
   * {@code Time.valueOf("12:34:56")} in New York is 17:34:56Z, so with a UTC Calendar BigQuery must
   * receive 17:34:56.
   */
  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testSetTimeWithCalendar_sendsTimeInCalendarZone(String zone) throws SQLException {
    useJvmZone(zone);
    Time time = Time.valueOf("12:34:56");
    String expected =
        Instant.ofEpochMilli(time.getTime()).atZone(ZoneOffset.UTC).format(TIME_DIGITS);
    try (Connection conn = connect();
        PreparedStatement ps = conn.prepareStatement(PROBE_TIME)) {
      ps.setTime(1, time, calendar(ZoneOffset.UTC));
      assertEquals(
          expected,
          storedString(ps),
          label(zone, "setTime(t, cal=UTC) must send the time of t in the Calendar's zone"));
    }
  }

  /**
   * Midnight of 2025-01-01 in Kolkata or Auckland is still 2024-12-31 in UTC. A historical date
   * read with getDate(col, cal) and bound back with setDate(i, d, cal) must arrive unchanged.
   */
  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testSetDateWithCalendar_sendsDateInCalendarZone(String zone) throws SQLException {
    useJvmZone(zone);
    Date date = Date.valueOf(D_DIGITS);
    String expected =
        Instant.ofEpochMilli(date.getTime()).atZone(ZoneOffset.UTC).toLocalDate().toString();
    Calendar cal = calendar(CAL_ZONE);
    try (Connection conn = connect();
        PreparedStatement ps = conn.prepareStatement(PROBE_DATE);
        Statement read = conn.createStatement();
        ResultSet rs =
            read.executeQuery("SELECT DATE '0001-01-01' AS d_min, DATE '1850-06-01' AS d_1850")) {
      ps.setDate(1, date, calendar(ZoneOffset.UTC));
      assertEquals(
          expected,
          storedString(ps),
          label(zone, "setDate(d, cal=UTC) must send the date of d in the Calendar's zone"));
      assertTrue(rs.next());
      ps.setDate(1, rs.getDate("d_min", cal), cal);
      assertEquals("0001-01-01", storedString(ps), label(zone, "d_min round trip, cal"));
      ps.setDate(1, rs.getDate("d_1850", cal), cal);
      assertEquals("1850-06-01", storedString(ps), label(zone, "d_1850 round trip, cal"));
    }
  }

  /** BigQuery reads a timestamp string without an offset as UTC. */
  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testSetString_isReadAsUtc(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        PreparedStatement ps = conn.prepareStatement(PROBE_TIMESTAMP)) {
      ps.setString(1, REF_UTC_STRING);
      assertEquals(REF, storedInstant(ps), label(zone, "setString must be read as UTC"));
    }
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testSetStringWithOffset_storesSameMoment(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        PreparedStatement ps = conn.prepareStatement(PROBE_TIMESTAMP)) {
      ps.setString(1, "2025-01-01T07:34:56.123-05:00");
      assertEquals(
          REF, storedInstant(ps), label(zone, "setString with an offset must keep that offset"));
    }
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testSetDateAndSetTime_sendDigits(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        PreparedStatement date = conn.prepareStatement(PROBE_DATE);
        PreparedStatement time = conn.prepareStatement(PROBE_TIME)) {
      date.setDate(1, Date.valueOf(D_DIGITS));
      time.setTime(1, Time.valueOf(T_DIGITS));
      assertAll(
          () -> assertEquals("2025-01-01", storedString(date), label(zone, "setDate digits")),
          () -> assertEquals("12:34:56", storedString(time), label(zone, "setTime digits")));
    }
  }

  /** 1582-10-10 is what getObject(LocalDate) returns for DATE '1582-10-10'; it must round-trip. */
  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testSetObjectJavaTime_sendsDigits(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        PreparedStatement dateTime = conn.prepareStatement(PROBE_DATETIME);
        PreparedStatement date = conn.prepareStatement(PROBE_DATE);
        PreparedStatement time = conn.prepareStatement(PROBE_TIME)) {
      dateTime.setObject(1, DT_DIGITS);
      date.setObject(1, LocalDate.of(1582, 10, 10));
      time.setObject(1, LocalTime.of(12, 34, 56, 789_123_000));
      assertAll(
          () ->
              assertEquals(
                  "2025-01-01 12:34:56.123",
                  storedString(dateTime),
                  label(zone, "setObject(LocalDateTime) must send its digits")),
          () ->
              assertEquals(
                  "1582-10-10", storedString(date), label(zone, "setObject(LocalDate) digits")),
          () ->
              assertEquals(
                  "12:34:56.789123", storedString(time), label(zone, "setObject(LocalTime)")));
    }
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testGetTimestampAndGetObject_returnMoment(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = readRow(stmt)) {
      assertAll(
          () ->
              assertEquals(
                  REF,
                  rs.getTimestamp("ts").toInstant(),
                  label(zone, "getTimestamp must return the stored moment")),
          () ->
              assertEquals(
                  Timestamp.from(REF),
                  rs.getObject("ts"),
                  label(zone, "getObject must return a Timestamp of the stored moment")),
          () ->
              assertEquals(
                  Instant.parse("1970-01-01T00:00:00.000001Z"),
                  rs.getTimestamp("ts_post_epoch").toInstant(),
                  label(zone, "getTimestamp just after the epoch")),
          () ->
              assertEquals(
                  Instant.parse("1969-12-31T23:59:59.999999Z"),
                  rs.getTimestamp("ts_pre_epoch").toInstant(),
                  label(zone, "getTimestamp just before the epoch")));
    }
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testGetObjectInstantAndOffsetDateTime_returnMoment(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = readRow(stmt)) {
      assertAll(
          () ->
              assertEquals(
                  REF,
                  rs.getObject("ts", Instant.class),
                  label(zone, "getObject(Instant) must return the stored moment")),
          () ->
              assertEquals(
                  REF,
                  rs.getObject("ts", OffsetDateTime.class).toInstant(),
                  label(zone, "getObject(OffsetDateTime) must return the stored moment")));
    }
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testLocalViewsOfTimestamp_useJvmZone(String zone) throws SQLException {
    useJvmZone(zone);
    ZonedDateTime local = REF.atZone(ZoneId.of(zone));
    try (Connection conn = connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = readRow(stmt)) {
      assertAll(
          () ->
              assertEquals(
                  local.toLocalDateTime(),
                  rs.getObject("ts", LocalDateTime.class),
                  label(zone, "getObject(LocalDateTime) on TIMESTAMP")),
          () ->
              assertEquals(
                  local.toLocalDate(),
                  rs.getDate("ts").toLocalDate(),
                  label(zone, "getDate on TIMESTAMP")),
          () ->
              assertEquals(
                  local.toLocalTime().withNano(0),
                  rs.getTime("ts").toLocalTime(),
                  label(zone, "getTime on TIMESTAMP")),
          () ->
              assertEquals(
                  TS_MIN.atZone(ZoneId.of(zone)).toLocalDateTime(),
                  rs.getObject("ts_min", LocalDateTime.class),
                  label(zone, "getObject(LocalDateTime) on pre-1582 TIMESTAMP")),
          () ->
              assertEquals(
                  TS_MIN.atZone(ZoneId.of(zone)).toLocalDate(),
                  rs.getObject("ts_min", LocalDate.class),
                  label(zone, "getObject(LocalDate) on pre-1582 TIMESTAMP")));
    }
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testWallClockTypes_returnDigits(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = readRow(stmt)) {
      assertAll(
          () ->
              assertEquals(
                  "2025-01-01 12:34:56.123000",
                  rs.getString("dt"),
                  label(zone, "getString on DATETIME")),
          () ->
              assertEquals(
                  DT_DIGITS,
                  rs.getObject("dt", LocalDateTime.class),
                  label(zone, "getObject(LocalDateTime) on DATETIME")),
          () ->
              assertEquals(
                  DT_DIGITS,
                  rs.getTimestamp("dt").toLocalDateTime(),
                  label(zone, "getTimestamp on DATETIME")),
          () ->
              assertEquals(
                  D_DIGITS, rs.getDate("dt").toLocalDate(), label(zone, "getDate on DATETIME")),
          () ->
              assertEquals(
                  T_DIGITS, rs.getTime("dt").toLocalTime(), label(zone, "getTime on DATETIME")),
          () ->
              assertEquals(D_DIGITS, rs.getDate("d").toLocalDate(), label(zone, "getDate on DATE")),
          () ->
              assertEquals(T_DIGITS, rs.getTime("t").toLocalTime(), label(zone, "getTime on TIME")),
          () -> assertHistoricDigits(rs, zone, "dt_min", "d_min", "0001-01-01T00:00"),
          () -> assertHistoricDigits(rs, zone, "dt_1850", "d_1850", "1850-06-01T12:00"),
          () ->
              assertEquals(
                  LocalDateTime.parse("0001-01-01T00:00").atZone(ZoneId.of(zone)).toInstant(),
                  rs.getObject("dt_min", Instant.class),
                  label(zone, "getObject(Instant) on pre-1582 DATETIME")),
          () -> assertEquals("1582-10-10", rs.getString("d_gap"), label(zone, "d_gap")),
          () ->
              assertEquals(
                  LocalDate.parse("1582-10-10"),
                  rs.getObject("d_gap", LocalDate.class),
                  label(zone, "d_gap")));
    }
  }

  private static void assertHistoricDigits(
      ResultSet rs, String zone, String dtColumn, String dColumn, String dateTime) {
    LocalDateTime dt = LocalDateTime.parse(dateTime);
    LocalDate d = dt.toLocalDate();
    assertAll(
        () -> assertEquals(dt, rs.getObject(dtColumn, LocalDateTime.class), label(zone, dtColumn)),
        () -> assertEquals(dt, rs.getTimestamp(dtColumn).toLocalDateTime(), label(zone, dtColumn)),
        () ->
            assertEquals(
                dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")),
                rs.getString(dtColumn),
                label(zone, dtColumn)),
        () -> assertEquals(d, rs.getObject(dColumn, LocalDate.class), label(zone, dColumn)),
        () -> assertEquals(d, rs.getDate(dColumn).toLocalDate(), label(zone, dColumn)),
        () -> assertEquals(d.toString(), rs.getString(dColumn), label(zone, dColumn)));
  }

  /** For DATETIME, DATE and TIME the Calendar is the zone the digits are interpreted in. */
  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testCalendarGettersOnWallClockTypes_useCalendarZone(String zone) throws SQLException {
    useJvmZone(zone);
    Calendar cal = calendar(CAL_ZONE);
    try (Connection conn = connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = readRow(stmt)) {
      assertAll(
          () ->
              assertEquals(
                  DT_DIGITS.atZone(CAL_ZONE).toInstant(),
                  rs.getTimestamp("dt", cal).toInstant(),
                  label(zone, "getTimestamp(DATETIME, cal)")),
          () ->
              assertEquals(
                  D_DIGITS,
                  inCalendarZone(rs.getDate("dt", cal).getTime()).toLocalDate(),
                  label(zone, "getDate(DATETIME, cal)")),
          () ->
              assertEquals(
                  DT_DIGITS.toLocalTime().withNano(0),
                  inCalendarZone(rs.getTime("dt", cal).getTime()).toLocalTime().withNano(0),
                  label(zone, "getTime(DATETIME, cal)")),
          () ->
              assertEquals(
                  D_DIGITS,
                  inCalendarZone(rs.getDate("d", cal).getTime()).toLocalDate(),
                  label(zone, "getDate(DATE, cal)")),
          () ->
              assertEquals(
                  T_DIGITS,
                  inCalendarZone(rs.getTime("t", cal).getTime()).toLocalTime().withNano(0),
                  label(zone, "getTime(TIME, cal)")),
          () ->
              assertEquals(
                  "0001-01-01",
                  calendarDate(rs.getDate("d_min", cal).getTime()),
                  label(zone, "d_min, cal")),
          () ->
              assertEquals(
                  "1850-06-01",
                  calendarDate(rs.getDate("d_1850", cal).getTime()),
                  label(zone, "d_1850, cal")),
          () ->
              assertEquals(
                  "1850-06-01",
                  calendarDate(rs.getTimestamp("dt_1850", cal).getTime()),
                  label(zone, "dt_1850, cal")));
    }
  }

  private static String calendarDate(long epochMillis) {
    Calendar c = calendar(CAL_ZONE);
    c.setTimeInMillis(epochMillis);
    return String.format(
        "%04d-%02d-%02d", c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DATE));
  }

  /** A TIMESTAMP is already a moment, so the Calendar does not change the result. */
  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testCalendarGettersOnTimestamp_matchNoCalendarGetters(String zone)
      throws SQLException {
    useJvmZone(zone);
    Calendar cal = calendar(CAL_ZONE);
    ZonedDateTime local = REF.atZone(ZoneId.of(zone));
    try (Connection conn = connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = readRow(stmt)) {
      assertAll(
          () ->
              assertEquals(
                  REF,
                  rs.getTimestamp("ts", cal).toInstant(),
                  label(zone, "getTimestamp(TIMESTAMP, cal)")),
          () ->
              assertEquals(
                  local.toLocalDate(),
                  rs.getDate("ts", cal).toLocalDate(),
                  label(zone, "getDate(TIMESTAMP, cal)")),
          () ->
              assertEquals(
                  local.toLocalTime().withNano(0),
                  rs.getTime("ts", cal).toLocalTime(),
                  label(zone, "getTime(TIMESTAMP, cal)")));
    }
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testGetString_returnsUtcDigits(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = readRow(stmt)) {
      assertAll(
          () ->
              assertEquals(
                  "2025-01-01 12:34:56.123000",
                  rs.getString("ts"),
                  label(zone, "getString on TIMESTAMP must return UTC digits")),
          () ->
              assertEquals(
                  "[2025-01-01 12:34:56.123]",
                  rs.getString("ts_array"),
                  label(zone, "getString on ARRAY<TIMESTAMP> must return UTC digits")),
          () ->
              assertEquals(
                  "{\"ts\":\"2025-01-01 12:34:56.123\"}",
                  rs.getString("ts_struct"),
                  label(zone, "getString on STRUCT<TIMESTAMP> must return UTC digits")),
          () ->
              assertEquals(
                  "1970-01-01 00:00:00.000001",
                  rs.getString("ts_post_epoch"),
                  label(zone, "getString just after the epoch")),
          () ->
              assertEquals(
                  "1969-12-31 23:59:59.999999",
                  rs.getString("ts_pre_epoch"),
                  label(zone, "getString just before the epoch")));
    }
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testRoundTrip_getTimestampThenSetTimestamp(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = readRow(stmt);
        PreparedStatement ps = conn.prepareStatement(PROBE_TIMESTAMP)) {
      ps.setTimestamp(1, rs.getTimestamp("ts"));
      assertEquals(
          REF, storedInstant(ps), label(zone, "getTimestamp -> setTimestamp must not move"));
    }
  }

  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  public void testRoundTrip_getStringThenSetString(String zone) throws SQLException {
    useJvmZone(zone);
    try (Connection conn = connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = readRow(stmt);
        PreparedStatement ps = conn.prepareStatement(PROBE_TIMESTAMP)) {
      ps.setString(1, rs.getString("ts"));
      assertEquals(REF, storedInstant(ps), label(zone, "getString -> setString must not move"));
    }
  }

  /** Confirms the TIMESTAMP probe behaves like a real INSERT. */
  @Test
  public void testInsertWithSetTimestamp_storesSameMoment() throws SQLException {
    String zone = "America/New_York";
    useJvmZone(zone);
    String table = String.format("`%s.%s.%s`", DEFAULT_CATALOG, DATASET, INSERT_TABLE);
    try (Connection conn = connect();
        PreparedStatement insert =
            conn.prepareStatement("INSERT INTO " + table + " (id, ts) VALUES (1, ?)");
        PreparedStatement select =
            conn.prepareStatement("SELECT UNIX_MILLIS(ts) FROM " + table + " WHERE id = 1")) {
      insert.setTimestamp(1, Timestamp.from(REF));
      assertEquals(1, insert.executeUpdate());
      assertEquals(
          REF, storedInstant(select), label(zone, "INSERT via setTimestamp must store the moment"));
    }
  }

  /**
   * {@code CAST(? AS DATETIME)} also accepts a TIMESTAMP parameter, so only a real INSERT shows
   * whether a {@code LocalDateTime} can be stored in a DATETIME column.
   */
  @Test
  public void testInsertWithSetObjectLocalDateTime_storesDigits() throws SQLException {
    String zone = "America/New_York";
    useJvmZone(zone);
    String table = String.format("`%s.%s.%s`", DEFAULT_CATALOG, DATASET, INSERT_TABLE);
    try (Connection conn = connect();
        PreparedStatement insert =
            conn.prepareStatement("INSERT INTO " + table + " (id, dt) VALUES (2, ?)");
        PreparedStatement select =
            conn.prepareStatement("SELECT CAST(dt AS STRING) FROM " + table + " WHERE id = 2")) {
      insert.setObject(1, DT_DIGITS);
      assertEquals(1, insert.executeUpdate());
      assertEquals(
          "2025-01-01 12:34:56.123",
          storedString(select),
          label(zone, "INSERT via setObject(LocalDateTime) must store its digits"));
    }
  }

  private static void useJvmZone(String zone) {
    TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of(zone)));
  }

  private static Connection connect() throws SQLException {
    return DriverManager.getConnection(connectionUrl);
  }

  private static ResultSet readRow(Statement stmt) throws SQLException {
    ResultSet rs = stmt.executeQuery(READ_SQL);
    assertTrue(rs.next(), "Reference row must exist");
    return rs;
  }

  /**
   * Reads {@code UNIX_MILLIS} via {@code getLong}, so no driver temporal conversion is involved.
   */
  private static Instant storedInstant(PreparedStatement ps) throws SQLException {
    try (ResultSet rs = ps.executeQuery()) {
      assertTrue(rs.next(), "Probe must return a row");
      return Instant.ofEpochMilli(rs.getLong(1));
    }
  }

  private static String storedString(PreparedStatement ps) throws SQLException {
    try (ResultSet rs = ps.executeQuery()) {
      assertTrue(rs.next(), "Probe must return a row");
      return rs.getString(1);
    }
  }

  private static Calendar calendar(ZoneId zone) {
    return Calendar.getInstance(TimeZone.getTimeZone(zone));
  }

  private static ZonedDateTime inCalendarZone(long epochMillis) {
    return Instant.ofEpochMilli(epochMillis).atZone(CAL_ZONE);
  }

  private static String label(String zone, String rule) {
    return "[JVM " + zone + "] " + rule;
  }
}

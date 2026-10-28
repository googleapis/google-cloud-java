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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.bigquery.QueryJobConfiguration;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Tag("disable_tpc")
public class ITJdbcTimestampPicosTest extends ITBase {

  private static final Random RANDOM = new Random();
  private static final int RANDOM_SUFFIX = RANDOM.nextInt(99999);
  private static final String TABLE_NAME = "JDBC_IT_PICOS_TEST_" + RANDOM_SUFFIX;
  private static final String INSERT_TABLE_NAME = "JDBC_IT_PICOS_INSERT_" + RANDOM_SUFFIX;
  private static String DATASET;

  private static final String TIMESTAMP_MODERN_STANDARD = "2025-01-01 12:34:56.123456";
  private static final String TIMESTAMP_MODERN_PICOS = "2025-01-01 12:34:56.123456789123";

  private static final String TIMESTAMP_PRE1970_STANDARD = "1969-07-20 20:17:40.123456";
  private static final String TIMESTAMP_PRE1970_PICOS = "1969-07-20 20:17:40.123456789123";

  private static final String TIMESTAMP_MAX_STANDARD = "9999-12-31 23:59:59.123456";
  private static final String TIMESTAMP_MAX_PICOS = "9999-12-31 23:59:59.123456789123";

  private static final String TIMESTAMP_BOUNDARY_STANDARD = "2025-06-15 10:20:30.999999";
  private static final String TIMESTAMP_BOUNDARY_PICOS = "2025-06-15 10:20:30.999999999999";

  private static final String DDL_CREATE_PICOS_TABLE =
      "CREATE OR REPLACE TABLE `%1$s.%2$s.%3$s` (\n"
          + "  id INT64,\n"
          + "  description STRING,\n"
          + "  ts_standard TIMESTAMP,\n"
          + "  ts_picos TIMESTAMP(12),\n"
          + "  ts_array ARRAY<TIMESTAMP(12)>,\n"
          + "  ts_struct STRUCT<picos_field TIMESTAMP(12), tag STRING>\n"
          + ");\n";

  private static final String DML_INSERT_PICOS_ROWS =
      "INSERT INTO `%1$s.%2$s.%3$s` (id, description, ts_standard, ts_picos, ts_array, ts_struct) VALUES\n"
          + "(1, 'Modern timestamp', TIMESTAMP '"
          + TIMESTAMP_MODERN_STANDARD
          + "', TIMESTAMP '"
          + TIMESTAMP_MODERN_PICOS
          + "', [TIMESTAMP '"
          + TIMESTAMP_MODERN_PICOS
          + "', TIMESTAMP '2025-01-02 00:00:00.000000000001'], STRUCT(TIMESTAMP '"
          + TIMESTAMP_MODERN_PICOS
          + "', 'tag1')),\n"
          + "(2, 'Pre-1970 negative epoch', TIMESTAMP '"
          + TIMESTAMP_PRE1970_STANDARD
          + "', TIMESTAMP '"
          + TIMESTAMP_PRE1970_PICOS
          + "', [TIMESTAMP '"
          + TIMESTAMP_PRE1970_PICOS
          + "'], STRUCT(TIMESTAMP '"
          + TIMESTAMP_PRE1970_PICOS
          + "', 'tag2')),\n"
          + "(3, 'Max boundary year 9999', TIMESTAMP '"
          + TIMESTAMP_MAX_STANDARD
          + "', TIMESTAMP '"
          + TIMESTAMP_MAX_PICOS
          + "', [TIMESTAMP '"
          + TIMESTAMP_MAX_PICOS
          + "'], STRUCT(TIMESTAMP '"
          + TIMESTAMP_MAX_PICOS
          + "', 'tag3')),\n"
          + "(4, 'Sub-microsecond truncation', TIMESTAMP '"
          + TIMESTAMP_BOUNDARY_STANDARD
          + "', TIMESTAMP '"
          + TIMESTAMP_BOUNDARY_PICOS
          + "', [TIMESTAMP '"
          + TIMESTAMP_BOUNDARY_PICOS
          + "'], STRUCT(TIMESTAMP '"
          + TIMESTAMP_BOUNDARY_PICOS
          + "', 'tag4'));\n";

  private static final String DDL_CREATE_INSERT_TABLE =
      "CREATE OR REPLACE TABLE `%1$s.%2$s.%3$s` (\n"
          + "  id INT64,\n"
          + "  ts_val TIMESTAMP(12),\n"
          + "  ts_nano TIMESTAMP(12)\n"
          + ");\n";

  // Row ids 100.. are reserved for the per-zone insert round-trip test; each invocation inserts
  // and reads back its own row. Row ids 200.. are reserved for the per-zone batch test, five per
  // invocation. The setString test uses 300.
  private static final AtomicInteger NEXT_ROUND_TRIP_ROW_ID = new AtomicInteger(100);
  private static final AtomicInteger NEXT_BATCH_ROW_ID = new AtomicInteger(200);
  private static final int BATCH_SIZE = 5;

  private TimeZone originalJvmZone;

  private static Stream<String> jvmZones() {
    return Stream.of("UTC", "America/New_York", "Asia/Kolkata", "Pacific/Auckland");
  }

  /**
   * Every JVM zone crossed with both result-set implementations, so a regression that only affects
   * the Arrow (Storage Read API) deserializer is caught as well as one in the REST/JSON path.
   */
  private static Stream<Arguments> jvmZonesAndReadPaths() {
    return jvmZones()
        .flatMap(zone -> Stream.of(Arguments.of(zone, false), Arguments.of(zone, true)));
  }

  @BeforeAll
  public static void setUpTestFixtures() throws InterruptedException {
    DATASET = ITBase.getSharedDataset();

    String createTableSql =
        String.format(DDL_CREATE_PICOS_TABLE, DEFAULT_CATALOG, DATASET, TABLE_NAME);
    bigQuery.query(QueryJobConfiguration.of(createTableSql));

    String insertRowsSql =
        String.format(DML_INSERT_PICOS_ROWS, DEFAULT_CATALOG, DATASET, TABLE_NAME);
    bigQuery.query(QueryJobConfiguration.of(insertRowsSql));

    String createInsertTableSql =
        String.format(DDL_CREATE_INSERT_TABLE, DEFAULT_CATALOG, DATASET, INSERT_TABLE_NAME);
    bigQuery.query(QueryJobConfiguration.of(createInsertTableSql));
  }

  @AfterAll
  public static void tearDownTestFixtures() throws InterruptedException {
    if (bigQuery != null && DATASET != null) {
      String dropTableSql =
          String.format("DROP TABLE IF EXISTS `%s.%s.%s`", DEFAULT_CATALOG, DATASET, TABLE_NAME);
      bigQuery.query(QueryJobConfiguration.of(dropTableSql));

      String dropInsertTableSql =
          String.format(
              "DROP TABLE IF EXISTS `%s.%s.%s`", DEFAULT_CATALOG, DATASET, INSERT_TABLE_NAME);
      bigQuery.query(QueryJobConfiguration.of(dropInsertTableSql));
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

  private static void useJvmZone(String zone) {
    TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of(zone)));
  }

  private static String label(String zone, String rule) {
    return "[JVM " + zone + "] " + rule;
  }

  private static String getPicosConnectionUrl(boolean picosEnabled, boolean arrowEnabled) {
    return ITBase.connectionUrl
        + "EnableTimestampPicos="
        + (picosEnabled ? "1" : "0")
        + ";"
        + (arrowEnabled
            ? ITBase.FORCE_READ_API_PROPERTIES + "MaxResults=1;"
            : "EnableHighThroughputAPI=0;");
  }

  /**
   * Guards against a silent fallback to the REST/JSON path when the Arrow path was requested, which
   * would let the remaining assertions pass without ever exercising Arrow deserialization.
   */
  private static void assertReadPath(ResultSet rs, boolean arrowExpected, String zone) {
    boolean isArrow = rs.getClass().getName().contains("BigQueryArrowResultSet");
    assertEquals(
        arrowExpected,
        isArrow,
        label(
            zone,
            (arrowExpected ? "expected the Arrow path" : "expected the JSON path")
                + " but got "
                + rs.getClass().getSimpleName()));
  }

  @Test
  public void testDefaultBehavior_picosDisabled_returnsMicrosecondsAndTimestampType()
      throws SQLException {
    String url = getPicosConnectionUrl(false, false);
    String query =
        String.format(
            "SELECT id, ts_standard, ts_picos FROM `%s.%s.%s` WHERE id = 1",
            DEFAULT_CATALOG, DATASET, TABLE_NAME);

    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query)) {

      assertTrue(rs.next());
      assertEquals(TIMESTAMP_MODERN_STANDARD, rs.getString("ts_standard"));
      // When EnableTimestampPicos is false, picosecond columns truncate to 6 digits
      assertEquals(TIMESTAMP_MODERN_STANDARD, rs.getString("ts_picos"));

      Object obj = rs.getObject("ts_picos");
      assertTrue(obj instanceof Timestamp, "getObject must return java.sql.Timestamp by default");

      ResultSetMetaData meta = rs.getMetaData();
      assertEquals(Types.TIMESTAMP, meta.getColumnType(3));
      assertEquals("TIMESTAMP", meta.getColumnTypeName(3));
      assertEquals(Timestamp.class.getName(), meta.getColumnClassName(3));
      assertEquals(26, meta.getColumnDisplaySize(3));
      assertEquals(6, meta.getScale(3));
    }
  }

  @Test
  @Tag("advanced") // asserts our internal Arrow result set type
  public void testPicosecondsEnabled_arrowPath_preserves12Digits() throws SQLException {
    String url = getPicosConnectionUrl(true, true);
    String query =
        String.format(
            "SELECT id, ts_standard, ts_picos FROM `%s.%s.%s` ORDER BY id ASC",
            DEFAULT_CATALOG, DATASET, TABLE_NAME);

    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query)) {

      // Guard against a silent fallback to the REST JSON path, which would make the remaining
      // assertions pass without ever exercising Arrow deserialization.
      assertTrue(
          rs.getClass().getName().contains("BigQueryArrowResultSet"),
          "Expected the Storage Read API (Arrow) path but got: " + rs.getClass().getName());

      // Row 1: Modern timestamp
      assertTrue(rs.next());
      assertEquals(1, rs.getInt("id"));
      assertEquals(TIMESTAMP_MODERN_STANDARD, rs.getString("ts_standard"));
      assertEquals(TIMESTAMP_MODERN_PICOS, rs.getString("ts_picos"));
      Object obj1 = rs.getObject("ts_picos");
      assertTrue(obj1 instanceof String, "getObject must return String for TIMESTAMP(12)");
      assertEquals(TIMESTAMP_MODERN_PICOS, obj1);
      Timestamp ts1 = rs.getTimestamp("ts_picos");
      assertNotNull(ts1);
      assertEquals(123456789, ts1.getNanos());

      // Row 2: Pre-1970 negative epoch
      assertTrue(rs.next());
      assertEquals(2, rs.getInt("id"));
      assertEquals(TIMESTAMP_PRE1970_PICOS, rs.getString("ts_picos"));

      // Row 3: Max year 9999
      assertTrue(rs.next());
      assertEquals(3, rs.getInt("id"));
      assertEquals(TIMESTAMP_MAX_PICOS, rs.getString("ts_picos"));

      // Row 4: Boundary sub-microsecond truncation without second rollover
      assertTrue(rs.next());
      assertEquals(4, rs.getInt("id"));
      assertEquals(TIMESTAMP_BOUNDARY_PICOS, rs.getString("ts_picos"));
    }
  }

  @Test
  public void testPicosecondsEnabled_restJsonPath_preserves12Digits() throws SQLException {
    String url = getPicosConnectionUrl(true, false);
    String query =
        String.format(
            "SELECT id, ts_standard, ts_picos FROM `%s.%s.%s` ORDER BY id ASC",
            DEFAULT_CATALOG, DATASET, TABLE_NAME);

    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query)) {

      // Row 1
      assertTrue(rs.next());
      assertEquals(1, rs.getInt("id"));
      assertEquals(TIMESTAMP_MODERN_STANDARD, rs.getString("ts_standard"));
      assertEquals(TIMESTAMP_MODERN_PICOS, rs.getString("ts_picos"));
      assertEquals(TIMESTAMP_MODERN_PICOS, rs.getObject("ts_picos"));

      // Row 2
      assertTrue(rs.next());
      assertEquals(2, rs.getInt("id"));
      assertEquals(TIMESTAMP_PRE1970_PICOS, rs.getString("ts_picos"));

      // Row 3
      assertTrue(rs.next());
      assertEquals(3, rs.getInt("id"));
      assertEquals(TIMESTAMP_MAX_PICOS, rs.getString("ts_picos"));

      // Row 4
      assertTrue(rs.next());
      assertEquals(4, rs.getInt("id"));
      assertEquals(TIMESTAMP_BOUNDARY_PICOS, rs.getString("ts_picos"));
    }
  }

  @Test
  @Tag("advanced")
  public void testComplexTypes_arrayAndStruct_preserve12Digits() throws SQLException {
    String url = getPicosConnectionUrl(true, false);
    String query =
        String.format(
            "SELECT id, ts_array, ts_struct FROM `%s.%s.%s` WHERE id = 1",
            DEFAULT_CATALOG, DATASET, TABLE_NAME);

    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query)) {

      assertTrue(rs.next());

      Array array = rs.getArray("ts_array");
      assertNotNull(array);
      Object[] elements = (Object[]) array.getArray();
      assertEquals(2, elements.length);
      assertEquals(TIMESTAMP_MODERN_PICOS, elements[0]);
      assertEquals("2025-01-02 00:00:00.000000000001", elements[1]);

      Object structObj = rs.getObject("ts_struct");
      assertNotNull(structObj);
      if (structObj instanceof Struct) {
        Struct struct = (Struct) structObj;
        Object[] attrs = struct.getAttributes();
        assertEquals(TIMESTAMP_MODERN_PICOS, attrs[0]);
      }
    }
  }

  @Test
  @Tag("advanced") // We report precision 32, not 65535
  public void testResultSetMetaData_picosEnabled() throws SQLException {
    String url = getPicosConnectionUrl(true, false);
    String query =
        String.format(
            "SELECT id, ts_standard, ts_picos FROM `%s.%s.%s` LIMIT 1",
            DEFAULT_CATALOG, DATASET, TABLE_NAME);

    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query)) {

      ResultSetMetaData meta = rs.getMetaData();

      // ts_standard
      assertEquals(Types.TIMESTAMP, meta.getColumnType(2));
      assertEquals("TIMESTAMP", meta.getColumnTypeName(2));
      assertEquals(26, meta.getColumnDisplaySize(2));
      assertEquals(6, meta.getScale(2));

      // ts_picos
      assertEquals(Types.VARCHAR, meta.getColumnType(3));
      assertEquals("TIMESTAMP_PICOSECONDS", meta.getColumnTypeName(3));
      assertEquals(String.class.getName(), meta.getColumnClassName(3));
      assertEquals(32, meta.getColumnDisplaySize(3));
      assertEquals(32, meta.getPrecision(3));
      assertEquals(12, meta.getScale(3));
    }
  }

  @Test
  @Tag("advanced") // We report COLUMN_SIZE 32, not 65535
  public void testDatabaseMetaData_getColumns_picosEnabled() throws SQLException {
    String url = getPicosConnectionUrl(true, false);

    try (Connection conn = DriverManager.getConnection(url)) {
      DatabaseMetaData dbmd = conn.getMetaData();
      try (ResultSet rs = dbmd.getColumns(DEFAULT_CATALOG, DATASET, TABLE_NAME, "ts_picos")) {
        assertTrue(rs.next(), "Column metadata for ts_picos must exist");
        assertEquals("ts_picos", rs.getString("COLUMN_NAME"));
        assertEquals(Types.VARCHAR, rs.getInt("DATA_TYPE"));
        assertEquals("TIMESTAMP_PICOSECONDS", rs.getString("TYPE_NAME"));
        assertEquals(32, rs.getInt("COLUMN_SIZE"));
        assertEquals(12, rs.getInt("DECIMAL_DIGITS"));
      }

      try (ResultSet rs = dbmd.getColumns(DEFAULT_CATALOG, DATASET, TABLE_NAME, "ts_standard")) {
        assertTrue(rs.next(), "Column metadata for ts_standard must exist");
        assertEquals("ts_standard", rs.getString("COLUMN_NAME"));
        assertEquals(Types.TIMESTAMP, rs.getInt("DATA_TYPE"));
        assertEquals("TIMESTAMP", rs.getString("TYPE_NAME"));
      }
    }
  }

  /**
   * BigQuery truncates {@code TIMESTAMP}-typed query parameters to microseconds, even against a
   * {@code TIMESTAMP(12)} column (b/419328655). Update the expectations when the backend fix lands.
   *
   * <p>Runs under several JVM default zones and over both result-set implementations to prove the
   * stored moment and the UTC rendering depend on neither where the client runs nor how it reads.
   */
  @ParameterizedTest(name = "JVM zone {0}")
  @MethodSource("jvmZones")
  @Tag("advanced") // Relies on this driver's TIMESTAMP parameter conversion.
  public void testPreparedStatement_insertRoundTrip_backendTruncatesToMicroseconds(String zone)
      throws SQLException {
    useJvmZone(zone);
    int rowId = NEXT_ROUND_TRIP_ROW_ID.getAndIncrement();
    String url = getPicosConnectionUrl(true, false);
    String insertSql =
        String.format(
            "INSERT INTO `%s.%s.%s` (id, ts_val, ts_nano) VALUES (?, ?, ?)",
            DEFAULT_CATALOG, DATASET, INSERT_TABLE_NAME);
    String selectSql =
        String.format(
            "SELECT id, ts_val, ts_nano FROM `%s.%s.%s` WHERE id = %d",
            DEFAULT_CATALOG, DATASET, INSERT_TABLE_NAME, rowId);

    // Both parameters denote the same UTC instant. BigQuery reads a zone-less string as UTC, so
    // the java.sql.Timestamp is built from an explicit UTC Instant rather than Timestamp.valueOf,
    // which would interpret the digits in the JVM default zone and store a different instant.
    String picosInsertVal = "2026-08-10 15:30:45.123456789012";
    Timestamp nanoTimestamp = Timestamp.from(Instant.parse("2026-08-10T15:30:45.123456789Z"));
    // What the backend actually keeps after truncating the parameter to microseconds.
    Instant expectedStoredInstant = Instant.parse("2026-08-10T15:30:45.123456Z");
    String expectedUtcString = "2026-08-10 15:30:45.123456000000";

    try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement ps = conn.prepareStatement(insertSql)) {
      ps.setInt(1, rowId);
      ps.setObject(2, picosInsertVal, Types.TIMESTAMP);
      ps.setTimestamp(3, nanoTimestamp);
      assertEquals(1, ps.executeUpdate(), label(zone, "one row inserted"));
    }

    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql)) {
      assertTrue(rs.next(), label(zone, "inserted row must exist"));
      assertEquals(rowId, rs.getInt("id"));

      assertEquals(
          expectedStoredInstant,
          rs.getTimestamp("ts_val").toInstant(),
          label(zone, "string parameter must store 15:30:45 UTC, truncated to micros"));
      assertEquals(
          expectedStoredInstant,
          rs.getTimestamp("ts_nano").toInstant(),
          label(zone, "Timestamp parameter must store the same moment as the string"));

      assertEquals(
          expectedUtcString,
          rs.getString("ts_val"),
          label(zone, "backend truncates TIMESTAMP parameters to microseconds; b/419328655"));
      assertEquals(
          expectedUtcString,
          rs.getString("ts_nano"),
          label(zone, "nanosecond tail of a java.sql.Timestamp parameter is truncated too"));
    }
  }

  /**
   * Batched {@code setTimestamp} / {@code setObject(String, TIMESTAMP)} must store the same moment
   * under every JVM default zone, and each batched row must be independently retrievable through
   * both result-set implementations.
   */
  @ParameterizedTest(name = "JVM zone {0}, arrow={1}")
  @MethodSource("jvmZonesAndReadPaths")
  @Tag("advanced") // Relies on this driver's TIMESTAMP parameter conversion.
  public void testPreparedStatement_batchInsertRoundTrip(String zone, boolean arrow)
      throws SQLException {
    useJvmZone(zone);
    int firstId = NEXT_BATCH_ROW_ID.getAndAdd(BATCH_SIZE);
    int endIdExclusive = firstId + BATCH_SIZE;
    String url = getPicosConnectionUrl(true, arrow);
    String insertSql =
        String.format(
            "INSERT INTO `%s.%s.%s` (id, ts_val, ts_nano) VALUES (?, ?, ?)",
            DEFAULT_CATALOG, DATASET, INSERT_TABLE_NAME);

    // Same UTC moment for every row; see the single-row test for why Timestamp.valueOf is avoided.
    Timestamp nanoTimestamp = Timestamp.from(Instant.parse("2026-09-01T10:00:00.123456789Z"));
    Instant expectedNanoInstant = Instant.parse("2026-09-01T10:00:00.123456Z");

    try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement ps = conn.prepareStatement(insertSql)) {
      for (int i = firstId; i < endIdExclusive; i++) {
        ps.setInt(1, i);
        // Only the microsecond component survives truncation, so it identifies the row.
        ps.setObject(
            2, "2026-09-01 10:00:00." + String.format("%06d", i) + "789012", Types.TIMESTAMP);
        ps.setTimestamp(3, nanoTimestamp);
        ps.addBatch();
      }

      int[] updateCounts = ps.executeBatch();
      assertEquals(BATCH_SIZE, updateCounts.length, label(zone, "one update count per row"));
    }

    String selectSql =
        String.format(
            "SELECT id, ts_val, ts_nano FROM `%s.%s.%s` WHERE id >= %d AND id < %d ORDER BY id",
            DEFAULT_CATALOG, DATASET, INSERT_TABLE_NAME, firstId, endIdExclusive);

    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql)) {
      assertReadPath(rs, arrow, zone);
      for (int i = firstId; i < endIdExclusive; i++) {
        assertTrue(rs.next(), label(zone, "batch row " + i + " must exist"));
        assertEquals(i, rs.getInt("id"));
        assertEquals(
            "2026-09-01 10:00:00." + String.format("%06d", i) + "000000",
            rs.getString("ts_val"),
            label(zone, "string parameter is read as UTC and truncated to micros"));
        assertEquals(
            expectedNanoInstant,
            rs.getTimestamp("ts_nano").toInstant(),
            label(zone, "batched setTimestamp must store the same moment in every JVM zone"));
      }
      assertFalse(rs.next(), label(zone, "exactly " + BATCH_SIZE + " batched rows are expected"));
    }
  }

  /**
   * {@code setString} preserves all 12 fractional digits: the value travels as a STRING parameter
   * and is coerced to {@code TIMESTAMP(12)} server side, bypassing the parameter truncation
   * documented on {@link #testPreparedStatement_insertRoundTrip_backendTruncatesToMicroseconds()}.
   * This is the supported way to write picosecond values today.
   */
  @Test
  @Tag("advanced")
  public void testPreparedStatement_setStringPreservesFullPrecision() throws SQLException {
    String url = getPicosConnectionUrl(true, false);
    String picosValue = "2026-10-05 08:15:30.987654321098";

    String insertSql =
        String.format(
            "INSERT INTO `%s.%s.%s` (id, ts_val) VALUES (?, ?)",
            DEFAULT_CATALOG, DATASET, INSERT_TABLE_NAME);

    try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement ps = conn.prepareStatement(insertSql)) {

      ps.setInt(1, 300);
      ps.setString(2, picosValue);
      assertEquals(1, ps.executeUpdate());
    }

    String selectSql =
        String.format(
            "SELECT ts_val FROM `%s.%s.%s` WHERE id = 300",
            DEFAULT_CATALOG, DATASET, INSERT_TABLE_NAME);

    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql)) {

      assertTrue(rs.next());
      assertEquals(
          picosValue,
          rs.getString("ts_val"),
          "setString must preserve all 12 fractional digits end to end");
    }
  }

  /**
   * Temporal accessors on a {@code TIMESTAMP(12)} value truncate to the Java type's precision. The
   * value is a moment, so a Calendar does not change the result.
   */
  @ParameterizedTest(name = "JVM zone {0}, arrow={1}")
  @MethodSource("jvmZonesAndReadPaths")
  @Tag("advanced")
  public void testTemporalAccessors_picosEnabled_truncateToJavaPrecision(String zone, boolean arrow)
      throws SQLException {
    useJvmZone(zone);
    String url = getPicosConnectionUrl(true, arrow);
    String query =
        String.format(
            "SELECT ts_picos FROM `%s.%s.%s` ORDER BY id ASC",
            DEFAULT_CATALOG, DATASET, TABLE_NAME);
    Instant moment = Instant.parse("2025-01-01T12:34:56.123456789Z");
    ZonedDateTime local = moment.atZone(ZoneId.systemDefault());
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));

    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query)) {
      assertReadPath(rs, arrow, zone);
      assertTrue(rs.next());
      assertAll(
          () ->
              assertEquals(
                  moment, rs.getTimestamp("ts_picos").toInstant(), label(zone, "getTimestamp")),
          () ->
              assertEquals(
                  moment,
                  rs.getObject("ts_picos", Instant.class),
                  label(zone, "getObject(Instant)")),
          () ->
              assertEquals(
                  moment,
                  rs.getObject("ts_picos", OffsetDateTime.class).toInstant(),
                  label(zone, "getObject(OffsetDateTime)")),
          () ->
              assertEquals(
                  local.toLocalDateTime(),
                  rs.getObject("ts_picos", LocalDateTime.class),
                  label(zone, "getObject(LocalDateTime)")),
          () ->
              assertEquals(
                  local.toLocalDate(),
                  rs.getDate("ts_picos").toLocalDate(),
                  label(zone, "getDate")),
          () ->
              assertEquals(
                  local.toLocalTime().withNano(0),
                  rs.getTime("ts_picos").toLocalTime(),
                  label(zone, "getTime")),
          () ->
              assertEquals(
                  moment,
                  rs.getTimestamp("ts_picos", cal).toInstant(),
                  label(zone, "getTimestamp(cal)")),
          () ->
              assertEquals(
                  local.toLocalDate(),
                  rs.getDate("ts_picos", cal).toLocalDate(),
                  label(zone, "getDate(cal)")),
          () ->
              assertEquals(
                  local.toLocalTime().withNano(0),
                  rs.getTime("ts_picos", cal).toLocalTime(),
                  label(zone, "getTime(cal)")));
    }
  }

  @Test
  public void testLegacySqlRejection_throwsSqlException() throws SQLException {
    String url = ITBase.connectionUrl + "EnableTimestampPicos=1;QueryDialect=BIG_QUERY;";

    // Legacy SQL table syntax. The query must reference a table: drivers that rely on the backend
    // to surface the incompatibility do not fail on a table-less statement such as SELECT 1.
    String legacyQuery =
        String.format("SELECT id FROM [%s:%s.%s]", DEFAULT_CATALOG, DATASET, INSERT_TABLE_NAME);

    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement()) {

      // Assert on SQLException rather than BigQueryJdbcException: referencing a driver-internal
      // type prevents this class from loading under the standalone/other-driver harness.
      SQLException ex =
          assertThrows(
              SQLException.class,
              () -> stmt.execute(legacyQuery),
              "Executing query with EnableTimestampPicos=1 and Legacy SQL must fail");

      assertTrue(
          ex.getMessage().contains("Picosecond data is incompatible with Legacy SQL"),
          "Exception message should mention Legacy SQL incompatibility");
    }
  }

  @Test
  public void testTimezoneInvariance_acrossJvmTimezones() throws SQLException {
    String url = getPicosConnectionUrl(true, false);
    String query =
        String.format(
            "SELECT ts_picos FROM `%s.%s.%s` WHERE id = 1", DEFAULT_CATALOG, DATASET, TABLE_NAME);

    TimeZone originalJvmTimeZone = TimeZone.getDefault();
    String[] testZones =
        new String[] {"UTC", "America/New_York", "Asia/Kolkata", "Pacific/Auckland"};

    try {
      for (String zoneId : testZones) {
        TimeZone.setDefault(TimeZone.getTimeZone(zoneId));

        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {

          assertTrue(rs.next(), "Row must exist in timezone " + zoneId);
          // Value must remain 100% in UTC regardless of JVM default timezone
          assertEquals(
              TIMESTAMP_MODERN_PICOS,
              rs.getString("ts_picos"),
              "Formatted picosecond timestamp must remain strictly in UTC under JVM timezone "
                  + zoneId);
        }
      }
    } finally {
      TimeZone.setDefault(originalJvmTimeZone);
    }
  }
}

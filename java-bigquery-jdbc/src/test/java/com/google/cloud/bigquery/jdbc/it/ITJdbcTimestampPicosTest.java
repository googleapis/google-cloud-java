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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.TimeZone;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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

  private static final DateTimeFormatter JVM_ZONE_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

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
   * Renders a UTC wall-clock literal in the JVM default time zone, with the fixed microsecond
   * precision that {@code getString} applies to a plain {@code TIMESTAMP} column. Those values are
   * zone dependent, whereas {@code TIMESTAMP(12)} values are returned as verbatim UTC strings.
   */
  private static String atJvmZone(String utcLiteral) {
    return LocalDateTime.parse(utcLiteral.replace(' ', 'T'))
        .atOffset(ZoneOffset.UTC)
        .atZoneSameInstant(ZoneId.systemDefault())
        .format(JVM_ZONE_FORMATTER);
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
      assertEquals(atJvmZone(TIMESTAMP_MODERN_STANDARD), rs.getString("ts_standard"));
      // When EnableTimestampPicos is false, picosecond columns truncate to 6 digits
      assertEquals(atJvmZone(TIMESTAMP_MODERN_STANDARD), rs.getString("ts_picos"));

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
      assertEquals(atJvmZone(TIMESTAMP_MODERN_STANDARD), rs.getString("ts_standard"));
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
      assertEquals(atJvmZone(TIMESTAMP_MODERN_STANDARD), rs.getString("ts_standard"));
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
   */
  @Test
  @Tag("advanced")
  public void testPreparedStatement_insertRoundTrip_backendTruncatesToMicroseconds()
      throws SQLException {
    String url = getPicosConnectionUrl(true, false);
    String insertSql =
        String.format(
            "INSERT INTO `%s.%s.%s` (id, ts_val, ts_nano) VALUES (?, ?, ?)",
            DEFAULT_CATALOG, DATASET, INSERT_TABLE_NAME);

    String selectSql =
        String.format(
            "SELECT id, ts_val, ts_nano FROM `%s.%s.%s` WHERE id = 100",
            DEFAULT_CATALOG, DATASET, INSERT_TABLE_NAME);

    String picosInsertVal = "2026-08-10 15:30:45.123456789012";
    Timestamp nanoTimestamp = Timestamp.valueOf("2026-08-10 15:30:45.123456789");

    try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement ps = conn.prepareStatement(insertSql)) {

      ps.setInt(1, 100);
      ps.setObject(2, picosInsertVal, Types.TIMESTAMP);
      ps.setTimestamp(3, nanoTimestamp);
      int rows = ps.executeUpdate();
      assertEquals(1, rows);
    }

    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql)) {

      assertTrue(rs.next());
      assertEquals(100, rs.getInt("id"));
      assertEquals(
          "2026-08-10 15:30:45.123456000000",
          rs.getString("ts_val"),
          "Backend truncates TIMESTAMP parameters to microseconds; see b/419328655");
      assertEquals(
          "2026-08-10 15:30:45.123456000000",
          rs.getString("ts_nano"),
          "Nanosecond tail of a java.sql.Timestamp parameter is truncated by the backend too");
    }
  }

  @Test
  @Tag("advanced")
  public void testPreparedStatement_batchInsertRoundTrip() throws SQLException {
    String url = getPicosConnectionUrl(true, false);
    String insertSql =
        String.format(
            "INSERT INTO `%s.%s.%s` (id, ts_val, ts_nano) VALUES (?, ?, ?)",
            DEFAULT_CATALOG, DATASET, INSERT_TABLE_NAME);

    try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement ps = conn.prepareStatement(insertSql)) {

      for (int i = 200; i < 205; i++) {
        ps.setInt(1, i);
        // Only the microsecond component survives truncation, so it identifies the row.
        ps.setObject(
            2, "2026-09-01 10:00:00." + String.format("%06d", i) + "789012", Types.TIMESTAMP);
        ps.setTimestamp(3, Timestamp.valueOf("2026-09-01 10:00:00.123456789"));
        ps.addBatch();
      }

      int[] updateCounts = ps.executeBatch();
      assertEquals(5, updateCounts.length);
    }

    String selectSql =
        String.format(
            "SELECT id, ts_val FROM `%s.%s.%s` WHERE id >= 200 AND id < 205 ORDER BY id",
            DEFAULT_CATALOG, DATASET, INSERT_TABLE_NAME);

    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql)) {

      for (int i = 200; i < 205; i++) {
        assertTrue(rs.next(), "Batch row " + i + " must exist");
        assertEquals(i, rs.getInt("id"));
        assertEquals(
            "2026-09-01 10:00:00." + String.format("%06d", i) + "000000", rs.getString("ts_val"));
      }
      assertFalse(rs.next(), "Exactly five batched rows are expected");
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

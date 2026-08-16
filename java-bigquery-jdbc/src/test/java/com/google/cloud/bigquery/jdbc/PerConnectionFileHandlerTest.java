/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.StandardSQLTypeName;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;

public class PerConnectionFileHandlerTest {

  @TempDir Path tempDir;

  private PerConnectionFileHandler handler;
  private BigQueryConnection mockConnection;
  private Level originalLevel;

  @BeforeEach
  public void setUp() {
    handler = new PerConnectionFileHandler(tempDir.toString(), Level.INFO);
    mockConnection = Mockito.mock(BigQueryConnection.class);
    BigQueryJdbcMdc.clear();
    originalLevel = BigQueryJdbcRootLogger.getRootLogger().getLevel();
    BigQueryJdbcRootLogger.getRootLogger().setLevel(Level.ALL);
  }

  @AfterEach
  public void tearDown() {
    if (handler != null) {
      handler.close();
    }
    BigQueryJdbcMdc.clear();
    BigQueryJdbcRootLogger.getRootLogger().setLevel(originalLevel);
  }

  private Optional<Path> findLogFile(String suffix) throws IOException {
    return Files.list(tempDir)
        .filter(
            p ->
                p.getFileName().toString().startsWith("BQ-JDBC-")
                    && p.getFileName().toString().endsWith(suffix))
        .findFirst();
  }

  @Test
  public void testInitialization() throws IOException {
    Path defaultLog = tempDir.resolve("BQ-JDBC-GLOBAL.log");
    assertTrue(Files.exists(defaultLog));
  }

  @Test
  public void testPublishDefault() throws IOException {
    LogRecord record = new LogRecord(Level.INFO, "Test message default");
    handler.publish(record);
    handler.flush();

    Path defaultLog = tempDir.resolve("BQ-JDBC-GLOBAL.log");
    assertTrue(Files.exists(defaultLog));
    String content = new String(Files.readAllBytes(defaultLog));
    assertTrue(content.contains("Test message default"));
  }

  @Test
  public void testPublishConnectionSpecific() throws IOException {
    BigQueryJdbcMdc.registerInstance("c123");

    LogRecord record = new LogRecord(Level.INFO, "Test message connection 123");
    handler.publish(record);
    handler.flush();

    Optional<Path> connLog = findLogFile("-c123.log");
    assertTrue(connLog.isPresent());
  }

  @Test
  public void testCloseHandler() throws IOException {
    BigQueryJdbcMdc.registerInstance("c123");

    LogRecord record = new LogRecord(Level.INFO, "Test message connection 123");
    handler.publish(record);
    handler.flush();

    Optional<Path> connLog = findLogFile("-c123.log");
    assertTrue(connLog.isPresent());

    handler.closeHandler("c123");
    // File remains on disk, but handler is closed.
    assertTrue(connLog.isPresent());
  }

  /**
   * Verifies that when an exception is thrown from within a dynamic proxy wrapper method while the
   * thread-local connection ID context is completely missing (null), the proxy's catch block
   * dynamically extracts the connection ID from the target instance, registers it on the executing
   * thread, and writes the severe exception log record directly to the connection-specific log file
   * (e.g. "BQ-JDBC-timestamp-c456.log") instead of the global log file.
   */
  @Test
  public void testProxyExceptionLogRouting() throws Exception {
    // Register the temp file handler to the root logger so proxy logs are routed to it
    java.util.logging.Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    rootLogger.addHandler(handler);

    try {
      // Ensure thread context is completely missing (null) before query
      BigQueryJdbcMdc.clear();
      assertNull(BigQueryJdbcMdc.getConnectionId());

      // Create a mock statement with connectionId = "c456"
      BigQueryStatement mockStmt = mock(BigQueryStatement.class);
      mockStmt.connectionId = "c456";

      // Mock executeQuery to throw an exception
      Mockito.when(mockStmt.executeQuery(Mockito.anyString()))
          .thenThrow(new SQLException("Database error"));

      // Wrap it using our proxy (which dynamically extracts "c456" as its connection ID!)
      Statement proxy = BigQueryJdbcContextProxy.wrap(mockStmt, Statement.class, "c456");
      assertNotNull(proxy);

      // Call the proxy method. It will throw SQLException
      assertThrows(SQLException.class, () -> proxy.executeQuery("SELECT *"));

      // Flush the handler to ensure logs are written to disk
      handler.flush();

      // Verify that the exception log got registered and written directly to c456.log!
      Optional<Path> connLog = findLogFile("-c456.log");
      assertTrue(connLog.isPresent());

      String content = new String(Files.readAllBytes(connLog.get()));
      assertTrue(content.contains("Database error"));
      assertTrue(content.contains("Exception occurred during executeQuery"));

    } finally {
      // Cleanup
      rootLogger.removeHandler(handler);
    }
  }

  /**
   * Verifies that when an exception is thrown from within an unproxied, raw ResultSet concrete
   * class while the thread-local connection ID context is completely missing (null), the internal
   * logAndCreateException() builder dynamically extracts the connection ID from its parent
   * statement, registers it on the executing thread, and writes the severe exception log record
   * directly to the connection-specific log file (e.g. "BQ-JDBC-timestamp-c789.log") instead of the
   * global log file.
   */
  @Test
  public void testResultSetExceptionLogRouting() throws Exception {
    // Register the temp file handler to the root logger so ResultSet logs are captured
    java.util.logging.Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    rootLogger.addHandler(handler);

    try {
      // Ensure thread context is completely missing (null) before call
      BigQueryJdbcMdc.clear();
      assertNull(BigQueryJdbcMdc.getConnectionId());

      // Create a mock statement with connectionId = "c789"
      BigQueryStatement mockStmt = mock(BigQueryStatement.class);
      mockStmt.connectionId = "c789";

      // Create a mock FieldList and schema for the ResultSet
      FieldList fields = FieldList.of(Field.of("col", StandardSQLTypeName.STRING));
      com.google.cloud.bigquery.Schema schema = com.google.cloud.bigquery.Schema.of(fields);

      // Instantiate a real BigQueryJsonResultSet (which extends BigQueryBaseResultSet)
      // passing the mock statement carrying connectionId "c789"
      BigQueryJsonResultSet rs =
          BigQueryJsonResultSet.of(schema, 0, null, mockStmt, new Future<?>[0]);

      // Calling findColumn(null) throws SQLException because column label is null
      assertThrows(SQLException.class, () -> rs.findColumn(null));

      // Flush the handler to ensure logs are written to disk
      handler.flush();

      // Verify that the ResultSet exception log got registered and written directly to c789.log!
      Optional<Path> connLog = findLogFile("-c789.log");
      assertTrue(connLog.isPresent());

      String content = new String(Files.readAllBytes(connLog.get()));
      assertTrue(content.contains("Column label cannot be null"));

    } finally {
      // Cleanup
      rootLogger.removeHandler(handler);
    }
  }
}

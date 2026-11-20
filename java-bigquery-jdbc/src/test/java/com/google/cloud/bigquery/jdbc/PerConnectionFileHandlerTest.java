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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.jdbc.utils.TestUtilities;
import com.google.cloud.bigquery.jdbc.utils.URIBuilder;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;

public class PerConnectionFileHandlerTest {

  @TempDir Path tempDir;

  private PerConnectionFileHandler handler;
  private Level originalLevel;

  @BeforeEach
  public void setUp() {
    handler = new PerConnectionFileHandler(tempDir.toString(), Level.INFO);
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

  private Optional<Path> findLogFile(Path dir, String suffix) throws IOException {
    try (Stream<Path> files = Files.list(dir)) {
      return files
          .filter(
              p ->
                  p.getFileName().toString().startsWith("BQ-JDBC-")
                      && p.getFileName().toString().endsWith(suffix))
          .findFirst();
    }
  }

  private Optional<Path> findLogFile(String suffix) throws IOException {
    return findLogFile(tempDir, suffix);
  }

  @Test
  public void testInitialization() {
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
    String content = new String(Files.readAllBytes(defaultLog), StandardCharsets.UTF_8);
    assertTrue(content.contains("Test message default"));
  }

  @Test
  public void testPublishConnectionSpecific() throws IOException {
    handler.registerConnection("c123");
    BigQueryJdbcMdc.registerInstance("c123");

    LogRecord record = new LogRecord(Level.INFO, "Test message connection 123");
    handler.publish(record);
    handler.flush();

    Optional<Path> connLog = findLogFile("-c123.log");
    assertTrue(connLog.isPresent());
  }

  @Test
  public void testCloseHandler() throws IOException {
    handler.registerConnection("c123");
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
    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    handler.registerConnection("c456");
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

      String content = new String(Files.readAllBytes(connLog.get()), StandardCharsets.UTF_8);
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
    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    handler.registerConnection("c789");
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
      Schema schema = Schema.of(fields);

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

      String content = new String(Files.readAllBytes(connLog.get()), StandardCharsets.UTF_8);
      assertTrue(content.contains("Column label cannot be null"));

    } finally {
      // Cleanup
      rootLogger.removeHandler(handler);
    }
  }

  @Test
  @EnabledOnOs({OS.LINUX, OS.MAC})
  public void testPosixOwnerOnlyPermissionsOnCreatedDirsAndFiles() throws IOException {
    Path nestedDir = tempDir.resolve("parent_logs/child_logs");
    PerConnectionFileHandler posixHandler =
        new PerConnectionFileHandler(nestedDir.toString(), Level.FINEST);
    try {
      posixHandler.registerConnection("p999");
      try (BigQueryJdbcMdc.MdcCloseable mdc = BigQueryJdbcMdc.registerInstance("p999")) {
        posixHandler.publish(new LogRecord(Level.INFO, "Secret query"));
      }
      posixHandler.flush();

      assertEquals(
          "rwx------",
          PosixFilePermissions.toString(Files.getPosixFilePermissions(nestedDir.getParent())));
      assertEquals(
          "rwx------", PosixFilePermissions.toString(Files.getPosixFilePermissions(nestedDir)));
      assertEquals(
          "rw-------",
          PosixFilePermissions.toString(
              Files.getPosixFilePermissions(nestedDir.resolve("BQ-JDBC-GLOBAL.log"))));

      Optional<Path> connLog = findLogFile(nestedDir, "-p999.log");
      assertTrue(connLog.isPresent());
      assertEquals(
          "rw-------", PosixFilePermissions.toString(Files.getPosixFilePermissions(connLog.get())));
    } finally {
      posixHandler.close();
    }
  }

  @Test
  @EnabledOnOs({OS.LINUX, OS.MAC})
  public void testExistingSharedDirectoryAndPermissiveFileHandling() throws IOException {
    Path sharedDir = Files.createDirectory(tempDir.resolve("shared_dir"));
    Files.setPosixFilePermissions(sharedDir, PosixFilePermissions.fromString("rwxr-xr-x"));

    // Pre-existing permissive (0644) regular global log file owned by current user gets tightened
    Path existingGlobal = Files.createFile(sharedDir.resolve("BQ-JDBC-GLOBAL.log"));
    Files.setPosixFilePermissions(existingGlobal, PosixFilePermissions.fromString("rw-r--r--"));

    PerConnectionFileHandler sharedHandler =
        new PerConnectionFileHandler(sharedDir.toString(), Level.INFO);
    try {
      assertEquals(
          "rwxr-xr-x", PosixFilePermissions.toString(Files.getPosixFilePermissions(sharedDir)));
      assertEquals(
          "rw-------",
          PosixFilePermissions.toString(Files.getPosixFilePermissions(existingGlobal)));
    } finally {
      sharedHandler.close();
    }

    // System /tmp root path (symlink on macOS, real dir on Linux) is accepted without altering mode
    assertNotNull(PerConnectionFileHandler.ensureSecureDirectory(Paths.get("/tmp")));
  }

  @Test
  @EnabledOnOs({OS.LINUX, OS.MAC})
  public void testSymbolicLinksAndNonRegularPathsAreRejected() throws IOException {
    Path targetFile = Files.write(tempDir.resolve("target.txt"), "keep".getBytes());
    Path fileSymlink = tempDir.resolve("symlink.log");
    Files.createSymbolicLink(fileSymlink, targetFile);

    assertThrows(
        IOException.class, () -> PerConnectionFileHandler.openSecureAppendChannel(fileSymlink));
    assertEquals("keep", new String(Files.readAllBytes(targetFile), StandardCharsets.UTF_8));

    // Directory passed where regular log file is expected must be rejected
    Path subDir = Files.createDirectory(tempDir.resolve("not_a_regular_file"));
    assertThrows(IOException.class, () -> PerConnectionFileHandler.openSecureAppendChannel(subDir));

    // Regular file passed where log directory is expected must be rejected
    assertThrows(
        IOException.class, () -> PerConnectionFileHandler.ensureSecureDirectory(targetFile));

    // Symlinked directory and nested path beneath a symlinked directory must both be rejected
    Path realTargetDir = Files.createDirectory(tempDir.resolve("real_target_dir"));
    Path dirSymlink = tempDir.resolve("dir_symlink");
    Files.createSymbolicLink(dirSymlink, realTargetDir);
    assertThrows(
        IOException.class, () -> PerConnectionFileHandler.ensureSecureDirectory(dirSymlink));
    assertThrows(
        IOException.class,
        () -> PerConnectionFileHandler.ensureSecureDirectory(dirSymlink.resolve("nested_child")));
    assertFalse(Files.exists(realTargetDir.resolve("nested_child")));

    // Existing file Channel append works cleanly for current user
    Path ownedFile = tempDir.resolve("owned.log");
    try (SeekableByteChannel ch = PerConnectionFileHandler.openSecureAppendChannel(ownedFile)) {
      assertNotNull(ch);
    }
  }

  @Test
  public void testPercentTokensAndSystemPropertyMaxBytes() throws IOException {
    Path literalPercentDir = tempDir.resolve("dir_%t_%h_%g_%u");
    PerConnectionFileHandler percentHandler =
        new PerConnectionFileHandler(literalPercentDir.toString(), Level.INFO);
    try {
      percentHandler.publish(new LogRecord(Level.INFO, "Literal percent dir log"));
      percentHandler.flush();

      Path globalLog = literalPercentDir.resolve("BQ-JDBC-GLOBAL.log");
      assertTrue(Files.exists(globalLog));
      String content = new String(Files.readAllBytes(globalLog), StandardCharsets.UTF_8);
      assertTrue(content.contains("Literal percent dir log"));
    } finally {
      percentHandler.close();
    }

    String prop = PerConnectionFileHandler.MAX_LOG_FILE_BYTES_SYSTEM_PROPERTY;
    String prev = System.getProperty(prop);
    try {
      System.setProperty(prop, "4096");
      assertEquals(4096, PerConnectionFileHandler.resolveMaxLogFileBytes());
      System.setProperty(prop, "-5");
      assertEquals(
          PerConnectionFileHandler.DEFAULT_MAX_LOG_FILE_BYTES,
          PerConnectionFileHandler.resolveMaxLogFileBytes());
    } finally {
      if (prev == null) {
        System.clearProperty(prop);
      } else {
        System.setProperty(prop, prev);
      }
    }
  }

  @Test
  public void testBoundedLogFileSizeAndSameSecondCollisionIsolation() throws IOException {
    Path boundedDir = tempDir.resolve("bounded");
    int maxBytes = 1024;
    PerConnectionFileHandler boundedHandler =
        new PerConnectionFileHandler(boundedDir.toString(), Level.INFO, maxBytes);
    try {
      for (int i = 0; i < 40; i++) {
        boundedHandler.publish(
            new LogRecord(Level.INFO, "Padding log line to exceed 1 KiB limit #" + i));
      }
      // Two connections sharing the same 4-char prefix in the same second get distinct files
      boundedHandler.registerConnection("abcd-1111");
      boundedHandler.registerConnection("abcd-2222");
      try (BigQueryJdbcMdc.MdcCloseable m1 = BigQueryJdbcMdc.registerInstance("abcd-1111")) {
        boundedHandler.publish(new LogRecord(Level.INFO, "First abcd connection"));
      }
      try (BigQueryJdbcMdc.MdcCloseable m2 = BigQueryJdbcMdc.registerInstance("abcd-2222")) {
        boundedHandler.publish(new LogRecord(Level.INFO, "Second abcd connection"));
      }
      boundedHandler.flush();
    } finally {
      boundedHandler.close();
    }

    // Post-close registerConnection and publish are safe no-ops
    boundedHandler.registerConnection("after-close");
    try (BigQueryJdbcMdc.MdcCloseable m3 = BigQueryJdbcMdc.registerInstance("after-close")) {
      boundedHandler.publish(new LogRecord(Level.INFO, "Ignored after handler close"));
    }

    try (Stream<Path> stream = Files.list(boundedDir)) {
      List<Path> files = stream.collect(Collectors.toList());
      assertTrue(files.stream().noneMatch(p -> p.getFileName().toString().endsWith(".lck")));
      assertEquals(
          2L, files.stream().filter(p -> p.getFileName().toString().endsWith("-abcd.log")).count());
      Path globalLog = boundedDir.resolve("BQ-JDBC-GLOBAL.log");
      assertTrue(Files.size(globalLog) <= maxBytes + 512);
    }
  }

  @Test
  public void testConcurrentCloseAndPublishLeavesNoOpenConnectionFiles() throws Exception {
    Path raceDir = tempDir.resolve("race");
    for (int round = 0; round < 15; round++) {
      PerConnectionFileHandler raceHandler =
          new PerConnectionFileHandler(raceDir.resolve("r" + round).toString(), Level.INFO);
      String connId = "race-" + round;
      raceHandler.registerConnection(connId);
      CountDownLatch start = new CountDownLatch(1);
      ExecutorService pool = Executors.newFixedThreadPool(2);
      try {
        Future<?> pubTask =
            pool.submit(
                () -> {
                  try (BigQueryJdbcMdc.MdcCloseable m = BigQueryJdbcMdc.registerInstance(connId)) {
                    start.await();
                    for (int i = 0; i < 10; i++) {
                      raceHandler.publish(new LogRecord(Level.INFO, "race msg " + i));
                    }
                  } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                  }
                });
        Future<?> closeTask =
            pool.submit(
                () -> {
                  try {
                    start.await();
                    raceHandler.close();
                  } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                  }
                });
        start.countDown();
        pubTask.get(5, TimeUnit.SECONDS);
        closeTask.get(5, TimeUnit.SECONDS);
      } finally {
        pool.shutdownNow();
      }
      // After close(), publishing again with the same connId must not create a new file
      Path roundDir = raceDir.resolve("r" + round);
      try (Stream<Path> before = Files.list(roundDir)) {
        long countAfterClose = before.count();
        try (BigQueryJdbcMdc.MdcCloseable m = BigQueryJdbcMdc.registerInstance(connId)) {
          raceHandler.publish(new LogRecord(Level.INFO, "post-close"));
        }
        try (Stream<Path> after = Files.list(roundDir)) {
          assertEquals(countAfterClose, after.count());
        }
      }
    }
  }

  @Test
  public void testPostCloseResultSetAndStringParamsDoNotResurrectHandlers() throws Exception {
    Path leakDir = tempDir.resolve("no_leak");
    PerConnectionFileHandler finestHandler =
        new PerConnectionFileHandler(leakDir.toString(), Level.FINEST);
    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    rootLogger.addHandler(finestHandler);

    try {
      String connId = "dead-conn-uuid";
      ConnectionLogContext activeCtx =
          BigQueryJdbcRootLogger.registerConnection(connId, Level.FINEST, null);
      assertNotNull(activeCtx);
      assertEquals(Level.FINEST.intValue(), activeCtx.levelValue());
      finestHandler.registerConnection(connId);

      // Construct ResultSet and child Struct logger WHILE connection is active (covers active !=
      // null)
      BigQueryStatement mockStmt = mock(BigQueryStatement.class);
      mockStmt.connectionId = connId;
      Schema schema = Schema.of(FieldList.of(Field.of("col", StandardSQLTypeName.INT64)));
      BigQueryJsonResultSet rs =
          BigQueryJsonResultSet.of(schema, 0, null, mockStmt, new Future<?>[0]);
      BigQueryJdbcResultSetLogger activeStructLogger = rs.LOG.getArrowStructLogger();

      try (BigQueryJdbcMdc.MdcCloseable mdc = BigQueryJdbcMdc.registerInstance(connId)) {
        finestHandler.publish(new LogRecord(Level.INFO, "Before close"));
      }
      finestHandler.flush();
      Optional<Path> initialLog = findLogFile(leakDir, "-dead.log");
      assertTrue(initialLog.isPresent());

      rs.close();
      BigQueryJdbcRootLogger.closeConnectionHandler(connId);
      finestHandler.closeHandler(connId);
      assertEquals(ConnectionLogContext.OFF_VALUE, activeCtx.levelValue());
      Files.delete(initialLog.get());

      // 1. Post-close ResultSet getter and exception log on ResultSet created while active
      assertThrows(SQLException.class, () -> rs.getShort(1));
      assertThrows(SQLException.class, () -> rs.findColumn(null));

      // 2. Pre-existing detached Struct logger AND newly obtained post-close logger (active ==
      // null)
      activeStructLogger.finestTrace("getAttributes");
      BigQueryJdbcResultSetLogger.getLogger(BigQueryArrowStruct.class, connId)
          .finestTrace("getAttributes");

      // 3. Third-party retry logger passing plain String in params[0] with empty MDC
      BigQueryJdbcMdc.clear();
      LogRecord retryRecord = new LogRecord(Level.FINEST, "Retrying RPC");
      retryRecord.setParameters(new Object[] {"BigQuery retried method: getQueryResults"});
      finestHandler.publish(retryRecord);
      finestHandler.flush();

      assertFalse(findLogFile(leakDir, "-dead.log").isPresent());
      assertFalse(findLogFile(leakDir, "-BigQ.log").isPresent());

      Formatter formatter = BigQueryJdbcRootLogger.getFormatter();
      String formattedRetry = formatter.format(retryRecord);
      assertTrue(formattedRetry.contains("[NO_CONN]"));
      assertFalse(formattedRetry.contains("[BigQuery retried method:"));
    } finally {
      rootLogger.removeHandler(finestHandler);
      finestHandler.close();
    }
  }

  @Test
  public void testFailedConnectionConstructorCleansUpActiveRegistration() throws IOException {
    Path failLogDir = tempDir.resolve("failed_conn_logs");
    int baselineActive = BigQueryJdbcRootLogger.activeConnectionCount();
    String invalidAuthUrl =
        new URIBuilder(TestUtilities.getBaseConnectionUrl())
            .append("ProjectId", "test-proj")
            .append("OAuthType", 99)
            .toString();

    BigQueryJdbcRootLogger.setLevel(Level.CONFIG, failLogDir.toString());
    try {
      assertThrows(RuntimeException.class, () -> new BigQueryConnection(invalidAuthUrl));
      assertEquals(baselineActive, BigQueryJdbcRootLogger.activeConnectionCount());
      // Constructor logged CONFIG properties before failing, then closed/unregistered its slot
      try (Stream<Path> files = Files.list(failLogDir)) {
        List<Path> created = files.collect(Collectors.toList());
        assertTrue(created.stream().anyMatch(p -> !p.endsWith("BQ-JDBC-GLOBAL.log")));
        assertTrue(created.stream().noneMatch(p -> p.getFileName().toString().endsWith(".lck")));
      }
    } finally {
      BigQueryJdbcRootLogger.setLevel(Level.OFF, null);
    }
  }

  @Test
  public void testPersistentHandlerDoesNotOpenImplicitSlotsForOffConnections() throws IOException {
    PerConnectionFileHandler persistent = new PerConnectionFileHandler();
    String offConnId = "explicit-off-conn";
    try {
      BigQueryJdbcRootLogger.registerConnection(offConnId, Level.OFF, null);
      try (BigQueryJdbcMdc.MdcCloseable mdc = BigQueryJdbcMdc.registerInstance(offConnId)) {
        persistent.publish(new LogRecord(Level.SEVERE, "Should not open implicit slot"));
      }
      persistent.flush();
      assertTrue(BigQueryJdbcRootLogger.isConnectionActive(offConnId));
    } finally {
      BigQueryJdbcRootLogger.closeConnectionHandler(offConnId);
      persistent.close();
    }
  }
}

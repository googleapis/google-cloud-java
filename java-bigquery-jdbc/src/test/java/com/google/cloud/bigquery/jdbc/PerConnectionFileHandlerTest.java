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
    java.util.logging.Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
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

  private static void assertMode(Path path, String expected) throws IOException {
    assertEquals(expected, PosixFilePermissions.toString(Files.getPosixFilePermissions(path)));
  }

  private static String readUtf8(Path path) throws IOException {
    return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
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
        posixHandler.publish(new LogRecord(Level.INFO, "Query log entry"));
      }
      posixHandler.flush();

      assertMode(nestedDir.getParent(), "rwx------");
      assertMode(nestedDir, "rwx------");
      assertMode(nestedDir.resolve("BQ-JDBC-GLOBAL.log"), "rw-------");

      Optional<Path> connLog = findLogFile(nestedDir, "-p999.log");
      assertTrue(connLog.isPresent());
      assertMode(connLog.get(), "rw-------");
    } finally {
      posixHandler.close();
    }
  }

  @Test
  @EnabledOnOs({OS.LINUX, OS.MAC})
  public void testExistingSharedDirectoryAndPermissiveFileHandling() throws IOException {
    Path sharedDir = Files.createDirectory(tempDir.resolve("shared_dir"));
    Files.setPosixFilePermissions(sharedDir, PosixFilePermissions.fromString("rwxr-xr-x"));

    Path existingGlobal =
        Files.write(
            sharedDir.resolve("BQ-JDBC-GLOBAL.log"),
            "Prior entry\n".getBytes(StandardCharsets.UTF_8));
    Files.setPosixFilePermissions(existingGlobal, PosixFilePermissions.fromString("rw-r--r--"));

    PerConnectionFileHandler sharedHandler =
        new PerConnectionFileHandler(sharedDir.toString(), Level.INFO);
    try {
      sharedHandler.publish(new LogRecord(Level.INFO, "Appended entry"));
      try (BigQueryJdbcMdc.MdcCloseable badIdMdc = BigQueryJdbcMdc.registerInstance("a/bc")) {
        sharedHandler.publish(new LogRecord(Level.INFO, "Fallback to global entry"));
      }
      sharedHandler.flush();
      assertMode(sharedDir, "rwxr-xr-x");
      assertMode(existingGlobal, "rw-------");
      String combined = readUtf8(existingGlobal);
      assertTrue(combined.contains("Prior entry") && combined.contains("Appended entry"));
      assertTrue(combined.contains("Fallback to global entry"));

      PerConnectionFileHandler secondHandler =
          new PerConnectionFileHandler(sharedDir.toString(), Level.INFO);
      try {
        secondHandler.publish(new LogRecord(Level.INFO, "Isolated PID entry"));
        secondHandler.flush();
        Path pidGlobal =
            sharedDir.resolve("BQ-JDBC-GLOBAL-" + BigQueryJdbcRootLogger.PROCESS_ID + ".log");
        assertTrue(Files.exists(pidGlobal));
        assertMode(pidGlobal, "rw-------");
      } finally {
        secondHandler.close();
      }
    } finally {
      sharedHandler.close();
    }

    String origUser = System.getProperty("user.name");
    try {
      System.setProperty("user.name", "");
      assertThrows(
          IOException.class,
          () -> PerConnectionFileHandler.openSecureAppendChannel(existingGlobal));
      System.setProperty("user.name", "other_user");
      assertThrows(
          IOException.class,
          () -> PerConnectionFileHandler.openSecureAppendChannel(existingGlobal));
    } finally {
      if (origUser != null) {
        System.setProperty("user.name", origUser);
      } else {
        System.clearProperty("user.name");
      }
    }

    assertNotNull(PerConnectionFileHandler.ensureSecureDirectory(Paths.get("/tmp")));
  }

  @Test
  @EnabledOnOs({OS.LINUX, OS.MAC})
  public void testSymbolicLinksAndNonRegularPathsAreRejected() throws IOException {
    Path targetFile =
        Files.write(tempDir.resolve("target.txt"), "keep".getBytes(StandardCharsets.UTF_8));
    Path fileSymlink = tempDir.resolve("symlink.log");
    Files.createSymbolicLink(fileSymlink, targetFile);

    assertThrows(
        IOException.class, () -> PerConnectionFileHandler.openSecureAppendChannel(fileSymlink));
    assertEquals("keep", readUtf8(targetFile));

    Path subDir = Files.createDirectory(tempDir.resolve("not_a_regular_file"));
    assertThrows(IOException.class, () -> PerConnectionFileHandler.openSecureAppendChannel(subDir));
    assertThrows(
        IOException.class, () -> PerConnectionFileHandler.ensureSecureDirectory(targetFile));

    Path realTargetDir = Files.createDirectory(tempDir.resolve("real_target_dir"));
    Path dirSymlink = tempDir.resolve("dir_symlink");
    Files.createSymbolicLink(dirSymlink, realTargetDir);
    assertThrows(
        IOException.class, () -> PerConnectionFileHandler.ensureSecureDirectory(dirSymlink));
    assertThrows(
        IOException.class,
        () -> PerConnectionFileHandler.ensureSecureDirectory(dirSymlink.resolve("nested_child")));
    PerConnectionFileHandler rejectedHandler =
        new PerConnectionFileHandler(dirSymlink.toString(), Level.INFO);
    try (BigQueryJdbcMdc.MdcCloseable mdc = BigQueryJdbcMdc.registerInstance("sym-conn")) {
      rejectedHandler.publish(new LogRecord(Level.INFO, "Should not write through symlink"));
    }
    rejectedHandler.close();
    assertFalse(Files.exists(realTargetDir.resolve("BQ-JDBC-GLOBAL.log")));

    PerConnectionFileHandler badSyntaxHandler =
        new PerConnectionFileHandler("bad\0path", Level.INFO);
    badSyntaxHandler.publish(new LogRecord(Level.INFO, "Gracefully ignored on invalid path"));
    badSyntaxHandler.close();

    try (SeekableByteChannel ch =
        PerConnectionFileHandler.openSecureAppendChannel(tempDir.resolve("owned.log"))) {
      assertNotNull(ch);
    }
  }

  @Test
  public void testPercentTokensAndCollisionIsolation() throws IOException {
    Path literalPercentDir = tempDir.resolve("dir_%t_%h_%g_%u");
    PerConnectionFileHandler percentHandler =
        new PerConnectionFileHandler(literalPercentDir.toString(), Level.INFO);
    BigQueryJdbcCustomLogger customLogger =
        new BigQueryJdbcCustomLogger(PerConnectionFileHandlerTest.class.getName());
    customLogger.setLevel(Level.ALL);
    customLogger.addHandler(percentHandler);
    try {
      customLogger.info("Literal percent dir log %s", "ok");
      percentHandler.registerConnection("abcd-1111");
      percentHandler.registerConnection("abcd-2222");
      try (BigQueryJdbcMdc.MdcCloseable m1 = BigQueryJdbcMdc.registerInstance("abcd-1111")) {
        percentHandler.publish(new LogRecord(Level.INFO, "First abcd connection"));
      }
      try (BigQueryJdbcMdc.MdcCloseable m2 = BigQueryJdbcMdc.registerInstance("abcd-2222")) {
        percentHandler.publish(new LogRecord(Level.INFO, "Second abcd connection"));
      }
      percentHandler.flush();
      String content = readUtf8(literalPercentDir.resolve("BQ-JDBC-GLOBAL.log"));
      assertTrue(content.contains("Literal percent dir log ok"));
      assertTrue(content.contains("PerConnectionFileHandlerTest"));
    } finally {
      customLogger.removeHandler(percentHandler);
      percentHandler.close();
    }

    percentHandler.registerConnection("after-close");
    try (BigQueryJdbcMdc.MdcCloseable m3 = BigQueryJdbcMdc.registerInstance("after-close")) {
      percentHandler.publish(new LogRecord(Level.INFO, "Ignored after handler close"));
    }

    try (Stream<Path> stream = Files.list(literalPercentDir)) {
      List<Path> files = stream.collect(Collectors.toList());
      assertTrue(files.stream().noneMatch(p -> p.getFileName().toString().endsWith(".lck")));
      assertTrue(files.stream().noneMatch(p -> p.getFileName().toString().endsWith("-afte.log")));
      assertEquals(
          2L, files.stream().filter(p -> p.getFileName().toString().endsWith("-abcd.log")).count());
    }
  }

  @Test
  public void testOneGibDefaultAndBackupFileRotationAndTypedParams() throws IOException {
    assertEquals(1024L * 1024L * 1024L, PerConnectionFileHandler.DEFAULT_MAX_LOG_FILE_BYTES);
    String prop = PerConnectionFileHandler.MAX_LOG_FILE_BYTES_SYSTEM_PROPERTY;
    String prev = System.getProperty(prop);
    try {
      System.setProperty(prop, "3000000000");
      assertEquals(3_000_000_000L, PerConnectionFileHandler.resolveMaxLogFileBytes());
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

    Path boundedDir = tempDir.resolve("bounded");
    long maxBytes = 1024L;
    PerConnectionFileHandler defaultMaxHandler =
        new PerConnectionFileHandler(tempDir.resolve("def_max").toString(), Level.INFO, 0L);
    defaultMaxHandler.close();

    ConnectionLogContext connCtx =
        new ConnectionLogContext("rotc-uuid", ConnectionLogContext.ALL_VALUE);
    assertEquals(ConnectionLogContext.ALL_VALUE, connCtx.levelValue());
    connCtx.setLevelValue(ConnectionLogContext.OFF_VALUE);
    assertEquals(ConnectionLogContext.OFF_VALUE, connCtx.levelValue());
    assertEquals("rotc-uuid", connCtx.toString());
    assertNull(ConnectionLogContext.extractFromParameters(null));

    PerConnectionFileHandler boundedHandler =
        new PerConnectionFileHandler(boundedDir.toString(), Level.FINEST, maxBytes);
    try {
      for (int i = 0; i < 40; i++) {
        boundedHandler.publish(
            new LogRecord(Level.INFO, "Padding log line to exceed 1 KiB limit #" + i));
      }
      // Route via ConnectionLogContext in params[0] with empty MDC and trigger per-conn .1.log
      boundedHandler.registerConnection("rotc-uuid");
      BigQueryJdbcMdc.clear();
      for (int i = 0; i < 15; i++) {
        LogRecord ctxRec = new LogRecord(Level.INFO, "Per-conn ctx rotation line #" + i);
        ctxRec.setParameters(new Object[] {connCtx});
        boundedHandler.publish(ctxRec);
      }
      // Plain String in params[0] with empty MDC routes to global log instead of "-BigQ.log"
      LogRecord retryRecord = new LogRecord(Level.FINEST, "Retrying RPC");
      retryRecord.setParameters(new Object[] {"BigQuery retried method: getQueryResults"});
      boundedHandler.publish(retryRecord);
      assertTrue(BigQueryJdbcRootLogger.getFormatter().format(retryRecord).contains("[NO_CONN]"));
      boundedHandler.flush();
    } finally {
      boundedHandler.close();
    }

    Path boundedGlobal = boundedDir.resolve("BQ-JDBC-GLOBAL.log");
    Path boundedBackup = boundedDir.resolve("BQ-JDBC-GLOBAL.1.log");
    assertTrue(Files.size(boundedGlobal) > 0 && Files.size(boundedGlobal) <= maxBytes);
    assertTrue(Files.size(boundedBackup) > 0 && Files.size(boundedBackup) <= maxBytes);
    assertFalse(Files.exists(boundedDir.resolve("BQ-JDBC-GLOBAL.2.log")));
    assertTrue(findLogFile(boundedDir, "-rotc.log").isPresent());
    assertTrue(findLogFile(boundedDir, "-rotc.1.log").isPresent());
    assertFalse(findLogFile(boundedDir, "-BigQ.log").isPresent());
    if (boundedBackup.getFileSystem().supportedFileAttributeViews().contains("posix")) {
      assertMode(boundedBackup, "rw-------");
      assertMode(boundedGlobal, "rw-------");
      assertMode(findLogFile(boundedDir, "-rotc.1.log").get(), "rw-------");

      // Symlink at .1.log is deleted safely without modifying target; foreign owner falls back
      Path symDir = tempDir.resolve("sym_rot");
      Files.createDirectories(symDir);
      Path untouchedTarget =
          Files.write(tempDir.resolve("untouched.txt"), "safe".getBytes(StandardCharsets.UTF_8));
      Files.createSymbolicLink(symDir.resolve("BQ-JDBC-GLOBAL.1.log"), untouchedTarget);
      PerConnectionFileHandler symRotHandler =
          new PerConnectionFileHandler(symDir.toString(), Level.INFO, maxBytes);
      String origUser = System.getProperty("user.name");
      try {
        for (int i = 0; i < 12; i++) {
          symRotHandler.publish(new LogRecord(Level.INFO, "Symlink backup rotation line #" + i));
        }
        assertEquals("safe", readUtf8(untouchedTarget));
        assertFalse(Files.isSymbolicLink(symDir.resolve("BQ-JDBC-GLOBAL.1.log")));
        System.setProperty("user.name", "other_user");
        for (int i = 0; i < 12; i++) {
          symRotHandler.publish(new LogRecord(Level.INFO, "Foreign backup fallback line #" + i));
        }
        symRotHandler.flush();
        assertTrue(readUtf8(symDir.resolve("BQ-JDBC-GLOBAL.log")).contains("fallback line #11"));
      } finally {
        if (origUser != null) {
          System.setProperty("user.name", origUser);
        } else {
          System.clearProperty("user.name");
        }
        symRotHandler.close();
      }
    }
    String backupContent = readUtf8(boundedBackup);
    String activeContent = readUtf8(boundedGlobal);
    assertFalse(backupContent.contains("limit #0") || activeContent.contains("limit #0"));
    assertTrue(backupContent.contains("Padding log line"));
    assertTrue(activeContent.contains("Retrying RPC"));

    // Non-regular directory blocking .1.log falls back gracefully to in-place truncation
    Path fallbackDir = tempDir.resolve("fallback_rot");
    Files.createDirectories(fallbackDir.resolve("BQ-JDBC-GLOBAL.1.log"));
    PerConnectionFileHandler fallbackHandler =
        new PerConnectionFileHandler(fallbackDir.toString(), Level.INFO, maxBytes);
    try {
      for (int i = 0; i < 20; i++) {
        fallbackHandler.publish(
            new LogRecord(Level.INFO, "Fallback line exceeding 1 KiB cap #" + i));
      }
      fallbackHandler.flush();
    } finally {
      fallbackHandler.close();
    }
    Path fallbackGlobal = fallbackDir.resolve("BQ-JDBC-GLOBAL.log");
    assertTrue(Files.size(fallbackGlobal) > 0 && Files.size(fallbackGlobal) <= maxBytes);
    assertTrue(readUtf8(fallbackGlobal).contains("cap #19"));
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
      ExecutorService pool = Executors.newFixedThreadPool(3);
      Runnable publishLoop =
          () -> {
            try (BigQueryJdbcMdc.MdcCloseable m = BigQueryJdbcMdc.registerInstance(connId)) {
              start.await();
              for (int i = 0; i < 10; i++) {
                raceHandler.publish(new LogRecord(Level.INFO, "race msg " + i));
              }
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          };
      try {
        Future<?> pubTask1 = pool.submit(publishLoop);
        Future<?> pubTask2 = pool.submit(publishLoop);
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
        pubTask1.get(5, TimeUnit.SECONDS);
        pubTask2.get(5, TimeUnit.SECONDS);
        closeTask.get(5, TimeUnit.SECONDS);
      } finally {
        pool.shutdownNow();
      }
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
      ConnectionLogContext activeCtx = BigQueryJdbcRootLogger.registerConnection(connId);
      assertNotNull(activeCtx);
      assertEquals(ConnectionLogContext.ALL_VALUE, activeCtx.levelValue());
      finestHandler.registerConnection(connId);

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

      assertThrows(SQLException.class, () -> rs.getShort(1));
      assertThrows(SQLException.class, () -> rs.findColumn(null));

      activeStructLogger.finestTrace("getAttributes");
      BigQueryJdbcResultSetLogger.getLogger(BigQueryArrowStruct.class, connId)
          .finestTrace("getAttributes");

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
      assertNull(BigQueryJdbcRootLogger.registerConnection(null));
      assertNull(BigQueryJdbcRootLogger.registerConnection(""));
      BigQueryJdbcRootLogger.closeConnectionHandler(null);
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
      try (Stream<Path> files = Files.list(failLogDir)) {
        List<Path> created = files.collect(Collectors.toList());
        assertTrue(created.stream().anyMatch(p -> !p.endsWith("BQ-JDBC-GLOBAL.log")));
        assertTrue(created.stream().noneMatch(p -> p.getFileName().toString().endsWith(".lck")));
      }
    } finally {
      BigQueryJdbcRootLogger.setLevel(Level.OFF, null);
    }
  }
}

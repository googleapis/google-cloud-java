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
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.jdbc.utils.TestUtilities;
import com.google.cloud.bigquery.jdbc.utils.URIBuilder;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.ErrorManager;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    assertFalse(Files.exists(defaultLog));
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

  private static boolean isPosix() {
    return FileSystems.getDefault().supportedFileAttributeViews().contains("posix");
  }

  private static ErrorManager silentErrorManager() {
    return new ErrorManager() {
      @Override
      public synchronized void error(String msg, Exception ex, int code) {}
    };
  }

  @Test
  public void testPosixOwnerOnlyPermissionsOnCreatedDirsAndFiles() throws IOException {
    assumeTrue(isPosix(), "POSIX permissions required");
    Path nestedDir = tempDir.resolve("nested").resolve("logs");
    PerConnectionFileHandler nestedHandler =
        new PerConnectionFileHandler(nestedDir.toString(), Level.INFO);
    try {
      nestedHandler.publish(new LogRecord(Level.INFO, "global perm check"));
      BigQueryJdbcMdc.registerInstance("BQ-JDBC-perm1234");
      nestedHandler.publish(new LogRecord(Level.INFO, "perm check"));

      Set<PosixFilePermission> expectedDir = PosixFilePermissions.fromString("rwx------");
      Set<PosixFilePermission> expectedFile = PosixFilePermissions.fromString("rw-------");
      assertEquals(
          expectedDir,
          Files.getPosixFilePermissions(nestedDir.getParent(), LinkOption.NOFOLLOW_LINKS));
      assertEquals(
          expectedDir, Files.getPosixFilePermissions(nestedDir, LinkOption.NOFOLLOW_LINKS));
      assertEquals(
          expectedFile,
          Files.getPosixFilePermissions(
              nestedDir.resolve("BQ-JDBC-GLOBAL.log"), LinkOption.NOFOLLOW_LINKS));
      try (Stream<Path> stream = Files.list(nestedDir)) {
        List<Path> connFiles =
            stream
                .filter(p -> p.getFileName().toString().endsWith("-perm.log"))
                .collect(Collectors.toList());
        assertEquals(1, connFiles.size());
        assertEquals(
            expectedFile,
            Files.getPosixFilePermissions(connFiles.get(0), LinkOption.NOFOLLOW_LINKS));
      }
    } finally {
      nestedHandler.close();
    }
  }

  @Test
  public void testCreateDirectoryUnderSharedNonSymlinkAncestor() throws IOException {
    assumeTrue(isPosix(), "POSIX permissions required");
    Path sharedParent = tempDir.resolve("shared-parent");
    Files.createDirectory(sharedParent);
    Files.setPosixFilePermissions(sharedParent, PosixFilePermissions.fromString("rwxr-xr-x"));

    Path leafDir = sharedParent.resolve("driver-logs");
    PerConnectionFileHandler subHandler =
        new PerConnectionFileHandler(leafDir.toString(), Level.INFO);
    try {
      subHandler.publish(new LogRecord(Level.INFO, "global init"));
      assertEquals(
          PosixFilePermissions.fromString("rwx------"),
          Files.getPosixFilePermissions(leafDir, LinkOption.NOFOLLOW_LINKS));
      assertEquals(
          PosixFilePermissions.fromString("rwxr-xr-x"),
          Files.getPosixFilePermissions(sharedParent, LinkOption.NOFOLLOW_LINKS));
      assertTrue(Files.exists(leafDir.resolve("BQ-JDBC-GLOBAL.log"), LinkOption.NOFOLLOW_LINKS));
    } finally {
      subHandler.close();
    }
  }

  @Test
  public void testExistingDirectoryKeeps0755Permissions() throws IOException {
    assumeTrue(isPosix(), "POSIX permissions required");
    Path existingDir = tempDir.resolve("existing-0755");
    Files.createDirectory(existingDir);
    Set<PosixFilePermission> mode0755 = PosixFilePermissions.fromString("rwxr-xr-x");
    Files.setPosixFilePermissions(existingDir, mode0755);

    PerConnectionFileHandler existingDirHandler =
        new PerConnectionFileHandler(existingDir.toString(), Level.INFO);
    try {
      existingDirHandler.publish(new LogRecord(Level.INFO, "preserve mode check"));
      assertEquals(mode0755, Files.getPosixFilePermissions(existingDir, LinkOption.NOFOLLOW_LINKS));
    } finally {
      existingDirHandler.close();
    }
  }

  @Test
  public void testSymbolicLinksAndNonRegularPathsAreRejected() throws IOException {
    assumeTrue(isPosix(), "Symbolic link creation required");
    Path victimFile = tempDir.resolve("victim-secret.txt");
    Files.write(victimFile, "TOP-SECRET".getBytes(StandardCharsets.UTF_8));

    Path realTargetDir = tempDir.resolve("real-dir");
    Files.createDirectory(realTargetDir);
    Path symlinkLeafDir = tempDir.resolve("symlink-dir");
    Files.createSymbolicLink(symlinkLeafDir, realTargetDir);

    PerConnectionFileHandler symlinkDirHandler =
        new PerConnectionFileHandler(symlinkLeafDir.toString(), Level.INFO);
    symlinkDirHandler.setErrorManager(silentErrorManager());
    try {
      symlinkDirHandler.publish(new LogRecord(Level.INFO, "must not write"));
      assertFalse(Files.exists(realTargetDir.resolve("BQ-JDBC-GLOBAL.log")));
    } finally {
      symlinkDirHandler.close();
    }

    Path symlinkGlobalDir = tempDir.resolve("symlink-global-dir");
    Files.createDirectory(symlinkGlobalDir);
    Files.createSymbolicLink(symlinkGlobalDir.resolve("BQ-JDBC-GLOBAL.log"), victimFile);
    PerConnectionFileHandler symlinkGlobalHandler =
        new PerConnectionFileHandler(symlinkGlobalDir.toString(), Level.INFO);
    symlinkGlobalHandler.setErrorManager(silentErrorManager());
    try {
      symlinkGlobalHandler.publish(new LogRecord(Level.INFO, "must not clobber victim"));
      assertEquals(
          "TOP-SECRET", new String(Files.readAllBytes(victimFile), StandardCharsets.UTF_8));
      try (Stream<Path> stream = Files.list(symlinkGlobalDir)) {
        assertTrue(
            stream.anyMatch(p -> p.getFileName().toString().startsWith("BQ-JDBC-GLOBAL-")),
            "Handler should fall back to unique global log when primary is a symlink");
      }
    } finally {
      symlinkGlobalHandler.close();
    }
  }

  @Test
  public void testPercentTokensCollisionSuffixesAndNoLockFiles() throws IOException {
    Path literalPercentDir = tempDir.resolve("logs-%t-%h-%g-%u");
    PerConnectionFileHandler pctHandler =
        new PerConnectionFileHandler(literalPercentDir.toString(), Level.INFO);
    try {
      BigQueryJdbcMdc.registerInstance("BQ-JDBC-abcd-1111");
      pctHandler.publish(new LogRecord(Level.INFO, "conn one"));
      BigQueryJdbcMdc.registerInstance("BQ-JDBC-abcd-2222");
      pctHandler.publish(new LogRecord(Level.INFO, "conn two"));

      assertTrue(Files.isDirectory(literalPercentDir, LinkOption.NOFOLLOW_LINKS));
      try (Stream<Path> stream = Files.list(literalPercentDir)) {
        List<Path> files = stream.collect(Collectors.toList());
        assertFalse(
            files.stream().anyMatch(p -> p.getFileName().toString().endsWith(".lck")),
            "No JUL .lck sidecar files should be created");
        long abcdFiles =
            files.stream().filter(p -> p.getFileName().toString().endsWith("-abcd.log")).count();
        assertEquals(2L, abcdFiles, "Colliding 4-char connection prefixes must get distinct files");
      }
    } finally {
      pctHandler.close();
    }
  }

  @Test
  public void testConcurrentGlobalHandlerContentionFallsBackToUniqueGlobalLog() throws IOException {
    Path contendedDir = tempDir.resolve("contended-global");
    PerConnectionFileHandler first =
        new PerConnectionFileHandler(contendedDir.toString(), Level.INFO);
    PerConnectionFileHandler second =
        new PerConnectionFileHandler(contendedDir.toString(), Level.INFO);
    try {
      first.publish(new LogRecord(Level.INFO, "first-owner-msg"));
      for (int i = 0; i < 5; i++) {
        PerConnectionFileHandler noGlobalRecords =
            new PerConnectionFileHandler(contendedDir.toString(), Level.INFO);
        noGlobalRecords.close();
      }
      second.publish(new LogRecord(Level.INFO, "second-contender-msg"));

      String primaryContent =
          new String(
              Files.readAllBytes(contendedDir.resolve("BQ-JDBC-GLOBAL.log")),
              StandardCharsets.UTF_8);
      assertTrue(primaryContent.contains("first-owner-msg"));
      assertFalse(primaryContent.contains("second-contender-msg"));

      try (Stream<Path> stream = Files.list(contendedDir)) {
        List<Path> fallbacks =
            stream
                .filter(p -> p.getFileName().toString().startsWith("BQ-JDBC-GLOBAL-"))
                .collect(Collectors.toList());
        assertEquals(1, fallbacks.size());
        String fallbackContent =
            new String(Files.readAllBytes(fallbacks.get(0)), StandardCharsets.UTF_8);
        assertTrue(fallbackContent.contains("second-contender-msg"));
      }
    } finally {
      second.close();
      first.close();
    }
  }

  @Test
  public void testForeignOwnedGlobalLogFallsBackAndHardLinkIsRejected() throws IOException {
    assumeTrue(isPosix(), "POSIX links and ownership required");
    Path dir = tempDir.resolve("foreign-uid-dir");
    Files.createDirectory(
        dir, PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rwx------")));
    Path primaryGlobal = dir.resolve("BQ-JDBC-GLOBAL.log");
    Files.write(primaryGlobal, "FOREIGN-DATA".getBytes(StandardCharsets.UTF_8));

    PerConnectionFileHandler.overrideUidForTesting = 999_999_999;
    try {
      // Directory itself is also checked against effective UID; when foreign-owned, directory is
      // rejected cleanly without clobbering primaryGlobal.
      PerConnectionFileHandler rejectedDirHandler =
          new PerConnectionFileHandler(dir.toString(), Level.INFO);
      rejectedDirHandler.setErrorManager(silentErrorManager());
      try {
        rejectedDirHandler.publish(new LogRecord(Level.INFO, "should not write"));
        assertEquals(
            "FOREIGN-DATA", new String(Files.readAllBytes(primaryGlobal), StandardCharsets.UTF_8));
      } finally {
        rejectedDirHandler.close();
      }
    } finally {
      PerConnectionFileHandler.overrideUidForTesting = null;
    }

    // Hard-linked global file (nlink == 2) must not be written to in-place; falls back cleanly.
    Path hardLinkDir = tempDir.resolve("hardlink-dir");
    Files.createDirectory(hardLinkDir);
    Path target = tempDir.resolve("hardlink-target.txt");
    Files.write(target, "ORIGINAL".getBytes(StandardCharsets.UTF_8));
    Files.createLink(hardLinkDir.resolve("BQ-JDBC-GLOBAL.log"), target);

    PerConnectionFileHandler hardLinkHandler =
        new PerConnectionFileHandler(hardLinkDir.toString(), Level.INFO);
    try {
      hardLinkHandler.publish(new LogRecord(Level.INFO, "isolated-from-hardlink"));
      assertEquals("ORIGINAL", new String(Files.readAllBytes(target), StandardCharsets.UTF_8));
      try (Stream<Path> stream = Files.list(hardLinkDir)) {
        assertTrue(stream.anyMatch(p -> p.getFileName().toString().startsWith("BQ-JDBC-GLOBAL-")));
      }
    } finally {
      hardLinkHandler.close();
    }
  }

  @Test
  public void testInterruptedPublishPreservesInterruptFlagAndKeepsChannelAlive()
      throws IOException {
    BigQueryJdbcMdc.registerInstance("BQ-JDBC-intr1234");
    Thread.currentThread().interrupt();
    try {
      handler.publish(new LogRecord(Level.INFO, "message while interrupted"));
      assertTrue(
          Thread.currentThread().isInterrupted(),
          "Caller thread interrupt status must be preserved");
    } finally {
      Thread.interrupted(); // clear interrupt flag for subsequent assertions
    }

    handler.publish(new LogRecord(Level.INFO, "message after interrupt"));
    Optional<Path> connLog = findLogFile("-intr.log");
    assertTrue(connLog.isPresent());
    String content = new String(Files.readAllBytes(connLog.get()), StandardCharsets.UTF_8);
    assertTrue(content.contains("message while interrupted"));
    assertTrue(content.contains("message after interrupt"));
  }

  private static Optional<Path> findLogFileInDir(Path dir, String suffix) throws IOException {
    try (Stream<Path> stream = Files.list(dir)) {
      return stream
          .filter(
              p ->
                  p.getFileName().toString().startsWith("BQ-JDBC-")
                      && p.getFileName().toString().endsWith(suffix))
          .findFirst();
    }
  }

  @Test
  public void testResolveMaxLogFileBytesSystemPropertyValidation() {
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
      System.setProperty(prop, "512MB");
      assertEquals(
          PerConnectionFileHandler.DEFAULT_MAX_LOG_FILE_BYTES,
          PerConnectionFileHandler.resolveMaxLogFileBytes());
      // Repeated identical bad value does not re-emit ErrorManager warning
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
  public void testBackupFileRotationAndParameterContextRouting() throws IOException {
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
      BigQueryJdbcMdc.clear();
      for (int i = 0; i < 15; i++) {
        LogRecord ctxRec = new LogRecord(Level.INFO, "Per-conn rotation line #" + i);
        ctxRec.setParameters(new Object[] {connCtx});
        boundedHandler.publish(ctxRec);
      }
      LogRecord retryRecord = new LogRecord(Level.FINEST, "Retrying RPC");
      retryRecord.setParameters(new Object[] {"BigQuery retried method: getQueryResults"});
      boundedHandler.publish(retryRecord);
      assertTrue(BigQueryJdbcRootLogger.getFormatter().format(retryRecord).contains("[NO_CONN]"));
    } finally {
      boundedHandler.close();
    }

    Path boundedGlobal = boundedDir.resolve("BQ-JDBC-GLOBAL.log");
    Path boundedBackup = boundedDir.resolve("BQ-JDBC-GLOBAL.1.log");
    assertTrue(Files.size(boundedGlobal) > 0 && Files.size(boundedGlobal) <= maxBytes);
    assertTrue(Files.size(boundedBackup) > 0 && Files.size(boundedBackup) <= maxBytes);
    assertFalse(Files.exists(boundedDir.resolve("BQ-JDBC-GLOBAL.2.log")));
    assertTrue(findLogFileInDir(boundedDir, "-rotc.log").isPresent());
    assertTrue(findLogFileInDir(boundedDir, "-rotc.1.log").isPresent());
    assertFalse(findLogFileInDir(boundedDir, "-BigQ.log").isPresent());

    if (isPosix()) {
      Set<PosixFilePermission> expected0600 = PosixFilePermissions.fromString("rw-------");
      assertEquals(
          expected0600, Files.getPosixFilePermissions(boundedBackup, LinkOption.NOFOLLOW_LINKS));
      assertEquals(
          expected0600, Files.getPosixFilePermissions(boundedGlobal, LinkOption.NOFOLLOW_LINKS));
      assertEquals(
          expected0600,
          Files.getPosixFilePermissions(
              findLogFileInDir(boundedDir, "-rotc.1.log").get(), LinkOption.NOFOLLOW_LINKS));
    }
  }

  @Test
  public void testRotationDeletesSymlinkBackupAndReplacesExistingBackup() throws IOException {
    assumeTrue(isPosix(), "POSIX symbolic links required");
    long maxBytes = 1024L;
    Path symDir = tempDir.resolve("sym_rot");
    Files.createDirectories(symDir);
    Path untouchedTarget = tempDir.resolve("untouched.txt");
    Files.write(untouchedTarget, "safe".getBytes(StandardCharsets.UTF_8));
    Files.createSymbolicLink(symDir.resolve("BQ-JDBC-GLOBAL.1.log"), untouchedTarget);
    PerConnectionFileHandler symRotHandler =
        new PerConnectionFileHandler(symDir.toString(), Level.INFO, maxBytes);
    symRotHandler.setErrorManager(silentErrorManager());
    try {
      for (int i = 0; i < 12; i++) {
        symRotHandler.publish(new LogRecord(Level.INFO, "Symlink backup rotation line #" + i));
      }
      assertEquals("safe", new String(Files.readAllBytes(untouchedTarget), StandardCharsets.UTF_8));
      assertFalse(Files.isSymbolicLink(symDir.resolve("BQ-JDBC-GLOBAL.1.log")));

      // Simulated UID mismatch on existing .1.log still rotates cleanly via atomic move
      PerConnectionFileHandler.overrideUidForTesting = 888_888_888;
      try {
        for (int i = 0; i < 12; i++) {
          symRotHandler.publish(new LogRecord(Level.INFO, "Foreign backup rotation line #" + i));
        }
      } finally {
        PerConnectionFileHandler.overrideUidForTesting = null;
      }
      assertTrue(Files.exists(symDir.resolve("BQ-JDBC-GLOBAL.1.log"), LinkOption.NOFOLLOW_LINKS));
      assertTrue(
          new String(
                  Files.readAllBytes(symDir.resolve("BQ-JDBC-GLOBAL.log")), StandardCharsets.UTF_8)
              .contains("rotation line #11"));
    } finally {
      symRotHandler.close();
    }
  }

  @Test
  public void testBlockedBackupDirectoryTruncatesWithMarkerAndWritesLargeChunks()
      throws IOException {
    long maxBytes = 1024L;
    Path fallbackDir = tempDir.resolve("fallback_rot");
    Files.createDirectories(fallbackDir.resolve("BQ-JDBC-GLOBAL.1.log"));
    PerConnectionFileHandler fallbackHandler =
        new PerConnectionFileHandler(fallbackDir.toString(), Level.INFO, maxBytes);
    fallbackHandler.setErrorManager(silentErrorManager());
    try {
      for (int i = 0; i < 20; i++) {
        fallbackHandler.publish(
            new LogRecord(Level.INFO, "Fallback line exceeding 1 KiB cap #" + i));
      }
    } finally {
      fallbackHandler.close();
    }
    Path fallbackGlobal = fallbackDir.resolve("BQ-JDBC-GLOBAL.log");
    assertTrue(Files.size(fallbackGlobal) > 0 && Files.size(fallbackGlobal) <= maxBytes);
    String truncatedContent =
        new String(Files.readAllBytes(fallbackGlobal), StandardCharsets.UTF_8);
    assertTrue(truncatedContent.contains("[LOG TRUNCATED: backup rotation failed (IOException)]"));
    assertTrue(truncatedContent.contains("cap #19"));

    // Large payload (> 8 KiB) exercises 8 KiB chunked ByteBuffer writes without data loss
    Path chunkDir = tempDir.resolve("chunk_write");
    PerConnectionFileHandler chunkHandler =
        new PerConnectionFileHandler(chunkDir.toString(), Level.INFO);
    try {
      StringBuilder largePayload = new StringBuilder(20_000);
      for (int i = 0; i < 2_000; i++) {
        largePayload.append("0123456789");
      }
      chunkHandler.publish(new LogRecord(Level.INFO, largePayload.toString()));
      String written =
          new String(
              Files.readAllBytes(chunkDir.resolve("BQ-JDBC-GLOBAL.log")), StandardCharsets.UTF_8);
      assertTrue(written.contains(largePayload.toString()));
      // Exercise DeduplicatingErrorManager on repeated vs distinct error keys
      ErrorManager em = chunkHandler.getErrorManager();
      assertNotNull(em);
      em.error("test-dedup-msg", null, ErrorManager.WRITE_FAILURE);
      em.error("test-dedup-msg", null, ErrorManager.WRITE_FAILURE);
    } finally {
      chunkHandler.close();
    }
  }

  @Test
  public void testConcurrentCloseAndPublishLeavesNoOpenConnectionFiles() throws Exception {
    Path raceDir = tempDir.resolve("race");
    for (int round = 0; round < 15; round++) {
      PerConnectionFileHandler raceHandler =
          new PerConnectionFileHandler(
              raceDir.resolve("r" + round).toString(), Level.INFO, 0L, true);
      String connId = "race-" + round;
      raceHandler.registerConnection(connId, Level.INFO);
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
        final int r = round;
        Future<?> closeTask =
            pool.submit(
                () -> {
                  try {
                    start.await();
                    if (r % 2 == 0) {
                      raceHandler.closeHandler(connId);
                    } else {
                      raceHandler.close();
                    }
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
      } finally {
        raceHandler.close();
      }
    }
  }

  @Test
  public void testPostCloseResultSetAndStringParamsDoNotResurrectHandlers() throws Exception {
    Path leakDir = tempDir.resolve("no_leak");
    String connId = "dead-conn-uuid";
    try {
      BigQueryJdbcRootLogger.registerConnection(connId, "7", leakDir.toString());
      ConnectionLogContext activeCtx = BigQueryJdbcRootLogger.getConnectionContext(connId);
      assertNotNull(activeCtx);
      assertTrue(BigQueryJdbcRootLogger.isConnectionActive(connId));

      BigQueryStatement mockStmt = mock(BigQueryStatement.class);
      mockStmt.connectionId = connId;
      Schema schema = Schema.of(FieldList.of(Field.of("col", StandardSQLTypeName.INT64)));
      BigQueryJsonResultSet rs =
          BigQueryJsonResultSet.of(schema, 0, null, mockStmt, new Future<?>[0]);
      BigQueryJdbcResultSetLogger activeStructLogger = rs.LOG.getArrowStructLogger();

      rs.LOG.finestTrace("beforeClose", "Before close trace");
      Optional<Path> initialLog = findLogFileInDir(leakDir, "-dead.log");
      assertTrue(initialLog.isPresent());

      rs.close();
      BigQueryJdbcRootLogger.closeConnectionHandler(connId);
      assertFalse(BigQueryJdbcRootLogger.isConnectionActive(connId));
      assertEquals(ConnectionLogContext.OFF_VALUE, activeCtx.levelValue());
      Files.delete(initialLog.get());

      assertThrows(SQLException.class, () -> rs.getShort(1));
      assertThrows(SQLException.class, () -> rs.findColumn(null));
      activeStructLogger.finestTrace("getAttributes");
      BigQueryJdbcResultSetLogger.getLogger(BigQueryArrowStruct.class, connId)
          .finestTrace("getAttributes");

      assertFalse(findLogFileInDir(leakDir, "-dead.log").isPresent());

      Formatter formatter = BigQueryJdbcRootLogger.getFormatter();
      LogRecord retryRecord = new LogRecord(Level.FINEST, "Retrying RPC");
      retryRecord.setParameters(new Object[] {"BigQuery retried method: getQueryResults"});
      assertTrue(formatter.format(retryRecord).contains("[NO_CONN]"));
    } finally {
      BigQueryJdbcRootLogger.resetForTest();
    }
  }

  @Test
  public void testFailedConnectionConstructorCleansUpActiveRegistration() {
    Path failLogDir = tempDir.resolve("failed_conn_logs");
    int baselineActive = BigQueryJdbcRootLogger.activeConnectionCount();
    String invalidAuthUrl =
        new URIBuilder(TestUtilities.getBaseConnectionUrl())
            .append("ProjectId", "test-proj")
            .append("OAuthType", 99)
            .append("LogLevel", 6)
            .append("LogPath", failLogDir.toString())
            .toString();

    try {
      assertThrows(RuntimeException.class, () -> new BigQueryConnection(invalidAuthUrl));
      assertEquals(baselineActive, BigQueryJdbcRootLogger.activeConnectionCount());
    } finally {
      BigQueryJdbcRootLogger.resetForTest();
    }
  }

  @Test
  public void testUnclosedGarbageCollectedConnectionsReclaimLogHandlersAndSlots() throws Exception {
    Path leakedLogDir = tempDir.resolve("leaked_conn_logs");
    BigQueryJdbcRootLogger.resetForTest();
    int leakedCount = 20;
    String url =
        new URIBuilder(TestUtilities.getBaseConnectionUrl())
            .append("OAuthType", 2)
            .append("OAuthAccessToken", "RedactedToken")
            .append("ProjectId", "test-proj")
            .append("LogLevel", 7)
            .append("LogPath", leakedLogDir.toString())
            .toString();

    try {
      List<String> leakedIds = allocateAndDropLeakedConnections(url, leakedCount);
      assertEquals(leakedCount, leakedIds.size());

      long deadlineNanos = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
      while (System.nanoTime() < deadlineNanos
          && (BigQueryJdbcRootLogger.activeConnectionCount() > 0
              || countManagedRootFileHandlers() > 0)) {
        System.gc();
        Thread.sleep(50L);
      }

      assertEquals(0, BigQueryJdbcRootLogger.activeConnectionCount());
      assertEquals(0, countManagedRootFileHandlers());
      assertEquals(Level.OFF, BigQueryJdbcRootLogger.getRootLogger().getLevel());
      for (String id : leakedIds) {
        assertFalse(BigQueryJdbcRootLogger.isConnectionActive(id));
      }

      // Verify BQ-JDBC-GLOBAL.log channel and sentinel lock were closed and released upon GC
      try (Stream<Path> before = Files.list(leakedLogDir)) {
        long fallbackBefore =
            before.filter(p -> p.getFileName().toString().startsWith("BQ-JDBC-GLOBAL-")).count();
        assertEquals(0L, fallbackBefore);
      }
      PerConnectionFileHandler verifyReleased =
          new PerConnectionFileHandler(leakedLogDir.toString(), Level.INFO);
      try {
        verifyReleased.publish(new LogRecord(Level.INFO, "verify-primary-reacquired"));
        try (Stream<Path> after = Files.list(leakedLogDir)) {
          long fallbackAfter =
              after.filter(p -> p.getFileName().toString().startsWith("BQ-JDBC-GLOBAL-")).count();
          assertEquals(0L, fallbackAfter);
        }
      } finally {
        verifyReleased.close();
      }
    } finally {
      BigQueryJdbcRootLogger.resetForTest();
    }
  }

  @Test
  public void testClosedWriterOnRotationFailureEvictsAndRecovers() throws IOException {
    Path recoverDir = tempDir.resolve("recover_rot");
    PerConnectionFileHandler recoverHandler =
        new PerConnectionFileHandler(recoverDir.toString(), Level.INFO, 512L, true);
    recoverHandler.setErrorManager(silentErrorManager());
    String connId = "BQ-JDBC-rcvr1234";
    recoverHandler.registerConnection(connId, Level.INFO);
    try (BigQueryJdbcMdc.MdcCloseable mdc = BigQueryJdbcMdc.registerInstance(connId)) {
      recoverHandler.publish(new LogRecord(Level.INFO, "initial-record"));
      Optional<Path> firstFile = findLogFileInDir(recoverDir, "-rcvr.log");
      assertTrue(firstFile.isPresent());

      Files.delete(firstFile.get());
      Files.delete(recoverDir);

      for (int i = 0; i < 10; i++) {
        recoverHandler.publish(
            new LogRecord(Level.INFO, "Trigger rotation while directory is missing #" + i));
      }

      Files.createDirectories(recoverDir);
      recoverHandler.publish(new LogRecord(Level.INFO, "recovered-after-dir-restored"));

      Optional<Path> reopenedFile = findLogFileInDir(recoverDir, "-rcvr.log");
      assertTrue(reopenedFile.isPresent());
      assertTrue(
          new String(Files.readAllBytes(reopenedFile.get()), StandardCharsets.UTF_8)
              .contains("recovered-after-dir-restored"));
    } finally {
      recoverHandler.close();
    }
  }

  @Test
  public void testFailedLogOpenUsesRetryBackoff() throws IOException {
    Path unusableDir = tempDir.resolve("backoff_dir");
    AtomicInteger openCalls = new AtomicInteger();
    PerConnectionFileHandler backoffHandler =
        new PerConnectionFileHandler(unusableDir.toString(), Level.INFO, 0L, true) {
          @Override
          ChannelLogWriter createLogWriter(
              String id, Path logDir, Level writerLevel, long limitBytes) {
            openCalls.incrementAndGet();
            return null;
          }
        };
    backoffHandler.setErrorManager(silentErrorManager());
    String connId = "BQ-JDBC-bkof1234";
    backoffHandler.registerConnection(connId, Level.INFO);
    try (BigQueryJdbcMdc.MdcCloseable mdc = BigQueryJdbcMdc.registerInstance(connId)) {
      for (int i = 0; i < 50; i++) {
        backoffHandler.publish(new LogRecord(Level.INFO, "record-" + i));
      }
      // 1 attempt for connection slot + 1 fallback attempt for defaultWriter across all 50 records
      assertEquals(2, openCalls.get());
    } finally {
      backoffHandler.close();
    }
  }

  private static List<String> allocateAndDropLeakedConnections(String url, int count)
      throws SQLException {
    BigQueryDriver driver = new BigQueryDriver();
    List<String> ids = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      Connection leaked = driver.connect(url, new Properties());
      ids.add(leaked.unwrap(BigQueryConnection.class).getConnectionId());
    }
    assertEquals(count, BigQueryJdbcRootLogger.activeConnectionCount());
    assertEquals(1, countManagedRootFileHandlers());
    return ids;
  }

  private static int countManagedRootFileHandlers() {
    int count = 0;
    for (Handler h : BigQueryJdbcRootLogger.getRootLogger().getHandlers()) {
      if (h instanceof PerConnectionFileHandler) {
        count++;
      }
    }
    return count;
  }
}

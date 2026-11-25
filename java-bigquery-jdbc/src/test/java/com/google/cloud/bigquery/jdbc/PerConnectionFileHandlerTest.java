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
import com.google.cloud.bigquery.StandardSQLTypeName;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.logging.ErrorManager;
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
}

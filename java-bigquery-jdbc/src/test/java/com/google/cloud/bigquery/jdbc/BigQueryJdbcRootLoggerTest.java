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

package com.google.cloud.bigquery.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.bigquery.jdbc.utils.TestUtilities;
import com.google.cloud.bigquery.jdbc.utils.URIBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.TraceFlags;
import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.context.Scope;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class BigQueryJdbcRootLoggerTest {

  @AfterEach
  public void tearDown() {
    BigQueryJdbcMdc.clear();
    BigQueryJdbcRootLogger.resetForTest();
  }

  @Test
  public void testGetFormatterFormat() {
    Formatter formatter = BigQueryJdbcRootLogger.getFormatter();
    assertNotNull(formatter);

    LogRecord record = new LogRecord(Level.INFO, "Test message");
    record.setMillis(1713715200000L);
    record.setLoggerName("TestLogger");
    record.setSourceMethodName("testMethod");

    String formatted = formatter.format(record);

    assertTrue(formatted.contains("INFO"));
    assertTrue(formatted.contains("Test message"));
    assertTrue(formatted.contains("TestLogger"));
    assertTrue(formatted.contains("testMethod"));
    assertTrue(formatted.contains("---"));
  }

  @Test
  public void testThreadNameTruncation() {
    Formatter formatter = BigQueryJdbcRootLogger.getFormatter();
    LogRecord record = new LogRecord(Level.INFO, "Test message");

    String formatted = formatter.format(record);
    int startIndex = formatted.indexOf("--- [") + 5;
    int endIndex = formatted.indexOf("]", startIndex);
    String threadPart = formatted.substring(startIndex, endIndex).trim();

    assertTrue(threadPart.length() <= 15);
  }

  @Test
  public void testGetThreadName() {
    Thread current = Thread.currentThread();
    String name = BigQueryJdbcRootLogger.getThreadName(current.getId());
    assertEquals(current.getName(), name);
  }

  @Test
  public void testGetThreadNameNotFound() {
    String name = BigQueryJdbcRootLogger.getThreadName(-1);
    assertEquals("", name);
  }

  @Test
  public void testFormatterWithOpenTelemetrySpan() {
    SpanContext spanContext =
        SpanContext.create(
            "00000000000000000000000000000001",
            "0000000000000002",
            TraceFlags.getDefault(),
            TraceState.getDefault());
    Span span = Span.wrap(spanContext);
    try (Scope scope = span.makeCurrent()) {
      Formatter formatter = BigQueryJdbcRootLogger.getFormatter();
      LogRecord record = new LogRecord(Level.INFO, "Test message with span");
      String formatted = formatter.format(record);
      assertTrue(
          formatted.contains(
              "[trace_id=00000000000000000000000000000001 span_id=0000000000000002] "));
    }
  }

  @Test
  public void testConcurrentConnectionsIsolateLogLevelsAndDirectories(@TempDir Path tempDir)
      throws Exception {
    Path dirShared = tempDir.resolve("shared");
    Path dirOther = tempDir.resolve("other");
    Path dirOff = tempDir.resolve("off");
    String connFinest = "aaaa1111-0000-0000-0000-000000000001";
    String connSevere = "bbbb2222-0000-0000-0000-000000000002";
    String connInfoOther = "cccc3333-0000-0000-0000-000000000003";
    String connOff = "dddd4444-0000-0000-0000-000000000004";

    BigQueryJdbcRootLogger.registerConnection(connSevere, "1", dirShared.toString());
    BigQueryJdbcRootLogger.registerConnection(connFinest, "7", dirShared.toString());
    BigQueryJdbcRootLogger.registerConnection(connInfoOther, "3", dirOther.toString());
    BigQueryJdbcRootLogger.registerConnection(connOff, "0", dirOff.toString());

    assertEquals(Level.FINEST, BigQueryJdbcRootLogger.getRootLogger().getLevel());
    assertEquals(2, countManagedFileHandlers());

    BigQueryJdbcCustomLogger customLogger =
        new BigQueryJdbcCustomLogger("com.google.cloud.bigquery.jdbc.IsolationTest");
    BigQueryJdbcResultSetLogger rsFinest =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class, connFinest);
    BigQueryJdbcResultSetLogger rsSevere =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class, connSevere);

    ExecutorService pool = BigQueryJdbcMdc.newFixedThreadPool("IsolationPool", 2);
    try {
      try (BigQueryJdbcMdc.MdcCloseable ignored = BigQueryJdbcMdc.registerInstance(connFinest)) {
        customLogger.finest("A-finest-msg");
        pool.submit(() -> customLogger.finer("A-async-finer-msg")).get(5, TimeUnit.SECONDS);
      }
      try (BigQueryJdbcMdc.MdcCloseable ignored = BigQueryJdbcMdc.registerInstance(connSevere)) {
        customLogger.info("B-info-should-drop");
        customLogger.severe("B-severe-msg");
        rsFinest.finestTrace("next", "A-rs-interleaved-finest");
        rsSevere.fineTrace("next", "B-rs-fine-should-drop");
      }
      try (BigQueryJdbcMdc.MdcCloseable ignored = BigQueryJdbcMdc.registerInstance(connInfoOther)) {
        customLogger.fine("C-fine-should-drop");
        customLogger.info("C-info-msg");
      }
      try (BigQueryJdbcMdc.MdcCloseable ignored = BigQueryJdbcMdc.registerInstance(connOff)) {
        customLogger.severe("D-off-should-drop");
      }
    } finally {
      pool.shutdownNow();
    }

    assertFalse(Files.exists(dirOff));
    String logA = readConnectionLog(dirShared, "aaaa");
    assertTrue(logA.contains("A-finest-msg") && logA.contains("A-async-finer-msg"));
    assertTrue(logA.contains("A-rs-interleaved-finest"));
    assertFalse(logA.contains("B-severe-msg") || logA.contains("C-info-msg"));

    String logB = readConnectionLog(dirShared, "bbbb");
    assertTrue(logB.contains("B-severe-msg"));
    assertFalse(logB.contains("B-info-should-drop") || logB.contains("B-rs-fine-should-drop"));
    assertFalse(logB.contains("A-finest-msg"));

    String logC = readConnectionLog(dirOther, "cccc");
    assertTrue(logC.contains("C-info-msg"));
    assertFalse(logC.contains("C-fine-should-drop") || logC.contains("A-finest-msg"));

    BigQueryJdbcRootLogger.closeConnectionHandler(connSevere);
    assertEquals(2, countManagedFileHandlers());
    try (BigQueryJdbcMdc.MdcCloseable ignored = BigQueryJdbcMdc.registerInstance(connFinest)) {
      customLogger.finest("A-after-B-closed");
    }
    assertTrue(readConnectionLog(dirShared, "aaaa").contains("A-after-B-closed"));

    BigQueryJdbcRootLogger.closeConnectionHandler(connFinest);
    assertEquals(Level.INFO, BigQueryJdbcRootLogger.getRootLogger().getLevel());
    BigQueryJdbcRootLogger.closeConnectionHandler(connInfoOther);
    BigQueryJdbcRootLogger.closeConnectionHandler(connOff);
    assertEquals(Level.OFF, BigQueryJdbcRootLogger.getRootLogger().getLevel());
    assertEquals(0, countManagedFileHandlers());
  }

  @Test
  public void testSecondConnectionWithLogLevelOffDoesNotSilenceActiveConnection(
      @TempDir Path tempDir) throws Exception {
    String verboseUrl =
        new URIBuilder(TestUtilities.getBaseConnectionUrl())
            .append("OAuthType", 2)
            .append("OAuthAccessToken", "RedactedToken")
            .append("ProjectId", "test-project")
            .append("LogLevel", "7")
            .append("LogPath", tempDir.toString())
            .toString();
    String silentUrl =
        new URIBuilder(TestUtilities.getBaseConnectionUrl())
            .append("OAuthType", 2)
            .append("OAuthAccessToken", "RedactedToken")
            .append("ProjectId", "test-project")
            .append("LogLevel", "0")
            .toString();

    BigQueryDriver driver = new BigQueryDriver();
    try (Connection conn1 = driver.connect(verboseUrl, new Properties())) {
      try (Connection conn2 = driver.connect(silentUrl, new Properties())) {
        assertFalse(conn2.isClosed());
      }
      conn1.getAutoCommit();
      String shortId = conn1.unwrap(BigQueryConnection.class).getConnectionId().substring(0, 4);
      String log1 = readConnectionLog(tempDir, shortId);
      assertTrue(log1.contains("Driver info :") && log1.contains("getAutoCommit"));
    }
    assertEquals(0, countManagedFileHandlers());
  }

  @Test
  public void testPreConnectScopeRoutesToTargetDirectoryAndCleansUpOnFailure(@TempDir Path tempDir)
      throws Exception {
    Path activeDir = tempDir.resolve("active");
    Path failingDir = tempDir.resolve("failing");
    BigQueryJdbcRootLogger.registerConnection(
        "eeee5555-0000-0000-0000-000000000005", "7", activeDir.toString());

    BigQueryJdbcCustomLogger logger =
        new BigQueryJdbcCustomLogger("com.google.cloud.bigquery.jdbc.PreConnectTest");
    try (BigQueryJdbcMdc.MdcCloseable pre =
        BigQueryJdbcRootLogger.openPreConnectScope(Level.INFO, failingDir.toString())) {
      logger.fine("preconnect-fine-should-drop");
      logger.warning("preconnect-url-warning");
    }

    assertEquals(1, countManagedFileHandlers());
    String globalFailingLog =
        new String(
            Files.readAllBytes(failingDir.resolve("BQ-JDBC-GLOBAL.log")), StandardCharsets.UTF_8);
    assertTrue(globalFailingLog.contains("preconnect-url-warning"));
    assertFalse(globalFailingLog.contains("preconnect-fine-should-drop"));
    assertFalse(Files.exists(activeDir.resolve("BQ-JDBC-GLOBAL.log")));
  }

  private static int countManagedFileHandlers() {
    int count = 0;
    for (Handler h : BigQueryJdbcRootLogger.getRootLogger().getHandlers()) {
      if (h instanceof PerConnectionFileHandler) {
        count++;
      }
    }
    return count;
  }

  private static String readConnectionLog(Path dir, String shortPrefix) throws IOException {
    try (Stream<Path> stream = Files.list(dir)) {
      List<Path> matches =
          stream
              .filter(p -> p.getFileName().toString().endsWith("-" + shortPrefix + ".log"))
              .collect(Collectors.toList());
      assertEquals(1, matches.size());
      return new String(Files.readAllBytes(matches.get(0)), StandardCharsets.UTF_8);
    }
  }
}

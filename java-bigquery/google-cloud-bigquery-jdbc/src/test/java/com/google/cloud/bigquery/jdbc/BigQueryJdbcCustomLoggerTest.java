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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BigQueryJdbcCustomLoggerTest {

  private BigQueryJdbcCustomLogger logger;
  private TestHandler testHandler;

  private static class TestHandler extends Handler {
    private final List<LogRecord> records = new ArrayList<>();

    @Override
    public void publish(LogRecord record) {
      records.add(record);
    }

    @Override
    public void flush() {}

    @Override
    public void close() throws SecurityException {}

    public List<LogRecord> getRecords() {
      return records;
    }
  }

  @BeforeEach
  public void setUp() {
    logger = new BigQueryJdbcCustomLogger("TestLogger");
    testHandler = new TestHandler();
    logger.addHandler(testHandler);
    logger.setLevel(Level.ALL);
  }

  @AfterEach
  public void tearDown() {
    if (logger != null && testHandler != null) {
      logger.removeHandler(testHandler);
    }
  }

  @Test
  public void testLogWithCallerInference() {
    logger.fine("Test message with format %s", "arg");

    List<LogRecord> records = testHandler.getRecords();
    assertEquals(1, records.size());
    LogRecord record = records.get(0);

    assertEquals("testLogWithCallerInference", record.getSourceMethodName());
    assertEquals(BigQueryJdbcCustomLoggerTest.class.getName(), record.getSourceClassName());
  }

  @Test
  public void testHotPathLoggerLogToDefaultWhenContextIsNull() {
    BigQueryJdbcCustomLogger hotpathLogger =
        new BigQueryJdbcCustomLogger("com.google.cloud.bigquery.jdbc.BigQueryArrowResultSet");
    TestHandler hotpathHandler = new TestHandler();
    hotpathLogger.addHandler(hotpathHandler);
    hotpathLogger.setLevel(Level.ALL);

    BigQueryJdbcMdc.clear(); // Ensure context is null
    hotpathLogger.fine("This should log to default");

    List<LogRecord> records = hotpathHandler.getRecords();
    assertEquals(1, records.size()); // Logged successfully, not dropped!
    assertEquals("This should log to default", records.get(0).getMessage());
  }

  @Test
  public void testHotPathLoggerNotSilencedWhenContextIsPresent() {
    BigQueryJdbcCustomLogger hotpathLogger =
        new BigQueryJdbcCustomLogger("com.google.cloud.bigquery.jdbc.BigQueryArrowResultSet");
    TestHandler hotpathHandler = new TestHandler();
    hotpathLogger.addHandler(hotpathHandler);
    hotpathLogger.setLevel(Level.ALL);

    BigQueryJdbcMdc.registerInstance("TestConnection"); // Set active context
    hotpathLogger.fine("This should not be silenced");

    List<LogRecord> records = hotpathHandler.getRecords();
    assertEquals(1, records.size()); // Allowed!
    assertEquals("This should not be silenced", records.get(0).getMessage());
  }

  @Test
  public void testLogWithException() {
    Exception ex = new Exception("Test exception");
    logger.severe("Error occurred: %s", ex, "detail");

    List<LogRecord> records = testHandler.getRecords();
    assertEquals(1, records.size());
    LogRecord record = records.get(0);

    assertEquals("testLogWithException", record.getSourceMethodName());
    assertEquals(BigQueryJdbcCustomLoggerTest.class.getName(), record.getSourceClassName());
    assertTrue(record.getMessage().contains("Error occurred: detail"));
    assertEquals(ex, record.getThrown());
  }

  @Test
  public void testResultSetLoggerTrace() {
    BigQueryJdbcResultSetLogger rsLogger = new BigQueryJdbcResultSetLogger(BigQueryBaseResultSet.class);
    TestHandler rsHandler = new TestHandler();
    rsLogger.addHandler(rsHandler);
    rsLogger.setLevel(Level.ALL);

    rsLogger.finestTrace("customMethod", "Hello finest trace message");

    List<LogRecord> records = rsHandler.getRecords();
    assertEquals(1, records.size());
    LogRecord record = records.get(0);

    assertEquals(Level.FINEST, record.getLevel());
    assertEquals("customMethod", record.getSourceMethodName());
    assertEquals(BigQueryBaseResultSet.class.getName(), record.getSourceClassName());
    assertEquals("Hello finest trace message", record.getMessage());
  }

  @Test
  public void testResultSetLoggerTraceFormat() {
    BigQueryJdbcResultSetLogger rsLogger = new BigQueryJdbcResultSetLogger(BigQueryBaseResultSet.class);
    TestHandler rsHandler = new TestHandler();
    rsLogger.addHandler(rsHandler);
    rsLogger.setLevel(Level.ALL);

    rsLogger.finestTrace("formattedMethod", "Value: %s, Code: %d", "abc", 123);

    List<LogRecord> records = rsHandler.getRecords();
    assertEquals(1, records.size());
    LogRecord record = records.get(0);

    assertEquals(Level.FINEST, record.getLevel());
    assertEquals("formattedMethod", record.getSourceMethodName());
    assertEquals(BigQueryBaseResultSet.class.getName(), record.getSourceClassName());
    assertEquals("Value: abc, Code: 123", record.getMessage());
  }

  @Test
  public void testResultSetLoggerStandardMethods() {
    BigQueryJdbcResultSetLogger rsLogger = new BigQueryJdbcResultSetLogger(BigQueryBaseResultSet.class);
    TestHandler rsHandler = new TestHandler();
    rsLogger.addHandler(rsHandler);
    rsLogger.setLevel(Level.ALL);

    rsLogger.finest("Finest msg");
    rsLogger.finer("Finer msg");
    rsLogger.fine("Fine msg");
    rsLogger.finest("Finest format: %s", "val");

    List<LogRecord> records = rsHandler.getRecords();
    assertEquals(4, records.size());

    LogRecord r1 = records.get(0);
    assertEquals(Level.FINEST, r1.getLevel());
    assertEquals("unknown", r1.getSourceMethodName());
    assertEquals(BigQueryBaseResultSet.class.getName(), r1.getSourceClassName());
    assertEquals("Finest msg", r1.getMessage());

    LogRecord r2 = records.get(1);
    assertEquals(Level.FINER, r2.getLevel());
    assertEquals("unknown", r2.getSourceMethodName());
    assertEquals("Finer msg", r2.getMessage());

    LogRecord r3 = records.get(2);
    assertEquals(Level.FINE, r3.getLevel());
    assertEquals("unknown", r3.getSourceMethodName());
    assertEquals("Fine msg", r3.getMessage());

    LogRecord r4 = records.get(3);
    assertEquals(Level.FINEST, r4.getLevel());
    assertEquals("unknown", r4.getSourceMethodName());
    assertEquals("Finest format: val", r4.getMessage());
  }
}



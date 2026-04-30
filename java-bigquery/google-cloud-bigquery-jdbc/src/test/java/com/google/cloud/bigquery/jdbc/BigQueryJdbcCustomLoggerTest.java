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
}

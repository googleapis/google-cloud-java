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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.junit.jupiter.api.Test;

public class BigQueryJdbcRootLoggerTest {

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
}

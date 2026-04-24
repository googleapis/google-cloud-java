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

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

  @BeforeEach
  public void setUp() {
    handler = new PerConnectionFileHandler(tempDir.toString(), Level.INFO);
    mockConnection = Mockito.mock(BigQueryConnection.class);
    BigQueryJdbcMdc.clear();
  }

  @AfterEach
  public void tearDown() {
    if (handler != null) {
      handler.close();
    }
    BigQueryJdbcMdc.clear();
  }

  @Test
  public void testInitialization() {
    Path defaultLog = tempDir.resolve("BigQuery-Jdbc-default.log");
    assertTrue(Files.exists(defaultLog));
  }

  @Test
  public void testPublishDefault() throws IOException {
    LogRecord record = new LogRecord(Level.INFO, "Test message default");
    handler.publish(record);
    handler.flush();

    Path defaultLog = tempDir.resolve("BigQuery-Jdbc-default.log");
    String content = new String(Files.readAllBytes(defaultLog));
    assertTrue(content.contains("Test message default"));
  }

  @Test
  public void testPublishConnectionSpecific() throws IOException {
    BigQueryJdbcMdc.registerInstance(mockConnection, "123");

    LogRecord record = new LogRecord(Level.INFO, "Test message connection 123");
    handler.publish(record);
    handler.flush();

    Path connLog = tempDir.resolve("BigQuery-JdbcConnection-123.log");
    assertTrue(Files.exists(connLog));
    String content = new String(Files.readAllBytes(connLog));
    assertTrue(content.contains("Test message connection 123"));
  }

  @Test
  public void testCloseHandler() {
    BigQueryJdbcMdc.registerInstance(mockConnection, "456");

    LogRecord record = new LogRecord(Level.INFO, "Test message connection 456");
    handler.publish(record);
    handler.flush();

    Path connLog = tempDir.resolve("BigQuery-JdbcConnection-456.log");
    assertTrue(Files.exists(connLog));

    handler.closeHandler("JdbcConnection-456");
    assertTrue(Files.exists(connLog));
  }
}

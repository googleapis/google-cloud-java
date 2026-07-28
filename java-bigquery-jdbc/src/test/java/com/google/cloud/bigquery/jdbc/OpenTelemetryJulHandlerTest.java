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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Payload;
import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.logs.Severity;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.logs.data.LogRecordData;
import io.opentelemetry.sdk.testing.junit5.OpenTelemetryExtension;
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mockito.ArgumentCaptor;

public class OpenTelemetryJulHandlerTest {

  @RegisterExtension
  static final OpenTelemetryExtension otelTesting = OpenTelemetryExtension.create();

  private static final Logger logger = Logger.getLogger("com.google.cloud.bigquery");
  private java.util.logging.Level originalLevel;

  @BeforeEach
  public void setUp() {
    originalLevel = logger.getLevel();
    logger.setLevel(java.util.logging.Level.ALL);
    BigQueryJdbcOpenTelemetry.ensureGlobalHandlerAttached();
  }

  @AfterEach
  public void tearDown() {
    BigQueryJdbcOpenTelemetry.unregisterConnection("test-uuid");
    BigQueryJdbcOpenTelemetry.unregisterConnection("wrong-uuid");
    BigQueryJdbcOpenTelemetry.unregisterConnection("gcp-uuid");
    logger.setLevel(originalLevel);
  }

  @Test
  public void testPublishToOTel() {
    BigQueryJdbcOpenTelemetry.registerConnection(
        "test-uuid", otelTesting.getOpenTelemetry(), null, false);

    BigQueryConnection mockConnection = mock(BigQueryConnection.class);
    Baggage baggage =
        Baggage.builder()
            .put(BigQueryJdbcOpenTelemetry.CONNECTION_ID_BAGGAGE_KEY, "test-uuid")
            .build();
    try (Scope scope = baggage.makeCurrent();
        BigQueryJdbcMdc.MdcCloseable mdcScope = BigQueryJdbcMdc.registerInstance("test-uuid")) {
      logger.info("Test message");
    }

    List<LogRecordData> logs = otelTesting.getLogRecords();
    assertEquals(1, logs.size());
    LogRecordData log = logs.get(0);
    assertEquals("Test message", log.getBody().asString());
    assertEquals(Severity.INFO, log.getSeverity());
    assertEquals(
        "test-uuid",
        log.getAttributes()
            .get(AttributeKey.stringKey(BigQueryJdbcOpenTelemetry.CONNECTION_ID_BAGGAGE_KEY)));
  }

  @Test
  public void testPublishWithFiltering() {
    // Register for "test-uuid"
    BigQueryJdbcOpenTelemetry.registerConnection(
        "test-uuid", otelTesting.getOpenTelemetry(), null, false);

    // Log with WRONG connection ID
    Baggage baggage =
        Baggage.builder()
            .put(BigQueryJdbcOpenTelemetry.CONNECTION_ID_BAGGAGE_KEY, "wrong-uuid")
            .build();
    try (Scope scope = baggage.makeCurrent()) {
      logger.info("Test message");
    }

    List<LogRecordData> logs = otelTesting.getLogRecords();
    assertTrue(logs.isEmpty()); // Should be filtered out because "wrong-uuid" has no config
  }

  @Test
  public void testPublishToGcp() {
    Logging loggingClient = mock(Logging.class);
    BigQueryJdbcOpenTelemetry.registerConnection(
        "gcp-uuid", otelTesting.getOpenTelemetry(), loggingClient, true);

    BigQueryConnection mockConnection = mock(BigQueryConnection.class);
    Baggage baggage =
        Baggage.builder()
            .put(BigQueryJdbcOpenTelemetry.CONNECTION_ID_BAGGAGE_KEY, "gcp-uuid")
            .build();
    try (Scope scope = baggage.makeCurrent();
        BigQueryJdbcMdc.MdcCloseable mdcScope = BigQueryJdbcMdc.registerInstance("gcp-uuid")) {
      logger.info("Test message");
    }

    ArgumentCaptor<Iterable<LogEntry>> captor = ArgumentCaptor.forClass(Iterable.class);
    verify(loggingClient).write(captor.capture());

    Iterable<LogEntry> entries = captor.getValue();
    LogEntry entry = entries.iterator().next();

    assertEquals("Test message", ((Payload.StringPayload) entry.getPayload()).getData());
    assertEquals(com.google.cloud.logging.Severity.INFO, entry.getSeverity());
  }
}

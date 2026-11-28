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
import static org.mockito.Mockito.times;
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
import java.util.logging.Level;
import java.util.logging.LogRecord;
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
    BigQueryJdbcOpenTelemetry.unregisterConnection("severe-only-uuid");
    BigQueryJdbcMdc.clear();
    BigQueryJdbcRootLogger.resetForTest();
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
      logger.log(new LogRecord(Level.INFO, null));
    }

    ArgumentCaptor<Iterable<LogEntry>> captor = ArgumentCaptor.forClass(Iterable.class);
    verify(loggingClient, times(2)).write(captor.capture());

    List<Iterable<LogEntry>> allWrites = captor.getAllValues();
    LogEntry entry = allWrites.get(0).iterator().next();
    LogEntry nullEntry = allWrites.get(1).iterator().next();

    assertEquals("Test message", ((Payload.StringPayload) entry.getPayload()).getData());
    assertEquals(com.google.cloud.logging.Severity.INFO, entry.getSeverity());
    assertEquals("", ((Payload.StringPayload) nullEntry.getPayload()).getData());
  }

  @Test
  public void testResultSetLoggerRoutingAndMessageFormatting() {
    BigQueryJdbcOpenTelemetry.registerConnection(
        "test-uuid", otelTesting.getOpenTelemetry(), null, false);
    BigQueryJdbcMdc.clear();

    BigQueryJdbcResultSetLogger rsLogger =
        BigQueryJdbcResultSetLogger.getLogger(BigQueryBaseResultSet.class, "test-uuid");
    rsLogger.fineTrace("getObject", "Column 'user_id' has unparsed {json}");

    LogRecord parameterized = new LogRecord(Level.INFO, "Processing job {0}");
    parameterized.setParameters(new Object[] {"job-999"});
    rsLogger.log(parameterized);

    Baggage baggage =
        Baggage.builder()
            .put(BigQueryJdbcOpenTelemetry.CONNECTION_ID_BAGGAGE_KEY, "test-uuid")
            .build();
    try (Scope scope = baggage.makeCurrent()) {
      LogRecord retryStyle = new LogRecord(Level.INFO, "Retrying 'getQueryResults'");
      retryStyle.setParameters(new Object[] {"attempt=1"});
      logger.log(retryStyle);

      LogRecord directPositional = new LogRecord(Level.INFO, "Direct {0} ok");
      directPositional.setParameters(new Object[] {"param0"});
      logger.log(directPositional);

      LogRecord malformedPattern = new LogRecord(Level.INFO, "Broken {0");
      malformedPattern.setParameters(new Object[] {"param0"});
      logger.log(malformedPattern);

      LogRecord nullMessage = new LogRecord(Level.INFO, null);
      logger.log(nullMessage);
    }

    List<LogRecordData> logs = otelTesting.getLogRecords();
    assertEquals(6, logs.size());
    assertEquals("Column 'user_id' has unparsed {json}", logs.get(0).getBody().asString());
    assertEquals("Processing job job-999", logs.get(1).getBody().asString());
    assertEquals("Retrying 'getQueryResults'", logs.get(2).getBody().asString());
    assertEquals("Direct param0 ok", logs.get(3).getBody().asString());
    assertEquals("Broken {0", logs.get(4).getBody().asString());
    assertTrue(logs.get(5).getBody().asString().isEmpty());
  }

  @Test
  public void testPerConnectionLogLevelFilteringWhenSiblingConnectionIsVerbose() {
    BigQueryJdbcRootLogger.registerConnection("verbose-sibling", "6", null);
    BigQueryJdbcRootLogger.registerConnection("severe-only-uuid", "1", null);
    BigQueryJdbcOpenTelemetry.registerConnection(
        "severe-only-uuid", otelTesting.getOpenTelemetry(), null, false);

    Baggage baggage =
        Baggage.builder()
            .put(BigQueryJdbcOpenTelemetry.CONNECTION_ID_BAGGAGE_KEY, "severe-only-uuid")
            .build();
    try (Scope scope = baggage.makeCurrent();
        BigQueryJdbcMdc.MdcCloseable mdc = BigQueryJdbcMdc.registerInstance("severe-only-uuid")) {
      logger.info("info-should-be-filtered");
      logger.severe("severe-should-export");
    }

    List<LogRecordData> logs = otelTesting.getLogRecords();
    assertEquals(1, logs.size());
    assertEquals("severe-should-export", logs.get(0).getBody().asString());
  }
}

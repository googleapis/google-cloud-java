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

import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.logs.Severity;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.logs.data.LogRecordData;
import io.opentelemetry.sdk.testing.junit5.OpenTelemetryExtension;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class OpenTelemetryJulHandlerTest {

  @RegisterExtension
  static final OpenTelemetryExtension otelTesting = OpenTelemetryExtension.create();

  @Test
  public void testPublishToOTel() {
    OpenTelemetryJulHandler handler =
        new OpenTelemetryJulHandler(null, otelTesting.getOpenTelemetry(), false, null);

    LogRecord record = new LogRecord(Level.INFO, "Test message");
    record.setLoggerName("test.logger");
    record.setMillis(System.currentTimeMillis());

    handler.publish(record);

    List<LogRecordData> logs = otelTesting.getLogRecords();
    assertEquals(1, logs.size());
    LogRecordData log = logs.get(0);
    assertEquals("Test message", log.getBody().asString());
    assertEquals("test.logger", log.getInstrumentationScopeInfo().getName());
    assertEquals(Severity.INFO, log.getSeverity());
  }

  @Test
  public void testPublishToOTelWithFiltering() {
    // Handler expects "correct-uuid"
    OpenTelemetryJulHandler handler =
        new OpenTelemetryJulHandler(null, otelTesting.getOpenTelemetry(), false, "correct-uuid");

    // Simulate log with NO connection ID
    LogRecord record = new LogRecord(Level.INFO, "Test message");
    record.setLoggerName("test.logger");

    handler.publish(record);

    List<LogRecordData> logs = otelTesting.getLogRecords();
    assertTrue(logs.isEmpty()); // Should be filtered out
  }

  @Test
  public void testPublishToOTelWithBaggage() {
    OpenTelemetryJulHandler handler =
        new OpenTelemetryJulHandler(null, otelTesting.getOpenTelemetry(), false, null);

    Baggage baggage = Baggage.builder().put("jdbc.connection_id", "test-uuid").build();
    try (Scope scope = baggage.makeCurrent()) {
      LogRecord record = new LogRecord(Level.INFO, "Test message");
      record.setLoggerName("test.logger");
      handler.publish(record);

      List<LogRecordData> logs = otelTesting.getLogRecords();
      assertEquals(1, logs.size());
      LogRecordData log = logs.get(0);
      assertEquals(
          "test-uuid", log.getAttributes().get(AttributeKey.stringKey("jdbc.connection_id")));
    }
  }
}

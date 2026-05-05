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

import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Payload;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.logs.Logger;
import io.opentelemetry.api.logs.Severity;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.context.Context;
import java.time.Instant;
import java.util.Collections;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Custom logging handler that bridges java.util.logging records to OpenTelemetry or Google Cloud
 * Logging. Extracts TraceId, SpanId, and Connection UUID from context.
 */
public class OpenTelemetryJulHandler extends Handler {

  private final Logging loggingClient;
  private final OpenTelemetry openTelemetry;
  private final boolean isGcpFallback;
  private final String expectedConnectionId;

  public OpenTelemetryJulHandler(
      Logging loggingClient,
      OpenTelemetry openTelemetry,
      boolean isGcpFallback,
      String expectedConnectionId) {
    this.loggingClient = loggingClient;
    this.openTelemetry = openTelemetry;
    this.isGcpFallback = isGcpFallback;
    this.expectedConnectionId = expectedConnectionId;
  }

  @Override
  public void publish(LogRecord record) {
    if (!isLoggable(record)) {
      return;
    }

    Context context = Context.current();
    SpanContext spanContext = Span.fromContext(context).getSpanContext();

    String traceId = spanContext.isValid() ? spanContext.getTraceId() : null;
    String spanId = spanContext.isValid() ? spanContext.getSpanId() : null;

    // Extract connection ID from baggage
    String connectionId = Baggage.fromContext(context).getEntryValue("jdbc.connection_id");

    // Fallback to MDC if not in baggage (if MDC is available and used)
    if (connectionId == null) {
      connectionId = BigQueryJdbcMdc.getConnectionId();
    }

    if (expectedConnectionId != null && !expectedConnectionId.equals(connectionId)) {
      return;
    }

    if (isGcpFallback && loggingClient != null) {
      publishToGcp(record, traceId, spanId, connectionId);
    } else if (openTelemetry != null) {
      publishToOTel(record, traceId, spanId, connectionId);
    }
  }

  private void publishToGcp(LogRecord record, String traceId, String spanId, String connectionId) {
    // TODO(b/491238299): May require refinement for structured logging or error handling
    if (loggingClient == null) {
      return;
    }

    LogEntry.Builder builder =
        LogEntry.newBuilder(Payload.StringPayload.of(record.getMessage()))
            .setSeverity(mapGcpSeverity(record.getLevel()))
            .setTimestamp(record.getMillis());

    if (traceId != null) {
      builder.setTrace(traceId);
    }
    if (spanId != null) {
      builder.setSpanId(spanId);
    }
    if (connectionId != null) {
      builder.addLabel("jdbc.connection_id", connectionId);
    }

    loggingClient.write(Collections.singleton(builder.build()));
  }

  private com.google.cloud.logging.Severity mapGcpSeverity(Level level) {
    if (level == Level.SEVERE) return com.google.cloud.logging.Severity.ERROR;
    if (level == Level.WARNING) return com.google.cloud.logging.Severity.WARNING;
    if (level == Level.INFO) return com.google.cloud.logging.Severity.INFO;
    if (level == Level.CONFIG) return com.google.cloud.logging.Severity.INFO;
    if (level == Level.FINE) return com.google.cloud.logging.Severity.DEBUG;
    return com.google.cloud.logging.Severity.DEBUG;
  }

  private void publishToOTel(LogRecord record, String traceId, String spanId, String connectionId) {
    if (openTelemetry == null) {
      return;
    }

    String loggerName = record.getLoggerName();
    Logger logger =
        openTelemetry
            .getLogsBridge()
            .get(loggerName != null ? loggerName : "com.google.cloud.bigquery.jdbc");

    logger
        .logRecordBuilder()
        .setBody(record.getMessage())
        .setSeverity(mapSeverity(record.getLevel()))
        .setTimestamp(Instant.ofEpochMilli(record.getMillis()))
        .setContext(Context.current())
        .setAttribute(
            AttributeKey.stringKey("jdbc.connection_id"), connectionId != null ? connectionId : "")
        .emit();
  }

  private Severity mapSeverity(Level level) {
    if (level == Level.SEVERE) return Severity.ERROR;
    if (level == Level.WARNING) return Severity.WARN;
    if (level == Level.INFO) return Severity.INFO;
    if (level == Level.CONFIG) return Severity.INFO;
    if (level == Level.FINE) return Severity.DEBUG;
    if (level == Level.FINER) return Severity.TRACE;
    if (level == Level.FINEST) return Severity.TRACE;
    return Severity.TRACE;
  }

  @Override
  public void flush() {
    if (isGcpFallback && loggingClient != null) {
      loggingClient.flush();
    }
  }

  @Override
  public void close() throws SecurityException {
    // TODO(b/491238299): Implement with gcp exporter logic
  }
}

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
import io.opentelemetry.api.logs.LogRecordBuilder;
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
import java.util.regex.Pattern;

/**
 * Custom logging handler that bridges java.util.logging records to OpenTelemetry or Google Cloud
 * Logging. Extracts TraceId, SpanId, and Connection UUID from context.
 */
public class OpenTelemetryJulHandler extends Handler {
  private static final Pattern UNSAFE_LOG_CHARACTERS = Pattern.compile("[^a-zA-Z0-9./_-]");

  public OpenTelemetryJulHandler() {
    setLevel(Level.ALL);
  }

  @Override
  public void publish(LogRecord record) {
    if (!isLoggable(record)) {
      return;
    }

    try {
      // Extract connection ID from baggage
      String connectionId =
          Baggage.fromContext(Context.current())
              .getEntryValue(BigQueryJdbcOpenTelemetry.CONNECTION_ID_BAGGAGE_KEY);

      if (connectionId == null) {
        return;
      }

      BigQueryJdbcOpenTelemetry.TelemetryConfig config =
          BigQueryJdbcOpenTelemetry.getConnectionConfig(connectionId);
      if (config == null) {
        return;
      }

      if (config.useDirectGcpLogging && config.loggingClient != null) {
        publishToGcp(record, connectionId, config.loggingClient);
      } else if (config.openTelemetry != null) {
        publishToOTel(record, connectionId, config.openTelemetry);
      }
    } catch (Throwable t) {
      // Ignore exceptions to prevent breaking application logging or other handlers
    }
  }

  private void publishToGcp(LogRecord record, String connectionId, Logging loggingClient) {
    Context context = Context.current();
    SpanContext spanContext = Span.fromContext(context).getSpanContext();
    String traceId = spanContext.isValid() ? spanContext.getTraceId() : null;
    String spanId = spanContext.isValid() ? spanContext.getSpanId() : null;

    String logId = record.getLoggerName();
    if (logId == null) {
      logId = BigQueryJdbcOpenTelemetry.INSTRUMENTATION_SCOPE_NAME;
    } else {
      logId = UNSAFE_LOG_CHARACTERS.matcher(logId).replaceAll("_");
    }

    LogEntry.Builder builder =
        LogEntry.newBuilder(Payload.StringPayload.of(formatMessage(record)))
            .setSeverity(mapGcpSeverity(record.getLevel()))
            .setTimestamp(record.getMillis())
            .setLogName(logId);

    if (traceId != null) {
      builder.setTrace(traceId);
    }
    if (spanId != null) {
      builder.setSpanId(spanId);
    }
    if (connectionId != null) {
      builder.addLabel(BigQueryJdbcOpenTelemetry.CONNECTION_ID_BAGGAGE_KEY, connectionId);
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

  private void publishToOTel(LogRecord record, String connectionId, OpenTelemetry openTelemetry) {
    String loggerName = record.getLoggerName();
    Logger logger =
        openTelemetry
            .getLogsBridge()
            .get(
                loggerName != null
                    ? loggerName
                    : BigQueryJdbcOpenTelemetry.INSTRUMENTATION_SCOPE_NAME);

    LogRecordBuilder builder =
        logger
            .logRecordBuilder()
            .setBody(formatMessage(record))
            .setSeverity(mapSeverity(record.getLevel()))
            .setTimestamp(Instant.ofEpochMilli(record.getMillis()))
            .setContext(Context.current());

    if (connectionId != null) {
      builder.setAttribute(
          AttributeKey.stringKey(BigQueryJdbcOpenTelemetry.CONNECTION_ID_BAGGAGE_KEY),
          connectionId);
    }

    builder.emit();
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

  private String formatMessage(LogRecord record) {
    String message = record.getMessage();
    Object[] params = record.getParameters();
    if (params != null && params.length > 0) {
      try {
        return java.text.MessageFormat.format(message, params);
      } catch (IllegalArgumentException e) {
        return message;
      }
    }
    return message;
  }

  @Override
  public void flush() {
    for (BigQueryJdbcOpenTelemetry.TelemetryConfig config :
        BigQueryJdbcOpenTelemetry.getRegisteredConfigs()) {
      if (config.useDirectGcpLogging && config.loggingClient != null) {
        try {
          config.loggingClient.flush();
        } catch (Exception e) {
          // Ignore failures during flush to protect other connections
        }
      }
    }
  }

  @Override
  public void close() throws SecurityException {
    flush();
  }
}

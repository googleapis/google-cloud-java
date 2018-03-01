/*
 * Copyright 2018 Google LLC
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

package com.google.cloud.logging.logback;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Severity;

/**
 * Collection of constants and static methods useful for writing LoggingEvent transformers
 * {@link ILoggingEventTransformer}
 */
public final class LoggingEventTransformerUtils {

  /**
   * Label to annotate log level names (e.g. "DEBUG") from {@link ILoggingEvent#getLevel()}.
   */
  public static final String LEVEL_NAME_KEY = "levelName";
  /**
   * Label to annotate log level numbers (e.g. "10000") from {@link ILoggingEvent#getLevel()}}.
   */
  public static final String LEVEL_VALUE_KEY = "levelValue";

  private LoggingEventTransformerUtils() {}

  /**
   * Transforms Logback logging levels to Cloud Severity levels
   *
   * @param level Logback logging level from {@link ILoggingEvent#getLevel()}
   * @return Cloud severity level
   */
  public static Severity severityFor(final Level level) {
    switch (level.toInt()) {
      // TRACE
      case 5000:
        return Severity.DEBUG;
      // DEBUG
      case 10000:
        return Severity.DEBUG;
      // INFO
      case 20000:
        return Severity.INFO;
      // WARNING
      case 30000:
        return Severity.WARNING;
      // ERROR
      case 40000:
        return Severity.ERROR;
      default:
        return Severity.DEFAULT;
    }
  }

  /**
   * Copies standard log information from a {@link ILoggingEvent} onto a {@link LogEntry.Builder}
   * including timestamp, severity, and log level.
   */
  public static void addCommonLogMetadata(final LogEntry.Builder builder,
                                          final ILoggingEvent loggingEvent) {
    Level level = loggingEvent.getLevel();
    builder.setTimestamp(loggingEvent.getTimeStamp())
        .setSeverity(severityFor(level))
        .addLabel(LEVEL_NAME_KEY, level.toString())
        .addLabel(LEVEL_VALUE_KEY, String.valueOf(level.toInt()));
  }


  /**
   * Write a stacktrace from {@link ILoggingEvent#getThrowableProxy()} to a StringBuilder.
   *
   * @param throwProxy from {@link ILoggingEvent#getThrowableProxy()}.
   */
  public static void writeStack(final IThrowableProxy throwProxy, final String prefix,
                                final StringBuilder payload) {
    if (throwProxy == null) {
      return;
    }
    payload
        .append(prefix)
        .append(throwProxy.getClassName())
        .append(": ")
        .append(throwProxy.getMessage())
        .append('\n');
    StackTraceElementProxy[] trace = throwProxy.getStackTraceElementProxyArray();
    if (trace == null) {
      trace = new StackTraceElementProxy[0];
    }

    final int commonFrames = throwProxy.getCommonFrames();
    final int printFrames = trace.length - commonFrames;
    for (int i = 0; i < printFrames; i++) {
      payload.append("    ").append(trace[i]).append('\n');
    }
    if (commonFrames != 0) {
      payload.append("    ... ").append(commonFrames).append(" common frames elided\n");
    }

    writeStack(throwProxy.getCause(), "caused by: ", payload);
  }
}

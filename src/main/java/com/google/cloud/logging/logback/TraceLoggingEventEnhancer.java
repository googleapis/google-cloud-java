/*
 * Copyright 2020 Google LLC
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

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.cloud.logging.LogEntry;
import org.slf4j.MDC;

/** Adds support for grouping logs by incoming http request */
public class TraceLoggingEventEnhancer implements LoggingEventEnhancer {

  // A key used by Cloud Logging for trace Id
  private static final String TRACE_ID = "logging.googleapis.trace";

  /**
   * Set the Trace ID associated with any logging done by the current thread.
   *
   * @param id The traceID, in the form projects/[PROJECT_ID]/traces/[TRACE_ID]
   */
  public static void setCurrentTraceId(String id) {
    MDC.put(TRACE_ID, id);
  }

  /** Clearing a trace Id from the MDC */
  public static void clearTraceId() {
    MDC.remove(TRACE_ID);
  }
  /**
   * Get the Trace ID associated with any logging done by the current thread.
   *
   * @return id The traceID
   */
  public static String getCurrentTraceId() {
    return MDC.get(TRACE_ID);
  }

  @Override
  public void enhanceLogEntry(LogEntry.Builder builder, ILoggingEvent e) {
    Object value = e.getMDCPropertyMap().get(TRACE_ID);
    String traceId = value != null ? value.toString() : null;
    if (traceId != null) {
      builder.setTrace(traceId);
    }
  }
}

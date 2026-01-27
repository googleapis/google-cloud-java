/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.logging;

/* Adds tracing support for logging with thread-local trace ID tracking. */
public class TraceLoggingEnhancer implements LoggingEnhancer {

  public TraceLoggingEnhancer() {}

  public TraceLoggingEnhancer(String prefix) {}

  private static final ThreadLocal<String> traceId = new ThreadLocal<>();
  private static final ThreadLocal<String> spanId = new ThreadLocal<>();
  private static final ThreadLocal<Boolean> traceSampled = new ThreadLocal<Boolean>();

  /**
   * Set the Trace ID associated with any logging done by the current thread.
   *
   * @param id The traceID, in the form projects/[PROJECT_ID]/traces/[TRACE_ID]
   */
  public static void setCurrentTraceId(String id) {
    if (id == null) {
      traceId.remove();
    } else {
      traceId.set(id);
    }
  }

  /**
   * Set the Span ID associated with any logging done by the current thread.
   *
   * @param id The spanID
   */
  public static void setCurrentSpanId(String id) {
    if (id == null) {
      spanId.remove();
    } else {
      spanId.set(id);
    }
  }

  /**
   * Set the trace sampled flag associated with any logging done by the current thread.
   *
   * @param isTraceSampled The traceSampled flag
   */
  public static void setCurrentTraceSampled(Boolean isTraceSampled) {
    if (isTraceSampled == null) {
      traceSampled.remove();
    } else {
      traceSampled.set(isTraceSampled);
    }
  }

  /**
   * Get the Trace ID associated with any logging done by the current thread.
   *
   * @return id The trace ID
   */
  public static String getCurrentTraceId() {
    return traceId.get();
  }

  /**
   * Get the Span ID associated with any logging done by the current thread.
   *
   * @return id The span ID
   */
  public static String getCurrentSpanId() {
    return spanId.get();
  }

  /**
   * Get the trace sampled flag associated with any logging done by the current thread.
   *
   * @return traceSampled The traceSampled flag
   */
  public static Boolean getCurrentTraceSampled() {
    return traceSampled.get();
  }

  @Override
  public void enhanceLogEntry(LogEntry.Builder builder) {
    String traceId = getCurrentTraceId();
    if (traceId != null) {
      builder.setTrace(traceId);
    }
    String spanId = getCurrentSpanId();
    if (spanId != null) {
      builder.setSpanId(spanId);
    }
    Boolean isTraceSampled = getCurrentTraceSampled();
    if (isTraceSampled != null) {
      builder.setTraceSampled(isTraceSampled);
    }
  }
}

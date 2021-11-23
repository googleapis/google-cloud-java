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
   * Get the Trace ID associated with any logging done by the current thread.
   *
   * @return id The traceID
   */
  public static String getCurrentTraceId() {
    return traceId.get();
  }

  @Override
  public void enhanceLogEntry(com.google.cloud.logging.LogEntry.Builder builder) {
    String traceId = getCurrentTraceId();
    if (traceId != null) {
      builder.setTrace(traceId);
    }
  }
}

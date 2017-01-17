/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import java.util.logging.LogRecord;

import com.google.cloud.MonitoredResource.Builder;

/**
 * A Logging {@link Enhancer} that enhances the logging for the 
 * GAE Flex environment. This enhancer can
 * be configured in a logging.properties file with:
 * 
 * <pre>
 * handlers=com.google.cloud.logging.LoggingHandler
 * com.google.cloud.logging.LoggingHandler.log=gaeflex.log
 * com.google.cloud.logging.LoggingHandler.resourceType=gae_app
 * com.google.cloud.logging.LoggingHandler.enhancers=com.google.cloud.logging.GaeFlexLoggingEnhancer
 * com.google.cloud.logging.LoggingHandler.formatter = java.util.logging.SimpleFormatter
 * java.util.logging.SimpleFormatter.format=%3$s: %5$s%6$s
 * </pre>
 *
 */
public class GaeFlexLoggingEnhancer implements LoggingHandler.Enhancer {

  private static final ThreadLocal<String> traceId = new ThreadLocal<>();

  private final String gaeInstanceId;

  /**
   * Set the Trace ID associated with any logging done by the current thread.
   * 
   * @param id The traceID
   */
  public static void setCurrentTraceId(String id) {
    traceId.set(id);
  }

  /**
   * Get the Trace ID associated with any logging done by the current thread.
   * 
   * @return id The traceID
   */
  public static String getCurrentTraceId() {
    return traceId.get();
  }

  public GaeFlexLoggingEnhancer() {
    gaeInstanceId = System.getenv("GAE_INSTANCE"); // Are we running on a GAE instance?
  }

  @Override
  public void enhanceMonitoredResource(Builder builder) {
    if (gaeInstanceId != null) {
      if (System.getenv("GAE_SERVICE") != null) {
        builder.addLabel("module_id", System.getenv("GAE_SERVICE"));
      }
      if (System.getenv("GAE_VERSION") != null) {
        builder.addLabel("version_id", System.getenv("GAE_VERSION"));
      }
    }
  }

  @Override
  public void enhanceLogEntry(com.google.cloud.logging.LogEntry.Builder builder, LogRecord record) {
    if (gaeInstanceId != null) {
      builder.addLabel("appengine.googleapis.com/instance_name", gaeInstanceId);
    }
    String traceId = getCurrentTraceId();
    if (traceId != null) {
      builder.addLabel("appengine.googleapis.com/trace_id", traceId);
    }
  }
}

/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package org.slf4j.impl;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.Severity;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Marker;
import org.slf4j.impl.config.ConfigLoader;
import org.slf4j.impl.logging.ILogging;
import org.slf4j.impl.logging.ILoggingFactory;

/** Cloud logging service with external configuration */
class CloudLogger {

  private static final String CONFIGURATION_FILE = "google-cloud-logging.yaml";
  private static final String CLOUD_LOGGING_CONFIG = "CLOUD_LOGGING_CONFIG";
  // 100kb payload limit : limit string payload to 95 kb (assume 2 bytes per character)
  private static final int MAX_LOG_SIZE_IN_CHARS = 1024 * 95 / 2;
  private static ConfigLoader configLoader;
  private static boolean INITIALIZED = false;
  private static ILogging logging;
  private MonitoredResource resource;
  private String fileName;
  private String loggerName;
  private Severity minSeverity;
  private boolean isEnabled;
  private Map<String, String> labels;

  CloudLogger(String loggerName) {
    try {
      init(loggerName);
    } catch (Exception e) {
      System.err.println("Error initializing cloud logging");
      e.printStackTrace();
    }
  }

  static void init() {
    if (!INITIALIZED) {
      String configFile = ConfigLoader.getValue(CLOUD_LOGGING_CONFIG, CONFIGURATION_FILE);
      configLoader = new ConfigLoader(configFile);
      logging = ILoggingFactory.get(configLoader.getDestination());
      logging.init();
      INITIALIZED = true;
    }
  }

  String getName() {
    return loggerName;
  }

  boolean isEnabled(Severity severity) {
    return (isEnabled && severity.compareTo(minSeverity) >= 0);
  }

  void log(Marker marker, Severity severity, String text, Throwable throwable) {
    writeLogEntries(marker, severity, text, throwable);
  }

  void log(Severity severity, String text, Throwable throwable) {
    writeLogEntries(null, severity, text, throwable);
  }

  void log(Marker marker, Severity severity, String text) {
    writeLogEntries(marker, severity, text, null);
  }

  void log(Severity severity, String text) {
    log(null, severity, text, null);
  }

  private void updateConfig() {
    minSeverity = configLoader.getSeverity(loggerName);
    labels = configLoader.getLabels(loggerName);
    fileName = configLoader.getFileName(loggerName);
    this.resource = MonitoredResource.newBuilder(configLoader.getResource(loggerName)).build();
    this.isEnabled = configLoader.isEnabled(loggerName);
  }

  private void init(String loggerName) throws Exception {
    this.loggerName = loggerName;
    updateConfig();
  }

  private LogEntry createLogEntry(Marker marker, Severity severity, String text) {
    LogDetailsTuple logDetailsTuple = new LogDetailsTuple(marker, labels, severity);
    return LogEntry.newBuilder(StringPayload.of(text))
        .setResource(resource)
        .setLabels(logDetailsTuple.getLabels())
        .setLogName(fileName)
        .setSeverity(logDetailsTuple.getLevel())
        .build();
  }

  private List<String> getChunks(String text) {
    List<String> chunks = new ArrayList<>();
    if (text.length() <= MAX_LOG_SIZE_IN_CHARS) {
      chunks.add(text);
      return chunks;
    }
    String[] splits = text.split("\n");
    StringBuilder sb = new StringBuilder();
    for (String s : splits) {
      if (s.length() + sb.length() < MAX_LOG_SIZE_IN_CHARS) {
        sb.append("\n");
        sb.append(s);
      } else {
        if (sb.length() > 0) {
          chunks.add(sb.toString());
          sb.setLength(0);
        }
        if (s.length() <= MAX_LOG_SIZE_IN_CHARS) {
          sb.append(s);
        } else {
          int start = 0;
          int end;
          while (start < s.length()) {
            end = Math.min(s.length() - start, MAX_LOG_SIZE_IN_CHARS - 1);
            chunks.add(s.substring(start, start + end));
            start = end;
          }
        }
      }
    }
    if (sb.length() > 0) {
      chunks.add(sb.toString());
    }
    return chunks;
  }

  private String getStackTrace(Throwable throwable) {
    StringWriter errors = new StringWriter();
    throwable.printStackTrace(new PrintWriter(errors));
    return errors.toString();
  }

  private void writeLogEntries(Marker marker, Severity level, String text, Throwable t) {
    if (!isEnabled(level)) {
      return;
    }
    if (t != null) {
      text = text + "\n" + getStackTrace(t);
    }
    List<String> chunks = getChunks(text);
    List<LogEntry> logEntries = new ArrayList<>();
    for (String chunk : chunks) {
      logEntries.add(createLogEntry(marker, level, chunk));
    }
    logging.write(logEntries);
  }
}

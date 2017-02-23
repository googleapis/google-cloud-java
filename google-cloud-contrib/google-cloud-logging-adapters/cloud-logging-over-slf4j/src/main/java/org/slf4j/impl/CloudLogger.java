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
import com.google.common.base.Splitter;
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
  private static ILogging logging;
  private MonitoredResource resource;
  private String fileName;
  private String loggerName;
  private Severity minSeverity;
  private boolean isEnabled;
  private Map<String, String> labels;

  CloudLogger(String loggerName) throws Exception {
      init(loggerName);
  }

  static void init() {
      String configFile = ConfigLoader.getValue(CLOUD_LOGGING_CONFIG, CONFIGURATION_FILE);
      configLoader = new ConfigLoader(configFile);
      logging = ILoggingFactory.get(configLoader.getDestination());
      logging.init();
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

  private Iterable<String> getChunks(String text) {
    return Splitter.fixedLength(MAX_LOG_SIZE_IN_CHARS)
        .omitEmptyStrings()
        .split(text);
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
    Iterable<String> chunks = getChunks(text);
    List<LogEntry> logEntries = new ArrayList<>();
    for (String chunk : chunks) {
      logEntries.add(createLogEntry(marker, level, chunk));
    }
    logging.write(logEntries);
  }
}

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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Custom logging handler that dynamically creates and routes log records to per-connection specific
 * log files using the connection ID retrieved from BigQueryJdbcMdc.
 */
class PerConnectionFileHandler extends Handler {
  private final Path baseLogPath;
  private final Level level;
  private final ConcurrentHashMap<String, FileHandler> handlers = new ConcurrentHashMap<>();
  private FileHandler defaultHandler;

  PerConnectionFileHandler(String baseLogPath, Level level) {
    this.baseLogPath = Paths.get(baseLogPath != null ? baseLogPath : "").toAbsolutePath();
    this.level = level;

    try {
      if (!Files.exists(this.baseLogPath)) {
        Files.createDirectories(this.baseLogPath);
      }

      this.defaultHandler = createFileHandler("Jdbc-default");
    } catch (IOException e) {
      reportError(
          "Failed to initialize default log file", e, java.util.logging.ErrorManager.OPEN_FAILURE);
    }
  }

  private String getLogFilePath(String id) {
    return baseLogPath.resolve("BigQuery-" + id + ".log").toString();
  }

  private FileHandler createFileHandler(String id) {
    try {
      String filePath = getLogFilePath(id);
      FileHandler fh = new FileHandler(filePath, 0, 1, true);
      fh.setLevel(level);
      fh.setFormatter(BigQueryJdbcRootLogger.getFormatter());
      return fh;
    } catch (IOException e) {
      reportError(
          "Failed to create log file for connection " + id,
          e,
          java.util.logging.ErrorManager.OPEN_FAILURE);
      return null;
    }
  }

  @Override
  public void publish(LogRecord record) {
    if (!isLoggable(record)) {
      return;
    }

    String connectionId = BigQueryJdbcMdc.getConnectionId();
    FileHandler handler = defaultHandler;

    if (connectionId != null && !connectionId.isEmpty()) {
      handler = handlers.computeIfAbsent(connectionId, this::createFileHandler);
      if (handler == null) {
        handler = defaultHandler;
      }
    }

    if (handler != null) {
      handler.publish(record);
    }
  }

  @Override
  public void flush() {
    if (defaultHandler != null) {
      defaultHandler.flush();
    }
    for (FileHandler h : handlers.values()) {
      h.flush();
    }
  }

  @Override
  public void close() throws SecurityException {
    for (FileHandler h : handlers.values()) {
      try {
        h.close();
      } catch (Exception e) {
      }
    }
    try {
      if (defaultHandler != null) defaultHandler.close();
    } finally {
      handlers.clear();
    }
  }

  public void closeHandler(String connectionId) {
    if (connectionId != null) {
      FileHandler handler = handlers.remove(connectionId);
      if (handler != null) {
        handler.close();
      }
    }
  }
}

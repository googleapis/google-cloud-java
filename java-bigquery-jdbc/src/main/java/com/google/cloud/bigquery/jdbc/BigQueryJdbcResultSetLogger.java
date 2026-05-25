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

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Specialized high-performance logger for ResultSet and its related classes. Avoids expensive stack
 * trace walking (caller inference) on hot-path logging calls.
 */
public class BigQueryJdbcResultSetLogger extends BigQueryJdbcCustomLogger {
  private static final ConcurrentHashMap<String, BigQueryJdbcResultSetLogger> cache =
      new ConcurrentHashMap<>();

  private final String targetClassName;
  private final String connectionId;

  public static BigQueryJdbcResultSetLogger getLogger(Class<?> clazz) {
    return getLogger(clazz, null);
  }

  public static BigQueryJdbcResultSetLogger getLogger(Class<?> clazz, String connectionId) {
    if (connectionId == null) {
      return cache.computeIfAbsent(
          clazz.getName(), k -> new BigQueryJdbcResultSetLogger(clazz, null));
    }
    return new BigQueryJdbcResultSetLogger(clazz, connectionId);
  }

  public String getConnectionId() {
    return connectionId;
  }

  private BigQueryJdbcResultSetLogger arrowStructLogger;
  private BigQueryJdbcResultSetLogger jsonStructLogger;
  private BigQueryJdbcResultSetLogger arrowArrayLogger;
  private BigQueryJdbcResultSetLogger jsonArrayLogger;

  public BigQueryJdbcResultSetLogger getArrowStructLogger() {
    if (arrowStructLogger == null) {
      arrowStructLogger = getLogger(BigQueryArrowStruct.class, connectionId);
    }
    return arrowStructLogger;
  }

  public BigQueryJdbcResultSetLogger getJsonStructLogger() {
    if (jsonStructLogger == null) {
      jsonStructLogger = getLogger(BigQueryJsonStruct.class, connectionId);
    }
    return jsonStructLogger;
  }

  public BigQueryJdbcResultSetLogger getArrowArrayLogger() {
    if (arrowArrayLogger == null) {
      arrowArrayLogger = getLogger(BigQueryArrowArray.class, connectionId);
    }
    return arrowArrayLogger;
  }

  public BigQueryJdbcResultSetLogger getJsonArrayLogger() {
    if (jsonArrayLogger == null) {
      jsonArrayLogger = getLogger(BigQueryJsonArray.class, connectionId);
    }
    return jsonArrayLogger;
  }

  public BigQueryJdbcResultSetLogger(Class<?> clazz) {
    this(clazz, null);
  }

  public BigQueryJdbcResultSetLogger(Class<?> clazz, String connectionId) {
    super(clazz.getName());
    this.targetClassName = clazz.getName();
    this.connectionId = connectionId;
  }

  @Override
  public void log(LogRecord record) {
    record.setSourceClassName(targetClassName);
    record.setThreadID((int) Thread.currentThread().getId());
    if (connectionId != null) {
      Object[] existingParams = record.getParameters();
      if (existingParams == null || existingParams.length == 0) {
        record.setParameters(new Object[] {connectionId});
      } else {
        Object[] newParams = new Object[existingParams.length + 1];
        newParams[0] = connectionId;
        System.arraycopy(existingParams, 0, newParams, 1, existingParams.length);
        record.setParameters(newParams);
      }
    }
    super.log(record);
  }

  private void logTrace(Level level, String methodName, String msg) {
    if (isLoggable(level)) {
      LogRecord record = new LogRecord(level, msg);
      record.setSourceMethodName(methodName);
      this.log(record);
    }
  }

  private void logTrace(Level level, String methodName, Supplier<String> msgSupplier) {
    if (isLoggable(level)) {
      LogRecord record = new LogRecord(level, msgSupplier.get());
      record.setSourceMethodName(methodName);
      this.log(record);
    }
  }

  /**
   * Log a message at Level.FINEST with predefined class name, method name and messageto avoid stack
   * trace parsing on the hot-path.
   */
  public void finestTrace(String methodName) {
    logTrace(Level.FINEST, methodName, "++enter++");
  }

  /**
   * Log a message at Level.FINEST with predefined class name and method name to avoid stack trace
   * parsing on the hot-path.
   */
  public void finestTrace(String methodName, String msg) {
    logTrace(Level.FINEST, methodName, msg);
  }

  /** Log a lazy message at Level.FINEST with predefined class name and method name. */
  public void finestTrace(String methodName, Supplier<String> msgSupplier) {
    logTrace(Level.FINEST, methodName, msgSupplier);
  }

  /** Log a message at Level.FINER with predefined class name and method name. */
  public void finerTrace(String methodName, String msg) {
    logTrace(Level.FINER, methodName, msg);
  }

  /** Log a lazy message at Level.FINER with predefined class name and method name. */
  public void finerTrace(String methodName, Supplier<String> msgSupplier) {
    logTrace(Level.FINER, methodName, msgSupplier);
  }

  /** Log a message at Level.FINE with predefined class name and method name. */
  public void fineTrace(String methodName, String msg) {
    logTrace(Level.FINE, methodName, msg);
  }

  /** Log a lazy message at Level.FINE with predefined class name and method name. */
  public void fineTrace(String methodName, Supplier<String> msgSupplier) {
    logTrace(Level.FINE, methodName, msgSupplier);
  }

  @Override
  public void finest(String msg) {
    logTrace(Level.FINEST, "unknown", msg);
  }

  @Override
  public void finest(Supplier<String> msgSupplier) {
    logTrace(Level.FINEST, "unknown", msgSupplier);
  }

  @Override
  public void finer(String msg) {
    logTrace(Level.FINER, "unknown", msg);
  }

  @Override
  public void finer(Supplier<String> msgSupplier) {
    logTrace(Level.FINER, "unknown", msgSupplier);
  }

  @Override
  public void fine(String msg) {
    logTrace(Level.FINE, "unknown", msg);
  }

  @Override
  public void fine(Supplier<String> msgSupplier) {
    logTrace(Level.FINE, "unknown", msgSupplier);
  }
}

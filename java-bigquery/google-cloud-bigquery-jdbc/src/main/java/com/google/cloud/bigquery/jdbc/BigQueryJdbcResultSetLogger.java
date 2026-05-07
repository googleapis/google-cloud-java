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
    String key = clazz.getName() + (connectionId != null ? ":" + connectionId : "");
    return cache.computeIfAbsent(key, k -> new BigQueryJdbcResultSetLogger(clazz, connectionId));
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
    if (connectionId != null) {
      record.setParameters(new Object[] {connectionId});
    }
    super.log(record);
  }

  /**
   * Log a message at Level.FINEST with predefined class name and method name to avoid stack trace
   * parsing on the hot-path.
   */
  public void finestTrace(String methodName, String msg) {
    if (isLoggable(Level.FINEST)) {
      logp(Level.FINEST, targetClassName, methodName, msg);
    }
  }

  /** Log a formatted message at Level.FINEST with predefined class name and method name. */
  public void finestTrace(String methodName, String format, Object... args) {
    if (isLoggable(Level.FINEST)) {
      logp(Level.FINEST, targetClassName, methodName, String.format(format, args));
    }
  }

  /** Log a lazy message at Level.FINEST with predefined class name and method name. */
  public void finestTrace(String methodName, Supplier<String> msgSupplier) {
    if (isLoggable(Level.FINEST)) {
      logp(Level.FINEST, targetClassName, methodName, msgSupplier);
    }
  }

  @Override
  public void finest(String msg) {
    if (isLoggable(Level.FINEST)) {
      logp(Level.FINEST, targetClassName, "unknown", msg);
    }
  }

  @Override
  public void finest(Supplier<String> msgSupplier) {
    if (isLoggable(Level.FINEST)) {
      logp(Level.FINEST, targetClassName, "unknown", msgSupplier);
    }
  }
}

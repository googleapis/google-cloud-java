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

  /** Log a message at Level.FINER with predefined class name and method name. */
  public void finerTrace(String methodName, String msg) {
    if (isLoggable(Level.FINER)) {
      logp(Level.FINER, targetClassName, methodName, msg);
    }
  }

  /** Log a formatted message at Level.FINER with predefined class name and method name. */
  public void finerTrace(String methodName, String format, Object... args) {
    if (isLoggable(Level.FINER)) {
      logp(Level.FINER, targetClassName, methodName, String.format(format, args));
    }
  }

  /** Log a lazy message at Level.FINER with predefined class name and method name. */
  public void finerTrace(String methodName, Supplier<String> msgSupplier) {
    if (isLoggable(Level.FINER)) {
      logp(Level.FINER, targetClassName, methodName, msgSupplier);
    }
  }

  /** Log a message at Level.FINE with predefined class name and method name. */
  public void fineTrace(String methodName, String msg) {
    if (isLoggable(Level.FINE)) {
      logp(Level.FINE, targetClassName, methodName, msg);
    }
  }

  /** Log a formatted message at Level.FINE with predefined class name and method name. */
  public void fineTrace(String methodName, String format, Object... args) {
    if (isLoggable(Level.FINE)) {
      logp(Level.FINE, targetClassName, methodName, String.format(format, args));
    }
  }

  /** Log a lazy message at Level.FINE with predefined class name and method name. */
  public void fineTrace(String methodName, Supplier<String> msgSupplier) {
    if (isLoggable(Level.FINE)) {
      logp(Level.FINE, targetClassName, methodName, msgSupplier);
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

  @Override
  public void finer(String msg) {
    if (isLoggable(Level.FINER)) {
      logp(Level.FINER, targetClassName, "unknown", msg);
    }
  }

  @Override
  public void finer(Supplier<String> msgSupplier) {
    if (isLoggable(Level.FINER)) {
      logp(Level.FINER, targetClassName, "unknown", msgSupplier);
    }
  }

  @Override
  public void fine(String msg) {
    if (isLoggable(Level.FINE)) {
      logp(Level.FINE, targetClassName, "unknown", msg);
    }
  }

  @Override
  public void fine(Supplier<String> msgSupplier) {
    if (isLoggable(Level.FINE)) {
      logp(Level.FINE, targetClassName, "unknown", msgSupplier);
    }
  }
}

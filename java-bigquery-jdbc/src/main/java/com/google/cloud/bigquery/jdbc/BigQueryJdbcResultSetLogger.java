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
 * High-performance logging facade for ResultSet and its related classes.
 *
 * <p>This is deliberately <em>not</em> a {@link java.util.logging.Logger}. Every {@code Logger}
 * instance registers itself as a child of its parent under a JVM-wide lock and that registration is
 * never released, so a logger-per-ResultSet leaks. Instead, one real {@link
 * BigQueryJdbcCustomLogger} is created per class and shared; this facade holds a reference to it
 * plus the connection ID of the ResultSet it serves.
 *
 * <p>Hot-path methods ({@code finestTrace} etc.) set the source class and method explicitly, so no
 * stack-trace walking (caller inference) happens for them. The connection ID is stamped into {@code
 * LogRecord.getParameters()[0]} on every record so {@code PerConnectionFileHandler} can route the
 * record even when the thread-local MDC (mapped diagnostic context — the per-thread connection ID
 * set by the JDBC proxy) is empty, which is the normal case for un-proxied ResultSet calls.
 */
public final class BigQueryJdbcResultSetLogger {

  /** One registered logger per class. Bounded by the number of result-set classes. */
  private static final ConcurrentHashMap<String, BigQueryJdbcCustomLogger> DELEGATES =
      new ConcurrentHashMap<>();

  /** Facades with no connection ID are immutable and shared, matching the old caching behaviour. */
  private static final ConcurrentHashMap<String, BigQueryJdbcResultSetLogger> GLOBAL_FACADES =
      new ConcurrentHashMap<>();

  private final BigQueryJdbcCustomLogger delegate;
  private final String targetClassName;
  private final String connectionId;

  private BigQueryJdbcResultSetLogger arrowStructLogger;
  private BigQueryJdbcResultSetLogger jsonStructLogger;
  private BigQueryJdbcResultSetLogger arrowArrayLogger;
  private BigQueryJdbcResultSetLogger jsonArrayLogger;

  private BigQueryJdbcResultSetLogger(
      BigQueryJdbcCustomLogger delegate, String targetClassName, String connectionId) {
    this.delegate = delegate;
    this.targetClassName = targetClassName;
    this.connectionId = connectionId;
  }

  public static BigQueryJdbcResultSetLogger getLogger(Class<?> clazz) {
    return getLogger(clazz, null);
  }

  public static BigQueryJdbcResultSetLogger getLogger(Class<?> clazz, String connectionId) {
    String className = clazz.getName();
    BigQueryJdbcCustomLogger delegate =
        DELEGATES.computeIfAbsent(className, BigQueryJdbcCustomLogger::new);
    if (connectionId == null) {
      return GLOBAL_FACADES.computeIfAbsent(
          className, k -> new BigQueryJdbcResultSetLogger(delegate, k, null));
    }
    return new BigQueryJdbcResultSetLogger(delegate, className, connectionId);
  }

  public String getConnectionId() {
    return connectionId;
  }

  /** The shared, registered logger this facade forwards to. Exposed for tests only. */
  BigQueryJdbcCustomLogger delegate() {
    return delegate;
  }

  public boolean isLoggable(Level level) {
    return delegate.isLoggable(level);
  }

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

  /**
   * Stamps the connection ID into {@code params[0]} and forwards to the shared logger. Does not
   * touch the record's source class/method: hot-path callers set them explicitly, and cold-path
   * callers ({@code severe}, {@code warning}) rely on {@link
   * BigQueryJdbcCustomLogger.BigQueryJdbcLogRecord} to infer them lazily.
   */
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
    delegate.log(record);
  }

  private void logTrace(Level level, String methodName, String msg) {
    if (!delegate.isLoggable(level)) {
      return;
    }
    LogRecord record = new LogRecord(level, msg);
    record.setSourceClassName(targetClassName);
    record.setSourceMethodName(methodName);
    log(record);
  }

  private void logTrace(Level level, String methodName, Supplier<String> msgSupplier) {
    if (!delegate.isLoggable(level)) {
      return;
    }
    logTrace(level, methodName, msgSupplier.get());
  }

  /** Cold path: builds a record whose caller is inferred lazily by the formatter. */
  private void logWithCaller(Level level, Throwable thrown, String msg) {
    if (!delegate.isLoggable(level)) {
      return;
    }
    LogRecord record = new BigQueryJdbcCustomLogger.BigQueryJdbcLogRecord(level, msg);
    record.setThrown(thrown);
    log(record);
  }

  /** Log at FINEST with the class name, method name and "++enter++" preset (no stack walk). */
  public void finestTrace(String methodName) {
    logTrace(Level.FINEST, methodName, "++enter++");
  }

  /** Log at FINEST with the class name and method name preset (no stack walk). */
  public void finestTrace(String methodName, String msg) {
    logTrace(Level.FINEST, methodName, msg);
  }

  /** Log a lazy message at FINEST with the class name and method name preset. */
  public void finestTrace(String methodName, Supplier<String> msgSupplier) {
    logTrace(Level.FINEST, methodName, msgSupplier);
  }

  /** Log at FINER with the class name and method name preset. */
  public void finerTrace(String methodName, String msg) {
    logTrace(Level.FINER, methodName, msg);
  }

  /** Log a lazy message at FINER with the class name and method name preset. */
  public void finerTrace(String methodName, Supplier<String> msgSupplier) {
    logTrace(Level.FINER, methodName, msgSupplier);
  }

  /** Log at FINE with the class name and method name preset. */
  public void fineTrace(String methodName, String msg) {
    logTrace(Level.FINE, methodName, msg);
  }

  /** Log a lazy message at FINE with the class name and method name preset. */
  public void fineTrace(String methodName, Supplier<String> msgSupplier) {
    logTrace(Level.FINE, methodName, msgSupplier);
  }

  public void finest(String msg) {
    logTrace(Level.FINEST, "unknown", msg);
  }

  public void finest(Supplier<String> msgSupplier) {
    logTrace(Level.FINEST, "unknown", msgSupplier);
  }

  public void finer(String msg) {
    logTrace(Level.FINER, "unknown", msg);
  }

  public void finer(Supplier<String> msgSupplier) {
    logTrace(Level.FINER, "unknown", msgSupplier);
  }

  public void fine(String msg) {
    logTrace(Level.FINE, "unknown", msg);
  }

  public void fine(Supplier<String> msgSupplier) {
    logTrace(Level.FINE, "unknown", msgSupplier);
  }

  void warning(String format, Object... args) {
    if (!delegate.isLoggable(Level.WARNING)) {
      return;
    }
    logWithCaller(Level.WARNING, null, String.format(format, args));
  }

  public void severe(String msg, Throwable thrown) {
    logWithCaller(Level.SEVERE, thrown, msg);
  }
}

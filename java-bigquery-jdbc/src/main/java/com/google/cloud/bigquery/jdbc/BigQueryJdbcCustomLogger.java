/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class BigQueryJdbcCustomLogger extends Logger {

  protected BigQueryJdbcCustomLogger(String name, String resourceBundleName) {
    super(name, resourceBundleName);
    this.setParent(BigQueryJdbcRootLogger.getRootLogger());
  }

  public BigQueryJdbcCustomLogger(String name) {
    this(name, null);
    this.setParent(BigQueryJdbcRootLogger.getRootLogger());
  }

  private void logWithCaller(Level level, Supplier<String> msgSupplier) {
    logWithCaller(level, null, msgSupplier);
  }

  private void logWithCaller(Level level, Throwable thrown, Supplier<String> msgSupplier) {
    if (!isLoggable(level)) {
      return;
    }

    LogRecord record = new BigQueryJdbcLogRecord(level, msgSupplier.get());
    record.setThrown(thrown);
    log(record);
  }

  static class BigQueryJdbcLogRecord extends LogRecord {
    private boolean callerInferred = false;
    private String sourceClass;
    private String sourceMethod;

    public BigQueryJdbcLogRecord(Level level, String msg) {
      super(level, msg);
    }

    synchronized boolean isCallerInferred() {
      return callerInferred;
    }

    @Override
    public synchronized String getSourceClassName() {
      inferCaller();
      return sourceClass;
    }

    @Override
    public synchronized void setSourceClassName(String sourceClassName) {
      super.setSourceClassName(sourceClassName);
      this.sourceClass = sourceClassName;
      this.callerInferred = true;
    }

    @Override
    public synchronized String getSourceMethodName() {
      inferCaller();
      return sourceMethod;
    }

    @Override
    public synchronized void setSourceMethodName(String sourceMethodName) {
      super.setSourceMethodName(sourceMethodName);
      this.sourceMethod = sourceMethodName;
      this.callerInferred = true;
    }

    private synchronized void inferCaller() {
      if (callerInferred) {
        return;
      }
      callerInferred = true;
      StackTraceElement[] stackTrace = new Throwable().getStackTrace();
      sourceClass = "unknown";
      sourceMethod = "unknown";

      for (StackTraceElement element : stackTrace) {
        String className = element.getClassName();
        if (isDriverClass(className) && !isLoggerClass(className)) {
          sourceClass = className;
          sourceMethod = element.getMethodName();
          break;
        }
      }
      super.setSourceClassName(sourceClass);
      super.setSourceMethodName(sourceMethod);
    }

    private static boolean isDriverClass(String className) {
      return className.startsWith("com.google.cloud.bigquery.jdbc.")
          || className.startsWith("com.google.cloud.bigquery.exception.");
    }

    private static boolean isLoggerClass(String className) {
      return className.equals("com.google.cloud.bigquery.jdbc.BigQueryJdbcCustomLogger")
          || className.equals("com.google.cloud.bigquery.jdbc.BigQueryJdbcResultSetLogger")
          || className.startsWith("com.google.cloud.bigquery.jdbc.BigQueryJdbcRootLogger")
          || className.equals(BigQueryJdbcLogRecord.class.getName());
    }
  }

  @Override
  public void finest(String msg) {
    logWithCaller(Level.FINEST, () -> msg);
  }

  @Override
  public void finer(String msg) {
    logWithCaller(Level.FINER, () -> msg);
  }

  @Override
  public void fine(String msg) {
    logWithCaller(Level.FINE, () -> msg);
  }

  void finest(String format, Object... args) {
    logWithCaller(Level.FINEST, () -> String.format(format, args));
  }

  void finer(String format, Object... args) {
    logWithCaller(Level.FINER, () -> String.format(format, args));
  }

  void fine(String format, Object... args) {
    logWithCaller(Level.FINE, () -> String.format(format, args));
  }

  void config(String format, Object... args) {
    logWithCaller(Level.CONFIG, () -> String.format(format, args));
  }

  void info(String format, Object... args) {
    logWithCaller(Level.INFO, () -> String.format(format, args));
  }

  void warning(String format, Object... args) {
    logWithCaller(Level.WARNING, () -> String.format(format, args));
  }

  void warning(Throwable thrown, String msg) {
    logWithCaller(Level.WARNING, thrown, () -> msg);
  }

  void warning(Throwable thrown, String format, Object... args) {
    logWithCaller(Level.WARNING, thrown, () -> String.format(format, args));
  }

  void severe(String format, Object... args) {
    logWithCaller(Level.SEVERE, () -> String.format(format, args));
  }

  public void severe(String msg, Throwable thrown) {
    logWithCaller(Level.SEVERE, thrown, () -> msg);
  }

  public void severe(String format, Throwable thrown, Object... args) {
    logWithCaller(Level.SEVERE, thrown, () -> String.format(format, args));
  }

  @Override
  public void finest(Supplier<String> msgSupplier) {
    logWithCaller(Level.FINEST, msgSupplier);
  }

  @Override
  public void fine(Supplier<String> msgSupplier) {
    logWithCaller(Level.FINE, msgSupplier);
  }
}

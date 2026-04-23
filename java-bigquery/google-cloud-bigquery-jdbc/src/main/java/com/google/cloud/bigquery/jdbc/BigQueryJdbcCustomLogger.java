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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

class BigQueryJdbcCustomLogger extends Logger {

  protected BigQueryJdbcCustomLogger(String name, String resourceBundleName) {
    super(name, resourceBundleName);
    this.setParent(BigQueryJdbcRootLogger.getRootLogger());
  }

  BigQueryJdbcCustomLogger(String name) {
    this(name, null);
    this.setParent(BigQueryJdbcRootLogger.getRootLogger());
  }

  private void logWithCaller(Level level, Supplier<String> msgSupplier) {
    if (!isLoggable(level)) {
      return;
    }

    StackTraceElement[] stackTrace = new Throwable().getStackTrace();
    String sourceClass = "unknown";
    String sourceMethod = "unknown";

    for (StackTraceElement element : stackTrace) {
      String className = element.getClassName();
      if (!className.equals(BigQueryJdbcCustomLogger.class.getName())) {
        sourceClass = className;
        sourceMethod = element.getMethodName();
        break;
      }
    }

    logp(level, sourceClass, sourceMethod, msgSupplier);
  }

  private String formatStackTrace(Throwable thrown) {
    StringWriter sw = new StringWriter();
    thrown.printStackTrace(new PrintWriter(sw));
    return sw.toString();
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
    logWithCaller(Level.WARNING, () -> msg + System.lineSeparator() + formatStackTrace(thrown));
  }

  void warning(Throwable thrown, String format, Object... args) {
    logWithCaller(
        Level.WARNING,
        () -> String.format(format, args) + System.lineSeparator() + formatStackTrace(thrown));
  }

  void severe(String format, Object... args) {
    logWithCaller(Level.SEVERE, () -> String.format(format, args));
  }

  void severe(Throwable thrown, String msg) {
    logWithCaller(Level.SEVERE, () -> msg + System.lineSeparator() + formatStackTrace(thrown));
  }

  void severe(Throwable thrown, String format, Object... args) {
    logWithCaller(
        Level.SEVERE,
        () -> String.format(format, args) + System.lineSeparator() + formatStackTrace(thrown));
  }
}

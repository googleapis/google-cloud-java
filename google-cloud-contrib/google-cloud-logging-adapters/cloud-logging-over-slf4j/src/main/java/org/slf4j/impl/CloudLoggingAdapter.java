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

import com.google.cloud.logging.Severity;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

public class CloudLoggingAdapter implements Logger, Serializable {

  private static final long serialVersionUID = 1L;
  private CloudLogger cloudLogger;

  CloudLoggingAdapter(String loggerName) {
    try {
      cloudLogger = new CloudLogger(loggerName);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static void lazyInit() {
    CloudLogger.init();
  }

  public String getName() {
    return cloudLogger.getName();
  }

  public boolean isTraceEnabled() {
    return cloudLogger.isEnabled(Severity.DEBUG);
  }

  public void trace(String s) {
    log(Severity.DEBUG, s);
  }

  public void trace(String s, Object o) {
    log(Severity.DEBUG, s, o);
  }

  public void trace(String format, Object o, Object o1) {
    log(Severity.DEBUG, format, o, o1);
  }

  public void trace(String format, Object[] objects) {
    log(Severity.DEBUG, format, objects);
  }

  public void trace(String s, Throwable throwable) {
    log(Severity.DEBUG, s, throwable);
  }

  public boolean isTraceEnabled(Marker marker) {
    return cloudLogger.isEnabled(Severity.DEBUG);
  }

  public void trace(Marker marker, String s) {
    log(marker, Severity.DEBUG, s);
  }

  public void trace(Marker marker, String format, Object o) {
    log(marker, Severity.DEBUG, format, o);
  }

  public void trace(Marker marker, String format, Object o, Object o1) {
    log(Severity.DEBUG, format, o, o1);
  }

  public void trace(Marker marker, String format, Object[] objects) {
    log(marker, Severity.DEBUG, format, objects);
  }

  public void trace(Marker marker, String s, Throwable throwable) {
    log(marker, Severity.DEBUG, s, throwable);
  }

  public boolean isDebugEnabled() {
    return cloudLogger.isEnabled(Severity.DEBUG);
  }

  public void debug(String s) {
    log(Severity.DEBUG, s);
  }

  public void debug(String format, Object o) {
    log(Severity.DEBUG, format, o);
  }

  public void debug(String format, Object o, Object o1) {
    log(Severity.DEBUG, format, o, o1);
  }

  public void debug(String format, Object[] objects) {
    log(Severity.DEBUG, format, objects);
  }

  public void debug(String s, Throwable throwable) {
    log(Severity.DEBUG, s, throwable);
  }

  public boolean isDebugEnabled(Marker marker) {
    return cloudLogger.isEnabled(Severity.DEBUG);
  }

  public void debug(Marker marker, String s) {
    log(marker, Severity.DEBUG, s);
  }

  public void debug(Marker marker, String format, Object o) {
    log(marker, Severity.DEBUG, format, o);
  }

  public void debug(Marker marker, String format, Object o, Object o1) {
    log(marker, Severity.DEBUG, format, o, o1);
  }

  public void debug(Marker marker, String format, Object[] objects) {
    log(marker, Severity.DEBUG, format, objects);
  }

  public void debug(Marker marker, String s, Throwable throwable) {
    log(marker, Severity.DEBUG, s, throwable);
  }

  public boolean isInfoEnabled() {
    return cloudLogger.isEnabled(Severity.INFO);
  }

  public void info(String s) {
    log(Severity.INFO, s);
  }

  public void info(String s, Object o) {
    log(Severity.INFO, s, o);
  }

  public void info(String s, Object o, Object o1) {
    log(Severity.INFO, s, o, o1);
  }

  public void info(String s, Object[] objects) {
    log(Severity.INFO, s, objects);
  }

  public void info(String s, Throwable throwable) {
    log(Severity.INFO, s, throwable);
  }

  public boolean isInfoEnabled(Marker marker) {
    return cloudLogger.isEnabled(Severity.INFO);
  }

  public void info(Marker marker, String s) {
    cloudLogger.log(marker, Severity.INFO, s);
  }

  public void info(Marker marker, String s, Object o) {
    log(marker, Severity.INFO, s, o);
  }

  public void info(Marker marker, String s, Object o, Object o1) {
    log(marker, Severity.INFO, s, o, o1);
  }

  public void info(Marker marker, String s, Object[] objects) {
    log(marker, Severity.INFO, s, objects);
  }

  public void info(Marker marker, String s, Throwable throwable) {
    log(marker, Severity.INFO, s, throwable);
  }

  public boolean isWarnEnabled() {
    return cloudLogger.isEnabled(Severity.WARNING);
  }

  public void warn(String s) {
    log(Severity.WARNING, s);
  }

  public void warn(String s, Object o) {
    log(Severity.WARNING, s, o);
  }

  public void warn(String s, Object[] objects) {
    log(Severity.WARNING, s, objects);
  }

  public void warn(String s, Object o, Object o1) {
    log(Severity.WARNING, s, o, o1);
  }

  public void warn(String s, Throwable throwable) {
    log(Severity.WARNING, s, throwable);
  }

  public boolean isWarnEnabled(Marker marker) {
    return cloudLogger.isEnabled(Severity.WARNING);
  }

  public void warn(Marker marker, String s) {
    log(marker, Severity.WARNING, s);
  }

  public void warn(Marker marker, String s, Object o) {
    log(marker, Severity.WARNING, s, o);
  }

  public void warn(Marker marker, String s, Object o, Object o1) {
    log(marker, Severity.WARNING, s, o, o1);
  }

  public void warn(Marker marker, String s, Object[] objects) {
    log(marker, Severity.WARNING, s, objects);
  }

  public void warn(Marker marker, String s, Throwable throwable) {
    log(marker, Severity.WARNING, s, throwable);
  }

  public boolean isErrorEnabled() {
    return cloudLogger.isEnabled(Severity.ERROR);
  }

  public void error(String s) {
    log(Severity.ERROR, s);
  }

  public void error(String s, Object o) {
    log(Severity.ERROR, s, o);
  }

  public void error(String s, Object o, Object o1) {
    log(Severity.ERROR, s, o, o1);
  }

  public void error(String s, Object[] objects) {
    log(Severity.ERROR, s, objects);
  }

  public void error(String s, Throwable throwable) {
    log(Severity.ERROR, s, throwable);
  }

  public boolean isErrorEnabled(Marker marker) {
    return cloudLogger.isEnabled(Severity.ERROR);
  }

  public void error(Marker marker, String s) {
    cloudLogger.log(marker, Severity.ERROR, s);
  }

  public void error(Marker marker, String s, Object o) {
    log(marker, Severity.ERROR, s, o);
  }

  public void error(Marker marker, String s, Object o, Object o1) {
    log(marker, Severity.ERROR, s, o, o1);
  }

  public void error(Marker marker, String s, Object[] objects) {
    log(marker, Severity.ERROR, s, objects);
  }

  public void error(Marker marker, String s, Throwable throwable) {
    log(marker, Severity.ERROR, s, throwable);
  }

  private void log(Severity severity, String s) {
    if (cloudLogger.isEnabled(severity)) {
      cloudLogger.log(severity, s);
    }
  }

  private void log(Severity severity, String format, Object... obj) {
    if (cloudLogger.isEnabled(severity)) {
      FormattingTuple tp = MessageFormatter.format(format, obj);
      cloudLogger.log(severity, tp.getMessage(), tp.getThrowable());
    }
  }

  private void log(Marker marker, Severity severity, String s) {
    if (cloudLogger.isEnabled(severity)) {
      cloudLogger.log(marker, severity, s);
    }
  }

  private void log(Marker marker, Severity severity, String format, Object... obj) {
    if (cloudLogger.isEnabled(severity)) {
      FormattingTuple tp = MessageFormatter.format(format, obj);
      cloudLogger.log(marker, severity, tp.getMessage(), tp.getThrowable());
    }
  }
}

/*
 * Copyright 2025 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.gax.logging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.event.KeyValuePair;
import org.slf4j.event.Level;
import org.slf4j.event.LoggingEvent;
import org.slf4j.spi.LoggingEventAware;

/** Logger implementation for testing purposes only. Only implemented methods used in tests. */
public class TestLogger implements Logger, LoggingEventAware {
  Map<String, String> MDCMap = new HashMap<>();
  List<String> messageList = new ArrayList<>();
  Level level;

  Map<String, Object> keyValuePairsMap = new HashMap<>();

  private String loggerName;
  private boolean infoEnabled;
  private boolean debugEnabled;

  public TestLogger(String name) {
    loggerName = name;
    infoEnabled = true;
    debugEnabled = true;
  }

  public TestLogger(String name, boolean info, boolean debug) {
    loggerName = name;
    infoEnabled = info;
    debugEnabled = debug;
  }

  @Override
  public String getName() {
    return loggerName;
  }

  @Override
  public boolean isTraceEnabled() {
    return false;
  }

  @Override
  public void trace(String msg) {
    level = Level.TRACE;
  }

  @Override
  public void trace(String format, Object arg) {}

  @Override
  public void trace(String format, Object arg1, Object arg2) {}

  @Override
  public void trace(String format, Object... arguments) {}

  @Override
  public void trace(String msg, Throwable t) {}

  @Override
  public boolean isTraceEnabled(Marker marker) {
    return false;
  }

  @Override
  public void trace(Marker marker, String msg) {}

  @Override
  public void trace(Marker marker, String format, Object arg) {}

  @Override
  public void trace(Marker marker, String format, Object arg1, Object arg2) {}

  @Override
  public void trace(Marker marker, String format, Object... argArray) {}

  @Override
  public void trace(Marker marker, String msg, Throwable t) {}

  @Override
  public boolean isDebugEnabled() {
    return debugEnabled;
  }

  @Override
  public void debug(String msg) {
    Map<String, String> currentMDC = MDC.getCopyOfContextMap();
    MDCMap.putAll(currentMDC);
    messageList.add(msg);
    level = Level.DEBUG;
  }

  @Override
  public void debug(String format, Object arg) {}

  @Override
  public void debug(String format, Object arg1, Object arg2) {}

  @Override
  public void debug(String format, Object... arguments) {}

  @Override
  public void debug(String msg, Throwable t) {}

  @Override
  public boolean isDebugEnabled(Marker marker) {
    return false;
  }

  @Override
  public void debug(Marker marker, String msg) {}

  @Override
  public void debug(Marker marker, String format, Object arg) {}

  @Override
  public void debug(Marker marker, String format, Object arg1, Object arg2) {}

  @Override
  public void debug(Marker marker, String format, Object... arguments) {}

  @Override
  public void debug(Marker marker, String msg, Throwable t) {}

  @Override
  public boolean isInfoEnabled() {
    return infoEnabled;
  }

  @Override
  public void info(String msg) {
    // access MDC content here before it is cleared.
    // TestMDCAdapter is set up via TestServiceProvider
    // to allow MDC values recorded and copied for testing here
    Map<String, String> currentMDC = MDC.getCopyOfContextMap();
    MDCMap.putAll(currentMDC);
    messageList.add(msg);
  }

  @Override
  public void info(String format, Object arg) {}

  @Override
  public void info(String format, Object arg1, Object arg2) {}

  @Override
  public void info(String format, Object... arguments) {}

  @Override
  public void info(String msg, Throwable t) {}

  @Override
  public boolean isInfoEnabled(Marker marker) {
    return false;
  }

  @Override
  public void info(Marker marker, String msg) {}

  @Override
  public void info(Marker marker, String format, Object arg) {}

  @Override
  public void info(Marker marker, String format, Object arg1, Object arg2) {}

  @Override
  public void info(Marker marker, String format, Object... arguments) {}

  @Override
  public void info(Marker marker, String msg, Throwable t) {}

  @Override
  public boolean isWarnEnabled() {
    return false;
  }

  @Override
  public void warn(String msg) {
    level = Level.WARN;
  }

  @Override
  public void warn(String format, Object arg) {}

  @Override
  public void warn(String format, Object... arguments) {}

  @Override
  public void warn(String format, Object arg1, Object arg2) {}

  @Override
  public void warn(String msg, Throwable t) {}

  @Override
  public boolean isWarnEnabled(Marker marker) {
    return false;
  }

  @Override
  public void warn(Marker marker, String msg) {}

  @Override
  public void warn(Marker marker, String format, Object arg) {}

  @Override
  public void warn(Marker marker, String format, Object arg1, Object arg2) {}

  @Override
  public void warn(Marker marker, String format, Object... arguments) {}

  @Override
  public void warn(Marker marker, String msg, Throwable t) {}

  @Override
  public boolean isErrorEnabled() {
    return false;
  }

  @Override
  public void error(String msg) {
    level = Level.ERROR;
  }

  @Override
  public void error(String format, Object arg) {}

  @Override
  public void error(String format, Object arg1, Object arg2) {}

  @Override
  public void error(String format, Object... arguments) {}

  @Override
  public void error(String msg, Throwable t) {}

  @Override
  public boolean isErrorEnabled(Marker marker) {
    return false;
  }

  @Override
  public void error(Marker marker, String msg) {}

  @Override
  public void error(Marker marker, String format, Object arg) {}

  @Override
  public void error(Marker marker, String format, Object arg1, Object arg2) {}

  @Override
  public void error(Marker marker, String format, Object... arguments) {}

  @Override
  public void error(Marker marker, String msg, Throwable t) {}

  @Override
  public void log(LoggingEvent event) {
    messageList.add(event.getMessage());
    level = event.getLevel();
    List<KeyValuePair> keyValuePairs = event.getKeyValuePairs();
    for (KeyValuePair pair : keyValuePairs) {
      keyValuePairsMap.put(pair.key, pair.value);
    }
  }
}

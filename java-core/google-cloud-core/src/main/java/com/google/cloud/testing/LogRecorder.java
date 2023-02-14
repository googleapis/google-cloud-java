/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.testing;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class records the logs in memory and flush them onto the {@link java.util.logging.Logger}
 * when {@link #flush()} method is called.
 *
 * <p>This component is useful to hold logs for some time and flush them if needed. For example, we
 * would want to ignore the trivial startup logs of a sub-process if it is started successfully, but
 * <b>in case any error occurs</b>, these logs should be propagated to the user for the debugging
 * purpose.
 */
class LogRecorder {

  private final Pattern logLinePattern = Pattern.compile("([A-Z]+):.*");
  private final Logger logger;
  private StringBuilder logs;

  public LogRecorder(Logger logger) {
    this.logger = logger;
    this.logs = new StringBuilder();
  }

  /**
   * Records a log line.
   *
   * @param logLine the log to record.
   */
  public void record(String logLine) {
    if (hasLevel(logLine)) {
      String stripLevel = logLine.split(":")[1].trim();
      this.logs.append(stripLevel);
    } else {
      this.logs.append(logLine);
    }
    this.logs.append(System.getProperty("line.separator"));
  }

  /** Flushes all the logs to the underlying {@link java.util.logging.Logger}. */
  public void flush() {
    if (this.logs.length() > 0) {
      logger.log(Level.INFO, this.logs.toString());
      this.logs = new StringBuilder();
    }
  }

  private boolean hasLevel(String line) {
    return getLevel(line) != null;
  }

  private Level getLevel(String line) {
    try {
      Matcher matcher = logLinePattern.matcher(line);
      if (matcher.matches()) {
        return Level.parse(matcher.group(1));
      } else {
        return null;
      }
    } catch (IllegalArgumentException e) {
      return null;
    }
  }
}

/*
 * Copyright 2022 Google LLC
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

public class StartupLogAggregator {

  private final Pattern logLinePattern = Pattern.compile("([A-Z]+):.*");
  private final Logger logger;
  private final StringBuilder logs;

  public StartupLogAggregator(Logger logger) {
    this.logger = logger;
    this.logs = new StringBuilder();
  }

  public void process(String logLine) {
    if (hasLevel(logLine)) {
      String stripLevel = logLine.split(":")[1].trim();
      this.logs.append(stripLevel);
    } else {
      this.logs.append(logLine);
    }
    this.logs.append(System.getProperty("line.separator"));
  }

  public void writeLog() {
    logger.log(Level.INFO, this.logs.toString());
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

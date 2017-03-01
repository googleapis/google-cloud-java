/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.common.base.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class allows to read a process output stream, block until a provided string appears on the
 * stream and redirect pertinent error logs to a provided logger.
 */
class BlockingProcessStreamReader extends Thread {

  private static final int LOG_LENGTH_LIMIT = 50000;

  private final BufferedReader errorReader;
  private final Logger logger;
  private StringBuilder currentLog;
  private Level currentLogLevel;
  private boolean collectionMode;
  private final String emulatorTag;
  private final Pattern logLinePattern;

  private BlockingProcessStreamReader(String emulator, InputStream stream, String blockUntil,
      Logger logger) throws IOException {
    super("blocking-process-stream-reader");
    setDaemon(true);
    errorReader = new BufferedReader(new InputStreamReader(stream));
    this.logger = logger;
    this.emulatorTag = "[" + emulator + "]";
    this.logLinePattern = Pattern.compile("(\\[" + emulator + "\\]\\s)?(\\w+):.*");
    if (!Strings.isNullOrEmpty(blockUntil)) {
      String line;
      do {
        line = errorReader.readLine();
      } while (line != null && !line.contains(blockUntil));
    }
  }

  @Override
  public void run() {
    String previousLine = "";
    String nextLine = "";
    try {
      for (;;) {
        previousLine = nextLine;
        nextLine = errorReader.readLine();
        if (nextLine == null) {
          break;
        }
        processLogLine(previousLine, nextLine);
      }
    } catch (IOException e) {
      e.printStackTrace(System.err);
    }
    processLogLine(previousLine, firstNonNull(nextLine, ""));
    writeLog();
  }

  private void processLogLine(String previousLine, String nextLine) {
    // Each log is two lines with the following format:
    //     [Emulator]? [Date] [Time] [LoggingClass] [method]
    //     [Emulator]? [LEVEL]: error message
    //     [Emulator]? more data
    // Exceptions and stack traces are included in error stream, separated by a newline
    Level nextLogLevel = getLevel(nextLine);
    if (nextLogLevel != null) {
      writeLog();
      currentLog = new StringBuilder();
      currentLogLevel = nextLogLevel;
      collectionMode = true;
    } else if (collectionMode) {
      if (currentLog.length() > LOG_LENGTH_LIMIT) {
        collectionMode = false;
      } else if (currentLog.length() == 0) {
        // strip level out of the line
        currentLog.append(emulatorTag);
        currentLog.append(previousLine.split(":", 2)[1]);
        currentLog.append(System.getProperty("line.separator"));
      } else {
        if (!previousLine.startsWith(emulatorTag)) {
          currentLog.append(emulatorTag);
          currentLog.append(' ');
        }
        currentLog.append(previousLine);
        currentLog.append(System.getProperty("line.separator"));
      }
    }
  }

  private void writeLog() {
    if (currentLogLevel != null && currentLog != null && currentLog.length() != 0) {
      logger.log(currentLogLevel, currentLog.toString().trim());
    }
  }

  private Level getLevel(String line) {
    try {
      Matcher matcher = logLinePattern.matcher(line);
      if (matcher.matches()) {
        return Level.parse(matcher.group(2));
      } else {
        return null;
      }
    } catch (IllegalArgumentException e) {
      return null; // level wasn't supplied in this log line
    }
  }

  static BlockingProcessStreamReader start(String emulator, InputStream stream, String blockUntil,
      Logger logger) throws IOException {
    BlockingProcessStreamReader thread =
        new BlockingProcessStreamReader(emulator, stream, blockUntil, logger);
    thread.start();
    return thread;
  }
}

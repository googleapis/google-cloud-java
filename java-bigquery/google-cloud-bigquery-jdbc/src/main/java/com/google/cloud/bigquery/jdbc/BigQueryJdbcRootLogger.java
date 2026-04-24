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

import com.google.common.base.Strings;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/** This class is used to log messages from the BigQuery JDBC Driver. */
class BigQueryJdbcRootLogger {

  /**
   * Note: Each connection will have its own file handler with the level and logPath specified in
   * the connection properties. But the logs will be driver logs and not connection specific.
   */
  private static final Logger logger = Logger.getLogger("com.google.cloud.bigquery");

  private static final Logger storageLogger = Logger.getLogger("com.google.cloud.bigquery.storage");
  private static final boolean isTest = Boolean.getBoolean("JDBC_TESTS");

  private static Handler fileHandler = null;
  private static Path currentLogPath = null;
  private static int fileCounter = 0;

  static final String PROCESS_ID = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];

  private static final ThreadLocal<SimpleDateFormat> DATE_FORMATTER =
      ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));

  static String getThreadName(long threadId) {
    Thread current = Thread.currentThread();
    if (current.getId() == threadId) {
      return current.getName();
    }
    ThreadGroup rootGroup = current.getThreadGroup();
    while (rootGroup.getParent() != null) {
      rootGroup = rootGroup.getParent();
    }

    int count = rootGroup.activeCount();
    Thread[] threads = new Thread[count * 2];
    int actualCount = rootGroup.enumerate(threads);
    for (int i = 0; i < actualCount; i++) {
      if (threads[i].getId() == threadId) {
        return threads[i].getName();
      }
    }
    return "";
  }

  static {
    logger.setUseParentHandlers(false);
    storageLogger.setUseParentHandlers(true);
    if (isTest) {
      ConsoleHandler consoleHandler = new ConsoleHandler();
      consoleHandler.setLevel(Level.SEVERE);
      consoleHandler.setFormatter(getFormatter());
      logger.addHandler(consoleHandler);
    }
  }

  public static Formatter getFormatter() {
    return new Formatter() {
      private static final int MAX_THREAD_NAME_LENGTH = 15;

      @Override
      public String format(LogRecord record) {
        String date = DATE_FORMATTER.get().format(new Date(record.getMillis()));

        long threadId = record.getThreadID();
        String threadName = getThreadName(threadId);

        if (threadName.length() > MAX_THREAD_NAME_LENGTH) {
          threadName = threadName.substring(threadName.length() - MAX_THREAD_NAME_LENGTH);
        }

        String sourceClassName = record.getLoggerName();
        String sourceMethodName = record.getSourceMethodName();

        // Expected log format: yyyy-MM-dd HH:mm:ss.SSS LEVEL PID --- [THREAD] CLASS METHOD: MESSAGE
        // Example: 2026-04-22 10:16:00.123  INFO 12345 --- [main   ]
        // com.google.cloud.bigquery.jdbc.BigQueryConnection connect             : Connection
        // successful
        StringBuilder sb = new StringBuilder(256);
        sb.append(date)
            .append(" ")
            .append(Strings.padStart(record.getLevel().getName(), 5, ' '))
            .append(" ")
            .append(PROCESS_ID)
            .append(" --- [")
            .append(Strings.padEnd(threadName, 7, ' '))
            .append("] ")
            .append(Strings.padEnd(sourceClassName != null ? sourceClassName : "", 50, ' '))
            .append(" ")
            .append(Strings.padEnd(sourceMethodName != null ? sourceMethodName : "", 20, ' '))
            .append(": ")
            .append(record.getMessage())
            .append(System.lineSeparator());

        if (record.getThrown() != null) {
          java.io.StringWriter sw = new java.io.StringWriter();
          record.getThrown().printStackTrace(new java.io.PrintWriter(sw));
          sb.append(sw.toString()).append(System.lineSeparator());
        }

        return sb.toString();
      }
    };
  }

  public static Logger getRootLogger() {
    return logger;
  }

  private static void setHandler() throws IOException {
    // If Console handler exists, remove it.
    // If File handler exists, use it. Else create new one.
    for (Handler h : logger.getHandlers()) {
      if (h instanceof ConsoleHandler) {
        if (!isTest) {
          h.close();
          logger.removeHandler(h);
        }
      } else if (h instanceof FileHandler) {
        fileHandler = h;
      }
    }

    if (fileHandler == null) {
      String fileName = String.format("BigQueryJdbc%d", fileCounter);
      fileCounter++;

      currentLogPath = Files.createTempFile(fileName, ".log");
      currentLogPath.toFile().deleteOnExit();

      fileHandler = new FileHandler(currentLogPath.toString(), 0, 1, true);
      logger.addHandler(fileHandler);
    }
  }

  public static void setLevel(Level level, String logPath) throws IOException {
    if (level != Level.OFF) {
      setPath(logPath);
      if (logger.getHandlers().length == 0) {
        setHandler();
        fileHandler.setFormatter(getFormatter());
        logger.setUseParentHandlers(false);
      }
      fileHandler.setLevel(level);
      logger.setLevel(level);
    } else {
      for (Handler h : logger.getHandlers()) {
        h.close();
        logger.removeHandler(h);
      }
      fileHandler = null;
      currentLogPath = null;
    }
  }

  static void setPath(String logPath) {
    try {
      if (!logPath.isEmpty() && !logPath.endsWith("/")) {
        logPath = logPath + "/";
      }
      Path dir = Paths.get(logPath);
      if (!Files.exists(dir)) {
        Files.createDirectory(dir);
      }

      String fileName = String.format("BigQueryJdbc%d.log", fileCounter);
      fileCounter++;
      Path destination = Paths.get(logPath + fileName).toAbsolutePath();

      if (currentLogPath != null && !currentLogPath.equals(destination)) {
        Path source = Paths.get(currentLogPath.toUri());
        Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
      }

      currentLogPath = destination;
      fileHandler = new FileHandler(currentLogPath.toString(), 0, 1, true);
      fileHandler.setFormatter(getFormatter());

      for (Handler h : logger.getHandlers()) {
        if (h instanceof FileHandler) {
          h.close();
          logger.removeHandler(h);
          break;
        }
      }

      logger.addHandler(fileHandler);

    } catch (IOException ex) {
      logger.warning("Log File warning : " + ex);
    }
  }
}

/*
 * Copyright 2026 Google LLC
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

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
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

  private static Handler fileHandler = null;
  private static Path currentLogPath = null;
  private static int fileCounter = 0;

  static {
    logger.setUseParentHandlers(false);
    storageLogger.setUseParentHandlers(true);
  }

  public static Formatter getFormatter() {
    return new Formatter() {
      private static final String PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
      private static final String FORMAT =
          "%1$s %2$5s %3$d --- [%4$-7.15s] %5$-50s %6$-20s: %7$s%8$s";
      private static final int MAX_THREAD_NAME_LENGTH = 15;

      /**
       * Returns the thread for the given thread id.
       *
       * @param threadId ID for the thread being logged.
       * @return returns the thread
       */
      Optional<Thread> getThread(long threadId) {
        return Thread.getAllStackTraces().keySet().stream()
            .filter(thread -> thread.getId() == threadId)
            .findFirst();
      }

      @Override
      public String format(LogRecord record) {
        String date = new SimpleDateFormat(PATTERN).format(new Date(record.getMillis()));
        String threadName =
            getThread(record.getThreadID())
                .map(Thread::getName)
                .map(
                    name ->
                        name.length() > MAX_THREAD_NAME_LENGTH
                            ? name.substring(name.length() - MAX_THREAD_NAME_LENGTH)
                            : name)
                .orElse("");
        long processId =
            Long.parseLong(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
        String sourceClassName = record.getLoggerName();
        String sourceMethodName = record.getSourceMethodName();
        return String.format(
            FORMAT,
            date,
            record.getLevel().getName(),
            processId,
            threadName,
            sourceClassName,
            sourceMethodName,
            record.getMessage(),
            System.lineSeparator());
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
        h.close();
        logger.removeHandler(h);
        break;
      }
      if (h instanceof FileHandler) {
        fileHandler = h;
        break;
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
